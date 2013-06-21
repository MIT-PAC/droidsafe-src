package android.net.wifi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.net.DhcpInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.Handler;
import android.os.RemoteException;
import android.os.WorkSource;
import android.os.Messenger;
import com.android.internal.util.AsyncChannel;
import java.util.List;

public class WifiManager {
    IWifiManager mService;
    Handler mHandler;
    private int mActiveLockCount;
    private AsyncChannel mAsyncChannel = new AsyncChannel();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.656 -0400", hash_original_method = "45AC664258FD08C08C588B627CDDFFBC", hash_generated_method = "EA4C19FA0F9670DD6FC8178A2D3B91D8")
    @DSModeled(DSC.SAFE)
    public WifiManager(IWifiManager service, Handler handler) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //mService = service;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.656 -0400", hash_original_method = "7B7EDD72C806D0E7DC8642CC316AA722", hash_generated_method = "46ED49BDF9A261A99C02BA1E93C72C5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<WifiConfiguration> getConfiguredNetworks() {
        try 
        {
            List<WifiConfiguration> var6F8BF3E9DC78D477E1A6E7BE7502E4AA_257839297 = (mService.getConfiguredNetworks());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.657 -0400", hash_original_method = "FC0AD51F5109F6EE6B896159A6BE091E", hash_generated_method = "97A5E89068717B6E39C7AEAFA79F7ED2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int addNetwork(WifiConfiguration config) {
        dsTaint.addTaint(config.dsTaint);
        config.networkId = -1;
        int var841DCE22DCAD53E534BE373AED1A9F2C_743455861 = (addOrUpdateNetwork(config));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (config == null) {
            //return -1;
        //}
        //config.networkId = -1;
        //return addOrUpdateNetwork(config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.657 -0400", hash_original_method = "BAE559B7BC959F87E1981FBD6EC47DF5", hash_generated_method = "0752FF8090765C76CA05B87E04C1760A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int updateNetwork(WifiConfiguration config) {
        dsTaint.addTaint(config.dsTaint);
        int var841DCE22DCAD53E534BE373AED1A9F2C_636463589 = (addOrUpdateNetwork(config));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (config == null || config.networkId < 0) {
            //return -1;
        //}
        //return addOrUpdateNetwork(config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.657 -0400", hash_original_method = "E64504FDFA81026BF4EAE79A420D3010", hash_generated_method = "2987CE9DCB14209FABF9DA8773788E7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int addOrUpdateNetwork(WifiConfiguration config) {
        dsTaint.addTaint(config.dsTaint);
        try 
        {
            int var29861749C3E419B96EEF8148CE5ACC73_677916087 = (mService.addOrUpdateNetwork(config));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.658 -0400", hash_original_method = "C55861B25E581745B3C6351405363685", hash_generated_method = "0BE4DEDEA343DE3242E5D21E2C30A947")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeNetwork(int netId) {
        dsTaint.addTaint(netId);
        try 
        {
            boolean var3969CE505792C9B2C42D9B989E5DCC6A_753804881 = (mService.removeNetwork(netId));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.658 -0400", hash_original_method = "A063D2F3A1A45A8B2BB20D41F98AEB1B", hash_generated_method = "93876CDE46E02D4B6B769DDB1D4E1953")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableNetwork(int netId, boolean disableOthers) {
        dsTaint.addTaint(disableOthers);
        dsTaint.addTaint(netId);
        try 
        {
            boolean var1D13A98DF752183E327DF71A161434AC_2121739236 = (mService.enableNetwork(netId, disableOthers));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.658 -0400", hash_original_method = "630BE7480BA2E95DA9CEC1F52BBE219A", hash_generated_method = "3C7DE2C4DC7D4B5B63AE4135B4D64892")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableNetwork(int netId) {
        dsTaint.addTaint(netId);
        try 
        {
            boolean var507F4C1A88F04AAAAE64FCFD7F68A129_1478876097 = (mService.disableNetwork(netId));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.658 -0400", hash_original_method = "4C2FCF871904470A4665E52D44D62875", hash_generated_method = "00EF61F8B85F646EDDAA70A78E9A2FE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableNetwork(int netId, int reason) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(netId);
        mAsyncChannel.sendMessage(CMD_DISABLE_NETWORK, netId, reason);
        // ---------- Original Method ----------
        //mAsyncChannel.sendMessage(CMD_DISABLE_NETWORK, netId, reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.658 -0400", hash_original_method = "13D7026BA6E2310038D9CCEC7D1F5CA4", hash_generated_method = "297FF63C9209488268DCAFE71C1B6327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.659 -0400", hash_original_method = "AD9DD9C3B4130EB49C99A6BF92BCA383", hash_generated_method = "4355FCC45DF12FB157F86E5DD98259ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.659 -0400", hash_original_method = "4462A23EEF44DC4F050ECB7EA4566A65", hash_generated_method = "94463C73664330A6B089A6D137538533")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.659 -0400", hash_original_method = "44FE7083E78F583BB16CDAFA3EBE6F36", hash_generated_method = "B1B7B665C9A8B396E2B882EA1C66D909")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean pingSupplicant() {
        try 
        {
            boolean var108AD08E67A26C352FC5E987B3605666_156165104 = (mService.pingSupplicant());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.659 -0400", hash_original_method = "F8088016DD577DAE90193BD2B16E77E5", hash_generated_method = "6EA2709A2A3B64E30AAF25E360D2F814")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.660 -0400", hash_original_method = "1BECDA97215EAB893F9C0F926E7877B4", hash_generated_method = "EA6D1885B8837EB9F742AA0D9FC464BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.660 -0400", hash_original_method = "8E854EE6D7B979BB188C54EFD6BB6717", hash_generated_method = "B43628B357473290E0C00B5E56052CD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiInfo getConnectionInfo() {
        try 
        {
            WifiInfo varE91B5D0B4EF71528E847E0FDE4A7CBA9_426680140 = (mService.getConnectionInfo());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.660 -0400", hash_original_method = "ADD60A4DA3445A3E968EB713F725E5F1", hash_generated_method = "EC5A675653BEA019627254088EA4872F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ScanResult> getScanResults() {
        try 
        {
            List<ScanResult> var12E0E391F73993D52EE8E8DF498A5AA5_524829336 = (mService.getScanResults());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.660 -0400", hash_original_method = "D1E32319AD181FF60DD93B5B2DB831F1", hash_generated_method = "B841FF425B34D639606C21223E86E90A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean saveConfiguration() {
        try 
        {
            boolean var65BADDEB467659B51E5D69A7C9FA99CA_1483596732 = (mService.saveConfiguration());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.661 -0400", hash_original_method = "9549A9F9433914F9E55F5CC34183554C", hash_generated_method = "B773AE7635C96F275E3AAE7BA59A8AFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.661 -0400", hash_original_method = "4B6C5827C7D51FB40ECD8DD67D760E19", hash_generated_method = "F7B870673B696347A86FEED83AE81F33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.661 -0400", hash_original_method = "481BDDBC9D497285776974614BBC7D82", hash_generated_method = "C77044DBE786263EE2FD38161ED4FB33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFrequencyBand() {
        try 
        {
            int varD3D26E601547C91817009BC00AFC6395_1478438254 = (mService.getFrequencyBand());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.661 -0400", hash_original_method = "F73D127A0D43FAD1AD9DBA6A689AC70A", hash_generated_method = "052699A9E026AFC118FC6189E2B3146F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDualBandSupported() {
        try 
        {
            boolean varD0866672BC37ED549DC39FCD6F97C3E7_2043549350 = (mService.isDualBandSupported());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.662 -0400", hash_original_method = "711DEA09870DB7E049F72B7F8BEBC0A1", hash_generated_method = "CF60230B1DF41B134C601700DCAE9547")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DhcpInfo getDhcpInfo() {
        try 
        {
            DhcpInfo var52C6CFAE70B48F88D653196EA2170C6E_1447513989 = (mService.getDhcpInfo());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.662 -0400", hash_original_method = "B9430AD639DDE3004B577A4BF40EB18B", hash_generated_method = "027866EDF6D32EA8588538424F729764")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setWifiEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        try 
        {
            boolean varB6FC8C8742D6B74DE1AE1DCC4A75F803_775624309 = (mService.setWifiEnabled(enabled));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.662 -0400", hash_original_method = "661FA885AE58B8C5231BF7DCF436505F", hash_generated_method = "6254E1EBBD72DD1791B9A82C5C9CCF41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWifiState() {
        try 
        {
            int var51177C283700A55013AE02DA22D9F373_1429836919 = (mService.getWifiEnabledState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.662 -0400", hash_original_method = "D7F0AFD1306EBF22F34F7E014A2C9B11", hash_generated_method = "A60BB4B804DBDEE6F7CB2787BE79E7E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isWifiEnabled() {
        boolean var6712056F5B3773D738C13AB491D89222_1496390349 = (getWifiState() == WIFI_STATE_ENABLED);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getWifiState() == WIFI_STATE_ENABLED;
    }

    
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

    
        public static int compareSignalLevel(int rssiA, int rssiB) {
        return rssiA - rssiB;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.663 -0400", hash_original_method = "2BFE81971E8D979C3ECBD7F543427F67", hash_generated_method = "2652E9103B1EB1F187157DEA126D02D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.663 -0400", hash_original_method = "B0BA72D208162E33734DF133F2E7F6AA", hash_generated_method = "6359D3A931EE8808FA79B28EE5A24002")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWifiApState() {
        try 
        {
            int var2E2FB8DE2B461FD2353125B69D9D13CD_1247958303 = (mService.getWifiApEnabledState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.664 -0400", hash_original_method = "657EB8B0A945E7FD7BA91E2539A322BE", hash_generated_method = "EA2515412D43524B82CD261851563268")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isWifiApEnabled() {
        boolean var50FC8F7F80F7565EBB0DC8805641F4CB_628704351 = (getWifiApState() == WIFI_AP_STATE_ENABLED);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getWifiApState() == WIFI_AP_STATE_ENABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.664 -0400", hash_original_method = "99407E6898AC76390D3E229EC6CF35C4", hash_generated_method = "70094C945256B275BA5EB301DAB3EA90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiConfiguration getWifiApConfiguration() {
        try 
        {
            WifiConfiguration var1B50143FEAE2AB5156DC10C0B1A12D52_1799986198 = (mService.getWifiApConfiguration());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.664 -0400", hash_original_method = "32645F13A37CD40BEF3F9464116D1367", hash_generated_method = "4C5DDB0950C1556811DA052022092918")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.664 -0400", hash_original_method = "F505CF72442DFA261366294723957A53", hash_generated_method = "6832C9A7F4C1AC83408840D40F0E1F7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.665 -0400", hash_original_method = "F7F977701F133D0F59F048A53A2C698B", hash_generated_method = "F25A7B1FA84A1A962D063C76277055D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.665 -0400", hash_original_method = "6E01C15F4CA49AC218CA465537508537", hash_generated_method = "EB567996DD038EB9E988EFBF910F0B4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.665 -0400", hash_original_method = "614FAF75AF873709E1677408EE18D7B6", hash_generated_method = "FFB64129DCB0E8C721F694DE614EE856")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.665 -0400", hash_original_method = "F93FD4BCC6C0F6B375A42EEFE25B9408", hash_generated_method = "9236A94269F6EFDDEC6B43266010A9A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void asyncConnect(Context srcContext, Handler srcHandler) {
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        mAsyncChannel.connect(srcContext, srcHandler, getMessenger());
        // ---------- Original Method ----------
        //mAsyncChannel.connect(srcContext, srcHandler, getMessenger());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.665 -0400", hash_original_method = "B69D8EEDABB0031125B40805CA5F91D8", hash_generated_method = "528F41699F9F735B94E6D7CE38BDCFC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connectNetwork(WifiConfiguration config) {
        dsTaint.addTaint(config.dsTaint);
        mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, config);
        // ---------- Original Method ----------
        //if (config == null) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.666 -0400", hash_original_method = "9464671A8FCBA7A99848867493116AAD", hash_generated_method = "E9DC4562951458D4BAB18BAE321A747C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connectNetwork(int networkId) {
        dsTaint.addTaint(networkId);
        mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, networkId);
        // ---------- Original Method ----------
        //if (networkId < 0) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, networkId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.666 -0400", hash_original_method = "210177ED8E63F9C12E442B1614E4B9E7", hash_generated_method = "B983D0E19FC3F4475951175C33ED496B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void saveNetwork(WifiConfiguration config) {
        dsTaint.addTaint(config.dsTaint);
        mAsyncChannel.sendMessage(CMD_SAVE_NETWORK, config);
        // ---------- Original Method ----------
        //if (config == null) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_SAVE_NETWORK, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.666 -0400", hash_original_method = "A04E73224B607EFF8F851CD080EF29BA", hash_generated_method = "35EB1EC244999C445E93F18EDCAA80BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void forgetNetwork(int netId) {
        dsTaint.addTaint(netId);
        mAsyncChannel.sendMessage(CMD_FORGET_NETWORK, netId);
        // ---------- Original Method ----------
        //if (netId < 0) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_FORGET_NETWORK, netId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.666 -0400", hash_original_method = "CB69F89B2E3E5728AFF3169858F2154E", hash_generated_method = "660BEA4A90D4ED56B4C066CCAB511E7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startWps(WpsInfo config) {
        dsTaint.addTaint(config.dsTaint);
        mAsyncChannel.sendMessage(CMD_START_WPS, config);
        // ---------- Original Method ----------
        //if (config == null) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_START_WPS, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.667 -0400", hash_original_method = "A358F8361C96DABE1A63B04B5804B3F5", hash_generated_method = "5B6979AD81872DA45D74A0C9A7D59738")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Messenger getMessenger() {
        try 
        {
            Messenger varAB82975146F1B86EF7AFAED5EB9D69F9_1753941511 = (mService.getMessenger());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.667 -0400", hash_original_method = "F47F46BF01C13AECFB0A8E0A7BCA30AB", hash_generated_method = "689C67BF011FF5058A954CF1F84352AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getConfigFile() {
        try 
        {
            String var7AF275B0EBE5B43C4D13A70D18439180_650424912 = (mService.getConfigFile());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.667 -0400", hash_original_method = "77C6D00CEFBA51FBEDF42525D5CAF8B4", hash_generated_method = "359629BE064C24604A16FCF34FCA5CBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiLock createWifiLock(int lockType, String tag) {
        dsTaint.addTaint(lockType);
        dsTaint.addTaint(tag);
        WifiLock var3DA606C2261E02B28099F335A7AD0140_1212543033 = (new WifiLock(lockType, tag));
        return (WifiLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new WifiLock(lockType, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.668 -0400", hash_original_method = "F25A7BAA745FE3E1539A4ACAD2E402AC", hash_generated_method = "F1BAF56CDF3145D82FF5B1061B8CD019")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiLock createWifiLock(String tag) {
        dsTaint.addTaint(tag);
        WifiLock varB1DFA43D472B7A90744E356B09421F68_39311503 = (new WifiLock(WIFI_MODE_FULL, tag));
        return (WifiLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new WifiLock(WIFI_MODE_FULL, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.668 -0400", hash_original_method = "90BF24DBA9F26B31ED84B0CABBF9287E", hash_generated_method = "0D7340A0E104A1F212662A84BA095332")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MulticastLock createMulticastLock(String tag) {
        dsTaint.addTaint(tag);
        MulticastLock var0FD8CDA667D17822EC9D51CC5413D75A_1207968912 = (new MulticastLock(tag));
        return (MulticastLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new MulticastLock(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.668 -0400", hash_original_method = "36EA363278EADF8446AD30BF262D8211", hash_generated_method = "C03F32DA6E2264AAC470940FC7B288F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMulticastEnabled() {
        try 
        {
            boolean varF69D9C3FD34D6BAECC97870E612144C2_2089456251 = (mService.isMulticastEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.668 -0400", hash_original_method = "03CE776E3230E83E55C388557E1A9516", hash_generated_method = "E83661934D36FB5BE94F23D88ACF0D5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private IBinder mBinder;
        private int mRefCount;
        int mLockType;
        private boolean mRefCounted;
        private boolean mHeld;
        private WorkSource mWorkSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.669 -0400", hash_original_method = "044CDC682150D26B37DC0497B735DA49", hash_generated_method = "5F8235AEB3886AED5C51F5E4088340BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.670 -0400", hash_original_method = "208DCD1288F5AC0918E067B51EC18B17", hash_generated_method = "95C0AB9BB40A0D76A6B2112CF6C46A8F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void acquire() {
            {
                {
                    try 
                    {
                        mService.acquireWifiLock(mBinder, mLockType, mTag, mWorkSource);
                        {
                            Object var1C3BCBC89D915D09A29A9D7ECF62293F_1596794306 = (WifiManager.this);
                            {
                                {
                                    mService.releaseWifiLock(mBinder);
                                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                                            "Exceeded maximum number of wifi locks");
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (RemoteException ignore)
                    { }
                    mHeld = true;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.671 -0400", hash_original_method = "EEC110369AFED5315DDFD7D45F992208", hash_generated_method = "5DE79EA39FFF70B004D31766494456B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void release() {
            {
                {
                    try 
                    {
                        mService.releaseWifiLock(mBinder);
                        {
                            Object var1C3BCBC89D915D09A29A9D7ECF62293F_216866679 = (WifiManager.this);
                        } //End collapsed parenthetic
                    } //End block
                    catch (RemoteException ignore)
                    { }
                    mHeld = false;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("WifiLock under-locked " + mTag);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.671 -0400", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "0424BD37F4F6EB6DAA9519C0383DDC55")
        @DSModeled(DSC.SAFE)
        public void setReferenceCounted(boolean refCounted) {
            dsTaint.addTaint(refCounted);
            // ---------- Original Method ----------
            //mRefCounted = refCounted;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.672 -0400", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "3372B685D748E4394ED9242A764B794D")
        @DSModeled(DSC.SAFE)
        public boolean isHeld() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.672 -0400", hash_original_method = "7C62BA62C0C3A7C1DC2FB1EDC51DE805", hash_generated_method = "CF9B1F9ED035840A95C590B475F26924")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setWorkSource(WorkSource ws) {
            dsTaint.addTaint(ws.dsTaint);
            {
                {
                    boolean varDCFAF0E9E34CB8562A3C2873888A5A3D_1667821679 = (ws != null && ws.size() == 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.672 -0400", hash_original_method = "30E303CA91E967AFDBED5B1FC9CE8E64", hash_generated_method = "ECB8B4D04FC1C0023E8F2BD4BE063EF3")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.673 -0400", hash_original_method = "CDAA53D98D74A433929787E6E7DF605C", hash_generated_method = "A50FF59100CDC1E31EC9A665597F0EDF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            {
                {
                    try 
                    {
                        mService.releaseWifiLock(mBinder);
                        {
                            Object var1C3BCBC89D915D09A29A9D7ECF62293F_1107299233 = (WifiManager.this);
                        } //End collapsed parenthetic
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
        private IBinder mBinder;
        private int mRefCount;
        private boolean mRefCounted;
        private boolean mHeld;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.673 -0400", hash_original_method = "DEAA1CCFF83554B98BCA4D411D463199", hash_generated_method = "BF534545D5B12104889C35196ACA0615")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.673 -0400", hash_original_method = "130A969831975A68066B20EB1F9033A3", hash_generated_method = "EF9640947257317D560EE1A5126E4C1B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void acquire() {
            {
                {
                    try 
                    {
                        mService.acquireMulticastLock(mBinder, mTag);
                        {
                            Object var1C3BCBC89D915D09A29A9D7ECF62293F_1636885493 = (WifiManager.this);
                            {
                                {
                                    mService.releaseMulticastLock();
                                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                                        "Exceeded maximum number of wifi locks");
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.674 -0400", hash_original_method = "325730E7689E55EAB909A58356E01384", hash_generated_method = "65B7B92FD3F638EA125B16D41218A1CE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void release() {
            {
                {
                    try 
                    {
                        mService.releaseMulticastLock();
                        {
                            Object var1C3BCBC89D915D09A29A9D7ECF62293F_1849104539 = (WifiManager.this);
                        } //End collapsed parenthetic
                    } //End block
                    catch (RemoteException ignore)
                    { }
                    mHeld = false;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("MulticastLock under-locked "
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.674 -0400", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "0424BD37F4F6EB6DAA9519C0383DDC55")
        @DSModeled(DSC.SAFE)
        public void setReferenceCounted(boolean refCounted) {
            dsTaint.addTaint(refCounted);
            // ---------- Original Method ----------
            //mRefCounted = refCounted;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.674 -0400", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "3372B685D748E4394ED9242A764B794D")
        @DSModeled(DSC.SAFE)
        public boolean isHeld() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.675 -0400", hash_original_method = "98C6FF6ECD72200F1F4D177BCA8A2AA1", hash_generated_method = "3298D4C2FBF961955A4BA3AA76CC698E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.675 -0400", hash_original_method = "EEB5ECA4A52575C705D77F616153B22D", hash_generated_method = "AC7C69579F80CDA3C53C84523B03E575")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    public static final int ERROR_AUTHENTICATING = 1;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String WIFI_STATE_CHANGED_ACTION =
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
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String SUPPLICANT_CONNECTION_CHANGE_ACTION =
        "android.net.wifi.supplicant.CONNECTION_CHANGE";
    public static final String EXTRA_SUPPLICANT_CONNECTED = "connected";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String NETWORK_STATE_CHANGED_ACTION = "android.net.wifi.STATE_CHANGE";
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    public static final String EXTRA_BSSID = "bssid";
    public static final String EXTRA_WIFI_INFO = "wifiInfo";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String SUPPLICANT_STATE_CHANGED_ACTION =
        "android.net.wifi.supplicant.STATE_CHANGE";
    public static final String EXTRA_NEW_STATE = "newState";
    public static final String EXTRA_SUPPLICANT_ERROR = "supplicantError";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ERROR_ACTION = "android.net.wifi.ERROR";
    public static final String EXTRA_ERROR_CODE = "errorCode";
    public static final int WPS_OVERLAP_ERROR = 1;
    public static final String CONFIGURED_NETWORKS_CHANGED_ACTION =
        "android.net.wifi.CONFIGURED_NETWORKS_CHANGE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String RSSI_CHANGED_ACTION = "android.net.wifi.RSSI_CHANGED";
    public static final String EXTRA_NEW_RSSI = "newRssi";
    public static final String LINK_CONFIGURATION_CHANGED_ACTION =
        "android.net.wifi.LINK_CONFIGURATION_CHANGED";
    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String NETWORK_IDS_CHANGED_ACTION = "android.net.wifi.NETWORK_IDS_CHANGED";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_PICK_WIFI_NETWORK = "android.net.wifi.PICK_WIFI_NETWORK";
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
    private static final int MAX_ACTIVE_LOCKS = 50;
    public static final int CMD_CONNECT_NETWORK             = 1;
    public static final int CMD_FORGET_NETWORK              = 2;
    public static final int CMD_SAVE_NETWORK                = 3;
    public static final int CMD_START_WPS                   = 4;
    public static final int CMD_DISABLE_NETWORK             = 5;
    public static final int CMD_WPS_COMPLETED               = 11;
    public static final int CMD_ENABLE_TRAFFIC_STATS_POLL   = 21;
    public static final int CMD_TRAFFIC_STATS_POLL          = 22;
}

