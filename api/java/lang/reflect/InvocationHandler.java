package java.lang.reflect;

// Droidsafe Imports

public interface InvocationHandler {

    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
