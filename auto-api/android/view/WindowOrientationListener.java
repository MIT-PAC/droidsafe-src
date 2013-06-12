package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.util.Slog;

public abstract class WindowOrientationListener {
    private static final String TAG = "WindowOrientationListener";
    private static final boolean DEBUG = false;
    private static final boolean localLOGV = DEBUG || false;
    private SensorManager mSensorManager;
    private boolean mEnabled;
    private int mRate;
    private Sensor mSensor;
    private SensorEventListenerImpl mSensorEventListener;
    boolean mLogEnabled;
    int mCurrentRotation = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.917 -0400", hash_original_method = "A82A711A75082F1132E0302F45D19386", hash_generated_method = "FECF3E77989AB66F31BFF4582EA7D51A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WindowOrientationListener(Context context) {
        this(context, SensorManager.SENSOR_DELAY_UI);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.918 -0400", hash_original_method = "FA32512194D1044CA10829E498D54F58", hash_generated_method = "D30047C488CB89AF492382DF284A7BFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private WindowOrientationListener(Context context, int rate) {
        dsTaint.addTaint(rate);
        dsTaint.addTaint(context.dsTaint);
        mSensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        {
            mSensorEventListener = new SensorEventListenerImpl(this);
        } //End block
        // ---------- Original Method ----------
        //mSensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        //mRate = rate;
        //mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //if (mSensor != null) {
            //mSensorEventListener = new SensorEventListenerImpl(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.918 -0400", hash_original_method = "29A758F5A1A01F349D632A06364B75CB", hash_generated_method = "590690B157D666BF93BF002FB26E28EF")
    @DSModeled(DSC.SAFE)
    public void enable() {
        {
            Log.d(TAG, "WindowOrientationListener enabled");
            mSensorManager.registerListener(mSensorEventListener, mSensor, mRate);
            mEnabled = true;
        } //End block
        // ---------- Original Method ----------
        //if (mSensor == null) {
            //Log.w(TAG, "Cannot detect sensors. Not enabled");
            //return;
        //}
        //if (mEnabled == false) {
            //if (localLOGV) Log.d(TAG, "WindowOrientationListener enabled");
            //mSensorManager.registerListener(mSensorEventListener, mSensor, mRate);
            //mEnabled = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.918 -0400", hash_original_method = "0F2BE7915022F1B9CA61A48D1BA329F2", hash_generated_method = "F8E5407F9AEC30A73CCE10F9B57956D6")
    @DSModeled(DSC.SAFE)
    public void disable() {
        {
            Log.d(TAG, "WindowOrientationListener disabled");
            mSensorManager.unregisterListener(mSensorEventListener);
            mEnabled = false;
        } //End block
        // ---------- Original Method ----------
        //if (mSensor == null) {
            //Log.w(TAG, "Cannot detect sensors. Invalid disable");
            //return;
        //}
        //if (mEnabled == true) {
            //if (localLOGV) Log.d(TAG, "WindowOrientationListener disabled");
            //mSensorManager.unregisterListener(mSensorEventListener);
            //mEnabled = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.918 -0400", hash_original_method = "64D97DEFBD47C980E3FA8DA999EC4EB6", hash_generated_method = "21A48EE688A723C05862E415AD687F05")
    @DSModeled(DSC.SAFE)
    public void setCurrentRotation(int rotation) {
        dsTaint.addTaint(rotation);
        // ---------- Original Method ----------
        //mCurrentRotation = rotation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.918 -0400", hash_original_method = "DC58F8A887830BD07E8A1DBF7E69B5D6", hash_generated_method = "CC8B7C3E92B4ED155C2D0942EF1335CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getProposedRotation() {
        {
            int var8CD4FB7A31BA9F93A577E914E576E28E_2037482619 = (mSensorEventListener.getProposedRotation());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mEnabled) {
            //return mSensorEventListener.getProposedRotation();
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.918 -0400", hash_original_method = "1094A3B76B1DFEFFD525547DCAE398E5", hash_generated_method = "A0E7CEF536C52D4541DE19EE693A5D05")
    @DSModeled(DSC.SAFE)
    public boolean canDetectOrientation() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSensor != null;
    }

    
    public abstract void onProposedRotationChanged(int rotation);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.918 -0400", hash_original_method = "1D30F0C11E35442BA40BC09385F2CF44", hash_generated_method = "835F17C6369284B7724FDAA890CA6BAB")
    @DSModeled(DSC.SAFE)
    public void setLogEnabled(boolean enable) {
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
        //mLogEnabled = enable;
    }

    
    static final class SensorEventListenerImpl implements SensorEventListener {
        private static final float RADIANS_TO_DEGREES = (float) (180 / Math.PI);
        private static final int ACCELEROMETER_DATA_X = 0;
        private static final int ACCELEROMETER_DATA_Y = 1;
        private static final int ACCELEROMETER_DATA_Z = 2;
        private final WindowOrientationListener mOrientationListener;
        private long mLastTimestamp = Long.MAX_VALUE;
        private float mLastFilteredX, mLastFilteredY, mLastFilteredZ;
        private long mProposalTime;
        private int mProposalRotation;
        private long mProposalAgeMS;
        private boolean mProposalSettled;
        private static final int HISTORY_SIZE = 20;
        private int mHistoryIndex;
        private int mHistoryLength;
        private final long[] mHistoryTimestampMS = new long[HISTORY_SIZE];
        private final float[] mHistoryMagnitudes = new float[HISTORY_SIZE];
        private final int[] mHistoryTiltAngles = new int[HISTORY_SIZE];
        private final int[] mHistoryOrientationAngles = new int[HISTORY_SIZE];
        private static final float MAX_FILTER_DELTA_TIME_MS = 1000;
        private static final float FILTER_TIME_CONSTANT_MS = 100.0f;
        private static final float MIN_ACCELERATION_MAGNITUDE =
                SensorManager.STANDARD_GRAVITY * 0.5f;
        private static final float MAX_ACCELERATION_MAGNITUDE =
            SensorManager.STANDARD_GRAVITY * 1.5f;
        private static final int MAX_TILT = 75;
        private static final int[][] TILT_TOLERANCE = new int[][] {
             { -25, 70 },
             { -25, 65 },
             { -25, 60 },
             { -25, 65 }
        };
        private static final int ADJACENT_ORIENTATION_ANGLE_GAP = 45;
        private static final int SETTLE_TIME_MIN_MS = 200;
        private static final int SETTLE_TIME_MAX_MS = 500;
        private static final float SETTLE_MAGNITUDE_MAX_DELTA =
                SensorManager.STANDARD_GRAVITY * 0.2f;
        private static final int SETTLE_TILT_ANGLE_MAX_DELTA = 8;
        private static final int SETTLE_ORIENTATION_ANGLE_MAX_DELTA = 8;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.918 -0400", hash_original_method = "56217EE38FC6311D8ABD1C486190CA3A", hash_generated_method = "88C47C2741743656B6ED9F60CCA0D8D0")
        @DSModeled(DSC.SAFE)
        public SensorEventListenerImpl(WindowOrientationListener orientationListener) {
            dsTaint.addTaint(orientationListener.dsTaint);
            // ---------- Original Method ----------
            //mOrientationListener = orientationListener;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.918 -0400", hash_original_method = "72C9B9BFF818E24303EA0999DCCA55C4", hash_generated_method = "C59415DDD2C810C9165C81DD78944297")
        @DSModeled(DSC.SAFE)
        public int getProposedRotation() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mProposalSettled ? mProposalRotation : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.918 -0400", hash_original_method = "203A2951410283BC62BAF2E5CECD84FA", hash_generated_method = "E04AD026BC78053DB33E790A7E4B06C0")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(sensor.dsTaint);
            dsTaint.addTaint(accuracy);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.919 -0400", hash_original_method = "E5159BC033CD8738F5BC8612E1AB5FC0", hash_generated_method = "7A406A13A5DEA093F1969D8675108F00")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onSensorChanged(SensorEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(event.dsTaint);
            final boolean log;
            log = mOrientationListener.mLogEnabled;
            float x;
            x = event.values[ACCELEROMETER_DATA_X];
            float y;
            y = event.values[ACCELEROMETER_DATA_Y];
            float z;
            z = event.values[ACCELEROMETER_DATA_Z];
            final long now;
            now = event.timestamp;
            final float timeDeltaMS;
            timeDeltaMS = (now - mLastTimestamp) * 0.000001f;
            boolean skipSample;
            {
                clearProposal();
                skipSample = true;
            } //End block
            {
                final float alpha;
                alpha = timeDeltaMS / (FILTER_TIME_CONSTANT_MS + timeDeltaMS);
                x = alpha * (x - mLastFilteredX) + mLastFilteredX;
                y = alpha * (y - mLastFilteredY) + mLastFilteredY;
                z = alpha * (z - mLastFilteredZ) + mLastFilteredZ;
                skipSample = false;
            } //End block
            mLastTimestamp = now;
            mLastFilteredX = x;
            mLastFilteredY = y;
            mLastFilteredZ = z;
            final int oldProposedRotation;
            oldProposedRotation = getProposedRotation();
            {
                final float magnitude;
                magnitude = (float) Math.sqrt(x * x + y * y + z * z);
                {
                    clearProposal();
                } //End block
                {
                    final int tiltAngle;
                    tiltAngle = (int) Math.round(
                            Math.asin(z / magnitude) * RADIANS_TO_DEGREES);
                    {
                        boolean var637F7BBFF928DFD2AF3E6D86E1838ACB_241819438 = (Math.abs(tiltAngle) > MAX_TILT);
                        {
                            clearProposal();
                        } //End block
                        {
                            int orientationAngle;
                            orientationAngle = (int) Math.round(
                                -Math.atan2(-x, y) * RADIANS_TO_DEGREES);
                            {
                                orientationAngle += 360;
                            } //End block
                            int nearestRotation;
                            nearestRotation = (orientationAngle + 45) / 90;
                            {
                                nearestRotation = 0;
                            } //End block
                            {
                                boolean var81ACB782CAEF4CE154EFDB2C4DA1D765_772980526 = (!isTiltAngleAcceptable(nearestRotation, tiltAngle)
                                || !isOrientationAngleAcceptable(nearestRotation,
                                        orientationAngle));
                                {
                                    clearProposal();
                                } //End block
                                {
                                    updateProposal(nearestRotation, now / 1000000L,
                                    magnitude, tiltAngle, orientationAngle);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            final int proposedRotation;
            proposedRotation = getProposedRotation();
            {
                final float proposalConfidence;
                proposalConfidence = Math.min(
                        mProposalAgeMS * 1.0f / SETTLE_TIME_MIN_MS, 1.0f);
            } //End block
            {
                mOrientationListener.onProposedRotationChanged(proposedRotation);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.919 -0400", hash_original_method = "7D2375C59A0A7C805389CA08D500882E", hash_generated_method = "508CD02632D749D0A65F69D44F4E81C5")
        @DSModeled(DSC.SAFE)
        private boolean isTiltAngleAcceptable(int proposedRotation,
                int tiltAngle) {
            dsTaint.addTaint(proposedRotation);
            dsTaint.addTaint(tiltAngle);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return tiltAngle >= TILT_TOLERANCE[proposedRotation][0]
                    //&& tiltAngle <= TILT_TOLERANCE[proposedRotation][1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.920 -0400", hash_original_method = "BA9208B8B5B6F372B19974951045C955", hash_generated_method = "2EAC4F3AE77C6E007D247A2536272990")
        @DSModeled(DSC.SAFE)
        private boolean isOrientationAngleAcceptable(int proposedRotation, int orientationAngle) {
            dsTaint.addTaint(proposedRotation);
            dsTaint.addTaint(orientationAngle);
            final int currentRotation;
            currentRotation = mOrientationListener.mCurrentRotation;
            {
                {
                    int lowerBound;
                    lowerBound = proposedRotation * 90 - 45
                            + ADJACENT_ORIENTATION_ANGLE_GAP / 2;
                } //End block
                {
                    int upperBound;
                    upperBound = proposedRotation * 90 + 45
                            - ADJACENT_ORIENTATION_ANGLE_GAP / 2;
                } //End block
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.920 -0400", hash_original_method = "A7F2CAA250EB7C6AFF2CEA76C42F643C", hash_generated_method = "B177951B638CFC6DEEB0A1945F492C37")
        @DSModeled(DSC.SAFE)
        private void clearProposal() {
            mProposalRotation = -1;
            mProposalAgeMS = 0;
            mProposalSettled = false;
            // ---------- Original Method ----------
            //mProposalRotation = -1;
            //mProposalAgeMS = 0;
            //mProposalSettled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.920 -0400", hash_original_method = "731DE9EAFB32BFA5DDBBD2380A2EA791", hash_generated_method = "067DCA4E1B00AE55AA96746CDB4E6499")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void updateProposal(int rotation, long timestampMS,
                float magnitude, int tiltAngle, int orientationAngle) {
            dsTaint.addTaint(timestampMS);
            dsTaint.addTaint(rotation);
            dsTaint.addTaint(magnitude);
            dsTaint.addTaint(tiltAngle);
            dsTaint.addTaint(orientationAngle);
            {
                mHistoryIndex = 0;
                mHistoryLength = 0;
            } //End block
            final int index;
            index = mHistoryIndex;
            mHistoryTimestampMS[index] = timestampMS;
            mHistoryMagnitudes[index] = magnitude;
            mHistoryTiltAngles[index] = tiltAngle;
            mHistoryOrientationAngles[index] = orientationAngle;
            mHistoryIndex = (index + 1) % HISTORY_SIZE;
            {
                mHistoryLength += 1;
            } //End block
            long age;
            age = 0;
            {
                int i;
                i = 1;
                {
                    final int olderIndex;
                    olderIndex = (index + HISTORY_SIZE - i) % HISTORY_SIZE;
                    {
                        boolean var7E169582AAF15BA243D9B748E171EA72_1166307902 = (Math.abs(mHistoryMagnitudes[olderIndex] - magnitude)
                        > SETTLE_MAGNITUDE_MAX_DELTA);
                    } //End collapsed parenthetic
                    {
                        boolean var4D7E561EDEECF3B0D6DDFEE792787535_558698344 = (angleAbsoluteDelta(mHistoryTiltAngles[olderIndex],
                        tiltAngle) > SETTLE_TILT_ANGLE_MAX_DELTA);
                    } //End collapsed parenthetic
                    {
                        boolean varDCD0F7591138DA63A42A4CEB52E35611_565329569 = (angleAbsoluteDelta(mHistoryOrientationAngles[olderIndex],
                        orientationAngle) > SETTLE_ORIENTATION_ANGLE_MAX_DELTA);
                    } //End collapsed parenthetic
                    age = timestampMS - mHistoryTimestampMS[olderIndex];
                } //End block
            } //End collapsed parenthetic
            mProposalAgeMS = age;
            {
                mProposalSettled = true;
            } //End block
            {
                mProposalSettled = false;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.920 -0400", hash_original_method = "833FF2FC34C811BB740FA4B473BB474A", hash_generated_method = "1D639D34612F6C4E772F5CC1EA843B4E")
        private static int angleAbsoluteDelta(int a, int b) {
            int delta = Math.abs(a - b);
            if (delta > 180) {
                delta = 360 - delta;
            }
            return delta;
        }

        
    }


    
}


