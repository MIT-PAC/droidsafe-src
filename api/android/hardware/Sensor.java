package android.hardware;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Sensor {
    public static final int TYPE_ACCELEROMETER = 1;
    public static final int TYPE_MAGNETIC_FIELD = 2;
    public static final int TYPE_GYROSCOPE = 4;
    public static final int TYPE_LIGHT = 5;
    public static final int TYPE_PRESSURE = 6;
    public static final int TYPE_PROXIMITY = 8;
    public static final int TYPE_GRAVITY = 9;
    public static final int TYPE_LINEAR_ACCELERATION = 10;
    public static final int TYPE_ROTATION_VECTOR = 11;
    public static final int TYPE_RELATIVE_HUMIDITY = 12;
    public static final int TYPE_AMBIENT_TEMPERATURE = 13;
    public static final int TYPE_ALL = -1;
    
    @Deprecated
    public static final int TYPE_TEMPERATURE = 7;
    @Deprecated
    public static final int TYPE_ORIENTATION = 3;

    private String  mName;
    private String  mVendor;
    private int     mVersion;
    private int     mHandle;
    private int     mType;
    private float   mMaxRange;
    private float   mResolution;
    private float   mPower;
    private int     mMinDelay;
    private int     mLegacyType;
    
    // GITI DSModeled - not original to Sensor.java, added to track the type of sensor
    // requested by the application (via SensorManager.java)
    @DSModeled(DSC.BAN)
    public Sensor(int type) {
    	dsTaint.addTaint(type);
    }

    // GITI DSModeled
    @DSModeled(DSC.SAFE)
    Sensor() {
    }

    // GITI DSModeled - just returning a string
    @DSModeled(DSC.SAFE)
    public String getName() {
    	return dsTaint.getTaintString();
        //return mName;
    }

    // GITI DSModeled - just returning a string 
    @DSModeled(DSC.SAFE)
    public String getVendor() {
    	return dsTaint.getTaintString();
        //return mVendor;
    }

    // GITI DSModeled - just returning an int
    @DSModeled(DSC.SAFE)
    public int getType() {
    	return dsTaint.getTaintInt();
        //return mType;
    }

    // GITI DSModeled - just returning an int
    @DSModeled(DSC.SAFE)
    public int getVersion() {
    	return dsTaint.getTaintInt();
        //return mVersion;
    }

    // GITI DSModeled - just returning a float
    @DSModeled(DSC.SAFE)
    public float getMaximumRange() {
    	return dsTaint.getTaintFloat();
        //return mMaxRange;
    }

    // GITI DSModeled - just returning a float
    @DSModeled(DSC.SAFE)
    public float getResolution() {
    	return dsTaint.getTaintInt();
        //return mResolution;
    }

    // GITI DSModeled - just returning a float
    @DSModeled(DSC.SAFE)
    public float getPower() {
    	return dsTaint.getTaintFloat();
        //return mPower;
    }

    // GITI DSModeled - just returning an int
    @DSModeled(DSC.SAFE)
    public int getMinDelay() {
    	return dsTaint.getTaintInt();
        //return mMinDelay;
    }

    int getHandle() {
    	return dsTaint.getTaintInt();
        //return mHandle;
    }

    void setRange(float max, float res) {
    	dsTaint.addTaint(max);
    	dsTaint.addTaint(res);
    }

    void setLegacyType(int legacyType) {
    	dsTaint.addTaint(legacyType);
    }

    int getLegacyType() {
    	return dsTaint.getTaintInt();
        //return mLegacyType;
    }
}
