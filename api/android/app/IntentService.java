package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;





public abstract class IntentService extends Service {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.498 -0400", hash_original_field = "895D9C25B61501F06B395F423CBECB05", hash_generated_field = "33385112DDE0E3E321411FB3B24485E8")

    private volatile Looper mServiceLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.498 -0400", hash_original_field = "BE7B16D1144D405C7B5C57C44F878C4D", hash_generated_field = "10B7385FA09CCC5FFC133C854DC08841")

    private volatile ServiceHandler mServiceHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.498 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.498 -0400", hash_original_field = "511FD1780C9A0397B85010166099D673", hash_generated_field = "B638FC293FF73E5C6335F69D10080A12")

    private boolean mRedelivery;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.498 -0400", hash_original_method = "65486D76CF06DAF1688CBC9F94DF0A6F", hash_generated_method = "E803BFED5D7E11609305F714CC10CB38")
    public  IntentService(String name) {
        super();
        mName = name;
        // ---------- Original Method ----------
        //mName = name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.499 -0400", hash_original_method = "5DC41098BF9C689ED5E1C1A6B5CD66D3", hash_generated_method = "BF0E6D5DC1A4107DCB204701CFD64C59")
    public void setIntentRedelivery(boolean enabled) {
        mRedelivery = enabled;
        // ---------- Original Method ----------
        //mRedelivery = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.499 -0400", hash_original_method = "D44587B147DECF989C6FA60808062415", hash_generated_method = "134209EF8F043B64491C32D5B342ADC6")
    @Override
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onCreate();
        HandlerThread thread = new HandlerThread("IntentService[" + mName + "]");
        thread.start();
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
        // ---------- Original Method ----------
        //super.onCreate();
        //HandlerThread thread = new HandlerThread("IntentService[" + mName + "]");
        //thread.start();
        //mServiceLooper = thread.getLooper();
        //mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.499 -0400", hash_original_method = "1A8CCBE4C5A081BBDC2E857325C2F354", hash_generated_method = "887436FAF5CDDB5C3BD15FD14B9A3878")
    @Override
    public void onStart(Intent intent, int startId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(startId);
        addTaint(intent.getTaint());
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        msg.obj = intent;
        mServiceHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = mServiceHandler.obtainMessage();
        //msg.arg1 = startId;
        //msg.obj = intent;
        //mServiceHandler.sendMessage(msg);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.499 -0400", hash_original_method = "38140402AEC024932D8DF709F80C2AA8", hash_generated_method = "6C6EE9C9971AE3A7F9CD82B757FDAB4E")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(startId);
        addTaint(flags);
        addTaint(intent.getTaint());
        onStart(intent, startId);
        int var1A31932D1065789B8FC2E0A8CC013C8A_1543865076 = (mRedelivery ? START_REDELIVER_INTENT : START_NOT_STICKY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164548796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164548796;
        // ---------- Original Method ----------
        //onStart(intent, startId);
        //return mRedelivery ? START_REDELIVER_INTENT : START_NOT_STICKY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.500 -0400", hash_original_method = "1A14C95333617FF45AA4B183BFCE9C2C", hash_generated_method = "57CFED3BCB345327405FC23DC37C7117")
    @Override
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mServiceLooper.quit();
        // ---------- Original Method ----------
        //mServiceLooper.quit();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.500 -0400", hash_original_method = "B9DB5B746A4D0B6826A1AC056C39AB0D", hash_generated_method = "C38BAFBC67137FBACD06C8549E6B765A")
    @Override
    public IBinder onBind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
IBinder var540C13E9E156B687226421B24F2DF178_1575286293 =         null;
        var540C13E9E156B687226421B24F2DF178_1575286293.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1575286293;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    protected abstract void onHandleIntent(Intent intent);

    
    private final class ServiceHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.500 -0400", hash_original_method = "66EEB465EED068540EC8804EEAB41C77", hash_generated_method = "483F79A59D6FFABD3DB5D2AD7A4017D7")
        public  ServiceHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.500 -0400", hash_original_method = "54FB6BD49FB0E5DF524AEC3E07C0037D", hash_generated_method = "EB11256F08F20A03F3A5317996878929")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            onHandleIntent((Intent)msg.obj);
            stopSelf(msg.arg1);
            // ---------- Original Method ----------
            //onHandleIntent((Intent)msg.obj);
            //stopSelf(msg.arg1);
        }

        
    }

    public void __ds__onHandleIntent(Intent intent) {
    	onHandleIntent(intent);
    }
}

