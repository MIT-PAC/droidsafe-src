package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.server.BluetoothA2dpService;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class BluetoothA2dp implements BluetoothProfile {
    private static final String TAG = "BluetoothA2dp";
    private static final boolean DBG = false;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PLAYING_STATE_CHANGED =
        "android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED";
    public static final int STATE_PLAYING   =  10;
    public static final int STATE_NOT_PLAYING   =  11;
    private ServiceListener mServiceListener;
    private IBluetoothA2dp mService;
    private BluetoothAdapter mAdapter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.037 -0400", hash_original_method = "84AC70841E1DE8A91A25AE9B1E768BDD", hash_generated_method = "8C6C8BF2E3262F4F31C2AD79C8F09CD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BluetoothA2dp(Context mContext, ServiceListener l) {
        dsTaint.addTaint(mContext.dsTaint);
        dsTaint.addTaint(l.dsTaint);
        IBinder b;
        b = ServiceManager.getService(BluetoothA2dpService.BLUETOOTH_A2DP_SERVICE);
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        {
            mService = IBluetoothA2dp.Stub.asInterface(b);
            {
                mServiceListener.onServiceConnected(BluetoothProfile.A2DP, this);
            } //End block
        } //End block
        {
            mService = null;
        } //End block
        // ---------- Original Method ----------
        //IBinder b = ServiceManager.getService(BluetoothA2dpService.BLUETOOTH_A2DP_SERVICE);
        //mServiceListener = l;
        //mAdapter = BluetoothAdapter.getDefaultAdapter();
        //if (b != null) {
            //mService = IBluetoothA2dp.Stub.asInterface(b);
            //if (mServiceListener != null) {
                //mServiceListener.onServiceConnected(BluetoothProfile.A2DP, this);
            //}
        //} else {
            //Log.w(TAG, "Bluetooth A2DP service not available!");
            //mService = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.037 -0400", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "2B5C53A388AA66DBF36E2B8DAB2C66B5")
    @DSModeled(DSC.SAFE)
     void close() {
        mServiceListener = null;
        // ---------- Original Method ----------
        //mServiceListener = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.038 -0400", hash_original_method = "700825FC4ECAB3A433DC66A7B0E84928", hash_generated_method = "597F33E242DAFA89346BC4CDAFD2E93D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean connect(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("connect(" + device + ")");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_457870533 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    boolean var0B2C239D4BAE8E44AF458661F9C7F268_118371338 = (mService.connect(device));
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
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.038 -0400", hash_original_method = "55DF4D676FC35487D0748922C473702F", hash_generated_method = "4502EC8CB9D1230331BE0381F7DE9977")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disconnect(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("disconnect(" + device + ")");
        {
            boolean var0369C0FFAF1FB08DA9DD99035656313C_1893139260 = (mService != null && isEnabled() &&
            isValidDevice(device));
            {
                try 
                {
                    boolean var71FA15D7E0A69D19CE95C271096764B8_914545694 = (mService.disconnect(device));
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
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.039 -0400", hash_original_method = "0ADED1F6ADFCC469E1E307997E79DBB8", hash_generated_method = "3BAF7D575B0CEF1EB55A4AA4D6CA2D0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<BluetoothDevice> getConnectedDevices() {
        log("getConnectedDevices()");
        {
            boolean varB81A0A2D0AE0723D883CBEEC3048B722_673208841 = (mService != null && isEnabled());
            {
                try 
                {
                    List<BluetoothDevice> var449D2BC70868AB9A2F6526D716647723_895808349 = (mService.getConnectedDevices());
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
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.039 -0400", hash_original_method = "EE46EB26B83008ABEDB21DB2056FFA88", hash_generated_method = "DA4BFCEA1BF65D833C1263E113490F76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(states);
        log("getDevicesMatchingStates()");
        {
            boolean varB81A0A2D0AE0723D883CBEEC3048B722_1225567592 = (mService != null && isEnabled());
            {
                try 
                {
                    List<BluetoothDevice> var40F1746C17CD2B3D4B5C9C2D6BDAED2B_1753501534 = (mService.getDevicesMatchingConnectionStates(states));
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
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return new ArrayList<BluetoothDevice>();
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return new ArrayList<BluetoothDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.040 -0400", hash_original_method = "B281ECAF166EAE88B310FDB0152ACEB7", hash_generated_method = "F57387B46239D9D9120AD74CEB36069D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getConnectionState(BluetoothDevice device) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(device.dsTaint);
        log("getState(" + device + ")");
        {
            boolean var8EA1B893EE6F9B51A9D1D26CB29FF950_972419917 = (mService != null && isEnabled()
            && isValidDevice(device));
            {
                try 
                {
                    int varF6A1731FCC853A33EF63A35CD176E322_998601615 = (mService.getConnectionState(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (DBG) log("getState(" + device + ")");
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.getConnectionState(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return BluetoothProfile.STATE_DISCONNECTED;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return BluetoothProfile.STATE_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.040 -0400", hash_original_method = "2B40F2C1D807822C775F30BF280CDA0D", hash_generated_method = "796D414CA033D7408C04CF666A6CA012")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setPriority(BluetoothDevice device, int priority) {
        dsTaint.addTaint(priority);
        dsTaint.addTaint(device.dsTaint);
        log("setPriority(" + device + ", " + priority + ")");
        {
            boolean var8EA1B893EE6F9B51A9D1D26CB29FF950_1029497874 = (mService != null && isEnabled()
            && isValidDevice(device));
            {
                try 
                {
                    boolean varEBEC3DA2438F0652C8BED4C88A98B344_1311507667 = (mService.setPriority(device, priority));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("setPriority(" + device + ", " + priority + ")");
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //if (priority != BluetoothProfile.PRIORITY_OFF &&
                //priority != BluetoothProfile.PRIORITY_ON) {
              //return false;
            //}
            //try {
                //return mService.setPriority(device, priority);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.041 -0400", hash_original_method = "23F2360BBDC60C257F7868DD2B8A1B81", hash_generated_method = "5C284C137C18A26BB8B16F98DD0F0B54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPriority(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        log("getPriority(" + device + ")");
        {
            boolean var8EA1B893EE6F9B51A9D1D26CB29FF950_850769184 = (mService != null && isEnabled()
            && isValidDevice(device));
            {
                try 
                {
                    int varAE155C73B81672E14DF83F4514164E0F_1038416643 = (mService.getPriority(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (DBG) log("getPriority(" + device + ")");
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.getPriority(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return BluetoothProfile.PRIORITY_OFF;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return BluetoothProfile.PRIORITY_OFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.041 -0400", hash_original_method = "0A81AC976D9A0E28DF6B1DEC7E34C5D3", hash_generated_method = "59F21F46DD650EA56FCFBDFCAB644829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isA2dpPlaying(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            boolean var8EA1B893EE6F9B51A9D1D26CB29FF950_1913381883 = (mService != null && isEnabled()
            && isValidDevice(device));
            {
                try 
                {
                    boolean var0A15C358AA0B37CFA906F1B340129A52_902074388 = (mService.isA2dpPlaying(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.isA2dpPlaying(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.042 -0400", hash_original_method = "FEE19D0C9AEE9A75BC73A57692A1B159", hash_generated_method = "ED4395DC6DA53371DF399B888B5CDE7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean suspendSink(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            boolean var8EA1B893EE6F9B51A9D1D26CB29FF950_107438065 = (mService != null && isEnabled()
            && isValidDevice(device));
            {
                try 
                {
                    boolean var659895D78BC5E8AD25F7204F8FE2E071_544415159 = (mService.suspendSink(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.suspendSink(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.042 -0400", hash_original_method = "18AFE84D45293B01197D290EE720FEAA", hash_generated_method = "AC16222E3467200BD00772E69E67DBFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean resumeSink(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            boolean var8EA1B893EE6F9B51A9D1D26CB29FF950_1373484190 = (mService != null && isEnabled()
            && isValidDevice(device));
            {
                try 
                {
                    boolean var620E2FC144F02847D84B1611BF1B4653_580993974 = (mService.resumeSink(device));
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mService != null && isEnabled()
            //&& isValidDevice(device)) {
            //try {
                //return mService.resumeSink(device);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                //return false;
            //}
        //}
        //if (mService == null) Log.w(TAG, "Proxy not attached to service");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.043 -0400", hash_original_method = "FF7FB4D142B82B6A187917634C749F84", hash_generated_method = "775625D9CC5DC2CF53E117233979C127")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean shouldSendVolumeKeys(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            boolean var05AD1E5902C31315702435694F7F4C73_1433028788 = (isEnabled() && isValidDevice(device));
            {
                ParcelUuid[] uuids;
                uuids = device.getUuids();
                {
                    Iterator<ParcelUuid> seatecAstronomy42 = uuids.iterator();
                    seatecAstronomy42.hasNext();
                    ParcelUuid uuid = seatecAstronomy42.next();
                    {
                        {
                            boolean var9B037CD7A2FF4EFAAE8122439AA2F725_1241546030 = (BluetoothUuid.isAvrcpTarget(uuid));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isEnabled() && isValidDevice(device)) {
            //ParcelUuid[] uuids = device.getUuids();
            //if (uuids == null) return false;
            //for (ParcelUuid uuid: uuids) {
                //if (BluetoothUuid.isAvrcpTarget(uuid)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.043 -0400", hash_original_method = "29CED80F2164214524C1FC1AF02F2B1A", hash_generated_method = "DDF1A9F6EFAE7BA6C5375B66CA9FD400")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean allowIncomingConnect(BluetoothDevice device, boolean value) {
        dsTaint.addTaint(device.dsTaint);
        dsTaint.addTaint(value);
        log("allowIncomingConnect(" + device + ":" + value + ")");
        try 
        {
            boolean var4A6093A74EA0BB9D4A70FCD273FE3FB8_384078466 = (mService.allowIncomingConnect(device, value));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("allowIncomingConnect(" + device + ":" + value + ")");
        //try {
            //return mService.allowIncomingConnect(device, value);
        //} catch (RemoteException e) {
            //Log.e(TAG, "", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.044 -0400", hash_original_method = "291F5B4072A01706D5283F5804B360A4", hash_generated_method = "BF1DDA278ADBC5A1516FEB70F1D9E90F")
    public static String stateToString(int state) {
        switch (state) {
        case STATE_DISCONNECTED:
            return "disconnected";
        case STATE_CONNECTING:
            return "connecting";
        case STATE_CONNECTED:
            return "connected";
        case STATE_DISCONNECTING:
            return "disconnecting";
        case STATE_PLAYING:
            return "playing";
        case STATE_NOT_PLAYING:
          return "not playing";
        default:
            return "<unknown state " + state + ">";
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.044 -0400", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "3E81110819236003DC0B5E0756F26E86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isEnabled() {
        {
            boolean var5C924306E6A8C4449032AD0CEF8AEE9F_1872672027 = (mAdapter.getState() == BluetoothAdapter.STATE_ON);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAdapter.getState() == BluetoothAdapter.STATE_ON) return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.044 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "DF476D3D84C6352AB3DD210A731384C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isValidDevice(BluetoothDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            boolean var558C44A3DBC8E7A99E7932AB31FA9A40_1033444968 = (BluetoothAdapter.checkBluetoothAddress(device.getAddress()));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (device == null) return false;
        //if (BluetoothAdapter.checkBluetoothAddress(device.getAddress())) return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.044 -0400", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
}


