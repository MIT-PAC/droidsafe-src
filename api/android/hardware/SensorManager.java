package android.hardware;

import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.Handler;
import android.os.Message;
import android.os.ServiceManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.IRotationWatcher;
import android.view.IWindowManager;
import android.view.Surface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public class SensorManager {
	private DSTaintObject dsTaint = new DSTaintObject();
	
	@DSModeled(value = DSC.SAFE)
	public SensorManager(Looper mainLooper) {
		dsTaint.addTaint(mainLooper);  //NOTE:  mMainLooper has package level protection 
		/*
		 * The rest of the original implementation is simply setting
		 * up some internal state managed in private variables.  This   
		 * functionality will be commented out for now as it isn't necessary
		 */
		/*
        mMainLooper = mainLooper;


        synchronized(sListeners) {
            if (!sSensorModuleInitialized) {
                sSensorModuleInitialized = true;

                nativeClassInit();

                sWindowManager = IWindowManager.Stub.asInterface(
                        ServiceManager.getService("window"));
                if (sWindowManager != null) {
                    // if it's null we're running in the system process
                    // which won't get the rotated values
                    try {
                        sRotation = sWindowManager.watchRotation(
                                new IRotationWatcher.Stub() {
                                    public void onRotationChanged(int rotation) {
                                        SensorManager.this.onRotationChanged(rotation);
                                    }
                                }
                        );
                    } catch (RemoteException e) {
                    }
                }

                // initialize the sensor list
                sensors_module_init();
                final ArrayList<Sensor> fullList = sFullSensorsList;
                int i = 0;
                do {
                    Sensor sensor = new Sensor();
                    i = sensors_module_get_next_sensor(sensor, i);

                    if (i>=0) {
                        //Log.d(TAG, "found sensor: " + sensor.getName() +
                        //        ", handle=" + sensor.getHandle());
                        sensor.setLegacyType(getLegacySensorType(sensor.getType()));
                        fullList.add(sensor);
                        sHandleToSensor.append(sensor.getHandle(), sensor);
                    }
                } while (i>0);

                sPool = new SensorEventPool( sFullSensorsList.size()*2 );
                sSensorThread = new SensorThread();
            }
        }
        */
    }
}
