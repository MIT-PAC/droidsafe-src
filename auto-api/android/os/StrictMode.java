package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.009 -0400", hash_original_method = "3F7643CB826EF0CE042B1409C79A26FA", hash_generated_method = "64DD3D0C55BC7D0122119CD45855DDDF")
        @DSModeled(DSC.SAFE)
        @Override
        protected ArrayList<ViolationInfo> initialValue() {
            return (ArrayList<ViolationInfo>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ArrayList<ViolationInfo>> violationsBeingTimed = new ThreadLocal<ArrayList<ViolationInfo>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.010 -0400", hash_original_method = "CB5695702D478EAB2FBBE8373134ED39", hash_generated_method = "C51AFAE9714653681C694217AC042BE4")
        @DSModeled(DSC.SAFE)
        @Override
        protected ArrayList<ViolationInfo> initialValue() {
            return (ArrayList<ViolationInfo>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ArrayList<ViolationInfo>();
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<Handler> threadHandler = new ThreadLocal<Handler>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.010 -0400", hash_original_method = "AFD0CE5945D0E9D14EE2FF5512B9324A", hash_generated_method = "0FC20EA5C61B43DCE5A1A0BE0399135F")
        @DSModeled(DSC.SAFE)
        @Override
        protected Handler initialValue() {
            return (Handler)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Handler();
        }

        
}; //Transformed anonymous class
    private static long sLastInstanceCountCheckMillis = 0;
    private static boolean sIsIdlerRegistered = false;
    private static final MessageQueue.IdleHandler sProcessIdleHandler = new MessageQueue.IdleHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.010 -0400", hash_original_method = "6956F5FF31712AF268FC89A0909C9E82", hash_generated_method = "447D7955FB8A5EE961B3B49C1971D63B")
        @DSModeled(DSC.SAFE)
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.010 -0400", hash_original_method = "D6FF905BC764A22CD5AFFCB47539B778", hash_generated_method = "2B69EF892B4FE48983108D5991303AF4")
        @DSModeled(DSC.SAFE)
        public void finish() {
            // ---------- Original Method ----------
        }

        
}; //Transformed anonymous class
    private static final ThreadLocal<ThreadSpanState> sThisThreadSpanState = new ThreadLocal<ThreadSpanState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.010 -0400", hash_original_method = "3F056F46AA4E010EAE891B386F384542", hash_generated_method = "7F8300E48FE602420DB7C7D5F504E959")
        @DSModeled(DSC.SAFE)
        @Override
        protected ThreadSpanState initialValue() {
            return (ThreadSpanState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ThreadSpanState();
        }

        
}; //Transformed anonymous class
    private static Singleton<IWindowManager> sWindowManager = new Singleton<IWindowManager>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.010 -0400", hash_original_method = "5B1F4967C7C17AD573D088D6B70DB243", hash_generated_method = "F1928D7E589F6D232FFE7909CA1D702E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected IWindowManager create() {
            IWindowManager varC157AE586095B148703594F04CAE95C0_1191635840 = (IWindowManager.Stub.asInterface(ServiceManager.getService("window")));
            return (IWindowManager)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        }

        
}; //Transformed anonymous class
    private static final HashMap<Class, Integer> sExpectedActivityInstanceCount =
            new HashMap<Class, Integer>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.010 -0400", hash_original_method = "E3867A4A77A9B912C067B4B7EB14B6CB", hash_generated_method = "588A689D3D763CE0628FAFE357D4E4BF")
    @DSModeled(DSC.SAFE)
    private StrictMode() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.010 -0400", hash_original_method = "EAF2550D78E81A3AE328ECCA2D8E112F", hash_generated_method = "5A09CA60BA8E320D1EB7DAC5A9D7D786")
    public static void setThreadPolicy(final ThreadPolicy policy) {
        setThreadPolicyMask(policy.mask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.011 -0400", hash_original_method = "E103159859299A70CFA6BDDF6D97BFB9", hash_generated_method = "D75821983262CCA2A189B2993C495F26")
    private static void setThreadPolicyMask(final int policyMask) {
        setBlockGuardPolicy(policyMask);
        Binder.setThreadStrictModePolicy(policyMask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.011 -0400", hash_original_method = "621EB7D543F59B08E720C397686C01C7", hash_generated_method = "0C67E320A9DC44A23CD56A5FF63141B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.011 -0400", hash_original_method = "A91AC5C680257C159878619FE045BB6E", hash_generated_method = "69E0B6702899716DD5BEDDAA8C84C9A9")
    private static void setCloseGuardEnabled(boolean enabled) {
        if (!(CloseGuard.getReporter() instanceof AndroidCloseGuardReporter)) {
            CloseGuard.setReporter(new AndroidCloseGuardReporter());
        }
        CloseGuard.setEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.011 -0400", hash_original_method = "846C0C89D35574B87DE239A886F76A3A", hash_generated_method = "DC71E2C046BD1C5E6C2EF35BD28B7815")
    public static int getThreadPolicyMask() {
        return BlockGuard.getThreadPolicy().getPolicyMask();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.011 -0400", hash_original_method = "B16B97050DB3110BD56237B889C54726", hash_generated_method = "776153C8E29B95C779FEB6B1071A901C")
    public static ThreadPolicy getThreadPolicy() {
        return new ThreadPolicy(getThreadPolicyMask());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.011 -0400", hash_original_method = "F942EE5DD2312CA96489AB4B4ACB1570", hash_generated_method = "ED8585635C06544393EACEC3BE69878D")
    public static ThreadPolicy allowThreadDiskWrites() {
        int oldPolicyMask = getThreadPolicyMask();
        int newPolicyMask = oldPolicyMask & ~(DETECT_DISK_WRITE | DETECT_DISK_READ);
        if (newPolicyMask != oldPolicyMask) {
            setThreadPolicyMask(newPolicyMask);
        }
        return new ThreadPolicy(oldPolicyMask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.011 -0400", hash_original_method = "22603A4E5136644C5946CA9D6D1AB7B2", hash_generated_method = "8F75F72036EB9B28A87868A9139A6199")
    public static ThreadPolicy allowThreadDiskReads() {
        int oldPolicyMask = getThreadPolicyMask();
        int newPolicyMask = oldPolicyMask & ~(DETECT_DISK_READ);
        if (newPolicyMask != oldPolicyMask) {
            setThreadPolicyMask(newPolicyMask);
        }
        return new ThreadPolicy(oldPolicyMask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.011 -0400", hash_original_method = "13EE91C23AA3A16D1C05B9C12BE22DBD", hash_generated_method = "F1721DE5BE015504A94FCE2418B8171B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.011 -0400", hash_original_method = "052278CA509C38C507499B2FA93CCBD3", hash_generated_method = "94F9C50B4BD860CD41F57A04CBE09FF2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.011 -0400", hash_original_method = "511C5822AAD77FC3309E37C883E816C8", hash_generated_method = "943148D2FBAAAB0DE8F1927558795D9F")
    public static void enableDeathOnNetwork() {
        int oldPolicy = getThreadPolicyMask();
        int newPolicy = oldPolicy | DETECT_NETWORK | PENALTY_DEATH_ON_NETWORK;
        setThreadPolicyMask(newPolicy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.012 -0400", hash_original_method = "505B6F2C5D14D5307D2792E4869F206A", hash_generated_method = "B2A8BE88A07C1CCC431566DDEBE0F08C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.012 -0400", hash_original_method = "45B3269BE626BB87F4C05CA0ACD29C39", hash_generated_method = "4CCEDD75E9105676A0753C8872D2F662")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.012 -0400", hash_original_method = "30484C59249AAEAE6E097D020A18B06F", hash_generated_method = "37F8ED1F104DFF04041FDF639CA6DE3E")
    private static boolean tooManyViolationsThisLoop() {
        return violationsBeingTimed.get().size() >= MAX_OFFENSES_PER_LOOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.012 -0400", hash_original_method = "D57761C9E43274832734BB25E55BB64E", hash_generated_method = "C76AA26C9CA762FACBC9B4EACDE82B97")
    private static void executeDeathPenalty(ViolationInfo info) {
        int violationBit = parseViolationFromMessage(info.crashInfo.exceptionMessage);
        throw new StrictModeViolation(info.policy, violationBit, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.012 -0400", hash_original_method = "494F3008991F5D0046D1B87690D6CD67", hash_generated_method = "22D07AE65C4698CEFC65F65C54E156CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.012 -0400", hash_original_method = "DE6218951D49C9DECACECFC904F7F4CB", hash_generated_method = "254D6A055CF39186CE308B0510685D6F")
    static boolean hasGatheredViolations() {
        return gatheredViolations.get() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.012 -0400", hash_original_method = "9805B7FF3BAD48B8D2DE0E62F52A36CA", hash_generated_method = "C424A8BDBD8B97D664023DF9B1CDBC17")
    static void clearGatheredViolations() {
        gatheredViolations.set(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.012 -0400", hash_original_method = "C576A675E231D1AF2242B014415FC93D", hash_generated_method = "A1222721EF1B9FE226FB1D8C5D323D3A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.012 -0400", hash_original_method = "4D7C8157BEE5C8ED378B4CE9D63026A6", hash_generated_method = "CF8E39CD834057B25689B88DE35EE11E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.012 -0400", hash_original_method = "773AC5E4A26A865807C4BE06BCEDFBE0", hash_generated_method = "BAC368470A9B79BBED3EFE65DCDDE574")
    public static VmPolicy getVmPolicy() {
        synchronized (StrictMode.class) {
            return sVmPolicy;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.013 -0400", hash_original_method = "E2B8E9CB6BAF69ECC897B9026B7DFBD5", hash_generated_method = "9B316586E332C50571E57B05AC7C4332")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.013 -0400", hash_original_method = "825007825C279D8D60066439CEB862D6", hash_generated_method = "0ACE2A786233EF90D83D444D5714465F")
    public static boolean vmSqliteObjectLeaksEnabled() {
        return (sVmPolicyMask & DETECT_VM_CURSOR_LEAKS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.013 -0400", hash_original_method = "00BE297DAE272F1287785C1C4E3D4CA4", hash_generated_method = "DBE6179150F20B8185E35558E4A3B09A")
    public static boolean vmClosableObjectLeaksEnabled() {
        return (sVmPolicyMask & DETECT_VM_CLOSABLE_LEAKS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.013 -0400", hash_original_method = "5F852AAD19A1F9B4EA699DB4FBF77E9F", hash_generated_method = "1F2478D3B073F4E91494B4E98D500390")
    public static void onSqliteObjectLeaked(String message, Throwable originStack) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onVmPolicyViolation(message, originStack);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.013 -0400", hash_original_method = "4857C9DB572D29FDFE605B2B1ACB6FB5", hash_generated_method = "81B78A083132263DD1912217B6F1B1E1")
    public static void onWebViewMethodCalledOnWrongThread(Throwable originStack) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onVmPolicyViolation(null, originStack);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.013 -0400", hash_original_method = "3BA160C791F73BC1B2756430F54D7253", hash_generated_method = "8F62917E32A2C95AAEADAEB79EDD3ADE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.013 -0400", hash_original_method = "988356C76891278DCB1E6DF1B3D94941", hash_generated_method = "D5928F7CE9894960691F2925BDD196F5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.013 -0400", hash_original_method = "85F9A054AA9529578DD28AD736197991", hash_generated_method = "A4755520127CB5F94780E024EE048EFF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.013 -0400", hash_original_method = "60E245C2A53AD4DE6244FC5F357660C8", hash_generated_method = "78945C81B34F3347D4044B647EE36D37")
    private static void onBinderStrictModePolicyChange(int newPolicy) {
        setBlockGuardPolicy(newPolicy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.014 -0400", hash_original_method = "26856C2649829AA4775248F490BA34F6", hash_generated_method = "0E185A40104CA1873D121832171D7D38")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.014 -0400", hash_original_method = "B98B8D959756B812CAEADC403B908021", hash_generated_method = "95536240377C18D6E14A4D595E2ABF9E")
    public static void noteSlowCall(String name) {
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onCustomSlowCall(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.014 -0400", hash_original_method = "750E68EADFFF9EF2A8A0F45DFD480746", hash_generated_method = "45B6E4A40641A795C19B819ED5A19897")
    public static void noteDiskRead() {
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onReadFromDisk();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.014 -0400", hash_original_method = "C2C60A74DC13C0F89DC4E47159DB8FD2", hash_generated_method = "90EE8DE9F03BE35835AC9F026701DE0D")
    public static void noteDiskWrite() {
        BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if (!(policy instanceof AndroidBlockGuardPolicy)) {
            return;
        }
        ((AndroidBlockGuardPolicy) policy).onWriteToDisk();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.014 -0400", hash_original_method = "E950565A85A7626D07FC065E3E871678", hash_generated_method = "C061937E7668406FE8E3C5A03CB49A50")
    public static Object trackActivity(Object instance) {
        return new InstanceTracker(instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.014 -0400", hash_original_method = "4C40B4FD0BD10B4EE6F7D0BFF962D7AA", hash_generated_method = "0D457BD9440D94DCA0BF865CD4A7ADDC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.014 -0400", hash_original_method = "F6C508055F46D99984B7E83214C007E3", hash_generated_method = "4D69736B2D4F53363B49EBF62BA55279")
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
        public static final ThreadPolicy LAX = new ThreadPolicy(0);
        final int mask;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.014 -0400", hash_original_method = "B0AC15ACB9093249F94C953D0A842CAE", hash_generated_method = "25A7FB3ACC15EB1652B297319B8D5570")
        @DSModeled(DSC.SAFE)
        private ThreadPolicy(int mask) {
            dsTaint.addTaint(mask);
            // ---------- Original Method ----------
            //this.mask = mask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.014 -0400", hash_original_method = "AE05BE3A66BEE06993F7653F4CB681EB", hash_generated_method = "3A490F580BDCCB73D7B6A15FB3F9FC8A")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "[StrictMode.ThreadPolicy; mask=" + mask + "]";
        }

        
        public static final class Builder {
            private int mMask = 0;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.015 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "9591C62A9F948170D00F955E1524AE93")
            @DSModeled(DSC.SAFE)
            public Builder() {
                mMask = 0;
                // ---------- Original Method ----------
                //mMask = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.015 -0400", hash_original_method = "2270BC971D9C4F82FBD51366B809A76A", hash_generated_method = "B59745A5CEBADB74EDB47605A2FB8227")
            @DSModeled(DSC.SAFE)
            public Builder(ThreadPolicy policy) {
                dsTaint.addTaint(policy.dsTaint);
                mMask = policy.mask;
                // ---------- Original Method ----------
                //mMask = policy.mask;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.015 -0400", hash_original_method = "399752AE3320783E8BC4077BF2BAABAB", hash_generated_method = "3E4C958E3C3C7E364F27817292C588DD")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectAll() {
                Builder varB75010659E1D3DB33577DAACF4003834_409944705 = (enable(ALL_THREAD_DETECT_BITS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(ALL_THREAD_DETECT_BITS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.015 -0400", hash_original_method = "3E31B254E1B4E9A5234881E68AADF1C7", hash_generated_method = "17C3E1757ABFF78964187D2F347B7276")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder permitAll() {
                Builder var90298C1A96D6CF1919E456114FCEDE8B_112944366 = (disable(ALL_THREAD_DETECT_BITS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return disable(ALL_THREAD_DETECT_BITS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.015 -0400", hash_original_method = "8F1CC5D4BDA427578EB68B001E341FDD", hash_generated_method = "340FDEBDCFE561F1A184D8962437AEC1")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectNetwork() {
                Builder varFB0BE371D11A80C4E2A0C81DBB0B0000_880093340 = (enable(DETECT_NETWORK));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.015 -0400", hash_original_method = "2A4244001D1666DDAFB3F602ED8EC7EA", hash_generated_method = "050274CD82A6B1DC6D59E097DD08D321")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder permitNetwork() {
                Builder var9DBE48447AFBD0D9DCA1F53C0C120F63_200577926 = (disable(DETECT_NETWORK));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return disable(DETECT_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.015 -0400", hash_original_method = "75C524432F954C01B0149630CE54DDB4", hash_generated_method = "6593FB1BA9518539F4B21E7DF19B5793")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectDiskReads() {
                Builder varFE9F28F6DCC1BED36D66D9EE8EE84768_745374710 = (enable(DETECT_DISK_READ));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_DISK_READ);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.015 -0400", hash_original_method = "1BD98C02F9A11EE892D0098B20BDD8BD", hash_generated_method = "DF2FF99E4857A12911EAEEF2259A50C0")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder permitDiskReads() {
                Builder var6DBD1174C4A11AA0E23E951007852A39_1542184709 = (disable(DETECT_DISK_READ));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return disable(DETECT_DISK_READ);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.015 -0400", hash_original_method = "0F761933C6E4A91421ABB8964A4D9EB8", hash_generated_method = "1EAF7655A33FA0017F59C3616820FBEF")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectCustomSlowCalls() {
                Builder var201413392CC19AD176C216B1005B7AB0_1159313745 = (enable(DETECT_CUSTOM));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_CUSTOM);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "1F5E52FF134E5A595D9B4F3AD9EF805B", hash_generated_method = "42C8143ADA66262FB7F4CA71A154159E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder permitCustomSlowCalls() {
                Builder var201413392CC19AD176C216B1005B7AB0_856523769 = (enable(DETECT_CUSTOM));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_CUSTOM);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "583E0D5D228DC11F4F3B1B541EE8393C", hash_generated_method = "B835874540EC1E68048BB9A36C0D60F4")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectDiskWrites() {
                Builder var57E2B7E251451B4FB7DA2A1472F83B9E_1927023868 = (enable(DETECT_DISK_WRITE));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_DISK_WRITE);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "A37C6D388BF979AC5AEB871BAB2E0B6F", hash_generated_method = "7EA7ECCEF9001AF2A19DDE3AA98D9C09")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder permitDiskWrites() {
                Builder varA82CEF86E32E73C1DEDFF450DD9EB012_416883530 = (disable(DETECT_DISK_WRITE));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return disable(DETECT_DISK_WRITE);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "8766DB09D651E2B3541ACB0418FFA365", hash_generated_method = "8BD6D51BAFCA1372B410A583AC4716D1")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDialog() {
                Builder varE3BDDF8F7BDF1A402D08692E5C898831_89889796 = (enable(PENALTY_DIALOG));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DIALOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "1302C8B3D103338D7C7807D8C41FE2B6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDeath() {
                Builder var1D71F5757972FF9DC154CB7A2BBB4BA7_178813540 = (enable(PENALTY_DEATH));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "3B3840DC05B4A1C1129369D4324CF6E7", hash_generated_method = "07170AC074E4B6813495B80DF7E41D82")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDeathOnNetwork() {
                Builder var8E285BFB0382FC4C94A68FC324775001_570607380 = (enable(PENALTY_DEATH_ON_NETWORK));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH_ON_NETWORK);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "D2175CC28C327D3A1AEA760A679D2369", hash_generated_method = "2A8FBCA904401F8469658969283D024D")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyFlashScreen() {
                Builder var966ADEC38EF7E614E8143F880ABA15E6_2044448091 = (enable(PENALTY_FLASH));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_FLASH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "321501E6D4179B23B4466CC078B9D720")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyLog() {
                Builder varAA5DB1D11209B827A2125309FAF8E6D6_854673633 = (enable(PENALTY_LOG));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_LOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "A9248607F035D84DD596DF62DF148E02")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDropBox() {
                Builder var959C22F6882E3E08E0D77F2A90947774_919267656 = (enable(PENALTY_DROPBOX));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DROPBOX);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "F5DC6D6D5FFF01D674BAD30FE20032C0")
            @DSModeled(DSC.SAFE)
            private Builder enable(int bit) {
                dsTaint.addTaint(bit);
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //mMask |= bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.016 -0400", hash_original_method = "DD377E4C338D3B09C11C3D4D7DFD99D3", hash_generated_method = "4D40D12786F4D14B18A2D8F75F74C04E")
            @DSModeled(DSC.SAFE)
            private Builder disable(int bit) {
                dsTaint.addTaint(bit);
                mMask &= ~bit;
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //mMask &= ~bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.017 -0400", hash_original_method = "3E686B94A275CF17A4C5CE0839D3E8D1", hash_generated_method = "8A1B8B9395B4891F2ADCD13730E3FFE3")
            @DSModeled(DSC.SAFE)
            public ThreadPolicy build() {
                {
                    penaltyLog();
                } //End block
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


        
    }


    
    public static final class VmPolicy {
        public static final VmPolicy LAX = new VmPolicy(0, EMPTY_CLASS_LIMIT_MAP);
        final int mask;
        final HashMap<Class, Integer> classInstanceLimit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.017 -0400", hash_original_method = "BE6E35A5EA1ACA059EF2A402B69D7023", hash_generated_method = "95CAEA12392980B0FF03D5FB92048765")
        @DSModeled(DSC.SAFE)
        private VmPolicy(int mask, HashMap<Class, Integer> classInstanceLimit) {
            dsTaint.addTaint(classInstanceLimit.dsTaint);
            dsTaint.addTaint(mask);
            {
                throw new NullPointerException("classInstanceLimit == null");
            } //End block
            // ---------- Original Method ----------
            //if (classInstanceLimit == null) {
                //throw new NullPointerException("classInstanceLimit == null");
            //}
            //this.mask = mask;
            //this.classInstanceLimit = classInstanceLimit;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.017 -0400", hash_original_method = "338C4A4B8F91E885EB5A5562BE10EA45", hash_generated_method = "45B6AD5BB84358858784377315AF34FF")
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.017 -0400", hash_original_method = "C72380FC51BF6FFB0D8183E2FF7C5DBE", hash_generated_method = "9591C62A9F948170D00F955E1524AE93")
            @DSModeled(DSC.SAFE)
            public Builder() {
                mMask = 0;
                // ---------- Original Method ----------
                //mMask = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.017 -0400", hash_original_method = "FBB1CB3954D34CB1AD109CEFAD7B1DDE", hash_generated_method = "C5CD66F3A319EE27EEFFD78E8D6ADE21")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.017 -0400", hash_original_method = "E6B0AD736B79FE1E50987D22EA6466E3", hash_generated_method = "A5065624DF833154B5411BC0003B9996")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder setClassInstanceLimit(Class klass, int instanceLimit) {
                dsTaint.addTaint(instanceLimit);
                dsTaint.addTaint(klass.dsTaint);
                {
                    throw new NullPointerException("klass == null");
                } //End block
                {
                    {
                        boolean varF54A66C0EAC712B4862EF63071243FC1_247696533 = (mClassInstanceLimit.containsKey(klass) &&
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.018 -0400", hash_original_method = "1E52C56D15D33FA545E602A30D1B7293", hash_generated_method = "70E54EB80FC3666C2E62F5FC7B56CEE2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectActivityLeaks() {
                Builder var780DBA67134F710256E37D1518C94046_824744911 = (enable(DETECT_VM_ACTIVITY_LEAKS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_VM_ACTIVITY_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.018 -0400", hash_original_method = "CEAA7924A62774EE9F1DB0EAFC23F606", hash_generated_method = "0ECF697C8EF1AAE80FB4F0193FE68813")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectAll() {
                Builder var572C1D5C75201B5F2EA42D3D4A83539F_993470443 = (enable(DETECT_VM_ACTIVITY_LEAKS |
                        DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_VM_ACTIVITY_LEAKS |
                        //DETECT_VM_CURSOR_LEAKS | DETECT_VM_CLOSABLE_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.018 -0400", hash_original_method = "7CA55A1EF27E65D4088A38B2843E1EE5", hash_generated_method = "4F17DA930B78C5574B7AA8264328E59E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectLeakedSqlLiteObjects() {
                Builder varC0A7A54EAA5500F6B0F27C61E98371FE_213036415 = (enable(DETECT_VM_CURSOR_LEAKS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_VM_CURSOR_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.018 -0400", hash_original_method = "76FD4F08E7705E8F66E31708D9A399EA", hash_generated_method = "3D40F777394B0D563A546E2C12D4C730")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder detectLeakedClosableObjects() {
                Builder varDBDF972D13A7A0F505B3E318564FA057_2001350497 = (enable(DETECT_VM_CLOSABLE_LEAKS));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(DETECT_VM_CLOSABLE_LEAKS);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.018 -0400", hash_original_method = "94F50CCB3C281DFAB53140F44BEA7518", hash_generated_method = "8F61B990F6A79449DAE5B94DE362F481")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDeath() {
                Builder var1D71F5757972FF9DC154CB7A2BBB4BA7_783628831 = (enable(PENALTY_DEATH));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DEATH);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.018 -0400", hash_original_method = "2F91CFDA044E15B06DFDEA717627020F", hash_generated_method = "D3E2471BC0F4DEFB8FE5F52FDADDF016")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyLog() {
                Builder varAA5DB1D11209B827A2125309FAF8E6D6_2136139376 = (enable(PENALTY_LOG));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_LOG);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.018 -0400", hash_original_method = "79D7F41C29935BA44118AFFA48FCC1BE", hash_generated_method = "87C3148B0C0B2EB6A7B384C7D0725E76")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Builder penaltyDropBox() {
                Builder var959C22F6882E3E08E0D77F2A90947774_1191884634 = (enable(PENALTY_DROPBOX));
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return enable(PENALTY_DROPBOX);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.018 -0400", hash_original_method = "450902735A2D953DC54C05378B49DC09", hash_generated_method = "F5DC6D6D5FFF01D674BAD30FE20032C0")
            @DSModeled(DSC.SAFE)
            private Builder enable(int bit) {
                dsTaint.addTaint(bit);
                return (Builder)dsTaint.getTaint();
                // ---------- Original Method ----------
                //mMask |= bit;
                //return this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.018 -0400", hash_original_method = "6432BC9C97797DD02AE9BFA4A7F87D54", hash_generated_method = "5E05C2A23F2DDF49E371B215013099C7")
            @DSModeled(DSC.SAFE)
            public VmPolicy build() {
                {
                    penaltyLog();
                } //End block
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


        
    }


    
    public static class StrictModeViolation extends BlockGuard.BlockGuardPolicyException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.019 -0400", hash_original_method = "E7438DD65D448EA29E2BF1E2E7B9AF17", hash_generated_method = "F7F6F4BF06A22FB2A540DAC2E497E30B")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.019 -0400", hash_original_method = "DBBD717A236AEADDFBDE9EEC846203D0", hash_generated_method = "17106CA1836F6F85C159F2C298FBB91D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StrictModeNetworkViolation(int policyMask) {
            super(policyMask, DETECT_NETWORK, null);
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeDiskReadViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.019 -0400", hash_original_method = "50FAC78594B32A364EC38A7051A6D828", hash_generated_method = "D88FC6DA2172E04DA09A3EE5DAB2E59F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StrictModeDiskReadViolation(int policyMask) {
            super(policyMask, DETECT_DISK_READ, null);
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeDiskWriteViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.019 -0400", hash_original_method = "3E79DB089B8A8B103215C527DD70DC9D", hash_generated_method = "7FBF706EC8BC800A7BD568F169B6BC1F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StrictModeDiskWriteViolation(int policyMask) {
            super(policyMask, DETECT_DISK_WRITE, null);
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class StrictModeCustomViolation extends StrictModeViolation {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.019 -0400", hash_original_method = "D9775B5587EA33BC7CC7CE8D67F82D3A", hash_generated_method = "162E1A3B182FB290E4AF5B8F685E6EA3")
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
        private final HashMap<Integer, Long> mLastViolationTime = new HashMap<Integer, Long>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.019 -0400", hash_original_method = "56B73F441F57B7F1580692BF8D8E5ECB", hash_generated_method = "20B3511AABE8E80CA09AA7E062D84DB9")
        @DSModeled(DSC.SAFE)
        public AndroidBlockGuardPolicy(final int policyMask) {
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
            //mPolicyMask = policyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.019 -0400", hash_original_method = "EC02A08C2D3910C2DE1DA94FE738CE60", hash_generated_method = "85A3FB065BC3E3874466527D7B1E51F1")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "AndroidBlockGuardPolicy; mPolicyMask=" + mPolicyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.019 -0400", hash_original_method = "BDAE35F9BC36FEF12DCB9013D520032B", hash_generated_method = "86DF9E8E7FD19C2312DB5FC334160C0C")
        @DSModeled(DSC.SAFE)
        public int getPolicyMask() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPolicyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.019 -0400", hash_original_method = "0D85458AC3FF96FC22E8C3819C12EFAB", hash_generated_method = "610DA5747772619EE95CA55DBBAEE31C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onWriteToDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_403090758 = (tooManyViolationsThisLoop());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.020 -0400", hash_original_method = "B44201BA71724735A91DD4F1FF43D337", hash_generated_method = "76205202DF7915F53E109E0FD6CFF782")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void onCustomSlowCall(String name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name);
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_315401471 = (tooManyViolationsThisLoop());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.020 -0400", hash_original_method = "DC9910586B30548E82E107CFA3542EA2", hash_generated_method = "86B07E2DB4E534C78D3A5C8D707EF280")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onReadFromDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_1623057675 = (tooManyViolationsThisLoop());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.020 -0400", hash_original_method = "D41EA35CCA984A26E96A9AAEEE4BCF1E", hash_generated_method = "C4FF915E1E1B93E4B3DAD9AD1AD99507")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onNetwork() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                throw new NetworkOnMainThreadException();
            } //End block
            {
                boolean varC1086D74C3264873DADAFE03ADA68117_1137969315 = (tooManyViolationsThisLoop());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.020 -0400", hash_original_method = "A35D2E9A8AD0B9C28C9280D1C3956061", hash_generated_method = "0FD1331CB88BF1A7427E6737A9E67F53")
        @DSModeled(DSC.SAFE)
        public void setPolicyMask(int policyMask) {
            dsTaint.addTaint(policyMask);
            // ---------- Original Method ----------
            //mPolicyMask = policyMask;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.020 -0400", hash_original_method = "5E39E8C314EEA382AFAE0CC045B36998", hash_generated_method = "C40077CF301C5E0F35A2990F077A4A3E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startHandlingViolationException(BlockGuard.BlockGuardPolicyException e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(e.dsTaint);
            final ViolationInfo info;
            info = new ViolationInfo(e, e.getPolicy());
            info.violationUptimeMillis = SystemClock.uptimeMillis();
            handleViolationWithTimingAttempt(info);
            // ---------- Original Method ----------
            //final ViolationInfo info = new ViolationInfo(e, e.getPolicy());
            //info.violationUptimeMillis = SystemClock.uptimeMillis();
            //handleViolationWithTimingAttempt(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.020 -0400", hash_original_method = "E564B46DD31AF359B07F190378DAA828", hash_generated_method = "B91D12345C30738FD6915A0077D2ABAA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void handleViolationWithTimingAttempt(final ViolationInfo info) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(info.dsTaint);
            Looper looper;
            looper = Looper.myLooper();
            {
                info.durationMillis = -1;
                handleViolation(info);
            } //End block
            final ArrayList<ViolationInfo> records;
            records = violationsBeingTimed.get();
            {
                boolean var93D414F0DAF507CC4844CFB90F056FDD_1300288599 = (records.size() >= MAX_OFFENSES_PER_LOOP);
            } //End collapsed parenthetic
            records.add(info);
            {
                boolean varD777943406E4C57D521B6D48914E48C5_1049855888 = (records.size() > 1);
            } //End collapsed parenthetic
            final IWindowManager windowManager;
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
                    public void run() {
                        long loopFinishTime = SystemClock.uptimeMillis();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.021 -0400", hash_original_method = "41F5C3E6841DC86E9C64A72E84C0FF7E", hash_generated_method = "30C28ACE949211C9A94EA0756ACA3DE4")
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
                    boolean var67E0B061679ECE750C918CCF810C909E_1831934388 = (violations.size() >= 5);
                } //End collapsed parenthetic
                {
                    Iterator<ViolationInfo> seatecAstronomy42 = violations.iterator();
                    seatecAstronomy42.hasNext();
                    ViolationInfo previous = seatecAstronomy42.next();
                    {
                        {
                            boolean varC9FD4943D1AECC98A74F6D3A1A981392_1475302512 = (info.crashInfo.stackTrace.equals(previous.crashInfo.stackTrace));
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
                boolean var19200966257A15248BB4C14BB760875F_2060688704 = (mLastViolationTime.containsKey(crashFingerprint));
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
                final int savedPolicyMask;
                savedPolicyMask = getThreadPolicyMask();
                final boolean justDropBox;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.022 -0400", hash_original_method = "1648939B3F4BE7F697201ED2CA10799D", hash_generated_method = "EEBC8666AA5788DDB23C595C38CAE000")
        @DSModeled(DSC.SAFE)
        public void report(String message, Throwable allocationSite) {
            dsTaint.addTaint(message);
            dsTaint.addTaint(allocationSite.dsTaint);
            onVmPolicyViolation(message, allocationSite);
            // ---------- Original Method ----------
            //onVmPolicyViolation(message, allocationSite);
        }

        
    }


    
    private static class LogStackTrace extends Exception {
        
    }


    
    public static class Span {
        private String mName;
        private long mCreateMillis;
        private Span mNext;
        private Span mPrev;
        private final ThreadSpanState mContainerState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.022 -0400", hash_original_method = "858C7F08B86E9ABCC5108174CEDFA974", hash_generated_method = "404519D152E349F6594892D5D68CBB47")
        @DSModeled(DSC.SAFE)
         Span(ThreadSpanState threadState) {
            dsTaint.addTaint(threadState.dsTaint);
            // ---------- Original Method ----------
            //mContainerState = threadState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.022 -0400", hash_original_method = "35ECB8DB5D2E2401D23EA00A0B49C3B0", hash_generated_method = "17E98D51E9140324E072C7D772CF686C")
        @DSModeled(DSC.SAFE)
        protected Span() {
            mContainerState = null;
            // ---------- Original Method ----------
            //mContainerState = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.022 -0400", hash_original_method = "BAA90C1A527ED6ADE64DE9CF5831D500", hash_generated_method = "AA5FEFE04B85CDDE51264AC8DBB73F5F")
        @DSModeled(DSC.SAFE)
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
                    state.mActiveHead = mNext;
                } //End block
                state.mActiveSize--;
                Log.d(TAG, "Span finished=" + mName + "; size=" + state.mActiveSize);
                this.mCreateMillis = -1;
                this.mName = null;
                this.mPrev = null;
                this.mNext = null;
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
        public Span mActiveHead;
        public int mActiveSize;
        public Span mFreeListHead;
        public int mFreeListSize;
        
    }


    
    public static class ViolationInfo {
        public final ApplicationErrorReport.CrashInfo crashInfo;
        public final int policy;
        public int durationMillis = -1;
        public int numAnimationsRunning = 0;
        public String[] tags;
        public int violationNumThisLoop;
        public long violationUptimeMillis;
        public String broadcastIntentAction;
        public long numInstances = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.022 -0400", hash_original_method = "D15EADA574CC6688E3A5C168E5A51EC1", hash_generated_method = "05F259CFCF46AE5605E16C87C997173A")
        @DSModeled(DSC.SAFE)
        public ViolationInfo() {
            crashInfo = null;
            policy = 0;
            // ---------- Original Method ----------
            //crashInfo = null;
            //policy = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.022 -0400", hash_original_method = "B97F48EA0F14252413142D91DE4A3BFA", hash_generated_method = "6104BDEED5F9D1A415F0489D0D5D4CC1")
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
                        index++;
                        iter = iter.mNext;
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.023 -0400", hash_original_method = "2281C8F6C464FE0E4D053A790D9731B4", hash_generated_method = "4E35E5856863C9C390797D940D4020C6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ViolationInfo(Parcel in) {
            this(in, false);
            dsTaint.addTaint(in.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.023 -0400", hash_original_method = "276C18C659FAD0D183192D3E613DC123", hash_generated_method = "8E6319729A0AFE149DE6625751BDB2D9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.023 -0400", hash_original_method = "C167EFD1AA966CEFAC170AF811F6D4AF", hash_generated_method = "6221587CB56D7F38029C11282DA5EEAB")
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
                    Iterator<String> seatecAstronomy42 = tags.iterator();
                    seatecAstronomy42.hasNext();
                    String tag = seatecAstronomy42.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.023 -0400", hash_original_method = "4C68F89668EEC8ACA3036C864AE1DCBA", hash_generated_method = "69229C5751E175F8EBCF8611CF912323")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.024 -0400", hash_original_method = "FB1CB9CE36DAC72C8A293B50C548452A", hash_generated_method = "D2FB676CB320A0A9CDD0D1AD9C9DD1AE")
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
                    Iterator<String> seatecAstronomy42 = tags.iterator();
                    seatecAstronomy42.hasNext();
                    String tag = seatecAstronomy42.next();
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
        final Class mClass;
        final long mInstances;
        final int mLimit;
        private static final StackTraceElement[] FAKE_STACK = {
            new StackTraceElement("android.os.StrictMode", "setClassInstanceLimit",
                                  "StrictMode.java", 1)
        };
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.024 -0400", hash_original_method = "E80F10435372AA752F8DBC4C44A2404B", hash_generated_method = "E406843F8E40D91721431FD518992466")
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

        
    }


    
    private static final class InstanceTracker {
        private static final HashMap<Class<?>, Integer> sInstanceCounts =
                new HashMap<Class<?>, Integer>();
        private final Class<?> mKlass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.024 -0400", hash_original_method = "D1695326538E61C61B9A9871778AEDEF", hash_generated_method = "AD10F62E4CC50B7712622A9EBF77EC14")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InstanceTracker(Object instance) {
            dsTaint.addTaint(instance.dsTaint);
            mKlass = instance.getClass();
            {
                final Integer value;
                value = sInstanceCounts.get(mKlass);
                final int newValue;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.024 -0400", hash_original_method = "3D9E07641D189E499B7BA8CA77DD9FB9", hash_generated_method = "552A36704E36EE9E93F573FF7B763BDD")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                {
                    final Integer value;
                    value = sInstanceCounts.get(mKlass);
                    {
                        final int newValue;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.024 -0400", hash_original_method = "C02E63494A43A201950056E55F3CBD0C", hash_generated_method = "7CAD8FEB118160808B68A1260CEF7531")
        public static int getInstanceCount(Class<?> klass) {
            synchronized (sInstanceCounts) {
                final Integer value = sInstanceCounts.get(klass);
                return value != null ? value : 0;
            }
        }

        
    }


    
}


