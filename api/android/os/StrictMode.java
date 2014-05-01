package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import android.animation.ValueAnimator;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.ApplicationErrorReport;
import android.app.IActivityManager;
import android.content.Intent;
import android.util.Log;
import android.util.Printer;
import android.util.Singleton;
import android.view.IWindowManager;

import com.android.internal.os.RuntimeInit;

import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import dalvik.system.VMDebug;

public final class StrictMode {

    /**
     * Sets the policy for what actions on the current thread should
     * be detected, as well as the penalty if such actions occur.
     *
     * <p>Internally this sets a thread-local variable which is
     * propagated across cross-process IPC calls, meaning you can
     * catch violations when a system service or another process
     * accesses the disk or network on your behalf.
     *
     * @param policy the policy to put into place
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.087 -0500", hash_original_method = "EAF2550D78E81A3AE328ECCA2D8E112F", hash_generated_method = "5A09CA60BA8E320D1EB7DAC5A9D7D786")
    
public static void setThreadPolicy(final ThreadPolicy policy) {
        // setThreadPolicyMask(policy.mask);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.090 -0500", hash_original_method = "E103159859299A70CFA6BDDF6D97BFB9", hash_generated_method = "64B3CD68640DDC6DAF70F01107CD41E0")
    
private static void setThreadPolicyMask(final int policyMask) {
        // In addition to the Java-level thread-local in Dalvik's
        // BlockGuard, we also need to keep a native thread-local in
        // Binder in order to propagate the value across Binder calls,
        // even across native-only processes.  The two are kept in
        // sync via the callback to onStrictModePolicyChange, below.
/*        setBlockGuardPolicy(policyMask);

        // And set the Android native version...
        Binder.setThreadStrictModePolicy(policyMask);*/
    }

    // Sets the policy in Dalvik/libcore (BlockGuard)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.092 -0500", hash_original_method = "621EB7D543F59B08E720C397686C01C7", hash_generated_method = "0C67E320A9DC44A23CD56A5FF63141B2")
    
private static void setBlockGuardPolicy(final int policyMask) {
/*        if (policyMask == 0) {
            BlockGuard.setThreadPolicy(BlockGuard.LAX_POLICY);
            return;
        }
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            BlockGuard.setThreadPolicy(new AndroidBlockGuardPolicy(policyMask));
        } else {
            AndroidBlockGuardPolicy androidPolicy = (AndroidBlockGuardPolicy) policy;
            androidPolicy.setPolicyMask(policyMask);
        }*/
    }

    // Sets up CloseGuard in Dalvik/libcore
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.094 -0500", hash_original_method = "A91AC5C680257C159878619FE045BB6E", hash_generated_method = "69E0B6702899716DD5BEDDAA8C84C9A9")
    
private static void setCloseGuardEnabled(boolean enabled) {
/*        if (!(CloseGuard.getReporter() instanceof AndroidCloseGuardReporter)) {
            CloseGuard.setReporter(new AndroidCloseGuardReporter());
        }
        CloseGuard.setEnabled(enabled);*/
    }

    /**
     * Returns the bitmask of the current thread's policy.
     *
     * @return the bitmask of all the DETECT_* and PENALTY_* bits currently enabled
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.120 -0500", hash_original_method = "846C0C89D35574B87DE239A886F76A3A", hash_generated_method = "DC71E2C046BD1C5E6C2EF35BD28B7815")
    
public static int getThreadPolicyMask() {
        //return BlockGuard.getThreadPolicy().getPolicyMask();
        return DSUtils.UNKNOWN_INT;
    }

    /**
     * Returns the current thread's policy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.122 -0500", hash_original_method = "B16B97050DB3110BD56237B889C54726", hash_generated_method = "1D6EE75000080668870997AC8B0370C6")
    
public static ThreadPolicy getThreadPolicy() {
        // TODO: this was a last minute Gingerbread API change (to
        // introduce VmPolicy cleanly) but this isn't particularly
        // optimal for users who might call this method often.  This
        // should be in a thread-local and not allocate on each call.
        return new ThreadPolicy(getThreadPolicyMask());
    }

    /**
     * A convenience wrapper that takes the current
     * {@link ThreadPolicy} from {@link #getThreadPolicy}, modifies it
     * to permit both disk reads &amp; writes, and sets the new policy
     * with {@link #setThreadPolicy}, returning the old policy so you
     * can restore it at the end of a block.
     *
     * @return the old policy, to be passed to {@link #setThreadPolicy} to
     *         restore the policy at the end of a block
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.125 -0500", hash_original_method = "F942EE5DD2312CA96489AB4B4ACB1570", hash_generated_method = "ED8585635C06544393EACEC3BE69878D")
    
public static ThreadPolicy allowThreadDiskWrites() {
        int oldPolicyMask = getThreadPolicyMask();
        int newPolicyMask = oldPolicyMask & ~(DETECT_DISK_WRITE | DETECT_DISK_READ);
        if (newPolicyMask != oldPolicyMask) {
            setThreadPolicyMask(newPolicyMask);
        }
        return new ThreadPolicy(oldPolicyMask);
    }

    /**
     * A convenience wrapper that takes the current
     * {@link ThreadPolicy} from {@link #getThreadPolicy}, modifies it
     * to permit disk reads, and sets the new policy
     * with {@link #setThreadPolicy}, returning the old policy so you
     * can restore it at the end of a block.
     *
     * @return the old policy, to be passed to setThreadPolicy to
     *         restore the policy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.127 -0500", hash_original_method = "22603A4E5136644C5946CA9D6D1AB7B2", hash_generated_method = "8F75F72036EB9B28A87868A9139A6199")
    
public static ThreadPolicy allowThreadDiskReads() {
        int oldPolicyMask = getThreadPolicyMask();
        int newPolicyMask = oldPolicyMask & ~(DETECT_DISK_READ);
        if (newPolicyMask != oldPolicyMask) {
            setThreadPolicyMask(newPolicyMask);
        }
        return new ThreadPolicy(oldPolicyMask);
    }

    // We don't want to flash the screen red in the system server
    // process, nor do we want to modify all the call sites of
    // conditionallyEnableDebugLogging() in the system server,
    // so instead we use this to determine if we are the system server.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.129 -0500", hash_original_method = "13EE91C23AA3A16D1C05B9C12BE22DBD", hash_generated_method = "AFC78790EC21E917F2FB96DCEBE01755")
    
private static boolean amTheSystemServerProcess() {
     /*   // Fast path.  Most apps don't have the system server's UID.
        if (Process.myUid() != Process.SYSTEM_UID) {
            return false;
        }

        // The settings app, though, has the system server's UID so
        // look up our stack to see if we came from the system server.
        Throwable stack = new Throwable();
        stack.fillInStackTrace();
        for (StackTraceElement ste : stack.getStackTrace()) {
            String clsName = ste.getClassName();
            if (clsName != null && clsName.startsWith("com.android.server.")) {
                return true;
            }
        }
        return false;*/
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    /**
     * Enable DropBox logging for debug phone builds.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.133 -0500", hash_original_method = "052278CA509C38C507499B2FA93CCBD3", hash_generated_method = "6360FD2ACFB7F3B7EF98972CB440886C")
    
public static boolean conditionallyEnableDebugLogging() {
       /* boolean doFlashes = SystemProperties.getBoolean(VISUAL_PROPERTY, false)
                && !amTheSystemServerProcess();
        final boolean suppress = SystemProperties.getBoolean(DISABLE_PROPERTY, false);

        // For debug builds, log event loop stalls to dropbox for analysis.
        // Similar logic also appears in ActivityThread.java for system apps.
        if (!doFlashes && (IS_USER_BUILD || suppress)) {
            setCloseGuardEnabled(false);
            return false;
        }

        // Eng builds have flashes on all the time.  The suppression property
        // overrides this, so we force the behavior only after the short-circuit
        // check above.
        if (IS_ENG_BUILD) {
            doFlashes = true;
        }

        // Thread policy controls BlockGuard.
        int threadPolicyMask = StrictMode.DETECT_DISK_WRITE |
                StrictMode.DETECT_DISK_READ |
                StrictMode.DETECT_NETWORK;

        if (!IS_USER_BUILD) {
            threadPolicyMask |= StrictMode.PENALTY_DROPBOX;
        }
        if (doFlashes) {
            threadPolicyMask |= StrictMode.PENALTY_FLASH;
        }

        StrictMode.setThreadPolicyMask(threadPolicyMask);

        // VM Policy controls CloseGuard, detection of Activity leaks,
        // and instance counting.
        if (IS_USER_BUILD) {
            setCloseGuardEnabled(false);
        } else {
            VmPolicy.Builder policyBuilder = new VmPolicy.Builder().detectAll().penaltyDropBox();
            if (IS_ENG_BUILD) {
                policyBuilder.penaltyLog();
            }
            setVmPolicy(policyBuilder.build());
            setCloseGuardEnabled(vmClosableObjectLeaksEnabled());
        }
        return true;
        */
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    /**
     * Used by the framework to make network usage on the main
     * thread a fatal error.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.135 -0500", hash_original_method = "511C5822AAD77FC3309E37C883E816C8", hash_generated_method = "943148D2FBAAAB0DE8F1927558795D9F")
    
public static void enableDeathOnNetwork() {
      /*  int oldPolicy = getThreadPolicyMask();
        int newPolicy = oldPolicy | DETECT_NETWORK | PENALTY_DEATH_ON_NETWORK;
        setThreadPolicyMask(newPolicy);*/
    }

    /**
     * Parses the BlockGuard policy mask out from the Exception's
     * getMessage() String value.  Kinda gross, but least
     * invasive.  :/
     *
     * Input is of the following forms:
     *     "policy=137 violation=64"
     *     "policy=137 violation=64 msg=Arbitrary text"
     *
     * Returns 0 on failure, which is a valid policy, but not a
     * valid policy during a violation (else there must've been
     * some policy in effect to violate).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.138 -0500", hash_original_method = "505B6F2C5D14D5307D2792E4869F206A", hash_generated_method = "B2A8BE88A07C1CCC431566DDEBE0F08C")
    
private static int parsePolicyFromMessage(String message) {
/*        
        if (message == null || !message.startsWith("policy=")) {
            return 0;
        }
        int spaceIndex = message.indexOf(' ');
        if (spaceIndex == -1) {
            return 0;
        }
        String policyString = message.substring(7, spaceIndex);
        try {
            return Integer.valueOf(policyString).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }*/
        
        return message.getTaintInt();
    }

    /**
     * Like parsePolicyFromMessage(), but returns the violation.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.141 -0500", hash_original_method = "45B3269BE626BB87F4C05CA0ACD29C39", hash_generated_method = "4CCEDD75E9105676A0753C8872D2F662")
    
private static int parseViolationFromMessage(String message) {
        return message.getTaintInt();
/*        if (message == null) {
            return 0;
        }
        int violationIndex = message.indexOf("violation=");
        if (violationIndex == -1) {
            return 0;
        }
        int numberStartIndex = violationIndex + "violation=".length();
        int numberEndIndex = message.indexOf(' ', numberStartIndex);
        if (numberEndIndex == -1) {
            numberEndIndex = message.length();
        }
        String violationString = message.substring(numberStartIndex, numberEndIndex);
        try {
            return Integer.valueOf(violationString).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }*/
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.153 -0500", hash_original_method = "30484C59249AAEAE6E097D020A18B06F", hash_generated_method = "37F8ED1F104DFF04041FDF639CA6DE3E")
    
