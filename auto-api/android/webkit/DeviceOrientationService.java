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
import android.webkit.DeviceMotionAndOrientationManager;
import java.lang.Runnable;
import java.util.List;

final class DeviceOrientationService implements SensorEventListener {
    private float[] mGravityVector;
    private float[] mMagneticFieldVector;
    private DeviceMotionAndOrientationManager mManager;
    private boolean mIsRunning;
    private Handler mHandler;
    private SensorManager mSensorManager;
    private Context mContext;
    private Double mAlpha;
    private Double mBeta;
    private Double mGamma;
    private boolean mHaveSentErrorEvent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.168 -0400", hash_original_method = "4D8FCE308D7FC749FF19FBAE89D7CA70", hash_generated_method = "5346557D14BE581F29F87EB28B385E3E")
    @DSModeled(DSC.SAFE)
    public DeviceOrientationService(DeviceMotionAndOrientationManager manager, Context context) {
        dsTaint.addTaint(manager.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mManager = manager;
        //assert(mManager != null);
        //mContext = context;
        //assert(mContext != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.168 -0400", hash_original_method = "4CC8267164C7FA2FF7A54409829F5B3F", hash_generated_method = "1271AEFE8C3FFFE0936AD75B93E923E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() {
        mIsRunning = true;
        registerForSensors();
        // ---------- Original Method ----------
        //mIsRunning = true;
        //registerForSensors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.168 -0400", hash_original_method = "E95AF6342D982D1129097C11892774DC", hash_generated_method = "574593EF3A6A5CC6922E3DFC8DCA805B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stop() {
        mIsRunning = false;
        unregisterFromSensors();
        // ---------- Original Method ----------
        //mIsRunning = false;
        //unregisterFromSensors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.169 -0400", hash_original_method = "D444E72BAE4BC67A93A8D811E5903DC0", hash_generated_method = "533B20682832B01765AE0229F204D016")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void suspend() {
        {
            unregisterFromSensors();
        } //End block
        // ---------- Original Method ----------
        //if (mIsRunning) {
            //unregisterFromSensors();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.169 -0400", hash_original_method = "13F627D50D1CD4F6B5F8D936ACD57861", hash_generated_method = "BA8DD886820E8980C98F486376D907FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void resume() {
        {
            registerForSensors();
        } //End block
        // ---------- Original Method ----------
        //if (mIsRunning) {
            //registerForSensors();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.169 -0400", hash_original_method = "C4E19FEB85A20B838CCD6120912B24F7", hash_generated_method = "E3B91F41D22FE1D21E99E485D15BC461")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendErrorEvent() {
        mHaveSentErrorEvent = true;
        mHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.169 -0400", hash_original_method = "1621C64DF7C2F75E1B41A795930D55FE", hash_generated_method = "F5328AA94959BD83345E20C737866B21")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                {
                    mManager.onOrientationChange(null, null, null);
                } //End block
                // ---------- Original Method ----------
                //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
                //if (mIsRunning) {
                    //mManager.onOrientationChange(null, null, null);
                //}
            }
});
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //if (mHaveSentErrorEvent)
            //return;
        //mHaveSentErrorEvent = true;
        //mHandler.post(new Runnable() {
            //@Override
            //public void run() {
                //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
                //if (mIsRunning) {
                    //mManager.onOrientationChange(null, null, null);
                //}
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.169 -0400", hash_original_method = "A01419D47FD253423887BAF542AEFD8C", hash_generated_method = "AF28C208BE9D264C6D2F409F51993939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void registerForSensors() {
        {
            mHandler = new Handler();
        } //End block
        {
            boolean varD10B56D8CDB3C9ACD05B4907C7995E4D_541911300 = (!registerForAccelerometerSensor() || !registerForMagneticFieldSensor());
            {
                unregisterFromSensors();
                sendErrorEvent();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mHandler == null) {
            //mHandler = new Handler();
        //}
        //if (!registerForAccelerometerSensor() || !registerForMagneticFieldSensor()) {
            //unregisterFromSensors();
            //sendErrorEvent();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.170 -0400", hash_original_method = "A3B30EF17FDC8C38C5B1B85F341CAEE6", hash_generated_method = "19A1B7551D176109138F78EB45335645")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getOrientationUsingGetRotationMatrix() {
        float[] deviceRotationMatrix;
        deviceRotationMatrix = new float[9];
        {
            boolean var04E5920A53519DAB5BCCE922FB99C72B_513651599 = (!SensorManager.getRotationMatrix(
                deviceRotationMatrix, null, mGravityVector, mMagneticFieldVector));
        } //End collapsed parenthetic
        float[] rotationAngles;
        rotationAngles = new float[3];
        SensorManager.getOrientation(deviceRotationMatrix, rotationAngles);
        double alpha;
        alpha = Math.toDegrees(-rotationAngles[0]) - 90.0;
        {
            alpha += 360.0;
        } //End block
        double beta;
        beta = Math.toDegrees(-rotationAngles[1]);
        {
            beta += 360.0;
        } //End block
        double gamma;
        gamma = Math.toDegrees(rotationAngles[2]);
        {
            gamma += 360.0;
        } //End block
        maybeSendChange(alpha, beta, gamma);
        // ---------- Original Method ----------
        //if (mGravityVector == null || mMagneticFieldVector == null) {
            //return;
        //}
        //float[] deviceRotationMatrix = new float[9];
        //if (!SensorManager.getRotationMatrix(
                //deviceRotationMatrix, null, mGravityVector, mMagneticFieldVector)) {
            //return;
        //}
        //float[] rotationAngles = new float[3];
        //SensorManager.getOrientation(deviceRotationMatrix, rotationAngles);
        //double alpha = Math.toDegrees(-rotationAngles[0]) - 90.0;
        //while (alpha < 0.0) { alpha += 360.0; }
        //double beta = Math.toDegrees(-rotationAngles[1]);
        //while (beta < -180.0) { beta += 360.0; }
        //double gamma = Math.toDegrees(rotationAngles[2]);
        //while (gamma < -90.0) { gamma += 360.0; }
        //maybeSendChange(alpha, beta, gamma);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.170 -0400", hash_original_method = "D09B23AC902B5D9C0E49BB52A156F918", hash_generated_method = "68420051782C3B29E23DB6D9B57A438F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.170 -0400", hash_original_method = "B3284C523F8E8DEDA1572FA7CE19585B", hash_generated_method = "240A3DE9041C1C40AC201BDD7B9F21BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean registerForAccelerometerSensor() {
        List<Sensor> sensors;
        sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        {
            boolean var60EE0D8C32CDAFA59C16DF69FA87513D_1087737180 = (sensors.isEmpty());
        } //End collapsed parenthetic
        boolean var6CCE466F5EF5C5884CB21519A351854C_1204859246 = (getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        //if (sensors.isEmpty()) {
            //return false;
        //}
        //return getSensorManager().registerListener(
                //this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.170 -0400", hash_original_method = "DFE78C89ABF5437F78B53A9E5486BEA8", hash_generated_method = "F33430C572A752E461893B02D5F535AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean registerForMagneticFieldSensor() {
        List<Sensor> sensors;
        sensors = getSensorManager().getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        {
            boolean var60EE0D8C32CDAFA59C16DF69FA87513D_656106893 = (sensors.isEmpty());
        } //End collapsed parenthetic
        boolean var6CCE466F5EF5C5884CB21519A351854C_455422981 = (getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        //if (sensors.isEmpty()) {
            //return false;
        //}
        //return getSensorManager().registerListener(
                //this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.171 -0400", hash_original_method = "3017DC11BC04FDEC5E6982352A18F2D7", hash_generated_method = "D951C525941C25B5CE19BA545AA9B4D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unregisterFromSensors() {
        getSensorManager().unregisterListener(this);
        // ---------- Original Method ----------
        //getSensorManager().unregisterListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.171 -0400", hash_original_method = "B4ADD48907D203A526782697C56D84A1", hash_generated_method = "576A1DA3FC021E51F937F9943A2A6808")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void maybeSendChange(double alpha, double beta, double gamma) {
        dsTaint.addTaint(gamma);
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(beta);
        {
            boolean var4D37320EFAE908439958107B39475443_347162581 = (mAlpha == null || mBeta == null || mGamma == null
                || Math.abs(alpha - mAlpha) > DELTA_DEGRESS
                || Math.abs(beta - mBeta) > DELTA_DEGRESS
                || Math.abs(gamma - mGamma) > DELTA_DEGRESS);
            {
                mManager.onOrientationChange(mAlpha, mBeta, mGamma);
                mHaveSentErrorEvent = false;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //if (mAlpha == null || mBeta == null || mGamma == null
                //|| Math.abs(alpha - mAlpha) > DELTA_DEGRESS
                //|| Math.abs(beta - mBeta) > DELTA_DEGRESS
                //|| Math.abs(gamma - mGamma) > DELTA_DEGRESS) {
            //mAlpha = alpha;
            //mBeta = beta;
            //mGamma = gamma;
            //mManager.onOrientationChange(mAlpha, mBeta, mGamma);
            //mHaveSentErrorEvent = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.171 -0400", hash_original_method = "2695E209DFB6DD433B7C6CE1A619CE79", hash_generated_method = "E78D916BFBFAE2907F5B3C539ED8D9C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onSensorChanged(SensorEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            Object var8AEBA24F22EBF3D3976665EB31D66317_641290784 = (event.sensor.getType());
            //Begin case Sensor.TYPE_ACCELEROMETER 
            {
                mGravityVector = new float[3];
            } //End block
            //End case Sensor.TYPE_ACCELEROMETER 
            //Begin case Sensor.TYPE_ACCELEROMETER 
            mGravityVector[0] = event.values[0];
            //End case Sensor.TYPE_ACCELEROMETER 
            //Begin case Sensor.TYPE_ACCELEROMETER 
            mGravityVector[1] = event.values[1];
            //End case Sensor.TYPE_ACCELEROMETER 
            //Begin case Sensor.TYPE_ACCELEROMETER 
            mGravityVector[2] = event.values[2];
            //End case Sensor.TYPE_ACCELEROMETER 
            //Begin case Sensor.TYPE_ACCELEROMETER 
            getOrientationUsingGetRotationMatrix();
            //End case Sensor.TYPE_ACCELEROMETER 
            //Begin case Sensor.TYPE_MAGNETIC_FIELD 
            {
                mMagneticFieldVector = new float[3];
            } //End block
            //End case Sensor.TYPE_MAGNETIC_FIELD 
            //Begin case Sensor.TYPE_MAGNETIC_FIELD 
            mMagneticFieldVector[0] = event.values[0];
            //End case Sensor.TYPE_MAGNETIC_FIELD 
            //Begin case Sensor.TYPE_MAGNETIC_FIELD 
            mMagneticFieldVector[1] = event.values[1];
            //End case Sensor.TYPE_MAGNETIC_FIELD 
            //Begin case Sensor.TYPE_MAGNETIC_FIELD 
            mMagneticFieldVector[2] = event.values[2];
            //End case Sensor.TYPE_MAGNETIC_FIELD 
            //Begin case Sensor.TYPE_MAGNETIC_FIELD 
            getOrientationUsingGetRotationMatrix();
            //End case Sensor.TYPE_MAGNETIC_FIELD 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.172 -0400", hash_original_method = "4C77A6863BACF480F39B2826F5CA663C", hash_generated_method = "81A8C3534F22D079E33B44B7968F9E76")
    @DSModeled(DSC.SAFE)
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(sensor.dsTaint);
        dsTaint.addTaint(accuracy);
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
    }

    
    private static final double DELTA_DEGRESS = 1.0;
}

