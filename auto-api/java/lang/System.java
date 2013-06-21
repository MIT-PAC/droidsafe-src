package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.280 -0400", hash_original_method = "E6A64E449436C53F69301A453DED3B55", hash_generated_method = "56A6DF4ABD5F4C986DFF90DF1C5AAD2A")
    @DSModeled(DSC.SAFE)
    private System() {
        // ---------- Original Method ----------
    }

    
        public static void setIn(InputStream newIn) {
        setFieldImpl("in", "Ljava/io/InputStream;", newIn);
    }

    
        public static void setOut(PrintStream newOut) {
        setFieldImpl("out", "Ljava/io/PrintStream;", newOut);
    }

    
        public static void setErr(PrintStream newErr) {
        setFieldImpl("err", "Ljava/io/PrintStream;", newErr);
    }

    
        public static void arraycopy(Object src, int srcPos, Object dst, int dstPos, int length) {
    }

    
        public static long currentTimeMillis() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long nanoTime() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static void exit(int code) {
        Runtime.getRuntime().exit(code);
    }

    
        public static void gc() {
        Runtime.getRuntime().gc();
    }

    
        public static String getenv(String name) {
        return getenv(name, null);
    }

    
        private static String getenv(String name, String defaultValue) {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        String value = Libcore.os.getenv(name);
        return (value != null) ? value : defaultValue;
    }

    
        private static String getEnvByName(String name) {
        return DSUtils.UNKNOWN_STRING;
    }

    
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

    
        public static Channel inheritedChannel() throws IOException {
        return SelectorProvider.provider().inheritedChannel();
    }

    
        public static Properties getProperties() {
        if (systemProperties == null) {
            initSystemProperties();
        }
        return systemProperties;
    }

    
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

    
        private static String[] specialProperties() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        private static void parsePropertyAssignments(Properties p, String[] assignments) {
        for (String assignment : assignments) {
            int split = assignment.indexOf('=');
            String key = assignment.substring(0, split);
            String value = assignment.substring(split + 1);
            p.put(key, value);
        }
    }

    
        public static String getProperty(String propertyName) {
        return getProperty(propertyName, null);
    }

    
        public static String getProperty(String prop, String defaultValue) {
        if (prop.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return getProperties().getProperty(prop, defaultValue);
    }

    
        public static String setProperty(String prop, String value) {
        if (prop.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (String) getProperties().setProperty(prop, value);
    }

    
        public static String clearProperty(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        if (key.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (String) getProperties().remove(key);
    }

    
        public static Console console() {
        return Console.getConsole();
    }

    
        public static SecurityManager getSecurityManager() {
        return null;
    }

    
        public static int identityHashCode(Object anObject) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static String lineSeparator() {
        return lineSeparator;
    }

    
        public static void load(String pathName) {
        Runtime.getRuntime().load(pathName, VMStack.getCallingClassLoader());
    }

    
        public static void loadLibrary(String libName) {
        Runtime.getRuntime().loadLibrary(libName, VMStack.getCallingClassLoader());
    }

    
        public static void logE(String message) {
        log('E', message, null);
    }

    
        public static void logE(String message, Throwable th) {
        log('E', message, th);
    }

    
        public static void logI(String message) {
        log('I', message, null);
    }

    
        public static void logI(String message, Throwable th) {
        log('I', message, th);
    }

    
        public static void logW(String message) {
        log('W', message, null);
    }

    
        public static void logW(String message, Throwable th) {
        log('W', message, th);
    }

    
        private static void log(char type, String message, Throwable th) {
    }

    
        public static void runFinalization() {
        Runtime.getRuntime().runFinalization();
    }

    
        @SuppressWarnings("deprecation")
    @Deprecated
    public static void runFinalizersOnExit(boolean flag) {
        Runtime.runFinalizersOnExit(flag);
    }

    
        public static void setProperties(Properties p) {
        systemProperties = p;
    }

    
        public static void setSecurityManager(SecurityManager sm) {
        if (sm != null) {
            throw new SecurityException();
        }
    }

    
        public static String mapLibraryName(String userLibName) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static void setFieldImpl(String fieldName, String signature, Object stream) {
    }

    
    static class SystemEnvironment extends AbstractMap<String, String> {
        private Map<String, String> map;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.289 -0400", hash_original_method = "B0FD4399CD935BEF9930B0D70FEAF52A", hash_generated_method = "CBD554627D13D786CF3A3840CB1CFDB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SystemEnvironment(Map<String, String> map) {
            dsTaint.addTaint(map.dsTaint);
            this.map = Collections.unmodifiableMap(map);
            // ---------- Original Method ----------
            //this.map = Collections.unmodifiableMap(map);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.289 -0400", hash_original_method = "72D95E6A5E33F4212177AA7AB73DA48C", hash_generated_method = "9FDD1BAA55CA42F21BD63DA75AA8F05A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Set<Entry<String, String>> entrySet() {
            Set<Entry<String, String>> varA45F318ED8E7A8DCF28C1D811639BEB4_1394628627 = (map.entrySet());
            return (Set<Entry<String, String>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return map.entrySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.289 -0400", hash_original_method = "427258176260CD297BEE74A463DA23FE", hash_generated_method = "33A29C50C0F2961A2386446BD52198AA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String get(Object key) {
            dsTaint.addTaint(key.dsTaint);
            String var7D12E71168D078A4D747B94EC55200B2_790378944 = (map.get(toNonNullString(key)));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return map.get(toNonNullString(key));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.290 -0400", hash_original_method = "5AA47FBF2138F3E35206A54E79436C96", hash_generated_method = "0B7D75F8DB01CB68A3F591A6ACFD0E83")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsKey(Object key) {
            dsTaint.addTaint(key.dsTaint);
            boolean var370902D7D7D89F24E5C316DE8C51F902_517495573 = (map.containsKey(toNonNullString(key)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return map.containsKey(toNonNullString(key));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.290 -0400", hash_original_method = "CC6AE6A57D73BE839427BC40B3BC71D9", hash_generated_method = "D303EC20A4CEF9D349FD2D9B5DCD8531")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsValue(Object value) {
            dsTaint.addTaint(value.dsTaint);
            boolean varF6ED1590D37AED4D2A39B7426648A8D9_1912278147 = (map.containsValue(toNonNullString(value)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return map.containsValue(toNonNullString(value));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.290 -0400", hash_original_method = "5309B26B5A621654CCE92CC093E8959E", hash_generated_method = "66ABAA6F1CCA1FEA15A26300EAC7BB7C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String toNonNullString(Object o) {
            dsTaint.addTaint(o.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //if (o == null) {
                //throw new NullPointerException();
            //}
            //return (String) o;
        }

        
    }


    
    public static final InputStream in;
    public static final PrintStream out;
    public static final PrintStream err;
    private static final String lineSeparator;
    private static Properties systemProperties;
    static {
        err = new PrintStream(new FileOutputStream(FileDescriptor.err));
        out = new PrintStream(new FileOutputStream(FileDescriptor.out));
        in = new FileInputStream(FileDescriptor.in);
        lineSeparator = System.getProperty("line.separator");
    }
    
}

