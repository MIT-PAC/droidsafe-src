package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import dalvik.system.VMRuntime;
import dalvik.system.VMStack;
import java.io.Console;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.channels.Channel;
import java.nio.channels.spi.SelectorProvider;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import libcore.icu.ICU;
import libcore.io.Libcore;
import libcore.io.StructUtsname;
import libcore.util.ZoneInfoDB;

public final class System {
    public static final InputStream in;
    public static final PrintStream out;
    public static final PrintStream err;
    private static final String lineSeparator;
    private static Properties systemProperties;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "E6A64E449436C53F69301A453DED3B55", hash_generated_method = "38FA6008DCCD3719F8654DA051C685F9")
    @DSModeled(DSC.SAFE)
    private System() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "D16452B6B75185BAA61EA9EFA159A8E9", hash_generated_method = "804D735CAAFC7C325DE9B365A0326D69")
    public static void setIn(InputStream newIn) {
        setFieldImpl("in", "Ljava/io/InputStream;", newIn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "FE0A5054D91BF71787912D03E790C89C", hash_generated_method = "D27468EB0FD43038B70B5EFA0F5EB7C1")
    public static void setOut(PrintStream newOut) {
        setFieldImpl("out", "Ljava/io/PrintStream;", newOut);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "FCF04532D043A59A407255C009845127", hash_generated_method = "EEA56B6E0025CF2A168F8DB5D7DCC840")
    public static void setErr(PrintStream newErr) {
        setFieldImpl("err", "Ljava/io/PrintStream;", newErr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "D7434757D4CAD81883F76DFD391AF5E8", hash_generated_method = "E7A91E1282487DCA86FA9B5B6099CD49")
    public static void arraycopy(Object src, int srcPos, Object dst, int dstPos, int length) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "160BB51793A80C253C811987AF1EB598", hash_generated_method = "61E2F2A8C3CC26139490BA547E85EB60")
    public static long currentTimeMillis() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "BC71756E7CB4F8DBA545A78B86F8B7C4", hash_generated_method = "786C33D4CA7FE4F5842FE64509FFFABE")
    public static long nanoTime() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "B689E3847550085AA4A48748B31E6C57", hash_generated_method = "2B0BEB3C7BDC42A2701677D835C9812E")
    public static void exit(int code) {
        Runtime.getRuntime().exit(code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "47EC6AE5C259ABE3B4A35CFA178D5702", hash_generated_method = "0709ED4B03A3139DD3527CC62BB2E466")
    public static void gc() {
        Runtime.getRuntime().gc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "79FB251DA8E670830D531170B8BBF153", hash_generated_method = "B7888C30425F3830863039B13886263D")
    public static String getenv(String name) {
        return getenv(name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "DDF861F1441EC0EABAADAA65E3E2ACBF", hash_generated_method = "77F3152230F90F924A2C30E830ABA4C2")
    private static String getenv(String name, String defaultValue) {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        String value = Libcore.os.getenv(name);
        return (value != null) ? value : defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "9FC22770968F10FA1E4DB07494582396", hash_generated_method = "3519C04F788D2A9CC0396167B083677F")
    private static String getEnvByName(String name) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "79B521B2EFD03E1D43F79EA09E867985", hash_generated_method = "14CE62E06E734A72D9890256F415124A")
    public static Map<String, String> getenv() {
        Map<String, String> map = new HashMap<String, String>();
        for (String entry : Libcore.os.environ()) {
            int index = entry.indexOf('=');
            if (index != -1) {
                map.put(entry.substring(0, index), entry.substring(index + 1));
            }
        }
        return new SystemEnvironment(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "A4AD4823D433FE3B00367B4686C599FE", hash_generated_method = "D5192B7E03EB3CF9AE4F88FC6DCBF3BA")
    public static Channel inheritedChannel() throws IOException {
        return SelectorProvider.provider().inheritedChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.944 -0400", hash_original_method = "3FDC8784D1C5F7E5946B08E486E63909", hash_generated_method = "1C947DC75EF01852C48A7D3F1ACB061A")
    public static Properties getProperties() {
        if (systemProperties == null) {
            initSystemProperties();
        }
        return systemProperties;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "C85DA87FF0B0FE3EC022FFA5CDEE5583", hash_generated_method = "99C625501321A3752A05B4A9D288C346")
    private static void initSystemProperties() {
        VMRuntime runtime = VMRuntime.getRuntime();
        Properties p = new Properties();
        String projectUrl = "http://www.android.com/";
        String projectName = "The Android Project";
        p.put("java.boot.class.path", runtime.bootClassPath());
        p.put("java.class.path", runtime.classPath());
        p.put("java.class.version", "50.0");
        p.put("java.compiler", "");
        p.put("java.ext.dirs", "");
        p.put("java.version", "0");
        p.put("java.home", getenv("JAVA_HOME", "/system"));
        p.put("java.io.tmpdir", "/tmp");
        p.put("java.library.path", getenv("LD_LIBRARY_PATH"));
        p.put("java.specification.name", "Dalvik Core Library");
        p.put("java.specification.vendor", projectName);
        p.put("java.specification.version", "0.9");
        p.put("java.vendor", projectName);
        p.put("java.vendor.url", projectUrl);
        p.put("java.vm.name", "Dalvik");
        p.put("java.vm.specification.name", "Dalvik Virtual Machine Specification");
        p.put("java.vm.specification.vendor", projectName);
        p.put("java.vm.specification.version", "0.9");
        p.put("java.vm.vendor", projectName);
        p.put("java.vm.version", runtime.vmVersion());
        p.put("file.separator", "/");
        p.put("line.separator", "\n");
        p.put("path.separator", ":");
        p.put("java.runtime.name", "Android Runtime");
        p.put("java.runtime.version", "0.9");
        p.put("java.vm.vendor.url", projectUrl);
        p.put("file.encoding", "UTF-8");
        p.put("user.language", "en");
        p.put("user.region", "US");
        p.put("user.home", getenv("HOME", ""));
        p.put("user.name", getenv("USER", ""));
        StructUtsname info = Libcore.os.uname();
        p.put("os.arch", info.machine);
        p.put("os.name", info.sysname);
        p.put("os.version", info.release);
        p.put("android.icu.library.version", ICU.getIcuVersion());
        p.put("android.icu.unicode.version", ICU.getUnicodeVersion());
        parsePropertyAssignments(p, specialProperties());
        parsePropertyAssignments(p, runtime.properties());
        systemProperties = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "F310EFA1596100CF0802801ED18060AD", hash_generated_method = "6D6E45FC92007F03117B3EEC6D7EE62C")
    private static String[] specialProperties() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	String [] properties = new String[] {
    			DSUtils.UNKNOWN_STRING
    	};
    	return properties;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "05094F845E3E5F63D2D668EAFF7A5EA3", hash_generated_method = "ED464C8D245A65A5099E569089B93A45")
    private static void parsePropertyAssignments(Properties p, String[] assignments) {
        for (String assignment : assignments) {
            int split = assignment.indexOf('=');
            String key = assignment.substring(0, split);
            String value = assignment.substring(split + 1);
            p.put(key, value);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "06C945E6AB6193665AD35FBCA9AFCB6D", hash_generated_method = "766C443FD74124DA91FB9FB0825E934E")
    public static String getProperty(String propertyName) {
        return getProperty(propertyName, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "0AD78573C84AE39631B832983C262457", hash_generated_method = "01672AFEB4169F8733E9B7130C897E0E")
    public static String getProperty(String prop, String defaultValue) {
        if (prop.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return getProperties().getProperty(prop, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "68A3BD921E5BE0343D8AB590A3A0C1ED", hash_generated_method = "8A6ABB9FC5C9F153DD0093091F1EAAA5")
    public static String setProperty(String prop, String value) {
        if (prop.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (String) getProperties().setProperty(prop, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "7D58B6BCA727F3F67D360A0CFD716CC6", hash_generated_method = "4ACB289319BB04D280A4168CCFF88F37")
    public static String clearProperty(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        if (key.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (String) getProperties().remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "510D3BD16A31CDD4C841B4E91270C2B4", hash_generated_method = "9552F3FF7A270239399C7A3019A2BE94")
    @DSModeled(DSC.BAN)
    public static Console console() {
        return Console.getConsole();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "C8F7CB4F1804392B0063D92E89423E1A", hash_generated_method = "4FDF597B2D74E6DD9D48FFB24DE4E3C9")
    @DSModeled(DSC.BAN)
    public static SecurityManager getSecurityManager() {
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "4A805BC9C12F17575A8FEA25AC623CBF", hash_generated_method = "E4870F7607B55F990E2734A0D2B9FE71")
    public static int identityHashCode(Object anObject) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return anObject.dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "2FD4DD67EFD3B97FB325132E454075F7", hash_generated_method = "569C7F439D58CDD88A28BF08084D2792")
    public static String lineSeparator() {
        return lineSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "0A5482C5BE01BBAB439F3387C549F83E", hash_generated_method = "02556AE73AEC2E1D7F54E204C98326F3")
    @DSModeled(DSC.BAN)
    public static void load(String pathName) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "0A3470DEBF4C375636532E38AAF3C5D7", hash_generated_method = "88D9169C5FC0C884DFF6AA876D761784")
    @DSModeled(DSC.BAN)
    public static void loadLibrary(String libName) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "B4D3BC404C9330FABBF2837824D5192F", hash_generated_method = "9ED12CE930441C0C49A5413C21F8F496")
    public static void logE(String message) {
        log('E', message, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "426C2F8FFE0D6DF11EE7DF3C30C2DE1F", hash_generated_method = "8ABC1A0A0CBBECB1E791898B9B218EF5")
    public static void logE(String message, Throwable th) {
        log('E', message, th);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "97DCA4E6697027EF1DB89F2FF8CC2381", hash_generated_method = "8441C4DBF16BAA43F633082C5313639B")
    public static void logI(String message) {
        log('I', message, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "A91E38651EFC9BA4CA17FE3E23D48B16", hash_generated_method = "292EF440C67DB5EB52676CA433322A60")
    public static void logI(String message, Throwable th) {
        log('I', message, th);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "4C6F29F0C73760E39E9FBF19730D8B91", hash_generated_method = "DC645407A10C11984BA16C0523AF1EA8")
    public static void logW(String message) {
        log('W', message, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "FDF7E59E0913674532DF05840F38F4F5", hash_generated_method = "663EAE27F5D7711B23637CBBEC4F625E")
    public static void logW(String message, Throwable th) {
        log('W', message, th);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "A72EF95309B469D5BD3A689CD4D5F687", hash_generated_method = "AF0BE89E9039F81EDEED88F44E9F57E7")
    private static void log(char type, String message, Throwable th) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "6EE6952ECA2DC5E5A6C1DD03C0E7FD35", hash_generated_method = "195A681901EA8D4D0CE146BE36AC1277")
    public static void runFinalization() {
        Runtime.getRuntime().runFinalization();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "9BEAEBDCB82386F5F7FA70BDCB71E5C3", hash_generated_method = "88EFC201D528182B951D509F3434C52E")
    @SuppressWarnings("deprecation")
    @Deprecated
    public static void runFinalizersOnExit(boolean flag) {
        Runtime.runFinalizersOnExit(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "76AE135BDC1F0727FE5943C1CE4D163E", hash_generated_method = "30B97EDB2D22B4226330E8CF3DFDF2D0")
    public static void setProperties(Properties p) {
        systemProperties = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "216C8E242EBCF141FD84CC88D6AABD84", hash_generated_method = "6ACE169D936A4C4905A308E32368FA5F")
    public static void setSecurityManager(SecurityManager sm) {
        if (sm != null) {
            throw new SecurityException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "14CC410355E66D71FA51E787DF393C3D", hash_generated_method = "02C2E73C5157D0525C6B73A22A73DF50")
    public static String mapLibraryName(String userLibName) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return userLibName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "8BA6D019B1CB8478E5833D6C205AD273", hash_generated_method = "BE04BB3384E18092650C615DE35CFA0B")
    private static void setFieldImpl(String fieldName, String signature, Object stream) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    static class SystemEnvironment extends AbstractMap<String, String> {
        private final Map<String, String> map;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "B0FD4399CD935BEF9930B0D70FEAF52A", hash_generated_method = "6403D3F362359E5B77B249CF7717206C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SystemEnvironment(Map<String, String> map) {
            dsTaint.addTaint(map.dsTaint);
            this.map = Collections.unmodifiableMap(map);
            // ---------- Original Method ----------
            //this.map = Collections.unmodifiableMap(map);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.945 -0400", hash_original_method = "72D95E6A5E33F4212177AA7AB73DA48C", hash_generated_method = "D60652114C320DD16C3F925B6B6F122C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Entry<String, String>> entrySet() {
            Set<Entry<String, String>> varA45F318ED8E7A8DCF28C1D811639BEB4_1204202398 = (map.entrySet());
            return (Set<Entry<String, String>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return map.entrySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.946 -0400", hash_original_method = "427258176260CD297BEE74A463DA23FE", hash_generated_method = "DD35A95213E9FDFB79E9179133953B4D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            String var7D12E71168D078A4D747B94EC55200B2_1570971995 = (map.get(toNonNullString(key)));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return map.get(toNonNullString(key));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.946 -0400", hash_original_method = "5AA47FBF2138F3E35206A54E79436C96", hash_generated_method = "3D85147957D702E1ADCA2C2AB731DAA8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean var370902D7D7D89F24E5C316DE8C51F902_1113280330 = (map.containsKey(toNonNullString(key)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return map.containsKey(toNonNullString(key));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.946 -0400", hash_original_method = "CC6AE6A57D73BE839427BC40B3BC71D9", hash_generated_method = "55AE1DF01CFBC9622CE67C7E8A53E1A3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            boolean varF6ED1590D37AED4D2A39B7426648A8D9_717386834 = (map.containsValue(toNonNullString(value)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return map.containsValue(toNonNullString(value));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.946 -0400", hash_original_method = "5309B26B5A621654CCE92CC093E8959E", hash_generated_method = "32DC895E05EDAC41F4B75F8D24BEA0BF")
        @DSModeled(DSC.SAFE)
        private String toNonNullString(Object o) {
            dsTaint.addTaint(o.dsTaint);
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //if (o == null) {
                //throw new NullPointerException();
            //}
            //return (String) o;
        }

        
    }


    
    static {
        err = new PrintStream(new FileOutputStream(FileDescriptor.err));
        out = new PrintStream(new FileOutputStream(FileDescriptor.out));
        in = new FileInputStream(FileDescriptor.in);
        lineSeparator = System.getProperty("line.separator");
    }
    
}


