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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.241 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "F21C7A33E41D98EA12963007269D2C47")

    private ClassLoader parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.246 -0400", hash_original_field = "2BB685EC85A743CD8A1D9EC57E6CA93C", hash_generated_field = "D93E16E52D6392375771C09EA3DB6BEE")

    private Map<String, Package> packages = new HashMap<String, Package>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.246 -0400", hash_original_method = "8E76514466172FE6741D8A4C6661DD70", hash_generated_method = "67B78B96E18A8A3E4D98CDB649E9B64A")
    protected  ClassLoader() {
        this(getSystemClassLoader(), false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.246 -0400", hash_original_method = "DB0BF52E0FA8D43D630F9D86095EF243", hash_generated_method = "68E30502081669C8BA075C762E52DBD8")
    protected  ClassLoader(ClassLoader parentLoader) {
        this(parentLoader, false);
        addTaint(parentLoader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.247 -0400", hash_original_method = "B3E4E8C3A704386E61A8D58325A9E2B7", hash_generated_method = "B5985C8077D8C3ABDF406538E33C146F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.248 -0400", hash_original_method = "EDBCEB3B7F6159932B32B9FEC39C429A", hash_generated_method = "3BC6C2B4542F0A7082EBE70EC19C0534")
    @Deprecated
    protected final Class<?> defineClass(byte[] classRep, int offset, int length) throws ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_97537986 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_97537986 = VMClassLoader.defineClass(this, classRep, offset, length);
        addTaint(classRep[0]);
        addTaint(offset);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_97537986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_97537986;
        // ---------- Original Method ----------
        //return VMClassLoader.defineClass(this, classRep, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.264 -0400", hash_original_method = "0F0A39CE7574A7CD22D1B4668E39A889", hash_generated_method = "4C7F2E8F7CA9D8455B3CAD4E1C999F23")
    protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length) throws ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1903323437 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1903323437 = defineClass(className, classRep, offset, length, null);
        addTaint(className.getTaint());
        addTaint(classRep[0]);
        addTaint(offset);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_1903323437.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1903323437;
        // ---------- Original Method ----------
        //return defineClass(className, classRep, offset, length, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.265 -0400", hash_original_method = "EBF70D1CA87DA01178FDB05EE0827744", hash_generated_method = "41C6A1D116DDC5675C67471F6FB4FD9A")
    protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length,
            ProtectionDomain protectionDomain) throws java.lang.ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1306842901 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1306842901 = VMClassLoader.defineClass(this, className, classRep, offset, length);
        addTaint(className.getTaint());
        addTaint(classRep[0]);
        addTaint(offset);
        addTaint(length);
        addTaint(protectionDomain.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1306842901.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1306842901;
        // ---------- Original Method ----------
        //return VMClassLoader.defineClass(this, className, classRep, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.266 -0400", hash_original_method = "05D340D0AFD0A4A41A098B1B021596A9", hash_generated_method = "873D4F79060E5E4EFDB43DC7D2768779")
    protected final Class<?> defineClass(String name, ByteBuffer b,
            ProtectionDomain protectionDomain) throws ClassFormatError {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_577214059 = null; //Variable for return #1
        byte[] temp;
        temp = new byte[b.remaining()];
        b.get(temp);
        varB4EAC82CA7396A68D541C85D26508E83_577214059 = defineClass(name, temp, 0, temp.length, protectionDomain);
        addTaint(name.getTaint());
        addTaint(b.getTaint());
        addTaint(protectionDomain.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_577214059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_577214059;
        // ---------- Original Method ----------
        //byte[] temp = new byte[b.remaining()];
        //b.get(temp);
        //return defineClass(name, temp, 0, temp.length, protectionDomain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.266 -0400", hash_original_method = "FDF53ED54BA8389D30C48D1E15C39772", hash_generated_method = "604BCE4B6C38EF47CE78A32F69F193EE")
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(className);
        addTaint(className.getTaint());
        // ---------- Original Method ----------
        //throw new ClassNotFoundException(className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.267 -0400", hash_original_method = "1BCB441A83D111A7AA8FEC24C2456543", hash_generated_method = "B9C6503271F601BEB54F334085180004")
    protected final Class<?> findLoadedClass(String className) {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1601316096 = null; //Variable for return #1
        ClassLoader loader;
        {
            boolean var8F8701484415A7E2B2BB44566E20F8F8_1087645613 = (this == BootClassLoader.getInstance());
            loader = null;
            loader = this;
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1601316096 = VMClassLoader.findLoadedClass(loader, className);
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1601316096.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1601316096;
        // ---------- Original Method ----------
        //ClassLoader loader;
        //if (this == BootClassLoader.getInstance())
            //loader = null;
        //else
            //loader = this;
        //return VMClassLoader.findLoadedClass(loader, className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.272 -0400", hash_original_method = "8781F33C8E67EE4404420C5C91B2F2B8", hash_generated_method = "779EEAE8853A764C8BA073FF67B3752C")
    protected final Class<?> findSystemClass(String className) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_314924171 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_314924171 = Class.forName(className, false, getSystemClassLoader());
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_314924171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_314924171;
        // ---------- Original Method ----------
        //return Class.forName(className, false, getSystemClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.272 -0400", hash_original_method = "C41AD9124585D3AEE85EC6C2F13127B8", hash_generated_method = "3E611077600F9A5E3EE93C3AB00D274E")
    public final ClassLoader getParent() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_32828167 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_32828167 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_32828167.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_32828167;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.273 -0400", hash_original_method = "51B198FC24245E471F59AEE285D4917F", hash_generated_method = "E75DDFA13D5568BD770DB8F79C605CF6")
    public URL getResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_2107752727 = null; //Variable for return #1
        URL resource;
        resource = parent.getResource(resName);
        {
            resource = findResource(resName);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2107752727 = resource;
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2107752727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2107752727;
        // ---------- Original Method ----------
        //URL resource = parent.getResource(resName);
        //if (resource == null) {
            //resource = findResource(resName);
        //}
        //return resource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.279 -0400", hash_original_method = "A1AC2BF370A36ABB9B1EEF5C25CA87C9", hash_generated_method = "67BB1CFEB86B7D5243C5AAFE86F43FA3")
    @SuppressWarnings("unchecked")
    public Enumeration<URL> getResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_2142170215 = null; //Variable for return #1
        Enumeration first;
        first = parent.getResources(resName);
        Enumeration second;
        second = findResources(resName);
        varB4EAC82CA7396A68D541C85D26508E83_2142170215 = new TwoEnumerationsInOne(first, second);
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2142170215.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2142170215;
        // ---------- Original Method ----------
        //Enumeration first = parent.getResources(resName);
        //Enumeration second = findResources(resName);
        //return new TwoEnumerationsInOne(first, second);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.280 -0400", hash_original_method = "D8955CCF86190424763C439F9FDF42B6", hash_generated_method = "A444D2522A4146661B6584C5AF0C8797")
    public InputStream getResourceAsStream(String resName) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1076442756 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1241847807 = null; //Variable for return #2
        try 
        {
            URL url;
            url = getResource(resName);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1076442756 = url.openStream();
            } //End block
        } //End block
        catch (IOException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1241847807 = null;
        addTaint(resName.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_1539087545; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1539087545 = varB4EAC82CA7396A68D541C85D26508E83_1076442756;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1539087545 = varB4EAC82CA7396A68D541C85D26508E83_1241847807;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1539087545.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1539087545;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.285 -0400", hash_original_method = "B81E0F32DC432F0B3276D4B4E41F12D0", hash_generated_method = "EFC002F1181B73131AF33083EB3792E9")
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1656768839 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1656768839 = loadClass(className, false);
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1656768839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1656768839;
        // ---------- Original Method ----------
        //return loadClass(className, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.297 -0400", hash_original_method = "733CC3AC678FE7D7ABDA5F1E7A258EB2", hash_generated_method = "059C086BD1D33AA238820B74B35D5A94")
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1491180599 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1491180599 = clazz;
        addTaint(className.getTaint());
        addTaint(resolve);
        varB4EAC82CA7396A68D541C85D26508E83_1491180599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1491180599;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.298 -0400", hash_original_method = "87395C94E1724A33A91DB9FA52BA76C0", hash_generated_method = "AECD55F08AE837F29C8894737A42DAA1")
    protected final void resolveClass(Class<?> clazz) {
        addTaint(clazz.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.298 -0400", hash_original_method = "A0771382989D9347D13AB7091421D08A", hash_generated_method = "63A728FBE91CA6D7B793D18BB0017F99")
    protected URL findResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_1775419348 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1775419348 = null;
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1775419348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1775419348;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.298 -0400", hash_original_method = "4B31BA177B6DE85B868949BABF9D20CF", hash_generated_method = "F520806EFA4BDF8040F59CDE21A0A6D7")
    @SuppressWarnings( {
            "unchecked", "unused"
    })
    protected Enumeration<URL> findResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_980352443 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_980352443 = Collections.emptyEnumeration();
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_980352443.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_980352443;
        // ---------- Original Method ----------
        //return Collections.emptyEnumeration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.299 -0400", hash_original_method = "77218157254CA1D97E6FAA91981AFD35", hash_generated_method = "882FE7482249798440B870F536E0D8FD")
    protected String findLibrary(String libName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1556024777 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1556024777 = null;
        addTaint(libName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1556024777.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1556024777;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.299 -0400", hash_original_method = "32CF87857A859A288886DD8F10CED2F8", hash_generated_method = "EE28F06D6E6062ED38C174BFB8328064")
    protected Package getPackage(String name) {
        Package varB4EAC82CA7396A68D541C85D26508E83_1045713496 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1045713496 = packages.get(name);
        } //End block
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1045713496.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1045713496;
        // ---------- Original Method ----------
        //synchronized (packages) {
            //return packages.get(name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.300 -0400", hash_original_method = "9287CE4A0AED64937C82364D387BD57D", hash_generated_method = "C709FCEEF1F06656060C75B452DC16EE")
    protected Package[] getPackages() {
        Package[] varB4EAC82CA7396A68D541C85D26508E83_668789650 = null; //Variable for return #1
        {
            Collection<Package> col;
            col = packages.values();
            Package[] result;
            result = new Package[col.size()];
            col.toArray(result);
            varB4EAC82CA7396A68D541C85D26508E83_668789650 = result;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_668789650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_668789650;
        // ---------- Original Method ----------
        //synchronized (packages) {
            //Collection<Package> col = packages.values();
            //Package[] result = new Package[col.size()];
            //col.toArray(result);
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.300 -0400", hash_original_method = "A43EE12FE4CCED7FFCD5E4E6E6B7450E", hash_generated_method = "D84D8A845722D56608544E610EDB6F11")
    protected Package definePackage(String name, String specTitle, String specVersion,
            String specVendor, String implTitle, String implVersion, String implVendor, URL sealBase) throws IllegalArgumentException {
        Package varB4EAC82CA7396A68D541C85D26508E83_1066142229 = null; //Variable for return #1
        {
            {
                boolean var4FC22D60BC5E4216DA180540D2BA6322_1648400304 = (packages.containsKey(name));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Package " + name + " already defined");
                } //End block
            } //End collapsed parenthetic
            Package newPackage;
            newPackage = new Package(name, specTitle, specVersion, specVendor, implTitle,
                    implVersion, implVendor, sealBase);
            packages.put(name, newPackage);
            varB4EAC82CA7396A68D541C85D26508E83_1066142229 = newPackage;
        } //End block
        addTaint(name.getTaint());
        addTaint(specTitle.getTaint());
        addTaint(specVersion.getTaint());
        addTaint(specVendor.getTaint());
        addTaint(implTitle.getTaint());
        addTaint(implVersion.getTaint());
        addTaint(implVendor.getTaint());
        addTaint(sealBase.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1066142229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1066142229;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.317 -0400", hash_original_method = "BAF7E3EE5C9000806386C90B3768A9FC", hash_generated_method = "498D842B4E2F87827F00CFCED696B29B")
    protected final void setSigners(Class<?> c, Object[] signers) {
        addTaint(c.getTaint());
        addTaint(signers[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.317 -0400", hash_original_method = "0651223F404879984496AF2BE37D7C48", hash_generated_method = "9552549080184D933A18FAE2024809E7")
    public void setClassAssertionStatus(String cname, boolean enable) {
        addTaint(cname.getTaint());
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.318 -0400", hash_original_method = "2F6CF0A6D7DAAB50984CC8577E0B6ED7", hash_generated_method = "DE2C1361DEB1CC3CD98E704C0E124F3C")
    public void setPackageAssertionStatus(String pname, boolean enable) {
        addTaint(pname.getTaint());
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.318 -0400", hash_original_method = "F3C67BF009E262C5EF85B89EAEA54A8D", hash_generated_method = "9CCCF9B831F31B11857410609390EEBD")
    public void setDefaultAssertionStatus(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.318 -0400", hash_original_method = "0F2B38C73B2795A58A5B8AC7764225D2", hash_generated_method = "E762A3660EF9111F915B372BD46E7E77")
    public void clearAssertionStatus() {
        // ---------- Original Method ----------
    }

    
    static private class SystemClassLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.318 -0400", hash_original_method = "5CAD2AFC0F0FA3887E4002E77FFD0C7D", hash_generated_method = "5CAD2AFC0F0FA3887E4002E77FFD0C7D")
        public SystemClassLoader ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.318 -0400", hash_original_field = "9E858FEF25484C5FE1CB8BD38218B4F2", hash_generated_field = "9F05049E5285C9256C3F77BCE2FFFB9C")

        public static ClassLoader loader = ClassLoader.createSystemClassLoader();
    }


    
}

class TwoEnumerationsInOne implements Enumeration<URL> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.319 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "8251EE6159DCC0C25ACB4653E04140B7")

    private Enumeration<URL> first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.319 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "48331890F3BE0E00347927CE21AF464F")

    private Enumeration<URL> second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.319 -0400", hash_original_method = "D3D417A978FD13F0C9B8800DA2920B14", hash_generated_method = "DC7052B6806C57873B5AB28FCC7C1781")
    public  TwoEnumerationsInOne(Enumeration<URL> first, Enumeration<URL> second) {
        this.first = first;
        this.second = second;
        // ---------- Original Method ----------
        //this.first = first;
        //this.second = second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.359 -0400", hash_original_method = "B34DCB72B1A55025C195F65FCCD0FE9D", hash_generated_method = "859F14BF1BCACA178F06C7D3F745DCB4")
    public boolean hasMoreElements() {
        boolean var3B7474792343C2E0A8284A054503A681_1594121448 = (first.hasMoreElements() || second.hasMoreElements());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707315370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707315370;
        // ---------- Original Method ----------
        //return first.hasMoreElements() || second.hasMoreElements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.359 -0400", hash_original_method = "CE040DB5C31CF9231E1B46430147AEAF", hash_generated_method = "3B50F0DA77D1CAF5FEDAF03B1D1FB165")
    public URL nextElement() {
        URL varB4EAC82CA7396A68D541C85D26508E83_1762841657 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_344670766 = null; //Variable for return #2
        {
            boolean var7A58C32FEBB686E98F9F9FDEB9139188_1963372232 = (first.hasMoreElements());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1762841657 = first.nextElement();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_344670766 = second.nextElement();
            } //End block
        } //End collapsed parenthetic
        URL varA7E53CE21691AB073D9660D615818899_1636642170; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1636642170 = varB4EAC82CA7396A68D541C85D26508E83_1762841657;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1636642170 = varB4EAC82CA7396A68D541C85D26508E83_344670766;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1636642170.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1636642170;
        // ---------- Original Method ----------
        //if (first.hasMoreElements()) {
            //return first.nextElement();
        //} else {
            //return second.nextElement();
        //}
    }

    
}

class BootClassLoader extends ClassLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.359 -0400", hash_original_method = "D3F85B3CE9250DAE48A2E24200FC3763", hash_generated_method = "9B3A59F55A35519AA35E648BA04DC88C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.360 -0400", hash_original_method = "0FBC8B1C710D0CE61299895128455485", hash_generated_method = "916B806D657DE3C00420F48647ADDFEF")
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1233701864 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1233701864 = VMClassLoader.loadClass(name, false);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1233701864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1233701864;
        // ---------- Original Method ----------
        //return VMClassLoader.loadClass(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.362 -0400", hash_original_method = "917FC7483F620F58EBF15901F64E5CCB", hash_generated_method = "A5B0FCFFC452D8C1577C81397E0EF42B")
    @Override
    protected URL findResource(String name) {
        URL varB4EAC82CA7396A68D541C85D26508E83_205063228 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_205063228 = VMClassLoader.getResource(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_205063228.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_205063228;
        // ---------- Original Method ----------
        //return VMClassLoader.getResource(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.365 -0400", hash_original_method = "16CE054D9A07227EFDD5E4525389B0A1", hash_generated_method = "00A3102C108C98185DCFF6BE954FB7E7")
    @SuppressWarnings("unused")
    @Override
    protected Enumeration<URL> findResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_1592659340 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1592659340 = Collections.enumeration(VMClassLoader.getResources(resName));
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1592659340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1592659340;
        // ---------- Original Method ----------
        //return Collections.enumeration(VMClassLoader.getResources(resName));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.368 -0400", hash_original_method = "F97E0A3F9917A73A09E7D2F766F9C1D2", hash_generated_method = "6EA356943D83237EFAD5EC70D92F38D2")
    @Override
    protected Package getPackage(String name) {
        Package varB4EAC82CA7396A68D541C85D26508E83_35856916 = null; //Variable for return #1
        Package varB4EAC82CA7396A68D541C85D26508E83_1887943819 = null; //Variable for return #2
        {
            boolean var8F2A85FBA5C7FD01FD8C0BFF3B70DD8B_394539101 = (name != null && !name.isEmpty());
            {
                {
                    Package pack;
                    pack = super.getPackage(name);
                    {
                        pack = definePackage(name, "Unknown", "0.0", "Unknown", "Unknown", "0.0",
                            "Unknown", null);
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_35856916 = pack;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1887943819 = null;
        addTaint(name.getTaint());
        Package varA7E53CE21691AB073D9660D615818899_45599318; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_45599318 = varB4EAC82CA7396A68D541C85D26508E83_35856916;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_45599318 = varB4EAC82CA7396A68D541C85D26508E83_1887943819;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_45599318.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_45599318;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.380 -0400", hash_original_method = "7C22470B48203835E4FECF5A2AF64904", hash_generated_method = "EBBE5E4095A84F63ABBDE398DEAC2AB4")
    @Override
    public URL getResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_1928778741 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1928778741 = findResource(resName);
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1928778741.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1928778741;
        // ---------- Original Method ----------
        //return findResource(resName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.381 -0400", hash_original_method = "0851F7C9918489BAFB5B84B48223EC31", hash_generated_method = "92CBB67193EEC2E00F333C450FC8D2B7")
    @Override
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_272952259 = null; //Variable for return #1
        Class<?> clazz;
        clazz = findLoadedClass(className);
        {
            clazz = findClass(className);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_272952259 = clazz;
        addTaint(className.getTaint());
        addTaint(resolve);
        varB4EAC82CA7396A68D541C85D26508E83_272952259.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_272952259;
        // ---------- Original Method ----------
        //Class<?> clazz = findLoadedClass(className);
        //if (clazz == null) {
            //clazz = findClass(className);
        //}
        //return clazz;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.382 -0400", hash_original_method = "606DC58E52051EDCF71806278059C734", hash_generated_method = "B949890D84386C4BFE6B6079BB70EA62")
    @Override
    public Enumeration<URL> getResources(String resName) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_207797039 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_207797039 = findResources(resName);
        addTaint(resName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_207797039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_207797039;
        // ---------- Original Method ----------
        //return findResources(resName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.382 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "1B790D50CC69E7023CCCAB838EB40A4E")

    private static BootClassLoader instance;
}

