package android.hardware;

// Droidsafe Imports
import droidsafe.annotations.*;



public class Sensor {
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
    
    @DSModeled(DSC.SAFE)
    Sensor() {
    }

    
    @DSModeled(DSC.SAFE)
    public String getName() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        //return mName;
    }

    
    @DSModeled(DSC.SAFE)
    public String getVendor() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        //return mVendor;
    }

    
    @DSModeled(DSC.SAFE)
    public int getType() {
    	return getTaintInt();
        //return mType;
    }

    
    @DSModeled(DSC.SAFE)
    public int getVersion() {
    	return getTaintInt();
        //return mVersion;
    }

    
    @DSModeled(DSC.SAFE)
    public float getMaximumRange() {
    	return getTaintFloat();
        //return mMaxRange;
    }

    
    @DSModeled(DSC.SAFE)
    public float getResolution() {
    	return getTaintInt();
        //return mResolution;
    }

    
    @DSModeled(DSC.SAFE)
    public float getPower() {
    	return getTaintFloat();
        //return mPower;
    }

    
    @DSModeled(DSC.SAFE)
    public int getMinDelay() {
    	return getTaintInt();
        //return mMinDelay;
    }

    
    @DSModeled(DSC.SAFE)
    int getHandle() {
    	return getTaintInt();
        //return mHandle;
    }

    
    @DSModeled(DSC.SAFE)
    void setRange(float max, float res) {
    	addTaint(max);
    	addTaint(res);
    }

    
    @DSModeled(DSC.SAFE)
    void setLegacyType(int legacyType) {
    	addTaint(legacyType);
    }

    
    @DSModeled(DSC.SAFE)
    int getLegacyType() {
    	return getTaintInt();
        //return mLegacyType;
    }

    
    public static final int TYPE_ACCELEROMETER = 1;
    public static final int TYPE_MAGNETIC_FIELD = 2;
    @Deprecated
    public static final int TYPE_ORIENTATION = 3;
    public static final int TYPE_GYROSCOPE = 4;
    public static final int TYPE_LIGHT = 5;
    public static final int TYPE_PRESSURE = 6;
    @Deprecated
    public static final int TYPE_TEMPERATURE = 7;
    public static final int TYPE_PROXIMITY = 8;
    public static final int TYPE_GRAVITY = 9;
    public static final int TYPE_LINEAR_ACCELERATION = 10;
    public static final int TYPE_ROTATION_VECTOR = 11;
    public static final int TYPE_RELATIVE_HUMIDITY = 12;
    public static final int TYPE_AMBIENT_TEMPERATURE = 13;
    public static final int TYPE_ALL = -1;
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public Sensor(int type) {
    	addTaint(type);
    }
    
}

