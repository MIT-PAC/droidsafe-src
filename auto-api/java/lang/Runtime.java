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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.065 -0400", hash_original_field = "6B000CDB16A1C13D718033E4DCCD85DA", hash_generated_field = "873422259A0094C2F3A569B7BBF35F19")

    private String[] mLibPaths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.065 -0400", hash_original_field = "79B302E8A5A117E80D56060C347988CB", hash_generated_field = "8FF982D34AB52E579D2BCD2486CCEB28")

    private List<Thread> shutdownHooks = new ArrayList<Thread>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.065 -0400", hash_original_field = "BE3D0AB12E871A97C27100D4A3183EC2", hash_generated_field = "7D744FBAE3A0077A4F980F9B4BD97716")

    private boolean shuttingDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.065 -0400", hash_original_field = "F19F90B8C4E6B181500D2F74A31F0D15", hash_generated_field = "C37DB832480F2E52014FFDC3AABF7287")

    private boolean tracingMethods;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.086 -0400", hash_original_method = "F82AC05B2B9BDA560435929D86D5DD16", hash_generated_method = "02F1FB5AFAC13964332D801BD85F389A")
    private  Runtime() {
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
                    boolean var1BFF5A0C86E86C64CD92FD978F3DE564_1333133288 = (!mLibPaths[i].endsWith(fileSep));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.086 -0400", hash_original_method = "CFCE84E7C9BE3630A08A3A7BB73629F7", hash_generated_method = "B904DFA848CA1549B6B528BA975031CC")
    public Process exec(String[] progArray) throws java.io.IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_1288153899 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1288153899 = exec(progArray, null, null);
        addTaint(progArray[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1288153899.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1288153899;
        // ---------- Original Method ----------
        //return exec(progArray, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.087 -0400", hash_original_method = "DBDF96D0DD01BF3A81297C1A77D3788B", hash_generated_method = "D7CA4D7F1C9F2FBD793AFC707F71220D")
    public Process exec(String[] progArray, String[] envp) throws java.io.IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_1464892557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1464892557 = exec(progArray, envp, null);
        addTaint(progArray[0].getTaint());
        addTaint(envp[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1464892557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1464892557;
        // ---------- Original Method ----------
        //return exec(progArray, envp, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.093 -0400", hash_original_method = "CA3870F83BC3F7A92215C18375ED76A3", hash_generated_method = "7E5EF783CA383EEF442D6F7FBFB58487")
    public Process exec(String[] progArray, String[] envp, File directory) throws IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_442385456 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_442385456 = ProcessManager.getInstance().exec(progArray, envp, directory, false);
        addTaint(progArray[0].getTaint());
        addTaint(envp[0].getTaint());
        addTaint(directory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_442385456.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_442385456;
        // ---------- Original Method ----------
        //return ProcessManager.getInstance().exec(progArray, envp, directory, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.094 -0400", hash_original_method = "06266E096A96F3360CE9E0923017372F", hash_generated_method = "5ED5DAAA48EC0FC4CB7280CB6A123887")
    public Process exec(String prog) throws java.io.IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_80409706 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_80409706 = exec(prog, null, null);
        addTaint(prog.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_80409706.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_80409706;
        // ---------- Original Method ----------
        //return exec(prog, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.094 -0400", hash_original_method = "7285BF96BB6399D281A4BE01B5D250F8", hash_generated_method = "8A60BC9CEA4F56D62DCB3455F42F7F01")
    public Process exec(String prog, String[] envp) throws java.io.IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_1033457328 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1033457328 = exec(prog, envp, null);
        addTaint(prog.getTaint());
        addTaint(envp[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1033457328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1033457328;
        // ---------- Original Method ----------
        //return exec(prog, envp, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.100 -0400", hash_original_method = "D63330F96D8E34D6A893E8125BEC80CB", hash_generated_method = "0B3E4C3F58E654EE23DDCDEFAF9882B7")
    public Process exec(String prog, String[] envp, File directory) throws java.io.IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_1294214785 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var76D3DE3C27BAB87F3C1BE357F241404A_603159769 = (prog.length() == 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1294214785 = exec(progArray, envp, directory);
        addTaint(prog.getTaint());
        addTaint(envp[0].getTaint());
        addTaint(directory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1294214785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1294214785;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.170 -0400", hash_original_method = "06E9B7958C64599C6A29BDE55862BAAD", hash_generated_method = "6AFB2DC9ABA17A2F4803FB3D2020ECDE")
    public void exit(int code) {
        {
            {
                shuttingDown = true;
                Thread[] hooks;
                {
                    hooks = new Thread[shutdownHooks.size()];
                    shutdownHooks.toArray(hooks);
                } //End block
                {
                    Iterator<Thread> varC5FB4F41E753A393942957BD44C2EF60_722948653 = (hooks).iterator();
                    varC5FB4F41E753A393942957BD44C2EF60_722948653.hasNext();
                    Thread hook = varC5FB4F41E753A393942957BD44C2EF60_722948653.next();
                    {
                        hook.start();
                    } //End block
                } //End collapsed parenthetic
                {
                    Iterator<Thread> varC5FB4F41E753A393942957BD44C2EF60_1289406353 = (hooks).iterator();
                    varC5FB4F41E753A393942957BD44C2EF60_1289406353.hasNext();
                    Thread hook = varC5FB4F41E753A393942957BD44C2EF60_1289406353.next();
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
        addTaint(code);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.170 -0400", hash_original_method = "67196F5597F9CC48251D355499CA1423", hash_generated_method = "FF63301EFD8E1A38DB7FECC24956A61D")
    public long freeMemory() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_503836864 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_503836864;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.172 -0400", hash_original_method = "D5E9C32F4CCF731A5E6B245C708DE511", hash_generated_method = "F2BA90326A844E033E7882399F00530F")
    public void gc() {
    }

    
        public static Runtime getRuntime() {
        return mRuntime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.173 -0400", hash_original_method = "D4CBB36D8902BC048F224692FC6F0770", hash_generated_method = "DC29CE609922968E32C2C6D814E5FC1B")
    public void load(String pathName) {
        load(pathName, VMStack.getCallingClassLoader());
        addTaint(pathName.getTaint());
        // ---------- Original Method ----------
        //load(pathName, VMStack.getCallingClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.174 -0400", hash_original_method = "93CD7EAF10A1B837C6D2761A80025550", hash_generated_method = "942482764565D39F622FB3858A360546")
     void load(String filename, ClassLoader loader) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("library path was null.");
        } //End block
        String error;
        error = nativeLoad(filename, loader);
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsatisfiedLinkError(error);
        } //End block
        addTaint(filename.getTaint());
        addTaint(loader.getTaint());
        // ---------- Original Method ----------
        //if (filename == null) {
            //throw new NullPointerException("library path was null.");
        //}
        //String error = nativeLoad(filename, loader);
        //if (error != null) {
            //throw new UnsatisfiedLinkError(error);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.177 -0400", hash_original_method = "552217161A043147D154E437EB4B14C4", hash_generated_method = "5719CC14A6F1CB750EA9A16604ADBA49")
    public void loadLibrary(String libName) {
        loadLibrary(libName, VMStack.getCallingClassLoader());
        addTaint(libName.getTaint());
        // ---------- Original Method ----------
        //loadLibrary(libName, VMStack.getCallingClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.239 -0400", hash_original_method = "5EE816C9B41613E4D79FD41D836C9458", hash_generated_method = "CE7F0E2CE82434EC92E200E1276EBB93")
     void loadLibrary(String libraryName, ClassLoader loader) {
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
                    boolean var83E84C412CAF9691B50D589C1BC72418_735684835 = (new File(candidate).exists());
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
        addTaint(libraryName.getTaint());
        addTaint(loader.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void nativeExit(int code, boolean isExit) {
    }

    
        private static String nativeLoad(String filename, ClassLoader loader) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.258 -0400", hash_original_method = "D97B4D8E5C3471916B8248342E55C9E3", hash_generated_method = "B8DF1E762B1639FEAD14C63E4F21ADD5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.259 -0400", hash_original_method = "4EB2522F808EA94D0A66B66F863EF421", hash_generated_method = "5DD5373B91E527E4FD47F9B2475F72AC")
    public long totalMemory() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_246217571 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_246217571;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.259 -0400", hash_original_method = "53798D26DA92803B5299289F1912C9D0", hash_generated_method = "D48C5D50EAB5ED262BC047C38DB9B711")
    public void traceInstructions(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.259 -0400", hash_original_method = "047BFF8451D039E49AAF4D452A82FBF3", hash_generated_method = "ED4C7F340C5E2463306E7F5086AE156E")
    public void traceMethodCalls(boolean enable) {
        {
            {
                VMDebug.startMethodTracing();
            } //End block
            {
                VMDebug.stopMethodTracing();
            } //End block
            tracingMethods = enable;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.260 -0400", hash_original_method = "4DD488C3A0CAA7F2473CD0DE597FBF5E", hash_generated_method = "7594A2C2B3353E3843982544DA96C777")
    @Deprecated
    public InputStream getLocalizedInputStream(InputStream stream) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_665867367 = null; //Variable for return #1
        String encoding;
        encoding = System.getProperty("file.encoding", "UTF-8");
        {
            boolean var56FB0B863E6966178EDCAEC9F77CCF78_761185950 = (!encoding.equals("UTF-8"));
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Cannot localize " + encoding);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_665867367 = stream;
        addTaint(stream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_665867367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_665867367;
        // ---------- Original Method ----------
        //String encoding = System.getProperty("file.encoding", "UTF-8");
        //if (!encoding.equals("UTF-8")) {
            //throw new UnsupportedOperationException("Cannot localize " + encoding);
        //}
        //return stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.260 -0400", hash_original_method = "E706425DACD57D6DD3EDF96DBA8FB92E", hash_generated_method = "632C9CF5795CD9E2624BCDFBB11121F3")
    @Deprecated
    public OutputStream getLocalizedOutputStream(OutputStream stream) {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1608976175 = null; //Variable for return #1
        String encoding;
        encoding = System.getProperty("file.encoding", "UTF-8");
        {
            boolean var56FB0B863E6966178EDCAEC9F77CCF78_190035578 = (!encoding.equals("UTF-8"));
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Cannot localize " + encoding);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1608976175 = stream;
        addTaint(stream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1608976175.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1608976175;
        // ---------- Original Method ----------
        //String encoding = System.getProperty("file.encoding", "UTF-8");
        //if (!encoding.equals("UTF-8")) {
            //throw new UnsupportedOperationException("Cannot localize " + encoding);
        //}
        //return stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.261 -0400", hash_original_method = "4A60C315F45CCAAE039020003BF5AFDA", hash_generated_method = "D9F3799D5A6BC251F130C7E826496637")
    public void addShutdownHook(Thread hook) {
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
                boolean varB375300D425302ED7695B13548FF6B77_622081127 = (shutdownHooks.contains(hook));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Hook already registered.");
                } //End block
            } //End collapsed parenthetic
            shutdownHooks.add(hook);
        } //End block
        addTaint(hook.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.261 -0400", hash_original_method = "402CE948C1020CDD411F4962B0A96E04", hash_generated_method = "3D17B371A033EFA4555CDBC791CCC5A7")
    public boolean removeShutdownHook(Thread hook) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Hook may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("VM already shutting down");
        } //End block
        {
            boolean var9FCE62545780AFCB81D1769B08241B09_1738036150 = (shutdownHooks.remove(hook));
        } //End block
        addTaint(hook.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013304026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013304026;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.265 -0400", hash_original_method = "9A4EA06F4CB88B6269FED18A769E865A", hash_generated_method = "7AEE91E4190510ED75A5A144A8539F6C")
    public void halt(int code) {
        nativeExit(code, false);
        addTaint(code);
        // ---------- Original Method ----------
        //nativeExit(code, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.265 -0400", hash_original_method = "1DA5795546617F35E1E74BDB5F5DDD58", hash_generated_method = "C36C7F232BCB5B4F092E764509F0FB0D")
    public int availableProcessors() {
        int varE4943BFEE5B34DD0F2833905316968EE_767220513 = ((int) Libcore.os.sysconf(_SC_NPROCESSORS_ONLN));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430441051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430441051;
        // ---------- Original Method ----------
        //return (int) Libcore.os.sysconf(_SC_NPROCESSORS_ONLN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.266 -0400", hash_original_method = "2D7CF54D0F59DA12C2E5D19C64B23A09", hash_generated_method = "1DD7E5D53EDE155D4E9271EA5DC8DCA2")
    public long maxMemory() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_160101782 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_160101782;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.266 -0400", hash_original_field = "64A54F6AA478FD75410DF278F8FCFDFB", hash_generated_field = "B4C08860E5CD7CD9C6324D581AD10E5C")

    private static Runtime mRuntime = new Runtime();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.266 -0400", hash_original_field = "91D2F657B5D6047F292755B5CAE6D9EA", hash_generated_field = "1AEBD11A773D78919BD6052F0FCA4C19")

    private static boolean finalizeOnExit;
}

