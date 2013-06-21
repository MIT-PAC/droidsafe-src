package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.PathClassLoader;
import dalvik.system.VMStack;
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

public abstract class ClassLoader {
    private ClassLoader parent;
    private Map<String, Package> packages = new HashMap<String, Package>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.644 -0400", hash_original_method = "8E76514466172FE6741D8A4C6661DD70", hash_generated_method = "67B78B96E18A8A3E4D98CDB649E9B64A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ClassLoader() {
        this(getSystemClassLoader(), false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.644 -0400", hash_original_method = "DB0BF52E0FA8D43D630F9D86095EF243", hash_generated_method = "454B3DA22656D940354220963C58DDEB")
    @DSModeled(DSC.BAN)
    protected ClassLoader(ClassLoader parentLoader) {
        this(parentLoader, false);
        dsTaint.addTaint(parentLoader.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.644 -0400", hash_original_method = "B3E4E8C3A704386E61A8D58325A9E2B7", hash_generated_method = "1897CB12EBD03CC87318DAD974E2A1FF")
    @DSModeled(DSC.BAN)
     ClassLoader(ClassLoader parentLoader, boolean nullAllowed) {
        dsTaint.addTaint(parentLoader.dsTaint);
        dsTaint.addTaint(nullAllowed);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Parent ClassLoader may not be null");
        } //End block
        // ---------- Original Method ----------
        //if (parentLoader == null && !nullAllowed) {
            //throw new NullPointerException("Parent ClassLoader may not be null");
        //}
        //parent = parentLoader;
    }

    
        private static ClassLoader createSystemClassLoader() {
        String classPath = System.getProperty("java.class.path", ".");
        return new PathClassLoader(classPath, BootClassLoader.getInstance());
    }

    
        public static ClassLoader getSystemClassLoader() {
        return SystemClassLoader.loader;
    }

    
        public static URL getSystemResource(String resName) {
        return SystemClassLoader.loader.getResource(resName);
    }

    
        public static Enumeration<URL> getSystemResources(String resName) throws IOException {
        return SystemClassLoader.loader.getResources(resName);
    }

    
        public static InputStream getSystemResourceAsStream(String resName) {
        return SystemClassLoader.loader.getResourceAsStream(resName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.645 -0400", hash_original_method = "EDBCEB3B7F6159932B32B9FEC39C429A", hash_generated_method = "89EDAC9AF4A74FB9B1637B71A6273DB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    protected final Class<?> defineClass(byte[] classRep, int offset, int length) throws ClassFormatError {
        dsTaint.addTaint(classRep[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        Class<?> var1F71E487DF26B4EDB9E103F6566E23FF_56157772 = (VMClassLoader.defineClass(this, classRep, offset, length));
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return VMClassLoader.defineClass(this, classRep, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.645 -0400", hash_original_method = "0F0A39CE7574A7CD22D1B4668E39A889", hash_generated_method = "F1945E566166924B8BE3C5B21AA235B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length) throws ClassFormatError {
        dsTaint.addTaint(classRep[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(className);
        dsTaint.addTaint(offset);
        Class<?> var722801F4B79DF2D0A7555677230D420F_1424450365 = (defineClass(className, classRep, offset, length, null));
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return defineClass(className, classRep, offset, length, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.645 -0400", hash_original_method = "EBF70D1CA87DA01178FDB05EE0827744", hash_generated_method = "6A4859D7EDE334D130C076BBED1F038E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length,
            ProtectionDomain protectionDomain) throws java.lang.ClassFormatError {
        dsTaint.addTaint(classRep[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(protectionDomain.dsTaint);
        dsTaint.addTaint(className);
        dsTaint.addTaint(offset);
        Class<?> var1BE1DEE13670C0D28A0C70B3A85D9AF5_1521024032 = (VMClassLoader.defineClass(this, className, classRep, offset, length));
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return VMClassLoader.defineClass(this, className, classRep, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.646 -0400", hash_original_method = "05D340D0AFD0A4A41A098B1B021596A9", hash_generated_method = "8004F25AC230F28B80C7969AF55F4A8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final Class<?> defineClass(String name, ByteBuffer b,
            ProtectionDomain protectionDomain) throws ClassFormatError {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(protectionDomain.dsTaint);
        byte[] temp;
        temp = new byte[b.remaining()];
        b.get(temp);
        Class<?> var8A17DF28313FC91FA875A3D90C604B84_1189536398 = (defineClass(name, temp, 0, temp.length, protectionDomain));
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byte[] temp = new byte[b.remaining()];
        //b.get(temp);
        //return defineClass(name, temp, 0, temp.length, protectionDomain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.646 -0400", hash_original_method = "FDF53ED54BA8389D30C48D1E15C39772", hash_generated_method = "55A315FF67D7402DC1B797DAEC9959A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        dsTaint.addTaint(className);
        if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(className);
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ClassNotFoundException(className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.646 -0400", hash_original_method = "1BCB441A83D111A7AA8FEC24C2456543", hash_generated_method = "A36A7461394989B8787B849987F1FC45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final Class<?> findLoadedClass(String className) {
        dsTaint.addTaint(className);
        ClassLoader loader;
        {
            boolean var8F8701484415A7E2B2BB44566E20F8F8_1009774072 = (this == BootClassLoader.getInstance());
            loader = null;
            loader = this;
        } //End collapsed parenthetic
        Class<?> varE825C8D027AC765B7C3E063A0C91CAEE_158283936 = (VMClassLoader.findLoadedClass(loader, className));
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ClassLoader loader;
        //if (this == BootClassLoader.getInstance())
            //loader = null;
        //else
            //loader = this;
        //return VMClassLoader.findLoadedClass(loader, className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.646 -0400", hash_original_method = "8781F33C8E67EE4404420C5C91B2F2B8", hash_generated_method = "3CE0EF7FDC49FA15DE73CE1D0B53DA12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final Class<?> findSystemClass(String className) throws ClassNotFoundException {
        dsTaint.addTaint(className);
        Class<?> var10A3100D50DAE2EF39F28109DF93D10A_1779105978 = (Class.forName(className, false, getSystemClassLoader()));
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Class.forName(className, false, getSystemClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.646 -0400", hash_original_method = "C41AD9124585D3AEE85EC6C2F13127B8", hash_generated_method = "683988F87303F26125CCAD5F6C43E143")
    @DSModeled(DSC.BAN)
    public final ClassLoader getParent() {
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.646 -0400", hash_original_method = "51B198FC24245E471F59AEE285D4917F", hash_generated_method = "5534F8E4009601F0E76F78C837A95B4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL getResource(String resName) {
        dsTaint.addTaint(resName);
        URL resource;
        resource = parent.getResource(resName);
        {
            resource = findResource(resName);
        } //End block
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //URL resource = parent.getResource(resName);
        //if (resource == null) {
            //resource = findResource(resName);
        //}
        //return resource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.647 -0400", hash_original_method = "A1AC2BF370A36ABB9B1EEF5C25CA87C9", hash_generated_method = "633F7FACB6C13F64E0527D5C0C51DAD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public Enumeration<URL> getResources(String resName) throws IOException {
        dsTaint.addTaint(resName);
        Enumeration first;
        first = parent.getResources(resName);
        Enumeration second;
        second = findResources(resName);
        Enumeration<URL> var622CDDBF6A54C6073E0C9A90219C53C9_414512833 = (new TwoEnumerationsInOne(first, second));
        return (Enumeration<URL>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Enumeration first = parent.getResources(resName);
        //Enumeration second = findResources(resName);
        //return new TwoEnumerationsInOne(first, second);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.647 -0400", hash_original_method = "D8955CCF86190424763C439F9FDF42B6", hash_generated_method = "69ECDCA23A64140B9476E3DA53A11808")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream getResourceAsStream(String resName) {
        dsTaint.addTaint(resName);
        try 
        {
            URL url;
            url = getResource(resName);
            {
                InputStream varA98D762F67D8870FBA74B03B4F1FCE73_1381403767 = (url.openStream());
            } //End block
        } //End block
        catch (IOException ex)
        { }
        return (InputStream)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.647 -0400", hash_original_method = "B81E0F32DC432F0B3276D4B4E41F12D0", hash_generated_method = "04E5C2995B4D20663048A879FBC36B2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        dsTaint.addTaint(className);
        Class<?> var9CF42E288A0F12639E6EE1E431621F93_695907899 = (loadClass(className, false));
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loadClass(className, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.647 -0400", hash_original_method = "733CC3AC678FE7D7ABDA5F1E7A258EB2", hash_generated_method = "C21FBB0DFF62AD09E8E69EBB900D1430")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        dsTaint.addTaint(resolve);
        dsTaint.addTaint(className);
        Class<?> clazz;
        clazz = findLoadedClass(className);
        {
            try 
            {
                clazz = parent.loadClass(className, false);
            } //End block
            catch (ClassNotFoundException e)
            { }
            {
                clazz = findClass(className);
            } //End block
        } //End block
        return (Class<?>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.648 -0400", hash_original_method = "87395C94E1724A33A91DB9FA52BA76C0", hash_generated_method = "91872BC539D2FA92212F530A69CEE22E")
    @DSModeled(DSC.SAFE)
    protected final void resolveClass(Class<?> clazz) {
        dsTaint.addTaint(clazz.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.648 -0400", hash_original_method = "A0771382989D9347D13AB7091421D08A", hash_generated_method = "2B822CDD44E8AC78D6F603C8E52054B4")
    @DSModeled(DSC.SAFE)
    protected URL findResource(String resName) {
        dsTaint.addTaint(resName);
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.648 -0400", hash_original_method = "4B31BA177B6DE85B868949BABF9D20CF", hash_generated_method = "6AF6ACB549B0A2B4B8833F2DA6BD1AEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings( {
            "unchecked", "unused"
    })
    protected Enumeration<URL> findResources(String resName) throws IOException {
        dsTaint.addTaint(resName);
        Enumeration<URL> var5C40137F01DA6F56F1B997AEF02CBC8F_482433530 = (Collections.emptyEnumeration());
        return (Enumeration<URL>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.emptyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.648 -0400", hash_original_method = "77218157254CA1D97E6FAA91981AFD35", hash_generated_method = "CFC33838A5BBAC746DD99A16F2829E29")
    @DSModeled(DSC.SAFE)
    protected String findLibrary(String libName) {
        dsTaint.addTaint(libName);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.648 -0400", hash_original_method = "32CF87857A859A288886DD8F10CED2F8", hash_generated_method = "DF9EBF702BE3889A12929CFC4689263A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Package getPackage(String name) {
        dsTaint.addTaint(name);
        {
            Package var31336D67B5DE173AA9934A7CABD4024A_615501394 = (packages.get(name));
        } //End block
        return (Package)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (packages) {
            //return packages.get(name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.648 -0400", hash_original_method = "9287CE4A0AED64937C82364D387BD57D", hash_generated_method = "3DF2B81F3EA14B57B7E24F1289F59FE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Package[] getPackages() {
        {
            Collection<Package> col;
            col = packages.values();
            Package[] result;
            result = new Package[col.size()];
            col.toArray(result);
        } //End block
        return (Package[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (packages) {
            //Collection<Package> col = packages.values();
            //Package[] result = new Package[col.size()];
            //col.toArray(result);
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.649 -0400", hash_original_method = "A43EE12FE4CCED7FFCD5E4E6E6B7450E", hash_generated_method = "109C65C8230820AF1EF2A5E612856437")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Package definePackage(String name, String specTitle, String specVersion,
            String specVendor, String implTitle, String implVersion, String implVendor, URL sealBase) throws IllegalArgumentException {
        dsTaint.addTaint(specVersion);
        dsTaint.addTaint(sealBase.dsTaint);
        dsTaint.addTaint(implVendor);
        dsTaint.addTaint(specTitle);
        dsTaint.addTaint(implVersion);
        dsTaint.addTaint(name);
        dsTaint.addTaint(specVendor);
        dsTaint.addTaint(implTitle);
        {
            {
                boolean var4FC22D60BC5E4216DA180540D2BA6322_2111661890 = (packages.containsKey(name));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Package " + name + " already defined");
                } //End block
            } //End collapsed parenthetic
            Package newPackage;
            newPackage = new Package(name, specTitle, specVersion, specVendor, implTitle,
                    implVersion, implVendor, sealBase);
            packages.put(name, newPackage);
        } //End block
        return (Package)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.649 -0400", hash_original_method = "BAF7E3EE5C9000806386C90B3768A9FC", hash_generated_method = "206CC911EAB251DA1650D7141545ACB9")
    @DSModeled(DSC.SAFE)
    protected final void setSigners(Class<?> c, Object[] signers) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(signers[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.649 -0400", hash_original_method = "0651223F404879984496AF2BE37D7C48", hash_generated_method = "683659EBF44A1EB2EEE199EA5C4C6BC5")
    @DSModeled(DSC.SAFE)
    public void setClassAssertionStatus(String cname, boolean enable) {
        dsTaint.addTaint(enable);
        dsTaint.addTaint(cname);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.649 -0400", hash_original_method = "2F6CF0A6D7DAAB50984CC8577E0B6ED7", hash_generated_method = "159163C392A74517DE10E4553D6CE26A")
    @DSModeled(DSC.SAFE)
    public void setPackageAssertionStatus(String pname, boolean enable) {
        dsTaint.addTaint(enable);
        dsTaint.addTaint(pname);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.649 -0400", hash_original_method = "F3C67BF009E262C5EF85B89EAEA54A8D", hash_generated_method = "9A95C5DD6EC48C611FBEBEC4B3E9F8DF")
    @DSModeled(DSC.SAFE)
    public void setDefaultAssertionStatus(boolean enable) {
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.650 -0400", hash_original_method = "0F2B38C73B2795A58A5B8AC7764225D2", hash_generated_method = "E762A3660EF9111F915B372BD46E7E77")
    @DSModeled(DSC.SAFE)
    public void clearAssertionStatus() {
        // ---------- Original Method ----------
    }

    
    static private class SystemClassLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.650 -0400", hash_original_method = "F86EA69E3A02620B42794AF278214778", hash_generated_method = "F86EA69E3A02620B42794AF278214778")
                public SystemClassLoader ()
        {
        }


        public static ClassLoader loader = ClassLoader.createSystemClassLoader();
    }


    
}

class TwoEnumerationsInOne implements Enumeration<URL> {
    private Enumeration<URL> first;
    private Enumeration<URL> second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.650 -0400", hash_original_method = "D3D417A978FD13F0C9B8800DA2920B14", hash_generated_method = "89CBF38023A050903CBDD9409F645879")
    @DSModeled(DSC.SAFE)
    public TwoEnumerationsInOne(Enumeration<URL> first, Enumeration<URL> second) {
        dsTaint.addTaint(second.dsTaint);
        dsTaint.addTaint(first.dsTaint);
        // ---------- Original Method ----------
        //this.first = first;
        //this.second = second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.650 -0400", hash_original_method = "B34DCB72B1A55025C195F65FCCD0FE9D", hash_generated_method = "9C7C33571E0D086A1D69BDB10F9AAECD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMoreElements() {
        boolean var3B7474792343C2E0A8284A054503A681_2070595010 = (first.hasMoreElements() || second.hasMoreElements());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return first.hasMoreElements() || second.hasMoreElements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.650 -0400", hash_original_method = "CE040DB5C31CF9231E1B46430147AEAF", hash_generated_method = "DE7F2E5DAB4219A6160C9D08A7E34F60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL nextElement() {
        {
            boolean var7A58C32FEBB686E98F9F9FDEB9139188_98845448 = (first.hasMoreElements());
            {
                URL var1CAD66C168AB934BFC03E59A6502B9BA_529128815 = (first.nextElement());
            } //End block
            {
                URL varF280BEB987C819731CDD933E23E6312D_1208221676 = (second.nextElement());
            } //End block
        } //End collapsed parenthetic
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (first.hasMoreElements()) {
            //return first.nextElement();
        //} else {
            //return second.nextElement();
        //}
    }

    
}

class BootClassLoader extends ClassLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.651 -0400", hash_original_method = "D3F85B3CE9250DAE48A2E24200FC3763", hash_generated_method = "9B3A59F55A35519AA35E648BA04DC88C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BootClassLoader() {
        super(null, true);
        // ---------- Original Method ----------
    }

    
        @FindBugsSuppressWarnings("DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED")
    public static synchronized BootClassLoader getInstance() {
        if (instance == null) {
            instance = new BootClassLoader();
        }
        return instance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.651 -0400", hash_original_method = "0FBC8B1C710D0CE61299895128455485", hash_generated_method = "ABEC1B292EE44DF3422CD2BA6F6425DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        dsTaint.addTaint(name);
        Class<?> var4C2779875033EDD61A21CB2D9B7724D0_2019621898 = (VMClassLoader.loadClass(name, false));
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return VMClassLoader.loadClass(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.651 -0400", hash_original_method = "917FC7483F620F58EBF15901F64E5CCB", hash_generated_method = "6ED43B085349792A857F3C4C032C1AB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URL findResource(String name) {
        dsTaint.addTaint(name);
        URL var8A314F9C0B209712154A84308225C2B3_1018583520 = (VMClassLoader.getResource(name));
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return VMClassLoader.getResource(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.651 -0400", hash_original_method = "16CE054D9A07227EFDD5E4525389B0A1", hash_generated_method = "1D16CC6DC783238A83B6852846D7BCD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    @Override
    protected Enumeration<URL> findResources(String resName) throws IOException {
        dsTaint.addTaint(resName);
        Enumeration<URL> var3A19B6750662A0A08D6BF35ED516B9F4_1548752873 = (Collections.enumeration(VMClassLoader.getResources(resName)));
        return (Enumeration<URL>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.enumeration(VMClassLoader.getResources(resName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.652 -0400", hash_original_method = "F97E0A3F9917A73A09E7D2F766F9C1D2", hash_generated_method = "BA98BF71A4EAB221F3F294D791B594F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Package getPackage(String name) {
        dsTaint.addTaint(name);
        {
            boolean var8F2A85FBA5C7FD01FD8C0BFF3B70DD8B_1865019383 = (name != null && !name.isEmpty());
            {
                {
                    Package pack;
                    pack = super.getPackage(name);
                    {
                        pack = definePackage(name, "Unknown", "0.0", "Unknown", "Unknown", "0.0",
                            "Unknown", null);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Package)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.652 -0400", hash_original_method = "7C22470B48203835E4FECF5A2AF64904", hash_generated_method = "F8CC0859562D82427D7808FCDE1E5CB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public URL getResource(String resName) {
        dsTaint.addTaint(resName);
        URL var14126CE3D31B1414D19E5BFD466AD78A_1485829185 = (findResource(resName));
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return findResource(resName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.652 -0400", hash_original_method = "0851F7C9918489BAFB5B84B48223EC31", hash_generated_method = "AC02773771939AAC94337734B14F76F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        dsTaint.addTaint(resolve);
        dsTaint.addTaint(className);
        Class<?> clazz;
        clazz = findLoadedClass(className);
        {
            clazz = findClass(className);
        } //End block
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Class<?> clazz = findLoadedClass(className);
        //if (clazz == null) {
            //clazz = findClass(className);
        //}
        //return clazz;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.652 -0400", hash_original_method = "606DC58E52051EDCF71806278059C734", hash_generated_method = "B8239FE032F0C301D9C47490C6416CCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Enumeration<URL> getResources(String resName) throws IOException {
        dsTaint.addTaint(resName);
        Enumeration<URL> var03E2F0A8A06ACA10D5A72E0400DEDEEA_1154120787 = (findResources(resName));
        return (Enumeration<URL>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return findResources(resName);
    }

    
    private static BootClassLoader instance;
}

