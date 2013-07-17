package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.File;
import java.net.URL;
import java.util.Enumeration;

public class BaseDexClassLoader extends ClassLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.685 -0400", hash_original_field = "E52907B281EBC39F748C5E9AF1646256", hash_generated_field = "3A1905766FA74BE7F45BBB06C9F84A8F")

    private String originalPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.685 -0400", hash_original_field = "F595D4C971339549E44E99ACE240CF42", hash_generated_field = "139BAEC5E13F7EB5F6959327397357CD")

    private DexPathList pathList;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.685 -0400", hash_original_method = "ADD286CC7B907BF4568C827AC1E89193", hash_generated_method = "CDB2BDC6E5E67AA9B137C4248320D43E")
    public  BaseDexClassLoader(String dexPath, File optimizedDirectory,
            String libraryPath, ClassLoader parent) {
        super(parent);
        addTaint(parent.getTaint());
        this.originalPath = dexPath;
        this.pathList =
            new DexPathList(this, dexPath, libraryPath, optimizedDirectory);
        // ---------- Original Method ----------
        //this.originalPath = dexPath;
        //this.pathList =
            //new DexPathList(this, dexPath, libraryPath, optimizedDirectory);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.685 -0400", hash_original_method = "521C939EE5D3EB6850693DC0AA73197C", hash_generated_method = "B7E8D36EE3BAA216C3ABCE7A39A5F953")
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        addTaint(name.getTaint());
        Class clazz = pathList.findClass(name);
        if(clazz == null)        
        {
            ClassNotFoundException varCD5E079E63A1D8649436CAB8BC9448A2_942943588 = new ClassNotFoundException(name);
            varCD5E079E63A1D8649436CAB8BC9448A2_942943588.addTaint(taint);
            throw varCD5E079E63A1D8649436CAB8BC9448A2_942943588;
        } //End block
Class<?> var3E303968598B6EE307EE3739CE40F332_72505753 =         clazz;
        var3E303968598B6EE307EE3739CE40F332_72505753.addTaint(taint);
        return var3E303968598B6EE307EE3739CE40F332_72505753;
        // ---------- Original Method ----------
        //Class clazz = pathList.findClass(name);
        //if (clazz == null) {
            //throw new ClassNotFoundException(name);
        //}
        //return clazz;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.686 -0400", hash_original_method = "7470A380EF1D93E773CA71CCC45CC5DC", hash_generated_method = "0A3376575D1F3169BA0C64468DA4E187")
    @Override
    protected URL findResource(String name) {
        addTaint(name.getTaint());
URL var711A2659EF8169CA1ACFB499F3D267C6_1240364158 =         pathList.findResource(name);
        var711A2659EF8169CA1ACFB499F3D267C6_1240364158.addTaint(taint);
        return var711A2659EF8169CA1ACFB499F3D267C6_1240364158;
        // ---------- Original Method ----------
        //return pathList.findResource(name);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.686 -0400", hash_original_method = "7D0FB955FF80F0A3807920CE00840D77", hash_generated_method = "663CE98D4C9A06BC948E995C5B1850A9")
    @Override
    protected Enumeration<URL> findResources(String name) {
        addTaint(name.getTaint());
Enumeration<URL> var76B87079F4B0CF54B0E673ED75A1D0A7_822677768 =         pathList.findResources(name);
        var76B87079F4B0CF54B0E673ED75A1D0A7_822677768.addTaint(taint);
        return var76B87079F4B0CF54B0E673ED75A1D0A7_822677768;
        // ---------- Original Method ----------
        //return pathList.findResources(name);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.686 -0400", hash_original_method = "C00307207743233EB6F3CC5C62BA4C3A", hash_generated_method = "5ADE6504D67AFCDF7E00ED0FB633C071")
    @Override
    public String findLibrary(String name) {
        addTaint(name.getTaint());
String varAE0CECAF56179FF8E923ABAA9062B12E_1555693007 =         pathList.findLibrary(name);
        varAE0CECAF56179FF8E923ABAA9062B12E_1555693007.addTaint(taint);
        return varAE0CECAF56179FF8E923ABAA9062B12E_1555693007;
        // ---------- Original Method ----------
        //return pathList.findLibrary(name);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.686 -0400", hash_original_method = "CA22ACC2BBED318A2E853CC270258DF9", hash_generated_method = "63CB087C68B651A374A6997380D5BCE9")
    @Override
    protected synchronized Package getPackage(String name) {
        addTaint(name.getTaint());
        if(name != null && !name.isEmpty())        
        {
            Package pack = super.getPackage(name);
            if(pack == null)            
            {
                pack = definePackage(name, "Unknown", "0.0", "Unknown",
                        "Unknown", "0.0", "Unknown", null);
            } //End block
Package var92767E2A4BD8914A1F39CCFB211BAF92_1309576636 =             pack;
            var92767E2A4BD8914A1F39CCFB211BAF92_1309576636.addTaint(taint);
            return var92767E2A4BD8914A1F39CCFB211BAF92_1309576636;
        } //End block
Package var540C13E9E156B687226421B24F2DF178_1556368343 =         null;
        var540C13E9E156B687226421B24F2DF178_1556368343.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1556368343;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.686 -0400", hash_original_method = "A4316A3AABC51F9CE057485DF0B501BC", hash_generated_method = "67DB8D57AEF78EFFF30B03FDA2CE7BC5")
    @Override
    public String toString() {
String varFD83E8FAD3A4DC4E0714054DAF9B227D_1227573883 =         getClass().getName() + "[" + originalPath + "]";
        varFD83E8FAD3A4DC4E0714054DAF9B227D_1227573883.addTaint(taint);
        return varFD83E8FAD3A4DC4E0714054DAF9B227D_1227573883;
        // ---------- Original Method ----------
        //return getClass().getName() + "[" + originalPath + "]";
    }

    
}

