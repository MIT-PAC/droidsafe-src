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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.669 -0400", hash_original_method = "7C334082B26825451B04478AF491B5D2", hash_generated_method = "7C334082B26825451B04478AF491B5D2")
        public VMClassLoader ()
    {
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
        return DSUtils.UNKNOWN_STRING;
    }

    
}

