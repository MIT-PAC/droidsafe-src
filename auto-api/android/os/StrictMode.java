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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.093 -0400", hash_original_method = "E3867A4A77A9B912C067B4B7EB14B6CB", hash_generated_method = "4A3827557D89D96B907E9813E3C5AC14")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.169 -0400", hash_original_field = "F2CE11EBF110993621BEDD8E747D7B1B", hash_generated_field = "DB965A11139AB665B00B4D2E2ABFFB32")

        int mask;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.170 -0400", hash_original_method = "B0AC15ACB9093249F94C953D0A842CAE", hash_generated_method = "CD2B4FBA33571E2F2EF5D0491C95A1F6")
        private  ThreadPolicy(int mask) {
            this.mask = mask;
            // ---------- Original Method ----------
            //this.mask = mask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.170 -0400", hash_original_method = "AE05BE3A66BEE06993F7653F4CB681EB", hash_generated_method = "10A295FC9953AC36C8B62F075D8C1A95")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1812642115 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1812642115 = "[StrictMode.ThreadPolicy; mask=" + mask + "]";
            varB4EAC82CA7396A68D541C85D26508E83_1812642115.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1812642115;
            // ---------- Original Method ----------
            //return "[StrictMode.ThreadPolicy; mask=" + mask + "]";
        }

        
        public static final class Builder {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.171 -0400", hash_original_field = "1C55ADB17279BAC09579C0440A039180", hash_generated_field = "B8B68F2E3B571F250FDA42AEED6F96EC")

            private int mMask = 0;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.190 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "C4A90307B6990541B60C2B86DCD4B526")
            public  Builder() {
                mMask = 0;
                // ---------- Original Method ----------
                //mMask = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.190 -0400", hash_original_method = "2270BC971D9C4F82FBD51366B809A76A", hash_generated_method = "631C274E04C6C0B7E08BF52CFE1C0EDE")
            public  Builder(ThreadPolicy policy) {
                mMask = policy.mask;
                // ---------- Original Method ----------
                //mMask = policy.mask;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.192 -0400", hash_original_method = "399752AE3320783E8BC4077BF2BAABAB", hash_generated_method = "E31A9DDEEEA5992034268B9325CFA119")
            public Builder detectAll() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_181289828 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_181289828 = enable(ALL_THREAD_DETECT_BITS);
                varB4EAC82CA7396A68D541C85D26508E83_181289828.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_181289828;
                // ---------- Original Method ----------
                //return enable(ALL_THREAD_DETECT_BITS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.192 -0400", hash_original_method = "3E31B254E1B4E9A5234881E68AADF1C7", hash_generated_method = "67D60C07A921CF9D3C9657B9239CC15A")
            public Builder permitAll() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_2124348407 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_2124348407 = disable(ALL_THREAD_DETECT_BITS);
                varB4EAC82CA7396A68D541C85D26508E83_2124348407.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_2124348407;
                // ---------- Original Method ----------
                //return disable(ALL_THREAD_DETECT_BITS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.193 -0400", hash_original_method = "8F1CC5D4BDA427578EB68B001E341FDD", hash_generated_method = "0D6C7CE579FED62D3A538042E3F31937")
            public Builder detectNetwork() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_188069296 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_188069296 = enable(DETECT_NETWORK);
                varB4EAC82CA7396A68D541C85D26508E83_188069296.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_188069296;
                // ---------- Original Method ----------
                //return enable(DETECT_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.212 -0400", hash_original_method = "2A4244001D1666DDAFB3F602ED8EC7EA", hash_generated_method = "DE9055778F6D329379B1FE813FCBBF85")
            public Builder permitNetwork() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_151891493 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_151891493 = disable(DETECT_NETWORK);
                varB4EAC82CA7396A68D541C85D26508E83_151891493.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_151891493;
                // ---------- Original Method ----------
                //return disable(DETECT_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.213 -0400", hash_original_method = "75C524432F954C01B0149630CE54DDB4", hash_generated_method = "0350757E0BF095F0CFD124A7E08C91AB")
            public Builder detectDiskReads() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1540676177 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1540676177 = enable(DETECT_DISK_READ);
                varB4EAC82CA7396A68D541C85D26508E83_1540676177.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1540676177;
                // ---------- Original Method ----------
                //return enable(DETECT_DISK_READ);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.213 -0400", hash_original_method = "1BD98C02F9A11EE892D0098B20BDD8BD", hash_generated_method = "D94B507D3821FEB088F051D6F44197DB")
            public Builder permitDiskReads() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1214738331 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1214738331 = disable(DETECT_DISK_READ);
                varB4EAC82CA7396A68D541C85D26508E83_1214738331.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1214738331;
                // ---------- Original Method ----------
                //return disable(DETECT_DISK_READ);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.214 -0400", hash_original_method = "0F761933C6E4A91421ABB8964A4D9EB8", hash_generated_method = "487468EEF0FA966FB33021E9C470B4E5")
            public Builder detectCustomSlowCalls() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_754516889 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_754516889 = enable(DETECT_CUSTOM);
                varB4EAC82CA7396A68D541C85D26508E83_754516889.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_754516889;
                // ---------- Original Method ----------
                //return enable(DETECT_CUSTOM);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.217 -0400", hash_original_method = "1F5E52FF134E5A595D9B4F3AD9EF805B", hash_generated_method = "5C35202F1B897FC21C188BA13D699B40")
            public Builder permitCustomSlowCalls() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_840265667 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_840265667 = enable(DETECT_CUSTOM);
                varB4EAC82CA7396A68D541C85D26508E83_840265667.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_840265667;
                // ---------- Original Method ----------
                //return enable(DETECT_CUSTOM);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.219 -0400", hash_original_method = "583E0D5D228DC11F4F3B1B541EE8393C", hash_generated_method = "76BDF06ABA03060BE05973810062A10A")
            public Builder detectDiskWrites() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1870942555 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1870942555 = enable(DETECT_DISK_WRITE);
                varB4EAC82CA7396A68D541C85D26508E83_1870942555.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1870942555;
                // ---------- Original Method ----------
                //return enable(DETECT_DISK_WRITE);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.219 -0400", hash_original_method = "A37C6D388BF979AC5AEB871BAB2E0B6F", hash_generated_method = "AA813CE64117BDCA61F645B9B9B5118E")
            public Builder permitDiskWrites() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_415217109 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_415217109 = disable(DETECT_DISK_WRITE);
                varB4EAC82CA7396A68D541C85D26508E83_415217109.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_415217109;
                // ---------- Original Method ----------
                //return disable(DETECT_DISK_WRITE);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.232 -0400", hash_original_method = "8766DB09D651E2B3541ACB0418FFA365", hash_generated_method = "EFFA9950E963850F222CE2B94C591113")
            public Builder penaltyDialog() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1164735885 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1164735885 = enable(PENALTY_DIALOG);
                varB4EAC82CA7396A68D541C85D26508E83_1164735885.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1164735885;
                // ---------- Original Method ----------
                //return enable(PENALTY_DIALOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.237 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "5F1982A6C4C08583D8C4D0B6B1FD83A5")
            public Builder penaltyDeath() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1309813139 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1309813139 = enable(PENALTY_DEATH);
                varB4EAC82CA7396A68D541C85D26508E83_1309813139.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1309813139;
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.253 -0400", hash_original_method = "3B3840DC05B4A1C1129369D4324CF6E7", hash_generated_method = "2EF97A31C170B908DCB2F77A7B40F0D1")
            public Builder penaltyDeathOnNetwork() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_129649002 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_129649002 = enable(PENALTY_DEATH_ON_NETWORK);
                varB4EAC82CA7396A68D541C85D26508E83_129649002.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_129649002;
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH_ON_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.258 -0400", hash_original_method = "D2175CC28C327D3A1AEA760A679D2369", hash_generated_method = "730D06AAF9385EA969D44BCD15A46985")
            public Builder penaltyFlashScreen() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1354471962 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1354471962 = enable(PENALTY_FLASH);
                varB4EAC82CA7396A68D541C85D26508E83_1354471962.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1354471962;
                // ---------- Original Method ----------
                //return enable(PENALTY_FLASH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.259 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "4427772EE37E4F43E4991245D0FB99A0")
            public Builder penaltyLog() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_674685973 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_674685973 = enable(PENALTY_LOG);
                varB4EAC82CA7396A68D541C85D26508E83_674685973.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_674685973;
                // ---------- Original Method ----------
                //return enable(PENALTY_LOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.259 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "C9E1CD65716D997196C63760D9B63BF9")
            public Builder penaltyDropBox() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_556048078 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_556048078 = enable(PENALTY_DROPBOX);
                varB4EAC82CA7396A68D541C85D26508E83_556048078.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_556048078;
                // ---------- Original Method ----------
                //return enable(PENALTY_DROPBOX);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.264 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "C5C2786C19A83872ADE65C986DD44CB0")
            private Builder enable(int bit) {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1107433055 = null; //Variable for return #1
                mMask |= bit;
                varB4EAC82CA7396A68D541C85D26508E83_1107433055 = this;
                varB4EAC82CA7396A68D541C85D26508E83_1107433055.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1107433055;
                // ---------- Original Method ----------
                //mMask |= bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.282 -0400", hash_original_method = "DD377E4C338D3B09C11C3D4D7DFD99D3", hash_generated_method = "97461B69C487C60B0F2F798FB2F006E0")
            private Builder disable(int bit) {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1099529567 = null; //Variable for return #1
                mMask &= ~bit;
                varB4EAC82CA7396A68D541C85D26508E83_1099529567 = this;
                varB4EAC82CA7396A68D541C85D26508E83_1099529567.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1099529567;
                // ---------- Original Method ----------
                //mMask &= ~bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.284 -0400", hash_original_method = "3E686B94A275CF17A4C5CE0839D3E8D1", hash_generated_method = "F8A0D8319C274B4FEF87173395EFAB73")
            public ThreadPolicy build() {
                ThreadPolicy varB4EAC82CA7396A68D541C85D26508E83_763072480 = null; //Variable for return #1
                {
                    penaltyLog();
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_763072480 = new ThreadPolicy(mMask);
                varB4EAC82CA7396A68D541C85D26508E83_763072480.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_763072480;
                // ---------- Original Method ----------
                //if (mMask != 0 &&
                    //(mMask & (PENALTY_DEATH | PENALTY_LOG |
                              //PENALTY_DROPBOX | PENALTY_DIALOG)) == 0) {
                    //penaltyLog();
                //}
                //return new ThreadPolicy(mMask);
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.285 -0400", hash_original_field = "E7DFCA04F3BE5F51D0361BA13D9F3EA4", hash_generated_field = "9578A9475850D552D61F6D5FCB916824")

        public static final ThreadPolicy LAX = new ThreadPolicy(0);
    }


    
    public static final class VmPolicy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.285 -0400", hash_original_field = "F2CE11EBF110993621BEDD8E747D7B1B", hash_generated_field = "DB965A11139AB665B00B4D2E2ABFFB32")

        int mask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.285 -0400", hash_original_field = "3FBB4B56631DFF224756AA0554DAE984", hash_generated_field = "C4A68A411991D38DAC450888E1864E75")

        HashMap<Class, Integer> classInstanceLimit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.297 -0400", hash_original_method = "BE6E35A5EA1ACA059EF2A402B69D7023", hash_generated_method = "C40052F13E7704AA82CE57C75F60DC3D")
        private  VmPolicy(int mask, HashMap<Class, Integer> classInstanceLimit) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("classInstanceLimit == null");
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.298 -0400", hash_original_method = "338C4A4B8F91E885EB5A5562BE10EA45", hash_generated_method = "5492CADFA4A48E528A5BDE7BADD7CA92")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_421211769 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_421211769 = "[StrictMode.VmPolicy; mask=" + mask + "]";
            varB4EAC82CA7396A68D541C85D26508E83_421211769.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_421211769;
            // ---------- Original Method ----------
            //return "[StrictMode.VmPolicy; mask=" + mask + "]";
        }

        
        public static final class Builder {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.299 -0400", hash_original_field = "E08A8EE01FA9CEC4B820220831BC5DE3", hash_generated_field = "F7C8905D5B34EE793946807F2A7E20A1")

            private int mMask;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.299 -0400", hash_original_field = "9CEE277A3C9F90A2D4A6976F0323CE98", hash_generated_field = "7DA905668F7F3F2312998927AB27A0B2")

            private HashMap<Class, Integer> mClassInstanceLimit;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.299 -0400", hash_original_field = "1E770C9E586080F95CD045212B6277DA", hash_generated_field = "2D6485C7C663B1648AF525BB6C2310A9")

            private boolean mClassInstanceLimitNeedCow = false;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.300 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "C4A90307B6990541B60C2B86DCD4B526")
            public  Builder() {
                mMask = 0;
                // ---------- Original Method ----------
                //mMask = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.311 -0400", hash_original_method = "FBB1CB3954D34CB1AD109CEFAD7B1DDE", hash_generated_method = "5B93757689D973A3868B8E54B0D3C06F")
            public  Builder(VmPolicy base) {
                mMask = base.mask;
                mClassInstanceLimitNeedCow = true;
                mClassInstanceLimit = base.classInstanceLimit;
                // ---------- Original Method ----------
                //mMask = base.mask;
                //mClassInstanceLimitNeedCow = true;
                //mClassInstanceLimit = base.classInstanceLimit;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.325 -0400", hash_original_method = "E6B0AD736B79FE1E50987D22EA6466E3", hash_generated_method = "1C2D4C5069A56349C6EA9DA222392155")
            public Builder setClassInstanceLimit(Class klass, int instanceLimit) {
                Builder varB4EAC82CA7396A68D541C85D26508E83_854651089 = null; //Variable for return #1
                Builder varB4EAC82CA7396A68D541C85D26508E83_216761582 = null; //Variable for return #2
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("klass == null");
                } //End block
                {
                    {
                        boolean varF54A66C0EAC712B4862EF63071243FC1_465132231 = (mClassInstanceLimit.containsKey(klass) &&
                        mClassInstanceLimit.get(klass) == instanceLimit);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_854651089 = this;
                        } //End block
                    } //End collapsed parenthetic
                    mClassInstanceLimitNeedCow = false;
                    mClassInstanceLimit = (HashMap<Class, Integer>) mClassInstanceLimit.clone();
                } //End block
                {
                    mClassInstanceLimit = new HashMap<Class, Integer>();
                } //End block
                mMask |= DETECT_VM_INSTANCE_LEAKS;
                mClassInstanceLimit.put(klass, instanceLimit);
                varB4EAC82CA7396A68D541C85D26508E83_216761582 = this;
                addTaint(klass.getTaint());
                addTaint(instanceLimit);
                Builder varA7E53CE21691AB073D9660D615818899_865937962; //Final return value
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: //Assign result for return ordinal #1
                        varA7E53CE21691AB073D9660D615818899_865937962 = varB4EAC82CA7396A68D541C85D26508E83_854651089;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_865937962 = varB4EAC82CA7396A68D541C85D26508E83_216761582;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_865937962.addTaint(getTaint()); //Add taint from parent
                return varA7E53CE21691AB073D9660D615818899_865937962;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.341 -0400", hash_original_method = "1E52C56D15D33FA545E602A30D1B7293", hash_generated_method = "284B615E3CA0D28896C06ACCE352CC1B")
            public Builder detectActivityLeaks() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_920182492 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_920182492 = enable(DETECT_VM_ACTIVITY_LEAKS);
                varB4EAC82CA7396A68D541C85D26508E83_920182492.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_920182492;
                // ---------- Original Method ----------
                //return enable(DETECT_VM_ACTIVITY_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.342 -0400", hash_original_method = "CEAA7924A62774EE9F1DB0EAFC23F606", hash_generated_method = "2F1BFBBC327F3C154DD4CAFE8634B9F5")
            public Builder detectAll() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1924341521 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1924341521 = enable(DETECT_VM_ACTIVITY_LEAKS |
                        DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS);
                varB4EAC82CA7396A68D541C85D26508E83_1924341521.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1924341521;
                // ---------- Original Method ----------
                //return enable(DETECT_VM_ACTIVITY_LEAKS |
                        //DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.345 -0400", hash_original_method = "7CA55A1EF27E65D4088A38B2843E1EE5", hash_generated_method = "6411CAC69AF1E4F1ED958082191F9A5C")
            public Builder detectLeakedSqlLiteObjects() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1344072707 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1344072707 = enable(DETECT_VM_CURSOR_LEAKS);
                varB4EAC82CA7396A68D541C85D26508E83_1344072707.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1344072707;
                // ---------- Original Method ----------
                //return enable(DETECT_VM_CURSOR_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.362 -0400", hash_original_method = "76FD4F08E7705E8F66E31708D9A399EA", hash_generated_method = "A30A01C7B56FE8612C84C67AE20E7FF3")
            public Builder detectLeakedClosableObjects() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1266476734 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1266476734 = enable(DETECT_VM_CLOSABLE_LEAKS);
                varB4EAC82CA7396A68D541C85D26508E83_1266476734.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1266476734;
                // ---------- Original Method ----------
                //return enable(DETECT_VM_CLOSABLE_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.363 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "660145417D9B57256C3466796C51B27B")
            public Builder penaltyDeath() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1730023787 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1730023787 = enable(PENALTY_DEATH);
                varB4EAC82CA7396A68D541C85D26508E83_1730023787.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1730023787;
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.364 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "EB8CE87E1A7A410E88970B9AE48CF215")
            public Builder penaltyLog() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1006300979 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1006300979 = enable(PENALTY_LOG);
                varB4EAC82CA7396A68D541C85D26508E83_1006300979.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1006300979;
                // ---------- Original Method ----------
                //return enable(PENALTY_LOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.364 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "A436B5CBFA75C66A2C5F3DF772AEC679")
            public Builder penaltyDropBox() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1278855197 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1278855197 = enable(PENALTY_DROPBOX);
                varB4EAC82CA7396A68D541C85D26508E83_1278855197.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1278855197;
                // ---------- Original Method ----------
                //return enable(PENALTY_DROPBOX);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.380 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "41FB7D3C0620B3A8D76E35577D17650B")
            private Builder enable(int bit) {
                Builder varB4EAC82CA7396A68D541C85D26508E83_634093483 = null; //Variable for return #1
                mMask |= bit;
                varB4EAC82CA7396A68D541C85D26508E83_634093483 = this;
                varB4EAC82CA7396A68D541C85D26508E83_634093483.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_634093483;
                // ---------- Original Method ----------
                //mMask |= bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.381 -0400", hash_original_method = "6432BC9C97797DD02AE9BFA4A7F87D54", hash_generated_method = "E8DCB7F0F24EFD9DA0C882FB9C497CA4")
            public VmPolicy build() {
                VmPolicy varB4EAC82CA7396A68D541C85D26508E83_156762077 = null; //Variable for return #1
                {
                    penaltyLog();
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_156762077 = new VmPolicy(mMask,
                        mClassInstanceLimit != null ? mClassInstanceLimit : EMPTY_CLASS_LIMIT_MAP);
                varB4EAC82CA7396A68D541C85D26508E83_156762077.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_156762077;
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


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.381 -0400", hash_original_field = "F1C7D869EBAAFBDF7AEDBE7466A42F96", hash_generated_field = "9254DDC9D251934961027FD07388D251")

        public static final VmPolicy LAX = new VmPolicy(0, EMPTY_CLASS_LIMIT_MAP);
    }


    
    public static class StrictModeViolation extends BlockGuard.BlockGuardPolicyException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.382 -0400", hash_original_method = "E7438DD65D448EA29E2BF1E2E7B9AF17", hash_generated_method = "DB56652DB836ED6DBA72E2DBDA20575A")
        public  StrictModeViolation(int policyState, int policyViolated, String message) {
            super(policyState, policyViolated, message);
            addTaint(policyState);
            addTaint(policyViolated);
            addTaint(message.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public static class StrictModeNetworkViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.398 -0400", hash_original_method = "DBBD717A236AEADDFBDE9EEC846203D0", hash_generated_method = "67817CB14B73DDA8A675A65BE03ACCB8")
        public  StrictModeNetworkViolation(int policyMask) {
            super(policyMask, DETECT_NETWORK, null);
            addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeDiskReadViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.402 -0400", hash_original_method = "50FAC78594B32A364EC38A7051A6D828", hash_generated_method = "45037306A9E5DF86F945894246B125E2")
        public  StrictModeDiskReadViolation(int policyMask) {
            super(policyMask, DETECT_DISK_READ, null);
            addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeDiskWriteViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.404 -0400", hash_original_method = "3E79DB089B8A8B103215C527DD70DC9D", hash_generated_method = "FC816BAC3953BE8E9F2D0633D3D74C62")
        public  StrictModeDiskWriteViolation(int policyMask) {
            super(policyMask, DETECT_DISK_WRITE, null);
            addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeCustomViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.404 -0400", hash_original_method = "D9775B5587EA33BC7CC7CE8D67F82D3A", hash_generated_method = "8A8AC09FC57A59E62A87D83A3B4D04E3")
        public  StrictModeCustomViolation(int policyMask, String name) {
            super(policyMask, DETECT_CUSTOM, name);
            addTaint(policyMask);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private static class AndroidBlockGuardPolicy implements BlockGuard.Policy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.404 -0400", hash_original_field = "762A5B3087E77BD4ABEEF3C3AF201E66", hash_generated_field = "A3F55928E2CD42B0872F6832B90FE4B8")

        private int mPolicyMask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.405 -0400", hash_original_field = "5836A78E9559B1DE0C28FCB615157AD2", hash_generated_field = "C344AAFE44D978505E4111B8CB7B9A54")

        private HashMap<Integer, Long> mLastViolationTime = new HashMap<Integer, Long>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.405 -0400", hash_original_method = "56B73F441F57B7F1580692BF8D8E5ECB", hash_generated_method = "D44A205806718F04E37473DFF9A09152")
        public  AndroidBlockGuardPolicy(final int policyMask) {
            mPolicyMask = policyMask;
            // ---------- Original Method ----------
            //mPolicyMask = policyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.419 -0400", hash_original_method = "EC02A08C2D3910C2DE1DA94FE738CE60", hash_generated_method = "B322B3A8808A94032564714B4BADEACB")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1369813684 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1369813684 = "AndroidBlockGuardPolicy; mPolicyMask=" + mPolicyMask;
            varB4EAC82CA7396A68D541C85D26508E83_1369813684.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1369813684;
            // ---------- Original Method ----------
            //return "AndroidBlockGuardPolicy; mPolicyMask=" + mPolicyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.420 -0400", hash_original_method = "BDAE35F9BC36FEF12DCB9013D520032B", hash_generated_method = "AD5762150B5AAFA3767F5D2A02D69E25")
        public int getPolicyMask() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272265082 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272265082;
            // ---------- Original Method ----------
            //return mPolicyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.424 -0400", hash_original_method = "0D85458AC3FF96FC22E8C3819C12EFAB", hash_generated_method = "5E3578170A9A0BE6F1AE04BB85F2107A")
        public void onWriteToDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_1291623016 = (tooManyViolationsThisLoop());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.438 -0400", hash_original_method = "B44201BA71724735A91DD4F1FF43D337", hash_generated_method = "8618EF661365CA6D583FDA31CC5CD0DA")
         void onCustomSlowCall(String name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_443575591 = (tooManyViolationsThisLoop());
            } //End collapsed parenthetic
            BlockGuard.BlockGuardPolicyException e;
            e = new StrictModeCustomViolation(mPolicyMask, name);
            e.fillInStackTrace();
            startHandlingViolationException(e);
            addTaint(name.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.439 -0400", hash_original_method = "DC9910586B30548E82E107CFA3542EA2", hash_generated_method = "EB358DA314068F35F91A249E65B65971")
        public void onReadFromDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_497429341 = (tooManyViolationsThisLoop());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.440 -0400", hash_original_method = "D41EA35CCA984A26E96A9AAEEE4BCF1E", hash_generated_method = "CDF55F3FD19E8E7120FBA29844277DF1")
        public void onNetwork() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                if (DroidSafeAndroidRuntime.control) throw new NetworkOnMainThreadException();
            } //End block
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_411710951 = (tooManyViolationsThisLoop());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.440 -0400", hash_original_method = "A35D2E9A8AD0B9C28C9280D1C3956061", hash_generated_method = "6D9513DC2646B63D96CE73E109E46A70")
        public void setPolicyMask(int policyMask) {
            mPolicyMask = policyMask;
            // ---------- Original Method ----------
            //mPolicyMask = policyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.453 -0400", hash_original_method = "5E39E8C314EEA382AFAE0CC045B36998", hash_generated_method = "4EC3F4FC10F730A01CA191AE81FD3E10")
         void startHandlingViolationException(BlockGuard.BlockGuardPolicyException e) {
            ViolationInfo info;
            info = new ViolationInfo(e, e.getPolicy());
            info.violationUptimeMillis = SystemClock.uptimeMillis();
            handleViolationWithTimingAttempt(info);
            addTaint(e.getTaint());
            // ---------- Original Method ----------
            //final ViolationInfo info = new ViolationInfo(e, e.getPolicy());
            //info.violationUptimeMillis = SystemClock.uptimeMillis();
            //handleViolationWithTimingAttempt(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.467 -0400", hash_original_method = "E564B46DD31AF359B07F190378DAA828", hash_generated_method = "D23E16BEBB082B9C930C26AFA8ECABC5")
         void handleViolationWithTimingAttempt(final ViolationInfo info) {
            Looper looper;
            looper = Looper.myLooper();
            {
                info.durationMillis = -1;
                handleViolation(info);
            } //End block
            ArrayList<ViolationInfo> records;
            records = violationsBeingTimed.get();
            {
                boolean var93D414F0DAF507CC4844CFB90F056FDD_1780710101 = (records.size() >= MAX_OFFENSES_PER_LOOP);
            } //End collapsed parenthetic
            records.add(info);
            {
                boolean varD777943406E4C57D521B6D48914E48C5_769782712 = (records.size() > 1);
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.455 -0400", hash_original_method = "13A73E46BCAE9FB3F25E0C7CB59DBB78", hash_generated_method = "2F1913436814823B79CFA298604766BB")
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
                        boolean var295180DEA5F59A98ADD9FC6CF590545D_1943273644 = (n < records.size());
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
            addTaint(info.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.929 -0400", hash_original_method = "41F5C3E6841DC86E9C64A72E84C0FF7E", hash_generated_method = "6E38D604711AE8A0F4A69435C6F735B3")
         void handleViolation(final ViolationInfo info) {
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
                    boolean var67E0B061679ECE750C918CCF810C909E_1748413780 = (violations.size() >= 5);
                } //End collapsed parenthetic
                {
                    Iterator<ViolationInfo> varD4E3ABC4825F26B3B2AA235E5643CBC8_1169060213 = (violations).iterator();
                    varD4E3ABC4825F26B3B2AA235E5643CBC8_1169060213.hasNext();
                    ViolationInfo previous = varD4E3ABC4825F26B3B2AA235E5643CBC8_1169060213.next();
                    {
                        {
                            boolean varC9FD4943D1AECC98A74F6D3A1A981392_1783551269 = (info.crashInfo.stackTrace.equals(previous.crashInfo.stackTrace));
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
                boolean var19200966257A15248BB4C14BB760875F_276671194 = (mLastViolationTime.containsKey(crashFingerprint));
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
            addTaint(info.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class AndroidCloseGuardReporter implements CloseGuard.Reporter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.930 -0400", hash_original_method = "E7772DF8591E8A95C00A24C3A7BC9385", hash_generated_method = "E7772DF8591E8A95C00A24C3A7BC9385")
        public AndroidCloseGuardReporter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.930 -0400", hash_original_method = "1648939B3F4BE7F697201ED2CA10799D", hash_generated_method = "16E582CA6C32D14F89CD98E1A8A95066")
        public void report(String message, Throwable allocationSite) {
            onVmPolicyViolation(message, allocationSite);
            addTaint(message.getTaint());
            addTaint(allocationSite.getTaint());
            // ---------- Original Method ----------
            //onVmPolicyViolation(message, allocationSite);
        }

        
    }


    
    private static class LogStackTrace extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.944 -0400", hash_original_method = "9318B319D2DE8ECE742465D2C7D8840B", hash_generated_method = "9318B319D2DE8ECE742465D2C7D8840B")
        public LogStackTrace ()
        {
            //Synthesized constructor
        }


    }


    
    public static class Span {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.945 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

        private String mName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.945 -0400", hash_original_field = "71A6739ACA1D6EFC8CA8BC59BC80FD37", hash_generated_field = "D9168B950155534AAD832724FE52C500")

        private long mCreateMillis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.945 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "E39EFCE10572D87C6F95E3A2B2BDFCB1")

        private Span mNext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.945 -0400", hash_original_field = "FBB5FC609118D0EDF116DBF7ED6BF692", hash_generated_field = "ABC77622AA8E19FF30E79A0A19830013")

        private Span mPrev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.945 -0400", hash_original_field = "ABDCF3E72E2FC93754EA083FEF8563EA", hash_generated_field = "71A5A2213C60169AAE2591AE6952C837")

        private ThreadSpanState mContainerState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.946 -0400", hash_original_method = "858C7F08B86E9ABCC5108174CEDFA974", hash_generated_method = "46A08256E701EE28F27EFDCC6EA7A311")
          Span(ThreadSpanState threadState) {
            mContainerState = threadState;
            // ---------- Original Method ----------
            //mContainerState = threadState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.946 -0400", hash_original_method = "35ECB8DB5D2E2401D23EA00A0B49C3B0", hash_generated_method = "9BA85CCA4EAE21C800E5947B396A9A75")
        protected  Span() {
            mContainerState = null;
            // ---------- Original Method ----------
            //mContainerState = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.947 -0400", hash_original_method = "BAA90C1A527ED6ADE64DE9CF5831D500", hash_generated_method = "46C88CFCC6E7C87455C81BBE221135B4")
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
                    boolean var15C0794A52BA15EDCCCE733A675E1A05_1954446247 = (state.mActiveHead == this);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.947 -0400", hash_original_field = "220FBF2583583706382506D68268B363", hash_generated_field = "518A04ADDEBFAA97A1EA0148B6F5FA97")

        public Span mActiveHead;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.947 -0400", hash_original_field = "E500488743B25A4A8E8980B2D8DD40C7", hash_generated_field = "B6D1D7D2D17432EE321593A3AEA5D914")

        public int mActiveSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.947 -0400", hash_original_field = "00C965908374A4B07EA5F85866B67C2E", hash_generated_field = "DA0030F95E05B17A8A5730A244932CA8")

        public Span mFreeListHead;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.947 -0400", hash_original_field = "E6AAF02BCBC197E806D06FB5EC18625D", hash_generated_field = "C3221ED1F561EAEA75567095BA88D9C9")

        public int mFreeListSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.947 -0400", hash_original_method = "897FCF469D672A73C45810344D5B48A8", hash_generated_method = "897FCF469D672A73C45810344D5B48A8")
        public ThreadSpanState ()
        {
            //Synthesized constructor
        }


    }


    
    public static class ViolationInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.948 -0400", hash_original_field = "E2830D8E0018BB9D7C72E36DDDB650B2", hash_generated_field = "CD846E661E8E518C4347C2ACA6146A7E")

        public ApplicationErrorReport.CrashInfo crashInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.948 -0400", hash_original_field = "F4AF8B5789576C000CE9105B25609BD6", hash_generated_field = "930B7D58F3DA097BBD08C13024DA937C")

        public int policy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.948 -0400", hash_original_field = "A8D317E1C938926947C4B210EBCECC1E", hash_generated_field = "F1C866B29B39A143C5FBB9A0CA778367")

        public int durationMillis = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.948 -0400", hash_original_field = "EEC8A1FCD4B77BB69BB144F25454CF22", hash_generated_field = "678196736B2E56BCECB08188576F10CE")

        public int numAnimationsRunning = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.948 -0400", hash_original_field = "D57AC45256849D9B13E2422D91580FB9", hash_generated_field = "F792D5F97BD30C470267CF28260B7EA9")

        public String[] tags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.948 -0400", hash_original_field = "8B568DABCCACE2EF4A593CDD6BCF2581", hash_generated_field = "AF05918DADCF889F179D3E20609A32AE")

        public int violationNumThisLoop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.948 -0400", hash_original_field = "DB2C6E10DE0472A82B45FDB1B9070EA2", hash_generated_field = "0AAC6D73647F1D34E070F27F164676C0")

        public long violationUptimeMillis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.948 -0400", hash_original_field = "A7BB6B742243FDA7D77036B57CD43DFF", hash_generated_field = "4B3B10B2069653BB6ABA4070A65734B4")

        public String broadcastIntentAction;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.948 -0400", hash_original_field = "CAB9C7B63599DF30611D8941676ECA28", hash_generated_field = "FCE79C922D923B8021DEFCC4604B4FB6")

        public long numInstances = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.966 -0400", hash_original_method = "D15EADA574CC6688E3A5C168E5A51EC1", hash_generated_method = "A280C1FD969189315D7D94DDC8202B0C")
        public  ViolationInfo() {
            crashInfo = null;
            policy = 0;
            // ---------- Original Method ----------
            //crashInfo = null;
            //policy = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.968 -0400", hash_original_method = "B97F48EA0F14252413142D91DE4A3BFA", hash_generated_method = "F359F3FF2EA18FD8D760E795CD2506BE")
        public  ViolationInfo(Throwable tr, int policy) {
            crashInfo = new ApplicationErrorReport.CrashInfo(tr);
            violationUptimeMillis = SystemClock.uptimeMillis();
            this.policy = policy;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.968 -0400", hash_original_method = "2281C8F6C464FE0E4D053A790D9731B4", hash_generated_method = "1DBE6343F31808980E62E49AD84C659D")
        public  ViolationInfo(Parcel in) {
            this(in, false);
            addTaint(in.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.980 -0400", hash_original_method = "276C18C659FAD0D183192D3E613DC123", hash_generated_method = "404214BF3FC46E5DE009F4A62ABCD5EA")
        public  ViolationInfo(Parcel in, boolean unsetGatheringBit) {
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
            addTaint(unsetGatheringBit);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.073 -0400", hash_original_method = "C167EFD1AA966CEFAC170AF811F6D4AF", hash_generated_method = "70C0C66630A44090BD7330B8F97A24BF")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028451305 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028451305;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.074 -0400", hash_original_method = "4C68F89668EEC8ACA3036C864AE1DCBA", hash_generated_method = "6E5657C7F8C25ACC14EB25627C3319D3")
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
            addTaint(dest.getTaint());
            addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.278 -0400", hash_original_method = "FB1CB9CE36DAC72C8A293B50C548452A", hash_generated_method = "BBB192A0FA28EF6E686D4B7CBFB58E3F")
        public void dump(Printer pw, String prefix) {
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
            addTaint(pw.getTaint());
            addTaint(prefix.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class InstanceCountViolation extends Throwable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.279 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "CE233813880487C713DB65203E06BCD9")

        Class mClass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.279 -0400", hash_original_field = "0D41B5AD1A7DB10272E2084BC9A3392B", hash_generated_field = "74080197B20CB35716F08D82964BE351")

        long mInstances;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.279 -0400", hash_original_field = "5B168C2292FF8EC273A67B1639E35C5D", hash_generated_field = "EAF07362CB0DE5A45A6B09193DE62144")

        int mLimit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.288 -0400", hash_original_method = "E80F10435372AA752F8DBC4C44A2404B", hash_generated_method = "019519EF16106C35D92003DDACCE9C26")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.288 -0400", hash_original_field = "23D915E793BC37F0BB86A95A59152961", hash_generated_field = "38AF7AF18858645C8A5A9D1133592681")

        private static StackTraceElement[] FAKE_STACK = {
            new StackTraceElement("android.os.StrictMode", "setClassInstanceLimit",
                                  "StrictMode.java", 1)
        };
    }


    
    private static final class InstanceTracker {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.288 -0400", hash_original_field = "644134EA3E6C2A378776F1961BA35811", hash_generated_field = "C91F484EFB2D5A548FE76D861FC04B66")

        private Class<?> mKlass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.289 -0400", hash_original_method = "D1695326538E61C61B9A9871778AEDEF", hash_generated_method = "9E43F87CBE0F8535C2AAACA96F72D40E")
        public  InstanceTracker(Object instance) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.298 -0400", hash_original_method = "3D9E07641D189E499B7BA8CA77DD9FB9", hash_generated_method = "5AD6BC3EB37253904B9F1D58FC2790CC")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "DD4CBD89079F688DE59AFC08B54388CB", hash_generated_field = "D227B2144252BA723E5B198A9AB9C7D3")

        private static HashMap<Class<?>, Integer> sInstanceCounts = new HashMap<Class<?>, Integer>();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "D3088EBAFFC0370793C876A1F529BEBF", hash_generated_field = "BF2DBE46E9E09EC9194266CB640DA9C3")

    private static String TAG = "StrictMode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "10012F752FC38C6B0CFDEC1B2E5B89AC", hash_generated_field = "FF231DB60B6985199FD198EC02D3EBFB")

    private static boolean LOG_V = Log.isLoggable(TAG, Log.VERBOSE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "A3F06E2DBC0DA963DFE1E41E297E849D", hash_generated_field = "CDCF7D9C7F241DEA613A00EC079ECA9D")

    private static boolean IS_USER_BUILD = "user".equals(Build.TYPE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "9D23AE2E1DF0783311B7EE88635EC302", hash_generated_field = "B7A55850ECF055033089690CFA190DA8")

    private static boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "F9788FE80D74F8AAF2B2257306FDF4F9", hash_generated_field = "3E92FD7ABB6619B38D620EDF029A22D9")

    public static final String DISABLE_PROPERTY = "persist.sys.strictmode.disable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "3475CE826B41B81BE9A2D348A9BB7CC8", hash_generated_field = "E70A21C58D25E28726CC89D8D9240ACA")

    public static final String VISUAL_PROPERTY = "persist.sys.strictmode.visual";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "405B98439BDD5E31488F7FE63DB2894F", hash_generated_field = "145B2A7C6B07739B24AD97444DC1B7EE")

    private static long MIN_LOG_INTERVAL_MS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "8D3BFCEBD0B88320011AA9B14A23B692", hash_generated_field = "DBE8F2F1AA795C9A861B1A5FE4B1253F")

    private static long MIN_DIALOG_INTERVAL_MS = 30000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "99EEFDD9B0F488ABE9D28409ED32E932", hash_generated_field = "157CF4BBC45A4B5F80318A1CC26C0FE7")

    private static int MAX_SPAN_TAGS = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.299 -0400", hash_original_field = "7A0A915FE061437DB98B2890AB7CF2CE", hash_generated_field = "95DEF9A044A08A95D12DD9E6099F34FF")

    private static int MAX_OFFENSES_PER_LOOP = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "D0F089381407693056149FE7CAA95BCE", hash_generated_field = "D504D2B86CFCD35894735D0BCD3EEA33")

    public static final int DETECT_DISK_WRITE = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "02C6FDF2CB0A3F274F5C7987262E09FC", hash_generated_field = "7C0AAD2513E22025E4555E4D43F8297C")

    public static final int DETECT_DISK_READ = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "74E04715DA6896901F74DA436A9AA197", hash_generated_field = "A0953BEBDA93B5AC1BDC661CE1AF0C64")

    public static final int DETECT_NETWORK = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "D5619D251598C75279F91C1DCF262984", hash_generated_field = "EDC2D333C7911473B0EA87279BE3E8A6")

    public static final int DETECT_CUSTOM = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "3B9D21470B9E6740B57563462D0BA29C", hash_generated_field = "CEBA44C621AC05C3BC4AB24D41454F0A")

    private static int ALL_THREAD_DETECT_BITS = DETECT_DISK_WRITE | DETECT_DISK_READ | DETECT_NETWORK | DETECT_CUSTOM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "6AF2813DB695929029F4BA10476B0CC0", hash_generated_field = "C8547878D8DA9B32C40632615B8C73D7")

    public static final int DETECT_VM_CURSOR_LEAKS = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "36E68A513DD293E166FB4F54BE29725C", hash_generated_field = "C9E5621265A28DF38A8FC7DA71DC98E1")

    public static final int DETECT_VM_CLOSABLE_LEAKS = 0x400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "A2310CDBCDD4C509EFF401292464CFD9", hash_generated_field = "FF0F20EB6EA7B6EFA0B50FB48E32AE8B")

    public static final int DETECT_VM_ACTIVITY_LEAKS = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "E52124B43913136C666B021988F5DEA8", hash_generated_field = "CDFFFD6F85F2BB5F914FA260B847F5B6")

    private static int DETECT_VM_INSTANCE_LEAKS = 0x1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "AD30D8213DA72B532896F5533DB7DEE7", hash_generated_field = "2748DE1D930A0AF7AF784911FEAFC4C5")

    private static int ALL_VM_DETECT_BITS = DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS |
            DETECT_VM_ACTIVITY_LEAKS | DETECT_VM_INSTANCE_LEAKS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "8FC0A17F12BDF8741B92E5F01FD7DCB6", hash_generated_field = "AD440199AC90AA853DAE6E553309E61E")

    public static final int PENALTY_LOG = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "5237B015D0FD40554D978C3F16F56117", hash_generated_field = "1B09956BCE6604535346C86F86199656")

    public static final int PENALTY_DIALOG = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "F3FAE1CCEDA4AC19AA37F2365135E9ED", hash_generated_field = "36B2F4DE7C0AEF684C2D4A0EA98A5FF6")

    public static final int PENALTY_DEATH = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "6F33760461E8219F9AA6406FE6162556", hash_generated_field = "43A59BD7C5C50C06D41CB3576F113D90")

    public static final int PENALTY_DEATH_ON_NETWORK = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.300 -0400", hash_original_field = "F6A171ECCB6555D6BF6665A4505B4B88", hash_generated_field = "D95570E99357CC6CAAFB830E0B8059B4")

    public static final int PENALTY_FLASH = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.301 -0400", hash_original_field = "56D01B1E4CE134211CEAD29A319DCB2D", hash_generated_field = "97FF6CEFBEACB56FCE27CC1D38BF5293")

    public static final int PENALTY_DROPBOX = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.301 -0400", hash_original_field = "275C15273FF88D606EF53A171326A356", hash_generated_field = "4A0AEEF9679F704885B2B478E1F03646")

    public static final int PENALTY_GATHER = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.301 -0400", hash_original_field = "5FE094B1555185981A4C03805EB67AC8", hash_generated_field = "D28C78FE2981DAD6D5F1E4B2135EC102")

    private static int THREAD_PENALTY_MASK = PENALTY_LOG | PENALTY_DIALOG | PENALTY_DEATH | PENALTY_DROPBOX | PENALTY_GATHER |
            PENALTY_DEATH_ON_NETWORK | PENALTY_FLASH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.301 -0400", hash_original_field = "12DCAF055C72980A2456D711E10064E9", hash_generated_field = "BB6F58FD3F320A78AF3F9FE30B49928F")

    private static int VM_PENALTY_MASK = PENALTY_LOG | PENALTY_DEATH | PENALTY_DROPBOX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.301 -0400", hash_original_field = "80C5BEAC52B0A4A37042B6AB8F02D3DA", hash_generated_field = "7815FEE99EF069587F6DDBAF20CA5CEF")

    private static HashMap<Class, Integer> EMPTY_CLASS_LIMIT_MAP = new HashMap<Class, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.301 -0400", hash_original_field = "73935208411D2C33F2F434E725AFAB4F", hash_generated_field = "A2DC93C9353C0CDFE42E43F2EDB31797")

    private static volatile int sVmPolicyMask = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.301 -0400", hash_original_field = "0EFDB39AB4151B8C9E69E1E46920E6DD", hash_generated_field = "6C6283435840FF828818AEADC035BB2B")

    private static volatile VmPolicy sVmPolicy = VmPolicy.LAX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.301 -0400", hash_original_field = "A6C62B4D7E99D84A85CA2ACFE986625B", hash_generated_field = "FFFD69F1ABFEB4879E6D470B817AB720")

    private static AtomicInteger sDropboxCallsInFlight = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.320 -0400", hash_original_field = "032D1DB3AC7977666A8FEE9196953B73", hash_generated_field = "84E86E4C3913A469E7892E8262F8CC80")

    private static ThreadLocal<ArrayList<ViolationInfo>> gatheredViolations = new ThreadLocal<ArrayList<ViolationInfo>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.320 -0400", hash_original_method = "3F7643CB826EF0CE042B1409C79A26FA", hash_generated_method = "8D2391A0186FA7B35D7C4EC49608ED96")
        @Override
        protected ArrayList<ViolationInfo> initialValue() {
            ArrayList<ViolationInfo> varB4EAC82CA7396A68D541C85D26508E83_1034207441 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1034207441 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1034207441.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1034207441;
            // ---------- Original Method ----------
            //return null;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.321 -0400", hash_original_field = "715B49E3F5CF23D0F2283607FFE671D2", hash_generated_field = "35C58168B764E3C5986C7BDAD3253C15")

    private static ThreadLocal<ArrayList<ViolationInfo>> violationsBeingTimed = new ThreadLocal<ArrayList<ViolationInfo>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.321 -0400", hash_original_method = "CB5695702D478EAB2FBBE8373134ED39", hash_generated_method = "572A58481F1D9D02869DD9D6C212C9AD")
        @Override
        protected ArrayList<ViolationInfo> initialValue() {
            ArrayList<ViolationInfo> varB4EAC82CA7396A68D541C85D26508E83_271964110 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_271964110 = new ArrayList<ViolationInfo>();
            varB4EAC82CA7396A68D541C85D26508E83_271964110.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_271964110;
            // ---------- Original Method ----------
            //return new ArrayList<ViolationInfo>();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.322 -0400", hash_original_field = "04600256D4F94A088BAF90F3ED687D15", hash_generated_field = "1B69432EE3B3538FD6344A16367F8D88")

    private static ThreadLocal<Handler> threadHandler = new ThreadLocal<Handler>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.321 -0400", hash_original_method = "AFD0CE5945D0E9D14EE2FF5512B9324A", hash_generated_method = "F666013497219783CFFE71638C486FC5")
        @Override
        protected Handler initialValue() {
            Handler varB4EAC82CA7396A68D541C85D26508E83_572680742 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_572680742 = new Handler();
            varB4EAC82CA7396A68D541C85D26508E83_572680742.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_572680742;
            // ---------- Original Method ----------
            //return new Handler();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.322 -0400", hash_original_field = "50788C7D307BD300374B864F668BDEBC", hash_generated_field = "9856A17E5723F71B95FE2020E6AD7FC5")

    private static long sLastInstanceCountCheckMillis = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.322 -0400", hash_original_field = "DCEA3F8C01AD46840FAE99198C9AAA60", hash_generated_field = "620CC23E40F92E04CF705F8C05DDBFB2")

    private static boolean sIsIdlerRegistered = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.325 -0400", hash_original_field = "B164AA3A1AEF10C398FA471F54B9AC10", hash_generated_field = "D6BDBBA63B0B43888A5099F866166634")

    private static MessageQueue.IdleHandler sProcessIdleHandler = new MessageQueue.IdleHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.322 -0400", hash_original_method = "6956F5FF31712AF268FC89A0909C9E82", hash_generated_method = "0C0D8A68FCFBADBA0C3E8E84EBF2EB58")
        public boolean queueIdle() {
            long now;
            now = SystemClock.uptimeMillis();
            {
                sLastInstanceCountCheckMillis = now;
                conditionallyCheckInstanceCounts();
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075077358 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075077358;
            // ---------- Original Method ----------
            //long now = SystemClock.uptimeMillis();
            //if (now - sLastInstanceCountCheckMillis > 30 * 1000) {
                        //sLastInstanceCountCheckMillis = now;
                        //conditionallyCheckInstanceCounts();
                    //}
            //return true;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.325 -0400", hash_original_field = "1D538736D2B5D329201BCBD8472DDCFE", hash_generated_field = "F90A6FD292B17E7B92A77E645B59D9B6")

    private static HashMap<Integer, Long> sLastVmViolationTime = new HashMap<Integer, Long>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.326 -0400", hash_original_field = "B86F8D90AB0DCFAFBC62E8F4A57E71BB", hash_generated_field = "037F713F8A540FD16401152D82CD1E7A")

    private static Span NO_OP_SPAN = new Span() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.326 -0400", hash_original_method = "D6FF905BC764A22CD5AFFCB47539B778", hash_generated_method = "3802941F36A062BAA51744D8D659BBA5")
        public void finish() {
            // ---------- Original Method ----------
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.341 -0400", hash_original_field = "B8165DB8CA25EBB672A04ED87F0CC32F", hash_generated_field = "4A2B43B1B0AF065B6C6E3BC575B7C2EC")

    private static ThreadLocal<ThreadSpanState> sThisThreadSpanState = new ThreadLocal<ThreadSpanState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.341 -0400", hash_original_method = "3F056F46AA4E010EAE891B386F384542", hash_generated_method = "3D3BE33FDA2413DBE9F15F50E1A68718")
        @Override
        protected ThreadSpanState initialValue() {
            ThreadSpanState varB4EAC82CA7396A68D541C85D26508E83_931565465 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_931565465 = new ThreadSpanState();
            varB4EAC82CA7396A68D541C85D26508E83_931565465.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_931565465;
            // ---------- Original Method ----------
            //return new ThreadSpanState();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.342 -0400", hash_original_field = "9012BF47FFA40D3BC924A9D478958B38", hash_generated_field = "48F13EBB584BFE9FFC3E8F88A8129C39")

    private static Singleton<IWindowManager> sWindowManager = new Singleton<IWindowManager>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.342 -0400", hash_original_method = "5B1F4967C7C17AD573D088D6B70DB243", hash_generated_method = "20EE9D9170F06D39077B96631BEDCAA8")
        protected IWindowManager create() {
            IWindowManager varB4EAC82CA7396A68D541C85D26508E83_1070344842 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1070344842 = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
            varB4EAC82CA7396A68D541C85D26508E83_1070344842.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1070344842;
            // ---------- Original Method ----------
            //return IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.343 -0400", hash_original_field = "085DE61E4920EC06EF3FB909B8607AB0", hash_generated_field = "B89979A31B1E22FFE880A2C50A950A92")

    private static HashMap<Class, Integer> sExpectedActivityInstanceCount = new HashMap<Class, Integer>();
}

