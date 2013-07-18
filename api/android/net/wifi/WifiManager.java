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
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class WifiManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.417 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "DB1464CA9C87828D9D93BD784121DA8C")

    IWifiManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.417 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.417 -0400", hash_original_field = "515CEC5C60BFB489FCE4D019DF434BA7", hash_generated_field = "D601BE33010BF0FF8F79216654DBC58D")

    private int mActiveLockCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.418 -0400", hash_original_field = "5FD29322753C3A7384C678B13BEFD72D", hash_generated_field = "C8DF611874A1503E325C16431857C1F2")

    private AsyncChannel mAsyncChannel = new AsyncChannel();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.418 -0400", hash_original_method = "45AC664258FD08C08C588B627CDDFFBC", hash_generated_method = "B4F1E9EA15C43234D8FE3A9CE9AF5CBA")
    public  WifiManager(IWifiManager service, Handler handler) {
        mService = service;
        mHandler = handler;
        // ---------- Original Method ----------
        //mService = service;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.419 -0400", hash_original_method = "7B7EDD72C806D0E7DC8642CC316AA722", hash_generated_method = "1D8DC1E24F27075C28B671CD3E21E8B2")
    public List<WifiConfiguration> getConfiguredNetworks() {
        try 
        {
List<WifiConfiguration> var4F88E0AB1FAFC9504D31144C9834BCBC_1895520904 =             mService.getConfiguredNetworks();
            var4F88E0AB1FAFC9504D31144C9834BCBC_1895520904.addTaint(taint);
            return var4F88E0AB1FAFC9504D31144C9834BCBC_1895520904;
        } //End block
        catch (RemoteException e)
        {
List<WifiConfiguration> var540C13E9E156B687226421B24F2DF178_230204521 =             null;
            var540C13E9E156B687226421B24F2DF178_230204521.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_230204521;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getConfiguredNetworks();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.420 -0400", hash_original_method = "FC0AD51F5109F6EE6B896159A6BE091E", hash_generated_method = "23D9BCA63E298452EDF5E7973EF69011")
    public int addNetwork(WifiConfiguration config) {
        addTaint(config.getTaint());
        if(config == null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2144923533 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_397527887 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_397527887;
        } //End block
        config.networkId = -1;
        int varC1C5E035E8D95985B9800E271455F437_1546228591 = (addOrUpdateNetwork(config));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799039937 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799039937;
        // ---------- Original Method ----------
        //if (config == null) {
            //return -1;
        //}
        //config.networkId = -1;
        //return addOrUpdateNetwork(config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.421 -0400", hash_original_method = "BAE559B7BC959F87E1981FBD6EC47DF5", hash_generated_method = "3B3171977041A701F8E2237E9C243333")
    public int updateNetwork(WifiConfiguration config) {
        addTaint(config.getTaint());
        if(config == null || config.networkId < 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_119687641 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159420027 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159420027;
        } //End block
        int varC1C5E035E8D95985B9800E271455F437_1609199553 = (addOrUpdateNetwork(config));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310382192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310382192;
        // ---------- Original Method ----------
        //if (config == null || config.networkId < 0) {
            //return -1;
        //}
        //return addOrUpdateNetwork(config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.422 -0400", hash_original_method = "E64504FDFA81026BF4EAE79A420D3010", hash_generated_method = "0C2739DCCB9DF9337379116B64874F00")
    private int addOrUpdateNetwork(WifiConfiguration config) {
        addTaint(config.getTaint());
        try 
        {
            int varDECE89ACD3A11BE8062E2E75EE60ED08_163889358 = (mService.addOrUpdateNetwork(config));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115833024 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115833024;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1467899426 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581578062 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581578062;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.addOrUpdateNetwork(config);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.423 -0400", hash_original_method = "C55861B25E581745B3C6351405363685", hash_generated_method = "0D8DABCBFB4F4804ADDB8B4A62A7B313")
    public boolean removeNetwork(int netId) {
        addTaint(netId);
        try 
        {
            boolean var6B07C45DCB6CCB41DCA24C3BC88383F2_619012630 = (mService.removeNetwork(netId));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_398190468 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_398190468;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1917038028 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_823157638 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_823157638;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.removeNetwork(netId);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.424 -0400", hash_original_method = "A063D2F3A1A45A8B2BB20D41F98AEB1B", hash_generated_method = "F8F66C6423DD6441A6804AF08BF04184")
    public boolean enableNetwork(int netId, boolean disableOthers) {
        addTaint(disableOthers);
        addTaint(netId);
        try 
        {
            boolean varA1C31F584B760D1424F1E6692105D579_1467548266 = (mService.enableNetwork(netId, disableOthers));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137929643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137929643;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1406916885 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398725713 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398725713;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.enableNetwork(netId, disableOthers);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.426 -0400", hash_original_method = "630BE7480BA2E95DA9CEC1F52BBE219A", hash_generated_method = "B14AEEA61DA5D40AF6809DCA3EAF9303")
    public boolean disableNetwork(int netId) {
        addTaint(netId);
        try 
        {
            boolean var1993053558E4FE4C474056782C19D982_1542397029 = (mService.disableNetwork(netId));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164349169 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_164349169;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_990922513 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16128091 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_16128091;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.disableNetwork(netId);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.427 -0400", hash_original_method = "4C2FCF871904470A4665E52D44D62875", hash_generated_method = "1BA8F87A87CA4418688E41CB10EB2A97")
    public void disableNetwork(int netId, int reason) {
        addTaint(reason);
        addTaint(netId);
        mAsyncChannel.sendMessage(CMD_DISABLE_NETWORK, netId, reason);
        // ---------- Original Method ----------
        //mAsyncChannel.sendMessage(CMD_DISABLE_NETWORK, netId, reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.429 -0400", hash_original_method = "13D7026BA6E2310038D9CCEC7D1F5CA4", hash_generated_method = "4B07EFDED4FA8A5BB24DC0C8FB0392C1")
    public boolean disconnect() {
        try 
        {
            mService.disconnect();
            boolean varB326B5062B2F0E69046810717534CB09_1720986208 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098459600 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098459600;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1663380144 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_726168649 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_726168649;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.disconnect();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.430 -0400", hash_original_method = "AD9DD9C3B4130EB49C99A6BF92BCA383", hash_generated_method = "C317D7BD2F460A0598C5181092866A73")
    public boolean reconnect() {
        try 
        {
            mService.reconnect();
            boolean varB326B5062B2F0E69046810717534CB09_1346459979 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_593278372 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_593278372;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1773110528 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1988148165 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1988148165;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.reconnect();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.431 -0400", hash_original_method = "4462A23EEF44DC4F050ECB7EA4566A65", hash_generated_method = "95A5741D2723FA722B7D589C7F4D2540")
    public boolean reassociate() {
        try 
        {
            mService.reassociate();
            boolean varB326B5062B2F0E69046810717534CB09_405531456 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787414928 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_787414928;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1492010607 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988641701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_988641701;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.reassociate();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.432 -0400", hash_original_method = "44FE7083E78F583BB16CDAFA3EBE6F36", hash_generated_method = "B5F9E82ECDFAA480D8407327AA7FE2E4")
    public boolean pingSupplicant() {
        if(mService == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_394903637 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1487720558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1487720558;
        }
        try 
        {
            boolean var2FA21A90D885B88AD93ADB5FDF7246A2_1350581010 = (mService.pingSupplicant());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_502707474 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_502707474;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1347236401 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406096912 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406096912;
        } //End block
        // ---------- Original Method ----------
        //if (mService == null)
            //return false;
        //try {
            //return mService.pingSupplicant();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.433 -0400", hash_original_method = "F8088016DD577DAE90193BD2B16E77E5", hash_generated_method = "1909980506968383D340FA834541BA78")
    public boolean startScan() {
        try 
        {
            mService.startScan(false);
            boolean varB326B5062B2F0E69046810717534CB09_1180968831 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1728264394 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1728264394;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1204339425 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796750051 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796750051;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.startScan(false);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.435 -0400", hash_original_method = "1BECDA97215EAB893F9C0F926E7877B4", hash_generated_method = "960FF3A1865B5F5C0051A520401AB961")
    public boolean startScanActive() {
        try 
        {
            mService.startScan(true);
            boolean varB326B5062B2F0E69046810717534CB09_1534448433 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634038441 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634038441;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1880553876 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815243640 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815243640;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.startScan(true);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.436 -0400", hash_original_method = "8E854EE6D7B979BB188C54EFD6BB6717", hash_generated_method = "FD7FFA06A343616BA3EFB1D661E32C5A")
    public WifiInfo getConnectionInfo() {
        try 
        {
WifiInfo var5705730BFC480D0E115D28CF547AA341_181000122 =             mService.getConnectionInfo();
            var5705730BFC480D0E115D28CF547AA341_181000122.addTaint(taint);
            return var5705730BFC480D0E115D28CF547AA341_181000122;
        } //End block
        catch (RemoteException e)
        {
WifiInfo var540C13E9E156B687226421B24F2DF178_372584698 =             null;
            var540C13E9E156B687226421B24F2DF178_372584698.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_372584698;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getConnectionInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.437 -0400", hash_original_method = "ADD60A4DA3445A3E968EB713F725E5F1", hash_generated_method = "B78F4C5003FD8F83FF6A15A26E6FD184")
    public List<ScanResult> getScanResults() {
        try 
        {
List<ScanResult> varDA562D6FE80BAE8CA65C00F581C14445_1151959716 =             mService.getScanResults();
            varDA562D6FE80BAE8CA65C00F581C14445_1151959716.addTaint(taint);
            return varDA562D6FE80BAE8CA65C00F581C14445_1151959716;
        } //End block
        catch (RemoteException e)
        {
List<ScanResult> var540C13E9E156B687226421B24F2DF178_2128924608 =             null;
            var540C13E9E156B687226421B24F2DF178_2128924608.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2128924608;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getScanResults();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.438 -0400", hash_original_method = "D1E32319AD181FF60DD93B5B2DB831F1", hash_generated_method = "2A3DEB4F9E1D9F7335290AFD6D4048A2")
    public boolean saveConfiguration() {
        try 
        {
            boolean var2C617EC4E42A92E0074105B18F95650E_445676725 = (mService.saveConfiguration());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396863224 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396863224;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_255461698 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710713239 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_710713239;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.saveConfiguration();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.439 -0400", hash_original_method = "9549A9F9433914F9E55F5CC34183554C", hash_generated_method = "AB8215AB2A46AFE10B080E75EED6B225")
    public void setCountryCode(String country, boolean persist) {
        addTaint(persist);
        addTaint(country.getTaint());
        try 
        {
            mService.setCountryCode(country, persist);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setCountryCode(country, persist);
        //} catch (RemoteException e) { }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.440 -0400", hash_original_method = "4B6C5827C7D51FB40ECD8DD67D760E19", hash_generated_method = "780648C0C390E84DC57B3D184EDCD094")
    public void setFrequencyBand(int band, boolean persist) {
        addTaint(persist);
        addTaint(band);
        try 
        {
            mService.setFrequencyBand(band, persist);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setFrequencyBand(band, persist);
        //} catch (RemoteException e) { }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.440 -0400", hash_original_method = "481BDDBC9D497285776974614BBC7D82", hash_generated_method = "160D7DE61B7D088EFFF851AA1440F75D")
    public int getFrequencyBand() {
        try 
        {
            int var717522526F6DCF9BC53B4B1C7DA1C250_868600535 = (mService.getFrequencyBand());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464734675 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464734675;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1602222043 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_32418819 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_32418819;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getFrequencyBand();
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.441 -0400", hash_original_method = "F73D127A0D43FAD1AD9DBA6A689AC70A", hash_generated_method = "5B61129B2F1526B8F7B48320DE5D5CDA")
    public boolean isDualBandSupported() {
        try 
        {
            boolean varEAAC367DCCD52A845F65255FF7683621_923234980 = (mService.isDualBandSupported());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113401494 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113401494;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1135449974 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1076122300 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1076122300;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.isDualBandSupported();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.442 -0400", hash_original_method = "711DEA09870DB7E049F72B7F8BEBC0A1", hash_generated_method = "1ACC0264F53F570E4254FD246793BE78")
    public DhcpInfo getDhcpInfo() {
        try 
        {
DhcpInfo var7F156C3E06F3DD8F97345C4B0AD9B9CB_1935399554 =             mService.getDhcpInfo();
            var7F156C3E06F3DD8F97345C4B0AD9B9CB_1935399554.addTaint(taint);
            return var7F156C3E06F3DD8F97345C4B0AD9B9CB_1935399554;
        } //End block
        catch (RemoteException e)
        {
DhcpInfo var540C13E9E156B687226421B24F2DF178_1330563889 =             null;
            var540C13E9E156B687226421B24F2DF178_1330563889.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1330563889;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getDhcpInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.443 -0400", hash_original_method = "B9430AD639DDE3004B577A4BF40EB18B", hash_generated_method = "5F8930B760EFFA53F660C57C1CEFBE1B")
    public boolean setWifiEnabled(boolean enabled) {
        addTaint(enabled);
        try 
        {
            boolean varBA7F2CCA3EE31C1A94DA0BEE5B8C6AEB_513291969 = (mService.setWifiEnabled(enabled));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295784849 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_295784849;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_426242168 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1180763623 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1180763623;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.setWifiEnabled(enabled);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.444 -0400", hash_original_method = "661FA885AE58B8C5231BF7DCF436505F", hash_generated_method = "BB262656999BD7AB954812CA1029E2C9")
    public int getWifiState() {
        try 
        {
            int varCD3132D86DB75414323C23431124E8FE_1144860613 = (mService.getWifiEnabledState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_244838974 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_244838974;
        } //End block
        catch (RemoteException e)
        {
            int var6D01601C9C9E20C43DFDDFE008E5E522_2056667079 = (WIFI_STATE_UNKNOWN);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389912380 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389912380;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getWifiEnabledState();
        //} catch (RemoteException e) {
            //return WIFI_STATE_UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.445 -0400", hash_original_method = "D7F0AFD1306EBF22F34F7E014A2C9B11", hash_generated_method = "F7E187A0BECD848F2DE39FD094D5017B")
    public boolean isWifiEnabled() {
        boolean varDEB3A887086CF2643222589D79401497_801341533 = (getWifiState() == WIFI_STATE_ENABLED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814444277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_814444277;
        // ---------- Original Method ----------
        //return getWifiState() == WIFI_STATE_ENABLED;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static int compareSignalLevel(int rssiA, int rssiB) {
        return rssiA - rssiB;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.447 -0400", hash_original_method = "2BFE81971E8D979C3ECBD7F543427F67", hash_generated_method = "DABBF9717DEA43AD27DB1D63F2B9F50F")
    public boolean setWifiApEnabled(WifiConfiguration wifiConfig, boolean enabled) {
        addTaint(enabled);
        addTaint(wifiConfig.getTaint());
        try 
        {
            mService.setWifiApEnabled(wifiConfig, enabled);
            boolean varB326B5062B2F0E69046810717534CB09_563784533 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_973341501 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_973341501;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_694858375 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163324170 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163324170;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setWifiApEnabled(wifiConfig, enabled);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.448 -0400", hash_original_method = "B0BA72D208162E33734DF133F2E7F6AA", hash_generated_method = "99B4DD67606E16F8F798D5CD5F3FFD2A")
    public int getWifiApState() {
        try 
        {
            int varD8CD85E85B7114B7C946D7366D0D5A87_530290629 = (mService.getWifiApEnabledState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748311908 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748311908;
        } //End block
        catch (RemoteException e)
        {
            int var838CE68F82E46116D81DE0525785B96B_1268297900 = (WIFI_AP_STATE_FAILED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77108445 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77108445;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getWifiApEnabledState();
        //} catch (RemoteException e) {
            //return WIFI_AP_STATE_FAILED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.448 -0400", hash_original_method = "657EB8B0A945E7FD7BA91E2539A322BE", hash_generated_method = "DBA52A744FB070057D2F06FA531033A7")
    public boolean isWifiApEnabled() {
        boolean var2AD5E4D3AFB8F4B8AA800AF5E27BBAE9_1425319853 = (getWifiApState() == WIFI_AP_STATE_ENABLED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_709246700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_709246700;
        // ---------- Original Method ----------
        //return getWifiApState() == WIFI_AP_STATE_ENABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.449 -0400", hash_original_method = "99407E6898AC76390D3E229EC6CF35C4", hash_generated_method = "0E381B067728193D9AABE30ACEEA581E")
    public WifiConfiguration getWifiApConfiguration() {
        try 
        {
WifiConfiguration var5445B0BDAF6A8DA52A529FEF1AED454F_172818878 =             mService.getWifiApConfiguration();
            var5445B0BDAF6A8DA52A529FEF1AED454F_172818878.addTaint(taint);
            return var5445B0BDAF6A8DA52A529FEF1AED454F_172818878;
        } //End block
        catch (RemoteException e)
        {
WifiConfiguration var540C13E9E156B687226421B24F2DF178_1133598784 =             null;
            var540C13E9E156B687226421B24F2DF178_1133598784.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1133598784;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getWifiApConfiguration();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.450 -0400", hash_original_method = "32645F13A37CD40BEF3F9464116D1367", hash_generated_method = "17889891F1A05AABE40475FBFF717A56")
    public boolean setWifiApConfiguration(WifiConfiguration wifiConfig) {
        addTaint(wifiConfig.getTaint());
        try 
        {
            mService.setWifiApConfiguration(wifiConfig);
            boolean varB326B5062B2F0E69046810717534CB09_364847724 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136655036 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_136655036;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_2068169431 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_846952890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_846952890;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setWifiApConfiguration(wifiConfig);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.451 -0400", hash_original_method = "F505CF72442DFA261366294723957A53", hash_generated_method = "3815053CB65244B89621779CEBA75B95")
    public boolean startWifi() {
        try 
        {
            mService.startWifi();
            boolean varB326B5062B2F0E69046810717534CB09_1859760590 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1014953617 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1014953617;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_440133420 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1590700542 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1590700542;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.startWifi();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.452 -0400", hash_original_method = "F7F977701F133D0F59F048A53A2C698B", hash_generated_method = "7B1FD2692470EBDC1AF74E3EFDE8BBA5")
    public boolean stopWifi() {
        try 
        {
            mService.stopWifi();
            boolean varB326B5062B2F0E69046810717534CB09_1304817124 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467354954 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467354954;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_584316238 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845370170 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845370170;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.stopWifi();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.453 -0400", hash_original_method = "6E01C15F4CA49AC218CA465537508537", hash_generated_method = "F9FCA34728499923035948A9E3F0C019")
    public boolean addToBlacklist(String bssid) {
        addTaint(bssid.getTaint());
        try 
        {
            mService.addToBlacklist(bssid);
            boolean varB326B5062B2F0E69046810717534CB09_807800569 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579746572 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579746572;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1125497971 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844367340 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_844367340;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.addToBlacklist(bssid);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.454 -0400", hash_original_method = "614FAF75AF873709E1677408EE18D7B6", hash_generated_method = "384EE96B01853435E4D1A6BAD5F5BAF8")
    public boolean clearBlacklist() {
        try 
        {
            mService.clearBlacklist();
            boolean varB326B5062B2F0E69046810717534CB09_1441748596 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_545789287 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_545789287;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_734388675 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1391250491 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1391250491;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.clearBlacklist();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.455 -0400", hash_original_method = "F93FD4BCC6C0F6B375A42EEFE25B9408", hash_generated_method = "F0745431211788A9F31DAC89ED140603")
    public void asyncConnect(Context srcContext, Handler srcHandler) {
        addTaint(srcHandler.getTaint());
        addTaint(srcContext.getTaint());
        mAsyncChannel.connect(srcContext, srcHandler, getMessenger());
        // ---------- Original Method ----------
        //mAsyncChannel.connect(srcContext, srcHandler, getMessenger());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.456 -0400", hash_original_method = "B69D8EEDABB0031125B40805CA5F91D8", hash_generated_method = "FEE6B5B517EB6F3402902C4D90A6915C")
    public void connectNetwork(WifiConfiguration config) {
        addTaint(config.getTaint());
        if(config == null)        
        {
            return;
        } //End block
        mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, config);
        // ---------- Original Method ----------
        //if (config == null) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.457 -0400", hash_original_method = "9464671A8FCBA7A99848867493116AAD", hash_generated_method = "BF2CCD32967AD1DD1F5BC178139A1AAD")
    public void connectNetwork(int networkId) {
        addTaint(networkId);
        if(networkId < 0)        
        {
            return;
        } //End block
        mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, networkId);
        // ---------- Original Method ----------
        //if (networkId < 0) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, networkId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.458 -0400", hash_original_method = "210177ED8E63F9C12E442B1614E4B9E7", hash_generated_method = "99E91FEBF569488B60C7CFA0FD7C1CC9")
    public void saveNetwork(WifiConfiguration config) {
        addTaint(config.getTaint());
        if(config == null)        
        {
            return;
        } //End block
        mAsyncChannel.sendMessage(CMD_SAVE_NETWORK, config);
        // ---------- Original Method ----------
        //if (config == null) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_SAVE_NETWORK, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.459 -0400", hash_original_method = "A04E73224B607EFF8F851CD080EF29BA", hash_generated_method = "54A1E6A6F717307C4C85F9C2E17F9960")
    public void forgetNetwork(int netId) {
        addTaint(netId);
        if(netId < 0)        
        {
            return;
        } //End block
        mAsyncChannel.sendMessage(CMD_FORGET_NETWORK, netId);
        // ---------- Original Method ----------
        //if (netId < 0) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_FORGET_NETWORK, netId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.459 -0400", hash_original_method = "CB69F89B2E3E5728AFF3169858F2154E", hash_generated_method = "7E7690C8BFC0C5E0E1D371EC87A08CCB")
    public void startWps(WpsInfo config) {
        addTaint(config.getTaint());
        if(config == null)        
        {
            return;
        } //End block
        mAsyncChannel.sendMessage(CMD_START_WPS, config);
        // ---------- Original Method ----------
        //if (config == null) {
            //return;
        //}
        //mAsyncChannel.sendMessage(CMD_START_WPS, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.460 -0400", hash_original_method = "A358F8361C96DABE1A63B04B5804B3F5", hash_generated_method = "9DBA59B30A59B025D90ED5E4EAA3E9C3")
    public Messenger getMessenger() {
        try 
        {
Messenger varF7929FC05940900E4513D8262C8E2654_1481374137 =             mService.getMessenger();
            varF7929FC05940900E4513D8262C8E2654_1481374137.addTaint(taint);
            return varF7929FC05940900E4513D8262C8E2654_1481374137;
        } //End block
        catch (RemoteException e)
        {
Messenger var540C13E9E156B687226421B24F2DF178_2051790017 =             null;
            var540C13E9E156B687226421B24F2DF178_2051790017.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2051790017;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getMessenger();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.462 -0400", hash_original_method = "F47F46BF01C13AECFB0A8E0A7BCA30AB", hash_generated_method = "67D2C02AF7729F26A640A16852BF6CAD")
    public String getConfigFile() {
        try 
        {
String varB42BB982F8EC56A555249A2A6B239AC0_579514503 =             mService.getConfigFile();
            varB42BB982F8EC56A555249A2A6B239AC0_579514503.addTaint(taint);
            return varB42BB982F8EC56A555249A2A6B239AC0_579514503;
        } //End block
        catch (RemoteException e)
        {
String var540C13E9E156B687226421B24F2DF178_1087025645 =             null;
            var540C13E9E156B687226421B24F2DF178_1087025645.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1087025645;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getConfigFile();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.463 -0400", hash_original_method = "77C6D00CEFBA51FBEDF42525D5CAF8B4", hash_generated_method = "92F989D2565C90CE2A700181DABCCEBC")
    public WifiLock createWifiLock(int lockType, String tag) {
        addTaint(tag.getTaint());
        addTaint(lockType);
WifiLock var780FF626E0BEB022C692CAF9DB88BC6C_711600355 =         new WifiLock(lockType, tag);
        var780FF626E0BEB022C692CAF9DB88BC6C_711600355.addTaint(taint);
        return var780FF626E0BEB022C692CAF9DB88BC6C_711600355;
        // ---------- Original Method ----------
        //return new WifiLock(lockType, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.463 -0400", hash_original_method = "F25A7BAA745FE3E1539A4ACAD2E402AC", hash_generated_method = "E3C33596911F4AACF8CDC71B846D8DD7")
    public WifiLock createWifiLock(String tag) {
        addTaint(tag.getTaint());
WifiLock var1515066542E695DE079F7D0491648C60_1404625542 =         new WifiLock(WIFI_MODE_FULL, tag);
        var1515066542E695DE079F7D0491648C60_1404625542.addTaint(taint);
        return var1515066542E695DE079F7D0491648C60_1404625542;
        // ---------- Original Method ----------
        //return new WifiLock(WIFI_MODE_FULL, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.464 -0400", hash_original_method = "90BF24DBA9F26B31ED84B0CABBF9287E", hash_generated_method = "D51E095D6AF3FF34EC0A72055B152043")
    public MulticastLock createMulticastLock(String tag) {
        addTaint(tag.getTaint());
MulticastLock varF7F0BDC4D2B91B78614D3DAAA6856880_973696805 =         new MulticastLock(tag);
        varF7F0BDC4D2B91B78614D3DAAA6856880_973696805.addTaint(taint);
        return varF7F0BDC4D2B91B78614D3DAAA6856880_973696805;
        // ---------- Original Method ----------
        //return new MulticastLock(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.464 -0400", hash_original_method = "36EA363278EADF8446AD30BF262D8211", hash_generated_method = "B181F6352DF73D2F66C8B5F35A1E33EC")
    public boolean isMulticastEnabled() {
        try 
        {
            boolean varD730F55F40FFB516E40037129275C513_1738964480 = (mService.isMulticastEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_103821949 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_103821949;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_2000270000 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2042442285 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2042442285;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.isMulticastEnabled();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.465 -0400", hash_original_method = "03CE776E3230E83E55C388557E1A9516", hash_generated_method = "8E023DD90132F46D9B6586D5CA5886C4")
    public boolean initializeMulticastFiltering() {
        try 
        {
            mService.initializeMulticastFiltering();
            boolean varB326B5062B2F0E69046810717534CB09_1976462475 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_91550570 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_91550570;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_958761723 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_427453375 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_427453375;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.initializeMulticastFiltering();
            //return true;
        //} catch (RemoteException e) {
             //return false;
        //}
    }

    
    public class WifiLock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.466 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.466 -0400", hash_original_field = "59251AD7EF4786A1A863CD24E536AB17", hash_generated_field = "A726660A8F3C406901F3D212C617E404")

        private IBinder mBinder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.466 -0400", hash_original_field = "DAC8A06C1EDF9825CDAF6DFCD18A7ADC", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

        private int mRefCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.466 -0400", hash_original_field = "2E26F41B503854D2664C327E649E3CAE", hash_generated_field = "3AD78D1D4CE6492B77426188DE5C8EB6")

        int mLockType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.466 -0400", hash_original_field = "2027736A79052BCC8F6250B2A1BACD52", hash_generated_field = "EEB06CC18CFEB1CEBC8608AACD58D0B5")

        private boolean mRefCounted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.466 -0400", hash_original_field = "AD25B113814807D236AFB0F5095B0005", hash_generated_field = "CC6ABDC2865C3E48C44DCFBA12BDB07C")

        private boolean mHeld;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.466 -0400", hash_original_field = "33F0FDFE72CD4D291DF24A21567DB5C9", hash_generated_field = "C5BF497580D66C18B0028C0F7134DDF3")

        private WorkSource mWorkSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.469 -0400", hash_original_method = "044CDC682150D26B37DC0497B735DA49", hash_generated_method = "1273DB766F5BD50415DCCD366CA34B18")
        private  WifiLock(int lockType, String tag) {
            mTag = tag;
            mLockType = lockType;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.470 -0400", hash_original_method = "208DCD1288F5AC0918E067B51EC18B17", hash_generated_method = "DC3CEB59BE74D54810B5CCF41FB87D95")
        public void acquire() {
            synchronized
(mBinder)            {
                if(mRefCounted ? (++mRefCount > 0) : (!mHeld))                
                {
                    try 
                    {
                        mService.acquireWifiLock(mBinder, mLockType, mTag, mWorkSource);
                        synchronized
(WifiManager.this)                        {
                            if(mActiveLockCount >= MAX_ACTIVE_LOCKS)                            
                            {
                                mService.releaseWifiLock(mBinder);
                                UnsupportedOperationException var6FB6F703E86436697EADCF1E3CEE23D9_1532962891 = new UnsupportedOperationException(
                                            "Exceeded maximum number of wifi locks");
                                var6FB6F703E86436697EADCF1E3CEE23D9_1532962891.addTaint(taint);
                                throw var6FB6F703E86436697EADCF1E3CEE23D9_1532962891;
                            } //End block
                            mActiveLockCount++;
                        } //End block
                    } //End block
                    catch (RemoteException ignore)
                    {
                    } //End block
                    mHeld = true;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.471 -0400", hash_original_method = "EEC110369AFED5315DDFD7D45F992208", hash_generated_method = "2E9A8EE061EE7CEF8DE20D47AAA7D97B")
        public void release() {
            synchronized
(mBinder)            {
                if(mRefCounted ? (--mRefCount == 0) : (mHeld))                
                {
                    try 
                    {
                        mService.releaseWifiLock(mBinder);
                        synchronized
(WifiManager.this)                        {
                            mActiveLockCount--;
                        } //End block
                    } //End block
                    catch (RemoteException ignore)
                    {
                    } //End block
                    mHeld = false;
                } //End block
                if(mRefCount < 0)                
                {
                    RuntimeException varC201BD43267ABC9990F7A44596550D06_1931813674 = new RuntimeException("WifiLock under-locked " + mTag);
                    varC201BD43267ABC9990F7A44596550D06_1931813674.addTaint(taint);
                    throw varC201BD43267ABC9990F7A44596550D06_1931813674;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.472 -0400", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "91B8A28629F935F303A73D2F07650B69")
        public void setReferenceCounted(boolean refCounted) {
            mRefCounted = refCounted;
            // ---------- Original Method ----------
            //mRefCounted = refCounted;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.472 -0400", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "DA4FA9643D71C20ADD9EB7D7BE65F958")
        public boolean isHeld() {
            synchronized
(mBinder)            {
                boolean varAD25B113814807D236AFB0F5095B0005_583705025 = (mHeld);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_670144635 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_670144635;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.474 -0400", hash_original_method = "7C62BA62C0C3A7C1DC2FB1EDC51DE805", hash_generated_method = "77121D7B133841530807150DBFF1D3DB")
        public void setWorkSource(WorkSource ws) {
            synchronized
(mBinder)            {
                if(ws != null && ws.size() == 0)                
                {
                    ws = null;
                } //End block
                boolean changed = true;
                if(ws == null)                
                {
                    mWorkSource = null;
                } //End block
                else
                if(mWorkSource == null)                
                {
                    changed = mWorkSource != null;
                    mWorkSource = new WorkSource(ws);
                } //End block
                else
                {
                    changed = mWorkSource.diff(ws);
                    if(changed)                    
                    {
                        mWorkSource.set(ws);
                    } //End block
                } //End block
                if(changed && mHeld)                
                {
                    try 
                    {
                        mService.updateWifiLockWorkSource(mBinder, mWorkSource);
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.476 -0400", hash_original_method = "30E303CA91E967AFDBED5B1FC9CE8E64", hash_generated_method = "58794497321D8509C244E1848A4EDD6E")
        public String toString() {
            String s1;
            String s2;
            String s3;
            synchronized
(mBinder)            {
                s1 = Integer.toHexString(System.identityHashCode(this));
                s2 = mHeld ? "held; " : "";
                if(mRefCounted)                
                {
                    s3 = "refcounted: refcount = " + mRefCount;
                } //End block
                else
                {
                    s3 = "not refcounted";
                } //End block
String varF6BD25B17478B3615FCC3F9239B0D36D_827980516 =                 "WifiLock{ " + s1 + "; " + s2 + s3 + " }";
                varF6BD25B17478B3615FCC3F9239B0D36D_827980516.addTaint(taint);
                return varF6BD25B17478B3615FCC3F9239B0D36D_827980516;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.477 -0400", hash_original_method = "CDAA53D98D74A433929787E6E7DF605C", hash_generated_method = "6715256FE3F91AE0459CB3C1E10A46D0")
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            synchronized
(mBinder)            {
                if(mHeld)                
                {
                    try 
                    {
                        mService.releaseWifiLock(mBinder);
                        synchronized
(WifiManager.this)                        {
                            mActiveLockCount--;
                        } //End block
                    } //End block
                    catch (RemoteException ignore)
                    {
                    } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.477 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.477 -0400", hash_original_field = "59251AD7EF4786A1A863CD24E536AB17", hash_generated_field = "A726660A8F3C406901F3D212C617E404")

        private IBinder mBinder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.478 -0400", hash_original_field = "DAC8A06C1EDF9825CDAF6DFCD18A7ADC", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

        private int mRefCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.478 -0400", hash_original_field = "2027736A79052BCC8F6250B2A1BACD52", hash_generated_field = "EEB06CC18CFEB1CEBC8608AACD58D0B5")

        private boolean mRefCounted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.478 -0400", hash_original_field = "AD25B113814807D236AFB0F5095B0005", hash_generated_field = "CC6ABDC2865C3E48C44DCFBA12BDB07C")

        private boolean mHeld;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.480 -0400", hash_original_method = "DEAA1CCFF83554B98BCA4D411D463199", hash_generated_method = "A1769D3129EB80B6FA9D01C9F3980BAA")
        private  MulticastLock(String tag) {
            mTag = tag;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.481 -0400", hash_original_method = "130A969831975A68066B20EB1F9033A3", hash_generated_method = "C72AD6D96802ED9BDE1F91FE61F4AE0A")
        public void acquire() {
            synchronized
(mBinder)            {
                if(mRefCounted ? (++mRefCount > 0) : (!mHeld))                
                {
                    try 
                    {
                        mService.acquireMulticastLock(mBinder, mTag);
                        synchronized
(WifiManager.this)                        {
                            if(mActiveLockCount >= MAX_ACTIVE_LOCKS)                            
                            {
                                mService.releaseMulticastLock();
                                UnsupportedOperationException var6FB6F703E86436697EADCF1E3CEE23D9_252790838 = new UnsupportedOperationException(
                                        "Exceeded maximum number of wifi locks");
                                var6FB6F703E86436697EADCF1E3CEE23D9_252790838.addTaint(taint);
                                throw var6FB6F703E86436697EADCF1E3CEE23D9_252790838;
                            } //End block
                            mActiveLockCount++;
                        } //End block
                    } //End block
                    catch (RemoteException ignore)
                    {
                    } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.482 -0400", hash_original_method = "325730E7689E55EAB909A58356E01384", hash_generated_method = "423066BF9F59209BC78F3DED9C3D7240")
        public void release() {
            synchronized
(mBinder)            {
                if(mRefCounted ? (--mRefCount == 0) : (mHeld))                
                {
                    try 
                    {
                        mService.releaseMulticastLock();
                        synchronized
(WifiManager.this)                        {
                            mActiveLockCount--;
                        } //End block
                    } //End block
                    catch (RemoteException ignore)
                    {
                    } //End block
                    mHeld = false;
                } //End block
                if(mRefCount < 0)                
                {
                    RuntimeException varBAC7FC4092273E4A09516AB353844518_807766958 = new RuntimeException("MulticastLock under-locked "
                            + mTag);
                    varBAC7FC4092273E4A09516AB353844518_807766958.addTaint(taint);
                    throw varBAC7FC4092273E4A09516AB353844518_807766958;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.483 -0400", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "91B8A28629F935F303A73D2F07650B69")
        public void setReferenceCounted(boolean refCounted) {
            mRefCounted = refCounted;
            // ---------- Original Method ----------
            //mRefCounted = refCounted;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.484 -0400", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "070A5221A793E69FD095A64CD7371DC3")
        public boolean isHeld() {
            synchronized
(mBinder)            {
                boolean varAD25B113814807D236AFB0F5095B0005_849560343 = (mHeld);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296900539 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296900539;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.485 -0400", hash_original_method = "98C6FF6ECD72200F1F4D177BCA8A2AA1", hash_generated_method = "E49F26DF9F2A76B76DAE646DBD94C077")
        public String toString() {
            String s1;
            String s2;
            String s3;
            synchronized
(mBinder)            {
                s1 = Integer.toHexString(System.identityHashCode(this));
                s2 = mHeld ? "held; " : "";
                if(mRefCounted)                
                {
                    s3 = "refcounted: refcount = " + mRefCount;
                } //End block
                else
                {
                    s3 = "not refcounted";
                } //End block
String var1932DB5234F23C2D55EBC21AE51F4029_1107740349 =                 "MulticastLock{ " + s1 + "; " + s2 + s3 + " }";
                var1932DB5234F23C2D55EBC21AE51F4029_1107740349.addTaint(taint);
                return var1932DB5234F23C2D55EBC21AE51F4029_1107740349;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.485 -0400", hash_original_method = "EEB5ECA4A52575C705D77F616153B22D", hash_generated_method = "AC7C69579F80CDA3C53C84523B03E575")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.486 -0400", hash_original_field = "D73D0D86C1025EFB856EDFE0FF5B7D26", hash_generated_field = "A61CFE599DE64B58698AA201FC982324")

    public static final int ERROR_AUTHENTICATING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.486 -0400", hash_original_field = "9A24D92AC8A9E1B7D5A312FBA6C3FD34", hash_generated_field = "9799DA49B75F0D0576BFFBB0C76088EE")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_STATE_CHANGED_ACTION =
        "android.net.wifi.WIFI_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.486 -0400", hash_original_field = "0944A2A65F601749B29178FEA703796B", hash_generated_field = "46567CB4BEB3DFB368FE4F8E475FB949")

    public static final String EXTRA_WIFI_STATE = "wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.486 -0400", hash_original_field = "7833C0EE32998283D8317C32D9B3E7E3", hash_generated_field = "D54DDD27C0FABD3E72B4463F8467DD8F")

    public static final String EXTRA_PREVIOUS_WIFI_STATE = "previous_wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.494 -0400", hash_original_field = "405CA49F40DDE4B13E9AC46791CA857F", hash_generated_field = "FE60C14FEA4D57BF2093A689913470B9")

    public static final int WIFI_STATE_DISABLING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.494 -0400", hash_original_field = "F3D1FDE24320FB177F2FEC055432E5A9", hash_generated_field = "6A5366DF6585701D33781E3066B4AFA8")

    public static final int WIFI_STATE_DISABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.494 -0400", hash_original_field = "7ED33E4EFFAB0957B139A4FBB46B1007", hash_generated_field = "F2ADABF7F2992B3ED65D27E20283D1F6")

    public static final int WIFI_STATE_ENABLING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.495 -0400", hash_original_field = "5AAFCB32A97D94C3DF5549300190AE52", hash_generated_field = "06DDD34F33E45C8F663664CD911FF5AB")

    public static final int WIFI_STATE_ENABLED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.495 -0400", hash_original_field = "20E5381E72985E573686190569CE5784", hash_generated_field = "E8AFD6E713201D2BE9CCD062C6A47AEA")

    public static final int WIFI_STATE_UNKNOWN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.495 -0400", hash_original_field = "3BE3DE3FFDA26AE538EAEBF3BB37528D", hash_generated_field = "705EDD303DB61EC718572FA5275D3C5A")

    public static final String WIFI_AP_STATE_CHANGED_ACTION =
        "android.net.wifi.WIFI_AP_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.495 -0400", hash_original_field = "78A247A8B44054497886DF62817F280D", hash_generated_field = "92AFA518C48CABAA417E28328E2D9063")

    public static final String EXTRA_WIFI_AP_STATE = "wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.495 -0400", hash_original_field = "3EF091900F15377421FA68C70BDA39AA", hash_generated_field = "7C2F550793EA245C07443AC5F1ED3AF6")

    public static final String EXTRA_PREVIOUS_WIFI_AP_STATE = "previous_wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.495 -0400", hash_original_field = "01B486AD62C331C8F0575BAA722E72EB", hash_generated_field = "209F5C5C2CDCF7B6F64BD4ED77AD042C")

    public static final int WIFI_AP_STATE_DISABLING = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.495 -0400", hash_original_field = "363357D0E2171D4C81373BD6ECFBD40A", hash_generated_field = "3A49281391657B7405283CBCE0E99B88")

    public static final int WIFI_AP_STATE_DISABLED = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.495 -0400", hash_original_field = "B17617B0A7DD8AFB4D8AFFDC300E98F9", hash_generated_field = "43E8773A0C034F3EDE7247F857A9B19E")

    public static final int WIFI_AP_STATE_ENABLING = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.496 -0400", hash_original_field = "A7F8AAEF17D7E999529D1B444EDFEED8", hash_generated_field = "597700F8A65905DB8E975F1D1E5F3DA6")

    public static final int WIFI_AP_STATE_ENABLED = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.496 -0400", hash_original_field = "AE13D766030DC8EE1A5D3EE767A9D04F", hash_generated_field = "A8488BD2ECBA6883D2DB38AE89ACE4F5")

    public static final int WIFI_AP_STATE_FAILED = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.496 -0400", hash_original_field = "1A198E48F79AE8725FF0D5C807F4ED19", hash_generated_field = "C77032707377A2B11B3B6B5DEFFE1311")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SUPPLICANT_CONNECTION_CHANGE_ACTION =
        "android.net.wifi.supplicant.CONNECTION_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.496 -0400", hash_original_field = "59E876250F9DB64F3DF776B93F9FEE46", hash_generated_field = "CDBC8B7CF4D0CA98D9425D824E922C3A")

    public static final String EXTRA_SUPPLICANT_CONNECTED = "connected";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.496 -0400", hash_original_field = "807BAA441D8390622A11EE235111390C", hash_generated_field = "B8648E4BFBAEF813252FD594CC108B4D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String NETWORK_STATE_CHANGED_ACTION = "android.net.wifi.STATE_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.496 -0400", hash_original_field = "ACAA90A79946019658CF4D2C0E90FC45", hash_generated_field = "422031D57C1A9E39521E008A0CBF3B3C")

    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.496 -0400", hash_original_field = "E82CEDA6F1000F5BB1A0C0E74BEEBCC9", hash_generated_field = "BF57671FDC2B9ABDFAF5D8AEA7BAA947")

    public static final String EXTRA_BSSID = "bssid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.498 -0400", hash_original_field = "C6DEB388FDA6ECEC13A8E9F9E931E5F6", hash_generated_field = "53C2244BE022BE4A381D06DA518EB76B")

    public static final String EXTRA_WIFI_INFO = "wifiInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.500 -0400", hash_original_field = "8942D46952F7066FEEB3511650A276FF", hash_generated_field = "D73D816A0B7FCFD432AA984E977AC22C")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SUPPLICANT_STATE_CHANGED_ACTION =
        "android.net.wifi.supplicant.STATE_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.503 -0400", hash_original_field = "E872A937F83834A9AD2CB1EFACA97397", hash_generated_field = "34AA826E3AF97AB38DB470F1C5654E68")

    public static final String EXTRA_NEW_STATE = "newState";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.505 -0400", hash_original_field = "3F8713876D6EE32D16E68249621C644E", hash_generated_field = "DE620C91519E2A376661E1B4006EAACA")

    public static final String EXTRA_SUPPLICANT_ERROR = "supplicantError";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.508 -0400", hash_original_field = "76A1C57BFAA36783CA0F2362FDCDD9D2", hash_generated_field = "8B73608A4EF89D78B6901DFA0665D165")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ERROR_ACTION = "android.net.wifi.ERROR";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.511 -0400", hash_original_field = "50472CF4F7672EB8868BF194FAA83042", hash_generated_field = "FA40DA21A3D0B77445C4852C84BE80AE")

    public static final String EXTRA_ERROR_CODE = "errorCode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.511 -0400", hash_original_field = "061DFF13C86BBDB544631213B8DC3B64", hash_generated_field = "2784A14BBCACF543186CCAAD68AC111C")

    public static final int WPS_OVERLAP_ERROR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.511 -0400", hash_original_field = "97D33284D99C36BAA3E4DDED69B4902F", hash_generated_field = "3DEB0A15DB5D2EDEE13E62DA3FC221C7")

    public static final String CONFIGURED_NETWORKS_CHANGED_ACTION =
        "android.net.wifi.CONFIGURED_NETWORKS_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.511 -0400", hash_original_field = "7F6E9185E4434BAD74AF662AE13977F6", hash_generated_field = "FB9CA3626A316B66033D491508ED5D88")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.513 -0400", hash_original_field = "1BF034FB8FF23CB493A7570E76E707B3", hash_generated_field = "C71F973F8B385841B02BE2C761218AEF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String RSSI_CHANGED_ACTION = "android.net.wifi.RSSI_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.513 -0400", hash_original_field = "32681E7B259952DABBFA332463B2E186", hash_generated_field = "F6576C7FACD2AA843A12F433031DB417")

    public static final String EXTRA_NEW_RSSI = "newRssi";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.514 -0400", hash_original_field = "54C389AE7454612FCBE99FC3790B8420", hash_generated_field = "4236F79C5A13A06E052A218C87FCD7AA")

    public static final String LINK_CONFIGURATION_CHANGED_ACTION =
        "android.net.wifi.LINK_CONFIGURATION_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.514 -0400", hash_original_field = "DAC37E4448A17DAA0BDB854C0225CA4C", hash_generated_field = "B2AF7393288899F9C62599EE162CC59A")

    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.516 -0400", hash_original_field = "7DFD46BB73461CD7286B9FDCCCA83168", hash_generated_field = "2EE887A583B9775AF34213DD8E61A00E")

    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.516 -0400", hash_original_field = "D3B8BEB61E404158A7530123E8D2B90B", hash_generated_field = "0325C95FCCE4B351CA7FEB67F6B7BA12")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String NETWORK_IDS_CHANGED_ACTION = "android.net.wifi.NETWORK_IDS_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.517 -0400", hash_original_field = "9D0493DF677AC43D136AF1B2A9906E7A", hash_generated_field = "55C17055111CE4074EEDA5CECF2B3757")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK_WIFI_NETWORK = "android.net.wifi.PICK_WIFI_NETWORK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.519 -0400", hash_original_field = "EE31A5071A8FFC8C237208177037337D", hash_generated_field = "165D11A1ECFD913E5C1ECF94299A477E")

    public static final int WIFI_MODE_FULL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.531 -0400", hash_original_field = "6AF2EF647228F3AFFA250FBF39A821A2", hash_generated_field = "94C5D29C1CE510F135890C372BE94396")

    public static final int WIFI_MODE_SCAN_ONLY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.531 -0400", hash_original_field = "5594AE1D7ED5804C1F81383076E59588", hash_generated_field = "F3AB5F19FC3DF915800D3B2F6E33706C")

    public static final int WIFI_MODE_FULL_HIGH_PERF = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.531 -0400", hash_original_field = "F81929FFFE83BD457D7742224C8B0457", hash_generated_field = "9F9088C65BD4F1789D8C8FDAB77015A8")

    private static final int MIN_RSSI = -100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.531 -0400", hash_original_field = "0A05ECF66C34A06419B23B745B0D45B0", hash_generated_field = "7DF91D8D2EC01CB1BE1AE4CAFCD0F309")

    private static final int MAX_RSSI = -55;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.531 -0400", hash_original_field = "F1CCB588F4099EFB4AC3B8F9C9324E97", hash_generated_field = "B84D769DCD709B183890B60DF3C274DA")

    public static final int WIFI_FREQUENCY_BAND_AUTO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.531 -0400", hash_original_field = "231C9D37A8817B4D3E118BEE7D5B371A", hash_generated_field = "F498C8314733151CD8E82921B0C4E22C")

    public static final int WIFI_FREQUENCY_BAND_5GHZ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.531 -0400", hash_original_field = "9730084C49D6A21C62927C1102B8D657", hash_generated_field = "6A1155A1B59CAD32A0FAC3FE219F29D2")

    public static final int WIFI_FREQUENCY_BAND_2GHZ = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.531 -0400", hash_original_field = "515162F4F8CFA5B14D2FE52C022E4BE3", hash_generated_field = "9B58465EB0D92245EC9CA4D811AEC5DD")

    public static final int DATA_ACTIVITY_NOTIFICATION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.532 -0400", hash_original_field = "6837AC5BB2753B6857C2C1DC403A0EB3", hash_generated_field = "F4CC6307DC2FF1A2B8CB7457E8B5AD9E")

    public static final int DATA_ACTIVITY_NONE         = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.532 -0400", hash_original_field = "FCAF43A79A1C904023D22A7AA61F7556", hash_generated_field = "B4DF8C490A9544C3C8D4B30926E0CD7E")

    public static final int DATA_ACTIVITY_IN           = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.532 -0400", hash_original_field = "2DC49AD01499C1665F43DA1A6F98AC48", hash_generated_field = "E3EC39EDBEEB9E8C0DC13BD46CB864BE")

    public static final int DATA_ACTIVITY_OUT          = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.532 -0400", hash_original_field = "960AF15D25F61CDA2363A2691565008A", hash_generated_field = "08F2BE8A202C8F8B111FD96D48B71285")

    public static final int DATA_ACTIVITY_INOUT        = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.532 -0400", hash_original_field = "1A512A00EB52378D4A10EF2AA242C735", hash_generated_field = "A46B2DFFFC241E78B7C771A4BAE78A6E")

    private static final int MAX_ACTIVE_LOCKS = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.532 -0400", hash_original_field = "646E42B947A8F7B418092CED9A6F4C1F", hash_generated_field = "5A67FC0349394E3625D9712DFC2DD495")

    public static final int CMD_CONNECT_NETWORK             = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.532 -0400", hash_original_field = "8B1A0832B35C196C0DF7D0CC76CF0AE0", hash_generated_field = "46529F28CB12A06C7F56C09018C641A0")

    public static final int CMD_FORGET_NETWORK              = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.532 -0400", hash_original_field = "AFBB98EEEF662FFF692214621B6A1DB3", hash_generated_field = "6B8553C6C496218E9F37E094D517F7E5")

    public static final int CMD_SAVE_NETWORK                = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.533 -0400", hash_original_field = "D91E8B64BF9FF96B110F55329B508315", hash_generated_field = "3FB85837ABE02F19E22F86C7FD9A7CB9")

    public static final int CMD_START_WPS                   = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.533 -0400", hash_original_field = "16E0E8180823F20E47D9A58EF1BFC579", hash_generated_field = "5A520D736A3DF8FA576C9E8034E02305")

    public static final int CMD_DISABLE_NETWORK             = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.533 -0400", hash_original_field = "FBCED99560CDF828EDED1A164C8ED672", hash_generated_field = "9BB6A17346ACCF1C252A49990A8E5790")

    public static final int CMD_WPS_COMPLETED               = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.533 -0400", hash_original_field = "4649341BB0476ACEB21B2F7C7CE8CF57", hash_generated_field = "ECCBA1FF030DC0DEEA34AAE6ED0A8AD8")

    public static final int CMD_ENABLE_TRAFFIC_STATS_POLL   = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.533 -0400", hash_original_field = "7BF3E1A2A9B4D47471730828319ECBF1", hash_generated_field = "7A5F8E8BF9878485F2FEE42B8FB5E475")

    public static final int CMD_TRAFFIC_STATS_POLL          = 22;
}

