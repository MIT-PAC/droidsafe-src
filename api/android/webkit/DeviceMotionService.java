package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;





final class DeviceMotionService implements SensorEventListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.223 -0500", hash_original_field = "556E408B717769DC8A8D3D20CB3A7B1C", hash_generated_field = "9BEB3C1E993D7EFC95522BDB3A8CC69D")


    private static final int INTERVAL_MILLIS = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.205 -0500", hash_original_field = "ADF7031C73AC58838DF2C97D4D015C9D", hash_generated_field = "66D108DFC043A6E0A2844E4843186070")

    private DeviceMotionAndOrientationManager mManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.207 -0500", hash_original_field = "F57A6C5BD72C70EB93523745929F338F", hash_generated_field = "B2DDC5809B05187D32A84097DC68019C")

    private boolean mIsRunning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.209 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.212 -0500", hash_original_field = "91B605B3904EBFC2D1278ACCB01BB947", hash_generated_field = "D8CC5B9F3DF5D78484C533BB7CDDA85C")

    private SensorManager mSensorManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.214 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.216 -0500", hash_original_field = "14A7A26477CD3B2D020623361CD6DC43", hash_generated_field = "16AAE3611879142DAF4D4972E6DBF92E")

    private boolean mHaveSentErrorEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.219 -0500", hash_original_field = "D10548A7FA093A4F56A25B4E0A2206C3", hash_generated_field = "16C911A75559FF3FC455929D8833F7AD")

    private Runnable mUpdateRunnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.221 -0500", hash_original_field = "42D29F2A756B4D035CB2C64BF8E493D3", hash_generated_field = "D4A570CD23CCC3472A74A9385901C82C")

    private float mLastAcceleration[];

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.225 -0500", hash_original_method = "F55301D24998230F1C8CCBC205AE8660", hash_generated_method = "F53C05E9493C7015751DC972A1F1CFF0")
    
public DeviceMotionService(DeviceMotionAndOrientationManager manager, Context context) {
        mManager = manager;
        assert(mManager != null);
        mContext = context;
        assert(mContext != null);
     }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.227 -0500", hash_original_method = "98B4404819C6BBBB3597C623BA4BB028", hash_generated_method = "7FCE85BE18FD6DF44D983B65486A1E80")
    
public void start() {
        mIsRunning = true;
        registerForSensor();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.230 -0500", hash_original_method = "01C2E2F2F39858D9C160CE6783C7D17B", hash_generated_method = "BA89E0CC6EC3858FF35499F6E8D9C0BC")
    
public void stop() {
        mIsRunning = false;
        stopSendingUpdates();
        unregisterFromSensor();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.232 -0500", hash_original_method = "7537A7F7CC7F152580C5E8AB37332B9F", hash_generated_method = "0D73ED366EFD3E9B23F624B14E7BBD20")
    
public void suspend() {
        if (mIsRunning) {
            stopSendingUpdates();
            unregisterFromSensor();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.234 -0500", hash_original_method = "06D001413EE6654679884BE0B710A988", hash_generated_method = "A9252E500B40A4482657C07F2BB2B600")
    
public void resume() {
        if (mIsRunning) {
            registerForSensor();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.239 -0500", hash_original_method = "CDFAD74C98E46044259B3BCC3613C4C6", hash_generated_method = "248C82923C8D497CD8C7D49BC31345BC")
    
private void sendErrorEvent() {
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        // The spec requires that each listener receives the error event only once.
        if (mHaveSentErrorEvent)
            return;
        mHaveSentErrorEvent = true;
        createHandler();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
                if (mIsRunning) {
                    // The special case of all nulls is used to signify a failure to get data.
                    mManager.onMotionChange(null, null, null, 0.0);
                }
            }
        });
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.245 -0500", hash_original_method = "9B63FE7EDAA2DFAC9F6DE1381BA682EF", hash_generated_method = "B62ED1B6B3A3982E40B89BD0A00319AE")
    
private void createHandler() {
        if (mHandler != null) {
            return;
        }

        mHandler = new Handler();
        mUpdateRunnable = new Runnable() {
            @Override
            public void run() {
                assert mIsRunning;
                mManager.onMotionChange(new Double(mLastAcceleration[0]),
                        new Double(mLastAcceleration[1]), new Double(mLastAcceleration[2]),
                        INTERVAL_MILLIS);
                mHandler.postDelayed(mUpdateRunnable, INTERVAL_MILLIS);
                // Now that we have successfully sent some data, reset whether we've sent an error.
                mHaveSentErrorEvent = false;
            }
        };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.247 -0500", hash_original_method = "A3A2E2444DD47EDD24E157A7D990CD47", hash_generated_method = "A8AB9EDA9D09C0FE057A3AB2FE95DC59")
    
private void startSendingUpdates() {
        createHandler();
        mUpdateRunnable.run();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.249 -0500", hash_original_method = "C91FFFB25BA3A01D4AF61CC044FBC20A", hash_generated_method = "547EFCEA723E6A896C300423D72C9312")
    
private void stopSendingUpdates() {
        mHandler.removeCallbacks(mUpdateRunnable);
        mLastAcceleration = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.251 -0500", hash_original_method = "8EA92813CD5F00D63229FB53D6348E72", hash_generated_method = "8D82A048E10B3C037F8FCAA443A9C304")
    
private void registerForSensor() {
        if (!registerForAccelerometerSensor()) {
            sendErrorEvent();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.254 -0500", hash_original_method = "D09B23AC902B5D9C0E49BB52A156F918", hash_generated_method = "FEB2F552C044EE42CFEE371617B0383D")
    
private SensorManager getSensorManager() {
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        if (mSensorManager == null) {
            mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        }
        return mSensorManager;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.257 -0500", hash_original_method = "132C72132CB3FECC364192FB60290F0C", hash_generated_method = "A3D352B71E1CC15368CF3146B53804A1")
    
private boolean registerForAccelerometerSensor() {
        List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.isEmpty()) {
            return false;
        }
        createHandler();
        // TODO: Consider handling multiple sensors.
        return getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_UI, mHandler);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.259 -0500", hash_original_method = "8F0ED17D95B5480F975ECDA7EDF68357", hash_generated_method = "641F1F35A7CD6569AAD9EDA882C9BEB2")
    
private void unregisterFromSensor() {
        getSensorManager().unregisterListener(this);
    }

    /**
     * SensorEventListener implementation.
     * Callbacks happen on the thread on which we registered - the WebCore thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.261 -0500", hash_original_method = "7AFE6EE6D4C15EE2C452A64798BB4D96", hash_generated_method = "F882DF3E0B42A2F33ACCDD3DBBCA5BAB")
    
public void onSensorChanged(SensorEvent event) {
        assert(event.values.length == 3);
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        assert(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER);

        // We may get callbacks after the call to getSensorManager().unregisterListener() returns.
        if (!mIsRunning) {
            return;
        }

        boolean firstData = mLastAcceleration == null;
        mLastAcceleration = event.values;
        if (firstData) {
            startSendingUpdates();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.264 -0500", hash_original_method = "4C77A6863BACF480F39B2826F5CA663C", hash_generated_method = "64E39387A039533466C0623BF8FBA522")
    
public void onAccuracyChanged(Sensor sensor, int accuracy) {
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
    }
}

