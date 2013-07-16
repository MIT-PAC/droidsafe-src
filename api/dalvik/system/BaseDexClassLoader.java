package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.File;
import java.net.URL;
import java.util.Enumeration;

public class BaseDexClassLoader extends ClassLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:18.512 -0400", hash_original_field = "E52907B281EBC39F748C5E9AF1646256", hash_generated_field = "3A1905766FA74BE7F45BBB06C9F84A8F")

    private String originalPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:18.513 -0400", hash_original_field = "F595D4C971339549E44E99ACE240CF42", hash_generated_field = "139BAEC5E13F7EB5F6959327397357CD")

    private DexPathList pathList;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:18.523 -0400", hash_original_method = "ADD286CC7B907BF4568C827AC1E89193", hash_generated_method = "CDB2BDC6E5E67AA9B137C4248320D43E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:18.528 -0400", hash_original_method = "521C939EE5D3EB6850693DC0AA73197C", hash_generated_method = "CB5F27CC6F9456243448155D7F278CB9")
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        addTaint(name.getTaint());
        Class clazz = pathList.findClass(name);
    if(clazz == null)        
        {
            ClassNotFoundException varCD5E079E63A1D8649436CAB8BC9448A2_399759631 = new ClassNotFoundException(name);
            varCD5E079E63A1D8649436CAB8BC9448A2_399759631.addTaint(taint);
            throw varCD5E079E63A1D8649436CAB8BC9448A2_399759631;
        } //End block
Class<?> var3E303968598B6EE307EE3739CE40F332_797299967 =         clazz;
        var3E303968598B6EE307EE3739CE40F332_797299967.addTaint(taint);
        return var3E303968598B6EE307EE3739CE40F332_797299967;
        // ---------- Original Method ----------
        //Class clazz = pathList.findClass(name);
        //if (clazz == null) {
            //throw new ClassNotFoundException(name);
        //}
        //return clazz;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:18.532 -0400", hash_original_method = "7470A380EF1D93E773CA71CCC45CC5DC", hash_generated_method = "B782A0989B4586EF2CFB94E376F224F4")
    @Override
    protected URL findResource(String name) {
        addTaint(name.getTaint());
URL var711A2659EF8169CA1ACFB499F3D267C6_384916203 =         pathList.findResource(name);
        var711A2659EF8169CA1ACFB499F3D267C6_384916203.addTaint(taint);
        return var711A2659EF8169CA1ACFB499F3D267C6_384916203;
        // ---------- Original Method ----------
        //return pathList.findResource(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:18.538 -0400", hash_original_method = "7D0FB955FF80F0A3807920CE00840D77", hash_generated_method = "2B07207E4B9499C02F37EF070E1214FD")
    @Override
    protected Enumeration<URL> findResources(String name) {
        addTaint(name.getTaint());
Enumeration<URL> var76B87079F4B0CF54B0E673ED75A1D0A7_844585636 =         pathList.findResources(name);
        var76B87079F4B0CF54B0E673ED75A1D0A7_844585636.addTaint(taint);
        return var76B87079F4B0CF54B0E673ED75A1D0A7_844585636;
        // ---------- Original Method ----------
        //return pathList.findResources(name);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:18.543 -0400", hash_original_method = "C00307207743233EB6F3CC5C62BA4C3A", hash_generated_method = "F7E1089B127D68E5F0DF797830AC8CEC")
    @Override
    public String findLibrary(String name) {
        addTaint(name.getTaint());
String varAE0CECAF56179FF8E923ABAA9062B12E_1500280114 =         pathList.findLibrary(name);
        varAE0CECAF56179FF8E923ABAA9062B12E_1500280114.addTaint(taint);
        return varAE0CECAF56179FF8E923ABAA9062B12E_1500280114;
        // ---------- Original Method ----------
        //return pathList.findLibrary(name);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:18.556 -0400", hash_original_method = "CA22ACC2BBED318A2E853CC270258DF9", hash_generated_method = "9B5D3559D2AA2753431394195D79309F")
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
Package var92767E2A4BD8914A1F39CCFB211BAF92_1848512177 =             pack;
            var92767E2A4BD8914A1F39CCFB211BAF92_1848512177.addTaint(taint);
            return var92767E2A4BD8914A1F39CCFB211BAF92_1848512177;
        } //End block
Package var540C13E9E156B687226421B24F2DF178_1452339540 =         null;
        var540C13E9E156B687226421B24F2DF178_1452339540.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1452339540;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:18.560 -0400", hash_original_method = "A4316A3AABC51F9CE057485DF0B501BC", hash_generated_method = "528FDC0CFD61E6E1BBEEA2A28AB8617B")
    @Override
    public String toString() {
String varFD83E8FAD3A4DC4E0714054DAF9B227D_1843858747 =         getClass().getName() + "[" + originalPath + "]";
        varFD83E8FAD3A4DC4E0714054DAF9B227D_1843858747.addTaint(taint);
        return varFD83E8FAD3A4DC4E0714054DAF9B227D_1843858747;
        // ---------- Original Method ----------
        //return getClass().getName() + "[" + originalPath + "]";
    }

    
}

