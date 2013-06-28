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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.548 -0400", hash_original_field = "E52907B281EBC39F748C5E9AF1646256", hash_generated_field = "3A1905766FA74BE7F45BBB06C9F84A8F")

    private String originalPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.548 -0400", hash_original_field = "F595D4C971339549E44E99ACE240CF42", hash_generated_field = "139BAEC5E13F7EB5F6959327397357CD")

    private DexPathList pathList;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.549 -0400", hash_original_method = "ADD286CC7B907BF4568C827AC1E89193", hash_generated_method = "9F4B9B088B95BC231E01D4C4EB48C5F9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.550 -0400", hash_original_method = "521C939EE5D3EB6850693DC0AA73197C", hash_generated_method = "5B9A2A27C1A823CC8B6124DF1CF04568")
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_861103811 = null; //Variable for return #1
        Class clazz = pathList.findClass(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_861103811 = clazz;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_861103811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_861103811;
        // ---------- Original Method ----------
        //Class clazz = pathList.findClass(name);
        //if (clazz == null) {
            //throw new ClassNotFoundException(name);
        //}
        //return clazz;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.550 -0400", hash_original_method = "7470A380EF1D93E773CA71CCC45CC5DC", hash_generated_method = "7D063D6F882AAF31C374A4AC95A3207F")
    @Override
    protected URL findResource(String name) {
        URL varB4EAC82CA7396A68D541C85D26508E83_1496337839 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1496337839 = pathList.findResource(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1496337839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1496337839;
        // ---------- Original Method ----------
        //return pathList.findResource(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.551 -0400", hash_original_method = "7D0FB955FF80F0A3807920CE00840D77", hash_generated_method = "BFD4B165DAC49CA091251A7F60EDB4BF")
    @Override
    protected Enumeration<URL> findResources(String name) {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_1537894793 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1537894793 = pathList.findResources(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1537894793.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1537894793;
        // ---------- Original Method ----------
        //return pathList.findResources(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.551 -0400", hash_original_method = "C00307207743233EB6F3CC5C62BA4C3A", hash_generated_method = "A6C520D03DF31E7E1078662FBFBA1B46")
    @Override
    public String findLibrary(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_2005116220 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2005116220 = pathList.findLibrary(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2005116220.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2005116220;
        // ---------- Original Method ----------
        //return pathList.findLibrary(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.552 -0400", hash_original_method = "CA22ACC2BBED318A2E853CC270258DF9", hash_generated_method = "5E66C37F8D50D8A4DA25F5B9A6D79E2A")
    @Override
    protected synchronized Package getPackage(String name) {
        Package varB4EAC82CA7396A68D541C85D26508E83_212945860 = null; //Variable for return #1
        Package varB4EAC82CA7396A68D541C85D26508E83_497740698 = null; //Variable for return #2
        {
            boolean var8F2A85FBA5C7FD01FD8C0BFF3B70DD8B_1226566420 = (name != null && !name.isEmpty());
            {
                Package pack = super.getPackage(name);
                {
                    pack = definePackage(name, "Unknown", "0.0", "Unknown",
                        "Unknown", "0.0", "Unknown", null);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_212945860 = pack;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_497740698 = null;
        addTaint(name.getTaint());
        Package varA7E53CE21691AB073D9660D615818899_2004869537; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2004869537 = varB4EAC82CA7396A68D541C85D26508E83_212945860;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2004869537 = varB4EAC82CA7396A68D541C85D26508E83_497740698;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2004869537.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2004869537;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.552 -0400", hash_original_method = "A4316A3AABC51F9CE057485DF0B501BC", hash_generated_method = "E50E1E0539A777DBB5DB62C55863A0F9")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_502583462 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_502583462 = getClass().getName() + "[" + originalPath + "]";
        varB4EAC82CA7396A68D541C85D26508E83_502583462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_502583462;
        // ---------- Original Method ----------
        //return getClass().getName() + "[" + originalPath + "]";
    }

    
}

