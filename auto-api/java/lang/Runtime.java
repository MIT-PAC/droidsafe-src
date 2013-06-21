package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.VMDebug;
import dalvik.system.VMStack;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.FinalizerReference;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import libcore.io.Libcore;
import static libcore.io.OsConstants._SC_NPROCESSORS_ONLN;

public class Runtime {
    private String[] mLibPaths;
    private List<Thread> shutdownHooks = new ArrayList<Thread>();
    private boolean shuttingDown;
    private boolean tracingMethods;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.985 -0400", hash_original_method = "F82AC05B2B9BDA560435929D86D5DD16", hash_generated_method = "41A4241B26C7DF592DE33286804548E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Runtime() {
        String pathList;
        pathList = System.getProperty("java.library.path", ".");
        String pathSep;
        pathSep = System.getProperty("path.separator", ":");
        String fileSep;
        fileSep = System.getProperty("file.separator", "/");
        mLibPaths = pathList.split(pathSep);
        {
            int i;
            i = 0;
            {
                {
                    boolean var1BFF5A0C86E86C64CD92FD978F3DE564_1432160781 = (!mLibPaths[i].endsWith(fileSep));
                    {
                        mLibPaths[i] += fileSep;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String pathList = System.getProperty("java.library.path", ".");
        //String pathSep = System.getProperty("path.separator", ":");
        //String fileSep = System.getProperty("file.separator", "/");
        //mLibPaths = pathList.split(pathSep);
        //for (int i = 0; i < mLibPaths.length; i++) {
            //if (!mLibPaths[i].endsWith(fileSep)) {
                //mLibPaths[i] += fileSep;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.985 -0400", hash_original_method = "CFCE84E7C9BE3630A08A3A7BB73629F7", hash_generated_method = "8401ED992273D0279AE174D62D097AC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Process exec(String[] progArray) throws java.io.IOException {
        dsTaint.addTaint(progArray[0]);
        Process varC712AF8F89C654D12DB41E27DACF8B4D_1606518372 = (exec(progArray, null, null));
        return (Process)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exec(progArray, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.985 -0400", hash_original_method = "DBDF96D0DD01BF3A81297C1A77D3788B", hash_generated_method = "D54ED76AE28BC631D5D63AFECBE2E390")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Process exec(String[] progArray, String[] envp) throws java.io.IOException {
        dsTaint.addTaint(progArray[0]);
        dsTaint.addTaint(envp[0]);
        Process var901F7680B043EDE6EA5AD1D0035C6DA6_32365102 = (exec(progArray, envp, null));
        return (Process)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exec(progArray, envp, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.985 -0400", hash_original_method = "CA3870F83BC3F7A92215C18375ED76A3", hash_generated_method = "EB441B3E7304D08DC3A4EAF84134D578")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Process exec(String[] progArray, String[] envp, File directory) throws IOException {
        dsTaint.addTaint(directory.dsTaint);
        dsTaint.addTaint(progArray[0]);
        dsTaint.addTaint(envp[0]);
        Process var3B7C86EC3E86D79554B05CEC036C29F3_1093942566 = (ProcessManager.getInstance().exec(progArray, envp, directory, false));
        return (Process)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ProcessManager.getInstance().exec(progArray, envp, directory, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.986 -0400", hash_original_method = "06266E096A96F3360CE9E0923017372F", hash_generated_method = "007C751076EE1E6FBC707CE8F465777A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Process exec(String prog) throws java.io.IOException {
        dsTaint.addTaint(prog);
        Process var6D201C2F6E998DF23552F694868EB72D_1362894519 = (exec(prog, null, null));
        return (Process)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exec(prog, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.986 -0400", hash_original_method = "7285BF96BB6399D281A4BE01B5D250F8", hash_generated_method = "38C285C56F3474A3E63B86CFD22FFF26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Process exec(String prog, String[] envp) throws java.io.IOException {
        dsTaint.addTaint(prog);
        dsTaint.addTaint(envp[0]);
        Process varA69EBEC7A37578DC80265B8FAF5EF53A_868852695 = (exec(prog, envp, null));
        return (Process)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exec(prog, envp, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.986 -0400", hash_original_method = "D63330F96D8E34D6A893E8125BEC80CB", hash_generated_method = "A206A63D505A87BD896DAF8558D185D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Process exec(String prog, String[] envp, File directory) throws java.io.IOException {
        dsTaint.addTaint(prog);
        dsTaint.addTaint(directory.dsTaint);
        dsTaint.addTaint(envp[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var76D3DE3C27BAB87F3C1BE357F241404A_355511666 = (prog.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        StringTokenizer tokenizer;
        tokenizer = new StringTokenizer(prog);
        int length;
        length = tokenizer.countTokens();
        String[] progArray;
        progArray = new String[length];
        {
            int i;
            i = 0;
            {
                progArray[i] = tokenizer.nextToken();
            } //End block
        } //End collapsed parenthetic
        Process varFFBF137830A4D1EE8483E505A2B748BF_1275376257 = (exec(progArray, envp, directory));
        return (Process)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (prog == null) {
            //throw new NullPointerException();
        //} else if (prog.length() == 0) {
            //throw new IllegalArgumentException();
        //}
        //StringTokenizer tokenizer = new StringTokenizer(prog);
        //int length = tokenizer.countTokens();
        //String[] progArray = new String[length];
        //for (int i = 0; i < length; i++) {
            //progArray[i] = tokenizer.nextToken();
        //}
        //return exec(progArray, envp, directory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.998 -0400", hash_original_method = "06E9B7958C64599C6A29BDE55862BAAD", hash_generated_method = "89BA03CC1B5ACB996E45EFB11F8FAA38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void exit(int code) {
        dsTaint.addTaint(code);
        {
            {
                shuttingDown = true;
                Thread[] hooks;
                {
                    hooks = new Thread[shutdownHooks.size()];
                    shutdownHooks.toArray(hooks);
                } //End block
                {
                    Thread hook = hooks[0];
                    {
                        hook.start();
                    } //End block
                } //End collapsed parenthetic
                {
                    Thread hook = hooks[0];
                    {
                        try 
                        {
                            hook.join();
                        } //End block
                        catch (InterruptedException ex)
                        { }
                    } //End block
                } //End collapsed parenthetic
                {
                    runFinalization();
                } //End block
                nativeExit(code, true);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.998 -0400", hash_original_method = "67196F5597F9CC48251D355499CA1423", hash_generated_method = "FBCC2E9A04EF6A540D409D67ACE4BF47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long freeMemory() {
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.999 -0400", hash_original_method = "D5E9C32F4CCF731A5E6B245C708DE511", hash_generated_method = "F2BA90326A844E033E7882399F00530F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void gc() {
    }

    
        public static Runtime getRuntime() {
        return mRuntime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.999 -0400", hash_original_method = "D4CBB36D8902BC048F224692FC6F0770", hash_generated_method = "1F5E7075A208788E6157CF0256EE842A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void load(String pathName) {
        dsTaint.addTaint(pathName);
        load(pathName, VMStack.getCallingClassLoader());
        // ---------- Original Method ----------
        //load(pathName, VMStack.getCallingClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.999 -0400", hash_original_method = "93CD7EAF10A1B837C6D2761A80025550", hash_generated_method = "C541D398F9BC3726E96A01AA21575FF6")
    @DSModeled(DSC.BAN)
     void load(String filename, ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(filename);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("library path was null.");
        } //End block
        String error;
        error = nativeLoad(filename, loader);
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsatisfiedLinkError(error);
        } //End block
        // ---------- Original Method ----------
        //if (filename == null) {
            //throw new NullPointerException("library path was null.");
        //}
        //String error = nativeLoad(filename, loader);
        //if (error != null) {
            //throw new UnsatisfiedLinkError(error);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.999 -0400", hash_original_method = "552217161A043147D154E437EB4B14C4", hash_generated_method = "52DAEA28038CF2DD97F032BEBF24C335")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadLibrary(String libName) {
        dsTaint.addTaint(libName);
        loadLibrary(libName, VMStack.getCallingClassLoader());
        // ---------- Original Method ----------
        //loadLibrary(libName, VMStack.getCallingClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.008 -0400", hash_original_method = "5EE816C9B41613E4D79FD41D836C9458", hash_generated_method = "7FA0755E98401A7C33A1E4F510E8DE49")
    @DSModeled(DSC.BAN)
     void loadLibrary(String libraryName, ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(libraryName);
        {
            String filename;
            filename = loader.findLibrary(libraryName);
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsatisfiedLinkError("Couldn't load " + libraryName + ": " +
                        "findLibrary returned null");
            } //End block
            String error;
            error = nativeLoad(filename, loader);
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsatisfiedLinkError(error);
            } //End block
        } //End block
        String filename;
        filename = System.mapLibraryName(libraryName);
        List<String> candidates;
        candidates = new ArrayList<String>();
        String lastError;
        lastError = null;
        {
            String directory = mLibPaths[0];
            {
                String candidate;
                candidate = directory + filename;
                candidates.add(candidate);
                {
                    boolean var83E84C412CAF9691B50D589C1BC72418_308070668 = (new File(candidate).exists());
                    {
                        String error;
                        error = nativeLoad(candidate, loader);
                        lastError = error;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsatisfiedLinkError(lastError);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsatisfiedLinkError("Library " + libraryName + " not found; tried " + candidates);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void nativeExit(int code, boolean isExit) {
    }

    
        private static String nativeLoad(String filename, ClassLoader loader) {
        return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.009 -0400", hash_original_method = "D97B4D8E5C3471916B8248342E55C9E3", hash_generated_method = "B8DF1E762B1639FEAD14C63E4F21ADD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void runFinalization() {
        try 
        {
            FinalizerReference.finalizeAllEnqueued();
        } //End block
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        } //End block
        // ---------- Original Method ----------
        //try {
            //FinalizerReference.finalizeAllEnqueued();
        //} catch (InterruptedException e) {
            //Thread.currentThread().interrupt();
        //}
    }

    
        @Deprecated
    public static void runFinalizersOnExit(boolean run) {
        finalizeOnExit = run;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.020 -0400", hash_original_method = "4EB2522F808EA94D0A66B66F863EF421", hash_generated_method = "E5837D7B5038DA56F18E860AE3E129F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long totalMemory() {
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.021 -0400", hash_original_method = "53798D26DA92803B5299289F1912C9D0", hash_generated_method = "A062AB90B27D9115359872AF85B37686")
    @DSModeled(DSC.SAFE)
    public void traceInstructions(boolean enable) {
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.021 -0400", hash_original_method = "047BFF8451D039E49AAF4D452A82FBF3", hash_generated_method = "250DA75875F9CE337CFE26B22E7E4F3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void traceMethodCalls(boolean enable) {
        dsTaint.addTaint(enable);
        {
            {
                VMDebug.startMethodTracing();
            } //End block
            {
                VMDebug.stopMethodTracing();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (enable != tracingMethods) {
            //if (enable) {
                //VMDebug.startMethodTracing();
            //} else {
                //VMDebug.stopMethodTracing();
            //}
            //tracingMethods = enable;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.023 -0400", hash_original_method = "4DD488C3A0CAA7F2473CD0DE597FBF5E", hash_generated_method = "FFC1FE543697B519946987ACA79AA6AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public InputStream getLocalizedInputStream(InputStream stream) {
        dsTaint.addTaint(stream.dsTaint);
        String encoding;
        encoding = System.getProperty("file.encoding", "UTF-8");
        {
            boolean var56FB0B863E6966178EDCAEC9F77CCF78_193927031 = (!encoding.equals("UTF-8"));
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Cannot localize " + encoding);
            } //End block
        } //End collapsed parenthetic
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String encoding = System.getProperty("file.encoding", "UTF-8");
        //if (!encoding.equals("UTF-8")) {
            //throw new UnsupportedOperationException("Cannot localize " + encoding);
        //}
        //return stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.023 -0400", hash_original_method = "E706425DACD57D6DD3EDF96DBA8FB92E", hash_generated_method = "303AB3BD99342FBD6CA9FA5F606C7C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public OutputStream getLocalizedOutputStream(OutputStream stream) {
        dsTaint.addTaint(stream.dsTaint);
        String encoding;
        encoding = System.getProperty("file.encoding", "UTF-8");
        {
            boolean var56FB0B863E6966178EDCAEC9F77CCF78_1796752715 = (!encoding.equals("UTF-8"));
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Cannot localize " + encoding);
            } //End block
        } //End collapsed parenthetic
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String encoding = System.getProperty("file.encoding", "UTF-8");
        //if (!encoding.equals("UTF-8")) {
            //throw new UnsupportedOperationException("Cannot localize " + encoding);
        //}
        //return stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.024 -0400", hash_original_method = "4A60C315F45CCAAE039020003BF5AFDA", hash_generated_method = "9D8543D94F8939824F17CC2206649F92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addShutdownHook(Thread hook) {
        dsTaint.addTaint(hook.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Hook may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("VM already shutting down");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Hook has already been started");
        } //End block
        {
            {
                boolean varB375300D425302ED7695B13548FF6B77_1395351029 = (shutdownHooks.contains(hook));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Hook already registered.");
                } //End block
            } //End collapsed parenthetic
            shutdownHooks.add(hook);
        } //End block
        // ---------- Original Method ----------
        //if (hook == null) {
            //throw new NullPointerException("Hook may not be null.");
        //}
        //if (shuttingDown) {
            //throw new IllegalStateException("VM already shutting down");
        //}
        //if (hook.hasBeenStarted) {
            //throw new IllegalArgumentException("Hook has already been started");
        //}
        //synchronized (shutdownHooks) {
            //if (shutdownHooks.contains(hook)) {
                //throw new IllegalArgumentException("Hook already registered.");
            //}
            //shutdownHooks.add(hook);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.024 -0400", hash_original_method = "402CE948C1020CDD411F4962B0A96E04", hash_generated_method = "874AF7A90DCF0221E1D7FA8BB8DAD1EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeShutdownHook(Thread hook) {
        dsTaint.addTaint(hook.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Hook may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("VM already shutting down");
        } //End block
        {
            boolean var9FCE62545780AFCB81D1769B08241B09_1318111519 = (shutdownHooks.remove(hook));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (hook == null) {
            //throw new NullPointerException("Hook may not be null.");
        //}
        //if (shuttingDown) {
            //throw new IllegalStateException("VM already shutting down");
        //}
        //synchronized (shutdownHooks) {
            //return shutdownHooks.remove(hook);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.025 -0400", hash_original_method = "9A4EA06F4CB88B6269FED18A769E865A", hash_generated_method = "3E74E3376C64B4AE3F18846B7287AB85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void halt(int code) {
        dsTaint.addTaint(code);
        nativeExit(code, false);
        // ---------- Original Method ----------
        //nativeExit(code, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.025 -0400", hash_original_method = "1DA5795546617F35E1E74BDB5F5DDD58", hash_generated_method = "83EB598B716CD871F41AB83F02A5A11E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int availableProcessors() {
        int varE4943BFEE5B34DD0F2833905316968EE_1662710968 = ((int) Libcore.os.sysconf(_SC_NPROCESSORS_ONLN));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) Libcore.os.sysconf(_SC_NPROCESSORS_ONLN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.025 -0400", hash_original_method = "2D7CF54D0F59DA12C2E5D19C64B23A09", hash_generated_method = "F72E5CF4029438E07F6D0F885CD8ED8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long maxMemory() {
        return dsTaint.getTaintLong();
    }

    
    private static final Runtime mRuntime = new Runtime();
    private static boolean finalizeOnExit;
}

