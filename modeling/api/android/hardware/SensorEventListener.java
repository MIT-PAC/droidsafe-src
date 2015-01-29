package android.hardware;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface SensorEventListener {
    
    @DSVerified    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void onSensorChanged(SensorEvent event);
    
    @DSVerified    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void onAccuracyChanged(Sensor sensor, int accuracy);    
}
