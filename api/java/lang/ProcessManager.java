package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.485 -0400", hash_original_field = "A33680F3D3BD7A96D5E7F85E9A0A202E", hash_generated_field = "1168B76BA43EB3A1C9C20A1EE6AADC71")

    private final Map<Integer, ProcessReference> processReferences = new HashMap<Integer, ProcessReference>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.485 -0400", hash_original_field = "5F9584FAD9C1B9FD872B31BD182D587F", hash_generated_field = "8E4D793B6871C6F122FC4F99A1156878")

    private final ProcessReferenceQueue referenceQueue = new ProcessReferenceQueue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.486 -0400", hash_original_method = "65B627E41D9F392064B029711B809D6A", hash_generated_method = "8F2C2A3FD38ED80D61DE63C94471BF94")
    private  ProcessManager() {
        Thread reaperThread = new Thread(ProcessManager.class.getName()) {
            @Override public void run() {
                watchChildren();
            }
        };
        reaperThread.setDaemon(true);
        reaperThread.start();
        
        
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.486 -0400", hash_original_method = "BF6AA9440795270C2D5A5C002031838F", hash_generated_method = "50FF5AF09DAF3AEF6C70F4782F9548BB")
    private void cleanUp() {
        ProcessReference reference;
        {
            boolean varF9AB159DB354DF4427D1D47AD9D91882_168442723 = ((reference = referenceQueue.poll()) != null);
            {
                {
                    processReferences.remove(reference.processId);
                } 
            } 
        } 
        
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.486 -0400", hash_original_method = "534F9793819E6D7D8427F97C64CDA54E", hash_generated_method = "689323DB49A90AFC6C05C5AFDCD5D58C")
    private void watchChildren() {
        MutableInt status = new MutableInt(-1);
        {
            try 
            {
                int pid = Libcore.os.waitpid(0, status, 0);
                int exitValue;
                {
                    boolean var93AE0B081D588A5BC31376B1BFCD953E_52800363 = (WIFEXITED(status.value));
                    {
                        exitValue = WEXITSTATUS(status.value);
                    } 
                    {
                        boolean var2DE5039BEA3B8AEE66D3C9261077C598_906927964 = (WIFSIGNALED(status.value));
                        {
                            exitValue = WTERMSIG(status.value);
                        } 
                        {
                            boolean varE198B01561721EE7B3C3A4CF4D65B162_1592483343 = (WIFSTOPPED(status.value));
                            {
                                exitValue = WSTOPSIG(status.value);
                            } 
                            {
                                if (DroidSafeAndroidRuntime.control) throw new AssertionError("unexpected status from waitpid: " + status.value);
                            } 
                        } 
                    } 
                } 
                onExit(pid, exitValue);
            } 
            catch (ErrnoException errnoException)
            {
                {
                    waitForMoreChildren();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError(errnoException);
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.487 -0400", hash_original_method = "4025BDFB051861E82299213D97AFEE05", hash_generated_method = "1B7DCDF3DC6E451577F263170F637A05")
    private void onExit(int pid, int exitValue) {
        ProcessReference processReference = null;
        {
            cleanUp();
            processReference = processReferences.remove(pid);
        } 
        {
            ProcessImpl process = processReference.get();
            {
                process.setExitValue(exitValue);
            } 
        } 
        addTaint(pid);
        addTaint(exitValue);
        
        
        
            
            
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.487 -0400", hash_original_method = "E4B4D1EC14DE436D47A63B575F4759A6", hash_generated_method = "30E0F5292A564D509D0FBFBFEED63BDF")
    private void waitForMoreChildren() {
        {
            {
                boolean var52708DC4F574858B6E03A45DCF7142C6_1333943170 = (processReferences.isEmpty());
                {
                    try 
                    {
                        processReferences.wait();
                    } 
                    catch (InterruptedException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new AssertionError("unexpected interrupt");
                    } 
                } 
            } 
        } 
        
        
            
                
                    
                
                    
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int exec(String[] command, String[] environment,
            String workingDirectory, FileDescriptor in, FileDescriptor out,
            FileDescriptor err, boolean redirectErrorStream) throws IOException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149867586 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149867586;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.501 -0400", hash_original_method = "3D8923075A9F95B30754D64C899AFA66", hash_generated_method = "443512EF919FE61C346B91B6052FB876")
    public Process exec(String[] taintedCommand, String[] taintedEnvironment, File workingDirectory,
            boolean redirectErrorStream) throws IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_326522367 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        String[] command = taintedCommand.clone();
        String[] environment;
        environment = taintedEnvironment.clone();
        environment = null;
        {
            String arg = command[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } 
            } 
        } 
        {
            {
                String env = environment[0];
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                    } 
                } 
            } 
        } 
        FileDescriptor in = new FileDescriptor();
        FileDescriptor out = new FileDescriptor();
        FileDescriptor err = new FileDescriptor();
        String workingPath;
        workingPath = null;
        workingPath = workingDirectory.getPath();
        {
            int pid = 0;
            try 
            {
                pid = exec(command, environment, workingPath, in, out, err, redirectErrorStream);
            } 
            catch (IOException e)
            {
                IOException wrapper = new IOException("Error running exec()."
                        + " Command: " + Arrays.toString(command)
                        + " Working Directory: " + workingDirectory
                        + " Environment: " + Arrays.toString(environment));
                wrapper.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw wrapper;
            } 

            ProcessImpl process = new ProcessImpl(pid, in, out, err);
            ProcessReference processReference = new ProcessReference(process, referenceQueue);
            processReferences.put(pid, processReference);
            processReferences.notifyAll();
            varB4EAC82CA7396A68D541C85D26508E83_326522367 = process;
        } 
        addTaint(taintedCommand[0].getTaint());
        addTaint(taintedEnvironment[0].getTaint());
        addTaint(workingDirectory.getTaint());
        addTaint(redirectErrorStream);
        varB4EAC82CA7396A68D541C85D26508E83_326522367.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_326522367;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ProcessManager getInstance() {
        return instance;
    }

    
    static class ProcessImpl extends Process {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.502 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "DBFF83134AA84403D6020EBC0053D7A1")

        private int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.502 -0400", hash_original_field = "62DC47682DD3356C8F8599B4D965B2B3", hash_generated_field = "F3EEB1922B674B66C2C9C0F3C3CBC81D")

        private InputStream errorStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.502 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

        private InputStream inputStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.502 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

        private OutputStream outputStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.502 -0400", hash_original_field = "BC1586C1BE70AF67885806428648A59D", hash_generated_field = "7070B274081DDEF5DFB2528C2234586D")

        private Integer exitValue = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.502 -0400", hash_original_field = "8C13A7DDEEF9C70E67D6BF68FBDFCBDA", hash_generated_field = "F72FE980C8215718C0EAB3CAED2ED8DD")

        private final Object exitValueMutex = new Object();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.503 -0400", hash_original_method = "C79C41A0F8183C5EC729A58D348A92CE", hash_generated_method = "8C51E83DF546839A9E24D7B3C5B03362")
          ProcessImpl(int pid, FileDescriptor in, FileDescriptor out, FileDescriptor err) {
            this.pid = pid;
            this.errorStream = new ProcessInputStream(err);
            this.inputStream = new ProcessInputStream(in);
            this.outputStream = new ProcessOutputStream(out);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.504 -0400", hash_original_method = "C1B009BFBA55AC97BB6BF3192F492760", hash_generated_method = "AC4DB112A19F1F3178EB0F2CC08E2806")
        public void destroy() {
            try 
            {
                Libcore.os.kill(pid, SIGKILL);
            } 
            catch (ErrnoException e)
            {
                System.logI("Failed to destroy process " + pid, e);
            } 
            IoUtils.closeQuietly(inputStream);
            IoUtils.closeQuietly(errorStream);
            IoUtils.closeQuietly(outputStream);
            
            
                
            
                
            
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.505 -0400", hash_original_method = "72D26C729273916A38DD81F020E1EC4C", hash_generated_method = "B4EBD0C0AEF689A2CCE2CFC2B27A2A3F")
        public int exitValue() {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Process has not yet terminated.");
                } 
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428753107 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428753107;
            
            
                
                    
                            
                
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.506 -0400", hash_original_method = "DCE7BF5109CA162BD54D93588001BD51", hash_generated_method = "680B0C60D858E5A3EF4C668D310C0313")
        public InputStream getErrorStream() {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_1634253641 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1634253641 = this.errorStream;
            varB4EAC82CA7396A68D541C85D26508E83_1634253641.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1634253641;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.507 -0400", hash_original_method = "DC1F0F5A793D1EF64AF6C7DB099DCE34", hash_generated_method = "286CAF29D60CAC729C6C299B9C21EC94")
        public InputStream getInputStream() {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_1586882243 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1586882243 = this.inputStream;
            varB4EAC82CA7396A68D541C85D26508E83_1586882243.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1586882243;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.508 -0400", hash_original_method = "94C3B255D73CD61583B0AC248BC392B9", hash_generated_method = "5A15A151E7ECDBEFD75546A508C4B9A8")
        public OutputStream getOutputStream() {
            OutputStream varB4EAC82CA7396A68D541C85D26508E83_778031264 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_778031264 = this.outputStream;
            varB4EAC82CA7396A68D541C85D26508E83_778031264.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_778031264;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.509 -0400", hash_original_method = "BE1794A2A2D4EC2F61628D9639894105", hash_generated_method = "4ABF83D3A0C77C82E7B93ADA34D12D03")
        public int waitFor() throws InterruptedException {
            {
                {
                    exitValueMutex.wait();
                } 
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132795958 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132795958;
            
            
                
                    
                
                
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.509 -0400", hash_original_method = "B7D46CBA2679C4E3B0149113D5DCFB48", hash_generated_method = "C75ECC9B762CE8F42D4CFF9DA7A3C4A4")
         void setExitValue(int exitValue) {
            {
                this.exitValue = exitValue;
                exitValueMutex.notifyAll();
            } 
            
            
                
                
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.510 -0400", hash_original_method = "945EE59E08960A318B9D424632962227", hash_generated_method = "58D8207420EBEDF45851A70B18B6B7F4")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_500218614 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_500218614 = "Process[pid=" + pid + "]";
            varB4EAC82CA7396A68D541C85D26508E83_500218614.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_500218614;
            
            
        }

        
    }


    
    static class ProcessReference extends WeakReference<ProcessImpl> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.510 -0400", hash_original_field = "D903442AB4EBEE4C1AA7CF992C2086B9", hash_generated_field = "E004204917AF1E5C42C1A06073D92523")

        int processId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.510 -0400", hash_original_method = "107F02CD09CE46F853F68815CD6B50B6", hash_generated_method = "9E61E0410799465CFBE0EED5A0B93BDE")
        public  ProcessReference(ProcessImpl referent, ProcessReferenceQueue referenceQueue) {
            super(referent, referenceQueue);
            this.processId = referent.pid;
            addTaint(referenceQueue.getTaint());
            
            
        }

        
    }


    
    static class ProcessReferenceQueue extends ReferenceQueue<ProcessImpl> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.511 -0400", hash_original_method = "862B9F300CC2459FB61E8AEDFA0DE051", hash_generated_method = "862B9F300CC2459FB61E8AEDFA0DE051")
        public ProcessReferenceQueue ()
        {
            
        }


        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.511 -0400", hash_original_method = "A8419736BED4DA94F6EABC777190260F", hash_generated_method = "9BDBFE86D200A52CE6F2385EC4027052")
        @Override
        public ProcessReference poll() {
            ProcessReference varB4EAC82CA7396A68D541C85D26508E83_507243329 = null; 
            Object reference = super.poll();
            varB4EAC82CA7396A68D541C85D26508E83_507243329 = (ProcessReference) reference;
            varB4EAC82CA7396A68D541C85D26508E83_507243329.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_507243329;
            
            
            
        }

        
    }


    
    private static class ProcessInputStream extends FileInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.511 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.512 -0400", hash_original_method = "BA3785E1A3DB1BABE64D1C4B047B2648", hash_generated_method = "13DCE028ACF64B329B01FFD270781DCF")
        private  ProcessInputStream(FileDescriptor fd) {
            super(fd);
            this.fd = fd;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.512 -0400", hash_original_method = "4096AFD26B789321960D656289AA88CA", hash_generated_method = "B0C874CED371BF6F166A77FBAD969BB2")
        @Override
        public void close() throws IOException {
            try 
            {
                super.close();
            } 
            finally 
            {
                {
                    try 
                    {
                        IoUtils.close(fd);
                    } 
                    finally 
                    {
                        fd = null;
                    } 
                } 
            } 
            
            
                
            
                
                    
                        
                    
                        
                    
                
            
        }

        
    }


    
    private static class ProcessOutputStream extends FileOutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.512 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.512 -0400", hash_original_method = "B3C6B215267D4A75B46BBDC1F5BB9CDB", hash_generated_method = "7303B1A97A9117BEB783BF40DA54A18E")
        private  ProcessOutputStream(FileDescriptor fd) {
            super(fd);
            this.fd = fd;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.513 -0400", hash_original_method = "4096AFD26B789321960D656289AA88CA", hash_generated_method = "B0C874CED371BF6F166A77FBAD969BB2")
        @Override
        public void close() throws IOException {
            try 
            {
                super.close();
            } 
            finally 
            {
                {
                    try 
                    {
                        IoUtils.close(fd);
                    } 
                    finally 
                    {
                        fd = null;
                    } 
                } 
            } 
            
            
                
            
                
                    
                        
                    
                        
                    
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.513 -0400", hash_original_field = "0F376D985AD312053503F275800742B8", hash_generated_field = "8D658FE2E05A9E4B2403457EE1E50872")

    private static final ProcessManager instance = new ProcessManager();
   
}

