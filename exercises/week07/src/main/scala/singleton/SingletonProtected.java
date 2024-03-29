

package singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonProtected implements Serializable {
    private static final long serialVersionUID = -1093810940935189395L;
    private static SingletonProtected sc = new SingletonProtected();

    private SingletonProtected() {
        if (sc != null) {
            throw new IllegalStateException("Already created.");
        }
    }

    private static Class getClass(String classname) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null)
            classLoader = SingletonProtected.class.getClassLoader();
        return (classLoader.loadClass(classname));


    }

    public static SingletonProtected getInstance() {
        return sc;
    }

    private Object readResolve() throws ObjectStreamException {
        return sc;
    }

    private Object writeReplace() throws ObjectStreamException {
        return sc;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton, cannot be cloned");
    }

}
