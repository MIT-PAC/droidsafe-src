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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.821 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "F21C7A33E41D98EA12963007269D2C47")

    private ClassLoader parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.821 -0400", hash_original_field = "2BB685EC85A743CD8A1D9EC57E6CA93C", hash_generated_field = "D93E16E52D6392375771C09EA3DB6BEE")

    private Map<String, Package> packages = new HashMap<String, Package>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.821 -0400", hash_original_method = "8E76514466172FE6741D8A4C6661DD70", hash_generated_method = "67B78B96E18A8A3E4D98CDB649E9B64A")
    protected  ClassLoader() {
        this(getSystemClassLoader(), false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.821 -0400", hash_original_method = "DB0BF52E0FA8D43D630F9D86095EF243", hash_generated_method = "68E30502081669C8BA075C762E52DBD8")
    protected  ClassLoader(ClassLoader parentLoader) {
        this(parentLoader, false);
        addTaint(parentLoader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.822 -0400", hash_original_method = "B3E4E8C3A704386E61A8D58325A9E2B7", hash_generated_method = "B5985C8077D8C3ABDF406538E33C146F")
      ClassLoader(ClassLoader parentLoader, boolean nullAllowed) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Parent ClassLoader may not be null");
        } //End block
        parent = parentLoader;
        addTaint(nullAllowed);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.823 -0400", hash_original_method = "EDBCEB3B7F6159932B32B9FEC39C429A", hash_generated_method = "797D3BB3A4BD0F225A171C72EF83CA5A")
    @Deprecated
    protected final Class<?> defineClass(byte[] classRep, int offset, int length) throws ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1248081682 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1248081682 = VMClassLoader.defineClass(this, classRep, offset, length);
        addTaint(classRep[0]);
        addTaint(offset);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_1248081682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1248081682;
        // ---------- Original Method ----------
        //return VMClassLoader.defineClass(this, classRep, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.823 -0400", hash_original_method = "0F0A39CE7574A7CD22D1B4668E39A889", hash_generated_method = "15290351032B9922A6FB3AFCD9762034")
    protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length) throws ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_187566255 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_187566255 = defineClass(className, classRep, offset, length, null);
        addTaint(className.getTaint());
        addTaint(classRep[0]);
        addTaint(offset);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_187566255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_187566255;
        // ---------- Original Method ----------
        //return defineClass(className, classRep, offset, length, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.824 -0400", hash_original_method = "EBF70D1CA87DA01178FDB05EE0827744", hash_generated_method = "42B60E4A330211800E54B0BCFE821A25")
    protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length,
            ProtectionDomain protectionDomain) throws java.lang.ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1255487187 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1255487187 = VMClassLoader.defineClass(this, className, classRep, offset, length);
        addTaint(className.getTaint());
        addTaint(classRep[0]);
        addTaint(offset);
        addTaint(length);
        addTaint(protectionDomain.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1255487187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1255487187;
        // ---------- Original Method ----------
        //return VMClassLoader.defineClass(this, className, classRep, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.826 -0400", hash_original_method = "05D340D0AFD0A4A41A098B1B021596A9", hash_generated_method = "34F71CFD91D8A9F1FB160BBDDF0128C4")
    protected final Class<?> defineClass(String name, ByteBuffer b,
            ProtectionDomain protectionDomain) throws ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1650371715 = null; //Variable for return #1
        byte[] temp = new byte[b.remaining()];
        b.get(temp);
        varB4EAC82CA7396A68D541C85D26508E83_1650371715 = defineClass(name, temp, 0, temp.length, protectionDomain);
        addTaint(name.getTaint());
        addTaint(b.getTaint());
        addTaint(protectionDomain.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1650371715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1650371715;
        // ---------- Original Method ----------
        //byte[] temp = new byte[b.remaining()];
        //b.get(temp);
        //return defineClass(name, temp, 0, temp.length, protectionDomain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.828 -0400", hash_original_method = "FDF53ED54BA8389D30C48D1E15C39772", hash_generated_method = "604BCE4B6C38EF47CE78A32F69F193EE")
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        throw new ClassNotFoundException(className);
      
        // ---------- Original Method ----------
        //throw new ClassNotFoundException(className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.830 -0400", hash_original_method = "1BCB441A83D111A7AA8FEC24C2456543", hash_generated_method = "25A243C35AD879CFD76D679299586F68")
    protected final Class<?> findLoadedClass(String className) {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_144047643 = null; //Variable for return #1
        ClassLoader loader;
        {
            boolean var8F8701484415A7E2B2BB44566E20F8F8_1180336585 = (this == BootClassLoader.getInstance());
            loader = null;
            loader = this;
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_144047643 = VMClassLoader.findLoadedClass(loader, className);
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_144047643.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_144047643;
        // ---------- Original Method ----------
        //ClassLoader loader;
        //if (this == BootClassLoader.getInstance())
            //loader = null;
        //else
            //loader = this;
        //return VMClassLoader.findLoadedClass(loader, className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.831 -0400", hash_original_method = "8781F33C8E67EE4404420C5C91B2F2B8", hash_generated_method = "FE7A5AC2469DC4003988E3042B9F62A8")
    protected final Class<?> findSystemClass(String className) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_872182102 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_872182102 = Class.forName(className, false, getSystemClassLoader());
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_872182102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_872182102;
        // ---------- Original Method ----------
        //return Class.forName(className, false, getSystemClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.831 -0400", hash_original_method = "C41AD9124585D3AEE85EC6C2F13127B8", hash_generated_method = "609FBC6170BAA7CCFDB683563B5BD6DD")
    public final ClassLoader getParent() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_725330082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_725330082 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_725330082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_725330082;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.832 -0400", hash_original_method = "51B198FC24245E471F59AEE285D4917F", hash_generated_method = "F29D93C4E1214827BE5DA9D1F92AA211")
    public URL getResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_798311009 = null; //Variable for return #1
        URL resource = parent.getResource(resName);
        {
            resource = findResource(resName);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_798311009 = resource;
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_798311009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_798311009;
        // ---------- Original Method ----------
        //URL resource = parent.getResource(resName);
        //if (resource == null) {
            //resource = findResource(resName);
        //}
        //return resource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.833 -0400", hash_original_method = "A1AC2BF370A36ABB9B1EEF5C25CA87C9", hash_generated_method = "73925FC395E9A4C443272DAB4A093340")
    @SuppressWarnings("unchecked")
    public Enumeration<URL> getResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_1504416040 = null; //Variable for return #1
        Enumeration first = parent.getResources(resName);
        Enumeration second = findResources(resName);
        varB4EAC82CA7396A68D541C85D26508E83_1504416040 = new TwoEnumerationsInOne(first, second);
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1504416040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1504416040;
        // ---------- Original Method ----------
        //Enumeration first = parent.getResources(resName);
        //Enumeration second = findResources(resName);
        //return new TwoEnumerationsInOne(first, second);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.834 -0400", hash_original_method = "D8955CCF86190424763C439F9FDF42B6", hash_generated_method = "665E0F5A87C756979B2393A3DC039DC9")
    public InputStream getResourceAsStream(String resName) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1210959697 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1283680074 = null; //Variable for return #2
        try 
        {
            URL url = getResource(resName);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1210959697 = url.openStream();
            } //End block
        } //End block
        catch (IOException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1283680074 = null;
        addTaint(resName.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_1278526613; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1278526613 = varB4EAC82CA7396A68D541C85D26508E83_1210959697;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1278526613 = varB4EAC82CA7396A68D541C85D26508E83_1283680074;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1278526613.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1278526613;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.835 -0400", hash_original_method = "B81E0F32DC432F0B3276D4B4E41F12D0", hash_generated_method = "21FE0C566E22F52C6F9E8786809A1B85")
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_395536635 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_395536635 = loadClass(className, false);
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_395536635.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_395536635;
        // ---------- Original Method ----------
        //return loadClass(className, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.836 -0400", hash_original_method = "733CC3AC678FE7D7ABDA5F1E7A258EB2", hash_generated_method = "A7CA060BEE9D452A01A9F5270D87C625")
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1662102694 = null; //Variable for return #1
        Class<?> clazz = findLoadedClass(className);
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
        varB4EAC82CA7396A68D541C85D26508E83_1662102694 = clazz;
        addTaint(className.getTaint());
        addTaint(resolve);
        varB4EAC82CA7396A68D541C85D26508E83_1662102694.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1662102694;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.837 -0400", hash_original_method = "87395C94E1724A33A91DB9FA52BA76C0", hash_generated_method = "AECD55F08AE837F29C8894737A42DAA1")
    protected final void resolveClass(Class<?> clazz) {
        addTaint(clazz.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.838 -0400", hash_original_method = "A0771382989D9347D13AB7091421D08A", hash_generated_method = "C18F77D8B1704C1AA360CFB762E16113")
    protected URL findResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_2073059668 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2073059668 = null;
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2073059668.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2073059668;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.839 -0400", hash_original_method = "4B31BA177B6DE85B868949BABF9D20CF", hash_generated_method = "A58F9AAC0A1962384A2C854336BB9028")
    @SuppressWarnings( {
            "unchecked", "unused"
    })
    protected Enumeration<URL> findResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_1492568823 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1492568823 = Collections.emptyEnumeration();
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1492568823.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1492568823;
        // ---------- Original Method ----------
        //return Collections.emptyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.840 -0400", hash_original_method = "77218157254CA1D97E6FAA91981AFD35", hash_generated_method = "EAA8EDFE133F98030A5D1D23AD3F317D")
    protected String findLibrary(String libName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1195000074 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1195000074 = null;
        addTaint(libName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1195000074.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1195000074;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.841 -0400", hash_original_method = "32CF87857A859A288886DD8F10CED2F8", hash_generated_method = "5E0B1ECFC223ACF6911D57596B0AC3B4")
    protected Package getPackage(String name) {
        Package varB4EAC82CA7396A68D541C85D26508E83_548599380 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_548599380 = packages.get(name);
        } //End block
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_548599380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_548599380;
        // ---------- Original Method ----------
        //synchronized (packages) {
            //return packages.get(name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.841 -0400", hash_original_method = "9287CE4A0AED64937C82364D387BD57D", hash_generated_method = "B84B5AB554EF966618DDE9E6CA6CAC0D")
    protected Package[] getPackages() {
        Package[] varB4EAC82CA7396A68D541C85D26508E83_681956449 = null; //Variable for return #1
        {
            Collection<Package> col = packages.values();
            Package[] result = new Package[col.size()];
            col.toArray(result);
            varB4EAC82CA7396A68D541C85D26508E83_681956449 = result;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_681956449.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_681956449;
        // ---------- Original Method ----------
        //synchronized (packages) {
            //Collection<Package> col = packages.values();
            //Package[] result = new Package[col.size()];
            //col.toArray(result);
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.842 -0400", hash_original_method = "A43EE12FE4CCED7FFCD5E4E6E6B7450E", hash_generated_method = "EEF65BD3E4B20AC8E02AE0D3B28B9BA2")
    protected Package definePackage(String name, String specTitle, String specVersion,
            String specVendor, String implTitle, String implVersion, String implVendor, URL sealBase) throws IllegalArgumentException {
        Package varB4EAC82CA7396A68D541C85D26508E83_3835966 = null; //Variable for return #1
        {
            {
                boolean var4FC22D60BC5E4216DA180540D2BA6322_695171747 = (packages.containsKey(name));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Package " + name + " already defined");
                } //End block
            } //End collapsed parenthetic
            Package newPackage = new Package(name, specTitle, specVersion, specVendor, implTitle,
                    implVersion, implVendor, sealBase);
            packages.put(name, newPackage);
            varB4EAC82CA7396A68D541C85D26508E83_3835966 = newPackage;
        } //End block
        addTaint(name.getTaint());
        addTaint(specTitle.getTaint());
        addTaint(specVersion.getTaint());
        addTaint(specVendor.getTaint());
        addTaint(implTitle.getTaint());
        addTaint(implVersion.getTaint());
        addTaint(implVendor.getTaint());
        addTaint(sealBase.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_3835966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_3835966;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.843 -0400", hash_original_method = "BAF7E3EE5C9000806386C90B3768A9FC", hash_generated_method = "498D842B4E2F87827F00CFCED696B29B")
    protected final void setSigners(Class<?> c, Object[] signers) {
        addTaint(c.getTaint());
        addTaint(signers[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.844 -0400", hash_original_method = "0651223F404879984496AF2BE37D7C48", hash_generated_method = "9552549080184D933A18FAE2024809E7")
    public void setClassAssertionStatus(String cname, boolean enable) {
        addTaint(cname.getTaint());
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.844 -0400", hash_original_method = "2F6CF0A6D7DAAB50984CC8577E0B6ED7", hash_generated_method = "DE2C1361DEB1CC3CD98E704C0E124F3C")
    public void setPackageAssertionStatus(String pname, boolean enable) {
        addTaint(pname.getTaint());
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.845 -0400", hash_original_method = "F3C67BF009E262C5EF85B89EAEA54A8D", hash_generated_method = "9CCCF9B831F31B11857410609390EEBD")
    public void setDefaultAssertionStatus(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.845 -0400", hash_original_method = "0F2B38C73B2795A58A5B8AC7764225D2", hash_generated_method = "E762A3660EF9111F915B372BD46E7E77")
    public void clearAssertionStatus() {
        // ---------- Original Method ----------
    }

    
    static private class SystemClassLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.845 -0400", hash_original_method = "5CAD2AFC0F0FA3887E4002E77FFD0C7D", hash_generated_method = "5CAD2AFC0F0FA3887E4002E77FFD0C7D")
        public SystemClassLoader ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.845 -0400", hash_original_field = "9E858FEF25484C5FE1CB8BD38218B4F2", hash_generated_field = "9F05049E5285C9256C3F77BCE2FFFB9C")

        public static ClassLoader loader = ClassLoader.createSystemClassLoader();
    }


    
}

class TwoEnumerationsInOne implements Enumeration<URL> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.845 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "8251EE6159DCC0C25ACB4653E04140B7")

    private Enumeration<URL> first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.845 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "48331890F3BE0E00347927CE21AF464F")

    private Enumeration<URL> second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.846 -0400", hash_original_method = "D3D417A978FD13F0C9B8800DA2920B14", hash_generated_method = "DC7052B6806C57873B5AB28FCC7C1781")
    public  TwoEnumerationsInOne(Enumeration<URL> first, Enumeration<URL> second) {
        this.first = first;
        this.second = second;
        // ---------- Original Method ----------
        //this.first = first;
        //this.second = second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.846 -0400", hash_original_method = "B34DCB72B1A55025C195F65FCCD0FE9D", hash_generated_method = "34C06C3E2E821BF1A94F8A098E5E76D4")
    public boolean hasMoreElements() {
        boolean var3B7474792343C2E0A8284A054503A681_1142832332 = (first.hasMoreElements() || second.hasMoreElements());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922950781 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_922950781;
        // ---------- Original Method ----------
        //return first.hasMoreElements() || second.hasMoreElements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.847 -0400", hash_original_method = "CE040DB5C31CF9231E1B46430147AEAF", hash_generated_method = "1D979CFCC85907229BBEA2C6F771F356")
    public URL nextElement() {
        URL varB4EAC82CA7396A68D541C85D26508E83_205357243 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_1223767587 = null; //Variable for return #2
        {
            boolean var7A58C32FEBB686E98F9F9FDEB9139188_97062278 = (first.hasMoreElements());
            {
                varB4EAC82CA7396A68D541C85D26508E83_205357243 = first.nextElement();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1223767587 = second.nextElement();
            } //End block
        } //End collapsed parenthetic
        URL varA7E53CE21691AB073D9660D615818899_1565557526; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1565557526 = varB4EAC82CA7396A68D541C85D26508E83_205357243;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1565557526 = varB4EAC82CA7396A68D541C85D26508E83_1223767587;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1565557526.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1565557526;
        // ---------- Original Method ----------
        //if (first.hasMoreElements()) {
            //return first.nextElement();
        //} else {
            //return second.nextElement();
        //}
    }

    
}

class BootClassLoader extends ClassLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.848 -0400", hash_original_method = "D3F85B3CE9250DAE48A2E24200FC3763", hash_generated_method = "9B3A59F55A35519AA35E648BA04DC88C")
    public  BootClassLoader() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.850 -0400", hash_original_method = "0FBC8B1C710D0CE61299895128455485", hash_generated_method = "CE46A9E9D2823C8AE888E9F9DCF6E97C")
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_759463392 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_759463392 = VMClassLoader.loadClass(name, false);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_759463392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_759463392;
        // ---------- Original Method ----------
        //return VMClassLoader.loadClass(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.854 -0400", hash_original_method = "917FC7483F620F58EBF15901F64E5CCB", hash_generated_method = "A4BA171992C8A5E323C6A1A8ADE347CE")
    @Override
    protected URL findResource(String name) {
        URL varB4EAC82CA7396A68D541C85D26508E83_1749072810 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1749072810 = VMClassLoader.getResource(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1749072810.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1749072810;
        // ---------- Original Method ----------
        //return VMClassLoader.getResource(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.856 -0400", hash_original_method = "16CE054D9A07227EFDD5E4525389B0A1", hash_generated_method = "F22C99C79611589FB9C7AB6649C75D9B")
    @SuppressWarnings("unused")
    @Override
    protected Enumeration<URL> findResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_377977324 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_377977324 = Collections.enumeration(VMClassLoader.getResources(resName));
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_377977324.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_377977324;
        // ---------- Original Method ----------
        //return Collections.enumeration(VMClassLoader.getResources(resName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.858 -0400", hash_original_method = "F97E0A3F9917A73A09E7D2F766F9C1D2", hash_generated_method = "A4026C6BB0B5C887E40D173369D08543")
    @Override
    protected Package getPackage(String name) {
        Package varB4EAC82CA7396A68D541C85D26508E83_678302820 = null; //Variable for return #1
        Package varB4EAC82CA7396A68D541C85D26508E83_1766063750 = null; //Variable for return #2
        {
            boolean var8F2A85FBA5C7FD01FD8C0BFF3B70DD8B_1117690602 = (name != null && !name.isEmpty());
            {
                {
                    Package pack = super.getPackage(name);
                    {
                        pack = definePackage(name, "Unknown", "0.0", "Unknown", "Unknown", "0.0",
                            "Unknown", null);
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_678302820 = pack;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1766063750 = null;
        addTaint(name.getTaint());
        Package varA7E53CE21691AB073D9660D615818899_207539044; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_207539044 = varB4EAC82CA7396A68D541C85D26508E83_678302820;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_207539044 = varB4EAC82CA7396A68D541C85D26508E83_1766063750;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_207539044.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_207539044;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.860 -0400", hash_original_method = "7C22470B48203835E4FECF5A2AF64904", hash_generated_method = "494FBA341643FC56AF503AE2EB74008C")
    @Override
    public URL getResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_732701095 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_732701095 = findResource(resName);
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_732701095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_732701095;
        // ---------- Original Method ----------
        //return findResource(resName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.862 -0400", hash_original_method = "0851F7C9918489BAFB5B84B48223EC31", hash_generated_method = "4EEEC2EEC5CB2F5CBA57E5E138383F48")
    @Override
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_58448169 = null; //Variable for return #1
        Class<?> clazz = findLoadedClass(className);
        {
            clazz = findClass(className);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_58448169 = clazz;
        addTaint(className.getTaint());
        addTaint(resolve);
        varB4EAC82CA7396A68D541C85D26508E83_58448169.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_58448169;
        // ---------- Original Method ----------
        //Class<?> clazz = findLoadedClass(className);
        //if (clazz == null) {
            //clazz = findClass(className);
        //}
        //return clazz;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.863 -0400", hash_original_method = "606DC58E52051EDCF71806278059C734", hash_generated_method = "67917811173C8BD5F3996E3B68C0CBB4")
    @Override
    public Enumeration<URL> getResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_815792438 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_815792438 = findResources(resName);
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_815792438.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_815792438;
        // ---------- Original Method ----------
        //return findResources(resName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.863 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "1B790D50CC69E7023CCCAB838EB40A4E")

    private static BootClassLoader instance;
}

