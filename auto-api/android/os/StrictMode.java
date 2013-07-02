package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.287 -0400", hash_original_method = "E3867A4A77A9B912C067B4B7EB14B6CB", hash_generated_method = "4A3827557D89D96B907E9813E3C5AC14")
    private  StrictMode() {
        
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

    
    @DSModeled(DSC.SAFE)
    private static void setCloseGuardEnabled(boolean enabled) {
        if (!(CloseGuard.getReporter() instanceof AndroidCloseGuardReporter)) {
            CloseGuard.setReporter(new AndroidCloseGuardReporter());
        }
        CloseGuard.setEnabled(enabled);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getThreadPolicyMask() {
        return BlockGuard.getThreadPolicy().getPolicyMask();
    }

    
    @DSModeled(DSC.SAFE)
    public static ThreadPolicy getThreadPolicy() {
        return new ThreadPolicy(getThreadPolicyMask());
    }

    
    @DSModeled(DSC.SAFE)
    public static ThreadPolicy allowThreadDiskWrites() {
        int oldPolicyMask = getThreadPolicyMask();
        int newPolicyMask = oldPolicyMask & ~(DETECT_DISK_WRITE | DETECT_DISK_READ);
        if (newPolicyMask != oldPolicyMask) {
            setThreadPolicyMask(newPolicyMask);
        }
        return new ThreadPolicy(oldPolicyMask);
    }

    
    @DSModeled(DSC.SAFE)
    public static ThreadPolicy allowThreadDiskReads() {
        int oldPolicyMask = getThreadPolicyMask();
        int newPolicyMask = oldPolicyMask & ~(DETECT_DISK_READ);
        if (newPolicyMask != oldPolicyMask) {
            setThreadPolicyMask(newPolicyMask);
        }
        return new ThreadPolicy(oldPolicyMask);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void enableDeathOnNetwork() {
        int oldPolicy = getThreadPolicyMask();
        int newPolicy = oldPolicy | DETECT_NETWORK | PENALTY_DEATH_ON_NETWORK;
        setThreadPolicyMask(newPolicy);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static boolean tooManyViolationsThisLoop() {
        return violationsBeingTimed.get().size() >= MAX_OFFENSES_PER_LOOP;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    static boolean hasGatheredViolations() {
        return gatheredViolations.get() != null;
    }

    
    @DSModeled(DSC.SAFE)
    static void clearGatheredViolations() {
        gatheredViolations.set(null);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void onSqliteObjectLeaked(String message, Throwable originStack) {
        
        onVmPolicyViolation(message, originStack);
    }

    
    @DSModeled(DSC.SAFE)
    public static void onWebViewMethodCalledOnWrongThread(Throwable originStack) {
        
        onVmPolicyViolation(null, originStack);
    }

    
    @DSModeled(DSC.SAFE)
    public static void onVmPolicyViolation(String message, Throwable originStack) {
        
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static void onBinderStrictModePolicyChange(int newPolicy) {
        setBlockGuardPolicy(newPolicy);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void noteSlowCall(String name) {
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onCustomSlowCall(name);
    }

    
    @DSModeled(DSC.SAFE)
    public static void noteDiskRead() {
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onReadFromDisk();
    }

    
    @DSModeled(DSC.SAFE)
    public static void noteDiskWrite() {
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onWriteToDisk();
    }

    
    @DSModeled(DSC.SAFE)
    public static Object trackActivity(Object instance) {
        return new InstanceTracker(instance);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.293 -0400", hash_original_field = "F2CE11EBF110993621BEDD8E747D7B1B", hash_generated_field = "DB965A11139AB665B00B4D2E2ABFFB32")

        int mask;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.293 -0400", hash_original_method = "B0AC15ACB9093249F94C953D0A842CAE", hash_generated_method = "CD2B4FBA33571E2F2EF5D0491C95A1F6")
        private  ThreadPolicy(int mask) {
            this.mask = mask;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.294 -0400", hash_original_method = "AE05BE3A66BEE06993F7653F4CB681EB", hash_generated_method = "F2E08753211F1B9B511B88DC74CD29AC")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2070223700 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2070223700 = "[StrictMode.ThreadPolicy; mask=" + mask + "]";
            varB4EAC82CA7396A68D541C85D26508E83_2070223700.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2070223700;
            
            
        }

        
        public static final class Builder {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.294 -0400", hash_original_field = "1C55ADB17279BAC09579C0440A039180", hash_generated_field = "B8B68F2E3B571F250FDA42AEED6F96EC")

            private int mMask = 0;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.294 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "C4A90307B6990541B60C2B86DCD4B526")
            public  Builder() {
                mMask = 0;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.294 -0400", hash_original_method = "2270BC971D9C4F82FBD51366B809A76A", hash_generated_method = "631C274E04C6C0B7E08BF52CFE1C0EDE")
            public  Builder(ThreadPolicy policy) {
                mMask = policy.mask;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.295 -0400", hash_original_method = "399752AE3320783E8BC4077BF2BAABAB", hash_generated_method = "AAE3C0A4E7320575816909F773F95BF0")
            public Builder detectAll() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1394807866 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1394807866 = enable(ALL_THREAD_DETECT_BITS);
                varB4EAC82CA7396A68D541C85D26508E83_1394807866.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1394807866;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.295 -0400", hash_original_method = "3E31B254E1B4E9A5234881E68AADF1C7", hash_generated_method = "883248299D16410ED08AE4EA02BDAFC6")
            public Builder permitAll() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1255884426 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1255884426 = disable(ALL_THREAD_DETECT_BITS);
                varB4EAC82CA7396A68D541C85D26508E83_1255884426.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1255884426;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.296 -0400", hash_original_method = "8F1CC5D4BDA427578EB68B001E341FDD", hash_generated_method = "7A57469646804078DB95A5C2E368F35A")
            public Builder detectNetwork() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_626878221 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_626878221 = enable(DETECT_NETWORK);
                varB4EAC82CA7396A68D541C85D26508E83_626878221.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_626878221;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.296 -0400", hash_original_method = "2A4244001D1666DDAFB3F602ED8EC7EA", hash_generated_method = "F029178FFFD2976EFB29871BA455EFD8")
            public Builder permitNetwork() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1669778155 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1669778155 = disable(DETECT_NETWORK);
                varB4EAC82CA7396A68D541C85D26508E83_1669778155.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1669778155;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.297 -0400", hash_original_method = "75C524432F954C01B0149630CE54DDB4", hash_generated_method = "74E080A802DBC81B26AFE4F4FEFF4A99")
            public Builder detectDiskReads() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1411777556 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1411777556 = enable(DETECT_DISK_READ);
                varB4EAC82CA7396A68D541C85D26508E83_1411777556.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1411777556;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.297 -0400", hash_original_method = "1BD98C02F9A11EE892D0098B20BDD8BD", hash_generated_method = "D746BCC599C560881D32393F8CCAB2C4")
            public Builder permitDiskReads() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_856404212 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_856404212 = disable(DETECT_DISK_READ);
                varB4EAC82CA7396A68D541C85D26508E83_856404212.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_856404212;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.298 -0400", hash_original_method = "0F761933C6E4A91421ABB8964A4D9EB8", hash_generated_method = "679D76E70517E2A3DE3ADA3D9462BCBA")
            public Builder detectCustomSlowCalls() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_968136404 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_968136404 = enable(DETECT_CUSTOM);
                varB4EAC82CA7396A68D541C85D26508E83_968136404.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_968136404;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.298 -0400", hash_original_method = "1F5E52FF134E5A595D9B4F3AD9EF805B", hash_generated_method = "E1ED1DB5F2DEB566590B303FCE220D8F")
            public Builder permitCustomSlowCalls() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_174159567 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_174159567 = enable(DETECT_CUSTOM);
                varB4EAC82CA7396A68D541C85D26508E83_174159567.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_174159567;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.299 -0400", hash_original_method = "583E0D5D228DC11F4F3B1B541EE8393C", hash_generated_method = "A11F4E6E7C4603A5F6CB9109D9072B82")
            public Builder detectDiskWrites() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1276897394 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1276897394 = enable(DETECT_DISK_WRITE);
                varB4EAC82CA7396A68D541C85D26508E83_1276897394.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1276897394;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.299 -0400", hash_original_method = "A37C6D388BF979AC5AEB871BAB2E0B6F", hash_generated_method = "FA090AE4AA0892CAC2F9BA5BA87F3779")
            public Builder permitDiskWrites() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1841281748 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1841281748 = disable(DETECT_DISK_WRITE);
                varB4EAC82CA7396A68D541C85D26508E83_1841281748.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1841281748;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.300 -0400", hash_original_method = "8766DB09D651E2B3541ACB0418FFA365", hash_generated_method = "DB8E489ECD3E14E8B4A76151364DAB3C")
            public Builder penaltyDialog() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1324435368 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1324435368 = enable(PENALTY_DIALOG);
                varB4EAC82CA7396A68D541C85D26508E83_1324435368.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1324435368;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.301 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "63B8D236021E820721A8D8A096452371")
            public Builder penaltyDeath() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1257456701 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1257456701 = enable(PENALTY_DEATH);
                varB4EAC82CA7396A68D541C85D26508E83_1257456701.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1257456701;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.302 -0400", hash_original_method = "3B3840DC05B4A1C1129369D4324CF6E7", hash_generated_method = "222EC29B3F963E429D40F87CD89EBA20")
            public Builder penaltyDeathOnNetwork() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1992870264 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1992870264 = enable(PENALTY_DEATH_ON_NETWORK);
                varB4EAC82CA7396A68D541C85D26508E83_1992870264.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1992870264;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.302 -0400", hash_original_method = "D2175CC28C327D3A1AEA760A679D2369", hash_generated_method = "282D9EC81131C1ADAED8115665714BFD")
            public Builder penaltyFlashScreen() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_34380709 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_34380709 = enable(PENALTY_FLASH);
                varB4EAC82CA7396A68D541C85D26508E83_34380709.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_34380709;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.303 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "10682823486391FE33ED3F92D603BB9F")
            public Builder penaltyLog() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_633734239 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_633734239 = enable(PENALTY_LOG);
                varB4EAC82CA7396A68D541C85D26508E83_633734239.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_633734239;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.303 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "8856D9D2FF273BF60DFE1A3578D801A7")
            public Builder penaltyDropBox() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1120961871 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1120961871 = enable(PENALTY_DROPBOX);
                varB4EAC82CA7396A68D541C85D26508E83_1120961871.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1120961871;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.304 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "2814457D8F49B1D73A4819BA8E547C48")
            private Builder enable(int bit) {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1962805246 = null; 
                mMask |= bit;
                varB4EAC82CA7396A68D541C85D26508E83_1962805246 = this;
                varB4EAC82CA7396A68D541C85D26508E83_1962805246.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1962805246;
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.305 -0400", hash_original_method = "DD377E4C338D3B09C11C3D4D7DFD99D3", hash_generated_method = "DA8E33686D2A625F0C94D0D7C43A8278")
            private Builder disable(int bit) {
                Builder varB4EAC82CA7396A68D541C85D26508E83_54106548 = null; 
                mMask &= ~bit;
                varB4EAC82CA7396A68D541C85D26508E83_54106548 = this;
                varB4EAC82CA7396A68D541C85D26508E83_54106548.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_54106548;
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.305 -0400", hash_original_method = "3E686B94A275CF17A4C5CE0839D3E8D1", hash_generated_method = "BCDEF73F9806D6646A3A4B6881D40E81")
            public ThreadPolicy build() {
                ThreadPolicy varB4EAC82CA7396A68D541C85D26508E83_1364917823 = null; 
                {
                    penaltyLog();
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1364917823 = new ThreadPolicy(mMask);
                varB4EAC82CA7396A68D541C85D26508E83_1364917823.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1364917823;
                
                
                    
                              
                    
                
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.305 -0400", hash_original_field = "E7DFCA04F3BE5F51D0361BA13D9F3EA4", hash_generated_field = "9578A9475850D552D61F6D5FCB916824")

        public static final ThreadPolicy LAX = new ThreadPolicy(0);
    }


    
    public static final class VmPolicy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.305 -0400", hash_original_field = "F2CE11EBF110993621BEDD8E747D7B1B", hash_generated_field = "DB965A11139AB665B00B4D2E2ABFFB32")

        int mask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.305 -0400", hash_original_field = "3FBB4B56631DFF224756AA0554DAE984", hash_generated_field = "C4A68A411991D38DAC450888E1864E75")

        HashMap<Class, Integer> classInstanceLimit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.306 -0400", hash_original_method = "BE6E35A5EA1ACA059EF2A402B69D7023", hash_generated_method = "C40052F13E7704AA82CE57C75F60DC3D")
        private  VmPolicy(int mask, HashMap<Class, Integer> classInstanceLimit) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("classInstanceLimit == null");
            } 
            this.mask = mask;
            this.classInstanceLimit = classInstanceLimit;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.306 -0400", hash_original_method = "338C4A4B8F91E885EB5A5562BE10EA45", hash_generated_method = "6A2296A19189F470DDFBF2596B6EB208")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1102510266 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1102510266 = "[StrictMode.VmPolicy; mask=" + mask + "]";
            varB4EAC82CA7396A68D541C85D26508E83_1102510266.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1102510266;
            
            
        }

        
        public static final class Builder {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.307 -0400", hash_original_field = "E08A8EE01FA9CEC4B820220831BC5DE3", hash_generated_field = "F7C8905D5B34EE793946807F2A7E20A1")

            private int mMask;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.307 -0400", hash_original_field = "9CEE277A3C9F90A2D4A6976F0323CE98", hash_generated_field = "7DA905668F7F3F2312998927AB27A0B2")

            private HashMap<Class, Integer> mClassInstanceLimit;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.307 -0400", hash_original_field = "1E770C9E586080F95CD045212B6277DA", hash_generated_field = "2D6485C7C663B1648AF525BB6C2310A9")

            private boolean mClassInstanceLimitNeedCow = false;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.307 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "C4A90307B6990541B60C2B86DCD4B526")
            public  Builder() {
                mMask = 0;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.307 -0400", hash_original_method = "FBB1CB3954D34CB1AD109CEFAD7B1DDE", hash_generated_method = "5B93757689D973A3868B8E54B0D3C06F")
            public  Builder(VmPolicy base) {
                mMask = base.mask;
                mClassInstanceLimitNeedCow = true;
                mClassInstanceLimit = base.classInstanceLimit;
                
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.308 -0400", hash_original_method = "E6B0AD736B79FE1E50987D22EA6466E3", hash_generated_method = "DDFEA3CFE82D73EE4C472892071C2E89")
            public Builder setClassInstanceLimit(Class klass, int instanceLimit) {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1243153576 = null; 
                Builder varB4EAC82CA7396A68D541C85D26508E83_45141612 = null; 
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("klass == null");
                } 
                {
                    {
                        boolean varF54A66C0EAC712B4862EF63071243FC1_1316416743 = (mClassInstanceLimit.containsKey(klass) &&
                        mClassInstanceLimit.get(klass) == instanceLimit);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1243153576 = this;
                        } 
                    } 
                    mClassInstanceLimitNeedCow = false;
                    mClassInstanceLimit = (HashMap<Class, Integer>) mClassInstanceLimit.clone();
                } 
                {
                    mClassInstanceLimit = new HashMap<Class, Integer>();
                } 
                mMask |= DETECT_VM_INSTANCE_LEAKS;
                mClassInstanceLimit.put(klass, instanceLimit);
                varB4EAC82CA7396A68D541C85D26508E83_45141612 = this;
                addTaint(klass.getTaint());
                addTaint(instanceLimit);
                Builder varA7E53CE21691AB073D9660D615818899_2077997752; 
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: 
                        varA7E53CE21691AB073D9660D615818899_2077997752 = varB4EAC82CA7396A68D541C85D26508E83_1243153576;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_2077997752 = varB4EAC82CA7396A68D541C85D26508E83_45141612;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_2077997752.addTaint(getTaint()); 
                return varA7E53CE21691AB073D9660D615818899_2077997752;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.309 -0400", hash_original_method = "1E52C56D15D33FA545E602A30D1B7293", hash_generated_method = "739CC0EB5249F92291A6423F0E57982B")
            public Builder detectActivityLeaks() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_129590670 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_129590670 = enable(DETECT_VM_ACTIVITY_LEAKS);
                varB4EAC82CA7396A68D541C85D26508E83_129590670.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_129590670;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.310 -0400", hash_original_method = "CEAA7924A62774EE9F1DB0EAFC23F606", hash_generated_method = "7F4A6446835C8FC2729E586B7F1C9EBC")
            public Builder detectAll() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_359034616 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_359034616 = enable(DETECT_VM_ACTIVITY_LEAKS |
                        DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS);
                varB4EAC82CA7396A68D541C85D26508E83_359034616.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_359034616;
                
                
                        
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.311 -0400", hash_original_method = "7CA55A1EF27E65D4088A38B2843E1EE5", hash_generated_method = "A1FCB0DC23D87BC8A43459E2E1D9C9E8")
            public Builder detectLeakedSqlLiteObjects() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_2018280739 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_2018280739 = enable(DETECT_VM_CURSOR_LEAKS);
                varB4EAC82CA7396A68D541C85D26508E83_2018280739.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_2018280739;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.312 -0400", hash_original_method = "76FD4F08E7705E8F66E31708D9A399EA", hash_generated_method = "F58F2A8CF801E514E7AC63CDDF746761")
            public Builder detectLeakedClosableObjects() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_42184099 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_42184099 = enable(DETECT_VM_CLOSABLE_LEAKS);
                varB4EAC82CA7396A68D541C85D26508E83_42184099.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_42184099;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.313 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "AB60567A5FD3D7E137EC5CAA6D00D43D")
            public Builder penaltyDeath() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1020065234 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1020065234 = enable(PENALTY_DEATH);
                varB4EAC82CA7396A68D541C85D26508E83_1020065234.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1020065234;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.313 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "6289A172B617AE08F91054CD8673E9F3")
            public Builder penaltyLog() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1733649929 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1733649929 = enable(PENALTY_LOG);
                varB4EAC82CA7396A68D541C85D26508E83_1733649929.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1733649929;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.314 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "EEAF99A80447B66B96DA1BE40249B5A4")
            public Builder penaltyDropBox() {
                Builder varB4EAC82CA7396A68D541C85D26508E83_1501379436 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1501379436 = enable(PENALTY_DROPBOX);
                varB4EAC82CA7396A68D541C85D26508E83_1501379436.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1501379436;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.314 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "3C1D05F7FD76C9388FC4C4E3402F288C")
            private Builder enable(int bit) {
                Builder varB4EAC82CA7396A68D541C85D26508E83_21991455 = null; 
                mMask |= bit;
                varB4EAC82CA7396A68D541C85D26508E83_21991455 = this;
                varB4EAC82CA7396A68D541C85D26508E83_21991455.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_21991455;
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.315 -0400", hash_original_method = "6432BC9C97797DD02AE9BFA4A7F87D54", hash_generated_method = "BFBF8EB62F2D119EEDAF51C5E7E5BDB8")
            public VmPolicy build() {
                VmPolicy varB4EAC82CA7396A68D541C85D26508E83_1085700883 = null; 
                {
                    penaltyLog();
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1085700883 = new VmPolicy(mMask,
                        mClassInstanceLimit != null ? mClassInstanceLimit : EMPTY_CLASS_LIMIT_MAP);
                varB4EAC82CA7396A68D541C85D26508E83_1085700883.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1085700883;
                
                
                    
                              
                    
                
                
                        
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.315 -0400", hash_original_field = "F1C7D869EBAAFBDF7AEDBE7466A42F96", hash_generated_field = "9254DDC9D251934961027FD07388D251")

        public static final VmPolicy LAX = new VmPolicy(0, EMPTY_CLASS_LIMIT_MAP);
    }


    
    public static class StrictModeViolation extends BlockGuard.BlockGuardPolicyException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.315 -0400", hash_original_method = "E7438DD65D448EA29E2BF1E2E7B9AF17", hash_generated_method = "DB56652DB836ED6DBA72E2DBDA20575A")
        public  StrictModeViolation(int policyState, int policyViolated, String message) {
            super(policyState, policyViolated, message);
            addTaint(policyState);
            addTaint(policyViolated);
            addTaint(message.getTaint());
            
        }

        
    }


    
    public static class StrictModeNetworkViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.316 -0400", hash_original_method = "DBBD717A236AEADDFBDE9EEC846203D0", hash_generated_method = "67817CB14B73DDA8A675A65BE03ACCB8")
        public  StrictModeNetworkViolation(int policyMask) {
            super(policyMask, DETECT_NETWORK, null);
            addTaint(policyMask);
            
        }

        
    }


    
    private static class StrictModeDiskReadViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.316 -0400", hash_original_method = "50FAC78594B32A364EC38A7051A6D828", hash_generated_method = "45037306A9E5DF86F945894246B125E2")
        public  StrictModeDiskReadViolation(int policyMask) {
            super(policyMask, DETECT_DISK_READ, null);
            addTaint(policyMask);
            
        }

        
    }


    
    private static class StrictModeDiskWriteViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.316 -0400", hash_original_method = "3E79DB089B8A8B103215C527DD70DC9D", hash_generated_method = "FC816BAC3953BE8E9F2D0633D3D74C62")
        public  StrictModeDiskWriteViolation(int policyMask) {
            super(policyMask, DETECT_DISK_WRITE, null);
            addTaint(policyMask);
            
        }

        
    }


    
    private static class StrictModeCustomViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.317 -0400", hash_original_method = "D9775B5587EA33BC7CC7CE8D67F82D3A", hash_generated_method = "8A8AC09FC57A59E62A87D83A3B4D04E3")
        public  StrictModeCustomViolation(int policyMask, String name) {
            super(policyMask, DETECT_CUSTOM, name);
            addTaint(policyMask);
            addTaint(name.getTaint());
            
        }

        
    }


    
    private static class AndroidBlockGuardPolicy implements BlockGuard.Policy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.317 -0400", hash_original_field = "762A5B3087E77BD4ABEEF3C3AF201E66", hash_generated_field = "A3F55928E2CD42B0872F6832B90FE4B8")

        private int mPolicyMask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.317 -0400", hash_original_field = "5836A78E9559B1DE0C28FCB615157AD2", hash_generated_field = "6460400958C25B64276F7B45AA1AE3E6")

        private final HashMap<Integer, Long> mLastViolationTime = new HashMap<Integer, Long>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.317 -0400", hash_original_method = "56B73F441F57B7F1580692BF8D8E5ECB", hash_generated_method = "D44A205806718F04E37473DFF9A09152")
        public  AndroidBlockGuardPolicy(final int policyMask) {
            mPolicyMask = policyMask;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.318 -0400", hash_original_method = "EC02A08C2D3910C2DE1DA94FE738CE60", hash_generated_method = "5DF65FC2C387F0B0442E1BB061139B12")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2117510671 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2117510671 = "AndroidBlockGuardPolicy; mPolicyMask=" + mPolicyMask;
            varB4EAC82CA7396A68D541C85D26508E83_2117510671.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2117510671;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.318 -0400", hash_original_method = "BDAE35F9BC36FEF12DCB9013D520032B", hash_generated_method = "82DC5767A4589C8BB0D2A68F045DB249")
        public int getPolicyMask() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604120362 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604120362;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.318 -0400", hash_original_method = "0D85458AC3FF96FC22E8C3819C12EFAB", hash_generated_method = "2B4E673F10606E0E78434C7D2D2E1CAD")
        public void onWriteToDisk() {
            
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_1622368369 = (tooManyViolationsThisLoop());
            } 
            BlockGuard.BlockGuardPolicyException e = new StrictModeDiskWriteViolation(mPolicyMask);
            e.fillInStackTrace();
            startHandlingViolationException(e);
            
            
                
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.319 -0400", hash_original_method = "B44201BA71724735A91DD4F1FF43D337", hash_generated_method = "A39CD6B0ABDBC4AADCEC4C6054737C7C")
         void onCustomSlowCall(String name) {
            
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_1980755863 = (tooManyViolationsThisLoop());
            } 
            BlockGuard.BlockGuardPolicyException e = new StrictModeCustomViolation(mPolicyMask, name);
            e.fillInStackTrace();
            startHandlingViolationException(e);
            addTaint(name.getTaint());
            
            
                
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.319 -0400", hash_original_method = "DC9910586B30548E82E107CFA3542EA2", hash_generated_method = "C97AB9C82F44B9ED346E0B9FB6181066")
        public void onReadFromDisk() {
            
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_1360512113 = (tooManyViolationsThisLoop());
            } 
            BlockGuard.BlockGuardPolicyException e = new StrictModeDiskReadViolation(mPolicyMask);
            e.fillInStackTrace();
            startHandlingViolationException(e);
            
            
                
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.320 -0400", hash_original_method = "D41EA35CCA984A26E96A9AAEEE4BCF1E", hash_generated_method = "1ACE4C9247FC5E80825C8E2F588B8DBF")
        public void onNetwork() {
            
            {
                if (DroidSafeAndroidRuntime.control) throw new NetworkOnMainThreadException();
            } 
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_1203003603 = (tooManyViolationsThisLoop());
            } 
            BlockGuard.BlockGuardPolicyException e = new StrictModeNetworkViolation(mPolicyMask);
            e.fillInStackTrace();
            startHandlingViolationException(e);
            
            
                
            
            
                
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.321 -0400", hash_original_method = "A35D2E9A8AD0B9C28C9280D1C3956061", hash_generated_method = "6D9513DC2646B63D96CE73E109E46A70")
        public void setPolicyMask(int policyMask) {
            mPolicyMask = policyMask;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.321 -0400", hash_original_method = "5E39E8C314EEA382AFAE0CC045B36998", hash_generated_method = "8B964EDCDD979DA19419FC921C74260D")
         void startHandlingViolationException(BlockGuard.BlockGuardPolicyException e) {
            final ViolationInfo info = new ViolationInfo(e, e.getPolicy());
            info.violationUptimeMillis = SystemClock.uptimeMillis();
            handleViolationWithTimingAttempt(info);
            addTaint(e.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.467 -0400", hash_original_method = "E564B46DD31AF359B07F190378DAA828", hash_generated_method = "D23E16BEBB082B9C930C26AFA8ECABC5")
         void handleViolationWithTimingAttempt(final ViolationInfo info) {
            Looper looper;
            looper = Looper.myLooper();
            {
                info.durationMillis = -1;
                handleViolation(info);
            } 
            final ArrayList<ViolationInfo> records;
            records = violationsBeingTimed.get();
            {
                boolean var93D414F0DAF507CC4844CFB90F056FDD_1780710101 = (records.size() >= MAX_OFFENSES_PER_LOOP);
            } 
            records.add(info);
            {
                boolean varD777943406E4C57D521B6D48914E48C5_769782712 = (records.size() > 1);
            } 
            final IWindowManager windowManager = DroidSafeAndroidRuntime.control ? sWindowManager.get() : null;
            {
                try 
                {
                    windowManager.showStrictModeViolation(true);
                } 
                catch (RemoteException unused)
                { }
            } 
            threadHandler.get().post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.455 -0400", hash_original_method = "13A73E46BCAE9FB3F25E0C7CB59DBB78", hash_generated_method = "2F1913436814823B79CFA298604766BB")
                public void run() {
                    long loopFinishTime;
                    loopFinishTime = SystemClock.uptimeMillis();
                    {
                        try 
                        {
                            windowManager.showStrictModeViolation(false);
                        } 
                        catch (RemoteException unused)
                        { }
                    } 
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
                        } 
                    } 
                    records.clear();
                    
                    
                    
                            
                                
                            
                            
                        
                    
                            
                            
                            
                                    
                            
                        
                    
                }
});
            addTaint(info.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.340 -0400", hash_original_method = "41F5C3E6841DC86E9C64A72E84C0FF7E", hash_generated_method = "036D3F336509B78DC893CC88E2E70F8C")
         void handleViolation(final ViolationInfo info) {
            {
                Log.wtf(TAG, "unexpected null stacktrace");
            } 
            Log.d(TAG, "handleViolation; policy=" + info.policy);
            {
                ArrayList<ViolationInfo> violations = gatheredViolations.get();
                {
                    violations = new ArrayList<ViolationInfo>(1);
                    gatheredViolations.set(violations);
                } 
                {
                    boolean var67E0B061679ECE750C918CCF810C909E_613431245 = (violations.size() >= 5);
                } 
                {
                    Iterator<ViolationInfo> varD4E3ABC4825F26B3B2AA235E5643CBC8_104528368 = (violations).iterator();
                    varD4E3ABC4825F26B3B2AA235E5643CBC8_104528368.hasNext();
                    ViolationInfo previous = varD4E3ABC4825F26B3B2AA235E5643CBC8_104528368.next();
                    {
                        {
                            boolean varC9FD4943D1AECC98A74F6D3A1A981392_1107843556 = (info.crashInfo.stackTrace.equals(previous.crashInfo.stackTrace));
                        } 
                    } 
                } 
                violations.add(info);
            } 
            Integer crashFingerprint = info.hashCode();
            long lastViolationTime = 0;
            {
                boolean var19200966257A15248BB4C14BB760875F_265720619 = (mLastViolationTime.containsKey(crashFingerprint));
                {
                    lastViolationTime = mLastViolationTime.get(crashFingerprint);
                } 
            } 
            long now = SystemClock.uptimeMillis();
            mLastViolationTime.put(crashFingerprint, now);
            long timeSinceLastViolationMillis;
            timeSinceLastViolationMillis = Long.MAX_VALUE;
            timeSinceLastViolationMillis = (now - lastViolationTime);
            {
                {
                    Log.d(TAG, "StrictMode policy violation; ~duration=" +
                          info.durationMillis + " ms: " + info.crashInfo.stackTrace);
                } 
                {
                    Log.d(TAG, "StrictMode policy violation: " + info.crashInfo.stackTrace);
                } 
            } 
            int violationMaskSubset = 0;
            {
                violationMaskSubset |= PENALTY_DIALOG;
            } 
            {
                violationMaskSubset |= PENALTY_DROPBOX;
            } 
            {
                int violationBit = parseViolationFromMessage(info.crashInfo.exceptionMessage);
                violationMaskSubset |= violationBit;
                final int savedPolicyMask = getThreadPolicyMask();
                final boolean justDropBox = (info.policy & THREAD_PENALTY_MASK) == PENALTY_DROPBOX;
                {
                    dropboxViolationAsync(violationMaskSubset, info);
                } 
                try 
                {
                    setThreadPolicyMask(0);
                    ActivityManagerNative.getDefault().handleApplicationStrictModeViolation(
                        RuntimeInit.getApplicationObject(),
                        violationMaskSubset,
                        info);
                } 
                catch (RemoteException e)
                { }
                finally 
                {
                    setThreadPolicyMask(savedPolicyMask);
                } 
            } 
            {
                executeDeathPenalty(info);
            } 
            addTaint(info.getTaint());
            
            
        }

        
    }


    
    private static class AndroidCloseGuardReporter implements CloseGuard.Reporter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.340 -0400", hash_original_method = "E7772DF8591E8A95C00A24C3A7BC9385", hash_generated_method = "E7772DF8591E8A95C00A24C3A7BC9385")
        public AndroidCloseGuardReporter ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.341 -0400", hash_original_method = "1648939B3F4BE7F697201ED2CA10799D", hash_generated_method = "16E582CA6C32D14F89CD98E1A8A95066")
        public void report(String message, Throwable allocationSite) {
            onVmPolicyViolation(message, allocationSite);
            addTaint(message.getTaint());
            addTaint(allocationSite.getTaint());
            
            
        }

        
    }


    
    private static class LogStackTrace extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.341 -0400", hash_original_method = "9318B319D2DE8ECE742465D2C7D8840B", hash_generated_method = "9318B319D2DE8ECE742465D2C7D8840B")
        public LogStackTrace ()
        {
            
        }


    }


    
    public static class Span {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.341 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

        private String mName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.341 -0400", hash_original_field = "71A6739ACA1D6EFC8CA8BC59BC80FD37", hash_generated_field = "D9168B950155534AAD832724FE52C500")

        private long mCreateMillis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.341 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "E39EFCE10572D87C6F95E3A2B2BDFCB1")

        private Span mNext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.341 -0400", hash_original_field = "FBB5FC609118D0EDF116DBF7ED6BF692", hash_generated_field = "ABC77622AA8E19FF30E79A0A19830013")

        private Span mPrev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.341 -0400", hash_original_field = "ABDCF3E72E2FC93754EA083FEF8563EA", hash_generated_field = "71A5A2213C60169AAE2591AE6952C837")

        private ThreadSpanState mContainerState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.342 -0400", hash_original_method = "858C7F08B86E9ABCC5108174CEDFA974", hash_generated_method = "46A08256E701EE28F27EFDCC6EA7A311")
          Span(ThreadSpanState threadState) {
            mContainerState = threadState;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.342 -0400", hash_original_method = "35ECB8DB5D2E2401D23EA00A0B49C3B0", hash_generated_method = "9BA85CCA4EAE21C800E5947B396A9A75")
        protected  Span() {
            mContainerState = null;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.343 -0400", hash_original_method = "BAA90C1A527ED6ADE64DE9CF5831D500", hash_generated_method = "22433A3A81F337DAE73D7CCA3ED2C59E")
        public void finish() {
            ThreadSpanState state = mContainerState;
            {
                {
                    mPrev.mNext = mNext;
                } 
                {
                    mNext.mPrev = mPrev;
                } 
                {
                    boolean var15C0794A52BA15EDCCCE733A675E1A05_2025278358 = (state.mActiveHead == this);
                    {
                        state.mActiveHead = mNext;
                    } 
                } 
                Log.d(TAG, "Span finished=" + mName + "; size=" + state.mActiveSize);
                this.mCreateMillis = -1;
                this.mName = null;
                this.mPrev = null;
                this.mNext = null;
                {
                    this.mNext = state.mFreeListHead;
                    state.mFreeListHead = this;
                } 
            } 
            
            
        }

        
    }


    
    private static class ThreadSpanState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "220FBF2583583706382506D68268B363", hash_generated_field = "518A04ADDEBFAA97A1EA0148B6F5FA97")

        public Span mActiveHead;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "E500488743B25A4A8E8980B2D8DD40C7", hash_generated_field = "B6D1D7D2D17432EE321593A3AEA5D914")

        public int mActiveSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "00C965908374A4B07EA5F85866B67C2E", hash_generated_field = "DA0030F95E05B17A8A5730A244932CA8")

        public Span mFreeListHead;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "E6AAF02BCBC197E806D06FB5EC18625D", hash_generated_field = "C3221ED1F561EAEA75567095BA88D9C9")

        public int mFreeListSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_method = "897FCF469D672A73C45810344D5B48A8", hash_generated_method = "897FCF469D672A73C45810344D5B48A8")
        public ThreadSpanState ()
        {
            
        }


    }


    
    public static class ViolationInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "E2830D8E0018BB9D7C72E36DDDB650B2", hash_generated_field = "CD846E661E8E518C4347C2ACA6146A7E")

        public ApplicationErrorReport.CrashInfo crashInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "F4AF8B5789576C000CE9105B25609BD6", hash_generated_field = "930B7D58F3DA097BBD08C13024DA937C")

        public int policy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "A8D317E1C938926947C4B210EBCECC1E", hash_generated_field = "F1C866B29B39A143C5FBB9A0CA778367")

        public int durationMillis = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "EEC8A1FCD4B77BB69BB144F25454CF22", hash_generated_field = "678196736B2E56BCECB08188576F10CE")

        public int numAnimationsRunning = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "D57AC45256849D9B13E2422D91580FB9", hash_generated_field = "F792D5F97BD30C470267CF28260B7EA9")

        public String[] tags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "8B568DABCCACE2EF4A593CDD6BCF2581", hash_generated_field = "AF05918DADCF889F179D3E20609A32AE")

        public int violationNumThisLoop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "DB2C6E10DE0472A82B45FDB1B9070EA2", hash_generated_field = "0AAC6D73647F1D34E070F27F164676C0")

        public long violationUptimeMillis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "A7BB6B742243FDA7D77036B57CD43DFF", hash_generated_field = "4B3B10B2069653BB6ABA4070A65734B4")

        public String broadcastIntentAction;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.344 -0400", hash_original_field = "CAB9C7B63599DF30611D8941676ECA28", hash_generated_field = "FCE79C922D923B8021DEFCC4604B4FB6")

        public long numInstances = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.345 -0400", hash_original_method = "D15EADA574CC6688E3A5C168E5A51EC1", hash_generated_method = "A280C1FD969189315D7D94DDC8202B0C")
        public  ViolationInfo() {
            crashInfo = null;
            policy = 0;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.346 -0400", hash_original_method = "B97F48EA0F14252413142D91DE4A3BFA", hash_generated_method = "A8F21DF5115E9DA8D25C54A57E06AA39")
        public  ViolationInfo(Throwable tr, int policy) {
            crashInfo = new ApplicationErrorReport.CrashInfo(tr);
            violationUptimeMillis = SystemClock.uptimeMillis();
            this.policy = policy;
            this.numAnimationsRunning = ValueAnimator.getCurrentAnimationsCount();
            Intent broadcastIntent = ActivityThread.getIntentBeingBroadcast();
            {
                broadcastIntentAction = broadcastIntent.getAction();
            } 
            ThreadSpanState state = sThisThreadSpanState.get();
            {
                this.numInstances = ((InstanceCountViolation) tr).mInstances;
            } 
            {
                int spanActiveCount = state.mActiveSize;
                {
                    spanActiveCount = MAX_SPAN_TAGS;
                } 
                {
                    this.tags = new String[spanActiveCount];
                    Span iter = state.mActiveHead;
                    int index = 0;
                    {
                        this.tags[index] = iter.mName;
                        iter = iter.mNext;
                    } 
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.347 -0400", hash_original_method = "2281C8F6C464FE0E4D053A790D9731B4", hash_generated_method = "1DBE6343F31808980E62E49AD84C659D")
        public  ViolationInfo(Parcel in) {
            this(in, false);
            addTaint(in.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.348 -0400", hash_original_method = "276C18C659FAD0D183192D3E613DC123", hash_generated_method = "D87E07D25D572C3332797D5B4F13FB7A")
        public  ViolationInfo(Parcel in, boolean unsetGatheringBit) {
            crashInfo = new ApplicationErrorReport.CrashInfo(in);
            int rawPolicy = in.readInt();
            {
                policy = rawPolicy & ~PENALTY_GATHER;
            } 
            {
                policy = rawPolicy;
            } 
            durationMillis = in.readInt();
            violationNumThisLoop = in.readInt();
            numAnimationsRunning = in.readInt();
            violationUptimeMillis = in.readLong();
            numInstances = in.readLong();
            broadcastIntentAction = in.readString();
            tags = in.readStringArray();
            addTaint(unsetGatheringBit);
            
            
            
            
                
            
                
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.353 -0400", hash_original_method = "C167EFD1AA966CEFAC170AF811F6D4AF", hash_generated_method = "6D808D799586E4886241F73FDC7C600B")
        @Override
        public int hashCode() {
            int result = 17;
            result = 37 * result + crashInfo.stackTrace.hashCode();
            {
                result *= 37;
            } 
            {
                result = 37 * result + broadcastIntentAction.hashCode();
            } 
            {
                {
                    String tag = tags[0];
                    {
                        result = 37 * result + tag.hashCode();
                    } 
                } 
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426304727 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426304727;
            
            
            
            
                
            
            
                
            
            
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.354 -0400", hash_original_method = "4C68F89668EEC8ACA3036C864AE1DCBA", hash_generated_method = "6E5657C7F8C25ACC14EB25627C3319D3")
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
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.368 -0400", hash_original_method = "FB1CB9CE36DAC72C8A293B50C548452A", hash_generated_method = "E30E26D9E45B21B84B3881F0CCA2963E")
        public void dump(Printer pw, String prefix) {
            crashInfo.dump(pw, prefix);
            pw.println(prefix + "policy: " + policy);
            {
                pw.println(prefix + "durationMillis: " + durationMillis);
            } 
            {
                pw.println(prefix + "numInstances: " + numInstances);
            } 
            {
                pw.println(prefix + "violationNumThisLoop: " + violationNumThisLoop);
            } 
            {
                pw.println(prefix + "numAnimationsRunning: " + numAnimationsRunning);
            } 
            pw.println(prefix + "violationUptimeMillis: " + violationUptimeMillis);
            {
                pw.println(prefix + "broadcastIntentAction: " + broadcastIntentAction);
            } 
            {
                int index = 0;
                {
                    String tag = tags[0];
                    {
                        pw.println(prefix + "tag[" + (index++) + "]: " + tag);
                    } 
                } 
            } 
            addTaint(pw.getTaint());
            addTaint(prefix.getTaint());
            
            
        }

        
    }


    
    private static class InstanceCountViolation extends Throwable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.368 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "CE233813880487C713DB65203E06BCD9")

        Class mClass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.369 -0400", hash_original_field = "0D41B5AD1A7DB10272E2084BC9A3392B", hash_generated_field = "74080197B20CB35716F08D82964BE351")

        long mInstances;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.369 -0400", hash_original_field = "5B168C2292FF8EC273A67B1639E35C5D", hash_generated_field = "EAF07362CB0DE5A45A6B09193DE62144")

        int mLimit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.369 -0400", hash_original_method = "E80F10435372AA752F8DBC4C44A2404B", hash_generated_method = "019519EF16106C35D92003DDACCE9C26")
        public  InstanceCountViolation(Class klass, long instances, int limit) {
            super(klass.toString() + "; instances=" + instances + "; limit=" + limit);
            setStackTrace(FAKE_STACK);
            mClass = klass;
            mInstances = instances;
            mLimit = limit;
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.369 -0400", hash_original_field = "23D915E793BC37F0BB86A95A59152961", hash_generated_field = "5B6CE22DDD6F454B97A831C7050366DC")

        private static final StackTraceElement[] FAKE_STACK = {
            new StackTraceElement("android.os.StrictMode", "setClassInstanceLimit",
                                  "StrictMode.java", 1)
        };
    }


    
    private static final class InstanceTracker {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.369 -0400", hash_original_field = "644134EA3E6C2A378776F1961BA35811", hash_generated_field = "C91F484EFB2D5A548FE76D861FC04B66")

        private Class<?> mKlass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.370 -0400", hash_original_method = "D1695326538E61C61B9A9871778AEDEF", hash_generated_method = "DBE013819D08608937550D7B68BE052F")
        public  InstanceTracker(Object instance) {
            mKlass = instance.getClass();
            {
                final Integer value = sInstanceCounts.get(mKlass);
                int newValue;
                newValue = value + 1;
                newValue = 1;
                sInstanceCounts.put(mKlass, newValue);
            } 
            
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.370 -0400", hash_original_method = "3D9E07641D189E499B7BA8CA77DD9FB9", hash_generated_method = "EC8B4AAC4CA4A3FA4A32059654120F96")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                {
                    final Integer value = sInstanceCounts.get(mKlass);
                    {
                        final int newValue = value - 1;
                        {
                            sInstanceCounts.put(mKlass, newValue);
                        } 
                        {
                            sInstanceCounts.remove(mKlass);
                        } 
                    } 
                } 
            } 
            finally 
            {
                super.finalize();
            } 
            
            
                
                    
                    
                        
                        
                            
                        
                            
                        
                    
                
            
                
            
        }

        
        public static int getInstanceCount(Class<?> klass) {
            synchronized (sInstanceCounts) {
                final Integer value = sInstanceCounts.get(klass);
                return value != null ? value : 0;
            }
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "DD4CBD89079F688DE59AFC08B54388CB", hash_generated_field = "116A2F2FC172FA2FA149155E4F1D5CD5")

        private static final HashMap<Class<?>, Integer> sInstanceCounts = new HashMap<Class<?>, Integer>();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "D3088EBAFFC0370793C876A1F529BEBF", hash_generated_field = "EFD495BFFD08DBECC91B6FEE7B253D98")

    private static final String TAG = "StrictMode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "10012F752FC38C6B0CFDEC1B2E5B89AC", hash_generated_field = "B71C40E2BD4A348A86F6A8DA6EFF35D9")

    private static final boolean LOG_V = Log.isLoggable(TAG, Log.VERBOSE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "A3F06E2DBC0DA963DFE1E41E297E849D", hash_generated_field = "23F752FC1CDA7050B5F1CC7BA955413B")

    private static final boolean IS_USER_BUILD = "user".equals(Build.TYPE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "9D23AE2E1DF0783311B7EE88635EC302", hash_generated_field = "5633022DA578E314CF52EE3A9C0CF47D")

    private static final boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "F9788FE80D74F8AAF2B2257306FDF4F9", hash_generated_field = "3E92FD7ABB6619B38D620EDF029A22D9")

    public static final String DISABLE_PROPERTY = "persist.sys.strictmode.disable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "3475CE826B41B81BE9A2D348A9BB7CC8", hash_generated_field = "E70A21C58D25E28726CC89D8D9240ACA")

    public static final String VISUAL_PROPERTY = "persist.sys.strictmode.visual";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "405B98439BDD5E31488F7FE63DB2894F", hash_generated_field = "FD19D25D87C076998E76A2F89CE1905E")

    private static final long MIN_LOG_INTERVAL_MS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "8D3BFCEBD0B88320011AA9B14A23B692", hash_generated_field = "DA3F5640282C927DA73236D0BA3ECD57")

    private static final long MIN_DIALOG_INTERVAL_MS = 30000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "99EEFDD9B0F488ABE9D28409ED32E932", hash_generated_field = "B19F03F9C3626AC77DC6B5D1D1998E3B")

    private static final int MAX_SPAN_TAGS = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "7A0A915FE061437DB98B2890AB7CF2CE", hash_generated_field = "E5654288F47CC7A3A6E622B174B34056")

    private static final int MAX_OFFENSES_PER_LOOP = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "D0F089381407693056149FE7CAA95BCE", hash_generated_field = "D504D2B86CFCD35894735D0BCD3EEA33")

    public static final int DETECT_DISK_WRITE = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "02C6FDF2CB0A3F274F5C7987262E09FC", hash_generated_field = "7C0AAD2513E22025E4555E4D43F8297C")

    public static final int DETECT_DISK_READ = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "74E04715DA6896901F74DA436A9AA197", hash_generated_field = "A0953BEBDA93B5AC1BDC661CE1AF0C64")

    public static final int DETECT_NETWORK = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "D5619D251598C75279F91C1DCF262984", hash_generated_field = "EDC2D333C7911473B0EA87279BE3E8A6")

    public static final int DETECT_CUSTOM = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.371 -0400", hash_original_field = "3B9D21470B9E6740B57563462D0BA29C", hash_generated_field = "DEF661BA57DCADA99F22533CDFDF239C")

    private static final int ALL_THREAD_DETECT_BITS = DETECT_DISK_WRITE | DETECT_DISK_READ | DETECT_NETWORK | DETECT_CUSTOM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "6AF2813DB695929029F4BA10476B0CC0", hash_generated_field = "C8547878D8DA9B32C40632615B8C73D7")

    public static final int DETECT_VM_CURSOR_LEAKS = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "36E68A513DD293E166FB4F54BE29725C", hash_generated_field = "C9E5621265A28DF38A8FC7DA71DC98E1")

    public static final int DETECT_VM_CLOSABLE_LEAKS = 0x400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "A2310CDBCDD4C509EFF401292464CFD9", hash_generated_field = "FF0F20EB6EA7B6EFA0B50FB48E32AE8B")

    public static final int DETECT_VM_ACTIVITY_LEAKS = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "E52124B43913136C666B021988F5DEA8", hash_generated_field = "83019C646CB0B9C05D60FAAB9A05A37D")

    private static final int DETECT_VM_INSTANCE_LEAKS = 0x1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "AD30D8213DA72B532896F5533DB7DEE7", hash_generated_field = "792A04564079CCBA55772389E5556C8F")

    private static final int ALL_VM_DETECT_BITS = DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS |
            DETECT_VM_ACTIVITY_LEAKS | DETECT_VM_INSTANCE_LEAKS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "8FC0A17F12BDF8741B92E5F01FD7DCB6", hash_generated_field = "AD440199AC90AA853DAE6E553309E61E")

    public static final int PENALTY_LOG = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "5237B015D0FD40554D978C3F16F56117", hash_generated_field = "1B09956BCE6604535346C86F86199656")

    public static final int PENALTY_DIALOG = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "F3FAE1CCEDA4AC19AA37F2365135E9ED", hash_generated_field = "36B2F4DE7C0AEF684C2D4A0EA98A5FF6")

    public static final int PENALTY_DEATH = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "6F33760461E8219F9AA6406FE6162556", hash_generated_field = "43A59BD7C5C50C06D41CB3576F113D90")

    public static final int PENALTY_DEATH_ON_NETWORK = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "F6A171ECCB6555D6BF6665A4505B4B88", hash_generated_field = "D95570E99357CC6CAAFB830E0B8059B4")

    public static final int PENALTY_FLASH = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "56D01B1E4CE134211CEAD29A319DCB2D", hash_generated_field = "97FF6CEFBEACB56FCE27CC1D38BF5293")

    public static final int PENALTY_DROPBOX = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "275C15273FF88D606EF53A171326A356", hash_generated_field = "4A0AEEF9679F704885B2B478E1F03646")

    public static final int PENALTY_GATHER = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "5FE094B1555185981A4C03805EB67AC8", hash_generated_field = "FCF43DBDCE0FE2111C7D3D0DB93F021C")

    private static final int THREAD_PENALTY_MASK = PENALTY_LOG | PENALTY_DIALOG | PENALTY_DEATH | PENALTY_DROPBOX | PENALTY_GATHER |
            PENALTY_DEATH_ON_NETWORK | PENALTY_FLASH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "12DCAF055C72980A2456D711E10064E9", hash_generated_field = "1570D6E62C2261DE7B2E5A5A8633B0EF")

    private static final int VM_PENALTY_MASK = PENALTY_LOG | PENALTY_DEATH | PENALTY_DROPBOX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "80C5BEAC52B0A4A37042B6AB8F02D3DA", hash_generated_field = "AD504B2F674416E05F7D8BB4F079CAD6")

    private static final HashMap<Class, Integer> EMPTY_CLASS_LIMIT_MAP = new HashMap<Class, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "73935208411D2C33F2F434E725AFAB4F", hash_generated_field = "A2DC93C9353C0CDFE42E43F2EDB31797")

    private static volatile int sVmPolicyMask = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "0EFDB39AB4151B8C9E69E1E46920E6DD", hash_generated_field = "6C6283435840FF828818AEADC035BB2B")

    private static volatile VmPolicy sVmPolicy = VmPolicy.LAX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.372 -0400", hash_original_field = "A6C62B4D7E99D84A85CA2ACFE986625B", hash_generated_field = "2C9F276C45FCDF0FDB0E9335F3464F44")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.376 -0400", hash_original_field = "50788C7D307BD300374B864F668BDEBC", hash_generated_field = "9856A17E5723F71B95FE2020E6AD7FC5")

    private static long sLastInstanceCountCheckMillis = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.376 -0400", hash_original_field = "DCEA3F8C01AD46840FAE99198C9AAA60", hash_generated_field = "620CC23E40F92E04CF705F8C05DDBFB2")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.377 -0400", hash_original_field = "1D538736D2B5D329201BCBD8472DDCFE", hash_generated_field = "EC2C449B6782F01CD0895152402E7785")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.379 -0400", hash_original_field = "085DE61E4920EC06EF3FB909B8607AB0", hash_generated_field = "35AF5773760644A2175E84471F6DD6ED")

    private static final HashMap<Class, Integer> sExpectedActivityInstanceCount = new HashMap<Class, Integer>();
}

