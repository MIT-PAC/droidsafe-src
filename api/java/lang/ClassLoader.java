package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import dalvik.system.PathClassLoader;





public abstract class ClassLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.696 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "F21C7A33E41D98EA12963007269D2C47")

    private ClassLoader parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.696 -0400", hash_original_field = "2BB685EC85A743CD8A1D9EC57E6CA93C", hash_generated_field = "D93E16E52D6392375771C09EA3DB6BEE")

    private Map<String, Package> packages = new HashMap<String, Package>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.696 -0400", hash_original_method = "8E76514466172FE6741D8A4C6661DD70", hash_generated_method = "67B78B96E18A8A3E4D98CDB649E9B64A")
    protected  ClassLoader() {
        this(getSystemClassLoader(), false);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.696 -0400", hash_original_method = "DB0BF52E0FA8D43D630F9D86095EF243", hash_generated_method = "68E30502081669C8BA075C762E52DBD8")
    protected  ClassLoader(ClassLoader parentLoader) {
        this(parentLoader, false);
        addTaint(parentLoader.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.696 -0400", hash_original_method = "B3E4E8C3A704386E61A8D58325A9E2B7", hash_generated_method = "CFDBC740C110265A458F7306FA8132C6")
      ClassLoader(ClassLoader parentLoader, boolean nullAllowed) {
        addTaint(nullAllowed);
        if(parentLoader == null && !nullAllowed)        
        {
            NullPointerException varA8F208BE8D874C4854367E2A744501F0_2043547317 = new NullPointerException("Parent ClassLoader may not be null");
            varA8F208BE8D874C4854367E2A744501F0_2043547317.addTaint(taint);
            throw varA8F208BE8D874C4854367E2A744501F0_2043547317;
        } //End block
        parent = parentLoader;
        // ---------- Original Method ----------
        //if (parentLoader == null && !nullAllowed) {
            //throw new NullPointerException("Parent ClassLoader may not be null");
        //}
        //parent = parentLoader;
    }

    
    @DSModeled(DSC.BAN)
    private static ClassLoader createSystemClassLoader() {
        String classPath = System.getProperty("java.class.path", ".");
        return new PathClassLoader(classPath, BootClassLoader.getInstance());
    }

    
    @DSModeled(DSC.BAN)
    public static ClassLoader getSystemClassLoader() {
        return SystemClassLoader.loader;
    }

    
    @DSModeled(DSC.SPEC)
    public static URL getSystemResource(String resName) {
        return SystemClassLoader.loader.getResource(resName);
    }

    
    public static Enumeration<URL> getSystemResources(String resName) throws IOException {
        return SystemClassLoader.loader.getResources(resName);
    }

    
    @DSModeled(DSC.BAN)
    public static InputStream getSystemResourceAsStream(String resName) {
        return SystemClassLoader.loader.getResourceAsStream(resName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.697 -0400", hash_original_method = "EDBCEB3B7F6159932B32B9FEC39C429A", hash_generated_method = "6BF686D20BB4BD01A5A168E554290B2F")
    @Deprecated
    protected final Class<?> defineClass(byte[] classRep, int offset, int length) throws ClassFormatError {
        addTaint(length);
        addTaint(offset);
        addTaint(classRep[0]);
Class<?> varB33E976EBACF0537AC1530CEFCC02978_129210622 =         VMClassLoader.defineClass(this, classRep, offset, length);
        varB33E976EBACF0537AC1530CEFCC02978_129210622.addTaint(taint);
        return varB33E976EBACF0537AC1530CEFCC02978_129210622;
        // ---------- Original Method ----------
        //return VMClassLoader.defineClass(this, classRep, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.697 -0400", hash_original_method = "0F0A39CE7574A7CD22D1B4668E39A889", hash_generated_method = "4B6FD8848D416D9873317462172D7D67")
    protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length) throws ClassFormatError {
        addTaint(length);
        addTaint(offset);
        addTaint(classRep[0]);
        addTaint(className.getTaint());
Class<?> varC66541EE24E1609F3FC3648586C5ABBF_963111780 =         defineClass(className, classRep, offset, length, null);
        varC66541EE24E1609F3FC3648586C5ABBF_963111780.addTaint(taint);
        return varC66541EE24E1609F3FC3648586C5ABBF_963111780;
        // ---------- Original Method ----------
        //return defineClass(className, classRep, offset, length, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.697 -0400", hash_original_method = "EBF70D1CA87DA01178FDB05EE0827744", hash_generated_method = "B709FD8BB1351468E8913F701A50BDFD")
    protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length,
            ProtectionDomain protectionDomain) throws java.lang.ClassFormatError {
        addTaint(protectionDomain.getTaint());
        addTaint(length);
        addTaint(offset);
        addTaint(classRep[0]);
        addTaint(className.getTaint());
Class<?> varD58860CD1B743EF3A60CDDB2136F0016_914888909 =         VMClassLoader.defineClass(this, className, classRep, offset, length);
        varD58860CD1B743EF3A60CDDB2136F0016_914888909.addTaint(taint);
        return varD58860CD1B743EF3A60CDDB2136F0016_914888909;
        // ---------- Original Method ----------
        //return VMClassLoader.defineClass(this, className, classRep, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.697 -0400", hash_original_method = "05D340D0AFD0A4A41A098B1B021596A9", hash_generated_method = "98F87B8708DC06B4CC5B35EDD2268326")
    protected final Class<?> defineClass(String name, ByteBuffer b,
            ProtectionDomain protectionDomain) throws ClassFormatError {
        addTaint(protectionDomain.getTaint());
        addTaint(b.getTaint());
        addTaint(name.getTaint());
        byte[] temp = new byte[b.remaining()];
        b.get(temp);
Class<?> varF16E0AF58C9D8813D6BD96651FAEEFAF_1080563917 =         defineClass(name, temp, 0, temp.length, protectionDomain);
        varF16E0AF58C9D8813D6BD96651FAEEFAF_1080563917.addTaint(taint);
        return varF16E0AF58C9D8813D6BD96651FAEEFAF_1080563917;
        // ---------- Original Method ----------
        //byte[] temp = new byte[b.remaining()];
        //b.get(temp);
        //return defineClass(name, temp, 0, temp.length, protectionDomain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.697 -0400", hash_original_method = "FDF53ED54BA8389D30C48D1E15C39772", hash_generated_method = "CDD797C3C61A19B7624708E9E06C2ED0")
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        addTaint(className.getTaint());
        ClassNotFoundException var861A229D206F1BEB1A241D25B0C809D0_1829990749 = new ClassNotFoundException(className);
        var861A229D206F1BEB1A241D25B0C809D0_1829990749.addTaint(taint);
        throw var861A229D206F1BEB1A241D25B0C809D0_1829990749;
        // ---------- Original Method ----------
        //throw new ClassNotFoundException(className);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.698 -0400", hash_original_method = "1BCB441A83D111A7AA8FEC24C2456543", hash_generated_method = "42E8C5B5B0BADFE99B77204DE172C4A9")
    protected final Class<?> findLoadedClass(String className) {
        addTaint(className.getTaint());
        ClassLoader loader;
        if(this == BootClassLoader.getInstance())        
        loader = null;
        else
        loader = this;
Class<?> var08F628993F2409C453589DD76ED38AF1_427277883 =         VMClassLoader.findLoadedClass(loader, className);
        var08F628993F2409C453589DD76ED38AF1_427277883.addTaint(taint);
        return var08F628993F2409C453589DD76ED38AF1_427277883;
        // ---------- Original Method ----------
        //ClassLoader loader;
        //if (this == BootClassLoader.getInstance())
            //loader = null;
        //else
            //loader = this;
        //return VMClassLoader.findLoadedClass(loader, className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.698 -0400", hash_original_method = "8781F33C8E67EE4404420C5C91B2F2B8", hash_generated_method = "0523865727A0509C62757174155521D7")
    protected final Class<?> findSystemClass(String className) throws ClassNotFoundException {
        addTaint(className.getTaint());
Class<?> varE1EC1A949B64F2720C6EA4CFB815BC24_607354667 =         Class.forName(className, false, getSystemClassLoader());
        varE1EC1A949B64F2720C6EA4CFB815BC24_607354667.addTaint(taint);
        return varE1EC1A949B64F2720C6EA4CFB815BC24_607354667;
        // ---------- Original Method ----------
        //return Class.forName(className, false, getSystemClassLoader());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.698 -0400", hash_original_method = "C41AD9124585D3AEE85EC6C2F13127B8", hash_generated_method = "F0E33F4D97CAA74AFF99E3B11E5A4657")
    public final ClassLoader getParent() {
ClassLoader var0F49909EA73F8892C338E4DCA6EB9906_2026649457 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_2026649457.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_2026649457;
        // ---------- Original Method ----------
        //return parent;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.698 -0400", hash_original_method = "51B198FC24245E471F59AEE285D4917F", hash_generated_method = "ED392ED110D1555D49432B202CFD3DDA")
    public URL getResource(String resName) {
        addTaint(resName.getTaint());
        URL resource = parent.getResource(resName);
        if(resource == null)        
        {
            resource = findResource(resName);
        } //End block
URL var43E8B6A4B99FCF378B49FF1E374C713F_1255918878 =         resource;
        var43E8B6A4B99FCF378B49FF1E374C713F_1255918878.addTaint(taint);
        return var43E8B6A4B99FCF378B49FF1E374C713F_1255918878;
        // ---------- Original Method ----------
        //URL resource = parent.getResource(resName);
        //if (resource == null) {
            //resource = findResource(resName);
        //}
        //return resource;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.698 -0400", hash_original_method = "A1AC2BF370A36ABB9B1EEF5C25CA87C9", hash_generated_method = "F0D0407482C0AD8D3AC0D70DE6D76D4A")
    @SuppressWarnings("unchecked")
    public Enumeration<URL> getResources(String resName) throws IOException {
        addTaint(resName.getTaint());
        Enumeration first = parent.getResources(resName);
        Enumeration second = findResources(resName);
Enumeration<URL> var29FC63E53C593F544CA2665302A605B4_1253472890 =         new TwoEnumerationsInOne(first, second);
        var29FC63E53C593F544CA2665302A605B4_1253472890.addTaint(taint);
        return var29FC63E53C593F544CA2665302A605B4_1253472890;
        // ---------- Original Method ----------
        //Enumeration first = parent.getResources(resName);
        //Enumeration second = findResources(resName);
        //return new TwoEnumerationsInOne(first, second);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.698 -0400", hash_original_method = "D8955CCF86190424763C439F9FDF42B6", hash_generated_method = "1709682A6BDCC90C15680CEC6CBA02F7")
    public InputStream getResourceAsStream(String resName) {
        addTaint(resName.getTaint());
        try 
        {
            URL url = getResource(resName);
            if(url != null)            
            {
InputStream var98AE6A59F8B94FA975B52B24770F9849_1581749074 =                 url.openStream();
                var98AE6A59F8B94FA975B52B24770F9849_1581749074.addTaint(taint);
                return var98AE6A59F8B94FA975B52B24770F9849_1581749074;
            } //End block
        } //End block
        catch (IOException ex)
        {
        } //End block
InputStream var540C13E9E156B687226421B24F2DF178_1103630469 =         null;
        var540C13E9E156B687226421B24F2DF178_1103630469.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1103630469;
        // ---------- Original Method ----------
        //try {
            //URL url = getResource(resName);
            //if (url != null) {
                //return url.openStream();
            //}
        //} catch (IOException ex) {
        //}
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.698 -0400", hash_original_method = "B81E0F32DC432F0B3276D4B4E41F12D0", hash_generated_method = "189415F4E46C66B846623C61F62D65D1")
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        addTaint(className.getTaint());
Class<?> varDABA5CC5243A82A517BB6B8B0E854144_992398354 =         loadClass(className, false);
        varDABA5CC5243A82A517BB6B8B0E854144_992398354.addTaint(taint);
        return varDABA5CC5243A82A517BB6B8B0E854144_992398354;
        // ---------- Original Method ----------
        //return loadClass(className, false);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.699 -0400", hash_original_method = "733CC3AC678FE7D7ABDA5F1E7A258EB2", hash_generated_method = "385A52E6B9D022D93C6D62A18789D0F6")
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        addTaint(resolve);
        addTaint(className.getTaint());
        Class<?> clazz = findLoadedClass(className);
        if(clazz == null)        
        {
            try 
            {
                clazz = parent.loadClass(className, false);
            } //End block
            catch (ClassNotFoundException e)
            {
            } //End block
            if(clazz == null)            
            {
                clazz = findClass(className);
            } //End block
        } //End block
Class<?> var3E303968598B6EE307EE3739CE40F332_1363033747 =         clazz;
        var3E303968598B6EE307EE3739CE40F332_1363033747.addTaint(taint);
        return var3E303968598B6EE307EE3739CE40F332_1363033747;
        // ---------- Original Method ----------
        //Class<?> clazz = findLoadedClass(className);
        //if (clazz == null) {
            //try {
                //clazz = parent.loadClass(className, false);
            //} catch (ClassNotFoundException e) {
            //}
            //if (clazz == null) {
                //clazz = findClass(className);
            //}
        //}
        //return clazz;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.699 -0400", hash_original_method = "87395C94E1724A33A91DB9FA52BA76C0", hash_generated_method = "AECD55F08AE837F29C8894737A42DAA1")
    protected final void resolveClass(Class<?> clazz) {
        addTaint(clazz.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.699 -0400", hash_original_method = "A0771382989D9347D13AB7091421D08A", hash_generated_method = "D795075DAF96F116249A603332DB7BD5")
    protected URL findResource(String resName) {
        addTaint(resName.getTaint());
URL var540C13E9E156B687226421B24F2DF178_632098363 =         null;
        var540C13E9E156B687226421B24F2DF178_632098363.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_632098363;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.699 -0400", hash_original_method = "4B31BA177B6DE85B868949BABF9D20CF", hash_generated_method = "D3F77A2E74B69604652B65510E809041")
    @SuppressWarnings( {
            "unchecked", "unused"
    })
    protected Enumeration<URL> findResources(String resName) throws IOException {
        addTaint(resName.getTaint());
Enumeration<URL> var89A53E363F514214E6187D5546BEF542_571951672 =         Collections.emptyEnumeration();
        var89A53E363F514214E6187D5546BEF542_571951672.addTaint(taint);
        return var89A53E363F514214E6187D5546BEF542_571951672;
        // ---------- Original Method ----------
        //return Collections.emptyEnumeration();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.699 -0400", hash_original_method = "77218157254CA1D97E6FAA91981AFD35", hash_generated_method = "4BBDF1533DF49CA530ABF1C36CDB76DA")
    protected String findLibrary(String libName) {
        addTaint(libName.getTaint());
String var540C13E9E156B687226421B24F2DF178_1405155780 =         null;
        var540C13E9E156B687226421B24F2DF178_1405155780.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1405155780;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.699 -0400", hash_original_method = "32CF87857A859A288886DD8F10CED2F8", hash_generated_method = "91B360C468599E8DAF732B9BB98750AD")
    protected Package getPackage(String name) {
        addTaint(name.getTaint());
        synchronized
(packages)        {
Package var879C3D82B4E204184FBD062358C07A11_303946731 =             packages.get(name);
            var879C3D82B4E204184FBD062358C07A11_303946731.addTaint(taint);
            return var879C3D82B4E204184FBD062358C07A11_303946731;
        } //End block
        // ---------- Original Method ----------
        //synchronized (packages) {
            //return packages.get(name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.699 -0400", hash_original_method = "9287CE4A0AED64937C82364D387BD57D", hash_generated_method = "935CD077345402A422D70860D7A80ADF")
    protected Package[] getPackages() {
        synchronized
(packages)        {
            Collection<Package> col = packages.values();
            Package[] result = new Package[col.size()];
            col.toArray(result);
Package[] varDC838461EE2FA0CA4C9BBB70A15456B0_1156005339 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1156005339.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1156005339;
        } //End block
        // ---------- Original Method ----------
        //synchronized (packages) {
            //Collection<Package> col = packages.values();
            //Package[] result = new Package[col.size()];
            //col.toArray(result);
            //return result;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.699 -0400", hash_original_method = "A43EE12FE4CCED7FFCD5E4E6E6B7450E", hash_generated_method = "8FD13513AEA9064A522DA1E0A6A93FDF")
    protected Package definePackage(String name, String specTitle, String specVersion,
            String specVendor, String implTitle, String implVersion, String implVendor, URL sealBase) throws IllegalArgumentException {
        addTaint(sealBase.getTaint());
        addTaint(implVendor.getTaint());
        addTaint(implVersion.getTaint());
        addTaint(implTitle.getTaint());
        addTaint(specVendor.getTaint());
        addTaint(specVersion.getTaint());
        addTaint(specTitle.getTaint());
        addTaint(name.getTaint());
        synchronized
(packages)        {
            if(packages.containsKey(name))            
            {
                IllegalArgumentException varCA42C2364F842AAB3D2FD395654AD60B_518451348 = new IllegalArgumentException("Package " + name + " already defined");
                varCA42C2364F842AAB3D2FD395654AD60B_518451348.addTaint(taint);
                throw varCA42C2364F842AAB3D2FD395654AD60B_518451348;
            } //End block
            Package newPackage = new Package(name, specTitle, specVersion, specVendor, implTitle,
                    implVersion, implVendor, sealBase);
            packages.put(name, newPackage);
Package var92B96FE3853575A1658E3A697814623E_650125723 =             newPackage;
            var92B96FE3853575A1658E3A697814623E_650125723.addTaint(taint);
            return var92B96FE3853575A1658E3A697814623E_650125723;
        } //End block
        // ---------- Original Method ----------
        //synchronized (packages) {
            //if (packages.containsKey(name)) {
                //throw new IllegalArgumentException("Package " + name + " already defined");
            //}
            //Package newPackage = new Package(name, specTitle, specVersion, specVendor, implTitle,
                    //implVersion, implVendor, sealBase);
            //packages.put(name, newPackage);
            //return newPackage;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_method = "BAF7E3EE5C9000806386C90B3768A9FC", hash_generated_method = "0CBC7270F4BB3468DA4BA45693E13FFD")
    protected final void setSigners(Class<?> c, Object[] signers) {
        addTaint(signers[0].getTaint());
        addTaint(c.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_method = "0651223F404879984496AF2BE37D7C48", hash_generated_method = "EA5217413AE835D5CED61CD6DE9A91CD")
    public void setClassAssertionStatus(String cname, boolean enable) {
        addTaint(enable);
        addTaint(cname.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_method = "2F6CF0A6D7DAAB50984CC8577E0B6ED7", hash_generated_method = "3DE3E7E60AEB1F9BEF6D653D204DF308")
    public void setPackageAssertionStatus(String pname, boolean enable) {
        addTaint(enable);
        addTaint(pname.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_method = "F3C67BF009E262C5EF85B89EAEA54A8D", hash_generated_method = "9CCCF9B831F31B11857410609390EEBD")
    public void setDefaultAssertionStatus(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_method = "0F2B38C73B2795A58A5B8AC7764225D2", hash_generated_method = "E762A3660EF9111F915B372BD46E7E77")
    public void clearAssertionStatus() {
        // ---------- Original Method ----------
    }

    
    static private class SystemClassLoader {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_method = "5CAD2AFC0F0FA3887E4002E77FFD0C7D", hash_generated_method = "5CAD2AFC0F0FA3887E4002E77FFD0C7D")
        public SystemClassLoader ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_field = "9E858FEF25484C5FE1CB8BD38218B4F2", hash_generated_field = "9F05049E5285C9256C3F77BCE2FFFB9C")

        public static ClassLoader loader = ClassLoader.createSystemClassLoader();
    }


    
}

class TwoEnumerationsInOne implements Enumeration<URL> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "8251EE6159DCC0C25ACB4653E04140B7")

    private Enumeration<URL> first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "48331890F3BE0E00347927CE21AF464F")

    private Enumeration<URL> second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_method = "D3D417A978FD13F0C9B8800DA2920B14", hash_generated_method = "DC7052B6806C57873B5AB28FCC7C1781")
    public  TwoEnumerationsInOne(Enumeration<URL> first, Enumeration<URL> second) {
        this.first = first;
        this.second = second;
        // ---------- Original Method ----------
        //this.first = first;
        //this.second = second;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_method = "B34DCB72B1A55025C195F65FCCD0FE9D", hash_generated_method = "86D8C6108AD85E4344FBE732C19BAF6C")
    public boolean hasMoreElements() {
        boolean varFA7BD4A162C8C063F79F4353F346F180_2070585027 = (first.hasMoreElements() || second.hasMoreElements());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2081279871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2081279871;
        // ---------- Original Method ----------
        //return first.hasMoreElements() || second.hasMoreElements();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_method = "CE040DB5C31CF9231E1B46430147AEAF", hash_generated_method = "1A22B4FA57DDE0601BCA90DA2D52740B")
    public URL nextElement() {
        if(first.hasMoreElements())        
        {
URL varCE149CD2B39378A9F0645DD813764AEF_125154219 =             first.nextElement();
            varCE149CD2B39378A9F0645DD813764AEF_125154219.addTaint(taint);
            return varCE149CD2B39378A9F0645DD813764AEF_125154219;
        } //End block
        else
        {
URL varF709D8EE1609F973FA2C794DF46727C9_662051504 =             second.nextElement();
            varF709D8EE1609F973FA2C794DF46727C9_662051504.addTaint(taint);
            return varF709D8EE1609F973FA2C794DF46727C9_662051504;
        } //End block
        // ---------- Original Method ----------
        //if (first.hasMoreElements()) {
            //return first.nextElement();
        //} else {
            //return second.nextElement();
        //}
    }

    
}

class BootClassLoader extends ClassLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.701 -0400", hash_original_method = "D3F85B3CE9250DAE48A2E24200FC3763", hash_generated_method = "9B3A59F55A35519AA35E648BA04DC88C")
    @DSModeled(DSC.BAN)
    public  BootClassLoader() {
        super(null, true);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    public static synchronized BootClassLoader getInstance() {
        if (instance == null) {
            instance = new BootClassLoader();
        }
        return instance;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.701 -0400", hash_original_method = "0FBC8B1C710D0CE61299895128455485", hash_generated_method = "6CE0A2DF6021DB4AB914574D7ACAAC74")
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        addTaint(name.getTaint());
Class<?> var3395E90E7215A3CC7F30E04EE174D39F_298454833 =         VMClassLoader.loadClass(name, false);
        var3395E90E7215A3CC7F30E04EE174D39F_298454833.addTaint(taint);
        return var3395E90E7215A3CC7F30E04EE174D39F_298454833;
        // ---------- Original Method ----------
        //return VMClassLoader.loadClass(name, false);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.701 -0400", hash_original_method = "917FC7483F620F58EBF15901F64E5CCB", hash_generated_method = "4E1D4AC820F473A58529AC1E7C815175")
    @Override
    protected URL findResource(String name) {
        addTaint(name.getTaint());
URL var7466CD68AA25041A670649C7835F7FDA_590254161 =         VMClassLoader.getResource(name);
        var7466CD68AA25041A670649C7835F7FDA_590254161.addTaint(taint);
        return var7466CD68AA25041A670649C7835F7FDA_590254161;
        // ---------- Original Method ----------
        //return VMClassLoader.getResource(name);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.701 -0400", hash_original_method = "16CE054D9A07227EFDD5E4525389B0A1", hash_generated_method = "7C0130BB41200D65DE97F2A95A0426F3")
    @SuppressWarnings("unused")
    @Override
    protected Enumeration<URL> findResources(String resName) throws IOException {
        addTaint(resName.getTaint());
Enumeration<URL> varD9496F4FD0571E4317562BDABA22F744_826452720 =         Collections.enumeration(VMClassLoader.getResources(resName));
        varD9496F4FD0571E4317562BDABA22F744_826452720.addTaint(taint);
        return varD9496F4FD0571E4317562BDABA22F744_826452720;
        // ---------- Original Method ----------
        //return Collections.enumeration(VMClassLoader.getResources(resName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.701 -0400", hash_original_method = "F97E0A3F9917A73A09E7D2F766F9C1D2", hash_generated_method = "8EFFC648557952357BEE799C371639E9")
    @Override
    protected Package getPackage(String name) {
        addTaint(name.getTaint());
        if(name != null && !name.isEmpty())        
        {
            synchronized
(this)            {
                Package pack = super.getPackage(name);
                if(pack == null)                
                {
                    pack = definePackage(name, "Unknown", "0.0", "Unknown", "Unknown", "0.0",
                            "Unknown", null);
                } //End block
Package var92767E2A4BD8914A1F39CCFB211BAF92_972622480 =                 pack;
                var92767E2A4BD8914A1F39CCFB211BAF92_972622480.addTaint(taint);
                return var92767E2A4BD8914A1F39CCFB211BAF92_972622480;
            } //End block
        } //End block
Package var540C13E9E156B687226421B24F2DF178_1522569117 =         null;
        var540C13E9E156B687226421B24F2DF178_1522569117.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1522569117;
        // ---------- Original Method ----------
        //if (name != null && !name.isEmpty()) {
            //synchronized (this) {
                //Package pack = super.getPackage(name);
                //if (pack == null) {
                    //pack = definePackage(name, "Unknown", "0.0", "Unknown", "Unknown", "0.0",
                            //"Unknown", null);
                //}
                //return pack;
            //}
        //}
        //return null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.701 -0400", hash_original_method = "7C22470B48203835E4FECF5A2AF64904", hash_generated_method = "F4D3FDCCDB32B26E5A92FC4B6A0640AF")
    @Override
    public URL getResource(String resName) {
        addTaint(resName.getTaint());
URL var5AA152384FEC6ED20C323D9BD1349753_1871325198 =         findResource(resName);
        var5AA152384FEC6ED20C323D9BD1349753_1871325198.addTaint(taint);
        return var5AA152384FEC6ED20C323D9BD1349753_1871325198;
        // ---------- Original Method ----------
        //return findResource(resName);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.701 -0400", hash_original_method = "0851F7C9918489BAFB5B84B48223EC31", hash_generated_method = "22D84E54FB87D6295FB88CD1B589541C")
    @Override
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        addTaint(resolve);
        addTaint(className.getTaint());
        Class<?> clazz = findLoadedClass(className);
        if(clazz == null)        
        {
            clazz = findClass(className);
        } //End block
Class<?> var3E303968598B6EE307EE3739CE40F332_457242761 =         clazz;
        var3E303968598B6EE307EE3739CE40F332_457242761.addTaint(taint);
        return var3E303968598B6EE307EE3739CE40F332_457242761;
        // ---------- Original Method ----------
        //Class<?> clazz = findLoadedClass(className);
        //if (clazz == null) {
            //clazz = findClass(className);
        //}
        //return clazz;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.701 -0400", hash_original_method = "606DC58E52051EDCF71806278059C734", hash_generated_method = "682994CA1C7552D1A55DA6D12F58423A")
    @Override
    public Enumeration<URL> getResources(String resName) throws IOException {
        addTaint(resName.getTaint());
Enumeration<URL> var8CFFF96B92B65C73171B114D63463E37_1511974646 =         findResources(resName);
        var8CFFF96B92B65C73171B114D63463E37_1511974646.addTaint(taint);
        return var8CFFF96B92B65C73171B114D63463E37_1511974646;
        // ---------- Original Method ----------
        //return findResources(resName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.702 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "1B790D50CC69E7023CCCAB838EB40A4E")

    private static BootClassLoader instance;
}