private static boolean tooManyViolationsThisLoop() {
        //return violationsBeingTimed.get().size() >= MAX_OFFENSES_PER_LOOP;

        return DSUtils.UNKNOWN_BOOLEAN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.203 -0500", hash_original_method = "D57761C9E43274832734BB25E55BB64E", hash_generated_method = "C76AA26C9CA762FACBC9B4EACDE82B97")
    
private static void executeDeathPenalty(ViolationInfo info) {
/*        int violationBit = parseViolationFromMessage(info.crashInfo.exceptionMessage);
        throw new StrictModeViolation(info.policy, violationBit, null);*/
    }
    
    private static void dropboxViolationAsync(
            final int violationMaskSubset, final ViolationInfo info) {
        int outstanding = sDropboxCallsInFlight.incrementAndGet();
        if (outstanding > 20) {
            sDropboxCallsInFlight.decrementAndGet();
            return;
        }
        if (LOG_V) Log.d(TAG, "Dropboxing async; in-flight=" + outstanding);
        new Thread("callActivityManagerForStrictModeDropbox") {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.208 -0500", hash_original_method = "A4F5F0C630DDC56879B6C50BF9886A5C", hash_generated_method = "BEB9A55813FA8C46E1F0C1241E1028D2")
            
public void run() {
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                try {
                    IActivityManager am = ActivityManagerNative.getDefault();
                    if (am == null) {
                        Log.d(TAG, "No activity manager; failed to Dropbox violation.");
                    } else {
                        am.handleApplicationStrictModeViolation(
                            RuntimeInit.getApplicationObject(),
                            violationMaskSubset,
                            info);
                    }
                } catch (RemoteException e) {
                    Log.e(TAG, "RemoteException handling StrictMode violation", e);
                }
                int outstanding = sDropboxCallsInFlight.decrementAndGet();
                if (LOG_V) Log.d(TAG, "Dropbox complete; in-flight=" + outstanding);
            }
        }.start();
    }

    /**
     * Called from Parcel.writeNoException()
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.217 -0500", hash_original_method = "DE6218951D49C9DECACECFC904F7F4CB", hash_generated_method = "254D6A055CF39186CE308B0510685D6F")
    
static boolean hasGatheredViolations() {
        return gatheredViolations.get() != null;
    }

    /**
     * Called from Parcel.writeException(), so we drop this memory and
     * don't incorrectly attribute it to the wrong caller on the next
     * Binder call on this thread.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.219 -0500", hash_original_method = "9805B7FF3BAD48B8D2DE0E62F52A36CA", hash_generated_method = "C424A8BDBD8B97D664023DF9B1CDBC17")
    
static void clearGatheredViolations() {
        gatheredViolations.set(null);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.222 -0500", hash_original_method = "C576A675E231D1AF2242B014415FC93D", hash_generated_method = "85661FFE999164B8940EC2E4934E174F")
    
public static void conditionallyCheckInstanceCounts() {
        VmPolicy policy = getVmPolicy();
        if (policy.classInstanceLimit.size() == 0) {
            return;
        }
        Runtime.getRuntime().gc();
        // Note: classInstanceLimit is immutable, so this is lock-free
        for (Map.Entry<Class, Integer> entry : policy.classInstanceLimit.entrySet()) {
            Class klass = entry.getKey();
            int limit = entry.getValue();
            long instances = VMDebug.countInstancesOfClass(klass, false);
            if (instances <= limit) {
                continue;
            }
            Throwable tr = new InstanceCountViolation(klass, instances, limit);
            onVmPolicyViolation(tr.getMessage(), tr);
        }
    }

    /**
     * Sets the policy for what actions in the VM process (on any
     * thread) should be detected, as well as the penalty if such
     * actions occur.
     *
     * @param policy the policy to put into place
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.235 -0500", hash_original_method = "4D7C8157BEE5C8ED378B4CE9D63026A6", hash_generated_method = "CF8E39CD834057B25689B88DE35EE11E")
    
public static void setVmPolicy(final VmPolicy policy) {
        synchronized (StrictMode.class) {
            sVmPolicy = policy;
            sVmPolicyMask = policy.mask;
           /* setCloseGuardEnabled(vmClosableObjectLeaksEnabled());

            Looper looper = Looper.getMainLooper();
            if (looper != null) {
                MessageQueue mq = looper.mQueue;
                if (policy.classInstanceLimit.size() == 0 ||
                    (sVmPolicyMask & VM_PENALTY_MASK) == 0) {
                    mq.removeIdleHandler(sProcessIdleHandler);
                    sIsIdlerRegistered = false;
                } else if (!sIsIdlerRegistered) {
                    mq.addIdleHandler(sProcessIdleHandler);
                    sIsIdlerRegistered = true;
                }
            }*/
        }
    }

    /**
     * Gets the current VM policy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.238 -0500", hash_original_method = "773AC5E4A26A865807C4BE06BCEDFBE0", hash_generated_method = "BAC368470A9B79BBED3EFE65DCDDE574")
    
public static VmPolicy getVmPolicy() {
        synchronized (StrictMode.class) {
            return sVmPolicy;
        }
    }

    /**
     * Enable the recommended StrictMode defaults, with violations just being logged.
     *
     * <p>This catches disk and network access on the main thread, as
     * well as leaked SQLite cursors and unclosed resources.  This is
     * simply a wrapper around {@link #setVmPolicy} and {@link
     * #setThreadPolicy}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.241 -0500", hash_original_method = "E2B8E9CB6BAF69ECC897B9026B7DFBD5", hash_generated_method = "9B316586E332C50571E57B05AC7C4332")
    
public static void enableDefaults() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                                   .detectAll()
                                   .penaltyLog()
                                   .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                               .detectAll()
                               .penaltyLog()
                               .build());
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.243 -0500", hash_original_method = "825007825C279D8D60066439CEB862D6", hash_generated_method = "0ACE2A786233EF90D83D444D5714465F")
    
public static boolean vmSqliteObjectLeaksEnabled() {
        return (sVmPolicyMask & DETECT_VM_CURSOR_LEAKS) != 0;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.245 -0500", hash_original_method = "00BE297DAE272F1287785C1C4E3D4CA4", hash_generated_method = "DBE6179150F20B8185E35558E4A3B09A")
    
public static boolean vmClosableObjectLeaksEnabled() {
        return (sVmPolicyMask & DETECT_VM_CLOSABLE_LEAKS) != 0;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.247 -0500", hash_original_method = "5F852AAD19A1F9B4EA699DB4FBF77E9F", hash_generated_method = "635C1F2B4BF370F7FA804D332EF0693F")
    
public static void onSqliteObjectLeaked(String message, Throwable originStack) {
        onVmPolicyViolation(message, originStack);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.249 -0500", hash_original_method = "4857C9DB572D29FDFE605B2B1ACB6FB5", hash_generated_method = "E2852C59B79F3533902847B8E033E255")
    
public static void onWebViewMethodCalledOnWrongThread(Throwable originStack) {
        onVmPolicyViolation(null, originStack);
    }

    /**
     * @hide
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.256 -0500", hash_original_method = "3BA160C791F73BC1B2756430F54D7253", hash_generated_method = "84C7935E4E3FABBD05E1556FC7CE4E7E")
    
public static void onVmPolicyViolation(String message, Throwable originStack) {
       /* final boolean penaltyDropbox = (sVmPolicyMask & PENALTY_DROPBOX) != 0;
        final boolean penaltyDeath = (sVmPolicyMask & PENALTY_DEATH) != 0;
        final boolean penaltyLog = (sVmPolicyMask & PENALTY_LOG) != 0;
        final ViolationInfo info = new ViolationInfo(originStack, sVmPolicyMask);

        // Erase stuff not relevant for process-wide violations
        info.numAnimationsRunning = 0;
        info.tags = null;
        info.broadcastIntentAction = null;

        final Integer fingerprint = info.hashCode();
        final long now = SystemClock.uptimeMillis();
        long lastViolationTime = 0;
        long timeSinceLastViolationMillis = Long.MAX_VALUE;
        synchronized (sLastVmViolationTime) {
            if (sLastVmViolationTime.containsKey(fingerprint)) {
                lastViolationTime = sLastVmViolationTime.get(fingerprint);
                timeSinceLastViolationMillis = now - lastViolationTime;
            }
            if (timeSinceLastViolationMillis > MIN_LOG_INTERVAL_MS) {
                sLastVmViolationTime.put(fingerprint, now);
            }
        }

        if (penaltyLog && timeSinceLastViolationMillis > MIN_LOG_INTERVAL_MS) {
            Log.e(TAG, message, originStack);
        }

        int violationMaskSubset = PENALTY_DROPBOX | (ALL_VM_DETECT_BITS & sVmPolicyMask);

        if (penaltyDropbox && !penaltyDeath) {
            // Common case for userdebug/eng builds.  If no death and
            // just dropboxing, we can do the ActivityManager call
            // asynchronously.
            dropboxViolationAsync(violationMaskSubset, info);
            return;
        }

        if (penaltyDropbox && lastViolationTime == 0) {
            // The violationMask, passed to ActivityManager, is a
            // subset of the original StrictMode policy bitmask, with
            // only the bit violated and penalty bits to be executed
            // by the ActivityManagerService remaining set.
            final int savedPolicyMask = getThreadPolicyMask();
            try {
                // First, remove any policy before we call into the Activity Manager,
                // otherwise we'll infinite recurse as we try to log policy violations
                // to disk, thus violating policy, thus requiring logging, etc...
                // We restore the current policy below, in the finally block.
                setThreadPolicyMask(0);

                ActivityManagerNative.getDefault().handleApplicationStrictModeViolation(
                    RuntimeInit.getApplicationObject(),
                    violationMaskSubset,
                    info);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException trying to handle StrictMode violation", e);
            } finally {
                // Restore the policy.
                setThreadPolicyMask(savedPolicyMask);
            }
        }

        if (penaltyDeath) {
            System.err.println("StrictMode VmPolicy violation with POLICY_DEATH; shutting down.");
            Process.killProcess(Process.myPid());
            System.exit(10);
        }*/
    }

    /**
     * Called from Parcel.writeNoException()
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.258 -0500", hash_original_method = "988356C76891278DCB1E6DF1B3D94941", hash_generated_method = "8DC97790E2EB719FA56E8E8D7CD81CAD")
    
static void writeGatheredViolationsToParcel(Parcel p) {
        ArrayList<ViolationInfo> violations = gatheredViolations.get();
        if (violations == null) {
            p.writeInt(0);
        } else {
            p.writeInt(violations.size());
            for (int i = 0; i < violations.size(); ++i) {
                violations.get(i).writeToParcel(p, 0 /* unused flags? */);
            }
            if (LOG_V) Log.d(TAG, "wrote violations to response parcel; num=" + violations.size());
            violations.clear(); // somewhat redundant, as we're about to null the threadlocal
        }
        gatheredViolations.set(null);
    }

    /**
     * Called from Parcel.readException() when the exception is EX_STRICT_MODE_VIOLATIONS,
     * we here read back all the encoded violations.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.263 -0500", hash_original_method = "85F9A054AA9529578DD28AD736197991", hash_generated_method = "BC279CCB9515367DC19E181BF23167FA")
    
static void readAndHandleBinderCallViolations(Parcel p) {
        // Our own stack trace to append
        StringWriter sw = new StringWriter();
        new LogStackTrace().printStackTrace(new PrintWriter(sw));
        String ourStack = sw.toString();

        int policyMask = getThreadPolicyMask();
        boolean currentlyGathering = (policyMask & PENALTY_GATHER) != 0;

        int numViolations = p.readInt();
        for (int i = 0; i < numViolations; ++i) {
            if (LOG_V) Log.d(TAG, "strict mode violation stacks read from binder call.  i=" + i);
            ViolationInfo info = new ViolationInfo(p, !currentlyGathering);
            info.crashInfo.stackTrace += "# via Binder call with stack:\n" + ourStack;
            BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
            if (policy instanceof AndroidBlockGuardPolicy) {
                ((AndroidBlockGuardPolicy) policy).handleViolationWithTimingAttempt(info);
            }
        }
    }

    /**
     * Called from android_util_Binder.cpp's
     * android_os_Parcel_enforceInterface when an incoming Binder call
     * requires changing the StrictMode policy mask.  The role of this
     * function is to ask Binder for its current (native) thread-local
     * policy value and synchronize it to libcore's (Java)
     * thread-local policy value.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.266 -0500", hash_original_method = "60E245C2A53AD4DE6244FC5F357660C8", hash_generated_method = "78945C81B34F3347D4044B647EE36D37")
    
private static void onBinderStrictModePolicyChange(int newPolicy) {
        setBlockGuardPolicy(newPolicy);
    }

    /**
     * Enter a named critical span (e.g. an animation)
     *
     * <p>The name is an arbitary label (or tag) that will be applied
     * to any strictmode violation that happens while this span is
     * active.  You must call finish() on the span when done.
     *
     * <p>This will never return null, but on devices without debugging
     * enabled, this may return a dummy object on which the finish()
     * method is a no-op.
     *
     * <p>TODO: add CloseGuard to this, verifying callers call finish.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.319 -0500", hash_original_method = "26856C2649829AA4775248F490BA34F6", hash_generated_method = "45AC9AC605902A3D5064001E26645581")
    
public static Span enterCriticalSpan(String name) {
        if (IS_USER_BUILD) {
            return NO_OP_SPAN;
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name must be non-null and non-empty");
        }
        
        ThreadSpanState state = sThisThreadSpanState.get();

        return new Span(state);
       /* Span span = null;
        synchronized (state) {
            if (state.mFreeListHead != null) {
                span = state.mFreeListHead;
                state.mFreeListHead = span.mNext;
                state.mFreeListSize--;
            } else {
                // Shouldn't have to do this often.
                span = new Span(state);
            }
            span.mName = name;
            span.mCreateMillis = SystemClock.uptimeMillis();
            span.mNext = state.mActiveHead;
            span.mPrev = null;
            state.mActiveHead = span;
            state.mActiveSize++;
            if (span.mNext != null) {
                span.mNext.mPrev = span;
            }
            if (LOG_V) Log.d(TAG, "Span enter=" + name + "; size=" + state.mActiveSize);
        }
        return span;*/
    }

    /**
     * For code to note that it's slow.  This is a no-op unless the
     * current thread's {@link android.os.StrictMode.ThreadPolicy} has
     * {@link android.os.StrictMode.ThreadPolicy.Builder#detectCustomSlowCalls}
     * enabled.
     *
     * @param name a short string for the exception stack trace that's
     *             built if when this fires.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.321 -0500", hash_original_method = "B98B8D959756B812CAEADC403B908021", hash_generated_method = "2AF92D94E361076B27970F1E047306BA")
    
public static void noteSlowCall(String name) {
      /*  BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            // StrictMode not enabled.
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onCustomSlowCall(name);*/
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.324 -0500", hash_original_method = "750E68EADFFF9EF2A8A0F45DFD480746", hash_generated_method = "E45B8AD0CDA3B0BAE91719810A69FEDC")
    
