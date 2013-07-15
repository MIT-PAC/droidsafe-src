package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.288 -0400", hash_original_field = "6B000CDB16A1C13D718033E4DCCD85DA", hash_generated_field = "873422259A0094C2F3A569B7BBF35F19")

    private String[] mLibPaths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.288 -0400", hash_original_field = "79B302E8A5A117E80D56060C347988CB", hash_generated_field = "8FF982D34AB52E579D2BCD2486CCEB28")

    private List<Thread> shutdownHooks = new ArrayList<Thread>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.289 -0400", hash_original_field = "BE3D0AB12E871A97C27100D4A3183EC2", hash_generated_field = "7D744FBAE3A0077A4F980F9B4BD97716")

    private boolean shuttingDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.289 -0400", hash_original_field = "F19F90B8C4E6B181500D2F74A31F0D15", hash_generated_field = "C37DB832480F2E52014FFDC3AABF7287")

    private boolean tracingMethods;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.290 -0400", hash_original_method = "F82AC05B2B9BDA560435929D86D5DD16", hash_generated_method = "AAB21F2EDBE02CAE189D3D873254E410")
    private  Runtime() {
        String pathList = System.getProperty("java.library.path", ".");
        String pathSep = System.getProperty("path.separator", ":");
        String fileSep = System.getProperty("file.separator", "/");
        mLibPaths = pathList.split(pathSep);
for(int i = 0;i < mLibPaths.length;i++)
        {
    if(!mLibPaths[i].endsWith(fileSep))            
            {
                mLibPaths[i] += fileSep;
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.290 -0400", hash_original_method = "CFCE84E7C9BE3630A08A3A7BB73629F7", hash_generated_method = "DE98BC0227E95C30D246389E4F838296")
    public Process exec(String[] progArray) throws java.io.IOException {
        addTaint(progArray[0].getTaint());
Process varB5AE023C2C76827666E188EFE3865CA0_281307029 =         exec(progArray, null, null);
        varB5AE023C2C76827666E188EFE3865CA0_281307029.addTaint(taint);
        return varB5AE023C2C76827666E188EFE3865CA0_281307029;
        // ---------- Original Method ----------
        //return exec(progArray, null, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.291 -0400", hash_original_method = "DBDF96D0DD01BF3A81297C1A77D3788B", hash_generated_method = "212DF5E69F0D8600F2931C7497DD9ED2")
    public Process exec(String[] progArray, String[] envp) throws java.io.IOException {
        addTaint(envp[0].getTaint());
        addTaint(progArray[0].getTaint());
Process var693CD98BF0722BB7E92D3DBC27727865_512526420 =         exec(progArray, envp, null);
        var693CD98BF0722BB7E92D3DBC27727865_512526420.addTaint(taint);
        return var693CD98BF0722BB7E92D3DBC27727865_512526420;
        // ---------- Original Method ----------
        //return exec(progArray, envp, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.292 -0400", hash_original_method = "CA3870F83BC3F7A92215C18375ED76A3", hash_generated_method = "7C7C6BEDA2CC047316009ABCF87D34ED")
    public Process exec(String[] progArray, String[] envp, File directory) throws IOException {
        addTaint(directory.getTaint());
        addTaint(envp[0].getTaint());
        addTaint(progArray[0].getTaint());
Process var4E4DCAD82A8B0D144A666A6F80D7C2BE_531265977 =         ProcessManager.getInstance().exec(progArray, envp, directory, false);
        var4E4DCAD82A8B0D144A666A6F80D7C2BE_531265977.addTaint(taint);
        return var4E4DCAD82A8B0D144A666A6F80D7C2BE_531265977;
        // ---------- Original Method ----------
        //return ProcessManager.getInstance().exec(progArray, envp, directory, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.292 -0400", hash_original_method = "06266E096A96F3360CE9E0923017372F", hash_generated_method = "6B90BD135C6F0E369B9E010AE0556E1F")
    public Process exec(String prog) throws java.io.IOException {
        addTaint(prog.getTaint());
Process var990C45AE4F02D2C793693326250AED03_1012966407 =         exec(prog, null, null);
        var990C45AE4F02D2C793693326250AED03_1012966407.addTaint(taint);
        return var990C45AE4F02D2C793693326250AED03_1012966407;
        // ---------- Original Method ----------
        //return exec(prog, null, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.293 -0400", hash_original_method = "7285BF96BB6399D281A4BE01B5D250F8", hash_generated_method = "D119F823CAC2DCAC6424181D6328DB5F")
    public Process exec(String prog, String[] envp) throws java.io.IOException {
        addTaint(envp[0].getTaint());
        addTaint(prog.getTaint());
Process varA431CE7DDA218E5A0D9A899C1ED75264_529693589 =         exec(prog, envp, null);
        varA431CE7DDA218E5A0D9A899C1ED75264_529693589.addTaint(taint);
        return varA431CE7DDA218E5A0D9A899C1ED75264_529693589;
        // ---------- Original Method ----------
        //return exec(prog, envp, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.294 -0400", hash_original_method = "D63330F96D8E34D6A893E8125BEC80CB", hash_generated_method = "B799BC96EEA0842B7C5829E7C76BD4A0")
    public Process exec(String prog, String[] envp, File directory) throws java.io.IOException {
        addTaint(directory.getTaint());
        addTaint(envp[0].getTaint());
        addTaint(prog.getTaint());
    if(prog == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_240332225 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_240332225.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_240332225;
        } //End block
        else
    if(prog.length() == 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_808594912 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_808594912.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_808594912;
        } //End block
        StringTokenizer tokenizer = new StringTokenizer(prog);
        int length = tokenizer.countTokens();
        String[] progArray = new String[length];
for(int i = 0;i < length;i++)
        {
            progArray[i] = tokenizer.nextToken();
        } //End block
Process var135DE1988B4098A40D0AEA4BE3D97DCB_1896453338 =         exec(progArray, envp, directory);
        var135DE1988B4098A40D0AEA4BE3D97DCB_1896453338.addTaint(taint);
        return var135DE1988B4098A40D0AEA4BE3D97DCB_1896453338;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.295 -0400", hash_original_method = "06E9B7958C64599C6A29BDE55862BAAD", hash_generated_method = "D896AC8A4E422CEB1E22D3CA47A35503")
    public void exit(int code) {
        addTaint(code);
        synchronized
(this)        {
    if(!shuttingDown)            
            {
                shuttingDown = true;
                Thread[] hooks;
                synchronized
(shutdownHooks)                {
                    hooks = new Thread[shutdownHooks.size()];
                    shutdownHooks.toArray(hooks);
                } //End block
for(Thread hook : hooks)
                {
                    hook.start();
                } //End block
for(Thread hook : hooks)
                {
                    try 
                    {
                        hook.join();
                    } //End block
                    catch (InterruptedException ex)
                    {
                    } //End block
                } //End block
    if(finalizeOnExit)                
                {
                    runFinalization();
                } //End block
                nativeExit(code, true);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.295 -0400", hash_original_method = "67196F5597F9CC48251D355499CA1423", hash_generated_method = "03408D5FDF9057D5E8E3B43BFBC88A1E")
    public long freeMemory() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_66097031 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_66097031;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.296 -0400", hash_original_method = "D5E9C32F4CCF731A5E6B245C708DE511", hash_generated_method = "F2BA90326A844E033E7882399F00530F")
    public void gc() {
    }

    
        @DSModeled(DSC.SAFE)
    public static Runtime getRuntime() {
        return mRuntime;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.296 -0400", hash_original_method = "D4CBB36D8902BC048F224692FC6F0770", hash_generated_method = "3199DB5401F7EABDB9921865C5D290C0")
    public void load(String pathName) {
        addTaint(pathName.getTaint());
        load(pathName, VMStack.getCallingClassLoader());
        // ---------- Original Method ----------
        //load(pathName, VMStack.getCallingClassLoader());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.297 -0400", hash_original_method = "93CD7EAF10A1B837C6D2761A80025550", hash_generated_method = "D94892DDD4F16F486160D0339689EC9C")
     void load(String filename, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(filename.getTaint());
    if(filename == null)        
        {
            NullPointerException var2887029265DA5CE77C424C12AD1C1202_166885195 = new NullPointerException("library path was null.");
            var2887029265DA5CE77C424C12AD1C1202_166885195.addTaint(taint);
            throw var2887029265DA5CE77C424C12AD1C1202_166885195;
        } //End block
        String error = nativeLoad(filename, loader);
    if(error != null)        
        {
            UnsatisfiedLinkError var6D9651BAAED668961F0ABBBB294D2B15_1228386985 = new UnsatisfiedLinkError(error);
            var6D9651BAAED668961F0ABBBB294D2B15_1228386985.addTaint(taint);
            throw var6D9651BAAED668961F0ABBBB294D2B15_1228386985;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.297 -0400", hash_original_method = "552217161A043147D154E437EB4B14C4", hash_generated_method = "77634FAC8FB00B1C8A58ABB17ECB3AB4")
    public void loadLibrary(String libName) {
        addTaint(libName.getTaint());
        loadLibrary(libName, VMStack.getCallingClassLoader());
        // ---------- Original Method ----------
        //loadLibrary(libName, VMStack.getCallingClassLoader());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.298 -0400", hash_original_method = "5EE816C9B41613E4D79FD41D836C9458", hash_generated_method = "8BAFF47C916258EB048BA3F408FC00F0")
     void loadLibrary(String libraryName, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(libraryName.getTaint());
    if(loader != null)        
        {
            String filename = loader.findLibrary(libraryName);
    if(filename == null)            
            {
                UnsatisfiedLinkError varC4B6326AECC763E5217CBCB514558E78_1117135018 = new UnsatisfiedLinkError("Couldn't load " + libraryName + ": " +
                        "findLibrary returned null");
                varC4B6326AECC763E5217CBCB514558E78_1117135018.addTaint(taint);
                throw varC4B6326AECC763E5217CBCB514558E78_1117135018;
            } //End block
            String error = nativeLoad(filename, loader);
    if(error != null)            
            {
                UnsatisfiedLinkError var6D9651BAAED668961F0ABBBB294D2B15_70382601 = new UnsatisfiedLinkError(error);
                var6D9651BAAED668961F0ABBBB294D2B15_70382601.addTaint(taint);
                throw var6D9651BAAED668961F0ABBBB294D2B15_70382601;
            } //End block
            return;
        } //End block
        String filename = System.mapLibraryName(libraryName);
        List<String> candidates = new ArrayList<String>();
        String lastError = null;
for(String directory : mLibPaths)
        {
            String candidate = directory + filename;
            candidates.add(candidate);
    if(new File(candidate).exists())            
            {
                String error = nativeLoad(candidate, loader);
    if(error == null)                
                {
                    return;
                } //End block
                lastError = error;
            } //End block
        } //End block
    if(lastError != null)        
        {
            UnsatisfiedLinkError var8F7D01AB79EC95BEF848DCBB4AB1B45A_688597007 = new UnsatisfiedLinkError(lastError);
            var8F7D01AB79EC95BEF848DCBB4AB1B45A_688597007.addTaint(taint);
            throw var8F7D01AB79EC95BEF848DCBB4AB1B45A_688597007;
        } //End block
        UnsatisfiedLinkError var0CDC881BAB489861DF33BA964E963465_1611379579 = new UnsatisfiedLinkError("Library " + libraryName + " not found; tried " + candidates);
        var0CDC881BAB489861DF33BA964E963465_1611379579.addTaint(taint);
        throw var0CDC881BAB489861DF33BA964E963465_1611379579;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeExit(int code, boolean isExit) {
	}

    
    @DSModeled(DSC.SAFE)
    private static String nativeLoad(String filename, ClassLoader loader) {
		String ret = new String();
		ret.addTaint(filename.taint);
		ret.addTaint(loader.taint);
		return ret;
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.299 -0400", hash_original_method = "D97B4D8E5C3471916B8248342E55C9E3", hash_generated_method = "B8DF1E762B1639FEAD14C63E4F21ADD5")
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

    
        @DSModeled(DSC.SAFE)
    @Deprecated
    public static void runFinalizersOnExit(boolean run) {
        finalizeOnExit = run;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.300 -0400", hash_original_method = "4EB2522F808EA94D0A66B66F863EF421", hash_generated_method = "181A8433F048FA7D08FFC2687F8D87F4")
    public long totalMemory() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1749391796 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1749391796;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.300 -0400", hash_original_method = "53798D26DA92803B5299289F1912C9D0", hash_generated_method = "D48C5D50EAB5ED262BC047C38DB9B711")
    public void traceInstructions(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.301 -0400", hash_original_method = "047BFF8451D039E49AAF4D452A82FBF3", hash_generated_method = "C3B1E7CFA2A8AD42FBF2700BC6F4D754")
    public void traceMethodCalls(boolean enable) {
    if(enable != tracingMethods)        
        {
    if(enable)            
            {
                VMDebug.startMethodTracing();
            } //End block
            else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.302 -0400", hash_original_method = "4DD488C3A0CAA7F2473CD0DE597FBF5E", hash_generated_method = "357022F036CE075CD7AEA66734010274")
    @Deprecated
    public InputStream getLocalizedInputStream(InputStream stream) {
        addTaint(stream.getTaint());
        String encoding = System.getProperty("file.encoding", "UTF-8");
    if(!encoding.equals("UTF-8"))        
        {
            UnsupportedOperationException var69AF4F26E2156FEA24D9CCC394B6D740_807485660 = new UnsupportedOperationException("Cannot localize " + encoding);
            var69AF4F26E2156FEA24D9CCC394B6D740_807485660.addTaint(taint);
            throw var69AF4F26E2156FEA24D9CCC394B6D740_807485660;
        } //End block
InputStream varA87CF74140B150613F4203E71875F9A7_1098659229 =         stream;
        varA87CF74140B150613F4203E71875F9A7_1098659229.addTaint(taint);
        return varA87CF74140B150613F4203E71875F9A7_1098659229;
        // ---------- Original Method ----------
        //String encoding = System.getProperty("file.encoding", "UTF-8");
        //if (!encoding.equals("UTF-8")) {
            //throw new UnsupportedOperationException("Cannot localize " + encoding);
        //}
        //return stream;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.303 -0400", hash_original_method = "E706425DACD57D6DD3EDF96DBA8FB92E", hash_generated_method = "3F28520119C6405523B85FA0A2A97683")
    @Deprecated
    public OutputStream getLocalizedOutputStream(OutputStream stream) {
        addTaint(stream.getTaint());
        String encoding = System.getProperty("file.encoding", "UTF-8");
    if(!encoding.equals("UTF-8"))        
        {
            UnsupportedOperationException var69AF4F26E2156FEA24D9CCC394B6D740_1259461864 = new UnsupportedOperationException("Cannot localize " + encoding);
            var69AF4F26E2156FEA24D9CCC394B6D740_1259461864.addTaint(taint);
            throw var69AF4F26E2156FEA24D9CCC394B6D740_1259461864;
        } //End block
OutputStream varA87CF74140B150613F4203E71875F9A7_1074491912 =         stream;
        varA87CF74140B150613F4203E71875F9A7_1074491912.addTaint(taint);
        return varA87CF74140B150613F4203E71875F9A7_1074491912;
        // ---------- Original Method ----------
        //String encoding = System.getProperty("file.encoding", "UTF-8");
        //if (!encoding.equals("UTF-8")) {
            //throw new UnsupportedOperationException("Cannot localize " + encoding);
        //}
        //return stream;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.303 -0400", hash_original_method = "4A60C315F45CCAAE039020003BF5AFDA", hash_generated_method = "7BA420BC48F89A7F61321646B1DCE1DB")
    public void addShutdownHook(Thread hook) {
        addTaint(hook.getTaint());
    if(hook == null)        
        {
            NullPointerException varD45B20DDAEE334176D265733B3022ECE_413483480 = new NullPointerException("Hook may not be null.");
            varD45B20DDAEE334176D265733B3022ECE_413483480.addTaint(taint);
            throw varD45B20DDAEE334176D265733B3022ECE_413483480;
        } //End block
    if(shuttingDown)        
        {
            IllegalStateException varAB7610C08E62199C846254E13EC9AEB7_211439441 = new IllegalStateException("VM already shutting down");
            varAB7610C08E62199C846254E13EC9AEB7_211439441.addTaint(taint);
            throw varAB7610C08E62199C846254E13EC9AEB7_211439441;
        } //End block
    if(hook.hasBeenStarted)        
        {
            IllegalArgumentException varB716A93D0B8494C7FD3589DC69CDA813_262818018 = new IllegalArgumentException("Hook has already been started");
            varB716A93D0B8494C7FD3589DC69CDA813_262818018.addTaint(taint);
            throw varB716A93D0B8494C7FD3589DC69CDA813_262818018;
        } //End block
        synchronized
(shutdownHooks)        {
    if(shutdownHooks.contains(hook))            
            {
                IllegalArgumentException var05627A522E1595B5E22BA75703BB10C0_66376373 = new IllegalArgumentException("Hook already registered.");
                var05627A522E1595B5E22BA75703BB10C0_66376373.addTaint(taint);
                throw var05627A522E1595B5E22BA75703BB10C0_66376373;
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.304 -0400", hash_original_method = "402CE948C1020CDD411F4962B0A96E04", hash_generated_method = "60440356EFEE521D328AE143402F9DCA")
    public boolean removeShutdownHook(Thread hook) {
        addTaint(hook.getTaint());
    if(hook == null)        
        {
            NullPointerException varD45B20DDAEE334176D265733B3022ECE_1672444972 = new NullPointerException("Hook may not be null.");
            varD45B20DDAEE334176D265733B3022ECE_1672444972.addTaint(taint);
            throw varD45B20DDAEE334176D265733B3022ECE_1672444972;
        } //End block
    if(shuttingDown)        
        {
            IllegalStateException varAB7610C08E62199C846254E13EC9AEB7_720364195 = new IllegalStateException("VM already shutting down");
            varAB7610C08E62199C846254E13EC9AEB7_720364195.addTaint(taint);
            throw varAB7610C08E62199C846254E13EC9AEB7_720364195;
        } //End block
        synchronized
(shutdownHooks)        {
            boolean var96EEC1262A5A2B26CF6FE609D93C6012_1184497252 = (shutdownHooks.remove(hook));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1745260419 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1745260419;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.305 -0400", hash_original_method = "9A4EA06F4CB88B6269FED18A769E865A", hash_generated_method = "34C9946A2662D758A0EEBDB220C2EFED")
    public void halt(int code) {
        addTaint(code);
        nativeExit(code, false);
        // ---------- Original Method ----------
        //nativeExit(code, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.305 -0400", hash_original_method = "1DA5795546617F35E1E74BDB5F5DDD58", hash_generated_method = "04A1F025618E6C920C775F4D56111792")
    public int availableProcessors() {
        int var105BBC3EB30D7A6EF772C997A1C528E3_1781802116 = ((int) Libcore.os.sysconf(_SC_NPROCESSORS_ONLN));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472643799 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472643799;
        // ---------- Original Method ----------
        //return (int) Libcore.os.sysconf(_SC_NPROCESSORS_ONLN);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.306 -0400", hash_original_method = "2D7CF54D0F59DA12C2E5D19C64B23A09", hash_generated_method = "BB6618274435E8AE203B52438B18E7F7")
    public long maxMemory() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1437157185 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1437157185;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.306 -0400", hash_original_field = "64A54F6AA478FD75410DF278F8FCFDFB", hash_generated_field = "BCF5878BF465442984A343ACEC428E44")

    private static final Runtime mRuntime = new Runtime();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.306 -0400", hash_original_field = "91D2F657B5D6047F292755B5CAE6D9EA", hash_generated_field = "1AEBD11A773D78919BD6052F0FCA4C19")

    private static boolean finalizeOnExit;
}

