package com.android.internal.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.777 -0400", hash_original_field = "ADAA094F2E9199B78AA3ADA013DBD64F", hash_generated_field = "9F88E22AD28B44C4F3ABF7860B4C458C")

    private LocalSocket mSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.777 -0400", hash_original_field = "DAF0DD849774F07F7CC400FF46C053C7", hash_generated_field = "A0824D1C247F56564C11BA8205E8EB5E")

    private DataOutputStream mSocketOutStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.777 -0400", hash_original_field = "08D153294DEC10839B965F71B7AB13E6", hash_generated_field = "F0D2329C97964096148900E8F81E43EC")

    private BufferedReader mSocketReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.777 -0400", hash_original_field = "F8FE68B4C4CBA197EFA9C8BBD45F144E", hash_generated_field = "B6123D5E946169D2772DFD87D959FEA7")

    private Credentials peer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.777 -0400", hash_original_method = "7184EAAE07D7B6F9BEC01EBE5F329335", hash_generated_method = "F3DF980F276C79A19AD29FC36BDC7D90")
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
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        
        
        
                
        
                
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.778 -0400", hash_original_method = "D031047267A17F3FBDEAA6E5A25F7FEC", hash_generated_method = "4F188BB060B4775854BBD511A11EEE58")
     FileDescriptor getFileDesciptor() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1227488671 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1227488671 = mSocket.getFileDescriptor();
        varB4EAC82CA7396A68D541C85D26508E83_1227488671.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1227488671;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.778 -0400", hash_original_method = "D83ED9D59CE4DAAE3BDA7C68EE854B3C", hash_generated_method = "3C1FA7EA140FBD5D4C97F27E7D6278DC")
     void run() throws ZygoteInit.MethodAndArgsCaller {
        int loopCount = ZygoteInit.GC_LOOP_COUNT;
        {
            {
                ZygoteInit.gc();
                loopCount = ZygoteInit.GC_LOOP_COUNT;
            } 
            {
                boolean var3956FC6BD84B33634CFE124145ABBD1D_1481866737 = (runOnce());
            } 
        } 
        
        
        
            
                
                
            
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.780 -0400", hash_original_method = "D76E963329652A6F2BCB5FE055E042D1", hash_generated_method = "99CCC71A757AF76F98305A4738065984")
     boolean runOnce() throws ZygoteInit.MethodAndArgsCaller {
        String args[] = null;
        Arguments parsedArgs = null;
        FileDescriptor[] descriptors = null;
        try 
        {
            args = readArgumentList();
            descriptors = mSocket.getAncillaryFileDescriptors();
        } 
        catch (IOException ex)
        {
            closeSocket();
        } 
        {
            closeSocket();
        } 
        PrintStream newStderr = null;
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
            {
                rlimits = parsedArgs.rlimits.toArray(intArray2d);
            } 
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
            {
                IoUtils.closeQuietly(serverPipeFd);
                serverPipeFd = null;
                handleChildProc(parsedArgs, descriptors, childPipeFd, newStderr);
            } 
            {
                IoUtils.closeQuietly(childPipeFd);
                childPipeFd = null;
                boolean var3BB28BDAA63918F5E760084AB2F56798_601688189 = (handleParentProc(pid, descriptors, serverPipeFd, parsedArgs));
            } 
        } 
        finally 
        {
            IoUtils.closeQuietly(childPipeFd);
            IoUtils.closeQuietly(serverPipeFd);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914558066 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_914558066;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.781 -0400", hash_original_method = "5A630DC8DA41E048830D803B657E049B", hash_generated_method = "42044CF4C6C378A3D5B1C19FAE943FED")
     void closeSocket() {
        try 
        {
            mSocket.close();
        } 
        catch (IOException ex)
        { }
        
        
            
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.782 -0400", hash_original_method = "366F843C8FBE8BB09896187A9CDF1388", hash_generated_method = "932D6CB0DBA31031BD86597C019CF95E")
    private String[] readArgumentList() throws IOException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_541729181 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_1294554178 = null; 
        int argc = 0;
        try 
        {
            String s = mSocketReader.readLine();
            {
                varB4EAC82CA7396A68D541C85D26508E83_541729181 = null;
            } 
            argc = Integer.parseInt(s);
        } 
        catch (NumberFormatException ex)
        { 
        	throw new IOException("invalid wire format");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("max arg count exceeded");
        } 
        String[] result = new String[argc];
        {
            int i = 0;
            {
                result[i] = mSocketReader.readLine();
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("truncated request");
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1294554178 = result;
        String[] varA7E53CE21691AB073D9660D615818899_864665360; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_864665360 = varB4EAC82CA7396A68D541C85D26508E83_541729181;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_864665360 = varB4EAC82CA7396A68D541C85D26508E83_1294554178;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_864665360.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_864665360;
        
        
        
            
            
                
            
            
        
            
            
        
        
            
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void applyDebuggerSystemProperty(Arguments args) {
        if ("1".equals(SystemProperties.get("ro.debuggable"))) {
            args.debugFlags |= Zygote.DEBUG_ENABLE_DEBUGGER;
        }
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static void applyInvokeWithSecurityPolicy(Arguments args, Credentials peer) throws ZygoteSecurityException {
        int peerUid = peer.getUid();
        if (args.invokeWith != null && peerUid != 0) {
            throw new ZygoteSecurityException("Peer is not permitted to specify "
                    + "an explicit invoke-with wrapper command");
        }
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.794 -0400", hash_original_method = "D56D87B601F5E5F24F9D8C0DB423B19E", hash_generated_method = "65CF7A551AF0CFE94BA1806122874E6B")
    private void handleChildProc(Arguments parsedArgs,
            FileDescriptor[] descriptors, FileDescriptor pipeFd, PrintStream newStderr) throws ZygoteInit.MethodAndArgsCaller {
        {
            try 
            {
                ZygoteInit.setCloseOnExec(mSocket.getFileDescriptor(), true);
                sPeerWaitSocket = mSocket;
            } 
            catch (IOException ex)
            { }
        } 
        {
            closeSocket();
            ZygoteInit.closeServerSocket();
        } 
        {
            try 
            {
                ZygoteInit.reopenStdio(descriptors[0],
                        descriptors[1], descriptors[2]);
                {
                    FileDescriptor fd = descriptors[0];
                    {
                        IoUtils.closeQuietly(fd);
                    } 
                } 
                newStderr = System.err;
            } 
            catch (IOException ex)
            { }
        } 
        {
            Process.setArgV0(parsedArgs.niceName);
        } 
        {
            {
                WrapperInit.execApplication(parsedArgs.invokeWith,
                        parsedArgs.niceName, parsedArgs.targetSdkVersion,
                        pipeFd, parsedArgs.remainingArgs);
            } 
            {
                RuntimeInit.zygoteInit(parsedArgs.targetSdkVersion,
                        parsedArgs.remainingArgs);
            } 
        } 
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
            {
                WrapperInit.execStandalone(parsedArgs.invokeWith,
                        parsedArgs.classpath, className, mainArgs);
            } 
            {
                ClassLoader cloader;
                {
                    cloader = new PathClassLoader(parsedArgs.classpath,
                            ClassLoader.getSystemClassLoader());
                } 
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
        addTaint(parsedArgs.getTaint());
        addTaint(descriptors[0].getTaint());
        addTaint(pipeFd.getTaint());
        addTaint(newStderr.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.807 -0400", hash_original_method = "3D3F8EE18B5CE9AC13BB6381C124884E", hash_generated_method = "548E329BA411F417C6826CD0FEAA7FE9")
    private boolean handleParentProc(int pid,
            FileDescriptor[] descriptors, FileDescriptor pipeFd, Arguments parsedArgs) {
        {
            setChildPgid(pid);
        } 
        {
            {
                FileDescriptor fd = descriptors[0];
                {
                    IoUtils.closeQuietly(fd);
                } 
            } 
        } 
        boolean usingWrapper = false;
        {
            DataInputStream is = new DataInputStream(new FileInputStream(pipeFd));
            int innerPid = -1;
            try 
            {
                innerPid = is.readInt();
            } 
            catch (IOException ex)
            { }
            finally 
            {
                try 
                {
                    is.close();
                } 
                catch (IOException ex)
                { }
            } 
            {
                int parentPid = innerPid;
                {
                    parentPid = Process.getParentPid(parentPid);
                } 
                {
                    pid = innerPid;
                    usingWrapper = true;
                } 
            } 
        } 
        try 
        {
            mSocketOutStream.writeInt(pid);
            mSocketOutStream.writeBoolean(usingWrapper);
        } 
        catch (IOException ex)
        { }
        {
            try 
            {
                mSocket.close();
            } 
            catch (IOException ex)
            { }
        } 
        addTaint(pid);
        addTaint(descriptors[0].getTaint());
        addTaint(pipeFd.getTaint());
        addTaint(parsedArgs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_349310165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_349310165;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.808 -0400", hash_original_method = "A5A16DB5966812C0B6C21E171E7DEF94", hash_generated_method = "890833DA3B7C6054EE7DA059DF81A371")
    private void setChildPgid(int pid) {
        try 
        {
            ZygoteInit.setpgid(pid, ZygoteInit.getpgid(peer.getPid()));
        } 
        catch (IOException ex)
        { }
        addTaint(pid);
        
        
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void logAndPrintError(PrintStream newStderr,
            String message, Throwable ex) {
        Log.e(TAG, message, ex);
        if (newStderr != null) {
            newStderr.println(message + (ex == null ? "" : ex));
        }
    }

    
    static class Arguments {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "0CB100AF67BD2EB1F0E2A464C0F12B08", hash_generated_field = "8E7F39D78C11D0D620F5769854F95AD4")

        int uid = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "8C752772BC3E7930653B65D1E22518B0", hash_generated_field = "FCC687D32DCADE2501DFF90534FB8EB3")

        boolean uidSpecified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "404F44BC9AAB75EF1799743675B1FBD1", hash_generated_field = "CD7DE07815123E8D5BDE5DC586F9E327")

        int gid = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "398A5174EFB36BC0BF8DE762DA220023", hash_generated_field = "7F9C72C3971857F2F2424F2876DDCB37")

        boolean gidSpecified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "77DBC042260703938C8CA627F28C6CF5", hash_generated_field = "54C577A65DD30DDDFB9215D4CF28DB70")

        int[] gids;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "2B754C222A01095B11299CC5E0B9E1CE", hash_generated_field = "DE4E6DC7B42CB6C9AA9043942BF17F86")

        boolean peerWait;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "003817FE41A79B41720958195F588744", hash_generated_field = "EE1851787F428E476E8277578F17E703")

        int debugFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "6099B90F1E5E8B48541E9B6E6B9E7C89", hash_generated_field = "6C1842C610E85CE5AAB422B21DE084EE")

        int targetSdkVersion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "ABE8F3014224BEA06B50EEDE67F3D8ED", hash_generated_field = "13C1E04054F8153548EFE0154E96AF4F")

        boolean targetSdkVersionSpecified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "621F8FA91E380C78BD98880BE47DFC8A", hash_generated_field = "F6B99376C3175C909AAF68D121783067")

        String classpath;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "BFB62C5307E4BCDA1B10795C274A1E70", hash_generated_field = "83B5575B50DE1C2A124BAC34BDE96481")

        boolean runtimeInit;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "24E312342380F3064032CB21B6D58823", hash_generated_field = "A9B0553B8BC7AA374068697DA246A7A6")

        String niceName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "60CBE6FEE7FEEC6AE73BF4B02B6B81E0", hash_generated_field = "A6E797CB91748575747AFCEF1EFABE00")

        boolean capabilitiesSpecified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "18DE92E733E3F8935E94E868D7001228", hash_generated_field = "1953FB01473D5608C92B58749337D80F")

        long permittedCapabilities;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "AA691C164A2FBAA688633A0E8F811EF1", hash_generated_field = "5B064209ACA1CCAE633A16D8D6ED5D7E")

        long effectiveCapabilities;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "41155B5DE35F5D4E67EF89201B7F5565", hash_generated_field = "6B6E7FE0066F3C40E26724314989FD1B")

        ArrayList<int[]> rlimits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "8E5E27F054987B84BB22F5307D0237B3", hash_generated_field = "452A5731BC14408AF85FDFEF2F034B9D")

        String invokeWith;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.809 -0400", hash_original_field = "3C8D8F8A1F0275D9C097D1CA5ADD856B", hash_generated_field = "88B6A06E0D43FBF96C1153AEAB5C29CA")

        String remainingArgs[];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.810 -0400", hash_original_method = "35BDC5101A4DE38616FDCE6EF4D8CA10", hash_generated_method = "DFC605ACC3B8EA6D90580703C327FB9B")
          Arguments(String args[]) throws IllegalArgumentException {
            parseArgs(args);
            addTaint(args[0].getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.813 -0400", hash_original_method = "12134C3215A59528551E59AC16868712", hash_generated_method = "AD862CA724B2E17A11DA361303129C1F")
        private void parseArgs(String args[]) throws IllegalArgumentException {
            int curArg = 0;
            {
                String arg = args[curArg];
                {
                    boolean var566DD555814D764ED9A29C42F8874316_820637683 = (arg.equals("--"));
                    {
                        boolean varB23576AD5E9EC539D85F6DF6FF560CA3_1295586044 = (arg.startsWith("--setuid="));
                        {
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                            } 
                            uidSpecified = true;
                            uid = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                        } 
                        {
                            boolean var615818C78584CF4A74BFFF152C4BEFC2_1674073777 = (arg.startsWith("--setgid="));
                            {
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                } 
                                gidSpecified = true;
                                gid = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                            } 
                            {
                                boolean var24763721E45D3CA4B8E6E1066D7BCF52_2128054974 = (arg.startsWith("--target-sdk-version="));
                                {
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate target-sdk-version specified");
                                    } 
                                    targetSdkVersionSpecified = true;
                                    targetSdkVersion = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                                } 
                                {
                                    boolean varF8C61B28A5711C2EA7983BBEA5459723_393348618 = (arg.equals("--enable-debugger"));
                                    {
                                        debugFlags |= Zygote.DEBUG_ENABLE_DEBUGGER;
                                    } 
                                    {
                                        boolean var60CF783C1D3CC8B3A3B2A942F345BEF5_662629123 = (arg.equals("--enable-safemode"));
                                        {
                                            debugFlags |= Zygote.DEBUG_ENABLE_SAFEMODE;
                                        } 
                                        {
                                            boolean var7BE4F9B0DD1B984250181EF453CE1295_1051239465 = (arg.equals("--enable-checkjni"));
                                            {
                                                debugFlags |= Zygote.DEBUG_ENABLE_CHECKJNI;
                                            } 
                                            {
                                                boolean varDFB4DAD6D222A85617A52FF793FE9196_1174334693 = (arg.equals("--enable-jni-logging"));
                                                {
                                                    debugFlags |= Zygote.DEBUG_ENABLE_JNI_LOGGING;
                                                } 
                                                {
                                                    boolean varC78F887AA1F638387C49BA1038BF2302_1304887556 = (arg.equals("--enable-assert"));
                                                    {
                                                        debugFlags |= Zygote.DEBUG_ENABLE_ASSERT;
                                                    } 
                                                    {
                                                        boolean varD484FD677E695FABB55E459F08F42464_1679839538 = (arg.equals("--peer-wait"));
                                                        {
                                                            peerWait = true;
                                                        } 
                                                        {
                                                            boolean varBF9C7EF5AA3D2A09214B59220EC60460_509570473 = (arg.equals("--runtime-init"));
                                                            {
                                                                runtimeInit = true;
                                                            } 
                                                            {
                                                                boolean var81FD0E7377BC8C8914370AAA0942FD02_1930403718 = (arg.startsWith("--capabilities="));
                                                                {
                                                                    {
                                                                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                                                    } 
                                                                    capabilitiesSpecified = true;
                                                                    String capString = arg.substring(arg.indexOf('=')+1);
                                                                    String[] capStrings = capString.split(",", 2);
                                                                    {
                                                                        effectiveCapabilities = Long.decode(capStrings[0]);
                                                                        permittedCapabilities = effectiveCapabilities;
                                                                    } 
                                                                    {
                                                                        permittedCapabilities = Long.decode(capStrings[0]);
                                                                        effectiveCapabilities = Long.decode(capStrings[1]);
                                                                    } 
                                                                } 
                                                                {
                                                                    boolean varD0122AC3E6EE8080F6A63FB354B07667_1354700134 = (arg.startsWith("--rlimit="));
                                                                    {
                                                                        String[] limitStrings = arg.substring(arg.indexOf('=')+1).split(",");
                                                                        {
                                                                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "--rlimit= should have 3 comma-delimited ints");
                                                                        } 
                                                                        int[] rlimitTuple = new int[limitStrings.length];
                                                                        {
                                                                            int i = 0;
                                                                            {
                                                                                rlimitTuple[i] = Integer.parseInt(limitStrings[i]);
                                                                            } 
                                                                        } 
                                                                        {
                                                                            rlimits = new ArrayList();
                                                                        } 
                                                                        rlimits.add(rlimitTuple);
                                                                    } 
                                                                    {
                                                                        boolean varFF9705365BEE70B07B6EFFB521D414AA_73114206 = (arg.equals("-classpath"));
                                                                        {
                                                                            {
                                                                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                                                            } 
                                                                            try 
                                                                            {
                                                                                classpath = args[++curArg];
                                                                            } 
                                                                            catch (IndexOutOfBoundsException ex)
                                                                            {
                                                                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "-classpath requires argument");
                                                                            } 
                                                                        } 
                                                                        {
                                                                            boolean var01A215526D08A822971F3966BC540C5C_1096960916 = (arg.startsWith("--setgroups="));
                                                                            {
                                                                                {
                                                                                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                                                                } 
                                                                                String[] params = arg.substring(arg.indexOf('=') + 1).split(",");
                                                                                gids = new int[params.length];
                                                                                {
                                                                                    int i = params.length - 1;
                                                                                    {
                                                                                        gids[i] = Integer.parseInt(params[i]);
                                                                                    } 
                                                                                } 
                                                                            } 
                                                                            {
                                                                                boolean varAB99EE29FAEDC9A537504420A8FE7C0C_624960670 = (arg.equals("--invoke-with"));
                                                                                {
                                                                                    {
                                                                                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                                                                    } 
                                                                                    try 
                                                                                    {
                                                                                        invokeWith = args[++curArg];
                                                                                    } 
                                                                                    catch (IndexOutOfBoundsException ex)
                                                                                    {
                                                                                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "--invoke-with requires argument");
                                                                                    } 
                                                                                } 
                                                                                {
                                                                                    boolean varBB33221C616B9A2EF60ADA576E53C449_1411485315 = (arg.startsWith("--nice-name="));
                                                                                    {
                                                                                        {
                                                                                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                                                                        } 
                                                                                        niceName = arg.substring(arg.indexOf('=') + 1);
                                                                                    } 
                                                                                } 
                                                                            } 
                                                                        } 
                                                                    } 
                                                                } 
                                                            } 
                                                        } 
                                                    } 
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "--runtime-init and -classpath are incompatible");
            } 
            remainingArgs = new String[args.length - curArg];
            System.arraycopy(args, curArg, remainingArgs, 0,
                    remainingArgs.length);
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.813 -0400", hash_original_field = "07E71AB65C7C829BB9961A38207CC4B3", hash_generated_field = "2A664B91B7AF4DD6DD39F407BBDAB91B")

    private static final String TAG = "Zygote";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.813 -0400", hash_original_field = "E0A6057357B310940FCD39CB93779051", hash_generated_field = "80CAE96E8C1B0DF29A980BF5109CC5BF")

    private static final int[][] intArray2d = new int[0][0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.813 -0400", hash_original_field = "60D62043D7F17FF5FDECBB860D085F6E", hash_generated_field = "F25FDE7970276014B50B25B9CC13AA49")

    private static final int CONNECTION_TIMEOUT_MILLIS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.813 -0400", hash_original_field = "1E48E792AF09046D0B312211C708BAD2", hash_generated_field = "B23BA5B642881C70E30A38B20D6C2EA9")

    private static final int MAX_ZYGOTE_ARGC = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.813 -0400", hash_original_field = "2F11EEC42CD2936CFFEC0BB3C6C0C738", hash_generated_field = "4F9908C941A92E3CBBEB2EF6B2065848")

    private static LocalSocket sPeerWaitSocket = null;
}

