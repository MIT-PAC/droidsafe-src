package android.hardware;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.IRotationWatcher;
import android.view.IWindowManager;
import android.view.Surface;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class SensorManager {
    Looper mMainLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.872 -0400", hash_original_field = "7BEB80E82E92B6E556110552EA9B73AD", hash_generated_field = "0F9F236B24164523848440F1C5249FC1")

    @SuppressWarnings("deprecation") private HashMap<SensorListener, LegacyListener> mLegacyListenersMap = new HashMap<SensorListener, LegacyListener>();
    
    @DSModeled(value = DSC.SAFE)
	public SensorManager(Looper mainLooper) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.875 -0400", hash_original_method = "9387EF1577B9728CF6A87474164955A1", hash_generated_method = "20AE1A907E794DAB7485BB6EDD1CF853")
    @Deprecated
    public int getSensors() {
        int result = 0;
        final ArrayList<Sensor> fullList = sFullSensorsList;
for(Sensor i : fullList)
        {
switch(i.getType()){
            case Sensor.TYPE_ACCELEROMETER:
            result |= SensorManager.SENSOR_ACCELEROMETER;
            break;
            case Sensor.TYPE_MAGNETIC_FIELD:
            result |= SensorManager.SENSOR_MAGNETIC_FIELD;
            break;
            case Sensor.TYPE_ORIENTATION:
            result |= SensorManager.SENSOR_ORIENTATION |
                    SensorManager.SENSOR_ORIENTATION_RAW;
            break;
}
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1826524907 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963984010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963984010;
        // ---------- Original Method ----------
        //int result = 0;
        //final ArrayList<Sensor> fullList = sFullSensorsList;
        //for (Sensor i : fullList) {
            //switch (i.getType()) {
                //case Sensor.TYPE_ACCELEROMETER:
                    //result |= SensorManager.SENSOR_ACCELEROMETER;
                    //break;
                //case Sensor.TYPE_MAGNETIC_FIELD:
                    //result |= SensorManager.SENSOR_MAGNETIC_FIELD;
                    //break;
                //case Sensor.TYPE_ORIENTATION:
                    //result |= SensorManager.SENSOR_ORIENTATION |
                    //SensorManager.SENSOR_ORIENTATION_RAW;
                    //break;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.875 -0400", hash_original_method = "D388F11CBE90143BC36FA3E001809013", hash_generated_method = "E3E1CF446F59C4883E58376EFB7C4AF6")
    public List<Sensor> getSensorList(int type) {
        addTaint(type);
        List<Sensor> list;
        final ArrayList<Sensor> fullList = sFullSensorsList;
        synchronized
(fullList)        {
            list = sSensorListByType.get(type);
            if(list == null)            
            {
                if(type == Sensor.TYPE_ALL)                
                {
                    list = fullList;
                } //End block
                else
                {
                    list = new ArrayList<Sensor>();
for(Sensor i : fullList)
                    {
                        if(i.getType() == type)                        
                        list.add(i);
                    } //End block
                } //End block
                list = Collections.unmodifiableList(list);
                sSensorListByType.append(type, list);
            } //End block
        } //End block
List<Sensor> varED12C351C2E8CA4F85F097DDC7E77B4D_1918059607 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1918059607.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1918059607;
        // ---------- Original Method ----------
        //List<Sensor> list;
        //final ArrayList<Sensor> fullList = sFullSensorsList;
        //synchronized(fullList) {
            //list = sSensorListByType.get(type);
            //if (list == null) {
                //if (type == Sensor.TYPE_ALL) {
                    //list = fullList;
                //} else {
                    //list = new ArrayList<Sensor>();
                    //for (Sensor i : fullList) {
                        //if (i.getType() == type)
                            //list.add(i);
                    //}
                //}
                //list = Collections.unmodifiableList(list);
                //sSensorListByType.append(type, list);
            //}
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.876 -0400", hash_original_method = "CA10DA2A107C571495F28D1A1A335E4D", hash_generated_method = "F78FDE58BD1A227AB23B75F1E28886A8")
    @Deprecated
    public boolean registerListener(SensorListener listener, int sensors) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(sensors);
        addTaint(listener.getTaint());
        boolean varAC5996AFD045CF63E6564E50303873FC_466551103 = (registerListener(listener, sensors, SENSOR_DELAY_NORMAL));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672387445 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672387445;
        // ---------- Original Method ----------
        //return registerListener(listener, sensors, SENSOR_DELAY_NORMAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.877 -0400", hash_original_method = "B7C7A7F6BC1EDB860C06401873DD1A46", hash_generated_method = "8B144E16CC8D944BB57DF1F5A04DC185")
    @Deprecated
    public boolean registerListener(SensorListener listener, int sensors, int rate) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(rate);
        addTaint(sensors);
        addTaint(listener.getTaint());
        if(listener == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_519934567 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134895097 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_134895097;
        } //End block
        boolean result = false;
        result = registerLegacyListener(SENSOR_ACCELEROMETER, Sensor.TYPE_ACCELEROMETER,
                listener, sensors, rate) || result;
        result = registerLegacyListener(SENSOR_MAGNETIC_FIELD, Sensor.TYPE_MAGNETIC_FIELD,
                listener, sensors, rate) || result;
        result = registerLegacyListener(SENSOR_ORIENTATION_RAW, Sensor.TYPE_ORIENTATION,
                listener, sensors, rate) || result;
        result = registerLegacyListener(SENSOR_ORIENTATION, Sensor.TYPE_ORIENTATION,
                listener, sensors, rate) || result;
        result = registerLegacyListener(SENSOR_TEMPERATURE, Sensor.TYPE_TEMPERATURE,
                listener, sensors, rate) || result;
        boolean varB4A88417B3D0170D754C647C30B7216A_1561773333 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_473431269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_473431269;
        // ---------- Original Method ----------
        //if (listener == null) {
            //return false;
        //}
        //boolean result = false;
        //result = registerLegacyListener(SENSOR_ACCELEROMETER, Sensor.TYPE_ACCELEROMETER,
                //listener, sensors, rate) || result;
        //result = registerLegacyListener(SENSOR_MAGNETIC_FIELD, Sensor.TYPE_MAGNETIC_FIELD,
                //listener, sensors, rate) || result;
        //result = registerLegacyListener(SENSOR_ORIENTATION_RAW, Sensor.TYPE_ORIENTATION,
                //listener, sensors, rate) || result;
        //result = registerLegacyListener(SENSOR_ORIENTATION, Sensor.TYPE_ORIENTATION,
                //listener, sensors, rate) || result;
        //result = registerLegacyListener(SENSOR_TEMPERATURE, Sensor.TYPE_TEMPERATURE,
                //listener, sensors, rate) || result;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.877 -0400", hash_original_method = "2BFEE9499E6BC093763ECA6BB97D348E", hash_generated_method = "BDBDE1E7D163E16871F71399C898F761")
    @SuppressWarnings("deprecation")
    private boolean registerLegacyListener(int legacyType, int type,
            SensorListener listener, int sensors, int rate) {
        addTaint(rate);
        addTaint(sensors);
        addTaint(listener.getTaint());
        addTaint(type);
        addTaint(legacyType);
        if(listener == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1867239703 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_23630577 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_23630577;
        } //End block
        boolean result = false;
        if((sensors & legacyType) != 0)        
        {
            Sensor sensor = getDefaultSensor(type);
            if(sensor != null)            
            {
                LegacyListener legacyListener = null;
                synchronized
(mLegacyListenersMap)                {
                    legacyListener = mLegacyListenersMap.get(listener);
                    if(legacyListener == null)                    
                    {
                        legacyListener = new LegacyListener(listener);
                        mLegacyListenersMap.put(listener, legacyListener);
                    } //End block
                } //End block
                legacyListener.registerSensor(legacyType);
                result = registerListener(legacyListener, sensor, rate);
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_1988046992 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_438242229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_438242229;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.878 -0400", hash_original_method = "08C00AEC5C2F4A8557AFE56DD5038FAA", hash_generated_method = "9D42C88D13E47450325B36329B12BE0A")
    @Deprecated
    public void unregisterListener(SensorListener listener, int sensors) {
        addTaint(sensors);
        addTaint(listener.getTaint());
        unregisterLegacyListener(SENSOR_ACCELEROMETER, Sensor.TYPE_ACCELEROMETER,
                listener, sensors);
        unregisterLegacyListener(SENSOR_MAGNETIC_FIELD, Sensor.TYPE_MAGNETIC_FIELD,
                listener, sensors);
        unregisterLegacyListener(SENSOR_ORIENTATION_RAW, Sensor.TYPE_ORIENTATION,
                listener, sensors);
        unregisterLegacyListener(SENSOR_ORIENTATION, Sensor.TYPE_ORIENTATION,
                listener, sensors);
        unregisterLegacyListener(SENSOR_TEMPERATURE, Sensor.TYPE_TEMPERATURE,
                listener, sensors);
        // ---------- Original Method ----------
        //unregisterLegacyListener(SENSOR_ACCELEROMETER, Sensor.TYPE_ACCELEROMETER,
                //listener, sensors);
        //unregisterLegacyListener(SENSOR_MAGNETIC_FIELD, Sensor.TYPE_MAGNETIC_FIELD,
                //listener, sensors);
        //unregisterLegacyListener(SENSOR_ORIENTATION_RAW, Sensor.TYPE_ORIENTATION,
                //listener, sensors);
        //unregisterLegacyListener(SENSOR_ORIENTATION, Sensor.TYPE_ORIENTATION,
                //listener, sensors);
        //unregisterLegacyListener(SENSOR_TEMPERATURE, Sensor.TYPE_TEMPERATURE,
                //listener, sensors);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.878 -0400", hash_original_method = "9C431FA18D1D7C546E542BF96DE5A08A", hash_generated_method = "6B299193632A75A92AEE1115E85972B2")
    @SuppressWarnings("deprecation")
    private void unregisterLegacyListener(int legacyType, int type,
            SensorListener listener, int sensors) {
        addTaint(sensors);
        addTaint(listener.getTaint());
        addTaint(type);
        addTaint(legacyType);
        if(listener == null)        
        {
            return;
        } //End block
        LegacyListener legacyListener = null;
        synchronized
(mLegacyListenersMap)        {
            legacyListener = mLegacyListenersMap.get(listener);
        } //End block
        if(legacyListener != null)        
        {
            if((sensors & legacyType) != 0)            
            {
                Sensor sensor = getDefaultSensor(type);
                if(sensor != null)                
                {
                    if(legacyListener.unregisterSensor(legacyType))                    
                    {
                        unregisterListener(legacyListener, sensor);
                        synchronized
(sListeners)                        {
                            boolean found = false;
for(ListenerDelegate i : sListeners)
                            {
                                if(i.getListener() == legacyListener)                                
                                {
                                    found = true;
                                    break;
                                } //End block
                            } //End block
                            if(!found)                            
                            {
                                synchronized
(mLegacyListenersMap)                                {
                                    mLegacyListenersMap.remove(listener);
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.879 -0400", hash_original_method = "F024191DD75DA5578F802D33C834CE8F", hash_generated_method = "F4EE929A1A6A4C70C3A8DE2D405AC865")
    @Deprecated
    public void unregisterListener(SensorListener listener) {
        addTaint(listener.getTaint());
        unregisterListener(listener, SENSOR_ALL | SENSOR_ORIENTATION_RAW);
        // ---------- Original Method ----------
        //unregisterListener(listener, SENSOR_ALL | SENSOR_ORIENTATION_RAW);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.879 -0400", hash_original_method = "A245758148D9D81E2CADBC67CD903CC7", hash_generated_method = "1A7A8DCC8AA6C4D35AA8357E67ED7B05")
    public void unregisterListener(SensorEventListener listener, Sensor sensor) {
        addTaint(sensor.getTaint());
        addTaint(listener.getTaint());
        unregisterListener((Object)listener, sensor);
        // ---------- Original Method ----------
        //unregisterListener((Object)listener, sensor);
    }

    
    @DSModeled(DSC.SAFE)
	public void unregisterListener(SensorEventListener listener) {
		unregisterListener((Object)listener);
    }

    
    @DSModeled(DSC.SAFE)
	public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate) {
		SensorEvent se = new SensorEvent(0);
		se.sensor = sensor;
		listener.onSensorChanged(se);
		return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.880 -0400", hash_original_method = "500C86ADE6AA4F4A0E12D1A653386772", hash_generated_method = "ECEB83A13D193ED6AF937AD2013DF140")
    private boolean enableSensorLocked(Sensor sensor, int delay) {
        addTaint(delay);
        addTaint(sensor.getTaint());
        boolean result = false;
for(ListenerDelegate i : sListeners)
        {
            if(i.hasSensor(sensor))            
            {
                String name = sensor.getName();
                int handle = sensor.getHandle();
                result = sensors_enable_sensor(sQueue, name, handle, delay);
                break;
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_2067275341 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_886564393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_886564393;
        // ---------- Original Method ----------
        //boolean result = false;
        //for (ListenerDelegate i : sListeners) {
            //if (i.hasSensor(sensor)) {
                //String name = sensor.getName();
                //int handle = sensor.getHandle();
                //result = sensors_enable_sensor(sQueue, name, handle, delay);
                //break;
            //}
        //}
        //return result;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.881 -0400", hash_original_method = "55FB0E0786574FCA30E9C20955CE2F64", hash_generated_method = "0F03A2A8EF12196941286E0DE06E7BD7")
    public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate,
            Handler handler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(handler.getTaint());
        addTaint(rate);
        addTaint(sensor.getTaint());
        addTaint(listener.getTaint());
        if(listener == null || sensor == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1423175387 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1567227947 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1567227947;
        } //End block
        boolean result = true;
        int delay = -1;
switch(rate){
        case SENSOR_DELAY_FASTEST:
        delay = 0;
        break;
        case SENSOR_DELAY_GAME:
        delay = 20000;
        break;
        case SENSOR_DELAY_UI:
        delay = 66667;
        break;
        case SENSOR_DELAY_NORMAL:
        delay = 200000;
        break;
        default:
        delay = rate;
        break;
}        synchronized
(sListeners)        {
            ListenerDelegate l = null;
for(ListenerDelegate i : sListeners)
            {
                if(i.getListener() == listener)                
                {
                    l = i;
                    break;
                } //End block
            } //End block
            if(l == null)            
            {
                l = new ListenerDelegate(listener, sensor, handler);
                sListeners.add(l);
                if(!sListeners.isEmpty())                
                {
                    if(sSensorThread.startLocked())                    
                    {
                        if(!enableSensorLocked(sensor, delay))                        
                        {
                            sListeners.remove(l);
                            result = false;
                        } //End block
                    } //End block
                    else
                    {
                        sListeners.remove(l);
                        result = false;
                    } //End block
                } //End block
                else
                {
                    result = false;
                } //End block
            } //End block
            else
            {
                l.addSensor(sensor);
                if(!enableSensorLocked(sensor, delay))                
                {
                    l.removeSensor(sensor);
                    result = false;
                } //End block
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_150419366 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349208204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349208204;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.882 -0400", hash_original_method = "1441CD23D4F492BD7877A59C29F56827", hash_generated_method = "68834892F5B6DC954FF63CBEBFA5FC17")
    private void unregisterListener(Object listener, Sensor sensor) {
        addTaint(sensor.getTaint());
        addTaint(listener.getTaint());
        if(listener == null || sensor == null)        
        {
            return;
        } //End block
        synchronized
(sListeners)        {
            final int size = sListeners.size();
for(int i=0;i<size;i++)
            {
                ListenerDelegate l = sListeners.get(i);
                if(l.getListener() == listener)                
                {
                    if(l.removeSensor(sensor) == 0)                    
                    {
                        sListeners.remove(i);
                    } //End block
                    break;
                } //End block
            } //End block
            disableSensorLocked(sensor);
        } //End block
        // ---------- Original Method ----------
        //if (listener == null || sensor == null) {
            //return;
        //}
        //synchronized (sListeners) {
            //final int size = sListeners.size();
            //for (int i=0 ; i<size ; i++) {
                //ListenerDelegate l = sListeners.get(i);
                //if (l.getListener() == listener) {
                    //if (l.removeSensor(sensor) == 0) {
                        //sListeners.remove(i);
                    //}
                    //break;
                //}
            //}
            //disableSensorLocked(sensor);
        //}
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

    
    public static boolean getRotationMatrix(float[] R, float[] I,
            float[] gravity, float[] geomagnetic) {
        float Ax = gravity[0];
        float Ay = gravity[1];
        float Az = gravity[2];
        final float Ex = geomagnetic[0];
        final float Ey = geomagnetic[1];
        final float Ez = geomagnetic[2];
        float Hx = Ey*Az - Ez*Ay;
        float Hy = Ez*Ax - Ex*Az;
        float Hz = Ex*Ay - Ey*Ax;
        final float normH = (float)Math.sqrt(Hx*Hx + Hy*Hy + Hz*Hz);
        if (normH < 0.1f) {
            return false;
        }
        final float invH = 1.0f / normH;
        Hx *= invH;
        Hy *= invH;
        Hz *= invH;
        final float invA = 1.0f / (float)Math.sqrt(Ax*Ax + Ay*Ay + Az*Az);
        Ax *= invA;
        Ay *= invA;
        Az *= invA;
        final float Mx = Ay*Hz - Az*Hy;
        final float My = Az*Hx - Ax*Hz;
        final float Mz = Ax*Hy - Ay*Hx;
        if (R != null) {
            if (R.length == 9) {
                R[0] = Hx;     R[1] = Hy;     R[2] = Hz;
                R[3] = Mx;     R[4] = My;     R[5] = Mz;
                R[6] = Ax;     R[7] = Ay;     R[8] = Az;
            } else if (R.length == 16) {
                R[0]  = Hx;    R[1]  = Hy;    R[2]  = Hz;   R[3]  = 0;
                R[4]  = Mx;    R[5]  = My;    R[6]  = Mz;   R[7]  = 0;
                R[8]  = Ax;    R[9]  = Ay;    R[10] = Az;   R[11] = 0;
                R[12] = 0;     R[13] = 0;     R[14] = 0;    R[15] = 1;
            }
        }
        if (I != null) {
            final float invE = 1.0f / (float)Math.sqrt(Ex*Ex + Ey*Ey + Ez*Ez);
            final float c = (Ex*Mx + Ey*My + Ez*Mz) * invE;
            final float s = (Ex*Ax + Ey*Ay + Ez*Az) * invE;
            if (I.length == 9) {
                I[0] = 1;     I[1] = 0;     I[2] = 0;
                I[3] = 0;     I[4] = c;     I[5] = s;
                I[6] = 0;     I[7] =-s;     I[8] = c;
            } else if (I.length == 16) {
                I[0] = 1;     I[1] = 0;     I[2] = 0;
                I[4] = 0;     I[5] = c;     I[6] = s;
                I[8] = 0;     I[9] =-s;     I[10]= c;
                I[3] = I[7] = I[11] = I[12] = I[13] = I[14] = 0;
                I[15] = 1;
            }
        }
        return true;
    }

    
    public static float getInclination(float[] I) {
        if (I.length == 9) {
            return (float)Math.atan2(I[5], I[4]);
        } else {
            return (float)Math.atan2(I[6], I[5]);
        }
    }

    
    public static boolean remapCoordinateSystem(float[] inR, int X, int Y,
            float[] outR) {
        if (inR == outR) {
            final float[] temp = mTempMatrix;
            synchronized(temp) {
                if (remapCoordinateSystemImpl(inR, X, Y, temp)) {
                    final int size = outR.length;
                    for (int i=0 ; i<size ; i++)
                        outR[i] = temp[i];
                    return true;
                }
            }
        }
        return remapCoordinateSystemImpl(inR, X, Y, outR);
    }

    
    private static boolean remapCoordinateSystemImpl(float[] inR, int X, int Y,
            float[] outR) {
        final int length = outR.length;
        if (inR.length != length)
            return false;
        if ((X & 0x7C)!=0 || (Y & 0x7C)!=0)
            return false;
        if (((X & 0x3)==0) || ((Y & 0x3)==0))
            return false;
        if ((X & 0x3) == (Y & 0x3))
            return false;
        int Z = X ^ Y;
        final int x = (X & 0x3)-1;
        final int y = (Y & 0x3)-1;
        final int z = (Z & 0x3)-1;
        final int axis_y = (z+1)%3;
        final int axis_z = (z+2)%3;
        if (((x^axis_y)|(y^axis_z)) != 0)
            Z ^= 0x80;
        final boolean sx = (X>=0x80);
        final boolean sy = (Y>=0x80);
        final boolean sz = (Z>=0x80);
        final int rowLength = ((length==16)?4:3);
        for (int j=0 ; j<3 ; j++) {
            final int offset = j*rowLength;
            for (int i=0 ; i<3 ; i++) {
                if (x==i)   outR[offset+i] = sx ? -inR[offset+0] : inR[offset+0];
                if (y==i)   outR[offset+i] = sy ? -inR[offset+1] : inR[offset+1];
                if (z==i)   outR[offset+i] = sz ? -inR[offset+2] : inR[offset+2];
            }
        }
        if (length == 16) {
            outR[3] = outR[7] = outR[11] = outR[12] = outR[13] = outR[14] = 0;
            outR[15] = 1;
        }
        return true;
    }

    
    public static float[] getOrientation(float[] R, float values[]) {
        if (R.length == 9) {
            values[0] = (float)Math.atan2(R[1], R[4]);
            values[1] = (float)Math.asin(-R[7]);
            values[2] = (float)Math.atan2(-R[6], R[8]);
        } else {
            values[0] = (float)Math.atan2(R[1], R[5]);
            values[1] = (float)Math.asin(-R[9]);
            values[2] = (float)Math.atan2(-R[8], R[10]);
        }
        return values;
    }

    
    public static float getAltitude(float p0, float p) {
        final float coef = 1.0f / 5.255f;
        return 44330.0f * (1.0f - (float)Math.pow(p/p0, coef));
    }

    
    public void onRotationChanged(int rotation) {
        synchronized(sListeners) {
        	addTaint(rotation);
            sRotation  = rotation;
        }
    }

    
    static int getRotation() {
        synchronized(sListeners) {
            return sRotation;
        }
    }

    
    public static void getAngleChange( float[] angleChange, float[] R, float[] prevR) {
        float rd1=0,rd4=0, rd6=0,rd7=0, rd8=0;
        float ri0=0,ri1=0,ri2=0,ri3=0,ri4=0,ri5=0,ri6=0,ri7=0,ri8=0;
        float pri0=0, pri1=0, pri2=0, pri3=0, pri4=0, pri5=0, pri6=0, pri7=0, pri8=0;
        int i, j, k;
        if(R.length == 9) {
            ri0 = R[0];
            ri1 = R[1];
            ri2 = R[2];
            ri3 = R[3];
            ri4 = R[4];
            ri5 = R[5];
            ri6 = R[6];
            ri7 = R[7];
            ri8 = R[8];
        } else if(R.length == 16) {
            ri0 = R[0];
            ri1 = R[1];
            ri2 = R[2];
            ri3 = R[4];
            ri4 = R[5];
            ri5 = R[6];
            ri6 = R[8];
            ri7 = R[9];
            ri8 = R[10];
        }
        if(prevR.length == 9) {
            pri0 = prevR[0];
            pri1 = prevR[1];
            pri2 = prevR[2];
            pri3 = prevR[3];
            pri4 = prevR[4];
            pri5 = prevR[5];
            pri6 = prevR[6];
            pri7 = prevR[7];
            pri8 = prevR[8];
        } else if(prevR.length == 16) {
            pri0 = prevR[0];
            pri1 = prevR[1];
            pri2 = prevR[2];
            pri3 = prevR[4];
            pri4 = prevR[5];
            pri5 = prevR[6];
            pri6 = prevR[8];
            pri7 = prevR[9];
            pri8 = prevR[10];
        }
        rd1 = pri0 * ri1 + pri3 * ri4 + pri6 * ri7;
        rd4 = pri1 * ri1 + pri4 * ri4 + pri7 * ri7;
        rd6 = pri2 * ri0 + pri5 * ri3 + pri8 * ri6;
        rd7 = pri2 * ri1 + pri5 * ri4 + pri8 * ri7;
        rd8 = pri2 * ri2 + pri5 * ri5 + pri8 * ri8;
        angleChange[0] = (float)Math.atan2(rd1, rd4);
        angleChange[1] = (float)Math.asin(-rd7);
        angleChange[2] = (float)Math.atan2(-rd6, rd8);
    }

    
    public static void getRotationMatrixFromVector(float[] R, float[] rotationVector) {
        float q0;
        float q1 = rotationVector[0];
        float q2 = rotationVector[1];
        float q3 = rotationVector[2];
        if (rotationVector.length == 4) {
            q0 = rotationVector[3];
        } else {
            q0 = 1 - q1*q1 - q2*q2 - q3*q3;
            q0 = (q0 > 0) ? (float)Math.sqrt(q0) : 0;
        }
        float sq_q1 = 2 * q1 * q1;
        float sq_q2 = 2 * q2 * q2;
        float sq_q3 = 2 * q3 * q3;
        float q1_q2 = 2 * q1 * q2;
        float q3_q0 = 2 * q3 * q0;
        float q1_q3 = 2 * q1 * q3;
        float q2_q0 = 2 * q2 * q0;
        float q2_q3 = 2 * q2 * q3;
        float q1_q0 = 2 * q1 * q0;
        if(R.length == 9) {
            R[0] = 1 - sq_q2 - sq_q3;
            R[1] = q1_q2 - q3_q0;
            R[2] = q1_q3 + q2_q0;
            R[3] = q1_q2 + q3_q0;
            R[4] = 1 - sq_q1 - sq_q3;
            R[5] = q2_q3 - q1_q0;
            R[6] = q1_q3 - q2_q0;
            R[7] = q2_q3 + q1_q0;
            R[8] = 1 - sq_q1 - sq_q2;
        } else if (R.length == 16) {
            R[0] = 1 - sq_q2 - sq_q3;
            R[1] = q1_q2 - q3_q0;
            R[2] = q1_q3 + q2_q0;
            R[3] = 0.0f;
            R[4] = q1_q2 + q3_q0;
            R[5] = 1 - sq_q1 - sq_q3;
            R[6] = q2_q3 - q1_q0;
            R[7] = 0.0f;
            R[8] = q1_q3 - q2_q0;
            R[9] = q2_q3 + q1_q0;
            R[10] = 1 - sq_q1 - sq_q2;
            R[11] = 0.0f;
            R[12] = R[13] = R[14] = 0.0f;
            R[15] = 1.0f;
        }
    }

    
    public static void getQuaternionFromVector(float[] Q, float[] rv) {
        if (rv.length == 4) {
            Q[0] = rv[3];
        } else {
            Q[0] = 1 - rv[0]*rv[0] - rv[1]*rv[1] - rv[2]*rv[2];
            Q[0] = (Q[0] > 0) ? (float)Math.sqrt(Q[0]) : 0;
        }
        Q[1] = rv[0];
        Q[2] = rv[1];
        Q[3] = rv[2];
    }

    
    private static void nativeClassInit() {  //Formerly a native method
		//Noop
	}

    
    private static int sensors_module_init() {  //Formerly a native method
		return 0;
	}

    
    private static int sensors_module_get_next_sensor(Sensor sensor, int next) { //Formerly a native method
		return 0;
	}

    
    static int sensors_create_queue() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712978663 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712978663;
    }

    
    static void sensors_destroy_queue(int queue) {
    }

    
    @DSModeled(DSC.SAFE)
	static boolean sensors_enable_sensor(int queue, String name, int sensor, int enable) {
		//Formerly a native method.  Generated a very simple stub.
		return false;
	}

    
    static int sensors_data_poll(int queue, float[] values, int[] status, long[] timestamp) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723860276 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723860276;
    }

    
    private class SensorEventPool {
        private final int mPoolSize;
        private final SensorEvent mPool[];
        private int mNumItemsInPool;
        
        SensorEventPool(int poolSize) {
			addTaint(poolSize);
            mPoolSize = poolSize;
            mNumItemsInPool = poolSize;
            mPool = new SensorEvent[poolSize];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.888 -0400", hash_original_method = "7237223B63C43177AB2849F160B99FEC", hash_generated_method = "6F089E7DC3B7C5939FE12778170233BB")
        private SensorEvent createSensorEvent() {
SensorEvent varCF57860F6690A6B594D00FB0F29270CF_1393524586 =             new SensorEvent(3);
            varCF57860F6690A6B594D00FB0F29270CF_1393524586.addTaint(taint);
            return varCF57860F6690A6B594D00FB0F29270CF_1393524586;
            // ---------- Original Method ----------
            //return new SensorEvent(3);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.889 -0400", hash_original_method = "91BAA7B0EF8F8AB0DA2081F8E926B4FD", hash_generated_method = "BB9120420D74F84CB83CAF63F249133B")
         SensorEvent getFromPool() {
            SensorEvent t = null;
            synchronized
(this)            {
                if(mNumItemsInPool > 0)                
                {
                    final int index = mPoolSize - mNumItemsInPool;
                    t = mPool[index];
                    mPool[index] = null;
                    mNumItemsInPool--;
                } //End block
            } //End block
            if(t == null)            
            {
                t = createSensorEvent();
            } //End block
SensorEvent varE0D714D758F1540A8DF364A965AF9150_207451627 =             t;
            varE0D714D758F1540A8DF364A965AF9150_207451627.addTaint(taint);
            return varE0D714D758F1540A8DF364A965AF9150_207451627;
            // ---------- Original Method ----------
            //SensorEvent t = null;
            //synchronized (this) {
                //if (mNumItemsInPool > 0) {
                    //final int index = mPoolSize - mNumItemsInPool;
                    //t = mPool[index];
                    //mPool[index] = null;
                    //mNumItemsInPool--;
                //}
            //}
            //if (t == null) {
                //t = createSensorEvent();
            //}
            //return t;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.889 -0400", hash_original_method = "C46016A1870C47E495A9527702944C16", hash_generated_method = "53B1EAA66C1F07A1BB242EC8E13B94A3")
         void returnToPool(SensorEvent t) {
            synchronized
(this)            {
                if(mNumItemsInPool < mPoolSize)                
                {
                    mNumItemsInPool++;
                    final int index = mPoolSize - mNumItemsInPool;
                    mPool[index] = t;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //if (mNumItemsInPool < mPoolSize) {
                    //mNumItemsInPool++;
                    //final int index = mPoolSize - mNumItemsInPool;
                    //mPool[index] = t;
                //}
            //}
        }

        
    }


    
    static private class SensorThread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.889 -0400", hash_original_field = "1E66AA878E170B83C94516726B34414A", hash_generated_field = "8CE20653889294789C714060A391C40F")

        Thread mThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.889 -0400", hash_original_field = "BFEC44F69BA3AC1C0519E0E0E96845F5", hash_generated_field = "08100F1ACCE57FCB9D4D360616E4C0FE")

        boolean mSensorsReady;
        
        SensorThread() {
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.890 -0400", hash_original_method = "3012BD4162FEB4D4063E0B4E3944BED9", hash_generated_method = "0065A500F2AC1D21DA0CBFBF0E28A56E")
        @Override
        protected void finalize() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.890 -0400", hash_original_method = "9B9CC9DE22F3A6E67DD39AE0CF54ADF8", hash_generated_method = "4E546DDF38CEC3D6784992258F3941D0")
         boolean startLocked() {
            try 
            {
                if(mThread == null)                
                {
                    mSensorsReady = false;
                    SensorThreadRunnable runnable = new SensorThreadRunnable();
                    Thread thread = new Thread(runnable, SensorThread.class.getName());
                    thread.start();
                    synchronized
(runnable)                    {
                        while
(mSensorsReady == false)                        
                        {
                            runnable.wait();
                        } //End block
                    } //End block
                    mThread = thread;
                } //End block
            } //End block
            catch (InterruptedException e)
            {
            } //End block
            boolean varF4C1FE06B16CD1629E27762E42CF15DD_320089477 = (mThread == null ? false : true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866959401 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866959401;
            // ---------- Original Method ----------
            //try {
                //if (mThread == null) {
                    //mSensorsReady = false;
                    //SensorThreadRunnable runnable = new SensorThreadRunnable();
                    //Thread thread = new Thread(runnable, SensorThread.class.getName());
                    //thread.start();
                    //synchronized (runnable) {
                        //while (mSensorsReady == false) {
                            //runnable.wait();
                        //}
                    //}
                    //mThread = thread;
                //}
            //} catch (InterruptedException e) {
            //}
            //return mThread == null ? false : true;
        }

        
        private class SensorThreadRunnable implements Runnable {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.891 -0400", hash_original_method = "E6F9E1FFFEF800CB7D3BCE3C8792674F", hash_generated_method = "DAC559901444A2EC31580DBE05ABA227")
              SensorThreadRunnable() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.891 -0400", hash_original_method = "8D69A6F3F762D5CCB4AA9AA134EC788D", hash_generated_method = "C17135B7C26B08A37574E9CD87338B83")
            private boolean open() {
                sQueue = sensors_create_queue();
                boolean varB326B5062B2F0E69046810717534CB09_1319254783 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691864572 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_691864572;
                // ---------- Original Method ----------
                //sQueue = sensors_create_queue();
                //return true;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.892 -0400", hash_original_method = "22D645F37E8BABB44C20A553228E0A5C", hash_generated_method = "7404A0D245CDF8477914CE6322AC3272")
            public void run() {
                final float[] values = new float[3];
                final int[] status = new int[1];
                final long timestamp[] = new long[1];
                Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_DISPLAY);
                if(!open())                
                {
                    return;
                } //End block
                synchronized
(this)                {
                    mSensorsReady = true;
                    this.notify();
                } //End block
                while
(true)                
                {
                    final int sensor = sensors_data_poll(sQueue, values, status, timestamp);
                    int accuracy = status[0];
                    synchronized
(sListeners)                    {
                        if(sensor == -1 || sListeners.isEmpty())                        
                        {
                            if(sensor == -1 && !sListeners.isEmpty())                            
                            {
                            } //End block
                            sensors_destroy_queue(sQueue);
                            sQueue = 0;
                            mThread = null;
                            break;
                        } //End block
                        final Sensor sensorObject = sHandleToSensor.get(sensor);
                        if(sensorObject != null)                        
                        {
                            final int size = sListeners.size();
for(int i=0;i<size;i++)
                            {
                                ListenerDelegate listener = sListeners.get(i);
                                if(listener.hasSensor(sensorObject))                                
                                {
                                    listener.onSensorChangedLocked(sensorObject,
                                            values, timestamp, accuracy);
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
    }


    
    private class ListenerDelegate {
        private final SensorEventListener mSensorEventListener;
        private final ArrayList<Sensor> mSensorList = new ArrayList<Sensor>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.892 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        public SparseBooleanArray mSensors = new SparseBooleanArray();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.892 -0400", hash_original_field = "D49CA084FF0B2D41D2F98B7DD8A32487", hash_generated_field = "2B2A7DE406F5691574493DA0CEC8A36F")

        public SparseBooleanArray mFirstEvent = new SparseBooleanArray();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.893 -0400", hash_original_field = "6ABB3A8F98A871CC3DFDEACAC4C31FC8", hash_generated_field = "6E81EC263127AF97C52C45F2AB5DE4E7")

        public SparseIntArray mSensorAccuracies = new SparseIntArray();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.894 -0400", hash_original_method = "5F32B99D810AC43D96375634E0119DDB", hash_generated_method = "5CA6755A9119E88ECD4DC18FA43CC4AE")
          ListenerDelegate(SensorEventListener listener, Sensor sensor, Handler handler) {
            addTaint(handler.getTaint());
            addTaint(sensor.getTaint());
            mSensorEventListener = listener;
            Looper looper = (handler != null) ? handler.getLooper() : mMainLooper;
            mHandler = new Handler(looper) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.894 -0400", hash_original_method = "88AB5A19CD687EFCA1A0154186BFC370", hash_generated_method = "DC09DD5B9AD73C3F22556D657D384D41")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
                final SensorEvent t = (SensorEvent)msg.obj;
                final int handle = t.sensor.getHandle();
switch(t.sensor.getType()){
                case Sensor.TYPE_MAGNETIC_FIELD:
                case Sensor.TYPE_ORIENTATION:
                final int accuracy = mSensorAccuracies.get(handle);
                if((t.accuracy >= 0) && (accuracy != t.accuracy))                
                {
                    mSensorAccuracies.put(handle, t.accuracy);
                    mSensorEventListener.onAccuracyChanged(t.sensor, t.accuracy);
                } //End block
                break;
                default:
                if(mFirstEvent.get(handle) == false)                
                {
                    mFirstEvent.put(handle, true);
                    mSensorEventListener.onAccuracyChanged(
                                        t.sensor, SENSOR_STATUS_ACCURACY_HIGH);
                } //End block
                break;
}                mSensorEventListener.onSensorChanged(t);
                sPool.returnToPool(t);
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
};
            addSensor(sensor);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        Object getListener() {
            return mSensorEventListener;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.895 -0400", hash_original_method = "B2FBA8302C1585AE96282F4E3DA295C6", hash_generated_method = "8CFE2C7630E00AC9D8BAA42DABC37F85")
         void addSensor(Sensor sensor) {
            addTaint(sensor.getTaint());
            mSensors.put(sensor.getHandle(), true);
            mSensorList.add(sensor);
            // ---------- Original Method ----------
            //mSensors.put(sensor.getHandle(), true);
            //mSensorList.add(sensor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.895 -0400", hash_original_method = "262A581E44AC35F2D9F50EC370F0EA9A", hash_generated_method = "A043EF083863D75236AB6D2E2E65C367")
         int removeSensor(Sensor sensor) {
            addTaint(sensor.getTaint());
            mSensors.delete(sensor.getHandle());
            mSensorList.remove(sensor);
            int varA5267D1FA8D70D91E0214E7F519D9226_574770562 = (mSensors.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020907578 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020907578;
            // ---------- Original Method ----------
            //mSensors.delete(sensor.getHandle());
            //mSensorList.remove(sensor);
            //return mSensors.size();
        }

        
        boolean hasSensor(Sensor sensor) {
            return mSensors.get(sensor.getHandle());
        }

        
        List<Sensor> getSensors() {
            return mSensorList;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.896 -0400", hash_original_method = "16733F3375BBFC31BBB88791653112DA", hash_generated_method = "B8F9BC1B521CC807677E52177DA7B0BA")
         void onSensorChangedLocked(Sensor sensor, float[] values, long[] timestamp, int accuracy) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(accuracy);
            addTaint(timestamp[0]);
            addTaint(values[0]);
            addTaint(sensor.getTaint());
            SensorEvent t = sPool.getFromPool();
            final float[] v = t.values;
            v[0] = values[0];
            v[1] = values[1];
            v[2] = values[2];
            t.timestamp = timestamp[0];
            t.accuracy = accuracy;
            t.sensor = sensor;
            Message msg = Message.obtain();
            msg.what = 0;
            msg.obj = t;
            mHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //SensorEvent t = sPool.getFromPool();
            //final float[] v = t.values;
            //v[0] = values[0];
            //v[1] = values[1];
            //v[2] = values[2];
            //t.timestamp = timestamp[0];
            //t.accuracy = accuracy;
            //t.sensor = sensor;
            //Message msg = Message.obtain();
            //msg.what = 0;
            //msg.obj = t;
            //mHandler.sendMessage(msg);
        }

        
        // orphaned legacy method
        private ListenerDelegate() {
			mSensorEventListener = null;
		}
        
    }


    
    private class LegacyListener implements SensorEventListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.896 -0400", hash_original_field = "E47F25F3490FA8219470F5E99B2E5EF7", hash_generated_field = "B920C0767E790BC8A809EAECA2930561")

        private float mValues[] = new float[6];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.896 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "C800818392D79FD320EB62250F8EBEC5")

        @SuppressWarnings("deprecation") private SensorListener mTarget;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.896 -0400", hash_original_field = "5931991606D6B2006CC80ECD9383A5A0", hash_generated_field = "56793FD343ADA798CA50C026B1054688")

        private int mSensors;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.896 -0400", hash_original_field = "87BACA3CFC02AF2CDD58C8C0A54C9480", hash_generated_field = "7423027F5055567C2CEE13EBCD7D43EF")

        private final LmsFilter mYawfilter = new LmsFilter();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.897 -0400", hash_original_method = "A655EEB442CA31096C7FBEA03DE93B9D", hash_generated_method = "CBB5CEA1870353CD7AEAFC08ACA9FF7B")
        @SuppressWarnings("deprecation")
          LegacyListener(SensorListener target) {
            mTarget = target;
            mSensors = 0;
            // ---------- Original Method ----------
            //mTarget = target;
            //mSensors = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.897 -0400", hash_original_method = "4097E1683A40A6DEAB5492A2296E3879", hash_generated_method = "8131930ADF7BA919DC4A2597B2FC2264")
         void registerSensor(int legacyType) {
            //DSFIXME: CODE0010: Possible callback registration function detected
            mSensors |= legacyType;
            // ---------- Original Method ----------
            //mSensors |= legacyType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.898 -0400", hash_original_method = "737F8C4556D577A83A29D9000B85627C", hash_generated_method = "0B92831132C386092318B786FE96B22F")
         boolean unregisterSensor(int legacyType) {
            mSensors &= ~legacyType;
            int mask = SENSOR_ORIENTATION|SENSOR_ORIENTATION_RAW;
            if(((legacyType&mask)!=0) && ((mSensors&mask)!=0))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1988163760 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1782016987 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1782016987;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1138031768 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513358146 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_513358146;
            // ---------- Original Method ----------
            //mSensors &= ~legacyType;
            //int mask = SENSOR_ORIENTATION|SENSOR_ORIENTATION_RAW;
            //if (((legacyType&mask)!=0) && ((mSensors&mask)!=0)) {
                //return false;
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.899 -0400", hash_original_method = "E64F8429635EF9F3222DE4609CE00D63", hash_generated_method = "476C5B84E62E075DBB0D5D7C41A911A5")
        @SuppressWarnings("deprecation")
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(accuracy);
            addTaint(sensor.getTaint());
            try 
            {
                mTarget.onAccuracyChanged(sensor.getLegacyType(), accuracy);
            } //End block
            catch (AbstractMethodError e)
            {
            } //End block
            // ---------- Original Method ----------
            //try {
                //mTarget.onAccuracyChanged(sensor.getLegacyType(), accuracy);
            //} catch (AbstractMethodError e) {
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.900 -0400", hash_original_method = "7B74886508DCBDDEB63A3DDB570295F3", hash_generated_method = "439E239BBB2F9E86621BEB68FCFFA0DA")
        @SuppressWarnings("deprecation")
        public void onSensorChanged(SensorEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            final float v[] = mValues;
            v[0] = event.values[0];
            v[1] = event.values[1];
            v[2] = event.values[2];
            int legacyType = event.sensor.getLegacyType();
            mapSensorDataToWindow(legacyType, v, SensorManager.getRotation());
            if(event.sensor.getType() == Sensor.TYPE_ORIENTATION)            
            {
                if((mSensors & SENSOR_ORIENTATION_RAW)!=0)                
                {
                    mTarget.onSensorChanged(SENSOR_ORIENTATION_RAW, v);
                } //End block
                if((mSensors & SENSOR_ORIENTATION)!=0)                
                {
                    v[0] = mYawfilter.filter(event.timestamp, v[0]);
                    mTarget.onSensorChanged(SENSOR_ORIENTATION, v);
                } //End block
            } //End block
            else
            {
                mTarget.onSensorChanged(legacyType, v);
            } //End block
            // ---------- Original Method ----------
            //final float v[] = mValues;
            //v[0] = event.values[0];
            //v[1] = event.values[1];
            //v[2] = event.values[2];
            //int legacyType = event.sensor.getLegacyType();
            //mapSensorDataToWindow(legacyType, v, SensorManager.getRotation());
            //if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
                //if ((mSensors & SENSOR_ORIENTATION_RAW)!=0) {
                    //mTarget.onSensorChanged(SENSOR_ORIENTATION_RAW, v);
                //}
                //if ((mSensors & SENSOR_ORIENTATION)!=0) {
                    //v[0] = mYawfilter.filter(event.timestamp, v[0]);
                    //mTarget.onSensorChanged(SENSOR_ORIENTATION, v);
                //}
            //} else {
                //mTarget.onSensorChanged(legacyType, v);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.901 -0400", hash_original_method = "7A14D827894C3DC6FC1EC81B36F33A0A", hash_generated_method = "4C265B1CB28A54021A32BEA4EF697D14")
        private void mapSensorDataToWindow(int sensor,
                float[] values, int orientation) {
            addTaint(orientation);
            addTaint(values[0]);
            addTaint(sensor);
            float x = values[0];
            float y = values[1];
            float z = values[2];
switch(sensor){
            case SensorManager.SENSOR_ORIENTATION:
            case SensorManager.SENSOR_ORIENTATION_RAW:
            z = -z;
            break;
            case SensorManager.SENSOR_ACCELEROMETER:
            x = -x;
            y = -y;
            z = -z;
            break;
            case SensorManager.SENSOR_MAGNETIC_FIELD:
            x = -x;
            y = -y;
            break;
}            values[0] = x;
            values[1] = y;
            values[2] = z;
            values[3] = x;
            values[4] = y;
            values[5] = z;
            if((orientation & Surface.ROTATION_90) != 0)            
            {
switch(sensor){
                case SENSOR_ACCELEROMETER:
                case SENSOR_MAGNETIC_FIELD:
                values[0] =-y;
                values[1] = x;
                values[2] = z;
                break;
                case SENSOR_ORIENTATION:
                case SENSOR_ORIENTATION_RAW:
                values[0] = x + ((x < 270) ? 90 : -270);
                values[1] = z;
                values[2] = y;
                break;
}
            } //End block
            if((orientation & Surface.ROTATION_180) != 0)            
            {
                x = values[0];
                y = values[1];
                z = values[2];
switch(sensor){
                case SENSOR_ACCELEROMETER:
                case SENSOR_MAGNETIC_FIELD:
                values[0] =-x;
                values[1] =-y;
                values[2] = z;
                break;
                case SENSOR_ORIENTATION:
                case SENSOR_ORIENTATION_RAW:
                values[0] = (x >= 180) ? (x - 180) : (x + 180);
                values[1] =-y;
                values[2] =-z;
                break;
}
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class LmsFilter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.901 -0400", hash_original_field = "48D0529DA1E5C381F063F44A0FD31829", hash_generated_field = "C71ED6AA46070A985BB77E25625E8D40")

        private float mV[] = new float[COUNT*2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.902 -0400", hash_original_field = "AF42DE60EDB9AFF44C9547CF14F97D4F", hash_generated_field = "454D11A3BEF77C99F353661B016C1D43")

        private float mT[] = new float[COUNT*2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.902 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.902 -0400", hash_original_method = "E02C377CCDCA56F06C1373683AAA5F27", hash_generated_method = "45D134E9ACF2C36E99725407618FA8B3")
        public  LmsFilter() {
            mIndex = COUNT;
            // ---------- Original Method ----------
            //mIndex = COUNT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.905 -0400", hash_original_method = "EF62ACDA1EDD9BA52B9A6B99F58CD8F6", hash_generated_method = "0CD321FCA8BC456B16F3E4CC3D379FA9")
        public float filter(long time, float in) {
            addTaint(in);
            addTaint(time);
            float v = in;
            final float ns = 1.0f / 1000000000.0f;
            final float t = time*ns;
            float v1 = mV[mIndex];
            if((v-v1) > 180)            
            {
                v -= 360;
            } //End block
            else
            if((v1-v) > 180)            
            {
                v += 360;
            } //End block
            mIndex++;
            if(mIndex >= COUNT*2)            
            mIndex = COUNT;
            mV[mIndex] = v;
            mT[mIndex] = t;
            mV[mIndex-COUNT] = v;
            mT[mIndex-COUNT] = t;
            float A;
            float B;
            float C;
            float D;
            float E;
            float a;
            float b;
            int i;
            A = B = C = D = E = 0;
for(i=0;i<COUNT-1;i++)
            {
                final int j = mIndex - 1 - i;
                final float Z = mV[j];
                final float T = 0.5f*(mT[j] + mT[j+1]) - t;
                float dT = mT[j] - mT[j+1];
                dT *= dT;
                A += Z*dT;
                B += T*(T*dT);
                C +=   (T*dT);
                D += Z*(T*dT);
                E += dT;
            } //End block
            b = (A*B + C*D) / (E*B + C*C);
            a = (E*b - A) / C;
            float f = b + PREDICTION_TIME*a;
            f *= (1.0f / 360.0f);
            if(((f>=0)?f:-f) >= 0.5f)            
            f = f - (float)Math.ceil(f + 0.5f) + 1.0f;
            if(f < 0)            
            f += 1.0f;
            f *= 360.0f;
            float var8FA14CDD754F91CC6554C9E71929CCE7_1992075070 = (f);
                        float var546ADE640B6EDFBC8A086EF31347E768_984742095 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_984742095;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.905 -0400", hash_original_field = "103CAA5BDBCC664D1E126B48D7949988", hash_generated_field = "289D3DCA2BB33F6334CDC99A63CB75B6")

        private static final int SENSORS_RATE_MS = 20;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "508B8C3655D9B752E1E6E227FB1BD041", hash_generated_field = "C613FE5DFDEE80ED430FEA7D721F3ABA")

        private static final int COUNT = 12;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "DCFF860EF95AAE60BF5F2096ED6EA6F0", hash_generated_field = "49D85FA4CF718BD5A4B3FDA8A3714C4E")

        private static final float PREDICTION_RATIO = 1.0f/3.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "953A86377A023C22BC3D7A9DBF476182", hash_generated_field = "81506F4C7994EEC27376AE73597A30EB")

        private static final float PREDICTION_TIME = (SENSORS_RATE_MS*COUNT/1000.0f)*PREDICTION_RATIO;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "FE6D8EEFB1A97E20A0E0DE90CC29E1F5", hash_generated_field = "D46DC572C2EFA3216DE38441F1A6F061")

    private static final String TAG = "SensorManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "CEFCF8ADB492DA36D048C615C751DBEE", hash_generated_field = "FCB5327581E18710CDCDFFB10CC66C83")

    private static final float[] mTempMatrix = new float[16];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "18682A395AE180286E34404DA8CCAB5D", hash_generated_field = "2C25A8F3B344BC2280502D7D6177CA06")

    @Deprecated
    public static final int SENSOR_ORIENTATION = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "8E3B93BB271B20FDCB0FA84BC5D7BF6E", hash_generated_field = "19414CED4FA72491B85F493F8AFF63B8")

    @Deprecated
    public static final int SENSOR_ACCELEROMETER = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "0F63345BC9BC93E62E62636F88AD2830", hash_generated_field = "3C2362FF7C126F067910E2BCCF1EDCD7")

    @Deprecated
    public static final int SENSOR_TEMPERATURE = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "A38724D702B3418F0023DCA1B1C1C70C", hash_generated_field = "9238F3C8D08D015AF0853B89AD78AFB6")

    @Deprecated
    public static final int SENSOR_MAGNETIC_FIELD = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "FAC2E3815BF306FA6F6DECCB32DE15A7", hash_generated_field = "0E321C5D1567C957A91304082C18D404")

    @Deprecated
    public static final int SENSOR_LIGHT = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "1DF0F829205C973C81D0743591712D7F", hash_generated_field = "98A64C2F6E579F9CD66D58F1C82DC056")

    @Deprecated
    public static final int SENSOR_PROXIMITY = 1 << 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.906 -0400", hash_original_field = "3A9FCCF164EDCC310950F453BAC936CD", hash_generated_field = "EE36B6630EA8165AC8F0F495DB61178C")

    @Deprecated
    public static final int SENSOR_TRICORDER = 1 << 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "6EC0F682F138CD6C531DDE4C1F16368C", hash_generated_field = "37F85BDAD647215D01EBBDFF4549DA57")

    @Deprecated
    public static final int SENSOR_ORIENTATION_RAW = 1 << 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "1EB67756B1DED6009AF8DB26B11288B5", hash_generated_field = "4CFF3B4F2A25C8651ED8E70AA89C2F52")

    @Deprecated
    public static final int SENSOR_ALL = 0x7F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "EEF320C94A673C43A234108609BEE616", hash_generated_field = "02BF52AB62B9B0271AC3030C44199DCA")

    @Deprecated
    public static final int SENSOR_MIN = SENSOR_ORIENTATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "E11A45BF27295B5D771F2417E376322C", hash_generated_field = "48907DD0332337C7F41FBC22BAD37F2C")

    @Deprecated
    public static final int SENSOR_MAX = ((SENSOR_ALL + 1)>>1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "513046CFD455157D525B490BA8298EA4", hash_generated_field = "A9AC5D766E2244D46793610E9BC9AF74")

    @Deprecated
    public static final int DATA_X = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "BBBC6C0047E11615CA65F66610BAAF5A", hash_generated_field = "76993CCDC259CB3593B45E118CC14227")

    @Deprecated
    public static final int DATA_Y = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "13E91B7FC776FE1F7B91832781508367", hash_generated_field = "B1BA023EF03C57726C71339FD98E8727")

    @Deprecated
    public static final int DATA_Z = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "CD19E212A3F00F5997F82D5177A95A1E", hash_generated_field = "24BE7FB5178190074444287EE659C8D4")

    @Deprecated
    public static final int RAW_DATA_INDEX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "8F77C07EB606698277BF30DCECA17978", hash_generated_field = "A2C6FB458B3AEA3A9E8F6B34EBB801A3")

    @Deprecated
    public static final int RAW_DATA_X = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "B4CE3E066B52283D533D54E5B9E6C8AA", hash_generated_field = "31BD80CB85213EDFB1B6363D6C309F09")

    @Deprecated
    public static final int RAW_DATA_Y = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "6DB04C96CB90846AA80A218196BB469B", hash_generated_field = "A4105335D9B0E187F4624C5923397873")

    @Deprecated
    public static final int RAW_DATA_Z = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "8E7FC78C4CB226C3B2AEC06E521953C9", hash_generated_field = "E677BD9FA81EE77A42D6C83D3FCA7A4B")

    public static final float STANDARD_GRAVITY = 9.80665f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.907 -0400", hash_original_field = "978574D95B5704DE3CDADEB471A1F2A5", hash_generated_field = "7DFB37D1E3A2A36A3E756E4105637B67")

    public static final float GRAVITY_SUN             = 275.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "D56A80F65C3616183559C8A556F28181", hash_generated_field = "49E30115EE56C7C9C31EF2637CCCDFC5")

    public static final float GRAVITY_MERCURY         = 3.70f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "FA8C605A3B3E6474B793B07E5347CF28", hash_generated_field = "AB9A7548046B9BF51CB962118DCA6151")

    public static final float GRAVITY_VENUS           = 8.87f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "300AECE8BED6A87CFDE2FEEEEE78B685", hash_generated_field = "6F33579BCEBFC3579E1DD27C36753C71")

    public static final float GRAVITY_EARTH           = 9.80665f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "C41D2AD32F9D5AAD7E3D63A73BF00E3E", hash_generated_field = "1FE0A959605FC1FAF77D69C67BFDC3BE")

    public static final float GRAVITY_MOON            = 1.6f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "4A68236B756283B21D51DCD3DF13DBA9", hash_generated_field = "2B17FA2A3C55F1F38A6124E59337C061")

    public static final float GRAVITY_MARS            = 3.71f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "09B7AEDEE8A9B4EC6471C8C0C31AE2F8", hash_generated_field = "73FD09FCDD1A7BCCC2B000AD68B58807")

    public static final float GRAVITY_JUPITER         = 23.12f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "4AD677438B8228A7AB8F14E60D8B7777", hash_generated_field = "8D4E50FE00223ED202335CC88DA303A3")

    public static final float GRAVITY_SATURN          = 8.96f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "19B49C8126D15D9476A95929BE21729C", hash_generated_field = "12102A9D8CFFE04151CFD7073BB79258")

    public static final float GRAVITY_URANUS          = 8.69f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "62E84C6681FAC2AE485CD54DF3883E64", hash_generated_field = "E673030DEC6B6CA64CDACFFE50927C22")

    public static final float GRAVITY_NEPTUNE         = 11.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "99A6E104BDB4734AF33480ABBF6B88A4", hash_generated_field = "3BB701AC05D98480880F7FCAE6D3014C")

    public static final float GRAVITY_PLUTO           = 0.6f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "7641A04626086870E11B1ECD0238FBCE", hash_generated_field = "03051E3DC5786D7CF1D464F068BD1BB4")

    public static final float GRAVITY_DEATH_STAR_I    = 0.000000353036145f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "D682956E892E216D8F9D377F7608B8A5", hash_generated_field = "E52FA1DC3A5B4CFE9963B2BDDA041697")

    public static final float GRAVITY_THE_ISLAND      = 4.815162342f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "DF37DD5EABEAD2F84BE8A21F6FEAAB19", hash_generated_field = "1F1D70384C09D59F42D38B16133845CE")

    public static final float MAGNETIC_FIELD_EARTH_MAX = 60.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "CA3FA688B2874F63C82594B89641012E", hash_generated_field = "68DAB024C15BA1D077DE1B93007B509C")

    public static final float MAGNETIC_FIELD_EARTH_MIN = 30.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.908 -0400", hash_original_field = "D2679A50BE3935EA63A912BB32859DB1", hash_generated_field = "60B956375CABAA5A38520D232A65B625")

    public static final float PRESSURE_STANDARD_ATMOSPHERE = 1013.25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "79B6CBC73FA3AF41FACA66B1AD239F47", hash_generated_field = "605D89F0BFF38A6E37EBEB6F08AEDF44")

    public static final float LIGHT_SUNLIGHT_MAX = 120000.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "1329487F36B9EC0AFDF19494DAB23BA5", hash_generated_field = "9A674B69EB6FB611C967FFBBDE8223D9")

    public static final float LIGHT_SUNLIGHT     = 110000.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "A2C2A872347AA22764717B3C341B1E97", hash_generated_field = "6BB4816214FD8859745E9C80F7494836")

    public static final float LIGHT_SHADE        = 20000.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "5F7E24FA2F17D92B5B76C73E7B3FD856", hash_generated_field = "C5A4E7A988335CAA4F0F517EE5EF0D37")

    public static final float LIGHT_OVERCAST     = 10000.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "EF3A2A2D045C3CD9B817D3FE740E0028", hash_generated_field = "F5A221C1278C6E88B02A299F37E4C30A")

    public static final float LIGHT_SUNRISE      = 400.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "504A30FBA5AA8F3CC1203FD571F34432", hash_generated_field = "B6A4154BC1F854EDF3EEDB64CA76D406")

    public static final float LIGHT_CLOUDY       = 100.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "51A80DF03506A302C387D22BE67D5CE6", hash_generated_field = "547BE1973329E70E3558646E76316249")

    public static final float LIGHT_FULLMOON     = 0.25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "5FC13C707507E2EBE82AC2CC6A294BC0", hash_generated_field = "AA692E072FB30E0F7EB38E4F82C0839E")

    public static final float LIGHT_NO_MOON      = 0.001f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "BD18A6202C5C272850B17B327F1A90A2", hash_generated_field = "9E8D453CFCBB64FDBAC4894075F651FA")

    public static final int SENSOR_DELAY_FASTEST = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "CD114FCD28CA40D53805799AC25065D9", hash_generated_field = "B1EA2DD8A518D8B936090226F48D8CFA")

    public static final int SENSOR_DELAY_GAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "A5C157721933C9520D4EEB1DE32DA6DE", hash_generated_field = "34CB384FEDB81178485444F2DF81E938")

    public static final int SENSOR_DELAY_UI = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "B68520CCCDABA2C0E4D44443106473E2", hash_generated_field = "ACB21A0A585352CC21D7D912BD549396")

    public static final int SENSOR_DELAY_NORMAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "53CA3D890B4BE5D284732B24203C3802", hash_generated_field = "793474660C061F4E91B691854E0C0210")

    public static final int SENSOR_STATUS_UNRELIABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "64379DE9C68E76F0251796861167BE6A", hash_generated_field = "3F2964151ACC9B0BA71471A94E89BA79")

    public static final int SENSOR_STATUS_ACCURACY_LOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.909 -0400", hash_original_field = "9D66606D0DB115A7008AD81596C5F8D9", hash_generated_field = "8281325EE294F56AC1F2FD20E0D435FD")

    public static final int SENSOR_STATUS_ACCURACY_MEDIUM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.910 -0400", hash_original_field = "0421BABEDF4DD6736C089369F5F1E37C", hash_generated_field = "1631007B616B86584B93182CCFA5F767")

    public static final int SENSOR_STATUS_ACCURACY_HIGH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.910 -0400", hash_original_field = "61898D2E79EAC458110D149AE3383F10", hash_generated_field = "6D9F2A6D7916944793A0E02EE9DAC11A")

    public static final int AXIS_X = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.910 -0400", hash_original_field = "5911E0BE3B6D7585D28EE81F64C78D86", hash_generated_field = "C26BE798D392A2035397D2CCF263856A")

    public static final int AXIS_Y = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.910 -0400", hash_original_field = "B565FB1D8E0C65566F61B2B5EDF6DFCE", hash_generated_field = "99DB4EB9E499DC8FD3F2A6667C2A655F")

    public static final int AXIS_Z = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.910 -0400", hash_original_field = "168EA56FAB59195DEDE7E86CE0729275", hash_generated_field = "3F3B6B92E6A1B2949A1EA7FCEDD211D6")

    public static final int AXIS_MINUS_X = AXIS_X | 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.910 -0400", hash_original_field = "272F0E95C20AE9886F5458759073F550", hash_generated_field = "256747ACA3A6B7781B5CC10FE1504A89")

    public static final int AXIS_MINUS_Y = AXIS_Y | 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.910 -0400", hash_original_field = "001CC8A4B22A0DB399377C9DC9088370", hash_generated_field = "6A8882357B156DD35296D89B47D4D0E6")

    public static final int AXIS_MINUS_Z = AXIS_Z | 0x80;
    private static final int SENSOR_DISABLE = -1;
    private static boolean sSensorModuleInitialized = false;
    private static ArrayList<Sensor> sFullSensorsList = new ArrayList<Sensor>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:36.910 -0400", hash_original_field = "E6334D220E08189D43EACB2F632A979B", hash_generated_field = "25CA1152319FF4B5C0D7E7F8076D16ED")

    private static SparseArray<List<Sensor>> sSensorListByType = new SparseArray<List<Sensor>>();
    private static IWindowManager sWindowManager;
    private static int sRotation = Surface.ROTATION_0;
    private static SensorThread sSensorThread;
    private static int sQueue;
    static SparseArray<Sensor> sHandleToSensor = new SparseArray<Sensor>();
    static final ArrayList<ListenerDelegate> sListeners =
			new ArrayList<ListenerDelegate>();
    private static SensorEventPool sPool;
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
	public Sensor getDefaultSensor(int i) {
		return new Sensor(i);
	}
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
	public SensorManager() {
	}
    
}

