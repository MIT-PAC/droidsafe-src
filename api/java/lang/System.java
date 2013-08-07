package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
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
import dalvik.system.VMRuntime;
import dalvik.system.VMStack;




import droidsafe.helpers.DSUtils;

public final class System {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.362 -0400", hash_original_method = "E6A64E449436C53F69301A453DED3B55", hash_generated_method = "56A6DF4ABD5F4C986DFF90DF1C5AAD2A")
    private  System() {
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

    
    @DSModeled(DSC.SAFE)
    public static void arraycopy(Object src, int srcPos, Object dst, int dstPos, int length) {
	}

    
    @DSModeled(DSC.SAFE)
    public static long currentTimeMillis() {
		long var0F5264038205EDFB1AC05FBB0E8C5E94_1308733048 = DSUtils.UNKNOWN_LONG;
		return var0F5264038205EDFB1AC05FBB0E8C5E94_1308733048;
	}

    
    @DSModeled(DSC.SAFE)
    public static long nanoTime() {
		long var0F5264038205EDFB1AC05FBB0E8C5E94_1522069111 = DSUtils.UNKNOWN_LONG;
		return var0F5264038205EDFB1AC05FBB0E8C5E94_1522069111;
	}

    
    public static void exit(int code) {
        Runtime.getRuntime().exit(code);
    }

    
    public static void gc() {
        Runtime.getRuntime().gc();
    }

    
    @DSModeled(DSC.SPEC)
    public static String getenv(String name) {
        return getenv(name, null);
    }

    
    @DSModeled(DSC.BAN)
    private static String getenv(String name, String defaultValue) {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        String value = Libcore.os.getenv(name);
        return (value != null) ? value : defaultValue;
    }

    
    @DSModeled(DSC.SAFE)
    private static String getEnvByName(String name) {
		return new String();
	}

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
    public static Properties getProperties() {
        if (systemProperties == null) {
            initSystemProperties();
        }
        return systemProperties;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    private static String[] specialProperties() {
		return new String[0];
	}

    
    @DSModeled(DSC.BAN)
    private static void parsePropertyAssignments(Properties p, String[] assignments) {
        for (String assignment : assignments) {
            int split = assignment.indexOf('=');
            String key = assignment.substring(0, split);
            String value = assignment.substring(split + 1);
            p.put(key, value);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static String getProperty(String propertyName) {
        return getProperty(propertyName, null);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static SecurityManager getSecurityManager() {
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    public static int identityHashCode(Object anObject) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396439638 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396439638;
	}

    
    @DSModeled(DSC.BAN)
    public static String lineSeparator() {
        return lineSeparator;
    }

    
    public static void load(String pathName) {
        Runtime.getRuntime().load(pathName, VMStack.getCallingClassLoader());
    }

    
    public static void loadLibrary(String libName) {
        Runtime.getRuntime().loadLibrary(libName, VMStack.getCallingClassLoader());
    }

    
    @DSModeled(DSC.BAN)
    public static void logE(String message) {
        log('E', message, null);
    }

    
    @DSModeled(DSC.BAN)
    public static void logE(String message, Throwable th) {
        log('E', message, th);
    }

    
    @DSModeled(DSC.BAN)
    public static void logI(String message) {
        log('I', message, null);
    }

    
    @DSModeled(DSC.BAN)
    public static void logI(String message, Throwable th) {
        log('I', message, th);
    }

    
    @DSModeled(DSC.BAN)
    public static void logW(String message) {
        log('W', message, null);
    }

    
    @DSModeled(DSC.BAN)
    public static void logW(String message, Throwable th) {
        log('W', message, th);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void setProperties(Properties p) {
        systemProperties = p;
    }

    
    public static void setSecurityManager(SecurityManager sm) {
        if (sm != null) {
            throw new SecurityException();
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static String mapLibraryName(String userLibName) {
		String ret = new String();
		ret.addTaint(userLibName.taint);
		return ret;
	}

    
    @DSModeled(DSC.SAFE)
    private static void setFieldImpl(String fieldName, String signature, Object stream) {
	}

    
    static class SystemEnvironment extends AbstractMap<String, String> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.367 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "AEDE8D1FD6B9D7350079530BA211AB11")

        private Map<String, String> map;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.367 -0400", hash_original_method = "B0FD4399CD935BEF9930B0D70FEAF52A", hash_generated_method = "47274EE90A9CC35993F9EE134C77826B")
        public  SystemEnvironment(Map<String, String> map) {
            this.map = Collections.unmodifiableMap(map);
            // ---------- Original Method ----------
            //this.map = Collections.unmodifiableMap(map);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.368 -0400", hash_original_method = "72D95E6A5E33F4212177AA7AB73DA48C", hash_generated_method = "F427F4D3586F1F7470ABFC44C4578F9D")
        @Override
        public Set<Entry<String, String>> entrySet() {
Set<Entry<String, String>> varD70A818A9C24919C79B0A6854ED78BA4_1539859050 =             map.entrySet();
            varD70A818A9C24919C79B0A6854ED78BA4_1539859050.addTaint(taint);
            return varD70A818A9C24919C79B0A6854ED78BA4_1539859050;
            // ---------- Original Method ----------
            //return map.entrySet();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.368 -0400", hash_original_method = "427258176260CD297BEE74A463DA23FE", hash_generated_method = "9EA576DF77B5F403983F2A3522D88874")
        @Override
        public String get(Object key) {
            addTaint(key.getTaint());
String var97F01DF1234C7D523320BD81BC314B44_892000716 =             map.get(toNonNullString(key));
            var97F01DF1234C7D523320BD81BC314B44_892000716.addTaint(taint);
            return var97F01DF1234C7D523320BD81BC314B44_892000716;
            // ---------- Original Method ----------
            //return map.get(toNonNullString(key));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.368 -0400", hash_original_method = "5AA47FBF2138F3E35206A54E79436C96", hash_generated_method = "AC1801FF8035667CC08DE19F55467BF9")
        @Override
        public boolean containsKey(Object key) {
            addTaint(key.getTaint());
            boolean var1CC8639F877576DDAF962665FC2AC8A9_1096129858 = (map.containsKey(toNonNullString(key)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1675650511 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1675650511;
            // ---------- Original Method ----------
            //return map.containsKey(toNonNullString(key));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.368 -0400", hash_original_method = "CC6AE6A57D73BE839427BC40B3BC71D9", hash_generated_method = "359C8666DD89FF26F82DA8A5896686CF")
        @Override
        public boolean containsValue(Object value) {
            addTaint(value.getTaint());
            boolean varDDFC8CE7CC09440F2F971A472071D732_698370654 = (map.containsValue(toNonNullString(value)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632850395 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_632850395;
            // ---------- Original Method ----------
            //return map.containsValue(toNonNullString(value));
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.368 -0400", hash_original_method = "5309B26B5A621654CCE92CC093E8959E", hash_generated_method = "1C547020BD5D5C81D6F22EDFCDFAE9D1")
        private String toNonNullString(Object o) {
            addTaint(o.getTaint());
            if(o == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_584451497 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_584451497.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_584451497;
            } //End block
String var05F8BA7898C830EEFB724B7656469F9E_914742332 =             (String) o;
            var05F8BA7898C830EEFB724B7656469F9E_914742332.addTaint(taint);
            return var05F8BA7898C830EEFB724B7656469F9E_914742332;
            // ---------- Original Method ----------
            //if (o == null) {
                //throw new NullPointerException();
            //}
            //return (String) o;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.368 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "38A011E6F7F8C1250D252BD46E263A94")

    public static final InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.369 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "EDA52A46216AAC1140B1897CE51020F5")

    public static final PrintStream out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.369 -0400", hash_original_field = "56BD7107802EBE56C6918992F0608EC6", hash_generated_field = "4AF680145FA7144D406FDF3A41509B54")

    public static final PrintStream err;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.369 -0400", hash_original_field = "2295B6F1520BB4ED9248E07AC41BC7AC", hash_generated_field = "4F120FCF427E27BF79D0B83F7A2E925B")

    private static String lineSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.369 -0400", hash_original_field = "FF68C967DBCFC921F883320F9AD54F87", hash_generated_field = "1BAE2C7F16338C14042F582AEB6D8AC2")

    private static Properties systemProperties;
    static {
        err = new PrintStream(new FileOutputStream(FileDescriptor.err));
        out = new PrintStream(new FileOutputStream(FileDescriptor.out));
        in = new FileInputStream(FileDescriptor.in);
        lineSeparator = System.getProperty("line.separator");
    }
    
}

