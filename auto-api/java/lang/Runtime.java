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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.608 -0400", hash_original_field = "6B000CDB16A1C13D718033E4DCCD85DA", hash_generated_field = "873422259A0094C2F3A569B7BBF35F19")

    private String[] mLibPaths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.608 -0400", hash_original_field = "79B302E8A5A117E80D56060C347988CB", hash_generated_field = "8FF982D34AB52E579D2BCD2486CCEB28")

    private List<Thread> shutdownHooks = new ArrayList<Thread>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.608 -0400", hash_original_field = "BE3D0AB12E871A97C27100D4A3183EC2", hash_generated_field = "7D744FBAE3A0077A4F980F9B4BD97716")

    private boolean shuttingDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.608 -0400", hash_original_field = "F19F90B8C4E6B181500D2F74A31F0D15", hash_generated_field = "C37DB832480F2E52014FFDC3AABF7287")

    private boolean tracingMethods;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.609 -0400", hash_original_method = "F82AC05B2B9BDA560435929D86D5DD16", hash_generated_method = "7368E10F5BAAA8CFF653BA7EC392E776")
    private  Runtime() {
        String pathList = System.getProperty("java.library.path", ".");
        String pathSep = System.getProperty("path.separator", ":");
        String fileSep = System.getProperty("file.separator", "/");
        mLibPaths = pathList.split(pathSep);
        {
            int i = 0;
            {
                {
                    boolean var1BFF5A0C86E86C64CD92FD978F3DE564_1195701954 = (!mLibPaths[i].endsWith(fileSep));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.609 -0400", hash_original_method = "CFCE84E7C9BE3630A08A3A7BB73629F7", hash_generated_method = "11410ACCDBEB07E525B97D07AFAED2BC")
    public Process exec(String[] progArray) throws java.io.IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_1456770187 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1456770187 = exec(progArray, null, null);
        addTaint(progArray[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1456770187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1456770187;
        // ---------- Original Method ----------
        //return exec(progArray, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.610 -0400", hash_original_method = "DBDF96D0DD01BF3A81297C1A77D3788B", hash_generated_method = "487A4897DC4B6D7C79CE7894AE271D10")
    public Process exec(String[] progArray, String[] envp) throws java.io.IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_1614219471 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1614219471 = exec(progArray, envp, null);
        addTaint(progArray[0].getTaint());
        addTaint(envp[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1614219471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1614219471;
        // ---------- Original Method ----------
        //return exec(progArray, envp, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.611 -0400", hash_original_method = "CA3870F83BC3F7A92215C18375ED76A3", hash_generated_method = "E61FC71E14F8B9C90174C0749CB31BBD")
    public Process exec(String[] progArray, String[] envp, File directory) throws IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_1729321189 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1729321189 = ProcessManager.getInstance().exec(progArray, envp, directory, false);
        addTaint(progArray[0].getTaint());
        addTaint(envp[0].getTaint());
        addTaint(directory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1729321189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1729321189;
        // ---------- Original Method ----------
        //return ProcessManager.getInstance().exec(progArray, envp, directory, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.612 -0400", hash_original_method = "06266E096A96F3360CE9E0923017372F", hash_generated_method = "D440C3C4F654B4776D45534B3F7A412B")
    public Process exec(String prog) throws java.io.IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_1655598375 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1655598375 = exec(prog, null, null);
        addTaint(prog.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1655598375.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1655598375;
        // ---------- Original Method ----------
        //return exec(prog, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.612 -0400", hash_original_method = "7285BF96BB6399D281A4BE01B5D250F8", hash_generated_method = "0BEDC099EA5FF05E70586E80EBA7DCCD")
    public Process exec(String prog, String[] envp) throws java.io.IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_1940030448 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1940030448 = exec(prog, envp, null);
        addTaint(prog.getTaint());
        addTaint(envp[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1940030448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1940030448;
        // ---------- Original Method ----------
        //return exec(prog, envp, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.613 -0400", hash_original_method = "D63330F96D8E34D6A893E8125BEC80CB", hash_generated_method = "36899C33FC37A47B336EC311F20A4C29")
    public Process exec(String prog, String[] envp, File directory) throws java.io.IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_2110238120 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var76D3DE3C27BAB87F3C1BE357F241404A_1610018788 = (prog.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        StringTokenizer tokenizer = new StringTokenizer(prog);
        int length = tokenizer.countTokens();
        String[] progArray = new String[length];
        {
            int i = 0;
            {
                progArray[i] = tokenizer.nextToken();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2110238120 = exec(progArray, envp, directory);
        addTaint(prog.getTaint());
        addTaint(envp[0].getTaint());
        addTaint(directory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2110238120.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2110238120;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.624 -0400", hash_original_method = "06E9B7958C64599C6A29BDE55862BAAD", hash_generated_method = "F3EF2054D3BCC5B4332A4A04A47155A2")
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
        addTaint(code);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.624 -0400", hash_original_method = "67196F5597F9CC48251D355499CA1423", hash_generated_method = "A21E5AB7BBD81B5CC954F118A80344D3")
    public long freeMemory() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1135677876 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1135677876;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.624 -0400", hash_original_method = "D5E9C32F4CCF731A5E6B245C708DE511", hash_generated_method = "F2BA90326A844E033E7882399F00530F")
    public void gc() {
    }

    
    public static Runtime getRuntime() {
        return mRuntime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.625 -0400", hash_original_method = "D4CBB36D8902BC048F224692FC6F0770", hash_generated_method = "DC29CE609922968E32C2C6D814E5FC1B")
    public void load(String pathName) {
        load(pathName, VMStack.getCallingClassLoader());
        addTaint(pathName.getTaint());
        // ---------- Original Method ----------
        //load(pathName, VMStack.getCallingClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.625 -0400", hash_original_method = "93CD7EAF10A1B837C6D2761A80025550", hash_generated_method = "A2D56C28EA37FCCF585207FFBB337419")
     void load(String filename, ClassLoader loader) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("library path was null.");
        } //End block
        String error = nativeLoad(filename, loader);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.626 -0400", hash_original_method = "552217161A043147D154E437EB4B14C4", hash_generated_method = "5719CC14A6F1CB750EA9A16604ADBA49")
    public void loadLibrary(String libName) {
        loadLibrary(libName, VMStack.getCallingClassLoader());
        addTaint(libName.getTaint());
        // ---------- Original Method ----------
        //loadLibrary(libName, VMStack.getCallingClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.632 -0400", hash_original_method = "5EE816C9B41613E4D79FD41D836C9458", hash_generated_method = "DE121221752AE396FAB2C57A77466D3A")
     void loadLibrary(String libraryName, ClassLoader loader) {
        {
            String filename = loader.findLibrary(libraryName);
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsatisfiedLinkError("Couldn't load " + libraryName + ": " +
                        "findLibrary returned null");
            } //End block
            String error = nativeLoad(filename, loader);
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsatisfiedLinkError(error);
            } //End block
        } //End block
        String filename = System.mapLibraryName(libraryName);
        List<String> candidates = new ArrayList<String>();
        String lastError = null;
        {
            String directory = mLibPaths[0];
            {
                String candidate = directory + filename;
                candidates.add(candidate);
                {
                    boolean var83E84C412CAF9691B50D589C1BC72418_1084978343 = (new File(candidate).exists());
                    {
                        String error = nativeLoad(candidate, loader);
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
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.633 -0400", hash_original_method = "D97B4D8E5C3471916B8248342E55C9E3", hash_generated_method = "B8DF1E762B1639FEAD14C63E4F21ADD5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.633 -0400", hash_original_method = "4EB2522F808EA94D0A66B66F863EF421", hash_generated_method = "C8317F58F83817B2CAFCFF0DB356528C")
    public long totalMemory() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_714844002 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_714844002;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.633 -0400", hash_original_method = "53798D26DA92803B5299289F1912C9D0", hash_generated_method = "D48C5D50EAB5ED262BC047C38DB9B711")
    public void traceInstructions(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.634 -0400", hash_original_method = "047BFF8451D039E49AAF4D452A82FBF3", hash_generated_method = "ED4C7F340C5E2463306E7F5086AE156E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.634 -0400", hash_original_method = "4DD488C3A0CAA7F2473CD0DE597FBF5E", hash_generated_method = "8FD33C87108C1FFA165BF73B9B93EE3B")
    @Deprecated
    public InputStream getLocalizedInputStream(InputStream stream) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1994265902 = null; //Variable for return #1
        String encoding = System.getProperty("file.encoding", "UTF-8");
        {
            boolean var56FB0B863E6966178EDCAEC9F77CCF78_1617258 = (!encoding.equals("UTF-8"));
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Cannot localize " + encoding);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1994265902 = stream;
        addTaint(stream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1994265902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1994265902;
        // ---------- Original Method ----------
        //String encoding = System.getProperty("file.encoding", "UTF-8");
        //if (!encoding.equals("UTF-8")) {
            //throw new UnsupportedOperationException("Cannot localize " + encoding);
        //}
        //return stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.635 -0400", hash_original_method = "E706425DACD57D6DD3EDF96DBA8FB92E", hash_generated_method = "B5D6D7CB8CC4C021DA4551F7674D91B5")
    @Deprecated
    public OutputStream getLocalizedOutputStream(OutputStream stream) {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_220828521 = null; //Variable for return #1
        String encoding = System.getProperty("file.encoding", "UTF-8");
        {
            boolean var56FB0B863E6966178EDCAEC9F77CCF78_1859523720 = (!encoding.equals("UTF-8"));
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Cannot localize " + encoding);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_220828521 = stream;
        addTaint(stream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_220828521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_220828521;
        // ---------- Original Method ----------
        //String encoding = System.getProperty("file.encoding", "UTF-8");
        //if (!encoding.equals("UTF-8")) {
            //throw new UnsupportedOperationException("Cannot localize " + encoding);
        //}
        //return stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.635 -0400", hash_original_method = "4A60C315F45CCAAE039020003BF5AFDA", hash_generated_method = "BAEA2140286CBED6D3018ADD6CF6CE3F")
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
                boolean varB375300D425302ED7695B13548FF6B77_115380046 = (shutdownHooks.contains(hook));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.635 -0400", hash_original_method = "402CE948C1020CDD411F4962B0A96E04", hash_generated_method = "7399FDC386DD9D42A3FEAAB5B7F17741")
    public boolean removeShutdownHook(Thread hook) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Hook may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("VM already shutting down");
        } //End block
        {
            boolean var9FCE62545780AFCB81D1769B08241B09_1830547334 = (shutdownHooks.remove(hook));
        } //End block
        addTaint(hook.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_377116162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_377116162;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.636 -0400", hash_original_method = "9A4EA06F4CB88B6269FED18A769E865A", hash_generated_method = "7AEE91E4190510ED75A5A144A8539F6C")
    public void halt(int code) {
        nativeExit(code, false);
        addTaint(code);
        // ---------- Original Method ----------
        //nativeExit(code, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.636 -0400", hash_original_method = "1DA5795546617F35E1E74BDB5F5DDD58", hash_generated_method = "963FF2DC27D394C9B65DC2F4D0956EF4")
    public int availableProcessors() {
        int varE4943BFEE5B34DD0F2833905316968EE_1639348303 = ((int) Libcore.os.sysconf(_SC_NPROCESSORS_ONLN));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503711936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503711936;
        // ---------- Original Method ----------
        //return (int) Libcore.os.sysconf(_SC_NPROCESSORS_ONLN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.636 -0400", hash_original_method = "2D7CF54D0F59DA12C2E5D19C64B23A09", hash_generated_method = "903AA4ED1DF7612A3B2CCBFA21511325")
    public long maxMemory() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_580957644 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_580957644;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.636 -0400", hash_original_field = "64A54F6AA478FD75410DF278F8FCFDFB", hash_generated_field = "BCF5878BF465442984A343ACEC428E44")

    private static final Runtime mRuntime = new Runtime();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.636 -0400", hash_original_field = "91D2F657B5D6047F292755B5CAE6D9EA", hash_generated_field = "1AEBD11A773D78919BD6052F0FCA4C19")

    private static boolean finalizeOnExit;
}

