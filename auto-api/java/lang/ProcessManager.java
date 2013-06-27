package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import static libcore.io.OsConstants.*;

final class ProcessManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.040 -0400", hash_original_field = "A33680F3D3BD7A96D5E7F85E9A0A202E", hash_generated_field = "E75A2235CDC55AE4A427DD2AC65D5D3A")

    private Map<Integer, ProcessReference> processReferences = new HashMap<Integer, ProcessReference>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.040 -0400", hash_original_field = "5F9584FAD9C1B9FD872B31BD182D587F", hash_generated_field = "F0914727332250B200F1EAF1459CECC8")

    private ProcessReferenceQueue referenceQueue = new ProcessReferenceQueue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.042 -0400", hash_original_method = "65B627E41D9F392064B029711B809D6A", hash_generated_method = "255F17C7811FA23DC0758B9F539EE277")
    private  ProcessManager() {
        Thread reaperThread;
        reaperThread = new Thread(ProcessManager.class.getName()) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.045 -0400", hash_original_method = "BF6AA9440795270C2D5A5C002031838F", hash_generated_method = "9C1C3AA1E72C564255D43F16C6790E92")
    private void cleanUp() {
        ProcessReference reference;
        {
            boolean varF9AB159DB354DF4427D1D47AD9D91882_1329562191 = ((reference = referenceQueue.poll()) != null);
            {
                {
                    processReferences.remove(reference.processId);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //ProcessReference reference;
        //while ((reference = referenceQueue.poll()) != null) {
            //synchronized (processReferences) {
                //processReferences.remove(reference.processId);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.070 -0400", hash_original_method = "534F9793819E6D7D8427F97C64CDA54E", hash_generated_method = "668DC706DF11E9CE03593DEBA8DAA4B7")
    private void watchChildren() {
        MutableInt status;
        status = new MutableInt(-1);
        {
            try 
            {
                int pid;
                pid = Libcore.os.waitpid(0, status, 0);
                int exitValue;
                {
                    boolean var93AE0B081D588A5BC31376B1BFCD953E_324277055 = (WIFEXITED(status.value));
                    {
                        exitValue = WEXITSTATUS(status.value);
                    } //End block
                    {
                        boolean var2DE5039BEA3B8AEE66D3C9261077C598_1878410231 = (WIFSIGNALED(status.value));
                        {
                            exitValue = WTERMSIG(status.value);
                        } //End block
                        {
                            boolean varE198B01561721EE7B3C3A4CF4D65B162_56507708 = (WIFSTOPPED(status.value));
                            {
                                exitValue = WSTOPSIG(status.value);
                            } //End block
                            {
                                if (DroidSafeAndroidRuntime.control) throw new AssertionError("unexpected status from waitpid: " + status.value);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                onExit(pid, exitValue);
            } //End block
            catch (ErrnoException errnoException)
            {
                {
                    waitForMoreChildren();
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError(errnoException);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.084 -0400", hash_original_method = "4025BDFB051861E82299213D97AFEE05", hash_generated_method = "0264476DA8E492104933F1EA2FED0EEF")
    private void onExit(int pid, int exitValue) {
        ProcessReference processReference;
        processReference = null;
        {
            cleanUp();
            processReference = processReferences.remove(pid);
        } //End block
        {
            ProcessImpl process;
            process = processReference.get();
            {
                process.setExitValue(exitValue);
            } //End block
        } //End block
        addTaint(pid);
        addTaint(exitValue);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.085 -0400", hash_original_method = "E4B4D1EC14DE436D47A63B575F4759A6", hash_generated_method = "AE0040573E087D9AF4A4FBDACBD16B93")
    private void waitForMoreChildren() {
        {
            {
                boolean var52708DC4F574858B6E03A45DCF7142C6_1165302681 = (processReferences.isEmpty());
                {
                    try 
                    {
                        processReferences.wait();
                    } //End block
                    catch (InterruptedException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new AssertionError("unexpected interrupt");
                    } //End block
                } //End block
            } //End collapsed parenthetic
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

    
        private static int exec(String[] command, String[] environment,
            String workingDirectory, FileDescriptor in, FileDescriptor out,
            FileDescriptor err, boolean redirectErrorStream) throws IOException {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.226 -0400", hash_original_method = "3D8923075A9F95B30754D64C899AFA66", hash_generated_method = "FCF6D0AD4B757AF288541D5BA980CA0E")
    public Process exec(String[] taintedCommand, String[] taintedEnvironment, File workingDirectory,
            boolean redirectErrorStream) throws IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_730039014 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        String[] command;
        command = taintedCommand.clone();
        String[] environment;
        environment = taintedEnvironment.clone();
        environment = null;
        {
            Iterator<String> varD96F24A549FE537169685B30E51593AF_1544927876 = (command).iterator();
            varD96F24A549FE537169685B30E51593AF_1544927876.hasNext();
            String arg = varD96F24A549FE537169685B30E51593AF_1544927876.next();
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                Iterator<String> varE97DC367C2FC643B5B3D2F7E98D77FB6_1540481001 = (environment).iterator();
                varE97DC367C2FC643B5B3D2F7E98D77FB6_1540481001.hasNext();
                String env = varE97DC367C2FC643B5B3D2F7E98D77FB6_1540481001.next();
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        FileDescriptor in;
        in = new FileDescriptor();
        FileDescriptor out;
        out = new FileDescriptor();
        FileDescriptor err;
        err = new FileDescriptor();
        String workingPath;
        workingPath = null;
        workingPath = workingDirectory.getPath();
        {
            int pid;
            try 
            {
                pid = exec(command, environment, workingPath, in, out, err, redirectErrorStream);
            } //End block
            catch (IOException e)
            {
                IOException wrapper;
                wrapper = new IOException("Error running exec()."
                        + " Command: " + Arrays.toString(command)
                        + " Working Directory: " + workingDirectory
                        + " Environment: " + Arrays.toString(environment));
                wrapper.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw wrapper;
            } //End block
            ProcessImpl process;
            process = new ProcessImpl(pid, in, out, err);
            ProcessReference processReference;
            processReference = new ProcessReference(process, referenceQueue);
            processReferences.put(pid, processReference);
            processReferences.notifyAll();
            varB4EAC82CA7396A68D541C85D26508E83_730039014 = process;
        } //End block
        addTaint(taintedCommand[0].getTaint());
        addTaint(taintedEnvironment[0].getTaint());
        addTaint(workingDirectory.getTaint());
        addTaint(redirectErrorStream);
        varB4EAC82CA7396A68D541C85D26508E83_730039014.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_730039014;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static ProcessManager getInstance() {
        return instance;
    }

    
    static class ProcessImpl extends Process {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.226 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "DBFF83134AA84403D6020EBC0053D7A1")

        private int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.226 -0400", hash_original_field = "62DC47682DD3356C8F8599B4D965B2B3", hash_generated_field = "F3EEB1922B674B66C2C9C0F3C3CBC81D")

        private InputStream errorStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.226 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

        private InputStream inputStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.226 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

        private OutputStream outputStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.227 -0400", hash_original_field = "BC1586C1BE70AF67885806428648A59D", hash_generated_field = "7070B274081DDEF5DFB2528C2234586D")

        private Integer exitValue = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.227 -0400", hash_original_field = "8C13A7DDEEF9C70E67D6BF68FBDFCBDA", hash_generated_field = "9D69CD93966B38489178ADB1D0047ACD")

        private Object exitValueMutex = new Object();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.227 -0400", hash_original_method = "C79C41A0F8183C5EC729A58D348A92CE", hash_generated_method = "8C51E83DF546839A9E24D7B3C5B03362")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.227 -0400", hash_original_method = "C1B009BFBA55AC97BB6BF3192F492760", hash_generated_method = "AC4DB112A19F1F3178EB0F2CC08E2806")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.231 -0400", hash_original_method = "72D26C729273916A38DD81F020E1EC4C", hash_generated_method = "0CEDAF713E3A230DF2B2195F2D1E14F9")
        public int exitValue() {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Process has not yet terminated.");
                } //End block
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797833843 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797833843;
            // ---------- Original Method ----------
            //synchronized (exitValueMutex) {
                //if (exitValue == null) {
                    //throw new IllegalThreadStateException(
                            //"Process has not yet terminated.");
                //}
                //return exitValue;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.247 -0400", hash_original_method = "DCE7BF5109CA162BD54D93588001BD51", hash_generated_method = "4EB71F1141B70A3A432FFF929EE6695C")
        public InputStream getErrorStream() {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_1534383975 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1534383975 = this.errorStream;
            varB4EAC82CA7396A68D541C85D26508E83_1534383975.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1534383975;
            // ---------- Original Method ----------
            //return this.errorStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.248 -0400", hash_original_method = "DC1F0F5A793D1EF64AF6C7DB099DCE34", hash_generated_method = "1C730E7892699D894C1604DA08EADF50")
        public InputStream getInputStream() {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_1181704863 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1181704863 = this.inputStream;
            varB4EAC82CA7396A68D541C85D26508E83_1181704863.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1181704863;
            // ---------- Original Method ----------
            //return this.inputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.249 -0400", hash_original_method = "94C3B255D73CD61583B0AC248BC392B9", hash_generated_method = "9EFDC0C09B1351C45E779E90444A2D5E")
        public OutputStream getOutputStream() {
            OutputStream varB4EAC82CA7396A68D541C85D26508E83_1987590515 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1987590515 = this.outputStream;
            varB4EAC82CA7396A68D541C85D26508E83_1987590515.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1987590515;
            // ---------- Original Method ----------
            //return this.outputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.249 -0400", hash_original_method = "BE1794A2A2D4EC2F61628D9639894105", hash_generated_method = "0702AD1F5D46D5D00E4DB90ADDEA7637")
        public int waitFor() throws InterruptedException {
            {
                {
                    exitValueMutex.wait();
                } //End block
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495023741 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495023741;
            // ---------- Original Method ----------
            //synchronized (exitValueMutex) {
                //while (exitValue == null) {
                    //exitValueMutex.wait();
                //}
                //return exitValue;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.250 -0400", hash_original_method = "B7D46CBA2679C4E3B0149113D5DCFB48", hash_generated_method = "C75ECC9B762CE8F42D4CFF9DA7A3C4A4")
         void setExitValue(int exitValue) {
            {
                this.exitValue = exitValue;
                exitValueMutex.notifyAll();
            } //End block
            // ---------- Original Method ----------
            //synchronized (exitValueMutex) {
                //this.exitValue = exitValue;
                //exitValueMutex.notifyAll();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.250 -0400", hash_original_method = "945EE59E08960A318B9D424632962227", hash_generated_method = "0E1C4FE4FDF161E329FA73705BE65041")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_327547259 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_327547259 = "Process[pid=" + pid + "]";
            varB4EAC82CA7396A68D541C85D26508E83_327547259.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_327547259;
            // ---------- Original Method ----------
            //return "Process[pid=" + pid + "]";
        }

        
    }


    
    static class ProcessReference extends WeakReference<ProcessImpl> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.250 -0400", hash_original_field = "D903442AB4EBEE4C1AA7CF992C2086B9", hash_generated_field = "E004204917AF1E5C42C1A06073D92523")

        int processId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.262 -0400", hash_original_method = "107F02CD09CE46F853F68815CD6B50B6", hash_generated_method = "9E61E0410799465CFBE0EED5A0B93BDE")
        public  ProcessReference(ProcessImpl referent, ProcessReferenceQueue referenceQueue) {
            super(referent, referenceQueue);
            this.processId = referent.pid;
            addTaint(referenceQueue.getTaint());
            // ---------- Original Method ----------
            //this.processId = referent.pid;
        }

        
    }


    
    static class ProcessReferenceQueue extends ReferenceQueue<ProcessImpl> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.262 -0400", hash_original_method = "862B9F300CC2459FB61E8AEDFA0DE051", hash_generated_method = "862B9F300CC2459FB61E8AEDFA0DE051")
        public ProcessReferenceQueue ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.264 -0400", hash_original_method = "A8419736BED4DA94F6EABC777190260F", hash_generated_method = "2D8195D5B0CB5784F5494DA25EE8F0BD")
        @Override
        public ProcessReference poll() {
            ProcessReference varB4EAC82CA7396A68D541C85D26508E83_920279472 = null; //Variable for return #1
            Object reference;
            reference = super.poll();
            varB4EAC82CA7396A68D541C85D26508E83_920279472 = (ProcessReference) reference;
            varB4EAC82CA7396A68D541C85D26508E83_920279472.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_920279472;
            // ---------- Original Method ----------
            //Object reference = super.poll();
            //return (ProcessReference) reference;
        }

        
    }


    
    private static class ProcessInputStream extends FileInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.264 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.264 -0400", hash_original_method = "BA3785E1A3DB1BABE64D1C4B047B2648", hash_generated_method = "13DCE028ACF64B329B01FFD270781DCF")
        private  ProcessInputStream(FileDescriptor fd) {
            super(fd);
            this.fd = fd;
            // ---------- Original Method ----------
            //this.fd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.265 -0400", hash_original_method = "4096AFD26B789321960D656289AA88CA", hash_generated_method = "B0C874CED371BF6F166A77FBAD969BB2")
        @Override
        public void close() throws IOException {
            try 
            {
                super.close();
            } //End block
            finally 
            {
                {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.280 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.282 -0400", hash_original_method = "B3C6B215267D4A75B46BBDC1F5BB9CDB", hash_generated_method = "7303B1A97A9117BEB783BF40DA54A18E")
        private  ProcessOutputStream(FileDescriptor fd) {
            super(fd);
            this.fd = fd;
            // ---------- Original Method ----------
            //this.fd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.282 -0400", hash_original_method = "4096AFD26B789321960D656289AA88CA", hash_generated_method = "B0C874CED371BF6F166A77FBAD969BB2")
        @Override
        public void close() throws IOException {
            try 
            {
                super.close();
            } //End block
            finally 
            {
                {
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.282 -0400", hash_original_field = "0F376D985AD312053503F275800742B8", hash_generated_field = "BFB3210616DC090BF9C0AFA4DC256514")

    private static ProcessManager instance = new ProcessManager();
}

