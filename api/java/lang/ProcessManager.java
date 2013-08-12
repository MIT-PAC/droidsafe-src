package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
import static libcore.io.OsConstants.ECHILD;
import static libcore.io.OsConstants.SIGKILL;
import static libcore.io.OsConstants.WEXITSTATUS;
import static libcore.io.OsConstants.WIFEXITED;
import static libcore.io.OsConstants.WIFSIGNALED;
import static libcore.io.OsConstants.WIFSTOPPED;
import static libcore.io.OsConstants.WSTOPSIG;
import static libcore.io.OsConstants.WTERMSIG;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.util.MutableInt;




import droidsafe.helpers.DSUtils;

final class ProcessManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.452 -0400", hash_original_field = "A33680F3D3BD7A96D5E7F85E9A0A202E", hash_generated_field = "1168B76BA43EB3A1C9C20A1EE6AADC71")

    private final Map<Integer, ProcessReference> processReferences = new HashMap<Integer, ProcessReference>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.452 -0400", hash_original_field = "5F9584FAD9C1B9FD872B31BD182D587F", hash_generated_field = "8E4D793B6871C6F122FC4F99A1156878")

    private final ProcessReferenceQueue referenceQueue = new ProcessReferenceQueue();
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.453 -0400", hash_original_method = "65B627E41D9F392064B029711B809D6A", hash_generated_method = "8F2C2A3FD38ED80D61DE63C94471BF94")
    private  ProcessManager() {
        Thread reaperThread = new Thread(ProcessManager.class.getName()) {
            @DSModeled(DSC.BAN)
        @Override public void run() {
                watchChildren();
            }
        };
        reaperThread.setDaemon(true);
        reaperThread.start();
        // ---------- Original Method ----------
        //Thread reaperThread = new Thread(ProcessManager.class.getName()) {
            //@Override public void run() {
                //watchChildren();
            //}
        //};
        //reaperThread.setDaemon(true);
        //reaperThread.start();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.453 -0400", hash_original_method = "BF6AA9440795270C2D5A5C002031838F", hash_generated_method = "54B0E2956D775063FBCA380BEE721098")
    private void cleanUp() {
        ProcessReference reference;
        while
((reference = referenceQueue.poll()) != null)        
        {
            synchronized
(processReferences)            {
                processReferences.remove(reference.processId);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //ProcessReference reference;
        //while ((reference = referenceQueue.poll()) != null) {
            //synchronized (processReferences) {
                //processReferences.remove(reference.processId);
            //}
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.454 -0400", hash_original_method = "534F9793819E6D7D8427F97C64CDA54E", hash_generated_method = "B0840AF9BB24D6E130D726E21B8F151B")
    private void watchChildren() {
        MutableInt status = new MutableInt(-1);
        while
(true)        
        {
            try 
            {
                int pid = Libcore.os.waitpid(0, status, 0);
                int exitValue;
                if(WIFEXITED(status.value))                
                {
                    exitValue = WEXITSTATUS(status.value);
                } //End block
                else
                if(WIFSIGNALED(status.value))                
                {
                    exitValue = WTERMSIG(status.value);
                } //End block
                else
                if(WIFSTOPPED(status.value))                
                {
                    exitValue = WSTOPSIG(status.value);
                } //End block
                else
                {
                    AssertionError varF8F88ED512E91040281B4876FE7446E1_2131783238 = new AssertionError("unexpected status from waitpid: " + status.value);
                    varF8F88ED512E91040281B4876FE7446E1_2131783238.addTaint(taint);
                    throw varF8F88ED512E91040281B4876FE7446E1_2131783238;
                } //End block
                onExit(pid, exitValue);
            } //End block
            catch (ErrnoException errnoException)
            {
                if(errnoException.errno == ECHILD)                
                {
                    waitForMoreChildren();
                    continue;
                } //End block
                else
                {
                    AssertionError var8D75DBC63153835F7D08A31E99200A1F_1534869033 = new AssertionError(errnoException);
                    var8D75DBC63153835F7D08A31E99200A1F_1534869033.addTaint(taint);
                    throw var8D75DBC63153835F7D08A31E99200A1F_1534869033;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.456 -0400", hash_original_method = "4025BDFB051861E82299213D97AFEE05", hash_generated_method = "CC590DE6C79383A31A027AF8E4B18ED1")
    private void onExit(int pid, int exitValue) {
        addTaint(exitValue);
        addTaint(pid);
        ProcessReference processReference = null;
        synchronized
(processReferences)        {
            cleanUp();
            processReference = processReferences.remove(pid);
        } //End block
        if(processReference != null)        
        {
            ProcessImpl process = processReference.get();
            if(process != null)            
            {
                process.setExitValue(exitValue);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //ProcessReference processReference = null;
        //synchronized (processReferences) {
            //cleanUp();
            //processReference = processReferences.remove(pid);
        //}
        //if (processReference != null) {
            //ProcessImpl process = processReference.get();
            //if (process != null) {
                //process.setExitValue(exitValue);
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.456 -0400", hash_original_method = "E4B4D1EC14DE436D47A63B575F4759A6", hash_generated_method = "2A3DC071AD631520B4ED17D86AEF9EA2")
    private void waitForMoreChildren() {
        synchronized
(processReferences)        {
            if(processReferences.isEmpty())            
            {
                try 
                {
                    processReferences.wait();
                } //End block
                catch (InterruptedException ex)
                {
                    AssertionError var678BDEFCD94D0450C0B290A7DCB9D6BB_1317459872 = new AssertionError("unexpected interrupt");
                    var678BDEFCD94D0450C0B290A7DCB9D6BB_1317459872.addTaint(taint);
                    throw var678BDEFCD94D0450C0B290A7DCB9D6BB_1317459872;
                } //End block
            } //End block
            else
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (processReferences) {
            //if (processReferences.isEmpty()) {
                //try {
                    //processReferences.wait();
                //} catch (InterruptedException ex) {
                    //throw new AssertionError("unexpected interrupt");
                //}
            //} else {
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    private static int exec(String[] command, String[] environment,
            String workingDirectory, FileDescriptor in, FileDescriptor out,
            FileDescriptor err, boolean redirectErrorStream) throws IOException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149867586 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149867586;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.458 -0400", hash_original_method = "3D8923075A9F95B30754D64C899AFA66", hash_generated_method = "42CA178AD897AFDFBA2FADDB47CEEE6A")
    public Process exec(String[] taintedCommand, String[] taintedEnvironment, File workingDirectory,
            boolean redirectErrorStream) throws IOException {
        addTaint(redirectErrorStream);
        addTaint(workingDirectory.getTaint());
        addTaint(taintedEnvironment[0].getTaint());
        addTaint(taintedCommand[0].getTaint());
        if(taintedCommand == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1001816296 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1001816296.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1001816296;
        } //End block
        if(taintedCommand.length == 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_414842445 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_414842445.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_414842445;
        } //End block
        String[] command = taintedCommand.clone();
        String[] environment = taintedEnvironment != null ? taintedEnvironment.clone() : null;
for(String arg : command)
        {
            if(arg == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_556824888 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_556824888.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_556824888;
            } //End block
        } //End block
        if(environment != null)        
        {
for(String env : environment)
            {
                if(env == null)                
                {
                    NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1329141993 = new NullPointerException();
                    var7338BC9F48D81FE0BBD6183F4014DCC4_1329141993.addTaint(taint);
                    throw var7338BC9F48D81FE0BBD6183F4014DCC4_1329141993;
                } //End block
            } //End block
        } //End block
        FileDescriptor in = new FileDescriptor();
        FileDescriptor out = new FileDescriptor();
        FileDescriptor err = new FileDescriptor();
        String workingPath = (workingDirectory == null)
                ? null
                : workingDirectory.getPath();
        synchronized
(processReferences)        {
            int pid;
            try 
            {
                pid = exec(command, environment, workingPath, in, out, err, redirectErrorStream);
            } //End block
            catch (IOException e)
            {
                IOException wrapper = new IOException("Error running exec()."
                        + " Command: " + Arrays.toString(command)
                        + " Working Directory: " + workingDirectory
                        + " Environment: " + Arrays.toString(environment));
                wrapper.initCause(e);
                wrapper.addTaint(taint);
                throw wrapper;
            } //End block
            ProcessImpl process = new ProcessImpl(pid, in, out, err);
            ProcessReference processReference = new ProcessReference(process, referenceQueue);
            processReferences.put(pid, processReference);
            processReferences.notifyAll();
Process var95FD552219433D6B22709796B000B842_1393224981 =             process;
            var95FD552219433D6B22709796B000B842_1393224981.addTaint(taint);
            return var95FD552219433D6B22709796B000B842_1393224981;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    public static ProcessManager getInstance() {
        return instance;
    }

    
    static class ProcessImpl extends Process {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.459 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "DBFF83134AA84403D6020EBC0053D7A1")

        private int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.459 -0400", hash_original_field = "62DC47682DD3356C8F8599B4D965B2B3", hash_generated_field = "F3EEB1922B674B66C2C9C0F3C3CBC81D")

        private InputStream errorStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.459 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

        private InputStream inputStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.460 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

        private OutputStream outputStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.460 -0400", hash_original_field = "BC1586C1BE70AF67885806428648A59D", hash_generated_field = "7070B274081DDEF5DFB2528C2234586D")

        private Integer exitValue = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.460 -0400", hash_original_field = "8C13A7DDEEF9C70E67D6BF68FBDFCBDA", hash_generated_field = "F72FE980C8215718C0EAB3CAED2ED8DD")

        private final Object exitValueMutex = new Object();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.461 -0400", hash_original_method = "C79C41A0F8183C5EC729A58D348A92CE", hash_generated_method = "8C51E83DF546839A9E24D7B3C5B03362")
          ProcessImpl(int pid, FileDescriptor in, FileDescriptor out, FileDescriptor err) {
            this.pid = pid;
            this.errorStream = new ProcessInputStream(err);
            this.inputStream = new ProcessInputStream(in);
            this.outputStream = new ProcessOutputStream(out);
            // ---------- Original Method ----------
            //this.pid = pid;
            //this.errorStream = new ProcessInputStream(err);
            //this.inputStream = new ProcessInputStream(in);
            //this.outputStream = new ProcessOutputStream(out);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.461 -0400", hash_original_method = "C1B009BFBA55AC97BB6BF3192F492760", hash_generated_method = "AC4DB112A19F1F3178EB0F2CC08E2806")
        public void destroy() {
            try 
            {
                Libcore.os.kill(pid, SIGKILL);
            } //End block
            catch (ErrnoException e)
            {
                System.logI("Failed to destroy process " + pid, e);
            } //End block
            IoUtils.closeQuietly(inputStream);
            IoUtils.closeQuietly(errorStream);
            IoUtils.closeQuietly(outputStream);
            // ---------- Original Method ----------
            //try {
                //Libcore.os.kill(pid, SIGKILL);
            //} catch (ErrnoException e) {
                //System.logI("Failed to destroy process " + pid, e);
            //}
            //IoUtils.closeQuietly(inputStream);
            //IoUtils.closeQuietly(errorStream);
            //IoUtils.closeQuietly(outputStream);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.461 -0400", hash_original_method = "72D26C729273916A38DD81F020E1EC4C", hash_generated_method = "40F2F8FC37905F9C16A01677E59415C7")
        public int exitValue() {
            synchronized
(exitValueMutex)            {
                if(exitValue == null)                
                {
                    IllegalThreadStateException varCC1DF42533230565D98A5648D23AFD0F_217894821 = new IllegalThreadStateException(
                            "Process has not yet terminated.");
                    varCC1DF42533230565D98A5648D23AFD0F_217894821.addTaint(taint);
                    throw varCC1DF42533230565D98A5648D23AFD0F_217894821;
                } //End block
                int varE81D8D8B20784FD6FAA308CE4E476F25_1707821816 = (exitValue);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367085883 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367085883;
            } //End block
            // ---------- Original Method ----------
            //synchronized (exitValueMutex) {
                //if (exitValue == null) {
                    //throw new IllegalThreadStateException(
                            //"Process has not yet terminated.");
                //}
                //return exitValue;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.462 -0400", hash_original_method = "DCE7BF5109CA162BD54D93588001BD51", hash_generated_method = "3B77EF23C911FDDA5F8A027D77D74058")
        public InputStream getErrorStream() {
InputStream varDB29EBF3A5CF9520B6DB980D65A9FD74_1248664096 =             this.errorStream;
            varDB29EBF3A5CF9520B6DB980D65A9FD74_1248664096.addTaint(taint);
            return varDB29EBF3A5CF9520B6DB980D65A9FD74_1248664096;
            // ---------- Original Method ----------
            //return this.errorStream;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.462 -0400", hash_original_method = "DC1F0F5A793D1EF64AF6C7DB099DCE34", hash_generated_method = "BA03937698C454E6CFA8976E81E48806")
        public InputStream getInputStream() {
InputStream varE57B54F82EC7D518A03C88F3C045BF46_598625433 =             this.inputStream;
            varE57B54F82EC7D518A03C88F3C045BF46_598625433.addTaint(taint);
            return varE57B54F82EC7D518A03C88F3C045BF46_598625433;
            // ---------- Original Method ----------
            //return this.inputStream;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.462 -0400", hash_original_method = "94C3B255D73CD61583B0AC248BC392B9", hash_generated_method = "FC7A8D944DB6CF82AC46505D4ACB55E2")
        public OutputStream getOutputStream() {
OutputStream varD1FAACFBEB53C1408150BAABD3C85558_53178915 =             this.outputStream;
            varD1FAACFBEB53C1408150BAABD3C85558_53178915.addTaint(taint);
            return varD1FAACFBEB53C1408150BAABD3C85558_53178915;
            // ---------- Original Method ----------
            //return this.outputStream;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.463 -0400", hash_original_method = "BE1794A2A2D4EC2F61628D9639894105", hash_generated_method = "3240BC94B65BCB20F51DCF6D74C82EDE")
        public int waitFor() throws InterruptedException {
            synchronized
(exitValueMutex)            {
                while
(exitValue == null)                
                {
                    exitValueMutex.wait();
                } //End block
                int varE81D8D8B20784FD6FAA308CE4E476F25_1168234440 = (exitValue);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053013222 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053013222;
            } //End block
            // ---------- Original Method ----------
            //synchronized (exitValueMutex) {
                //while (exitValue == null) {
                    //exitValueMutex.wait();
                //}
                //return exitValue;
            //}
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.464 -0400", hash_original_method = "B7D46CBA2679C4E3B0149113D5DCFB48", hash_generated_method = "48BDFD8466D48ABFC4C9C7823F423F61")
         void setExitValue(int exitValue) {
            synchronized
(exitValueMutex)            {
                this.exitValue = exitValue;
                exitValueMutex.notifyAll();
            } //End block
            // ---------- Original Method ----------
            //synchronized (exitValueMutex) {
                //this.exitValue = exitValue;
                //exitValueMutex.notifyAll();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.464 -0400", hash_original_method = "945EE59E08960A318B9D424632962227", hash_generated_method = "3976B9B228E10969B17EE783ADC36B84")
        @Override
        public String toString() {
String var7F08C3EC7CEBE6D57C12B6ED1F6F42CA_227385180 =             "Process[pid=" + pid + "]";
            var7F08C3EC7CEBE6D57C12B6ED1F6F42CA_227385180.addTaint(taint);
            return var7F08C3EC7CEBE6D57C12B6ED1F6F42CA_227385180;
            // ---------- Original Method ----------
            //return "Process[pid=" + pid + "]";
        }

        
    }


    
    static class ProcessReference extends WeakReference<ProcessImpl> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.464 -0400", hash_original_field = "D903442AB4EBEE4C1AA7CF992C2086B9", hash_generated_field = "E004204917AF1E5C42C1A06073D92523")

        int processId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.465 -0400", hash_original_method = "107F02CD09CE46F853F68815CD6B50B6", hash_generated_method = "FB2D780FE47AF1E384BA7671B51B3474")
        public  ProcessReference(ProcessImpl referent, ProcessReferenceQueue referenceQueue) {
            super(referent, referenceQueue);
            addTaint(referenceQueue.getTaint());
            this.processId = referent.pid;
            // ---------- Original Method ----------
            //this.processId = referent.pid;
        }

        
    }


    
    static class ProcessReferenceQueue extends ReferenceQueue<ProcessImpl> {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.465 -0400", hash_original_method = "862B9F300CC2459FB61E8AEDFA0DE051", hash_generated_method = "862B9F300CC2459FB61E8AEDFA0DE051")
        public ProcessReferenceQueue ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.466 -0400", hash_original_method = "A8419736BED4DA94F6EABC777190260F", hash_generated_method = "0EE7E91DF7CB731A6EB91EF75E7BB649")
        @Override
        public ProcessReference poll() {
            Object reference = super.poll();
ProcessReference varD01FA5E21A742C1114FBE0E758C3D263_700224810 =             (ProcessReference) reference;
            varD01FA5E21A742C1114FBE0E758C3D263_700224810.addTaint(taint);
            return varD01FA5E21A742C1114FBE0E758C3D263_700224810;
            // ---------- Original Method ----------
            //Object reference = super.poll();
            //return (ProcessReference) reference;
        }

        
    }


    
    private static class ProcessInputStream extends FileInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.466 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.466 -0400", hash_original_method = "BA3785E1A3DB1BABE64D1C4B047B2648", hash_generated_method = "13DCE028ACF64B329B01FFD270781DCF")
        private  ProcessInputStream(FileDescriptor fd) {
            super(fd);
            this.fd = fd;
            // ---------- Original Method ----------
            //this.fd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.466 -0400", hash_original_method = "4096AFD26B789321960D656289AA88CA", hash_generated_method = "97B7C0F2A0CC657929A480ACE6AB7757")
        @Override
        public void close() throws IOException {
            try 
            {
                super.close();
            } //End block
            finally 
            {
                synchronized
(this)                {
                    try 
                    {
                        IoUtils.close(fd);
                    } //End block
                    finally 
                    {
                        fd = null;
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //try {
                //super.close();
            //} finally {
                //synchronized (this) {
                    //try {
                        //IoUtils.close(fd);
                    //} finally {
                        //fd = null;
                    //}
                //}
            //}
        }

        
    }


    
    private static class ProcessOutputStream extends FileOutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.466 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.466 -0400", hash_original_method = "B3C6B215267D4A75B46BBDC1F5BB9CDB", hash_generated_method = "7303B1A97A9117BEB783BF40DA54A18E")
        private  ProcessOutputStream(FileDescriptor fd) {
            super(fd);
            this.fd = fd;
            // ---------- Original Method ----------
            //this.fd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.467 -0400", hash_original_method = "4096AFD26B789321960D656289AA88CA", hash_generated_method = "97B7C0F2A0CC657929A480ACE6AB7757")
        @Override
        public void close() throws IOException {
            try 
            {
                super.close();
            } //End block
            finally 
            {
                synchronized
(this)                {
                    try 
                    {
                        IoUtils.close(fd);
                    } //End block
                    finally 
                    {
                        fd = null;
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //try {
                //super.close();
            //} finally {
                //synchronized (this) {
                    //try {
                        //IoUtils.close(fd);
                    //} finally {
                        //fd = null;
                    //}
                //}
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.467 -0400", hash_original_field = "0F376D985AD312053503F275800742B8", hash_generated_field = "8D658FE2E05A9E4B2403457EE1E50872")

    private static final ProcessManager instance = new ProcessManager();
}

