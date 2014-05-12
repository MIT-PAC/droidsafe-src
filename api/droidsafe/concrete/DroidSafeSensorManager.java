package droidsafe.concrete;

//Droidsafe Imports
import droidsafe.annotations.*;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class DroidSafeSensorManager extends SensorManager {

	@DSSafe(DSCat.SAFE_OTHERS)
    public DroidSafeSensorManager() {
		super(null);	
	}
	
	@DSSpec(DSCat.ANDROID_MANAGER)
    public Sensor getDefaultSensor(int i) {
		return null;
	}
	
	@DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate) {
		SensorEvent se = new SensorEvent();
		se.sensor = sensor;
		
		listener.onSensorChanged(se);
		return true;
	}
	
	@DSSafe(DSCat.SAFE_OTHERS)
    public void unregisterListener(SensorEventListener sel) {
		
	}
}

