package android.hardware;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class SensorEvent {
    public final float[] values;
    public Sensor sensor = new Sensor();
    public int accuracy;
    public long timestamp;
    
    @DSModeled(DSC.SAFE)
    public SensorEvent(int size) {
        values = new float[size];
    }

    
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
    public SensorEvent() {
    	//Method doesn't exist in original implementation, needed for specdump
    	this(0);  //Call the original constructor with a size of 0
    }
    
}

