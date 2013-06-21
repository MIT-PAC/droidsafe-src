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
    private Map<Integer, ProcessReference> processReferences
            = new HashMap<Integer, ProcessReference>();
    private ProcessReferenceQueue referenceQueue = new ProcessReferenceQueue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.928 -0400", hash_original_method = "65B627E41D9F392064B029711B809D6A", hash_generated_method = "255F17C7811FA23DC0758B9F539EE277")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ProcessManager() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.928 -0400", hash_original_method = "BF6AA9440795270C2D5A5C002031838F", hash_generated_method = "C256755D191EB58183BE317FCEA188F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cleanUp() {
        ProcessReference reference;
        {
            boolean varF9AB159DB354DF4427D1D47AD9D91882_1432263613 = ((reference = referenceQueue.poll()) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.928 -0400", hash_original_method = "534F9793819E6D7D8427F97C64CDA54E", hash_generated_method = "75696210A2828840FA2ADC0685B9F6D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean var93AE0B081D588A5BC31376B1BFCD953E_705694169 = (WIFEXITED(status.value));
                    {
                        exitValue = WEXITSTATUS(status.value);
                    } //End block
                    {
                        boolean var2DE5039BEA3B8AEE66D3C9261077C598_1309544546 = (WIFSIGNALED(status.value));
                        {
                            exitValue = WTERMSIG(status.value);
                        } //End block
                        {
                            boolean varE198B01561721EE7B3C3A4CF4D65B162_1117970884 = (WIFSTOPPED(status.value));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.929 -0400", hash_original_method = "4025BDFB051861E82299213D97AFEE05", hash_generated_method = "D246987B20ECB9BC1833D20F26273AA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onExit(int pid, int exitValue) {
        dsTaint.addTaint(pid);
        dsTaint.addTaint(exitValue);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.929 -0400", hash_original_method = "E4B4D1EC14DE436D47A63B575F4759A6", hash_generated_method = "07AEF9084D63CE7D768BEB2D42ACEECC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void waitForMoreChildren() {
        {
            {
                boolean var52708DC4F574858B6E03A45DCF7142C6_1303525782 = (processReferences.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.944 -0400", hash_original_method = "3D8923075A9F95B30754D64C899AFA66", hash_generated_method = "BE5D3CD71C1C041C579490E1F594932F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Process exec(String[] taintedCommand, String[] taintedEnvironment, File workingDirectory,
            boolean redirectErrorStream) throws IOException {
        dsTaint.addTaint(taintedEnvironment[0]);
        dsTaint.addTaint(redirectErrorStream);
        dsTaint.addTaint(workingDirectory.dsTaint);
        dsTaint.addTaint(taintedCommand[0]);
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
            String arg = command[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                String env = environment[0];
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
        } //End block
        return (Process)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static ProcessManager getInstance() {
        return instance;
    }

    
    static class ProcessImpl extends Process {
        private int pid;
        private InputStream errorStream;
        private InputStream inputStream;
        private OutputStream outputStream;
        private Integer exitValue = null;
        private Object exitValueMutex = new Object();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.944 -0400", hash_original_method = "C79C41A0F8183C5EC729A58D348A92CE", hash_generated_method = "304B4628D5F1D0633930175AFC6A9001")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ProcessImpl(int pid, FileDescriptor in, FileDescriptor out, FileDescriptor err) {
            dsTaint.addTaint(err.dsTaint);
            dsTaint.addTaint(pid);
            dsTaint.addTaint(in.dsTaint);
            dsTaint.addTaint(out.dsTaint);
            this.errorStream = new ProcessInputStream(err);
            this.inputStream = new ProcessInputStream(in);
            this.outputStream = new ProcessOutputStream(out);
            // ---------- Original Method ----------
            //this.pid = pid;
            //this.errorStream = new ProcessInputStream(err);
            //this.inputStream = new ProcessInputStream(in);
            //this.outputStream = new ProcessOutputStream(out);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.945 -0400", hash_original_method = "C1B009BFBA55AC97BB6BF3192F492760", hash_generated_method = "AC4DB112A19F1F3178EB0F2CC08E2806")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.945 -0400", hash_original_method = "72D26C729273916A38DD81F020E1EC4C", hash_generated_method = "BC978FDDDBF206A89017A64402909717")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int exitValue() {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Process has not yet terminated.");
                } //End block
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (exitValueMutex) {
                //if (exitValue == null) {
                    //throw new IllegalThreadStateException(
                            //"Process has not yet terminated.");
                //}
                //return exitValue;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.945 -0400", hash_original_method = "DCE7BF5109CA162BD54D93588001BD51", hash_generated_method = "FCC820EE4B58E4B9A115025FCE87E2F5")
        @DSModeled(DSC.SAFE)
        public InputStream getErrorStream() {
            return (InputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return this.errorStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.945 -0400", hash_original_method = "DC1F0F5A793D1EF64AF6C7DB099DCE34", hash_generated_method = "80659F11C0A1F72CE3DBE66E488941DD")
        @DSModeled(DSC.SAFE)
        public InputStream getInputStream() {
            return (InputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return this.inputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.945 -0400", hash_original_method = "94C3B255D73CD61583B0AC248BC392B9", hash_generated_method = "DF12EBD535C42C55ECAF56A31A0AE1C1")
        @DSModeled(DSC.SAFE)
        public OutputStream getOutputStream() {
            return (OutputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return this.outputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.946 -0400", hash_original_method = "BE1794A2A2D4EC2F61628D9639894105", hash_generated_method = "E80670C67DAD38A10BD35DCDD995176F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int waitFor() throws InterruptedException {
            {
                {
                    exitValueMutex.wait();
                } //End block
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (exitValueMutex) {
                //while (exitValue == null) {
                    //exitValueMutex.wait();
                //}
                //return exitValue;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.946 -0400", hash_original_method = "B7D46CBA2679C4E3B0149113D5DCFB48", hash_generated_method = "DEE3AD63A583D5295B142174FA94D70B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void setExitValue(int exitValue) {
            dsTaint.addTaint(exitValue);
            {
                exitValueMutex.notifyAll();
            } //End block
            // ---------- Original Method ----------
            //synchronized (exitValueMutex) {
                //this.exitValue = exitValue;
                //exitValueMutex.notifyAll();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.946 -0400", hash_original_method = "945EE59E08960A318B9D424632962227", hash_generated_method = "69C17D27FD952133488BCEA420BCB367")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Process[pid=" + pid + "]";
        }

        
    }


    
    static class ProcessReference extends WeakReference<ProcessImpl> {
        int processId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.946 -0400", hash_original_method = "107F02CD09CE46F853F68815CD6B50B6", hash_generated_method = "98ED049789BCF07E6A555E99112842DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ProcessReference(ProcessImpl referent, ProcessReferenceQueue referenceQueue) {
            super(referent, referenceQueue);
            dsTaint.addTaint(referent.dsTaint);
            dsTaint.addTaint(referenceQueue.dsTaint);
            this.processId = referent.pid;
            // ---------- Original Method ----------
            //this.processId = referent.pid;
        }

        
    }


    
    static class ProcessReferenceQueue extends ReferenceQueue<ProcessImpl> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.946 -0400", hash_original_method = "62106F0C19EF4585E825A0CB3685FECF", hash_generated_method = "62106F0C19EF4585E825A0CB3685FECF")
                public ProcessReferenceQueue ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.946 -0400", hash_original_method = "A8419736BED4DA94F6EABC777190260F", hash_generated_method = "6CB6448CA96461F860EB1C6CE3D587AA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ProcessReference poll() {
            Object reference;
            reference = super.poll();
            return (ProcessReference)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object reference = super.poll();
            //return (ProcessReference) reference;
        }

        
    }


    
    private static class ProcessInputStream extends FileInputStream {
        private FileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.947 -0400", hash_original_method = "BA3785E1A3DB1BABE64D1C4B047B2648", hash_generated_method = "50582CACF281AD7FBF6A434FC4C990CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private ProcessInputStream(FileDescriptor fd) {
            super(fd);
            dsTaint.addTaint(fd.dsTaint);
            // ---------- Original Method ----------
            //this.fd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.947 -0400", hash_original_method = "4096AFD26B789321960D656289AA88CA", hash_generated_method = "B0C874CED371BF6F166A77FBAD969BB2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private FileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.947 -0400", hash_original_method = "B3C6B215267D4A75B46BBDC1F5BB9CDB", hash_generated_method = "2BAF3A2A4EA354CE264DFB07DAFBFC64")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private ProcessOutputStream(FileDescriptor fd) {
            super(fd);
            dsTaint.addTaint(fd.dsTaint);
            // ---------- Original Method ----------
            //this.fd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.947 -0400", hash_original_method = "4096AFD26B789321960D656289AA88CA", hash_generated_method = "B0C874CED371BF6F166A77FBAD969BB2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    private static final ProcessManager instance = new ProcessManager();
}

