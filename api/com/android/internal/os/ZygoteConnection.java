package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
import android.net.Credentials;
import android.net.LocalSocket;
import android.os.Process;
import android.os.SystemProperties;
import android.util.Log;
import dalvik.system.PathClassLoader;
import dalvik.system.Zygote;

class ZygoteConnection {

    /**
     * Applies zygote security policy per bugs #875058 and #1082165. 
     * Based on the credentials of the process issuing a zygote command:
     * <ol>
     * <li> uid 0 (root) may specify any uid, gid, and setgroups() list
     * <li> uid 1000 (Process.SYSTEM_UID) may specify any uid &gt; 1000 in normal
     * operation. It may also specify any gid and setgroups() list it chooses.
     * In factory test mode, it may specify any UID.
     * <li> Any other uid may not specify any uid, gid, or setgroups list. The
     * uid and gid will be inherited from the requesting process.
     * </ul>
     *
     * @param args non-null; zygote spawner arguments
     * @param peer non-null; peer credentials
     * @throws ZygoteSecurityException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.868 -0500", hash_original_method = "ED4471B18A05C7C9B2609597C03313FB", hash_generated_method = "0383447E8C2335734E5731CE956BDF1C")
    
private static void applyUidSecurityPolicy(Arguments args, Credentials peer)
            throws ZygoteSecurityException {

        int peerUid = peer.getUid();

        if (peerUid == 0) {
            // Root can do what it wants
        } else if (peerUid == Process.SYSTEM_UID ) {
            // System UID is restricted, except in factory test mode
            String factoryTest = SystemProperties.get("ro.factorytest");
            boolean uidRestricted;

            /* In normal operation, SYSTEM_UID can only specify a restricted
             * set of UIDs. In factory test mode, SYSTEM_UID may specify any uid.
             */
            uidRestricted  
                 = !(factoryTest.equals("1") || factoryTest.equals("2"));

