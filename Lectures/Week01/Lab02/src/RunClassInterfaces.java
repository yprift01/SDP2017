import java.util.Scanner;

public class RunClassInterfaces {
    public static void main(String[] args)
    {
        ClassInterfaces cl = new ClassInterfaces();
        System.out.print("Enter full class name: ");
        Scanner sc = new Scanner(System.in);
        String className = sc.next();
        System.out.print(cl.PrintInterface(className));

    }
}
