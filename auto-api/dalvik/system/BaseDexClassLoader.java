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
    private String originalPath;
    private DexPathList pathList;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.206 -0400", hash_original_method = "ADD286CC7B907BF4568C827AC1E89193", hash_generated_method = "67DF838721F45F301F695F502E309BC6")
    @DSModeled(DSC.BAN)
    public BaseDexClassLoader(String dexPath, File optimizedDirectory,
            String libraryPath, ClassLoader parent) {
        super(parent);
        dsTaint.addTaint(optimizedDirectory.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(dexPath);
        dsTaint.addTaint(libraryPath);
        this.pathList =
            new DexPathList(this, dexPath, libraryPath, optimizedDirectory);
        // ---------- Original Method ----------
        //this.originalPath = dexPath;
        //this.pathList =
            //new DexPathList(this, dexPath, libraryPath, optimizedDirectory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.206 -0400", hash_original_method = "521C939EE5D3EB6850693DC0AA73197C", hash_generated_method = "B904507C0691422F4985C5D5CE3F5812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        dsTaint.addTaint(name);
        Class clazz;
        clazz = pathList.findClass(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(name);
        } //End block
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Class clazz = pathList.findClass(name);
        //if (clazz == null) {
            //throw new ClassNotFoundException(name);
        //}
        //return clazz;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.206 -0400", hash_original_method = "7470A380EF1D93E773CA71CCC45CC5DC", hash_generated_method = "570AEB431F71F7E3F595551556B613D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URL findResource(String name) {
        dsTaint.addTaint(name);
        URL var781D89D0598FD9788F52560A154A030F_754849174 = (pathList.findResource(name));
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return pathList.findResource(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.206 -0400", hash_original_method = "7D0FB955FF80F0A3807920CE00840D77", hash_generated_method = "FD021EB3AE55704810219F916710E537")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Enumeration<URL> findResources(String name) {
        dsTaint.addTaint(name);
        Enumeration<URL> var6B0AC887D0C9D7EE77E10D3381D4A36A_415889415 = (pathList.findResources(name));
        return (Enumeration<URL>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return pathList.findResources(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.206 -0400", hash_original_method = "C00307207743233EB6F3CC5C62BA4C3A", hash_generated_method = "B6E85D702E2737052FF6BEA3629574E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String findLibrary(String name) {
        dsTaint.addTaint(name);
        String var5CDEAB4696B64658C2A4B9D3FA60E09D_1514182709 = (pathList.findLibrary(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pathList.findLibrary(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.207 -0400", hash_original_method = "CA22ACC2BBED318A2E853CC270258DF9", hash_generated_method = "D37945CB640B2E08B6E573B28B1699F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected synchronized Package getPackage(String name) {
        dsTaint.addTaint(name);
        {
            boolean var8F2A85FBA5C7FD01FD8C0BFF3B70DD8B_1883755864 = (name != null && !name.isEmpty());
            {
                Package pack;
                pack = super.getPackage(name);
                {
                    pack = definePackage(name, "Unknown", "0.0", "Unknown",
                        "Unknown", "0.0", "Unknown", null);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Package)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.207 -0400", hash_original_method = "A4316A3AABC51F9CE057485DF0B501BC", hash_generated_method = "57C231FF6BB2452A6315831AE9FB5899")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varCBB9CCFA2FBBDF6035576708C08B6300_416234874 = (getClass().getName() + "[" + originalPath + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[" + originalPath + "]";
    }

    
}

