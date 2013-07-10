package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.427 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "66D108DFC043A6E0A2844E4843186070")

    private DeviceMotionAndOrientationManager mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.427 -0400", hash_original_field = "130D713CAF236B328B5223DFA18F1488", hash_generated_field = "B2DDC5809B05187D32A84097DC68019C")

    private boolean mIsRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.427 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.427 -0400", hash_original_field = "8CDFC97B128FB94D2A2F11FDAFFE50EA", hash_generated_field = "D8CC5B9F3DF5D78484C533BB7CDDA85C")

    private SensorManager mSensorManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.427 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.427 -0400", hash_original_field = "2C3606D875A88A4154C18923EE3485CF", hash_generated_field = "16AAE3611879142DAF4D4972E6DBF92E")

    private boolean mHaveSentErrorEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.427 -0400", hash_original_field = "084498CA6FFD1B3976129A78E779839D", hash_generated_field = "16C911A75559FF3FC455929D8833F7AD")

    private Runnable mUpdateRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.427 -0400", hash_original_field = "B521B76CAC58E2A585AF8E91991B773E", hash_generated_field = "D4A570CD23CCC3472A74A9385901C82C")

    private float mLastAcceleration[];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.427 -0400", hash_original_method = "F55301D24998230F1C8CCBC205AE8660", hash_generated_method = "91D9E15C868D33484D657357AE6A6D5A")
    public  DeviceMotionService(DeviceMotionAndOrientationManager manager, Context context) {
        mManager = manager;
        mContext = context;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.428 -0400", hash_original_method = "98B4404819C6BBBB3597C623BA4BB028", hash_generated_method = "B7F692BDF799E4ACD08DFAD15C4EC7B0")
    public void start() {
        mIsRunning = true;
        registerForSensor();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.428 -0400", hash_original_method = "01C2E2F2F39858D9C160CE6783C7D17B", hash_generated_method = "D2F2FBC703239730100BC77A7A87E537")
    public void stop() {
        mIsRunning = false;
        stopSendingUpdates();
        unregisterFromSensor();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.429 -0400", hash_original_method = "7537A7F7CC7F152580C5E8AB37332B9F", hash_generated_method = "74AA08EED187C7AF41E2E27CF3870552")
    public void suspend() {
        {
            stopSendingUpdates();
            unregisterFromSensor();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.429 -0400", hash_original_method = "06D001413EE6654679884BE0B710A988", hash_generated_method = "72CED80097AB1F64A75A2D2BE809ECA5")
    public void resume() {
        {
            registerForSensor();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.430 -0400", hash_original_method = "CDFAD74C98E46044259B3BCC3613C4C6", hash_generated_method = "0288846C3D574FF8119F8CAFA0EC0B0C")
    private void sendErrorEvent() {
        mHaveSentErrorEvent = true;
        createHandler();
        mHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.430 -0400", hash_original_method = "7A626774FEDB8F7ED99A6D9AA618F581", hash_generated_method = "A9B9AA3581038650352546A765A7D60E")
            @Override
            public void run() {
                {
                    mManager.onMotionChange(null, null, null, 0.0);
                } 
                
                
                
                    
                
            }
});
        
        
        
            
        
        
        
            
            
                
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.432 -0400", hash_original_method = "9B63FE7EDAA2DFAC9F6DE1381BA682EF", hash_generated_method = "4BA22B2D383730BF62A0527069C298E6")
    private void createHandler() {
        mHandler = new Handler();
        mUpdateRunnable = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.432 -0400", hash_original_method = "BF4DF07DFA0B7EFFD5AC0E28D1CE9285", hash_generated_method = "9058959D11C31754F9029A679BB2DC7A")
            @Override
            public void run() {
                mManager.onMotionChange(new Double(mLastAcceleration[0]),
                        new Double(mLastAcceleration[1]), new Double(mLastAcceleration[2]),
                        INTERVAL_MILLIS);
                mHandler.postDelayed(mUpdateRunnable, INTERVAL_MILLIS);
                mHaveSentErrorEvent = false;
                
                
                
                        
                        
                
                
            }
};
        
        
            
        
        
        
            
            
                
                
                        
                        
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.433 -0400", hash_original_method = "A3A2E2444DD47EDD24E157A7D990CD47", hash_generated_method = "9D2E6C8D82D655D950CB0FEE1EEC48AE")
    private void startSendingUpdates() {
        createHandler();
        mUpdateRunnable.run();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.433 -0400", hash_original_method = "C91FFFB25BA3A01D4AF61CC044FBC20A", hash_generated_method = "BCE08908D6D1E37280656543AC394DA7")
    private void stopSendingUpdates() {
        mHandler.removeCallbacks(mUpdateRunnable);
        mLastAcceleration = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.434 -0400", hash_original_method = "8EA92813CD5F00D63229FB53D6348E72", hash_generated_method = "BD4287FECA688A9780CE4F8159099033")
    private void registerForSensor() {
        {
            boolean var7B71D659CEDC4F674BF637DDEB7E8F23_827691317 = (!registerForAccelerometerSensor());
            {
                sendErrorEvent();
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.434 -0400", hash_original_method = "D09B23AC902B5D9C0E49BB52A156F918", hash_generated_method = "FC5F2E2673C35C3953BE0025FD0F744B")
    private SensorManager getSensorManager() {
        SensorManager varB4EAC82CA7396A68D541C85D26508E83_1204667475 = null; 
        {
            mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1204667475 = mSensorManager;
        varB4EAC82CA7396A68D541C85D26508E83_1204667475.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1204667475;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.435 -0400", hash_original_method = "132C72132CB3FECC364192FB60290F0C", hash_generated_method = "A7EBD80598C54666AE731D6903235A2B")
    private boolean registerForAccelerometerSensor() {
        List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        {
            boolean var60EE0D8C32CDAFA59C16DF69FA87513D_116456104 = (sensors.isEmpty());
        } 
        createHandler();
        boolean var9A009F83A3E9451F0925F7E801D939AA_680765523 = (getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_UI, mHandler));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619043477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619043477;
        
        
        
            
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.435 -0400", hash_original_method = "8F0ED17D95B5480F975ECDA7EDF68357", hash_generated_method = "9047F07B49AB7461A60D1DD86FDABEAE")
    private void unregisterFromSensor() {
        getSensorManager().unregisterListener(this);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.436 -0400", hash_original_method = "7AFE6EE6D4C15EE2C452A64798BB4D96", hash_generated_method = "240E360E1E20A03EDFCA5AFC5DCCC1C0")
    public void onSensorChanged(SensorEvent event) {
        
        boolean firstData = mLastAcceleration == null;
        mLastAcceleration = event.values;
        {
            startSendingUpdates();
        } 
        
        
        
        
        
            
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.436 -0400", hash_original_method = "4C77A6863BACF480F39B2826F5CA663C", hash_generated_method = "1A434A1FCBBAC533510C9D8C55877D2F")
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        
        addTaint(sensor.getTaint());
        addTaint(accuracy);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.436 -0400", hash_original_field = "6F01D460799E7BF514D22B06957DBD6A", hash_generated_field = "9BEB3C1E993D7EFC95522BDB3A8CC69D")

    private static final int INTERVAL_MILLIS = 100;
}

