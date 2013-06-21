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
    	addTaint(type.getTaint());
    }

    // GITI DSModeled
    @DSModeled(DSC.SAFE)
    Sensor() {
    }

    // GITI DSModeled - just returning a string
    @DSModeled(DSC.SAFE)
    public String getName() {
    	return getTaintString();
        //return mName;
    }

    // GITI DSModeled - just returning a string 
    @DSModeled(DSC.SAFE)
    public String getVendor() {
    	return getTaintString();
        //return mVendor;
    }

    // GITI DSModeled - just returning an int
    @DSModeled(DSC.SAFE)
    public int getType() {
    	return getTaintInt();
        //return mType;
    }

    // GITI DSModeled - just returning an int
    @DSModeled(DSC.SAFE)
    public int getVersion() {
    	return getTaintInt();
        //return mVersion;
    }

    // GITI DSModeled - just returning a float
    @DSModeled(DSC.SAFE)
    public float getMaximumRange() {
    	return getTaintFloat();
        //return mMaxRange;
    }

    // GITI DSModeled - just returning a float
    @DSModeled(DSC.SAFE)
    public float getResolution() {
    	return getTaintInt();
        //return mResolution;
    }

    // GITI DSModeled - just returning a float
    @DSModeled(DSC.SAFE)
    public float getPower() {
    	return getTaintFloat();
        //return mPower;
    }

    // GITI DSModeled - just returning an int
    @DSModeled(DSC.SAFE)
    public int getMinDelay() {
    	return getTaintInt();
        //return mMinDelay;
    }

    int getHandle() {
    	return getTaintInt();
        //return mHandle;
    }

    void setRange(float max, float res) {
    	addTaint(max.getTaint());
    	addTaint(res.getTaint());
    }

    void setLegacyType(int legacyType) {
    	addTaint(legacyType.getTaint());
    }

    int getLegacyType() {
    	return getTaintInt();
        //return mLegacyType;
    }
}
