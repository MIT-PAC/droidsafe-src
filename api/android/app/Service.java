
package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;

public abstract class Service extends ContextWrapper implements ComponentCallbacks2 {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.391 -0500", hash_original_field = "ECCA61699D3D51FA9DA8707329318842", hash_generated_field = "BCD56721F1394C062DFD537E559B3715")

    private static final String TAG = "Service";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.403 -0500", hash_original_field = "FACBE2619491F20F2734A45FD218DF61", hash_generated_field = "86EFEF5908B3F0A48EAB2E5148EFD2CE")

    public static final int START_CONTINUATION_MASK = 0xf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.405 -0500", hash_original_field = "0D22AB768DF147E552705F1117D4F08F", hash_generated_field = "6AB8AE8C585B1915F248A48E422129E7")

    public static final int START_STICKY_COMPATIBILITY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.407 -0500", hash_original_field = "DCE773BAD1660016214942C2187EECE0", hash_generated_field = "C488F1F47EE1B6BEB81C4B247221B19D")

    public static final int START_STICKY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.410 -0500", hash_original_field = "F4264EADDDE9C1197225E226020C254F", hash_generated_field = "842E5BD5CBB5E2EFE4C7F51F34DD7682")

    public static final int START_NOT_STICKY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.412 -0500", hash_original_field = "A90DFD6216D2CE9B0D7E6491C273DA98", hash_generated_field = "F19A890EE4A2FB7E7378A4C58AC77ECC")

    public static final int START_REDELIVER_INTENT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.414 -0500", hash_original_field = "23315CD87A3DDF6A21CD6031CECBDE0A", hash_generated_field = "FD5FC98B1B2FB67809451B9816107761")

    public static final int START_TASK_REMOVED_COMPLETE = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.417 -0500", hash_original_field = "CEC3588CC64A732B3D88BDEB868103EA", hash_generated_field = "BAB9A01E808DDE43FF848B5DFA65963D")

    public static final int START_FLAG_REDELIVERY = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.419 -0500", hash_original_field = "508D2106DE7B81DE360BF1E993576E21", hash_generated_field = "A3148E49A6C6B3EB316E1423172174D4")

    public static final int START_FLAG_RETRY = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.461 -0500", hash_original_field = "1DCC86ACED37EA88F412C3388F4C9815", hash_generated_field = "4DECD94BE6B0174DE36067CBF50C84C9")

    private ActivityThread mThread = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.463 -0500", hash_original_field = "9374BE347D6656736B33699DF3656A5B", hash_generated_field = "BE683FA5966EBD9F84092C95A35E6E34")

    private String mClassName = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.465 -0500", hash_original_field = "4FD235622B197D8B4C98227E068368C3", hash_generated_field = "DAC5D9DD61EA17334F7C3255730A488C")

    private IBinder mToken = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.467 -0500", hash_original_field = "6E333FE7C5490F63EE76C310D5EBDA33", hash_generated_field = "4662AB87CC0467DEECD3520FB534F4C7")

    private Application mApplication = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.469 -0500", hash_original_field = "FE4DE40B893FC45F4905A860A1F04787", hash_generated_field = "EC19CF3CBCE73E0074A7B2A120F55C7D")

    private IActivityManager mActivityManager = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.472 -0500", hash_original_field = "5A79CD52138A0720E23D9B1A46118EF6", hash_generated_field = "056DB6B553A04FAC52364200FA203D0E")

    private boolean mStartCompatibility = false;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.394 -0500", hash_original_method = "D0179C650F036CDA92B50348E0090B82", hash_generated_method = "51E9E57980FDAAC374C77A00B7C0E1C8")
    
public Service() {
        super(null);
    }

