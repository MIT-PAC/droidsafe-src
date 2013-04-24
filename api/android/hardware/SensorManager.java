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
	private static final int SENSOR_DISABLE = -1;
	private static int sQueue;
	private static boolean sSensorModuleInitialized = false;
	private static IWindowManager sWindowManager;
	private static int sRotation = Surface.ROTATION_0;
	private static ArrayList<Sensor> sFullSensorsList = new ArrayList<Sensor>();
	private static SensorEventPool sPool;
	private static SensorThread sSensorThread;
	
	static SparseArray<Sensor> sHandleToSensor = new SparseArray<Sensor>();
	static final ArrayList<ListenerDelegate> sListeners =
			new ArrayList<ListenerDelegate>();
	
	private DSTaintObject dsTaint = new DSTaintObject();
	
	Looper mMainLooper;
	
	@DSModeled(value = DSC.SAFE)
	public SensorManager(Looper mainLooper) {
		dsTaint.addTaint(mainLooper);  //NOTE:  mMainLooper has package level protection 
		/*
		 * The rest of the original implementation is simply setting
		 * up some internal state managed in private variables.  This   
		 * functionality will be commented out for now as it isn't necessary
		 */
		
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
    }
	
	public void onRotationChanged(int rotation) {
        synchronized(sListeners) {
        	dsTaint.addTaint(rotation);
            sRotation  = rotation;
        }
    }
	
	private int getLegacySensorType(int type) {
		/*
        switch (type) {
            case Sensor.TYPE_ACCELEROMETER:
                return SENSOR_ACCELEROMETER;
            case Sensor.TYPE_MAGNETIC_FIELD:
                return SENSOR_MAGNETIC_FIELD;
            case Sensor.TYPE_ORIENTATION:
                return SENSOR_ORIENTATION_RAW;
            case Sensor.TYPE_TEMPERATURE:
                return SENSOR_TEMPERATURE;
        }
        */
        return 0;
    }
	
	private static int sensors_module_get_next_sensor(Sensor sensor, int next) { //Formerly a native method
		return 0;
	}
	
	private static int sensors_module_init() {  //Formerly a native method
		return 0;
	}
	
	private static void nativeClassInit() {  //Formerly a native method
		//Noop
	}
	
	@DSModeled(DSC.SAFE)
	public void unregisterListener(SensorEventListener listener) {
		unregisterListener((Object)listener);
    }
	
	@DSModeled(DSC.SAFE)
	private void unregisterListener(Object listener) {
        if (listener == null) {
            return;
        }

        synchronized (sListeners) {
            final int size = sListeners.size();
            for (int i=0 ; i<size ; i++) {
                ListenerDelegate l = sListeners.get(i);
                if (l.getListener() == listener) {
                    sListeners.remove(i);
                    // disable all sensors for this listener
                    for (Sensor sensor : l.getSensors()) {
                        disableSensorLocked(sensor);
                    }
                    break;
                }
            }
        }
    }
	
	@DSModeled(DSC.SAFE)
	private boolean disableSensorLocked(Sensor sensor) {
        for (ListenerDelegate i : sListeners) {
            if (i.hasSensor(sensor)) {
                // not an error, it's just that this sensor is still in use
                return true;
            }
        }
        String name = sensor.getName();
        int handle = sensor.getHandle();
        return sensors_enable_sensor(sQueue, name, handle, SENSOR_DISABLE);
    }
	
	@DSModeled(DSC.SAFE)
	static boolean sensors_enable_sensor(int queue, String name, int sensor, int enable) {
		//Formerly a native method.  Generated a very simple stub.
		return false;
	}
	
	private class ListenerDelegate {
		private final SensorEventListener mSensorEventListener;
		private final ArrayList<Sensor> mSensorList = new ArrayList<Sensor>();
		public SparseBooleanArray mSensors = new SparseBooleanArray();
		
		private ListenerDelegate() {
			mSensorEventListener = null;
		}
		
		Object getListener() {
            return mSensorEventListener;
        }
		
		List<Sensor> getSensors() {
            return mSensorList;
        }
		
		boolean hasSensor(Sensor sensor) {
            return mSensors.get(sensor.getHandle());
        }
	}
	
	private class SensorEventPool {
		private final int mPoolSize;
        private final SensorEvent mPool[];
        private int mNumItemsInPool;
        
        private DSTaintObject dsTaint = new DSTaintObject();
        
		SensorEventPool(int poolSize) {
			dsTaint.addTaint(poolSize);
            mPoolSize = poolSize;
            mNumItemsInPool = poolSize;
            mPool = new SensorEvent[poolSize];
        }
	}
	
	@DSModeled(DSC.SAFE)
	static private class SensorThread {
		SensorThread() {
        }
	}
	
	@DSModeled(DSC.SAFE)
	public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate) {
		SensorEvent se = new SensorEvent(0);
		se.sensor = sensor;
		
		listener.onSensorChanged(se);
		return true;
    }
}
