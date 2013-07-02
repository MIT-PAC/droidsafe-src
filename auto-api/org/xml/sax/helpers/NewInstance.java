package org.xml.sax.helpers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class NewInstance {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.960 -0400", hash_original_method = "3A1A52FA8F8F310ECE2DC8F1F45CC136", hash_generated_method = "3A1A52FA8F8F310ECE2DC8F1F45CC136")
    public NewInstance ()
    {
        
    }


    static Object newInstance(ClassLoader classLoader, String className) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        Class driverClass;
        if (classLoader == null) {
            driverClass = Class.forName(className);
        } else {
            driverClass = classLoader.loadClass(className);
        }
        return driverClass.newInstance();
    }

    
    static ClassLoader getClassLoader() {
        Method m = null;
        try {
            m = Thread.class.getMethod("getContextClassLoader");
        } catch (NoSuchMethodException e) {
            return NewInstance.class.getClassLoader();
        }
        try {
            return (ClassLoader) m.invoke(Thread.currentThread());
        } catch (IllegalAccessException e) {
            throw new UnknownError(e.getMessage());
        } catch (InvocationTargetException e) {
            throw new UnknownError(e.getMessage());
        }
    }

    
}

