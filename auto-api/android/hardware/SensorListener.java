package android.hardware;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

@Deprecated public interface SensorListener {

    
    public void onSensorChanged(int sensor, float[] values);

    
    public void onAccuracyChanged(int sensor, int accuracy);    
}
