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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.941 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")

    private final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.941 -0400", hash_original_field = "4637F257714ED0010AAAD4B2D42CA0B5", hash_generated_field = "4DECD94BE6B0174DE36067CBF50C84C9")

    private ActivityThread mThread = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.941 -0400", hash_original_field = "707EC1AFA46D7EA72081360AA30DB33B", hash_generated_field = "EE117464CCFBB71A57DA2F8BADEB6233")

    private MessageQueue mMessageQueue = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.941 -0400", hash_original_field = "76CA776B9484D9843D577178FB774E92", hash_generated_field = "CF9AE987035AAD94FADA826204456158")

    private Context mInstrContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.941 -0400", hash_original_field = "5ABA4A253E78386295F297E632FF4E34", hash_generated_field = "722D46A23A9E453AC7AC6D5797C29418")

    private Context mAppContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.941 -0400", hash_original_field = "C0386E973BB6E008B1720A8BB4936F69", hash_generated_field = "1B40E7C57A0B1682389BAE16521C0844")

    private ComponentName mComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.942 -0400", hash_original_field = "22D8CE98A01A307983EC97778B73FE9E", hash_generated_field = "83CDC5A21BC91E43BA3B83822ED24524")

    private Thread mRunner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.942 -0400", hash_original_field = "7848C7EA0F7A7B533B80748240896F3F", hash_generated_field = "A6C142CC3F6E6296AB67C595830F5086")

    private List<ActivityWaiter> mWaitingActivities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.942 -0400", hash_original_field = "BBA184EA143905687B1CBD1ABA6B112A", hash_generated_field = "5A3BE51583B9275D70583A158D75384D")

    private List<ActivityMonitor> mActivityMonitors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.942 -0400", hash_original_field = "47CD6CB6B9A4FA63425D0BEAFAF438EE", hash_generated_field = "BD19A60B1E71F2A79E53A58C34F52CB2")

    private IInstrumentationWatcher mWatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.942 -0400", hash_original_field = "7535B9020CF0E0D6F2F2FC2C55D5D303", hash_generated_field = "C00E68D542ECF5CA8FC17F9FED17FEEA")

    private boolean mAutomaticPerformanceSnapshots = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.942 -0400", hash_original_field = "99E4031EB7E21B827C92C62233E4B425", hash_generated_field = "68DE569686980EC11F79E2F9C9488F60")

    private PerformanceCollector mPerformanceCollector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.942 -0400", hash_original_field = "0A173F6C54C8DC69EF40909480126796", hash_generated_field = "74370D5BDE597F43882751037480C6FB")

    private Bundle mPerfMetrics = new Bundle();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.943 -0400", hash_original_method = "2A2FEB9F4AAE35A924F5C88DA8F6FDF1", hash_generated_method = "05D8623C11D87D684B7E40B654AAAA52")
    public  Instrumentation() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.943 -0400", hash_original_method = "4B024CDE66137DA3ED66BF57127A0E80", hash_generated_method = "618433C04A9C5C61D907C7BAF3E63003")
    public void onCreate(Bundle arguments) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(arguments.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.943 -0400", hash_original_method = "75096E18A1A48E91D30DD9D6FBFD5D1F", hash_generated_method = "B182D72CA75E106C7C1742F3754E710E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.944 -0400", hash_original_method = "0451E38101EC2D69951E664FB36904F0", hash_generated_method = "C270D6AECB942165605F46F9C723CFA1")
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.945 -0400", hash_original_method = "8DC9492B498FF3067475C41C79EEAB3B", hash_generated_method = "96FC526C982913C690CC586473556A88")
    public boolean onException(Object obj, Throwable e) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(obj.getTaint());
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1844120824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1844120824;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.946 -0400", hash_original_method = "5CE1AB9DF7D7162F89956B1D13BE745E", hash_generated_method = "D4818A205F156CAA9C45B295CCAFA19A")
    public void sendStatus(int resultCode, Bundle results) {
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
        addTaint(resultCode);
        addTaint(results.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.946 -0400", hash_original_method = "93CEFEE99BA727186FFD22BEC1D0D072", hash_generated_method = "8205AFADB160065CDF62F281C6ABBFF0")
    public void finish(int resultCode, Bundle results) {
        {
            endPerformanceSnapshot();
        } //End block
        {
            results.putAll(mPerfMetrics);
        } //End block
        mThread.finishInstrumentation(resultCode, results);
        addTaint(resultCode);
        addTaint(results.getTaint());
        // ---------- Original Method ----------
        //if (mAutomaticPerformanceSnapshots) {
            //endPerformanceSnapshot();
        //}
        //if (mPerfMetrics != null) {
            //results.putAll(mPerfMetrics);
        //}
        //mThread.finishInstrumentation(resultCode, results);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.947 -0400", hash_original_method = "6EB9EED76498D1668A96326FD6FFBEE9", hash_generated_method = "FD3545546835D20A0C087ACC19F8773F")
    public void setAutomaticPerformanceSnapshots() {
        mAutomaticPerformanceSnapshots = true;
        mPerformanceCollector = new PerformanceCollector();
        // ---------- Original Method ----------
        //mAutomaticPerformanceSnapshots = true;
        //mPerformanceCollector = new PerformanceCollector();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.947 -0400", hash_original_method = "59F6F337F904783653DF79F6C5B4E5AA", hash_generated_method = "51E467EEE62EB5C8791BF96B2E00AF17")
    public void startPerformanceSnapshot() {
        {
            boolean var32F63117AA68B41701446BAB1196A3B6_1342016254 = (!isProfiling());
            {
                mPerformanceCollector.beginSnapshot(null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isProfiling()) {
            //mPerformanceCollector.beginSnapshot(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.948 -0400", hash_original_method = "8BB380F00D03C999D4B5625E8ECD5AAA", hash_generated_method = "E4B85EAEBCFE471E81A63A5B6D3D1AF6")
    public void endPerformanceSnapshot() {
        {
            boolean var32F63117AA68B41701446BAB1196A3B6_6023986 = (!isProfiling());
            {
                mPerfMetrics = mPerformanceCollector.endSnapshot();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isProfiling()) {
            //mPerfMetrics = mPerformanceCollector.endSnapshot();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.948 -0400", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "E5C4FFF396F837C85A1D40A9B232BFA0")
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.949 -0400", hash_original_method = "0612F59C08E6EE31E243F52D2CCB68AA", hash_generated_method = "3DDCD57A3409851492A8EA23FA22B677")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1567854033 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1567854033 = mInstrContext;
        varB4EAC82CA7396A68D541C85D26508E83_1567854033.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1567854033;
        // ---------- Original Method ----------
        //return mInstrContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.949 -0400", hash_original_method = "6C1D36E28C0C97736EA4779A7FB1715C", hash_generated_method = "7AFA0E70529C794AB1A5C17D9100D0B3")
    public ComponentName getComponentName() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1923153523 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1923153523 = mComponent;
        varB4EAC82CA7396A68D541C85D26508E83_1923153523.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1923153523;
        // ---------- Original Method ----------
        //return mComponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.950 -0400", hash_original_method = "D1026223DF11B7056861FB0AA4B64828", hash_generated_method = "C0C62B484AF91FDB6BF40FE5582635E7")
    public Context getTargetContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_637648277 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_637648277 = mAppContext;
        varB4EAC82CA7396A68D541C85D26508E83_637648277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_637648277;
        // ---------- Original Method ----------
        //return mAppContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.951 -0400", hash_original_method = "7D34AF538E9A67DEA76272AB02F2CDC6", hash_generated_method = "D2219E19121141ECDFB18C45DC210787")
    public boolean isProfiling() {
        boolean var2E415148C7B7470B2B3A38C816E662AA_2065144272 = (mThread.isProfiling());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654311870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654311870;
        // ---------- Original Method ----------
        //return mThread.isProfiling();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.951 -0400", hash_original_method = "988500FDA3CAE61033EABAD95C8BF0F1", hash_generated_method = "AD00AFB3F3469DF7B89429EC4949B180")
    public void startProfiling() {
        {
            boolean var293A0446960E74ADC95BC62CEC42A6FA_109388529 = (mThread.isProfiling());
            {
                File file = new File(mThread.getProfileFilePath());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.952 -0400", hash_original_method = "1FEC2A39C917937DB00CBC5BA91E5501", hash_generated_method = "68E251CE612A90B1601BD75AFA05AB62")
    public void stopProfiling() {
        {
            boolean var293A0446960E74ADC95BC62CEC42A6FA_1904501188 = (mThread.isProfiling());
            {
                Debug.stopMethodTracing();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mThread.isProfiling()) {
            //Debug.stopMethodTracing();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.953 -0400", hash_original_method = "EEC5F78C5E75C7158C64611E1694E1A0", hash_generated_method = "300D118A40BB5CA34857122238A4EB41")
    public void setInTouchMode(boolean inTouch) {
        try 
        {
            IWindowManager.Stub.asInterface(
                    ServiceManager.getService("window")).setInTouchMode(inTouch);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(inTouch);
        // ---------- Original Method ----------
        //try {
            //IWindowManager.Stub.asInterface(
                    //ServiceManager.getService("window")).setInTouchMode(inTouch);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.953 -0400", hash_original_method = "9CBDEDF34C527A410521706D53450B12", hash_generated_method = "CEDA8A58C245D7BB85E438F0FFA8E60F")
    public void waitForIdle(Runnable recipient) {
        mMessageQueue.addIdleHandler(new Idler(recipient));
        mThread.getHandler().post(new EmptyRunnable());
        addTaint(recipient.getTaint());
        // ---------- Original Method ----------
        //mMessageQueue.addIdleHandler(new Idler(recipient));
        //mThread.getHandler().post(new EmptyRunnable());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.954 -0400", hash_original_method = "89AA1CC3D27AC9ADF27421ED4392817A", hash_generated_method = "FAD81B4FE8B64782BCCD8ABCBD6F0562")
    public void waitForIdleSync() {
        validateNotAppThread();
        Idler idler = new Idler(null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.956 -0400", hash_original_method = "23FE2246FE60A7859CD93D836CF467DE", hash_generated_method = "D0E2819D16AFFDF8AFF69957AE490A8E")
    public void runOnMainSync(Runnable runner) {
        validateNotAppThread();
        SyncRunnable sr = new SyncRunnable(runner);
        mThread.getHandler().post(sr);
        sr.waitForComplete();
        addTaint(runner.getTaint());
        // ---------- Original Method ----------
        //validateNotAppThread();
        //SyncRunnable sr = new SyncRunnable(runner);
        //mThread.getHandler().post(sr);
        //sr.waitForComplete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.959 -0400", hash_original_method = "834B647755C86ED587A771C499B38AF8", hash_generated_method = "29ED5F3D06B9852D8B69F2CA8A3C8094")
    public Activity startActivitySync(Intent intent) {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1628660408 = null; //Variable for return #1
        validateNotAppThread();
        {
            intent = new Intent(intent);
            ActivityInfo ai = intent.resolveActivityInfo(
                getTargetContext().getPackageManager(), 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unable to resolve activity for: " + intent);
            } //End block
            String myProc = mThread.getProcessName();
            {
                boolean varD8D363FC173629EAE19D3F60EB68E1B8_1669819081 = (!ai.processName.equals(myProc));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Intent in process "
                        + myProc + " resolved to different process "
                        + ai.processName + ": " + intent);
                } //End block
            } //End collapsed parenthetic
            intent.setComponent(new ComponentName(
                    ai.applicationInfo.packageName, ai.name));
            final ActivityWaiter aw = new ActivityWaiter(intent);
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
                boolean var58BADEC5202E1F9ECFC4CA15E819048E_2055441628 = (mWaitingActivities.contains(aw));
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1628660408 = aw.activity;
        } //End block
        addTaint(intent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1628660408.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1628660408;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.960 -0400", hash_original_method = "608AF20D37ADB77B72D35062305FF16B", hash_generated_method = "577C51DA0E431FB7DDDB8A74F6232B32")
    public void addMonitor(ActivityMonitor monitor) {
        {
            {
                mActivityMonitors = new ArrayList();
            } //End block
            mActivityMonitors.add(monitor);
        } //End block
        addTaint(monitor.getTaint());
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mActivityMonitors == null) {
                //mActivityMonitors = new ArrayList();
            //}
            //mActivityMonitors.add(monitor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.961 -0400", hash_original_method = "A7BDDA46B206533FE67A2A87AD7D2268", hash_generated_method = "A7045D64051987250EDED186F091826E")
    public ActivityMonitor addMonitor(
        IntentFilter filter, ActivityResult result, boolean block) {
        ActivityMonitor varB4EAC82CA7396A68D541C85D26508E83_29378346 = null; //Variable for return #1
        ActivityMonitor am = new ActivityMonitor(filter, result, block);
        addMonitor(am);
        varB4EAC82CA7396A68D541C85D26508E83_29378346 = am;
        addTaint(filter.getTaint());
        addTaint(result.getTaint());
        addTaint(block);
        varB4EAC82CA7396A68D541C85D26508E83_29378346.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_29378346;
        // ---------- Original Method ----------
        //ActivityMonitor am = new ActivityMonitor(filter, result, block);
        //addMonitor(am);
        //return am;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.963 -0400", hash_original_method = "1AE73A4BC3EDE4468A3DB90D9129EBCC", hash_generated_method = "1C35150EF370EB0D52CA182E295706EC")
    public ActivityMonitor addMonitor(
        String cls, ActivityResult result, boolean block) {
        ActivityMonitor varB4EAC82CA7396A68D541C85D26508E83_1391413077 = null; //Variable for return #1
        ActivityMonitor am = new ActivityMonitor(cls, result, block);
        addMonitor(am);
        varB4EAC82CA7396A68D541C85D26508E83_1391413077 = am;
        addTaint(cls.getTaint());
        addTaint(result.getTaint());
        addTaint(block);
        varB4EAC82CA7396A68D541C85D26508E83_1391413077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1391413077;
        // ---------- Original Method ----------
        //ActivityMonitor am = new ActivityMonitor(cls, result, block);
        //addMonitor(am);
        //return am;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.964 -0400", hash_original_method = "29E7A5CE85EC83DC1A6299DE5A3CFA02", hash_generated_method = "CF86D70E8427B77730AF331CD506B127")
    public boolean checkMonitorHit(ActivityMonitor monitor, int minHits) {
        waitForIdleSync();
        {
            {
                boolean varFAB6AF39377D40587098ED5F1691D051_590910605 = (monitor.getHits() < minHits);
            } //End collapsed parenthetic
            mActivityMonitors.remove(monitor);
        } //End block
        addTaint(monitor.getTaint());
        addTaint(minHits);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704520950 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_704520950;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.967 -0400", hash_original_method = "ACAA082ACBE3DC4BF5F5B838A83827D9", hash_generated_method = "DC89771EC29EA7CDD51B4D35B2394044")
    public Activity waitForMonitor(ActivityMonitor monitor) {
        Activity varB4EAC82CA7396A68D541C85D26508E83_511029291 = null; //Variable for return #1
        Activity activity = monitor.waitForActivity();
        {
            mActivityMonitors.remove(monitor);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_511029291 = activity;
        addTaint(monitor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_511029291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_511029291;
        // ---------- Original Method ----------
        //Activity activity = monitor.waitForActivity();
        //synchronized (mSync) {
            //mActivityMonitors.remove(monitor);
        //}
        //return activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.969 -0400", hash_original_method = "C35EC81162DCBEC6CBBF630B6FBC9A38", hash_generated_method = "50BC36340480EBFF374C65AC98E3C249")
    public Activity waitForMonitorWithTimeout(ActivityMonitor monitor, long timeOut) {
        Activity varB4EAC82CA7396A68D541C85D26508E83_555275181 = null; //Variable for return #1
        Activity activity = monitor.waitForActivityWithTimeout(timeOut);
        {
            mActivityMonitors.remove(monitor);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_555275181 = activity;
        addTaint(monitor.getTaint());
        addTaint(timeOut);
        varB4EAC82CA7396A68D541C85D26508E83_555275181.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_555275181;
        // ---------- Original Method ----------
        //Activity activity = monitor.waitForActivityWithTimeout(timeOut);
        //synchronized (mSync) {
            //mActivityMonitors.remove(monitor);
        //}
        //return activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.970 -0400", hash_original_method = "667CF28A3BE8CF2696555BC3512917A7", hash_generated_method = "A2DE57E536FC83980F9166A0B97DB08E")
    public void removeMonitor(ActivityMonitor monitor) {
        {
            mActivityMonitors.remove(monitor);
        } //End block
        addTaint(monitor.getTaint());
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //mActivityMonitors.remove(monitor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.973 -0400", hash_original_method = "4D155A3E8D909DAB8A4322BEF2D5BDFA", hash_generated_method = "9E32D9F958AC5BF60234089A76C9A22E")
    public boolean invokeMenuActionSync(Activity targetActivity, 
                                    int id, int flag) {
        class MenuRunnable implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.971 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "073B8C8E0ED83C0B182572C1444991DD")
            private Activity activity;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.971 -0400", hash_original_field = "F393F3F5E496869A15BC72CBFD56F541", hash_generated_field = "17A8B79B91E5A599D96EB04B1C01F867")
            private int identifier;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.971 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")
            private int flags;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.972 -0400", hash_original_field = "A7E53CE21691AB073D9660D615818899", hash_generated_field = "ECDF201421EBB4A2C3D7973F567DB5B7")
            boolean returnValue;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.972 -0400", hash_original_method = "29927998E9364A9B4F18182584446309", hash_generated_method = "8142DFAED140D1033B368E771D8BFCFF")
            public  MenuRunnable(Activity _activity, int _identifier,
                                    int _flags) {
                activity = _activity;
                identifier = _identifier;
                flags = _flags;
                // ---------- Original Method ----------
                //activity = _activity;
                //identifier = _identifier;
                //flags = _flags;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.973 -0400", hash_original_method = "76921810C67DCF51EE72D55418C1BAD6", hash_generated_method = "B274A9643CC50A64CA3C45222D0853E3")
            public void run() {
                Window win = activity.getWindow();
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
        MenuRunnable mr = new MenuRunnable(targetActivity, id, flag);
        runOnMainSync(mr);
        addTaint(targetActivity.getTaint());
        addTaint(id);
        addTaint(flag);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400811757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400811757;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.977 -0400", hash_original_method = "28CE40BD9E15A522E886C67E234DD689", hash_generated_method = "5398F1C7D216454876630F1DB4924E5D")
    public boolean invokeContextMenuAction(Activity targetActivity, int id, int flag) {
        validateNotAppThread();
        final KeyEvent downEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_CENTER);
        sendKeySync(downEvent);
        waitForIdleSync();
        try 
        {
            Thread.sleep(ViewConfiguration.getLongPressTimeout());
        } //End block
        catch (InterruptedException e)
        { }
        final KeyEvent upEvent = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_CENTER);
        sendKeySync(upEvent);
        waitForIdleSync();
        class ContextMenuRunnable implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.974 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "073B8C8E0ED83C0B182572C1444991DD")
            private Activity activity;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.974 -0400", hash_original_field = "F393F3F5E496869A15BC72CBFD56F541", hash_generated_field = "17A8B79B91E5A599D96EB04B1C01F867")
            private int identifier;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.975 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")
            private int flags;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.975 -0400", hash_original_field = "A7E53CE21691AB073D9660D615818899", hash_generated_field = "ECDF201421EBB4A2C3D7973F567DB5B7")
            boolean returnValue;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.976 -0400", hash_original_method = "798263D9D537A1153607D5F0FAA29A33", hash_generated_method = "573F59F2075A6B0930120A804295896E")
            public  ContextMenuRunnable(Activity _activity, int _identifier,
                                    int _flags) {
                activity = _activity;
                identifier = _identifier;
                flags = _flags;
                // ---------- Original Method ----------
                //activity = _activity;
                //identifier = _identifier;
                //flags = _flags;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.976 -0400", hash_original_method = "E7EE26BA0D2735345FDDDF8FC2DD3A31", hash_generated_method = "FB3E45218CBDCD4E0D1EBA5F331EC332")
            public void run() {
                Window win = activity.getWindow();
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
        ContextMenuRunnable cmr = new ContextMenuRunnable(targetActivity, id, flag);
        runOnMainSync(cmr);
        addTaint(targetActivity.getTaint());
        addTaint(id);
        addTaint(flag);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1690284172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1690284172;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.978 -0400", hash_original_method = "029397BC692B989F9FCA48D48FDB9479", hash_generated_method = "114E965462C6F224B7BA99C47B33F57F")
    public void sendStringSync(String text) {
        KeyCharacterMap keyCharacterMap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
        KeyEvent[] events = keyCharacterMap.getEvents(text.toCharArray());
        {
            {
                int i = 0;
                {
                    sendKeySync(events[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(text.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.979 -0400", hash_original_method = "8EB82A3200B456D290A2F7A26355BB76", hash_generated_method = "AFCB28CB5E9F75D7A6B44ED0BE93CC41")
    public void sendKeySync(KeyEvent event) {
        validateNotAppThread();
        try 
        {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectKeyEvent(event, true);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //validateNotAppThread();
        //try {
            //(IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                //.injectKeyEvent(event, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.980 -0400", hash_original_method = "EAB0936DFBB6258C56105993043121F1", hash_generated_method = "521535D7E54F3495BC845B45D4BC210D")
    public void sendKeyDownUpSync(int key) {
        sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, key));
        sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, key));
        addTaint(key);
        // ---------- Original Method ----------
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, key));
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, key));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.981 -0400", hash_original_method = "481470F7D6C4847394865E9F06AE8ED8", hash_generated_method = "60406F2FA3D4B8925F58A19F6A7651F3")
    public void sendCharacterSync(int keyCode) {
        sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
        sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, keyCode));
        addTaint(keyCode);
        // ---------- Original Method ----------
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, keyCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.981 -0400", hash_original_method = "B9A3EF31E8BF5F99FCCA686BC6658BE3", hash_generated_method = "1A60C213A497FBE68119315B9BB4B082")
    public void sendPointerSync(MotionEvent event) {
        validateNotAppThread();
        try 
        {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectPointerEvent(event, true);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //validateNotAppThread();
        //try {
            //(IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                //.injectPointerEvent(event, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.982 -0400", hash_original_method = "6B2ECCD3AB22E94B5B1243023E902F6D", hash_generated_method = "3C59BAF087A5F3AECBD5B27CC60E406F")
    public void sendTrackballEventSync(MotionEvent event) {
        validateNotAppThread();
        try 
        {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectTrackballEvent(event, true);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //validateNotAppThread();
        //try {
            //(IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                //.injectTrackballEvent(event, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.983 -0400", hash_original_method = "1A9EF24656896AC4FCE906BFB43593E0", hash_generated_method = "FE1A8E70921FF33EE11731AC18BC1C75")
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, 
            ClassNotFoundException {
        Application varB4EAC82CA7396A68D541C85D26508E83_1428887012 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1428887012 = newApplication(cl.loadClass(className), context);
        addTaint(cl.getTaint());
        addTaint(className.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1428887012.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1428887012;
        // ---------- Original Method ----------
        //return newApplication(cl.loadClass(className), context);
    }

    
    static public Application newApplication(Class<?> clazz, Context context) throws InstantiationException, IllegalAccessException, 
            ClassNotFoundException {
        Application app = (Application)clazz.newInstance();
        app.attach(context);
        return app;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.984 -0400", hash_original_method = "3D967D3E47594084D340D0FEDC81A2D2", hash_generated_method = "B55875D0FBBEE31B0C0F25B5C3A201C0")
    public void callApplicationOnCreate(Application app) {
        app.onCreate();
        addTaint(app.getTaint());
        // ---------- Original Method ----------
        //app.onCreate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.985 -0400", hash_original_method = "A9111F868862B9E251C99947D42ADECF", hash_generated_method = "2ECAFFECF709AF496DAD056DBC5B4A18")
    public Activity newActivity(Class<?> clazz, Context context, 
            IBinder token, Application application, Intent intent, ActivityInfo info, 
            CharSequence title, Activity parent, String id,
            Object lastNonConfigurationInstance) throws InstantiationException, 
            IllegalAccessException {
        Activity varB4EAC82CA7396A68D541C85D26508E83_299615300 = null; //Variable for return #1
        Activity activity = (Activity)clazz.newInstance();
        ActivityThread aThread = null;
        activity.attach(context, aThread, this, token, application, intent,
                info, title, parent, id,
                (Activity.NonConfigurationInstances)lastNonConfigurationInstance,
                new Configuration());
        varB4EAC82CA7396A68D541C85D26508E83_299615300 = activity;
        addTaint(clazz.getTaint());
        addTaint(context.getTaint());
        addTaint(token.getTaint());
        addTaint(application.getTaint());
        addTaint(intent.getTaint());
        addTaint(info.getTaint());
        addTaint(title.getTaint());
        addTaint(parent.getTaint());
        addTaint(id.getTaint());
        addTaint(lastNonConfigurationInstance.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_299615300.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_299615300;
        // ---------- Original Method ----------
        //Activity activity = (Activity)clazz.newInstance();
        //ActivityThread aThread = null;
        //activity.attach(context, aThread, this, token, application, intent,
                //info, title, parent, id,
                //(Activity.NonConfigurationInstances)lastNonConfigurationInstance,
                //new Configuration());
        //return activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.987 -0400", hash_original_method = "67A9E29CAF7C169812898E8BB0812F51", hash_generated_method = "05D40FC2596C5E5C1771B72B76D3DFFB")
    public Activity newActivity(ClassLoader cl, String className,
            Intent intent) throws InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        Activity varB4EAC82CA7396A68D541C85D26508E83_662968469 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_662968469 = (Activity)cl.loadClass(className).newInstance();
        addTaint(cl.getTaint());
        addTaint(className.getTaint());
        addTaint(intent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_662968469.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_662968469;
        // ---------- Original Method ----------
        //return (Activity)cl.loadClass(className).newInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.989 -0400", hash_original_method = "5B22BAF104CC01C4555866A70EB5D211", hash_generated_method = "6F0DEF6C18206492E6E1DDA89733E9DE")
    public void callActivityOnCreate(Activity activity, Bundle icicle) {
        {
            {
                final int N = mWaitingActivities.size();
                {
                    int i = 0;
                    {
                        final ActivityWaiter aw = mWaitingActivities.get(i);
                        final Intent intent = aw.intent;
                        {
                            boolean var342D97B360658057F9A6B74D7AD8662E_406808467 = (intent.filterEquals(activity.getIntent()));
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
                final int N = mActivityMonitors.size();
                {
                    int i = 0;
                    {
                        final ActivityMonitor am = mActivityMonitors.get(i);
                        am.match(activity, activity, activity.getIntent());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(activity.getTaint());
        addTaint(icicle.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.990 -0400", hash_original_method = "ACD4ACDF1D4AD87F23B45E29C987968F", hash_generated_method = "44CE7D4D7B41377AF364C3258AF4F415")
    public void callActivityOnDestroy(Activity activity) {
        activity.performDestroy();
        {
            {
                final int N = mActivityMonitors.size();
                {
                    int i = 0;
                    {
                        final ActivityMonitor am = mActivityMonitors.get(i);
                        am.match(activity, activity, activity.getIntent());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(activity.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.991 -0400", hash_original_method = "E084363C345B4BF61D861FC0D5D07D15", hash_generated_method = "9D42CB5515ED1313D7668D591A258C9A")
    public void callActivityOnRestoreInstanceState(Activity activity, Bundle savedInstanceState) {
        activity.performRestoreInstanceState(savedInstanceState);
        addTaint(activity.getTaint());
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //activity.performRestoreInstanceState(savedInstanceState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.992 -0400", hash_original_method = "2BECA7ACE9ECA4B1DD0299ACB1DA09B9", hash_generated_method = "C9B6BD1B12026D85189A35803EB74B7D")
    public void callActivityOnPostCreate(Activity activity, Bundle icicle) {
        activity.onPostCreate(icicle);
        addTaint(activity.getTaint());
        addTaint(icicle.getTaint());
        // ---------- Original Method ----------
        //activity.onPostCreate(icicle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.992 -0400", hash_original_method = "5C607C7DDC680DB12532E9DB6F9CBC1F", hash_generated_method = "0EEBC340D57C7E6518EB586C232BD876")
    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        activity.onNewIntent(intent);
        addTaint(activity.getTaint());
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //activity.onNewIntent(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.993 -0400", hash_original_method = "92E54A7AE2339DA4EE7A292F370BB21D", hash_generated_method = "554EB5A4520460660AA3F42344B1C8FD")
    public void callActivityOnStart(Activity activity) {
        activity.onStart();
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //activity.onStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.994 -0400", hash_original_method = "85BE14FC295678CF247F9E472F613652", hash_generated_method = "F81A82B2836C4CBF9E725712F2A963F9")
    public void callActivityOnRestart(Activity activity) {
        activity.onRestart();
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //activity.onRestart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.994 -0400", hash_original_method = "7A6C498E491E406F2D113F8023D1483F", hash_generated_method = "A6B8AC63E3112084FBF288CEF24E7E86")
    public void callActivityOnResume(Activity activity) {
        activity.mResumed = true;
        activity.onResume();
        {
            {
                final int N = mActivityMonitors.size();
                {
                    int i = 0;
                    {
                        final ActivityMonitor am = mActivityMonitors.get(i);
                        am.match(activity, activity, activity.getIntent());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(activity.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.995 -0400", hash_original_method = "0F89D6C7937A191011A20B47DB6599C5", hash_generated_method = "1189581813D9C9819DCD7CC6B0E64CB5")
    public void callActivityOnStop(Activity activity) {
        activity.onStop();
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //activity.onStop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.995 -0400", hash_original_method = "E8ECFB0E3E7F6A98F4E3FE19FF7167B5", hash_generated_method = "1A8D5BE74ACF04B409C603F102E3B321")
    public void callActivityOnSaveInstanceState(Activity activity, Bundle outState) {
        activity.performSaveInstanceState(outState);
        addTaint(activity.getTaint());
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //activity.performSaveInstanceState(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.996 -0400", hash_original_method = "A3AB5C16D17E1593B1F616581634810F", hash_generated_method = "6062393471488A2A01653C693744852E")
    public void callActivityOnPause(Activity activity) {
        activity.performPause();
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //activity.performPause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.997 -0400", hash_original_method = "436C260B8868F376171ACCB198E870A3", hash_generated_method = "5702568A951EAAE17722ADC22F79515D")
    public void callActivityOnUserLeaving(Activity activity) {
        activity.performUserLeaving();
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //activity.performUserLeaving();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.999 -0400", hash_original_method = "7FDB53D95055F8344C6717BAA41CDD62", hash_generated_method = "30C2B3835BA32D0C19AF35DC83FE7525")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.000 -0400", hash_original_method = "0DC5272531C251864B2A214C154F0F7A", hash_generated_method = "D46BBBE387BBBBD9A6E2A4FED2A36980")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.001 -0400", hash_original_method = "8051F011270999D9228A08818EFD61DD", hash_generated_method = "4068EA2EE1C04D8796A6974A1C038107")
    private void addValue(String key, int value, Bundle results) {
        {
            boolean var995B4440ACB6664962C911ABBA2A083D_214705719 = (results.containsKey(key));
            {
                List<Integer> list = results.getIntegerArrayList(key);
                {
                    list.add(value);
                } //End block
            } //End block
            {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(value);
                results.putIntegerArrayList(key, list);
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        addTaint(value);
        addTaint(results.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.002 -0400", hash_original_method = "733DA96DDB5CBA410EC33155388CAA51", hash_generated_method = "FEFF1A66827CA6769D02394B805A944C")
    public Bundle getAllocCounts() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_363810540 = null; //Variable for return #1
        Bundle results = new Bundle();
        results.putLong("global_alloc_count", Debug.getGlobalAllocCount());
        results.putLong("global_alloc_size", Debug.getGlobalAllocSize());
        results.putLong("global_freed_count", Debug.getGlobalFreedCount());
        results.putLong("global_freed_size", Debug.getGlobalFreedSize());
        results.putLong("gc_invocation_count", Debug.getGlobalGcInvocationCount());
        varB4EAC82CA7396A68D541C85D26508E83_363810540 = results;
        varB4EAC82CA7396A68D541C85D26508E83_363810540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_363810540;
        // ---------- Original Method ----------
        //Bundle results = new Bundle();
        //results.putLong("global_alloc_count", Debug.getGlobalAllocCount());
        //results.putLong("global_alloc_size", Debug.getGlobalAllocSize());
        //results.putLong("global_freed_count", Debug.getGlobalFreedCount());
        //results.putLong("global_freed_size", Debug.getGlobalFreedSize());
        //results.putLong("gc_invocation_count", Debug.getGlobalGcInvocationCount());
        //return results;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.003 -0400", hash_original_method = "C29A199041D930C7B60D186159DABF9F", hash_generated_method = "BE488FB6489D224C927EBB9BF1A1175F")
    public Bundle getBinderCounts() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_374764866 = null; //Variable for return #1
        Bundle results = new Bundle();
        results.putLong("sent_transactions", Debug.getBinderSentTransactions());
        results.putLong("received_transactions", Debug.getBinderReceivedTransactions());
        varB4EAC82CA7396A68D541C85D26508E83_374764866 = results;
        varB4EAC82CA7396A68D541C85D26508E83_374764866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_374764866;
        // ---------- Original Method ----------
        //Bundle results = new Bundle();
        //results.putLong("sent_transactions", Debug.getBinderSentTransactions());
        //results.putLong("received_transactions", Debug.getBinderReceivedTransactions());
        //return results;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.004 -0400", hash_original_method = "2C6BFD417D58A73C3437D9BD22014CB6", hash_generated_method = "12DC5467C52538D1276CB5367582E1DB")
    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode) {
        ActivityResult varB4EAC82CA7396A68D541C85D26508E83_837935339 = null; //Variable for return #1
        ActivityResult varB4EAC82CA7396A68D541C85D26508E83_125433505 = null; //Variable for return #2
        IApplicationThread whoThread = (IApplicationThread) contextThread;
        {
            {
                final int N = mActivityMonitors.size();
                {
                    int i = 0;
                    {
                        final ActivityMonitor am = mActivityMonitors.get(i);
                        {
                            boolean varCCE938CC8183C61CC0B6CB7B51CCB927_924755795 = (am.match(who, null, intent));
                            {
                                {
                                    boolean var02966132C31C4B68E0EDCB725C6B30A2_1524112812 = (am.isBlocking());
                                    {
                                        varB4EAC82CA7396A68D541C85D26508E83_837935339 = requestCode >= 0 ? am.getResult() : null;
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
            int result = ActivityManagerNative.getDefault()
                .startActivity(whoThread, intent,
                        intent.resolveTypeIfNeeded(who.getContentResolver()),
                        null, 0, token, target != null ? target.mEmbeddedID : null,
                        requestCode, false, false, null, null, false);//DSFIXME:  CODE0008: Nested ternary operator in expression
            checkStartActivityResult(result, intent);
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_125433505 = null;
        addTaint(who.getTaint());
        addTaint(contextThread.getTaint());
        addTaint(token.getTaint());
        addTaint(target.getTaint());
        addTaint(intent.getTaint());
        addTaint(requestCode);
        ActivityResult varA7E53CE21691AB073D9660D615818899_556158195; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_556158195 = varB4EAC82CA7396A68D541C85D26508E83_837935339;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_556158195 = varB4EAC82CA7396A68D541C85D26508E83_125433505;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_556158195.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_556158195;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.005 -0400", hash_original_method = "7F406AB00C6E84903D3FA39AC1C6F8AE", hash_generated_method = "CF4F17DF5BA772D339DB590A94DA75E8")
    public void execStartActivities(Context who, IBinder contextThread,
            IBinder token, Activity target, Intent[] intents) {
        IApplicationThread whoThread = (IApplicationThread) contextThread;
        {
            {
                final int N = mActivityMonitors.size();
                {
                    int i = 0;
                    {
                        final ActivityMonitor am = mActivityMonitors.get(i);
                        {
                            boolean var3B98ADC439434BEC23FECC1F0A621E92_893838141 = (am.match(who, null, intents[0]));
                            {
                                {
                                    boolean var02966132C31C4B68E0EDCB725C6B30A2_587534510 = (am.isBlocking());
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        try 
        {
            String[] resolvedTypes = new String[intents.length];
            {
                int i = 0;
                {
                    intents[i].setAllowFds(false);
                    resolvedTypes[i] = intents[i].resolveTypeIfNeeded(who.getContentResolver());
                } //End block
            } //End collapsed parenthetic
            int result = ActivityManagerNative.getDefault()
                .startActivities(whoThread, intents, resolvedTypes, token);
            checkStartActivityResult(result, intents[0]);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(who.getTaint());
        addTaint(contextThread.getTaint());
        addTaint(token.getTaint());
        addTaint(target.getTaint());
        addTaint(intents[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.008 -0400", hash_original_method = "D8D9B46CC68EC6EB44E02EECB84F8BB9", hash_generated_method = "1770B32238B890077964898AE012C218")
    public ActivityResult execStartActivity(
        Context who, IBinder contextThread, IBinder token, Fragment target,
        Intent intent, int requestCode) {
        ActivityResult varB4EAC82CA7396A68D541C85D26508E83_87171097 = null; //Variable for return #1
        ActivityResult varB4EAC82CA7396A68D541C85D26508E83_1435096977 = null; //Variable for return #2
        IApplicationThread whoThread = (IApplicationThread) contextThread;
        {
            {
                final int N = mActivityMonitors.size();
                {
                    int i = 0;
                    {
                        final ActivityMonitor am = mActivityMonitors.get(i);
                        {
                            boolean varCCE938CC8183C61CC0B6CB7B51CCB927_2001604116 = (am.match(who, null, intent));
                            {
                                {
                                    boolean var02966132C31C4B68E0EDCB725C6B30A2_712449247 = (am.isBlocking());
                                    {
                                        varB4EAC82CA7396A68D541C85D26508E83_87171097 = requestCode >= 0 ? am.getResult() : null;
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
            int result = ActivityManagerNative.getDefault()
                .startActivity(whoThread, intent,
                        intent.resolveTypeIfNeeded(who.getContentResolver()),
                        null, 0, token, target != null ? target.mWho : null,
                        requestCode, false, false, null, null, false);//DSFIXME:  CODE0008: Nested ternary operator in expression
            checkStartActivityResult(result, intent);
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1435096977 = null;
        addTaint(who.getTaint());
        addTaint(contextThread.getTaint());
        addTaint(token.getTaint());
        addTaint(target.getTaint());
        addTaint(intent.getTaint());
        addTaint(requestCode);
        ActivityResult varA7E53CE21691AB073D9660D615818899_840455123; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_840455123 = varB4EAC82CA7396A68D541C85D26508E83_87171097;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_840455123 = varB4EAC82CA7396A68D541C85D26508E83_1435096977;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_840455123.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_840455123;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.010 -0400", hash_original_method = "B2107F3A70ADB2CB9368A3E0EA3587E6", hash_generated_method = "42B119C6203163811D713199383D8723")
    final void init(ActivityThread thread,
            Context instrContext, Context appContext, ComponentName component, 
            IInstrumentationWatcher watcher) {
        mThread = thread;
        mMessageQueue = mThread.getLooper().myQueue();
        mInstrContext = instrContext;
        mAppContext = appContext;
        mComponent = component;
        mWatcher = watcher;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.012 -0400", hash_original_method = "F94F35385602BE8879B41CCA4D6F8D26", hash_generated_method = "9313CC44774C400D3D095F675CE8C411")
    private final void validateNotAppThread() {
        {
            boolean varC58C83EB03E77373FDCB86E705DE7351_35427698 = (ActivityThread.currentActivityThread() != null);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.012 -0400", hash_original_field = "0897AC215ECF8155758EFD206F32E8DB", hash_generated_field = "AF74A86DAFFBC4B54B5C18398CFDAB42")

        private IntentFilter mWhich;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.012 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "5E2CA74CC8E570ED6932C7E63B69D503")

        private String mClass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.015 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "2C01E1B2BB3E6DFFE6E3668CD94CB3E6")

        private ActivityResult mResult;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.015 -0400", hash_original_field = "E5ADD54C021234204DB48E99A01961D7", hash_generated_field = "6781DA6A293ED68705EB1F6D6AF21DBE")

        private boolean mBlock;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.015 -0400", hash_original_field = "55149A6B502A641554A8D5631A93175B", hash_generated_field = "C00AE67DB98B5AE298A1158B3E81E69C")

        int mHits = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.015 -0400", hash_original_field = "36FBBE397ECFED22994E73164648FBBB", hash_generated_field = "78E79A1B34133AC2215BE692FE7324EA")

        Activity mLastActivity = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.016 -0400", hash_original_method = "44AA99B3E06F91C4A28CA95A02F486A4", hash_generated_method = "E4A5E6742246C5439461F3551FABFFC9")
        public  ActivityMonitor(
            IntentFilter which, ActivityResult result, boolean block) {
            mWhich = which;
            mClass = null;
            mResult = result;
            mBlock = block;
            // ---------- Original Method ----------
            //mWhich = which;
            //mClass = null;
            //mResult = result;
            //mBlock = block;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.017 -0400", hash_original_method = "96127A12D0FD338A76B8651F7EF76641", hash_generated_method = "B8CB547530469F4780DD76CC734AFA8D")
        public  ActivityMonitor(
            String cls, ActivityResult result, boolean block) {
            mWhich = null;
            mClass = cls;
            mResult = result;
            mBlock = block;
            // ---------- Original Method ----------
            //mWhich = null;
            //mClass = cls;
            //mResult = result;
            //mBlock = block;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.018 -0400", hash_original_method = "5CEC767AFA0B77CA42139688DDFFE7D0", hash_generated_method = "315861BAE2027AD040D045240D0D2A87")
        public final IntentFilter getFilter() {
            IntentFilter varB4EAC82CA7396A68D541C85D26508E83_1515128237 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1515128237 = mWhich;
            varB4EAC82CA7396A68D541C85D26508E83_1515128237.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1515128237;
            // ---------- Original Method ----------
            //return mWhich;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.020 -0400", hash_original_method = "907D5A2A73ED7959ACD2198F97C8DDFD", hash_generated_method = "CEB9CE557757757F1301D86D1EBDE86B")
        public final ActivityResult getResult() {
            ActivityResult varB4EAC82CA7396A68D541C85D26508E83_1340420692 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1340420692 = mResult;
            varB4EAC82CA7396A68D541C85D26508E83_1340420692.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1340420692;
            // ---------- Original Method ----------
            //return mResult;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.021 -0400", hash_original_method = "6E6027F9B3B42A9863ABB214525B0A55", hash_generated_method = "253FE68927A70591B3FDE5A298381B93")
        public final boolean isBlocking() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252270962 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_252270962;
            // ---------- Original Method ----------
            //return mBlock;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.022 -0400", hash_original_method = "6A2B57F4CCAF664CD709CE454AF8AF4E", hash_generated_method = "F9E95A5ED741182A2AAA372955FE9612")
        public final int getHits() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522898494 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522898494;
            // ---------- Original Method ----------
            //return mHits;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.023 -0400", hash_original_method = "1AD813C5DE346D876C42D8A64F1E0FB4", hash_generated_method = "DFD0BB5D40245FB5601E04A2D3DDE5DB")
        public final Activity getLastActivity() {
            Activity varB4EAC82CA7396A68D541C85D26508E83_1752334074 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1752334074 = mLastActivity;
            varB4EAC82CA7396A68D541C85D26508E83_1752334074.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1752334074;
            // ---------- Original Method ----------
            //return mLastActivity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.025 -0400", hash_original_method = "905168F82A17E43399C57E76AC6D268D", hash_generated_method = "B1C18160B6376A04F15616A6F28CA4FE")
        public final Activity waitForActivity() {
            Activity varB4EAC82CA7396A68D541C85D26508E83_1794290579 = null; //Variable for return #1
            {
                {
                    try 
                    {
                        wait();
                    } //End block
                    catch (InterruptedException e)
                    { }
                } //End block
                Activity res = mLastActivity;
                mLastActivity = null;
                varB4EAC82CA7396A68D541C85D26508E83_1794290579 = res;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1794290579.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1794290579;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.026 -0400", hash_original_method = "68E343228598567180DC80BCAD1066EC", hash_generated_method = "F448E6AFFD9587068F1726CF69048C2B")
        public final Activity waitForActivityWithTimeout(long timeOut) {
            Activity varB4EAC82CA7396A68D541C85D26508E83_1419148123 = null; //Variable for return #1
            Activity varB4EAC82CA7396A68D541C85D26508E83_1179628131 = null; //Variable for return #2
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
                    varB4EAC82CA7396A68D541C85D26508E83_1419148123 = null;
                } //End block
                {
                    Activity res = mLastActivity;
                    mLastActivity = null;
                    varB4EAC82CA7396A68D541C85D26508E83_1179628131 = res;
                } //End block
            } //End block
            addTaint(timeOut);
            Activity varA7E53CE21691AB073D9660D615818899_1758591673; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1758591673 = varB4EAC82CA7396A68D541C85D26508E83_1419148123;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1758591673 = varB4EAC82CA7396A68D541C85D26508E83_1179628131;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1758591673.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1758591673;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.028 -0400", hash_original_method = "81CE78024E25171646CA4AFCDB286C47", hash_generated_method = "2DE4A0FA899E6549632E7A6DF7367E59")
        final boolean match(Context who,
                            Activity activity,
                            Intent intent) {
            {
                {
                    boolean var2B7A60CCE4E6911C4A9F4E8793624EF5_668190360 = (mWhich != null
                    && mWhich.match(who.getContentResolver(), intent,
                                    true, "Instrumentation") < 0);
                } //End collapsed parenthetic
                {
                    String cls = null;
                    {
                        cls = activity.getClass().getName();
                    } //End block
                    {
                        boolean varAC9DF57045B235D222971A1BC52BD87E_1414673907 = (intent.getComponent() != null);
                        {
                            cls = intent.getComponent().getClassName();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varAD5F671F79F4CFA6F4D54B486D6F7C93_493933821 = (cls == null || !mClass.equals(cls));
                    } //End collapsed parenthetic
                } //End block
                {
                    mLastActivity = activity;
                    notifyAll();
                } //End block
            } //End block
            addTaint(who.getTaint());
            addTaint(intent.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144785453 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144785453;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static final class ActivityResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.028 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")

        private int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.028 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "2ACA4EFB7F1C3D021D8C2319D9F4A1B0")

        private Intent mResultData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.029 -0400", hash_original_method = "C450F5B8EDB38A231DF953C34FD7C745", hash_generated_method = "24DA7F362B57EA7AFBB13D11AD29E232")
        public  ActivityResult(int resultCode, Intent resultData) {
            mResultCode = resultCode;
            mResultData = resultData;
            // ---------- Original Method ----------
            //mResultCode = resultCode;
            //mResultData = resultData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.031 -0400", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "56B0A088BE38667A9BFF3C4456EDFF80")
        public int getResultCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928772042 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928772042;
            // ---------- Original Method ----------
            //return mResultCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.032 -0400", hash_original_method = "230B95D397C0359A2CE808B90BABA149", hash_generated_method = "5E926A7C17762072AA106723B7FD6E9A")
        public Intent getResultData() {
            Intent varB4EAC82CA7396A68D541C85D26508E83_62658712 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_62658712 = mResultData;
            varB4EAC82CA7396A68D541C85D26508E83_62658712.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_62658712;
            // ---------- Original Method ----------
            //return mResultData;
        }

        
    }


    
    private final class InstrumentationThread extends Thread {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.033 -0400", hash_original_method = "63270DA70BB76F2F3E4D4969BE7BFAFC", hash_generated_method = "1846024E4D47701B100381EAE9601478")
        public  InstrumentationThread(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.034 -0400", hash_original_method = "801DE955A4997069AEAE1C9E4306FFC2", hash_generated_method = "7039EC307B46275FC6745D7A4DDF78A7")
        public void run() {
            IActivityManager am = ActivityManagerNative.getDefault();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.034 -0400", hash_original_method = "9351A801773C8F1D9056187EA700F8B4", hash_generated_method = "9351A801773C8F1D9056187EA700F8B4")
        public EmptyRunnable ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.035 -0400", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "A2E5AE58616EECC7176440E5139E1684")
        public void run() {
            // ---------- Original Method ----------
        }

        
    }


    
    private static final class SyncRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.035 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "B38DEE567D624A06D39175E911A12BE6")

        private Runnable mTarget;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.035 -0400", hash_original_field = "FD1D40CA7A22C1FB8C4721FF4D7B4E13", hash_generated_field = "C7DFAA7BAEC783B90B2A4CC60586CA74")

        private boolean mComplete;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.035 -0400", hash_original_method = "52C4D1F6D6B56C48522BD51EB3CA3671", hash_generated_method = "5D92DD35625E7C01B1A427675450D4FF")
        public  SyncRunnable(Runnable target) {
            mTarget = target;
            // ---------- Original Method ----------
            //mTarget = target;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.036 -0400", hash_original_method = "44AE594487B622FAC5CF0DF348DF4C16", hash_generated_method = "758B6517728AD22654C0C76D72E99FC6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.037 -0400", hash_original_method = "02D1E24DCA4BB39BCA765C3BAB20012A", hash_generated_method = "80681B8394C590665A98C3BD201EA399")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.037 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "5DEDAC72AD89B3864945324786195E0B")

        public Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.037 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "8EB481EDAD2FDE318A05890E655F5C10")

        public Activity activity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.037 -0400", hash_original_method = "749CA2F0047E4C5ABC5CE22C281FA095", hash_generated_method = "3059D2ED47C5D0B987E8709844E0C081")
        public  ActivityWaiter(Intent _intent) {
            intent = _intent;
            // ---------- Original Method ----------
            //intent = _intent;
        }

        
    }


    
    private final class ActivityGoing implements MessageQueue.IdleHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.038 -0400", hash_original_field = "BFB5BEE603E80EEC1A8030FC0DC96B43", hash_generated_field = "D1D9DBA4EB12F84FE5F9E1BF6FFC4059")

        private ActivityWaiter mWaiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.038 -0400", hash_original_method = "C941F219CD1DB06313DFA66C54B64070", hash_generated_method = "112E0EFA9E3E1E4D0209C198398F4B90")
        public  ActivityGoing(ActivityWaiter waiter) {
            mWaiter = waiter;
            // ---------- Original Method ----------
            //mWaiter = waiter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.039 -0400", hash_original_method = "6BEF536DFBCFB4C74EC4C0EA4FEAD5BE", hash_generated_method = "DE1B7EFFD3CD0267ECBB5A4FF84C1B69")
        public final boolean queueIdle() {
            {
                mWaitingActivities.remove(mWaiter);
                mSync.notifyAll();
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835429007 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_835429007;
            // ---------- Original Method ----------
            //synchronized (mSync) {
                //mWaitingActivities.remove(mWaiter);
                //mSync.notifyAll();
            //}
            //return false;
        }

        
    }


    
    private static final class Idler implements MessageQueue.IdleHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.040 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "A3563124F239CF73FFEC0EB79C97D4FC")

        private Runnable mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.040 -0400", hash_original_field = "55AD180A169FF1C7D858A291A97089D7", hash_generated_field = "9B659026DF37979A10F87338BD5AE24B")

        private boolean mIdle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.041 -0400", hash_original_method = "4434628995BB6492F17F2A3E55C00ABF", hash_generated_method = "63FBA13112CEF4A27296386CBFEF1690")
        public  Idler(Runnable callback) {
            mCallback = callback;
            mIdle = false;
            // ---------- Original Method ----------
            //mCallback = callback;
            //mIdle = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.042 -0400", hash_original_method = "B0AE6A8D5B64501509EFCE6FDAF91034", hash_generated_method = "E9EAEDAD791ACD08219FFFA1786C5052")
        public final boolean queueIdle() {
            {
                mCallback.run();
            } //End block
            {
                mIdle = true;
                notifyAll();
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1948581760 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1948581760;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.042 -0400", hash_original_method = "DF4D50EB6BB518BE09549DCD9C0630C1", hash_generated_method = "4A208046355C9EDFEB0932DA3228259F")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.043 -0400", hash_original_field = "C67C9833A29A3C3AA6E6F75E1F3C2F60", hash_generated_field = "B1FDF1E5A9E128A7382EC05D1B2C02BE")

    public static final String REPORT_KEY_IDENTIFIER = "id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.043 -0400", hash_original_field = "DF34AF130918581DB93971EEC13B8486", hash_generated_field = "13C91CEB9ED83DD17ABB1FD056C7003C")

    public static final String REPORT_KEY_STREAMRESULT = "stream";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.043 -0400", hash_original_field = "CF06207C135ED2AE013476D0083DE7AA", hash_generated_field = "A6549731053B582294DF4842CC523BD8")

    private static final String TAG = "Instrumentation";
}

