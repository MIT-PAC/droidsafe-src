package android.hardware;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.003 -0400", hash_original_field = "6C2EA91B438529F1372D806717F5AE04", hash_generated_field = "22AA67C96F8F7AD7DFD89E53DF216F9A")

    Looper mMainLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.003 -0400", hash_original_field = "7BEB80E82E92B6E556110552EA9B73AD", hash_generated_field = "0F9F236B24164523848440F1C5249FC1")

    @SuppressWarnings("deprecation") private HashMap<SensorListener, LegacyListener> mLegacyListenersMap = new HashMap<SensorListener, LegacyListener>();
    
    // Made public by DS Modeling, should not be called by application
 	@DSModeled(DSC.BAN)
 	public SensorManager() {
 	}
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.005 -0400", hash_original_method = "D89BA857D2DFC071EE5A857E0568AFCF", hash_generated_method = "84B64F0F51C0586B48C6D2C308267F6B")
    public  SensorManager(Looper mainLooper) {
        mMainLooper = mainLooper;
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
                            @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.004 -0400", hash_original_method = "BE005D6720C412EC6EF9D753DC3A6572", hash_generated_method = "ABD597AB6D97EA2FD083DF4550868008")
                            public void onRotationChanged(int rotation) {
                                
                                SensorManager.this.onRotationChanged(rotation);
                                addTaint(rotation);
                                
                                
                            }
}
                        );
                    } 
                    catch (RemoteException e)
                    { }
                } 
                sensors_module_init();
                final ArrayList<Sensor> fullList = sFullSensorsList;
                int i = 0;
                {
                    Sensor sensor = new Sensor();
                    i = sensors_module_get_next_sensor(sensor, i);
                    {
                        sensor.setLegacyType(getLegacySensorType(sensor.getType()));
                        fullList.add(sensor);
                        sHandleToSensor.append(sensor.getHandle(), sensor);
                    } 
                } 
                sPool = new SensorEventPool( sFullSensorsList.size()*2 );
                sSensorThread = new SensorThread();
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.005 -0400", hash_original_method = "F97F3FCBB2B92661C96383BC3925201E", hash_generated_method = "BACB0928271E673135B619DC3F5E4CD4")
    private int getLegacySensorType(int type) {
        addTaint(type);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19991395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19991395;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.010 -0400", hash_original_method = "9387EF1577B9728CF6A87474164955A1", hash_generated_method = "2E17078B11E952A75DDC08B6AC13C291")
    @Deprecated
    public int getSensors() {
        int result = 0;
        final ArrayList<Sensor> fullList = sFullSensorsList;
        {
            Iterator<Sensor> var0DEABE92509D42B4E259D30A1F0E9F9B_744208509 = (fullList).iterator();
            var0DEABE92509D42B4E259D30A1F0E9F9B_744208509.hasNext();
            Sensor i = var0DEABE92509D42B4E259D30A1F0E9F9B_744208509.next();
            {
                {
                    Object var38AF2FBEBB9E1731747F2959C06CD9D2_2033175196 = (i.getType());
                    
                    result |= SensorManager.SENSOR_ACCELEROMETER;
                    
                    
                    result |= SensorManager.SENSOR_MAGNETIC_FIELD;
                    
                    
                    result |= SensorManager.SENSOR_ORIENTATION |
                    SensorManager.SENSOR_ORIENTATION_RAW;
                    
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_761125037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_761125037;
        
        
        
        
            
                
                    
                    
                
                    
                    
                
                    
                    
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.014 -0400", hash_original_method = "D388F11CBE90143BC36FA3E001809013", hash_generated_method = "26D95EC67E49C7F26CF3DDC85922F261")
    public List<Sensor> getSensorList(int type) {
        List<Sensor> varB4EAC82CA7396A68D541C85D26508E83_229458488 = null; 
        List<Sensor> list;
        final ArrayList<Sensor> fullList = sFullSensorsList;
        {
            list = sSensorListByType.get(type);
            {
                {
                    list = fullList;
                } 
                {
                    list = new ArrayList<Sensor>();
                    {
                        Iterator<Sensor> var0DEABE92509D42B4E259D30A1F0E9F9B_51125751 = (fullList).iterator();
                        var0DEABE92509D42B4E259D30A1F0E9F9B_51125751.hasNext();
                        Sensor i = var0DEABE92509D42B4E259D30A1F0E9F9B_51125751.next();
                        {
                            {
                                boolean var7614D0966578B0CB10CCAAD9D58C74AC_717657160 = (i.getType() == type);
                                list.add(i);
                            } 
                        } 
                    } 
                } 
                list = Collections.unmodifiableList(list);
                sSensorListByType.append(type, list);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_229458488 = list;
        addTaint(type);
        varB4EAC82CA7396A68D541C85D26508E83_229458488.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_229458488;
        
        
        
        
            
            
                
                    
                
                    
                    
                        
                            
                    
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.015 -0400", hash_original_method = "051BFE8F8271F52ABA0B8E99C6E74461", hash_generated_method = "25A18325DAA5BEA836789C8971CBED22")
    public Sensor getDefaultSensor(int type) {
        Sensor varB4EAC82CA7396A68D541C85D26508E83_1916454720 = null; 
        List<Sensor> l = getSensorList(type);
        varB4EAC82CA7396A68D541C85D26508E83_1916454720 = l.isEmpty() ? null : l.get(0);
        addTaint(type);
        varB4EAC82CA7396A68D541C85D26508E83_1916454720.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1916454720;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.015 -0400", hash_original_method = "CA10DA2A107C571495F28D1A1A335E4D", hash_generated_method = "172C8996C928772B0E7E33CF52B5B809")
    @Deprecated
    public boolean registerListener(SensorListener listener, int sensors) {
        
        boolean var0BF2B61900138CF1C60B85B7842D08C3_1166440901 = (registerListener(listener, sensors, SENSOR_DELAY_NORMAL));
        addTaint(listener.getTaint());
        addTaint(sensors);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_333555372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_333555372;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.016 -0400", hash_original_method = "B7C7A7F6BC1EDB860C06401873DD1A46", hash_generated_method = "4BC59BF39EDCB98EA1192553FD5C4A64")
    @Deprecated
    public boolean registerListener(SensorListener listener, int sensors, int rate) {
        
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
        addTaint(listener.getTaint());
        addTaint(sensors);
        addTaint(rate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81268103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_81268103;
        
        
            
        
        
        
                
        
                
        
                
        
                
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.017 -0400", hash_original_method = "2BFEE9499E6BC093763ECA6BB97D348E", hash_generated_method = "E5DD29AF9DA362B61A70530F8D58DFFC")
    @SuppressWarnings("deprecation")
    private boolean registerLegacyListener(int legacyType, int type,
            SensorListener listener, int sensors, int rate) {
        boolean result = false;
        {
            Sensor sensor = getDefaultSensor(type);
            {
                LegacyListener legacyListener = null;
                {
                    legacyListener = mLegacyListenersMap.get(listener);
                    {
                        legacyListener = new LegacyListener(listener);
                        mLegacyListenersMap.put(listener, legacyListener);
                    } 
                } 
                legacyListener.registerSensor(legacyType);
                result = registerListener(legacyListener, sensor, rate);
            } 
        } 
        addTaint(legacyType);
        addTaint(type);
        addTaint(listener.getTaint());
        addTaint(sensors);
        addTaint(rate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176132873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_176132873;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.018 -0400", hash_original_method = "08C00AEC5C2F4A8557AFE56DD5038FAA", hash_generated_method = "8F997475CDBEDBD28692C01E118FE905")
    @Deprecated
    public void unregisterListener(SensorListener listener, int sensors) {
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
        addTaint(listener.getTaint());
        addTaint(sensors);
        
        
                
        
                
        
                
        
                
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.034 -0400", hash_original_method = "9C431FA18D1D7C546E542BF96DE5A08A", hash_generated_method = "717227CE390B052AD7BB58AB0B376515")
    @SuppressWarnings("deprecation")
    private void unregisterLegacyListener(int legacyType, int type,
            SensorListener listener, int sensors) {
        LegacyListener legacyListener = null;
        {
            legacyListener = mLegacyListenersMap.get(listener);
        } 
        {
            {
                Sensor sensor = getDefaultSensor(type);
                {
                    {
                        boolean var99B715C543012D6D71309E3E94E937E5_1116434306 = (legacyListener.unregisterSensor(legacyType));
                        {
                            unregisterListener(legacyListener, sensor);
                            {
                                boolean found = false;
                                {
                                    Iterator<ListenerDelegate> var93B5C79A12C2463BBDFB4D05D3DB26A4_1691882418 = (sListeners).iterator();
                                    var93B5C79A12C2463BBDFB4D05D3DB26A4_1691882418.hasNext();
                                    ListenerDelegate i = var93B5C79A12C2463BBDFB4D05D3DB26A4_1691882418.next();
                                    {
                                        {
                                            boolean var52DC0C35F59BFF0EE51A50C3EAAAEE0B_1151730945 = (i.getListener() == legacyListener);
                                            {
                                                found = true;
                                            } 
                                        } 
                                    } 
                                } 
                                {
                                    {
                                        mLegacyListenersMap.remove(listener);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(legacyType);
        addTaint(type);
        addTaint(listener.getTaint());
        addTaint(sensors);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.034 -0400", hash_original_method = "F024191DD75DA5578F802D33C834CE8F", hash_generated_method = "0CB929AA44D6B264065C3B4F5E539818")
    @Deprecated
    public void unregisterListener(SensorListener listener) {
        unregisterListener(listener, SENSOR_ALL | SENSOR_ORIENTATION_RAW);
        addTaint(listener.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.035 -0400", hash_original_method = "A245758148D9D81E2CADBC67CD903CC7", hash_generated_method = "4FE5F77871A96349261B2607FDC5D066")
    public void unregisterListener(SensorEventListener listener, Sensor sensor) {
        unregisterListener((Object)listener, sensor);
        addTaint(listener.getTaint());
        addTaint(sensor.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.035 -0400", hash_original_method = "C9A0C02866BC64B5017A48A301526982", hash_generated_method = "C0126C5E58B1502478A3D21ABBF9555C")
    public void unregisterListener(SensorEventListener listener) {
        unregisterListener((Object)listener);
        addTaint(listener.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.036 -0400", hash_original_method = "EEA9FC3069A1CEC2680F553E722797E3", hash_generated_method = "1A563EC7A552D095BC24FCDAB1B51A2D")
    public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate) {
        
        boolean varD3243FA077760CCBCBDDCB77D8EFCE42_217301604 = (registerListener(listener, sensor, rate, null));
        addTaint(listener.getTaint());
        addTaint(sensor.getTaint());
        addTaint(rate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1601300925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1601300925;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.041 -0400", hash_original_method = "500C86ADE6AA4F4A0E12D1A653386772", hash_generated_method = "4F3833BE63D330A7352F25120CAFB82C")
    private boolean enableSensorLocked(Sensor sensor, int delay) {
        boolean result = false;
        {
            Iterator<ListenerDelegate> var93B5C79A12C2463BBDFB4D05D3DB26A4_584460799 = (sListeners).iterator();
            var93B5C79A12C2463BBDFB4D05D3DB26A4_584460799.hasNext();
            ListenerDelegate i = var93B5C79A12C2463BBDFB4D05D3DB26A4_584460799.next();
            {
                {
                    boolean varD5C4AA45C80B3832F93AE2792FBE9608_44907105 = (i.hasSensor(sensor));
                    {
                        String name = sensor.getName();
                        int handle = sensor.getHandle();
                        result = sensors_enable_sensor(sQueue, name, handle, delay);
                    } 
                } 
            } 
        } 
        addTaint(sensor.getTaint());
        addTaint(delay);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_737870657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_737870657;
        
        
        
            
                
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.045 -0400", hash_original_method = "4F96C2E0F6181D20ADA1404B28BE0C37", hash_generated_method = "7E9CAA6D86D923E19029C448371A0679")
    private boolean disableSensorLocked(Sensor sensor) {
        {
            Iterator<ListenerDelegate> var93B5C79A12C2463BBDFB4D05D3DB26A4_2042952396 = (sListeners).iterator();
            var93B5C79A12C2463BBDFB4D05D3DB26A4_2042952396.hasNext();
            ListenerDelegate i = var93B5C79A12C2463BBDFB4D05D3DB26A4_2042952396.next();
            {
                {
                    boolean varD5C4AA45C80B3832F93AE2792FBE9608_659533770 = (i.hasSensor(sensor));
                } 
            } 
        } 
        String name = sensor.getName();
        int handle = sensor.getHandle();
        boolean var240274763501E0777166463484969D38_225063210 = (sensors_enable_sensor(sQueue, name, handle, SENSOR_DISABLE));
        addTaint(sensor.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138684784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138684784;
        
        
            
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.064 -0400", hash_original_method = "55FB0E0786574FCA30E9C20955CE2F64", hash_generated_method = "B3E41D7EA26461DA2902FF4075623B36")
    public boolean registerListener(SensorEventListener listener, Sensor sensor, int rate,
            Handler handler) {
        
        boolean result = true;
        int delay = -1;
        
        delay = 0;
        
        
        delay = 20000;
        
        
        delay = 66667;
        
        
        delay = 200000;
        
        
        delay = rate;
        
        {
            ListenerDelegate l = null;
            {
                Iterator<ListenerDelegate> var93B5C79A12C2463BBDFB4D05D3DB26A4_1305250334 = (sListeners).iterator();
                var93B5C79A12C2463BBDFB4D05D3DB26A4_1305250334.hasNext();
                ListenerDelegate i = var93B5C79A12C2463BBDFB4D05D3DB26A4_1305250334.next();
                {
                    {
                        boolean var0BBE1CA9C28FD254D7916A3A201A9C57_197290643 = (i.getListener() == listener);
                        {
                            l = i;
                        } 
                    } 
                } 
            } 
            {
                l = new ListenerDelegate(listener, sensor, handler);
                sListeners.add(l);
                {
                    boolean varDA117198B3E757541D0D1AC89ACADD7C_507433750 = (!sListeners.isEmpty());
                    {
                        {
                            boolean varC6EAD9B6F4CC7D99EBE9EBC801163308_1397205898 = (sSensorThread.startLocked());
                            {
                                {
                                    boolean var7C2493CCA8EE6B8D8E012534AE552B3D_720943248 = (!enableSensorLocked(sensor, delay));
                                    {
                                        sListeners.remove(l);
                                        result = false;
                                    } 
                                } 
                            } 
                            {
                                sListeners.remove(l);
                                result = false;
                            } 
                        } 
                    } 
                    {
                        result = false;
                    } 
                } 
            } 
            {
                l.addSensor(sensor);
                {
                    boolean var31C2766AC2E2FB0586CAE28FC9E23C04_1626307500 = (!enableSensorLocked(sensor, delay));
                    {
                        l.removeSensor(sensor);
                        result = false;
                    } 
                } 
            } 
        } 
        addTaint(listener.getTaint());
        addTaint(sensor.getTaint());
        addTaint(rate);
        addTaint(handler.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030260197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030260197;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.065 -0400", hash_original_method = "1441CD23D4F492BD7877A59C29F56827", hash_generated_method = "0A51E22BF72887ABFA7B497999EE7752")
    private void unregisterListener(Object listener, Sensor sensor) {
        {
            final int size = sListeners.size();
            {
                int i = 0;
                {
                    ListenerDelegate l = sListeners.get(i);
                    {
                        boolean var59EE92861E91E921B93BC86C1074CE98_405797065 = (l.getListener() == listener);
                        {
                            {
                                boolean var254510C2CC6D8FB1AABA470DAF28ED32_1907750769 = (l.removeSensor(sensor) == 0);
                                {
                                    sListeners.remove(i);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            disableSensorLocked(sensor);
        } 
        addTaint(listener.getTaint());
        addTaint(sensor.getTaint());
        
        
            
        
        
            
            
                
                
                    
                        
                    
                    
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.072 -0400", hash_original_method = "63ADCF337C7E30C1A2DEC34D1892CFB3", hash_generated_method = "8868F5C3CE35680B284F12BFD938167D")
    private void unregisterListener(Object listener) {
        {
            final int size = sListeners.size();
            {
                int i = 0;
                {
                    ListenerDelegate l = sListeners.get(i);
                    {
                        boolean var59EE92861E91E921B93BC86C1074CE98_855666698 = (l.getListener() == listener);
                        {
                            sListeners.remove(i);
                            {
                                Iterator<Sensor> var8EE2CF31A277C918A8BE3D40E46B7476_1610288632 = (l.getSensors()).iterator();
                                var8EE2CF31A277C918A8BE3D40E46B7476_1610288632.hasNext();
                                Sensor sensor = var8EE2CF31A277C918A8BE3D40E46B7476_1610288632.next();
                                {
                                    disableSensorLocked(sensor);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(listener.getTaint());
        
        
            
        
        
            
            
                
                
                    
                    
                        
                    
                    
                
            
        
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
    public static float getInclination(float[] I) {
        if (I.length == 9) {
            return (float)Math.atan2(I[5], I[4]);
        } else {
            return (float)Math.atan2(I[6], I[5]);
        }
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
    public static float getAltitude(float p0, float p) {
        final float coef = 1.0f / 5.255f;
        return 44330.0f * (1.0f - (float)Math.pow(p/p0, coef));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.076 -0400", hash_original_method = "E0193DACD15BA8C3AC5F2C441048790B", hash_generated_method = "F45DE39634447C543023CA82667F0611")
    public void onRotationChanged(int rotation) {
        
        {
            sRotation  = rotation;
        } 
        addTaint(rotation);
        
        
            
        
    }

    
        @DSModeled(DSC.SAFE)
    static int getRotation() {
        synchronized(sListeners) {
            return sRotation;
        }
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
    private static void nativeClassInit() {
    }

    
        @DSModeled(DSC.SAFE)
    private static int sensors_module_init() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289465153 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289465153;
    }

    
        @DSModeled(DSC.SAFE)
    private static int sensors_module_get_next_sensor(Sensor sensor, int next) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_887780932 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_887780932;
    }

    
        @DSModeled(DSC.SAFE)
    static int sensors_create_queue() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801185530 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801185530;
    }

    
        @DSModeled(DSC.SAFE)
    static void sensors_destroy_queue(int queue) {
    }

    
        @DSModeled(DSC.SAFE)
    static boolean sensors_enable_sensor(int queue, String name, int sensor, int enable) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1987149488 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1987149488;
    }

    
        @DSModeled(DSC.SAFE)
    static int sensors_data_poll(int queue, float[] values, int[] status, long[] timestamp) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378875873 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378875873;
    }

    
    private class SensorEventPool {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.080 -0400", hash_original_field = "7AA23320BFA4200A90AB5D265B483107", hash_generated_field = "845BC6592821AED77B94BBB0FC4DDA9D")

        private int mPoolSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.080 -0400", hash_original_field = "EB343D9C6E31026C312AFCAC869C6020", hash_generated_field = "EE1301E693311ED21AE794595E0520C9")

        private SensorEvent mPool[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.080 -0400", hash_original_field = "2D41DA4101D45805C67929AE3CFF3F24", hash_generated_field = "3D0F60AFB8892A60CC0726A46DE3F85F")

        private int mNumItemsInPool;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.080 -0400", hash_original_method = "ED871CCD57C994313960FB83DAC25B3A", hash_generated_method = "F717475FA75FA31D35E1F9F00F8E555D")
          SensorEventPool(int poolSize) {
            mPoolSize = poolSize;
            mNumItemsInPool = poolSize;
            mPool = new SensorEvent[poolSize];
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.081 -0400", hash_original_method = "7237223B63C43177AB2849F160B99FEC", hash_generated_method = "0FE204D229E605DDCFC2119EEE08567A")
        private SensorEvent createSensorEvent() {
            SensorEvent varB4EAC82CA7396A68D541C85D26508E83_1616113565 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1616113565 = new SensorEvent(3);
            varB4EAC82CA7396A68D541C85D26508E83_1616113565.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1616113565;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.082 -0400", hash_original_method = "91BAA7B0EF8F8AB0DA2081F8E926B4FD", hash_generated_method = "47143C6EA285FCED0C94A6ECB3F0866E")
         SensorEvent getFromPool() {
            SensorEvent varB4EAC82CA7396A68D541C85D26508E83_1638978904 = null; 
            SensorEvent t = null;
            {
                {
                    final int index = mPoolSize - mNumItemsInPool;
                    t = mPool[index];
                    mPool[index] = null;
                } 
            } 
            {
                t = createSensorEvent();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1638978904 = t;
            varB4EAC82CA7396A68D541C85D26508E83_1638978904.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1638978904;
            
            
            
                
                    
                    
                    
                    
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.082 -0400", hash_original_method = "C46016A1870C47E495A9527702944C16", hash_generated_method = "EA7521FA436708DF1B7C8A9D177D117F")
         void returnToPool(SensorEvent t) {
            {
                {
                    final int index = mPoolSize - mNumItemsInPool;
                    mPool[index] = t;
                } 
            } 
            
            
                
                    
                    
                    
                
            
        }

        
    }


    
    static private class SensorThread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.082 -0400", hash_original_field = "1E66AA878E170B83C94516726B34414A", hash_generated_field = "8CE20653889294789C714060A391C40F")

        Thread mThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.082 -0400", hash_original_field = "BFEC44F69BA3AC1C0519E0E0E96845F5", hash_generated_field = "08100F1ACCE57FCB9D4D360616E4C0FE")

        boolean mSensorsReady;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.083 -0400", hash_original_method = "900B05FC812E5D001EF6E5D26AE8C532", hash_generated_method = "2055EED44BADC56C62DBBEEFADC404FB")
          SensorThread() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.083 -0400", hash_original_method = "3012BD4162FEB4D4063E0B4E3944BED9", hash_generated_method = "0065A500F2AC1D21DA0CBFBF0E28A56E")
        @Override
        protected void finalize() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.085 -0400", hash_original_method = "9B9CC9DE22F3A6E67DD39AE0CF54ADF8", hash_generated_method = "8BEAC14696D6E3018640B9C76686FE2C")
         boolean startLocked() {
            try 
            {
                {
                    mSensorsReady = false;
                    SensorThreadRunnable runnable = new SensorThreadRunnable();
                    Thread thread = new Thread(runnable, SensorThread.class.getName());
                    thread.start();
                    {
                        {
                            runnable.wait();
                        } 
                    } 
                    mThread = thread;
                } 
            } 
            catch (InterruptedException e)
            { }
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1095783557 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1095783557;
            
            
                
                    
                    
                    
                    
                    
                        
                            
                        
                    
                    
                
            
            
            
        }

        
        private class SensorThreadRunnable implements Runnable {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.086 -0400", hash_original_method = "E6F9E1FFFEF800CB7D3BCE3C8792674F", hash_generated_method = "DAC559901444A2EC31580DBE05ABA227")
              SensorThreadRunnable() {
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.087 -0400", hash_original_method = "8D69A6F3F762D5CCB4AA9AA134EC788D", hash_generated_method = "E74DCE819B40FFD3AB2989F0C01B6A93")
            private boolean open() {
                sQueue = sensors_create_queue();
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_220635619 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_220635619;
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.088 -0400", hash_original_method = "22D645F37E8BABB44C20A553228E0A5C", hash_generated_method = "33F7DF3130755EEC882F93EF3FC01719")
            public void run() {
                final float[] values = new float[3];
                final int[] status = new int[1];
                final long timestamp[] = new long[1];
                Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_DISPLAY);
                {
                    boolean var985605CBA0A19C7C31CFE2830DD0F087_1816177729 = (!open());
                } 
                {
                    mSensorsReady = true;
                    this.notify();
                } 
                {
                    final int sensor = sensors_data_poll(sQueue, values, status, timestamp);
                    int accuracy = status[0];
                    {
                        {
                            boolean var127190B4DE7E6D58B20B51E001B0BFCF_1009739317 = (sensor == -1 || sListeners.isEmpty());
                            {
                                {
                                    boolean var9D5E914AD6651B63A683B5BB46131EAC_409572581 = (sensor == -1 && !sListeners.isEmpty());
                                } 
                                sensors_destroy_queue(sQueue);
                                sQueue = 0;
                                mThread = null;
                            } 
                        } 
                        final Sensor sensorObject = sHandleToSensor.get(sensor);
                        {
                            final int size = sListeners.size();
                            {
                                int i = 0;
                                {
                                    ListenerDelegate listener = sListeners.get(i);
                                    {
                                        boolean var921FBD6C2D0284B5A15EBFD01F2697D2_1277868266 = (listener.hasSensor(sensorObject));
                                        {
                                            listener.onSensorChangedLocked(sensorObject,
                                            values, timestamp, accuracy);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                
                
            }

            
        }


        
    }


    
    private class ListenerDelegate {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.088 -0400", hash_original_field = "2EA4F09FB971E19728BD37B9F29E0383", hash_generated_field = "7CDF70F92784BF2F50B0C9C6E0D50D7E")

        private SensorEventListener mSensorEventListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.088 -0400", hash_original_field = "AC26E4836F0924CB815825E05CAD4EAB", hash_generated_field = "EA873B4B64DB82DE247512BA02A4C250")

        private final ArrayList<Sensor> mSensorList = new ArrayList<Sensor>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.088 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.088 -0400", hash_original_field = "DA8137A1714DC286EAE8D705C1514C80", hash_generated_field = "07735EE29000B01D7B06726363C9CD51")

        public SparseBooleanArray mSensors = new SparseBooleanArray();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.088 -0400", hash_original_field = "D49CA084FF0B2D41D2F98B7DD8A32487", hash_generated_field = "2B2A7DE406F5691574493DA0CEC8A36F")

        public SparseBooleanArray mFirstEvent = new SparseBooleanArray();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.088 -0400", hash_original_field = "6ABB3A8F98A871CC3DFDEACAC4C31FC8", hash_generated_field = "6E81EC263127AF97C52C45F2AB5DE4E7")

        public SparseIntArray mSensorAccuracies = new SparseIntArray();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.090 -0400", hash_original_method = "5F32B99D810AC43D96375634E0119DDB", hash_generated_method = "704513C1C3273A23825C2BD8E6E37DB5")
          ListenerDelegate(SensorEventListener listener, Sensor sensor, Handler handler) {
            mSensorEventListener = listener;
            Looper looper;
            looper = handler.getLooper();
            looper = mMainLooper;
            mHandler = new Handler(looper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.090 -0400", hash_original_method = "88AB5A19CD687EFCA1A0154186BFC370", hash_generated_method = "53C267F13D4FBB280019873B1FA88C90")
                @Override
                public void handleMessage(Message msg) {
                    final SensorEvent t = (SensorEvent)msg.obj;
                    final int handle = t.sensor.getHandle();
                    {
                        Object var5D5C6575D3FD1676C12EC71766D80FCD_239975231 = (t.sensor.getType());
                        
                        final int accuracy = mSensorAccuracies.get(handle);
                        
                        
                        {
                            mSensorAccuracies.put(handle, t.accuracy);
                            mSensorEventListener.onAccuracyChanged(t.sensor, t.accuracy);
                        } 
                        
                        
                        {
                            boolean var94EF3086E6F6B1D3D4536540A251DDF6_1369710946 = (mFirstEvent.get(handle) == false);
                            {
                                mFirstEvent.put(handle, true);
                                mSensorEventListener.onAccuracyChanged(
                                        t.sensor, SENSOR_STATUS_ACCURACY_HIGH);
                            } 
                        } 
                        
                    } 
                    mSensorEventListener.onSensorChanged(t);
                    sPool.returnToPool(t);
                    addTaint(msg.getTaint());
                    
                    
                }
};
            addSensor(sensor);
            addTaint(sensor.getTaint());
            addTaint(handler.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.091 -0400", hash_original_method = "02DCCE55D13DD3643E30DA559E9BDE85", hash_generated_method = "78B4A75F49A9C5693983982D8C29D160")
         Object getListener() {
            Object varB4EAC82CA7396A68D541C85D26508E83_738562002 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_738562002 = mSensorEventListener;
            varB4EAC82CA7396A68D541C85D26508E83_738562002.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_738562002;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.091 -0400", hash_original_method = "B2FBA8302C1585AE96282F4E3DA295C6", hash_generated_method = "DA304EF18DE6974303EF28AA1C1EC1F7")
         void addSensor(Sensor sensor) {
            mSensors.put(sensor.getHandle(), true);
            mSensorList.add(sensor);
            addTaint(sensor.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.091 -0400", hash_original_method = "262A581E44AC35F2D9F50EC370F0EA9A", hash_generated_method = "40B2EB0E19B21AC1BF981DD9991B9A80")
         int removeSensor(Sensor sensor) {
            mSensors.delete(sensor.getHandle());
            mSensorList.remove(sensor);
            int var6BFAA1E0B112F76B5AEF542407218A12_115406709 = (mSensors.size());
            addTaint(sensor.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_718376208 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_718376208;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.092 -0400", hash_original_method = "5A86EBC59444E6C07690511EA8C8466D", hash_generated_method = "AA7A9DF407C1EDA09208BEBB45D6F5A2")
         boolean hasSensor(Sensor sensor) {
            boolean var950F191B8F54F762584455E74F5BBE34_1436690111 = (mSensors.get(sensor.getHandle()));
            addTaint(sensor.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019175110 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019175110;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.093 -0400", hash_original_method = "DA37BCA933FDDA4900146E3A50CD9005", hash_generated_method = "9FC3BDF93479D4B25442D8003C6BF179")
         List<Sensor> getSensors() {
            List<Sensor> varB4EAC82CA7396A68D541C85D26508E83_325038175 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_325038175 = mSensorList;
            varB4EAC82CA7396A68D541C85D26508E83_325038175.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_325038175;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.094 -0400", hash_original_method = "16733F3375BBFC31BBB88791653112DA", hash_generated_method = "82AA40E7897B76622753884BEF23ECBF")
         void onSensorChangedLocked(Sensor sensor, float[] values, long[] timestamp, int accuracy) {
            
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
            addTaint(sensor.getTaint());
            addTaint(values[0]);
            addTaint(timestamp[0]);
            addTaint(accuracy);
            
            
            
            
            
            
            
            
            
            
            
            
            
        }

        
    }


    
    private class LegacyListener implements SensorEventListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.094 -0400", hash_original_field = "E47F25F3490FA8219470F5E99B2E5EF7", hash_generated_field = "B920C0767E790BC8A809EAECA2930561")

        private float mValues[] = new float[6];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.094 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "C800818392D79FD320EB62250F8EBEC5")

        @SuppressWarnings("deprecation") private SensorListener mTarget;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.094 -0400", hash_original_field = "5931991606D6B2006CC80ECD9383A5A0", hash_generated_field = "56793FD343ADA798CA50C026B1054688")

        private int mSensors;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.094 -0400", hash_original_field = "87BACA3CFC02AF2CDD58C8C0A54C9480", hash_generated_field = "7423027F5055567C2CEE13EBCD7D43EF")

        private final LmsFilter mYawfilter = new LmsFilter();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.095 -0400", hash_original_method = "A655EEB442CA31096C7FBEA03DE93B9D", hash_generated_method = "CBB5CEA1870353CD7AEAFC08ACA9FF7B")
        @SuppressWarnings("deprecation")
          LegacyListener(SensorListener target) {
            mTarget = target;
            mSensors = 0;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.095 -0400", hash_original_method = "4097E1683A40A6DEAB5492A2296E3879", hash_generated_method = "8131930ADF7BA919DC4A2597B2FC2264")
         void registerSensor(int legacyType) {
            
            mSensors |= legacyType;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.097 -0400", hash_original_method = "737F8C4556D577A83A29D9000B85627C", hash_generated_method = "14E41210CAC75E17CDE29D78969B1D95")
         boolean unregisterSensor(int legacyType) {
            mSensors &= ~legacyType;
            int mask = SENSOR_ORIENTATION|SENSOR_ORIENTATION_RAW;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_652638801 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_652638801;
            
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.098 -0400", hash_original_method = "E64F8429635EF9F3222DE4609CE00D63", hash_generated_method = "0EEE162EB40C7200E2C069D37F6F5A40")
        @SuppressWarnings("deprecation")
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            
            try 
            {
                mTarget.onAccuracyChanged(sensor.getLegacyType(), accuracy);
            } 
            catch (AbstractMethodError e)
            { }
            addTaint(sensor.getTaint());
            addTaint(accuracy);
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.099 -0400", hash_original_method = "7B74886508DCBDDEB63A3DDB570295F3", hash_generated_method = "30DB54115F42C4507C8A1AA1685CFDE2")
        @SuppressWarnings("deprecation")
        public void onSensorChanged(SensorEvent event) {
            
            final float v[] = mValues;
            v[0] = event.values[0];
            v[1] = event.values[1];
            v[2] = event.values[2];
            int legacyType = event.sensor.getLegacyType();
            mapSensorDataToWindow(legacyType, v, SensorManager.getRotation());
            {
                boolean var4F7F0CC1AE211203503D2B829C8F4CB6_1632313920 = (event.sensor.getType() == Sensor.TYPE_ORIENTATION);
                {
                    {
                        mTarget.onSensorChanged(SENSOR_ORIENTATION_RAW, v);
                    } 
                    {
                        v[0] = mYawfilter.filter(event.timestamp, v[0]);
                        mTarget.onSensorChanged(SENSOR_ORIENTATION, v);
                    } 
                } 
                {
                    mTarget.onSensorChanged(legacyType, v);
                } 
            } 
            addTaint(event.getTaint());
            
            
            
            
            
            
            
            
                
                    
                
                
                    
                    
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.100 -0400", hash_original_method = "7A14D827894C3DC6FC1EC81B36F33A0A", hash_generated_method = "7379D636E35EC54AA61FB2831CE85338")
        private void mapSensorDataToWindow(int sensor,
                float[] values, int orientation) {
            float x = values[0];
            float y = values[1];
            float z = values[2];
            
            z = -z;
            
            
            x = -x;
            
            
            y = -y;
            
            
            z = -z;
            
            
            x = -x;
            
            
            y = -y;
            
            values[0] = x;
            values[1] = y;
            values[2] = z;
            values[3] = x;
            values[4] = y;
            values[5] = z;
            {
                
                values[0] =-y;
                
                
                values[1] = x;
                
                
                values[2] = z;
                
                
                values[0] = x + ((x < 270) ? 90 : -270);
                
                
                values[1] = z;
                
                
                values[2] = y;
                
            } 
            {
                x = values[0];
                y = values[1];
                z = values[2];
                
                values[0] =-x;
                
                
                values[1] =-y;
                
                
                values[2] = z;
                
                
                values[0] = (x >= 180) ? (x - 180) : (x + 180);
                
                
                values[1] =-y;
                
                
                values[2] =-z;
                
            } 
            addTaint(sensor);
            addTaint(values[0]);
            addTaint(orientation);
            
            
        }

        
    }


    
    class LmsFilter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.100 -0400", hash_original_field = "48D0529DA1E5C381F063F44A0FD31829", hash_generated_field = "C71ED6AA46070A985BB77E25625E8D40")

        private float mV[] = new float[COUNT*2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.100 -0400", hash_original_field = "AF42DE60EDB9AFF44C9547CF14F97D4F", hash_generated_field = "454D11A3BEF77C99F353661B016C1D43")

        private float mT[] = new float[COUNT*2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.100 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.100 -0400", hash_original_method = "E02C377CCDCA56F06C1373683AAA5F27", hash_generated_method = "45D134E9ACF2C36E99725407618FA8B3")
        public  LmsFilter() {
            mIndex = COUNT;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.101 -0400", hash_original_method = "EF62ACDA1EDD9BA52B9A6B99F58CD8F6", hash_generated_method = "2CDF9A61B330C19148D26D8B516A064C")
        public float filter(long time, float in) {
            float v = in;
            final float ns = 1.0f / 1000000000.0f;
            final float t = time*ns;
            float v1 = mV[mIndex];
            {
                v -= 360;
            } 
            {
                v += 360;
            } 
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
            {
                i=0;
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
                } 
            } 
            b = (A*B + C*D) / (E*B + C*C);
            a = (E*b - A) / C;
            float f = b + PREDICTION_TIME*a;
            f *= (1.0f / 360.0f);
            f = f - (float)Math.ceil(f + 0.5f) + 1.0f;
            f += 1.0f;
            f *= 360.0f;
            addTaint(time);
            addTaint(in);
            float var546ADE640B6EDFBC8A086EF31347E768_770179051 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_770179051;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.787 -0400", hash_original_field = "103CAA5BDBCC664D1E126B48D7949988", hash_generated_field = "D74F70BB71AF1F7D23DF5A7ADA4F5F1D")

        private static final int SENSORS_RATE_MS = 20;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.788 -0400", hash_original_field = "508B8C3655D9B752E1E6E227FB1BD041", hash_generated_field = "519F09DCAE2CBF8552CDCCE8B8A72C3A")

        private static final int COUNT = 12;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.801 -0400", hash_original_field = "DCFF860EF95AAE60BF5F2096ED6EA6F0", hash_generated_field = "0ABCD59E4341DC913B4404C00B76FEF1")

        private static final float PREDICTION_RATIO = 1.0f/3.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:19.801 -0400", hash_original_field = "953A86377A023C22BC3D7A9DBF476182", hash_generated_field = "969E544E29F7CDE4CAF3886ADF80D0EC")

        private static final float PREDICTION_TIME = (SENSORS_RATE_MS*COUNT/1000.0f)*PREDICTION_RATIO;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "FE6D8EEFB1A97E20A0E0DE90CC29E1F5", hash_generated_field = "D46DC572C2EFA3216DE38441F1A6F061")

    private static final String TAG = "SensorManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "CEFCF8ADB492DA36D048C615C751DBEE", hash_generated_field = "FCB5327581E18710CDCDFFB10CC66C83")

    private static final float[] mTempMatrix = new float[16];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "18682A395AE180286E34404DA8CCAB5D", hash_generated_field = "2C25A8F3B344BC2280502D7D6177CA06")

    @Deprecated
    public static final int SENSOR_ORIENTATION = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "8E3B93BB271B20FDCB0FA84BC5D7BF6E", hash_generated_field = "19414CED4FA72491B85F493F8AFF63B8")

    @Deprecated
    public static final int SENSOR_ACCELEROMETER = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "0F63345BC9BC93E62E62636F88AD2830", hash_generated_field = "3C2362FF7C126F067910E2BCCF1EDCD7")

    @Deprecated
    public static final int SENSOR_TEMPERATURE = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "A38724D702B3418F0023DCA1B1C1C70C", hash_generated_field = "9238F3C8D08D015AF0853B89AD78AFB6")

    @Deprecated
    public static final int SENSOR_MAGNETIC_FIELD = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "FAC2E3815BF306FA6F6DECCB32DE15A7", hash_generated_field = "0E321C5D1567C957A91304082C18D404")

    @Deprecated
    public static final int SENSOR_LIGHT = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "1DF0F829205C973C81D0743591712D7F", hash_generated_field = "98A64C2F6E579F9CD66D58F1C82DC056")

    @Deprecated
    public static final int SENSOR_PROXIMITY = 1 << 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "3A9FCCF164EDCC310950F453BAC936CD", hash_generated_field = "EE36B6630EA8165AC8F0F495DB61178C")

    @Deprecated
    public static final int SENSOR_TRICORDER = 1 << 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "6EC0F682F138CD6C531DDE4C1F16368C", hash_generated_field = "37F85BDAD647215D01EBBDFF4549DA57")

    @Deprecated
    public static final int SENSOR_ORIENTATION_RAW = 1 << 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "1EB67756B1DED6009AF8DB26B11288B5", hash_generated_field = "4CFF3B4F2A25C8651ED8E70AA89C2F52")

    @Deprecated
    public static final int SENSOR_ALL = 0x7F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "EEF320C94A673C43A234108609BEE616", hash_generated_field = "02BF52AB62B9B0271AC3030C44199DCA")

    @Deprecated
    public static final int SENSOR_MIN = SENSOR_ORIENTATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "E11A45BF27295B5D771F2417E376322C", hash_generated_field = "48907DD0332337C7F41FBC22BAD37F2C")

    @Deprecated
    public static final int SENSOR_MAX = ((SENSOR_ALL + 1)>>1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "513046CFD455157D525B490BA8298EA4", hash_generated_field = "A9AC5D766E2244D46793610E9BC9AF74")

    @Deprecated
    public static final int DATA_X = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "BBBC6C0047E11615CA65F66610BAAF5A", hash_generated_field = "76993CCDC259CB3593B45E118CC14227")

    @Deprecated
    public static final int DATA_Y = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "13E91B7FC776FE1F7B91832781508367", hash_generated_field = "B1BA023EF03C57726C71339FD98E8727")

    @Deprecated
    public static final int DATA_Z = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "CD19E212A3F00F5997F82D5177A95A1E", hash_generated_field = "24BE7FB5178190074444287EE659C8D4")

    @Deprecated
    public static final int RAW_DATA_INDEX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "8F77C07EB606698277BF30DCECA17978", hash_generated_field = "A2C6FB458B3AEA3A9E8F6B34EBB801A3")

    @Deprecated
    public static final int RAW_DATA_X = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "B4CE3E066B52283D533D54E5B9E6C8AA", hash_generated_field = "31BD80CB85213EDFB1B6363D6C309F09")

    @Deprecated
    public static final int RAW_DATA_Y = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "6DB04C96CB90846AA80A218196BB469B", hash_generated_field = "A4105335D9B0E187F4624C5923397873")

    @Deprecated
    public static final int RAW_DATA_Z = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "8E7FC78C4CB226C3B2AEC06E521953C9", hash_generated_field = "E677BD9FA81EE77A42D6C83D3FCA7A4B")

    public static final float STANDARD_GRAVITY = 9.80665f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "978574D95B5704DE3CDADEB471A1F2A5", hash_generated_field = "7DFB37D1E3A2A36A3E756E4105637B67")

    public static final float GRAVITY_SUN             = 275.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "D56A80F65C3616183559C8A556F28181", hash_generated_field = "49E30115EE56C7C9C31EF2637CCCDFC5")

    public static final float GRAVITY_MERCURY         = 3.70f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "FA8C605A3B3E6474B793B07E5347CF28", hash_generated_field = "AB9A7548046B9BF51CB962118DCA6151")

    public static final float GRAVITY_VENUS           = 8.87f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "300AECE8BED6A87CFDE2FEEEEE78B685", hash_generated_field = "6F33579BCEBFC3579E1DD27C36753C71")

    public static final float GRAVITY_EARTH           = 9.80665f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "C41D2AD32F9D5AAD7E3D63A73BF00E3E", hash_generated_field = "1FE0A959605FC1FAF77D69C67BFDC3BE")

    public static final float GRAVITY_MOON            = 1.6f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "4A68236B756283B21D51DCD3DF13DBA9", hash_generated_field = "2B17FA2A3C55F1F38A6124E59337C061")

    public static final float GRAVITY_MARS            = 3.71f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "09B7AEDEE8A9B4EC6471C8C0C31AE2F8", hash_generated_field = "73FD09FCDD1A7BCCC2B000AD68B58807")

    public static final float GRAVITY_JUPITER         = 23.12f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "4AD677438B8228A7AB8F14E60D8B7777", hash_generated_field = "8D4E50FE00223ED202335CC88DA303A3")

    public static final float GRAVITY_SATURN          = 8.96f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "19B49C8126D15D9476A95929BE21729C", hash_generated_field = "12102A9D8CFFE04151CFD7073BB79258")

    public static final float GRAVITY_URANUS          = 8.69f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "62E84C6681FAC2AE485CD54DF3883E64", hash_generated_field = "E673030DEC6B6CA64CDACFFE50927C22")

    public static final float GRAVITY_NEPTUNE         = 11.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.102 -0400", hash_original_field = "99A6E104BDB4734AF33480ABBF6B88A4", hash_generated_field = "3BB701AC05D98480880F7FCAE6D3014C")

    public static final float GRAVITY_PLUTO           = 0.6f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "7641A04626086870E11B1ECD0238FBCE", hash_generated_field = "03051E3DC5786D7CF1D464F068BD1BB4")

    public static final float GRAVITY_DEATH_STAR_I    = 0.000000353036145f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "D682956E892E216D8F9D377F7608B8A5", hash_generated_field = "E52FA1DC3A5B4CFE9963B2BDDA041697")

    public static final float GRAVITY_THE_ISLAND      = 4.815162342f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "DF37DD5EABEAD2F84BE8A21F6FEAAB19", hash_generated_field = "1F1D70384C09D59F42D38B16133845CE")

    public static final float MAGNETIC_FIELD_EARTH_MAX = 60.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "CA3FA688B2874F63C82594B89641012E", hash_generated_field = "68DAB024C15BA1D077DE1B93007B509C")

    public static final float MAGNETIC_FIELD_EARTH_MIN = 30.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "D2679A50BE3935EA63A912BB32859DB1", hash_generated_field = "60B956375CABAA5A38520D232A65B625")

    public static final float PRESSURE_STANDARD_ATMOSPHERE = 1013.25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "79B6CBC73FA3AF41FACA66B1AD239F47", hash_generated_field = "605D89F0BFF38A6E37EBEB6F08AEDF44")

    public static final float LIGHT_SUNLIGHT_MAX = 120000.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "1329487F36B9EC0AFDF19494DAB23BA5", hash_generated_field = "9A674B69EB6FB611C967FFBBDE8223D9")

    public static final float LIGHT_SUNLIGHT     = 110000.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "A2C2A872347AA22764717B3C341B1E97", hash_generated_field = "6BB4816214FD8859745E9C80F7494836")

    public static final float LIGHT_SHADE        = 20000.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "5F7E24FA2F17D92B5B76C73E7B3FD856", hash_generated_field = "C5A4E7A988335CAA4F0F517EE5EF0D37")

    public static final float LIGHT_OVERCAST     = 10000.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "EF3A2A2D045C3CD9B817D3FE740E0028", hash_generated_field = "F5A221C1278C6E88B02A299F37E4C30A")

    public static final float LIGHT_SUNRISE      = 400.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "504A30FBA5AA8F3CC1203FD571F34432", hash_generated_field = "B6A4154BC1F854EDF3EEDB64CA76D406")

    public static final float LIGHT_CLOUDY       = 100.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "51A80DF03506A302C387D22BE67D5CE6", hash_generated_field = "547BE1973329E70E3558646E76316249")

    public static final float LIGHT_FULLMOON     = 0.25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "5FC13C707507E2EBE82AC2CC6A294BC0", hash_generated_field = "AA692E072FB30E0F7EB38E4F82C0839E")

    public static final float LIGHT_NO_MOON      = 0.001f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "BD18A6202C5C272850B17B327F1A90A2", hash_generated_field = "9E8D453CFCBB64FDBAC4894075F651FA")

    public static final int SENSOR_DELAY_FASTEST = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "CD114FCD28CA40D53805799AC25065D9", hash_generated_field = "B1EA2DD8A518D8B936090226F48D8CFA")

    public static final int SENSOR_DELAY_GAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "A5C157721933C9520D4EEB1DE32DA6DE", hash_generated_field = "34CB384FEDB81178485444F2DF81E938")

    public static final int SENSOR_DELAY_UI = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "B68520CCCDABA2C0E4D44443106473E2", hash_generated_field = "ACB21A0A585352CC21D7D912BD549396")

    public static final int SENSOR_DELAY_NORMAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "53CA3D890B4BE5D284732B24203C3802", hash_generated_field = "793474660C061F4E91B691854E0C0210")

    public static final int SENSOR_STATUS_UNRELIABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "64379DE9C68E76F0251796861167BE6A", hash_generated_field = "3F2964151ACC9B0BA71471A94E89BA79")

    public static final int SENSOR_STATUS_ACCURACY_LOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "9D66606D0DB115A7008AD81596C5F8D9", hash_generated_field = "8281325EE294F56AC1F2FD20E0D435FD")

    public static final int SENSOR_STATUS_ACCURACY_MEDIUM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "0421BABEDF4DD6736C089369F5F1E37C", hash_generated_field = "1631007B616B86584B93182CCFA5F767")

    public static final int SENSOR_STATUS_ACCURACY_HIGH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "61898D2E79EAC458110D149AE3383F10", hash_generated_field = "6D9F2A6D7916944793A0E02EE9DAC11A")

    public static final int AXIS_X = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "5911E0BE3B6D7585D28EE81F64C78D86", hash_generated_field = "C26BE798D392A2035397D2CCF263856A")

    public static final int AXIS_Y = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "B565FB1D8E0C65566F61B2B5EDF6DFCE", hash_generated_field = "99DB4EB9E499DC8FD3F2A6667C2A655F")

    public static final int AXIS_Z = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "168EA56FAB59195DEDE7E86CE0729275", hash_generated_field = "3F3B6B92E6A1B2949A1EA7FCEDD211D6")

    public static final int AXIS_MINUS_X = AXIS_X | 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "272F0E95C20AE9886F5458759073F550", hash_generated_field = "256747ACA3A6B7781B5CC10FE1504A89")

    public static final int AXIS_MINUS_Y = AXIS_Y | 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "001CC8A4B22A0DB399377C9DC9088370", hash_generated_field = "6A8882357B156DD35296D89B47D4D0E6")

    public static final int AXIS_MINUS_Z = AXIS_Z | 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "91F0FAAEF284F777B9CED6BEB115CD98", hash_generated_field = "0B37599A21C0B41121A764FFBD9EADED")

    private static final int SENSOR_DISABLE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "031C76E33B9461ACEE8BD3BD5EDF4B8B", hash_generated_field = "239E704B77E2A22CC375A94A4D19171C")

    private static boolean sSensorModuleInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "76824A59663511EA0370709A3BAB2660", hash_generated_field = "B57A3B1812D8F35DF7BF04190BDD96FA")

    private static ArrayList<Sensor> sFullSensorsList = new ArrayList<Sensor>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "E6334D220E08189D43EACB2F632A979B", hash_generated_field = "25CA1152319FF4B5C0D7E7F8076D16ED")

    private static SparseArray<List<Sensor>> sSensorListByType = new SparseArray<List<Sensor>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.103 -0400", hash_original_field = "DE97087D3E19CB4D19590D5EDC0B28DE", hash_generated_field = "9FFB1E54F186971CA192F7BE25683B37")

    private static IWindowManager sWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.104 -0400", hash_original_field = "F7F7DA17FF62BE660827ABDCA48F1859", hash_generated_field = "0BBAD8D916700BAD614C4C1F4378A2FE")

    private static int sRotation = Surface.ROTATION_0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.104 -0400", hash_original_field = "CD8EE599E533AA215756A75793735016", hash_generated_field = "A8490936AB367117DB9EB37709DAADF2")

    private static SensorThread sSensorThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.104 -0400", hash_original_field = "2E6EFCCCFACB75BE4B413B94588CBA28", hash_generated_field = "085EF692D1F4F5696051F009EDF77397")

    private static int sQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.104 -0400", hash_original_field = "E60156BCFA0D761783FF428DFB8D840D", hash_generated_field = "BCFD400BB8D3E8AD87E27FCB7A4C3151")

    static SparseArray<Sensor> sHandleToSensor = new SparseArray<Sensor>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.104 -0400", hash_original_field = "D844674D7BDF4311669416A6B2D57E1A", hash_generated_field = "65AB8B1411F9486973328C8F78BB86A3")

    static final ArrayList<ListenerDelegate> sListeners = new ArrayList<ListenerDelegate>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.104 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "15CA115588C710DFD7C46B04856CF02D")

    private static SensorEventPool sPool;
}

