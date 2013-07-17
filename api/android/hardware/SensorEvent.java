package android.hardware;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SensorEvent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.325 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "08CDF65A917190C764B2D9069756F141")

    public float[] values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.325 -0400", hash_original_field = "A5FE26D5D09B736A77F4345E9F80B951", hash_generated_field = "E3EF17D4BA6CB4B7E422EA40D31F2B0F")

    public Sensor sensor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.325 -0400", hash_original_field = "5D6DB9A1DC722586187FC2DB530F8388", hash_generated_field = "7F2B820F3882E94A9556DB7409C1AD98")

    public int accuracy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.325 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "37EA591B5E14A037995EF6FFB5E9C3F8")

    public long timestamp;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.313 -0400", hash_original_method = "70E99143ED23AB543A4BC023624913AA", hash_generated_method = "61F2DC68074AC669893F0BE5944FEDBC")
	public
      SensorEvent(int size) {
        values = new float[size];
        // ---------- Original Method ----------
        //values = new float[size];
    }

    
}

