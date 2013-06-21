package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PerformanceCollector;
import android.os.RemoteException;
import android.os.Debug;
import android.os.IBinder;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.os.ServiceManager;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.IWindowManager;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Instrumentation {
    private Object mSync = new Object();
    private ActivityThread mThread = null;
    private MessageQueue mMessageQueue = null;
    private Context mInstrContext;
    private Context mAppContext;
    private ComponentName mComponent;
    private Thread mRunner;
    private List<ActivityWaiter> mWaitingActivities;
    private List<ActivityMonitor> mActivityMonitors;
    private IInstrumentationWatcher mWatcher;
    private boolean mAutomaticPerformanceSnapshots = false;
    private PerformanceCollector mPerformanceCollector;
    private Bundle mPerfMetrics = new Bundle();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.104 -0400", hash_original_method = "2A2FEB9F4AAE35A924F5C88DA8F6FDF1", hash_generated_method = "05D8623C11D87D684B7E40B654AAAA52")
    @DSModeled(DSC.SAFE)
    public Instrumentation() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.104 -0400", hash_original_method = "4B024CDE66137DA3ED66BF57127A0E80", hash_generated_method = "7370BA31CF67D75DEEBCD51E77B47298")
    @DSModeled(DSC.SAFE)
    public void onCreate(Bundle arguments) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(arguments.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.105 -0400", hash_original_method = "75096E18A1A48E91D30DD9D6FBFD5D1F", hash_generated_method = "B182D72CA75E106C7C1742F3754E710E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Instrumentation already started");
        } //End block
        mRunner = new InstrumentationThread("Instr: " + getClass().getName());
        mRunner.start();
        // ---------- Original Method ----------
        //if (mRunner != null) {
            //throw new RuntimeException("Instrumentation already started");
        //}
        //mRunner = new InstrumentationThread("Instr: " + getClass().getName());
        //mRunner.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.105 -0400", hash_original_method = "0451E38101EC2D69951E664FB36904F0", hash_generated_method = "C270D6AECB942165605F46F9C723CFA1")
    @DSModeled(DSC.SAFE)
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.106 -0400", hash_original_method = "8DC9492B498FF3067475C41C79EEAB3B", hash_generated_method = "AA9F13069E4B8CEE2EA1F689F8CF829D")
    @DSModeled(DSC.SAFE)
    public boolean onException(Object obj, Throwable e) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(obj.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.106 -0400", hash_original_method = "5CE1AB9DF7D7162F89956B1D13BE745E", hash_generated_method = "98A0B58B324F16E3956A730B976BACA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendStatus(int resultCode, Bundle results) {
        dsTaint.addTaint(results.dsTaint);
        dsTaint.addTaint(resultCode);
        {
            try 
            {
                mWatcher.instrumentationStatus(mComponent, resultCode, results);
            } //End block
            catch (RemoteException e)
            {
                mWatcher = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mWatcher != null) {
            //try {
                //mWatcher.instrumentationStatus(mComponent, resultCode, results);
            //}
            //catch (RemoteException e) {
                //mWatcher = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.106 -0400", hash_original_method = "93CEFEE99BA727186FFD22BEC1D0D072", hash_generated_method = "E2AF4364398D035667C893257B1B298B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finish(int resultCode, Bundle results) {
        dsTaint.addTaint(results.dsTaint);
        dsTaint.addTaint(resultCode);
        {
            endPerformanceSnapshot();
        } //End block
        {
            results.putAll(mPerfMetrics);
        } //End block
        mThread.finishInstrumentation(resultCode, results);
        // ---------- Original Method ----------
        //if (mAutomaticPerformanceSnapshots) {
            //endPerformanceSnapshot();
        //}
        //if (mPerfMetrics != null) {
            //results.putAll(mPerfMetrics);
        //}
        //mThread.finishInstrumentation(resultCode, results);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.107 -0400", hash_original_method = "6EB9EED76498D1668A96326FD6FFBEE9", hash_generated_method = "FD3545546835D20A0C087ACC19F8773F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAutomaticPerformanceSnapshots() {
        mAutomaticPerformanceSnapshots = true;
        mPerformanceCollector = new PerformanceCollector();
        // ---------- Original Method ----------
        //mAutomaticPerformanceSnapshots = true;
        //mPerformanceCollector = new PerformanceCollector();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.107 -0400", hash_original_method = "59F6F337F904783653DF79F6C5B4E5AA", hash_generated_method = "A5C36516B1CA034D6DACB95784B2DD19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startPerformanceSnapshot() {
        {
            boolean var32F63117AA68B41701446BAB1196A3B6_807081402 = (!isProfiling());
            {
                mPerformanceCollector.beginSnapshot(null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isProfiling()) {
            //mPerformanceCollector.beginSnapshot(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.108 -0400", hash_original_method = "8BB380F00D03C999D4B5625E8ECD5AAA", hash_generated_method = "3836E295793C67C80AB6092779C3F793")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endPerformanceSnapshot() {
        {
            boolean var32F63117AA68B41701446BAB1196A3B6_1716257372 = (!isProfiling());
            {
                mPerfMetrics = mPerformanceCollector.endSnapshot();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isProfiling()) {
            //mPerfMetrics = mPerformanceCollector.endSnapshot();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.108 -0400", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "E5C4FFF396F837C85A1D40A9B232BFA0")
    @DSModeled(DSC.SAFE)
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.108 -0400", hash_original_method = "0612F59C08E6EE31E243F52D2CCB68AA", hash_generated_method = "0809B3AFF3B16315A4ACE3B6F4A448FE")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInstrContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.109 -0400", hash_original_method = "6C1D36E28C0C97736EA4779A7FB1715C", hash_generated_method = "123907E24CE652D9CBCF4C58DCA10581")
    @DSModeled(DSC.SAFE)
    public ComponentName getComponentName() {
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mComponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.109 -0400", hash_original_method = "D1026223DF11B7056861FB0AA4B64828", hash_generated_method = "9D51A521972DFA367C79282EE38765FA")
    @DSModeled(DSC.SAFE)
    public Context getTargetContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAppContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.109 -0400", hash_original_method = "7D34AF538E9A67DEA76272AB02F2CDC6", hash_generated_method = "AE7ED82DEA5544375B4443FB28766C51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isProfiling() {
        boolean var2E415148C7B7470B2B3A38C816E662AA_297472507 = (mThread.isProfiling());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mThread.isProfiling();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.110 -0400", hash_original_method = "988500FDA3CAE61033EABAD95C8BF0F1", hash_generated_method = "A8CC2BD3FE1981A64746E67A74A0ABAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startProfiling() {
        {
            boolean var293A0446960E74ADC95BC62CEC42A6FA_2007688336 = (mThread.isProfiling());
            {
                File file;
                file = new File(mThread.getProfileFilePath());
                file.getParentFile().mkdirs();
                Debug.startMethodTracing(file.toString(), 8 * 1024 * 1024);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mThread.isProfiling()) {
            //File file = new File(mThread.getProfileFilePath());
            //file.getParentFile().mkdirs();
            //Debug.startMethodTracing(file.toString(), 8 * 1024 * 1024);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.110 -0400", hash_original_method = "1FEC2A39C917937DB00CBC5BA91E5501", hash_generated_method = "A4A3036F44CD420EC4B68D46DC3AB004")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopProfiling() {
        {
            boolean var293A0446960E74ADC95BC62CEC42A6FA_300562949 = (mThread.isProfiling());
            {
                Debug.stopMethodTracing();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mThread.isProfiling()) {
            //Debug.stopMethodTracing();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.110 -0400", hash_original_method = "EEC5F78C5E75C7158C64611E1694E1A0", hash_generated_method = "24933F525190882FA7B175F6411A781F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInTouchMode(boolean inTouch) {
        dsTaint.addTaint(inTouch);
        try 
        {
            IWindowManager.Stub.asInterface(
                    ServiceManager.getService("window")).setInTouchMode(inTouch);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //IWindowManager.Stub.asInterface(
                    //ServiceManager.getService("window")).setInTouchMode(inTouch);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.111 -0400", hash_original_method = "9CBDEDF34C527A410521706D53450B12", hash_generated_method = "4850D14FE72CF0E5E00BE4F38EA938C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void waitForIdle(Runnable recipient) {
        dsTaint.addTaint(recipient.dsTaint);
        mMessageQueue.addIdleHandler(new Idler(recipient));
        mThread.getHandler().post(new EmptyRunnable());
        // ---------- Original Method ----------
        //mMessageQueue.addIdleHandler(new Idler(recipient));
        //mThread.getHandler().post(new EmptyRunnable());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.111 -0400", hash_original_method = "89AA1CC3D27AC9ADF27421ED4392817A", hash_generated_method = "EC7161BBDA4932C5B3504C4548A15C76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void waitForIdleSync() {
        validateNotAppThread();
        Idler idler;
        idler = new Idler(null);
        mMessageQueue.addIdleHandler(idler);
        mThread.getHandler().post(new EmptyRunnable());
        idler.waitForIdle();
        // ---------- Original Method ----------
        //validateNotAppThread();
        //Idler idler = new Idler(null);
        //mMessageQueue.addIdleHandler(idler);
        //mThread.getHandler().post(new EmptyRunnable());
        //idler.waitForIdle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.112 -0400", hash_original_method = "23FE2246FE60A7859CD93D836CF467DE", hash_generated_method = "B6A6103A1D4F2BBB9600D537F5DDBCF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void runOnMainSync(Runnable runner) {
        dsTaint.addTaint(runner.dsTaint);
        validateNotAppThread();
        SyncRunnable sr;
        sr = new SyncRunnable(runner);
        mThread.getHandler().post(sr);
        sr.waitForComplete();
        // ---------- Original Method ----------
        //validateNotAppThread();
        //SyncRunnable sr = new SyncRunnable(runner);
        //mThread.getHandler().post(sr);
        //sr.waitForComplete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.112 -0400", hash_original_method = "834B647755C86ED587A771C499B38AF8", hash_generated_method = "5AE5F3BAB2CFD0DE2CFD5D0285A9D48D")
    @DSModeled(DSC.SPEC)
    public Activity startActivitySync(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        validateNotAppThread();
        {
            intent = new Intent(intent);
            ActivityInfo ai;
            ai = intent.resolveActivityInfo(
                getTargetContext().getPackageManager(), 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unable to resolve activity for: " + intent);
            } //End block
            String myProc;
            myProc = mThread.getProcessName();
            {
                boolean varD8D363FC173629EAE19D3F60EB68E1B8_13796918 = (!ai.processName.equals(myProc));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Intent in process "
                        + myProc + " resolved to different process "
                        + ai.processName + ": " + intent);
                } //End block
            } //End collapsed parenthetic
            intent.setComponent(new ComponentName(
                    ai.applicationInfo.packageName, ai.name));
            ActivityWaiter aw;
            aw = new ActivityWaiter(intent);
            {
                mWaitingActivities = new ArrayList();
            } //End block
            mWaitingActivities.add(aw);
            getTargetContext().startActivity(intent);
            {
                try 
                {
                    mSync.wait();
                } //End block
                catch (InterruptedException e)
                { }
            } //End block
            {
                boolean var58BADEC5202E1F9ECFC4CA15E819048E_120537698 = (mWaitingActivities.contains(aw));
            } //End collapsed parenthetic
        } //End block
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.113 -0400", hash_original_method = "608AF20D37ADB77B72D35062305FF16B", hash_generated_method = "2485B21ABFC49E88EBE36185B0211ED9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addMonitor(ActivityMonitor monitor) {
        dsTaint.addTaint(monitor.dsTaint);
        {
            {
                mActivityMonitors = new ArrayList();
            } //End block
            mActivityMonitors.add(monitor);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mActivityMonitors == null) {
                //mActivityMonitors = new ArrayList();
            //}
            //mActivityMonitors.add(monitor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.113 -0400", hash_original_method = "A7BDDA46B206533FE67A2A87AD7D2268", hash_generated_method = "F0AAA30B5D007FADE6E1E5D80E666248")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActivityMonitor addMonitor(
        IntentFilter filter, ActivityResult result, boolean block) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(block);
        dsTaint.addTaint(filter.dsTaint);
        ActivityMonitor am;
        am = new ActivityMonitor(filter, result, block);
        addMonitor(am);
        return (ActivityMonitor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ActivityMonitor am = new ActivityMonitor(filter, result, block);
        //addMonitor(am);
        //return am;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.114 -0400", hash_original_method = "1AE73A4BC3EDE4468A3DB90D9129EBCC", hash_generated_method = "CEC47D6064845A0D788D1FF180C8DEB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActivityMonitor addMonitor(
        String cls, ActivityResult result, boolean block) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(cls);
        dsTaint.addTaint(block);
        ActivityMonitor am;
        am = new ActivityMonitor(cls, result, block);
        addMonitor(am);
        return (ActivityMonitor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ActivityMonitor am = new ActivityMonitor(cls, result, block);
        //addMonitor(am);
        //return am;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.114 -0400", hash_original_method = "29E7A5CE85EC83DC1A6299DE5A3CFA02", hash_generated_method = "9572D3F5F0B8CC811E3AB4B69F79D63B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean checkMonitorHit(ActivityMonitor monitor, int minHits) {
        dsTaint.addTaint(monitor.dsTaint);
        dsTaint.addTaint(minHits);
        waitForIdleSync();
        {
            {
                boolean varFAB6AF39377D40587098ED5F1691D051_997200540 = (monitor.getHits() < minHits);
            } //End collapsed parenthetic
            mActivityMonitors.remove(monitor);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //waitForIdleSync();
        //synchronized (mSync) {
            //if (monitor.getHits() < minHits) {
                //return false;
            //}
            //mActivityMonitors.remove(monitor);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.115 -0400", hash_original_method = "ACAA082ACBE3DC4BF5F5B838A83827D9", hash_generated_method = "D44881F48AEB2C7C31EC22A1AC5DEC1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Activity waitForMonitor(ActivityMonitor monitor) {
        dsTaint.addTaint(monitor.dsTaint);
        Activity activity;
        activity = monitor.waitForActivity();
        {
            mActivityMonitors.remove(monitor);
        } //End block
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Activity activity = monitor.waitForActivity();
        //synchronized (mSync) {
            //mActivityMonitors.remove(monitor);
        //}
        //return activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.115 -0400", hash_original_method = "C35EC81162DCBEC6CBBF630B6FBC9A38", hash_generated_method = "DABCB5C669CF8ABB8CF91A1D55EC8525")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Activity waitForMonitorWithTimeout(ActivityMonitor monitor, long timeOut) {
        dsTaint.addTaint(monitor.dsTaint);
        dsTaint.addTaint(timeOut);
        Activity activity;
        activity = monitor.waitForActivityWithTimeout(timeOut);
        {
            mActivityMonitors.remove(monitor);
        } //End block
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Activity activity = monitor.waitForActivityWithTimeout(timeOut);
        //synchronized (mSync) {
            //mActivityMonitors.remove(monitor);
        //}
        //return activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.116 -0400", hash_original_method = "667CF28A3BE8CF2696555BC3512917A7", hash_generated_method = "35259BC6D2E748F0AD1EA4B06731859C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeMonitor(ActivityMonitor monitor) {
        dsTaint.addTaint(monitor.dsTaint);
        {
            mActivityMonitors.remove(monitor);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //mActivityMonitors.remove(monitor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.118 -0400", hash_original_method = "4D155A3E8D909DAB8A4322BEF2D5BDFA", hash_generated_method = "2A2DD1202961508A8BB992D33A723E0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean invokeMenuActionSync(Activity targetActivity, 
                                    int id, int flag) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(flag);
        dsTaint.addTaint(targetActivity.dsTaint);
        class MenuRunnable implements Runnable {
            private Activity activity;
            private int identifier;
            private int flags;
            boolean returnValue;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.117 -0400", hash_original_method = "29927998E9364A9B4F18182584446309", hash_generated_method = "D6A474E7A1032D1F6D96F3B15F7E19D3")
            @DSModeled(DSC.SAFE)
            public MenuRunnable(Activity _activity, int _identifier,
                                    int _flags) {
                dsTaint.addTaint(_activity.dsTaint);
                dsTaint.addTaint(_identifier);
                dsTaint.addTaint(_flags);
                // ---------- Original Method ----------
                //activity = _activity;
                //identifier = _identifier;
                //flags = _flags;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.117 -0400", hash_original_method = "76921810C67DCF51EE72D55418C1BAD6", hash_generated_method = "B7D37EC36247FE63D51E288E00BEE274")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                Window win;
                win = activity.getWindow();
                returnValue = win.performPanelIdentifierAction(
                            Window.FEATURE_OPTIONS_PANEL,
                            identifier, 
                            flags);
                // ---------- Original Method ----------
                //Window win = activity.getWindow();
                //returnValue = win.performPanelIdentifierAction(
                            //Window.FEATURE_OPTIONS_PANEL,
                            //identifier, 
                            //flags);
            }
        }
        MenuRunnable mr;
        mr = new MenuRunnable(targetActivity, id, flag);
        runOnMainSync(mr);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.120 -0400", hash_original_method = "28CE40BD9E15A522E886C67E234DD689", hash_generated_method = "3DCA00AB9189F2C3546E9413AD01ED64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean invokeContextMenuAction(Activity targetActivity, int id, int flag) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(flag);
        dsTaint.addTaint(targetActivity.dsTaint);
        validateNotAppThread();
        KeyEvent downEvent;
        downEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_CENTER);
        sendKeySync(downEvent);
        waitForIdleSync();
        try 
        {
            Thread.sleep(ViewConfiguration.getLongPressTimeout());
        } //End block
        catch (InterruptedException e)
        { }
        KeyEvent upEvent;
        upEvent = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_CENTER);
        sendKeySync(upEvent);
        waitForIdleSync();
        class ContextMenuRunnable implements Runnable {
            private Activity activity;
            private int identifier;
            private int flags;
            boolean returnValue;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.119 -0400", hash_original_method = "798263D9D537A1153607D5F0FAA29A33", hash_generated_method = "F8520D67046AF0655C2CB9D1AD471472")
            @DSModeled(DSC.SAFE)
            public ContextMenuRunnable(Activity _activity, int _identifier,
                                    int _flags) {
                dsTaint.addTaint(_activity.dsTaint);
                dsTaint.addTaint(_identifier);
                dsTaint.addTaint(_flags);
                // ---------- Original Method ----------
                //activity = _activity;
                //identifier = _identifier;
                //flags = _flags;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.120 -0400", hash_original_method = "E7EE26BA0D2735345FDDDF8FC2DD3A31", hash_generated_method = "BAEE6E9359978C20B41217A5B7E3211C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                Window win;
                win = activity.getWindow();
                returnValue = win.performContextMenuIdentifierAction(
                            identifier, 
                            flags);
                // ---------- Original Method ----------
                //Window win = activity.getWindow();
                //returnValue = win.performContextMenuIdentifierAction(
                            //identifier, 
                            //flags);
            }
        }
        ContextMenuRunnable cmr;
        cmr = new ContextMenuRunnable(targetActivity, id, flag);
        runOnMainSync(cmr);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.121 -0400", hash_original_method = "029397BC692B989F9FCA48D48FDB9479", hash_generated_method = "EDCE5D9D32734BB9C0E62818D170CC0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendStringSync(String text) {
        dsTaint.addTaint(text);
        KeyCharacterMap keyCharacterMap;
        keyCharacterMap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
        KeyEvent[] events;
        events = keyCharacterMap.getEvents(text.toCharArray());
        {
            {
                int i;
                i = 0;
                {
                    sendKeySync(events[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (text == null) {
            //return;
        //}
        //KeyCharacterMap keyCharacterMap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
        //KeyEvent[] events = keyCharacterMap.getEvents(text.toCharArray());
        //if (events != null) {
            //for (int i = 0; i < events.length; i++) {
                //sendKeySync(events[i]);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.122 -0400", hash_original_method = "8EB82A3200B456D290A2F7A26355BB76", hash_generated_method = "6FF2DA373A061EAC18C8284785A4A1F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendKeySync(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        validateNotAppThread();
        try 
        {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectKeyEvent(event, true);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //validateNotAppThread();
        //try {
            //(IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                //.injectKeyEvent(event, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.123 -0400", hash_original_method = "EAB0936DFBB6258C56105993043121F1", hash_generated_method = "22C10BD793E46A190F14C8C63206914B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendKeyDownUpSync(int key) {
        dsTaint.addTaint(key);
        sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, key));
        sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, key));
        // ---------- Original Method ----------
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, key));
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, key));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.123 -0400", hash_original_method = "481470F7D6C4847394865E9F06AE8ED8", hash_generated_method = "593DEC6900C70B3096141FDDC5DE88E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendCharacterSync(int keyCode) {
        dsTaint.addTaint(keyCode);
        sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
        sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, keyCode));
        // ---------- Original Method ----------
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, keyCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.124 -0400", hash_original_method = "B9A3EF31E8BF5F99FCCA686BC6658BE3", hash_generated_method = "4784B4396FA2074651724A2930F1039A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendPointerSync(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        validateNotAppThread();
        try 
        {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectPointerEvent(event, true);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //validateNotAppThread();
        //try {
            //(IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                //.injectPointerEvent(event, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.125 -0400", hash_original_method = "6B2ECCD3AB22E94B5B1243023E902F6D", hash_generated_method = "DCBD6EEC74E5CBCF75B07EB93D2AED3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendTrackballEventSync(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        validateNotAppThread();
        try 
        {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectTrackballEvent(event, true);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //validateNotAppThread();
        //try {
            //(IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                //.injectTrackballEvent(event, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.126 -0400", hash_original_method = "1A9EF24656896AC4FCE906BFB43593E0", hash_generated_method = "71F26F639DB172D5B6688639EE0084CE")
    @DSModeled(DSC.BAN)
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, 
            ClassNotFoundException {
        dsTaint.addTaint(cl.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(className);
        Application var9DC4802E10329003156334868FA5041D_1353954324 = (newApplication(cl.loadClass(className), context));
        return (Application)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return newApplication(cl.loadClass(className), context);
    }

    
        static public Application newApplication(Class<?> clazz, Context context) throws InstantiationException, IllegalAccessException, 
            ClassNotFoundException {
        Application app = (Application)clazz.newInstance();
        app.attach(context);
        return app;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.127 -0400", hash_original_method = "3D967D3E47594084D340D0FEDC81A2D2", hash_generated_method = "07E9A9F66F959574095BE3B286245AA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callApplicationOnCreate(Application app) {
        dsTaint.addTaint(app.dsTaint);
        app.onCreate();
        // ---------- Original Method ----------
        //app.onCreate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.127 -0400", hash_original_method = "A9111F868862B9E251C99947D42ADECF", hash_generated_method = "DB26496E21A5D678F9F87DCAD97F74FD")
    @DSModeled(DSC.SPEC)
    public Activity newActivity(Class<?> clazz, Context context, 
            IBinder token, Application application, Intent intent, ActivityInfo info, 
            CharSequence title, Activity parent, String id,
            Object lastNonConfigurationInstance) throws InstantiationException, 
            IllegalAccessException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(title);
        dsTaint.addTaint(application.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(lastNonConfigurationInstance.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(clazz.dsTaint);
        dsTaint.addTaint(info.dsTaint);
        Activity activity;
        activity = (Activity)clazz.newInstance();
        ActivityThread aThread;
        aThread = null;
        activity.attach(context, aThread, this, token, application, intent,
                info, title, parent, id,
                (Activity.NonConfigurationInstances)lastNonConfigurationInstance,
                new Configuration());
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Activity activity = (Activity)clazz.newInstance();
        //ActivityThread aThread = null;
        //activity.attach(context, aThread, this, token, application, intent,
                //info, title, parent, id,
                //(Activity.NonConfigurationInstances)lastNonConfigurationInstance,
                //new Configuration());
        //return activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.128 -0400", hash_original_method = "67A9E29CAF7C169812898E8BB0812F51", hash_generated_method = "A939EDC9F94562F546007D064AC2C889")
    @DSModeled(DSC.BAN)
    public Activity newActivity(ClassLoader cl, String className,
            Intent intent) throws InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        dsTaint.addTaint(cl.dsTaint);
        dsTaint.addTaint(className);
        dsTaint.addTaint(intent.dsTaint);
        Activity var0111B709F563B1CDD0EF2B9E1C08AD11_1551530559 = ((Activity)cl.loadClass(className).newInstance());
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Activity)cl.loadClass(className).newInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.131 -0400", hash_original_method = "5B22BAF104CC01C4555866A70EB5D211", hash_generated_method = "1F8CECF2349F0E797DAE7900E87984BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnCreate(Activity activity, Bundle icicle) {
        dsTaint.addTaint(icicle.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        {
            {
                int N;
                N = mWaitingActivities.size();
                {
                    int i;
                    i = 0;
                    {
                        ActivityWaiter aw;
                        aw = mWaitingActivities.get(i);
                        Intent intent;
                        intent = aw.intent;
                        {
                            boolean var342D97B360658057F9A6B74D7AD8662E_1526454705 = (intent.filterEquals(activity.getIntent()));
                            {
                                aw.activity = activity;
                                mMessageQueue.addIdleHandler(new ActivityGoing(aw));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        activity.performCreate(icicle);
        {
            {
                int N;
                N = mActivityMonitors.size();
                {
                    int i;
                    i = 0;
                    {
                        ActivityMonitor am;
                        am = mActivityMonitors.get(i);
                        am.match(activity, activity, activity.getIntent());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.132 -0400", hash_original_method = "ACD4ACDF1D4AD87F23B45E29C987968F", hash_generated_method = "C1C8B6C887F276286629A2400516F5B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnDestroy(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        activity.performDestroy();
        {
            {
                int N;
                N = mActivityMonitors.size();
                {
                    int i;
                    i = 0;
                    {
                        ActivityMonitor am;
                        am = mActivityMonitors.get(i);
                        am.match(activity, activity, activity.getIntent());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        //activity.performDestroy();
        //if (mActivityMonitors != null) {
          //synchronized (mSync) {
              //final int N = mActivityMonitors.size();
              //for (int i=0; i<N; i++) {
                  //final ActivityMonitor am = mActivityMonitors.get(i);
                  //am.match(activity, activity, activity.getIntent());
              //}
          //}
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.132 -0400", hash_original_method = "E084363C345B4BF61D861FC0D5D07D15", hash_generated_method = "369FADD3147780F7B983878F6E331AE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnRestoreInstanceState(Activity activity, Bundle savedInstanceState) {
        dsTaint.addTaint(savedInstanceState.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        activity.performRestoreInstanceState(savedInstanceState);
        // ---------- Original Method ----------
        //activity.performRestoreInstanceState(savedInstanceState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.133 -0400", hash_original_method = "2BECA7ACE9ECA4B1DD0299ACB1DA09B9", hash_generated_method = "9A4E02A645EC6A2625A5D847B29B3E02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnPostCreate(Activity activity, Bundle icicle) {
        dsTaint.addTaint(icicle.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        activity.onPostCreate(icicle);
        // ---------- Original Method ----------
        //activity.onPostCreate(icicle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.133 -0400", hash_original_method = "5C607C7DDC680DB12532E9DB6F9CBC1F", hash_generated_method = "74C4C07EE5BBC869F2505E72E835F642")
    @DSModeled(DSC.SPEC)
    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        activity.onNewIntent(intent);
        // ---------- Original Method ----------
        //activity.onNewIntent(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.133 -0400", hash_original_method = "92E54A7AE2339DA4EE7A292F370BB21D", hash_generated_method = "6D01B82131F4CE6482F74B4732514440")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnStart(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        activity.onStart();
        // ---------- Original Method ----------
        //activity.onStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.134 -0400", hash_original_method = "85BE14FC295678CF247F9E472F613652", hash_generated_method = "F1686B8E046062D07DE5B17C0EFD86DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnRestart(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        activity.onRestart();
        // ---------- Original Method ----------
        //activity.onRestart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.134 -0400", hash_original_method = "7A6C498E491E406F2D113F8023D1483F", hash_generated_method = "2B6FE42CF216002648A63E249F9CF9CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnResume(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        activity.mResumed = true;
        activity.onResume();
        {
            {
                int N;
                N = mActivityMonitors.size();
                {
                    int i;
                    i = 0;
                    {
                        ActivityMonitor am;
                        am = mActivityMonitors.get(i);
                        am.match(activity, activity, activity.getIntent());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        //activity.mResumed = true;
        //activity.onResume();
        //if (mActivityMonitors != null) {
            //synchronized (mSync) {
                //final int N = mActivityMonitors.size();
                //for (int i=0; i<N; i++) {
                    //final ActivityMonitor am = mActivityMonitors.get(i);
                    //am.match(activity, activity, activity.getIntent());
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.135 -0400", hash_original_method = "0F89D6C7937A191011A20B47DB6599C5", hash_generated_method = "0D562BCA1C0998D403DA2B21A47F52ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnStop(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        activity.onStop();
        // ---------- Original Method ----------
        //activity.onStop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.135 -0400", hash_original_method = "E8ECFB0E3E7F6A98F4E3FE19FF7167B5", hash_generated_method = "968121633F64EAA1F67F6487CCC8ED68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnSaveInstanceState(Activity activity, Bundle outState) {
        dsTaint.addTaint(outState.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        activity.performSaveInstanceState(outState);
        // ---------- Original Method ----------
        //activity.performSaveInstanceState(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.135 -0400", hash_original_method = "A3AB5C16D17E1593B1F616581634810F", hash_generated_method = "0616C645A28651F6F2E1F80760F3FCCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnPause(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        activity.performPause();
        // ---------- Original Method ----------
        //activity.performPause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.136 -0400", hash_original_method = "436C260B8868F376171ACCB198E870A3", hash_generated_method = "B1BDA5354A0A999904905BBEFBB8C521")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void callActivityOnUserLeaving(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        activity.performUserLeaving();
        // ---------- Original Method ----------
        //activity.performUserLeaving();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.136 -0400", hash_original_method = "7FDB53D95055F8344C6717BAA41CDD62", hash_generated_method = "30C2B3835BA32D0C19AF35DC83FE7525")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.resetAllCounts();
        Debug.startAllocCounting();
        // ---------- Original Method ----------
        //Runtime.getRuntime().gc();
        //Runtime.getRuntime().runFinalization();
        //Runtime.getRuntime().gc();
        //Debug.resetAllCounts();
        //Debug.startAllocCounting();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.136 -0400", hash_original_method = "0DC5272531C251864B2A214C154F0F7A", hash_generated_method = "D46BBBE387BBBBD9A6E2A4FED2A36980")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.stopAllocCounting();
        // ---------- Original Method ----------
        //Runtime.getRuntime().gc();
        //Runtime.getRuntime().runFinalization();
        //Runtime.getRuntime().gc();
        //Debug.stopAllocCounting();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.137 -0400", hash_original_method = "8051F011270999D9228A08818EFD61DD", hash_generated_method = "242730104CEE79A9BEA124F76E68FBE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addValue(String key, int value, Bundle results) {
        dsTaint.addTaint(results.dsTaint);
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        {
            boolean var995B4440ACB6664962C911ABBA2A083D_1063565548 = (results.containsKey(key));
            {
                List<Integer> list;
                list = results.getIntegerArrayList(key);
                {
                    list.add(value);
                } //End block
            } //End block
            {
                ArrayList<Integer> list;
                list = new ArrayList<Integer>();
                list.add(value);
                results.putIntegerArrayList(key, list);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (results.containsKey(key)) {
            //List<Integer> list = results.getIntegerArrayList(key);
            //if (list != null) {
                //list.add(value);
            //}
        //} else {
            //ArrayList<Integer> list = new ArrayList<Integer>();
            //list.add(value);
            //results.putIntegerArrayList(key, list);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.137 -0400", hash_original_method = "733DA96DDB5CBA410EC33155388CAA51", hash_generated_method = "5C885DCC82169AA7420300A04076C443")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle getAllocCounts() {
        Bundle results;
        results = new Bundle();
        results.putLong("global_alloc_count", Debug.getGlobalAllocCount());
        results.putLong("global_alloc_size", Debug.getGlobalAllocSize());
        results.putLong("global_freed_count", Debug.getGlobalFreedCount());
        results.putLong("global_freed_size", Debug.getGlobalFreedSize());
        results.putLong("gc_invocation_count", Debug.getGlobalGcInvocationCount());
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bundle results = new Bundle();
        //results.putLong("global_alloc_count", Debug.getGlobalAllocCount());
        //results.putLong("global_alloc_size", Debug.getGlobalAllocSize());
        //results.putLong("global_freed_count", Debug.getGlobalFreedCount());
        //results.putLong("global_freed_size", Debug.getGlobalFreedSize());
        //results.putLong("gc_invocation_count", Debug.getGlobalGcInvocationCount());
        //return results;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.138 -0400", hash_original_method = "C29A199041D930C7B60D186159DABF9F", hash_generated_method = "C7CF62E1F26145B7BF38F2B00DAE4445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle getBinderCounts() {
        Bundle results;
        results = new Bundle();
        results.putLong("sent_transactions", Debug.getBinderSentTransactions());
        results.putLong("received_transactions", Debug.getBinderReceivedTransactions());
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bundle results = new Bundle();
        //results.putLong("sent_transactions", Debug.getBinderSentTransactions());
        //results.putLong("received_transactions", Debug.getBinderReceivedTransactions());
        //return results;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.139 -0400", hash_original_method = "2C6BFD417D58A73C3437D9BD22014CB6", hash_generated_method = "514C1FC260B235A8D8D13218376162C5")
    @DSModeled(DSC.SPEC)
    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode) {
        dsTaint.addTaint(contextThread.dsTaint);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        IApplicationThread whoThread;
        whoThread = (IApplicationThread) contextThread;
        {
            {
                int N;
                N = mActivityMonitors.size();
                {
                    int i;
                    i = 0;
                    {
                        ActivityMonitor am;
                        am = mActivityMonitors.get(i);
                        {
                            boolean varCCE938CC8183C61CC0B6CB7B51CCB927_1808137055 = (am.match(who, null, intent));
                            {
                                {
                                    boolean var02966132C31C4B68E0EDCB725C6B30A2_1365726597 = (am.isBlocking());
                                    {
                                        {
                                            Object varE9D9E6868E114AA882D09568A5B00E3E_248809686 = (am.getResult());
                                        } //End flattened ternary
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        try 
        {
            intent.setAllowFds(false);
            int result;
            result = ActivityManagerNative.getDefault()
                .startActivity(whoThread, intent,
                        intent.resolveTypeIfNeeded(who.getContentResolver()),
                        null, 0, token, target != null ? target.mEmbeddedID : null,
                        requestCode, false, false, null, null, false);//DSFIXME:  CODE0008: Nested ternary operator in expression
            checkStartActivityResult(result, intent);
        } //End block
        catch (RemoteException e)
        { }
        return (ActivityResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.139 -0400", hash_original_method = "7F406AB00C6E84903D3FA39AC1C6F8AE", hash_generated_method = "2B2B63FE37279AD6294EBA47A1C821B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void execStartActivities(Context who, IBinder contextThread,
            IBinder token, Activity target, Intent[] intents) {
        dsTaint.addTaint(intents[0].dsTaint);
        dsTaint.addTaint(contextThread.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        IApplicationThread whoThread;
        whoThread = (IApplicationThread) contextThread;
        {
            {
                int N;
                N = mActivityMonitors.size();
                {
                    int i;
                    i = 0;
                    {
                        ActivityMonitor am;
                        am = mActivityMonitors.get(i);
                        {
                            boolean var3B98ADC439434BEC23FECC1F0A621E92_2083333638 = (am.match(who, null, intents[0]));
                            {
                                {
                                    boolean var02966132C31C4B68E0EDCB725C6B30A2_2126250743 = (am.isBlocking());
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        try 
        {
            String[] resolvedTypes;
            resolvedTypes = new String[intents.length];
            {
                int i;
                i = 0;
                {
                    intents[i].setAllowFds(false);
                    resolvedTypes[i] = intents[i].resolveTypeIfNeeded(who.getContentResolver());
                } //End block
            } //End collapsed parenthetic
            int result;
            result = ActivityManagerNative.getDefault()
                .startActivities(whoThread, intents, resolvedTypes, token);
            checkStartActivityResult(result, intents[0]);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.140 -0400", hash_original_method = "D8D9B46CC68EC6EB44E02EECB84F8BB9", hash_generated_method = "447E90329E85984FAA16E460D2E6A794")
    @DSModeled(DSC.SPEC)
    public ActivityResult execStartActivity(
        Context who, IBinder contextThread, IBinder token, Fragment target,
        Intent intent, int requestCode) {
        dsTaint.addTaint(contextThread.dsTaint);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        IApplicationThread whoThread;
        whoThread = (IApplicationThread) contextThread;
        {
            {
                int N;
                N = mActivityMonitors.size();
                {
                    int i;
                    i = 0;
                    {
                        ActivityMonitor am;
                        am = mActivityMonitors.get(i);
                        {
                            boolean varCCE938CC8183C61CC0B6CB7B51CCB927_203603228 = (am.match(who, null, intent));
                            {
                                {
                                    boolean var02966132C31C4B68E0EDCB725C6B30A2_199267913 = (am.isBlocking());
                                    {
                                        {
                                            Object varE9D9E6868E114AA882D09568A5B00E3E_1279492896 = (am.getResult());
                                        } //End flattened ternary
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        try 
        {
            intent.setAllowFds(false);
            int result;
            result = ActivityManagerNative.getDefault()
                .startActivity(whoThread, intent,
                        intent.resolveTypeIfNeeded(who.getContentResolver()),
                        null, 0, token, target != null ? target.mWho : null,
                        requestCode, false, false, null, null, false);//DSFIXME:  CODE0008: Nested ternary operator in expression
            checkStartActivityResult(result, intent);
        } //End block
        catch (RemoteException e)
        { }
        return (ActivityResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.141 -0400", hash_original_method = "B2107F3A70ADB2CB9368A3E0EA3587E6", hash_generated_method = "7CE735C65EF2F798481323B8158A8B24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void init(ActivityThread thread,
            Context instrContext, Context appContext, ComponentName component, 
            IInstrumentationWatcher watcher) {
        dsTaint.addTaint(instrContext.dsTaint);
        dsTaint.addTaint(component.dsTaint);
        dsTaint.addTaint(thread.dsTaint);
        dsTaint.addTaint(watcher.dsTaint);
        dsTaint.addTaint(appContext.dsTaint);
        mMessageQueue = mThread.getLooper().myQueue();
        // ---------- Original Method ----------
        //mThread = thread;
        //mMessageQueue = mThread.getLooper().myQueue();
        //mInstrContext = instrContext;
        //mAppContext = appContext;
        //mComponent = component;
        //mWatcher = watcher;
    }

    
        static void checkStartActivityResult(int res, Object intent) {
        if (res >= IActivityManager.START_SUCCESS) {
            return;
        }
        switch (res) {
            case IActivityManager.START_INTENT_NOT_RESOLVED:
            case IActivityManager.START_CLASS_NOT_FOUND:
                if (intent instanceof Intent && ((Intent)intent).getComponent() != null)
                    throw new ActivityNotFoundException(
                            "Unable to find explicit activity class "
                            + ((Intent)intent).getComponent().toShortString()
                            + "; have you declared this activity in your AndroidManifest.xml?");
                throw new ActivityNotFoundException(
                        "No Activity found to handle " + intent);
            case IActivityManager.START_PERMISSION_DENIED:
                throw new SecurityException("Not allowed to start activity "
                        + intent);
            case IActivityManager.START_FORWARD_AND_REQUEST_CONFLICT:
                throw new AndroidRuntimeException(
                        "FORWARD_RESULT_FLAG used while also requesting a result");
            case IActivityManager.START_NOT_ACTIVITY:
                throw new IllegalArgumentException(
                        "PendingIntent is not an activity");
            default:
                throw new AndroidRuntimeException("Unknown error code "
                        + res + " when starting " + intent);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.141 -0400", hash_original_method = "F94F35385602BE8879B41CCA4D6F8D26", hash_generated_method = "0A117CABFF8A5A331A853E28C19CA6B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void validateNotAppThread() {
        {
            boolean varC58C83EB03E77373FDCB86E705DE7351_110882955 = (ActivityThread.currentActivityThread() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "This method can not be called from the main application thread");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (ActivityThread.currentActivityThread() != null) {
            //throw new RuntimeException(
                //"This method can not be called from the main application thread");
        //}
    }

    
    public static class ActivityMonitor {
        private IntentFilter mWhich;
        private String mClass;
        private ActivityResult mResult;
        private boolean mBlock;
        int mHits = 0;
        Activity mLastActivity = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.142 -0400", hash_original_method = "44AA99B3E06F91C4A28CA95A02F486A4", hash_generated_method = "EA99EB53FDE1D0E5E202C62870B38B64")
        @DSModeled(DSC.SAFE)
        public ActivityMonitor(
            IntentFilter which, ActivityResult result, boolean block) {
            dsTaint.addTaint(result.dsTaint);
            dsTaint.addTaint(which.dsTaint);
            dsTaint.addTaint(block);
            mClass = null;
            // ---------- Original Method ----------
            //mWhich = which;
            //mClass = null;
            //mResult = result;
            //mBlock = block;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.142 -0400", hash_original_method = "96127A12D0FD338A76B8651F7EF76641", hash_generated_method = "20547BB6AF66EB7E7D0B097D26808989")
        @DSModeled(DSC.SAFE)
        public ActivityMonitor(
            String cls, ActivityResult result, boolean block) {
            dsTaint.addTaint(result.dsTaint);
            dsTaint.addTaint(cls);
            dsTaint.addTaint(block);
            mWhich = null;
            // ---------- Original Method ----------
            //mWhich = null;
            //mClass = cls;
            //mResult = result;
            //mBlock = block;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.143 -0400", hash_original_method = "5CEC767AFA0B77CA42139688DDFFE7D0", hash_generated_method = "65AF5C8262CA11F7D0366A3E6B9F8DBB")
        @DSModeled(DSC.SAFE)
        public final IntentFilter getFilter() {
            return (IntentFilter)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mWhich;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.143 -0400", hash_original_method = "907D5A2A73ED7959ACD2198F97C8DDFD", hash_generated_method = "26214D2F234CBFB65EF58D40CFE3A51D")
        @DSModeled(DSC.SAFE)
        public final ActivityResult getResult() {
            return (ActivityResult)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mResult;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.143 -0400", hash_original_method = "6E6027F9B3B42A9863ABB214525B0A55", hash_generated_method = "AE4D9B4D6488C2BC1005FE90009C00E9")
        @DSModeled(DSC.SAFE)
        public final boolean isBlocking() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mBlock;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.144 -0400", hash_original_method = "6A2B57F4CCAF664CD709CE454AF8AF4E", hash_generated_method = "013661E688489E17B335F99852C9384B")
        @DSModeled(DSC.SAFE)
        public final int getHits() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mHits;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.144 -0400", hash_original_method = "1AD813C5DE346D876C42D8A64F1E0FB4", hash_generated_method = "B2F29911A95E1AB80FA5FE1F3F015189")
        @DSModeled(DSC.SAFE)
        public final Activity getLastActivity() {
            return (Activity)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mLastActivity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.144 -0400", hash_original_method = "905168F82A17E43399C57E76AC6D268D", hash_generated_method = "8803C1F7FE2B29606801236E0B079F26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final Activity waitForActivity() {
            {
                {
                    try 
                    {
                        wait();
                    } //End block
                    catch (InterruptedException e)
                    { }
                } //End block
                Activity res;
                res = mLastActivity;
                mLastActivity = null;
            } //End block
            return (Activity)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (this) {
                //while (mLastActivity == null) {
                    //try {
                        //wait();
                    //} catch (InterruptedException e) {
                    //}
                //}
                //Activity res = mLastActivity;
                //mLastActivity = null;
                //return res;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.145 -0400", hash_original_method = "68E343228598567180DC80BCAD1066EC", hash_generated_method = "5A577510B77341268526A0BBEF6BE122")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final Activity waitForActivityWithTimeout(long timeOut) {
            dsTaint.addTaint(timeOut);
            {
                {
                    try 
                    {
                        wait(timeOut);
                    } //End block
                    catch (InterruptedException e)
                    { }
                } //End block
                {
                    Activity res;
                    res = mLastActivity;
                    mLastActivity = null;
                } //End block
            } //End block
            return (Activity)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (this) {
                //if (mLastActivity == null) {
                    //try {
                        //wait(timeOut);
                    //} catch (InterruptedException e) {
                    //}
                //}
                //if (mLastActivity == null) {
                    //return null;
                //} else {
                    //Activity res = mLastActivity;
                    //mLastActivity = null;
                    //return res;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.146 -0400", hash_original_method = "81CE78024E25171646CA4AFCDB286C47", hash_generated_method = "0159A6338B4223BE4AC35950F1F43DBF")
        @DSModeled(DSC.SPEC)
        final boolean match(Context who,
                            Activity activity,
                            Intent intent) {
            dsTaint.addTaint(intent.dsTaint);
            dsTaint.addTaint(activity.dsTaint);
            dsTaint.addTaint(who.dsTaint);
            {
                {
                    boolean var2B7A60CCE4E6911C4A9F4E8793624EF5_1631958705 = (mWhich != null
                    && mWhich.match(who.getContentResolver(), intent,
                                    true, "Instrumentation") < 0);
                } //End collapsed parenthetic
                {
                    String cls;
                    cls = null;
                    {
                        cls = activity.getClass().getName();
                    } //End block
                    {
                        boolean varAC9DF57045B235D222971A1BC52BD87E_735413437 = (intent.getComponent() != null);
                        {
                            cls = intent.getComponent().getClassName();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varAD5F671F79F4CFA6F4D54B486D6F7C93_297217342 = (cls == null || !mClass.equals(cls));
                    } //End collapsed parenthetic
                } //End block
                {
                    notifyAll();
                } //End block
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static final class ActivityResult {
        private int mResultCode;
        private Intent mResultData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.146 -0400", hash_original_method = "C450F5B8EDB38A231DF953C34FD7C745", hash_generated_method = "5A5C87744F5511BF23FCB62A05797460")
        @DSModeled(DSC.SPEC)
        public ActivityResult(int resultCode, Intent resultData) {
            dsTaint.addTaint(resultData.dsTaint);
            dsTaint.addTaint(resultCode);
            // ---------- Original Method ----------
            //mResultCode = resultCode;
            //mResultData = resultData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.147 -0400", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "BAD768340524366FEF2807D356F05C29")
        @DSModeled(DSC.SAFE)
        public int getResultCode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mResultCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.147 -0400", hash_original_method = "230B95D397C0359A2CE808B90BABA149", hash_generated_method = "DF1256D061120CFB7D5876F757919E22")
        @DSModeled(DSC.SPEC)
        public Intent getResultData() {
            return (Intent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mResultData;
        }

        
    }


    
    private final class InstrumentationThread extends Thread {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.147 -0400", hash_original_method = "63270DA70BB76F2F3E4D4969BE7BFAFC", hash_generated_method = "93808E8F900E406D8E5FC16B26350F4A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InstrumentationThread(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.148 -0400", hash_original_method = "801DE955A4997069AEAE1C9E4306FFC2", hash_generated_method = "A2DC881CE165EFE3480B41B106DE6E05")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            IActivityManager am;
            am = ActivityManagerNative.getDefault();
            try 
            {
                Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_DISPLAY);
            } //End block
            catch (RuntimeException e)
            { }
            {
                startPerformanceSnapshot();
            } //End block
            onStart();
            // ---------- Original Method ----------
            //IActivityManager am = ActivityManagerNative.getDefault();
            //try {
                //Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_DISPLAY);
            //} catch (RuntimeException e) {
                //Log.w(TAG, "Exception setting priority of instrumentation thread "                                            
                        //+ Process.myTid(), e);                                                                             
            //}
            //if (mAutomaticPerformanceSnapshots) {
                //startPerformanceSnapshot();
            //}
            //onStart();
        }

        
    }


    
    private static final class EmptyRunnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.148 -0400", hash_original_method = "1F595E4F4D2DB72A1C3042EDDC1398A0", hash_generated_method = "1F595E4F4D2DB72A1C3042EDDC1398A0")
                public EmptyRunnable ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.148 -0400", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "A2E5AE58616EECC7176440E5139E1684")
        @DSModeled(DSC.SAFE)
        public void run() {
            // ---------- Original Method ----------
        }

        
    }


    
    private static final class SyncRunnable implements Runnable {
        private Runnable mTarget;
        private boolean mComplete;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.149 -0400", hash_original_method = "52C4D1F6D6B56C48522BD51EB3CA3671", hash_generated_method = "7C3E6C0638E78D5D5CC441E0AA4BAD75")
        @DSModeled(DSC.SAFE)
        public SyncRunnable(Runnable target) {
            dsTaint.addTaint(target.dsTaint);
            // ---------- Original Method ----------
            //mTarget = target;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.149 -0400", hash_original_method = "44AE594487B622FAC5CF0DF348DF4C16", hash_generated_method = "758B6517728AD22654C0C76D72E99FC6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            mTarget.run();
            {
                mComplete = true;
                notifyAll();
            } //End block
            // ---------- Original Method ----------
            //mTarget.run();
            //synchronized (this) {
                //mComplete = true;
                //notifyAll();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.150 -0400", hash_original_method = "02D1E24DCA4BB39BCA765C3BAB20012A", hash_generated_method = "80681B8394C590665A98C3BD201EA399")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void waitForComplete() {
            {
                {
                    try 
                    {
                        wait();
                    } //End block
                    catch (InterruptedException e)
                    { }
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //while (!mComplete) {
                    //try {
                        //wait();
                    //} catch (InterruptedException e) {
                    //}
                //}
            //}
        }

        
    }


    
    private static final class ActivityWaiter {
        public Intent intent;
        public Activity activity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.150 -0400", hash_original_method = "749CA2F0047E4C5ABC5CE22C281FA095", hash_generated_method = "0105534DB86E7793C8171332A5AD8EDE")
        @DSModeled(DSC.SPEC)
        public ActivityWaiter(Intent _intent) {
            dsTaint.addTaint(_intent.dsTaint);
            // ---------- Original Method ----------
            //intent = _intent;
        }

        
    }


    
    private final class ActivityGoing implements MessageQueue.IdleHandler {
        private ActivityWaiter mWaiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.150 -0400", hash_original_method = "C941F219CD1DB06313DFA66C54B64070", hash_generated_method = "185A400ED7BAAA9C39C8B8FF3C397680")
        @DSModeled(DSC.SAFE)
        public ActivityGoing(ActivityWaiter waiter) {
            dsTaint.addTaint(waiter.dsTaint);
            // ---------- Original Method ----------
            //mWaiter = waiter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.151 -0400", hash_original_method = "6BEF536DFBCFB4C74EC4C0EA4FEAD5BE", hash_generated_method = "125B95F1CEB2142997E6A60FAB4F34AE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean queueIdle() {
            {
                mWaitingActivities.remove(mWaiter);
                mSync.notifyAll();
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mSync) {
                //mWaitingActivities.remove(mWaiter);
                //mSync.notifyAll();
            //}
            //return false;
        }

        
    }


    
    private static final class Idler implements MessageQueue.IdleHandler {
        private Runnable mCallback;
        private boolean mIdle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.151 -0400", hash_original_method = "4434628995BB6492F17F2A3E55C00ABF", hash_generated_method = "9194FACB9C9FAC3CF6F410C3B883DCA0")
        @DSModeled(DSC.SAFE)
        public Idler(Runnable callback) {
            dsTaint.addTaint(callback.dsTaint);
            mIdle = false;
            // ---------- Original Method ----------
            //mCallback = callback;
            //mIdle = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.152 -0400", hash_original_method = "B0AE6A8D5B64501509EFCE6FDAF91034", hash_generated_method = "1050B70CF871A09C9D0E33C0CC2F0D89")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean queueIdle() {
            {
                mCallback.run();
            } //End block
            {
                mIdle = true;
                notifyAll();
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //mCallback.run();
            //}
            //synchronized (this) {
                //mIdle = true;
                //notifyAll();
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.152 -0400", hash_original_method = "DF4D50EB6BB518BE09549DCD9C0630C1", hash_generated_method = "4A208046355C9EDFEB0932DA3228259F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void waitForIdle() {
            {
                {
                    try 
                    {
                        wait();
                    } //End block
                    catch (InterruptedException e)
                    { }
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //while (!mIdle) {
                    //try {
                        //wait();
                    //} catch (InterruptedException e) {
                    //}
                //}
            //}
        }

        
    }


    
    public static final String REPORT_KEY_IDENTIFIER = "id";
    public static final String REPORT_KEY_STREAMRESULT = "stream";
    private static final String TAG = "Instrumentation";
}

