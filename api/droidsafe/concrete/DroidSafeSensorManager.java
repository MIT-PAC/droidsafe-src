package droidsafe.concrete;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class DroidSafeSensorManager extends SensorManager {
	@DSModeled(DSC.SAFE)
	public DroidSafeSensorManager() {
		super(null);	
	}

	@DSModeled(DSC.SAFE)
	public Sensor getDefaultSensor(int i) {
		return null;
	}
	
	
}


