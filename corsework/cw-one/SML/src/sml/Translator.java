package sml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
public class Translator {

    private static final String PATH = "/home/yprift01/Dev/SDP2017/corsework/cw-one/";
    // word + line is the part of the current line that's not yet processed
    // word has no whitespace
    // If word and line are not empty, line begins with whitespace
    private String line = "";
    private Labels labels; // The labels of the program being translated
    private ArrayList<Instruction> program; // The program to be created
    private String fileName; // source file of SML code

    public Translator(String fileName) {
        this.fileName = PATH + fileName;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"
    public boolean readAndTranslate(Labels lab, ArrayList<Instruction> prog) {

        try (Scanner sc = new Scanner(new File(fileName))) {
            // Scanner attached to the file chosen by the user
            labels = lab;
            labels.reset();
            program = prog;
            program.clear();

            try {
                line = sc.nextLine();
            } catch (NoSuchElementException ioE) {
                return false;
            }

            // Each iteration processes line and reads the next line into line
            while (line != null) {
                // Store the label in label
                String label = scan();

                if (label.length() > 0) {
                    Instruction ins = getInstruction(label);
                    if (ins != null) {
                        labels.addLabel(label);
                        program.add(ins);
                    }
                }

                try {
                    line = sc.nextLine();
                } catch (NoSuchElementException ioE) {
                    return false;
                }
            }
        } catch (IOException ioE) {
            System.out.println("File: IO error " + ioE.getMessage());
            System.exit(-1);
            return false;
        }
        return true;
    }

    // line should consist of an MML instruction, with its label already
    // removed. Translate line into an instruction with label label
    // and return the instruction
    public Instruction getInstruction(String label) {
        int s1; // Possible operands of the instruction
        int s2;
        int r;
        int x;

        if (line.equals(""))
            return null;

        String ins = scan();
        /*
           To comply with kiss we will create a convention: The name of the instruction + the word instruction will identify the class to create
           For example "add" creates AddInstruction (CamelCase), "lin" creates LinInstruction

           all input parameters are int and we will read all the available input parameters. This will have to match the number of parameters for the class we are creating



         */

        String shortSub = ins.substring(0,1).toUpperCase() + ins.substring(1);

        String instruction = "sml."+ shortSub + "Instruction";
        try {

            Class insClass = Class.forName(instruction);
            ArrayList<Integer> parameters = new ArrayList();
            ArrayList<String> sparams = new ArrayList();
            while(true){
                if(!shortSub.equals("Bnz")) {
                    int nextParam = scanInt();
                    if (nextParam == Integer.MAX_VALUE) break;
                    parameters.add(nextParam);
                } else {
                    int nextParam = scanInt();
                    String jumpTo = scan();
                    parameters.add(nextParam);
                    sparams.add(jumpTo);
                    break;
                }

            }

            Object[] params = new Object[parameters.size()+1 + sparams.size()];
            Class<?>[] consParams = new Class<?>[parameters.size()+1 + sparams.size()];
            params[0] = label;
            consParams[0] = String.class;

            for(int i = 1; i<parameters.size()+1;i++){
                params[i] = parameters.get(i-1);
                consParams[i] = int.class;
            }
            if(sparams.size() > 0) {
                for(int i = parameters.size() + 1; i<parameters.size() + 1 + sparams.size();i++){
                    params[i] = sparams.get(i-1 - parameters.size());
                    consParams[i] = String.class;
                }
            }

            Instruction returnObject = (Instruction) insClass.getConstructor(consParams).newInstance(params);

            return returnObject;

        } catch (Exception ex) {
            //Exceptions are treated as unreadable instruction hence ignored
            return null;
        }

     }

    /*
     * Return the first word of line and remove it from line. If there is no
     * word, return ""
     */
    private String scan() {
        line = line.trim();
        if (line.length() == 0)
            return "";

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '\t') {
            i = i + 1;
        }
        String word = line.substring(0, i);
        line = line.substring(i);
        return word;
    }

    // Return the first word of line as an integer. If there is
    // any error, return the maximum int
    private int scanInt() {
        String word = scan();
        if (word.length() == 0) {
            return Integer.MAX_VALUE;
        }

        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
    }
}
