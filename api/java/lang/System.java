package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * Sets the standard input stream to the given user defined input stream.
     *
     * @param newIn
     *            the user defined input stream to set as the standard input
     *            stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.609 -0500", hash_original_method = "D16452B6B75185BAA61EA9EFA159A8E9", hash_generated_method = "804D735CAAFC7C325DE9B365A0326D69")
    
public static void setIn(InputStream newIn) {
        setFieldImpl("in", "Ljava/io/InputStream;", newIn);
    }

    /**
     * Sets the standard output stream to the given user defined output stream.
     *
     * @param newOut
     *            the user defined output stream to set as the standard output
     *            stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.611 -0500", hash_original_method = "FE0A5054D91BF71787912D03E790C89C", hash_generated_method = "D27468EB0FD43038B70B5EFA0F5EB7C1")
    
public static void setOut(PrintStream newOut) {
        setFieldImpl("out", "Ljava/io/PrintStream;", newOut);
    }

    /**
     * Sets the standard error output stream to the given user defined output
     * stream.
     *
     * @param newErr
     *            the user defined output stream to set as the standard error
     *            output stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.614 -0500", hash_original_method = "FCF04532D043A59A407255C009845127", hash_generated_method = "EEA56B6E0025CF2A168F8DB5D7DCC840")
    
public static void setErr(PrintStream newErr) {
        setFieldImpl("err", "Ljava/io/PrintStream;", newErr);
    }

    
    @DSModeled(DSC.SAFE)
    public static void arraycopy(Object src, int srcPos, Object dst, int dstPos, int length) {
	}

    
    @DSModeled(DSC.SPEC)
    public static long currentTimeMillis() {
		long var0F5264038205EDFB1AC05FBB0E8C5E94_1308733048 = DSUtils.UNKNOWN_LONG;
		return var0F5264038205EDFB1AC05FBB0E8C5E94_1308733048;
	}

    
    @DSModeled(DSC.SPEC)
    public static long nanoTime() {
		long var0F5264038205EDFB1AC05FBB0E8C5E94_1522069111 = DSUtils.UNKNOWN_LONG;
		return var0F5264038205EDFB1AC05FBB0E8C5E94_1522069111;
	}

    /**
     * Causes the VM to stop running and the program to exit. If
     * {@link #runFinalizersOnExit(boolean)} has been previously invoked with a
     * {@code true} argument, then all objects will be properly
     * garbage-collected and finalized first.
     *
     * @param code
     *            the return code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.632 -0500", hash_original_method = "B689E3847550085AA4A48748B31E6C57", hash_generated_method = "2B0BEB3C7BDC42A2701677D835C9812E")
    
public static void exit(int code) {
        Runtime.getRuntime().exit(code);
    }

    /**
     * Indicates to the VM that it would be a good time to run the
     * garbage collector. Note that this is a hint only. There is no guarantee
     * that the garbage collector will actually be run.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.634 -0500", hash_original_method = "47EC6AE5C259ABE3B4A35CFA178D5702", hash_generated_method = "0709ED4B03A3139DD3527CC62BB2E466")
    
public static void gc() {
        Runtime.getRuntime().gc();
    }

    /**
     * Returns the value of the environment variable with the given name {@code
     * var}.
     *
     * @param name
     *            the name of the environment variable.
     * @return the value of the specified environment variable or {@code null}
     *         if no variable exists with the given name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.636 -0500", hash_original_method = "79FB251DA8E670830D531170B8BBF153", hash_generated_method = "B7888C30425F3830863039B13886263D")
    
public static String getenv(String name) {
        return getenv(name, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.639 -0500", hash_original_method = "DDF861F1441EC0EABAADAA65E3E2ACBF", hash_generated_method = "77F3152230F90F924A2C30E830ABA4C2")
    
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

    /**
     * Returns an unmodifiable map of all available environment variables.
     *
     * @return the map representing all environment variables.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.646 -0500", hash_original_method = "79B521B2EFD03E1D43F79EA09E867985", hash_generated_method = "14CE62E06E734A72D9890256F415124A")
    
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

    /**
     * Returns the inherited channel from the creator of the current virtual
     * machine.
     *
     * @return the inherited {@link Channel} or {@code null} if none exists.
     * @throws IOException
     *             if an I/O error occurred.
     * @see SelectorProvider
     * @see SelectorProvider#inheritedChannel()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.648 -0500", hash_original_method = "A4AD4823D433FE3B00367B4686C599FE", hash_generated_method = "D5192B7E03EB3CF9AE4F88FC6DCBF3BA")
    
public static Channel inheritedChannel() throws IOException {
        return SelectorProvider.provider().inheritedChannel();
    }

    /**
     * Returns the system properties. Note that this is not a copy, so that
     * changes made to the returned Properties object will be reflected in
     * subsequent calls to getProperty and getProperties.
     *
     * @return the system properties.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.652 -0500", hash_original_method = "3FDC8784D1C5F7E5946B08E486E63909", hash_generated_method = "1C947DC75EF01852C48A7D3F1ACB061A")
    
public static Properties getProperties() {
        if (systemProperties == null) {
            initSystemProperties();
        }
        return systemProperties;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.655 -0500", hash_original_method = "B252A11CAEEE644CE1E741E5C5B0B404", hash_generated_method = "99DA69E508AD9A7D0CF6A0DFE6E6F064")
    
private static void initSystemProperties() {
        VMRuntime runtime = VMRuntime.getRuntime();
        Properties p = new Properties();

        String projectUrl = "http://www.android.com/";
        String projectName = "The Android Project";

        p.put("java.boot.class.path", runtime.bootClassPath());
        p.put("java.class.path", runtime.classPath());

        // None of these four are meaningful on Android, but these keys are guaranteed
        // to be present for System.getProperty. For java.class.version, we use the maximum
        // class file version that dx currently supports.
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

        // Undocumented Android-only properties.
        p.put("android.icu.library.version", ICU.getIcuVersion());
        p.put("android.icu.unicode.version", ICU.getUnicodeVersion());
        // TODO: it would be nice to have this but currently it causes circularity.
        // p.put("android.tzdata.version", ZoneInfoDB.getVersion());
        parsePropertyAssignments(p, specialProperties());

        // Override built-in properties with settings from the command line.
        parsePropertyAssignments(p, runtime.properties());

        systemProperties = p;
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] specialProperties() {
		return new String[0];
	}

    /**
     * Adds each element of 'assignments' to 'p', treating each element as an
     * assignment in the form "key=value".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.661 -0500", hash_original_method = "05094F845E3E5F63D2D668EAFF7A5EA3", hash_generated_method = "ED464C8D245A65A5099E569089B93A45")
    
private static void parsePropertyAssignments(Properties p, String[] assignments) {
        for (String assignment : assignments) {
            int split = assignment.indexOf('=');
            String key = assignment.substring(0, split);
            String value = assignment.substring(split + 1);
            p.put(key, value);
        }
    }

    /**
     * Returns the value of a particular system property or {@code null} if no
     * such property exists.
     *
     * <p>The following properties are always provided by the Dalvik VM:
     * <p><table BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0" SUMMARY="">
     * <tr BGCOLOR="#CCCCFF" CLASS="TableHeadingColor">
     *     <td><b>Name</b></td>        <td><b>Meaning</b></td>                    <td><b>Example</b></td></tr>
     * <tr><td>file.separator</td>     <td>{@link java.io.File#separator}</td>    <td>{@code /}</td></tr>
     *
     * <tr><td>java.class.path</td>    <td>System class path</td>                 <td>{@code .}</td></tr>
     * <tr><td>java.class.version</td> <td>(Not useful on Android)</td>           <td>{@code 50.0}</td></tr>
     * <tr><td>java.compiler</td>      <td>(Not useful on Android)</td>           <td>Empty</td></tr>
     * <tr><td>java.ext.dirs</td>      <td>(Not useful on Android)</td>           <td>Empty</td></tr>
     * <tr><td>java.home</td>          <td>Location of the VM on the file system</td> <td>{@code /system}</td></tr>
     * <tr><td>java.io.tmpdir</td>     <td>See {@link java.io.File#createTempFile}</td> <td>{@code /sdcard}</td></tr>
     * <tr><td>java.library.path</td>  <td>Search path for JNI libraries</td>     <td>{@code /system/lib}</td></tr>
     * <tr><td>java.vendor</td>        <td>Human-readable VM vendor</td>          <td>{@code The Android Project}</td></tr>
     * <tr><td>java.vendor.url</td>    <td>URL for VM vendor's web site</td>      <td>{@code http://www.android.com/}</td></tr>
     * <tr><td>java.version</td>       <td>(Not useful on Android)</td>           <td>{@code 0}</td></tr>
     *
     * <tr><td>java.specification.version</td>    <td>VM libraries version</td>        <td>{@code 0.9}</td></tr>
     * <tr><td>java.specification.vendor</td>     <td>VM libraries vendor</td>         <td>{@code The Android Project}</td></tr>
     * <tr><td>java.specification.name</td>       <td>VM libraries name</td>           <td>{@code Dalvik Core Library}</td></tr>
     * <tr><td>java.vm.version</td>               <td>VM implementation version</td>   <td>{@code 1.2.0}</td></tr>
     * <tr><td>java.vm.vendor</td>                <td>VM implementation vendor</td>    <td>{@code The Android Project}</td></tr>
     * <tr><td>java.vm.name</td>                  <td>VM implementation name</td>      <td>{@code Dalvik}</td></tr>
     * <tr><td>java.vm.specification.version</td> <td>VM specification version</td>    <td>{@code 0.9}</td></tr>
     * <tr><td>java.vm.specification.vendor</td>  <td>VM specification vendor</td>     <td>{@code The Android Project}</td></tr>
     * <tr><td>java.vm.specification.name</td>    <td>VM specification name</td>       <td>{@code Dalvik Virtual Machine Specification}</td></tr>
     *
     * <tr><td>line.separator</td>     <td>The system line separator</td>         <td>{@code \n}</td></tr>
     *
     * <tr><td>os.arch</td>            <td>OS architecture</td>                   <td>{@code armv7l}</td></tr>
     * <tr><td>os.name</td>            <td>OS (kernel) name</td>                  <td>{@code Linux}</td></tr>
     * <tr><td>os.version</td>         <td>OS (kernel) version</td>               <td>{@code 2.6.32.9-g103d848}</td></tr>
     *
     * <tr><td>path.separator</td>     <td>See {@link java.io.File#pathSeparator}</td> <td>{@code :}</td></tr>
     *
     * <tr><td>user.dir</td>           <td>Base of non-absolute paths</td>        <td>{@code /}</td></tr>
     * <tr><td>user.home</td>          <td>(Not useful on Android)</td>           <td>Empty</td></tr>
     * <tr><td>user.name</td>          <td>(Not useful on Android)</td>           <td>Empty</td></tr>
     *
     * </table>
     *
     * <p>It is a mistake to try to override any of these. Doing so will have unpredictable results.
     *
     * @param propertyName
     *            the name of the system property to look up.
     * @return the value of the specified system property or {@code null} if the
     *         property doesn't exist.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.664 -0500", hash_original_method = "06C945E6AB6193665AD35FBCA9AFCB6D", hash_generated_method = "766C443FD74124DA91FB9FB0825E934E")
    
public static String getProperty(String propertyName) {
        return getProperty(propertyName, null);
    }

    /**
     * Returns the value of a particular system property. The {@code
     * defaultValue} will be returned if no such property has been found.
     *
     * @param prop
     *            the name of the system property to look up.
     * @param defaultValue
     *            the return value if the system property with the given name
     *            does not exist.
     * @return the value of the specified system property or the {@code
     *         defaultValue} if the property does not exist.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.667 -0500", hash_original_method = "0AD78573C84AE39631B832983C262457", hash_generated_method = "01672AFEB4169F8733E9B7130C897E0E")
    
public static String getProperty(String prop, String defaultValue) {
        if (prop.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return getProperties().getProperty(prop, defaultValue);
    }

    /**
     * Sets the value of a particular system property.
     *
     * @param prop
     *            the name of the system property to be changed.
     * @param value
     *            the value to associate with the given property {@code prop}.
     * @return the old value of the property or {@code null} if the property
     *         didn't exist.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.669 -0500", hash_original_method = "68A3BD921E5BE0343D8AB590A3A0C1ED", hash_generated_method = "8A6ABB9FC5C9F153DD0093091F1EAAA5")
    
public static String setProperty(String prop, String value) {
        if (prop.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (String) getProperties().setProperty(prop, value);
    }

    /**
     * Removes a specific system property.
     *
     * @param key
     *            the name of the system property to be removed.
     * @return the property value or {@code null} if the property didn't exist.
     * @throws NullPointerException
     *             if the argument {@code key} is {@code null}.
     * @throws IllegalArgumentException
     *             if the argument {@code key} is empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.673 -0500", hash_original_method = "7D58B6BCA727F3F67D360A0CFD716CC6", hash_generated_method = "4ACB289319BB04D280A4168CCFF88F37")
    
public static String clearProperty(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        if (key.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (String) getProperties().remove(key);
    }

    /**
     * Returns the {@link java.io.Console} associated with this VM, or null.
     * Not all VMs will have an associated console. A console is typically only
     * available for programs run from the command line.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.675 -0500", hash_original_method = "510D3BD16A31CDD4C841B4E91270C2B4", hash_generated_method = "9552F3FF7A270239399C7A3019A2BE94")
    
public static Console console() {
        return Console.getConsole();
    }

    /**
     * Returns null. Android does not use {@code SecurityManager}. This method
     * is only provided for source compatibility.
     *
     * @return null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.678 -0500", hash_original_method = "C8F7CB4F1804392B0063D92E89423E1A", hash_generated_method = "4FDF597B2D74E6DD9D48FFB24DE4E3C9")
    
public static SecurityManager getSecurityManager() {
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    public static int identityHashCode(Object anObject) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396439638 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396439638;
	}

    /**
     * Returns the system's line separator. On Android, this is {@code "\n"}. The value
     * comes from the value of the {@code line.separator} system property when the VM
     * starts. Later changes to the property will not affect the value returned by this
     * method.
     * @since 1.7
     * @hide 1.7 - fix documentation references to "line.separator" in Formatter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.684 -0500", hash_original_method = "2FD4DD67EFD3B97FB325132E454075F7", hash_generated_method = "569C7F439D58CDD88A28BF08084D2792")
    
public static String lineSeparator() {
        return lineSeparator;
    }

    /**
     * Loads and links the dynamic library that is identified through the
     * specified path. This method is similar to {@link #loadLibrary(String)},
     * but it accepts a full path specification whereas {@code loadLibrary} just
     * accepts the name of the library to load.
     *
     * @param pathName
     *            the path of the file to be loaded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.686 -0500", hash_original_method = "0A5482C5BE01BBAB439F3387C549F83E", hash_generated_method = "02556AE73AEC2E1D7F54E204C98326F3")
    
public static void load(String pathName) {
        Runtime.getRuntime().load(pathName, VMStack.getCallingClassLoader());
    }

    /**
     * Loads and links the library with the specified name. The mapping of the
     * specified library name to the full path for loading the library is
     * implementation-dependent.
     *
     * @param libName
     *            the name of the library to load.
     * @throws UnsatisfiedLinkError
     *             if the library could not be loaded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.689 -0500", hash_original_method = "0A3470DEBF4C375636532E38AAF3C5D7", hash_generated_method = "88D9169C5FC0C884DFF6AA876D761784")
    
public static void loadLibrary(String libName) {
        Runtime.getRuntime().loadLibrary(libName, VMStack.getCallingClassLoader());
    }

    /**
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.691 -0500", hash_original_method = "B4D3BC404C9330FABBF2837824D5192F", hash_generated_method = "9ED12CE930441C0C49A5413C21F8F496")
    
public static void logE(String message) {
        log('E', message, null);
    }

    /**
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.694 -0500", hash_original_method = "426C2F8FFE0D6DF11EE7DF3C30C2DE1F", hash_generated_method = "8ABC1A0A0CBBECB1E791898B9B218EF5")
    
public static void logE(String message, Throwable th) {
        log('E', message, th);
    }

    /**
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.697 -0500", hash_original_method = "97DCA4E6697027EF1DB89F2FF8CC2381", hash_generated_method = "8441C4DBF16BAA43F633082C5313639B")
    
public static void logI(String message) {
        log('I', message, null);
    }

    /**
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.699 -0500", hash_original_method = "A91E38651EFC9BA4CA17FE3E23D48B16", hash_generated_method = "292EF440C67DB5EB52676CA433322A60")
    
public static void logI(String message, Throwable th) {
        log('I', message, th);
    }

    /**
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.701 -0500", hash_original_method = "4C6F29F0C73760E39E9FBF19730D8B91", hash_generated_method = "DC645407A10C11984BA16C0523AF1EA8")
    
public static void logW(String message) {
        log('W', message, null);
    }

    /**
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.704 -0500", hash_original_method = "FDF7E59E0913674532DF05840F38F4F5", hash_generated_method = "663EAE27F5D7711B23637CBBEC4F625E")
    
public static void logW(String message, Throwable th) {
        log('W', message, th);
    }

    
    @DSModeled(DSC.SAFE)
    private static void log(char type, String message, Throwable th) {
	}

    /**
     * Provides a hint to the VM that it would be useful to attempt
     * to perform any outstanding object finalization.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.710 -0500", hash_original_method = "6EE6952ECA2DC5E5A6C1DD03C0E7FD35", hash_generated_method = "195A681901EA8D4D0CE146BE36AC1277")
    
public static void runFinalization() {
        Runtime.getRuntime().runFinalization();
    }

    /**
     * Ensures that, when the VM is about to exit, all objects are
     * finalized. Note that all finalization which occurs when the system is
     * exiting is performed after all running threads have been terminated.
     *
     * @param flag
     *            the flag determines if finalization on exit is enabled.
     * @deprecated this method is unsafe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.713 -0500", hash_original_method = "9BEAEBDCB82386F5F7FA70BDCB71E5C3", hash_generated_method = "88EFC201D528182B951D509F3434C52E")
    
@SuppressWarnings("deprecation")
    @Deprecated
    public static void runFinalizersOnExit(boolean flag) {
        Runtime.runFinalizersOnExit(flag);
    }

    /**
     * Sets all system properties. This does not take a copy; the passed-in object is used
     * directly. Passing null causes the VM to reinitialize the properties to how they were
     * when the VM was started.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.715 -0500", hash_original_method = "76AE135BDC1F0727FE5943C1CE4D163E", hash_generated_method = "30B97EDB2D22B4226330E8CF3DFDF2D0")
    
public static void setProperties(Properties p) {
        systemProperties = p;
    }

    /**
     * Throws {@code SecurityException}.
     *
     * <p>Security managers do <i>not</i> provide a secure environment for
     * executing untrusted code and are unsupported on Android. Untrusted code
     * cannot be safely isolated within a single VM on Android.
     *
     * @param sm a security manager
     * @throws SecurityException always
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.718 -0500", hash_original_method = "216C8E242EBCF141FD84CC88D6AABD84", hash_generated_method = "6ACE169D936A4C4905A308E32368FA5F")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.596 -0500", hash_original_field = "0A829BC26C36EAF422E245C1EC11D5B0", hash_generated_field = "B443C5C680D4DA0BD118CB991BCB8B38")

    public static  InputStream in;

    
    static class SystemEnvironment extends AbstractMap<String, String> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.729 -0500", hash_original_field = "B2320E74448A8A8D4C529584B2F6C72E", hash_generated_field = "AEDE8D1FD6B9D7350079530BA211AB11")

        private  Map<String, String> map;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.732 -0500", hash_original_method = "B0FD4399CD935BEF9930B0D70FEAF52A", hash_generated_method = "D521E967EF09F35E0669DA331F3F5484")
        
public SystemEnvironment(Map<String, String> map) {
            this.map = Collections.unmodifiableMap(map);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.735 -0500", hash_original_method = "72D95E6A5E33F4212177AA7AB73DA48C", hash_generated_method = "B739A5065DB968A82F089F3C38EDEF87")
        
@Override public Set<Entry<String, String>> entrySet() {
            return map.entrySet();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.737 -0500", hash_original_method = "427258176260CD297BEE74A463DA23FE", hash_generated_method = "058B2ACC34010774810D06841FBEC1D8")
        
@Override public String get(Object key) {
            return map.get(toNonNullString(key));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.741 -0500", hash_original_method = "5AA47FBF2138F3E35206A54E79436C96", hash_generated_method = "DB430FBFE68FF50D08FFBEA7988F55B5")
        
@Override public boolean containsKey(Object key) {
            return map.containsKey(toNonNullString(key));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.744 -0500", hash_original_method = "CC6AE6A57D73BE839427BC40B3BC71D9", hash_generated_method = "4ECFE6D54A52B77DB41E783CC7A58231")
        
@Override public boolean containsValue(Object value) {
            return map.containsValue(toNonNullString(value));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.746 -0500", hash_original_method = "5309B26B5A621654CCE92CC093E8959E", hash_generated_method = "5221DC6EA45BD37C8A7ED98DBD8D9D2D")
        
private String toNonNullString(Object o) {
            if (o == null) {
                throw new NullPointerException();
            }
            return (String) o;
        }

        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.599 -0500", hash_original_field = "3012FF5B828647FA4929921E808B58B8", hash_generated_field = "6D64AE7213A180429B33C84A1527B8AC")

    public static  PrintStream out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.601 -0500", hash_original_field = "833BD6DDDF0961BCE332288D516BF86F", hash_generated_field = "3FB5D1959F2361274134EC5E4782CDA0")

    public static  PrintStream err;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.604 -0500", hash_original_field = "D327D4A790DD1B7EE14E3F55E6B49404", hash_generated_field = "4F120FCF427E27BF79D0B83F7A2E925B")


    private static  String lineSeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.606 -0500", hash_original_field = "2692616CA0AD8BEC04ACC8D4CDF6E6AF", hash_generated_field = "1BAE2C7F16338C14042F582AEB6D8AC2")

    private static Properties systemProperties;

    /**
     * Prevents this class from being instantiated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.616 -0500", hash_original_method = "E6A64E449436C53F69301A453DED3B55", hash_generated_method = "4C5BFFF833D1388E8E698D0CDB2E2C77")
    
private System() {
    }
    static {
        err = new PrintStream(new FileOutputStream(FileDescriptor.err));
        out = new PrintStream(new FileOutputStream(FileDescriptor.out));
        in = new FileInputStream(FileDescriptor.in);
        lineSeparator = System.getProperty("line.separator");
    }
    
}

