package android.os;

// Droidsafe Imports
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class StrictMode {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.746 -0400", hash_original_method = "E3867A4A77A9B912C067B4B7EB14B6CB", hash_generated_method = "4A3827557D89D96B907E9813E3C5AC14")
    private  StrictMode() {
        // ---------- Original Method ----------
    }

    
    public static void setThreadPolicy(final ThreadPolicy policy) {
        setThreadPolicyMask(policy.mask);
    }

    
    private static void setThreadPolicyMask(final int policyMask) {
        setBlockGuardPolicy(policyMask);
        Binder.setThreadStrictModePolicy(policyMask);
    }

    
    private static void setBlockGuardPolicy(final int policyMask) {
        if (policyMask == 0) {
            BlockGuard.setThreadPolicy(BlockGuard.LAX_POLICY);
            return;
        }
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            BlockGuard.setThreadPolicy(new AndroidBlockGuardPolicy(policyMask));
        } else {
            AndroidBlockGuardPolicy androidPolicy = (AndroidBlockGuardPolicy) policy;
            androidPolicy.setPolicyMask(policyMask);
        }
    }

    
    private static void setCloseGuardEnabled(boolean enabled) {
        if (!(CloseGuard.getReporter() instanceof AndroidCloseGuardReporter)) {
            CloseGuard.setReporter(new AndroidCloseGuardReporter());
        }
        CloseGuard.setEnabled(enabled);
    }

    
    public static int getThreadPolicyMask() {
        return BlockGuard.getThreadPolicy().getPolicyMask();
    }

    
    public static ThreadPolicy getThreadPolicy() {
        return new ThreadPolicy(getThreadPolicyMask());
    }

    
    public static ThreadPolicy allowThreadDiskWrites() {
        int oldPolicyMask = getThreadPolicyMask();
        int newPolicyMask = oldPolicyMask & ~(DETECT_DISK_WRITE | DETECT_DISK_READ);
        if (newPolicyMask != oldPolicyMask) {
            setThreadPolicyMask(newPolicyMask);
        }
        return new ThreadPolicy(oldPolicyMask);
    }

    
    public static ThreadPolicy allowThreadDiskReads() {
        int oldPolicyMask = getThreadPolicyMask();
        int newPolicyMask = oldPolicyMask & ~(DETECT_DISK_READ);
        if (newPolicyMask != oldPolicyMask) {
            setThreadPolicyMask(newPolicyMask);
        }
        return new ThreadPolicy(oldPolicyMask);
    }

    
    private static boolean amTheSystemServerProcess() {
        if (Process.myUid() != Process.SYSTEM_UID) {
            return false;
        }
        Throwable stack = new Throwable();
        stack.fillInStackTrace();
        for (StackTraceElement ste : stack.getStackTrace()) {
            String clsName = ste.getClassName();
            if (clsName != null && clsName.startsWith("com.android.server.")) {
                return true;
            }
        }
        return false;
    }

    
    public static boolean conditionallyEnableDebugLogging() {
        boolean doFlashes = SystemProperties.getBoolean(VISUAL_PROPERTY, false)
                && !amTheSystemServerProcess();
        final boolean suppress = SystemProperties.getBoolean(DISABLE_PROPERTY, false);
        if (!doFlashes && (IS_USER_BUILD || suppress)) {
            setCloseGuardEnabled(false);
            return false;
        }
        if (IS_ENG_BUILD) {
            doFlashes = true;
        }
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
    }

    
    public static void enableDeathOnNetwork() {
        int oldPolicy = getThreadPolicyMask();
        int newPolicy = oldPolicy | DETECT_NETWORK | PENALTY_DEATH_ON_NETWORK;
        setThreadPolicyMask(newPolicy);
    }

    
    private static int parsePolicyFromMessage(String message) {
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
        }
    }

    
    private static int parseViolationFromMessage(String message) {
        if (message == null) {
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
        }
    }

    
    private static boolean tooManyViolationsThisLoop() {
        return violationsBeingTimed.get().size() >= MAX_OFFENSES_PER_LOOP;
    }

    
    private static void executeDeathPenalty(ViolationInfo info) {
        int violationBit = parseViolationFromMessage(info.crashInfo.exceptionMessage);
        throw new StrictModeViolation(info.policy, violationBit, null);
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

    
    static boolean hasGatheredViolations() {
        return gatheredViolations.get() != null;
    }

    
    static void clearGatheredViolations() {
        gatheredViolations.set(null);
    }

    
    public static void conditionallyCheckInstanceCounts() {
        VmPolicy policy = getVmPolicy();
        if (policy.classInstanceLimit.size() == 0) {
            return;
        }
        Runtime.getRuntime().gc();
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

    
    public static void setVmPolicy(final VmPolicy policy) {
        synchronized (StrictMode.class) {
            sVmPolicy = policy;
            sVmPolicyMask = policy.mask;
            setCloseGuardEnabled(vmClosableObjectLeaksEnabled());
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
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static VmPolicy getVmPolicy() {
        synchronized (StrictMode.class) {
            return sVmPolicy;
        }
    }

    
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

    
    @DSModeled(DSC.SAFE)
    public static boolean vmSqliteObjectLeaksEnabled() {
        return (sVmPolicyMask & DETECT_VM_CURSOR_LEAKS) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean vmClosableObjectLeaksEnabled() {
        return (sVmPolicyMask & DETECT_VM_CLOSABLE_LEAKS) != 0;
    }

    
    public static void onSqliteObjectLeaked(String message, Throwable originStack) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onVmPolicyViolation(message, originStack);
    }

    
    public static void onWebViewMethodCalledOnWrongThread(Throwable originStack) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onVmPolicyViolation(null, originStack);
    }

    
    public static void onVmPolicyViolation(String message, Throwable originStack) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final boolean penaltyDropbox = (sVmPolicyMask & PENALTY_DROPBOX) != 0;
        final boolean penaltyDeath = (sVmPolicyMask & PENALTY_DEATH) != 0;
        final boolean penaltyLog = (sVmPolicyMask & PENALTY_LOG) != 0;
        final ViolationInfo info = new ViolationInfo(originStack, sVmPolicyMask);
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
            dropboxViolationAsync(violationMaskSubset, info);
            return;
        }
        if (penaltyDropbox && lastViolationTime == 0) {
            final int savedPolicyMask = getThreadPolicyMask();
            try {
                setThreadPolicyMask(0);
                ActivityManagerNative.getDefault().handleApplicationStrictModeViolation(
                    RuntimeInit.getApplicationObject(),
                    violationMaskSubset,
                    info);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException trying to handle StrictMode violation", e);
            } finally {
                setThreadPolicyMask(savedPolicyMask);
            }
        }
        if (penaltyDeath) {
            System.err.println("StrictMode VmPolicy violation with POLICY_DEATH; shutting down.");
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
    }

    
    static void writeGatheredViolationsToParcel(Parcel p) {
        ArrayList<ViolationInfo> violations = gatheredViolations.get();
        if (violations == null) {
            p.writeInt(0);
        } else {
            p.writeInt(violations.size());
            for (int i = 0; i < violations.size(); ++i) {
                violations.get(i).writeToParcel(p, 0 );
            }
            if (LOG_V) Log.d(TAG, "wrote violations to response parcel; num=" + violations.size());
            violations.clear(); 
        }
        gatheredViolations.set(null);
    }

    
    static void readAndHandleBinderCallViolations(Parcel p) {
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

    
    private static void onBinderStrictModePolicyChange(int newPolicy) {
        setBlockGuardPolicy(newPolicy);
    }

    
    public static Span enterCriticalSpan(String name) {
        if (IS_USER_BUILD) {
            return NO_OP_SPAN;
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name must be non-null and non-empty");
        }
        ThreadSpanState state = sThisThreadSpanState.get();
        Span span = null;
        synchronized (state) {
            if (state.mFreeListHead != null) {
                span = state.mFreeListHead;
                state.mFreeListHead = span.mNext;
                state.mFreeListSize--;
            } else {
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
        return span;
    }

    
    public static void noteSlowCall(String name) {
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onCustomSlowCall(name);
    }

    
    public static void noteDiskRead() {
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onReadFromDisk();
    }

    
    public static void noteDiskWrite() {
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onWriteToDisk();
    }

    
    public static Object trackActivity(Object instance) {
        return new InstanceTracker(instance);
    }

    
    public static void incrementExpectedActivityCount(Class klass) {
        if (klass == null) {
            return;
        }
        synchronized (StrictMode.class) {
            if ((sVmPolicy.mask & DETECT_VM_ACTIVITY_LEAKS) == 0) {
                return;
            }
            Integer expected = sExpectedActivityInstanceCount.get(klass);
            Integer newExpected = expected == null ? 1 : expected + 1;
            sExpectedActivityInstanceCount.put(klass, newExpected);
        }
    }

    
    public static void decrementExpectedActivityCount(Class klass) {
        if (klass == null) {
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
            limit = newExpected + 1;
        }
        int actual = InstanceTracker.getInstanceCount(klass);
        if (actual <= limit) {
            return;
        }
        Runtime.getRuntime().gc();
        long instances = VMDebug.countInstancesOfClass(klass, false);
        if (instances > limit) {
            Throwable tr = new InstanceCountViolation(klass, instances, limit);
            onVmPolicyViolation(tr.getMessage(), tr);
        }
    }

    
    public static final class ThreadPolicy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.750 -0400", hash_original_field = "F2CE11EBF110993621BEDD8E747D7B1B", hash_generated_field = "DB965A11139AB665B00B4D2E2ABFFB32")

        int mask;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.750 -0400", hash_original_method = "B0AC15ACB9093249F94C953D0A842CAE", hash_generated_method = "CD2B4FBA33571E2F2EF5D0491C95A1F6")
        private  ThreadPolicy(int mask) {
            this.mask = mask;
            // ---------- Original Method ----------
            //this.mask = mask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.750 -0400", hash_original_method = "AE05BE3A66BEE06993F7653F4CB681EB", hash_generated_method = "2422CBCDB661511AE3AA16A2CCD42659")
        @Override
        public String toString() {
String varEA020F0794DC249B4DFA91451430514A_1897088837 =             "[StrictMode.ThreadPolicy; mask=" + mask + "]";
            varEA020F0794DC249B4DFA91451430514A_1897088837.addTaint(taint);
            return varEA020F0794DC249B4DFA91451430514A_1897088837;
            // ---------- Original Method ----------
            //return "[StrictMode.ThreadPolicy; mask=" + mask + "]";
        }

        
        public static final class Builder {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.750 -0400", hash_original_field = "1C55ADB17279BAC09579C0440A039180", hash_generated_field = "B8B68F2E3B571F250FDA42AEED6F96EC")

            private int mMask = 0;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.750 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "C4A90307B6990541B60C2B86DCD4B526")
            public  Builder() {
                mMask = 0;
                // ---------- Original Method ----------
                //mMask = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.750 -0400", hash_original_method = "2270BC971D9C4F82FBD51366B809A76A", hash_generated_method = "631C274E04C6C0B7E08BF52CFE1C0EDE")
            public  Builder(ThreadPolicy policy) {
                mMask = policy.mask;
                // ---------- Original Method ----------
                //mMask = policy.mask;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.751 -0400", hash_original_method = "399752AE3320783E8BC4077BF2BAABAB", hash_generated_method = "07C1C26EAD19A72D87AB0C27B2E49029")
            public Builder detectAll() {
Builder varF8028DE273C96D9B4307CF88AD033CC0_970729084 =                 enable(ALL_THREAD_DETECT_BITS);
                varF8028DE273C96D9B4307CF88AD033CC0_970729084.addTaint(taint);
                return varF8028DE273C96D9B4307CF88AD033CC0_970729084;
                // ---------- Original Method ----------
                //return enable(ALL_THREAD_DETECT_BITS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.751 -0400", hash_original_method = "3E31B254E1B4E9A5234881E68AADF1C7", hash_generated_method = "70E5FA0ED9A0D7E62A31BA148947946D")
            public Builder permitAll() {
Builder var127B5FA52E24BFBDE16E8DA40A786827_471918344 =                 disable(ALL_THREAD_DETECT_BITS);
                var127B5FA52E24BFBDE16E8DA40A786827_471918344.addTaint(taint);
                return var127B5FA52E24BFBDE16E8DA40A786827_471918344;
                // ---------- Original Method ----------
                //return disable(ALL_THREAD_DETECT_BITS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.751 -0400", hash_original_method = "8F1CC5D4BDA427578EB68B001E341FDD", hash_generated_method = "0CD136C19682D1F5FB1B27795853E777")
            public Builder detectNetwork() {
Builder var060B56A9EE6E877186348768E1026203_496671497 =                 enable(DETECT_NETWORK);
                var060B56A9EE6E877186348768E1026203_496671497.addTaint(taint);
                return var060B56A9EE6E877186348768E1026203_496671497;
                // ---------- Original Method ----------
                //return enable(DETECT_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.751 -0400", hash_original_method = "2A4244001D1666DDAFB3F602ED8EC7EA", hash_generated_method = "9C21C84799D74CEA7071CD454128C5CA")
            public Builder permitNetwork() {
Builder var11897196A9FAF00B1E55698E6825D150_1488759416 =                 disable(DETECT_NETWORK);
                var11897196A9FAF00B1E55698E6825D150_1488759416.addTaint(taint);
                return var11897196A9FAF00B1E55698E6825D150_1488759416;
                // ---------- Original Method ----------
                //return disable(DETECT_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.751 -0400", hash_original_method = "75C524432F954C01B0149630CE54DDB4", hash_generated_method = "5D48DD135E72B972FF40F3AA53812743")
            public Builder detectDiskReads() {
Builder var3F063EB9BA6514A4587A93DCF87C0A3F_1112233187 =                 enable(DETECT_DISK_READ);
                var3F063EB9BA6514A4587A93DCF87C0A3F_1112233187.addTaint(taint);
                return var3F063EB9BA6514A4587A93DCF87C0A3F_1112233187;
                // ---------- Original Method ----------
                //return enable(DETECT_DISK_READ);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.751 -0400", hash_original_method = "1BD98C02F9A11EE892D0098B20BDD8BD", hash_generated_method = "1308C47E3D0C647F8B68CB2FE126EBC9")
            public Builder permitDiskReads() {
Builder var12A35DDA5597598C86F385006473D33F_742670652 =                 disable(DETECT_DISK_READ);
                var12A35DDA5597598C86F385006473D33F_742670652.addTaint(taint);
                return var12A35DDA5597598C86F385006473D33F_742670652;
                // ---------- Original Method ----------
                //return disable(DETECT_DISK_READ);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.751 -0400", hash_original_method = "0F761933C6E4A91421ABB8964A4D9EB8", hash_generated_method = "3D92E7A58F1CE88ECE753B17BF8239CC")
            public Builder detectCustomSlowCalls() {
Builder varB551A65CDB5E9D4D674BF0E51A845100_914489296 =                 enable(DETECT_CUSTOM);
                varB551A65CDB5E9D4D674BF0E51A845100_914489296.addTaint(taint);
                return varB551A65CDB5E9D4D674BF0E51A845100_914489296;
                // ---------- Original Method ----------
                //return enable(DETECT_CUSTOM);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.751 -0400", hash_original_method = "1F5E52FF134E5A595D9B4F3AD9EF805B", hash_generated_method = "7029BDB3930F98A5DD39908427651579")
            public Builder permitCustomSlowCalls() {
Builder varB551A65CDB5E9D4D674BF0E51A845100_1863351094 =                 enable(DETECT_CUSTOM);
                varB551A65CDB5E9D4D674BF0E51A845100_1863351094.addTaint(taint);
                return varB551A65CDB5E9D4D674BF0E51A845100_1863351094;
                // ---------- Original Method ----------
                //return enable(DETECT_CUSTOM);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.751 -0400", hash_original_method = "583E0D5D228DC11F4F3B1B541EE8393C", hash_generated_method = "D51D94EA353CAFF60F2EC84B55B81EDA")
            public Builder detectDiskWrites() {
Builder varDD77C3520ED2D64CC1AB70214F6E6110_1853935928 =                 enable(DETECT_DISK_WRITE);
                varDD77C3520ED2D64CC1AB70214F6E6110_1853935928.addTaint(taint);
                return varDD77C3520ED2D64CC1AB70214F6E6110_1853935928;
                // ---------- Original Method ----------
                //return enable(DETECT_DISK_WRITE);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.751 -0400", hash_original_method = "A37C6D388BF979AC5AEB871BAB2E0B6F", hash_generated_method = "E8801E98186E200CDE2B15C8AA4497B9")
            public Builder permitDiskWrites() {
Builder var24EE8F4D13A53650B5D44898DCAA4E34_181589665 =                 disable(DETECT_DISK_WRITE);
                var24EE8F4D13A53650B5D44898DCAA4E34_181589665.addTaint(taint);
                return var24EE8F4D13A53650B5D44898DCAA4E34_181589665;
                // ---------- Original Method ----------
                //return disable(DETECT_DISK_WRITE);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.752 -0400", hash_original_method = "8766DB09D651E2B3541ACB0418FFA365", hash_generated_method = "469F172247834C12102BA9DE61DB92D3")
            public Builder penaltyDialog() {
Builder var4FB3EC1CFDBDC4DC0249B9B2B8BFFEAB_974043980 =                 enable(PENALTY_DIALOG);
                var4FB3EC1CFDBDC4DC0249B9B2B8BFFEAB_974043980.addTaint(taint);
                return var4FB3EC1CFDBDC4DC0249B9B2B8BFFEAB_974043980;
                // ---------- Original Method ----------
                //return enable(PENALTY_DIALOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.752 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "609E0F3274E1E7CDB20C8C1214B54E39")
            public Builder penaltyDeath() {
Builder var6F115A07D237A33880541F25719D67B0_2002099028 =                 enable(PENALTY_DEATH);
                var6F115A07D237A33880541F25719D67B0_2002099028.addTaint(taint);
                return var6F115A07D237A33880541F25719D67B0_2002099028;
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.752 -0400", hash_original_method = "3B3840DC05B4A1C1129369D4324CF6E7", hash_generated_method = "3D5AC88C889441FB478F87F175763419")
            public Builder penaltyDeathOnNetwork() {
Builder var4D622F4AC95636106DBB9B4371461C0F_751186870 =                 enable(PENALTY_DEATH_ON_NETWORK);
                var4D622F4AC95636106DBB9B4371461C0F_751186870.addTaint(taint);
                return var4D622F4AC95636106DBB9B4371461C0F_751186870;
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH_ON_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.752 -0400", hash_original_method = "D2175CC28C327D3A1AEA760A679D2369", hash_generated_method = "8F9C88FFD1E949E24AB369C90C4296FB")
            public Builder penaltyFlashScreen() {
Builder var7AEBB7BE9C233214B8A8E14BB80D42F5_1988865061 =                 enable(PENALTY_FLASH);
                var7AEBB7BE9C233214B8A8E14BB80D42F5_1988865061.addTaint(taint);
                return var7AEBB7BE9C233214B8A8E14BB80D42F5_1988865061;
                // ---------- Original Method ----------
                //return enable(PENALTY_FLASH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.752 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "1CC4D4A210E00B6613436E78672F1FE6")
            public Builder penaltyLog() {
Builder var7C46BCB224406F4BC478971CF4360D87_1331381772 =                 enable(PENALTY_LOG);
                var7C46BCB224406F4BC478971CF4360D87_1331381772.addTaint(taint);
                return var7C46BCB224406F4BC478971CF4360D87_1331381772;
                // ---------- Original Method ----------
                //return enable(PENALTY_LOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.752 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "2C3BD61C95D9EE847E2B40DEE3DDB588")
            public Builder penaltyDropBox() {
Builder varC3126CEB2524227BCB28FCD226FE486C_1747300594 =                 enable(PENALTY_DROPBOX);
                varC3126CEB2524227BCB28FCD226FE486C_1747300594.addTaint(taint);
                return varC3126CEB2524227BCB28FCD226FE486C_1747300594;
                // ---------- Original Method ----------
                //return enable(PENALTY_DROPBOX);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.752 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "2254A93B7EA82193EB3433A6A97592A0")
            private Builder enable(int bit) {
                mMask |= bit;
Builder var72A74007B2BE62B849F475C7BDA4658B_366612052 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_366612052.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_366612052;
                // ---------- Original Method ----------
                //mMask |= bit;
                //return this;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.752 -0400", hash_original_method = "DD377E4C338D3B09C11C3D4D7DFD99D3", hash_generated_method = "FB995DD0D8A66E96AE5E8F78D6779930")
            private Builder disable(int bit) {
                mMask &= ~bit;
Builder var72A74007B2BE62B849F475C7BDA4658B_2078753159 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_2078753159.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_2078753159;
                // ---------- Original Method ----------
                //mMask &= ~bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.753 -0400", hash_original_method = "3E686B94A275CF17A4C5CE0839D3E8D1", hash_generated_method = "0ABF8621E457633E1FD59B25E1C65592")
            public ThreadPolicy build() {
                if(mMask != 0 &&
                    (mMask & (PENALTY_DEATH | PENALTY_LOG |
                              PENALTY_DROPBOX | PENALTY_DIALOG)) == 0)                
                {
                    penaltyLog();
                } //End block
ThreadPolicy varEBA1A0201E5503996C968AF363927B41_1318457206 =                 new ThreadPolicy(mMask);
                varEBA1A0201E5503996C968AF363927B41_1318457206.addTaint(taint);
                return varEBA1A0201E5503996C968AF363927B41_1318457206;
                // ---------- Original Method ----------
                //if (mMask != 0 &&
                    //(mMask & (PENALTY_DEATH | PENALTY_LOG |
                              //PENALTY_DROPBOX | PENALTY_DIALOG)) == 0) {
                    //penaltyLog();
                //}
                //return new ThreadPolicy(mMask);
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.753 -0400", hash_original_field = "E7DFCA04F3BE5F51D0361BA13D9F3EA4", hash_generated_field = "9578A9475850D552D61F6D5FCB916824")

        public static final ThreadPolicy LAX = new ThreadPolicy(0);
    }


    
    public static final class VmPolicy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.753 -0400", hash_original_field = "F2CE11EBF110993621BEDD8E747D7B1B", hash_generated_field = "DB965A11139AB665B00B4D2E2ABFFB32")

        int mask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.753 -0400", hash_original_field = "3FBB4B56631DFF224756AA0554DAE984", hash_generated_field = "C4A68A411991D38DAC450888E1864E75")

        HashMap<Class, Integer> classInstanceLimit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.753 -0400", hash_original_method = "BE6E35A5EA1ACA059EF2A402B69D7023", hash_generated_method = "AF3E0963E335112AB7A8226A9368692D")
        private  VmPolicy(int mask, HashMap<Class, Integer> classInstanceLimit) {
            if(classInstanceLimit == null)            
            {
                NullPointerException var7477CAB079CA09E117BDAE6A2F278039_985346947 = new NullPointerException("classInstanceLimit == null");
                var7477CAB079CA09E117BDAE6A2F278039_985346947.addTaint(taint);
                throw var7477CAB079CA09E117BDAE6A2F278039_985346947;
            } //End block
            this.mask = mask;
            this.classInstanceLimit = classInstanceLimit;
            // ---------- Original Method ----------
            //if (classInstanceLimit == null) {
                //throw new NullPointerException("classInstanceLimit == null");
            //}
            //this.mask = mask;
            //this.classInstanceLimit = classInstanceLimit;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.753 -0400", hash_original_method = "338C4A4B8F91E885EB5A5562BE10EA45", hash_generated_method = "BEBFFB7DC503947BF6A3A5B3E6B556B4")
        @Override
        public String toString() {
String var1CA5F32371B0F7CE34D9E4113B1966E8_99951224 =             "[StrictMode.VmPolicy; mask=" + mask + "]";
            var1CA5F32371B0F7CE34D9E4113B1966E8_99951224.addTaint(taint);
            return var1CA5F32371B0F7CE34D9E4113B1966E8_99951224;
            // ---------- Original Method ----------
            //return "[StrictMode.VmPolicy; mask=" + mask + "]";
        }

        
        public static final class Builder {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.754 -0400", hash_original_field = "E08A8EE01FA9CEC4B820220831BC5DE3", hash_generated_field = "F7C8905D5B34EE793946807F2A7E20A1")

            private int mMask;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.754 -0400", hash_original_field = "9CEE277A3C9F90A2D4A6976F0323CE98", hash_generated_field = "7DA905668F7F3F2312998927AB27A0B2")

            private HashMap<Class, Integer> mClassInstanceLimit;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.754 -0400", hash_original_field = "1E770C9E586080F95CD045212B6277DA", hash_generated_field = "2D6485C7C663B1648AF525BB6C2310A9")

            private boolean mClassInstanceLimitNeedCow = false;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.754 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "C4A90307B6990541B60C2B86DCD4B526")
            public  Builder() {
                mMask = 0;
                // ---------- Original Method ----------
                //mMask = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.754 -0400", hash_original_method = "FBB1CB3954D34CB1AD109CEFAD7B1DDE", hash_generated_method = "5B93757689D973A3868B8E54B0D3C06F")
            public  Builder(VmPolicy base) {
                mMask = base.mask;
                mClassInstanceLimitNeedCow = true;
                mClassInstanceLimit = base.classInstanceLimit;
                // ---------- Original Method ----------
                //mMask = base.mask;
                //mClassInstanceLimitNeedCow = true;
                //mClassInstanceLimit = base.classInstanceLimit;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.754 -0400", hash_original_method = "E6B0AD736B79FE1E50987D22EA6466E3", hash_generated_method = "32EE6C83860031C8A04FF5BDEE3ADDEC")
            public Builder setClassInstanceLimit(Class klass, int instanceLimit) {
                addTaint(instanceLimit);
                addTaint(klass.getTaint());
                if(klass == null)                
                {
                    NullPointerException varEC8722BB6331CF6DCBF064C77DE13ACE_490234587 = new NullPointerException("klass == null");
                    varEC8722BB6331CF6DCBF064C77DE13ACE_490234587.addTaint(taint);
                    throw varEC8722BB6331CF6DCBF064C77DE13ACE_490234587;
                } //End block
                if(mClassInstanceLimitNeedCow)                
                {
                    if(mClassInstanceLimit.containsKey(klass) &&
                        mClassInstanceLimit.get(klass) == instanceLimit)                    
                    {
Builder var72A74007B2BE62B849F475C7BDA4658B_1611926109 =                         this;
                        var72A74007B2BE62B849F475C7BDA4658B_1611926109.addTaint(taint);
                        return var72A74007B2BE62B849F475C7BDA4658B_1611926109;
                    } //End block
                    mClassInstanceLimitNeedCow = false;
                    mClassInstanceLimit = (HashMap<Class, Integer>) mClassInstanceLimit.clone();
                } //End block
                else
                if(mClassInstanceLimit == null)                
                {
                    mClassInstanceLimit = new HashMap<Class, Integer>();
                } //End block
                mMask |= DETECT_VM_INSTANCE_LEAKS;
                mClassInstanceLimit.put(klass, instanceLimit);
Builder var72A74007B2BE62B849F475C7BDA4658B_1904288568 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1904288568.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1904288568;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "1E52C56D15D33FA545E602A30D1B7293", hash_generated_method = "56E21CC43B28853CA1326D5674BFAB2E")
            public Builder detectActivityLeaks() {
Builder var8524FF6E5F58BD95313BDC3DEBCA1C6C_315409102 =                 enable(DETECT_VM_ACTIVITY_LEAKS);
                var8524FF6E5F58BD95313BDC3DEBCA1C6C_315409102.addTaint(taint);
                return var8524FF6E5F58BD95313BDC3DEBCA1C6C_315409102;
                // ---------- Original Method ----------
                //return enable(DETECT_VM_ACTIVITY_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "CEAA7924A62774EE9F1DB0EAFC23F606", hash_generated_method = "5F954BEE109498F2781F9EEB0D5AE57A")
            public Builder detectAll() {
Builder var1CCC29012BEF03C8B2CAA346F1691BB7_203819372 =                 enable(DETECT_VM_ACTIVITY_LEAKS |
                        DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS);
                var1CCC29012BEF03C8B2CAA346F1691BB7_203819372.addTaint(taint);
                return var1CCC29012BEF03C8B2CAA346F1691BB7_203819372;
                // ---------- Original Method ----------
                //return enable(DETECT_VM_ACTIVITY_LEAKS |
                        //DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "7CA55A1EF27E65D4088A38B2843E1EE5", hash_generated_method = "EB80A4EF8088D6E6DC1F3A183354C015")
            public Builder detectLeakedSqlLiteObjects() {
Builder var299E070569B7903CA6AB30AF17C33B96_255832132 =                 enable(DETECT_VM_CURSOR_LEAKS);
                var299E070569B7903CA6AB30AF17C33B96_255832132.addTaint(taint);
                return var299E070569B7903CA6AB30AF17C33B96_255832132;
                // ---------- Original Method ----------
                //return enable(DETECT_VM_CURSOR_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "76FD4F08E7705E8F66E31708D9A399EA", hash_generated_method = "E32FFE8A02A294B784D30CDB11F62F91")
            public Builder detectLeakedClosableObjects() {
Builder var97E97BCCFDD5CCC88D830C9545A76C50_642377558 =                 enable(DETECT_VM_CLOSABLE_LEAKS);
                var97E97BCCFDD5CCC88D830C9545A76C50_642377558.addTaint(taint);
                return var97E97BCCFDD5CCC88D830C9545A76C50_642377558;
                // ---------- Original Method ----------
                //return enable(DETECT_VM_CLOSABLE_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "70D58CB86738E652D64572B273F4DEEA")
            public Builder penaltyDeath() {
Builder var6F115A07D237A33880541F25719D67B0_1559101226 =                 enable(PENALTY_DEATH);
                var6F115A07D237A33880541F25719D67B0_1559101226.addTaint(taint);
                return var6F115A07D237A33880541F25719D67B0_1559101226;
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "500E5F189D822DE77B9BA7533BD281D3")
            public Builder penaltyLog() {
Builder var7C46BCB224406F4BC478971CF4360D87_1946014504 =                 enable(PENALTY_LOG);
                var7C46BCB224406F4BC478971CF4360D87_1946014504.addTaint(taint);
                return var7C46BCB224406F4BC478971CF4360D87_1946014504;
                // ---------- Original Method ----------
                //return enable(PENALTY_LOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "534BBD6BF05727FEE3669BE78D059282")
            public Builder penaltyDropBox() {
Builder varC3126CEB2524227BCB28FCD226FE486C_1272195904 =                 enable(PENALTY_DROPBOX);
                varC3126CEB2524227BCB28FCD226FE486C_1272195904.addTaint(taint);
                return varC3126CEB2524227BCB28FCD226FE486C_1272195904;
                // ---------- Original Method ----------
                //return enable(PENALTY_DROPBOX);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.755 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "879AA6DE2768B208ED13B14418D603DB")
            private Builder enable(int bit) {
                mMask |= bit;
Builder var72A74007B2BE62B849F475C7BDA4658B_2113603366 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_2113603366.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_2113603366;
                // ---------- Original Method ----------
                //mMask |= bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.756 -0400", hash_original_method = "6432BC9C97797DD02AE9BFA4A7F87D54", hash_generated_method = "05E1581C7328C92BCADD8F8C1C68EE97")
            public VmPolicy build() {
                if(mMask != 0 &&
                    (mMask & (PENALTY_DEATH | PENALTY_LOG |
                              PENALTY_DROPBOX | PENALTY_DIALOG)) == 0)                
                {
                    penaltyLog();
                } //End block
VmPolicy varE95CDCB511F5178776413479725D337E_1354535532 =                 new VmPolicy(mMask,
                        mClassInstanceLimit != null ? mClassInstanceLimit : EMPTY_CLASS_LIMIT_MAP);
                varE95CDCB511F5178776413479725D337E_1354535532.addTaint(taint);
                return varE95CDCB511F5178776413479725D337E_1354535532;
                // ---------- Original Method ----------
                //if (mMask != 0 &&
                    //(mMask & (PENALTY_DEATH | PENALTY_LOG |
                              //PENALTY_DROPBOX | PENALTY_DIALOG)) == 0) {
                    //penaltyLog();
                //}
                //return new VmPolicy(mMask,
                        //mClassInstanceLimit != null ? mClassInstanceLimit : EMPTY_CLASS_LIMIT_MAP);
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.756 -0400", hash_original_field = "F1C7D869EBAAFBDF7AEDBE7466A42F96", hash_generated_field = "9254DDC9D251934961027FD07388D251")

        public static final VmPolicy LAX = new VmPolicy(0, EMPTY_CLASS_LIMIT_MAP);
    }


    
    public static class StrictModeViolation extends BlockGuard.BlockGuardPolicyException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.756 -0400", hash_original_method = "E7438DD65D448EA29E2BF1E2E7B9AF17", hash_generated_method = "A50A194961232A2B4D645FB225F1D1B2")
        public  StrictModeViolation(int policyState, int policyViolated, String message) {
            super(policyState, policyViolated, message);
            addTaint(message.getTaint());
            addTaint(policyViolated);
            addTaint(policyState);
            // ---------- Original Method ----------
        }

        
    }


    
    public static class StrictModeNetworkViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.756 -0400", hash_original_method = "DBBD717A236AEADDFBDE9EEC846203D0", hash_generated_method = "67817CB14B73DDA8A675A65BE03ACCB8")
        public  StrictModeNetworkViolation(int policyMask) {
            super(policyMask, DETECT_NETWORK, null);
            addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeDiskReadViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.756 -0400", hash_original_method = "50FAC78594B32A364EC38A7051A6D828", hash_generated_method = "45037306A9E5DF86F945894246B125E2")
        public  StrictModeDiskReadViolation(int policyMask) {
            super(policyMask, DETECT_DISK_READ, null);
            addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeDiskWriteViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.756 -0400", hash_original_method = "3E79DB089B8A8B103215C527DD70DC9D", hash_generated_method = "FC816BAC3953BE8E9F2D0633D3D74C62")
        public  StrictModeDiskWriteViolation(int policyMask) {
            super(policyMask, DETECT_DISK_WRITE, null);
            addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeCustomViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.756 -0400", hash_original_method = "D9775B5587EA33BC7CC7CE8D67F82D3A", hash_generated_method = "5C43A99AC1E40725AB9B9C38176D456C")
        public  StrictModeCustomViolation(int policyMask, String name) {
            super(policyMask, DETECT_CUSTOM, name);
            addTaint(name.getTaint());
            addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class AndroidBlockGuardPolicy implements BlockGuard.Policy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.757 -0400", hash_original_field = "762A5B3087E77BD4ABEEF3C3AF201E66", hash_generated_field = "A3F55928E2CD42B0872F6832B90FE4B8")

        private int mPolicyMask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.757 -0400", hash_original_field = "5836A78E9559B1DE0C28FCB615157AD2", hash_generated_field = "6460400958C25B64276F7B45AA1AE3E6")

        private final HashMap<Integer, Long> mLastViolationTime = new HashMap<Integer, Long>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.757 -0400", hash_original_method = "56B73F441F57B7F1580692BF8D8E5ECB", hash_generated_method = "D44A205806718F04E37473DFF9A09152")
        public  AndroidBlockGuardPolicy(final int policyMask) {
            mPolicyMask = policyMask;
            // ---------- Original Method ----------
            //mPolicyMask = policyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.757 -0400", hash_original_method = "EC02A08C2D3910C2DE1DA94FE738CE60", hash_generated_method = "BF991861DFB4A36D720433980D173AD7")
        @Override
        public String toString() {
String var88FE0C10C841ADC188489DE26D480D44_1591693979 =             "AndroidBlockGuardPolicy; mPolicyMask=" + mPolicyMask;
            var88FE0C10C841ADC188489DE26D480D44_1591693979.addTaint(taint);
            return var88FE0C10C841ADC188489DE26D480D44_1591693979;
            // ---------- Original Method ----------
            //return "AndroidBlockGuardPolicy; mPolicyMask=" + mPolicyMask;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.758 -0400", hash_original_method = "BDAE35F9BC36FEF12DCB9013D520032B", hash_generated_method = "3C42E5B32F36B81211BB8A86194E605B")
        public int getPolicyMask() {
            int var762A5B3087E77BD4ABEEF3C3AF201E66_1303326739 = (mPolicyMask);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_186333667 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_186333667;
            // ---------- Original Method ----------
            //return mPolicyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.758 -0400", hash_original_method = "0D85458AC3FF96FC22E8C3819C12EFAB", hash_generated_method = "939C668F45930394A597ACFF2F9393D0")
        public void onWriteToDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if((mPolicyMask & DETECT_DISK_WRITE) == 0)            
            {
                return;
            } //End block
            if(tooManyViolationsThisLoop())            
            {
                return;
            } //End block
            BlockGuard.BlockGuardPolicyException e = new StrictModeDiskWriteViolation(mPolicyMask);
            e.fillInStackTrace();
            startHandlingViolationException(e);
            // ---------- Original Method ----------
            //if ((mPolicyMask & DETECT_DISK_WRITE) == 0) {
                //return;
            //}
            //if (tooManyViolationsThisLoop()) {
                //return;
            //}
            //BlockGuard.BlockGuardPolicyException e = new StrictModeDiskWriteViolation(mPolicyMask);
            //e.fillInStackTrace();
            //startHandlingViolationException(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.758 -0400", hash_original_method = "B44201BA71724735A91DD4F1FF43D337", hash_generated_method = "FCC973E5F8E6D63A696BD074ABCD0B15")
         void onCustomSlowCall(String name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(name.getTaint());
            if((mPolicyMask & DETECT_CUSTOM) == 0)            
            {
                return;
            } //End block
            if(tooManyViolationsThisLoop())            
            {
                return;
            } //End block
            BlockGuard.BlockGuardPolicyException e = new StrictModeCustomViolation(mPolicyMask, name);
            e.fillInStackTrace();
            startHandlingViolationException(e);
            // ---------- Original Method ----------
            //if ((mPolicyMask & DETECT_CUSTOM) == 0) {
                //return;
            //}
            //if (tooManyViolationsThisLoop()) {
                //return;
            //}
            //BlockGuard.BlockGuardPolicyException e = new StrictModeCustomViolation(mPolicyMask, name);
            //e.fillInStackTrace();
            //startHandlingViolationException(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.758 -0400", hash_original_method = "DC9910586B30548E82E107CFA3542EA2", hash_generated_method = "642E6787E527A9CDB18531D1EA1315C7")
        public void onReadFromDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if((mPolicyMask & DETECT_DISK_READ) == 0)            
            {
                return;
            } //End block
            if(tooManyViolationsThisLoop())            
            {
                return;
            } //End block
            BlockGuard.BlockGuardPolicyException e = new StrictModeDiskReadViolation(mPolicyMask);
            e.fillInStackTrace();
            startHandlingViolationException(e);
            // ---------- Original Method ----------
            //if ((mPolicyMask & DETECT_DISK_READ) == 0) {
                //return;
            //}
            //if (tooManyViolationsThisLoop()) {
                //return;
            //}
            //BlockGuard.BlockGuardPolicyException e = new StrictModeDiskReadViolation(mPolicyMask);
            //e.fillInStackTrace();
            //startHandlingViolationException(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.758 -0400", hash_original_method = "D41EA35CCA984A26E96A9AAEEE4BCF1E", hash_generated_method = "32F3AE735719B3528EB05968E487918A")
        public void onNetwork() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if((mPolicyMask & DETECT_NETWORK) == 0)            
            {
                return;
            } //End block
            if((mPolicyMask & PENALTY_DEATH_ON_NETWORK) != 0)            
            {
                NetworkOnMainThreadException varA37BA107317F3E6381657CE477C8D261_2026566188 = new NetworkOnMainThreadException();
                varA37BA107317F3E6381657CE477C8D261_2026566188.addTaint(taint);
                throw varA37BA107317F3E6381657CE477C8D261_2026566188;
            } //End block
            if(tooManyViolationsThisLoop())            
            {
                return;
            } //End block
            BlockGuard.BlockGuardPolicyException e = new StrictModeNetworkViolation(mPolicyMask);
            e.fillInStackTrace();
            startHandlingViolationException(e);
            // ---------- Original Method ----------
            //if ((mPolicyMask & DETECT_NETWORK) == 0) {
                //return;
            //}
            //if ((mPolicyMask & PENALTY_DEATH_ON_NETWORK) != 0) {
                //throw new NetworkOnMainThreadException();
            //}
            //if (tooManyViolationsThisLoop()) {
                //return;
            //}
            //BlockGuard.BlockGuardPolicyException e = new StrictModeNetworkViolation(mPolicyMask);
            //e.fillInStackTrace();
            //startHandlingViolationException(e);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.758 -0400", hash_original_method = "A35D2E9A8AD0B9C28C9280D1C3956061", hash_generated_method = "6D9513DC2646B63D96CE73E109E46A70")
        public void setPolicyMask(int policyMask) {
            mPolicyMask = policyMask;
            // ---------- Original Method ----------
            //mPolicyMask = policyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.759 -0400", hash_original_method = "5E39E8C314EEA382AFAE0CC045B36998", hash_generated_method = "313352E0C15FE1A3718262CB17047DD4")
         void startHandlingViolationException(BlockGuard.BlockGuardPolicyException e) {
            addTaint(e.getTaint());
            final ViolationInfo info = new ViolationInfo(e, e.getPolicy());
            info.violationUptimeMillis = SystemClock.uptimeMillis();
            handleViolationWithTimingAttempt(info);
            // ---------- Original Method ----------
            //final ViolationInfo info = new ViolationInfo(e, e.getPolicy());
            //info.violationUptimeMillis = SystemClock.uptimeMillis();
            //handleViolationWithTimingAttempt(info);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.760 -0400", hash_original_method = "13A73E46BCAE9FB3F25E0C7CB59DBB78", hash_generated_method = "CC200B3D14D759E46EE269E659AE6050")
            public void run() {
                long loopFinishTime = SystemClock.uptimeMillis();
                if(windowManager != null)                
                {
                    try 
                    {
                        windowManager.showStrictModeViolation(false);
                    } //End block
                    catch (RemoteException unused)
                    {
                    } //End block
                } //End block
for(int n = 0;n < records.size();++n)
                {
                    ViolationInfo v = records.get(n);
                    v.violationNumThisLoop = n + 1;
                    v.durationMillis =
                                    (int) (loopFinishTime - v.violationUptimeMillis);
                    handleViolation(v);
                } //End block
                records.clear();
                // ---------- Original Method ----------
                //long loopFinishTime = SystemClock.uptimeMillis();
                //if (windowManager != null) {
                            //try {
                                //windowManager.showStrictModeViolation(false);
                            //} catch (RemoteException unused) {
                            //}
                        //}
                //for (int n = 0; n < records.size(); ++n) {
                            //ViolationInfo v = records.get(n);
                            //v.violationNumThisLoop = n + 1;
                            //v.durationMillis =
                                    //(int) (loopFinishTime - v.violationUptimeMillis);
                            //handleViolation(v);
                        //}
                //records.clear();
            }
});
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.763 -0400", hash_original_method = "41F5C3E6841DC86E9C64A72E84C0FF7E", hash_generated_method = "C378359697D2B5EA39503CCDF847E327")
         void handleViolation(final ViolationInfo info) {
            addTaint(info.getTaint());
            if(info == null || info.crashInfo == null || info.crashInfo.stackTrace == null)            
            {
                Log.wtf(TAG, "unexpected null stacktrace");
                return;
            } //End block
            if(LOG_V)            
            Log.d(TAG, "handleViolation; policy=" + info.policy);
            if((info.policy & PENALTY_GATHER) != 0)            
            {
                ArrayList<ViolationInfo> violations = gatheredViolations.get();
                if(violations == null)                
                {
                    violations = new ArrayList<ViolationInfo>(1);
                    gatheredViolations.set(violations);
                } //End block
                else
                if(violations.size() >= 5)                
                {
                    return;
                } //End block
for(ViolationInfo previous : violations)
                {
                    if(info.crashInfo.stackTrace.equals(previous.crashInfo.stackTrace))                    
                    {
                        return;
                    } //End block
                } //End block
                violations.add(info);
                return;
            } //End block
            Integer crashFingerprint = info.hashCode();
            long lastViolationTime = 0;
            if(mLastViolationTime.containsKey(crashFingerprint))            
            {
                lastViolationTime = mLastViolationTime.get(crashFingerprint);
            } //End block
            long now = SystemClock.uptimeMillis();
            mLastViolationTime.put(crashFingerprint, now);
            long timeSinceLastViolationMillis = lastViolationTime == 0 ?
                    Long.MAX_VALUE : (now - lastViolationTime);
            if((info.policy & PENALTY_LOG) != 0 &&
                timeSinceLastViolationMillis > MIN_LOG_INTERVAL_MS)            
            {
                if(info.durationMillis != -1)                
                {
                    Log.d(TAG, "StrictMode policy violation; ~duration=" +
                          info.durationMillis + " ms: " + info.crashInfo.stackTrace);
                } //End block
                else
                {
                    Log.d(TAG, "StrictMode policy violation: " + info.crashInfo.stackTrace);
                } //End block
            } //End block
            int violationMaskSubset = 0;
            if((info.policy & PENALTY_DIALOG) != 0 &&
                timeSinceLastViolationMillis > MIN_DIALOG_INTERVAL_MS)            
            {
                violationMaskSubset |= PENALTY_DIALOG;
            } //End block
            if((info.policy & PENALTY_DROPBOX) != 0 && lastViolationTime == 0)            
            {
                violationMaskSubset |= PENALTY_DROPBOX;
            } //End block
            if(violationMaskSubset != 0)            
            {
                int violationBit = parseViolationFromMessage(info.crashInfo.exceptionMessage);
                violationMaskSubset |= violationBit;
                final int savedPolicyMask = getThreadPolicyMask();
                final boolean justDropBox = (info.policy & THREAD_PENALTY_MASK) == PENALTY_DROPBOX;
                if(justDropBox)                
                {
                    dropboxViolationAsync(violationMaskSubset, info);
                    return;
                } //End block
                try 
                {
                    setThreadPolicyMask(0);
                    ActivityManagerNative.getDefault().handleApplicationStrictModeViolation(
                        RuntimeInit.getApplicationObject(),
                        violationMaskSubset,
                        info);
                } //End block
                catch (RemoteException e)
                {
                } //End block
                finally 
                {
                    setThreadPolicyMask(savedPolicyMask);
                } //End block
            } //End block
            if((info.policy & PENALTY_DEATH) != 0)            
            {
                executeDeathPenalty(info);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class AndroidCloseGuardReporter implements CloseGuard.Reporter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.763 -0400", hash_original_method = "E7772DF8591E8A95C00A24C3A7BC9385", hash_generated_method = "E7772DF8591E8A95C00A24C3A7BC9385")
        public AndroidCloseGuardReporter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.763 -0400", hash_original_method = "1648939B3F4BE7F697201ED2CA10799D", hash_generated_method = "2F7DB8F1120A1051EA77F31721DCAB11")
        public void report(String message, Throwable allocationSite) {
            addTaint(allocationSite.getTaint());
            addTaint(message.getTaint());
            onVmPolicyViolation(message, allocationSite);
            // ---------- Original Method ----------
            //onVmPolicyViolation(message, allocationSite);
        }

        
    }


    
    private static class LogStackTrace extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.764 -0400", hash_original_method = "9318B319D2DE8ECE742465D2C7D8840B", hash_generated_method = "9318B319D2DE8ECE742465D2C7D8840B")
        public LogStackTrace ()
        {
            //Synthesized constructor
        }


    }


    
    public static class Span {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.764 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

        private String mName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.764 -0400", hash_original_field = "71A6739ACA1D6EFC8CA8BC59BC80FD37", hash_generated_field = "D9168B950155534AAD832724FE52C500")

        private long mCreateMillis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.764 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "E39EFCE10572D87C6F95E3A2B2BDFCB1")

        private Span mNext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.764 -0400", hash_original_field = "FBB5FC609118D0EDF116DBF7ED6BF692", hash_generated_field = "ABC77622AA8E19FF30E79A0A19830013")

        private Span mPrev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.764 -0400", hash_original_field = "ABDCF3E72E2FC93754EA083FEF8563EA", hash_generated_field = "71A5A2213C60169AAE2591AE6952C837")

        private ThreadSpanState mContainerState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.765 -0400", hash_original_method = "858C7F08B86E9ABCC5108174CEDFA974", hash_generated_method = "46A08256E701EE28F27EFDCC6EA7A311")
          Span(ThreadSpanState threadState) {
            mContainerState = threadState;
            // ---------- Original Method ----------
            //mContainerState = threadState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.765 -0400", hash_original_method = "35ECB8DB5D2E2401D23EA00A0B49C3B0", hash_generated_method = "9BA85CCA4EAE21C800E5947B396A9A75")
        protected  Span() {
            mContainerState = null;
            // ---------- Original Method ----------
            //mContainerState = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.765 -0400", hash_original_method = "BAA90C1A527ED6ADE64DE9CF5831D500", hash_generated_method = "5812B292A3A2312F9CA6B671439979D5")
        public void finish() {
            ThreadSpanState state = mContainerState;
            synchronized
(state)            {
                if(mName == null)                
                {
                    return;
                } //End block
                if(mPrev != null)                
                {
                    mPrev.mNext = mNext;
                } //End block
                if(mNext != null)                
                {
                    mNext.mPrev = mPrev;
                } //End block
                if(state.mActiveHead == this)                
                {
                    state.mActiveHead = mNext;
                } //End block
                state.mActiveSize--;
                if(LOG_V)                
                Log.d(TAG, "Span finished=" + mName + "; size=" + state.mActiveSize);
                this.mCreateMillis = -1;
                this.mName = null;
                this.mPrev = null;
                this.mNext = null;
                if(state.mFreeListSize < 5)                
                {
                    this.mNext = state.mFreeListHead;
                    state.mFreeListHead = this;
                    state.mFreeListSize++;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class ThreadSpanState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.765 -0400", hash_original_field = "220FBF2583583706382506D68268B363", hash_generated_field = "518A04ADDEBFAA97A1EA0148B6F5FA97")

        public Span mActiveHead;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.765 -0400", hash_original_field = "E500488743B25A4A8E8980B2D8DD40C7", hash_generated_field = "B6D1D7D2D17432EE321593A3AEA5D914")

        public int mActiveSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.765 -0400", hash_original_field = "00C965908374A4B07EA5F85866B67C2E", hash_generated_field = "DA0030F95E05B17A8A5730A244932CA8")

        public Span mFreeListHead;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.765 -0400", hash_original_field = "E6AAF02BCBC197E806D06FB5EC18625D", hash_generated_field = "C3221ED1F561EAEA75567095BA88D9C9")

        public int mFreeListSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.765 -0400", hash_original_method = "897FCF469D672A73C45810344D5B48A8", hash_generated_method = "897FCF469D672A73C45810344D5B48A8")
        public ThreadSpanState ()
        {
            //Synthesized constructor
        }


    }


    
    public static class ViolationInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.767 -0400", hash_original_field = "E2830D8E0018BB9D7C72E36DDDB650B2", hash_generated_field = "CD846E661E8E518C4347C2ACA6146A7E")

        public ApplicationErrorReport.CrashInfo crashInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.767 -0400", hash_original_field = "F4AF8B5789576C000CE9105B25609BD6", hash_generated_field = "930B7D58F3DA097BBD08C13024DA937C")

        public int policy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.767 -0400", hash_original_field = "A8D317E1C938926947C4B210EBCECC1E", hash_generated_field = "F1C866B29B39A143C5FBB9A0CA778367")

        public int durationMillis = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.767 -0400", hash_original_field = "EEC8A1FCD4B77BB69BB144F25454CF22", hash_generated_field = "678196736B2E56BCECB08188576F10CE")

        public int numAnimationsRunning = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.767 -0400", hash_original_field = "D57AC45256849D9B13E2422D91580FB9", hash_generated_field = "F792D5F97BD30C470267CF28260B7EA9")

        public String[] tags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.767 -0400", hash_original_field = "8B568DABCCACE2EF4A593CDD6BCF2581", hash_generated_field = "AF05918DADCF889F179D3E20609A32AE")

        public int violationNumThisLoop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.767 -0400", hash_original_field = "DB2C6E10DE0472A82B45FDB1B9070EA2", hash_generated_field = "0AAC6D73647F1D34E070F27F164676C0")

        public long violationUptimeMillis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.767 -0400", hash_original_field = "A7BB6B742243FDA7D77036B57CD43DFF", hash_generated_field = "4B3B10B2069653BB6ABA4070A65734B4")

        public String broadcastIntentAction;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.767 -0400", hash_original_field = "CAB9C7B63599DF30611D8941676ECA28", hash_generated_field = "FCE79C922D923B8021DEFCC4604B4FB6")

        public long numInstances = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.767 -0400", hash_original_method = "D15EADA574CC6688E3A5C168E5A51EC1", hash_generated_method = "A280C1FD969189315D7D94DDC8202B0C")
        public  ViolationInfo() {
            crashInfo = null;
            policy = 0;
            // ---------- Original Method ----------
            //crashInfo = null;
            //policy = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.769 -0400", hash_original_method = "B97F48EA0F14252413142D91DE4A3BFA", hash_generated_method = "576322EE9889180031D8E2C24FEFD5E0")
        public  ViolationInfo(Throwable tr, int policy) {
            crashInfo = new ApplicationErrorReport.CrashInfo(tr);
            violationUptimeMillis = SystemClock.uptimeMillis();
            this.policy = policy;
            this.numAnimationsRunning = ValueAnimator.getCurrentAnimationsCount();
            Intent broadcastIntent = ActivityThread.getIntentBeingBroadcast();
            if(broadcastIntent != null)            
            {
                broadcastIntentAction = broadcastIntent.getAction();
            } //End block
            ThreadSpanState state = sThisThreadSpanState.get();
            if(tr instanceof InstanceCountViolation)            
            {
                this.numInstances = ((InstanceCountViolation) tr).mInstances;
            } //End block
            synchronized
(state)            {
                int spanActiveCount = state.mActiveSize;
                if(spanActiveCount > MAX_SPAN_TAGS)                
                {
                    spanActiveCount = MAX_SPAN_TAGS;
                } //End block
                if(spanActiveCount != 0)                
                {
                    this.tags = new String[spanActiveCount];
                    Span iter = state.mActiveHead;
                    int index = 0;
                    while
(iter != null && index < spanActiveCount)                    
                    {
                        this.tags[index] = iter.mName;
                        index++;
                        iter = iter.mNext;
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.769 -0400", hash_original_method = "2281C8F6C464FE0E4D053A790D9731B4", hash_generated_method = "1DBE6343F31808980E62E49AD84C659D")
        public  ViolationInfo(Parcel in) {
            this(in, false);
            addTaint(in.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.773 -0400", hash_original_method = "276C18C659FAD0D183192D3E613DC123", hash_generated_method = "BFDB6C63F25A54BF3A337F949111751B")
        public  ViolationInfo(Parcel in, boolean unsetGatheringBit) {
            addTaint(unsetGatheringBit);
            crashInfo = new ApplicationErrorReport.CrashInfo(in);
            int rawPolicy = in.readInt();
            if(unsetGatheringBit)            
            {
                policy = rawPolicy & ~PENALTY_GATHER;
            } //End block
            else
            {
                policy = rawPolicy;
            } //End block
            durationMillis = in.readInt();
            violationNumThisLoop = in.readInt();
            numAnimationsRunning = in.readInt();
            violationUptimeMillis = in.readLong();
            numInstances = in.readLong();
            broadcastIntentAction = in.readString();
            tags = in.readStringArray();
            // ---------- Original Method ----------
            //crashInfo = new ApplicationErrorReport.CrashInfo(in);
            //int rawPolicy = in.readInt();
            //if (unsetGatheringBit) {
                //policy = rawPolicy & ~PENALTY_GATHER;
            //} else {
                //policy = rawPolicy;
            //}
            //durationMillis = in.readInt();
            //violationNumThisLoop = in.readInt();
            //numAnimationsRunning = in.readInt();
            //violationUptimeMillis = in.readLong();
            //numInstances = in.readLong();
            //broadcastIntentAction = in.readString();
            //tags = in.readStringArray();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.774 -0400", hash_original_method = "C167EFD1AA966CEFAC170AF811F6D4AF", hash_generated_method = "4B01C4C0395510C5E101C576071D637F")
        @Override
        public int hashCode() {
            int result = 17;
            result = 37 * result + crashInfo.stackTrace.hashCode();
            if(numAnimationsRunning != 0)            
            {
                result *= 37;
            } //End block
            if(broadcastIntentAction != null)            
            {
                result = 37 * result + broadcastIntentAction.hashCode();
            } //End block
            if(tags != null)            
            {
for(String tag : tags)
                {
                    result = 37 * result + tag.hashCode();
                } //End block
            } //End block
            int varB4A88417B3D0170D754C647C30B7216A_38337818 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097240718 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097240718;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 37 * result + crashInfo.stackTrace.hashCode();
            //if (numAnimationsRunning != 0) {
                //result *= 37;
            //}
            //if (broadcastIntentAction != null) {
                //result = 37 * result + broadcastIntentAction.hashCode();
            //}
            //if (tags != null) {
                //for (String tag : tags) {
                    //result = 37 * result + tag.hashCode();
                //}
            //}
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.774 -0400", hash_original_method = "4C68F89668EEC8ACA3036C864AE1DCBA", hash_generated_method = "84046AAF389AEEFD3DD5880FCF7A73E5")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            crashInfo.writeToParcel(dest, flags);
            dest.writeInt(policy);
            dest.writeInt(durationMillis);
            dest.writeInt(violationNumThisLoop);
            dest.writeInt(numAnimationsRunning);
            dest.writeLong(violationUptimeMillis);
            dest.writeLong(numInstances);
            dest.writeString(broadcastIntentAction);
            dest.writeStringArray(tags);
            // ---------- Original Method ----------
            //crashInfo.writeToParcel(dest, flags);
            //dest.writeInt(policy);
            //dest.writeInt(durationMillis);
            //dest.writeInt(violationNumThisLoop);
            //dest.writeInt(numAnimationsRunning);
            //dest.writeLong(violationUptimeMillis);
            //dest.writeLong(numInstances);
            //dest.writeString(broadcastIntentAction);
            //dest.writeStringArray(tags);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.774 -0400", hash_original_method = "FB1CB9CE36DAC72C8A293B50C548452A", hash_generated_method = "BAE8C1C2FCA907DFAE22A369D222C3D6")
        public void dump(Printer pw, String prefix) {
            addTaint(prefix.getTaint());
            addTaint(pw.getTaint());
            crashInfo.dump(pw, prefix);
            pw.println(prefix + "policy: " + policy);
            if(durationMillis != -1)            
            {
                pw.println(prefix + "durationMillis: " + durationMillis);
            } //End block
            if(numInstances != -1)            
            {
                pw.println(prefix + "numInstances: " + numInstances);
            } //End block
            if(violationNumThisLoop != 0)            
            {
                pw.println(prefix + "violationNumThisLoop: " + violationNumThisLoop);
            } //End block
            if(numAnimationsRunning != 0)            
            {
                pw.println(prefix + "numAnimationsRunning: " + numAnimationsRunning);
            } //End block
            pw.println(prefix + "violationUptimeMillis: " + violationUptimeMillis);
            if(broadcastIntentAction != null)            
            {
                pw.println(prefix + "broadcastIntentAction: " + broadcastIntentAction);
            } //End block
            if(tags != null)            
            {
                int index = 0;
for(String tag : tags)
                {
                    pw.println(prefix + "tag[" + (index++) + "]: " + tag);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class InstanceCountViolation extends Throwable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.774 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "CE233813880487C713DB65203E06BCD9")

        Class mClass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.775 -0400", hash_original_field = "0D41B5AD1A7DB10272E2084BC9A3392B", hash_generated_field = "74080197B20CB35716F08D82964BE351")

        long mInstances;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.775 -0400", hash_original_field = "5B168C2292FF8EC273A67B1639E35C5D", hash_generated_field = "EAF07362CB0DE5A45A6B09193DE62144")

        int mLimit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.775 -0400", hash_original_method = "E80F10435372AA752F8DBC4C44A2404B", hash_generated_method = "019519EF16106C35D92003DDACCE9C26")
        public  InstanceCountViolation(Class klass, long instances, int limit) {
            super(klass.toString() + "; instances=" + instances + "; limit=" + limit);
            setStackTrace(FAKE_STACK);
            mClass = klass;
            mInstances = instances;
            mLimit = limit;
            // ---------- Original Method ----------
            //setStackTrace(FAKE_STACK);
            //mClass = klass;
            //mInstances = instances;
            //mLimit = limit;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.775 -0400", hash_original_field = "23D915E793BC37F0BB86A95A59152961", hash_generated_field = "5B6CE22DDD6F454B97A831C7050366DC")

        private static final StackTraceElement[] FAKE_STACK = {
            new StackTraceElement("android.os.StrictMode", "setClassInstanceLimit",
                                  "StrictMode.java", 1)
        };
    }


    
    private static final class InstanceTracker {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.775 -0400", hash_original_field = "644134EA3E6C2A378776F1961BA35811", hash_generated_field = "C91F484EFB2D5A548FE76D861FC04B66")

        private Class<?> mKlass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.775 -0400", hash_original_method = "D1695326538E61C61B9A9871778AEDEF", hash_generated_method = "8142FDFB0A77BCF7DCEB94224F2C301E")
        public  InstanceTracker(Object instance) {
            mKlass = instance.getClass();
            synchronized
(sInstanceCounts)            {
                final Integer value = sInstanceCounts.get(mKlass);
                final int newValue = value != null ? value + 1 : 1;
                sInstanceCounts.put(mKlass, newValue);
            } //End block
            // ---------- Original Method ----------
            //mKlass = instance.getClass();
            //synchronized (sInstanceCounts) {
                //final Integer value = sInstanceCounts.get(mKlass);
                //final int newValue = value != null ? value + 1 : 1;
                //sInstanceCounts.put(mKlass, newValue);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.776 -0400", hash_original_method = "3D9E07641D189E499B7BA8CA77DD9FB9", hash_generated_method = "132DE6035C1C81BD35957B3DD5B028D8")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                synchronized
(sInstanceCounts)                {
                    final Integer value = sInstanceCounts.get(mKlass);
                    if(value != null)                    
                    {
                        final int newValue = value - 1;
                        if(newValue > 0)                        
                        {
                            sInstanceCounts.put(mKlass, newValue);
                        } //End block
                        else
                        {
                            sInstanceCounts.remove(mKlass);
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //synchronized (sInstanceCounts) {
                    //final Integer value = sInstanceCounts.get(mKlass);
                    //if (value != null) {
                        //final int newValue = value - 1;
                        //if (newValue > 0) {
                            //sInstanceCounts.put(mKlass, newValue);
                        //} else {
                            //sInstanceCounts.remove(mKlass);
                        //}
                    //}
                //}
            //} finally {
                //super.finalize();
            //}
        }

        
        public static int getInstanceCount(Class<?> klass) {
            synchronized (sInstanceCounts) {
                final Integer value = sInstanceCounts.get(klass);
                return value != null ? value : 0;
            }
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.776 -0400", hash_original_field = "DD4CBD89079F688DE59AFC08B54388CB", hash_generated_field = "116A2F2FC172FA2FA149155E4F1D5CD5")

        private static final HashMap<Class<?>, Integer> sInstanceCounts = new HashMap<Class<?>, Integer>();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.776 -0400", hash_original_field = "D3088EBAFFC0370793C876A1F529BEBF", hash_generated_field = "EFD495BFFD08DBECC91B6FEE7B253D98")

    private static final String TAG = "StrictMode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.776 -0400", hash_original_field = "10012F752FC38C6B0CFDEC1B2E5B89AC", hash_generated_field = "B71C40E2BD4A348A86F6A8DA6EFF35D9")

    private static final boolean LOG_V = Log.isLoggable(TAG, Log.VERBOSE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.776 -0400", hash_original_field = "A3F06E2DBC0DA963DFE1E41E297E849D", hash_generated_field = "23F752FC1CDA7050B5F1CC7BA955413B")

    private static final boolean IS_USER_BUILD = "user".equals(Build.TYPE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "9D23AE2E1DF0783311B7EE88635EC302", hash_generated_field = "5633022DA578E314CF52EE3A9C0CF47D")

    private static final boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "F9788FE80D74F8AAF2B2257306FDF4F9", hash_generated_field = "3E92FD7ABB6619B38D620EDF029A22D9")

    public static final String DISABLE_PROPERTY = "persist.sys.strictmode.disable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "3475CE826B41B81BE9A2D348A9BB7CC8", hash_generated_field = "E70A21C58D25E28726CC89D8D9240ACA")

    public static final String VISUAL_PROPERTY = "persist.sys.strictmode.visual";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "405B98439BDD5E31488F7FE63DB2894F", hash_generated_field = "FD19D25D87C076998E76A2F89CE1905E")

    private static final long MIN_LOG_INTERVAL_MS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "8D3BFCEBD0B88320011AA9B14A23B692", hash_generated_field = "DA3F5640282C927DA73236D0BA3ECD57")

    private static final long MIN_DIALOG_INTERVAL_MS = 30000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "99EEFDD9B0F488ABE9D28409ED32E932", hash_generated_field = "B19F03F9C3626AC77DC6B5D1D1998E3B")

    private static final int MAX_SPAN_TAGS = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "7A0A915FE061437DB98B2890AB7CF2CE", hash_generated_field = "E5654288F47CC7A3A6E622B174B34056")

    private static final int MAX_OFFENSES_PER_LOOP = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "D0F089381407693056149FE7CAA95BCE", hash_generated_field = "D504D2B86CFCD35894735D0BCD3EEA33")

    public static final int DETECT_DISK_WRITE = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "02C6FDF2CB0A3F274F5C7987262E09FC", hash_generated_field = "7C0AAD2513E22025E4555E4D43F8297C")

    public static final int DETECT_DISK_READ = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "74E04715DA6896901F74DA436A9AA197", hash_generated_field = "A0953BEBDA93B5AC1BDC661CE1AF0C64")

    public static final int DETECT_NETWORK = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "D5619D251598C75279F91C1DCF262984", hash_generated_field = "EDC2D333C7911473B0EA87279BE3E8A6")

    public static final int DETECT_CUSTOM = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "3B9D21470B9E6740B57563462D0BA29C", hash_generated_field = "DEF661BA57DCADA99F22533CDFDF239C")

    private static final int ALL_THREAD_DETECT_BITS = DETECT_DISK_WRITE | DETECT_DISK_READ | DETECT_NETWORK | DETECT_CUSTOM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "6AF2813DB695929029F4BA10476B0CC0", hash_generated_field = "C8547878D8DA9B32C40632615B8C73D7")

    public static final int DETECT_VM_CURSOR_LEAKS = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "36E68A513DD293E166FB4F54BE29725C", hash_generated_field = "C9E5621265A28DF38A8FC7DA71DC98E1")

    public static final int DETECT_VM_CLOSABLE_LEAKS = 0x400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "A2310CDBCDD4C509EFF401292464CFD9", hash_generated_field = "FF0F20EB6EA7B6EFA0B50FB48E32AE8B")

    public static final int DETECT_VM_ACTIVITY_LEAKS = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "E52124B43913136C666B021988F5DEA8", hash_generated_field = "83019C646CB0B9C05D60FAAB9A05A37D")

    private static final int DETECT_VM_INSTANCE_LEAKS = 0x1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "AD30D8213DA72B532896F5533DB7DEE7", hash_generated_field = "792A04564079CCBA55772389E5556C8F")

    private static final int ALL_VM_DETECT_BITS = DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS |
            DETECT_VM_ACTIVITY_LEAKS | DETECT_VM_INSTANCE_LEAKS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "8FC0A17F12BDF8741B92E5F01FD7DCB6", hash_generated_field = "AD440199AC90AA853DAE6E553309E61E")

    public static final int PENALTY_LOG = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "5237B015D0FD40554D978C3F16F56117", hash_generated_field = "1B09956BCE6604535346C86F86199656")

    public static final int PENALTY_DIALOG = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.777 -0400", hash_original_field = "F3FAE1CCEDA4AC19AA37F2365135E9ED", hash_generated_field = "36B2F4DE7C0AEF684C2D4A0EA98A5FF6")

    public static final int PENALTY_DEATH = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "6F33760461E8219F9AA6406FE6162556", hash_generated_field = "43A59BD7C5C50C06D41CB3576F113D90")

    public static final int PENALTY_DEATH_ON_NETWORK = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "F6A171ECCB6555D6BF6665A4505B4B88", hash_generated_field = "D95570E99357CC6CAAFB830E0B8059B4")

    public static final int PENALTY_FLASH = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "56D01B1E4CE134211CEAD29A319DCB2D", hash_generated_field = "97FF6CEFBEACB56FCE27CC1D38BF5293")

    public static final int PENALTY_DROPBOX = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "275C15273FF88D606EF53A171326A356", hash_generated_field = "4A0AEEF9679F704885B2B478E1F03646")

    public static final int PENALTY_GATHER = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "5FE094B1555185981A4C03805EB67AC8", hash_generated_field = "FCF43DBDCE0FE2111C7D3D0DB93F021C")

    private static final int THREAD_PENALTY_MASK = PENALTY_LOG | PENALTY_DIALOG | PENALTY_DEATH | PENALTY_DROPBOX | PENALTY_GATHER |
            PENALTY_DEATH_ON_NETWORK | PENALTY_FLASH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "12DCAF055C72980A2456D711E10064E9", hash_generated_field = "1570D6E62C2261DE7B2E5A5A8633B0EF")

    private static final int VM_PENALTY_MASK = PENALTY_LOG | PENALTY_DEATH | PENALTY_DROPBOX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "80C5BEAC52B0A4A37042B6AB8F02D3DA", hash_generated_field = "AD504B2F674416E05F7D8BB4F079CAD6")

    private static final HashMap<Class, Integer> EMPTY_CLASS_LIMIT_MAP = new HashMap<Class, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "73935208411D2C33F2F434E725AFAB4F", hash_generated_field = "A2DC93C9353C0CDFE42E43F2EDB31797")

    private static volatile int sVmPolicyMask = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "0EFDB39AB4151B8C9E69E1E46920E6DD", hash_generated_field = "6C6283435840FF828818AEADC035BB2B")

    private static volatile VmPolicy sVmPolicy = VmPolicy.LAX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "A6C62B4D7E99D84A85CA2ACFE986625B", hash_generated_field = "2C9F276C45FCDF0FDB0E9335F3464F44")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "50788C7D307BD300374B864F668BDEBC", hash_generated_field = "9856A17E5723F71B95FE2020E6AD7FC5")

    private static long sLastInstanceCountCheckMillis = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "DCEA3F8C01AD46840FAE99198C9AAA60", hash_generated_field = "620CC23E40F92E04CF705F8C05DDBFB2")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "1D538736D2B5D329201BCBD8472DDCFE", hash_generated_field = "EC2C449B6782F01CD0895152402E7785")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.778 -0400", hash_original_field = "085DE61E4920EC06EF3FB909B8607AB0", hash_generated_field = "35AF5773760644A2175E84471F6DD6ED")

    private static final HashMap<Class, Integer> sExpectedActivityInstanceCount = new HashMap<Class, Integer>();
}

