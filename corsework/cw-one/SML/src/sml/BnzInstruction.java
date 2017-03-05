package sml;

/**
 * Created by yprift01 on 05/03/17.
 */
public class BnzInstruction extends Instruction {
    private int op1;
    private String op2;

    public BnzInstruction(String label, String op) {
        super(label, op);
    }

    public BnzInstruction(String label, int op1, String op2) {
        this(label, "bnz");
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(op1);
        String value2 = op2;
        if (value1!=0)
        {
            int newIndex = m.getLabels().indexOf(value2);
            if (newIndex > 0)
                m.setPc(newIndex);
        }
    }

    @Override
    public String toString() {
        boolean doJump = op1==0;
        return super.toString() + " " + op1 + " + " + op2 + " to " + doJump;
    }

}
