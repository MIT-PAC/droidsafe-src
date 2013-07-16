package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.541 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")

    private final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.542 -0400", hash_original_field = "4637F257714ED0010AAAD4B2D42CA0B5", hash_generated_field = "4DECD94BE6B0174DE36067CBF50C84C9")

    private ActivityThread mThread = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.542 -0400", hash_original_field = "707EC1AFA46D7EA72081360AA30DB33B", hash_generated_field = "EE117464CCFBB71A57DA2F8BADEB6233")

    private MessageQueue mMessageQueue = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.542 -0400", hash_original_field = "76CA776B9484D9843D577178FB774E92", hash_generated_field = "CF9AE987035AAD94FADA826204456158")

    private Context mInstrContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.542 -0400", hash_original_field = "5ABA4A253E78386295F297E632FF4E34", hash_generated_field = "722D46A23A9E453AC7AC6D5797C29418")

    private Context mAppContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.542 -0400", hash_original_field = "C0386E973BB6E008B1720A8BB4936F69", hash_generated_field = "1B40E7C57A0B1682389BAE16521C0844")

    private ComponentName mComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.542 -0400", hash_original_field = "22D8CE98A01A307983EC97778B73FE9E", hash_generated_field = "83CDC5A21BC91E43BA3B83822ED24524")

    private Thread mRunner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.542 -0400", hash_original_field = "7848C7EA0F7A7B533B80748240896F3F", hash_generated_field = "A6C142CC3F6E6296AB67C595830F5086")

    private List<ActivityWaiter> mWaitingActivities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.542 -0400", hash_original_field = "BBA184EA143905687B1CBD1ABA6B112A", hash_generated_field = "5A3BE51583B9275D70583A158D75384D")

    private List<ActivityMonitor> mActivityMonitors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.543 -0400", hash_original_field = "47CD6CB6B9A4FA63425D0BEAFAF438EE", hash_generated_field = "BD19A60B1E71F2A79E53A58C34F52CB2")

    private IInstrumentationWatcher mWatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.543 -0400", hash_original_field = "7535B9020CF0E0D6F2F2FC2C55D5D303", hash_generated_field = "C00E68D542ECF5CA8FC17F9FED17FEEA")

    private boolean mAutomaticPerformanceSnapshots = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.543 -0400", hash_original_field = "99E4031EB7E21B827C92C62233E4B425", hash_generated_field = "68DE569686980EC11F79E2F9C9488F60")

    private PerformanceCollector mPerformanceCollector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.543 -0400", hash_original_field = "0A173F6C54C8DC69EF40909480126796", hash_generated_field = "74370D5BDE597F43882751037480C6FB")

    private Bundle mPerfMetrics = new Bundle();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.543 -0400", hash_original_method = "2A2FEB9F4AAE35A924F5C88DA8F6FDF1", hash_generated_method = "05D8623C11D87D684B7E40B654AAAA52")
    public  Instrumentation() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.544 -0400", hash_original_method = "4B024CDE66137DA3ED66BF57127A0E80", hash_generated_method = "618433C04A9C5C61D907C7BAF3E63003")
    public void onCreate(Bundle arguments) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(arguments.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.545 -0400", hash_original_method = "75096E18A1A48E91D30DD9D6FBFD5D1F", hash_generated_method = "C97828F16ADA530CDD04A9AF4950930A")
    public void start() {
    if(mRunner != null)        
        {
            RuntimeException varE9730EF0382160D94F29186A612BDE01_1823779895 = new RuntimeException("Instrumentation already started");
            varE9730EF0382160D94F29186A612BDE01_1823779895.addTaint(taint);
            throw varE9730EF0382160D94F29186A612BDE01_1823779895;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.545 -0400", hash_original_method = "0451E38101EC2D69951E664FB36904F0", hash_generated_method = "C270D6AECB942165605F46F9C723CFA1")
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.546 -0400", hash_original_method = "8DC9492B498FF3067475C41C79EEAB3B", hash_generated_method = "0404899803F2573CB6678DAE40A1E027")
    public boolean onException(Object obj, Throwable e) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(e.getTaint());
        addTaint(obj.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_295476907 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228020526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228020526;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.547 -0400", hash_original_method = "5CE1AB9DF7D7162F89956B1D13BE745E", hash_generated_method = "7A10A3F5A3163851361A82480E3A5794")
    public void sendStatus(int resultCode, Bundle results) {
        addTaint(results.getTaint());
        addTaint(resultCode);
    if(mWatcher != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.548 -0400", hash_original_method = "93CEFEE99BA727186FFD22BEC1D0D072", hash_generated_method = "9B4ABE27FA056C13D095AD48F87871F3")
    public void finish(int resultCode, Bundle results) {
        addTaint(results.getTaint());
        addTaint(resultCode);
    if(mAutomaticPerformanceSnapshots)        
        {
            endPerformanceSnapshot();
        } //End block
    if(mPerfMetrics != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.549 -0400", hash_original_method = "6EB9EED76498D1668A96326FD6FFBEE9", hash_generated_method = "FD3545546835D20A0C087ACC19F8773F")
    public void setAutomaticPerformanceSnapshots() {
        mAutomaticPerformanceSnapshots = true;
        mPerformanceCollector = new PerformanceCollector();
        // ---------- Original Method ----------
        //mAutomaticPerformanceSnapshots = true;
        //mPerformanceCollector = new PerformanceCollector();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.549 -0400", hash_original_method = "59F6F337F904783653DF79F6C5B4E5AA", hash_generated_method = "832523B66E7E9F3D7863007FEC8AA429")
    public void startPerformanceSnapshot() {
    if(!isProfiling())        
        {
            mPerformanceCollector.beginSnapshot(null);
        } //End block
        // ---------- Original Method ----------
        //if (!isProfiling()) {
            //mPerformanceCollector.beginSnapshot(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.549 -0400", hash_original_method = "8BB380F00D03C999D4B5625E8ECD5AAA", hash_generated_method = "F03460A5F1E644B23B1C6921AF0E6A3B")
    public void endPerformanceSnapshot() {
    if(!isProfiling())        
        {
            mPerfMetrics = mPerformanceCollector.endSnapshot();
        } //End block
        // ---------- Original Method ----------
        //if (!isProfiling()) {
            //mPerfMetrics = mPerformanceCollector.endSnapshot();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.550 -0400", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "E5C4FFF396F837C85A1D40A9B232BFA0")
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.551 -0400", hash_original_method = "0612F59C08E6EE31E243F52D2CCB68AA", hash_generated_method = "5054BA76A1B6A9A7BB5F1DAE55810B37")
    public Context getContext() {
Context var7C973FF6A647252FD84A74D84093D275_931504749 =         mInstrContext;
        var7C973FF6A647252FD84A74D84093D275_931504749.addTaint(taint);
        return var7C973FF6A647252FD84A74D84093D275_931504749;
        // ---------- Original Method ----------
        //return mInstrContext;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.551 -0400", hash_original_method = "6C1D36E28C0C97736EA4779A7FB1715C", hash_generated_method = "42057771BD358E238279147A24F687C1")
    public ComponentName getComponentName() {
ComponentName var05A4B5AD7D0B7D1F57C4FD8455C615E7_740339770 =         mComponent;
        var05A4B5AD7D0B7D1F57C4FD8455C615E7_740339770.addTaint(taint);
        return var05A4B5AD7D0B7D1F57C4FD8455C615E7_740339770;
        // ---------- Original Method ----------
        //return mComponent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.551 -0400", hash_original_method = "D1026223DF11B7056861FB0AA4B64828", hash_generated_method = "282D863DC590F8B80811AE90CAC3DE81")
    public Context getTargetContext() {
Context var4908ADF1214C45A06C620C4F7C556D83_1452914291 =         mAppContext;
        var4908ADF1214C45A06C620C4F7C556D83_1452914291.addTaint(taint);
        return var4908ADF1214C45A06C620C4F7C556D83_1452914291;
        // ---------- Original Method ----------
        //return mAppContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.552 -0400", hash_original_method = "7D34AF538E9A67DEA76272AB02F2CDC6", hash_generated_method = "B844AFCCE807C2C57D26AABA1366B9D5")
    public boolean isProfiling() {
        boolean varC305E169F783F816751B596025156119_522418888 = (mThread.isProfiling());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104367864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_104367864;
        // ---------- Original Method ----------
        //return mThread.isProfiling();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.552 -0400", hash_original_method = "988500FDA3CAE61033EABAD95C8BF0F1", hash_generated_method = "B9955A4B2395468018D90EF21501C5CD")
    public void startProfiling() {
    if(mThread.isProfiling())        
        {
            File file = new File(mThread.getProfileFilePath());
            file.getParentFile().mkdirs();
            Debug.startMethodTracing(file.toString(), 8 * 1024 * 1024);
        } //End block
        // ---------- Original Method ----------
        //if (mThread.isProfiling()) {
            //File file = new File(mThread.getProfileFilePath());
            //file.getParentFile().mkdirs();
            //Debug.startMethodTracing(file.toString(), 8 * 1024 * 1024);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.553 -0400", hash_original_method = "1FEC2A39C917937DB00CBC5BA91E5501", hash_generated_method = "CA97E60ACAAB850F17A77167CDB7CA48")
    public void stopProfiling() {
    if(mThread.isProfiling())        
        {
            Debug.stopMethodTracing();
        } //End block
        // ---------- Original Method ----------
        //if (mThread.isProfiling()) {
            //Debug.stopMethodTracing();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.554 -0400", hash_original_method = "EEC5F78C5E75C7158C64611E1694E1A0", hash_generated_method = "0298622A827BB715452A2004D3E56E24")
    public void setInTouchMode(boolean inTouch) {
        addTaint(inTouch);
        try 
        {
            IWindowManager.Stub.asInterface(
                    ServiceManager.getService("window")).setInTouchMode(inTouch);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //IWindowManager.Stub.asInterface(
                    //ServiceManager.getService("window")).setInTouchMode(inTouch);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.555 -0400", hash_original_method = "9CBDEDF34C527A410521706D53450B12", hash_generated_method = "945F76808FEB6E8C7C5581FFB8175A0A")
    public void waitForIdle(Runnable recipient) {
        addTaint(recipient.getTaint());
        mMessageQueue.addIdleHandler(new Idler(recipient));
        mThread.getHandler().post(new EmptyRunnable());
        // ---------- Original Method ----------
        //mMessageQueue.addIdleHandler(new Idler(recipient));
        //mThread.getHandler().post(new EmptyRunnable());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.556 -0400", hash_original_method = "89AA1CC3D27AC9ADF27421ED4392817A", hash_generated_method = "FAD81B4FE8B64782BCCD8ABCBD6F0562")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.558 -0400", hash_original_method = "23FE2246FE60A7859CD93D836CF467DE", hash_generated_method = "66120250230854B416A813D75328D0B3")
    public void runOnMainSync(Runnable runner) {
        addTaint(runner.getTaint());
        validateNotAppThread();
        SyncRunnable sr = new SyncRunnable(runner);
        mThread.getHandler().post(sr);
        sr.waitForComplete();
        // ---------- Original Method ----------
        //validateNotAppThread();
        //SyncRunnable sr = new SyncRunnable(runner);
        //mThread.getHandler().post(sr);
        //sr.waitForComplete();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.560 -0400", hash_original_method = "834B647755C86ED587A771C499B38AF8", hash_generated_method = "02C48280113E8E874755340038EBCA02")
    public Activity startActivitySync(Intent intent) {
        addTaint(intent.getTaint());
        validateNotAppThread();
        synchronized
(mSync)        {
            intent = new Intent(intent);
            ActivityInfo ai = intent.resolveActivityInfo(
                getTargetContext().getPackageManager(), 0);
    if(ai == null)            
            {
                RuntimeException var05CA0AC09655F29988BF0B88381DCF20_471336815 = new RuntimeException("Unable to resolve activity for: " + intent);
                var05CA0AC09655F29988BF0B88381DCF20_471336815.addTaint(taint);
                throw var05CA0AC09655F29988BF0B88381DCF20_471336815;
            } //End block
            String myProc = mThread.getProcessName();
    if(!ai.processName.equals(myProc))            
            {
                RuntimeException var9887368A942D550F7B003E9B6F4E5BE3_537524376 = new RuntimeException("Intent in process "
                        + myProc + " resolved to different process "
                        + ai.processName + ": " + intent);
                var9887368A942D550F7B003E9B6F4E5BE3_537524376.addTaint(taint);
                throw var9887368A942D550F7B003E9B6F4E5BE3_537524376;
            } //End block
            intent.setComponent(new ComponentName(
                    ai.applicationInfo.packageName, ai.name));
            final ActivityWaiter aw = new ActivityWaiter(intent);
    if(mWaitingActivities == null)            
            {
                mWaitingActivities = new ArrayList();
            } //End block
            mWaitingActivities.add(aw);
            getTargetContext().startActivity(intent);
            do {
                {
                    try 
                    {
                        mSync.wait();
                    } //End block
                    catch (InterruptedException e)
                    {
                    } //End block
                } //End block
} while (mWaitingActivities.contains(aw));
Activity var4AFCD6251278B9C9F0440D6979AA2C29_1614944745 =             aw.activity;
            var4AFCD6251278B9C9F0440D6979AA2C29_1614944745.addTaint(taint);
            return var4AFCD6251278B9C9F0440D6979AA2C29_1614944745;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.562 -0400", hash_original_method = "608AF20D37ADB77B72D35062305FF16B", hash_generated_method = "13C7978E2793BB16147E85923277F4F5")
    public void addMonitor(ActivityMonitor monitor) {
        addTaint(monitor.getTaint());
        synchronized
(mSync)        {
    if(mActivityMonitors == null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.562 -0400", hash_original_method = "A7BDDA46B206533FE67A2A87AD7D2268", hash_generated_method = "49120060730244632FFAA67E057691BB")
    public ActivityMonitor addMonitor(
        IntentFilter filter, ActivityResult result, boolean block) {
        addTaint(block);
        addTaint(result.getTaint());
        addTaint(filter.getTaint());
        ActivityMonitor am = new ActivityMonitor(filter, result, block);
        addMonitor(am);
ActivityMonitor var0EE62FBAA5467D9B6F72D472A1B595B3_1417003986 =         am;
        var0EE62FBAA5467D9B6F72D472A1B595B3_1417003986.addTaint(taint);
        return var0EE62FBAA5467D9B6F72D472A1B595B3_1417003986;
        // ---------- Original Method ----------
        //ActivityMonitor am = new ActivityMonitor(filter, result, block);
        //addMonitor(am);
        //return am;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.563 -0400", hash_original_method = "1AE73A4BC3EDE4468A3DB90D9129EBCC", hash_generated_method = "FCDB6A06A71B7DE51E9B62500D0DE0FF")
    public ActivityMonitor addMonitor(
        String cls, ActivityResult result, boolean block) {
        addTaint(block);
        addTaint(result.getTaint());
        addTaint(cls.getTaint());
        ActivityMonitor am = new ActivityMonitor(cls, result, block);
        addMonitor(am);
ActivityMonitor var0EE62FBAA5467D9B6F72D472A1B595B3_934195160 =         am;
        var0EE62FBAA5467D9B6F72D472A1B595B3_934195160.addTaint(taint);
        return var0EE62FBAA5467D9B6F72D472A1B595B3_934195160;
        // ---------- Original Method ----------
        //ActivityMonitor am = new ActivityMonitor(cls, result, block);
        //addMonitor(am);
        //return am;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.564 -0400", hash_original_method = "29E7A5CE85EC83DC1A6299DE5A3CFA02", hash_generated_method = "AE1FC6351680CA3A4363C9855EEFE7E3")
    public boolean checkMonitorHit(ActivityMonitor monitor, int minHits) {
        addTaint(minHits);
        addTaint(monitor.getTaint());
        waitForIdleSync();
        synchronized
(mSync)        {
    if(monitor.getHits() < minHits)            
            {
                boolean var68934A3E9455FA72420237EB05902327_2140703614 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852519474 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_852519474;
            } //End block
            mActivityMonitors.remove(monitor);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1042459442 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_273883826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_273883826;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.564 -0400", hash_original_method = "ACAA082ACBE3DC4BF5F5B838A83827D9", hash_generated_method = "A1DEB6088E3BD379BE584964AAFDC88F")
    public Activity waitForMonitor(ActivityMonitor monitor) {
        addTaint(monitor.getTaint());
        Activity activity = monitor.waitForActivity();
        synchronized
(mSync)        {
            mActivityMonitors.remove(monitor);
        } //End block
Activity var8CEBAC25E19008E785695F06EF11C2CD_1534593114 =         activity;
        var8CEBAC25E19008E785695F06EF11C2CD_1534593114.addTaint(taint);
        return var8CEBAC25E19008E785695F06EF11C2CD_1534593114;
        // ---------- Original Method ----------
        //Activity activity = monitor.waitForActivity();
        //synchronized (mSync) {
            //mActivityMonitors.remove(monitor);
        //}
        //return activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.565 -0400", hash_original_method = "C35EC81162DCBEC6CBBF630B6FBC9A38", hash_generated_method = "1327C8A6871852C287D747C01F455D6E")
    public Activity waitForMonitorWithTimeout(ActivityMonitor monitor, long timeOut) {
        addTaint(timeOut);
        addTaint(monitor.getTaint());
        Activity activity = monitor.waitForActivityWithTimeout(timeOut);
        synchronized
(mSync)        {
            mActivityMonitors.remove(monitor);
        } //End block
Activity var8CEBAC25E19008E785695F06EF11C2CD_879076007 =         activity;
        var8CEBAC25E19008E785695F06EF11C2CD_879076007.addTaint(taint);
        return var8CEBAC25E19008E785695F06EF11C2CD_879076007;
        // ---------- Original Method ----------
        //Activity activity = monitor.waitForActivityWithTimeout(timeOut);
        //synchronized (mSync) {
            //mActivityMonitors.remove(monitor);
        //}
        //return activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.566 -0400", hash_original_method = "667CF28A3BE8CF2696555BC3512917A7", hash_generated_method = "5B00097FD4868259B23CFE9018DFDC6B")
    public void removeMonitor(ActivityMonitor monitor) {
        addTaint(monitor.getTaint());
        synchronized
(mSync)        {
            mActivityMonitors.remove(monitor);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //mActivityMonitors.remove(monitor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.570 -0400", hash_original_method = "4D155A3E8D909DAB8A4322BEF2D5BDFA", hash_generated_method = "2A9FCAB9E2208FCA8F8C3041D0B3F14D")
    public boolean invokeMenuActionSync(Activity targetActivity, 
                                    int id, int flag) {
        addTaint(flag);
        addTaint(id);
        addTaint(targetActivity.getTaint());
        class MenuRunnable implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.567 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "073B8C8E0ED83C0B182572C1444991DD")
            private Activity activity;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.567 -0400", hash_original_field = "F393F3F5E496869A15BC72CBFD56F541", hash_generated_field = "17A8B79B91E5A599D96EB04B1C01F867")
            private int identifier;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.567 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")
            private int flags;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.568 -0400", hash_original_field = "A7E53CE21691AB073D9660D615818899", hash_generated_field = "ECDF201421EBB4A2C3D7973F567DB5B7")
            boolean returnValue;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.569 -0400", hash_original_method = "29927998E9364A9B4F18182584446309", hash_generated_method = "8142DFAED140D1033B368E771D8BFCFF")
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.570 -0400", hash_original_method = "76921810C67DCF51EE72D55418C1BAD6", hash_generated_method = "B274A9643CC50A64CA3C45222D0853E3")
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
        boolean var53CB527E3B326C94C354AA96AEFF3CC9_263090160 = (mr.returnValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_837981099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_837981099;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.573 -0400", hash_original_method = "28CE40BD9E15A522E886C67E234DD689", hash_generated_method = "A0DB54DA97FFA3A07FD577AFEB99B163")
    public boolean invokeContextMenuAction(Activity targetActivity, int id, int flag) {
        addTaint(flag);
        addTaint(id);
        addTaint(targetActivity.getTaint());
        validateNotAppThread();
        final KeyEvent downEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_CENTER);
        sendKeySync(downEvent);
        waitForIdleSync();
        try 
        {
            Thread.sleep(ViewConfiguration.getLongPressTimeout());
        } //End block
        catch (InterruptedException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_24191897 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1484206245 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1484206245;
        } //End block
        final KeyEvent upEvent = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_CENTER);
        sendKeySync(upEvent);
        waitForIdleSync();
        class ContextMenuRunnable implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.571 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "073B8C8E0ED83C0B182572C1444991DD")
            private Activity activity;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.571 -0400", hash_original_field = "F393F3F5E496869A15BC72CBFD56F541", hash_generated_field = "17A8B79B91E5A599D96EB04B1C01F867")
            private int identifier;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.571 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")
            private int flags;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.571 -0400", hash_original_field = "A7E53CE21691AB073D9660D615818899", hash_generated_field = "ECDF201421EBB4A2C3D7973F567DB5B7")
            boolean returnValue;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.572 -0400", hash_original_method = "798263D9D537A1153607D5F0FAA29A33", hash_generated_method = "573F59F2075A6B0930120A804295896E")
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.573 -0400", hash_original_method = "E7EE26BA0D2735345FDDDF8FC2DD3A31", hash_generated_method = "FB3E45218CBDCD4E0D1EBA5F331EC332")
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
        boolean var7F68A7EB2BCD135A1A8DD257EE299F50_1510854739 = (cmr.returnValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614735178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614735178;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.575 -0400", hash_original_method = "029397BC692B989F9FCA48D48FDB9479", hash_generated_method = "12F25BDAF3A4A5FBA334182824957A8C")
    public void sendStringSync(String text) {
        addTaint(text.getTaint());
    if(text == null)        
        {
            return;
        } //End block
        KeyCharacterMap keyCharacterMap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
        KeyEvent[] events = keyCharacterMap.getEvents(text.toCharArray());
    if(events != null)        
        {
for(int i = 0;i < events.length;i++)
            {
                sendKeySync(events[i]);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.576 -0400", hash_original_method = "8EB82A3200B456D290A2F7A26355BB76", hash_generated_method = "1C005B54B7D54FF96D737259EA574091")
    public void sendKeySync(KeyEvent event) {
        addTaint(event.getTaint());
        validateNotAppThread();
        try 
        {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectKeyEvent(event, true);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //validateNotAppThread();
        //try {
            //(IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                //.injectKeyEvent(event, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.577 -0400", hash_original_method = "EAB0936DFBB6258C56105993043121F1", hash_generated_method = "FF7303FB48B8E043FB9585EC9B2EFDD4")
    public void sendKeyDownUpSync(int key) {
        addTaint(key);
        sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, key));
        sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, key));
        // ---------- Original Method ----------
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, key));
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, key));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.578 -0400", hash_original_method = "481470F7D6C4847394865E9F06AE8ED8", hash_generated_method = "6F24A98803C99967FFB1CC9504DEFEC0")
    public void sendCharacterSync(int keyCode) {
        addTaint(keyCode);
        sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
        sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, keyCode));
        // ---------- Original Method ----------
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
        //sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, keyCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.579 -0400", hash_original_method = "B9A3EF31E8BF5F99FCCA686BC6658BE3", hash_generated_method = "9DED309319688233BAC7BCFE91D311B3")
    public void sendPointerSync(MotionEvent event) {
        addTaint(event.getTaint());
        validateNotAppThread();
        try 
        {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectPointerEvent(event, true);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //validateNotAppThread();
        //try {
            //(IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                //.injectPointerEvent(event, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.580 -0400", hash_original_method = "6B2ECCD3AB22E94B5B1243023E902F6D", hash_generated_method = "27B1767E851AD0A3BBF6F900B9F883A2")
    public void sendTrackballEventSync(MotionEvent event) {
        addTaint(event.getTaint());
        validateNotAppThread();
        try 
        {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectTrackballEvent(event, true);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //validateNotAppThread();
        //try {
            //(IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                //.injectTrackballEvent(event, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.582 -0400", hash_original_method = "1A9EF24656896AC4FCE906BFB43593E0", hash_generated_method = "9846480DD37655701EAB993C743406A9")
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, 
            ClassNotFoundException {
        addTaint(context.getTaint());
        addTaint(className.getTaint());
        addTaint(cl.getTaint());
Application var462AA7D74A15F95A3674E0E27E1A513F_1254087291 =         newApplication(cl.loadClass(className), context);
        var462AA7D74A15F95A3674E0E27E1A513F_1254087291.addTaint(taint);
        return var462AA7D74A15F95A3674E0E27E1A513F_1254087291;
        // ---------- Original Method ----------
        //return newApplication(cl.loadClass(className), context);
    }

    
        static public Application newApplication(Class<?> clazz, Context context) throws InstantiationException, IllegalAccessException, 
            ClassNotFoundException {
        Application app = (Application)clazz.newInstance();
        app.attach(context);
        return app;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.585 -0400", hash_original_method = "3D967D3E47594084D340D0FEDC81A2D2", hash_generated_method = "D3A3951AA16DDF7937A0229F8195A0F3")
    public void callApplicationOnCreate(Application app) {
        addTaint(app.getTaint());
        app.onCreate();
        // ---------- Original Method ----------
        //app.onCreate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.587 -0400", hash_original_method = "A9111F868862B9E251C99947D42ADECF", hash_generated_method = "34EF575F20D8AE379BCA85EB9A4E97BD")
    public Activity newActivity(Class<?> clazz, Context context, 
            IBinder token, Application application, Intent intent, ActivityInfo info, 
            CharSequence title, Activity parent, String id,
            Object lastNonConfigurationInstance) throws InstantiationException, 
            IllegalAccessException {
        addTaint(lastNonConfigurationInstance.getTaint());
        addTaint(id.getTaint());
        addTaint(parent.getTaint());
        addTaint(title.getTaint());
        addTaint(info.getTaint());
        addTaint(intent.getTaint());
        addTaint(application.getTaint());
        addTaint(token.getTaint());
        addTaint(context.getTaint());
        addTaint(clazz.getTaint());
        Activity activity = (Activity)clazz.newInstance();
        ActivityThread aThread = null;
        activity.attach(context, aThread, this, token, application, intent,
                info, title, parent, id,
                (Activity.NonConfigurationInstances)lastNonConfigurationInstance,
                new Configuration());
Activity var8CEBAC25E19008E785695F06EF11C2CD_1044966438 =         activity;
        var8CEBAC25E19008E785695F06EF11C2CD_1044966438.addTaint(taint);
        return var8CEBAC25E19008E785695F06EF11C2CD_1044966438;
        // ---------- Original Method ----------
        //Activity activity = (Activity)clazz.newInstance();
        //ActivityThread aThread = null;
        //activity.attach(context, aThread, this, token, application, intent,
                //info, title, parent, id,
                //(Activity.NonConfigurationInstances)lastNonConfigurationInstance,
                //new Configuration());
        //return activity;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.589 -0400", hash_original_method = "67A9E29CAF7C169812898E8BB0812F51", hash_generated_method = "B55A298B6522D318F669DA9A12A66B15")
    public Activity newActivity(ClassLoader cl, String className,
            Intent intent) throws InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        addTaint(intent.getTaint());
        addTaint(className.getTaint());
        addTaint(cl.getTaint());
Activity var09CB010C1562C1A24F51A5646120A738_476868237 =         (Activity)cl.loadClass(className).newInstance();
        var09CB010C1562C1A24F51A5646120A738_476868237.addTaint(taint);
        return var09CB010C1562C1A24F51A5646120A738_476868237;
        // ---------- Original Method ----------
        //return (Activity)cl.loadClass(className).newInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.591 -0400", hash_original_method = "5B22BAF104CC01C4555866A70EB5D211", hash_generated_method = "0AE7939351465B8BF5CAE49644C95D5D")
    public void callActivityOnCreate(Activity activity, Bundle icicle) {
        addTaint(icicle.getTaint());
        addTaint(activity.getTaint());
    if(mWaitingActivities != null)        
        {
            synchronized
(mSync)            {
                final int N = mWaitingActivities.size();
for(int i=0;i<N;i++)
                {
                    final ActivityWaiter aw = mWaitingActivities.get(i);
                    final Intent intent = aw.intent;
    if(intent.filterEquals(activity.getIntent()))                    
                    {
                        aw.activity = activity;
                        mMessageQueue.addIdleHandler(new ActivityGoing(aw));
                    } //End block
                } //End block
            } //End block
        } //End block
        activity.performCreate(icicle);
    if(mActivityMonitors != null)        
        {
            synchronized
(mSync)            {
                final int N = mActivityMonitors.size();
for(int i=0;i<N;i++)
                {
                    final ActivityMonitor am = mActivityMonitors.get(i);
                    am.match(activity, activity, activity.getIntent());
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.593 -0400", hash_original_method = "ACD4ACDF1D4AD87F23B45E29C987968F", hash_generated_method = "FEF30983E8D37FF063CA05A56C795AA7")
    public void callActivityOnDestroy(Activity activity) {
        addTaint(activity.getTaint());
        activity.performDestroy();
    if(mActivityMonitors != null)        
        {
            synchronized
(mSync)            {
                final int N = mActivityMonitors.size();
for(int i=0;i<N;i++)
                {
                    final ActivityMonitor am = mActivityMonitors.get(i);
                    am.match(activity, activity, activity.getIntent());
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.594 -0400", hash_original_method = "E084363C345B4BF61D861FC0D5D07D15", hash_generated_method = "C0454D95D8C523836B70846229FF49E4")
    public void callActivityOnRestoreInstanceState(Activity activity, Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
        addTaint(activity.getTaint());
        activity.performRestoreInstanceState(savedInstanceState);
        // ---------- Original Method ----------
        //activity.performRestoreInstanceState(savedInstanceState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.595 -0400", hash_original_method = "2BECA7ACE9ECA4B1DD0299ACB1DA09B9", hash_generated_method = "517B4A6C6608ED92FC6720A84F1F4D48")
    public void callActivityOnPostCreate(Activity activity, Bundle icicle) {
        addTaint(icicle.getTaint());
        addTaint(activity.getTaint());
        activity.onPostCreate(icicle);
        // ---------- Original Method ----------
        //activity.onPostCreate(icicle);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.595 -0400", hash_original_method = "5C607C7DDC680DB12532E9DB6F9CBC1F", hash_generated_method = "F828474EF8A20C9EC836F8E06653A174")
    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        addTaint(intent.getTaint());
        addTaint(activity.getTaint());
        activity.onNewIntent(intent);
        // ---------- Original Method ----------
        //activity.onNewIntent(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.596 -0400", hash_original_method = "92E54A7AE2339DA4EE7A292F370BB21D", hash_generated_method = "839162480452A6ED311438A09730ABDB")
    public void callActivityOnStart(Activity activity) {
        addTaint(activity.getTaint());
        activity.onStart();
        // ---------- Original Method ----------
        //activity.onStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.597 -0400", hash_original_method = "85BE14FC295678CF247F9E472F613652", hash_generated_method = "61FC05C0266591378AC47E2931FFFD28")
    public void callActivityOnRestart(Activity activity) {
        addTaint(activity.getTaint());
        activity.onRestart();
        // ---------- Original Method ----------
        //activity.onRestart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.599 -0400", hash_original_method = "7A6C498E491E406F2D113F8023D1483F", hash_generated_method = "90578509F773AC93D9072652AAD5772B")
    public void callActivityOnResume(Activity activity) {
        addTaint(activity.getTaint());
        activity.mResumed = true;
        activity.onResume();
    if(mActivityMonitors != null)        
        {
            synchronized
(mSync)            {
                final int N = mActivityMonitors.size();
for(int i=0;i<N;i++)
                {
                    final ActivityMonitor am = mActivityMonitors.get(i);
                    am.match(activity, activity, activity.getIntent());
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.601 -0400", hash_original_method = "0F89D6C7937A191011A20B47DB6599C5", hash_generated_method = "FBBD56724208F171B2F14F22E2612A0C")
    public void callActivityOnStop(Activity activity) {
        addTaint(activity.getTaint());
        activity.onStop();
        // ---------- Original Method ----------
        //activity.onStop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.602 -0400", hash_original_method = "E8ECFB0E3E7F6A98F4E3FE19FF7167B5", hash_generated_method = "E30581CB6FA350A95041A3972023EFE8")
    public void callActivityOnSaveInstanceState(Activity activity, Bundle outState) {
        addTaint(outState.getTaint());
        addTaint(activity.getTaint());
        activity.performSaveInstanceState(outState);
        // ---------- Original Method ----------
        //activity.performSaveInstanceState(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.603 -0400", hash_original_method = "A3AB5C16D17E1593B1F616581634810F", hash_generated_method = "83AFA0532B96417064295F4BBC3EFD99")
    public void callActivityOnPause(Activity activity) {
        addTaint(activity.getTaint());
        activity.performPause();
        // ---------- Original Method ----------
        //activity.performPause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.604 -0400", hash_original_method = "436C260B8868F376171ACCB198E870A3", hash_generated_method = "21FAF5ADA9022AD7CDA3E1795084B3A7")
    public void callActivityOnUserLeaving(Activity activity) {
        addTaint(activity.getTaint());
        activity.performUserLeaving();
        // ---------- Original Method ----------
        //activity.performUserLeaving();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.604 -0400", hash_original_method = "7FDB53D95055F8344C6717BAA41CDD62", hash_generated_method = "30C2B3835BA32D0C19AF35DC83FE7525")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.605 -0400", hash_original_method = "0DC5272531C251864B2A214C154F0F7A", hash_generated_method = "D46BBBE387BBBBD9A6E2A4FED2A36980")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.606 -0400", hash_original_method = "8051F011270999D9228A08818EFD61DD", hash_generated_method = "8868714604E8DB7AB8E2D72B050A5A11")
    private void addValue(String key, int value, Bundle results) {
        addTaint(results.getTaint());
        addTaint(value);
        addTaint(key.getTaint());
    if(results.containsKey(key))        
        {
            List<Integer> list = results.getIntegerArrayList(key);
    if(list != null)            
            {
                list.add(value);
            } //End block
        } //End block
        else
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(value);
            results.putIntegerArrayList(key, list);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.608 -0400", hash_original_method = "733DA96DDB5CBA410EC33155388CAA51", hash_generated_method = "79F9CEB7FBB72207A276E742C7A2F3DE")
    public Bundle getAllocCounts() {
        Bundle results = new Bundle();
        results.putLong("global_alloc_count", Debug.getGlobalAllocCount());
        results.putLong("global_alloc_size", Debug.getGlobalAllocSize());
        results.putLong("global_freed_count", Debug.getGlobalFreedCount());
        results.putLong("global_freed_size", Debug.getGlobalFreedSize());
        results.putLong("gc_invocation_count", Debug.getGlobalGcInvocationCount());
Bundle var238ECCC9872FFCA0B3C3DB83598FF044_1388406389 =         results;
        var238ECCC9872FFCA0B3C3DB83598FF044_1388406389.addTaint(taint);
        return var238ECCC9872FFCA0B3C3DB83598FF044_1388406389;
        // ---------- Original Method ----------
        //Bundle results = new Bundle();
        //results.putLong("global_alloc_count", Debug.getGlobalAllocCount());
        //results.putLong("global_alloc_size", Debug.getGlobalAllocSize());
        //results.putLong("global_freed_count", Debug.getGlobalFreedCount());
        //results.putLong("global_freed_size", Debug.getGlobalFreedSize());
        //results.putLong("gc_invocation_count", Debug.getGlobalGcInvocationCount());
        //return results;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.611 -0400", hash_original_method = "C29A199041D930C7B60D186159DABF9F", hash_generated_method = "D3FCE8EF88CF51AF6E12D28A928770A6")
    public Bundle getBinderCounts() {
        Bundle results = new Bundle();
        results.putLong("sent_transactions", Debug.getBinderSentTransactions());
        results.putLong("received_transactions", Debug.getBinderReceivedTransactions());
Bundle var238ECCC9872FFCA0B3C3DB83598FF044_2086314797 =         results;
        var238ECCC9872FFCA0B3C3DB83598FF044_2086314797.addTaint(taint);
        return var238ECCC9872FFCA0B3C3DB83598FF044_2086314797;
        // ---------- Original Method ----------
        //Bundle results = new Bundle();
        //results.putLong("sent_transactions", Debug.getBinderSentTransactions());
        //results.putLong("received_transactions", Debug.getBinderReceivedTransactions());
        //return results;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.614 -0400", hash_original_method = "2C6BFD417D58A73C3437D9BD22014CB6", hash_generated_method = "102DEA7C1B2D2F7EF7A081235242050A")
    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode) {
        addTaint(requestCode);
        addTaint(intent.getTaint());
        addTaint(target.getTaint());
        addTaint(token.getTaint());
        addTaint(contextThread.getTaint());
        addTaint(who.getTaint());
        IApplicationThread whoThread = (IApplicationThread) contextThread;
    if(mActivityMonitors != null)        
        {
            synchronized
(mSync)            {
                final int N = mActivityMonitors.size();
for(int i=0;i<N;i++)
                {
                    final ActivityMonitor am = mActivityMonitors.get(i);
    if(am.match(who, null, intent))                    
                    {
                        am.mHits++;
    if(am.isBlocking())                        
                        {
ActivityResult var11657B872FB65F1F3BB9439B5C315751_1702877654 =                             requestCode >= 0 ? am.getResult() : null;
                            var11657B872FB65F1F3BB9439B5C315751_1702877654.addTaint(taint);
                            return var11657B872FB65F1F3BB9439B5C315751_1702877654;
                        } //End block
                        break;
                    } //End block
                } //End block
            } //End block
        } //End block
        try 
        {
            intent.setAllowFds(false);
            int result = ActivityManagerNative.getDefault()
                .startActivity(whoThread, intent,
                        intent.resolveTypeIfNeeded(who.getContentResolver()),
                        null, 0, token, target != null ? target.mEmbeddedID : null,
                        requestCode, false, false, null, null, false);
            checkStartActivityResult(result, intent);
        } //End block
        catch (RemoteException e)
        {
        } //End block
ActivityResult var540C13E9E156B687226421B24F2DF178_1390272437 =         null;
        var540C13E9E156B687226421B24F2DF178_1390272437.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1390272437;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.615 -0400", hash_original_method = "7F406AB00C6E84903D3FA39AC1C6F8AE", hash_generated_method = "D16F843CF6CC2D988211CFCC6D02AFE9")
    public void execStartActivities(Context who, IBinder contextThread,
            IBinder token, Activity target, Intent[] intents) {
        addTaint(intents[0].getTaint());
        addTaint(target.getTaint());
        addTaint(token.getTaint());
        addTaint(contextThread.getTaint());
        addTaint(who.getTaint());
        IApplicationThread whoThread = (IApplicationThread) contextThread;
    if(mActivityMonitors != null)        
        {
            synchronized
(mSync)            {
                final int N = mActivityMonitors.size();
for(int i=0;i<N;i++)
                {
                    final ActivityMonitor am = mActivityMonitors.get(i);
    if(am.match(who, null, intents[0]))                    
                    {
                        am.mHits++;
    if(am.isBlocking())                        
                        {
                            return;
                        } //End block
                        break;
                    } //End block
                } //End block
            } //End block
        } //End block
        try 
        {
            String[] resolvedTypes = new String[intents.length];
for(int i=0;i<intents.length;i++)
            {
                intents[i].setAllowFds(false);
                resolvedTypes[i] = intents[i].resolveTypeIfNeeded(who.getContentResolver());
            } //End block
            int result = ActivityManagerNative.getDefault()
                .startActivities(whoThread, intents, resolvedTypes, token);
            checkStartActivityResult(result, intents[0]);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.616 -0400", hash_original_method = "D8D9B46CC68EC6EB44E02EECB84F8BB9", hash_generated_method = "C86E3A6B11DABDB370859AA45E9702ED")
    public ActivityResult execStartActivity(
        Context who, IBinder contextThread, IBinder token, Fragment target,
        Intent intent, int requestCode) {
        addTaint(requestCode);
        addTaint(intent.getTaint());
        addTaint(target.getTaint());
        addTaint(token.getTaint());
        addTaint(contextThread.getTaint());
        addTaint(who.getTaint());
        IApplicationThread whoThread = (IApplicationThread) contextThread;
    if(mActivityMonitors != null)        
        {
            synchronized
(mSync)            {
                final int N = mActivityMonitors.size();
for(int i=0;i<N;i++)
                {
                    final ActivityMonitor am = mActivityMonitors.get(i);
    if(am.match(who, null, intent))                    
                    {
                        am.mHits++;
    if(am.isBlocking())                        
                        {
ActivityResult var11657B872FB65F1F3BB9439B5C315751_1090356653 =                             requestCode >= 0 ? am.getResult() : null;
                            var11657B872FB65F1F3BB9439B5C315751_1090356653.addTaint(taint);
                            return var11657B872FB65F1F3BB9439B5C315751_1090356653;
                        } //End block
                        break;
                    } //End block
                } //End block
            } //End block
        } //End block
        try 
        {
            intent.setAllowFds(false);
            int result = ActivityManagerNative.getDefault()
                .startActivity(whoThread, intent,
                        intent.resolveTypeIfNeeded(who.getContentResolver()),
                        null, 0, token, target != null ? target.mWho : null,
                        requestCode, false, false, null, null, false);
            checkStartActivityResult(result, intent);
        } //End block
        catch (RemoteException e)
        {
        } //End block
ActivityResult var540C13E9E156B687226421B24F2DF178_1265293012 =         null;
        var540C13E9E156B687226421B24F2DF178_1265293012.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1265293012;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.619 -0400", hash_original_method = "B2107F3A70ADB2CB9368A3E0EA3587E6", hash_generated_method = "42B119C6203163811D713199383D8723")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.620 -0400", hash_original_method = "F94F35385602BE8879B41CCA4D6F8D26", hash_generated_method = "A3E09498DDA3816CF55E51B46A3BC356")
    private final void validateNotAppThread() {
    if(ActivityThread.currentActivityThread() != null)        
        {
            RuntimeException var3E51B64CAB9C971A4C87E5412624DF9A_1888498953 = new RuntimeException(
                "This method can not be called from the main application thread");
            var3E51B64CAB9C971A4C87E5412624DF9A_1888498953.addTaint(taint);
            throw var3E51B64CAB9C971A4C87E5412624DF9A_1888498953;
        } //End block
        // ---------- Original Method ----------
        //if (ActivityThread.currentActivityThread() != null) {
            //throw new RuntimeException(
                //"This method can not be called from the main application thread");
        //}
    }

    
    public static class ActivityMonitor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.621 -0400", hash_original_field = "0897AC215ECF8155758EFD206F32E8DB", hash_generated_field = "AF74A86DAFFBC4B54B5C18398CFDAB42")

        private IntentFilter mWhich;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.621 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "5E2CA74CC8E570ED6932C7E63B69D503")

        private String mClass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.621 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "2C01E1B2BB3E6DFFE6E3668CD94CB3E6")

        private ActivityResult mResult;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.621 -0400", hash_original_field = "E5ADD54C021234204DB48E99A01961D7", hash_generated_field = "6781DA6A293ED68705EB1F6D6AF21DBE")

        private boolean mBlock;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.621 -0400", hash_original_field = "55149A6B502A641554A8D5631A93175B", hash_generated_field = "C00AE67DB98B5AE298A1158B3E81E69C")

        int mHits = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.621 -0400", hash_original_field = "36FBBE397ECFED22994E73164648FBBB", hash_generated_field = "78E79A1B34133AC2215BE692FE7324EA")

        Activity mLastActivity = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.622 -0400", hash_original_method = "44AA99B3E06F91C4A28CA95A02F486A4", hash_generated_method = "E4A5E6742246C5439461F3551FABFFC9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.623 -0400", hash_original_method = "96127A12D0FD338A76B8651F7EF76641", hash_generated_method = "B8CB547530469F4780DD76CC734AFA8D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.624 -0400", hash_original_method = "5CEC767AFA0B77CA42139688DDFFE7D0", hash_generated_method = "BA16D14530FA3391EDDA876C407C28B4")
        public final IntentFilter getFilter() {
IntentFilter var7A6583B89023FF3098B73650E09B0508_789317069 =             mWhich;
            var7A6583B89023FF3098B73650E09B0508_789317069.addTaint(taint);
            return var7A6583B89023FF3098B73650E09B0508_789317069;
            // ---------- Original Method ----------
            //return mWhich;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.624 -0400", hash_original_method = "907D5A2A73ED7959ACD2198F97C8DDFD", hash_generated_method = "D06E7538C8BD0628F9F7615C6D4F5790")
        public final ActivityResult getResult() {
ActivityResult var8EC17D26103D23643357521909BC2C9A_248035709 =             mResult;
            var8EC17D26103D23643357521909BC2C9A_248035709.addTaint(taint);
            return var8EC17D26103D23643357521909BC2C9A_248035709;
            // ---------- Original Method ----------
            //return mResult;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.624 -0400", hash_original_method = "6E6027F9B3B42A9863ABB214525B0A55", hash_generated_method = "84F2221A782038C66750B7EBE3C52CA6")
        public final boolean isBlocking() {
            boolean varE5ADD54C021234204DB48E99A01961D7_1498009511 = (mBlock);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2007403872 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2007403872;
            // ---------- Original Method ----------
            //return mBlock;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.625 -0400", hash_original_method = "6A2B57F4CCAF664CD709CE454AF8AF4E", hash_generated_method = "A27356C7F52D72EBA107DC5ADD0158F5")
        public final int getHits() {
            int var5ECB2354C5ACBBFBE9428ACC00A6CC57_1417292978 = (mHits);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413895289 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413895289;
            // ---------- Original Method ----------
            //return mHits;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.625 -0400", hash_original_method = "1AD813C5DE346D876C42D8A64F1E0FB4", hash_generated_method = "301554B1747F79A3F2A979904CEB3036")
        public final Activity getLastActivity() {
Activity varB2DA8B7B053D8CC25E96301AE1CAB7FD_608310281 =             mLastActivity;
            varB2DA8B7B053D8CC25E96301AE1CAB7FD_608310281.addTaint(taint);
            return varB2DA8B7B053D8CC25E96301AE1CAB7FD_608310281;
            // ---------- Original Method ----------
            //return mLastActivity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.626 -0400", hash_original_method = "905168F82A17E43399C57E76AC6D268D", hash_generated_method = "1D2DAE2083DED1AAE6D615FD94474A16")
        public final Activity waitForActivity() {
            synchronized
(this)            {
                while
(mLastActivity == null)                
                {
                    try 
                    {
                        wait();
                    } //End block
                    catch (InterruptedException e)
                    {
                    } //End block
                } //End block
                Activity res = mLastActivity;
                mLastActivity = null;
Activity varB5053E025797B3BF768F5C37934C244D_1990769691 =                 res;
                varB5053E025797B3BF768F5C37934C244D_1990769691.addTaint(taint);
                return varB5053E025797B3BF768F5C37934C244D_1990769691;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.627 -0400", hash_original_method = "68E343228598567180DC80BCAD1066EC", hash_generated_method = "A62781880D283A750677C9898D932E50")
        public final Activity waitForActivityWithTimeout(long timeOut) {
            addTaint(timeOut);
            synchronized
(this)            {
    if(mLastActivity == null)                
                {
                    try 
                    {
                        wait(timeOut);
                    } //End block
                    catch (InterruptedException e)
                    {
                    } //End block
                } //End block
    if(mLastActivity == null)                
                {
Activity var540C13E9E156B687226421B24F2DF178_639053344 =                     null;
                    var540C13E9E156B687226421B24F2DF178_639053344.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_639053344;
                } //End block
                else
                {
                    Activity res = mLastActivity;
                    mLastActivity = null;
Activity varB5053E025797B3BF768F5C37934C244D_2087176395 =                     res;
                    varB5053E025797B3BF768F5C37934C244D_2087176395.addTaint(taint);
                    return varB5053E025797B3BF768F5C37934C244D_2087176395;
                } //End block
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.628 -0400", hash_original_method = "81CE78024E25171646CA4AFCDB286C47", hash_generated_method = "1A20AA10217E8E053450E0F4C6D026FE")
        final boolean match(Context who,
                            Activity activity,
                            Intent intent) {
            addTaint(intent.getTaint());
            addTaint(who.getTaint());
            synchronized
(this)            {
    if(mWhich != null
                    && mWhich.match(who.getContentResolver(), intent,
                                    true, "Instrumentation") < 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_445961093 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_674219547 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_674219547;
                } //End block
    if(mClass != null)                
                {
                    String cls = null;
    if(activity != null)                    
                    {
                        cls = activity.getClass().getName();
                    } //End block
                    else
    if(intent.getComponent() != null)                    
                    {
                        cls = intent.getComponent().getClassName();
                    } //End block
    if(cls == null || !mClass.equals(cls))                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_988043362 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_233511653 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_233511653;
                    } //End block
                } //End block
    if(activity != null)                
                {
                    mLastActivity = activity;
                    notifyAll();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_381043588 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498425518 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498425518;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static final class ActivityResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.630 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")

        private int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.630 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "2ACA4EFB7F1C3D021D8C2319D9F4A1B0")

        private Intent mResultData;
        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.632 -0400", hash_original_method = "C450F5B8EDB38A231DF953C34FD7C745", hash_generated_method = "24DA7F362B57EA7AFBB13D11AD29E232")
        public  ActivityResult(int resultCode, Intent resultData) {
            mResultCode = resultCode;
            mResultData = resultData;
            // ---------- Original Method ----------
            //mResultCode = resultCode;
            //mResultData = resultData;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.633 -0400", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "2E9746437A355BD7EFBA9E3517C45C4E")
        public int getResultCode() {
            int varE5CED19E692744D577EC9F38B767773F_1111679257 = (mResultCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050887651 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050887651;
            // ---------- Original Method ----------
            //return mResultCode;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.634 -0400", hash_original_method = "230B95D397C0359A2CE808B90BABA149", hash_generated_method = "9D97A707088BC8DABA21A74193578A83")
        public Intent getResultData() {
Intent var7AF81C367EA4623980C8741236739982_230886168 =             mResultData;
            var7AF81C367EA4623980C8741236739982_230886168.addTaint(taint);
            return var7AF81C367EA4623980C8741236739982_230886168;
            // ---------- Original Method ----------
            //return mResultData;
        }

        
    }


    
    private final class InstrumentationThread extends Thread {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.634 -0400", hash_original_method = "63270DA70BB76F2F3E4D4969BE7BFAFC", hash_generated_method = "1846024E4D47701B100381EAE9601478")
        public  InstrumentationThread(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.635 -0400", hash_original_method = "801DE955A4997069AEAE1C9E4306FFC2", hash_generated_method = "D7FD4C2EC28F1DBA09F02A0163C49B05")
        public void run() {
            IActivityManager am = ActivityManagerNative.getDefault();
            try 
            {
                Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_DISPLAY);
            } //End block
            catch (RuntimeException e)
            {
            } //End block
    if(mAutomaticPerformanceSnapshots)            
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.635 -0400", hash_original_method = "9351A801773C8F1D9056187EA700F8B4", hash_generated_method = "9351A801773C8F1D9056187EA700F8B4")
        public EmptyRunnable ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.636 -0400", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "A2E5AE58616EECC7176440E5139E1684")
        public void run() {
            // ---------- Original Method ----------
        }

        
    }


    
    private static final class SyncRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.636 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "B38DEE567D624A06D39175E911A12BE6")

        private Runnable mTarget;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.636 -0400", hash_original_field = "FD1D40CA7A22C1FB8C4721FF4D7B4E13", hash_generated_field = "C7DFAA7BAEC783B90B2A4CC60586CA74")

        private boolean mComplete;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.637 -0400", hash_original_method = "52C4D1F6D6B56C48522BD51EB3CA3671", hash_generated_method = "5D92DD35625E7C01B1A427675450D4FF")
        public  SyncRunnable(Runnable target) {
            mTarget = target;
            // ---------- Original Method ----------
            //mTarget = target;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.637 -0400", hash_original_method = "44AE594487B622FAC5CF0DF348DF4C16", hash_generated_method = "91CEAC2172AC3353D1797437797450CD")
        public void run() {
            mTarget.run();
            synchronized
(this)            {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.638 -0400", hash_original_method = "02D1E24DCA4BB39BCA765C3BAB20012A", hash_generated_method = "11A877631E126555698F80E27FF48AD4")
        public void waitForComplete() {
            synchronized
(this)            {
                while
(!mComplete)                
                {
                    try 
                    {
                        wait();
                    } //End block
                    catch (InterruptedException e)
                    {
                    } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.638 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "5DEDAC72AD89B3864945324786195E0B")

        public Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.639 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "8EB481EDAD2FDE318A05890E655F5C10")

        public Activity activity;
        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.639 -0400", hash_original_method = "749CA2F0047E4C5ABC5CE22C281FA095", hash_generated_method = "3059D2ED47C5D0B987E8709844E0C081")
        public  ActivityWaiter(Intent _intent) {
            intent = _intent;
            // ---------- Original Method ----------
            //intent = _intent;
        }

        
    }


    
    private final class ActivityGoing implements MessageQueue.IdleHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.640 -0400", hash_original_field = "BFB5BEE603E80EEC1A8030FC0DC96B43", hash_generated_field = "D1D9DBA4EB12F84FE5F9E1BF6FFC4059")

        private ActivityWaiter mWaiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.640 -0400", hash_original_method = "C941F219CD1DB06313DFA66C54B64070", hash_generated_method = "112E0EFA9E3E1E4D0209C198398F4B90")
        public  ActivityGoing(ActivityWaiter waiter) {
            mWaiter = waiter;
            // ---------- Original Method ----------
            //mWaiter = waiter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.641 -0400", hash_original_method = "6BEF536DFBCFB4C74EC4C0EA4FEAD5BE", hash_generated_method = "01C46F9078224A425A1E658F78F15C68")
        public final boolean queueIdle() {
            synchronized
(mSync)            {
                mWaitingActivities.remove(mWaiter);
                mSync.notifyAll();
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1479189333 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952556516 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_952556516;
            // ---------- Original Method ----------
            //synchronized (mSync) {
                //mWaitingActivities.remove(mWaiter);
                //mSync.notifyAll();
            //}
            //return false;
        }

        
    }


    
    private static final class Idler implements MessageQueue.IdleHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.641 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "A3563124F239CF73FFEC0EB79C97D4FC")

        private Runnable mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.642 -0400", hash_original_field = "55AD180A169FF1C7D858A291A97089D7", hash_generated_field = "9B659026DF37979A10F87338BD5AE24B")

        private boolean mIdle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.642 -0400", hash_original_method = "4434628995BB6492F17F2A3E55C00ABF", hash_generated_method = "63FBA13112CEF4A27296386CBFEF1690")
        public  Idler(Runnable callback) {
            mCallback = callback;
            mIdle = false;
            // ---------- Original Method ----------
            //mCallback = callback;
            //mIdle = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.643 -0400", hash_original_method = "B0AE6A8D5B64501509EFCE6FDAF91034", hash_generated_method = "EE0FDC7E041FDB04DF3AB75D72D2FE4F")
        public final boolean queueIdle() {
    if(mCallback != null)            
            {
                mCallback.run();
            } //End block
            synchronized
(this)            {
                mIdle = true;
                notifyAll();
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_267354832 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267132506 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267132506;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.643 -0400", hash_original_method = "DF4D50EB6BB518BE09549DCD9C0630C1", hash_generated_method = "25A901D8D0C38E4AC0C81028606466F8")
        public void waitForIdle() {
            synchronized
(this)            {
                while
(!mIdle)                
                {
                    try 
                    {
                        wait();
                    } //End block
                    catch (InterruptedException e)
                    {
                    } //End block
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.643 -0400", hash_original_field = "C67C9833A29A3C3AA6E6F75E1F3C2F60", hash_generated_field = "B1FDF1E5A9E128A7382EC05D1B2C02BE")

    public static final String REPORT_KEY_IDENTIFIER = "id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.644 -0400", hash_original_field = "DF34AF130918581DB93971EEC13B8486", hash_generated_field = "13C91CEB9ED83DD17ABB1FD056C7003C")

    public static final String REPORT_KEY_STREAMRESULT = "stream";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.644 -0400", hash_original_field = "CF06207C135ED2AE013476D0083DE7AA", hash_generated_field = "A6549731053B582294DF4842CC523BD8")

    private static final String TAG = "Instrumentation";
}

