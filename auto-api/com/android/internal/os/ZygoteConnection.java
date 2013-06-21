package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private LocalSocket mSocket;
    private DataOutputStream mSocketOutStream;
    private BufferedReader mSocketReader;
    private Credentials peer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.315 -0400", hash_original_method = "7184EAAE07D7B6F9BEC01EBE5F329335", hash_generated_method = "FE41A74259A7EA64DE3966E502814D15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ZygoteConnection(LocalSocket socket) throws IOException {
        dsTaint.addTaint(socket.dsTaint);
        mSocketOutStream
                = new DataOutputStream(socket.getOutputStream());
        mSocketReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()), 256);
        mSocket.setSoTimeout(CONNECTION_TIMEOUT_MILLIS);
        try 
        {
            peer = mSocket.getPeerCredentials();
        } //End block
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        // ---------- Original Method ----------
        //mSocket = socket;
        //mSocketOutStream
                //= new DataOutputStream(socket.getOutputStream());
        //mSocketReader = new BufferedReader(
                //new InputStreamReader(socket.getInputStream()), 256);
        //mSocket.setSoTimeout(CONNECTION_TIMEOUT_MILLIS);
        //try {
            //peer = mSocket.getPeerCredentials();
        //} catch (IOException ex) {
            //Log.e(TAG, "Cannot read peer credentials", ex);
            //throw ex;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.316 -0400", hash_original_method = "D031047267A17F3FBDEAA6E5A25F7FEC", hash_generated_method = "3CF69F15DBB8E963DA2B9E8A04817F4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FileDescriptor getFileDesciptor() {
        FileDescriptor var6CB27DE96920987E2173F885122A6F5B_1936283242 = (mSocket.getFileDescriptor());
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSocket.getFileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.316 -0400", hash_original_method = "D83ED9D59CE4DAAE3BDA7C68EE854B3C", hash_generated_method = "257DDB7ECE4F4DF912958EC52FCD6B11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void run() throws ZygoteInit.MethodAndArgsCaller {
        int loopCount;
        loopCount = ZygoteInit.GC_LOOP_COUNT;
        {
            {
                ZygoteInit.gc();
                loopCount = ZygoteInit.GC_LOOP_COUNT;
            } //End block
            {
                boolean var3956FC6BD84B33634CFE124145ABBD1D_1841575677 = (runOnce());
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //int loopCount = ZygoteInit.GC_LOOP_COUNT;
        //while (true) {
            //if (loopCount <= 0) {
                //ZygoteInit.gc();
                //loopCount = ZygoteInit.GC_LOOP_COUNT;
            //} else {
                //loopCount--;
            //}
            //if (runOnce()) {
                //break;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.317 -0400", hash_original_method = "D76E963329652A6F2BCB5FE055E042D1", hash_generated_method = "757C454DAA19D1C723278135D47266B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean runOnce() throws ZygoteInit.MethodAndArgsCaller {
        String args[];
        Arguments parsedArgs;
        parsedArgs = null;
        FileDescriptor[] descriptors;
        try 
        {
            args = readArgumentList();
            descriptors = mSocket.getAncillaryFileDescriptors();
        } //End block
        catch (IOException ex)
        {
            closeSocket();
        } //End block
        {
            closeSocket();
        } //End block
        PrintStream newStderr;
        newStderr = null;
        {
            newStderr = new PrintStream(
                    new FileOutputStream(descriptors[2]));
        } //End block
        int pid;
        pid = -1;
        FileDescriptor childPipeFd;
        childPipeFd = null;
        FileDescriptor serverPipeFd;
        serverPipeFd = null;
        try 
        {
            parsedArgs = new Arguments(args);
            applyUidSecurityPolicy(parsedArgs, peer);
            applyRlimitSecurityPolicy(parsedArgs, peer);
            applyCapabilitiesSecurityPolicy(parsedArgs, peer);
            applyInvokeWithSecurityPolicy(parsedArgs, peer);
            applyDebuggerSystemProperty(parsedArgs);
            applyInvokeWithSystemProperty(parsedArgs);
            int[][] rlimits;
            rlimits = null;
            {
                rlimits = parsedArgs.rlimits.toArray(intArray2d);
            } //End block
            {
                FileDescriptor[] pipeFds;
                pipeFds = Libcore.os.pipe();
                childPipeFd = pipeFds[1];
                serverPipeFd = pipeFds[0];
                ZygoteInit.setCloseOnExec(serverPipeFd, true);
            } //End block
            pid = Zygote.forkAndSpecialize(parsedArgs.uid, parsedArgs.gid,
                    parsedArgs.gids, parsedArgs.debugFlags, rlimits);
        } //End block
        catch (IOException ex)
        {
            logAndPrintError(newStderr, "Exception creating pipe", ex);
        } //End block
        catch (ErrnoException ex)
        {
            logAndPrintError(newStderr, "Exception creating pipe", ex);
        } //End block
        catch (IllegalArgumentException ex)
        {
            logAndPrintError(newStderr, "Invalid zygote arguments", ex);
        } //End block
        catch (ZygoteSecurityException ex)
        {
            logAndPrintError(newStderr,
                    "Zygote security policy prevents request: ", ex);
        } //End block
        try 
        {
            {
                IoUtils.closeQuietly(serverPipeFd);
                serverPipeFd = null;
                handleChildProc(parsedArgs, descriptors, childPipeFd, newStderr);
            } //End block
            {
                IoUtils.closeQuietly(childPipeFd);
                childPipeFd = null;
                boolean var3BB28BDAA63918F5E760084AB2F56798_1893857186 = (handleParentProc(pid, descriptors, serverPipeFd, parsedArgs));
            } //End block
        } //End block
        finally 
        {
            IoUtils.closeQuietly(childPipeFd);
            IoUtils.closeQuietly(serverPipeFd);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.317 -0400", hash_original_method = "5A630DC8DA41E048830D803B657E049B", hash_generated_method = "42044CF4C6C378A3D5B1C19FAE943FED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void closeSocket() {
        try 
        {
            mSocket.close();
        } //End block
        catch (IOException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mSocket.close();
        //} catch (IOException ex) {
            //Log.e(TAG, "Exception while closing command "
                    //+ "socket in parent", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.318 -0400", hash_original_method = "366F843C8FBE8BB09896187A9CDF1388", hash_generated_method = "10A840CBD81495F59CCC8A015B66568F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String[] readArgumentList() throws IOException {
        int argc;
        try 
        {
            String s;
            s = mSocketReader.readLine();
            argc = Integer.parseInt(s);
        } //End block
        catch (NumberFormatException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("invalid wire format");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("max arg count exceeded");
        } //End block
        String[] result;
        result = new String[argc];
        {
            int i;
            i = 0;
            {
                result[i] = mSocketReader.readLine();
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("truncated request");
                } //End block
            } //End block
        } //End collapsed parenthetic
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //int argc;
        //try {
            //String s = mSocketReader.readLine();
            //if (s == null) {
                //return null;
            //}
            //argc = Integer.parseInt(s);
        //} catch (NumberFormatException ex) {
            //Log.e(TAG, "invalid Zygote wire format: non-int at argc");
            //throw new IOException("invalid wire format");
        //}
        //if (argc > MAX_ZYGOTE_ARGC) {   
            //throw new IOException("max arg count exceeded");
        //}
        //String[] result = new String[argc];
        //for (int i = 0; i < argc; i++) {
            //result[i] = mSocketReader.readLine();
            //if (result[i] == null) {
                //throw new IOException("truncated request");
            //}
        //}
        //return result;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.331 -0400", hash_original_method = "D56D87B601F5E5F24F9D8C0DB423B19E", hash_generated_method = "279D33174DFEAA43C017AC10E6518ACB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleChildProc(Arguments parsedArgs,
            FileDescriptor[] descriptors, FileDescriptor pipeFd, PrintStream newStderr) throws ZygoteInit.MethodAndArgsCaller {
        dsTaint.addTaint(newStderr.dsTaint);
        dsTaint.addTaint(pipeFd.dsTaint);
        dsTaint.addTaint(parsedArgs.dsTaint);
        dsTaint.addTaint(descriptors[0].dsTaint);
        {
            try 
            {
                ZygoteInit.setCloseOnExec(mSocket.getFileDescriptor(), true);
                sPeerWaitSocket = mSocket;
            } //End block
            catch (IOException ex)
            { }
        } //End block
        {
            closeSocket();
            ZygoteInit.closeServerSocket();
        } //End block
        {
            try 
            {
                ZygoteInit.reopenStdio(descriptors[0],
                        descriptors[1], descriptors[2]);
                {
                    FileDescriptor fd = descriptors[0];
                    {
                        IoUtils.closeQuietly(fd);
                    } //End block
                } //End collapsed parenthetic
                newStderr = System.err;
            } //End block
            catch (IOException ex)
            { }
        } //End block
        {
            Process.setArgV0(parsedArgs.niceName);
        } //End block
        {
            {
                WrapperInit.execApplication(parsedArgs.invokeWith,
                        parsedArgs.niceName, parsedArgs.targetSdkVersion,
                        pipeFd, parsedArgs.remainingArgs);
            } //End block
            {
                RuntimeInit.zygoteInit(parsedArgs.targetSdkVersion,
                        parsedArgs.remainingArgs);
            } //End block
        } //End block
        {
            String className;
            try 
            {
                className = parsedArgs.remainingArgs[0];
            } //End block
            catch (ArrayIndexOutOfBoundsException ex)
            {
                logAndPrintError(newStderr,
                        "Missing required class name argument", null);
            } //End block
            String[] mainArgs;
            mainArgs = new String[parsedArgs.remainingArgs.length - 1];
            System.arraycopy(parsedArgs.remainingArgs, 1,
                    mainArgs, 0, mainArgs.length);
            {
                WrapperInit.execStandalone(parsedArgs.invokeWith,
                        parsedArgs.classpath, className, mainArgs);
            } //End block
            {
                ClassLoader cloader;
                {
                    cloader = new PathClassLoader(parsedArgs.classpath,
                            ClassLoader.getSystemClassLoader());
                } //End block
                {
                    cloader = ClassLoader.getSystemClassLoader();
                } //End block
                try 
                {
                    ZygoteInit.invokeStaticMain(cloader, className, mainArgs);
                } //End block
                catch (RuntimeException ex)
                {
                    logAndPrintError(newStderr, "Error starting.", ex);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.350 -0400", hash_original_method = "3D3F8EE18B5CE9AC13BB6381C124884E", hash_generated_method = "F957D098A23AAF74E6ACEAF8074BC708")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleParentProc(int pid,
            FileDescriptor[] descriptors, FileDescriptor pipeFd, Arguments parsedArgs) {
        dsTaint.addTaint(pipeFd.dsTaint);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(parsedArgs.dsTaint);
        dsTaint.addTaint(descriptors[0].dsTaint);
        {
            setChildPgid(pid);
        } //End block
        {
            {
                FileDescriptor fd = descriptors[0];
                {
                    IoUtils.closeQuietly(fd);
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean usingWrapper;
        usingWrapper = false;
        {
            DataInputStream is;
            is = new DataInputStream(new FileInputStream(pipeFd));
            int innerPid;
            innerPid = -1;
            try 
            {
                innerPid = is.readInt();
            } //End block
            catch (IOException ex)
            { }
            finally 
            {
                try 
                {
                    is.close();
                } //End block
                catch (IOException ex)
                { }
            } //End block
            {
                int parentPid;
                parentPid = innerPid;
                {
                    parentPid = Process.getParentPid(parentPid);
                } //End block
                {
                    pid = innerPid;
                    usingWrapper = true;
                } //End block
            } //End block
        } //End block
        try 
        {
            mSocketOutStream.writeInt(pid);
            mSocketOutStream.writeBoolean(usingWrapper);
        } //End block
        catch (IOException ex)
        { }
        {
            try 
            {
                mSocket.close();
            } //End block
            catch (IOException ex)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.353 -0400", hash_original_method = "A5A16DB5966812C0B6C21E171E7DEF94", hash_generated_method = "C2B85B4E90745939529E1646EF6FD2FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setChildPgid(int pid) {
        dsTaint.addTaint(pid);
        try 
        {
            ZygoteInit.setpgid(pid, ZygoteInit.getpgid(peer.getPid()));
        } //End block
        catch (IOException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //ZygoteInit.setpgid(pid, ZygoteInit.getpgid(peer.getPid()));
        //} catch (IOException ex) {
            //Log.i(TAG, "Zygote: setpgid failed. This is "
                //+ "normal if peer is not in our session");
        //}
    }

    
        private static void logAndPrintError(PrintStream newStderr,
            String message, Throwable ex) {
        Log.e(TAG, message, ex);
        if (newStderr != null) {
            newStderr.println(message + (ex == null ? "" : ex));
        }
    }

    
    static class Arguments {
        int uid = 0;
        boolean uidSpecified;
        int gid = 0;
        boolean gidSpecified;
        int[] gids;
        boolean peerWait;
        int debugFlags;
        int targetSdkVersion;
        boolean targetSdkVersionSpecified;
        String classpath;
        boolean runtimeInit;
        String niceName;
        boolean capabilitiesSpecified;
        long permittedCapabilities;
        long effectiveCapabilities;
        ArrayList<int[]> rlimits;
        String invokeWith;
        String remainingArgs[];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.354 -0400", hash_original_method = "35BDC5101A4DE38616FDCE6EF4D8CA10", hash_generated_method = "7C3C468C8855B70D2E2F10F8CC7B8088")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Arguments(String args[]) throws IllegalArgumentException {
            dsTaint.addTaint(args);
            parseArgs(args);
            // ---------- Original Method ----------
            //parseArgs(args);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.358 -0400", hash_original_method = "12134C3215A59528551E59AC16868712", hash_generated_method = "20D0735DFEE361C488A64C8F73CF270E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void parseArgs(String args[]) throws IllegalArgumentException {
            dsTaint.addTaint(args);
            int curArg;
            curArg = 0;
            {
                String arg;
                arg = args[curArg];
                {
                    boolean var566DD555814D764ED9A29C42F8874316_1385329692 = (arg.equals("--"));
                    {
                        boolean varB23576AD5E9EC539D85F6DF6FF560CA3_1929739585 = (arg.startsWith("--setuid="));
                        {
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                            } //End block
                            uidSpecified = true;
                            uid = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                        } //End block
                        {
                            boolean var615818C78584CF4A74BFFF152C4BEFC2_1028112371 = (arg.startsWith("--setgid="));
                            {
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                } //End block
                                gidSpecified = true;
                                gid = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                            } //End block
                            {
                                boolean var24763721E45D3CA4B8E6E1066D7BCF52_1702297039 = (arg.startsWith("--target-sdk-version="));
                                {
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate target-sdk-version specified");
                                    } //End block
                                    targetSdkVersionSpecified = true;
                                    targetSdkVersion = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                                } //End block
                                {
                                    boolean varF8C61B28A5711C2EA7983BBEA5459723_535967997 = (arg.equals("--enable-debugger"));
                                    {
                                        debugFlags |= Zygote.DEBUG_ENABLE_DEBUGGER;
                                    } //End block
                                    {
                                        boolean var60CF783C1D3CC8B3A3B2A942F345BEF5_2134979111 = (arg.equals("--enable-safemode"));
                                        {
                                            debugFlags |= Zygote.DEBUG_ENABLE_SAFEMODE;
                                        } //End block
                                        {
                                            boolean var7BE4F9B0DD1B984250181EF453CE1295_1709767791 = (arg.equals("--enable-checkjni"));
                                            {
                                                debugFlags |= Zygote.DEBUG_ENABLE_CHECKJNI;
                                            } //End block
                                            {
                                                boolean varDFB4DAD6D222A85617A52FF793FE9196_830318059 = (arg.equals("--enable-jni-logging"));
                                                {
                                                    debugFlags |= Zygote.DEBUG_ENABLE_JNI_LOGGING;
                                                } //End block
                                                {
                                                    boolean varC78F887AA1F638387C49BA1038BF2302_1619332353 = (arg.equals("--enable-assert"));
                                                    {
                                                        debugFlags |= Zygote.DEBUG_ENABLE_ASSERT;
                                                    } //End block
                                                    {
                                                        boolean varD484FD677E695FABB55E459F08F42464_1404598810 = (arg.equals("--peer-wait"));
                                                        {
                                                            peerWait = true;
                                                        } //End block
                                                        {
                                                            boolean varBF9C7EF5AA3D2A09214B59220EC60460_1044492347 = (arg.equals("--runtime-init"));
                                                            {
                                                                runtimeInit = true;
                                                            } //End block
                                                            {
                                                                boolean var81FD0E7377BC8C8914370AAA0942FD02_232453869 = (arg.startsWith("--capabilities="));
                                                                {
                                                                    {
                                                                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                                                    } //End block
                                                                    capabilitiesSpecified = true;
                                                                    String capString;
                                                                    capString = arg.substring(arg.indexOf('=')+1);
                                                                    String[] capStrings;
                                                                    capStrings = capString.split(",", 2);
                                                                    {
                                                                        effectiveCapabilities = Long.decode(capStrings[0]);
                                                                        permittedCapabilities = effectiveCapabilities;
                                                                    } //End block
                                                                    {
                                                                        permittedCapabilities = Long.decode(capStrings[0]);
                                                                        effectiveCapabilities = Long.decode(capStrings[1]);
                                                                    } //End block
                                                                } //End block
                                                                {
                                                                    boolean varD0122AC3E6EE8080F6A63FB354B07667_139980730 = (arg.startsWith("--rlimit="));
                                                                    {
                                                                        String[] limitStrings;
                                                                        limitStrings = arg.substring(arg.indexOf('=')+1).split(",");
                                                                        {
                                                                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "--rlimit= should have 3 comma-delimited ints");
                                                                        } //End block
                                                                        int[] rlimitTuple;
                                                                        rlimitTuple = new int[limitStrings.length];
                                                                        {
                                                                            int i;
                                                                            i = 0;
                                                                            {
                                                                                rlimitTuple[i] = Integer.parseInt(limitStrings[i]);
                                                                            } //End block
                                                                        } //End collapsed parenthetic
                                                                        {
                                                                            rlimits = new ArrayList();
                                                                        } //End block
                                                                        rlimits.add(rlimitTuple);
                                                                    } //End block
                                                                    {
                                                                        boolean varFF9705365BEE70B07B6EFFB521D414AA_1406973147 = (arg.equals("-classpath"));
                                                                        {
                                                                            {
                                                                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                                                            } //End block
                                                                            try 
                                                                            {
                                                                                classpath = args[++curArg];
                                                                            } //End block
                                                                            catch (IndexOutOfBoundsException ex)
                                                                            {
                                                                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "-classpath requires argument");
                                                                            } //End block
                                                                        } //End block
                                                                        {
                                                                            boolean var01A215526D08A822971F3966BC540C5C_1567818639 = (arg.startsWith("--setgroups="));
                                                                            {
                                                                                {
                                                                                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                                                                } //End block
                                                                                String[] params;
                                                                                params = arg.substring(arg.indexOf('=') + 1).split(",");
                                                                                gids = new int[params.length];
                                                                                {
                                                                                    int i;
                                                                                    i = params.length - 1;
                                                                                    {
                                                                                        gids[i] = Integer.parseInt(params[i]);
                                                                                    } //End block
                                                                                } //End collapsed parenthetic
                                                                            } //End block
                                                                            {
                                                                                boolean varAB99EE29FAEDC9A537504420A8FE7C0C_609126702 = (arg.equals("--invoke-with"));
                                                                                {
                                                                                    {
                                                                                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                                                                    } //End block
                                                                                    try 
                                                                                    {
                                                                                        invokeWith = args[++curArg];
                                                                                    } //End block
                                                                                    catch (IndexOutOfBoundsException ex)
                                                                                    {
                                                                                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "--invoke-with requires argument");
                                                                                    } //End block
                                                                                } //End block
                                                                                {
                                                                                    boolean varBB33221C616B9A2EF60ADA576E53C449_925527966 = (arg.startsWith("--nice-name="));
                                                                                    {
                                                                                        {
                                                                                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                                "Duplicate arg specified");
                                                                                        } //End block
                                                                                        niceName = arg.substring(arg.indexOf('=') + 1);
                                                                                    } //End block
                                                                                } //End collapsed parenthetic
                                                                            } //End collapsed parenthetic
                                                                        } //End collapsed parenthetic
                                                                    } //End collapsed parenthetic
                                                                } //End collapsed parenthetic
                                                            } //End collapsed parenthetic
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "--runtime-init and -classpath are incompatible");
            } //End block
            remainingArgs = new String[args.length - curArg];
            System.arraycopy(args, curArg, remainingArgs, 0,
                    remainingArgs.length);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static final String TAG = "Zygote";
    private static final int[][] intArray2d = new int[0][0];
    private static final int CONNECTION_TIMEOUT_MILLIS = 1000;
    private static final int MAX_ZYGOTE_ARGC=1024;
    private static LocalSocket sPeerWaitSocket = null;
}

