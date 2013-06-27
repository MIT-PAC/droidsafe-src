package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class VMClassLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.735 -0400", hash_original_method = "4AEDA864BABA59DB003EAC2DE676238C", hash_generated_method = "4AEDA864BABA59DB003EAC2DE676238C")
    public VMClassLoader ()
    {
        //Synthesized constructor
    }


        static URL getResource(String name) {
        int numEntries = getBootClassPathSize();
        for (int i = 0; i < numEntries; i++) {
            String urlStr = getBootClassPathResource(name, i);
            if (urlStr != null) {
                try {
                    return new URL(urlStr);
                } catch (MalformedURLException mue) {
                    mue.printStackTrace();
                }
            }
        }
        return null;
    }

    
        static List<URL> getResources(String name) {
        ArrayList<URL> list = new ArrayList<URL>();
        int numEntries = getBootClassPathSize();
        for (int i = 0; i < numEntries; i++) {
            String urlStr = getBootClassPathResource(name, i);
            if (urlStr != null) {
                try {
                    list.add(new URL(urlStr));
                } catch (MalformedURLException mue) {
                    mue.printStackTrace();
                }
            }
        }
        return list;
    }

    
        static Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static Class getPrimitiveClass(char type) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static Class defineClass(ClassLoader cl, String name, byte[] data, int offset, int len) throws ClassFormatError {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static Class defineClass(ClassLoader cl, byte[] data, int offset, int len) throws ClassFormatError {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static Class findLoadedClass(ClassLoader cl, String name) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static int getBootClassPathSize() {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static String getBootClassPathResource(String name, int index) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
}

