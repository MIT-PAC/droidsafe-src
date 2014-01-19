package droidsafe.concrete;

//Droidsafe Imports
import droidsafe.annotations.*;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class DroidSafeSensorManager extends SensorManager {

	public DroidSafeSensorManager() {
		super(null);	
	}
	
	public Sensor getDefaultSensor(int i) {
		return null;
	}
	
	public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate) {
		SensorEvent se = new SensorEvent();
		se.sensor = sensor;
		
		listener.onSensorChanged(se);
		return true;
	}
	
	public void unregisterListener(SensorEventListener sel) {
		
	}
}

