/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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
	
	@DSSafe(DSCat.SAFE_LIST)
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

