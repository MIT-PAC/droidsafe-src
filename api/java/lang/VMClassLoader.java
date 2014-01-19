package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import droidsafe.helpers.DSUtils;

class VMClassLoader {

    /**
     * Get a resource from a file in the bootstrap class path.
     *
     * It would be simpler to just walk through the class path elements
     * ourselves, but that would require reopening Jar files.
     *
     * We assume that the bootclasspath can't change once the VM has
     * started.  This assumption seems to be supported by the spec.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.660 -0500", hash_original_method = "AF486A7D7E964EDE4DDBB83EBC604A43", hash_generated_method = "6271D690045E117ED2B73930093ED883")
    
static URL getResource(String name) {
        int numEntries = getBootClassPathSize();
        for (int i = 0; i < numEntries; i++) {
            String urlStr = getBootClassPathResource(name, i);
            if (urlStr != null) {
                try {
                    return new URL(urlStr);
                } catch (MalformedURLException mue) {
                    mue.printStackTrace();
                    // unexpected; keep going
                }
            }
        }
        return null;
    }

    /*
     * Get an enumeration with all matching resources.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.663 -0500", hash_original_method = "41BB43040C33BB8F9D26EFBD637FF5E0", hash_generated_method = "BA6F8EFE5770630EF076EF012F1DAE80")
    
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
                    // unexpected; keep going
                }
            }
        }
        return list;
    }
    
    static Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
    	Class ret = (Class)new Object();
    	ret.addTaint(name.taint);
    	ret.addTaint(resolve);
    	return ret;
    }
    
    static Class getPrimitiveClass(char type) {
    	Class ret = (Class)new Object();
    	ret.addTaint(type);
    	return ret;
    }
    
    static Class defineClass(ClassLoader cl, String name, byte[] data, int offset, int len) throws ClassFormatError {
    	Class ret = (Class)new Object();
    	ret.addTaint(cl.taint);
    	ret.addTaint(data[0]);
    	ret.addTaint(offset);
    	ret.addTaint(len);
    	return ret;
    }
    
    static Class defineClass(ClassLoader cl, byte[] data, int offset, int len) throws ClassFormatError {
    	Class ret = (Class)new Object();
    	ret.addTaint(cl.taint);
    	ret.addTaint(data[0]);
    	ret.addTaint(offset);
    	ret.addTaint(len);
    	return ret;
    }
    
    static Class findLoadedClass(ClassLoader cl, String name) {
    	Class ret = (Class)new Object();
    	ret.addTaint(name.taint);
    	ret.addTaint(cl.taint);
    	return ret;
    }
    
    private static int getBootClassPathSize() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375923467 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375923467;
    }
    
    private static String getBootClassPathResource(String name, int index) {
    	String ret = new String();
    	ret.addTaint(name.taint);
    	ret.addTaint(index);
    	return ret;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.695 -0400", hash_original_method = "4AEDA864BABA59DB003EAC2DE676238C", hash_generated_method = "4AEDA864BABA59DB003EAC2DE676238C")
    public VMClassLoader ()
    {
        //Synthesized constructor
    }
    
}

