package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
    
    private static int exec(String[] command, String[] environment,
            String workingDirectory, FileDescriptor in, FileDescriptor out,
            FileDescriptor err, boolean redirectErrorStream) throws IOException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149867586 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149867586;
    }

    /** Gets the process manager. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.615 -0500", hash_original_method = "B41DB4FA1120B721DD670DFD65EC3117", hash_generated_method = "2CC82AAB217E781A411AC5965F8714CD")
    
public static ProcessManager getInstance() {
        return instance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.613 -0500", hash_original_field = "E88E23A0339006D35AC814B8C0C9D60B", hash_generated_field = "8D658FE2E05A9E4B2403457EE1E50872")

    private static final ProcessManager instance = new ProcessManager();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.530 -0500", hash_original_field = "4A9F08197610839E2D311F4656BF4C37", hash_generated_field = "1168B76BA43EB3A1C9C20A1EE6AADC71")

    private final Map<Integer, ProcessReference> processReferences
            = new HashMap<Integer, ProcessReference>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.533 -0500", hash_original_field = "4ACA4E8AD31F32798941E64BE42946D4", hash_generated_field = "8E4D793B6871C6F122FC4F99A1156878")

    private final ProcessReferenceQueue referenceQueue = new ProcessReferenceQueue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.453 -0400", hash_original_method = "65B627E41D9F392064B029711B809D6A", hash_generated_method = "8F2C2A3FD38ED80D61DE63C94471BF94")
    private  ProcessManager() {
        Thread reaperThread = new Thread(ProcessManager.class.getName()) {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.536 -0500", hash_original_method = "5EDA8A1888B05474B51AEC07008E0508", hash_generated_method = "95A1875BC116738308AC99181C6ADE9D")
            
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

    /**
     * Cleans up after garbage collected processes. Requires the lock on the
     * map.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.541 -0500", hash_original_method = "BF6AA9440795270C2D5A5C002031838F", hash_generated_method = "300FAF7F4C3C8A3A9809C1A337418A2E")
    
private void cleanUp() {
        ProcessReference reference;
        while ((reference = referenceQueue.poll()) != null) {
            synchronized (processReferences) {
                processReferences.remove(reference.processId);
            }
        }
    }

    /**
     * Loops indefinitely and calls ProcessManager.onExit() when children exit.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.544 -0500", hash_original_method = "534F9793819E6D7D8427F97C64CDA54E", hash_generated_method = "616A7277059590F31C767CB08E6096DD")
    
private void watchChildren() {
        MutableInt status = new MutableInt(-1);
        while (true) {
            try {
                // Wait for children in our process group.
                int pid = Libcore.os.waitpid(0, status, 0);

                // Work out what onExit wants to hear.
                int exitValue;
                if (WIFEXITED(status.value)) {
                    exitValue = WEXITSTATUS(status.value);
                } else if (WIFSIGNALED(status.value)) {
                    exitValue = WTERMSIG(status.value);
                } else if (WIFSTOPPED(status.value)) {
                    exitValue = WSTOPSIG(status.value);
                } else {
                    throw new AssertionError("unexpected status from waitpid: " + status.value);
                }

                onExit(pid, exitValue);
            } catch (ErrnoException errnoException) {
                if (errnoException.errno == ECHILD) {
                    // Expected errno: there are no children to wait for.
                    // onExit will sleep until it is informed of another child coming to life.
                    waitForMoreChildren();
                    continue;
                } else {
                    throw new AssertionError(errnoException);
                }
            }
        }
    }

    /**
     * Called by {@link #watchChildren()} when a child process exits.
     *
     * @param pid ID of process that exited
     * @param exitValue value the process returned upon exit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.546 -0500", hash_original_method = "4025BDFB051861E82299213D97AFEE05", hash_generated_method = "2F2078B86361797FF47A2820BC5DCC4A")
    
private void onExit(int pid, int exitValue) {
        ProcessReference processReference = null;
        synchronized (processReferences) {
            cleanUp();
            processReference = processReferences.remove(pid);
        }
        if (processReference != null) {
            ProcessImpl process = processReference.get();
            if (process != null) {
                process.setExitValue(exitValue);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.549 -0500", hash_original_method = "E4B4D1EC14DE436D47A63B575F4759A6", hash_generated_method = "8F648B9A138EFDC6C481A63D5CF8B07E")
    
private void waitForMoreChildren() {
        synchronized (processReferences) {
            if (processReferences.isEmpty()) {
                // There are no eligible children; wait for one to be added.
                // This wait will return because of the notifyAll call in exec.
                try {
                    processReferences.wait();
                } catch (InterruptedException ex) {
                    // This should never happen.
                    throw new AssertionError("unexpected interrupt");
                }
            } else {
                /*
                 * A new child was spawned just before we entered
                 * the synchronized block. We can just fall through
                 * without doing anything special and land back in
                 * the native waitpid().
                 */
            }
        }
    }
    
    static class ProcessImpl extends Process {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.560 -0500", hash_original_field = "3D9A6B8E69012AA56F160CA7CCE3CF4F", hash_generated_field = "DBFF83134AA84403D6020EBC0053D7A1")

        private  int pid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.562 -0500", hash_original_field = "FF138C3B799C70B3252924677C443956", hash_generated_field = "F3EEB1922B674B66C2C9C0F3C3CBC81D")

        private  InputStream errorStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.566 -0500", hash_original_field = "219F81106B069BE15533E4B7BAC5527C", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

        private  InputStream inputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.568 -0500", hash_original_field = "661AC26F0CF33AB40D90D727DEB87E17", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

        private  OutputStream outputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.570 -0500", hash_original_field = "6907BECF224AE1F697BBF7E0D5365F61", hash_generated_field = "7070B274081DDEF5DFB2528C2234586D")

        private Integer exitValue = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.573 -0500", hash_original_field = "48E05A2AF47E554918DC95ED0C6FB683", hash_generated_field = "F72FE980C8215718C0EAB3CAED2ED8DD")

        private final Object exitValueMutex = new Object();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.576 -0500", hash_original_method = "C79C41A0F8183C5EC729A58D348A92CE", hash_generated_method = "C79C41A0F8183C5EC729A58D348A92CE")
        
ProcessImpl(int pid, FileDescriptor in, FileDescriptor out, FileDescriptor err) {
            this.pid = pid;

            this.errorStream = new ProcessInputStream(err);
            this.inputStream = new ProcessInputStream(in);
            this.outputStream = new ProcessOutputStream(out);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.578 -0500", hash_original_method = "C1B009BFBA55AC97BB6BF3192F492760", hash_generated_method = "8D0E7A5C1AD07B52B2004C7B56E63A6B")
        
public void destroy() {
            try {
                Libcore.os.kill(pid, SIGKILL);
            } catch (ErrnoException e) {
                System.logI("Failed to destroy process " + pid, e);
            }
            IoUtils.closeQuietly(inputStream);
            IoUtils.closeQuietly(errorStream);
            IoUtils.closeQuietly(outputStream);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.581 -0500", hash_original_method = "72D26C729273916A38DD81F020E1EC4C", hash_generated_method = "B657200AFE52939BF41791395FB037B6")
        
public int exitValue() {
            synchronized (exitValueMutex) {
                if (exitValue == null) {
                    throw new IllegalThreadStateException(
                            "Process has not yet terminated.");
                }

                return exitValue;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.583 -0500", hash_original_method = "DCE7BF5109CA162BD54D93588001BD51", hash_generated_method = "35E01D63A5F5E2CB917B76EB06BCC5C1")
        
public InputStream getErrorStream() {
            return this.errorStream;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.586 -0500", hash_original_method = "DC1F0F5A793D1EF64AF6C7DB099DCE34", hash_generated_method = "045B7D54BB0AFFCC2F40B43FACDF9DCC")
        
public InputStream getInputStream() {
            return this.inputStream;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.588 -0500", hash_original_method = "94C3B255D73CD61583B0AC248BC392B9", hash_generated_method = "5B8B07E552425D28CAC88F79CCC9D958")
        
public OutputStream getOutputStream() {
            return this.outputStream;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.591 -0500", hash_original_method = "BE1794A2A2D4EC2F61628D9639894105", hash_generated_method = "CD203357F948B827B4C6BF231EF7FD14")
        
public int waitFor() throws InterruptedException {
            synchronized (exitValueMutex) {
                while (exitValue == null) {
                    exitValueMutex.wait();
                }
                return exitValue;
            }
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.593 -0500", hash_original_method = "B7D46CBA2679C4E3B0149113D5DCFB48", hash_generated_method = "B7D46CBA2679C4E3B0149113D5DCFB48")
        
void setExitValue(int exitValue) {
            synchronized (exitValueMutex) {
                this.exitValue = exitValue;
                exitValueMutex.notifyAll();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.595 -0500", hash_original_method = "945EE59E08960A318B9D424632962227", hash_generated_method = "DFEEF2A254443AD7F5E65F34BEB0B90B")
        
@Override
        public String toString() {
            return "Process[pid=" + pid + "]";
        }
        
    }
    
    static class ProcessReference extends WeakReference<ProcessImpl> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.600 -0500", hash_original_field = "E004204917AF1E5C42C1A06073D92523", hash_generated_field = "E004204917AF1E5C42C1A06073D92523")

         int processId;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.603 -0500", hash_original_method = "107F02CD09CE46F853F68815CD6B50B6", hash_generated_method = "B038722E6AC33DDC6A38858D0498D96D")
        
public ProcessReference(ProcessImpl referent, ProcessReferenceQueue referenceQueue) {
            super(referent, referenceQueue);
            this.processId = referent.pid;
        }
        
    }
    
    static class ProcessReferenceQueue extends ReferenceQueue<ProcessImpl> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.465 -0400", hash_original_method = "862B9F300CC2459FB61E8AEDFA0DE051", hash_generated_method = "862B9F300CC2459FB61E8AEDFA0DE051")
        public ProcessReferenceQueue ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.609 -0500", hash_original_method = "A8419736BED4DA94F6EABC777190260F", hash_generated_method = "E1F71BD84F819DF7A541D8F28359513B")
        
@Override
        public ProcessReference poll() {
            // Why couldn't they get the generics right on ReferenceQueue? :(
            Object reference = super.poll();
            return (ProcessReference) reference;
        }
        
    }
    
    private static class ProcessInputStream extends FileInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.618 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.621 -0500", hash_original_method = "BA3785E1A3DB1BABE64D1C4B047B2648", hash_generated_method = "7B83815A871CA1A709EF76A91096EA1E")
        
private ProcessInputStream(FileDescriptor fd) {
            super(fd);
            this.fd = fd;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.624 -0500", hash_original_method = "4096AFD26B789321960D656289AA88CA", hash_generated_method = "4733FF6090B618D723DD27CEE6DE9C46")
        
@Override
        public void close() throws IOException {
            try {
                super.close();
            } finally {
                synchronized (this) {
                    try {
                        IoUtils.close(fd);
                    } finally {
                        fd = null;
                    }
                }
            }
        }
        
    }
    
    private static class ProcessOutputStream extends FileOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.629 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.632 -0500", hash_original_method = "B3C6B215267D4A75B46BBDC1F5BB9CDB", hash_generated_method = "2348488383A9C8783CF3E70811384549")
        
private ProcessOutputStream(FileDescriptor fd) {
            super(fd);
            this.fd = fd;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.634 -0500", hash_original_method = "4096AFD26B789321960D656289AA88CA", hash_generated_method = "4733FF6090B618D723DD27CEE6DE9C46")
        
@Override
        public void close() throws IOException {
            try {
                super.close();
            } finally {
                synchronized (this) {
                    try {
                        IoUtils.close(fd);
                    } finally {
                        fd = null;
                    }
                }
            }
        }
        
    }

    /**
     * Executes a process and returns an object representing it.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.556 -0500", hash_original_method = "3D8923075A9F95B30754D64C899AFA66", hash_generated_method = "BB59D398D3F667713061D80B34E12A3C")
    
public Process exec(String[] taintedCommand, String[] taintedEnvironment, File workingDirectory,
            boolean redirectErrorStream) throws IOException {
        // Make sure we throw the same exceptions as the RI.
        if (taintedCommand == null) {
            throw new NullPointerException();
        }
        if (taintedCommand.length == 0) {
            throw new IndexOutOfBoundsException();
        }

        // Handle security and safety by copying mutable inputs and checking them.
        String[] command = taintedCommand.clone();
        String[] environment = taintedEnvironment != null ? taintedEnvironment.clone() : null;

        // Check we're not passing null Strings to the native exec.
        for (String arg : command) {
            if (arg == null) {
                throw new NullPointerException();
            }
        }
        // The environment is allowed to be null or empty, but no element may be null.
        if (environment != null) {
            for (String env : environment) {
                if (env == null) {
                    throw new NullPointerException();
                }
            }
        }

        FileDescriptor in = new FileDescriptor();
        FileDescriptor out = new FileDescriptor();
        FileDescriptor err = new FileDescriptor();

        String workingPath = (workingDirectory == null)
                ? null
                : workingDirectory.getPath();

        // Ensure onExit() doesn't access the process map before we add our
        // entry.
        synchronized (processReferences) {
            int pid;
            try {
                pid = exec(command, environment, workingPath, in, out, err, redirectErrorStream);
            } catch (IOException e) {
                IOException wrapper = new IOException("Error running exec()."
                        + " Command: " + Arrays.toString(command)
                        + " Working Directory: " + workingDirectory
                        + " Environment: " + Arrays.toString(environment));
                wrapper.initCause(e);
                throw wrapper;
            }
            ProcessImpl process = new ProcessImpl(pid, in, out, err);
            ProcessReference processReference = new ProcessReference(process, referenceQueue);
            processReferences.put(pid, processReference);

            /*
             * This will wake up the child monitor thread in case there
             * weren't previously any children to wait on.
             */
            processReferences.notifyAll();

            return process;
        }
    }
}

