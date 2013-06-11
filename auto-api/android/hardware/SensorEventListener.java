package android.hardware;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface SensorEventListener {

    
    public void onSensorChanged(SensorEvent event);

    
    public void onAccuracyChanged(Sensor sensor, int accuracy);    
}

