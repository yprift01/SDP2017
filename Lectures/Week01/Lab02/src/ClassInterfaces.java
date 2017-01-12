import java.lang.reflect.Method;

public class ClassInterfaces{


    public ClassInterfaces(){

    }

    public String PrintInterface(String className){
        String result = "";
        try {

            Object genericObject = Class.forName(className);
            result+="Class Loaded OK.\n";

            Class objectClass = genericObject.getClass();
            Method[] methods = objectClass.getMethods();
            result+="Public Methods: \n";
            for(int i = 0; i<methods.length;i++){
               //if(methods[i].isAccessible()){
                    result+=methods[i].getName() + "\n";
               // }
            }
        }catch (Exception ex){
            System.err.print(ex.getLocalizedMessage());
        }

        result += "Complete " + className;
        return result;
    }

}