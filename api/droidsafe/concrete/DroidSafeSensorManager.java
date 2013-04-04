package droidsafe.concrete;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Looper;

import droidsafe.annotations.*;

import android.hardware.Sensor;

public class DroidSafeSensorManager extends SensorManager {

	public DroidSafeSensorManager() {
		super(null);	
	}

	@DSModeled(DSC.SAFE)
	public Sensor getDefaultSensor(int i) {
		return null;
	}
	
	@DSModeled(DSC.SAFE)
	public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate) {
		SensorEvent se = new SensorEvent(0);
		se.sensor = sensor;
		
		listener.onSensorChanged(se);
		return true;
	}
}