            if (uidRestricted
                    && args.uidSpecified && (args.uid < Process.SYSTEM_UID)) {
                throw new ZygoteSecurityException(
                        "System UID may not launch process with UID < "
                                + Process.SYSTEM_UID);
            }
        } else {
            // Everything else
            if (args.uidSpecified || args.gidSpecified
                || args.gids != null) {
                throw new ZygoteSecurityException(
                        "App UIDs may not specify uid's or gid's");
            }
        }

        // If not otherwise specified, uid and gid are inherited from peer
        if (!args.uidSpecified) {
            args.uid = peer.getUid();
            args.uidSpecified = true;
        }
        if (!args.gidSpecified) {
            args.gid = peer.getGid();
            args.gidSpecified = true;
        }
    }

    /**
     * Applies debugger system properties to the zygote arguments.
     *
     * If "ro.debuggable" is "1", all apps are debuggable. Otherwise,
     * the debugger state is specified via the "--enable-debugger" flag
     * in the spawn request.
     *
     * @param args non-null; zygote spawner args
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.871 -0500", hash_original_method = "54930D8E89EFC71A5AA62EEEA5BD364C", hash_generated_method = "51262DF640D5CA19086BA71421BEABE1")
    
public static void applyDebuggerSystemProperty(Arguments args) {
        if ("1".equals(SystemProperties.get("ro.debuggable"))) {
            args.debugFlags |= Zygote.DEBUG_ENABLE_DEBUGGER;
        }
    }

    /**
     * Applies zygote security policy per bug #1042973. Based on the credentials
     * of the process issuing a zygote command:
     * <ol>
     * <li> peers of  uid 0 (root) and uid 1000 (Process.SYSTEM_UID)
     * may specify any rlimits.
     * <li> All other uids may not specify rlimits.
     * </ul>
     * @param args non-null; zygote spawner arguments
     * @param peer non-null; peer credentials
     * @throws ZygoteSecurityException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.873 -0500", hash_original_method = "9E045B3D7FEF0937E005932B72E7BC4F", hash_generated_method = "D5AFF4E478858FC622769DBC7F688630")
    
private static void applyRlimitSecurityPolicy(
            Arguments args, Credentials peer)
            throws ZygoteSecurityException {

        int peerUid = peer.getUid();

        if (!(peerUid == 0 || peerUid == Process.SYSTEM_UID)) {
            // All peers with UID other than root or SYSTEM_UID
            if (args.rlimits != null) {
                throw new ZygoteSecurityException(
                        "This UID may not specify rlimits.");
            }
        }
    }

    /**
     * Applies zygote security policy per bug #1042973. A root peer may
     * spawn an instance with any capabilities. All other uids may spawn
     * instances with any of the capabilities in the peer's permitted set
     * but no more.
     *
     * @param args non-null; zygote spawner arguments
     * @param peer non-null; peer credentials
     * @throws ZygoteSecurityException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.877 -0500", hash_original_method = "5C901DFE988DB9E0BABB61B8EF5034CC", hash_generated_method = "FD30597EA05804D7010AB66782EB4CBD")
    
private static void applyCapabilitiesSecurityPolicy(
            Arguments args, Credentials peer)
            throws ZygoteSecurityException {

        if (args.permittedCapabilities == 0
                && args.effectiveCapabilities == 0) {
            // nothing to check
            return;
        }

        if (peer.getUid() == 0) {
            // root may specify anything
            return;
        }

        long permittedCaps;

        try {
            permittedCaps = ZygoteInit.capgetPermitted(peer.getPid());
        } catch (IOException ex) {
            throw new ZygoteSecurityException(
                    "Error retrieving peer's capabilities.");
        }

        /*
         * Ensure that the client did not specify an effective set larger
         * than the permitted set. The kernel will enforce this too, but we
         * do it here to make the following check easier.
         */
        if (((~args.permittedCapabilities) & args.effectiveCapabilities) != 0) {
            throw new ZygoteSecurityException(
                    "Effective capabilities cannot be superset of "
                            + " permitted capabilities" );
        }

        /*
         * Ensure that the new permitted (and thus the new effective) set is
         * a subset of the peer process's permitted set
         */

        if (((~permittedCaps) & args.permittedCapabilities) != 0) {
            throw new ZygoteSecurityException(
                    "Peer specified unpermitted capabilities" );
        }
    }

    /**
     * Applies zygote security policy.
     * Based on the credentials of the process issuing a zygote command:
     * <ol>
     * <li> uid 0 (root) may specify --invoke-with to launch Zygote with a
     * wrapper command.
     * <li> Any other uid may not specify any invoke-with argument.
     * </ul>
     *
     * @param args non-null; zygote spawner arguments
     * @param peer non-null; peer credentials
     * @throws ZygoteSecurityException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.879 -0500", hash_original_method = "41BD172CDA07BE5F4D9598EFF8EB9D29", hash_generated_method = "54B8312A3A41C9C5C3658A17557380D4")
    
private static void applyInvokeWithSecurityPolicy(Arguments args, Credentials peer)
            throws ZygoteSecurityException {
        int peerUid = peer.getUid();

        if (args.invokeWith != null && peerUid != 0) {
            throw new ZygoteSecurityException("Peer is not permitted to specify "
                    + "an explicit invoke-with wrapper command");
        }
    }

    /**
     * Applies invoke-with system properties to the zygote arguments.
     *
     * @param parsedArgs non-null; zygote args
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.881 -0500", hash_original_method = "A784152F9E30B67264CE14AA01B5FC5D", hash_generated_method = "AFFFCDC65DE7F65E3FC9C87F421D0B5F")
    
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

    /**
     * Logs an error message and prints it to the specified stream, if
     * provided
     *
     * @param newStderr null-ok; a standard error stream
     * @param message non-null; error message
     * @param ex null-ok an exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.895 -0500", hash_original_method = "DF65FA753319B9C502684E1A241A3191", hash_generated_method = "7BE5235DE18EAFA623725F269AEE58AB")
    
private static void logAndPrintError (PrintStream newStderr,
            String message, Throwable ex) {
        Log.e(TAG, message, ex);
        if (newStderr != null) {
            newStderr.println(message + (ex == null ? "" : ex));
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.764 -0500", hash_original_field = "CA9104072FF1AE74E9853C2A46401BC7", hash_generated_field = "2A664B91B7AF4DD6DD39F407BBDAB91B")

    private static final String TAG = "Zygote";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.767 -0500", hash_original_field = "D90492E3464ECC8A101F2656E4C9D75D", hash_generated_field = "80CAE96E8C1B0DF29A980BF5109CC5BF")

    private static final int[][] intArray2d = new int[0][0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.769 -0500", hash_original_field = "BADEA2C328058CA359AE2EA07658E5E2", hash_generated_field = "F25FDE7970276014B50B25B9CC13AA49")

    private static final int CONNECTION_TIMEOUT_MILLIS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.772 -0500", hash_original_field = "43B4EC4BBCF1F298EBE8BE4942A3F79C", hash_generated_field = "B23BA5B642881C70E30A38B20D6C2EA9")

    private static final int MAX_ZYGOTE_ARGC=1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.784 -0500", hash_original_field = "F3210BC41AFCDF095BD362F24468ABF5", hash_generated_field = "4F9908C941A92E3CBBEB2EF6B2065848")

    private static LocalSocket sPeerWaitSocket = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.775 -0500", hash_original_field = "6971E2A0D3E5B2508308ACDF0894CC71", hash_generated_field = "9F88E22AD28B44C4F3ABF7860B4C458C")

    private  LocalSocket mSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.777 -0500", hash_original_field = "2B75E28B7B18E7EBC34BF2567A2E9165", hash_generated_field = "A0824D1C247F56564C11BA8205E8EB5E")

    private  DataOutputStream mSocketOutStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.779 -0500", hash_original_field = "C6954FB8D5C54B2A5CAF0FC1A0241C98", hash_generated_field = "F0D2329C97964096148900E8F81E43EC")

    private  BufferedReader mSocketReader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.782 -0500", hash_original_field = "40FBD125B8108F3E5948443195F2405F", hash_generated_field = "B6123D5E946169D2772DFD87D959FEA7")

    private  Credentials peer;

    /**
     * Constructs instance from connected socket.
     *
     * @param socket non-null; connected socket
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.787 -0500", hash_original_method = "7184EAAE07D7B6F9BEC01EBE5F329335", hash_generated_method = "7184EAAE07D7B6F9BEC01EBE5F329335")
    
ZygoteConnection(LocalSocket socket) throws IOException {
        mSocket = socket;

        mSocketOutStream
                = new DataOutputStream(socket.getOutputStream());

        mSocketReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()), 256);

        mSocket.setSoTimeout(CONNECTION_TIMEOUT_MILLIS);
                
        try {
            peer = mSocket.getPeerCredentials();
        } catch (IOException ex) {
            Log.e(TAG, "Cannot read peer credentials", ex);
            throw ex;
        }
    }

    /**
     * Returns the file descriptor of the associated socket.
     *
     * @return null-ok; file descriptor
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.789 -0500", hash_original_method = "D031047267A17F3FBDEAA6E5A25F7FEC", hash_generated_method = "D031047267A17F3FBDEAA6E5A25F7FEC")
    
FileDescriptor getFileDesciptor() {
        return mSocket.getFileDescriptor();
    }

    /**
     * Reads start commands from an open command socket.
     * Start commands are presently a pair of newline-delimited lines
     * indicating a) class to invoke main() on b) nice name to set argv[0] to.
     * Continues to read commands and forkAndSpecialize children until
     * the socket is closed. This method is used in ZYGOTE_FORK_MODE
     *
     * @throws ZygoteInit.MethodAndArgsCaller trampoline to invoke main()
     * method in child process
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.792 -0500", hash_original_method = "D83ED9D59CE4DAAE3BDA7C68EE854B3C", hash_generated_method = "1AC9EAA50F6993A129EFED22FD356A19")
    
void run() throws ZygoteInit.MethodAndArgsCaller {

        int loopCount = ZygoteInit.GC_LOOP_COUNT;

        while (true) {
            /*
             * Call gc() before we block in readArgumentList().
             * It's work that has to be done anyway, and it's better
             * to avoid making every child do it.  It will also
             * madvise() any free memory as a side-effect.
             *
             * Don't call it every time, because walking the entire
             * heap is a lot of overhead to free a few hundred bytes.
             */
            if (loopCount <= 0) {
                ZygoteInit.gc();
                loopCount = ZygoteInit.GC_LOOP_COUNT;
            } else {
                loopCount--;
            }

            if (runOnce()) {
                break;
            }
        }
    }

    /**
     * Reads one start command from the command socket. If successful,
     * a child is forked and a {@link ZygoteInit.MethodAndArgsCaller}
     * exception is thrown in that child while in the parent process,
     * the method returns normally. On failure, the child is not
     * spawned and messages are printed to the log and stderr. Returns
     * a boolean status value indicating whether an end-of-file on the command
     * socket has been encountered.
     *
     * @return false if command socket should continue to be read from, or
     * true if an end-of-file has been encountered.
     * @throws ZygoteInit.MethodAndArgsCaller trampoline to invoke main()
     * method in child process
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.796 -0500", hash_original_method = "D76E963329652A6F2BCB5FE055E042D1", hash_generated_method = "54B63CBA7F76BDD313C56D3CB823D8C9")
    
boolean runOnce() throws ZygoteInit.MethodAndArgsCaller {

        String args[];
        Arguments parsedArgs = null;
        FileDescriptor[] descriptors;

        try {
            args = readArgumentList();
            descriptors = mSocket.getAncillaryFileDescriptors();
        } catch (IOException ex) {
            Log.w(TAG, "IOException on command socket " + ex.getMessage());
            closeSocket();
            return true;
        }

        if (args == null) {
            // EOF reached.
            closeSocket();
            return true;
        }

        /** the stderr of the most recent request, if avail */
        PrintStream newStderr = null;

        if (descriptors != null && descriptors.length >= 3) {
            newStderr = new PrintStream(
                    new FileOutputStream(descriptors[2]));
        }

        int pid = -1;
        FileDescriptor childPipeFd = null;
        FileDescriptor serverPipeFd = null;

        try {
            parsedArgs = new Arguments(args);

            applyUidSecurityPolicy(parsedArgs, peer);
            applyRlimitSecurityPolicy(parsedArgs, peer);
            applyCapabilitiesSecurityPolicy(parsedArgs, peer);
            applyInvokeWithSecurityPolicy(parsedArgs, peer);

            applyDebuggerSystemProperty(parsedArgs);
            applyInvokeWithSystemProperty(parsedArgs);

            int[][] rlimits = null;

            if (parsedArgs.rlimits != null) {
                rlimits = parsedArgs.rlimits.toArray(intArray2d);
            }

            if (parsedArgs.runtimeInit && parsedArgs.invokeWith != null) {
                FileDescriptor[] pipeFds = Libcore.os.pipe();
                childPipeFd = pipeFds[1];
                serverPipeFd = pipeFds[0];
                ZygoteInit.setCloseOnExec(serverPipeFd, true);
            }

            pid = Zygote.forkAndSpecialize(parsedArgs.uid, parsedArgs.gid,
                    parsedArgs.gids, parsedArgs.debugFlags, rlimits);
        } catch (IOException ex) {
            logAndPrintError(newStderr, "Exception creating pipe", ex);
        } catch (ErrnoException ex) {
            logAndPrintError(newStderr, "Exception creating pipe", ex);
        } catch (IllegalArgumentException ex) {
            logAndPrintError(newStderr, "Invalid zygote arguments", ex);
        } catch (ZygoteSecurityException ex) {
            logAndPrintError(newStderr,
                    "Zygote security policy prevents request: ", ex);
        }

        try {
            if (pid == 0) {
                // in child
                IoUtils.closeQuietly(serverPipeFd);
                serverPipeFd = null;
                handleChildProc(parsedArgs, descriptors, childPipeFd, newStderr);

                // should never get here, the child is expected to either
                // throw ZygoteInit.MethodAndArgsCaller or exec().
                return true;
            } else {
                // in parent...pid of < 0 means failure
                IoUtils.closeQuietly(childPipeFd);
                childPipeFd = null;
                return handleParentProc(pid, descriptors, serverPipeFd, parsedArgs);
            }
        } finally {
            IoUtils.closeQuietly(childPipeFd);
            IoUtils.closeQuietly(serverPipeFd);
        }
    }
    
    static class Arguments {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.802 -0500", hash_original_field = "8E7F39D78C11D0D620F5769854F95AD4", hash_generated_field = "8E7F39D78C11D0D620F5769854F95AD4")

        int uid = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.805 -0500", hash_original_field = "FCC687D32DCADE2501DFF90534FB8EB3", hash_generated_field = "FCC687D32DCADE2501DFF90534FB8EB3")

        boolean uidSpecified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.807 -0500", hash_original_field = "CD7DE07815123E8D5BDE5DC586F9E327", hash_generated_field = "CD7DE07815123E8D5BDE5DC586F9E327")

        int gid = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.811 -0500", hash_original_field = "7F9C72C3971857F2F2424F2876DDCB37", hash_generated_field = "7F9C72C3971857F2F2424F2876DDCB37")

        boolean gidSpecified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.814 -0500", hash_original_field = "54C577A65DD30DDDFB9215D4CF28DB70", hash_generated_field = "54C577A65DD30DDDFB9215D4CF28DB70")

        int[] gids;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.816 -0500", hash_original_field = "DE4E6DC7B42CB6C9AA9043942BF17F86", hash_generated_field = "DE4E6DC7B42CB6C9AA9043942BF17F86")

        boolean peerWait;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.819 -0500", hash_original_field = "EE1851787F428E476E8277578F17E703", hash_generated_field = "EE1851787F428E476E8277578F17E703")

        int debugFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.822 -0500", hash_original_field = "6C1842C610E85CE5AAB422B21DE084EE", hash_generated_field = "6C1842C610E85CE5AAB422B21DE084EE")

        int targetSdkVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.825 -0500", hash_original_field = "13C1E04054F8153548EFE0154E96AF4F", hash_generated_field = "13C1E04054F8153548EFE0154E96AF4F")

        boolean targetSdkVersionSpecified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.829 -0500", hash_original_field = "F6B99376C3175C909AAF68D121783067", hash_generated_field = "F6B99376C3175C909AAF68D121783067")

        String classpath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.833 -0500", hash_original_field = "83B5575B50DE1C2A124BAC34BDE96481", hash_generated_field = "83B5575B50DE1C2A124BAC34BDE96481")

        boolean runtimeInit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.836 -0500", hash_original_field = "A9B0553B8BC7AA374068697DA246A7A6", hash_generated_field = "A9B0553B8BC7AA374068697DA246A7A6")

        String niceName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.838 -0500", hash_original_field = "A6E797CB91748575747AFCEF1EFABE00", hash_generated_field = "A6E797CB91748575747AFCEF1EFABE00")

        boolean capabilitiesSpecified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.840 -0500", hash_original_field = "1953FB01473D5608C92B58749337D80F", hash_generated_field = "1953FB01473D5608C92B58749337D80F")

        long permittedCapabilities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.842 -0500", hash_original_field = "5B064209ACA1CCAE633A16D8D6ED5D7E", hash_generated_field = "5B064209ACA1CCAE633A16D8D6ED5D7E")

        long effectiveCapabilities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.845 -0500", hash_original_field = "6B6E7FE0066F3C40E26724314989FD1B", hash_generated_field = "6B6E7FE0066F3C40E26724314989FD1B")

        ArrayList<int[]> rlimits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.847 -0500", hash_original_field = "452A5731BC14408AF85FDFEF2F034B9D", hash_generated_field = "452A5731BC14408AF85FDFEF2F034B9D")

        String invokeWith;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.850 -0500", hash_original_field = "88B6A06E0D43FBF96C1153AEAB5C29CA", hash_generated_field = "88B6A06E0D43FBF96C1153AEAB5C29CA")

        String remainingArgs[];

        /**
         * Constructs instance and parses args
         * @param args zygote command-line args
         * @throws IllegalArgumentException
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.852 -0500", hash_original_method = "35BDC5101A4DE38616FDCE6EF4D8CA10", hash_generated_method = "35BDC5101A4DE38616FDCE6EF4D8CA10")
        
Arguments(String args[]) throws IllegalArgumentException {
            parseArgs(args);
        }

        /**
         * Parses the commandline arguments intended for the Zygote spawner
         * (such as "--setuid=" and "--setgid=") and creates an array
         * containing the remaining args.
         *
         * Per security review bug #1112214, duplicate args are disallowed in
         * critical cases to make injection harder.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.859 -0500", hash_original_method = "12134C3215A59528551E59AC16868712", hash_generated_method = "93EE9BCAF5076F45C58A977C9F074FBD")
        
private void parseArgs(String args[])
                throws IllegalArgumentException {
            int curArg = 0;

            for ( /* curArg */ ; curArg < args.length; curArg++) {
                String arg = args[curArg];

                if (arg.equals("--")) {
                    curArg++;
                    break;
                } else if (arg.startsWith("--setuid=")) {
                    if (uidSpecified) {
                        throw new IllegalArgumentException(
                                "Duplicate arg specified");
                    }
                    uidSpecified = true;
                    uid = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                } else if (arg.startsWith("--setgid=")) {
                    if (gidSpecified) {
                        throw new IllegalArgumentException(
                                "Duplicate arg specified");
                    }
                    gidSpecified = true;
                    gid = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                } else if (arg.startsWith("--target-sdk-version=")) {
                    if (targetSdkVersionSpecified) {
                        throw new IllegalArgumentException(
                                "Duplicate target-sdk-version specified");
                    }
                    targetSdkVersionSpecified = true;
                    targetSdkVersion = Integer.parseInt(
                            arg.substring(arg.indexOf('=') + 1));
                } else if (arg.equals("--enable-debugger")) {
                    debugFlags |= Zygote.DEBUG_ENABLE_DEBUGGER;
                } else if (arg.equals("--enable-safemode")) {
                    debugFlags |= Zygote.DEBUG_ENABLE_SAFEMODE;
                } else if (arg.equals("--enable-checkjni")) {
                    debugFlags |= Zygote.DEBUG_ENABLE_CHECKJNI;
                } else if (arg.equals("--enable-jni-logging")) {
                    debugFlags |= Zygote.DEBUG_ENABLE_JNI_LOGGING;
                } else if (arg.equals("--enable-assert")) {
                    debugFlags |= Zygote.DEBUG_ENABLE_ASSERT;
                } else if (arg.equals("--peer-wait")) {
                    peerWait = true;
                } else if (arg.equals("--runtime-init")) {
                    runtimeInit = true;
                } else if (arg.startsWith("--capabilities=")) {
                    if (capabilitiesSpecified) {
                        throw new IllegalArgumentException(
                                "Duplicate arg specified");
                    }
                    capabilitiesSpecified = true;
                    String capString = arg.substring(arg.indexOf('=')+1);

                    String[] capStrings = capString.split(",", 2);

                    if (capStrings.length == 1) {
                        effectiveCapabilities = Long.decode(capStrings[0]);
                        permittedCapabilities = effectiveCapabilities;
                    } else {
                        permittedCapabilities = Long.decode(capStrings[0]);
                        effectiveCapabilities = Long.decode(capStrings[1]);
                    }
                } else if (arg.startsWith("--rlimit=")) {
                    // Duplicate --rlimit arguments are specifically allowed.
                    String[] limitStrings
                            = arg.substring(arg.indexOf('=')+1).split(",");

                    if (limitStrings.length != 3) {
                        throw new IllegalArgumentException(
                                "--rlimit= should have 3 comma-delimited ints");
                    }
                    int[] rlimitTuple = new int[limitStrings.length];

                    for(int i=0; i < limitStrings.length; i++) {
                        rlimitTuple[i] = Integer.parseInt(limitStrings[i]);
                    }

                    if (rlimits == null) {
                        rlimits = new ArrayList();
                    }

                    rlimits.add(rlimitTuple);
                } else if (arg.equals("-classpath")) {
                    if (classpath != null) {
                        throw new IllegalArgumentException(
                                "Duplicate arg specified");
                    }
                    try {
                        classpath = args[++curArg];
                    } catch (IndexOutOfBoundsException ex) {
                        throw new IllegalArgumentException(
                                "-classpath requires argument");
                    }
                } else if (arg.startsWith("--setgroups=")) {
                    if (gids != null) {
                        throw new IllegalArgumentException(
                                "Duplicate arg specified");
                    }

                    String[] params
                            = arg.substring(arg.indexOf('=') + 1).split(",");

                    gids = new int[params.length];

                    for (int i = params.length - 1; i >= 0 ; i--) {
                        gids[i] = Integer.parseInt(params[i]);
                    }
                } else if (arg.equals("--invoke-with")) {
                    if (invokeWith != null) {
                        throw new IllegalArgumentException(
                                "Duplicate arg specified");
                    }
                    try {
                        invokeWith = args[++curArg];
                    } catch (IndexOutOfBoundsException ex) {
                        throw new IllegalArgumentException(
                                "--invoke-with requires argument");
                    }
                } else if (arg.startsWith("--nice-name=")) {
                    if (niceName != null) {
                        throw new IllegalArgumentException(
                                "Duplicate arg specified");
                    }
                    niceName = arg.substring(arg.indexOf('=') + 1);
                } else {
                    break;
                }
            }

            if (runtimeInit && classpath != null) {
                throw new IllegalArgumentException(
                        "--runtime-init and -classpath are incompatible");
            }

            remainingArgs = new String[args.length - curArg];

            System.arraycopy(args, curArg, remainingArgs, 0,
                    remainingArgs.length);
        }
        
    }

    /**
     * Closes socket associated with this connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.799 -0500", hash_original_method = "5A630DC8DA41E048830D803B657E049B", hash_generated_method = "5A630DC8DA41E048830D803B657E049B")
    
void closeSocket() {
        try {
            mSocket.close();
        } catch (IOException ex) {
            Log.e(TAG, "Exception while closing command "
                    + "socket in parent", ex);
        }
    }

    /**
     * Reads an argument list from the command socket/
     * @return Argument list or null if EOF is reached
     * @throws IOException passed straight through
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.865 -0500", hash_original_method = "366F843C8FBE8BB09896187A9CDF1388", hash_generated_method = "4859A824ABAA5B362F6D19FCD2E6553C")
    
private String[] readArgumentList()
            throws IOException {

        /**
         * See android.os.Process.zygoteSendArgsAndGetPid()
         * Presently the wire format to the zygote process is:
         * a) a count of arguments (argc, in essence)
         * b) a number of newline-separated argument strings equal to count
         *
         * After the zygote process reads these it will write the pid of
         * the child or -1 on failure.
         */

        int argc;

        try {
            String s = mSocketReader.readLine();

            if (s == null) {
                // EOF reached.
                return null;
            }
            argc = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            Log.e(TAG, "invalid Zygote wire format: non-int at argc");
            throw new IOException("invalid wire format");
        }

        // See bug 1092107: large argc can be used for a DOS attack
        if (argc > MAX_ZYGOTE_ARGC) {   
            throw new IOException("max arg count exceeded");
        }

        String[] result = new String[argc];
        for (int i = 0; i < argc; i++) {
            result[i] = mSocketReader.readLine();
            if (result[i] == null) {
                // We got an unexpected EOF.
                throw new IOException("truncated request");
            }
        }

        return result;
    }

    /**
     * Handles post-fork setup of child proc, closing sockets as appropriate,
     * reopen stdio as appropriate, and ultimately throwing MethodAndArgsCaller
     * if successful or returning if failed.
     *
     * @param parsedArgs non-null; zygote args
     * @param descriptors null-ok; new file descriptors for stdio if available.
     * @param pipeFd null-ok; pipe for communication back to Zygote.
     * @param newStderr null-ok; stream to use for stderr until stdio
     * is reopened.
     *
     * @throws ZygoteInit.MethodAndArgsCaller on success to
     * trampoline to code that invokes static main.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.885 -0500", hash_original_method = "D56D87B601F5E5F24F9D8C0DB423B19E", hash_generated_method = "D8364B9C65435399E437E4C6B080D315")
    
private void handleChildProc(Arguments parsedArgs,
            FileDescriptor[] descriptors, FileDescriptor pipeFd, PrintStream newStderr)
            throws ZygoteInit.MethodAndArgsCaller {

        /*
         * Close the socket, unless we're in "peer wait" mode, in which
         * case it's used to track the liveness of this process.
         */

        if (parsedArgs.peerWait) {
            try {
                ZygoteInit.setCloseOnExec(mSocket.getFileDescriptor(), true);
                sPeerWaitSocket = mSocket;
            } catch (IOException ex) {
                Log.e(TAG, "Zygote Child: error setting peer wait "
                        + "socket to be close-on-exec", ex);
            }
        } else {
            closeSocket();
            ZygoteInit.closeServerSocket();
        }

        if (descriptors != null) {
            try {
                ZygoteInit.reopenStdio(descriptors[0],
                        descriptors[1], descriptors[2]);

                for (FileDescriptor fd: descriptors) {
                    IoUtils.closeQuietly(fd);
                }
                newStderr = System.err;
            } catch (IOException ex) {
                Log.e(TAG, "Error reopening stdio", ex);
            }
        }

        if (parsedArgs.niceName != null) {
            Process.setArgV0(parsedArgs.niceName);
        }

        if (parsedArgs.runtimeInit) {
            if (parsedArgs.invokeWith != null) {
                WrapperInit.execApplication(parsedArgs.invokeWith,
                        parsedArgs.niceName, parsedArgs.targetSdkVersion,
                        pipeFd, parsedArgs.remainingArgs);
            } else {
                RuntimeInit.zygoteInit(parsedArgs.targetSdkVersion,
                        parsedArgs.remainingArgs);
            }
        } else {
            String className;
            try {
                className = parsedArgs.remainingArgs[0];
            } catch (ArrayIndexOutOfBoundsException ex) {
                logAndPrintError(newStderr,
                        "Missing required class name argument", null);
                return;
            }

            String[] mainArgs = new String[parsedArgs.remainingArgs.length - 1];
            System.arraycopy(parsedArgs.remainingArgs, 1,
                    mainArgs, 0, mainArgs.length);

            if (parsedArgs.invokeWith != null) {
                WrapperInit.execStandalone(parsedArgs.invokeWith,
                        parsedArgs.classpath, className, mainArgs);
            } else {
                ClassLoader cloader;
                if (parsedArgs.classpath != null) {
                    cloader = new PathClassLoader(parsedArgs.classpath,
                            ClassLoader.getSystemClassLoader());
                } else {
                    cloader = ClassLoader.getSystemClassLoader();
                }

                try {
                    ZygoteInit.invokeStaticMain(cloader, className, mainArgs);
                } catch (RuntimeException ex) {
                    logAndPrintError(newStderr, "Error starting.", ex);
                }
            }
        }
    }

    /**
     * Handles post-fork cleanup of parent proc
     *
     * @param pid != 0; pid of child if &gt; 0 or indication of failed fork
     * if &lt; 0;
     * @param descriptors null-ok; file descriptors for child's new stdio if
     * specified.
     * @param pipeFd null-ok; pipe for communication with child.
     * @param parsedArgs non-null; zygote args
     * @return true for "exit command loop" and false for "continue command
     * loop"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.888 -0500", hash_original_method = "3D3F8EE18B5CE9AC13BB6381C124884E", hash_generated_method = "3D5BAD4397EDF17631B025110C08CA48")
    
private boolean handleParentProc(int pid,
            FileDescriptor[] descriptors, FileDescriptor pipeFd, Arguments parsedArgs) {

        if (pid > 0) {
            setChildPgid(pid);
        }

        if (descriptors != null) {
            for (FileDescriptor fd: descriptors) {
                IoUtils.closeQuietly(fd);
            }
        }

        boolean usingWrapper = false;
        if (pipeFd != null && pid > 0) {
            DataInputStream is = new DataInputStream(new FileInputStream(pipeFd));
            int innerPid = -1;
            try {
                innerPid = is.readInt();
            } catch (IOException ex) {
                Log.w(TAG, "Error reading pid from wrapped process, child may have died", ex);
            } finally {
                try {
                    is.close();
                } catch (IOException ex) {
                }
            }

            // Ensure that the pid reported by the wrapped process is either the
            // child process that we forked, or a descendant of it.
            if (innerPid > 0) {
                int parentPid = innerPid;
                while (parentPid > 0 && parentPid != pid) {
                    parentPid = Process.getParentPid(parentPid);
                }
                if (parentPid > 0) {
                    Log.i(TAG, "Wrapped process has pid " + innerPid);
                    pid = innerPid;
                    usingWrapper = true;
                } else {
                    Log.w(TAG, "Wrapped process reported a pid that is not a child of "
                            + "the process that we forked: childPid=" + pid
                            + " innerPid=" + innerPid);
                }
            }
        }

        try {
            mSocketOutStream.writeInt(pid);
            mSocketOutStream.writeBoolean(usingWrapper);
        } catch (IOException ex) {
            Log.e(TAG, "Error reading from command socket", ex);
            return true;
        }

        /*
         * If the peer wants to use the socket to wait on the
         * newly spawned process, then we're all done.
         */
        if (parsedArgs.peerWait) {
            try {
                mSocket.close();
            } catch (IOException ex) {
                Log.e(TAG, "Zygote: error closing sockets", ex);
            }
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.892 -0500", hash_original_method = "A5A16DB5966812C0B6C21E171E7DEF94", hash_generated_method = "D1E829C404BF83AEF9B86E3EC545510C")
    
private void setChildPgid(int pid) {
        // Try to move the new child into the peer's process group.
        try {
            ZygoteInit.setpgid(pid, ZygoteInit.getpgid(peer.getPid()));
        } catch (IOException ex) {
            // This exception is expected in the case where
            // the peer is not in our session
            // TODO get rid of this log message in the case where
            // getsid(0) != getsid(peer.getPid())
            Log.i(TAG, "Zygote: setpgid failed. This is "
                + "normal if peer is not in our session");
        }
    }
}

