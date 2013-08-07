package android.hardware;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface SensorEventListener {

    
    public void onSensorChanged(SensorEvent event);

    
    public void onAccuracyChanged(Sensor sensor, int accuracy);    
}
