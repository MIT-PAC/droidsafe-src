package android.hardware;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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

public class SensorManager {
    private static final String TAG = "SensorManager";
    private static final float[] mTempMatrix = new float[16];
    @Deprecated
    public static final int SENSOR_ORIENTATION = 1 << 0;
    @Deprecated
    public static final int SENSOR_ACCELEROMETER = 1 << 1;
    @Deprecated
    public static final int SENSOR_TEMPERATURE = 1 << 2;
    @Deprecated
    public static final int SENSOR_MAGNETIC_FIELD = 1 << 3;
    @Deprecated
    public static final int SENSOR_LIGHT = 1 << 4;
    @Deprecated
    public static final int SENSOR_PROXIMITY = 1 << 5;
    @Deprecated
    public static final int SENSOR_TRICORDER = 1 << 6;
    @Deprecated
    public static final int SENSOR_ORIENTATION_RAW = 1 << 7;
    @Deprecated
    public static final int SENSOR_ALL = 0x7F;
    @Deprecated
    public static final int SENSOR_MIN = SENSOR_ORIENTATION;
    @Deprecated
    public static final int SENSOR_MAX = ((SENSOR_ALL + 1)>>1);
    @Deprecated
    public static final int DATA_X = 0;
    @Deprecated
    public static final int DATA_Y = 1;
    @Deprecated
    public static final int DATA_Z = 2;
    @Deprecated
    public static final int RAW_DATA_INDEX = 3;
    @Deprecated
    public static final int RAW_DATA_X = 3;
    @Deprecated
    public static final int RAW_DATA_Y = 4;
    @Deprecated
    public static final int RAW_DATA_Z = 5;
    public static final float STANDARD_GRAVITY = 9.80665f;
    public static final float GRAVITY_SUN             = 275.0f;
    public static final float GRAVITY_MERCURY         = 3.70f;
    public static final float GRAVITY_VENUS           = 8.87f;
    public static final float GRAVITY_EARTH           = 9.80665f;
    public static final float GRAVITY_MOON            = 1.6f;
    public static final float GRAVITY_MARS            = 3.71f;
    public static final float GRAVITY_JUPITER         = 23.12f;
    public static final float GRAVITY_SATURN          = 8.96f;
    public static final float GRAVITY_URANUS          = 8.69f;
    public static final float GRAVITY_NEPTUNE         = 11.0f;
    public static final float GRAVITY_PLUTO           = 0.6f;
    public static final float GRAVITY_DEATH_STAR_I    = 0.000000353036145f;
    public static final float GRAVITY_THE_ISLAND      = 4.815162342f;
    public static final float MAGNETIC_FIELD_EARTH_MAX = 60.0f;
    public static final float MAGNETIC_FIELD_EARTH_MIN = 30.0f;
    public static final float PRESSURE_STANDARD_ATMOSPHERE = 1013.25f;
    public static final float LIGHT_SUNLIGHT_MAX = 120000.0f;
    public static final float LIGHT_SUNLIGHT     = 110000.0f;
    public static final float LIGHT_SHADE        = 20000.0f;
    public static final float LIGHT_OVERCAST     = 10000.0f;
    public static final float LIGHT_SUNRISE      = 400.0f;
    public static final float LIGHT_CLOUDY       = 100.0f;
    public static final float LIGHT_FULLMOON     = 0.25f;
    public static final float LIGHT_NO_MOON      = 0.001f;
    public static final int SENSOR_DELAY_FASTEST = 0;
    public static final int SENSOR_DELAY_GAME = 1;
    public static final int SENSOR_DELAY_UI = 2;
    public static final int SENSOR_DELAY_NORMAL = 3;
    public static final int SENSOR_STATUS_UNRELIABLE = 0;
    public static final int SENSOR_STATUS_ACCURACY_LOW = 1;
    public static final int SENSOR_STATUS_ACCURACY_MEDIUM = 2;
    public static final int SENSOR_STATUS_ACCURACY_HIGH = 3;
    public static final int AXIS_X = 1;
    public static final int AXIS_Y = 2;
    public static final int AXIS_Z = 3;
    public static final int AXIS_MINUS_X = AXIS_X | 0x80;
    public static final int AXIS_MINUS_Y = AXIS_Y | 0x80;
    public static final int AXIS_MINUS_Z = AXIS_Z | 0x80;
    Looper mMainLooper;
    @SuppressWarnings("deprecation")
    private HashMap<SensorListener, LegacyListener> mLegacyListenersMap =
        new HashMap<SensorListener, LegacyListener>();
    private static final int SENSOR_DISABLE = -1;
    private static boolean sSensorModuleInitialized = false;
    private static ArrayList<Sensor> sFullSensorsList = new ArrayList<Sensor>();
    private static SparseArray<List<Sensor>> sSensorListByType = new SparseArray<List<Sensor>>();
    private static IWindowManager sWindowManager;
    private static int sRotation = Surface.ROTATION_0;
    private static SensorThread sSensorThread;
    private static int sQueue;
    static SparseArray<Sensor> sHandleToSensor = new SparseArray<Sensor>();
    static final ArrayList<ListenerDelegate> sListeners =
        new ArrayList<ListenerDelegate>();
    private static SensorEventPool sPool;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.590 -0400", hash_original_method = "D89BA857D2DFC071EE5A857E0568AFCF", hash_generated_method = "E5525391F705ADCBA73222D5BE88CD5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SensorManager(Looper mainLooper) {
        dsTaint.addTaint(mainLooper.dsTaint);
        {
            {
                sSensorModuleInitialized = true;
                nativeClassInit();
                sWindowManager = IWindowManager.Stub.asInterface(
                        ServiceManager.getService("window"));
                {
                    try 
                    {
                        sRotation = sWindowManager.watchRotation(
                                new IRotationWatcher.Stub() {
                                    public void onRotationChanged(int rotation) {
                                        SensorManager.this.onRotationChanged(rotation);
                                    }
                                }
                        );
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
                sensors_module_init();
                final ArrayList<Sensor> fullList;
                fullList = sFullSensorsList;
                int i;
                i = 0;
                {
                    Sensor sensor;
                    sensor = new Sensor();
                    i = sensors_module_get_next_sensor(sensor, i);
                    {
                        sensor.setLegacyType(getLegacySensorType(sensor.getType()));
                        fullList.add(sensor);
                        sHandleToSensor.append(sensor.getHandle(), sensor);
                    } //End block
                } //End block
                sPool = new SensorEventPool( sFullSensorsList.size()*2 );
                sSensorThread = new SensorThread();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.591 -0400", hash_original_method = "F97F3FCBB2B92661C96383BC3925201E", hash_generated_method = "DE4625BBE620608A0C2F9BC7672503A1")
    @DSModeled(DSC.SAFE)
    private int getLegacySensorType(int type) {
        dsTaint.addTaint(type);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (type) {
            //case Sensor.TYPE_ACCELEROMETER:
                //return SENSOR_ACCELEROMETER;
            //case Sensor.TYPE_MAGNETIC_FIELD:
                //return SENSOR_MAGNETIC_FIELD;
            //case Sensor.TYPE_ORIENTATION:
                //return SENSOR_ORIENTATION_RAW;
            //case Sensor.TYPE_TEMPERATURE:
                //return SENSOR_TEMPERATURE;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.591 -0400", hash_original_method = "9387EF1577B9728CF6A87474164955A1", hash_generated_method = "F4BD62FBC843A0064FD9D1DD679D9583")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getSensors() {
        int result;
        result = 0;
        final ArrayList<Sensor> fullList;
        fullList = sFullSensorsList;
        {
            Iterator<Sensor> seatecAstronomy42 = fullList.iterator();
            seatecAstronomy42.hasNext();
            Sensor i = seatecAstronomy42.next();
            {
                {
                    Object var38AF2FBEBB9E1731747F2959C06CD9D2_1512204391 = (i.getType());
                    //Begin case Sensor.TYPE_ACCELEROMETER 
                    result |= SensorManager.SENSOR_ACCELEROMETER;
                    //End case Sensor.TYPE_ACCELEROMETER 
                    //Begin case Sensor.TYPE_MAGNETIC_FIELD 
                    result |= SensorManager.SENSOR_MAGNETIC_FIELD;
                    //End case Sensor.TYPE_MAGNETIC_FIELD 
                    //Begin case Sensor.TYPE_ORIENTATION 
                    result |= SensorManager.SENSOR_ORIENTATION |
                    SensorManager.SENSOR_ORIENTATION_RAW;
                    //End case Sensor.TYPE_ORIENTATION 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.591 -0400", hash_original_method = "D388F11CBE90143BC36FA3E001809013", hash_generated_method = "89C259621DBAF3DAF0197CBAB1850812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<Sensor> getSensorList(int type) {
        dsTaint.addTaint(type);
        List<Sensor> list;
        final ArrayList<Sensor> fullList;
        fullList = sFullSensorsList;
        {
            list = sSensorListByType.get(type);
            {
                {
                    list = fullList;
                } //End block
                {
                    list = new ArrayList<Sensor>();
                    {
                        Iterator<Sensor> seatecAstronomy42 = fullList.iterator();
                        seatecAstronomy42.hasNext();
                        Sensor i = seatecAstronomy42.next();
                        {
                            {
                                boolean var7614D0966578B0CB10CCAAD9D58C74AC_2034576894 = (i.getType() == type);
                                list.add(i);
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                list = Collections.unmodifiableList(list);
                sSensorListByType.append(type, list);
            } //End block
        } //End block
        return (List<Sensor>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.591 -0400", hash_original_method = "051BFE8F8271F52ABA0B8E99C6E74461", hash_generated_method = "464061C89F47BDE1C2F0571541C7D164")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Sensor getDefaultSensor(int type) {
        dsTaint.addTaint(type);
        List<Sensor> l;
        l = getSensorList(type);
        {
            boolean varC49566FBCD8AA9A9719A8EE0EBB7B543_518441684 = (l.isEmpty());
            Object varA410D3F0CB49AC67C751EA3F63C02956_307429537 = (l.get(0));
        } //End flattened ternary
        return (Sensor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //List<Sensor> l = getSensorList(type);
        //return l.isEmpty() ? null : l.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.591 -0400", hash_original_method = "CA10DA2A107C571495F28D1A1A335E4D", hash_generated_method = "BB663F531C65D8C3C8B16C8C8FD3F9D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean registerListener(SensorListener listener, int sensors) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(sensors);
        dsTaint.addTaint(listener.dsTaint);
        boolean var0BF2B61900138CF1C60B85B7842D08C3_1292169947 = (registerListener(listener, sensors, SENSOR_DELAY_NORMAL));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return registerListener(listener, sensors, SENSOR_DELAY_NORMAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.592 -0400", hash_original_method = "B7C7A7F6BC1EDB860C06401873DD1A46", hash_generated_method = "B5F4F780B75F2CBF90832FFB6C357496")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean registerListener(SensorListener listener, int sensors, int rate) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(sensors);
        dsTaint.addTaint(rate);
        dsTaint.addTaint(listener.dsTaint);
        boolean result;
        result = false;
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.592 -0400", hash_original_method = "2BFEE9499E6BC093763ECA6BB97D348E", hash_generated_method = "913302D41EDBC577E6DA0A758140BCC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    private boolean registerLegacyListener(int legacyType, int type,
            SensorListener listener, int sensors, int rate) {
        dsTaint.addTaint(sensors);
        dsTaint.addTaint(rate);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(legacyType);
        boolean result;
        result = false;
        {
            Sensor sensor;
            sensor = getDefaultSensor(type);
            {
                LegacyListener legacyListener;
                legacyListener = null;
                {
                    legacyListener = mLegacyListenersMap.get(listener);
                    {
                        legacyListener = new LegacyListener(listener);
                        mLegacyListenersMap.put(listener, legacyListener);
                    } //End block
                } //End block
                legacyListener.registerSensor(legacyType);
                result = registerListener(legacyListener, sensor, rate);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.592 -0400", hash_original_method = "08C00AEC5C2F4A8557AFE56DD5038FAA", hash_generated_method = "0BA10CB8BDD34BDBDDED6AB7D31F097C")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void unregisterListener(SensorListener listener, int sensors) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(sensors);
        dsTaint.addTaint(listener.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.593 -0400", hash_original_method = "9C431FA18D1D7C546E542BF96DE5A08A", hash_generated_method = "896C14259B05BCAFA0F605FBADB73F20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    private void unregisterLegacyListener(int legacyType, int type,
            SensorListener listener, int sensors) {
        dsTaint.addTaint(sensors);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(legacyType);
        LegacyListener legacyListener;
        legacyListener = null;
        {
            legacyListener = mLegacyListenersMap.get(listener);
        } //End block
        {
            {
                Sensor sensor;
                sensor = getDefaultSensor(type);
                {
                    {
                        boolean var99B715C543012D6D71309E3E94E937E5_113710625 = (legacyListener.unregisterSensor(legacyType));
                        {
                            unregisterListener(legacyListener, sensor);
                            {
                                boolean found;
                                found = false;
                                {
                                    Iterator<ListenerDelegate> seatecAstronomy42 = sListeners.iterator();
                                    seatecAstronomy42.hasNext();
                                    ListenerDelegate i = seatecAstronomy42.next();
                                    {
                                        {
                                            boolean var52DC0C35F59BFF0EE51A50C3EAAAEE0B_226037858 = (i.getListener() == legacyListener);
                                            {
                                                found = true;
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                                {
                                    {
                                        mLegacyListenersMap.remove(listener);
                                    } //End block
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.593 -0400", hash_original_method = "F024191DD75DA5578F802D33C834CE8F", hash_generated_method = "C8D4174B0BBFE03FCF1CF5F479AA788B")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void unregisterListener(SensorListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        unregisterListener(listener, SENSOR_ALL | SENSOR_ORIENTATION_RAW);
        // ---------- Original Method ----------
        //unregisterListener(listener, SENSOR_ALL | SENSOR_ORIENTATION_RAW);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.593 -0400", hash_original_method = "A245758148D9D81E2CADBC67CD903CC7", hash_generated_method = "84B9D9DB5223BBAAD48719813B26D922")
    @DSModeled(DSC.SAFE)
    public void unregisterListener(SensorEventListener listener, Sensor sensor) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(sensor.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        unregisterListener((Object)listener, sensor);
        // ---------- Original Method ----------
        //unregisterListener((Object)listener, sensor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.593 -0400", hash_original_method = "C9A0C02866BC64B5017A48A301526982", hash_generated_method = "F84228AC622697AC244FD6A7E6C2005F")
    @DSModeled(DSC.SAFE)
    public void unregisterListener(SensorEventListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        unregisterListener((Object)listener);
        // ---------- Original Method ----------
        //unregisterListener((Object)listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.593 -0400", hash_original_method = "EEA9FC3069A1CEC2680F553E722797E3", hash_generated_method = "68E04ECEB7891754C14711F332B1739A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(sensor.dsTaint);
        dsTaint.addTaint(rate);
        dsTaint.addTaint(listener.dsTaint);
        boolean varD3243FA077760CCBCBDDCB77D8EFCE42_1452021420 = (registerListener(listener, sensor, rate, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return registerListener(listener, sensor, rate, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.593 -0400", hash_original_method = "500C86ADE6AA4F4A0E12D1A653386772", hash_generated_method = "B8E33AF57A29FF8107FC9C38B9AB5B50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean enableSensorLocked(Sensor sensor, int delay) {
        dsTaint.addTaint(sensor.dsTaint);
        dsTaint.addTaint(delay);
        boolean result;
        result = false;
        {
            Iterator<ListenerDelegate> seatecAstronomy42 = sListeners.iterator();
            seatecAstronomy42.hasNext();
            ListenerDelegate i = seatecAstronomy42.next();
            {
                {
                    boolean varD5C4AA45C80B3832F93AE2792FBE9608_588243928 = (i.hasSensor(sensor));
                    {
                        String name;
                        name = sensor.getName();
                        int handle;
                        handle = sensor.getHandle();
                        result = sensors_enable_sensor(sQueue, name, handle, delay);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.593 -0400", hash_original_method = "4F96C2E0F6181D20ADA1404B28BE0C37", hash_generated_method = "1C2AF8C848C51940E8ED72108D75FDCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean disableSensorLocked(Sensor sensor) {
        dsTaint.addTaint(sensor.dsTaint);
        {
            Iterator<ListenerDelegate> seatecAstronomy42 = sListeners.iterator();
            seatecAstronomy42.hasNext();
            ListenerDelegate i = seatecAstronomy42.next();
            {
                {
                    boolean varD5C4AA45C80B3832F93AE2792FBE9608_9469343 = (i.hasSensor(sensor));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String name;
        name = sensor.getName();
        int handle;
        handle = sensor.getHandle();
        boolean var240274763501E0777166463484969D38_706055880 = (sensors_enable_sensor(sQueue, name, handle, SENSOR_DISABLE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (ListenerDelegate i : sListeners) {
            //if (i.hasSensor(sensor)) {
                //return true;
            //}
        //}
        //String name = sensor.getName();
        //int handle = sensor.getHandle();
        //return sensors_enable_sensor(sQueue, name, handle, SENSOR_DISABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.594 -0400", hash_original_method = "55FB0E0786574FCA30E9C20955CE2F64", hash_generated_method = "330B4499A423F8CA9D66A848410FB6E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate,
            Handler handler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(sensor.dsTaint);
        dsTaint.addTaint(rate);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        boolean result;
        result = true;
        int delay;
        delay = -1;
        //Begin case SENSOR_DELAY_FASTEST 
        delay = 0;
        //End case SENSOR_DELAY_FASTEST 
        //Begin case SENSOR_DELAY_GAME 
        delay = 20000;
        //End case SENSOR_DELAY_GAME 
        //Begin case SENSOR_DELAY_UI 
        delay = 66667;
        //End case SENSOR_DELAY_UI 
        //Begin case SENSOR_DELAY_NORMAL 
        delay = 200000;
        //End case SENSOR_DELAY_NORMAL 
        //Begin case default 
        delay = rate;
        //End case default 
        {
            ListenerDelegate l;
            l = null;
            {
                Iterator<ListenerDelegate> seatecAstronomy42 = sListeners.iterator();
                seatecAstronomy42.hasNext();
                ListenerDelegate i = seatecAstronomy42.next();
                {
                    {
                        boolean var0BBE1CA9C28FD254D7916A3A201A9C57_1074117450 = (i.getListener() == listener);
                        {
                            l = i;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                l = new ListenerDelegate(listener, sensor, handler);
                sListeners.add(l);
                {
                    boolean varDA117198B3E757541D0D1AC89ACADD7C_890483434 = (!sListeners.isEmpty());
                    {
                        {
                            boolean varC6EAD9B6F4CC7D99EBE9EBC801163308_320568347 = (sSensorThread.startLocked());
                            {
                                {
                                    boolean var7C2493CCA8EE6B8D8E012534AE552B3D_1414000212 = (!enableSensorLocked(sensor, delay));
                                    {
                                        sListeners.remove(l);
                                        result = false;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                sListeners.remove(l);
                                result = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        result = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                l.addSensor(sensor);
                {
                    boolean var31C2766AC2E2FB0586CAE28FC9E23C04_1249593919 = (!enableSensorLocked(sensor, delay));
                    {
                        l.removeSensor(sensor);
                        result = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.594 -0400", hash_original_method = "1441CD23D4F492BD7877A59C29F56827", hash_generated_method = "29CE01AB7C0ADA386AB110DA3C0EF07B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unregisterListener(Object listener, Sensor sensor) {
        dsTaint.addTaint(sensor.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        {
            final int size;
            size = sListeners.size();
            {
                int i;
                i = 0;
                {
                    ListenerDelegate l;
                    l = sListeners.get(i);
                    {
                        boolean var59EE92861E91E921B93BC86C1074CE98_1167522257 = (l.getListener() == listener);
                        {
                            {
                                boolean var254510C2CC6D8FB1AABA470DAF28ED32_1814334255 = (l.removeSensor(sensor) == 0);
                                {
                                    sListeners.remove(i);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.594 -0400", hash_original_method = "63ADCF337C7E30C1A2DEC34D1892CFB3", hash_generated_method = "2EF8F6393EC321D96E3F854499FBBE2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unregisterListener(Object listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            final int size;
            size = sListeners.size();
            {
                int i;
                i = 0;
                {
                    ListenerDelegate l;
                    l = sListeners.get(i);
                    {
                        boolean var59EE92861E91E921B93BC86C1074CE98_2039441862 = (l.getListener() == listener);
                        {
                            sListeners.remove(i);
                            {
                                Iterator<Sensor> seatecAstronomy42 = l.getSensors().iterator();
                                seatecAstronomy42.hasNext();
                                Sensor sensor = seatecAstronomy42.next();
                                {
                                    disableSensorLocked(sensor);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (listener == null) {
            //return;
        //}
        //synchronized (sListeners) {
            //final int size = sListeners.size();
            //for (int i=0 ; i<size ; i++) {
                //ListenerDelegate l = sListeners.get(i);
                //if (l.getListener() == listener) {
                    //sListeners.remove(i);
                    //for (Sensor sensor : l.getSensors()) {
                        //disableSensorLocked(sensor);
                    //}
                    //break;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.595 -0400", hash_original_method = "80FFBDA32F1CA6FB68C3B24B9C01CA42", hash_generated_method = "54C26D4452177E7CC8F62129048CADB3")
    public static boolean getRotationMatrix(float[] R, float[] I,
            float[] gravity, float[] geomagnetic) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.595 -0400", hash_original_method = "FC0D372BF97A5B9BCD6915691825C261", hash_generated_method = "D5A70E08C36B24C4FBB1CE4753C03A9A")
    public static float getInclination(float[] I) {
        if (I.length == 9) {
            return (float)Math.atan2(I[5], I[4]);
        } else {
            return (float)Math.atan2(I[6], I[5]);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.595 -0400", hash_original_method = "FE2484DC0236D6664EA6E4EA310B2D70", hash_generated_method = "4FAEA5AF9D191590AB12FDAE936CECB1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.595 -0400", hash_original_method = "FD95EEF3A35F6010EF733035D8CD816B", hash_generated_method = "A305C2600B4CE198F85BCE6A8CFEBA1D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.596 -0400", hash_original_method = "48D1C344F1CE2628DE4C68ABB227A1F6", hash_generated_method = "58B573E4CBD353F7625694C617B52C88")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.596 -0400", hash_original_method = "8E6E2A16641CB1071F07CC6C84B1A29D", hash_generated_method = "D7502A3FF04FED1BC8DD49FCBA47C0F0")
    public static float getAltitude(float p0, float p) {
        final float coef = 1.0f / 5.255f;
        return 44330.0f * (1.0f - (float)Math.pow(p/p0, coef));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.596 -0400", hash_original_method = "E0193DACD15BA8C3AC5F2C441048790B", hash_generated_method = "9C3CB13D4FAFAF898CC613E457B32DCA")
    @DSModeled(DSC.SAFE)
    public void onRotationChanged(int rotation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(rotation);
        // ---------- Original Method ----------
        //synchronized(sListeners) {
            //sRotation  = rotation;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.596 -0400", hash_original_method = "14C63D8E207B99EF2DEBC9C5BACA5384", hash_generated_method = "891234789498953B63D3A0AEE094E837")
    static int getRotation() {
        synchronized(sListeners) {
            return sRotation;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.596 -0400", hash_original_method = "8B9F6F99770AC610A78817CE4E6CAD01", hash_generated_method = "292720BA26E5C47FB763CD3A0EC2FD8A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.596 -0400", hash_original_method = "3DB3B83767C3E6A9B01AB274AC444879", hash_generated_method = "B2F783217F54BDCC93E781D30D5C7FF4")
    public static void getRotationMatrixFromVector(float[] R, float[] rotationVector) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.597 -0400", hash_original_method = "E42DD1F670DB7ECCA034D643DAC17008", hash_generated_method = "4D2AC6CF6B996AB184E65BF38023BB34")
    public static void getQuaternionFromVector(float[] Q, float[] rv) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.597 -0400", hash_original_method = "368BCBBAD3F68FEF8C07AE5DC4D2077C", hash_generated_method = "66CFEED3BA0F1B2AF18C8805660BFF70")
    private static void nativeClassInit() {
    }

    private static final DSTaintObject staticTaint = new DSTaintObject();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.597 -0400", hash_original_method = "6365E13BB087A838DD54B258D6E856F5", hash_generated_method = "9BD65DDBB3CA118801006316859722CC")
    private static int sensors_module_init() {
    	return staticTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.597 -0400", hash_original_method = "46EA0F084B7F191DA6C3F86709BF6135", hash_generated_method = "D94A0FF57EA9FFAB193920F43223B49C")
    private static int sensors_module_get_next_sensor(Sensor sensor, int next) {
    	staticTaint.addTaint(sensor.dsTaint);
    	staticTaint.addTaint(next);
    	return staticTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.597 -0400", hash_original_method = "31DCE2209DC68F9077EEC42B395ED913", hash_generated_method = "D32231EC8B3F90BCB1EC1DE000D8B4A7")
    static int sensors_create_queue() {
    	return staticTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.597 -0400", hash_original_method = "E019B082870518BD19ED3F85992F5CB7", hash_generated_method = "7EDE2441CCDB6594185D9811BCB7955F")
    static void sensors_destroy_queue(int queue) {
    	staticTaint.addTaint(queue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.597 -0400", hash_original_method = "117E19DFC6184FA649725FA403FAE58B", hash_generated_method = "575B0FC4A84BB8BF4E47FC7AAB673626")
    static boolean sensors_enable_sensor(int queue, String name, int sensor, int enable) {
    	staticTaint.addTaint(queue);
    	staticTaint.addTaint(name);
    	staticTaint.addTaint(sensor);
    	staticTaint.addTaint(enable);
    	return staticTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.597 -0400", hash_original_method = "AA2AC4B95365F4C2C82E555A36AD9CDF", hash_generated_method = "8FF42117C095835441F766569922931D")
    static int sensors_data_poll(int queue, float[] values, int[] status, long[] timestamp) {
    	staticTaint.addTaint(queue);
    	staticTaint.addTaint(values);
    	staticTaint.addTaint(status);
    	staticTaint.addTaint(timestamp);
    	return staticTaint.getTaintInt();
    }

    
    private class SensorEventPool {
        private final int mPoolSize;
        private final SensorEvent mPool[];
        private int mNumItemsInPool;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.597 -0400", hash_original_method = "ED871CCD57C994313960FB83DAC25B3A", hash_generated_method = "26365197C31AE5D33FF4418B2E02A1A5")
        @DSModeled(DSC.SAFE)
         SensorEventPool(int poolSize) {
            dsTaint.addTaint(poolSize);
            mPoolSize = poolSize;
            mPool = new SensorEvent[poolSize];
            // ---------- Original Method ----------
            //mPoolSize = poolSize;
            //mNumItemsInPool = poolSize;
            //mPool = new SensorEvent[poolSize];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.598 -0400", hash_original_method = "7237223B63C43177AB2849F160B99FEC", hash_generated_method = "57ED3EAF25FF42A4B8BA1FEA333C5C17")
        @DSModeled(DSC.SAFE)
        private SensorEvent createSensorEvent() {
            return (SensorEvent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SensorEvent(3);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.598 -0400", hash_original_method = "91BAA7B0EF8F8AB0DA2081F8E926B4FD", hash_generated_method = "310264758404ABA8FA01C71536B0FFE4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SensorEvent getFromPool() {
            SensorEvent t;
            t = null;
            {
                {
                    final int index;
                    index = mPoolSize - mNumItemsInPool;
                    t = mPool[index];
                    mPool[index] = null;
                    mNumItemsInPool--;
                } //End block
            } //End block
            {
                t = createSensorEvent();
            } //End block
            return (SensorEvent)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.598 -0400", hash_original_method = "C46016A1870C47E495A9527702944C16", hash_generated_method = "82CA33993D035398730D19ECD4A7D570")
        @DSModeled(DSC.SAFE)
         void returnToPool(SensorEvent t) {
            dsTaint.addTaint(t.dsTaint);
            {
                {
                    mNumItemsInPool++;
                    final int index;
                    index = mPoolSize - mNumItemsInPool;
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
        Thread mThread;
        boolean mSensorsReady;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.598 -0400", hash_original_method = "900B05FC812E5D001EF6E5D26AE8C532", hash_generated_method = "A5FD8A7E5CBF712661A2F2A026755DF3")
        @DSModeled(DSC.SAFE)
         SensorThread() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.598 -0400", hash_original_method = "3012BD4162FEB4D4063E0B4E3944BED9", hash_generated_method = "85E7C300EB010EE8D1A9CDD10E5AE37A")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.598 -0400", hash_original_method = "9B9CC9DE22F3A6E67DD39AE0CF54ADF8", hash_generated_method = "78BCBEBB32F2A271E8864EAA6CA5FB25")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean startLocked() {
            try 
            {
                {
                    mSensorsReady = false;
                    SensorThreadRunnable runnable;
                    runnable = new SensorThreadRunnable();
                    Thread thread;
                    thread = new Thread(runnable, SensorThread.class.getName());
                    thread.start();
                    {
                        {
                            runnable.wait();
                        } //End block
                    } //End block
                    mThread = thread;
                } //End block
            } //End block
            catch (InterruptedException e)
            { }
            return dsTaint.getTaintBoolean();
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.598 -0400", hash_original_method = "E6F9E1FFFEF800CB7D3BCE3C8792674F", hash_generated_method = "2914E6FFA0A9B9E96154ED2F6DE0618F")
            @DSModeled(DSC.SAFE)
             SensorThreadRunnable() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.599 -0400", hash_original_method = "8D69A6F3F762D5CCB4AA9AA134EC788D", hash_generated_method = "2757B91FEFCD8F142C259A8AFEA02753")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            private boolean open() {
                sQueue = sensors_create_queue();
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //sQueue = sensors_create_queue();
                //return true;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.599 -0400", hash_original_method = "22D645F37E8BABB44C20A553228E0A5C", hash_generated_method = "22164A172F6742C4773FB29385AAA2A9")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                final float[] values;
                values = new float[3];
                final int[] status;
                status = new int[1];
                final long timestamp[];
                timestamp = new long[1];
                Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_DISPLAY);
                {
                    boolean var985605CBA0A19C7C31CFE2830DD0F087_137071835 = (!open());
                } //End collapsed parenthetic
                {
                    mSensorsReady = true;
                    this.notify();
                } //End block
                {
                    final int sensor;
                    sensor = sensors_data_poll(sQueue, values, status, timestamp);
                    int accuracy;
                    accuracy = status[0];
                    {
                        {
                            boolean var127190B4DE7E6D58B20B51E001B0BFCF_295443635 = (sensor == -1 || sListeners.isEmpty());
                            {
                                {
                                    boolean var9D5E914AD6651B63A683B5BB46131EAC_67058159 = (sensor == -1 && !sListeners.isEmpty());
                                } //End collapsed parenthetic
                                sensors_destroy_queue(sQueue);
                                sQueue = 0;
                                mThread = null;
                            } //End block
                        } //End collapsed parenthetic
                        final Sensor sensorObject;
                        sensorObject = sHandleToSensor.get(sensor);
                        {
                            final int size;
                            size = sListeners.size();
                            {
                                int i;
                                i = 0;
                                {
                                    ListenerDelegate listener;
                                    listener = sListeners.get(i);
                                    {
                                        boolean var921FBD6C2D0284B5A15EBFD01F2697D2_1912217218 = (listener.hasSensor(sensorObject));
                                        {
                                            listener.onSensorChangedLocked(sensorObject,
                                            values, timestamp, accuracy);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
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
        private final Handler mHandler;
        public SparseBooleanArray mSensors = new SparseBooleanArray();
        public SparseBooleanArray mFirstEvent = new SparseBooleanArray();
        public SparseIntArray mSensorAccuracies = new SparseIntArray();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.599 -0400", hash_original_method = "5F32B99D810AC43D96375634E0119DDB", hash_generated_method = "5DF5188C8D410034B2C8103E54BEF75C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ListenerDelegate(SensorEventListener listener, Sensor sensor, Handler handler) {
            dsTaint.addTaint(sensor.dsTaint);
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            mSensorEventListener = listener;
            Looper looper;
            looper = handler.getLooper();
            looper = mMainLooper;
            mHandler = new Handler(looper) {
                @Override
                public void handleMessage(Message msg) {
                    final SensorEvent t = (SensorEvent)msg.obj;
                    final int handle = t.sensor.getHandle();
                    switch (t.sensor.getType()) {
                        case Sensor.TYPE_MAGNETIC_FIELD:
                        case Sensor.TYPE_ORIENTATION:
                            final int accuracy = mSensorAccuracies.get(handle);
                            if ((t.accuracy >= 0) && (accuracy != t.accuracy)) {
                                mSensorAccuracies.put(handle, t.accuracy);
                                mSensorEventListener.onAccuracyChanged(t.sensor, t.accuracy);
                            }
                            break;
                        default:
                            if (mFirstEvent.get(handle) == false) {
                                mFirstEvent.put(handle, true);
                                mSensorEventListener.onAccuracyChanged(
                                        t.sensor, SENSOR_STATUS_ACCURACY_HIGH);
                            }
                            break;
                    }
                    mSensorEventListener.onSensorChanged(t);
                    sPool.returnToPool(t);
                }
            };
            addSensor(sensor);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.600 -0400", hash_original_method = "02DCCE55D13DD3643E30DA559E9BDE85", hash_generated_method = "328364B469DB2E708590EF55647100C5")
        @DSModeled(DSC.SAFE)
         Object getListener() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mSensorEventListener;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.600 -0400", hash_original_method = "B2FBA8302C1585AE96282F4E3DA295C6", hash_generated_method = "CB94F97083E631DF9004C2D3CBB78B7E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void addSensor(Sensor sensor) {
            dsTaint.addTaint(sensor.dsTaint);
            mSensors.put(sensor.getHandle(), true);
            mSensorList.add(sensor);
            // ---------- Original Method ----------
            //mSensors.put(sensor.getHandle(), true);
            //mSensorList.add(sensor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.600 -0400", hash_original_method = "262A581E44AC35F2D9F50EC370F0EA9A", hash_generated_method = "5383C7A7BB0731FAA396C23C264A7026")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         int removeSensor(Sensor sensor) {
            dsTaint.addTaint(sensor.dsTaint);
            mSensors.delete(sensor.getHandle());
            mSensorList.remove(sensor);
            int var6BFAA1E0B112F76B5AEF542407218A12_1425192625 = (mSensors.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //mSensors.delete(sensor.getHandle());
            //mSensorList.remove(sensor);
            //return mSensors.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.600 -0400", hash_original_method = "5A86EBC59444E6C07690511EA8C8466D", hash_generated_method = "2AAE5EAB09ADBC6FCD8A652DF808DB8A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean hasSensor(Sensor sensor) {
            dsTaint.addTaint(sensor.dsTaint);
            boolean var950F191B8F54F762584455E74F5BBE34_2021448924 = (mSensors.get(sensor.getHandle()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mSensors.get(sensor.getHandle());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.600 -0400", hash_original_method = "DA37BCA933FDDA4900146E3A50CD9005", hash_generated_method = "B46DDA37008AC8CA07BDE741FFE5D760")
        @DSModeled(DSC.SAFE)
         List<Sensor> getSensors() {
            return (List<Sensor>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mSensorList;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.600 -0400", hash_original_method = "16733F3375BBFC31BBB88791653112DA", hash_generated_method = "B7E7FDF388268C7A08735825482CA9F2")
        @DSModeled(DSC.SAFE)
         void onSensorChangedLocked(Sensor sensor, float[] values, long[] timestamp, int accuracy) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(sensor.dsTaint);
            dsTaint.addTaint(timestamp);
            dsTaint.addTaint(values);
            dsTaint.addTaint(accuracy);
            SensorEvent t;
            t = sPool.getFromPool();
            final float[] v;
            v = t.values;
            v[0] = values[0];
            v[1] = values[1];
            v[2] = values[2];
            t.timestamp = timestamp[0];
            t.accuracy = accuracy;
            t.sensor = sensor;
            Message msg;
            msg = Message.obtain();
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

        
    }


    
    private class LegacyListener implements SensorEventListener {
        private float mValues[] = new float[6];
        @SuppressWarnings("deprecation")
        private SensorListener mTarget;
        private int mSensors;
        private final LmsFilter mYawfilter = new LmsFilter();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.600 -0400", hash_original_method = "A655EEB442CA31096C7FBEA03DE93B9D", hash_generated_method = "AC5ED95DA0E4767FE637AF0A4DD59911")
        @DSModeled(DSC.SAFE)
        @SuppressWarnings("deprecation")
         LegacyListener(SensorListener target) {
            dsTaint.addTaint(target.dsTaint);
            mSensors = 0;
            // ---------- Original Method ----------
            //mTarget = target;
            //mSensors = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.601 -0400", hash_original_method = "4097E1683A40A6DEAB5492A2296E3879", hash_generated_method = "DA433926F863C9F573E2E3421CAD7AF1")
        @DSModeled(DSC.SAFE)
         void registerSensor(int legacyType) {
            //DSFIXME: CODE0010: Possible callback registration function detected
            dsTaint.addTaint(legacyType);
            // ---------- Original Method ----------
            //mSensors |= legacyType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.601 -0400", hash_original_method = "737F8C4556D577A83A29D9000B85627C", hash_generated_method = "2A6EC00CEDC26A6B8CECB08256CA95F5")
        @DSModeled(DSC.SAFE)
         boolean unregisterSensor(int legacyType) {
            //DSFIXME: CODE0010: Possible callback registration function detected
            dsTaint.addTaint(legacyType);
            mSensors &= ~legacyType;
            int mask;
            mask = SENSOR_ORIENTATION|SENSOR_ORIENTATION_RAW;
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //mSensors &= ~legacyType;
            //int mask = SENSOR_ORIENTATION|SENSOR_ORIENTATION_RAW;
            //if (((legacyType&mask)!=0) && ((mSensors&mask)!=0)) {
                //return false;
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.601 -0400", hash_original_method = "E64F8429635EF9F3222DE4609CE00D63", hash_generated_method = "7284BCDA166523E780AF1597DC3CBACD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("deprecation")
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(sensor.dsTaint);
            dsTaint.addTaint(accuracy);
            try 
            {
                mTarget.onAccuracyChanged(sensor.getLegacyType(), accuracy);
            } //End block
            catch (AbstractMethodError e)
            { }
            // ---------- Original Method ----------
            //try {
                //mTarget.onAccuracyChanged(sensor.getLegacyType(), accuracy);
            //} catch (AbstractMethodError e) {
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.601 -0400", hash_original_method = "7B74886508DCBDDEB63A3DDB570295F3", hash_generated_method = "508A7BE31330F9E43AF841EC2100A32C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("deprecation")
        public void onSensorChanged(SensorEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(event.dsTaint);
            final float v[];
            v = mValues;
            v[0] = event.values[0];
            v[1] = event.values[1];
            v[2] = event.values[2];
            int legacyType;
            legacyType = event.sensor.getLegacyType();
            mapSensorDataToWindow(legacyType, v, SensorManager.getRotation());
            {
                boolean var4F7F0CC1AE211203503D2B829C8F4CB6_564530744 = (event.sensor.getType() == Sensor.TYPE_ORIENTATION);
                {
                    {
                        mTarget.onSensorChanged(SENSOR_ORIENTATION_RAW, v);
                    } //End block
                    {
                        v[0] = mYawfilter.filter(event.timestamp, v[0]);
                        mTarget.onSensorChanged(SENSOR_ORIENTATION, v);
                    } //End block
                } //End block
                {
                    mTarget.onSensorChanged(legacyType, v);
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.602 -0400", hash_original_method = "7A14D827894C3DC6FC1EC81B36F33A0A", hash_generated_method = "AA269D4A362A03CD81759BE340080EFA")
        @DSModeled(DSC.SAFE)
        private void mapSensorDataToWindow(int sensor,
                float[] values, int orientation) {
            dsTaint.addTaint(sensor);
            dsTaint.addTaint(orientation);
            dsTaint.addTaint(values);
            float x;
            x = values[0];
            float y;
            y = values[1];
            float z;
            z = values[2];
            //Begin case SensorManager.SENSOR_ORIENTATION SensorManager.SENSOR_ORIENTATION_RAW 
            z = -z;
            //End case SensorManager.SENSOR_ORIENTATION SensorManager.SENSOR_ORIENTATION_RAW 
            //Begin case SensorManager.SENSOR_ACCELEROMETER 
            x = -x;
            //End case SensorManager.SENSOR_ACCELEROMETER 
            //Begin case SensorManager.SENSOR_ACCELEROMETER 
            y = -y;
            //End case SensorManager.SENSOR_ACCELEROMETER 
            //Begin case SensorManager.SENSOR_ACCELEROMETER 
            z = -z;
            //End case SensorManager.SENSOR_ACCELEROMETER 
            //Begin case SensorManager.SENSOR_MAGNETIC_FIELD 
            x = -x;
            //End case SensorManager.SENSOR_MAGNETIC_FIELD 
            //Begin case SensorManager.SENSOR_MAGNETIC_FIELD 
            y = -y;
            //End case SensorManager.SENSOR_MAGNETIC_FIELD 
            values[0] = x;
            values[1] = y;
            values[2] = z;
            values[3] = x;
            values[4] = y;
            values[5] = z;
            {
                //Begin case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                values[0] =-y;
                //End case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                //Begin case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                values[1] = x;
                //End case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                //Begin case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                values[2] = z;
                //End case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                //Begin case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
                values[0] = x + ((x < 270) ? 90 : -270);
                //End case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
                //Begin case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
                values[1] = z;
                //End case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
                //Begin case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
                values[2] = y;
                //End case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
            } //End block
            {
                x = values[0];
                y = values[1];
                z = values[2];
                //Begin case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                values[0] =-x;
                //End case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                //Begin case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                values[1] =-y;
                //End case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                //Begin case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                values[2] = z;
                //End case SENSOR_ACCELEROMETER SENSOR_MAGNETIC_FIELD 
                //Begin case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
                values[0] = (x >= 180) ? (x - 180) : (x + 180);
                //End case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
                //Begin case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
                values[1] =-y;
                //End case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
                //Begin case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
                values[2] =-z;
                //End case SENSOR_ORIENTATION SENSOR_ORIENTATION_RAW 
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class LmsFilter {
        private static final int SENSORS_RATE_MS = 20;
        private static final int COUNT = 12;
        private static final float PREDICTION_RATIO = 1.0f/3.0f;
        private static final float PREDICTION_TIME = (SENSORS_RATE_MS*COUNT/1000.0f)*PREDICTION_RATIO;
        private float mV[] = new float[COUNT*2];
        private float mT[] = new float[COUNT*2];
        private int mIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.602 -0400", hash_original_method = "E02C377CCDCA56F06C1373683AAA5F27", hash_generated_method = "F67B8A5F2C0951314A98491CF0E3335F")
        @DSModeled(DSC.SAFE)
        public LmsFilter() {
            mIndex = COUNT;
            // ---------- Original Method ----------
            //mIndex = COUNT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.602 -0400", hash_original_method = "EF62ACDA1EDD9BA52B9A6B99F58CD8F6", hash_generated_method = "8E9F2CCA112771F0663231590B622015")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float filter(long time, float in) {
            dsTaint.addTaint(time);
            dsTaint.addTaint(in);
            float v;
            v = in;
            final float ns;
            ns = 1.0f / 1000000000.0f;
            final float t;
            t = time*ns;
            float v1;
            v1 = mV[mIndex];
            {
                v -= 360;
            } //End block
            {
                v += 360;
            } //End block
            mIndex++;
            mIndex = COUNT;
            mV[mIndex] = v;
            mT[mIndex] = t;
            mV[mIndex-COUNT] = v;
            mT[mIndex-COUNT] = t;
            float A, B, C, D, E;
            float a, b;
            int i;
            A = B = C = D = E = 0;
            {
                i=0;
                {
                    final int j;
                    j = mIndex - 1 - i;
                    final float Z;
                    Z = mV[j];
                    final float T;
                    T = 0.5f*(mT[j] + mT[j+1]) - t;
                    float dT;
                    dT = mT[j] - mT[j+1];
                    dT *= dT;
                    A += Z*dT;
                    B += T*(T*dT);
                    C +=   (T*dT);
                    D += Z*(T*dT);
                    E += dT;
                } //End block
            } //End collapsed parenthetic
            b = (A*B + C*D) / (E*B + C*C);
            a = (E*b - A) / C;
            float f;
            f = b + PREDICTION_TIME*a;
            f *= (1.0f / 360.0f);
            f = f - (float)Math.ceil(f + 0.5f) + 1.0f;
            f += 1.0f;
            f *= 360.0f;
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
}


