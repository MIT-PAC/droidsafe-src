package android.hardware;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface SensorEventListener {

    
    public void onSensorChanged(SensorEvent event);

    
    public void onAccuracyChanged(Sensor sensor, int accuracy);    
}
