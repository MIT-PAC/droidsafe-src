package android.hardware;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SensorEvent {
    public final float[] values;
    public Sensor sensor;
    public int accuracy;
    public long timestamp;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.480 -0400", hash_original_method = "70E99143ED23AB543A4BC023624913AA", hash_generated_method = "6A2107F5229384B5E9BFBD65A1293A71")
    @DSModeled(DSC.SAFE)
     public SensorEvent(int size) {
        dsTaint.addTaint(size);
        values = new float[size];
        // ---------- Original Method ----------
        //values = new float[size];
    }

    
}