public static void noteDiskRead() {
       /* BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            // StrictMode not enabled.
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onReadFromDisk();*/
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.326 -0500", hash_original_method = "C2C60A74DC13C0F89DC4E47159DB8FD2", hash_generated_method = "121CB5F2B452143B05D28AAC32EF6673")
    
public static void noteDiskWrite() {
      /*  BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            // StrictMode not enabled.
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onWriteToDisk();*/
    }

    /**
     * Returns an object that is used to track instances of activites.
     * The activity should store a reference to the tracker object in one of its fields.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.331 -0500", hash_original_method = "E950565A85A7626D07FC065E3E871678", hash_generated_method = "C061937E7668406FE8E3C5A03CB49A50")
    
public static Object trackActivity(Object instance) {
        return new InstanceTracker(instance);
    }

    /**
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.333 -0500", hash_original_method = "4C40B4FD0BD10B4EE6F7D0BFF962D7AA", hash_generated_method = "0D457BD9440D94DCA0BF865CD4A7ADDC")
    
public static void incrementExpectedActivityCount(Class klass) {
        /*if (klass == null) {
            return;
        }

        synchronized (StrictMode.class) {
            if ((sVmPolicy.mask & DETECT_VM_ACTIVITY_LEAKS) == 0) {
                return;
            }

            Integer expected = sExpectedActivityInstanceCount.get(klass);
            Integer newExpected = expected == null ? 1 : expected + 1;
            sExpectedActivityInstanceCount.put(klass, newExpected);
        }*/
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.337 -0500", hash_original_method = "F6C508055F46D99984B7E83214C007E3", hash_generated_method = "C9EEFF1EDA70124026A116A3829AF691")
    
public static void decrementExpectedActivityCount(Class klass) {
        /*if (klass == null) {
            return;
        }

        final int limit;
        synchronized (StrictMode.class) {
            if ((sVmPolicy.mask & DETECT_VM_ACTIVITY_LEAKS) == 0) {
                return;
            }

            Integer expected = sExpectedActivityInstanceCount.get(klass);
            int newExpected = (expected == null || expected == 0) ? 0 : expected - 1;
            if (newExpected == 0) {
                sExpectedActivityInstanceCount.remove(klass);
            } else {
                sExpectedActivityInstanceCount.put(klass, newExpected);
            }

            // Note: adding 1 here to give some breathing room during
            // orientation changes.  (shouldn't be necessary, though?)
            limit = newExpected + 1;
        }

        // Quick check.
        int actual = InstanceTracker.getInstanceCount(klass);
        if (actual <= limit) {
            return;
        }

        // Do a GC and explicit count to double-check.
        // This is the work that we are trying to avoid by tracking the object instances
        // explicity.  Running an explicit GC can be expensive (80ms) and so can walking
        // the heap to count instance (30ms).  This extra work can make the system feel
        // noticeably less responsive during orientation changes when activities are
        // being restarted.  Granted, it is only a problem when StrictMode is enabled
        // but it is annoying.
        Runtime.getRuntime().gc();

        long instances = VMDebug.countInstancesOfClass(klass, false);
        if (instances > limit) {
            Throwable tr = new InstanceCountViolation(klass, instances, limit);
            onVmPolicyViolation(tr.getMessage(), tr);
        }*/
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.871 -0500", hash_original_field = "09E16BB7B51D673D1BCEFBE815620A11", hash_generated_field = "EFD495BFFD08DBECC91B6FEE7B253D98")

    private static final String TAG = "StrictMode";
    
    public static final class ThreadPolicy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.954 -0500", hash_original_field = "DADE8E7DB6AA2D277AD26A7D0E8C2E88", hash_generated_field = "9578A9475850D552D61F6D5FCB916824")

        public static final ThreadPolicy LAX = new ThreadPolicy(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.956 -0500", hash_original_field = "DB965A11139AB665B00B4D2E2ABFFB32", hash_generated_field = "DB965A11139AB665B00B4D2E2ABFFB32")

         int mask;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.959 -0500", hash_original_method = "B0AC15ACB9093249F94C953D0A842CAE", hash_generated_method = "43C350FD2EC7FD2FAA309ED219B5C058")
        
private ThreadPolicy(int mask) {
            this.mask = mask;
        }
        
        public static final class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.964 -0500", hash_original_field = "5D5C3A37F8AF5444E0AC898E62346D28", hash_generated_field = "B8B68F2E3B571F250FDA42AEED6F96EC")

            private int mMask = 0;  // need copy-on-write

            @DSComment("Only URI passing around is important")
            @DSSafe(DSCat.UTIL_FUNCTION)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.046 -0500", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "2DBF625FFD06FDF36909DDC7E5DF2F6A")
            
public Builder() {
                mMask = 0;
            }

            /**
             * Initialize a Builder from an existing ThreadPolicy.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.970 -0500", hash_original_method = "2270BC971D9C4F82FBD51366B809A76A", hash_generated_method = "8BE728A10D6EDBA1FAE08A07F263A007")
            
public Builder(ThreadPolicy policy) {
                mMask = policy.mask;
            }

            /**
             * Detect everything that's potentially suspect.
             *
             * <p>As of the Gingerbread release this includes network and
             * disk operations but will likely expand in future releases.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.973 -0500", hash_original_method = "399752AE3320783E8BC4077BF2BAABAB", hash_generated_method = "DF7BFDCBE80F7E650B0690F79EA2CEC8")
            
public Builder detectAll() {
                return enable(ALL_THREAD_DETECT_BITS);
            }

            /**
             * Disable the detection of everything.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.975 -0500", hash_original_method = "3E31B254E1B4E9A5234881E68AADF1C7", hash_generated_method = "0017153D2B012663C8461E431C2718A0")
            
public Builder permitAll() {
                return disable(ALL_THREAD_DETECT_BITS);
            }

            /**
             * Enable detection of network operations.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.977 -0500", hash_original_method = "8F1CC5D4BDA427578EB68B001E341FDD", hash_generated_method = "1276A69927832A306A1F253BA90ADEA6")
            
public Builder detectNetwork() {
                return enable(DETECT_NETWORK);
            }

            /**
             * Disable detection of network operations.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.980 -0500", hash_original_method = "2A4244001D1666DDAFB3F602ED8EC7EA", hash_generated_method = "0EE1C61F081D9D14D216A27E7AF6F9E1")
            
public Builder permitNetwork() {
                return disable(DETECT_NETWORK);
            }

            /**
             * Enable detection of disk reads.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.982 -0500", hash_original_method = "75C524432F954C01B0149630CE54DDB4", hash_generated_method = "971A11FE9A821D05203024F158BC4E21")
            
public Builder detectDiskReads() {
                return enable(DETECT_DISK_READ);
            }

            /**
             * Disable detection of disk reads.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.985 -0500", hash_original_method = "1BD98C02F9A11EE892D0098B20BDD8BD", hash_generated_method = "38C987EC07C1C09CE658C77769CB3364")
            
public Builder permitDiskReads() {
                return disable(DETECT_DISK_READ);
            }

            /**
             * Enable detection of disk reads.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.987 -0500", hash_original_method = "0F761933C6E4A91421ABB8964A4D9EB8", hash_generated_method = "10EA241F4E17C54E56CD73AD014CFB39")
            
public Builder detectCustomSlowCalls() {
                return enable(DETECT_CUSTOM);
            }

            /**
             * Enable detection of disk reads.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.989 -0500", hash_original_method = "1F5E52FF134E5A595D9B4F3AD9EF805B", hash_generated_method = "B34ECCA1173A46DC77AEC0E5DA1F925F")
            
public Builder permitCustomSlowCalls() {
                return enable(DETECT_CUSTOM);
            }

            /**
             * Enable detection of disk writes.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.991 -0500", hash_original_method = "583E0D5D228DC11F4F3B1B541EE8393C", hash_generated_method = "65DA150612AFC1A906C50197734E6BB1")
            
public Builder detectDiskWrites() {
                return enable(DETECT_DISK_WRITE);
            }

            /**
             * Disable detection of disk writes.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.993 -0500", hash_original_method = "A37C6D388BF979AC5AEB871BAB2E0B6F", hash_generated_method = "9C9E35E47D28A00E8E739A9137FC59BD")
            
public Builder permitDiskWrites() {
                return disable(DETECT_DISK_WRITE);
            }

            /**
             * Show an annoying dialog to the developer on detected
             * violations, rate-limited to be only a little annoying.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.997 -0500", hash_original_method = "8766DB09D651E2B3541ACB0418FFA365", hash_generated_method = "D09555F2947D75B2837EAF1A3FB8DD71")
            
public Builder penaltyDialog() {
                return enable(PENALTY_DIALOG);
            }

            /**
             * Crashes the whole process on violation.  This penalty runs at
             * the end of all enabled penalties so yo you'll still get
             * your logging or other violations before the process dies.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.063 -0500", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "1E4E197488849CB34459EC1D10621814")
            
public Builder penaltyDeath() {
                return enable(PENALTY_DEATH);
            }

            /**
             * Crash the whole process on any network usage.  Unlike
             * {@link #penaltyDeath}, this penalty runs
             * <em>before</em> anything else.  You must still have
             * called {@link #detectNetwork} to enable this.
             *
             * <p>In the Honeycomb or later SDKs, this is on by default.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.002 -0500", hash_original_method = "3B3840DC05B4A1C1129369D4324CF6E7", hash_generated_method = "36AA36C0D41EBC085C3CFC7496FC4690")
            
public Builder penaltyDeathOnNetwork() {
                return enable(PENALTY_DEATH_ON_NETWORK);
            }

            /**
             * Flash the screen during a violation.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.004 -0500", hash_original_method = "D2175CC28C327D3A1AEA760A679D2369", hash_generated_method = "80D0B91D85C9D2728A674E0E7B1BB8B7")
            
public Builder penaltyFlashScreen() {
                return enable(PENALTY_FLASH);
            }

            /**
             * Log detected violations to the system log.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.065 -0500", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "F838F350808EF8DE76A2A3DA20F92096")
            
public Builder penaltyLog() {
                return enable(PENALTY_LOG);
            }

            /**
             * Enable detected violations log a stacktrace and timing data
             * to the {@link android.os.DropBoxManager DropBox} on policy
             * violation.  Intended mostly for platform integrators doing
             * beta user field data collection.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.068 -0500", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "D5142B7D1052A69247CFB7DD49F182C5")
            
public Builder penaltyDropBox() {
                return enable(PENALTY_DROPBOX);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.071 -0500", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "E140B3922FC0EA6AE7CF33E6B7722936")
            
private Builder enable(int bit) {
                mMask |= bit;
                return this;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.014 -0500", hash_original_method = "DD377E4C338D3B09C11C3D4D7DFD99D3", hash_generated_method = "52497D065FC906A00D81524DB39B8CA0")
            
private Builder disable(int bit) {
                mMask &= ~bit;
                return this;
            }

            /**
             * Construct the ThreadPolicy instance.
             *
             * <p>Note: if no penalties are enabled before calling
             * <code>build</code>, {@link #penaltyLog} is implicitly
             * set.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.017 -0500", hash_original_method = "3E686B94A275CF17A4C5CE0839D3E8D1", hash_generated_method = "02A6980043E272C2A3D26810B761D9D7")
            
public ThreadPolicy build() {
                // If there are detection bits set but no violation bits
                // set, enable simple logging.
                if (mMask != 0 &&
                    (mMask & (PENALTY_DEATH | PENALTY_LOG |
                              PENALTY_DROPBOX | PENALTY_DIALOG)) == 0) {
                    penaltyLog();
                }
                return new ThreadPolicy(mMask);
            }
            
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.961 -0500", hash_original_method = "AE05BE3A66BEE06993F7653F4CB681EB", hash_generated_method = "D0EEABE072A274220FB1724BB3C8E223")
        
@Override
        public String toString() {
            return "[StrictMode.ThreadPolicy; mask=" + mask + "]";
        }
    }
    
    public static final class VmPolicy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.026 -0500", hash_original_field = "7F88ECADC0E1588635922A1A98E8507E", hash_generated_field = "9254DDC9D251934961027FD07388D251")

        public static final VmPolicy LAX = new VmPolicy(0, EMPTY_CLASS_LIMIT_MAP);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.028 -0500", hash_original_field = "DB965A11139AB665B00B4D2E2ABFFB32", hash_generated_field = "DB965A11139AB665B00B4D2E2ABFFB32")

         int mask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.030 -0500", hash_original_field = "C4A68A411991D38DAC450888E1864E75", hash_generated_field = "C4A68A411991D38DAC450888E1864E75")

         HashMap<Class, Integer> classInstanceLimit;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.033 -0500", hash_original_method = "BE6E35A5EA1ACA059EF2A402B69D7023", hash_generated_method = "4F5A40A8E136017B53E027E78AA4EC6C")
        
private VmPolicy(int mask, HashMap<Class, Integer> classInstanceLimit) {
            if (classInstanceLimit == null) {
                throw new NullPointerException("classInstanceLimit == null");
            }
            this.mask = mask;
            this.classInstanceLimit = classInstanceLimit;
        }
        
        public static final class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.038 -0500", hash_original_field = "71806D576457AC3BE7E0FCD88576215F", hash_generated_field = "F7C8905D5B34EE793946807F2A7E20A1")

            private int mMask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.041 -0500", hash_original_field = "7DFABFD9EB20AC38A9FCD33C78A539D0", hash_generated_field = "7DA905668F7F3F2312998927AB27A0B2")

            private HashMap<Class, Integer> mClassInstanceLimit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.043 -0500", hash_original_field = "4518B98219D402F5A88E5F6CED5FEAB8", hash_generated_field = "2D6485C7C663B1648AF525BB6C2310A9")

            private boolean mClassInstanceLimitNeedCow = false;
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.754 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "C4A90307B6990541B60C2B86DCD4B526")
            public  Builder() {
                mMask = 0;
                // ---------- Original Method ----------
                //mMask = 0;
            }

            /**
             * Build upon an existing VmPolicy.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.049 -0500", hash_original_method = "FBB1CB3954D34CB1AD109CEFAD7B1DDE", hash_generated_method = "DABCB0F3CC1C040754C636AC3DDF91DE")
            
public Builder(VmPolicy base) {
                mMask = base.mask;
                mClassInstanceLimitNeedCow = true;
                mClassInstanceLimit = base.classInstanceLimit;
            }

            /**
             * Set an upper bound on how many instances of a class can be in memory
             * at once.  Helps to prevent object leaks.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.052 -0500", hash_original_method = "E6B0AD736B79FE1E50987D22EA6466E3", hash_generated_method = "64B74F2F2544B85F495C3C18E7D99AF5")
            
public Builder setClassInstanceLimit(Class klass, int instanceLimit) {
                if (klass == null) {
                    throw new NullPointerException("klass == null");
                }
                if (mClassInstanceLimitNeedCow) {
                    if (mClassInstanceLimit.containsKey(klass) &&
                        mClassInstanceLimit.get(klass) == instanceLimit) {
                        // no-op; don't break COW
                        return this;
                    }
                    mClassInstanceLimitNeedCow = false;
                    mClassInstanceLimit = (HashMap<Class, Integer>) mClassInstanceLimit.clone();
                } else if (mClassInstanceLimit == null) {
                    mClassInstanceLimit = new HashMap<Class, Integer>();
                }
                mMask |= DETECT_VM_INSTANCE_LEAKS;
                mClassInstanceLimit.put(klass, instanceLimit);
                return this;
            }

            /**
             * Detect leaks of {@link android.app.Activity} subclasses.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.054 -0500", hash_original_method = "1E52C56D15D33FA545E602A30D1B7293", hash_generated_method = "D2E41D142E8385275E20AA70FB83AA2D")
            
public Builder detectActivityLeaks() {
                return enable(DETECT_VM_ACTIVITY_LEAKS);
            }

            /**
             * Detect everything that's potentially suspect.
             *
             * <p>In the Honeycomb release this includes leaks of
             * SQLite cursors, Activities, and other closable objects
             * but will likely expand in future releases.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.057 -0500", hash_original_method = "CEAA7924A62774EE9F1DB0EAFC23F606", hash_generated_method = "BBE069E8424B2AE9D19405A0EC7E1F13")
            
public Builder detectAll() {
                return enable(DETECT_VM_ACTIVITY_LEAKS |
                        DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS);
            }

            /**
             * Detect when an
             * {@link android.database.sqlite.SQLiteCursor} or other
             * SQLite object is finalized without having been closed.
             *
             * <p>You always want to explicitly close your SQLite
             * cursors to avoid unnecessary database contention and
             * temporary memory leaks.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.059 -0500", hash_original_method = "7CA55A1EF27E65D4088A38B2843E1EE5", hash_generated_method = "241B8377B18562134F87560E6DD9F257")
            
public Builder detectLeakedSqlLiteObjects() {
                return enable(DETECT_VM_CURSOR_LEAKS);
            }

            /**
             * Detect when an {@link java.io.Closeable} or other
             * object with a explict termination method is finalized
             * without having been closed.
             *
             * <p>You always want to explicitly close such objects to
             * avoid unnecessary resources leaks.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.061 -0500", hash_original_method = "76FD4F08E7705E8F66E31708D9A399EA", hash_generated_method = "A441AB886E881C221DFC070262CCA4C2")
            
public Builder detectLeakedClosableObjects() {
                return enable(DETECT_VM_CLOSABLE_LEAKS);
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "70D58CB86738E652D64572B273F4DEEA")
            public Builder penaltyDeath() {
Builder var6F115A07D237A33880541F25719D67B0_1559101226 =                 enable(PENALTY_DEATH);
                var6F115A07D237A33880541F25719D67B0_1559101226.addTaint(getTaint());
                return var6F115A07D237A33880541F25719D67B0_1559101226;
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH);
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "500E5F189D822DE77B9BA7533BD281D3")
            public Builder penaltyLog() {
Builder var7C46BCB224406F4BC478971CF4360D87_1946014504 =                 enable(PENALTY_LOG);
                var7C46BCB224406F4BC478971CF4360D87_1946014504.addTaint(getTaint());
                return var7C46BCB224406F4BC478971CF4360D87_1946014504;
                // ---------- Original Method ----------
                //return enable(PENALTY_LOG);
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "534BBD6BF05727FEE3669BE78D059282")
            public Builder penaltyDropBox() {
Builder varC3126CEB2524227BCB28FCD226FE486C_1272195904 =                 enable(PENALTY_DROPBOX);
                varC3126CEB2524227BCB28FCD226FE486C_1272195904.addTaint(getTaint());
                return varC3126CEB2524227BCB28FCD226FE486C_1272195904;
                // ---------- Original Method ----------
                //return enable(PENALTY_DROPBOX);
            }
                        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "879AA6DE2768B208ED13B14418D603DB")
            private Builder enable(int bit) {
                mMask |= bit;
Builder var72A74007B2BE62B849F475C7BDA4658B_2113603366 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_2113603366.addTaint(getTaint());
                return var72A74007B2BE62B849F475C7BDA4658B_2113603366;
                // ---------- Original Method ----------
                //mMask |= bit;
                //return this;
            }

            /**
             * Construct the VmPolicy instance.
             *
             * <p>Note: if no penalties are enabled before calling
             * <code>build</code>, {@link #penaltyLog} is implicitly
             * set.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.073 -0500", hash_original_method = "6432BC9C97797DD02AE9BFA4A7F87D54", hash_generated_method = "12B7E82AF5C78632A4EEECAEBF7B1DCE")
            
public VmPolicy build() {
                // If there are detection bits set but no violation bits
                // set, enable simple logging.
                if (mMask != 0 &&
                    (mMask & (PENALTY_DEATH | PENALTY_LOG |
                              PENALTY_DROPBOX | PENALTY_DIALOG)) == 0) {
                    penaltyLog();
                }
                return new VmPolicy(mMask,
                        mClassInstanceLimit != null ? mClassInstanceLimit : EMPTY_CLASS_LIMIT_MAP);
            }
            
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.035 -0500", hash_original_method = "338C4A4B8F91E885EB5A5562BE10EA45", hash_generated_method = "FDEE3D24684D7B163B78F97431CD5C31")
        
@Override
        public String toString() {
            return "[StrictMode.VmPolicy; mask=" + mask + "]";
        }
    }
    
    public static class StrictModeViolation extends BlockGuard.BlockGuardPolicyException {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.098 -0500", hash_original_method = "E7438DD65D448EA29E2BF1E2E7B9AF17", hash_generated_method = "A29B7365FE9E1FFEDCF43496881938C5")
        
public StrictModeViolation(int policyState, int policyViolated, String message) {
            super(policyState, policyViolated, message);
        }
        
    }
    
    public static class StrictModeNetworkViolation extends StrictModeViolation {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.103 -0500", hash_original_method = "DBBD717A236AEADDFBDE9EEC846203D0", hash_generated_method = "F5259CA93DE8509355CE9CD1508A4B26")
        
public StrictModeNetworkViolation(int policyMask) {
            super(policyMask, DETECT_NETWORK, null);
        }
        
    }
    
    private static class StrictModeDiskReadViolation extends StrictModeViolation {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.107 -0500", hash_original_method = "50FAC78594B32A364EC38A7051A6D828", hash_generated_method = "6F2D3C986A9D378445E2020175A1A22D")
        
public StrictModeDiskReadViolation(int policyMask) {
            super(policyMask, DETECT_DISK_READ, null);
        }
        
    }
    
    private static class StrictModeDiskWriteViolation extends StrictModeViolation {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.111 -0500", hash_original_method = "3E79DB089B8A8B103215C527DD70DC9D", hash_generated_method = "6F51284BE211F14B2EDDBC428625C354")
        
public StrictModeDiskWriteViolation(int policyMask) {
            super(policyMask, DETECT_DISK_WRITE, null);
        }
        
    }
    
    private static class StrictModeCustomViolation extends StrictModeViolation {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.116 -0500", hash_original_method = "D9775B5587EA33BC7CC7CE8D67F82D3A", hash_generated_method = "FA64B5B18F281D05E8A9EE93A9BC20E4")
        
public StrictModeCustomViolation(int policyMask, String name) {
            super(policyMask, DETECT_CUSTOM, name);
        }
        
    }
    
    private static class AndroidBlockGuardPolicy implements BlockGuard.Policy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.156 -0500", hash_original_field = "483449A757D8EAA5C8F766E048F61B54", hash_generated_field = "A3F55928E2CD42B0872F6832B90FE4B8")

        private int mPolicyMask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.158 -0500", hash_original_field = "6F56E72D66B5A36B99558A1F6FBC6F8C", hash_generated_field = "19F379320C91AB11D1168928AD9759E6")

        // last violation.  No locking needed, as this is only
        // accessed by the same thread.
        private final HashMap<Integer, Long> mLastViolationTime = new HashMap<Integer, Long>();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.161 -0500", hash_original_method = "56B73F441F57B7F1580692BF8D8E5ECB", hash_generated_method = "94EB69ADB3DBBCDCC1B5B5FB120D73E4")
        
public AndroidBlockGuardPolicy(final int policyMask) {
            mPolicyMask = policyMask;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.164 -0500", hash_original_method = "EC02A08C2D3910C2DE1DA94FE738CE60", hash_generated_method = "F39C3AADFF2389FE5B47EA4B6A27487B")
        
@Override
        public String toString() {
            return "AndroidBlockGuardPolicy; mPolicyMask=" + mPolicyMask;
        }

        // Part of BlockGuard.Policy interface:
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.166 -0500", hash_original_method = "BDAE35F9BC36FEF12DCB9013D520032B", hash_generated_method = "8DB41D24CE713E7FAE656DFD19F5AD6E")
        
public int getPolicyMask() {
            return mPolicyMask;
        }

        // Part of BlockGuard.Policy interface:
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.168 -0500", hash_original_method = "0D85458AC3FF96FC22E8C3819C12EFAB", hash_generated_method = "E6EB4126ABA479D8B23F3329B026E6C9")
        
public void onWriteToDisk() {
            if ((mPolicyMask & DETECT_DISK_WRITE) == 0) {
                return;
            }
            if (tooManyViolationsThisLoop()) {
                return;
            }
            BlockGuard.BlockGuardPolicyException e = new StrictModeDiskWriteViolation(mPolicyMask);
            e.fillInStackTrace();
            startHandlingViolationException(e);
        }

        // Not part of BlockGuard.Policy; just part of StrictMode:
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.171 -0500", hash_original_method = "B44201BA71724735A91DD4F1FF43D337", hash_generated_method = "B44201BA71724735A91DD4F1FF43D337")
        
void onCustomSlowCall(String name) {
            if ((mPolicyMask & DETECT_CUSTOM) == 0) {
                return;
            }
            if (tooManyViolationsThisLoop()) {
                return;
            }
            BlockGuard.BlockGuardPolicyException e = new StrictModeCustomViolation(mPolicyMask, name);
            e.fillInStackTrace();
            startHandlingViolationException(e);
        }

        // Part of BlockGuard.Policy interface:
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.174 -0500", hash_original_method = "DC9910586B30548E82E107CFA3542EA2", hash_generated_method = "3CCEA3A07CA065606AC3E45591511F49")
        
public void onReadFromDisk() {
            if ((mPolicyMask & DETECT_DISK_READ) == 0) {
                return;
            }
            if (tooManyViolationsThisLoop()) {
                return;
            }
            BlockGuard.BlockGuardPolicyException e = new StrictModeDiskReadViolation(mPolicyMask);
            e.fillInStackTrace();
            startHandlingViolationException(e);
        }

        // Part of BlockGuard.Policy interface:
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.177 -0500", hash_original_method = "D41EA35CCA984A26E96A9AAEEE4BCF1E", hash_generated_method = "FF30C3E9DF6E5D4C9E61E0195BE02AF4")
        
public void onNetwork() {
            if ((mPolicyMask & DETECT_NETWORK) == 0) {
                return;
            }
            if ((mPolicyMask & PENALTY_DEATH_ON_NETWORK) != 0) {
                throw new NetworkOnMainThreadException();
            }
            if (tooManyViolationsThisLoop()) {
                return;
            }
            BlockGuard.BlockGuardPolicyException e = new StrictModeNetworkViolation(mPolicyMask);
            e.fillInStackTrace();
            startHandlingViolationException(e);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.179 -0500", hash_original_method = "A35D2E9A8AD0B9C28C9280D1C3956061", hash_generated_method = "CF632B9E27019859308A66B38FBD94C0")
        
public void setPolicyMask(int policyMask) {
            mPolicyMask = policyMask;
        }

        // Start handling a violation that just started and hasn't
        // actually run yet (e.g. no disk write or network operation
        // has yet occurred).  This sees if we're in an event loop
        // thread and, if so, uses it to roughly measure how long the
        // violation took.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.181 -0500", hash_original_method = "5E39E8C314EEA382AFAE0CC045B36998", hash_generated_method = "5E39E8C314EEA382AFAE0CC045B36998")
        
void startHandlingViolationException(BlockGuard.BlockGuardPolicyException e) {
            final ViolationInfo info = new ViolationInfo(e, e.getPolicy());
            info.violationUptimeMillis = SystemClock.uptimeMillis();
            handleViolationWithTimingAttempt(info);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.760 -0400", hash_original_method = "E564B46DD31AF359B07F190378DAA828", hash_generated_method = "101CD51A507E6022F7DCD55692F1537B")
         void handleViolationWithTimingAttempt(final ViolationInfo info) {
            addTaint(info.getTaint());
            Looper looper = Looper.myLooper();
            if(looper == null ||
                (info.policy & THREAD_PENALTY_MASK) == PENALTY_DEATH)            
            {
                info.durationMillis = -1;
                handleViolation(info);
                return;
            } //End block
            final ArrayList<ViolationInfo> records = violationsBeingTimed.get();
            if(records.size() >= MAX_OFFENSES_PER_LOOP)            
            {
                return;
            } //End block
            records.add(info);
            if(records.size() > 1)            
            {
                return;
            } //End block
            final IWindowManager windowManager = (info.policy & PENALTY_FLASH) != 0 ?
                    sWindowManager.get() : null;
            if(windowManager != null)            
            {
                try 
                {
                    windowManager.showStrictModeViolation(true);
                } //End block
                catch (RemoteException unused)
                {
                } //End block
            } //End block
            threadHandler.get().post(new Runnable() {
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.189 -0500", hash_original_method = "13A73E46BCAE9FB3F25E0C7CB59DBB78", hash_generated_method = "70F361BA6BFD68D67760519D8A02B240")
                
public void run() {
                        long loopFinishTime = SystemClock.uptimeMillis();

                        // Note: we do this early, before handling the
                        // violation below, as handling the violation
                        // may include PENALTY_DEATH and we don't want
                        // to keep the red border on.
                        if (windowManager != null) {
                            try {
                                windowManager.showStrictModeViolation(false);
                            } catch (RemoteException unused) {
                            }
                        }

                        for (int n = 0; n < records.size(); ++n) {
                            ViolationInfo v = records.get(n);
                            v.violationNumThisLoop = n + 1;
                            v.durationMillis =
                                    (int) (loopFinishTime - v.violationUptimeMillis);
                            handleViolation(v);
                        }
                        records.clear();
                    }
});
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        // Note: It's possible (even quite likely) that the
        // thread-local policy mask has changed from the time the
        // violation fired and now (after the violating code ran) due
        // to people who push/pop temporary policy in regions of code,
        // hence the policy being passed around.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.197 -0500", hash_original_method = "41F5C3E6841DC86E9C64A72E84C0FF7E", hash_generated_method = "B487B717F59A2A1064CE6CBD296931D5")
        
void handleViolation(final ViolationInfo info) {
            if (info == null || info.crashInfo == null || info.crashInfo.stackTrace == null) {
                Log.wtf(TAG, "unexpected null stacktrace");
                return;
            }

            if (LOG_V) Log.d(TAG, "handleViolation; policy=" + info.policy);

            if ((info.policy & PENALTY_GATHER) != 0) {
                ArrayList<ViolationInfo> violations = gatheredViolations.get();
                if (violations == null) {
                    violations = new ArrayList<ViolationInfo>(1);
                    gatheredViolations.set(violations);
                } else if (violations.size() >= 5) {
                    // Too many.  In a loop or something?  Don't gather them all.
                    return;
                }
                for (ViolationInfo previous : violations) {
                    if (info.crashInfo.stackTrace.equals(previous.crashInfo.stackTrace)) {
                        // Duplicate. Don't log.
                        return;
                    }
                }
                violations.add(info);
                return;
            }

            // Not perfect, but fast and good enough for dup suppression.
            Integer crashFingerprint = info.hashCode();
            long lastViolationTime = 0;
            if (mLastViolationTime.containsKey(crashFingerprint)) {
                lastViolationTime = mLastViolationTime.get(crashFingerprint);
            }
            long now = SystemClock.uptimeMillis();
            mLastViolationTime.put(crashFingerprint, now);
            long timeSinceLastViolationMillis = lastViolationTime == 0 ?
                    Long.MAX_VALUE : (now - lastViolationTime);

            if ((info.policy & PENALTY_LOG) != 0 &&
                timeSinceLastViolationMillis > MIN_LOG_INTERVAL_MS) {
                if (info.durationMillis != -1) {
                    Log.d(TAG, "StrictMode policy violation; ~duration=" +
                          info.durationMillis + " ms: " + info.crashInfo.stackTrace);
                } else {
                    Log.d(TAG, "StrictMode policy violation: " + info.crashInfo.stackTrace);
                }
            }

            // The violationMaskSubset, passed to ActivityManager, is a
            // subset of the original StrictMode policy bitmask, with
            // only the bit violated and penalty bits to be executed
            // by the ActivityManagerService remaining set.
            int violationMaskSubset = 0;

            if ((info.policy & PENALTY_DIALOG) != 0 &&
                timeSinceLastViolationMillis > MIN_DIALOG_INTERVAL_MS) {
                violationMaskSubset |= PENALTY_DIALOG;
            }

            if ((info.policy & PENALTY_DROPBOX) != 0 && lastViolationTime == 0) {
                violationMaskSubset |= PENALTY_DROPBOX;
            }

            if (violationMaskSubset != 0) {
                int violationBit = parseViolationFromMessage(info.crashInfo.exceptionMessage);
                violationMaskSubset |= violationBit;
                final int savedPolicyMask = getThreadPolicyMask();

                final boolean justDropBox = (info.policy & THREAD_PENALTY_MASK) == PENALTY_DROPBOX;
                if (justDropBox) {
                    // If all we're going to ask the activity manager
                    // to do is dropbox it (the common case during
                    // platform development), we can avoid doing this
                    // call synchronously which Binder data suggests
                    // isn't always super fast, despite the implementation
                    // in the ActivityManager trying to be mostly async.
                    dropboxViolationAsync(violationMaskSubset, info);
                    return;
                }

                // Normal synchronous call to the ActivityManager.
                try {
                    // First, remove any policy before we call into the Activity Manager,
                    // otherwise we'll infinite recurse as we try to log policy violations
                    // to disk, thus violating policy, thus requiring logging, etc...
                    // We restore the current policy below, in the finally block.
                    setThreadPolicyMask(0);

                    ActivityManagerNative.getDefault().handleApplicationStrictModeViolation(
                        RuntimeInit.getApplicationObject(),
                        violationMaskSubset,
                        info);
                } catch (RemoteException e) {
                    Log.e(TAG, "RemoteException trying to handle StrictMode violation", e);
                } finally {
                    // Restore the policy.
                    setThreadPolicyMask(savedPolicyMask);
                }
            }

            if ((info.policy & PENALTY_DEATH) != 0) {
                executeDeathPenalty(info);
            }
        }
        
    }
    
    private static class AndroidCloseGuardReporter implements CloseGuard.Reporter {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.763 -0400", hash_original_method = "E7772DF8591E8A95C00A24C3A7BC9385", hash_generated_method = "E7772DF8591E8A95C00A24C3A7BC9385")
        public AndroidCloseGuardReporter ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.213 -0500", hash_original_method = "1648939B3F4BE7F697201ED2CA10799D", hash_generated_method = "C5A649A34249029FDEB4403F37328607")
        
public void report (String message, Throwable allocationSite) {
            onVmPolicyViolation(message, allocationSite);
        }
        
    }
    
    private static class LogStackTrace extends Exception {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.764 -0400", hash_original_method = "9318B319D2DE8ECE742465D2C7D8840B", hash_generated_method = "9318B319D2DE8ECE742465D2C7D8840B")
        public LogStackTrace ()
        {
            //Synthesized constructor
        }

    }
    
    public static class Span {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.269 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

        private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.271 -0500", hash_original_field = "E9AFEC5C60D51DAE569BCE08AB1DF9A7", hash_generated_field = "D9168B950155534AAD832724FE52C500")

        private long mCreateMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.273 -0500", hash_original_field = "7D4F25790A374D45006D60140F1C3E4E", hash_generated_field = "E39EFCE10572D87C6F95E3A2B2BDFCB1")

        private Span mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.276 -0500", hash_original_field = "5F1D8F63B5C96F1671E725455EC06B40", hash_generated_field = "ABC77622AA8E19FF30E79A0A19830013")

        private Span mPrev;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.279 -0500", hash_original_field = "96BE3FF8E436D8551616A6DF4C4B6116", hash_generated_field = "71A5A2213C60169AAE2591AE6952C837")

        private  ThreadSpanState mContainerState;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.281 -0500", hash_original_method = "858C7F08B86E9ABCC5108174CEDFA974", hash_generated_method = "858C7F08B86E9ABCC5108174CEDFA974")
        
Span(ThreadSpanState threadState) {
            mContainerState = threadState;
        }

        // Empty constructor for the NO_OP_SPAN
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.284 -0500", hash_original_method = "35ECB8DB5D2E2401D23EA00A0B49C3B0", hash_generated_method = "ED1A4239CAF71D33303BC23D1C0C3B5A")
        
protected Span() {
            mContainerState = null;
        }

        /**
         * To be called when the critical span is complete (i.e. the
         * animation is done animating).  This can be called on any
         * thread (even a different one from where the animation was
         * taking place), but that's only a defensive implementation
         * measure.  It really makes no sense for you to call this on
         * thread other than that where you created it.
         *
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.287 -0500", hash_original_method = "BAA90C1A527ED6ADE64DE9CF5831D500", hash_generated_method = "132AEEF0AEA6CA5B546CA4A7DAD99066")
        
public void finish() {
            ThreadSpanState state = mContainerState;
            synchronized (state) {
                if (mName == null) {
                    // Duplicate finish call.  Ignore.
                    return;
                }

                // Remove ourselves from the active list.
                if (mPrev != null) {
                    mPrev.mNext = mNext;
                }
                if (mNext != null) {
                    mNext.mPrev = mPrev;
                }
                if (state.mActiveHead == this) {
                    state.mActiveHead = mNext;
                }

                state.mActiveSize--;

                if (LOG_V) Log.d(TAG, "Span finished=" + mName + "; size=" + state.mActiveSize);

                this.mCreateMillis = -1;
                this.mName = null;
                this.mPrev = null;
                this.mNext = null;

                // Add ourselves to the freeList, if it's not already
                // too big.
                if (state.mFreeListSize < 5) {
                    this.mNext = state.mFreeListHead;
                    state.mFreeListHead = this;
                    state.mFreeListSize++;
                }
            }
        }
        
    }
    
    private static class ThreadSpanState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.297 -0500", hash_original_field = "2994BEFE3FAF05AF59EC8B7455DE802C", hash_generated_field = "518A04ADDEBFAA97A1EA0148B6F5FA97")

        public Span mActiveHead;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.299 -0500", hash_original_field = "469F089A27ECB6E2BCF64A4AC4538DB6", hash_generated_field = "B6D1D7D2D17432EE321593A3AEA5D914")

        public int mActiveSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.301 -0500", hash_original_field = "E704A2C205EBF36C04CA302C105782DA", hash_generated_field = "DA0030F95E05B17A8A5730A244932CA8")

        public Span mFreeListHead;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.303 -0500", hash_original_field = "EDAF19BE5D81DD25F93076CB7249D51E", hash_generated_field = "C3221ED1F561EAEA75567095BA88D9C9")

        public int mFreeListSize;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.765 -0400", hash_original_method = "897FCF469D672A73C45810344D5B48A8", hash_generated_method = "897FCF469D672A73C45810344D5B48A8")
        public ThreadSpanState ()
        {
            //Synthesized constructor
        }

    }
    
    public static class ViolationInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.339 -0500", hash_original_field = "CFC847948D9EC92AF23D33102A32EBB0", hash_generated_field = "CD846E661E8E518C4347C2ACA6146A7E")

        public  ApplicationErrorReport.CrashInfo crashInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.343 -0500", hash_original_field = "760B73BBAC4D3EAA6E4123AEF5B13B93", hash_generated_field = "930B7D58F3DA097BBD08C13024DA937C")

        public  int policy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.345 -0500", hash_original_field = "C4AB19059A4137F72C299A465BE5BF4E", hash_generated_field = "F1C866B29B39A143C5FBB9A0CA778367")

        public int durationMillis = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.347 -0500", hash_original_field = "773AF6C1A46FE06E358A021C43C3F801", hash_generated_field = "678196736B2E56BCECB08188576F10CE")

        public int numAnimationsRunning = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.349 -0500", hash_original_field = "DB3F92727615CD63589F0714FBAFB32B", hash_generated_field = "F792D5F97BD30C470267CF28260B7EA9")

        public String[] tags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.352 -0500", hash_original_field = "9C6D8997CB803938E0285B4BDFD6F229", hash_generated_field = "AF05918DADCF889F179D3E20609A32AE")

        public int violationNumThisLoop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.354 -0500", hash_original_field = "592AB44F5F3BB0E3F0E3F709AB9A248A", hash_generated_field = "0AAC6D73647F1D34E070F27F164676C0")

        public long violationUptimeMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.356 -0500", hash_original_field = "EC1ED92244C942819A9C9C46FFEEED13", hash_generated_field = "4B3B10B2069653BB6ABA4070A65734B4")

        public String broadcastIntentAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.358 -0500", hash_original_field = "55336AFCE70E5A14FC61BAE4F372AAB0", hash_generated_field = "FCE79C922D923B8021DEFCC4604B4FB6")

        public long numInstances = -1;

        /**
         * Create an uninitialized instance of ViolationInfo
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.361 -0500", hash_original_method = "D15EADA574CC6688E3A5C168E5A51EC1", hash_generated_method = "5F00CAF8B081ECDF52D74B2EA73978CD")
        
public ViolationInfo() {
            crashInfo = null;
            policy = 0;
        }

        /**
         * Create an instance of ViolationInfo initialized from an exception.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.364 -0500", hash_original_method = "B97F48EA0F14252413142D91DE4A3BFA", hash_generated_method = "86913E9551B857462339C45B3E0F0407")
        
public ViolationInfo(Throwable tr, int policy) {
            crashInfo = new ApplicationErrorReport.CrashInfo(tr);
            violationUptimeMillis = SystemClock.uptimeMillis();
            this.policy = policy;
            this.numAnimationsRunning = ValueAnimator.getCurrentAnimationsCount();
            Intent broadcastIntent = ActivityThread.getIntentBeingBroadcast();
            if (broadcastIntent != null) {
                broadcastIntentAction = broadcastIntent.getAction();
            }
            ThreadSpanState state = sThisThreadSpanState.get();
            if (tr instanceof InstanceCountViolation) {
                this.numInstances = ((InstanceCountViolation) tr).mInstances;
            }
            synchronized (state) {
                int spanActiveCount = state.mActiveSize;
                if (spanActiveCount > MAX_SPAN_TAGS) {
                    spanActiveCount = MAX_SPAN_TAGS;
                }
                if (spanActiveCount != 0) {
                    this.tags = new String[spanActiveCount];
                    Span iter = state.mActiveHead;
                    int index = 0;
                    while (iter != null && index < spanActiveCount) {
                        this.tags[index] = iter.mName;
                        index++;
                        iter = iter.mNext;
                    }
                }
            }
        }

        /**
         * Create an instance of ViolationInfo initialized from a Parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.369 -0500", hash_original_method = "2281C8F6C464FE0E4D053A790D9731B4", hash_generated_method = "CE146E0B7925136CBDE7DB6C7441BE7C")
        
public ViolationInfo(Parcel in) {
            this(in, false);
        }

        /**
         * Create an instance of ViolationInfo initialized from a Parcel.
         *
         * @param unsetGatheringBit if true, the caller is the root caller
         *   and the gathering penalty should be removed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.373 -0500", hash_original_method = "276C18C659FAD0D183192D3E613DC123", hash_generated_method = "BE93730CA41BE33A2A3EB37CEE8379CD")
        
public ViolationInfo(Parcel in, boolean unsetGatheringBit) {
            crashInfo = new ApplicationErrorReport.CrashInfo(in);
            int rawPolicy = in.readInt();
            if (unsetGatheringBit) {
                policy = rawPolicy & ~PENALTY_GATHER;
            } else {
                policy = rawPolicy;
            }
            durationMillis = in.readInt();
            violationNumThisLoop = in.readInt();
            numAnimationsRunning = in.readInt();
            violationUptimeMillis = in.readLong();
            numInstances = in.readLong();
            broadcastIntentAction = in.readString();
            tags = in.readStringArray();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.367 -0500", hash_original_method = "C167EFD1AA966CEFAC170AF811F6D4AF", hash_generated_method = "3D60EF1745D00AC01DABE6A6AAB571F8")
        
@Override
        public int hashCode() {
            int result = 17;
            result = 37 * result + crashInfo.stackTrace.hashCode();
            if (numAnimationsRunning != 0) {
                result *= 37;
            }
            if (broadcastIntentAction != null) {
                result = 37 * result + broadcastIntentAction.hashCode();
            }
            if (tags != null) {
                for (String tag : tags) {
                    result = 37 * result + tag.hashCode();
                }
            }
            return result;
        }

        /**
         * Save a ViolationInfo instance to a parcel.
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.376 -0500", hash_original_method = "4C68F89668EEC8ACA3036C864AE1DCBA", hash_generated_method = "CCEFBCB218FB24E74153F4AC5CC8BEB6")
        
public void writeToParcel(Parcel dest, int flags) {
            crashInfo.writeToParcel(dest, flags);
            dest.writeInt(policy);
            dest.writeInt(durationMillis);
            dest.writeInt(violationNumThisLoop);
            dest.writeInt(numAnimationsRunning);
            dest.writeLong(violationUptimeMillis);
            dest.writeLong(numInstances);
            dest.writeString(broadcastIntentAction);
            dest.writeStringArray(tags);
        }

        /**
         * Dump a ViolationInfo instance to a Printer.
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.379 -0500", hash_original_method = "FB1CB9CE36DAC72C8A293B50C548452A", hash_generated_method = "22BB318C5D3CC33996B2FEA75757D0E6")
        
public void dump(Printer pw, String prefix) {
            crashInfo.dump(pw, prefix);
            pw.println(prefix + "policy: " + policy);
            if (durationMillis != -1) {
                pw.println(prefix + "durationMillis: " + durationMillis);
            }
            if (numInstances != -1) {
                pw.println(prefix + "numInstances: " + numInstances);
            }
            if (violationNumThisLoop != 0) {
                pw.println(prefix + "violationNumThisLoop: " + violationNumThisLoop);
            }
            if (numAnimationsRunning != 0) {
                pw.println(prefix + "numAnimationsRunning: " + numAnimationsRunning);
            }
            pw.println(prefix + "violationUptimeMillis: " + violationUptimeMillis);
            if (broadcastIntentAction != null) {
                pw.println(prefix + "broadcastIntentAction: " + broadcastIntentAction);
            }
            if (tags != null) {
                int index = 0;
                for (String tag : tags) {
                    pw.println(prefix + "tag[" + (index++) + "]: " + tag);
                }
            }
        }
        
    }
    
    private static class InstanceCountViolation extends Throwable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.392 -0500", hash_original_field = "A02C654AC7E1DA7AAF40F127060FCDF1", hash_generated_field = "5B6CE22DDD6F454B97A831C7050366DC")

        private static final StackTraceElement[] FAKE_STACK = {
            new StackTraceElement("android.os.StrictMode", "setClassInstanceLimit",
                                  "StrictMode.java", 1)
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.384 -0500", hash_original_field = "CE233813880487C713DB65203E06BCD9", hash_generated_field = "CE233813880487C713DB65203E06BCD9")

         Class mClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.387 -0500", hash_original_field = "74080197B20CB35716F08D82964BE351", hash_generated_field = "74080197B20CB35716F08D82964BE351")

         long mInstances;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.390 -0500", hash_original_field = "EAF07362CB0DE5A45A6B09193DE62144", hash_generated_field = "EAF07362CB0DE5A45A6B09193DE62144")

         int mLimit;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.395 -0500", hash_original_method = "E80F10435372AA752F8DBC4C44A2404B", hash_generated_method = "1F44B1749B8AC59F99DBF2C991976773")
        
public InstanceCountViolation(Class klass, long instances, int limit) {
            super(klass.toString() + "; instances=" + instances + "; limit=" + limit);
            setStackTrace(FAKE_STACK);
            mClass = klass;
            mInstances = instances;
            mLimit = limit;
        }
    }
    
    private static final class InstanceTracker {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.411 -0500", hash_original_method = "C02E63494A43A201950056E55F3CBD0C", hash_generated_method = "7CAD8FEB118160808B68A1260CEF7531")
        
public static int getInstanceCount(Class<?> klass) {
            synchronized (sInstanceCounts) {
                final Integer value = sInstanceCounts.get(klass);
                return value != null ? value : 0;
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.400 -0500", hash_original_field = "8ABAA16849391A5123773C1CB9E5A257", hash_generated_field = "116A2F2FC172FA2FA149155E4F1D5CD5")

        private static final HashMap<Class<?>, Integer> sInstanceCounts =
                new HashMap<Class<?>, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.402 -0500", hash_original_field = "FD12CB27A6786C0FEBA5BE4C1FB74F1C", hash_generated_field = "C91F484EFB2D5A548FE76D861FC04B66")

        private  Class<?> mKlass;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.405 -0500", hash_original_method = "D1695326538E61C61B9A9871778AEDEF", hash_generated_method = "E209347E9BC35CDFDC1FA4464484E00F")
        
public InstanceTracker(Object instance) {
            mKlass = instance.getClass();

            synchronized (sInstanceCounts) {
                final Integer value = sInstanceCounts.get(mKlass);
                final int newValue = value != null ? value + 1 : 1;
                sInstanceCounts.put(mKlass, newValue);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.408 -0500", hash_original_method = "3D9E07641D189E499B7BA8CA77DD9FB9", hash_generated_method = "105486E1C62BBD74132CFE36E86DEC21")
        
@Override
        protected void finalize() throws Throwable {
            try {
                synchronized (sInstanceCounts) {
                    final Integer value = sInstanceCounts.get(mKlass);
                    if (value != null) {
                        final int newValue = value - 1;
                        if (newValue > 0) {
                            sInstanceCounts.put(mKlass, newValue);
                        } else {
                            sInstanceCounts.remove(mKlass);
                        }
                    }
                }
            } finally {
                super.finalize();
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.873 -0500", hash_original_field = "0BA915F699E1941BC307EA9FA638F9AA", hash_generated_field = "B71C40E2BD4A348A86F6A8DA6EFF35D9")

    private static final boolean LOG_V = Log.isLoggable(TAG, Log.VERBOSE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.875 -0500", hash_original_field = "9458A38F8A0C6004FBED798C6C1FA5F4", hash_generated_field = "23F752FC1CDA7050B5F1CC7BA955413B")

    private static final boolean IS_USER_BUILD = "user".equals(Build.TYPE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.878 -0500", hash_original_field = "3C3C2BD02B342D685B1CE8841A554EBE", hash_generated_field = "5633022DA578E314CF52EE3A9C0CF47D")

    private static final boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.880 -0500", hash_original_field = "98DEBB9B38288DD647FA1B2A538438DA", hash_generated_field = "3E92FD7ABB6619B38D620EDF029A22D9")

    public static final String DISABLE_PROPERTY = "persist.sys.strictmode.disable";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.883 -0500", hash_original_field = "F49B7999E64D62D67A40C26ADDCEB241", hash_generated_field = "E70A21C58D25E28726CC89D8D9240ACA")

    public static final String VISUAL_PROPERTY = "persist.sys.strictmode.visual";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.885 -0500", hash_original_field = "878D10447724020E173A11F4EB517A38", hash_generated_field = "FD19D25D87C076998E76A2F89CE1905E")

    private static final long MIN_LOG_INTERVAL_MS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.887 -0500", hash_original_field = "DFDCBBB023F1F29AED16EC9F43AC9059", hash_generated_field = "DA3F5640282C927DA73236D0BA3ECD57")

    private static final long MIN_DIALOG_INTERVAL_MS = 30000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.890 -0500", hash_original_field = "6910E93C2AB8CCFF55E8BE4513C782C3", hash_generated_field = "B19F03F9C3626AC77DC6B5D1D1998E3B")

    private static final int MAX_SPAN_TAGS = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.893 -0500", hash_original_field = "54EB6C91398D5262722E934A74F69EA9", hash_generated_field = "62D9C095D6B4A3AE1398D000AD43B62F")

    // of the Looper.
    private static final int MAX_OFFENSES_PER_LOOP = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.895 -0500", hash_original_field = "53C881171108C5423242795C1A71786C", hash_generated_field = "0DC8529A94304CAA555890F83F489EE2")

    /**
     * @hide
     */
    public static final int DETECT_DISK_WRITE = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.897 -0500", hash_original_field = "12F256B42DA03943B773FA2321D26107", hash_generated_field = "3B0BC9E776FCEF0C8599FE3E434D6AC6")

    /**
      * @hide
     */
    public static final int DETECT_DISK_READ = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.900 -0500", hash_original_field = "ADB4B3C7525A38377078D1B117E03CE6", hash_generated_field = "2C68E3EDD4C852D76A185E3C9D2D5904")

    /**
     * @hide
     */
    public static final int DETECT_NETWORK = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.902 -0500", hash_original_field = "983581883FF985383DDE1B43CAD42065", hash_generated_field = "47203AA0974E3F1ADE577FA7477EA93D")

    /**
     * For StrictMode.noteSlowCall()
     *
     * @hide
     */
    public static final int DETECT_CUSTOM = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.904 -0500", hash_original_field = "D07D692FDBE51E553CB02B1FB59E164C", hash_generated_field = "DEF661BA57DCADA99F22533CDFDF239C")

    private static final int ALL_THREAD_DETECT_BITS =
            DETECT_DISK_WRITE | DETECT_DISK_READ | DETECT_NETWORK | DETECT_CUSTOM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.907 -0500", hash_original_field = "3B0253E0A540645CCDCA0F998752F0D7", hash_generated_field = "42FCE94AB8F05A6621C7C2A7488B911F")

    /**
     * Note, a "VM_" bit, not thread.
     * @hide
     */
    public static final int DETECT_VM_CURSOR_LEAKS = 0x200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.910 -0500", hash_original_field = "12424A4B1A135F244B0827372FFF6509", hash_generated_field = "CF95C5EC7C9D91852EDD65FEC405E876")

    /**
     * Note, a "VM_" bit, not thread.
     * @hide
     */
    public static final int DETECT_VM_CLOSABLE_LEAKS = 0x400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.912 -0500", hash_original_field = "A95209BDC111FF0344FD6D9B839232F7", hash_generated_field = "01CA71CE407A71196CE88C91BB259835")

    /**
     * Note, a "VM_" bit, not thread.
     * @hide
     */
    public static final int DETECT_VM_ACTIVITY_LEAKS = 0x800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.914 -0500", hash_original_field = "978A80E092214D64EB92CE90304E95EF", hash_generated_field = "C79ED654FCB1C51584ABF483FD3D4EEC")

    /**
     * @hide
     */
    private static final int DETECT_VM_INSTANCE_LEAKS = 0x1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.917 -0500", hash_original_field = "B5C2B7A6C92B21957696DD3CF43027F3", hash_generated_field = "792A04564079CCBA55772389E5556C8F")

    private static final int ALL_VM_DETECT_BITS =
            DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS |
            DETECT_VM_ACTIVITY_LEAKS | DETECT_VM_INSTANCE_LEAKS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.919 -0500", hash_original_field = "18447843D21EA9B30ED6EA1B8103C72A", hash_generated_field = "AD440199AC90AA853DAE6E553309E61E")

    public static final int PENALTY_LOG = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.921 -0500", hash_original_field = "67A2C54ADA6FBBA64CC72C0B9A697A1B", hash_generated_field = "C77B7ABE6C3766A393E2A38820D63557")

    // Used for both process and thread policy:

    /**
     * @hide
     */
    public static final int PENALTY_DIALOG = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.924 -0500", hash_original_field = "BE667C23E13908C3A9F5E8A13874D02C", hash_generated_field = "36B2F4DE7C0AEF684C2D4A0EA98A5FF6")

    public static final int PENALTY_DEATH = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.926 -0500", hash_original_field = "092F36C56AB5DEAA334AE8E9967A2273", hash_generated_field = "43A59BD7C5C50C06D41CB3576F113D90")

    public static final int PENALTY_DEATH_ON_NETWORK = 0x200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.928 -0500", hash_original_field = "583805E8C4C6E9FDEB6AFE23AC2A93D5", hash_generated_field = "D95570E99357CC6CAAFB830E0B8059B4")

    public static final int PENALTY_FLASH = 0x800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.931 -0500", hash_original_field = "661FB812D06721FF77B38DAEBB4AA9F1", hash_generated_field = "97FF6CEFBEACB56FCE27CC1D38BF5293")

    public static final int PENALTY_DROPBOX = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.933 -0500", hash_original_field = "B5F8446F2DD133E70B4B7B76864AF3EC", hash_generated_field = "4A0AEEF9679F704885B2B478E1F03646")

    public static final int PENALTY_GATHER = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.936 -0500", hash_original_field = "E6ECC54F57561E0EC1232D79470EE6B7", hash_generated_field = "FCF43DBDCE0FE2111C7D3D0DB93F021C")

    private static final int THREAD_PENALTY_MASK =
            PENALTY_LOG | PENALTY_DIALOG | PENALTY_DEATH | PENALTY_DROPBOX | PENALTY_GATHER |
            PENALTY_DEATH_ON_NETWORK | PENALTY_FLASH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.939 -0500", hash_original_field = "0E53B3F02512C595F2F90AC2317545B8", hash_generated_field = "1570D6E62C2261DE7B2E5A5A8633B0EF")

    private static final int VM_PENALTY_MASK =
            PENALTY_LOG | PENALTY_DEATH | PENALTY_DROPBOX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.941 -0500", hash_original_field = "42F71D6BFD5B54609F9038D863D059B5", hash_generated_field = "9C78378872056437FDCC8F92B2971855")

    // Note: must be before static initialization of sVmPolicy.
    private static final HashMap<Class, Integer> EMPTY_CLASS_LIMIT_MAP = new HashMap<Class, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.943 -0500", hash_original_field = "E8480596A9AA31FFEA406E59DC62FBDC", hash_generated_field = "A2DC93C9353C0CDFE42E43F2EDB31797")

    private static volatile int sVmPolicyMask = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.945 -0500", hash_original_field = "33B31BD6E0D20DF8A54051E8A247F0F6", hash_generated_field = "6C6283435840FF828818AEADC035BB2B")

    private static volatile VmPolicy sVmPolicy = VmPolicy.LAX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.948 -0500", hash_original_field = "C20A572254971A537F79B40B361AAEEA", hash_generated_field = "2C9F276C45FCDF0FDB0E9335F3464F44")

    private static final AtomicInteger sDropboxCallsInFlight = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.374 -0400", hash_original_field = "032D1DB3AC7977666A8FEE9196953B73", hash_generated_field = "A9537943E12E1BE66F65A9E047340B84")

    private static final ThreadLocal<ArrayList<ViolationInfo>> gatheredViolations = new ThreadLocal<ArrayList<ViolationInfo>>() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.374 -0400", hash_original_method = "3F7643CB826EF0CE042B1409C79A26FA", hash_generated_method = "17F9046DABF4760439BFBA0AF9FA6792")
        @Override
        protected ArrayList<ViolationInfo> initialValue() {
            ArrayList<ViolationInfo> varB4EAC82CA7396A68D541C85D26508E83_2145674522 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2145674522 = null;
            varB4EAC82CA7396A68D541C85D26508E83_2145674522.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2145674522;
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.375 -0400", hash_original_field = "715B49E3F5CF23D0F2283607FFE671D2", hash_generated_field = "468766B1185D36E3C34C6CC8132A3BBA")

    private static final ThreadLocal<ArrayList<ViolationInfo>> violationsBeingTimed = new ThreadLocal<ArrayList<ViolationInfo>>() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.375 -0400", hash_original_method = "CB5695702D478EAB2FBBE8373134ED39", hash_generated_method = "DD5545FE6BD3BC5EEFC9A9B56ECE011C")
        @Override
        protected ArrayList<ViolationInfo> initialValue() {
            ArrayList<ViolationInfo> varB4EAC82CA7396A68D541C85D26508E83_122129988 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_122129988 = new ArrayList<ViolationInfo>();
            varB4EAC82CA7396A68D541C85D26508E83_122129988.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_122129988;
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.376 -0400", hash_original_field = "04600256D4F94A088BAF90F3ED687D15", hash_generated_field = "9E72204DB7595403D8ED153039D502F7")

    private static final ThreadLocal<Handler> threadHandler = new ThreadLocal<Handler>() {
    	
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.376 -0400", hash_original_method = "AFD0CE5945D0E9D14EE2FF5512B9324A", hash_generated_method = "785B4A8F3F59814D3C58DE7CA9CDAA9D")
        @Override
        protected Handler initialValue() {
            Handler varB4EAC82CA7396A68D541C85D26508E83_1280274125 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1280274125 = new Handler();
            varB4EAC82CA7396A68D541C85D26508E83_1280274125.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1280274125;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.225 -0500", hash_original_field = "BB487055B3905F3874C8ED09AA7AEB8C", hash_generated_field = "9856A17E5723F71B95FE2020E6AD7FC5")

    private static long sLastInstanceCountCheckMillis = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.227 -0500", hash_original_field = "03FCF333EB26A7253F59FA9B1A2CDB94", hash_generated_field = "620CC23E40F92E04CF705F8C05DDBFB2")

    private static boolean sIsIdlerRegistered = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.377 -0400", hash_original_field = "B164AA3A1AEF10C398FA471F54B9AC10", hash_generated_field = "76025C66C8858E75C2E2EE021C5EC2F6")

    private static final MessageQueue.IdleHandler sProcessIdleHandler = new MessageQueue.IdleHandler() {
    	
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.377 -0400", hash_original_method = "6956F5FF31712AF268FC89A0909C9E82", hash_generated_method = "884769DEEAC1BC5A58EFB848653AD4FF")
        public boolean queueIdle() {
            long now = SystemClock.uptimeMillis();
            {
                sLastInstanceCountCheckMillis = now;
                conditionallyCheckInstanceCounts();
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365236886 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365236886;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.252 -0500", hash_original_field = "315EBC33CE5C2829712C6671DC6E91E4", hash_generated_field = "EC2C449B6782F01CD0895152402E7785")

    private static final HashMap<Integer, Long> sLastVmViolationTime = new HashMap<Integer, Long>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.377 -0400", hash_original_field = "B86F8D90AB0DCFAFBC62E8F4A57E71BB", hash_generated_field = "A9868B4563548BD63158F22F4F3DE838")

    private static final Span NO_OP_SPAN = new Span() {
    	
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.377 -0400", hash_original_method = "D6FF905BC764A22CD5AFFCB47539B778", hash_generated_method = "3802941F36A062BAA51744D8D659BBA5")
        public void finish() {
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.378 -0400", hash_original_field = "B8165DB8CA25EBB672A04ED87F0CC32F", hash_generated_field = "96C1D1B545A479025D4E8BCB442BB45E")

    private static final ThreadLocal<ThreadSpanState> sThisThreadSpanState = new ThreadLocal<ThreadSpanState>() {
    	
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.378 -0400", hash_original_method = "3F056F46AA4E010EAE891B386F384542", hash_generated_method = "2A821F208287915B2CA2C4C1BA99BA14")
        @Override
        protected ThreadSpanState initialValue() {
            ThreadSpanState varB4EAC82CA7396A68D541C85D26508E83_693431700 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_693431700 = new ThreadSpanState();
            varB4EAC82CA7396A68D541C85D26508E83_693431700.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_693431700;
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.379 -0400", hash_original_field = "9012BF47FFA40D3BC924A9D478958B38", hash_generated_field = "8DE7816BA6907AF22598735C221C000A")

    private static Singleton<IWindowManager> sWindowManager = new Singleton<IWindowManager>() {
    	
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.379 -0400", hash_original_method = "5B1F4967C7C17AD573D088D6B70DB243", hash_generated_method = "C5ACD2CDD070A587CDD55EC8C8ED2603")
        protected IWindowManager create() {
            IWindowManager varB4EAC82CA7396A68D541C85D26508E83_2138217971 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2138217971 = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
            varB4EAC82CA7396A68D541C85D26508E83_2138217971.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2138217971;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:40.329 -0500", hash_original_field = "576836B99856F28B6DEB312A2069368B", hash_generated_field = "35AF5773760644A2175E84471F6DD6ED")

    private static final HashMap<Class, Integer> sExpectedActivityInstanceCount =
            new HashMap<Class, Integer>();

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.950 -0500", hash_original_method = "E3867A4A77A9B912C067B4B7EB14B6CB", hash_generated_method = "0D0ADA1BC3FB4C3229B88A9E8A267886")
    
private StrictMode() {}
}

