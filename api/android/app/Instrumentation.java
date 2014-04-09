package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.os.MessageQueue;
import android.os.PerformanceCollector;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.AndroidRuntimeException;
import android.view.IWindowManager;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.Window;

public class Instrumentation {
    
    /**
     * Perform instantiation of the process's {@link Application} object.  The
     * default implementation provides the normal system behavior.
     * 
     * @param clazz The class used to create an Application object from.
     * @param context The context to initialize the application with
     * 
     * @return The newly instantiated Application object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.198 -0500", hash_original_method = "AFB44FBA32CAE269CE2A04280BCD2F62", hash_generated_method = "B89EFB93C7726832C199AB65CC29841D")
    
static public Application newApplication(Class<?> clazz, Context context)
            throws InstantiationException, IllegalAccessException, 
            ClassNotFoundException {
        Application app = (Application)clazz.newInstance();
        app.attach(context);
        return app;
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.271 -0500", hash_original_method = "EA993055DB510E2C2B619EED4CD3438E", hash_generated_method = "2B7FC3687024DFF3E3C0F6C494EB6AC8")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.003 -0500", hash_original_field = "0B8E9B3AA8EB9C345AADE0033BCDF048", hash_generated_field = "B1FDF1E5A9E128A7382EC05D1B2C02BE")

    public static final String REPORT_KEY_IDENTIFIER = "id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.005 -0500", hash_original_field = "55D338BA141DAA15565D2902308EE82D", hash_generated_field = "13C91CEB9ED83DD17ABB1FD056C7003C")

    public static final String REPORT_KEY_STREAMRESULT = "stream";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.007 -0500", hash_original_field = "7DAF15C2214938E7EB8B8D6BA4BA65F6", hash_generated_field = "A6549731053B582294DF4842CC523BD8")
    
    private static final String TAG = "Instrumentation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.009 -0500", hash_original_field = "349D1EAD6A3DD6EDFBBB76E7AC55FC2F", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")
    
    private final Object mSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.011 -0500", hash_original_field = "1DCC86ACED37EA88F412C3388F4C9815", hash_generated_field = "4DECD94BE6B0174DE36067CBF50C84C9")

    private ActivityThread mThread = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.013 -0500", hash_original_field = "72A9BE7CE8145E6E998E27021B535FC3", hash_generated_field = "EE117464CCFBB71A57DA2F8BADEB6233")

    private MessageQueue mMessageQueue = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.016 -0500", hash_original_field = "C9B1769CEB5D2BBE57D5BBF2FA666AC8", hash_generated_field = "CF9AE987035AAD94FADA826204456158")

    private Context mInstrContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.018 -0500", hash_original_field = "EA4750DA6687DD56CD040978206975ED", hash_generated_field = "722D46A23A9E453AC7AC6D5797C29418")

    private Context mAppContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.020 -0500", hash_original_field = "FC166AFC662871D7EC38777C0105881C", hash_generated_field = "1B40E7C57A0B1682389BAE16521C0844")

    private ComponentName mComponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.022 -0500", hash_original_field = "7ED8E7719FAE6F86660D1AF4BCC9CF18", hash_generated_field = "83CDC5A21BC91E43BA3B83822ED24524")

    private Thread mRunner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.024 -0500", hash_original_field = "20CCE29370D20D3A83951FB4D146BECD", hash_generated_field = "A6C142CC3F6E6296AB67C595830F5086")

    private List<ActivityWaiter> mWaitingActivities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.026 -0500", hash_original_field = "253EBD4CE8665C15424144ECD28CFD0F", hash_generated_field = "5A3BE51583B9275D70583A158D75384D")

    private List<ActivityMonitor> mActivityMonitors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.028 -0500", hash_original_field = "40D7043F88849B0B535F2BD6048827F4", hash_generated_field = "BD19A60B1E71F2A79E53A58C34F52CB2")

    private IInstrumentationWatcher mWatcher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.031 -0500", hash_original_field = "FAEE5BD536F4CD9B7DF58C23A6F6821C", hash_generated_field = "C00E68D542ECF5CA8FC17F9FED17FEEA")

    private boolean mAutomaticPerformanceSnapshots = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.033 -0500", hash_original_field = "36B6802E3DB9EA0F72FEF225DD6F4175", hash_generated_field = "68DE569686980EC11F79E2F9C9488F60")

    private PerformanceCollector mPerformanceCollector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.035 -0500", hash_original_field = "36A9676A8430776CC6FD07DC2C0D3429", hash_generated_field = "74370D5BDE597F43882751037480C6FB")

    private Bundle mPerfMetrics = new Bundle();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.037 -0500", hash_original_method = "2A2FEB9F4AAE35A924F5C88DA8F6FDF1", hash_generated_method = "DAAC01208288F58E96162AA048AA39F5")
    
public Instrumentation() {
    }

    /**
     * Called when the instrumentation is starting, before any application code
     * has been loaded.  Usually this will be implemented to simply call
     * {@link #start} to begin the instrumentation thread, which will then
     * continue execution in {@link #onStart}.
     * 
     * <p>If you do not need your own thread -- that is you are writing your
     * instrumentation to be completely asynchronous (returning to the event
     * loop so that the application can run), you can simply begin your
     * instrumentation here, for example call {@link Context#startActivity} to
     * begin the appropriate first activity of the application. 
     *  
     * @param arguments Any additional arguments that were supplied when the 
     *                  instrumentation was started.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.039 -0500", hash_original_method = "4B024CDE66137DA3ED66BF57127A0E80", hash_generated_method = "FD724EC6217F37A4C66C91309A4B069D")
    
public void onCreate(Bundle arguments) {
    }

    /**
     * Create and start a new thread in which to run instrumentation.  This new
     * thread will call to {@link #onStart} where you can implement the
     * instrumentation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.042 -0500", hash_original_method = "75096E18A1A48E91D30DD9D6FBFD5D1F", hash_generated_method = "1E2706DE60A02D54620F196B92C537DA")
    
public void start() {
        if (mRunner != null) {
            throw new RuntimeException("Instrumentation already started");
        }
        mRunner = new InstrumentationThread("Instr: " + getClass().getName());
        mRunner.start();
    }

    /**
     * Method where the instrumentation thread enters execution.  This allows
     * you to run your instrumentation code in a separate thread than the
     * application, so that it can perform blocking operation such as
     * {@link #sendKeySync} or {@link #startActivitySync}.
     * 
     * <p>You will typically want to call finish() when this function is done,
     * to end your instrumentation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.044 -0500", hash_original_method = "0451E38101EC2D69951E664FB36904F0", hash_generated_method = "2FD8444A3A1FF37609A1D0BEB76319DD")
    
public void onStart() {
    }

    /**
     * This is called whenever the system captures an unhandled exception that
     * was thrown by the application.  The default implementation simply
     * returns false, allowing normal system handling of the exception to take
     * place.
     * 
     * @param obj The client object that generated the exception.  May be an
     *            Application, Activity, BroadcastReceiver, Service, or null.
     * @param e The exception that was thrown.
     *  
     * @return To allow normal system exception process to occur, return false.
     *         If true is returned, the system will proceed as if the exception
     *         didn't happen.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.046 -0500", hash_original_method = "8DC9492B498FF3067475C41C79EEAB3B", hash_generated_method = "9BE872B75FB064CD381E454316EBF68C")
    
public boolean onException(Object obj, Throwable e) {
        return false;
    }

    /**
     * Provide a status report about the application.
     *  
     * @param resultCode Current success/failure of instrumentation. 
     * @param results Any results to send back to the code that started the instrumentation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.048 -0500", hash_original_method = "5CE1AB9DF7D7162F89956B1D13BE745E", hash_generated_method = "31A9F3A8193481445E2152C80BE55093")
    
public void sendStatus(int resultCode, Bundle results) {
        if (mWatcher != null) {
            try {
                mWatcher.instrumentationStatus(mComponent, resultCode, results);
            }
            catch (RemoteException e) {
                mWatcher = null;
            }
        }
    }
    
    /**
     * Terminate instrumentation of the application.  This will cause the
     * application process to exit, removing this instrumentation from the next
     * time the application is started. 
     *  
     * @param resultCode Overall success/failure of instrumentation. 
     * @param results Any results to send back to the code that started the 
     *                instrumentation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.050 -0500", hash_original_method = "93CEFEE99BA727186FFD22BEC1D0D072", hash_generated_method = "2A8D554863F54BC85029412975D5A381")
    
public void finish(int resultCode, Bundle results) {
        if (mAutomaticPerformanceSnapshots) {
            endPerformanceSnapshot();
        }
        if (mPerfMetrics != null) {
            results.putAll(mPerfMetrics);
        }
        mThread.finishInstrumentation(resultCode, results);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.052 -0500", hash_original_method = "6EB9EED76498D1668A96326FD6FFBEE9", hash_generated_method = "440CAFE50CF5C592984670D4D87B5755")
    
public void setAutomaticPerformanceSnapshots() {
        mAutomaticPerformanceSnapshots = true;
        mPerformanceCollector = new PerformanceCollector();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.054 -0500", hash_original_method = "59F6F337F904783653DF79F6C5B4E5AA", hash_generated_method = "3ECCC1F19DA0FDFF76400DCC88CD64A3")
    
public void startPerformanceSnapshot() {
        if (!isProfiling()) {
            mPerformanceCollector.beginSnapshot(null);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.056 -0500", hash_original_method = "8BB380F00D03C999D4B5625E8ECD5AAA", hash_generated_method = "260FFF7A2F23D446AF1C21B0E86E4E20")
    
public void endPerformanceSnapshot() {
        if (!isProfiling()) {
            mPerfMetrics = mPerformanceCollector.endSnapshot();
        }
    }
    
    /**
     * Called when the instrumented application is stopping, after all of the
     * normal application cleanup has occurred.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.058 -0500", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "B543AE4E1838FF864DE64776FEE21A06")
    
public void onDestroy() {
    }

    /**
     * Return the Context of this instrumentation's package.  Note that this is
     * often different than the Context of the application being
     * instrumentated, since the instrumentation code often lives is a
     * different package than that of the application it is running against.
     * See {@link #getTargetContext} to retrieve a Context for the target
     * application.
     * 
     * @return The instrumentation's package context.
     * 
     * @see #getTargetContext
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.061 -0500", hash_original_method = "0612F59C08E6EE31E243F52D2CCB68AA", hash_generated_method = "CED92F4D868F4EE82F3F4B62AE9813BA")
    
public Context getContext() {
        return mInstrContext;
    }

    /**
     * Returns complete component name of this instrumentation.
     * 
     * @return Returns the complete component name for this instrumentation.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.063 -0500", hash_original_method = "6C1D36E28C0C97736EA4779A7FB1715C", hash_generated_method = "0218C20A36476A71EF5D80D906810879")
    
public ComponentName getComponentName() {
        return mComponent;
    }
    
    /**
     * Return a Context for the target application being instrumented.  Note
     * that this is often different than the Context of the instrumentation
     * code, since the instrumentation code often lives is a different package
     * than that of the application it is running against. See
     * {@link #getContext} to retrieve a Context for the instrumentation code.
     * 
     * @return A Context in the target application.
     * 
     * @see #getContext
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.065 -0500", hash_original_method = "D1026223DF11B7056861FB0AA4B64828", hash_generated_method = "4B2320D69B2781FFCE4561936A920812")
    
public Context getTargetContext() {
        return mAppContext;
    }

    /**
     * Check whether this instrumentation was started with profiling enabled.
     * 
     * @return Returns true if profiling was enabled when starting, else false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.067 -0500", hash_original_method = "7D34AF538E9A67DEA76272AB02F2CDC6", hash_generated_method = "BDC0CC98902031F367B4EBF54D94EDAF")
    
public boolean isProfiling() {
        return mThread.isProfiling();
    }

    /**
     * This method will start profiling if isProfiling() returns true. You should
     * only call this method if you set the handleProfiling attribute in the 
     * manifest file for this Instrumentation to true.  
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.069 -0500", hash_original_method = "988500FDA3CAE61033EABAD95C8BF0F1", hash_generated_method = "DD9C02800C5798E8159C5027D473F265")
    
public void startProfiling() {
        if (mThread.isProfiling()) {
            File file = new File(mThread.getProfileFilePath());
            file.getParentFile().mkdirs();
            Debug.startMethodTracing(file.toString(), 8 * 1024 * 1024);
        }
    }

    /**
     * Stops profiling if isProfiling() returns true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.071 -0500", hash_original_method = "1FEC2A39C917937DB00CBC5BA91E5501", hash_generated_method = "BB37420F70B665076F94DCFCD970A581")
    
public void stopProfiling() {
        if (mThread.isProfiling()) {
            Debug.stopMethodTracing();
        }
    }
    
    /**
     * Force the global system in or out of touch mode.  This can be used if
     * your instrumentation relies on the UI being in one more or the other
     * when it starts.
     * 
     * @param inTouch Set to true to be in touch mode, false to be in
     * focus mode.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.074 -0500", hash_original_method = "EEC5F78C5E75C7158C64611E1694E1A0", hash_generated_method = "29441361A373C07D4DBF7405867532BB")
    
public void setInTouchMode(boolean inTouch) {
        try {
            IWindowManager.Stub.asInterface(
                    ServiceManager.getService("window")).setInTouchMode(inTouch);
        } catch (RemoteException e) {
            // Shouldn't happen!
        }
    }
    
    /**
     * Schedule a callback for when the application's main thread goes idle
     * (has no more events to process).
     * 
     * @param recipient Called the next time the thread's message queue is
     *                  idle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.076 -0500", hash_original_method = "9CBDEDF34C527A410521706D53450B12", hash_generated_method = "49A7A7A3637AB734AAB578182CC5AFC2")
    
public void waitForIdle(Runnable recipient) {
        mMessageQueue.addIdleHandler(new Idler(recipient));
        mThread.getHandler().post(new EmptyRunnable());
    }

    /**
     * Synchronously wait for the application to be idle.  Can not be called
     * from the main application thread -- use {@link #start} to execute
     * instrumentation in its own thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.078 -0500", hash_original_method = "89AA1CC3D27AC9ADF27421ED4392817A", hash_generated_method = "DE1859567A770B050775C9B8F3FAA49E")
    
public void waitForIdleSync() {
        validateNotAppThread();
        Idler idler = new Idler(null);
        mMessageQueue.addIdleHandler(idler);
        mThread.getHandler().post(new EmptyRunnable());
        idler.waitForIdle();
    }

    /**
     * Execute a call on the application's main thread, blocking until it is
     * complete.  Useful for doing things that are not thread-safe, such as
     * looking at or modifying the view hierarchy.
     * 
     * @param runner The code to run on the main thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.080 -0500", hash_original_method = "23FE2246FE60A7859CD93D836CF467DE", hash_generated_method = "0EF3D39AA54E6C404C253299675A50A8")
    
public void runOnMainSync(Runnable runner) {
        validateNotAppThread();
        SyncRunnable sr = new SyncRunnable(runner);
        mThread.getHandler().post(sr);
        sr.waitForComplete();
    }

    /**
     * Start a new activity and wait for it to begin running before returning.
     * In addition to being synchronous, this method as some semantic
     * differences from the standard {@link Context#startActivity} call: the
     * activity component is resolved before talking with the activity manager
     * (its class name is specified in the Intent that this method ultimately
     * starts), and it does not allow you to start activities that run in a
     * different process.  In addition, if the given Intent resolves to
     * multiple activities, instead of displaying a dialog for the user to
     * select an activity, an exception will be thrown.
     * 
     * <p>The function returns as soon as the activity goes idle following the
     * call to its {@link Activity#onCreate}.  Generally this means it has gone
     * through the full initialization including {@link Activity#onResume} and
     * drawn and displayed its initial window.
     * 
     * @param intent Description of the activity to start.
     * 
     * @see Context#startActivity
     */
    @DSSink({DSSinkKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.084 -0500", hash_original_method = "834B647755C86ED587A771C499B38AF8", hash_generated_method = "15B067D8E4EB48AB10815059D86B5E66")
    
public Activity startActivitySync(Intent intent) {
        validateNotAppThread();

        synchronized (mSync) {
            intent = new Intent(intent);
    
            ActivityInfo ai = intent.resolveActivityInfo(
                getTargetContext().getPackageManager(), 0);
            if (ai == null) {
                throw new RuntimeException("Unable to resolve activity for: " + intent);
            }
            String myProc = mThread.getProcessName();
            if (!ai.processName.equals(myProc)) {
                // todo: if this intent is ambiguous, look here to see if
                // there is a single match that is in our package.
                throw new RuntimeException("Intent in process "
                        + myProc + " resolved to different process "
                        + ai.processName + ": " + intent);
            }
    
            intent.setComponent(new ComponentName(
                    ai.applicationInfo.packageName, ai.name));
            final ActivityWaiter aw = new ActivityWaiter(intent);

            if (mWaitingActivities == null) {
                mWaitingActivities = new ArrayList();
            }
            mWaitingActivities.add(aw);

            getTargetContext().startActivity(intent);

            do {
                try {
                    mSync.wait();
                } catch (InterruptedException e) {
                }
            } while (mWaitingActivities.contains(aw));
         
            return aw.activity;
        }
    }

    /**
     * Add a new {@link ActivityMonitor} that will be checked whenever an 
     * activity is started.  The monitor is added 
     * after any existing ones; the monitor will be hit only if none of the 
     * existing monitors can themselves handle the Intent. 
     *  
     * @param monitor The new ActivityMonitor to see. 
     *  
     * @see #addMonitor(IntentFilter, ActivityResult, boolean) 
     * @see #checkMonitorHit 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.129 -0500", hash_original_method = "608AF20D37ADB77B72D35062305FF16B", hash_generated_method = "B53923ACBBFB1D419A114A077199E3E1")
    
public void addMonitor(ActivityMonitor monitor) {
        synchronized (mSync) {
            if (mActivityMonitors == null) {
                mActivityMonitors = new ArrayList();
            }
            mActivityMonitors.add(monitor);
        }
    }

    /**
     * A convenience wrapper for {@link #addMonitor(ActivityMonitor)} that 
     * creates an intent filter matching {@link ActivityMonitor} for you and 
     * returns it. 
     *  
     * @param filter The set of intents this monitor is responsible for.
     * @param result A canned result to return if the monitor is hit; can 
     *               be null.
     * @param block Controls whether the monitor should block the activity 
     *              start (returning its canned result) or let the call
     *              proceed.
     * 
     * @return The newly created and added activity monitor. 
     *  
     * @see #addMonitor(ActivityMonitor) 
     * @see #checkMonitorHit 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.131 -0500", hash_original_method = "A7BDDA46B206533FE67A2A87AD7D2268", hash_generated_method = "4C95A6F93DF88940CE6A67067AC4FE00")
    
public ActivityMonitor addMonitor(
        IntentFilter filter, ActivityResult result, boolean block) {
        ActivityMonitor am = new ActivityMonitor(filter, result, block);
        addMonitor(am);
        return am;
    }

    /**
     * A convenience wrapper for {@link #addMonitor(ActivityMonitor)} that 
     * creates a class matching {@link ActivityMonitor} for you and returns it.
     *  
     * @param cls The activity class this monitor is responsible for.
     * @param result A canned result to return if the monitor is hit; can 
     *               be null.
     * @param block Controls whether the monitor should block the activity 
     *              start (returning its canned result) or let the call
     *              proceed.
     * 
     * @return The newly created and added activity monitor. 
     *  
     * @see #addMonitor(ActivityMonitor) 
     * @see #checkMonitorHit 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.133 -0500", hash_original_method = "1AE73A4BC3EDE4468A3DB90D9129EBCC", hash_generated_method = "E255D4024EF5F3F0E6977E1C71153DC7")
    
public ActivityMonitor addMonitor(
        String cls, ActivityResult result, boolean block) {
        ActivityMonitor am = new ActivityMonitor(cls, result, block);
        addMonitor(am);
        return am;
    }

    /**
     * Test whether an existing {@link ActivityMonitor} has been hit.  If the 
     * monitor has been hit at least <var>minHits</var> times, then it will be 
     * removed from the activity monitor list and true returned.  Otherwise it 
     * is left as-is and false is returned. 
     *  
     * @param monitor The ActivityMonitor to check.
     * @param minHits The minimum number of hits required.
     * 
     * @return True if the hit count has been reached, else false. 
     *  
     * @see #addMonitor 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.136 -0500", hash_original_method = "29E7A5CE85EC83DC1A6299DE5A3CFA02", hash_generated_method = "33F5136CD9C80BCF7162FEECC9B9C8A5")
    
public boolean checkMonitorHit(ActivityMonitor monitor, int minHits) {
        waitForIdleSync();
        synchronized (mSync) {
            if (monitor.getHits() < minHits) {
                return false;
            }
            mActivityMonitors.remove(monitor);
        }
        return true;
    }

    /**
     * Wait for an existing {@link ActivityMonitor} to be hit.  Once the 
     * monitor has been hit, it is removed from the activity monitor list and 
     * the first created Activity object that matched it is returned.
     *  
     * @param monitor The ActivityMonitor to wait for.
     * 
     * @return The Activity object that matched the monitor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.138 -0500", hash_original_method = "ACAA082ACBE3DC4BF5F5B838A83827D9", hash_generated_method = "482E508FD2A2DFC5B5F633DD5B3135B6")
    
public Activity waitForMonitor(ActivityMonitor monitor) {
        Activity activity = monitor.waitForActivity();
        synchronized (mSync) {
            mActivityMonitors.remove(monitor);
        }
        return activity;
    }

    /**
     * Wait for an existing {@link ActivityMonitor} to be hit till the timeout
     * expires.  Once the monitor has been hit, it is removed from the activity 
     * monitor list and the first created Activity object that matched it is 
     * returned.  If the timeout expires, a null object is returned. 
     *
     * @param monitor The ActivityMonitor to wait for.
     * @param timeOut The timeout value in secs.
     *
     * @return The Activity object that matched the monitor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.140 -0500", hash_original_method = "C35EC81162DCBEC6CBBF630B6FBC9A38", hash_generated_method = "8389BF6FA00666D69AD0616DD6774396")
    
public Activity waitForMonitorWithTimeout(ActivityMonitor monitor, long timeOut) {
        Activity activity = monitor.waitForActivityWithTimeout(timeOut);
        synchronized (mSync) {
            mActivityMonitors.remove(monitor);
        }
        return activity;
    }
    
    /**
     * Remove an {@link ActivityMonitor} that was previously added with 
     * {@link #addMonitor}.
     *  
     * @param monitor The monitor to remove.
     *  
     * @see #addMonitor 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.142 -0500", hash_original_method = "667CF28A3BE8CF2696555BC3512917A7", hash_generated_method = "49872648BF00AD93542FE1D5D4959BB0")
    
public void removeMonitor(ActivityMonitor monitor) {
        synchronized (mSync) {
            mActivityMonitors.remove(monitor);
        }
    }

    /**
     * Execute a particular menu item.
     * 
     * @param targetActivity The activity in question.
     * @param id The identifier associated with the menu item.
     * @param flag Additional flags, if any.
     * @return Whether the invocation was successful (for example, it could be
     *         false if item is disabled).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.160 -0500", hash_original_method = "4D155A3E8D909DAB8A4322BEF2D5BDFA", hash_generated_method = "1A6633E9919BAB2DB16D58EC4C8ACE67")
    
public boolean invokeMenuActionSync(Activity targetActivity, 
                                    int id, int flag) {
        class MenuRunnable implements Runnable {
            private final Activity activity;
            private final int identifier;
            private final int flags;
            boolean returnValue;
            
            public MenuRunnable(Activity _activity, int _identifier,
                                    int _flags) {
                activity = _activity;
                identifier = _identifier;
                flags = _flags;
            }
            
            public void run() {
                Window win = activity.getWindow();
                
                returnValue = win.performPanelIdentifierAction(
                            Window.FEATURE_OPTIONS_PANEL,
                            identifier, 
                            flags);                
            }
            
        }        
        MenuRunnable mr = new MenuRunnable(targetActivity, id, flag);
        runOnMainSync(mr);
        return mr.returnValue;
    }

    /**
     * Show the context menu for the currently focused view and executes a
     * particular context menu item.
     * 
     * @param targetActivity The activity in question.
     * @param id The identifier associated with the context menu item.
     * @param flag Additional flags, if any.
     * @return Whether the invocation was successful (for example, it could be
     *         false if item is disabled).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.178 -0500", hash_original_method = "28CE40BD9E15A522E886C67E234DD689", hash_generated_method = "B0637438CA29A7ACF85B20074556156F")
    
public boolean invokeContextMenuAction(Activity targetActivity, int id, int flag) {
        validateNotAppThread();
        
        // Bring up context menu for current focus.
        // It'd be nice to do this through code, but currently ListView depends on
        //   long press to set metadata for its selected child
        
        final KeyEvent downEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_CENTER); 
        sendKeySync(downEvent);

        // Need to wait for long press
        waitForIdleSync();
        try {
            Thread.sleep(ViewConfiguration.getLongPressTimeout());
        } catch (InterruptedException e) {
            Log.e(TAG, "Could not sleep for long press timeout", e);
            return false;
        }

        final KeyEvent upEvent = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_CENTER); 
        sendKeySync(upEvent);

        // Wait for context menu to appear
        waitForIdleSync();
        
        class ContextMenuRunnable implements Runnable {
            private final Activity activity;
            private final int identifier;
            private final int flags;
            boolean returnValue;
            
            public ContextMenuRunnable(Activity _activity, int _identifier,
                                    int _flags) {
                activity = _activity;
                identifier = _identifier;
                flags = _flags;
            }
            
            public void run() {
                Window win = activity.getWindow();
                returnValue = win.performContextMenuIdentifierAction(
                            identifier, 
                            flags);                
            }
            
        }
        
        ContextMenuRunnable cmr = new ContextMenuRunnable(targetActivity, id, flag);
        runOnMainSync(cmr);
        return cmr.returnValue;
    }
    
    /**
     * Sends the key events corresponding to the text to the app being
     * instrumented.
     * 
     * @param text The text to be sent. 
     */
    @DSSink({DSSinkKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.182 -0500", hash_original_method = "029397BC692B989F9FCA48D48FDB9479", hash_generated_method = "D01052788D1D7136B5EB7BB540B7EA01")
    
public void sendStringSync(String text) {
        if (text == null) {
            return;
        }
        KeyCharacterMap keyCharacterMap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
        
        KeyEvent[] events = keyCharacterMap.getEvents(text.toCharArray());
        
        if (events != null) {
            for (int i = 0; i < events.length; i++) {
                sendKeySync(events[i]);
            }
        }        
    }
    
    /**
     * Send a key event to the currently focused window/view and wait for it to
     * be processed.  Finished at some point after the recipient has returned
     * from its event processing, though it may <em>not</em> have completely
     * finished reacting from the event -- for example, if it needs to update
     * its display as a result, it may still be in the process of doing that.
     * 
     * @param event The event to send to the current focus.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.184 -0500", hash_original_method = "8EB82A3200B456D290A2F7A26355BB76", hash_generated_method = "CF8918FE7154564E15A069C8BCA7C4A9")
    
public void sendKeySync(KeyEvent event) {
        validateNotAppThread();
        try {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectKeyEvent(event, true);
        } catch (RemoteException e) {
        }
    }
    
    /**
     * Sends an up and down key event sync to the currently focused window.
     * 
     * @param key The integer keycode for the event.
     */
    @DSSink({DSSinkKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.187 -0500", hash_original_method = "EAB0936DFBB6258C56105993043121F1", hash_generated_method = "9C2BED586BE6C8197B38E42163E685FD")
    
public void sendKeyDownUpSync(int key) {        
        sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, key));
        sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, key));
    }

    /**
     * Higher-level method for sending both the down and up key events for a
     * particular character key code.  Equivalent to creating both KeyEvent
     * objects by hand and calling {@link #sendKeySync}.  The event appears
     * as if it came from keyboard 0, the built in one.
     * 
     * @param keyCode The key code of the character to send.
     */
    @DSSink({DSSinkKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.189 -0500", hash_original_method = "481470F7D6C4847394865E9F06AE8ED8", hash_generated_method = "D9872B287C6362313EDE1BBF6B3D5BD2")
    
public void sendCharacterSync(int keyCode) {
        sendKeySync(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
        sendKeySync(new KeyEvent(KeyEvent.ACTION_UP, keyCode));
    }
    
    /**
     * Dispatch a pointer event. Finished at some point after the recipient has
     * returned from its event processing, though it may <em>not</em> have
     * completely finished reacting from the event -- for example, if it needs
     * to update its display as a result, it may still be in the process of
     * doing that.
     * 
     * @param event A motion event describing the pointer action.  (As noted in 
     * {@link MotionEvent#obtain(long, long, int, float, float, int)}, be sure to use 
     * {@link SystemClock#uptimeMillis()} as the timebase.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.191 -0500", hash_original_method = "B9A3EF31E8BF5F99FCCA686BC6658BE3", hash_generated_method = "C1E09FF5BD1174485EE8889FAFA5A650")
    
public void sendPointerSync(MotionEvent event) {
        validateNotAppThread();
        try {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectPointerEvent(event, true);
        } catch (RemoteException e) {
        }
    }

    /**
     * Dispatch a trackball event. Finished at some point after the recipient has
     * returned from its event processing, though it may <em>not</em> have
     * completely finished reacting from the event -- for example, if it needs
     * to update its display as a result, it may still be in the process of
     * doing that.
     * 
     * @param event A motion event describing the trackball action.  (As noted in 
     * {@link MotionEvent#obtain(long, long, int, float, float, int)}, be sure to use 
     * {@link SystemClock#uptimeMillis()} as the timebase.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.193 -0500", hash_original_method = "6B2ECCD3AB22E94B5B1243023E902F6D", hash_generated_method = "11E14FB2D8B9288473842E4011F1F597")
    
public void sendTrackballEventSync(MotionEvent event) {
        validateNotAppThread();
        try {
            (IWindowManager.Stub.asInterface(ServiceManager.getService("window")))
                .injectTrackballEvent(event, true);
        } catch (RemoteException e) {
        }
    }

    /**
     * Perform instantiation of the process's {@link Application} object.  The
     * default implementation provides the normal system behavior.
     * 
     * @param cl The ClassLoader with which to instantiate the object.
     * @param className The name of the class implementing the Application
     *                  object.
     * @param context The context to initialize the application with
     * 
     * @return The newly instantiated Application object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.195 -0500", hash_original_method = "1A9EF24656896AC4FCE906BFB43593E0", hash_generated_method = "0CDC14DD4171F2DAB42DA660DE8AF67F")
    
public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, 
            ClassNotFoundException {
        return newApplication(cl.loadClass(className), context);
    }

    /**
     * Perform calling of the application's {@link Application#onCreate}
     * method.  The default implementation simply calls through to that method.
     * 
     * @param app The application being created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.200 -0500", hash_original_method = "3D967D3E47594084D340D0FEDC81A2D2", hash_generated_method = "2723079149E0FA05B32D563FD330F794")
    
public void callApplicationOnCreate(Application app) {
        app.onCreate();
    }
    
    /**
     * Perform instantiation of an {@link Activity} object.  This method is intended for use with
     * unit tests, such as android.test.ActivityUnitTestCase.  The activity will be useable
     * locally but will be missing some of the linkages necessary for use within the sytem.
     * 
     * @param clazz The Class of the desired Activity
     * @param context The base context for the activity to use
     * @param token The token for this activity to communicate with
     * @param application The application object (if any)
     * @param intent The intent that started this Activity
     * @param info ActivityInfo from the manifest
     * @param title The title, typically retrieved from the ActivityInfo record
     * @param parent The parent Activity (if any)
     * @param id The embedded Id (if any)
     * @param lastNonConfigurationInstance Arbitrary object that will be
     * available via {@link Activity#getLastNonConfigurationInstance()
     * Activity.getLastNonConfigurationInstance()}.
     * @return Returns the instantiated activity
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.202 -0500", hash_original_method = "A9111F868862B9E251C99947D42ADECF", hash_generated_method = "AA32DF566ED91D2FEF900EBFF46382CC")
    
public Activity newActivity(Class<?> clazz, Context context, 
            IBinder token, Application application, Intent intent, ActivityInfo info, 
            CharSequence title, Activity parent, String id,
            Object lastNonConfigurationInstance) throws InstantiationException, 
            IllegalAccessException {
        Activity activity = (Activity)clazz.newInstance();
        ActivityThread aThread = null;
        activity.attach(context, aThread, this, token, application, intent,
                info, title, parent, id,
                (Activity.NonConfigurationInstances)lastNonConfigurationInstance,
                new Configuration());
        return activity;
    }

    /**
     * Perform instantiation of the process's {@link Activity} object.  The
     * default implementation provides the normal system behavior.
     * 
     * @param cl The ClassLoader with which to instantiate the object.
     * @param className The name of the class implementing the Activity
     *                  object.
     * @param intent The Intent object that specified the activity class being
     *               instantiated.
     * 
     * @return The newly instantiated Activity object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.205 -0500", hash_original_method = "67A9E29CAF7C169812898E8BB0812F51", hash_generated_method = "6D91FD591496EE517F8E250D4175FE39")
    
public Activity newActivity(ClassLoader cl, String className,
            Intent intent)
            throws InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        return (Activity)cl.loadClass(className).newInstance();
    }

    /**
     * Perform calling of an activity's {@link Activity#onCreate}
     * method.  The default implementation simply calls through to that method.
     * 
     * @param activity The activity being created.
     * @param icicle The previously frozen state (or null) to pass through to
     *               onCreate().
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.207 -0500", hash_original_method = "5B22BAF104CC01C4555866A70EB5D211", hash_generated_method = "2ED36F90DC21FCD558045E853E94DAF2")
    
public void callActivityOnCreate(Activity activity, Bundle icicle) {
        if (mWaitingActivities != null) {
            synchronized (mSync) {
                final int N = mWaitingActivities.size();
                for (int i=0; i<N; i++) {
                    final ActivityWaiter aw = mWaitingActivities.get(i);
                    final Intent intent = aw.intent;
                    if (intent.filterEquals(activity.getIntent())) {
                        aw.activity = activity;
                        mMessageQueue.addIdleHandler(new ActivityGoing(aw));
                    }
                }
            }
        }
        
        activity.performCreate(icicle);
        
        if (mActivityMonitors != null) {
            synchronized (mSync) {
                final int N = mActivityMonitors.size();
                for (int i=0; i<N; i++) {
                    final ActivityMonitor am = mActivityMonitors.get(i);
                    am.match(activity, activity, activity.getIntent());
                }
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.210 -0500", hash_original_method = "ACD4ACDF1D4AD87F23B45E29C987968F", hash_generated_method = "73D33C92748F0D9E84185617A03C4397")
    
public void callActivityOnDestroy(Activity activity) {
      // TODO: the following block causes intermittent hangs when using startActivity
      // temporarily comment out until root cause is fixed (bug 2630683)
//      if (mWaitingActivities != null) {
//          synchronized (mSync) {
//              final int N = mWaitingActivities.size();
//              for (int i=0; i<N; i++) {
//                  final ActivityWaiter aw = mWaitingActivities.get(i);
//                  final Intent intent = aw.intent;
//                  if (intent.filterEquals(activity.getIntent())) {
//                      aw.activity = activity;
//                      mMessageQueue.addIdleHandler(new ActivityGoing(aw));
//                  }
//              }
//          }
//      }
      
      activity.performDestroy();
      
      if (mActivityMonitors != null) {
          synchronized (mSync) {
              final int N = mActivityMonitors.size();
              for (int i=0; i<N; i++) {
                  final ActivityMonitor am = mActivityMonitors.get(i);
                  am.match(activity, activity, activity.getIntent());
              }
          }
      }
  }

    /**
     * Perform calling of an activity's {@link Activity#onRestoreInstanceState}
     * method.  The default implementation simply calls through to that method.
     * 
     * @param activity The activity being restored.
     * @param savedInstanceState The previously saved state being restored.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.212 -0500", hash_original_method = "E084363C345B4BF61D861FC0D5D07D15", hash_generated_method = "B4FB84BC846C006AD4E1972742F988A2")
    
public void callActivityOnRestoreInstanceState(Activity activity, Bundle savedInstanceState) {
        activity.performRestoreInstanceState(savedInstanceState);
    }

    /**
     * Perform calling of an activity's {@link Activity#onPostCreate} method.
     * The default implementation simply calls through to that method.
     * 
     * @param activity The activity being created.
     * @param icicle The previously frozen state (or null) to pass through to
     *               onPostCreate().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.214 -0500", hash_original_method = "2BECA7ACE9ECA4B1DD0299ACB1DA09B9", hash_generated_method = "B3E41BC067D53A7893BAE2F7609D64B1")
    
public void callActivityOnPostCreate(Activity activity, Bundle icicle) {
        activity.onPostCreate(icicle);
    }

    /**
     * Perform calling of an activity's {@link Activity#onNewIntent}
     * method.  The default implementation simply calls through to that method.
     * 
     * @param activity The activity receiving a new Intent.
     * @param intent The new intent being received.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.216 -0500", hash_original_method = "5C607C7DDC680DB12532E9DB6F9CBC1F", hash_generated_method = "CC52AC7F8DF622A739046E1D71127BCF")
    
public void callActivityOnNewIntent(Activity activity, Intent intent) {
        activity.onNewIntent(intent);
    }

    /**
     * Perform calling of an activity's {@link Activity#onStart}
     * method.  The default implementation simply calls through to that method.
     * 
     * @param activity The activity being started.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.218 -0500", hash_original_method = "92E54A7AE2339DA4EE7A292F370BB21D", hash_generated_method = "C068DC78514963288761F18BD98D6979")
    
public void callActivityOnStart(Activity activity) {
        activity.onStart();
    }

    /**
     * Perform calling of an activity's {@link Activity#onRestart}
     * method.  The default implementation simply calls through to that method.
     * 
     * @param activity The activity being restarted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.220 -0500", hash_original_method = "85BE14FC295678CF247F9E472F613652", hash_generated_method = "DFF6B0F40F72E17F86ACC57C045F08E8")
    
public void callActivityOnRestart(Activity activity) {
        activity.onRestart();
    }

    /**
     * Perform calling of an activity's {@link Activity#onResume} method.  The
     * default implementation simply calls through to that method.
     * 
     * @param activity The activity being resumed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.223 -0500", hash_original_method = "7A6C498E491E406F2D113F8023D1483F", hash_generated_method = "4A2E4013D6BBDF14B743A44D27544984")
    
public void callActivityOnResume(Activity activity) {
        activity.mResumed = true;
        activity.onResume();
        
        if (mActivityMonitors != null) {
            synchronized (mSync) {
                final int N = mActivityMonitors.size();
                for (int i=0; i<N; i++) {
                    final ActivityMonitor am = mActivityMonitors.get(i);
                    am.match(activity, activity, activity.getIntent());
                }
            }
        }
    }

    /**
     * Perform calling of an activity's {@link Activity#onStop}
     * method.  The default implementation simply calls through to that method.
     * 
     * @param activity The activity being stopped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.225 -0500", hash_original_method = "0F89D6C7937A191011A20B47DB6599C5", hash_generated_method = "91DD4089B6C42C5EBE4975CD2004467C")
    
public void callActivityOnStop(Activity activity) {
        activity.onStop();
    }

    /**
     * Perform calling of an activity's {@link Activity#onPause} method.  The
     * default implementation simply calls through to that method.
     * 
     * @param activity The activity being saved.
     * @param outState The bundle to pass to the call.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.227 -0500", hash_original_method = "E8ECFB0E3E7F6A98F4E3FE19FF7167B5", hash_generated_method = "AED061B9009FBECDDBCBDF33F2A7EC03")
    
public void callActivityOnSaveInstanceState(Activity activity, Bundle outState) {
        activity.performSaveInstanceState(outState);
    }

    /**
     * Perform calling of an activity's {@link Activity#onPause} method.  The
     * default implementation simply calls through to that method.
     * 
     * @param activity The activity being paused.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.229 -0500", hash_original_method = "A3AB5C16D17E1593B1F616581634810F", hash_generated_method = "BD53181BA1F45521164AF47AADC4EF13")
    
public void callActivityOnPause(Activity activity) {
        activity.performPause();
    }
    
    /**
     * Perform calling of an activity's {@link Activity#onUserLeaveHint} method.
     * The default implementation simply calls through to that method.
     * 
     * @param activity The activity being notified that the user has navigated away
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.232 -0500", hash_original_method = "436C260B8868F376171ACCB198E870A3", hash_generated_method = "B7494B5BCAD97DE435D87F2166D08728")
    
public void callActivityOnUserLeaving(Activity activity) {
        activity.performUserLeaving();
    }
    
    /*
     * Starts allocation counting. This triggers a gc and resets the counts.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.235 -0500", hash_original_method = "7FDB53D95055F8344C6717BAA41CDD62", hash_generated_method = "DB320E01DFF602F21797E370F003F553")
    
public void startAllocCounting() {
        // Before we start trigger a GC and reset the debug counts. Run the 
        // finalizers and another GC before starting and stopping the alloc
        // counts. This will free up any objects that were just sitting around 
        // waiting for their finalizers to be run.
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();

        Debug.resetAllCounts();
        
        // start the counts
        Debug.startAllocCounting();
    }
    
    /*
     * Stops allocation counting.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.237 -0500", hash_original_method = "0DC5272531C251864B2A214C154F0F7A", hash_generated_method = "B62E334895136F174CBE5D9618978BBE")
    
public void stopAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.stopAllocCounting();
    }
    
    /**
     * If Results already contains Key, it appends Value to the key's ArrayList
     * associated with the key. If the key doesn't already exist in results, it
     * adds the key/value pair to results.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.239 -0500", hash_original_method = "8051F011270999D9228A08818EFD61DD", hash_generated_method = "8DA6C0EB41A062AF1C6AD942B2D3E8C3")
    
private void addValue(String key, int value, Bundle results) {
        if (results.containsKey(key)) {
            List<Integer> list = results.getIntegerArrayList(key);
            if (list != null) {
                list.add(value);
            }
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(value);
            results.putIntegerArrayList(key, list);
        }
    }

    /**
     * Returns a bundle with the current results from the allocation counting.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.241 -0500", hash_original_method = "733DA96DDB5CBA410EC33155388CAA51", hash_generated_method = "D1EB78DE0220B18E485959E42814D16A")
    
public Bundle getAllocCounts() {
        Bundle results = new Bundle();
        results.putLong("global_alloc_count", Debug.getGlobalAllocCount());
        results.putLong("global_alloc_size", Debug.getGlobalAllocSize());
        results.putLong("global_freed_count", Debug.getGlobalFreedCount());
        results.putLong("global_freed_size", Debug.getGlobalFreedSize());
        results.putLong("gc_invocation_count", Debug.getGlobalGcInvocationCount());    
        return results;
    }

    /**
     * Returns a bundle with the counts for various binder counts for this process. Currently the only two that are
     * reported are the number of send and the number of received transactions.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.244 -0500", hash_original_method = "C29A199041D930C7B60D186159DABF9F", hash_generated_method = "9779A2A3D8077F781D01772052366265")
    
public Bundle getBinderCounts() {
        Bundle results = new Bundle();
        results.putLong("sent_transactions", Debug.getBinderSentTransactions());
        results.putLong("received_transactions", Debug.getBinderReceivedTransactions());
        return results;
    }

    /**
     * Execute a startActivity call made by the application.  The default 
     * implementation takes care of updating any active {@link ActivityMonitor}
     * objects and dispatches this call to the system activity manager; you can
     * override this to watch for the application to start an activity, and 
     * modify what happens when it does. 
     *  
     * <p>This method returns an {@link ActivityResult} object, which you can 
     * use when intercepting application calls to avoid performing the start 
     * activity action but still return the result the application is 
     * expecting.  To do this, override this method to catch the call to start 
     * activity so that it returns a new ActivityResult containing the results 
     * you would like the application to see, and don't call up to the super 
     * class.  Note that an application is only expecting a result if 
     * <var>requestCode</var> is &gt;= 0.
     *  
     * <p>This method throws {@link android.content.ActivityNotFoundException}
     * if there was no Activity found to run the given Intent.
     * 
     * @param who The Context from which the activity is being started.
     * @param contextThread The main thread of the Context from which the activity
     *                      is being started.
     * @param token Internal token identifying to the system who is starting 
     *              the activity; may be null.
     * @param target Which activity is performing the start (and thus receiving 
     *               any result); may be null if this call is not being made
     *               from an activity.
     * @param intent The actual Intent to start.
     * @param requestCode Identifier for this request's result; less than zero 
     *                    if the caller is not expecting a result.
     * 
     * @return To force the return of a particular result, return an 
     *         ActivityResult object containing the desired data; otherwise
     *         return null.  The default implementation always returns null.
     *  
     * @throws android.content.ActivityNotFoundException
     * 
     * @see Activity#startActivity(Intent)
     * @see Activity#startActivityForResult(Intent, int)
     * @see Activity#startActivityFromChild
     * 
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.261 -0500", hash_original_method = "2C6BFD417D58A73C3437D9BD22014CB6", hash_generated_method = "EF166A1E98C842B1AA2E4E629B8CEEA7")
    
public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode) {
        IApplicationThread whoThread = (IApplicationThread) contextThread;
        if (mActivityMonitors != null) {
            synchronized (mSync) {
                final int N = mActivityMonitors.size();
                for (int i=0; i<N; i++) {
                    final ActivityMonitor am = mActivityMonitors.get(i);
                    if (am.match(who, null, intent)) {
                        am.mHits++;
                        if (am.isBlocking()) {
                            am.addTaint(requestCode);
                            ActivityResult result = am.getResult(); 
                            result.addTaint(requestCode);
                            return requestCode >= 0 ? result : null;
                        }
                        break;
                    }
                }
            }
        }
        try {
            intent.setAllowFds(false);
            int result = ActivityManagerNative.getDefault()
                .startActivity(whoThread, intent,
                        intent.resolveTypeIfNeeded(who.getContentResolver()),
                        null, 0, token, target != null ? target.mEmbeddedID : null,
                        requestCode, false, false, null, null, false);
            checkStartActivityResult(result, intent);
        } catch (RemoteException e) {
        }
        return null;
    }

    /**
     * Like {@link #execStartActivity(Context, IBinder, IBinder, Activity, Intent, int)},
     * but accepts an array of activities to be started.  Note that active
     * {@link ActivityMonitor} objects only match against the first activity in
     * the array.
     *
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.263 -0500", hash_original_method = "7F406AB00C6E84903D3FA39AC1C6F8AE", hash_generated_method = "D7C40CC915B23AE4A03E123704CD8015")
    
public void execStartActivities(Context who, IBinder contextThread,
            IBinder token, Activity target, Intent[] intents) {
        IApplicationThread whoThread = (IApplicationThread) contextThread;
        if (mActivityMonitors != null) {
            synchronized (mSync) {
                final int N = mActivityMonitors.size();
                for (int i=0; i<N; i++) {
                    final ActivityMonitor am = mActivityMonitors.get(i);
                    if (am.match(who, null, intents[0])) {
                        am.mHits++;
                        if (am.isBlocking()) {
                            return;
                        }
                        break;
                    }
                }
            }
        }
        try {
            String[] resolvedTypes = new String[intents.length];
            for (int i=0; i<intents.length; i++) {
                intents[i].setAllowFds(false);
                resolvedTypes[i] = intents[i].resolveTypeIfNeeded(who.getContentResolver());
            }
            int result = ActivityManagerNative.getDefault()
                .startActivities(whoThread, intents, resolvedTypes, token);
            checkStartActivityResult(result, intents[0]);
        } catch (RemoteException e) {
        }
    }
    
    public static class ActivityMonitor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.087 -0500", hash_original_field = "BBC2EC8A86140B6608C1C3575B806A81", hash_generated_field = "AF74A86DAFFBC4B54B5C18398CFDAB42")

        private  IntentFilter mWhich;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.089 -0500", hash_original_field = "7B9BED5A2E35C35D1D3CD4CF0C575024", hash_generated_field = "5E2CA74CC8E570ED6932C7E63B69D503")

        private  String mClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.092 -0500", hash_original_field = "F06C0A7BB2F7BC13DC1AA71197F6DECA", hash_generated_field = "2C01E1B2BB3E6DFFE6E3668CD94CB3E6")

        private  ActivityResult mResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.094 -0500", hash_original_field = "A3340CE303D1C3521B987BA833FC6075", hash_generated_field = "6781DA6A293ED68705EB1F6D6AF21DBE")

        private  boolean mBlock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.096 -0500", hash_original_field = "C00AE67DB98B5AE298A1158B3E81E69C", hash_generated_field = "EB4D52EBD2A0EF54EA790CD4A82F9437")

        /*package*/ int mHits = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.098 -0500", hash_original_field = "78E79A1B34133AC2215BE692FE7324EA", hash_generated_field = "21994DACBF96FB878B04EE094D940FEC")

        /*package*/ Activity mLastActivity = null;

        /**
         * Create a new ActivityMonitor that looks for a particular kind of 
         * intent to be started.
         *  
         * @param which The set of intents this monitor is responsible for.
         * @param result A canned result to return if the monitor is hit; can 
         *               be null.
         * @param block Controls whether the monitor should block the activity 
         *              start (returning its canned result) or let the call
         *              proceed.
         *  
         * @see Instrumentation#addMonitor 
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.100 -0500", hash_original_method = "44AA99B3E06F91C4A28CA95A02F486A4", hash_generated_method = "1FF68244F39CE237A2FA2C3738169987")
        
public ActivityMonitor(
            IntentFilter which, ActivityResult result, boolean block) {
            mWhich = which;
            mClass = null;
            mResult = result;
            mBlock = block;
        }

        /**
         * Create a new ActivityMonitor that looks for a specific activity 
         * class to be started. 
         *  
         * @param cls The activity class this monitor is responsible for.
         * @param result A canned result to return if the monitor is hit; can 
         *               be null.
         * @param block Controls whether the monitor should block the activity 
         *              start (returning its canned result) or let the call
         *              proceed.
         *  
         * @see Instrumentation#addMonitor 
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.103 -0500", hash_original_method = "96127A12D0FD338A76B8651F7EF76641", hash_generated_method = "4C6CA4BAB6E956E2812EB9D744773149")
        
public ActivityMonitor(
            String cls, ActivityResult result, boolean block) {
            mWhich = null;
            mClass = cls;
            mResult = result;
            mBlock = block;
        }

        /**
         * Retrieve the filter associated with this ActivityMonitor.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.106 -0500", hash_original_method = "5CEC767AFA0B77CA42139688DDFFE7D0", hash_generated_method = "EEB89DB80307814A28C25480A6DDC5DE")
        
public final IntentFilter getFilter() {
            return mWhich;
        }

        /**
         * Retrieve the result associated with this ActivityMonitor, or null if 
         * none. 
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.108 -0500", hash_original_method = "907D5A2A73ED7959ACD2198F97C8DDFD", hash_generated_method = "BAEF7D9E028C6031F8053933BD12AC10")
        
public final ActivityResult getResult() {
            return mResult;
        }

        /**
         * Check whether this monitor blocks activity starts (not allowing the 
         * actual activity to run) or allows them to execute normally. 
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.111 -0500", hash_original_method = "6E6027F9B3B42A9863ABB214525B0A55", hash_generated_method = "147D9EC4187374661DBE6E98C13EBA9A")
        
public final boolean isBlocking() {
            return mBlock;
        }

        /**
         * Retrieve the number of times the monitor has been hit so far.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.113 -0500", hash_original_method = "6A2B57F4CCAF664CD709CE454AF8AF4E", hash_generated_method = "3A06AB8C5E844F44218627C35EB91D88")
        
public final int getHits() {
            return mHits;
        }

        /**
         * Retrieve the most recent activity class that was seen by this 
         * monitor. 
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.115 -0500", hash_original_method = "1AD813C5DE346D876C42D8A64F1E0FB4", hash_generated_method = "E5FD8926AB241950AE5A04CCCD6C1785")
        
public final Activity getLastActivity() {
            return mLastActivity;
        }

        /**
         * Block until an Activity is created that matches this monitor, 
         * returning the resulting activity. 
         * 
         * @return Activity
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.118 -0500", hash_original_method = "905168F82A17E43399C57E76AC6D268D", hash_generated_method = "69D04CBC3A1BDA9C304600B26CA6114D")
        
public final Activity waitForActivity() {
            synchronized (this) {
                while (mLastActivity == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
                Activity res = mLastActivity;
                mLastActivity = null;
                return res;
            }
        }

        /**
         * Block until an Activity is created that matches this monitor, 
         * returning the resulting activity or till the timeOut period expires.
         * If the timeOut expires before the activity is started, return null. 
         * 
         * @param timeOut Time to wait before the activity is created.
         * 
         * @return Activity
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.121 -0500", hash_original_method = "68E343228598567180DC80BCAD1066EC", hash_generated_method = "DD6E89DB04E2ABBF7C0B0C623BC62A93")
        
public final Activity waitForActivityWithTimeout(long timeOut) {
            synchronized (this) {
                if (mLastActivity == null) {
                    try {
                        wait(timeOut);
                    } catch (InterruptedException e) {
                    }
                }
                if (mLastActivity == null) {
                    return null;
                } else {
                    Activity res = mLastActivity;
                    mLastActivity = null;
                    return res;
                }
            }
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.123 -0500", hash_original_method = "81CE78024E25171646CA4AFCDB286C47", hash_generated_method = "20EBF901E2F5BB6DA0098EC94B21F575")
        
final boolean match(Context who,
                            Activity activity,
                            Intent intent) {
            synchronized (this) {
                if (mWhich != null
                    && mWhich.match(who.getContentResolver(), intent,
                                    true, "Instrumentation") < 0) {
                    return false;
                }
                if (mClass != null) {
                    String cls = null;
                    if (activity != null) {
                        cls = activity.getClass().getName();
                    } else if (intent.getComponent() != null) {
                        cls = intent.getComponent().getClassName();
                    }
                    if (cls == null || !mClass.equals(cls)) {
                        return false;
                    }
                }
                if (activity != null) {
                    mLastActivity = activity;
                    notifyAll();
                }
                return true;
            }
        }
        
    }
    
    public static final class ActivityResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.254 -0500", hash_original_field = "457E6BFD9A88F809DF3F4A88B9B7B893", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")

        private  int mResultCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.257 -0500", hash_original_field = "DCB68FC375C4B54ED333BF58AF1CBC8A", hash_generated_field = "2ACA4EFB7F1C3D021D8C2319D9F4A1B0")

        private  Intent mResultData;
        /**
         * Create a new activity result.  See {@link Activity#setResult} for 
         * more information. 
         *  
         * @param resultCode The result code to propagate back to the
         * originating activity, often RESULT_CANCELED or RESULT_OK
         * @param resultData The data to propagate back to the originating
         * activity.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.247 -0500", hash_original_method = "C450F5B8EDB38A231DF953C34FD7C745", hash_generated_method = "707C557A2BF77EF2AE75A4E29CB39B57")
        
public ActivityResult(int resultCode, Intent resultData) {
            mResultCode = resultCode;
            mResultData = resultData;
        }

        /**
         * Retrieve the result code contained in this result.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.249 -0500", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "BAB089F9DACBDE2D78C92F55EB927359")
        
public int getResultCode() {
            return mResultCode;
        }

        /**
         * Retrieve the data contained in this result.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.252 -0500", hash_original_method = "230B95D397C0359A2CE808B90BABA149", hash_generated_method = "2A136C66111909BAFC222981163E4C89")
        
public Intent getResultData() {
            return mResultData;
        }
        
    }
    
    private final class InstrumentationThread extends Thread {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.277 -0500", hash_original_method = "63270DA70BB76F2F3E4D4969BE7BFAFC", hash_generated_method = "293BD817EDA05D9BBEAA1ABDE32EAE9A")
        
public InstrumentationThread(String name) {
            super(name);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.280 -0500", hash_original_method = "801DE955A4997069AEAE1C9E4306FFC2", hash_generated_method = "D266232BF9AA48C02850913B112602E5")
        
public void run() {
            IActivityManager am = ActivityManagerNative.getDefault();
            try {
                Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_DISPLAY);
            } catch (RuntimeException e) {
                Log.w(TAG, "Exception setting priority of instrumentation thread "                                            
                        + Process.myTid(), e);                                                                             
            }
            if (mAutomaticPerformanceSnapshots) {
                startPerformanceSnapshot();
            }
            onStart();
        }
        
    }
    
    private static final class EmptyRunnable implements Runnable {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.475 -0400", hash_original_method = "9351A801773C8F1D9056187EA700F8B4", hash_generated_method = "9351A801773C8F1D9056187EA700F8B4")
        public EmptyRunnable ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.284 -0500", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "90F21E94AFD861A0B7D82CACD0D3E70A")
        
public void run() {
        }
        
    }
    
    private static final class SyncRunnable implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.289 -0500", hash_original_field = "849A4B4B1A94E30A6CA7F95681D7068B", hash_generated_field = "B38DEE567D624A06D39175E911A12BE6")

        private  Runnable mTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.292 -0500", hash_original_field = "CEE7D211CBD86AF1AE7B0C8EDED79C3A", hash_generated_field = "C7DFAA7BAEC783B90B2A4CC60586CA74")

        private boolean mComplete;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.295 -0500", hash_original_method = "52C4D1F6D6B56C48522BD51EB3CA3671", hash_generated_method = "11A3B0454EB03D49CEF59A52E75DC7FA")
        
public SyncRunnable(Runnable target) {
            mTarget = target;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.297 -0500", hash_original_method = "44AE594487B622FAC5CF0DF348DF4C16", hash_generated_method = "E1C01245DDFC7780F3E2F65B966E49CD")
        
public void run() {
            mTarget.run();
            synchronized (this) {
                mComplete = true;
                notifyAll();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.299 -0500", hash_original_method = "02D1E24DCA4BB39BCA765C3BAB20012A", hash_generated_method = "5A06CEB7CE2F9319C20A107A6FF5062C")
        
public void waitForComplete() {
            synchronized (this) {
                while (!mComplete) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        
    }
    
    private static final class ActivityWaiter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.304 -0500", hash_original_field = "170FCA7A98A65D8003A3D20D5B3C245D", hash_generated_field = "5DEDAC72AD89B3864945324786195E0B")

        public  Intent intent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.306 -0500", hash_original_field = "A63B0916BD4AC2611D1AF746A2DF045C", hash_generated_field = "8EB481EDAD2FDE318A05890E655F5C10")

        public Activity activity;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.308 -0500", hash_original_method = "749CA2F0047E4C5ABC5CE22C281FA095", hash_generated_method = "832568DAD167D7D9B4A4F24FAE48C4EE")
        
public ActivityWaiter(Intent _intent) {
            intent = _intent;
        }
        
    }
    
    private final class ActivityGoing implements MessageQueue.IdleHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.312 -0500", hash_original_field = "40B01AA85CFA6EB01F9D7192B9DB9003", hash_generated_field = "D1D9DBA4EB12F84FE5F9E1BF6FFC4059")

        private  ActivityWaiter mWaiter;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.316 -0500", hash_original_method = "C941F219CD1DB06313DFA66C54B64070", hash_generated_method = "88D9CC88531438586B5C222059BFF906")
        
public ActivityGoing(ActivityWaiter waiter) {
            mWaiter = waiter;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.318 -0500", hash_original_method = "6BEF536DFBCFB4C74EC4C0EA4FEAD5BE", hash_generated_method = "BDEA0A8E72A5142056454B4A0CFB6DC3")
        
public final boolean queueIdle() {
            synchronized (mSync) {
                mWaitingActivities.remove(mWaiter);
                mSync.notifyAll();
            }
            return false;
        }
        
    }
    
    private static final class Idler implements MessageQueue.IdleHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.323 -0500", hash_original_field = "A96DAF5C1D70171F409ED450DEACFE0A", hash_generated_field = "A3563124F239CF73FFEC0EB79C97D4FC")

        private  Runnable mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.325 -0500", hash_original_field = "F18D04F46EBBE063ECF41DF7A07C689D", hash_generated_field = "9B659026DF37979A10F87338BD5AE24B")

        private boolean mIdle;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.328 -0500", hash_original_method = "4434628995BB6492F17F2A3E55C00ABF", hash_generated_method = "DBFB43F4862FAF1E700712AF509FCA29")
        
public Idler(Runnable callback) {
            mCallback = callback;
            mIdle = false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.330 -0500", hash_original_method = "B0AE6A8D5B64501509EFCE6FDAF91034", hash_generated_method = "0861B92C2286FBB2B7CD245D6DB00305")
        
public final boolean queueIdle() {
            if (mCallback != null) {
                mCallback.run();
            }
            synchronized (this) {
                mIdle = true;
                notifyAll();
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.333 -0500", hash_original_method = "DF4D50EB6BB518BE09549DCD9C0630C1", hash_generated_method = "C14A7EB57744228F85DF299290615F3B")
        
public void waitForIdle() {
            synchronized (this) {
                while (!mIdle) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        
    }

    /**
     * Like {@link #execStartActivity(Context, IBinder, IBinder, Activity, Intent, int)},
     * but for calls from a {#link Fragment}.
     * 
     * @param who The Context from which the activity is being started.
     * @param contextThread The main thread of the Context from which the activity
     *                      is being started.
     * @param token Internal token identifying to the system who is starting 
     *              the activity; may be null.
     * @param target Which fragment is performing the start (and thus receiving 
     *               any result).
     * @param intent The actual Intent to start.
     * @param requestCode Identifier for this request's result; less than zero 
     *                    if the caller is not expecting a result.
     * 
     * @return To force the return of a particular result, return an 
     *         ActivityResult object containing the desired data; otherwise
     *         return null.  The default implementation always returns null.
     *  
     * @throws android.content.ActivityNotFoundException
     * 
     * @see Activity#startActivity(Intent)
     * @see Activity#startActivityForResult(Intent, int)
     * @see Activity#startActivityFromChild
     * 
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.266 -0500", hash_original_method = "D8D9B46CC68EC6EB44E02EECB84F8BB9", hash_generated_method = "B992FA463F0EB32F4A8044FEDA788F35")
    
public ActivityResult execStartActivity(
        Context who, IBinder contextThread, IBinder token, Fragment target,
        Intent intent, int requestCode) {
        IApplicationThread whoThread = (IApplicationThread) contextThread;
        if (mActivityMonitors != null) {
            synchronized (mSync) {
                final int N = mActivityMonitors.size();
                for (int i=0; i<N; i++) {
                    final ActivityMonitor am = mActivityMonitors.get(i);
                    if (am.match(who, null, intent)) {
                        am.mHits++;
                        if (am.isBlocking()) {
                            ActivityResult result = am.getResult(); 
                            result.addTaint(am.isBlocking());
                            result.addTaint(requestCode);
                            return requestCode >= 0 ? result : null;
                        }
                        break;
                    }
                }
            }
        }
        try {
            intent.setAllowFds(false);
            int result = ActivityManagerNative.getDefault()
                .startActivity(whoThread, intent,
                        intent.resolveTypeIfNeeded(who.getContentResolver()),
                        null, 0, token, target != null ? target.mWho : null,
                        requestCode, false, false, null, null, false);
            checkStartActivityResult(result, intent);
        } catch (RemoteException e) {
        }
        return null;
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.268 -0500", hash_original_method = "B2107F3A70ADB2CB9368A3E0EA3587E6", hash_generated_method = "99A5BEA9C463F290223F77DE2D662AA7")
    
final void init(ActivityThread thread,
            Context instrContext, Context appContext, ComponentName component, 
            IInstrumentationWatcher watcher) {
        mThread = thread;
        mMessageQueue = mThread.getLooper().myQueue();
        mInstrContext = instrContext;
        mAppContext = appContext;
        mComponent = component;
        mWatcher = watcher;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:44.274 -0500", hash_original_method = "F94F35385602BE8879B41CCA4D6F8D26", hash_generated_method = "CC4090B00BAFC1A95057F5CF76475804")
    
private final void validateNotAppThread() {
        if (ActivityThread.currentActivityThread() != null) {
            throw new RuntimeException(
                "This method can not be called from the main application thread");
        }
    }
}

