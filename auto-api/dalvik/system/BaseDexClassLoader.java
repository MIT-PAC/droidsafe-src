package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.net.URL;
import java.util.Enumeration;

public class BaseDexClassLoader extends ClassLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.227 -0400", hash_original_field = "E52907B281EBC39F748C5E9AF1646256", hash_generated_field = "3A1905766FA74BE7F45BBB06C9F84A8F")

    private String originalPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.227 -0400", hash_original_field = "F595D4C971339549E44E99ACE240CF42", hash_generated_field = "139BAEC5E13F7EB5F6959327397357CD")

    private DexPathList pathList;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.228 -0400", hash_original_method = "ADD286CC7B907BF4568C827AC1E89193", hash_generated_method = "9F4B9B088B95BC231E01D4C4EB48C5F9")
    public  BaseDexClassLoader(String dexPath, File optimizedDirectory,
            String libraryPath, ClassLoader parent) {
        super(parent);
        this.originalPath = dexPath;
        this.pathList =
            new DexPathList(this, dexPath, libraryPath, optimizedDirectory);
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
        //this.originalPath = dexPath;
        //this.pathList =
            //new DexPathList(this, dexPath, libraryPath, optimizedDirectory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.229 -0400", hash_original_method = "521C939EE5D3EB6850693DC0AA73197C", hash_generated_method = "4A75B848BA3756909167B7AB0A3A603C")
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_33937596 = null; //Variable for return #1
        Class clazz;
        clazz = pathList.findClass(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_33937596 = clazz;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_33937596.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_33937596;
        // ---------- Original Method ----------
        //Class clazz = pathList.findClass(name);
        //if (clazz == null) {
            //throw new ClassNotFoundException(name);
        //}
        //return clazz;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.243 -0400", hash_original_method = "7470A380EF1D93E773CA71CCC45CC5DC", hash_generated_method = "82361E699821875FBB2775BE7349CFB2")
    @Override
    protected URL findResource(String name) {
        URL varB4EAC82CA7396A68D541C85D26508E83_1609598945 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1609598945 = pathList.findResource(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1609598945.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1609598945;
        // ---------- Original Method ----------
        //return pathList.findResource(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.245 -0400", hash_original_method = "7D0FB955FF80F0A3807920CE00840D77", hash_generated_method = "1CBBE9AC23DF2B1962F889F999DE3B1B")
    @Override
    protected Enumeration<URL> findResources(String name) {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_219840999 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_219840999 = pathList.findResources(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_219840999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_219840999;
        // ---------- Original Method ----------
        //return pathList.findResources(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.266 -0400", hash_original_method = "C00307207743233EB6F3CC5C62BA4C3A", hash_generated_method = "45AFC9AEE94D4BAC81873ADFAA293CA9")
    @Override
    public String findLibrary(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_137268515 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_137268515 = pathList.findLibrary(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_137268515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_137268515;
        // ---------- Original Method ----------
        //return pathList.findLibrary(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.267 -0400", hash_original_method = "CA22ACC2BBED318A2E853CC270258DF9", hash_generated_method = "520AF435AB641436ADB6B0927A4ED012")
    @Override
    protected synchronized Package getPackage(String name) {
        Package varB4EAC82CA7396A68D541C85D26508E83_1294933767 = null; //Variable for return #1
        Package varB4EAC82CA7396A68D541C85D26508E83_1266896308 = null; //Variable for return #2
        {
            boolean var8F2A85FBA5C7FD01FD8C0BFF3B70DD8B_743411206 = (name != null && !name.isEmpty());
            {
                Package pack;
                pack = super.getPackage(name);
                {
                    pack = definePackage(name, "Unknown", "0.0", "Unknown",
                        "Unknown", "0.0", "Unknown", null);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1294933767 = pack;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1266896308 = null;
        addTaint(name.getTaint());
        Package varA7E53CE21691AB073D9660D615818899_1944833234; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1944833234 = varB4EAC82CA7396A68D541C85D26508E83_1294933767;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1944833234 = varB4EAC82CA7396A68D541C85D26508E83_1266896308;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1944833234.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1944833234;
        // ---------- Original Method ----------
        //if (name != null && !name.isEmpty()) {
            //Package pack = super.getPackage(name);
            //if (pack == null) {
                //pack = definePackage(name, "Unknown", "0.0", "Unknown",
                        //"Unknown", "0.0", "Unknown", null);
            //}
            //return pack;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.269 -0400", hash_original_method = "A4316A3AABC51F9CE057485DF0B501BC", hash_generated_method = "798CCC035269DF942C4A40BBC8BC7F19")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_326045785 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_326045785 = getClass().getName() + "[" + originalPath + "]";
        varB4EAC82CA7396A68D541C85D26508E83_326045785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_326045785;
        // ---------- Original Method ----------
        //return getClass().getName() + "[" + originalPath + "]";
    }

    
}

