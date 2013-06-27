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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.225 -0400", hash_original_field = "3ED8275DCE79E42B3B02ABEA2442432B", hash_generated_field = "9C5FFC7AB264A9E2409475E7791D4532")

    private float[] mGravityVector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.225 -0400", hash_original_field = "7AE8C37126C35170590102A57FD32B35", hash_generated_field = "0130128FE056DC76160B4827D4BE644E")

    private float[] mMagneticFieldVector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.225 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "66D108DFC043A6E0A2844E4843186070")

    private DeviceMotionAndOrientationManager mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.225 -0400", hash_original_field = "130D713CAF236B328B5223DFA18F1488", hash_generated_field = "B2DDC5809B05187D32A84097DC68019C")

    private boolean mIsRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.225 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.226 -0400", hash_original_field = "8CDFC97B128FB94D2A2F11FDAFFE50EA", hash_generated_field = "D8CC5B9F3DF5D78484C533BB7CDDA85C")

    private SensorManager mSensorManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.226 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.235 -0400", hash_original_field = "7574041472B9B2E76867A37482E74343", hash_generated_field = "0A23F4655A3DFB9C9E452D889EBE9404")

    private Double mAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.235 -0400", hash_original_field = "6A50E75BFB2FD3E51E931E0FB19516A2", hash_generated_field = "64234C701661B0D83F7238BD4569B56F")

    private Double mBeta;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.235 -0400", hash_original_field = "D0E25905791C4A3739FADA1C0E52A041", hash_generated_field = "9EEB92A35AEC39199205F7CE49B953F3")

    private Double mGamma;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.235 -0400", hash_original_field = "2C3606D875A88A4154C18923EE3485CF", hash_generated_field = "16AAE3611879142DAF4D4972E6DBF92E")

    private boolean mHaveSentErrorEvent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.236 -0400", hash_original_method = "4D8FCE308D7FC749FF19FBAE89D7CA70", hash_generated_method = "87D6AFD046F32ED648775F26C5959B17")
    public  DeviceOrientationService(DeviceMotionAndOrientationManager manager, Context context) {
        mManager = manager;
        mContext = context;
        // ---------- Original Method ----------
        //mManager = manager;
        //assert(mManager != null);
        //mContext = context;
        //assert(mContext != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.237 -0400", hash_original_method = "4CC8267164C7FA2FF7A54409829F5B3F", hash_generated_method = "1271AEFE8C3FFFE0936AD75B93E923E4")
    public void start() {
        mIsRunning = true;
        registerForSensors();
        // ---------- Original Method ----------
        //mIsRunning = true;
        //registerForSensors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.237 -0400", hash_original_method = "E95AF6342D982D1129097C11892774DC", hash_generated_method = "574593EF3A6A5CC6922E3DFC8DCA805B")
    public void stop() {
        mIsRunning = false;
        unregisterFromSensors();
        // ---------- Original Method ----------
        //mIsRunning = false;
        //unregisterFromSensors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.237 -0400", hash_original_method = "D444E72BAE4BC67A93A8D811E5903DC0", hash_generated_method = "533B20682832B01765AE0229F204D016")
    public void suspend() {
        {
            unregisterFromSensors();
        } //End block
        // ---------- Original Method ----------
        //if (mIsRunning) {
            //unregisterFromSensors();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.243 -0400", hash_original_method = "13F627D50D1CD4F6B5F8D936ACD57861", hash_generated_method = "BA8DD886820E8980C98F486376D907FD")
    public void resume() {
        {
            registerForSensors();
        } //End block
        // ---------- Original Method ----------
        //if (mIsRunning) {
            //registerForSensors();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.245 -0400", hash_original_method = "C4E19FEB85A20B838CCD6120912B24F7", hash_generated_method = "7763B3DB4469D36A97FAC3AE955286DF")
    private void sendErrorEvent() {
        mHaveSentErrorEvent = true;
        mHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.245 -0400", hash_original_method = "1621C64DF7C2F75E1B41A795930D55FE", hash_generated_method = "F5328AA94959BD83345E20C737866B21")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.245 -0400", hash_original_method = "A01419D47FD253423887BAF542AEFD8C", hash_generated_method = "12D27B5E8F5AC7FD9BB5E3117A942C73")
    private void registerForSensors() {
        {
            mHandler = new Handler();
        } //End block
        {
            boolean varD10B56D8CDB3C9ACD05B4907C7995E4D_801387646 = (!registerForAccelerometerSensor() || !registerForMagneticFieldSensor());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.255 -0400", hash_original_method = "A3B30EF17FDC8C38C5B1B85F341CAEE6", hash_generated_method = "BA62A2F84430FA04FE056DEFFEE7F81E")
    private void getOrientationUsingGetRotationMatrix() {
        float[] deviceRotationMatrix;
        deviceRotationMatrix = new float[9];
        {
            boolean var04E5920A53519DAB5BCCE922FB99C72B_1151897455 = (!SensorManager.getRotationMatrix(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.256 -0400", hash_original_method = "D09B23AC902B5D9C0E49BB52A156F918", hash_generated_method = "1C5DAE2C0EBD916E6ECBF7DA162964D6")
    private SensorManager getSensorManager() {
        SensorManager varB4EAC82CA7396A68D541C85D26508E83_328859058 = null; //Variable for return #1
        {
            mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_328859058 = mSensorManager;
        varB4EAC82CA7396A68D541C85D26508E83_328859058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_328859058;
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //if (mSensorManager == null) {
            //mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        //}
        //return mSensorManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.256 -0400", hash_original_method = "B3284C523F8E8DEDA1572FA7CE19585B", hash_generated_method = "851E6DB9E2DAF3FC65D4C3FB1CFDCB4F")
    private boolean registerForAccelerometerSensor() {
        List<Sensor> sensors;
        sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        {
            boolean var60EE0D8C32CDAFA59C16DF69FA87513D_397919118 = (sensors.isEmpty());
        } //End collapsed parenthetic
        boolean var6CCE466F5EF5C5884CB21519A351854C_537537258 = (getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534850854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_534850854;
        // ---------- Original Method ----------
        //List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        //if (sensors.isEmpty()) {
            //return false;
        //}
        //return getSensorManager().registerListener(
                //this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.257 -0400", hash_original_method = "DFE78C89ABF5437F78B53A9E5486BEA8", hash_generated_method = "CC87A63A116272B180707778C3B6284F")
    private boolean registerForMagneticFieldSensor() {
        List<Sensor> sensors;
        sensors = getSensorManager().getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        {
            boolean var60EE0D8C32CDAFA59C16DF69FA87513D_1496059454 = (sensors.isEmpty());
        } //End collapsed parenthetic
        boolean var6CCE466F5EF5C5884CB21519A351854C_460776527 = (getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680751046 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680751046;
        // ---------- Original Method ----------
        //List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        //if (sensors.isEmpty()) {
            //return false;
        //}
        //return getSensorManager().registerListener(
                //this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.359 -0400", hash_original_method = "3017DC11BC04FDEC5E6982352A18F2D7", hash_generated_method = "D951C525941C25B5CE19BA545AA9B4D8")
    private void unregisterFromSensors() {
        getSensorManager().unregisterListener(this);
        // ---------- Original Method ----------
        //getSensorManager().unregisterListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.360 -0400", hash_original_method = "B4ADD48907D203A526782697C56D84A1", hash_generated_method = "7AE66C6E0A50B76E77537E6CFAA8E5EB")
    private void maybeSendChange(double alpha, double beta, double gamma) {
        {
            boolean var4D37320EFAE908439958107B39475443_940616042 = (mAlpha == null || mBeta == null || mGamma == null
                || Math.abs(alpha - mAlpha) > DELTA_DEGRESS
                || Math.abs(beta - mBeta) > DELTA_DEGRESS
                || Math.abs(gamma - mGamma) > DELTA_DEGRESS);
            {
                mAlpha = alpha;
                mBeta = beta;
                mGamma = gamma;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.361 -0400", hash_original_method = "2695E209DFB6DD433B7C6CE1A619CE79", hash_generated_method = "CA489CDD2829510B4EF0D099292BE659")
    public void onSensorChanged(SensorEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Object var8AEBA24F22EBF3D3976665EB31D66317_428883620 = (event.sensor.getType());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.362 -0400", hash_original_method = "4C77A6863BACF480F39B2826F5CA663C", hash_generated_method = "1A434A1FCBBAC533510C9D8C55877D2F")
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(sensor.getTaint());
        addTaint(accuracy);
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.362 -0400", hash_original_field = "7FDCB9E51A150844B0E9DB43E2297EE0", hash_generated_field = "A3CC1989C6FA0A79F4808898BEF3365B")

    private static double DELTA_DEGRESS = 1.0;
}

