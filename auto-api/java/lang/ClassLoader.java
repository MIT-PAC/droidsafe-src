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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.361 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "F21C7A33E41D98EA12963007269D2C47")

    private ClassLoader parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.361 -0400", hash_original_field = "2BB685EC85A743CD8A1D9EC57E6CA93C", hash_generated_field = "D93E16E52D6392375771C09EA3DB6BEE")

    private Map<String, Package> packages = new HashMap<String, Package>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.362 -0400", hash_original_method = "8E76514466172FE6741D8A4C6661DD70", hash_generated_method = "67B78B96E18A8A3E4D98CDB649E9B64A")
    protected  ClassLoader() {
        this(getSystemClassLoader(), false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.373 -0400", hash_original_method = "DB0BF52E0FA8D43D630F9D86095EF243", hash_generated_method = "68E30502081669C8BA075C762E52DBD8")
    protected  ClassLoader(ClassLoader parentLoader) {
        this(parentLoader, false);
        addTaint(parentLoader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.376 -0400", hash_original_method = "B3E4E8C3A704386E61A8D58325A9E2B7", hash_generated_method = "B5985C8077D8C3ABDF406538E33C146F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.381 -0400", hash_original_method = "EDBCEB3B7F6159932B32B9FEC39C429A", hash_generated_method = "D1C31043FFD6342311CFC849EF7154FE")
    @Deprecated
    protected final Class<?> defineClass(byte[] classRep, int offset, int length) throws ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1107282115 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1107282115 = VMClassLoader.defineClass(this, classRep, offset, length);
        addTaint(classRep[0]);
        addTaint(offset);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_1107282115.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1107282115;
        // ---------- Original Method ----------
        //return VMClassLoader.defineClass(this, classRep, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.382 -0400", hash_original_method = "0F0A39CE7574A7CD22D1B4668E39A889", hash_generated_method = "AC19F9EA0C0CCF3048052A91FADA38CC")
    protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length) throws ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_75577007 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_75577007 = defineClass(className, classRep, offset, length, null);
        addTaint(className.getTaint());
        addTaint(classRep[0]);
        addTaint(offset);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_75577007.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_75577007;
        // ---------- Original Method ----------
        //return defineClass(className, classRep, offset, length, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.385 -0400", hash_original_method = "EBF70D1CA87DA01178FDB05EE0827744", hash_generated_method = "D72409074FC937CDEC4F8F2D7C2BB100")
    protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length,
            ProtectionDomain protectionDomain) throws java.lang.ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_493267171 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_493267171 = VMClassLoader.defineClass(this, className, classRep, offset, length);
        addTaint(className.getTaint());
        addTaint(classRep[0]);
        addTaint(offset);
        addTaint(length);
        addTaint(protectionDomain.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_493267171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_493267171;
        // ---------- Original Method ----------
        //return VMClassLoader.defineClass(this, className, classRep, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.386 -0400", hash_original_method = "05D340D0AFD0A4A41A098B1B021596A9", hash_generated_method = "D29956677274EE7F51C106733F52F652")
    protected final Class<?> defineClass(String name, ByteBuffer b,
            ProtectionDomain protectionDomain) throws ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1688220146 = null; //Variable for return #1
        byte[] temp;
        temp = new byte[b.remaining()];
        b.get(temp);
        varB4EAC82CA7396A68D541C85D26508E83_1688220146 = defineClass(name, temp, 0, temp.length, protectionDomain);
        addTaint(name.getTaint());
        addTaint(b.getTaint());
        addTaint(protectionDomain.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1688220146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1688220146;
        // ---------- Original Method ----------
        //byte[] temp = new byte[b.remaining()];
        //b.get(temp);
        //return defineClass(name, temp, 0, temp.length, protectionDomain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.389 -0400", hash_original_method = "FDF53ED54BA8389D30C48D1E15C39772", hash_generated_method = "604BCE4B6C38EF47CE78A32F69F193EE")
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(className);
        addTaint(className.getTaint());
        // ---------- Original Method ----------
        //throw new ClassNotFoundException(className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.390 -0400", hash_original_method = "1BCB441A83D111A7AA8FEC24C2456543", hash_generated_method = "79D4596B77112DB41309F9CEAD283A45")
    protected final Class<?> findLoadedClass(String className) {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1845596560 = null; //Variable for return #1
        ClassLoader loader;
        {
            boolean var8F8701484415A7E2B2BB44566E20F8F8_1590095611 = (this == BootClassLoader.getInstance());
            loader = null;
            loader = this;
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1845596560 = VMClassLoader.findLoadedClass(loader, className);
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1845596560.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1845596560;
        // ---------- Original Method ----------
        //ClassLoader loader;
        //if (this == BootClassLoader.getInstance())
            //loader = null;
        //else
            //loader = this;
        //return VMClassLoader.findLoadedClass(loader, className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.400 -0400", hash_original_method = "8781F33C8E67EE4404420C5C91B2F2B8", hash_generated_method = "8208B967E500C7417954225D56DECE52")
    protected final Class<?> findSystemClass(String className) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1888132618 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1888132618 = Class.forName(className, false, getSystemClassLoader());
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1888132618.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1888132618;
        // ---------- Original Method ----------
        //return Class.forName(className, false, getSystemClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.401 -0400", hash_original_method = "C41AD9124585D3AEE85EC6C2F13127B8", hash_generated_method = "7DC683061CA33F4BD30E151754FB11E5")
    public final ClassLoader getParent() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1928310809 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1928310809 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_1928310809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1928310809;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.401 -0400", hash_original_method = "51B198FC24245E471F59AEE285D4917F", hash_generated_method = "BA1E90B777589D01C874668E1E39ABC5")
    public URL getResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_1976583906 = null; //Variable for return #1
        URL resource;
        resource = parent.getResource(resName);
        {
            resource = findResource(resName);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1976583906 = resource;
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1976583906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1976583906;
        // ---------- Original Method ----------
        //URL resource = parent.getResource(resName);
        //if (resource == null) {
            //resource = findResource(resName);
        //}
        //return resource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.404 -0400", hash_original_method = "A1AC2BF370A36ABB9B1EEF5C25CA87C9", hash_generated_method = "F21CE783672209C8D1DF8B575D3051DD")
    @SuppressWarnings("unchecked")
    public Enumeration<URL> getResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_383743867 = null; //Variable for return #1
        Enumeration first;
        first = parent.getResources(resName);
        Enumeration second;
        second = findResources(resName);
        varB4EAC82CA7396A68D541C85D26508E83_383743867 = new TwoEnumerationsInOne(first, second);
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_383743867.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_383743867;
        // ---------- Original Method ----------
        //Enumeration first = parent.getResources(resName);
        //Enumeration second = findResources(resName);
        //return new TwoEnumerationsInOne(first, second);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.413 -0400", hash_original_method = "D8955CCF86190424763C439F9FDF42B6", hash_generated_method = "F5A9E38BF9AB709A1047E8A02515C2A9")
    public InputStream getResourceAsStream(String resName) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1135111046 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1624477995 = null; //Variable for return #2
        try 
        {
            URL url;
            url = getResource(resName);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1135111046 = url.openStream();
            } //End block
        } //End block
        catch (IOException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1624477995 = null;
        addTaint(resName.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_726015150; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_726015150 = varB4EAC82CA7396A68D541C85D26508E83_1135111046;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_726015150 = varB4EAC82CA7396A68D541C85D26508E83_1624477995;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_726015150.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_726015150;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.418 -0400", hash_original_method = "B81E0F32DC432F0B3276D4B4E41F12D0", hash_generated_method = "BFA830B186446E37DFDA668F2FA1B1A7")
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_966155355 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_966155355 = loadClass(className, false);
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_966155355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_966155355;
        // ---------- Original Method ----------
        //return loadClass(className, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.420 -0400", hash_original_method = "733CC3AC678FE7D7ABDA5F1E7A258EB2", hash_generated_method = "F693E2B3B3D0AE4E07CA3A561BFEEA00")
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1816734644 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1816734644 = clazz;
        addTaint(className.getTaint());
        addTaint(resolve);
        varB4EAC82CA7396A68D541C85D26508E83_1816734644.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1816734644;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.427 -0400", hash_original_method = "87395C94E1724A33A91DB9FA52BA76C0", hash_generated_method = "AECD55F08AE837F29C8894737A42DAA1")
    protected final void resolveClass(Class<?> clazz) {
        addTaint(clazz.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.428 -0400", hash_original_method = "A0771382989D9347D13AB7091421D08A", hash_generated_method = "E44A1DEC0F507DC061BA70FDCB35B6F1")
    protected URL findResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_404169877 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_404169877 = null;
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_404169877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_404169877;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.429 -0400", hash_original_method = "4B31BA177B6DE85B868949BABF9D20CF", hash_generated_method = "CA863D05BA5DF8534B70BD0A3E9A0F7B")
    @SuppressWarnings( {
            "unchecked", "unused"
    })
    protected Enumeration<URL> findResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_1852250137 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1852250137 = Collections.emptyEnumeration();
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1852250137.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1852250137;
        // ---------- Original Method ----------
        //return Collections.emptyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.429 -0400", hash_original_method = "77218157254CA1D97E6FAA91981AFD35", hash_generated_method = "4F856A8D26F8254C3BA3B4EE66C0B99A")
    protected String findLibrary(String libName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1021863576 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1021863576 = null;
        addTaint(libName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1021863576.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1021863576;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.438 -0400", hash_original_method = "32CF87857A859A288886DD8F10CED2F8", hash_generated_method = "B3D11B8B36592ADC2F766374AFC5F19E")
    protected Package getPackage(String name) {
        Package varB4EAC82CA7396A68D541C85D26508E83_703597043 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_703597043 = packages.get(name);
        } //End block
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_703597043.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_703597043;
        // ---------- Original Method ----------
        //synchronized (packages) {
            //return packages.get(name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.439 -0400", hash_original_method = "9287CE4A0AED64937C82364D387BD57D", hash_generated_method = "3CA99A4CD43F1B18833A9AB9EDF8C059")
    protected Package[] getPackages() {
        Package[] varB4EAC82CA7396A68D541C85D26508E83_1098734432 = null; //Variable for return #1
        {
            Collection<Package> col;
            col = packages.values();
            Package[] result;
            result = new Package[col.size()];
            col.toArray(result);
            varB4EAC82CA7396A68D541C85D26508E83_1098734432 = result;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1098734432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1098734432;
        // ---------- Original Method ----------
        //synchronized (packages) {
            //Collection<Package> col = packages.values();
            //Package[] result = new Package[col.size()];
            //col.toArray(result);
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.497 -0400", hash_original_method = "A43EE12FE4CCED7FFCD5E4E6E6B7450E", hash_generated_method = "F48A9725CB8ECD57422CA0030694046F")
    protected Package definePackage(String name, String specTitle, String specVersion,
            String specVendor, String implTitle, String implVersion, String implVendor, URL sealBase) throws IllegalArgumentException {
        Package varB4EAC82CA7396A68D541C85D26508E83_1903729313 = null; //Variable for return #1
        {
            {
                boolean var4FC22D60BC5E4216DA180540D2BA6322_76216493 = (packages.containsKey(name));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Package " + name + " already defined");
                } //End block
            } //End collapsed parenthetic
            Package newPackage;
            newPackage = new Package(name, specTitle, specVersion, specVendor, implTitle,
                    implVersion, implVendor, sealBase);
            packages.put(name, newPackage);
            varB4EAC82CA7396A68D541C85D26508E83_1903729313 = newPackage;
        } //End block
        addTaint(name.getTaint());
        addTaint(specTitle.getTaint());
        addTaint(specVersion.getTaint());
        addTaint(specVendor.getTaint());
        addTaint(implTitle.getTaint());
        addTaint(implVersion.getTaint());
        addTaint(implVendor.getTaint());
        addTaint(sealBase.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1903729313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1903729313;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.498 -0400", hash_original_method = "BAF7E3EE5C9000806386C90B3768A9FC", hash_generated_method = "498D842B4E2F87827F00CFCED696B29B")
    protected final void setSigners(Class<?> c, Object[] signers) {
        addTaint(c.getTaint());
        addTaint(signers[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.499 -0400", hash_original_method = "0651223F404879984496AF2BE37D7C48", hash_generated_method = "9552549080184D933A18FAE2024809E7")
    public void setClassAssertionStatus(String cname, boolean enable) {
        addTaint(cname.getTaint());
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.499 -0400", hash_original_method = "2F6CF0A6D7DAAB50984CC8577E0B6ED7", hash_generated_method = "DE2C1361DEB1CC3CD98E704C0E124F3C")
    public void setPackageAssertionStatus(String pname, boolean enable) {
        addTaint(pname.getTaint());
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.499 -0400", hash_original_method = "F3C67BF009E262C5EF85B89EAEA54A8D", hash_generated_method = "9CCCF9B831F31B11857410609390EEBD")
    public void setDefaultAssertionStatus(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.499 -0400", hash_original_method = "0F2B38C73B2795A58A5B8AC7764225D2", hash_generated_method = "E762A3660EF9111F915B372BD46E7E77")
    public void clearAssertionStatus() {
        // ---------- Original Method ----------
    }

    
    static private class SystemClassLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.503 -0400", hash_original_method = "5CAD2AFC0F0FA3887E4002E77FFD0C7D", hash_generated_method = "5CAD2AFC0F0FA3887E4002E77FFD0C7D")
        public SystemClassLoader ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.503 -0400", hash_original_field = "9E858FEF25484C5FE1CB8BD38218B4F2", hash_generated_field = "9F05049E5285C9256C3F77BCE2FFFB9C")

        public static ClassLoader loader = ClassLoader.createSystemClassLoader();
    }


    
}

class TwoEnumerationsInOne implements Enumeration<URL> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.503 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "8251EE6159DCC0C25ACB4653E04140B7")

    private Enumeration<URL> first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.503 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "48331890F3BE0E00347927CE21AF464F")

    private Enumeration<URL> second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.504 -0400", hash_original_method = "D3D417A978FD13F0C9B8800DA2920B14", hash_generated_method = "DC7052B6806C57873B5AB28FCC7C1781")
    public  TwoEnumerationsInOne(Enumeration<URL> first, Enumeration<URL> second) {
        this.first = first;
        this.second = second;
        // ---------- Original Method ----------
        //this.first = first;
        //this.second = second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.504 -0400", hash_original_method = "B34DCB72B1A55025C195F65FCCD0FE9D", hash_generated_method = "6B7993258EECB967EBD5B566C91AB66C")
    public boolean hasMoreElements() {
        boolean var3B7474792343C2E0A8284A054503A681_1168028985 = (first.hasMoreElements() || second.hasMoreElements());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1754372270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1754372270;
        // ---------- Original Method ----------
        //return first.hasMoreElements() || second.hasMoreElements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.505 -0400", hash_original_method = "CE040DB5C31CF9231E1B46430147AEAF", hash_generated_method = "3F136FFE1399B39E1BFD5BDB6412070A")
    public URL nextElement() {
        URL varB4EAC82CA7396A68D541C85D26508E83_1225258748 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_1545891626 = null; //Variable for return #2
        {
            boolean var7A58C32FEBB686E98F9F9FDEB9139188_2024602685 = (first.hasMoreElements());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1225258748 = first.nextElement();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1545891626 = second.nextElement();
            } //End block
        } //End collapsed parenthetic
        URL varA7E53CE21691AB073D9660D615818899_1606089627; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1606089627 = varB4EAC82CA7396A68D541C85D26508E83_1225258748;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1606089627 = varB4EAC82CA7396A68D541C85D26508E83_1545891626;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1606089627.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1606089627;
        // ---------- Original Method ----------
        //if (first.hasMoreElements()) {
            //return first.nextElement();
        //} else {
            //return second.nextElement();
        //}
    }

    
}

class BootClassLoader extends ClassLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.505 -0400", hash_original_method = "D3F85B3CE9250DAE48A2E24200FC3763", hash_generated_method = "9B3A59F55A35519AA35E648BA04DC88C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.505 -0400", hash_original_method = "0FBC8B1C710D0CE61299895128455485", hash_generated_method = "369371E7A53E4AB0D3F4743849F0AB2C")
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_2121130002 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2121130002 = VMClassLoader.loadClass(name, false);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2121130002.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2121130002;
        // ---------- Original Method ----------
        //return VMClassLoader.loadClass(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.513 -0400", hash_original_method = "917FC7483F620F58EBF15901F64E5CCB", hash_generated_method = "62061611DF495A95DF1F7C6FF5CA5DFD")
    @Override
    protected URL findResource(String name) {
        URL varB4EAC82CA7396A68D541C85D26508E83_1341739783 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1341739783 = VMClassLoader.getResource(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1341739783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1341739783;
        // ---------- Original Method ----------
        //return VMClassLoader.getResource(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.532 -0400", hash_original_method = "16CE054D9A07227EFDD5E4525389B0A1", hash_generated_method = "CAD8E96E812936EEADD698DA07C4A250")
    @SuppressWarnings("unused")
    @Override
    protected Enumeration<URL> findResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_855621139 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_855621139 = Collections.enumeration(VMClassLoader.getResources(resName));
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_855621139.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_855621139;
        // ---------- Original Method ----------
        //return Collections.enumeration(VMClassLoader.getResources(resName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.533 -0400", hash_original_method = "F97E0A3F9917A73A09E7D2F766F9C1D2", hash_generated_method = "17A41C223A198EFB8FF9BA957194FC22")
    @Override
    protected Package getPackage(String name) {
        Package varB4EAC82CA7396A68D541C85D26508E83_1652153915 = null; //Variable for return #1
        Package varB4EAC82CA7396A68D541C85D26508E83_303072070 = null; //Variable for return #2
        {
            boolean var8F2A85FBA5C7FD01FD8C0BFF3B70DD8B_1659371764 = (name != null && !name.isEmpty());
            {
                {
                    Package pack;
                    pack = super.getPackage(name);
                    {
                        pack = definePackage(name, "Unknown", "0.0", "Unknown", "Unknown", "0.0",
                            "Unknown", null);
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_1652153915 = pack;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_303072070 = null;
        addTaint(name.getTaint());
        Package varA7E53CE21691AB073D9660D615818899_32588093; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_32588093 = varB4EAC82CA7396A68D541C85D26508E83_1652153915;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_32588093 = varB4EAC82CA7396A68D541C85D26508E83_303072070;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_32588093.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_32588093;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.533 -0400", hash_original_method = "7C22470B48203835E4FECF5A2AF64904", hash_generated_method = "F194160ABD7A8095169D03E4E97FD89A")
    @Override
    public URL getResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_2069290053 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2069290053 = findResource(resName);
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2069290053.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2069290053;
        // ---------- Original Method ----------
        //return findResource(resName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.534 -0400", hash_original_method = "0851F7C9918489BAFB5B84B48223EC31", hash_generated_method = "825B7CCAB9FCA29951908BA3BBC69166")
    @Override
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_958058638 = null; //Variable for return #1
        Class<?> clazz;
        clazz = findLoadedClass(className);
        {
            clazz = findClass(className);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_958058638 = clazz;
        addTaint(className.getTaint());
        addTaint(resolve);
        varB4EAC82CA7396A68D541C85D26508E83_958058638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_958058638;
        // ---------- Original Method ----------
        //Class<?> clazz = findLoadedClass(className);
        //if (clazz == null) {
            //clazz = findClass(className);
        //}
        //return clazz;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.534 -0400", hash_original_method = "606DC58E52051EDCF71806278059C734", hash_generated_method = "0BFBF3FFB0EA24B751848DE7AD1E8601")
    @Override
    public Enumeration<URL> getResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_38420128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_38420128 = findResources(resName);
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_38420128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_38420128;
        // ---------- Original Method ----------
        //return findResources(resName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.534 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "1B790D50CC69E7023CCCAB838EB40A4E")

    private static BootClassLoader instance;
}

