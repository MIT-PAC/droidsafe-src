package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class StrictMode {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.277 -0400", hash_original_method = "E3867A4A77A9B912C067B4B7EB14B6CB", hash_generated_method = "4A3827557D89D96B907E9813E3C5AC14")
    @DSModeled(DSC.SAFE)
    private StrictMode() {
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

    
        public static boolean vmSqliteObjectLeaksEnabled() {
        return (sVmPolicyMask & DETECT_VM_CURSOR_LEAKS) != 0;
    }

    
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
        int mask;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.285 -0400", hash_original_method = "B0AC15ACB9093249F94C953D0A842CAE", hash_generated_method = "7B856375CFEC6EA99C66B1BF1493B5F9")
        @DSModeled(DSC.SAFE)
        private ThreadPolicy(int mask) {
            dsTaint.addTaint(mask);
            // ---------- Original Method ----------
            //this.mask = mask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.285 -0400", hash_original_method = "AE05BE3A66BEE06993F7653F4CB681EB", hash_generated_method = "681B513CA4F64F14E75C0129E1710E89")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "[StrictMode.ThreadPolicy; mask=" + mask + "]";
        }

        
        public static final class Builder {
            private int mMask = 0;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.286 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "C4A90307B6990541B60C2B86DCD4B526")
            @DSModeled(DSC.SAFE)
            public Builder() {
                mMask = 0;
                // ---------- Original Method ----------
                //mMask = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.286 -0400", hash_original_method = "2270BC971D9C4F82FBD51366B809A76A", hash_generated_method = "D07FF060604283B2DE97CE903E59E6E6")
            @DSModeled(DSC.SAFE)
            public Builder(ThreadPolicy policy) {
                dsTaint.addTaint(policy.dsTaint);
                mMask = policy.mask;
                // ---------- Original Method ----------
                //mMask = policy.mask;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.286 -0400", hash_original_method = "399752AE3320783E8BC4077BF2BAABAB", hash_generated_method = "1D05088B381AE65CC4AB94AA304F81E0")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectAll() {
                Builder varB75010659E1D3DB33577DAACF4003834_1152016791 = (enable(ALL_THREAD_DETECT_BITS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(ALL_THREAD_DETECT_BITS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.286 -0400", hash_original_method = "3E31B254E1B4E9A5234881E68AADF1C7", hash_generated_method = "F43A13125983742225A1E047D980B754")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder permitAll() {
                Builder var90298C1A96D6CF1919E456114FCEDE8B_1225781019 = (disable(ALL_THREAD_DETECT_BITS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return disable(ALL_THREAD_DETECT_BITS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.287 -0400", hash_original_method = "8F1CC5D4BDA427578EB68B001E341FDD", hash_generated_method = "EC51DFE7D41217FDA37DF9FDAEAB8500")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectNetwork() {
                Builder varFB0BE371D11A80C4E2A0C81DBB0B0000_322027638 = (enable(DETECT_NETWORK));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.288 -0400", hash_original_method = "2A4244001D1666DDAFB3F602ED8EC7EA", hash_generated_method = "BE105C4DB4D87149F8ABAE8C9659E136")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder permitNetwork() {
                Builder var9DBE48447AFBD0D9DCA1F53C0C120F63_1798511218 = (disable(DETECT_NETWORK));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return disable(DETECT_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.289 -0400", hash_original_method = "75C524432F954C01B0149630CE54DDB4", hash_generated_method = "927F1776FE158C17B4BA70260CEA2633")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectDiskReads() {
                Builder varFE9F28F6DCC1BED36D66D9EE8EE84768_2095808300 = (enable(DETECT_DISK_READ));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_DISK_READ);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.289 -0400", hash_original_method = "1BD98C02F9A11EE892D0098B20BDD8BD", hash_generated_method = "E06F9C9F5E25BDE29758D9A113EAC035")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder permitDiskReads() {
                Builder var6DBD1174C4A11AA0E23E951007852A39_82469494 = (disable(DETECT_DISK_READ));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return disable(DETECT_DISK_READ);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.289 -0400", hash_original_method = "0F761933C6E4A91421ABB8964A4D9EB8", hash_generated_method = "D53B1A6B7FA2B2C06552A16BF1B6CEAF")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectCustomSlowCalls() {
                Builder var201413392CC19AD176C216B1005B7AB0_1994169202 = (enable(DETECT_CUSTOM));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_CUSTOM);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.289 -0400", hash_original_method = "1F5E52FF134E5A595D9B4F3AD9EF805B", hash_generated_method = "96EEC3AEEC6427ECB843C727F3502029")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder permitCustomSlowCalls() {
                Builder var201413392CC19AD176C216B1005B7AB0_1717509992 = (enable(DETECT_CUSTOM));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_CUSTOM);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.290 -0400", hash_original_method = "583E0D5D228DC11F4F3B1B541EE8393C", hash_generated_method = "FF387EEA65A9AA0C4CE8F269A70C1BAA")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectDiskWrites() {
                Builder var57E2B7E251451B4FB7DA2A1472F83B9E_1927610411 = (enable(DETECT_DISK_WRITE));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_DISK_WRITE);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.290 -0400", hash_original_method = "A37C6D388BF979AC5AEB871BAB2E0B6F", hash_generated_method = "6CBC7112CFE43B29A5C8D7EB563C7B97")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder permitDiskWrites() {
                Builder varA82CEF86E32E73C1DEDFF450DD9EB012_1946570334 = (disable(DETECT_DISK_WRITE));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return disable(DETECT_DISK_WRITE);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.290 -0400", hash_original_method = "8766DB09D651E2B3541ACB0418FFA365", hash_generated_method = "2AE61A7A5A3C24B91A53BB6010CA9CD0")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDialog() {
                Builder varE3BDDF8F7BDF1A402D08692E5C898831_454980825 = (enable(PENALTY_DIALOG));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DIALOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.290 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "0178D5238A5497539D6BF94F357A8E9F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDeath() {
                Builder var1D71F5757972FF9DC154CB7A2BBB4BA7_1912981319 = (enable(PENALTY_DEATH));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.291 -0400", hash_original_method = "3B3840DC05B4A1C1129369D4324CF6E7", hash_generated_method = "17D6107C5C9D86D194B64FC2CE313290")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDeathOnNetwork() {
                Builder var8E285BFB0382FC4C94A68FC324775001_1089299973 = (enable(PENALTY_DEATH_ON_NETWORK));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH_ON_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.291 -0400", hash_original_method = "D2175CC28C327D3A1AEA760A679D2369", hash_generated_method = "2D2C252041B409FB62DAABF643DDB391")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyFlashScreen() {
                Builder var966ADEC38EF7E614E8143F880ABA15E6_1005503774 = (enable(PENALTY_FLASH));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_FLASH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.291 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "BB6F63969AC4863CBC325EB9A417B149")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyLog() {
                Builder varAA5DB1D11209B827A2125309FAF8E6D6_64378884 = (enable(PENALTY_LOG));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_LOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.291 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "FC7A46FA62B95A5559FA44A372446E8A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDropBox() {
                Builder var959C22F6882E3E08E0D77F2A90947774_971729628 = (enable(PENALTY_DROPBOX));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DROPBOX);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.292 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "FBDAFFE99A3DED99EFF9B948CA36075F")
            @DSModeled(DSC.SAFE)
            private Builder enable(int bit) {
                dsTaint.addTaint(bit);
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //mMask |= bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.292 -0400", hash_original_method = "DD377E4C338D3B09C11C3D4D7DFD99D3", hash_generated_method = "1334A9F87699D9B2094D7A9130D1610D")
            @DSModeled(DSC.SAFE)
            private Builder disable(int bit) {
                dsTaint.addTaint(bit);
                mMask &= ~bit;
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //mMask &= ~bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.292 -0400", hash_original_method = "3E686B94A275CF17A4C5CE0839D3E8D1", hash_generated_method = "C33203A0C1D5943348D254F38806EAA8")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public ThreadPolicy build() {
                {
                    penaltyLog();
                } //End block
                ThreadPolicy var3625EC4830B886C7D7908B528565CE0A_1749177987 = (new ThreadPolicy(mMask));
                return (ThreadPolicy)dsTaint.getTaint();
                // ---------- Original Method ----------
                //if (mMask != 0 &&
                    //(mMask & (PENALTY_DEATH | PENALTY_LOG |
                              //PENALTY_DROPBOX | PENALTY_DIALOG)) == 0) {
                    //penaltyLog();
                //}
                //return new ThreadPolicy(mMask);
            }

            
        }


        
        public static final ThreadPolicy LAX = new ThreadPolicy(0);
    }


    
    public static final class VmPolicy {
        int mask;
        HashMap<Class, Integer> classInstanceLimit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.293 -0400", hash_original_method = "BE6E35A5EA1ACA059EF2A402B69D7023", hash_generated_method = "1435E3B0E049CB8B13E87085816D7192")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private VmPolicy(int mask, HashMap<Class, Integer> classInstanceLimit) {
            dsTaint.addTaint(classInstanceLimit.dsTaint);
            dsTaint.addTaint(mask);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("classInstanceLimit == null");
            } //End block
            // ---------- Original Method ----------
            //if (classInstanceLimit == null) {
                //throw new NullPointerException("classInstanceLimit == null");
            //}
            //this.mask = mask;
            //this.classInstanceLimit = classInstanceLimit;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.294 -0400", hash_original_method = "338C4A4B8F91E885EB5A5562BE10EA45", hash_generated_method = "74450E4FE3D689CEFD2EFC7E13206843")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "[StrictMode.VmPolicy; mask=" + mask + "]";
        }

        
        public static final class Builder {
            private int mMask;
            private HashMap<Class, Integer> mClassInstanceLimit;
            private boolean mClassInstanceLimitNeedCow = false;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.295 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "C4A90307B6990541B60C2B86DCD4B526")
            @DSModeled(DSC.SAFE)
            public Builder() {
                mMask = 0;
                // ---------- Original Method ----------
                //mMask = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.295 -0400", hash_original_method = "FBB1CB3954D34CB1AD109CEFAD7B1DDE", hash_generated_method = "2F9E64EC4CC25D8FD89B63D46DEE7D9F")
            @DSModeled(DSC.SAFE)
            public Builder(VmPolicy base) {
                dsTaint.addTaint(base.dsTaint);
                mMask = base.mask;
                mClassInstanceLimitNeedCow = true;
                mClassInstanceLimit = base.classInstanceLimit;
                // ---------- Original Method ----------
                //mMask = base.mask;
                //mClassInstanceLimitNeedCow = true;
                //mClassInstanceLimit = base.classInstanceLimit;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.295 -0400", hash_original_method = "E6B0AD736B79FE1E50987D22EA6466E3", hash_generated_method = "87DFCD8891803405BE4BD96D26A7514F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder setClassInstanceLimit(Class klass, int instanceLimit) {
                dsTaint.addTaint(instanceLimit);
                dsTaint.addTaint(klass.dsTaint);
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("klass == null");
                } //End block
                {
                    {
                        boolean varF54A66C0EAC712B4862EF63071243FC1_495774921 = (mClassInstanceLimit.containsKey(klass) &&
                        mClassInstanceLimit.get(klass) == instanceLimit);
                    } //End collapsed parenthetic
                    mClassInstanceLimitNeedCow = false;
                    mClassInstanceLimit = (HashMap<Class, Integer>) mClassInstanceLimit.clone();
                } //End block
                {
                    mClassInstanceLimit = new HashMap<Class, Integer>();
                } //End block
                mMask |= DETECT_VM_INSTANCE_LEAKS;
                mClassInstanceLimit.put(klass, instanceLimit);
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.296 -0400", hash_original_method = "1E52C56D15D33FA545E602A30D1B7293", hash_generated_method = "86EE0075CC17DF70FA7324933A81E6D6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectActivityLeaks() {
                Builder var780DBA67134F710256E37D1518C94046_441850285 = (enable(DETECT_VM_ACTIVITY_LEAKS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_VM_ACTIVITY_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.296 -0400", hash_original_method = "CEAA7924A62774EE9F1DB0EAFC23F606", hash_generated_method = "1874D14562D9F93E550B138DA2B2CFA7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectAll() {
                Builder var572C1D5C75201B5F2EA42D3D4A83539F_1514003838 = (enable(DETECT_VM_ACTIVITY_LEAKS |
                        DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_VM_ACTIVITY_LEAKS |
                        //DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.296 -0400", hash_original_method = "7CA55A1EF27E65D4088A38B2843E1EE5", hash_generated_method = "3F638A5943AA06FADA694067A5825473")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectLeakedSqlLiteObjects() {
                Builder varC0A7A54EAA5500F6B0F27C61E98371FE_981399103 = (enable(DETECT_VM_CURSOR_LEAKS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_VM_CURSOR_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.296 -0400", hash_original_method = "76FD4F08E7705E8F66E31708D9A399EA", hash_generated_method = "664E1417019FF065D4B1A2F643B66625")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectLeakedClosableObjects() {
                Builder varDBDF972D13A7A0F505B3E318564FA057_812797573 = (enable(DETECT_VM_CLOSABLE_LEAKS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_VM_CLOSABLE_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.297 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "500BA61C909F9518D87536454199E19B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDeath() {
                Builder var1D71F5757972FF9DC154CB7A2BBB4BA7_2034279381 = (enable(PENALTY_DEATH));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.297 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "2E8016945C9998753B7216E55539421A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyLog() {
                Builder varAA5DB1D11209B827A2125309FAF8E6D6_468585890 = (enable(PENALTY_LOG));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_LOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.297 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "5D2BF00E26E5D7E24B2E7C0730C5BB2A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDropBox() {
                Builder var959C22F6882E3E08E0D77F2A90947774_1182661900 = (enable(PENALTY_DROPBOX));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DROPBOX);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.297 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "FBDAFFE99A3DED99EFF9B948CA36075F")
            @DSModeled(DSC.SAFE)
            private Builder enable(int bit) {
                dsTaint.addTaint(bit);
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //mMask |= bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.298 -0400", hash_original_method = "6432BC9C97797DD02AE9BFA4A7F87D54", hash_generated_method = "242462A027BE695926CC5E687B66045E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public VmPolicy build() {
                {
                    penaltyLog();
                } //End block
                VmPolicy varA4317057F58870E69471FE4C1E4C1100_1662443457 = (new VmPolicy(mMask,
                        mClassInstanceLimit != null ? mClassInstanceLimit : EMPTY_CLASS_LIMIT_MAP)); //DSFIXME:  CODE0008: Nested ternary operator in expression
                return (VmPolicy)dsTaint.getTaint();
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


        
        public static final VmPolicy LAX = new VmPolicy(0, EMPTY_CLASS_LIMIT_MAP);
    }


    
    public static class StrictModeViolation extends BlockGuard.BlockGuardPolicyException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.298 -0400", hash_original_method = "E7438DD65D448EA29E2BF1E2E7B9AF17", hash_generated_method = "EA804F4D5B010C026570487441E53E13")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StrictModeViolation(int policyState, int policyViolated, String message) {
            super(policyState, policyViolated, message);
            dsTaint.addTaint(message);
            dsTaint.addTaint(policyState);
            dsTaint.addTaint(policyViolated);
            // ---------- Original Method ----------
        }

        
    }


    
    public static class StrictModeNetworkViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.298 -0400", hash_original_method = "DBBD717A236AEADDFBDE9EEC846203D0", hash_generated_method = "B0F45AB4DBEE3A703CD3EA18D2DD7382")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StrictModeNetworkViolation(int policyMask) {
            super(policyMask, DETECT_NETWORK, null);
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeDiskReadViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.299 -0400", hash_original_method = "50FAC78594B32A364EC38A7051A6D828", hash_generated_method = "0EBF0949AA7A5F95579F20A0A3C083C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StrictModeDiskReadViolation(int policyMask) {
            super(policyMask, DETECT_DISK_READ, null);
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeDiskWriteViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.299 -0400", hash_original_method = "3E79DB089B8A8B103215C527DD70DC9D", hash_generated_method = "97EA8B2E91E2EF84179FE99E8526995F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StrictModeDiskWriteViolation(int policyMask) {
            super(policyMask, DETECT_DISK_WRITE, null);
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeCustomViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.299 -0400", hash_original_method = "D9775B5587EA33BC7CC7CE8D67F82D3A", hash_generated_method = "09DD1AC236B358119985F8C5F238259D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StrictModeCustomViolation(int policyMask, String name) {
            super(policyMask, DETECT_CUSTOM, name);
            dsTaint.addTaint(name);
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class AndroidBlockGuardPolicy implements BlockGuard.Policy {
        private int mPolicyMask;
        private HashMap<Integer, Long> mLastViolationTime = new HashMap<Integer, Long>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.299 -0400", hash_original_method = "56B73F441F57B7F1580692BF8D8E5ECB", hash_generated_method = "2E775DABDE40504409FBC55CDAEC5A6F")
        @DSModeled(DSC.SAFE)
        public AndroidBlockGuardPolicy(final int policyMask) {
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
            //mPolicyMask = policyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.300 -0400", hash_original_method = "EC02A08C2D3910C2DE1DA94FE738CE60", hash_generated_method = "23754226B77152F4728F13B9BD1590BD")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "AndroidBlockGuardPolicy; mPolicyMask=" + mPolicyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.300 -0400", hash_original_method = "BDAE35F9BC36FEF12DCB9013D520032B", hash_generated_method = "C5B3AE6AACA81A77F8D4463F15350A9E")
        @DSModeled(DSC.SAFE)
        public int getPolicyMask() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPolicyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.300 -0400", hash_original_method = "0D85458AC3FF96FC22E8C3819C12EFAB", hash_generated_method = "5D5CF7FBF09495F935497821FACE9D4D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onWriteToDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_1417352743 = (tooManyViolationsThisLoop());
            } //End collapsed parenthetic
            BlockGuard.BlockGuardPolicyException e;
            e = new StrictModeDiskWriteViolation(mPolicyMask);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.300 -0400", hash_original_method = "B44201BA71724735A91DD4F1FF43D337", hash_generated_method = "B1DEBB9C34B0220285177A36B2E88E9A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void onCustomSlowCall(String name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name);
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_464053220 = (tooManyViolationsThisLoop());
            } //End collapsed parenthetic
            BlockGuard.BlockGuardPolicyException e;
            e = new StrictModeCustomViolation(mPolicyMask, name);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.301 -0400", hash_original_method = "DC9910586B30548E82E107CFA3542EA2", hash_generated_method = "3EB46DD8B6984F914D2C96B711D948DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onReadFromDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_1790200557 = (tooManyViolationsThisLoop());
            } //End collapsed parenthetic
            BlockGuard.BlockGuardPolicyException e;
            e = new StrictModeDiskReadViolation(mPolicyMask);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.301 -0400", hash_original_method = "D41EA35CCA984A26E96A9AAEEE4BCF1E", hash_generated_method = "787EEB300C778142F2D6AA324CC18D8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onNetwork() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                if (DroidSafeAndroidRuntime.control) throw new NetworkOnMainThreadException();
            } //End block
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_2125783863 = (tooManyViolationsThisLoop());
            } //End collapsed parenthetic
            BlockGuard.BlockGuardPolicyException e;
            e = new StrictModeNetworkViolation(mPolicyMask);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.301 -0400", hash_original_method = "A35D2E9A8AD0B9C28C9280D1C3956061", hash_generated_method = "99367993AF814CF7CD58547AE5D679AC")
        @DSModeled(DSC.SAFE)
        public void setPolicyMask(int policyMask) {
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
            //mPolicyMask = policyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.302 -0400", hash_original_method = "5E39E8C314EEA382AFAE0CC045B36998", hash_generated_method = "12A5E66D941B97046E918EFE395BD501")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startHandlingViolationException(BlockGuard.BlockGuardPolicyException e) {
            dsTaint.addTaint(e.dsTaint);
            ViolationInfo info;
            info = new ViolationInfo(e, e.getPolicy());
            info.violationUptimeMillis = SystemClock.uptimeMillis();
            handleViolationWithTimingAttempt(info);
            // ---------- Original Method ----------
            //final ViolationInfo info = new ViolationInfo(e, e.getPolicy());
            //info.violationUptimeMillis = SystemClock.uptimeMillis();
            //handleViolationWithTimingAttempt(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.305 -0400", hash_original_method = "E564B46DD31AF359B07F190378DAA828", hash_generated_method = "42D87A2F35F60AFBA3CFB7D1276AD07E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void handleViolationWithTimingAttempt(final ViolationInfo info) {
            dsTaint.addTaint(info.dsTaint);
            Looper looper;
            looper = Looper.myLooper();
            {
                info.durationMillis = -1;
                handleViolation(info);
            } //End block
            ArrayList<ViolationInfo> records;
            records = violationsBeingTimed.get();
            {
                boolean var93D414F0DAF507CC4844CFB90F056FDD_2089989024 = (records.size() >= MAX_OFFENSES_PER_LOOP);
            } //End collapsed parenthetic
            records.add(info);
            {
                boolean varD777943406E4C57D521B6D48914E48C5_1453437591 = (records.size() > 1);
            } //End collapsed parenthetic
            IWindowManager windowManager;
            windowManager = sWindowManager.get();
            windowManager = null;
            {
                try 
                {
                    windowManager.showStrictModeViolation(true);
                } //End block
                catch (RemoteException unused)
                { }
            } //End block
            threadHandler.get().post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.305 -0400", hash_original_method = "13A73E46BCAE9FB3F25E0C7CB59DBB78", hash_generated_method = "0AF143332D454387DF757813234C0067")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    long loopFinishTime;
                    loopFinishTime = SystemClock.uptimeMillis();
                    {
                        try 
                        {
                            windowManager.showStrictModeViolation(false);
                        } //End block
                        catch (RemoteException unused)
                        { }
                    } //End block
                    {
                        int n;
                        n = 0;
                        boolean var295180DEA5F59A98ADD9FC6CF590545D_1066905390 = (n < records.size());
                        {
                            ViolationInfo v;
                            v = records.get(n);
                            v.violationNumThisLoop = n + 1;
                            v.durationMillis =
                                    (int) (loopFinishTime - v.violationUptimeMillis);
                            handleViolation(v);
                        } //End block
                    } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.344 -0400", hash_original_method = "41F5C3E6841DC86E9C64A72E84C0FF7E", hash_generated_method = "A448FBCDD2997450775A73EE33062671")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void handleViolation(final ViolationInfo info) {
            dsTaint.addTaint(info.dsTaint);
            {
                Log.wtf(TAG, "unexpected null stacktrace");
            } //End block
            Log.d(TAG, "handleViolation; policy=" + info.policy);
            {
                ArrayList<ViolationInfo> violations;
                violations = gatheredViolations.get();
                {
                    violations = new ArrayList<ViolationInfo>(1);
                    gatheredViolations.set(violations);
                } //End block
                {
                    boolean var67E0B061679ECE750C918CCF810C909E_793748063 = (violations.size() >= 5);
                } //End collapsed parenthetic
                {
                    Iterator<ViolationInfo> varD4E3ABC4825F26B3B2AA235E5643CBC8_1182401107 = (violations).iterator();
                    varD4E3ABC4825F26B3B2AA235E5643CBC8_1182401107.hasNext();
                    ViolationInfo previous = varD4E3ABC4825F26B3B2AA235E5643CBC8_1182401107.next();
                    {
                        {
                            boolean varC9FD4943D1AECC98A74F6D3A1A981392_1180418028 = (info.crashInfo.stackTrace.equals(previous.crashInfo.stackTrace));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                violations.add(info);
            } //End block
            Integer crashFingerprint;
            crashFingerprint = info.hashCode();
            long lastViolationTime;
            lastViolationTime = 0;
            {
                boolean var19200966257A15248BB4C14BB760875F_324756379 = (mLastViolationTime.containsKey(crashFingerprint));
                {
                    lastViolationTime = mLastViolationTime.get(crashFingerprint);
                } //End block
            } //End collapsed parenthetic
            long now;
            now = SystemClock.uptimeMillis();
            mLastViolationTime.put(crashFingerprint, now);
            long timeSinceLastViolationMillis;
            timeSinceLastViolationMillis = Long.MAX_VALUE;
            timeSinceLastViolationMillis = (now - lastViolationTime);
            {
                {
                    Log.d(TAG, "StrictMode policy violation; ~duration=" +
                          info.durationMillis + " ms: " + info.crashInfo.stackTrace);
                } //End block
                {
                    Log.d(TAG, "StrictMode policy violation: " + info.crashInfo.stackTrace);
                } //End block
            } //End block
            int violationMaskSubset;
            violationMaskSubset = 0;
            {
                violationMaskSubset |= PENALTY_DIALOG;
            } //End block
            {
                violationMaskSubset |= PENALTY_DROPBOX;
            } //End block
            {
                int violationBit;
                violationBit = parseViolationFromMessage(info.crashInfo.exceptionMessage);
                violationMaskSubset |= violationBit;
                int savedPolicyMask;
                savedPolicyMask = getThreadPolicyMask();
                boolean justDropBox;
                justDropBox = (info.policy & THREAD_PENALTY_MASK) == PENALTY_DROPBOX;
                {
                    dropboxViolationAsync(violationMaskSubset, info);
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
                { }
                finally 
                {
                    setThreadPolicyMask(savedPolicyMask);
                } //End block
            } //End block
            {
                executeDeathPenalty(info);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class AndroidCloseGuardReporter implements CloseGuard.Reporter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.344 -0400", hash_original_method = "A9A1537F709EBCDDB56A99F2748808D0", hash_generated_method = "A9A1537F709EBCDDB56A99F2748808D0")
                public AndroidCloseGuardReporter ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.345 -0400", hash_original_method = "1648939B3F4BE7F697201ED2CA10799D", hash_generated_method = "300D8A7C3C10F1128E114EBA485DC7E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void report(String message, Throwable allocationSite) {
            dsTaint.addTaint(message);
            dsTaint.addTaint(allocationSite.dsTaint);
            onVmPolicyViolation(message, allocationSite);
            // ---------- Original Method ----------
            //onVmPolicyViolation(message, allocationSite);
        }

        
    }


    
    private static class LogStackTrace extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.345 -0400", hash_original_method = "BD681E6068887FE7355C45B36383086D", hash_generated_method = "BD681E6068887FE7355C45B36383086D")
                public LogStackTrace ()
        {
        }


    }


    
    public static class Span {
        private String mName;
        private long mCreateMillis;
        private Span mNext;
        private Span mPrev;
        private ThreadSpanState mContainerState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.346 -0400", hash_original_method = "858C7F08B86E9ABCC5108174CEDFA974", hash_generated_method = "0538523B05FDEB0859DDDA171AA78C24")
        @DSModeled(DSC.SAFE)
         Span(ThreadSpanState threadState) {
            dsTaint.addTaint(threadState.dsTaint);
            // ---------- Original Method ----------
            //mContainerState = threadState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.346 -0400", hash_original_method = "35ECB8DB5D2E2401D23EA00A0B49C3B0", hash_generated_method = "9BA85CCA4EAE21C800E5947B396A9A75")
        @DSModeled(DSC.SAFE)
        protected Span() {
            mContainerState = null;
            // ---------- Original Method ----------
            //mContainerState = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.347 -0400", hash_original_method = "BAA90C1A527ED6ADE64DE9CF5831D500", hash_generated_method = "49FE78DDF43055766791D85ADA96EDF5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void finish() {
            ThreadSpanState state;
            state = mContainerState;
            {
                {
                    mPrev.mNext = mNext;
                } //End block
                {
                    mNext.mPrev = mPrev;
                } //End block
                {
                    boolean var15C0794A52BA15EDCCCE733A675E1A05_1125620282 = (state.mActiveHead == this);
                    {
                        state.mActiveHead = mNext;
                    } //End block
                } //End collapsed parenthetic
                Log.d(TAG, "Span finished=" + mName + "; size=" + state.mActiveSize);
                this.mCreateMillis = -1;
                this.mName = null;
                this.mPrev = null;
                this.mNext = null;
                {
                    this.mNext = state.mFreeListHead;
                    state.mFreeListHead = this;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class ThreadSpanState {
        public Span mActiveHead;
        public int mActiveSize;
        public Span mFreeListHead;
        public int mFreeListSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.347 -0400", hash_original_method = "C2793DA716341667248CA1EC1009DBED", hash_generated_method = "C2793DA716341667248CA1EC1009DBED")
                public ThreadSpanState ()
        {
        }


    }


    
    public static class ViolationInfo {
        public ApplicationErrorReport.CrashInfo crashInfo;
        public int policy;
        public int durationMillis = -1;
        public int numAnimationsRunning = 0;
        public String[] tags;
        public int violationNumThisLoop;
        public long violationUptimeMillis;
        public String broadcastIntentAction;
        public long numInstances = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.347 -0400", hash_original_method = "D15EADA574CC6688E3A5C168E5A51EC1", hash_generated_method = "A280C1FD969189315D7D94DDC8202B0C")
        @DSModeled(DSC.SAFE)
        public ViolationInfo() {
            crashInfo = null;
            policy = 0;
            // ---------- Original Method ----------
            //crashInfo = null;
            //policy = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.348 -0400", hash_original_method = "B97F48EA0F14252413142D91DE4A3BFA", hash_generated_method = "536B5C01A4F9BF2CBAC776138F1C56EA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ViolationInfo(Throwable tr, int policy) {
            dsTaint.addTaint(tr.dsTaint);
            dsTaint.addTaint(policy);
            crashInfo = new ApplicationErrorReport.CrashInfo(tr);
            violationUptimeMillis = SystemClock.uptimeMillis();
            this.numAnimationsRunning = ValueAnimator.getCurrentAnimationsCount();
            Intent broadcastIntent;
            broadcastIntent = ActivityThread.getIntentBeingBroadcast();
            {
                broadcastIntentAction = broadcastIntent.getAction();
            } //End block
            ThreadSpanState state;
            state = sThisThreadSpanState.get();
            {
                this.numInstances = ((InstanceCountViolation) tr).mInstances;
            } //End block
            {
                int spanActiveCount;
                spanActiveCount = state.mActiveSize;
                {
                    spanActiveCount = MAX_SPAN_TAGS;
                } //End block
                {
                    this.tags = new String[spanActiveCount];
                    Span iter;
                    iter = state.mActiveHead;
                    int index;
                    index = 0;
                    {
                        this.tags[index] = iter.mName;
                        iter = iter.mNext;
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.348 -0400", hash_original_method = "2281C8F6C464FE0E4D053A790D9731B4", hash_generated_method = "DE6C347B6BB16E8FA3DE1EBC02820BE9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ViolationInfo(Parcel in) {
            this(in, false);
            dsTaint.addTaint(in.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.349 -0400", hash_original_method = "276C18C659FAD0D183192D3E613DC123", hash_generated_method = "0F6BC3D9B7800F3A66C10AD70D798A79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ViolationInfo(Parcel in, boolean unsetGatheringBit) {
            dsTaint.addTaint(unsetGatheringBit);
            dsTaint.addTaint(in.dsTaint);
            crashInfo = new ApplicationErrorReport.CrashInfo(in);
            int rawPolicy;
            rawPolicy = in.readInt();
            {
                policy = rawPolicy & ~PENALTY_GATHER;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.355 -0400", hash_original_method = "C167EFD1AA966CEFAC170AF811F6D4AF", hash_generated_method = "6DC284609FB60C54C0BE0CF3EEDE9E15")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int result;
            result = 17;
            result = 37 * result + crashInfo.stackTrace.hashCode();
            {
                result *= 37;
            } //End block
            {
                result = 37 * result + broadcastIntentAction.hashCode();
            } //End block
            {
                {
                    String tag = tags[0];
                    {
                        result = 37 * result + tag.hashCode();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.357 -0400", hash_original_method = "4C68F89668EEC8ACA3036C864AE1DCBA", hash_generated_method = "7182D6A3C83EEED3BF11541AA97008FB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.370 -0400", hash_original_method = "FB1CB9CE36DAC72C8A293B50C548452A", hash_generated_method = "F5FD45EB66970B8D5FD22C2997B4C7FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dump(Printer pw, String prefix) {
            dsTaint.addTaint(prefix);
            dsTaint.addTaint(pw.dsTaint);
            crashInfo.dump(pw, prefix);
            pw.println(prefix + "policy: " + policy);
            {
                pw.println(prefix + "durationMillis: " + durationMillis);
            } //End block
            {
                pw.println(prefix + "numInstances: " + numInstances);
            } //End block
            {
                pw.println(prefix + "violationNumThisLoop: " + violationNumThisLoop);
            } //End block
            {
                pw.println(prefix + "numAnimationsRunning: " + numAnimationsRunning);
            } //End block
            pw.println(prefix + "violationUptimeMillis: " + violationUptimeMillis);
            {
                pw.println(prefix + "broadcastIntentAction: " + broadcastIntentAction);
            } //End block
            {
                int index;
                index = 0;
                {
                    String tag = tags[0];
                    {
                        pw.println(prefix + "tag[" + (index++) + "]: " + tag);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class InstanceCountViolation extends Throwable {
        Class mClass;
        long mInstances;
        int mLimit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.370 -0400", hash_original_method = "E80F10435372AA752F8DBC4C44A2404B", hash_generated_method = "96FB8BADC8A17A0D4FC95CF4F0072A4C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InstanceCountViolation(Class klass, long instances, int limit) {
            super(klass.toString() + "; instances=" + instances + "; limit=" + limit);
            dsTaint.addTaint(limit);
            dsTaint.addTaint(klass.dsTaint);
            dsTaint.addTaint(instances);
            setStackTrace(FAKE_STACK);
            // ---------- Original Method ----------
            //setStackTrace(FAKE_STACK);
            //mClass = klass;
            //mInstances = instances;
            //mLimit = limit;
        }

        
        private static final StackTraceElement[] FAKE_STACK = {
            new StackTraceElement("android.os.StrictMode", "setClassInstanceLimit",
                                  "StrictMode.java", 1)
        };
    }


    
    private static final class InstanceTracker {
        private Class<?> mKlass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.371 -0400", hash_original_method = "D1695326538E61C61B9A9871778AEDEF", hash_generated_method = "BC6A1BD5A10FE8CD98A03F70D0214034")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InstanceTracker(Object instance) {
            dsTaint.addTaint(instance.dsTaint);
            mKlass = instance.getClass();
            {
                Integer value;
                value = sInstanceCounts.get(mKlass);
                int newValue;
                newValue = value + 1;
                newValue = 1;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.371 -0400", hash_original_method = "3D9E07641D189E499B7BA8CA77DD9FB9", hash_generated_method = "5AD6BC3EB37253904B9F1D58FC2790CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                {
                    Integer value;
                    value = sInstanceCounts.get(mKlass);
                    {
                        int newValue;
                        newValue = value - 1;
                        {
                            sInstanceCounts.put(mKlass, newValue);
                        } //End block
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

        
        private static final HashMap<Class<?>, Integer> sInstanceCounts =
                new HashMap<Class<?>, Integer>();
    }


    
    private static final String TAG = "StrictMode";
    private static final boolean LOG_V = Log.isLoggable(TAG, Log.VERBOSE);
    private static final boolean IS_USER_BUILD = "user".equals(Build.TYPE);
    private static final boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
    public static final String DISABLE_PROPERTY = "persist.sys.strictmode.disable";
    public static final String VISUAL_PROPERTY = "persist.sys.strictmode.visual";
    private static final long MIN_LOG_INTERVAL_MS = 1000;
    private static final long MIN_DIALOG_INTERVAL_MS = 30000;
    private static final int MAX_SPAN_TAGS = 20;
    private static final int MAX_OFFENSES_PER_LOOP = 10;
    public static final int DETECT_DISK_WRITE = 0x01;
    public static final int DETECT_DISK_READ = 0x02;
    public static final int DETECT_NETWORK = 0x04;
    public static final int DETECT_CUSTOM = 0x08;
    private static final int ALL_THREAD_DETECT_BITS =
            DETECT_DISK_WRITE | DETECT_DISK_READ | DETECT_NETWORK | DETECT_CUSTOM;
    public static final int DETECT_VM_CURSOR_LEAKS = 0x200;
    public static final int DETECT_VM_CLOSABLE_LEAKS = 0x400;
    public static final int DETECT_VM_ACTIVITY_LEAKS = 0x800;
    private static final int DETECT_VM_INSTANCE_LEAKS = 0x1000;
    private static final int ALL_VM_DETECT_BITS =
            DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS |
            DETECT_VM_ACTIVITY_LEAKS | DETECT_VM_INSTANCE_LEAKS;
    public static final int PENALTY_LOG = 0x10;
    public static final int PENALTY_DIALOG = 0x20;
    public static final int PENALTY_DEATH = 0x40;
    public static final int PENALTY_DEATH_ON_NETWORK = 0x200;
    public static final int PENALTY_FLASH = 0x800;
    public static final int PENALTY_DROPBOX = 0x80;
    public static final int PENALTY_GATHER = 0x100;
    private static final int THREAD_PENALTY_MASK =
            PENALTY_LOG | PENALTY_DIALOG | PENALTY_DEATH | PENALTY_DROPBOX | PENALTY_GATHER |
            PENALTY_DEATH_ON_NETWORK | PENALTY_FLASH;
    private static final int VM_PENALTY_MASK =
            PENALTY_LOG | PENALTY_DEATH | PENALTY_DROPBOX;
    private static final HashMap<Class, Integer> EMPTY_CLASS_LIMIT_MAP = new HashMap<Class, Integer>();
    private static volatile int sVmPolicyMask = 0;
    private static volatile VmPolicy sVmPolicy = VmPolicy.LAX;
    private static final AtomicInteger sDropboxCallsInFlight = new AtomicInteger(0);
    private static final ThreadLocal<ArrayList<ViolationInfo>> gatheredViolations = new ThreadLocal<ArrayList<ViolationInfo>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.372 -0400", hash_original_method = "3F7643CB826EF0CE042B1409C79A26FA", hash_generated_method = "186CA0A4C7C571C3F97A8A91C724FE72")
        @DSModeled(DSC.SAFE)
        @Override
        protected ArrayList<ViolationInfo> initialValue() {
            return (ArrayList<ViolationInfo>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ArrayList<ViolationInfo>> violationsBeingTimed = new ThreadLocal<ArrayList<ViolationInfo>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.372 -0400", hash_original_method = "CB5695702D478EAB2FBBE8373134ED39", hash_generated_method = "B199D71A21539352B84FDCC24654F9AE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected ArrayList<ViolationInfo> initialValue() {
            ArrayList<ViolationInfo> var3A78B5BBE0BB8491FDB70462B2CC44CE_758058039 = (new ArrayList<ViolationInfo>());
            return (ArrayList<ViolationInfo>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ViolationInfo>();
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<Handler> threadHandler = new ThreadLocal<Handler>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.372 -0400", hash_original_method = "AFD0CE5945D0E9D14EE2FF5512B9324A", hash_generated_method = "9251EBBEDF9514047B803AFD0F14668E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Handler initialValue() {
            Handler varBA2CC05558C0855B5670B2CE470A504D_1560033943 = (new Handler());
            return (Handler)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Handler();
        }

        
}; //Transformed anonymous class
    private static long sLastInstanceCountCheckMillis = 0;
    private static boolean sIsIdlerRegistered = false;
    private static final MessageQueue.IdleHandler sProcessIdleHandler = new MessageQueue.IdleHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.372 -0400", hash_original_method = "6956F5FF31712AF268FC89A0909C9E82", hash_generated_method = "29358FF334B70C8DF65123375CD1E793")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean queueIdle() {
            long now;
            now = SystemClock.uptimeMillis();
            {
                sLastInstanceCountCheckMillis = now;
                conditionallyCheckInstanceCounts();
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //long now = SystemClock.uptimeMillis();
            //if (now - sLastInstanceCountCheckMillis > 30 * 1000) {
                        //sLastInstanceCountCheckMillis = now;
                        //conditionallyCheckInstanceCounts();
                    //}
            //return true;
        }

        
}; //Transformed anonymous class
    private static final HashMap<Integer, Long> sLastVmViolationTime = new HashMap<Integer, Long>();
    private static final Span NO_OP_SPAN = new Span() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.373 -0400", hash_original_method = "D6FF905BC764A22CD5AFFCB47539B778", hash_generated_method = "3802941F36A062BAA51744D8D659BBA5")
        @DSModeled(DSC.SAFE)
        public void finish() {
            // ---------- Original Method ----------
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ThreadSpanState> sThisThreadSpanState = new ThreadLocal<ThreadSpanState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.373 -0400", hash_original_method = "3F056F46AA4E010EAE891B386F384542", hash_generated_method = "79F1672CEE9AD65B5E4A93EE44FFF3BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected ThreadSpanState initialValue() {
            ThreadSpanState var15F0A2B8FCA5E54778F4D4A4D1DDCC7B_1517201039 = (new ThreadSpanState());
            return (ThreadSpanState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ThreadSpanState();
        }

        
}; //Transformed anonymous class
    private static Singleton<IWindowManager> sWindowManager = new Singleton<IWindowManager>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.373 -0400", hash_original_method = "5B1F4967C7C17AD573D088D6B70DB243", hash_generated_method = "970D504F80411E69369F1E06FAAC7F26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected IWindowManager create() {
            IWindowManager varC157AE586095B148703594F04CAE95C0_396753659 = (IWindowManager.Stub.asInterface(ServiceManager.getService("window")));
            return (IWindowManager)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        }

        
}; //Transformed anonymous class
    private static final HashMap<Class, Integer> sExpectedActivityInstanceCount =
            new HashMap<Class, Integer>();
}

