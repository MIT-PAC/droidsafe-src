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

final class DeviceOrientationService implements SensorEventListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.637 -0500", hash_original_field = "30DB8291403D11AAB709408A31447F79", hash_generated_field = "4E3D251C42A5CB0D1F6817ECA2EF0DA8")

    private static final double DELTA_DEGRESS = 1.0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.613 -0500", hash_original_field = "3710C3B52AF0B64B41D5AA0DD08D7E67", hash_generated_field = "9C5FFC7AB264A9E2409475E7791D4532")

    private float[] mGravityVector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.615 -0500", hash_original_field = "448CC27F4F6647E6D0241BB357871CA2", hash_generated_field = "0130128FE056DC76160B4827D4BE644E")

    private float[] mMagneticFieldVector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.617 -0500", hash_original_field = "ADF7031C73AC58838DF2C97D4D015C9D", hash_generated_field = "66D108DFC043A6E0A2844E4843186070")

    private DeviceMotionAndOrientationManager mManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.620 -0500", hash_original_field = "F57A6C5BD72C70EB93523745929F338F", hash_generated_field = "B2DDC5809B05187D32A84097DC68019C")

    private boolean mIsRunning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.622 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.624 -0500", hash_original_field = "91B605B3904EBFC2D1278ACCB01BB947", hash_generated_field = "D8CC5B9F3DF5D78484C533BB7CDDA85C")

    private SensorManager mSensorManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.626 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.628 -0500", hash_original_field = "74762BD3B102389962831584944D8ED0", hash_generated_field = "0A23F4655A3DFB9C9E452D889EBE9404")

    private Double mAlpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.630 -0500", hash_original_field = "3B5BE767EB704CCE2DBDDB6F42841D80", hash_generated_field = "64234C701661B0D83F7238BD4569B56F")

    private Double mBeta;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.632 -0500", hash_original_field = "5B245232059005441BB9780AA666C500", hash_generated_field = "9EEB92A35AEC39199205F7CE49B953F3")

    private Double mGamma;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.634 -0500", hash_original_field = "14A7A26477CD3B2D020623361CD6DC43", hash_generated_field = "16AAE3611879142DAF4D4972E6DBF92E")

    private boolean mHaveSentErrorEvent;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.639 -0500", hash_original_method = "4D8FCE308D7FC749FF19FBAE89D7CA70", hash_generated_method = "0C232130D9235FCA828DD614F27B2AE0")
    
public DeviceOrientationService(DeviceMotionAndOrientationManager manager, Context context) {
        mManager = manager;
        assert(mManager != null);
        mContext = context;
        assert(mContext != null);
     }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.641 -0500", hash_original_method = "4CC8267164C7FA2FF7A54409829F5B3F", hash_generated_method = "83CF35FC52DD44194CAF263FA55D49FA")
    
