package sml;

/**
 * Created by yprift01 on 05/03/17.
 */
public class DonthingInstruction extends Instruction {
    private int register;
    private int value;

    public DonthingInstruction(String label, String opcode) {
        super(label, opcode);
    }

    public DonthingInstruction(String label, int op) {
        super(label, "donthing");
    }

    @Override
    public void execute(Machine m) {

    }

    @Override
    public String toString() {
        return super.toString() + " Nothing Done! " ;
    }

}
