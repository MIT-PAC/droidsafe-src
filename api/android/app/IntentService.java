package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

public abstract class IntentService extends Service {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.818 -0500", hash_original_field = "EB66E49061F21B01C586336F5B80897E", hash_generated_field = "33385112DDE0E3E321411FB3B24485E8")

    private volatile Looper mServiceLooper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.820 -0500", hash_original_field = "B40565E22FBAA0B9F2DB0B431D978A45", hash_generated_field = "10B7385FA09CCC5FFC133C854DC08841")

    private volatile ServiceHandler mServiceHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.822 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.824 -0500", hash_original_field = "188B2E6B4A16F5675B57F98CFBB1543F", hash_generated_field = "B638FC293FF73E5C6335F69D10080A12")

    private boolean mRedelivery;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    @DSComment("Standard service for offloading task to background")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.834 -0500", hash_original_method = "65486D76CF06DAF1688CBC9F94DF0A6F", hash_generated_method = "1F8C236D9D024086E13FC09FFC3A3C72")
    
public IntentService(String name) {
        super();
        mName = name;
    }

    /**
     * Sets intent redelivery preferences.  Usually called from the constructor
     * with your preferred semantics.
     *
     * <p>If enabled is true,
     * {@link #onStartCommand(Intent, int, int)} will return
     * {@link Service#START_REDELIVER_INTENT}, so if this process dies before
     * {@link #onHandleIntent(Intent)} returns, the process will be restarted
     * and the intent redelivered.  If multiple Intents have been sent, only
     * the most recent one is guaranteed to be redelivered.
     *
     * <p>If enabled is false (the default),
     * {@link #onStartCommand(Intent, int, int)} will return
     * {@link Service#START_NOT_STICKY}, and if the process dies, the Intent
     * dies along with it.
     */
    @DSComment("no impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.836 -0500", hash_original_method = "5DC41098BF9C689ED5E1C1A6B5CD66D3", hash_generated_method = "9819940AC2D0C760DCD334594E90C004")
    
public void setIntentRedelivery(boolean enabled) {
        mRedelivery = enabled;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.838 -0500", hash_original_method = "D44587B147DECF989C6FA60808062415", hash_generated_method = "7C2E7A3D8CB60D4DD3F2650DD1DE5ABC")
    
@Override
    public void onCreate() {
        // TODO: It would be nice to have an option to hold a partial wakelock
        // during processing, and to have a static startService(Context, Intent)
        // method that would launch the service & hand off a wakelock.

        super.onCreate();
        HandlerThread thread = new HandlerThread("IntentService[" + mName + "]");
        thread.start();

        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.841 -0500", hash_original_method = "1A8CCBE4C5A081BBDC2E857325C2F354", hash_generated_method = "44FDF9E70DE06721462D5094339E1AE1")
    
@Override
    public void onStart(Intent intent, int startId) {
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        msg.obj = intent;
        mServiceHandler.sendMessage(msg);
    }

    /**
     * You should not override this method for your IntentService. Instead,
     * override {@link #onHandleIntent}, which the system calls when the IntentService
     * receives a start request.
     * @see android.app.Service#onStartCommand
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.843 -0500", hash_original_method = "38140402AEC024932D8DF709F80C2AA8", hash_generated_method = "8A862437975BF5D7F532D7E88BD5534F")
    
@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        onStart(intent, startId);
        return mRedelivery ? START_REDELIVER_INTENT : START_NOT_STICKY;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.845 -0500", hash_original_method = "1A14C95333617FF45AA4B183BFCE9C2C", hash_generated_method = "E0C452F6F9ED4DD053BA58A501C61F28")
    
@Override
    public void onDestroy() {
        mServiceLooper.quit();
    }

    /**
     * Unless you provide binding for your service, you don't need to implement this
     * method, because the default implementation returns null. 
     * @see android.app.Service#onBind
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.847 -0500", hash_original_method = "B9DB5B746A4D0B6826A1AC056C39AB0D", hash_generated_method = "44085DEE1AB74F2E611DE1D443ED2150")
    
@Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * This method is invoked on the worker thread with a request to process.
     * Only one Intent is processed at a time, but the processing happens on a
     * worker thread that runs independently from other application logic.
     * So, if this code takes a long time, it will hold up other requests to
     * the same IntentService, but it will not hold up anything else.
     * When all requests have been handled, the IntentService stops itself,
     * so you should not call {@link #stopSelf}.
     *
     * @param intent The value passed to {@link
     *               android.content.Context#startService(Intent)}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.849 -0500", hash_original_method = "3873E8578EC35B4631BF55BE7B040145", hash_generated_method = "76B2D51F2AC1BE5101F9DFE35DD2D67A")
    
protected abstract void onHandleIntent(Intent intent);
    
    private final class ServiceHandler extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.828 -0500", hash_original_method = "66EEB465EED068540EC8804EEAB41C77", hash_generated_method = "3FC585DC347F6956BFDECFB1F53984B6")
        
public ServiceHandler(Looper looper) {
            super(looper);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.830 -0500", hash_original_method = "54FB6BD49FB0E5DF524AEC3E07C0037D", hash_generated_method = "72C7E7960D6CAE09BBA5E612FD9119CF")
        
@Override
        public void handleMessage(Message msg) {
            onHandleIntent((Intent)msg.obj);
            stopSelf(msg.arg1);
        }
        
    }
    
    public void __ds__onHandleIntent(Intent intent) {
    	onHandleIntent(intent);
    }
}

