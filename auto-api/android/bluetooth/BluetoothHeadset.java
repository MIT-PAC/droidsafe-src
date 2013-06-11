package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class BluetoothHeadset implements BluetoothProfile {
    private static final String TAG = "BluetoothHeadset";
    private static final boolean DBG = false;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AUDIO_STATE_CHANGED =
        "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_VENDOR_SPECIFIC_HEADSET_EVENT =
            "android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT";
    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD";
    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE";
    public static final int AT_CMD_TYPE_READ = 0;
    public static final int AT_CMD_TYPE_TEST = 1;
    public static final int AT_CMD_TYPE_SET = 2;
    public static final int AT_CMD_TYPE_BASIC = 3;
    public static final int AT_CMD_TYPE_ACTION = 4;
    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_ARGS =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_ARGS";
    public static final String VENDOR_SPECIFIC_HEADSET_EVENT_COMPANY_ID_CATEGORY  =
            "android.bluetooth.headset.intent.category.companyid";
    public static final int STATE_AUDIO_DISCONNECTED = 10;
    public static final int STATE_AUDIO_CONNECTING = 11;
    public static final int STATE_AUDIO_CONNECTED = 12;
    private Context mContext;
    private ServiceListener mServiceListener;
    private IBluetoothHeadset mService;
    BluetoothAdapter mAdapter;
    private ServiceConnection mConnection = new ServiceConnection() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.130 -0400", hash_original_method = "49B1367FF57AEC89B6CC00CC921EF188", hash_generated_method = "DB1E3E6D959C6EFA5D5E152866F332CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceConnected(ComponentName className, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(service.dsTaint);
            dsTaint.addTaint(className.dsTaint);
            Log.d(TAG, "Proxy object connected");
            mService = IBluetoothHeadset.Stub.asInterface(service);
            {
                mServiceListener.onServiceConnected(BluetoothProfile.HEADSET, BluetoothHeadset.this);
            } //End block
            // ---------- Original Method ----------
            //if (DBG) Log.d(TAG, "Proxy object connected");
            //mService = IBluetoothHeadset.Stub.asInterface(service);
            //if (mServiceListener != null) {
                //mServiceListener.onServiceConnected(BluetoothProfile.HEADSET, BluetoothHeadset.this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.131 -0400", hash_original_method = "5E9993D21DC5F46D871DD6D0C9DF0475", hash_generated_method = "4ECFF7073869307594B9E8F28D480B6C")
        @DSModeled(DSC.SAFE)
        public void onServiceDisconnected(ComponentName className) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(className.dsTaint);
            Log.d(TAG, "Proxy object disconnected");
            mService = null;
            {
                mServiceListener.onServiceDisconnected(BluetoothProfile.HEADSET);
            } //End block
            // ---------- Original Method ----------
            //if (DBG) Log.d(TAG, "Proxy object disconnected");
            //mService = null;
            //if (mServiceListener != null) {
                //mServiceListener.onServiceDisconnected(BluetoothProfile.HEADSET);
            //}
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.134 -0400", hash_original_method = "B2E3A495C7EEB290E3194E45B33ED96D", hash_generated_method = "E930D077ED9E261E216CD545FB27779C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BluetoothHeadset(Context context, ServiceListener l) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(l.dsTaint);
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        {
            boolean var314790CAEB8D37BCE5D315A936D0DBAF_1045515942 = (!context.bindService(new Intent(IBluetoothHeadset.class.getName()), mConnection, 0));
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mContext = context;
        //mServiceListener = l;
        //mAdapter = BluetoothAdapter.getDefaultAdapter();
        //if (!context.bindService(new Intent(IBluetoothHeadset.class.getName()), mConnection, 0)) {
            //Log.e(TAG, "Could not bind to Bluetooth Headset Service");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.134 -0400", hash_original_method = "072F8B79FA7D55AD4D16BF2975AA6259", hash_generated_method = "3DC5A005BD53EA796E0886A3AC3D412D")
    @DSModeled(DSC.SAFE)
    synchronized void close() {
        log("close()");
        {
            mContext.unbindService(mConnection);
            mConnection = null;
        } //End block
        mServiceListener = null;
        // ---------- Original Method ----------
        //if (DBG) log("close()");
        //if (mConnection != null) {
            //mContext.unbindService(mConnection);
            //mConnection = null;
        //}
        //mServiceListener = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.135 -0400", hash_original_method = "7284EC53ABB82E4A2B97F7B894F0105F", hash_generated_method = "9C5D1F8DF8A4B7488B364BB0ACF6FF97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean connect(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("connect(" + device + ")");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_987842835 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    boolean var0B2C239D4BAE8E44AF458661F9C7F268_2066961269 = (mService.connect(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("connect(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.connect(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.135 -0400", hash_original_method = "4AB2501852FA35F2A69CDF567F29169A", hash_generated_method = "AD2ED0EE063FAEBBD6FF3E144602823F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disconnect(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("disconnect(" + device + ")");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_53861490 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    boolean var71FA15D7E0A69D19CE95C271096764B8_1741483163 = (mService.disconnect(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("disconnect(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.disconnect(device);
            //} catch (RemoteException e) {
              //Log.e(TAG, Log.getStackTraceString(new Throwable()));
              //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.136 -0400", hash_original_method = "49C359566F3934D08711C62C957BAB9A", hash_generated_method = "A4E773F865913C59722A015FECA26290")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<BluetoothDevice> getConnectedDevices() {
        log("getConnectedDevices()");
        {
            boolean varB81A0A2D0AE0723D883CBEEC3048B722_2070206964 = (mService != null && isEnabled());
            {
                try 
                {
                    List<BluetoothDevice> var449D2BC70868AB9A2F6526D716647723_143249232 = (mService.getConnectedDevices());
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return (List<BluetoothDevice>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (DBG) log("getConnectedDevices()");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getConnectedDevices();
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.136 -0400", hash_original_method = "E177F9FA262CA684CC709DA528C57F1A", hash_generated_method = "4CD620041DFCA6E778F8E568A883F663")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(states);
        log("getDevicesMatchingStates()");
        {
            boolean varB81A0A2D0AE0723D883CBEEC3048B722_1622202433 = (mService != null && isEnabled());
            {
                try 
                {
                    List<BluetoothDevice> var40F1746C17CD2B3D4B5C9C2D6BDAED2B_1962687433 = (mService.getDevicesMatchingConnectionStates(states));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return (List<BluetoothDevice>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (DBG) log("getDevicesMatchingStates()");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.getDevicesMatchingConnectionStates(states);
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.137 -0400", hash_original_method = "1FDB9A860CA32B38F33F04C33CC0DC9B", hash_generated_method = "2840219CD85386BB3402BEA8DD65D493")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getConnectionState(BluetoothDevice device) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(device.dsTaint);
        log("getConnectionState(" + device + ")");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_2078622468 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    int varF6A1731FCC853A33EF63A35CD176E322_1457928303 = (mService.getConnectionState(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (DBG) log("getConnectionState(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.getConnectionState(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return BluetoothProfile.STATE_DISCONNECTED;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return BluetoothProfile.STATE_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.137 -0400", hash_original_method = "F982CE0C4DEC9189A14DF4553C949192", hash_generated_method = "459E2C5F7B95A2314D624B68203F8841")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setPriority(BluetoothDevice device, int priority) {
        dsTaint.addTaint(priority);
        dsTaint.addTaint(device.dsTaint);
        log("setPriority(" + device + ", " + priority + ")");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_949959514 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    boolean varEBEC3DA2438F0652C8BED4C88A98B344_1982225870 = (mService.setPriority(device, priority));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("setPriority(" + device + ", " + priority + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //if (priority != BluetoothProfile.PRIORITY_OFF &&
                //priority != BluetoothProfile.PRIORITY_ON) {
              //return false;
            //}
            //try {
                //return mService.setPriority(device, priority);
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.138 -0400", hash_original_method = "705F88F05E8E78847084743E12D945BD", hash_generated_method = "71DED66B79CAC1F24CAFFB6EE754AF6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPriority(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("getPriority(" + device + ")");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_1683022385 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    int varAE155C73B81672E14DF83F4514164E0F_943893008 = (mService.getPriority(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (DBG) log("getPriority(" + device + ")");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.getPriority(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, Log.getStackTraceString(new Throwable()));
                //return PRIORITY_OFF;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return PRIORITY_OFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.138 -0400", hash_original_method = "27AD2A5F99F8BC607BCDEC817A66E20B", hash_generated_method = "C1C717DB8AFBE80BE18BEA3F9EF3A805")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startVoiceRecognition(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("startVoiceRecognition()");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_1929882133 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    boolean var080BAA34874C69C19884E5A7EE3C451D_866959924 = (mService.startVoiceRecognition(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("startVoiceRecognition()");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.startVoiceRecognition(device);
            //} catch (RemoteException e) {
                //Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.139 -0400", hash_original_method = "9C079C73E681F82F25C06C8EF6915217", hash_generated_method = "B38EAE61E634D0E74874B9563B97C547")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean stopVoiceRecognition(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("stopVoiceRecognition()");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_1493700811 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    boolean varA4734C4406290735E0F4E57412DDD671_87293897 = (mService.stopVoiceRecognition(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("stopVoiceRecognition()");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.stopVoiceRecognition(device);
            //} catch (RemoteException e) {
                //Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.139 -0400", hash_original_method = "B8A3B3939435110554206CE07E152F67", hash_generated_method = "C5434BD8DF92C012E6A86181F914D728")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAudioConnected(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("isAudioConnected()");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_2098996833 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    boolean varBA315ADD546215670D74E2B6933C8287_896700652 = (mService.isAudioConnected(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("isAudioConnected()");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
              //return mService.isAudioConnected(device);
            //} catch (RemoteException e) {
              //Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.140 -0400", hash_original_method = "6F6D31332C45DEAF9F6DB793EAF6FAFC", hash_generated_method = "AF5874E9502DBB106C067AB0402E2323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBatteryUsageHint(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("getBatteryUsageHint()");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_1928206837 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    int varE006B2B867DFA2745988E265B27086E8_779784529 = (mService.getBatteryUsageHint(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (DBG) log("getBatteryUsageHint()");
        //if (mService != null && isEnabled() &&
            //isValidDevice(device)) {
            //try {
                //return mService.getBatteryUsageHint(device);
            //} catch (RemoteException e) {
                //Log.e(TAG,  Log.getStackTraceString(new Throwable()));
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.140 -0400", hash_original_method = "7DFB2B07729CC5CD070DB2D2031A339C", hash_generated_method = "869441714ECC050145171561C4601151")
    public static boolean isBluetoothVoiceDialingEnabled(Context context) {
        return context.getResources().getBoolean(
                com.android.internal.R.bool.config_bluetooth_sco_off_call);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.140 -0400", hash_original_method = "2676E323C2C9765143A21FFE59CC6873", hash_generated_method = "2A14D5707D7E28B723AAC536EFFFC9C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean cancelConnectThread() {
        log("cancelConnectThread");
        {
            boolean varB81A0A2D0AE0723D883CBEEC3048B722_4351956 = (mService != null && isEnabled());
            {
                try 
                {
                    boolean var60A6C0824EC823D0A84E6B7D1D6E71B9_945615576 = (mService.cancelConnectThread());
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                Log.d(TAG, Log.getStackTraceString(new Throwable()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("cancelConnectThread");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.cancelConnectThread();
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.141 -0400", hash_original_method = "EA55CECCBAC2EAE8EDC221C89634D263", hash_generated_method = "89A74E28E4AE0019322F0868B0EF2FDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean acceptIncomingConnect(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("acceptIncomingConnect");
        {
            boolean varB81A0A2D0AE0723D883CBEEC3048B722_51589452 = (mService != null && isEnabled());
            {
                try 
                {
                    boolean varFEA5049EC427D551488F3F320E8B6581_1603691186 = (mService.acceptIncomingConnect(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                Log.d(TAG, Log.getStackTraceString(new Throwable()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("acceptIncomingConnect");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.acceptIncomingConnect(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.141 -0400", hash_original_method = "6D2538BEDFF897738BE4A0A290C33070", hash_generated_method = "293599567CA6303EF4AF805D4A7A3D20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean createIncomingConnect(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("createIncomingConnect");
        {
            boolean varB81A0A2D0AE0723D883CBEEC3048B722_761879313 = (mService != null && isEnabled());
            {
                try 
                {
                    boolean varDECCB4447B617A981BAF5A18B1D8DA65_2109996367 = (mService.createIncomingConnect(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                Log.d(TAG, Log.getStackTraceString(new Throwable()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("createIncomingConnect");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.createIncomingConnect(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.142 -0400", hash_original_method = "4505463E5EDB411267D82D01A0F1D824", hash_generated_method = "5ADC64A8BF4C2661484EF7D6C8D31ECD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean rejectIncomingConnect(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("rejectIncomingConnect");
        {
            try 
            {
                boolean var82BFAC441A278AE2E64C21ADB05E0F45_6659660 = (mService.rejectIncomingConnect(device));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("rejectIncomingConnect");
        //if (mService != null) {
            //try {
                //return mService.rejectIncomingConnect(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.142 -0400", hash_original_method = "A8F7BAC49E734C18D4B72E93D6F191D5", hash_generated_method = "D1E4A638E8DA920F6BE558DE194C6ECE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean connectHeadsetInternal(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("connectHeadsetInternal");
        {
            boolean varB81A0A2D0AE0723D883CBEEC3048B722_1260162147 = (mService != null && isEnabled());
            {
                try 
                {
                    boolean var1B4A762D62ACFA202806B8C5A2BD4373_2136855518 = (mService.connectHeadsetInternal(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                Log.d(TAG, Log.getStackTraceString(new Throwable()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("connectHeadsetInternal");
        //if (mService != null && isEnabled()) {
            //try {
                //return mService.connectHeadsetInternal(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.143 -0400", hash_original_method = "DE8B58BD5456FA1A62F7BE53852C68CF", hash_generated_method = "BFB5A419CBF4A9DD85F374B989A46CD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disconnectHeadsetInternal(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("disconnectHeadsetInternal");
        {
            boolean varCB3EEC539906276135EF93563ADDE943_589486918 = (mService != null && !isDisabled());
            {
                try 
                {
                    boolean varDB21CBCEB039577AF9B65375C3A6FA58_695306509 = (mService.disconnectHeadsetInternal(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                Log.d(TAG, Log.getStackTraceString(new Throwable()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("disconnectHeadsetInternal");
        //if (mService != null && !isDisabled()) {
            //try {
                 //return mService.disconnectHeadsetInternal(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.143 -0400", hash_original_method = "04E80317E50A33841443E656AF5FDA5A", hash_generated_method = "098721FC3B4B164CD5BE0D0B7E2E09C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setAudioState(BluetoothDevice device, int state) {
        dsTaint.addTaint(device.dsTaint);
        dsTaint.addTaint(state);
        log("setAudioState");
        {
            boolean varCB3EEC539906276135EF93563ADDE943_494047381 = (mService != null && !isDisabled());
            {
                try 
                {
                    boolean var0269E11DED944D246E165391AD8047C9_1658266179 = (mService.setAudioState(device, state));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                Log.d(TAG, Log.getStackTraceString(new Throwable()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("setAudioState");
        //if (mService != null && !isDisabled()) {
            //try {
                //return mService.setAudioState(device, state);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.144 -0400", hash_original_method = "398E968FC0AE96999E6F1C9EB97CF08A", hash_generated_method = "F29DC83CB5D1328E0C90C679C6E677C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAudioState(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("getAudioState");
        {
            boolean varCB3EEC539906276135EF93563ADDE943_38184319 = (mService != null && !isDisabled());
            {
                try 
                {
                    int var022337647BD5A98254C7AC96BE6A3F39_1277091165 = (mService.getAudioState(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                Log.d(TAG, Log.getStackTraceString(new Throwable()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (DBG) log("getAudioState");
        //if (mService != null && !isDisabled()) {
            //try {
                //return mService.getAudioState(device);
            //} catch (RemoteException e) {Log.e(TAG, e.toString());}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return BluetoothHeadset.STATE_AUDIO_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.144 -0400", hash_original_method = "D15419F6AD1B4E28C80D3421F9F86FA4", hash_generated_method = "E89EDD124C1D0CEE26FB01FF10F5197C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startScoUsingVirtualVoiceCall(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("startScoUsingVirtualVoiceCall()");
        {
            boolean var2F4287189D762EE54965825E0EA4AADE_1448686029 = (mService != null && isEnabled() && isValidDevice(device));
            {
                try 
                {
                    boolean var634617523BCC6C08620830620D2AEACF_1216235917 = (mService.startScoUsingVirtualVoiceCall(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                Log.d(TAG, Log.getStackTraceString(new Throwable()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("startScoUsingVirtualVoiceCall()");
        //if (mService != null && isEnabled() && isValidDevice(device)) {
            //try {
                //return mService.startScoUsingVirtualVoiceCall(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, e.toString());
            //}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.145 -0400", hash_original_method = "EC64256DA9DAF95A4E5DDEFAF84087E3", hash_generated_method = "72F5754A8BEFF52006078F237CAD12A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean stopScoUsingVirtualVoiceCall(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("stopScoUsingVirtualVoiceCall()");
        {
            boolean var2F4287189D762EE54965825E0EA4AADE_183505884 = (mService != null && isEnabled() && isValidDevice(device));
            {
                try 
                {
                    boolean varD86823B025FA6FE98DC039B6ADE2A1AE_612842191 = (mService.stopScoUsingVirtualVoiceCall(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                Log.d(TAG, Log.getStackTraceString(new Throwable()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("stopScoUsingVirtualVoiceCall()");
        //if (mService != null && isEnabled() && isValidDevice(device)) {
            //try {
                //return mService.stopScoUsingVirtualVoiceCall(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, e.toString());
            //}
        //} else {
            //Log.w(TAG, "Proxy not attached to service");
            //if (DBG) Log.d(TAG, Log.getStackTraceString(new Throwable()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.145 -0400", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "5C748AB809A75ECA1CDA67BD83366067")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isEnabled() {
        {
            boolean var5C924306E6A8C4449032AD0CEF8AEE9F_1849007794 = (mAdapter.getState() == BluetoothAdapter.STATE_ON);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAdapter.getState() == BluetoothAdapter.STATE_ON) return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.145 -0400", hash_original_method = "7FB46929D91880D43466C28024A250A9", hash_generated_method = "702BB48944553C60A3557D9F8B251291")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isDisabled() {
        {
            boolean var91DD12ACD451E6F1BFE84765D8E291B4_958260492 = (mAdapter.getState() == BluetoothAdapter.STATE_OFF);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAdapter.getState() == BluetoothAdapter.STATE_OFF) return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.146 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "FE710A2DB9701BB0FC4984063CD0DD8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isValidDevice(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            boolean var558C44A3DBC8E7A99E7932AB31FA9A40_316197813 = (BluetoothAdapter.checkBluetoothAddress(device.getAddress()));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (device == null) return false;
        //if (BluetoothAdapter.checkBluetoothAddress(device.getAddress())) return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.146 -0400", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
}


