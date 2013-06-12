package android.net.wifi;

// Droidsafe Imports
import java.util.List;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.net.DhcpInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.WorkSource;

import com.android.internal.util.AsyncChannel;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class WifiManager {
    public static final int ERROR_AUTHENTICATING = 1;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_STATE_CHANGED_ACTION =
        "android.net.wifi.WIFI_STATE_CHANGED";
    public static final String EXTRA_WIFI_STATE = "wifi_state";
    public static final String EXTRA_PREVIOUS_WIFI_STATE = "previous_wifi_state";
    public static final int WIFI_STATE_DISABLING = 0;
    public static final int WIFI_STATE_DISABLED = 1;
    public static final int WIFI_STATE_ENABLING = 2;
    public static final int WIFI_STATE_ENABLED = 3;
    public static final int WIFI_STATE_UNKNOWN = 4;
    public static final String WIFI_AP_STATE_CHANGED_ACTION =
        "android.net.wifi.WIFI_AP_STATE_CHANGED";
    public static final String EXTRA_WIFI_AP_STATE = "wifi_state";
    public static final String EXTRA_PREVIOUS_WIFI_AP_STATE = "previous_wifi_state";
    public static final int WIFI_AP_STATE_DISABLING = 10;
    public static final int WIFI_AP_STATE_DISABLED = 11;
    public static final int WIFI_AP_STATE_ENABLING = 12;
    public static final int WIFI_AP_STATE_ENABLED = 13;
    public static final int WIFI_AP_STATE_FAILED = 14;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SUPPLICANT_CONNECTION_CHANGE_ACTION =
        "android.net.wifi.supplicant.CONNECTION_CHANGE";
    public static final String EXTRA_SUPPLICANT_CONNECTED = "connected";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String NETWORK_STATE_CHANGED_ACTION = "android.net.wifi.STATE_CHANGE";
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    public static final String EXTRA_BSSID = "bssid";
    public static final String EXTRA_WIFI_INFO = "wifiInfo";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SUPPLICANT_STATE_CHANGED_ACTION =
        "android.net.wifi.supplicant.STATE_CHANGE";
    public static final String EXTRA_NEW_STATE = "newState";
    public static final String EXTRA_SUPPLICANT_ERROR = "supplicantError";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ERROR_ACTION = "android.net.wifi.ERROR";
    public static final String EXTRA_ERROR_CODE = "errorCode";
    public static final int WPS_OVERLAP_ERROR = 1;
    public static final String CONFIGURED_NETWORKS_CHANGED_ACTION =
        "android.net.wifi.CONFIGURED_NETWORKS_CHANGE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String RSSI_CHANGED_ACTION = "android.net.wifi.RSSI_CHANGED";
    public static final String EXTRA_NEW_RSSI = "newRssi";
    public static final String LINK_CONFIGURATION_CHANGED_ACTION =
        "android.net.wifi.LINK_CONFIGURATION_CHANGED";
    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String NETWORK_IDS_CHANGED_ACTION = "android.net.wifi.NETWORK_IDS_CHANGED";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK_WIFI_NETWORK = "android.net.wifi.PICK_WIFI_NETWORK";
    public static final int WIFI_MODE_FULL = 1;
    public static final int WIFI_MODE_SCAN_ONLY = 2;
    public static final int WIFI_MODE_FULL_HIGH_PERF = 3;
    private static final int MIN_RSSI = -100;
    private static final int MAX_RSSI = -55;
    public static final int WIFI_FREQUENCY_BAND_AUTO = 0;
    public static final int WIFI_FREQUENCY_BAND_5GHZ = 1;
    public static final int WIFI_FREQUENCY_BAND_2GHZ = 2;
    public static final int DATA_ACTIVITY_NOTIFICATION = 1;
    public static final int DATA_ACTIVITY_NONE         = 0x00;
    public static final int DATA_ACTIVITY_IN           = 0x01;
    public static final int DATA_ACTIVITY_OUT          = 0x02;
    public static final int DATA_ACTIVITY_INOUT        = 0x03;
    IWifiManager mService;
    Handler mHandler;
    private static final int MAX_ACTIVE_LOCKS = 50;
    private int mActiveLockCount;
    private AsyncChannel mAsyncChannel = new AsyncChannel();
    public static final int CMD_CONNECT_NETWORK             = 1;
    public static final int CMD_FORGET_NETWORK              = 2;
    public static final int CMD_SAVE_NETWORK                = 3;
    public static final int CMD_START_WPS                   = 4;
    public static final int CMD_DISABLE_NETWORK             = 5;
    public static final int CMD_WPS_COMPLETED               = 11;
    public static final int CMD_ENABLE_TRAFFIC_STATS_POLL   = 21;
    public static final int CMD_TRAFFIC_STATS_POLL          = 22;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.487 -0400", hash_original_method = "45AC664258FD08C08C588B627CDDFFBC", hash_generated_method = "DAFA6E542945668E2968FE98D069C749")
    @DSModeled(DSC.SAFE)
    public WifiManager(IWifiManager service, Handler handler) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //mService = service;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.487 -0400", hash_original_method = "7B7EDD72C806D0E7DC8642CC316AA722", hash_generated_method = "6F67BC6C6CCBDFEE18AFD01CD4B61A09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<WifiConfiguration> getConfiguredNetworks() {
        try 
        {
            List<WifiConfiguration> var6F8BF3E9DC78D477E1A6E7BE7502E4AA_126565802 = (mService.getConfiguredNetworks());
        } //End block
        catch (RemoteException e)
        { }
        return (List<WifiConfiguration>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getConfiguredNetworks();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.487 -0400", hash_original_method = "FC0AD51F5109F6EE6B896159A6BE091E", hash_generated_method = "5FEAD09F5CD5292CD7F914BEE58EEEFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int addNetwork(WifiConfiguration config) {
        dsTaint.addTaint(config.dsTaint);
        config.networkId = -1;
        int var841DCE22DCAD53E534BE373AED1A9F2C_297620431 = (addOrUpdateNetwork(config));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (config == null) {
            //return -1;
        //}
        //config.networkId = -1;
        //return addOrUpdateNetwork(config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.488 -0400", hash_original_method = "BAE559B7BC959F87E1981FBD6EC47DF5", hash_generated_method = "3036DFFD9D6B7B3481E216BB5C3164AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int updateNetwork(WifiConfiguration config) {
        dsTaint.addTaint(config.dsTaint);
        int var841DCE22DCAD53E534BE373AED1A9F2C_714531175 = (addOrUpdateNetwork(config));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (config == null || config.networkId < 0) {
            //return -1;
        //}
        //return addOrUpdateNetwork(config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.488 -0400", hash_original_method = "E64504FDFA81026BF4EAE79A420D3010", hash_generated_method = "C7777C3DD98619EAF877D83221C0A6D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int addOrUpdateNetwork(WifiConfiguration config) {
        dsTaint.addTaint(config.dsTaint);
        try 
        {
            int var29861749C3E419B96EEF8148CE5ACC73_2331544 = (mService.addOrUpdateNetwork(config));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.addOrUpdateNetwork(config);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.488 -0400", hash_original_method = "C55861B25E581745B3C6351405363685", hash_generated_method = "9235E49870FB568F7256FB6CEAFE4A5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeNetwork(int netId) {
        dsTaint.addTaint(netId);
        try 
        {
            boolean var3969CE505792C9B2C42D9B989E5DCC6A_1497507263 = (mService.removeNetwork(netId));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.removeNetwork(netId);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.488 -0400", hash_original_method = "A063D2F3A1A45A8B2BB20D41F98AEB1B", hash_generated_method = "F8389E0075BBEF0B9FBC70806C341856")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableNetwork(int netId, boolean disableOthers) {
        dsTaint.addTaint(disableOthers);
        dsTaint.addTaint(netId);
        try 
        {
            boolean var1D13A98DF752183E327DF71A161434AC_469870747 = (mService.enableNetwork(netId, disableOthers));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.enableNetwork(netId, disableOthers);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.488 -0400", hash_original_method = "630BE7480BA2E95DA9CEC1F52BBE219A", hash_generated_method = "08A9CED98C192584E1E68E874EDE6194")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableNetwork(int netId) {
        dsTaint.addTaint(netId);
        try 
        {
            boolean var507F4C1A88F04AAAAE64FCFD7F68A129_2121425544 = (mService.disableNetwork(netId));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.disableNetwork(netId);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.488 -0400", hash_original_method = "4C2FCF871904470A4665E52D44D62875", hash_generated_method = "88097030EF6C07D9CC68F06F01C82194")
    @DSModeled(DSC.SAFE)
    public void disableNetwork(int netId, int reason) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(netId);
        mAsyncChannel.sendMessage(CMD_DISABLE_NETWORK, netId, reason);
        // ---------- Original Method ----------
        //mAsyncChannel.sendMessage(CMD_DISABLE_NETWORK, netId, reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.488 -0400", hash_original_method = "13D7026BA6E2310038D9CCEC7D1F5CA4", hash_generated_method = "0BB15DD1DA61EB9E1E306C4FFBFA634A")
    @DSModeled(DSC.SAFE)
    public boolean disconnect() {
        try 
        {
            mService.disconnect();
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.disconnect();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.489 -0400", hash_original_method = "AD9DD9C3B4130EB49C99A6BF92BCA383", hash_generated_method = "C31A620EF7E28A34D67AF805669DA5A7")
    @DSModeled(DSC.SAFE)
    public boolean reconnect() {
        try 
        {
            mService.reconnect();
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.reconnect();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.489 -0400", hash_original_method = "4462A23EEF44DC4F050ECB7EA4566A65", hash_generated_method = "B384D4D9E7B8585C225574C878F06E70")
    @DSModeled(DSC.SAFE)
    public boolean reassociate() {
        try 
        {
            mService.reassociate();
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.reassociate();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.489 -0400", hash_original_method = "44FE7083E78F583BB16CDAFA3EBE6F36", hash_generated_method = "A8599939E3E391EBBD1FD376555CC5A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean pingSupplicant() {
        try 
        {
            boolean var108AD08E67A26C352FC5E987B3605666_887337095 = (mService.pingSupplicant());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mService == null)
            //return false;
        //try {
            //return mService.pingSupplicant();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.489 -0400", hash_original_method = "F8088016DD577DAE90193BD2B16E77E5", hash_generated_method = "460FA3B1F81D73AA5507658D0C268505")
    @DSModeled(DSC.SAFE)
    public boolean startScan() {
        try 
        {
            mService.startScan(false);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.startScan(false);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.489 -0400", hash_original_method = "1BECDA97215EAB893F9C0F926E7877B4", hash_generated_method = "1EB218D14700BEF894C9F457A7976434")
    @DSModeled(DSC.SAFE)
    public boolean startScanActive() {
        try 
        {
            mService.startScan(true);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.startScan(true);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.489 -0400", hash_original_method = "8E854EE6D7B979BB188C54EFD6BB6717", hash_generated_method = "FE600368FA3C4F5471199F86F94722E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiInfo getConnectionInfo() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        try 
        {
            WifiInfo varE91B5D0B4EF71528E847E0FDE4A7CBA9_265380506 = (mService.getConnectionInfo());
        } //End block
        catch (RemoteException e)
        { }
        return (WifiInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getConnectionInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.489 -0400", hash_original_method = "ADD60A4DA3445A3E968EB713F725E5F1", hash_generated_method = "4FA3D0EDB215B4A250F67807CD1918FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ScanResult> getScanResults() {
        try 
        {
            List<ScanResult> var12E0E391F73993D52EE8E8DF498A5AA5_1916112392 = (mService.getScanResults());
        } //End block
        catch (RemoteException e)
        { }
        return (List<ScanResult>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getScanResults();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.489 -0400", hash_original_method = "D1E32319AD181FF60DD93B5B2DB831F1", hash_generated_method = "2354BF42ED7B86E2D6526C350174D9D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean saveConfiguration() {
        try 
        {
            boolean var65BADDEB467659B51E5D69A7C9FA99CA_879034865 = (mService.saveConfiguration());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.saveConfiguration();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.490 -0400", hash_original_method = "9549A9F9433914F9E55F5CC34183554C", hash_generated_method = "5E6312BECB12D132B1243EBA2FCFF36D")
    @DSModeled(DSC.SAFE)
    public void setCountryCode(String country, boolean persist) {
        dsTaint.addTaint(persist);
        dsTaint.addTaint(country);
        try 
        {
            mService.setCountryCode(country, persist);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setCountryCode(country, persist);
        //} catch (RemoteException e) { }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.490 -0400", hash_original_method = "4B6C5827C7D51FB40ECD8DD67D760E19", hash_generated_method = "BBB168936376A6B641035DEECB1321D6")
    @DSModeled(DSC.SAFE)
    public void setFrequencyBand(int band, boolean persist) {
        dsTaint.addTaint(band);
        dsTaint.addTaint(persist);
        try 
        {
            mService.setFrequencyBand(band, persist);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setFrequencyBand(band, persist);
        //} catch (RemoteException e) { }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.490 -0400", hash_original_method = "481BDDBC9D497285776974614BBC7D82", hash_generated_method = "B682A046059258951CC0DA33421ACFCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFrequencyBand() {
        try 
        {
            int varD3D26E601547C91817009BC00AFC6395_1253043488 = (mService.getFrequencyBand());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.getFrequencyBand();
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.490 -0400", hash_original_method = "F73D127A0D43FAD1AD9DBA6A689AC70A", hash_generated_method = "820D7FF3A292985829EC56B145E15119")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDualBandSupported() {
        try 
        {
            boolean varD0866672BC37ED549DC39FCD6F97C3E7_1444931514 = (mService.isDualBandSupported());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.isDualBandSupported();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.490 -0400", hash_original_method = "711DEA09870DB7E049F72B7F8BEBC0A1", hash_generated_method = "AC5F549BBACF7CDE6966C1A50C870389")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DhcpInfo getDhcpInfo() {
        try 
        {
            DhcpInfo var52C6CFAE70B48F88D653196EA2170C6E_268162919 = (mService.getDhcpInfo());
        } //End block
        catch (RemoteException e)
        { }
        return (DhcpInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getDhcpInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.490 -0400", hash_original_method = "B9430AD639DDE3004B577A4BF40EB18B", hash_generated_method = "E0A62849A9DB0D8A86E4419908BF2441")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setWifiEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        try 
        {
            boolean varB6FC8C8742D6B74DE1AE1DCC4A75F803_188902771 = (mService.setWifiEnabled(enabled));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.setWifiEnabled(enabled);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.490 -0400", hash_original_method = "661FA885AE58B8C5231BF7DCF436505F", hash_generated_method = "5329BB457287CBBDD434E155F0F30E99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWifiState() {
        try 
        {
            int var51177C283700A55013AE02DA22D9F373_1562819486 = (mService.getWifiEnabledState());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.getWifiEnabledState();
        //} catch (RemoteException e) {
            //return WIFI_STATE_UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.490 -0400", hash_original_method = "D7F0AFD1306EBF22F34F7E014A2C9B11", hash_generated_method = "E72124C6F8D725428567AAF40895A383")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isWifiEnabled() {
        boolean var6712056F5B3773D738C13AB491D89222_503342840 = (getWifiState() == WIFI_STATE_ENABLED);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getWifiState() == WIFI_STATE_ENABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.491 -0400", hash_original_method = "EC5E9CE8FA57602393C1D5810AE2C351", hash_generated_method = "847260701FB52388FF90DC2C4169A50B")
    public static int calculateSignalLevel(int rssi, int numLevels) {
        if (rssi <= MIN_RSSI) {
            return 0;
        } else if (rssi >= MAX_RSSI) {
            return numLevels - 1;
        } else {
            float inputRange = (MAX_RSSI - MIN_RSSI);
            float outputRange = (numLevels - 1);
            return (int)((float)(rssi - MIN_RSSI) * outputRange / inputRange);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.491 -0400", hash_original_method = "AC2D0644B70FE8C5B0B7836FC70F62E4", hash_generated_method = "9E8A2CC6A73F339F1823EB99E6F99432")
    public static int compareSignalLevel(int rssiA, int rssiB) {
        return rssiA - rssiB;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.491 -0400", hash_original_method = "2BFE81971E8D979C3ECBD7F543427F67", hash_generated_method = "FF81B939DF85AEEC2E730E0465EF1A7D")
    @DSModeled(DSC.SAFE)
    public boolean setWifiApEnabled(WifiConfiguration wifiConfig, boolean enabled) {
        dsTaint.addTaint(enabled);
        dsTaint.addTaint(wifiConfig.dsTaint);
        try 
        {
            mService.setWifiApEnabled(wifiConfig, enabled);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.setWifiApEnabled(wifiConfig, enabled);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.491 -0400", hash_original_method = "B0BA72D208162E33734DF133F2E7F6AA", hash_generated_method = "8700DB3351ADCE69E3BFD8997527FBDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWifiApState() {
        try 
        {
            int var2E2FB8DE2B461FD2353125B69D9D13CD_269566198 = (mService.getWifiApEnabledState());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.getWifiApEnabledState();
        //} catch (RemoteException e) {
            //return WIFI_AP_STATE_FAILED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.491 -0400", hash_original_method = "657EB8B0A945E7FD7BA91E2539A322BE", hash_generated_method = "9C1E0E41EB7826619F1516EFFD688157")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isWifiApEnabled() {
        boolean var50FC8F7F80F7565EBB0DC8805641F4CB_696316153 = (getWifiApState() == WIFI_AP_STATE_ENABLED);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getWifiApState() == WIFI_AP_STATE_ENABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.491 -0400", hash_original_method = "99407E6898AC76390D3E229EC6CF35C4", hash_generated_method = "F9E1392FAF0CE8C8EF61A4E3C55DF57B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiConfiguration getWifiApConfiguration() {
        try 
        {
            WifiConfiguration var1B50143FEAE2AB5156DC10C0B1A12D52_27762347 = (mService.getWifiApConfiguration());
        } //End block
        catch (RemoteException e)
        { }
        return (WifiConfiguration)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getWifiApConfiguration();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.491 -0400", hash_original_method = "32645F13A37CD40BEF3F9464116D1367", hash_generated_method = "0880051D47608157A01513A576018B3A")
    @DSModeled(DSC.SAFE)
    public boolean setWifiApConfiguration(WifiConfiguration wifiConfig) {
        dsTaint.addTaint(wifiConfig.dsTaint);
        try 
        {
            mService.setWifiApConfiguration(wifiConfig);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.setWifiApConfiguration(wifiConfig);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.492 -0400", hash_original_method = "F505CF72442DFA261366294723957A53", hash_generated_method = "BC2158AB4D89E9ECACBA90E2F61802B6")
    @DSModeled(DSC.SAFE)
    public boolean startWifi() {
        try 
        {
            mService.startWifi();
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.startWifi();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.492 -0400", hash_original_method = "F7F977701F133D0F59F048A53A2C698B", hash_generated_method = "BBA2796E96F4FAF5416E81697F62F461")
    @DSModeled(DSC.SAFE)
    public boolean stopWifi() {
        try 
        {
            mService.stopWifi();
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.stopWifi();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.492 -0400", hash_original_method = "6E01C15F4CA49AC218CA465537508537", hash_generated_method = "A80B7E478E89E4660C81711E75314D94")
    @DSModeled(DSC.SAFE)
    public boolean addToBlacklist(String bssid) {
        dsTaint.addTaint(bssid);
        try 
        {
            mService.addToBlacklist(bssid);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.addToBlacklist(bssid);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.492 -0400", hash_original_method = "614FAF75AF873709E1677408EE18D7B6", hash_generated_method = "130469DCFA5B7AB9CDB28B5B90A7BA9F")
    @DSModeled(DSC.SAFE)
    public boolean clearBlacklist() {
        try 
        {
            mService.clearBlacklist();
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.clearBlacklist();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.492 -0400", hash_original_method = "F93FD4BCC6C0F6B375A42EEFE25B9408", hash_generated_method = "C88FB7E34D446ABB4A2B43088D44B77A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void asyncConnect(Context srcContext, Handler srcHandler) {
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        mAsyncChannel.connect(srcContext, srcHandler, getMessenger());
        // ---------- Original Method ----------
        //mAsyncChannel.connect(srcContext, srcHandler, getMessenger());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.492 -0400", hash_original_method = "B69D8EEDABB0031125B40805CA5F91D8", hash_generated_method = "3691032EED9EF88B195EB0DFF1140A0C")
    @DSModeled(DSC.SAFE)
    public void connectNetwork(WifiConfiguration config) {
        dsTaint.addTaint(config.dsTaint);
        mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, config);
        // ---------- Original Method ----------
        //if (config == null) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.492 -0400", hash_original_method = "9464671A8FCBA7A99848867493116AAD", hash_generated_method = "3069B99647B39E52E71B04606DC185B4")
    @DSModeled(DSC.SAFE)
    public void connectNetwork(int networkId) {
        dsTaint.addTaint(networkId);
        mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, networkId);
        // ---------- Original Method ----------
        //if (networkId < 0) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, networkId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.492 -0400", hash_original_method = "210177ED8E63F9C12E442B1614E4B9E7", hash_generated_method = "066ED8799DD3D064E025157EC9C0AD51")
    @DSModeled(DSC.SAFE)
    public void saveNetwork(WifiConfiguration config) {
        dsTaint.addTaint(config.dsTaint);
        mAsyncChannel.sendMessage(CMD_SAVE_NETWORK, config);
        // ---------- Original Method ----------
        //if (config == null) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_SAVE_NETWORK, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.492 -0400", hash_original_method = "A04E73224B607EFF8F851CD080EF29BA", hash_generated_method = "543396043A04F4F4DCC72189A1BF62F5")
    @DSModeled(DSC.SAFE)
    public void forgetNetwork(int netId) {
        dsTaint.addTaint(netId);
        mAsyncChannel.sendMessage(CMD_FORGET_NETWORK, netId);
        // ---------- Original Method ----------
        //if (netId < 0) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_FORGET_NETWORK, netId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.493 -0400", hash_original_method = "CB69F89B2E3E5728AFF3169858F2154E", hash_generated_method = "FC43FBB4E0F54659B0972257200B33FF")
    @DSModeled(DSC.SAFE)
    public void startWps(WpsInfo config) {
        dsTaint.addTaint(config.dsTaint);
        mAsyncChannel.sendMessage(CMD_START_WPS, config);
        // ---------- Original Method ----------
        //if (config == null) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_START_WPS, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.493 -0400", hash_original_method = "A358F8361C96DABE1A63B04B5804B3F5", hash_generated_method = "AC29C5402F612E656AB989B27232ED84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Messenger getMessenger() {
        try 
        {
            Messenger varAB82975146F1B86EF7AFAED5EB9D69F9_426810225 = (mService.getMessenger());
        } //End block
        catch (RemoteException e)
        { }
        return (Messenger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getMessenger();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.493 -0400", hash_original_method = "F47F46BF01C13AECFB0A8E0A7BCA30AB", hash_generated_method = "3D6273F6211817FF415D1D0DB54DC8ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getConfigFile() {
        try 
        {
            String var7AF275B0EBE5B43C4D13A70D18439180_1077492142 = (mService.getConfigFile());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return mService.getConfigFile();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.493 -0400", hash_original_method = "77C6D00CEFBA51FBEDF42525D5CAF8B4", hash_generated_method = "91FC540699C6FE1ED42ED6229C1FD245")
    @DSModeled(DSC.SAFE)
    public WifiLock createWifiLock(int lockType, String tag) {
        dsTaint.addTaint(lockType);
        dsTaint.addTaint(tag);
        return (WifiLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new WifiLock(lockType, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.493 -0400", hash_original_method = "F25A7BAA745FE3E1539A4ACAD2E402AC", hash_generated_method = "C4C3A14F159F3DF36A3624C0E184572B")
    @DSModeled(DSC.SAFE)
    public WifiLock createWifiLock(String tag) {
        dsTaint.addTaint(tag);
        return (WifiLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new WifiLock(WIFI_MODE_FULL, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.493 -0400", hash_original_method = "90BF24DBA9F26B31ED84B0CABBF9287E", hash_generated_method = "678AA2B07DA1180611600246C3EA2156")
    @DSModeled(DSC.SAFE)
    public MulticastLock createMulticastLock(String tag) {
        dsTaint.addTaint(tag);
        return (MulticastLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new MulticastLock(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.493 -0400", hash_original_method = "36EA363278EADF8446AD30BF262D8211", hash_generated_method = "2C62F855CCA924AC53A8B39D6CA69DED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMulticastEnabled() {
        try 
        {
            boolean varF69D9C3FD34D6BAECC97870E612144C2_773001557 = (mService.isMulticastEnabled());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.isMulticastEnabled();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.494 -0400", hash_original_method = "03CE776E3230E83E55C388557E1A9516", hash_generated_method = "30E75D96F7CA6FCF88BC2D4393FC569A")
    @DSModeled(DSC.SAFE)
    public boolean initializeMulticastFiltering() {
        try 
        {
            mService.initializeMulticastFiltering();
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.initializeMulticastFiltering();
            //return true;
        //} catch (RemoteException e) {
             //return false;
        //}
    }

    
    public class WifiLock {
        private String mTag;
        private final IBinder mBinder;
        private int mRefCount;
        int mLockType;
        private boolean mRefCounted;
        private boolean mHeld;
        private WorkSource mWorkSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.494 -0400", hash_original_method = "044CDC682150D26B37DC0497B735DA49", hash_generated_method = "B1C02064C4230A81CFF865F715E40485")
        @DSModeled(DSC.SAFE)
        private WifiLock(int lockType, String tag) {
            dsTaint.addTaint(lockType);
            dsTaint.addTaint(tag);
            mBinder = new Binder();
            mRefCount = 0;
            mRefCounted = true;
            mHeld = false;
            // ---------- Original Method ----------
            //mTag = tag;
            //mLockType = lockType;
            //mBinder = new Binder();
            //mRefCount = 0;
            //mRefCounted = true;
            //mHeld = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.494 -0400", hash_original_method = "208DCD1288F5AC0918E067B51EC18B17", hash_generated_method = "B19D9A93A2167E1AF512688FA88ECC05")
        @DSModeled(DSC.SAFE)
        public void acquire() {
            {
                {
                    try 
                    {
                        mService.acquireWifiLock(mBinder, mLockType, mTag, mWorkSource);
                        {
                            {
                                mService.releaseWifiLock(mBinder);
                                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                                            "Exceeded maximum number of wifi locks");
                            } //End block
                            mActiveLockCount++;
                        } //End block
                    } //End block
                    catch (RemoteException ignore)
                    { }
                    mHeld = true;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.494 -0400", hash_original_method = "EEC110369AFED5315DDFD7D45F992208", hash_generated_method = "E4DF65D7BC2BB542E10B8DDC9465D907")
        @DSModeled(DSC.SAFE)
        public void release() {
            {
                {
                    try 
                    {
                        mService.releaseWifiLock(mBinder);
                        {
                            mActiveLockCount--;
                        } //End block
                    } //End block
                    catch (RemoteException ignore)
                    { }
                    mHeld = false;
                } //End block
                {
                    throw new RuntimeException("WifiLock under-locked " + mTag);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //if (mRefCounted ? (--mRefCount == 0) : (mHeld)) {
                    //try {
                        //mService.releaseWifiLock(mBinder);
                        //synchronized (WifiManager.this) {
                            //mActiveLockCount--;
                        //}
                    //} catch (RemoteException ignore) {
                    //}
                    //mHeld = false;
                //}
                //if (mRefCount < 0) {
                    //throw new RuntimeException("WifiLock under-locked " + mTag);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.494 -0400", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "4B077E4AF914EBAC3321CC7A93A58C86")
        @DSModeled(DSC.SAFE)
        public void setReferenceCounted(boolean refCounted) {
            dsTaint.addTaint(refCounted);
            // ---------- Original Method ----------
            //mRefCounted = refCounted;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.494 -0400", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "F11850BDAF419AD2CB0C0D3930FFEDB3")
        @DSModeled(DSC.SAFE)
        public boolean isHeld() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.495 -0400", hash_original_method = "7C62BA62C0C3A7C1DC2FB1EDC51DE805", hash_generated_method = "6E0C98168CD33610DD2F3BE1A5BAD181")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setWorkSource(WorkSource ws) {
            dsTaint.addTaint(ws.dsTaint);
            {
                {
                    boolean varDCFAF0E9E34CB8562A3C2873888A5A3D_1143889572 = (ws != null && ws.size() == 0);
                    {
                        ws = null;
                    } //End block
                } //End collapsed parenthetic
                boolean changed;
                changed = true;
                {
                    mWorkSource = null;
                } //End block
                {
                    changed = mWorkSource != null;
                    mWorkSource = new WorkSource(ws);
                } //End block
                {
                    changed = mWorkSource.diff(ws);
                    {
                        mWorkSource.set(ws);
                    } //End block
                } //End block
                {
                    try 
                    {
                        mService.updateWifiLockWorkSource(mBinder, mWorkSource);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.495 -0400", hash_original_method = "30E303CA91E967AFDBED5B1FC9CE8E64", hash_generated_method = "651361CDB9CD867442E889321A0B69DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String s1, s2, s3;
            {
                s1 = Integer.toHexString(System.identityHashCode(this));
                s2 = mHeld ? "held; " : "";
                {
                    s3 = "refcounted: refcount = " + mRefCount;
                } //End block
                {
                    s3 = "not refcounted";
                } //End block
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String s1, s2, s3;
            //synchronized (mBinder) {
                //s1 = Integer.toHexString(System.identityHashCode(this));
                //s2 = mHeld ? "held; " : "";
                //if (mRefCounted) {
                    //s3 = "refcounted: refcount = " + mRefCount;
                //} else {
                    //s3 = "not refcounted";
                //}
                //return "WifiLock{ " + s1 + "; " + s2 + s3 + " }";
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.495 -0400", hash_original_method = "CDAA53D98D74A433929787E6E7DF605C", hash_generated_method = "490BF169B6180C92C1A8F8D72EFB59FA")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            {
                {
                    try 
                    {
                        mService.releaseWifiLock(mBinder);
                        {
                            mActiveLockCount--;
                        } //End block
                    } //End block
                    catch (RemoteException ignore)
                    { }
                } //End block
            } //End block
            // ---------- Original Method ----------
            //super.finalize();
            //synchronized (mBinder) {
                //if (mHeld) {
                    //try {
                        //mService.releaseWifiLock(mBinder);
                        //synchronized (WifiManager.this) {
                            //mActiveLockCount--;
                        //}
                    //} catch (RemoteException ignore) {
                    //}
                //}
            //}
        }

        
    }


    
    public class MulticastLock {
        private String mTag;
        private final IBinder mBinder;
        private int mRefCount;
        private boolean mRefCounted;
        private boolean mHeld;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.495 -0400", hash_original_method = "DEAA1CCFF83554B98BCA4D411D463199", hash_generated_method = "1D53134A84998C15D980F25C9A90D30B")
        @DSModeled(DSC.SAFE)
        private MulticastLock(String tag) {
            dsTaint.addTaint(tag);
            mBinder = new Binder();
            mRefCount = 0;
            mRefCounted = true;
            mHeld = false;
            // ---------- Original Method ----------
            //mTag = tag;
            //mBinder = new Binder();
            //mRefCount = 0;
            //mRefCounted = true;
            //mHeld = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.495 -0400", hash_original_method = "130A969831975A68066B20EB1F9033A3", hash_generated_method = "7F6F130086E2B7DACA92D6581C4582BB")
        @DSModeled(DSC.SAFE)
        public void acquire() {
            {
                {
                    try 
                    {
                        mService.acquireMulticastLock(mBinder, mTag);
                        {
                            {
                                mService.releaseMulticastLock();
                                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                                        "Exceeded maximum number of wifi locks");
                            } //End block
                            mActiveLockCount++;
                        } //End block
                    } //End block
                    catch (RemoteException ignore)
                    { }
                    mHeld = true;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //if (mRefCounted ? (++mRefCount > 0) : (!mHeld)) {
                    //try {
                        //mService.acquireMulticastLock(mBinder, mTag);
                        //synchronized (WifiManager.this) {
                            //if (mActiveLockCount >= MAX_ACTIVE_LOCKS) {
                                //mService.releaseMulticastLock();
                                //throw new UnsupportedOperationException(
                                        //"Exceeded maximum number of wifi locks");
                            //}
                            //mActiveLockCount++;
                        //}
                    //} catch (RemoteException ignore) {
                    //}
                    //mHeld = true;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.496 -0400", hash_original_method = "325730E7689E55EAB909A58356E01384", hash_generated_method = "2A3616701140ED42AE9E6FCC08FF0AAE")
        @DSModeled(DSC.SAFE)
        public void release() {
            {
                {
                    try 
                    {
                        mService.releaseMulticastLock();
                        {
                            mActiveLockCount--;
                        } //End block
                    } //End block
                    catch (RemoteException ignore)
                    { }
                    mHeld = false;
                } //End block
                {
                    throw new RuntimeException("MulticastLock under-locked "
                            + mTag);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //if (mRefCounted ? (--mRefCount == 0) : (mHeld)) {
                    //try {
                        //mService.releaseMulticastLock();
                        //synchronized (WifiManager.this) {
                            //mActiveLockCount--;
                        //}
                    //} catch (RemoteException ignore) {
                    //}
                    //mHeld = false;
                //}
                //if (mRefCount < 0) {
                    //throw new RuntimeException("MulticastLock under-locked "
                            //+ mTag);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.496 -0400", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "4B077E4AF914EBAC3321CC7A93A58C86")
        @DSModeled(DSC.SAFE)
        public void setReferenceCounted(boolean refCounted) {
            dsTaint.addTaint(refCounted);
            // ---------- Original Method ----------
            //mRefCounted = refCounted;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.496 -0400", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "F11850BDAF419AD2CB0C0D3930FFEDB3")
        @DSModeled(DSC.SAFE)
        public boolean isHeld() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.496 -0400", hash_original_method = "98C6FF6ECD72200F1F4D177BCA8A2AA1", hash_generated_method = "6ACF51E1CC357A497CCF4279E4E92410")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String s1, s2, s3;
            {
                s1 = Integer.toHexString(System.identityHashCode(this));
                s2 = mHeld ? "held; " : "";
                {
                    s3 = "refcounted: refcount = " + mRefCount;
                } //End block
                {
                    s3 = "not refcounted";
                } //End block
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String s1, s2, s3;
            //synchronized (mBinder) {
                //s1 = Integer.toHexString(System.identityHashCode(this));
                //s2 = mHeld ? "held; " : "";
                //if (mRefCounted) {
                    //s3 = "refcounted: refcount = " + mRefCount;
                //} else {
                    //s3 = "not refcounted";
                //}
                //return "MulticastLock{ " + s1 + "; " + s2 + s3 + " }";
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.496 -0400", hash_original_method = "EEB5ECA4A52575C705D77F616153B22D", hash_generated_method = "315047C67A771D7FFC8B0F57C174B0B5")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            setReferenceCounted(false);
            release();
            // ---------- Original Method ----------
            //super.finalize();
            //setReferenceCounted(false);
            //release();
        }

        
    }


    
}


