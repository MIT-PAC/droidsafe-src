package android.hardware;

// Droidsafe Imports

public interface SensorEventListener {

    
    public void onSensorChanged(SensorEvent event);

    
    public void onAccuracyChanged(Sensor sensor, int accuracy);    
}
