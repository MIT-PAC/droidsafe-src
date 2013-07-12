package android.hardware;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

@Deprecated public interface SensorListener {

    
    public void onSensorChanged(int sensor, float[] values);

    
    public void onAccuracyChanged(int sensor, int accuracy);    
}
