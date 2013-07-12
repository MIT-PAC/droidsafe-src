package com.android.internal.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.net.Credentials;
import android.net.LocalSocket;
import android.os.Build;
import android.os.Process;
import android.os.SystemProperties;
import android.util.Log;
import dalvik.system.PathClassLoader;
import dalvik.system.Zygote;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;

class ZygoteConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.209 -0400", hash_original_field = "ADAA094F2E9199B78AA3ADA013DBD64F", hash_generated_field = "9F88E22AD28B44C4F3ABF7860B4C458C")

    private LocalSocket mSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.210 -0400", hash_original_field = "DAF0DD849774F07F7CC400FF46C053C7", hash_generated_field = "A0824D1C247F56564C11BA8205E8EB5E")

    private DataOutputStream mSocketOutStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.210 -0400", hash_original_field = "08D153294DEC10839B965F71B7AB13E6", hash_generated_field = "F0D2329C97964096148900E8F81E43EC")

    private BufferedReader mSocketReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.210 -0400", hash_original_field = "F8FE68B4C4CBA197EFA9C8BBD45F144E", hash_generated_field = "B6123D5E946169D2772DFD87D959FEA7")

    private Credentials peer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.210 -0400", hash_original_method = "7184EAAE07D7B6F9BEC01EBE5F329335", hash_generated_method = "32172E099DE9BCF8575C851672103C15")
      ZygoteConnection(LocalSocket socket) throws IOException {
        mSocket = socket;
        mSocketOutStream
                = new DataOutputStream(socket.getOutputStream());
        mSocketReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()), 256);
        mSocket.setSoTimeout(CONNECTION_TIMEOUT_MILLIS);
        try 
        {
            peer = mSocket.getPeerCredentials();
        } 
        catch (IOException ex)
        {
            ex.addTaint(taint);
            throw ex;
        } 
        
        
        
                
        
                
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.211 -0400", hash_original_method = "D031047267A17F3FBDEAA6E5A25F7FEC", hash_generated_method = "B4C229F3F85114521BCD63ECF867F555")
     FileDescriptor getFileDesciptor() {
FileDescriptor varB4DE187B48E9D304340996C59BDD1FA8_1484399033 =         mSocket.getFileDescriptor();
        varB4DE187B48E9D304340996C59BDD1FA8_1484399033.addTaint(taint);
        return varB4DE187B48E9D304340996C59BDD1FA8_1484399033;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.211 -0400", hash_original_method = "D83ED9D59CE4DAAE3BDA7C68EE854B3C", hash_generated_method = "1C7CAD8C67BE94B6CD19899D9CA20F15")
     void run() throws ZygoteInit.MethodAndArgsCaller {
        int loopCount = ZygoteInit.GC_LOOP_COUNT;
        while
(true)        
        {
    if(loopCount <= 0)            
            {
                ZygoteInit.gc();
                loopCount = ZygoteInit.GC_LOOP_COUNT;
            } 
            else
            {
                loopCount--;
            } 
    if(runOnce())            
            {
                break;
            } 
        } 
        
        
        
            
                
                
            
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.213 -0400", hash_original_method = "D76E963329652A6F2BCB5FE055E042D1", hash_generated_method = "BB94EE6BFBBE00BBE1D2A1FE3DFC3BA0")
     boolean runOnce() throws ZygoteInit.MethodAndArgsCaller {
        String args[];
        Arguments parsedArgs = null;
        FileDescriptor[] descriptors;
        try 
        {
            args = readArgumentList();
            descriptors = mSocket.getAncillaryFileDescriptors();
        } 
        catch (IOException ex)
        {
            closeSocket();
            boolean varB326B5062B2F0E69046810717534CB09_876660246 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746034647 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746034647;
        } 
    if(args == null)        
        {
            closeSocket();
            boolean varB326B5062B2F0E69046810717534CB09_1424172976 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1047991731 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1047991731;
        } 
        PrintStream newStderr = null;
    if(descriptors != null && descriptors.length >= 3)        
        {
            newStderr = new PrintStream(
                    new FileOutputStream(descriptors[2]));
        } 
        int pid = -1;
        FileDescriptor childPipeFd = null;
        FileDescriptor serverPipeFd = null;
        try 
        {
            parsedArgs = new Arguments(args);
            applyUidSecurityPolicy(parsedArgs, peer);
            applyRlimitSecurityPolicy(parsedArgs, peer);
            applyCapabilitiesSecurityPolicy(parsedArgs, peer);
            applyInvokeWithSecurityPolicy(parsedArgs, peer);
            applyDebuggerSystemProperty(parsedArgs);
            applyInvokeWithSystemProperty(parsedArgs);
            int[][] rlimits = null;
    if(parsedArgs.rlimits != null)            
            {
                rlimits = parsedArgs.rlimits.toArray(intArray2d);
            } 
    if(parsedArgs.runtimeInit && parsedArgs.invokeWith != null)            
            {
                FileDescriptor[] pipeFds = Libcore.os.pipe();
                childPipeFd = pipeFds[1];
                serverPipeFd = pipeFds[0];
                ZygoteInit.setCloseOnExec(serverPipeFd, true);
            } 
            pid = Zygote.forkAndSpecialize(parsedArgs.uid, parsedArgs.gid,
                    parsedArgs.gids, parsedArgs.debugFlags, rlimits);
        } 
        catch (IOException ex)
        {
            logAndPrintError(newStderr, "Exception creating pipe", ex);
        } 
        catch (ErrnoException ex)
        {
            logAndPrintError(newStderr, "Exception creating pipe", ex);
        } 
        catch (IllegalArgumentException ex)
        {
            logAndPrintError(newStderr, "Invalid zygote arguments", ex);
        } 
        catch (ZygoteSecurityException ex)
        {
            logAndPrintError(newStderr,
                    "Zygote security policy prevents request: ", ex);
        } 
        try 
        {
    if(pid == 0)            
            {
                IoUtils.closeQuietly(serverPipeFd);
                serverPipeFd = null;
                handleChildProc(parsedArgs, descriptors, childPipeFd, newStderr);
                boolean varB326B5062B2F0E69046810717534CB09_874424608 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426830299 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_426830299;
            } 
            else
            {
                IoUtils.closeQuietly(childPipeFd);
                childPipeFd = null;
                boolean varC9454D8B2FD50A402C6425B646C1B138_65468694 = (handleParentProc(pid, descriptors, serverPipeFd, parsedArgs));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021912928 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021912928;
            } 
        } 
        finally 
        {
            IoUtils.closeQuietly(childPipeFd);
            IoUtils.closeQuietly(serverPipeFd);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.215 -0400", hash_original_method = "5A630DC8DA41E048830D803B657E049B", hash_generated_method = "BDBFC3193A46F7EDF42B929530CD44F3")
     void closeSocket() {
        try 
        {
            mSocket.close();
        } 
        catch (IOException ex)
        {
        } 
        
        
            
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.215 -0400", hash_original_method = "366F843C8FBE8BB09896187A9CDF1388", hash_generated_method = "1DC6A3E0AA0034F1CBD937111D70A206")
    private String[] readArgumentList() throws IOException {
        int argc;
        try 
        {
            String s = mSocketReader.readLine();
    if(s == null)            
            {
String[] var540C13E9E156B687226421B24F2DF178_120693395 =                 null;
                var540C13E9E156B687226421B24F2DF178_120693395.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_120693395;
            } 
            argc = Integer.parseInt(s);
        } 
        catch (NumberFormatException ex)
        {
            IOException var6C89B7A455FCE963F839DFAFC943A1BE_37881215 = new IOException("invalid wire format");
            var6C89B7A455FCE963F839DFAFC943A1BE_37881215.addTaint(taint);
            throw var6C89B7A455FCE963F839DFAFC943A1BE_37881215;
        } 
    if(argc > MAX_ZYGOTE_ARGC)        
        {
            IOException var1D1E79A74E5DE2797FA901986995986F_1180327689 = new IOException("max arg count exceeded");
            var1D1E79A74E5DE2797FA901986995986F_1180327689.addTaint(taint);
            throw var1D1E79A74E5DE2797FA901986995986F_1180327689;
        } 
        String[] result = new String[argc];
for(int i = 0;i < argc;i++)
        {
            result[i] = mSocketReader.readLine();
    if(result[i] == null)            
            {
                IOException varB43CBEE8C043A2E86ADF4FD06368D48D_781131251 = new IOException("truncated request");
                varB43CBEE8C043A2E86ADF4FD06368D48D_781131251.addTaint(taint);
                throw varB43CBEE8C043A2E86ADF4FD06368D48D_781131251;
            } 
        } 
String[] varDC838461EE2FA0CA4C9BBB70A15456B0_119276507 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_119276507.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_119276507;
        
        
        
            
            
                
            
            
        
            
            
        
        
            
        
        
        
            
            
                
            
        
        
    }

    
        private static void applyUidSecurityPolicy(Arguments args, Credentials peer) throws ZygoteSecurityException {
        int peerUid = peer.getUid();
        if (peerUid == 0) {
        } else if (peerUid == Process.SYSTEM_UID ) {
            String factoryTest = SystemProperties.get("ro.factorytest");
            boolean uidRestricted;
            uidRestricted  
                 = !(factoryTest.equals("1") || factoryTest.equals("2"));
            if (uidRestricted
                    && args.uidSpecified && (args.uid < Process.SYSTEM_UID)) {
                throw new ZygoteSecurityException(
                        "System UID may not launch process with UID < "
                                + Process.SYSTEM_UID);
            }
        } else {
            if (args.uidSpecified || args.gidSpecified
                || args.gids != null) {
                throw new ZygoteSecurityException(
                        "App UIDs may not specify uid's or gid's");
            }
        }
        if (!args.uidSpecified) {
            args.uid = peer.getUid();
            args.uidSpecified = true;
        }
        if (!args.gidSpecified) {
            args.gid = peer.getGid();
            args.gidSpecified = true;
        }
    }

    
        public static void applyDebuggerSystemProperty(Arguments args) {
        if ("1".equals(SystemProperties.get("ro.debuggable"))) {
            args.debugFlags |= Zygote.DEBUG_ENABLE_DEBUGGER;
        }
    }

    
        private static void applyRlimitSecurityPolicy(
            Arguments args, Credentials peer) throws ZygoteSecurityException {
        int peerUid = peer.getUid();
        if (!(peerUid == 0 || peerUid == Process.SYSTEM_UID)) {
            if (args.rlimits != null) {
                throw new ZygoteSecurityException(
                        "This UID may not specify rlimits.");
            }
        }
    }

    
        private static void applyCapabilitiesSecurityPolicy(
            Arguments args, Credentials peer) throws ZygoteSecurityException {
        if (args.permittedCapabilities == 0
                && args.effectiveCapabilities == 0) {
            return;
        }
        if (peer.getUid() == 0) {
            return;
        }
        long permittedCaps;
        try {
            permittedCaps = ZygoteInit.capgetPermitted(peer.getPid());
        } catch (IOException ex) {
            throw new ZygoteSecurityException(
                    "Error retrieving peer's capabilities.");
        }
        if (((~args.permittedCapabilities) & args.effectiveCapabilities) != 0) {
            throw new ZygoteSecurityException(
                    "Effective capabilities cannot be superset of "
                            + " permitted capabilities" );
        }
        if (((~permittedCaps) & args.permittedCapabilities) != 0) {
            throw new ZygoteSecurityException(
                    "Peer specified unpermitted capabilities" );
        }
    }

    
        private static void applyInvokeWithSecurityPolicy(Arguments args, Credentials peer) throws ZygoteSecurityException {
        int peerUid = peer.getUid();
        if (args.invokeWith != null && peerUid != 0) {
            throw new ZygoteSecurityException("Peer is not permitted to specify "
                    + "an explicit invoke-with wrapper command");
        }
    }

    
        public static void applyInvokeWithSystemProperty(Arguments args) {
        if (args.invokeWith == null && args.niceName != null) {
            if (args.niceName != null) {
                String property = "wrap." + args.niceName;
                if (property.length() > 31) {
                    property = property.substring(0, 31);
                }
                args.invokeWith = SystemProperties.get(property);
                if (args.invokeWith != null && args.invokeWith.length() == 0) {
                    args.invokeWith = null;
                }
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.231 -0400", hash_original_method = "D56D87B601F5E5F24F9D8C0DB423B19E", hash_generated_method = "E1A23CA1BD482645DFD7BF20A908D27C")
    private void handleChildProc(Arguments parsedArgs,
            FileDescriptor[] descriptors, FileDescriptor pipeFd, PrintStream newStderr) throws ZygoteInit.MethodAndArgsCaller {
        addTaint(newStderr.getTaint());
        addTaint(pipeFd.getTaint());
        addTaint(descriptors[0].getTaint());
        addTaint(parsedArgs.getTaint());
    if(parsedArgs.peerWait)        
        {
            try 
            {
                ZygoteInit.setCloseOnExec(mSocket.getFileDescriptor(), true);
                sPeerWaitSocket = mSocket;
            } 
            catch (IOException ex)
            {
            } 
        } 
        else
        {
            closeSocket();
            ZygoteInit.closeServerSocket();
        } 
    if(descriptors != null)        
        {
            try 
            {
                ZygoteInit.reopenStdio(descriptors[0],
                        descriptors[1], descriptors[2]);
for(FileDescriptor fd : descriptors)
                {
                    IoUtils.closeQuietly(fd);
                } 
                newStderr = System.err;
            } 
            catch (IOException ex)
            {
            } 
        } 
    if(parsedArgs.niceName != null)        
        {
            Process.setArgV0(parsedArgs.niceName);
        } 
    if(parsedArgs.runtimeInit)        
        {
    if(parsedArgs.invokeWith != null)            
            {
                WrapperInit.execApplication(parsedArgs.invokeWith,
                        parsedArgs.niceName, parsedArgs.targetSdkVersion,
                        pipeFd, parsedArgs.remainingArgs);
            } 
            else
            {
                RuntimeInit.zygoteInit(parsedArgs.targetSdkVersion,
                        parsedArgs.remainingArgs);
            } 
        } 
        else
        {
            String className;
            try 
            {
                className = parsedArgs.remainingArgs[0];
            } 
            catch (ArrayIndexOutOfBoundsException ex)
            {
                logAndPrintError(newStderr,
                        "Missing required class name argument", null);
                return;
            } 
            String[] mainArgs = new String[parsedArgs.remainingArgs.length - 1];
            System.arraycopy(parsedArgs.remainingArgs, 1,
                    mainArgs, 0, mainArgs.length);
    if(parsedArgs.invokeWith != null)            
            {
                WrapperInit.execStandalone(parsedArgs.invokeWith,
                        parsedArgs.classpath, className, mainArgs);
            } 
            else
            {
                ClassLoader cloader;
    if(parsedArgs.classpath != null)                
                {
                    cloader = new PathClassLoader(parsedArgs.classpath,
                            ClassLoader.getSystemClassLoader());
                } 
                else
                {
                    cloader = ClassLoader.getSystemClassLoader();
                } 
                try 
                {
                    ZygoteInit.invokeStaticMain(cloader, className, mainArgs);
                } 
                catch (RuntimeException ex)
                {
                    logAndPrintError(newStderr, "Error starting.", ex);
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.232 -0400", hash_original_method = "3D3F8EE18B5CE9AC13BB6381C124884E", hash_generated_method = "0AE4CE5E1D097DCD919D152D854A4AE3")
    private boolean handleParentProc(int pid,
            FileDescriptor[] descriptors, FileDescriptor pipeFd, Arguments parsedArgs) {
        addTaint(parsedArgs.getTaint());
        addTaint(pipeFd.getTaint());
        addTaint(descriptors[0].getTaint());
        addTaint(pid);
    if(pid > 0)        
        {
            setChildPgid(pid);
        } 
    if(descriptors != null)        
        {
for(FileDescriptor fd : descriptors)
            {
                IoUtils.closeQuietly(fd);
            } 
        } 
        boolean usingWrapper = false;
    if(pipeFd != null && pid > 0)        
        {
            DataInputStream is = new DataInputStream(new FileInputStream(pipeFd));
            int innerPid = -1;
            try 
            {
                innerPid = is.readInt();
            } 
            catch (IOException ex)
            {
            } 
            finally 
            {
                try 
                {
                    is.close();
                } 
                catch (IOException ex)
                {
                } 
            } 
    if(innerPid > 0)            
            {
                int parentPid = innerPid;
                while
(parentPid > 0 && parentPid != pid)                
                {
                    parentPid = Process.getParentPid(parentPid);
                } 
    if(parentPid > 0)                
                {
                    pid = innerPid;
                    usingWrapper = true;
                } 
                else
                {
                } 
            } 
        } 
        try 
        {
            mSocketOutStream.writeInt(pid);
            mSocketOutStream.writeBoolean(usingWrapper);
        } 
        catch (IOException ex)
        {
            boolean varB326B5062B2F0E69046810717534CB09_1285480358 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583393880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_583393880;
        } 
    if(parsedArgs.peerWait)        
        {
            try 
            {
                mSocket.close();
            } 
            catch (IOException ex)
            {
            } 
            boolean varB326B5062B2F0E69046810717534CB09_1502002904 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_363451806 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_363451806;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1469748757 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1865500525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1865500525;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.232 -0400", hash_original_method = "A5A16DB5966812C0B6C21E171E7DEF94", hash_generated_method = "5BFB956212478E9B0A9275A55802037F")
    private void setChildPgid(int pid) {
        addTaint(pid);
        try 
        {
            ZygoteInit.setpgid(pid, ZygoteInit.getpgid(peer.getPid()));
        } 
        catch (IOException ex)
        {
        } 
        
        
            
        
            
                
        
    }

    
        private static void logAndPrintError(PrintStream newStderr,
            String message, Throwable ex) {
        Log.e(TAG, message, ex);
        if (newStderr != null) {
            newStderr.println(message + (ex == null ? "" : ex));
        }
    }

    
    static class Arguments {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "0CB100AF67BD2EB1F0E2A464C0F12B08", hash_generated_field = "8E7F39D78C11D0D620F5769854F95AD4")

        int uid = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "8C752772BC3E7930653B65D1E22518B0", hash_generated_field = "FCC687D32DCADE2501DFF90534FB8EB3")

        boolean uidSpecified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "404F44BC9AAB75EF1799743675B1FBD1", hash_generated_field = "CD7DE07815123E8D5BDE5DC586F9E327")

        int gid = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "398A5174EFB36BC0BF8DE762DA220023", hash_generated_field = "7F9C72C3971857F2F2424F2876DDCB37")

        boolean gidSpecified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "77DBC042260703938C8CA627F28C6CF5", hash_generated_field = "54C577A65DD30DDDFB9215D4CF28DB70")

        int[] gids;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "2B754C222A01095B11299CC5E0B9E1CE", hash_generated_field = "DE4E6DC7B42CB6C9AA9043942BF17F86")

        boolean peerWait;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "003817FE41A79B41720958195F588744", hash_generated_field = "EE1851787F428E476E8277578F17E703")

        int debugFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "6099B90F1E5E8B48541E9B6E6B9E7C89", hash_generated_field = "6C1842C610E85CE5AAB422B21DE084EE")

        int targetSdkVersion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "ABE8F3014224BEA06B50EEDE67F3D8ED", hash_generated_field = "13C1E04054F8153548EFE0154E96AF4F")

        boolean targetSdkVersionSpecified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "621F8FA91E380C78BD98880BE47DFC8A", hash_generated_field = "F6B99376C3175C909AAF68D121783067")

        String classpath;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "BFB62C5307E4BCDA1B10795C274A1E70", hash_generated_field = "83B5575B50DE1C2A124BAC34BDE96481")

        boolean runtimeInit;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "24E312342380F3064032CB21B6D58823", hash_generated_field = "A9B0553B8BC7AA374068697DA246A7A6")

        String niceName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "60CBE6FEE7FEEC6AE73BF4B02B6B81E0", hash_generated_field = "A6E797CB91748575747AFCEF1EFABE00")

        boolean capabilitiesSpecified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "18DE92E733E3F8935E94E868D7001228", hash_generated_field = "1953FB01473D5608C92B58749337D80F")

        long permittedCapabilities;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "AA691C164A2FBAA688633A0E8F811EF1", hash_generated_field = "5B064209ACA1CCAE633A16D8D6ED5D7E")

        long effectiveCapabilities;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "41155B5DE35F5D4E67EF89201B7F5565", hash_generated_field = "6B6E7FE0066F3C40E26724314989FD1B")

        ArrayList<int[]> rlimits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "8E5E27F054987B84BB22F5307D0237B3", hash_generated_field = "452A5731BC14408AF85FDFEF2F034B9D")

        String invokeWith;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_field = "3C8D8F8A1F0275D9C097D1CA5ADD856B", hash_generated_field = "88B6A06E0D43FBF96C1153AEAB5C29CA")

        String remainingArgs[];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.233 -0400", hash_original_method = "35BDC5101A4DE38616FDCE6EF4D8CA10", hash_generated_method = "F181F5A7A31C345E3645C1582D1EBC3E")
          Arguments(String args[]) throws IllegalArgumentException {
            addTaint(args[0].getTaint());
            parseArgs(args);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.235 -0400", hash_original_method = "12134C3215A59528551E59AC16868712", hash_generated_method = "742B8A4905318469366561EF0F45A675")
        private void parseArgs(String args[]) throws IllegalArgumentException {
            int curArg = 0;
for(;curArg < args.length;curArg++)
            {
                String arg = args[curArg];
    if(arg.equals("--"))                
                {
                    curArg++;
                    break;
                } 
                else
    if(arg.startsWith("--setuid="))                
                {
    if(uidSpecified)                    
                    {
                        IllegalArgumentException var41F501EC6FE3B8CCBEAAB484537CAE17_2100975099 = new IllegalArgumentException(
                                "Duplicate arg specified");
                        var41F501EC6FE3B8CCBEAAB484537CAE17_2100975099.addTaint(taint);
                        throw var41F501EC6FE3B8CCBEAAB484537CAE17_2100975099;
                    } 
                    uidSpecified = true;
                    uid = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                } 
                else
    if(arg.startsWith("--setgid="))                
                {
    if(gidSpecified)                    
                    {
                        IllegalArgumentException var41F501EC6FE3B8CCBEAAB484537CAE17_1666861104 = new IllegalArgumentException(
                                "Duplicate arg specified");
                        var41F501EC6FE3B8CCBEAAB484537CAE17_1666861104.addTaint(taint);
                        throw var41F501EC6FE3B8CCBEAAB484537CAE17_1666861104;
                    } 
                    gidSpecified = true;
                    gid = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                } 
                else
    if(arg.startsWith("--target-sdk-version="))                
                {
    if(targetSdkVersionSpecified)                    
                    {
                        IllegalArgumentException varDAE300AAC3AF6B744E685129EC227019_64457881 = new IllegalArgumentException(
                                "Duplicate target-sdk-version specified");
                        varDAE300AAC3AF6B744E685129EC227019_64457881.addTaint(taint);
                        throw varDAE300AAC3AF6B744E685129EC227019_64457881;
                    } 
                    targetSdkVersionSpecified = true;
                    targetSdkVersion = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                } 
                else
    if(arg.equals("--enable-debugger"))                
                {
                    debugFlags |= Zygote.DEBUG_ENABLE_DEBUGGER;
                } 
                else
    if(arg.equals("--enable-safemode"))                
                {
                    debugFlags |= Zygote.DEBUG_ENABLE_SAFEMODE;
                } 
                else
    if(arg.equals("--enable-checkjni"))                
                {
                    debugFlags |= Zygote.DEBUG_ENABLE_CHECKJNI;
                } 
                else
    if(arg.equals("--enable-jni-logging"))                
                {
                    debugFlags |= Zygote.DEBUG_ENABLE_JNI_LOGGING;
                } 
                else
    if(arg.equals("--enable-assert"))                
                {
                    debugFlags |= Zygote.DEBUG_ENABLE_ASSERT;
                } 
                else
    if(arg.equals("--peer-wait"))                
                {
                    peerWait = true;
                } 
                else
    if(arg.equals("--runtime-init"))                
                {
                    runtimeInit = true;
                } 
                else
    if(arg.startsWith("--capabilities="))                
                {
    if(capabilitiesSpecified)                    
                    {
                        IllegalArgumentException var41F501EC6FE3B8CCBEAAB484537CAE17_814840265 = new IllegalArgumentException(
                                "Duplicate arg specified");
                        var41F501EC6FE3B8CCBEAAB484537CAE17_814840265.addTaint(taint);
                        throw var41F501EC6FE3B8CCBEAAB484537CAE17_814840265;
                    } 
                    capabilitiesSpecified = true;
                    String capString = arg.substring(arg.indexOf('=')+1);
                    String[] capStrings = capString.split(",", 2);
    if(capStrings.length == 1)                    
                    {
                        effectiveCapabilities = Long.decode(capStrings[0]);
                        permittedCapabilities = effectiveCapabilities;
                    } 
                    else
                    {
                        permittedCapabilities = Long.decode(capStrings[0]);
                        effectiveCapabilities = Long.decode(capStrings[1]);
                    } 
                } 
                else
    if(arg.startsWith("--rlimit="))                
                {
                    String[] limitStrings = arg.substring(arg.indexOf('=')+1).split(",");
    if(limitStrings.length != 3)                    
                    {
                        IllegalArgumentException varA3A82844D5DED517944607DEF74964EF_348176929 = new IllegalArgumentException(
                                "--rlimit= should have 3 comma-delimited ints");
                        varA3A82844D5DED517944607DEF74964EF_348176929.addTaint(taint);
                        throw varA3A82844D5DED517944607DEF74964EF_348176929;
                    } 
                    int[] rlimitTuple = new int[limitStrings.length];
for(int i=0;i < limitStrings.length;i++)
                    {
                        rlimitTuple[i] = Integer.parseInt(limitStrings[i]);
                    } 
    if(rlimits == null)                    
                    {
                        rlimits = new ArrayList();
                    } 
                    rlimits.add(rlimitTuple);
                } 
                else
    if(arg.equals("-classpath"))                
                {
    if(classpath != null)                    
                    {
                        IllegalArgumentException var41F501EC6FE3B8CCBEAAB484537CAE17_550815925 = new IllegalArgumentException(
                                "Duplicate arg specified");
                        var41F501EC6FE3B8CCBEAAB484537CAE17_550815925.addTaint(taint);
                        throw var41F501EC6FE3B8CCBEAAB484537CAE17_550815925;
                    } 
                    try 
                    {
                        classpath = args[++curArg];
                    } 
                    catch (IndexOutOfBoundsException ex)
                    {
                        IllegalArgumentException var96548A85B722FC30CB777360AE3D089B_1311041273 = new IllegalArgumentException(
                                "-classpath requires argument");
                        var96548A85B722FC30CB777360AE3D089B_1311041273.addTaint(taint);
                        throw var96548A85B722FC30CB777360AE3D089B_1311041273;
                    } 
                } 
                else
    if(arg.startsWith("--setgroups="))                
                {
    if(gids != null)                    
                    {
                        IllegalArgumentException var41F501EC6FE3B8CCBEAAB484537CAE17_460214072 = new IllegalArgumentException(
                                "Duplicate arg specified");
                        var41F501EC6FE3B8CCBEAAB484537CAE17_460214072.addTaint(taint);
                        throw var41F501EC6FE3B8CCBEAAB484537CAE17_460214072;
                    } 
                    String[] params = arg.substring(arg.indexOf('=') + 1).split(",");
                    gids = new int[params.length];
for(int i = params.length - 1;i >= 0;i--)
                    {
                        gids[i] = Integer.parseInt(params[i]);
                    } 
                } 
                else
    if(arg.equals("--invoke-with"))                
                {
    if(invokeWith != null)                    
                    {
                        IllegalArgumentException var41F501EC6FE3B8CCBEAAB484537CAE17_129419292 = new IllegalArgumentException(
                                "Duplicate arg specified");
                        var41F501EC6FE3B8CCBEAAB484537CAE17_129419292.addTaint(taint);
                        throw var41F501EC6FE3B8CCBEAAB484537CAE17_129419292;
                    } 
                    try 
                    {
                        invokeWith = args[++curArg];
                    } 
                    catch (IndexOutOfBoundsException ex)
                    {
                        IllegalArgumentException varE2A51B3BCFADD77D07E9A0F9C05711D9_2012001535 = new IllegalArgumentException(
                                "--invoke-with requires argument");
                        varE2A51B3BCFADD77D07E9A0F9C05711D9_2012001535.addTaint(taint);
                        throw varE2A51B3BCFADD77D07E9A0F9C05711D9_2012001535;
                    } 
                } 
                else
    if(arg.startsWith("--nice-name="))                
                {
    if(niceName != null)                    
                    {
                        IllegalArgumentException var41F501EC6FE3B8CCBEAAB484537CAE17_749659854 = new IllegalArgumentException(
                                "Duplicate arg specified");
                        var41F501EC6FE3B8CCBEAAB484537CAE17_749659854.addTaint(taint);
                        throw var41F501EC6FE3B8CCBEAAB484537CAE17_749659854;
                    } 
                    niceName = arg.substring(arg.indexOf('=') + 1);
                } 
                else
                {
                    break;
                } 
            } 
    if(runtimeInit && classpath != null)            
            {
                IllegalArgumentException varF8B1F16B216A25570E07F810842782D1_1050718260 = new IllegalArgumentException(
                        "--runtime-init and -classpath are incompatible");
                varF8B1F16B216A25570E07F810842782D1_1050718260.addTaint(taint);
                throw varF8B1F16B216A25570E07F810842782D1_1050718260;
            } 
            remainingArgs = new String[args.length - curArg];
            System.arraycopy(args, curArg, remainingArgs, 0,
                    remainingArgs.length);
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.236 -0400", hash_original_field = "07E71AB65C7C829BB9961A38207CC4B3", hash_generated_field = "2A664B91B7AF4DD6DD39F407BBDAB91B")

    private static final String TAG = "Zygote";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.236 -0400", hash_original_field = "E0A6057357B310940FCD39CB93779051", hash_generated_field = "80CAE96E8C1B0DF29A980BF5109CC5BF")

    private static final int[][] intArray2d = new int[0][0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.236 -0400", hash_original_field = "60D62043D7F17FF5FDECBB860D085F6E", hash_generated_field = "F25FDE7970276014B50B25B9CC13AA49")

    private static final int CONNECTION_TIMEOUT_MILLIS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.236 -0400", hash_original_field = "1E48E792AF09046D0B312211C708BAD2", hash_generated_field = "B23BA5B642881C70E30A38B20D6C2EA9")

    private static final int MAX_ZYGOTE_ARGC = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.236 -0400", hash_original_field = "2F11EEC42CD2936CFFEC0BB3C6C0C738", hash_generated_field = "4F9908C941A92E3CBBEB2EF6B2065848")

    private static LocalSocket sPeerWaitSocket = null;
}