    /** Return the application that owns this service. */
    @DSComment("Modeled")
    @DSSafe(DSCat.SERVICE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.396 -0500", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "63791FE33C4BA47B317000A8E62CC095")
    
public final Application getApplication() {
        return mApplication;
    }

    /**
     * Called by the system when the service is first created.  Do not call this method directly.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.397 -0500", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "9687CB6D9F1B2A9EE9EE5E6EB201E78C")
    
public void onCreate() {
    }

    /**
     * @deprecated Implement {@link #onStartCommand(Intent, int, int)} instead.
     */
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.400 -0500", hash_original_method = "8DB0845BC67A569482FD95D924F2B38E", hash_generated_method = "CF926B6A86164E3DF6A5EB52ADD8A622")
@Deprecated
    public void onStart(Intent intent, int startId) {
    }
    
    /**
     * Called by the system every time a client explicitly starts the service by calling 
     * {@link android.content.Context#startService}, providing the arguments it supplied and a 
     * unique integer token representing the start request.  Do not call this method directly.
     * 
     * <p>For backwards compatibility, the default implementation calls
     * {@link #onStart} and returns either {@link #START_STICKY}
     * or {@link #START_STICKY_COMPATIBILITY}.
     * 
     * <p>If you need your application to run on platform versions prior to API
     * level 5, you can use the following model to handle the older {@link #onStart}
     * callback in that case.  The <code>handleCommand</code> method is implemented by
     * you as appropriate:
     * 
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/ForegroundService.java
     *   start_compatibility}
     *
     * <p class="caution">Note that the system calls this on your
     * service's main thread.  A service's main thread is the same
     * thread where UI operations take place for Activities running in the
     * same process.  You should always avoid stalling the main
     * thread's event loop.  When doing long-running operations,
     * network calls, or heavy disk I/O, you should kick off a new
     * thread, or use {@link android.os.AsyncTask}.</p>
     *
     * @param intent The Intent supplied to {@link android.content.Context#startService}, 
     * as given.  This may be null if the service is being restarted after
     * its process has gone away, and it had previously returned anything
     * except {@link #START_STICKY_COMPATIBILITY}.
     * @param flags Additional data about this start request.  Currently either
     * 0, {@link #START_FLAG_REDELIVERY}, or {@link #START_FLAG_RETRY}.
     * @param startId A unique integer representing this specific request to 
     * start.  Use with {@link #stopSelfResult(int)}.
     * 
     * @return The return value indicates what semantics the system should
     * use for the service's current started state.  It may be one of the
     * constants associated with the {@link #START_CONTINUATION_MASK} bits.
     * 
     * @see #stopSelfResult(int)
     */
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.421 -0500", hash_original_method = "C7065D6B9C7065CE68918429E4AC852C", hash_generated_method = "8F82C5618944297E2295D41E531A28CB")
    
public int onStartCommand(Intent intent, int flags, int startId) {
        onStart(intent, startId);
        return mStartCompatibility ? START_STICKY_COMPATIBILITY : START_STICKY;
    }
    
    /**
     * Called by the system to notify a Service that it is no longer used and is being removed.  The
     * service should clean up an resources it holds (threads, registered
     * receivers, etc) at this point.  Upon return, there will be no more calls
     * in to this Service object and it is effectively dead.  Do not call this method directly.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.423 -0500", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "B543AE4E1838FF864DE64776FEE21A06")
    
public void onDestroy() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.425 -0500", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "7225E52F3A5BCFC0B4421616E52468C0")
    
public void onConfigurationChanged(Configuration newConfig) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.427 -0500", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "79F592DC22C7A97AE301DB7CC367A921")
    
public void onLowMemory() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.429 -0500", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "447804E40C3F002F4A06D23D7AFAFD46")
    
public void onTrimMemory(int level) {
    }

    /**
     * Return the communication channel to the service.  May return null if 
     * clients can not bind to the service.  The returned
     * {@link android.os.IBinder} is usually for a complex interface
     * that has been <a href="{@docRoot}guide/developing/tools/aidl.html">described using
     * aidl</a>.
     * 
     * <p><em>Note that unlike other application components, calls on to the
     * IBinder interface returned here may not happen on the main thread
     * of the process</em>.  More information about the main thread can be found in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html">Processes and
     * Threads</a>.</p>
     * 
     * @param intent The Intent that was used to bind to this service,
     * as given to {@link android.content.Context#bindService
     * Context.bindService}.  Note that any extras that were included with
     * the Intent at that point will <em>not</em> be seen here.
     * 
     * @return Return an IBinder through which clients can call on to the 
     *         service.
     */
    @DSVerified
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.432 -0500", hash_original_method = "E7069E97241B54247C185B02B263733A", hash_generated_method = "00BCEE37A5873355128A7403645D0D57")
    
public abstract IBinder onBind(Intent intent);

    /**
     * Called when all clients have disconnected from a particular interface
     * published by the service.  The default implementation does nothing and
     * returns false.
     * 
     * @param intent The Intent that was used to bind to this service,
     * as given to {@link android.content.Context#bindService
     * Context.bindService}.  Note that any extras that were included with
     * the Intent at that point will <em>not</em> be seen here.
     * 
     * @return Return true if you would like to have the service's
     * {@link #onRebind} method later called when new clients bind to it.
     */
    @DSVerified
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.434 -0500", hash_original_method = "5942B5AC8056FD2F0F888A571E85A724", hash_generated_method = "B52FE46858C6AEA7DD3A25C370E114B2")    
public boolean onUnbind(Intent intent) {
        return false;
    }
    
    /**
     * Called when new clients have connected to the service, after it had
     * previously been notified that all had disconnected in its
     * {@link #onUnbind}.  This will only be called if the implementation
     * of {@link #onUnbind} was overridden to return true.
     * 
     * @param intent The Intent that was used to bind to this service,
     * as given to {@link android.content.Context#bindService
     * Context.bindService}.  Note that any extras that were included with
     * the Intent at that point will <em>not</em> be seen here.
     */
    @DSVerified
    @DSComment("Potential intent to trigger other processing")    
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.436 -0500", hash_original_method = "96E602EF97C136D1349E20B0217FC297", hash_generated_method = "170404668CF0E888E1F95844174DBC8F")
    
public void onRebind(Intent intent) {
    }
    
    /**
     * This is called if the service is currently running and the user has
     * removed a task that comes from the service's application.  If you have
     * set {@link android.content.pm.ServiceInfo#FLAG_STOP_WITH_TASK ServiceInfo.FLAG_STOP_WITH_TASK}
     * then you will not receive this callback; instead, the service will simply
     * be stopped.
     *
     * @param rootIntent The original root Intent that was used to launch
     * the task that is being removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.438 -0500", hash_original_method = "8FB0E93CA9596F065DFD6DBA45B93821", hash_generated_method = "D19487D23911CA2C5A5E261B83D459BB")
    @DSVerified
    @DSComment("Potential intent to trigger other processing")    
    @DSSpec(DSCat.INTENT_EXCHANGE)
public void onTaskRemoved(Intent rootIntent) {
    }

    /**
     * Stop the service, if it was previously started.  This is the same as
     * calling {@link android.content.Context#stopService} for this particular service.
     *  
     * @see #stopSelfResult(int)
     */
    @DSComment("Modeled")
    @DSSafe(DSCat.SERVICE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.440 -0500", hash_original_method = "63DABFC9549E2FB476F01FDE2AC0A25B", hash_generated_method = "6A4F3280C1644685ECF463CC6170460B")
    
public final void stopSelf() {
        stopSelf(-1);
    }

    /**
     * Old version of {@link #stopSelfResult} that doesn't return a result.
     *  
     * @see #stopSelfResult
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.442 -0500", hash_original_method = "945F4D421616C07D2272A8F5A6D0EDF6", hash_generated_method = "84E7E3054C0728C13863EFE9EB35900B")
    
public final void stopSelf(int startId) {
        if (mActivityManager == null) {
            return;
        }
        try {
            mActivityManager.stopServiceToken(
                    new ComponentName(this, mClassName), mToken, startId);
        } catch (RemoteException ex) {
        }
    }
    
    /**
     * Stop the service if the most recent time it was started was 
     * <var>startId</var>.  This is the same as calling {@link 
     * android.content.Context#stopService} for this particular service but allows you to 
     * safely avoid stopping if there is a start request from a client that you 
     * haven't yet seen in {@link #onStart}. 
     * 
     * <p><em>Be careful about ordering of your calls to this function.</em>.
     * If you call this function with the most-recently received ID before
     * you have called it for previously received IDs, the service will be
     * immediately stopped anyway.  If you may end up processing IDs out
     * of order (such as by dispatching them on separate threads), then you
     * are responsible for stopping them in the same order you received them.</p>
     * 
     * @param startId The most recent start identifier received in {@link 
     *                #onStart}.
     * @return Returns true if the startId matches the last start request
     * and the service will be stopped, else false.
     *  
     * @see #stopSelf()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.445 -0500", hash_original_method = "12B5F8394AD7AE16AD90C8F95EA27CB9", hash_generated_method = "D75869DD78ADA2243A0449E131830721")
    
public final boolean stopSelfResult(int startId) {
        if (mActivityManager == null) {
            return false;
        }
        try {
            return mActivityManager.stopServiceToken(
                    new ComponentName(this, mClassName), mToken, startId);
        } catch (RemoteException ex) {
        }
        return false;
    }
    
    /**
     * @deprecated This is a now a no-op, use
     * {@link #startForeground(int, Notification)} instead.  This method
     * has been turned into a no-op rather than simply being deprecated
     * because analysis of numerous poorly behaving devices has shown that
     * increasingly often the trouble is being caused in part by applications
     * that are abusing it.  Thus, given a choice between introducing
     * problems in existing applications using this API (by allowing them to
     * be killed when they would like to avoid it), vs allowing the performance
     * of the entire system to be decreased, this method was deemed less
     * important.
     * 
     * @hide
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.448 -0500", hash_original_method = "3B13E95A68EC397B0EFBCB7AA4B170BC", hash_generated_method = "FA750168AC8DBEF3DC22D855ED02CD9A")
    
@Deprecated
    public final void setForeground(boolean isForeground) {
        Log.w(TAG, "setForeground: ignoring old API call on " + getClass().getName());
    }
    
    /**
     * Make this service run in the foreground, supplying the ongoing
     * notification to be shown to the user while in this state.
     * By default services are background, meaning that if the system needs to
     * kill them to reclaim more memory (such as to display a large page in a
     * web browser), they can be killed without too much harm.  You can set this
     * flag if killing your service would be disruptive to the user, such as
     * if your service is performing background music playback, so the user
     * would notice if their music stopped playing.
     * 
     * <p>If you need your application to run on platform versions prior to API
     * level 5, you can use the following model to call the the older setForeground()
     * or this modern method as appropriate:
     * 
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/ForegroundService.java
     *   foreground_compatibility}
     * 
     * @param id The identifier for this notification as per
     * {@link NotificationManager#notify(int, Notification)
     * NotificationManager.notify(int, Notification)}.
     * @param notification The Notification to be displayed.
     * 
     * @see #stopForeground(boolean)
     */
    @DSComment("Modeled")
    @DSSafe(DSCat.SERVICE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.450 -0500", hash_original_method = "4FFCDBDE627194B5F1589AC610EF3404", hash_generated_method = "E7922E938EE15A47E01E0BF5C300A6DD")
    
public final void startForeground(int id, Notification notification) {
        try {
            mActivityManager.setServiceForeground(
                    new ComponentName(this, mClassName), mToken, id,
                    notification, true);
        } catch (RemoteException ex) {
        }
    }
    
    /**
     * Remove this service from foreground state, allowing it to be killed if
     * more memory is needed.
     * @param removeNotification If true, the notification previously provided
     * to {@link #startForeground} will be removed.  Otherwise it will remain
     * until a later call removes it (or the service is destroyed).
     * @see #startForeground(int, Notification)
     */
    @DSComment("Modeled")
    @DSSafe(DSCat.SERVICE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.453 -0500", hash_original_method = "4C19D500B60A0A1E30AA501DC977F119", hash_generated_method = "59FCD336F1BF8E1E136DD024DAFDF61C")
    
public final void stopForeground(boolean removeNotification) {
        try {
            mActivityManager.setServiceForeground(
                    new ComponentName(this, mClassName), mToken, 0, null,
                    removeNotification);
        } catch (RemoteException ex) {
        }
    }
    
    /**
     * Print the Service's state into the given stream.  This gets invoked if
     * you run "adb shell dumpsys activity service <yourservicename>".
     * This is distinct from "dumpsys <servicename>", which only works for
     * named system services and which invokes the {@link IBinder#dump} method
     * on the {@link IBinder} interface registered with ServiceManager.
     *
     * @param fd The raw file descriptor that the dump is being sent to.
     * @param writer The PrintWriter to which you should dump your state.  This will be
     * closed for you after you return.
     * @param args additional arguments to the dump request.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.455 -0500", hash_original_method = "708CD3B4DCC4F45281F620E4C375E85F", hash_generated_method = "031B7EE125168FCDC45ABAEF9B7728B9")
    
protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.println("nothing to dump");
    }

    // ------------------ Internal API ------------------
    
    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.457 -0500", hash_original_method = "9EEE96C6B536EA578538BBE977205B62", hash_generated_method = "4B5F95705D5E22C79C38A8BC63593F12")
    
public final void attach(
            Context context,
            ActivityThread thread, String className, IBinder token,
            Application application, Object activityManager) {
        attachBaseContext(context);
        mThread = thread;           // NOTE:  unused - remove?
        mClassName = className;
        mToken = token;
        mApplication = application;
        mActivityManager = (IActivityManager)activityManager;
        mStartCompatibility = getApplicationInfo().targetSdkVersion
                < Build.VERSION_CODES.ECLAIR;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:43.459 -0500", hash_original_method = "8DA57A133C364DA0C4CA877026045103", hash_generated_method = "F6EF08CB09E5F3BCA9DE4EF151038199")
    
final String getClassName() {
        return mClassName;
    }

    @DSSafe
    public void droidSafeOnBind(Intent intent, ServiceConnection connection) {
        IBinder binder = this.onBind(intent);
        this.onUnbind(intent);
        this.onRebind(intent);
        connection.onServiceConnected(intent.getComponent(), binder);
        connection.onServiceDisconnected(intent.getComponent());
    }

    /**
     * callback hook for subservices
     */
    
    public void droidsafeOnSubServiceHook() {
        
    }
    
        public void setApplication(Application app) { 
                this.mApplication = app;
        }

}

