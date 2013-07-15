package android.hardware;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface SensorEventListener {

    
    public void onSensorChanged(SensorEvent event);

    
    public void onAccuracyChanged(Sensor sensor, int accuracy);    
}
