package android.hardware;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

@Deprecated public interface SensorListener {

    
    public void onSensorChanged(int sensor, float[] values);

    
    public void onAccuracyChanged(int sensor, int accuracy);    
}
