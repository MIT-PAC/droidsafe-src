package android.hardware;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SensorEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.051 -0500", hash_original_field = "34347BA7077FDF6590D0C0F92E7987C8", hash_generated_field = "4C1F93B13D708FDED2C5B6FA6458F63C")

    public final float[] values;
    public Sensor sensor = new Sensor();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.056 -0500", hash_original_field = "F968021B8FC52C3A5A8A5DC1E79FDC6D", hash_generated_field = "7F2B820F3882E94A9556DB7409C1AD98")

    public int accuracy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.059 -0500", hash_original_field = "145039C09D0281F07AE1DE322AF921C0", hash_generated_field = "37EA591B5E14A037995EF6FFB5E9C3F8")

    public long timestamp;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.062 -0500", hash_original_method = "70E99143ED23AB543A4BC023624913AA", hash_generated_method = "70E99143ED23AB543A4BC023624913AA")
    
SensorEvent(int size) {
        values = new float[size];
    }
    
    // orphaned legacy method
    
    public SensorEvent() {
    	//Method doesn't exist in original implementation, needed for specdump
    	this(0);  //Call the original constructor with a size of 0
    }
    
}

