package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.webkit.DeviceMotionAndOrientationManager;
import java.lang.Runnable;
import java.util.List;

final class DeviceMotionService implements SensorEventListener {
    private DeviceMotionAndOrientationManager mManager;
    private boolean mIsRunning;
    private Handler mHandler;
    private SensorManager mSensorManager;
    private Context mContext;
    private boolean mHaveSentErrorEvent;
    private Runnable mUpdateRunnable;
    private float mLastAcceleration[];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.130 -0400", hash_original_method = "F55301D24998230F1C8CCBC205AE8660", hash_generated_method = "8DABE17E17536201EACC5704B194CEA7")
    @DSModeled(DSC.SAFE)
    public DeviceMotionService(DeviceMotionAndOrientationManager manager, Context context) {
        dsTaint.addTaint(manager.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mManager = manager;
        //assert(mManager != null);
        //mContext = context;
        //assert(mContext != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.130 -0400", hash_original_method = "98B4404819C6BBBB3597C623BA4BB028", hash_generated_method = "B7F692BDF799E4ACD08DFAD15C4EC7B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() {
        mIsRunning = true;
        registerForSensor();
        // ---------- Original Method ----------
        //mIsRunning = true;
        //registerForSensor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.130 -0400", hash_original_method = "01C2E2F2F39858D9C160CE6783C7D17B", hash_generated_method = "D2F2FBC703239730100BC77A7A87E537")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stop() {
        mIsRunning = false;
        stopSendingUpdates();
        unregisterFromSensor();
        // ---------- Original Method ----------
        //mIsRunning = false;
        //stopSendingUpdates();
        //unregisterFromSensor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.130 -0400", hash_original_method = "7537A7F7CC7F152580C5E8AB37332B9F", hash_generated_method = "74AA08EED187C7AF41E2E27CF3870552")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void suspend() {
        {
            stopSendingUpdates();
            unregisterFromSensor();
        } //End block
        // ---------- Original Method ----------
        //if (mIsRunning) {
            //stopSendingUpdates();
            //unregisterFromSensor();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.131 -0400", hash_original_method = "06D001413EE6654679884BE0B710A988", hash_generated_method = "72CED80097AB1F64A75A2D2BE809ECA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void resume() {
        {
            registerForSensor();
        } //End block
        // ---------- Original Method ----------
        //if (mIsRunning) {
            //registerForSensor();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.131 -0400", hash_original_method = "CDFAD74C98E46044259B3BCC3613C4C6", hash_generated_method = "59A9C13325F28103E518C0389F6C380B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendErrorEvent() {
        mHaveSentErrorEvent = true;
        createHandler();
        mHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.131 -0400", hash_original_method = "7A626774FEDB8F7ED99A6D9AA618F581", hash_generated_method = "A9B9AA3581038650352546A765A7D60E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                {
                    mManager.onMotionChange(null, null, null, 0.0);
                } //End block
                // ---------- Original Method ----------
                //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
                //if (mIsRunning) {
                    //mManager.onMotionChange(null, null, null, 0.0);
                //}
            }
});
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //if (mHaveSentErrorEvent)
            //return;
        //mHaveSentErrorEvent = true;
        //createHandler();
        //mHandler.post(new Runnable() {
            //@Override
            //public void run() {
                //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
                //if (mIsRunning) {
                    //mManager.onMotionChange(null, null, null, 0.0);
                //}
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.132 -0400", hash_original_method = "9B63FE7EDAA2DFAC9F6DE1381BA682EF", hash_generated_method = "9D08C4A621B8A6937125A807D051431F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createHandler() {
        mHandler = new Handler();
        mUpdateRunnable = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.132 -0400", hash_original_method = "BF4DF07DFA0B7EFFD5AC0E28D1CE9285", hash_generated_method = "9058959D11C31754F9029A679BB2DC7A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                mManager.onMotionChange(new Double(mLastAcceleration[0]),
                        new Double(mLastAcceleration[1]), new Double(mLastAcceleration[2]),
                        INTERVAL_MILLIS);
                mHandler.postDelayed(mUpdateRunnable, INTERVAL_MILLIS);
                mHaveSentErrorEvent = false;
                // ---------- Original Method ----------
                //assert mIsRunning;
                //mManager.onMotionChange(new Double(mLastAcceleration[0]),
                        //new Double(mLastAcceleration[1]), new Double(mLastAcceleration[2]),
                        //INTERVAL_MILLIS);
                //mHandler.postDelayed(mUpdateRunnable, INTERVAL_MILLIS);
                //mHaveSentErrorEvent = false;
            }
};
        // ---------- Original Method ----------
        //if (mHandler != null) {
            //return;
        //}
        //mHandler = new Handler();
        //mUpdateRunnable = new Runnable() {
            //@Override
            //public void run() {
                //assert mIsRunning;
                //mManager.onMotionChange(new Double(mLastAcceleration[0]),
                        //new Double(mLastAcceleration[1]), new Double(mLastAcceleration[2]),
                        //INTERVAL_MILLIS);
                //mHandler.postDelayed(mUpdateRunnable, INTERVAL_MILLIS);
                //mHaveSentErrorEvent = false;
            //}
        //};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.132 -0400", hash_original_method = "A3A2E2444DD47EDD24E157A7D990CD47", hash_generated_method = "9D2E6C8D82D655D950CB0FEE1EEC48AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startSendingUpdates() {
        createHandler();
        mUpdateRunnable.run();
        // ---------- Original Method ----------
        //createHandler();
        //mUpdateRunnable.run();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.141 -0400", hash_original_method = "C91FFFB25BA3A01D4AF61CC044FBC20A", hash_generated_method = "BCE08908D6D1E37280656543AC394DA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void stopSendingUpdates() {
        mHandler.removeCallbacks(mUpdateRunnable);
        mLastAcceleration = null;
        // ---------- Original Method ----------
        //mHandler.removeCallbacks(mUpdateRunnable);
        //mLastAcceleration = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.142 -0400", hash_original_method = "8EA92813CD5F00D63229FB53D6348E72", hash_generated_method = "70117127A973E2EEEDE50AF764CB8568")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void registerForSensor() {
        {
            boolean var7B71D659CEDC4F674BF637DDEB7E8F23_1431526058 = (!registerForAccelerometerSensor());
            {
                sendErrorEvent();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!registerForAccelerometerSensor()) {
            //sendErrorEvent();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.142 -0400", hash_original_method = "D09B23AC902B5D9C0E49BB52A156F918", hash_generated_method = "68420051782C3B29E23DB6D9B57A438F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SensorManager getSensorManager() {
        {
            mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        } //End block
        return (SensorManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //if (mSensorManager == null) {
            //mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        //}
        //return mSensorManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.142 -0400", hash_original_method = "132C72132CB3FECC364192FB60290F0C", hash_generated_method = "E8308301A6E32D0AF4FFC0A7E96A2AB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean registerForAccelerometerSensor() {
        List<Sensor> sensors;
        sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        {
            boolean var60EE0D8C32CDAFA59C16DF69FA87513D_185483065 = (sensors.isEmpty());
        } //End collapsed parenthetic
        createHandler();
        boolean var9A009F83A3E9451F0925F7E801D939AA_1229229628 = (getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_UI, mHandler));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        //if (sensors.isEmpty()) {
            //return false;
        //}
        //createHandler();
        //return getSensorManager().registerListener(
                //this, sensors.get(0), SensorManager.SENSOR_DELAY_UI, mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.143 -0400", hash_original_method = "8F0ED17D95B5480F975ECDA7EDF68357", hash_generated_method = "9047F07B49AB7461A60D1DD86FDABEAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unregisterFromSensor() {
        getSensorManager().unregisterListener(this);
        // ---------- Original Method ----------
        //getSensorManager().unregisterListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.143 -0400", hash_original_method = "7AFE6EE6D4C15EE2C452A64798BB4D96", hash_generated_method = "E8E376837645579F14462C1DEA6B14ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onSensorChanged(SensorEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        boolean firstData;
        firstData = mLastAcceleration == null;
        mLastAcceleration = event.values;
        {
            startSendingUpdates();
        } //End block
        // ---------- Original Method ----------
        //assert(event.values.length == 3);
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //assert(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER);
        //if (!mIsRunning) {
            //return;
        //}
        //boolean firstData = mLastAcceleration == null;
        //mLastAcceleration = event.values;
        //if (firstData) {
            //startSendingUpdates();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.143 -0400", hash_original_method = "4C77A6863BACF480F39B2826F5CA663C", hash_generated_method = "81A8C3534F22D079E33B44B7968F9E76")
    @DSModeled(DSC.SAFE)
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(sensor.dsTaint);
        dsTaint.addTaint(accuracy);
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
    }

    
    private static final int INTERVAL_MILLIS = 100;
}

