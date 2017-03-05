package sml;

/**
 * Created by yprift01 on 05/03/17.
 */
public class OutInstruction extends Instruction {

    private int op1;
    private int value;

    public OutInstruction(String label, String opcode) {
            super(label, opcode);
            }

    public OutInstruction(String label, int op1) {
        super(label, "out");
        this.op1 = op1;
    }


    @Override
    public void execute(Machine m) {
            value = m.getRegisters().getRegister(op1);
            System.out.println(value);
      }

    @Override
    public String toString() {
            return super.toString() + " register " + op1 ;
     }

}
