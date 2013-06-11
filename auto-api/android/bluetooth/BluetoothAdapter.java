package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public final class BluetoothAdapter {
    private static final String TAG = "BluetoothAdapter";
    private static final boolean DBG = false;
    public static final int ERROR = Integer.MIN_VALUE;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_STATE_CHANGED =
            "android.bluetooth.adapter.action.STATE_CHANGED";
    public static final String EXTRA_STATE =
            "android.bluetooth.adapter.extra.STATE";
    public static final String EXTRA_PREVIOUS_STATE =
            "android.bluetooth.adapter.extra.PREVIOUS_STATE";
    public static final int STATE_OFF = 10;
    public static final int STATE_TURNING_ON = 11;
    public static final int STATE_ON = 12;
    public static final int STATE_TURNING_OFF = 13;
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_REQUEST_DISCOVERABLE =
            "android.bluetooth.adapter.action.REQUEST_DISCOVERABLE";
    public static final String EXTRA_DISCOVERABLE_DURATION =
            "android.bluetooth.adapter.extra.DISCOVERABLE_DURATION";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_REQUEST_ENABLE =
            "android.bluetooth.adapter.action.REQUEST_ENABLE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCAN_MODE_CHANGED =
            "android.bluetooth.adapter.action.SCAN_MODE_CHANGED";
    public static final String EXTRA_SCAN_MODE = "android.bluetooth.adapter.extra.SCAN_MODE";
    public static final String EXTRA_PREVIOUS_SCAN_MODE =
            "android.bluetooth.adapter.extra.PREVIOUS_SCAN_MODE";
    public static final int SCAN_MODE_NONE = 20;
    public static final int SCAN_MODE_CONNECTABLE = 21;
    public static final int SCAN_MODE_CONNECTABLE_DISCOVERABLE = 23;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DISCOVERY_STARTED =
            "android.bluetooth.adapter.action.DISCOVERY_STARTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DISCOVERY_FINISHED =
            "android.bluetooth.adapter.action.DISCOVERY_FINISHED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_LOCAL_NAME_CHANGED =
            "android.bluetooth.adapter.action.LOCAL_NAME_CHANGED";
    public static final String EXTRA_LOCAL_NAME = "android.bluetooth.adapter.extra.LOCAL_NAME";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED";
    public static final String EXTRA_CONNECTION_STATE =
        "android.bluetooth.adapter.extra.CONNECTION_STATE";
    public static final String EXTRA_PREVIOUS_CONNECTION_STATE =
          "android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE";
    public static final int STATE_DISCONNECTED  = 0;
    public static final int STATE_CONNECTING    = 1;
    public static final int STATE_CONNECTED     = 2;
    public static final int STATE_DISCONNECTING = 3;
    public static final String BLUETOOTH_SERVICE = "bluetooth";
    private static final int ADDRESS_LENGTH = 17;
    private static BluetoothAdapter sAdapter;
    private final IBluetooth mService;
    private Handler mServiceRecordHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.063 -0400", hash_original_method = "5CDBAADAD73677B9DBA69CD49D17E787", hash_generated_method = "2EAEC6F8F0E41E869A197043C75F09BC")
    @DSModeled(DSC.SAFE)
    public BluetoothAdapter(IBluetooth service) {
        dsTaint.addTaint(service.dsTaint);
        {
            throw new IllegalArgumentException("service is null");
        } //End block
        mServiceRecordHandler = null;
        // ---------- Original Method ----------
        //if (service == null) {
            //throw new IllegalArgumentException("service is null");
        //}
        //mService = service;
        //mServiceRecordHandler = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.063 -0400", hash_original_method = "0EA032C93B9BB6C4C1D29146E96BABA8", hash_generated_method = "2A85D30D637B72EC36DE7AF12AA14DD7")
    public static synchronized BluetoothAdapter getDefaultAdapter() {
        if (sAdapter == null) {
            IBinder b = ServiceManager.getService(BluetoothAdapter.BLUETOOTH_SERVICE);
            if (b != null) {
                IBluetooth service = IBluetooth.Stub.asInterface(b);
                sAdapter = new BluetoothAdapter(service);
            }
        }
        return sAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.063 -0400", hash_original_method = "BAA9CF7F2ACFCBAB9569C2DACFA96981", hash_generated_method = "13014149FCC38A031865FAF64540797D")
    @DSModeled(DSC.SAFE)
    public BluetoothDevice getRemoteDevice(String address) {
        dsTaint.addTaint(address);
        return (BluetoothDevice)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BluetoothDevice(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.064 -0400", hash_original_method = "D4868B88346C10F14C8F7C77B49B5DE2", hash_generated_method = "E5071D149479858E535C727DD892C52A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEnabled() {
        try 
        {
            boolean var25B27786296C560F002D8A39058B7704_434714265 = (mService.isEnabled());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.isEnabled();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.064 -0400", hash_original_method = "FCF9C6106F07630DEF71CB873FCC3D8F", hash_generated_method = "7ABE10FDAF726BF2E68C16BABD832CD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getState() {
        try 
        {
            int varF40A2994E9D834EE6532E260119CF12B_870634801 = (mService.getBluetoothState());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.getBluetoothState();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return STATE_OFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.064 -0400", hash_original_method = "F70C75CE8A3147FA6677C79F04CF4B02", hash_generated_method = "201742DB0139B7601DDE3E9ADFF14E1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enable() {
        try 
        {
            boolean var9C911BE8B5BBE2021999A65CC2022CEB_388310234 = (mService.enable());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.enable();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.065 -0400", hash_original_method = "DC1BB7EEB209838517C27214CEB71072", hash_generated_method = "2596893F0A23F895855954F1B1FD5A8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disable() {
        try 
        {
            boolean var353D431F17CA8D97E3AF088CD9A54D95_2090170840 = (mService.disable(true));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.disable(true);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.065 -0400", hash_original_method = "45FE79E8525553C566F03D519E5189F4", hash_generated_method = "ADD849472D2A535826BA2B6D24975DFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAddress() {
        try 
        {
            String var7B759DCAD00E879DE9B6FE9D2470CF67_1029654882 = (mService.getAddress());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return mService.getAddress();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.065 -0400", hash_original_method = "AA5C06C383156A346DC521053F89AB2B", hash_generated_method = "035D92A8802CD73115439079D9D67FF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        try 
        {
            String var4467FDB7F4F17D4819BEBDD0326A4318_1372685276 = (mService.getName());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return mService.getName();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.066 -0400", hash_original_method = "1404BBF93844A5B6047C7A268CEA1843", hash_generated_method = "D2C055CFEC834567F84C03FE217E0AF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParcelUuid[] getUuids() {
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_460516682 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            ParcelUuid[] var3A5F0B82278DB9AFFA0AF921723BCC3C_832261992 = (mService.getUuids());
        } //End block
        catch (RemoteException e)
        { }
        return (ParcelUuid[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return null;
        //try {
            //return mService.getUuids();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.066 -0400", hash_original_method = "08F81801C25A11FE898E4D65E015413F", hash_generated_method = "0BFA0E9377BD4F7DAA748E7FA00D20AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setName(String name) {
        dsTaint.addTaint(name);
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_13181190 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            boolean var7C8D50ABAD5A8B90B45B4D1F36679D68_1278971737 = (mService.setName(name));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //try {
            //return mService.setName(name);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.067 -0400", hash_original_method = "76CF52E29182798DA67FD15A9B155F30", hash_generated_method = "CC7C0A9707EA238F7842FE1627830CF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScanMode() {
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_1143328718 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            int var95BD9A7E7431A5FE83987E78B6F44DFB_987975207 = (mService.getScanMode());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return SCAN_MODE_NONE;
        //try {
            //return mService.getScanMode();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return SCAN_MODE_NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.067 -0400", hash_original_method = "EAE2AE792A5A03E2A7F346C251F56DAF", hash_generated_method = "63A5D6281B8AC0D3868C6E50F66AA18D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setScanMode(int mode, int duration) {
        dsTaint.addTaint(duration);
        dsTaint.addTaint(mode);
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_2050199876 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            boolean varEDDB68F9C5DB8028D6607B11F7F55715_1798732452 = (mService.setScanMode(mode, duration));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //try {
            //return mService.setScanMode(mode, duration);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.067 -0400", hash_original_method = "5FA36C89B86406F549228E4F23C31FB5", hash_generated_method = "953F027FD45C2930205827AB7FCBD34B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setScanMode(int mode) {
        dsTaint.addTaint(mode);
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_610614807 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        boolean varBA530550733FAAF7F47532C36DC2CED8_1194101645 = (setScanMode(mode, 120));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //return setScanMode(mode, 120);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.068 -0400", hash_original_method = "9BECEF34E1AD2659C72AC1024F8DAE1C", hash_generated_method = "DFFAA7F05776B10420EBB0DA72E8646A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDiscoverableTimeout() {
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_1212574085 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            int varBD5546AD7B473B00D2F0F8A4BE89B581_434040134 = (mService.getDiscoverableTimeout());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return -1;
        //try {
            //return mService.getDiscoverableTimeout();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.068 -0400", hash_original_method = "040DE868F00C15E58DE726DEE9429CA3", hash_generated_method = "B2D1C0A42F4BF5D3AEA1AF7040F107F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDiscoverableTimeout(int timeout) {
        dsTaint.addTaint(timeout);
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_1355908324 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            mService.setDiscoverableTimeout(timeout);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return;
        //try {
            //mService.setDiscoverableTimeout(timeout);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.069 -0400", hash_original_method = "10268AD378D15FC8A51253E10EC3C6B2", hash_generated_method = "776B9C322AE11A497CB2E682380E2B35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startDiscovery() {
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_163110321 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            boolean var35CA7BCA3BF9CBC531B07F5B08DA5AF2_816744733 = (mService.startDiscovery());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //try {
            //return mService.startDiscovery();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.069 -0400", hash_original_method = "63E67EB5C61EED8D2B51A1BF56472E25", hash_generated_method = "6BCF32CB97D366CA3A3E37A712D7ECCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean cancelDiscovery() {
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_1598485893 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            boolean var672E1E4770FF807F2431F6DA5AB6A201_535842778 = (mService.cancelDiscovery());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //try {
            //return mService.cancelDiscovery();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.069 -0400", hash_original_method = "C88946A48EEE076D7E3C1C6C5F371E49", hash_generated_method = "4D7F0C8F97E8E0B00DFE53AE2F40C0D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDiscovering() {
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_613987933 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            boolean varAAF226F38FC583DCC13BB5E6F9A92322_1378985107 = (mService.isDiscovering());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //try {
            //return mService.isDiscovering();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.070 -0400", hash_original_method = "A20534464E90E0C8E439D633BB81432E", hash_generated_method = "AB5DDDD7A7D2C40B50CF5738E784F630")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<BluetoothDevice> getBondedDevices() {
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_1715781965 = (getState() != STATE_ON);
            {
                Set<BluetoothDevice> varB571E4DC50040FAA95B96F5B127EA872_1455173684 = (toDeviceSet(new String[0]));
            } //End block
        } //End collapsed parenthetic
        try 
        {
            Set<BluetoothDevice> var1EDCDFCBB6D4AB5CC9127710C4489C89_567845517 = (toDeviceSet(mService.listBonds()));
        } //End block
        catch (RemoteException e)
        { }
        return (Set<BluetoothDevice>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) {
            //return toDeviceSet(new String[0]);
        //}
        //try {
            //return toDeviceSet(mService.listBonds());
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.070 -0400", hash_original_method = "456CF28BE83652F494DDCF30722C3BAD", hash_generated_method = "9C4DAC1F0E9B8F0E65248D07E5232D15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getConnectionState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_1086810018 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            int varBAC176015CFEA974040D678AC8103C8E_1252230692 = (mService.getAdapterConnectionState());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return BluetoothAdapter.STATE_DISCONNECTED;
        //try {
            //return mService.getAdapterConnectionState();
        //} catch (RemoteException e) {Log.e(TAG, "getConnectionState:", e);}
        //return BluetoothAdapter.STATE_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.071 -0400", hash_original_method = "0796F6753B11E4CA7CEE3403756A4526", hash_generated_method = "74861F7B6F38BF5FD1D9D92D7160E9D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getProfileConnectionState(int profile) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(profile);
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_158034217 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            int var2EFA5070FDA53EBD27B5F80ADE45B79E_1606057901 = (mService.getProfileConnectionState(profile));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return BluetoothProfile.STATE_DISCONNECTED;
        //try {
            //return mService.getProfileConnectionState(profile);
        //} catch (RemoteException e) {
            //Log.e(TAG, "getProfileConnectionState:", e);
        //}
        //return BluetoothProfile.STATE_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.071 -0400", hash_original_method = "71D512ADABDF23669C5DC04339CD42B4", hash_generated_method = "B095B396D807A562C03E7EB723F49D4A")
    @DSModeled(DSC.SAFE)
    public BluetoothServerSocket listenUsingRfcommOn(int channel) throws IOException {
        dsTaint.addTaint(channel);
        BluetoothServerSocket socket;
        socket = new BluetoothServerSocket(
                BluetoothSocket.TYPE_RFCOMM, true, true, channel);
        int errno;
        errno = socket.mSocket.bindListen();
        {
            try 
            {
                socket.close();
            } //End block
            catch (IOException e)
            { }
            socket.mSocket.throwErrnoNative(errno);
        } //End block
        return (BluetoothServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BluetoothServerSocket socket = new BluetoothServerSocket(
                //BluetoothSocket.TYPE_RFCOMM, true, true, channel);
        //int errno = socket.mSocket.bindListen();
        //if (errno != 0) {
            //try {
                //socket.close();
            //} catch (IOException e) {}
            //socket.mSocket.throwErrnoNative(errno);
        //}
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.071 -0400", hash_original_method = "89D65DC00BFA81C813C9155DE20CC833", hash_generated_method = "9637E218D7389295E3C7AD1352B97C03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BluetoothServerSocket listenUsingRfcommWithServiceRecord(String name, UUID uuid) throws IOException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(uuid.dsTaint);
        BluetoothServerSocket varA04EF57B1E88CBD258767C36BC2BB38B_726632318 = (createNewRfcommSocketAndRecord(name, uuid, true, true));
        return (BluetoothServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createNewRfcommSocketAndRecord(name, uuid, true, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.072 -0400", hash_original_method = "67A9DCDB5D1364F0197D124A8C117BDF", hash_generated_method = "1C7B31432D61547178812BD0D130013E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord(String name, UUID uuid) throws IOException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(uuid.dsTaint);
        BluetoothServerSocket varE2C5D594F01D0BDEEBF28E550159ACE4_1667018288 = (createNewRfcommSocketAndRecord(name, uuid, false, false));
        return (BluetoothServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createNewRfcommSocketAndRecord(name, uuid, false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.072 -0400", hash_original_method = "D75F65DB3EAF8C02EDFD121756834A36", hash_generated_method = "34C6A14E9FBDFA44D7F53C86A44D42B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BluetoothServerSocket listenUsingEncryptedRfcommWithServiceRecord(
            String name, UUID uuid) throws IOException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(uuid.dsTaint);
        BluetoothServerSocket varFB1ED1D46F5B6427B8CC7BB5A98EE6E6_1008286945 = (createNewRfcommSocketAndRecord(name, uuid, false, true));
        return (BluetoothServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createNewRfcommSocketAndRecord(name, uuid, false, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.073 -0400", hash_original_method = "ABCD96E52C8B56B2C4BF1A6AB6CFAB37", hash_generated_method = "4B0AC7F10079731CFE805E6A778C968E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private BluetoothServerSocket createNewRfcommSocketAndRecord(String name, UUID uuid,
            boolean auth, boolean encrypt) throws IOException {
        dsTaint.addTaint(encrypt);
        dsTaint.addTaint(name);
        dsTaint.addTaint(uuid.dsTaint);
        dsTaint.addTaint(auth);
        RfcommChannelPicker picker;
        picker = new RfcommChannelPicker(uuid);
        BluetoothServerSocket socket;
        int channel;
        int errno;
        {
            channel = picker.nextChannel();
            {
                throw new IOException("No available channels");
            } //End block
            socket = new BluetoothServerSocket(
                    BluetoothSocket.TYPE_RFCOMM, auth, encrypt, channel);
            errno = socket.mSocket.bindListen();
            {
                Log.d(TAG, "listening on RFCOMM channel " + channel);
            } //End block
            {
                Log.d(TAG, "RFCOMM channel " + channel + " in use");
                try 
                {
                    socket.close();
                } //End block
                catch (IOException e)
                { }
            } //End block
            {
                try 
                {
                    socket.close();
                } //End block
                catch (IOException e)
                { }
                socket.mSocket.throwErrnoNative(errno);
            } //End block
        } //End block
        int handle;
        handle = -1;
        try 
        {
            handle = mService.addRfcommServiceRecord(name, new ParcelUuid(uuid), channel,
                    new Binder());
        } //End block
        catch (RemoteException e)
        { }
        {
            try 
            {
                socket.close();
            } //End block
            catch (IOException e)
            { }
            throw new IOException("Not able to register SDP record for " + name);
        } //End block
        {
            mServiceRecordHandler = new Handler(Looper.getMainLooper()) {
                    public void handleMessage(Message msg) {
                        int handle = msg.what;
                        try {
                            if (DBG) Log.d(TAG, "Removing service record " +
                                           Integer.toHexString(handle));
                            mService.removeServiceRecord(handle);
                        } catch (RemoteException e) {Log.e(TAG, "", e);}
                    }
                };
        } //End block
        socket.setCloseHandler(mServiceRecordHandler, handle);
        return (BluetoothServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.073 -0400", hash_original_method = "27EC1A367A39F94DC128CEF34B5C5DD2", hash_generated_method = "D35C87E1FD4CE150135E5DB7C437D38C")
    @DSModeled(DSC.SAFE)
    public BluetoothServerSocket listenUsingInsecureRfcommOn(int port) throws IOException {
        dsTaint.addTaint(port);
        BluetoothServerSocket socket;
        socket = new BluetoothServerSocket(
                BluetoothSocket.TYPE_RFCOMM, false, false, port);
        int errno;
        errno = socket.mSocket.bindListen();
        {
            try 
            {
                socket.close();
            } //End block
            catch (IOException e)
            { }
            socket.mSocket.throwErrnoNative(errno);
        } //End block
        return (BluetoothServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BluetoothServerSocket socket = new BluetoothServerSocket(
                //BluetoothSocket.TYPE_RFCOMM, false, false, port);
        //int errno = socket.mSocket.bindListen();
        //if (errno != 0) {
            //try {
                //socket.close();
            //} catch (IOException e) {}
            //socket.mSocket.throwErrnoNative(errno);
        //}
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.074 -0400", hash_original_method = "7C75ECDC8A8B7963B0A9DF6AD0038A85", hash_generated_method = "50A45D4FFE1A46370F3D8B053812284C")
    @DSModeled(DSC.SAFE)
    public BluetoothServerSocket listenUsingEncryptedRfcommOn(int port) throws IOException {
        dsTaint.addTaint(port);
        BluetoothServerSocket socket;
        socket = new BluetoothServerSocket(
                BluetoothSocket.TYPE_RFCOMM, false, true, port);
        int errno;
        errno = socket.mSocket.bindListen();
        {
            try 
            {
                socket.close();
            } //End block
            catch (IOException e)
            { }
            socket.mSocket.throwErrnoNative(errno);
        } //End block
        return (BluetoothServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BluetoothServerSocket socket = new BluetoothServerSocket(
                //BluetoothSocket.TYPE_RFCOMM, false, true, port);
        //int errno = socket.mSocket.bindListen();
        //if (errno != 0) {
            //try {
                //socket.close();
            //} catch (IOException e) {}
            //socket.mSocket.throwErrnoNative(errno);
        //}
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.074 -0400", hash_original_method = "4FDEAA2F9CA614612C71A6D8B4280274", hash_generated_method = "C37696850A86CCBE485C3A2F5F2792B2")
    public static BluetoothServerSocket listenUsingScoOn() throws IOException {
        BluetoothServerSocket socket = new BluetoothServerSocket(
                BluetoothSocket.TYPE_SCO, false, false, -1);
        int errno = socket.mSocket.bindListen();
        if (errno != 0) {
            try {
                socket.close();
            } catch (IOException e) {}
            socket.mSocket.throwErrnoNative(errno);
        }
        return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.074 -0400", hash_original_method = "ABFDDF29A52D91D363C001D4DD695916", hash_generated_method = "B9FFD50C6D2AC29F44A326F42753E09A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Pair<byte[], byte[]> readOutOfBandData() {
        {
            boolean varF0D2F0335AFFC672C5E34710080A8085_1719313946 = (getState() != STATE_ON);
        } //End collapsed parenthetic
        try 
        {
            byte[] hash;
            byte[] randomizer;
            byte[] ret;
            ret = mService.readOutOfBandData();
            hash = Arrays.copyOfRange(ret, 0, 16);
            randomizer = Arrays.copyOfRange(ret, 16, 32);
            {
                Log.d(TAG, "readOutOfBandData:" + Arrays.toString(hash) +
                  ":" + Arrays.toString(randomizer));
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        return (Pair<byte[], byte[]>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return null;
        //try {
            //byte[] hash;
            //byte[] randomizer;
            //byte[] ret = mService.readOutOfBandData();
            //if (ret  == null || ret.length != 32) return null;
            //hash = Arrays.copyOfRange(ret, 0, 16);
            //randomizer = Arrays.copyOfRange(ret, 16, 32);
            //if (DBG) {
                //Log.d(TAG, "readOutOfBandData:" + Arrays.toString(hash) +
                  //":" + Arrays.toString(randomizer));
            //}
            //return new Pair<byte[], byte[]>(hash, randomizer);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.075 -0400", hash_original_method = "7E4371B1FE17235BDA29BC99978F2247", hash_generated_method = "123BD61C76B7D227F7A0553039EE2DF3")
    @DSModeled(DSC.SAFE)
    public boolean getProfileProxy(Context context, BluetoothProfile.ServiceListener listener,
                                   int profile) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(profile);
        {
            BluetoothHeadset headset;
            headset = new BluetoothHeadset(context, listener);
        } //End block
        {
            BluetoothA2dp a2dp;
            a2dp = new BluetoothA2dp(context, listener);
        } //End block
        {
            BluetoothInputDevice iDev;
            iDev = new BluetoothInputDevice(context, listener);
        } //End block
        {
            BluetoothPan pan;
            pan = new BluetoothPan(context, listener);
        } //End block
        {
            BluetoothHealth health;
            health = new BluetoothHealth(context, listener);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.075 -0400", hash_original_method = "C3F4A021A34A1F5D994F708A9A411E49", hash_generated_method = "86603D301992AC119BB456250EAE11DD")
    @DSModeled(DSC.SAFE)
    public void closeProfileProxy(int profile, BluetoothProfile proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(profile);
        //Begin case BluetoothProfile.HEADSET 
        BluetoothHeadset headset;
        headset = (BluetoothHeadset)proxy;
        //End case BluetoothProfile.HEADSET 
        //Begin case BluetoothProfile.HEADSET 
        headset.close();
        //End case BluetoothProfile.HEADSET 
        //Begin case BluetoothProfile.A2DP 
        BluetoothA2dp a2dp;
        a2dp = (BluetoothA2dp)proxy;
        //End case BluetoothProfile.A2DP 
        //Begin case BluetoothProfile.A2DP 
        a2dp.close();
        //End case BluetoothProfile.A2DP 
        //Begin case BluetoothProfile.INPUT_DEVICE 
        BluetoothInputDevice iDev;
        iDev = (BluetoothInputDevice)proxy;
        //End case BluetoothProfile.INPUT_DEVICE 
        //Begin case BluetoothProfile.INPUT_DEVICE 
        iDev.close();
        //End case BluetoothProfile.INPUT_DEVICE 
        //Begin case BluetoothProfile.PAN 
        BluetoothPan pan;
        pan = (BluetoothPan)proxy;
        //End case BluetoothProfile.PAN 
        //Begin case BluetoothProfile.PAN 
        pan.close();
        //End case BluetoothProfile.PAN 
        //Begin case BluetoothProfile.HEALTH 
        BluetoothHealth health;
        health = (BluetoothHealth)proxy;
        //End case BluetoothProfile.HEALTH 
        //Begin case BluetoothProfile.HEALTH 
        health.close();
        //End case BluetoothProfile.HEALTH 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.076 -0400", hash_original_method = "A99B511CC77AEC21CDC5C0D9EF322DC5", hash_generated_method = "5D7174782420C4EA4498FD16175B45DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean changeApplicationBluetoothState(boolean on,
                                                   BluetoothStateChangeCallback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(on);
        try 
        {
            boolean var6F6D0373F30CA1296F85F010408671AA_2108745194 = (mService.changeApplicationBluetoothState(on, new
                    StateChangeCallbackWrapper(callback), new Binder()));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (callback == null) return false;
        //try {
            //return mService.changeApplicationBluetoothState(on, new
                    //StateChangeCallbackWrapper(callback), new Binder());
        //} catch (RemoteException e) {
            //Log.e(TAG, "changeBluetoothState", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.076 -0400", hash_original_method = "513CC86480EBB28E1771EE0ECDF9AF42", hash_generated_method = "6C72FC5D7AE8F1B8127F0DFE6DFDDB48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Set<BluetoothDevice> toDeviceSet(String[] addresses) {
        dsTaint.addTaint(addresses);
        Set<BluetoothDevice> devices;
        devices = new HashSet<BluetoothDevice>(addresses.length);
        {
            int i;
            i = 0;
            {
                devices.add(getRemoteDevice(addresses[i]));
            } //End block
        } //End collapsed parenthetic
        Set<BluetoothDevice> varD9935986BFAE97CEC79C45ACDCE7F4A7_533690418 = (Collections.unmodifiableSet(devices));
        return (Set<BluetoothDevice>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<BluetoothDevice> devices = new HashSet<BluetoothDevice>(addresses.length);
        //for (int i = 0; i < addresses.length; i++) {
            //devices.add(getRemoteDevice(addresses[i]));
        //}
        //return Collections.unmodifiableSet(devices);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.076 -0400", hash_original_method = "880F9FAA13E21096CB5A27114BEEE514", hash_generated_method = "917E76824FFDF66DDB71CE09A1063550")
    public static boolean checkBluetoothAddress(String address) {
        if (address == null || address.length() != ADDRESS_LENGTH) {
            return false;
        }
        for (int i = 0; i < ADDRESS_LENGTH; i++) {
            char c = address.charAt(i);
            switch (i % 3) {
            case 0:
            case 1:
                if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F')) {
                    break;
                }
                return false;
            case 2:
                if (c == ':') {
                    break;  
                }
                return false;
            }
        }
        return true;
    }

    
    private static class RfcommChannelPicker {
        private static final int[] RESERVED_RFCOMM_CHANNELS =  new int[] {
            10,  
            11,  
            12,  
            19,  
        };
        private static LinkedList<Integer> sChannels;
        private static Random sRandom;
        private final LinkedList<Integer> mChannels;
        private final UUID mUuid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.077 -0400", hash_original_method = "28D5B18AE357E7C373AB413DE32AB5A2", hash_generated_method = "5D29211EDB7A9BD612236F8F17EC9C02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RfcommChannelPicker(UUID uuid) {
            dsTaint.addTaint(uuid.dsTaint);
            {
                {
                    sChannels = new LinkedList<Integer>();
                    {
                        int i;
                        i = 1;
                        {
                            sChannels.addLast(new Integer(i));
                        } //End block
                    } //End collapsed parenthetic
                    {
                        int reserved = RESERVED_RFCOMM_CHANNELS[0];
                        {
                            sChannels.remove(new Integer(reserved));
                        } //End block
                    } //End collapsed parenthetic
                    sRandom = new Random();
                } //End block
                mChannels = (LinkedList<Integer>)sChannels.clone();
            } //End block
            // ---------- Original Method ----------
            //synchronized (RfcommChannelPicker.class) {
                //if (sChannels == null) {
                    //sChannels = new LinkedList<Integer>();
                    //for (int i = 1; i <= BluetoothSocket.MAX_RFCOMM_CHANNEL; i++) {
                        //sChannels.addLast(new Integer(i));
                    //}
                    //for (int reserved : RESERVED_RFCOMM_CHANNELS) {
                        //sChannels.remove(new Integer(reserved));
                    //}
                    //sRandom = new Random();
                //}
                //mChannels = (LinkedList<Integer>)sChannels.clone();
            //}
            //mUuid = uuid;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.077 -0400", hash_original_method = "81BCBA018F169CE48612651EBB944AF7", hash_generated_method = "359F5BBEB4E6C68DA3CA3F1838425B56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int nextChannel() {
            {
                boolean var08D67C333E5C8395588B3843A7F7E0FA_647068245 = (mChannels.size() == 0);
            } //End collapsed parenthetic
            int var1CDFFF0CE7EEF9D5D572BD5434B40368_1444846805 = (mChannels.remove(sRandom.nextInt(mChannels.size())));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (mChannels.size() == 0) {
                //return -1;
            //}
            //return mChannels.remove(sRandom.nextInt(mChannels.size()));
        }

        
    }


    
    public class StateChangeCallbackWrapper extends IBluetoothStateChangeCallback.Stub {
        private BluetoothStateChangeCallback mCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.078 -0400", hash_original_method = "A0CF36872107300FB780BF535F8F7268", hash_generated_method = "E35526E8565E986D10DA578C12C70B69")
        @DSModeled(DSC.SAFE)
         StateChangeCallbackWrapper(BluetoothStateChangeCallback
                callback) {
            dsTaint.addTaint(callback.dsTaint);
            // ---------- Original Method ----------
            //mCallback = callback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.078 -0400", hash_original_method = "A0576354509BA338556525A396FF4F6A", hash_generated_method = "A387B0E00770B0F6095984A89CD5DBAE")
        @DSModeled(DSC.SAFE)
        @Override
        public void onBluetoothStateChange(boolean on) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(on);
            mCallback.onBluetoothStateChange(on);
            // ---------- Original Method ----------
            //mCallback.onBluetoothStateChange(on);
        }

        
    }


    
    public interface BluetoothStateChangeCallback {
        public void onBluetoothStateChange(boolean on);
    }
    
}