public void start() {
        mIsRunning = true;
        registerForSensors();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.643 -0500", hash_original_method = "E95AF6342D982D1129097C11892774DC", hash_generated_method = "F1DCF66D832850114E7E22363630A65F")
    
public void stop() {
        mIsRunning = false;
        unregisterFromSensors();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.646 -0500", hash_original_method = "D444E72BAE4BC67A93A8D811E5903DC0", hash_generated_method = "4BA6CF5A9F8931EF2171ED30DC94DB47")
    
public void suspend() {
        if (mIsRunning) {
            unregisterFromSensors();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.648 -0500", hash_original_method = "13F627D50D1CD4F6B5F8D936ACD57861", hash_generated_method = "87E3ED0D50DD0DEF02E34A78B18FB77A")
    
public void resume() {
        if (mIsRunning) {
            registerForSensors();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.653 -0500", hash_original_method = "C4E19FEB85A20B838CCD6120912B24F7", hash_generated_method = "95ABA55925D955ACFDEC810BAB37F09C")
    
private void sendErrorEvent() {
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        // The spec requires that each listener receives the error event only once.
        if (mHaveSentErrorEvent)
            return;
        mHaveSentErrorEvent = true;
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
                if (mIsRunning) {
                    // The special case of all nulls is used to signify a failure to get data.
                    mManager.onOrientationChange(null, null, null);
                }
            }
        });
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.656 -0500", hash_original_method = "A01419D47FD253423887BAF542AEFD8C", hash_generated_method = "4355C08A56FDAFBB5A86EAAA5B9C1F88")
    
private void registerForSensors() {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        if (!registerForAccelerometerSensor() || !registerForMagneticFieldSensor()) {
            unregisterFromSensors();
            sendErrorEvent();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.658 -0500", hash_original_method = "A3B30EF17FDC8C38C5B1B85F341CAEE6", hash_generated_method = "200B33FB012130D2EAADF8509F9BD3C4")
    
private void getOrientationUsingGetRotationMatrix() {
        if (mGravityVector == null || mMagneticFieldVector == null) {
            return;
        }

        // Get the rotation matrix.
        // The rotation matrix that transforms from the body frame to the earth frame.
        float[] deviceRotationMatrix = new float[9];
        if (!SensorManager.getRotationMatrix(
                deviceRotationMatrix, null, mGravityVector, mMagneticFieldVector)) {
            return;
        }

        // Convert rotation matrix to rotation angles.
        // Assuming that the rotations are appied in the order listed at
        // http://developer.android.com/reference/android/hardware/SensorEvent.html#values
        // the rotations are applied about the same axes and in the same order as required by the
        // API. The only conversions are sign changes as follows.
        // The angles are in radians
        float[] rotationAngles = new float[3];
        SensorManager.getOrientation(deviceRotationMatrix, rotationAngles);
        double alpha = Math.toDegrees(-rotationAngles[0]) - 90.0;
        while (alpha < 0.0) { alpha += 360.0; } // [0, 360)
        double beta = Math.toDegrees(-rotationAngles[1]);
        while (beta < -180.0) { beta += 360.0; } // [-180, 180)
        double gamma = Math.toDegrees(rotationAngles[2]);
        while (gamma < -90.0) { gamma += 360.0; } // [-90, 90)

        maybeSendChange(alpha, beta, gamma);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.661 -0500", hash_original_method = "D09B23AC902B5D9C0E49BB52A156F918", hash_generated_method = "FEB2F552C044EE42CFEE371617B0383D")
    
private SensorManager getSensorManager() {
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        if (mSensorManager == null) {
            mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        }
        return mSensorManager;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.663 -0500", hash_original_method = "B3284C523F8E8DEDA1572FA7CE19585B", hash_generated_method = "7380B0290872694DF42C283F87CB83B0")
    
private boolean registerForAccelerometerSensor() {
        List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.isEmpty()) {
            return false;
        }
        // TODO: Consider handling multiple sensors.
        return getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.666 -0500", hash_original_method = "DFE78C89ABF5437F78B53A9E5486BEA8", hash_generated_method = "3035649FC5F676D4337711BD20C3FAAF")
    
private boolean registerForMagneticFieldSensor() {
        List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        if (sensors.isEmpty()) {
            return false;
        }
        // TODO: Consider handling multiple sensors.
        return getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.668 -0500", hash_original_method = "3017DC11BC04FDEC5E6982352A18F2D7", hash_generated_method = "DAB42F16B53F4D46DCD344E32346FDDB")
    
private void unregisterFromSensors() {
        getSensorManager().unregisterListener(this);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.670 -0500", hash_original_method = "B4ADD48907D203A526782697C56D84A1", hash_generated_method = "3D1A6280CBD3A8C7B2C77B7CAD4EC4AE")
    
private void maybeSendChange(double alpha, double beta, double gamma) {
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        if (mAlpha == null || mBeta == null || mGamma == null
                || Math.abs(alpha - mAlpha) > DELTA_DEGRESS
                || Math.abs(beta - mBeta) > DELTA_DEGRESS
                || Math.abs(gamma - mGamma) > DELTA_DEGRESS) {
            mAlpha = alpha;
            mBeta = beta;
            mGamma = gamma;
            mManager.onOrientationChange(mAlpha, mBeta, mGamma);
            // Now that we have successfully sent some data, reset whether we've sent an error.
            mHaveSentErrorEvent = false;
        }
    }

    /**
     * SensorEventListener implementation.
     * Callbacks happen on the thread on which we registered - the WebCore thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.673 -0500", hash_original_method = "2695E209DFB6DD433B7C6CE1A619CE79", hash_generated_method = "F216DEEC3BE2568BC69A2E14A939134F")
    
public void onSensorChanged(SensorEvent event) {
        assert(event.values.length == 3);
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());

        // We may get callbacks after the call to getSensorManager().unregisterListener() returns.
        if (!mIsRunning) {
            return;
        }

        switch (event.sensor.getType()) {
          case Sensor.TYPE_ACCELEROMETER:
            if (mGravityVector == null) {
                mGravityVector = new float[3];
            }
            mGravityVector[0] = event.values[0];
            mGravityVector[1] = event.values[1];
            mGravityVector[2] = event.values[2];
            getOrientationUsingGetRotationMatrix();
            break;
          case Sensor.TYPE_MAGNETIC_FIELD:
            if (mMagneticFieldVector == null) {
                mMagneticFieldVector = new float[3];
            }
            mMagneticFieldVector[0] = event.values[0];
            mMagneticFieldVector[1] = event.values[1];
            mMagneticFieldVector[2] = event.values[2];
            getOrientationUsingGetRotationMatrix();
            break;
          default:
            assert(false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.675 -0500", hash_original_method = "4C77A6863BACF480F39B2826F5CA663C", hash_generated_method = "64E39387A039533466C0623BF8FBA522")
    
public void onAccuracyChanged(Sensor sensor, int accuracy) {
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
    }
}

