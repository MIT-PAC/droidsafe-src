package android.net.wifi;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.599 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "DB1464CA9C87828D9D93BD784121DA8C")

    IWifiManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.599 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.599 -0400", hash_original_field = "515CEC5C60BFB489FCE4D019DF434BA7", hash_generated_field = "D601BE33010BF0FF8F79216654DBC58D")

    private int mActiveLockCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.599 -0400", hash_original_field = "5FD29322753C3A7384C678B13BEFD72D", hash_generated_field = "C8DF611874A1503E325C16431857C1F2")

    private AsyncChannel mAsyncChannel = new AsyncChannel();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.600 -0400", hash_original_method = "45AC664258FD08C08C588B627CDDFFBC", hash_generated_method = "B4F1E9EA15C43234D8FE3A9CE9AF5CBA")
    public  WifiManager(IWifiManager service, Handler handler) {
        mService = service;
        mHandler = handler;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.601 -0400", hash_original_method = "7B7EDD72C806D0E7DC8642CC316AA722", hash_generated_method = "F285EE958BD480100F1EDE69C0ACAEBC")
    public List<WifiConfiguration> getConfiguredNetworks() {
        List<WifiConfiguration> varB4EAC82CA7396A68D541C85D26508E83_1034819277 = null; 
        List<WifiConfiguration> varB4EAC82CA7396A68D541C85D26508E83_976591106 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1034819277 = mService.getConfiguredNetworks();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_976591106 = null;
        } 
        List<WifiConfiguration> varA7E53CE21691AB073D9660D615818899_1119915965; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1119915965 = varB4EAC82CA7396A68D541C85D26508E83_1034819277;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1119915965 = varB4EAC82CA7396A68D541C85D26508E83_976591106;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1119915965.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1119915965;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.601 -0400", hash_original_method = "FC0AD51F5109F6EE6B896159A6BE091E", hash_generated_method = "791F7991BDBE47061BED2E3A8747B0E7")
    public int addNetwork(WifiConfiguration config) {
        config.networkId = -1;
        int var841DCE22DCAD53E534BE373AED1A9F2C_1455135901 = (addOrUpdateNetwork(config));
        addTaint(config.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567839406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567839406;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.602 -0400", hash_original_method = "BAE559B7BC959F87E1981FBD6EC47DF5", hash_generated_method = "D154301DF08FDC4F826C797F8C5CDB1A")
    public int updateNetwork(WifiConfiguration config) {
        int var841DCE22DCAD53E534BE373AED1A9F2C_1135273522 = (addOrUpdateNetwork(config));
        addTaint(config.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095604517 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095604517;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.602 -0400", hash_original_method = "E64504FDFA81026BF4EAE79A420D3010", hash_generated_method = "D983240F3731E1FC48FD709B1D112CFC")
    private int addOrUpdateNetwork(WifiConfiguration config) {
        try 
        {
            int var29861749C3E419B96EEF8148CE5ACC73_1801825095 = (mService.addOrUpdateNetwork(config));
        } 
        catch (RemoteException e)
        { }
        addTaint(config.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383074074 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383074074;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.603 -0400", hash_original_method = "C55861B25E581745B3C6351405363685", hash_generated_method = "35F95A4A05ED85E9CEB91E9930C878C2")
    public boolean removeNetwork(int netId) {
        try 
        {
            boolean var3969CE505792C9B2C42D9B989E5DCC6A_933724704 = (mService.removeNetwork(netId));
        } 
        catch (RemoteException e)
        { }
        addTaint(netId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_157120545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_157120545;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.603 -0400", hash_original_method = "A063D2F3A1A45A8B2BB20D41F98AEB1B", hash_generated_method = "0780A7D8C7BF18FC7749CCD7A35FEDAB")
    public boolean enableNetwork(int netId, boolean disableOthers) {
        try 
        {
            boolean var1D13A98DF752183E327DF71A161434AC_1428624884 = (mService.enableNetwork(netId, disableOthers));
        } 
        catch (RemoteException e)
        { }
        addTaint(netId);
        addTaint(disableOthers);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_13721991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_13721991;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.604 -0400", hash_original_method = "630BE7480BA2E95DA9CEC1F52BBE219A", hash_generated_method = "1F9A24D7F498FD3617571E41470D8013")
    public boolean disableNetwork(int netId) {
        try 
        {
            boolean var507F4C1A88F04AAAAE64FCFD7F68A129_82814700 = (mService.disableNetwork(netId));
        } 
        catch (RemoteException e)
        { }
        addTaint(netId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745217778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745217778;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.604 -0400", hash_original_method = "4C2FCF871904470A4665E52D44D62875", hash_generated_method = "3B09F2EE53F1604E7AB344F33F103DCC")
    public void disableNetwork(int netId, int reason) {
        mAsyncChannel.sendMessage(CMD_DISABLE_NETWORK, netId, reason);
        addTaint(netId);
        addTaint(reason);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.604 -0400", hash_original_method = "13D7026BA6E2310038D9CCEC7D1F5CA4", hash_generated_method = "27BA03B92399184CA3B692C6478A8923")
    public boolean disconnect() {
        try 
        {
            mService.disconnect();
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1586493616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1586493616;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.605 -0400", hash_original_method = "AD9DD9C3B4130EB49C99A6BF92BCA383", hash_generated_method = "824BA6020E214893E07DB26A54FE703E")
    public boolean reconnect() {
        try 
        {
            mService.reconnect();
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1730252257 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1730252257;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.605 -0400", hash_original_method = "4462A23EEF44DC4F050ECB7EA4566A65", hash_generated_method = "CC337F1969D028152A16CC24487420A9")
    public boolean reassociate() {
        try 
        {
            mService.reassociate();
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_260831133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_260831133;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.605 -0400", hash_original_method = "44FE7083E78F583BB16CDAFA3EBE6F36", hash_generated_method = "12A4262C076DF2D451C710E2EFF7005D")
    public boolean pingSupplicant() {
        try 
        {
            boolean var108AD08E67A26C352FC5E987B3605666_2114284266 = (mService.pingSupplicant());
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_629321124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_629321124;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.606 -0400", hash_original_method = "F8088016DD577DAE90193BD2B16E77E5", hash_generated_method = "111549C6B9C970A84C5F96708E1D8BC1")
    public boolean startScan() {
        try 
        {
            mService.startScan(false);
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962531218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962531218;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.606 -0400", hash_original_method = "1BECDA97215EAB893F9C0F926E7877B4", hash_generated_method = "D354B6E125EE199BE9842106BC7F4DEF")
    public boolean startScanActive() {
        try 
        {
            mService.startScan(true);
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_129991388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_129991388;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.607 -0400", hash_original_method = "8E854EE6D7B979BB188C54EFD6BB6717", hash_generated_method = "7663F4F715CC4EEAC5B1BE81606556AA")
    public WifiInfo getConnectionInfo() {
        WifiInfo varB4EAC82CA7396A68D541C85D26508E83_961096253 = null; 
        WifiInfo varB4EAC82CA7396A68D541C85D26508E83_948930747 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_961096253 = mService.getConnectionInfo();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_948930747 = null;
        } 
        WifiInfo varA7E53CE21691AB073D9660D615818899_1428910631; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1428910631 = varB4EAC82CA7396A68D541C85D26508E83_961096253;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1428910631 = varB4EAC82CA7396A68D541C85D26508E83_948930747;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1428910631.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1428910631;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.607 -0400", hash_original_method = "ADD60A4DA3445A3E968EB713F725E5F1", hash_generated_method = "02677C930E7B88B4C1B4A4E0A219C57D")
    public List<ScanResult> getScanResults() {
        List<ScanResult> varB4EAC82CA7396A68D541C85D26508E83_557225135 = null; 
        List<ScanResult> varB4EAC82CA7396A68D541C85D26508E83_559298518 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_557225135 = mService.getScanResults();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_559298518 = null;
        } 
        List<ScanResult> varA7E53CE21691AB073D9660D615818899_34089413; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_34089413 = varB4EAC82CA7396A68D541C85D26508E83_557225135;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_34089413 = varB4EAC82CA7396A68D541C85D26508E83_559298518;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_34089413.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_34089413;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.608 -0400", hash_original_method = "D1E32319AD181FF60DD93B5B2DB831F1", hash_generated_method = "7C2DBB6FA7A3DD4CFD3F8885646767F0")
    public boolean saveConfiguration() {
        try 
        {
            boolean var65BADDEB467659B51E5D69A7C9FA99CA_1168697877 = (mService.saveConfiguration());
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2114598697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2114598697;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.608 -0400", hash_original_method = "9549A9F9433914F9E55F5CC34183554C", hash_generated_method = "806EA1327A02B74ECCF71D196BBCF20D")
    public void setCountryCode(String country, boolean persist) {
        try 
        {
            mService.setCountryCode(country, persist);
        } 
        catch (RemoteException e)
        { }
        addTaint(country.getTaint());
        addTaint(persist);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.608 -0400", hash_original_method = "4B6C5827C7D51FB40ECD8DD67D760E19", hash_generated_method = "9D53049E258ABC4C69A3B99255588137")
    public void setFrequencyBand(int band, boolean persist) {
        try 
        {
            mService.setFrequencyBand(band, persist);
        } 
        catch (RemoteException e)
        { }
        addTaint(band);
        addTaint(persist);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.609 -0400", hash_original_method = "481BDDBC9D497285776974614BBC7D82", hash_generated_method = "CF739361C612369073F09ED45B03C6E5")
    public int getFrequencyBand() {
        try 
        {
            int varD3D26E601547C91817009BC00AFC6395_70935991 = (mService.getFrequencyBand());
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042931242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042931242;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.609 -0400", hash_original_method = "F73D127A0D43FAD1AD9DBA6A689AC70A", hash_generated_method = "54832D1E228B4793CE1D6170238C79F7")
    public boolean isDualBandSupported() {
        try 
        {
            boolean varD0866672BC37ED549DC39FCD6F97C3E7_656470768 = (mService.isDualBandSupported());
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25369626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_25369626;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.610 -0400", hash_original_method = "711DEA09870DB7E049F72B7F8BEBC0A1", hash_generated_method = "BD1804EFDEB4AEB029FA876EC5F0B67B")
    public DhcpInfo getDhcpInfo() {
        DhcpInfo varB4EAC82CA7396A68D541C85D26508E83_383701815 = null; 
        DhcpInfo varB4EAC82CA7396A68D541C85D26508E83_1819228652 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_383701815 = mService.getDhcpInfo();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1819228652 = null;
        } 
        DhcpInfo varA7E53CE21691AB073D9660D615818899_439512283; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_439512283 = varB4EAC82CA7396A68D541C85D26508E83_383701815;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_439512283 = varB4EAC82CA7396A68D541C85D26508E83_1819228652;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_439512283.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_439512283;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.610 -0400", hash_original_method = "B9430AD639DDE3004B577A4BF40EB18B", hash_generated_method = "68CD6609F1A1EBEDFA845C691D01235F")
    public boolean setWifiEnabled(boolean enabled) {
        try 
        {
            boolean varB6FC8C8742D6B74DE1AE1DCC4A75F803_1003518044 = (mService.setWifiEnabled(enabled));
        } 
        catch (RemoteException e)
        { }
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_352624010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_352624010;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.610 -0400", hash_original_method = "661FA885AE58B8C5231BF7DCF436505F", hash_generated_method = "25001E18534B895DA01083A4FD296D7E")
    public int getWifiState() {
        try 
        {
            int var51177C283700A55013AE02DA22D9F373_544759856 = (mService.getWifiEnabledState());
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448118474 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448118474;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.611 -0400", hash_original_method = "D7F0AFD1306EBF22F34F7E014A2C9B11", hash_generated_method = "7CD54F5ED8C51670CA677C86145A29F2")
    public boolean isWifiEnabled() {
        boolean var6712056F5B3773D738C13AB491D89222_1933076376 = (getWifiState() == WIFI_STATE_ENABLED);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50948639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50948639;
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.612 -0400", hash_original_method = "2BFE81971E8D979C3ECBD7F543427F67", hash_generated_method = "75204C671326F9552B9EA465C1368354")
    public boolean setWifiApEnabled(WifiConfiguration wifiConfig, boolean enabled) {
        try 
        {
            mService.setWifiApEnabled(wifiConfig, enabled);
        } 
        catch (RemoteException e)
        { }
        addTaint(wifiConfig.getTaint());
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121992435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_121992435;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.612 -0400", hash_original_method = "B0BA72D208162E33734DF133F2E7F6AA", hash_generated_method = "E8FACE5659A12F9BFA695D316F8F5C07")
    public int getWifiApState() {
        try 
        {
            int var2E2FB8DE2B461FD2353125B69D9D13CD_1192207409 = (mService.getWifiApEnabledState());
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_787805917 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_787805917;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.613 -0400", hash_original_method = "657EB8B0A945E7FD7BA91E2539A322BE", hash_generated_method = "B75F341B669C64A9BB90E3A7A6327B12")
    public boolean isWifiApEnabled() {
        boolean var50FC8F7F80F7565EBB0DC8805641F4CB_1256032849 = (getWifiApState() == WIFI_AP_STATE_ENABLED);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985441177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_985441177;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.614 -0400", hash_original_method = "99407E6898AC76390D3E229EC6CF35C4", hash_generated_method = "EA3BF170DF6660764482991E8B1E988D")
    public WifiConfiguration getWifiApConfiguration() {
        WifiConfiguration varB4EAC82CA7396A68D541C85D26508E83_1384309796 = null; 
        WifiConfiguration varB4EAC82CA7396A68D541C85D26508E83_1436881521 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1384309796 = mService.getWifiApConfiguration();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1436881521 = null;
        } 
        WifiConfiguration varA7E53CE21691AB073D9660D615818899_1733851930; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1733851930 = varB4EAC82CA7396A68D541C85D26508E83_1384309796;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1733851930 = varB4EAC82CA7396A68D541C85D26508E83_1436881521;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1733851930.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1733851930;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.615 -0400", hash_original_method = "32645F13A37CD40BEF3F9464116D1367", hash_generated_method = "0CAAD29AA9D1AEE0A1C00F70D97C2441")
    public boolean setWifiApConfiguration(WifiConfiguration wifiConfig) {
        try 
        {
            mService.setWifiApConfiguration(wifiConfig);
        } 
        catch (RemoteException e)
        { }
        addTaint(wifiConfig.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493703529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493703529;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.615 -0400", hash_original_method = "F505CF72442DFA261366294723957A53", hash_generated_method = "5C289F2F83D5DB3F640B606C92F06BF2")
    public boolean startWifi() {
        try 
        {
            mService.startWifi();
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663905163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663905163;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.616 -0400", hash_original_method = "F7F977701F133D0F59F048A53A2C698B", hash_generated_method = "F14FEC728FBFA0163876CE534B9CC179")
    public boolean stopWifi() {
        try 
        {
            mService.stopWifi();
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1743955282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1743955282;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.616 -0400", hash_original_method = "6E01C15F4CA49AC218CA465537508537", hash_generated_method = "B2357A55366FB88383E4D8012D007F0D")
    public boolean addToBlacklist(String bssid) {
        try 
        {
            mService.addToBlacklist(bssid);
        } 
        catch (RemoteException e)
        { }
        addTaint(bssid.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_126920523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_126920523;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.617 -0400", hash_original_method = "614FAF75AF873709E1677408EE18D7B6", hash_generated_method = "C8DCDB93B34081E8A7EC34A2AA1E58C6")
    public boolean clearBlacklist() {
        try 
        {
            mService.clearBlacklist();
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_429199541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_429199541;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.617 -0400", hash_original_method = "F93FD4BCC6C0F6B375A42EEFE25B9408", hash_generated_method = "849CF27CED4BDAF5C05F6D9F0A8479CD")
    public void asyncConnect(Context srcContext, Handler srcHandler) {
        mAsyncChannel.connect(srcContext, srcHandler, getMessenger());
        addTaint(srcContext.getTaint());
        addTaint(srcHandler.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.617 -0400", hash_original_method = "B69D8EEDABB0031125B40805CA5F91D8", hash_generated_method = "87015BDCB8D4C8A774F98471C2290FC6")
    public void connectNetwork(WifiConfiguration config) {
        mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, config);
        addTaint(config.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.618 -0400", hash_original_method = "9464671A8FCBA7A99848867493116AAD", hash_generated_method = "4E1CD6273F947702DBF5312D54C53E67")
    public void connectNetwork(int networkId) {
        mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, networkId);
        addTaint(networkId);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.618 -0400", hash_original_method = "210177ED8E63F9C12E442B1614E4B9E7", hash_generated_method = "1BC40F45892D4DC42D538964366EC0EB")
    public void saveNetwork(WifiConfiguration config) {
        mAsyncChannel.sendMessage(CMD_SAVE_NETWORK, config);
        addTaint(config.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.618 -0400", hash_original_method = "A04E73224B607EFF8F851CD080EF29BA", hash_generated_method = "F4F9C89D2C2EEEE4784EAC892AE91060")
    public void forgetNetwork(int netId) {
        mAsyncChannel.sendMessage(CMD_FORGET_NETWORK, netId);
        addTaint(netId);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.619 -0400", hash_original_method = "CB69F89B2E3E5728AFF3169858F2154E", hash_generated_method = "BD62A0DBEC0438565725233FA7D9F8F4")
    public void startWps(WpsInfo config) {
        mAsyncChannel.sendMessage(CMD_START_WPS, config);
        addTaint(config.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.619 -0400", hash_original_method = "A358F8361C96DABE1A63B04B5804B3F5", hash_generated_method = "4F8A5426EFC06672A3467B48E4B0D64E")
    public Messenger getMessenger() {
        Messenger varB4EAC82CA7396A68D541C85D26508E83_493491233 = null; 
        Messenger varB4EAC82CA7396A68D541C85D26508E83_1679973170 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_493491233 = mService.getMessenger();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1679973170 = null;
        } 
        Messenger varA7E53CE21691AB073D9660D615818899_1807214944; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1807214944 = varB4EAC82CA7396A68D541C85D26508E83_493491233;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1807214944 = varB4EAC82CA7396A68D541C85D26508E83_1679973170;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1807214944.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1807214944;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.620 -0400", hash_original_method = "F47F46BF01C13AECFB0A8E0A7BCA30AB", hash_generated_method = "E7384668A07DEB59ABE4C2566D695DA6")
    public String getConfigFile() {
        String varB4EAC82CA7396A68D541C85D26508E83_237978967 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_722870152 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_237978967 = mService.getConfigFile();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_722870152 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_1488027471; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1488027471 = varB4EAC82CA7396A68D541C85D26508E83_237978967;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1488027471 = varB4EAC82CA7396A68D541C85D26508E83_722870152;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1488027471.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1488027471;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.620 -0400", hash_original_method = "77C6D00CEFBA51FBEDF42525D5CAF8B4", hash_generated_method = "26BDB73B77DF3EADF5CC57A795224BFD")
    public WifiLock createWifiLock(int lockType, String tag) {
        WifiLock varB4EAC82CA7396A68D541C85D26508E83_533291287 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_533291287 = new WifiLock(lockType, tag);
        addTaint(lockType);
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_533291287.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_533291287;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.621 -0400", hash_original_method = "F25A7BAA745FE3E1539A4ACAD2E402AC", hash_generated_method = "5004D93D172278258DF766D9B7EA4B33")
    public WifiLock createWifiLock(String tag) {
        WifiLock varB4EAC82CA7396A68D541C85D26508E83_514556742 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_514556742 = new WifiLock(WIFI_MODE_FULL, tag);
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_514556742.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_514556742;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.621 -0400", hash_original_method = "90BF24DBA9F26B31ED84B0CABBF9287E", hash_generated_method = "A8144FD3D43D07C1B767E8F4F995C4AA")
    public MulticastLock createMulticastLock(String tag) {
        MulticastLock varB4EAC82CA7396A68D541C85D26508E83_539010048 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_539010048 = new MulticastLock(tag);
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_539010048.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_539010048;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.622 -0400", hash_original_method = "36EA363278EADF8446AD30BF262D8211", hash_generated_method = "CB2E0BD3020AA227E8C1C3F99FDB644D")
    public boolean isMulticastEnabled() {
        try 
        {
            boolean varF69D9C3FD34D6BAECC97870E612144C2_1796548899 = (mService.isMulticastEnabled());
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084369019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084369019;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.622 -0400", hash_original_method = "03CE776E3230E83E55C388557E1A9516", hash_generated_method = "5CB56280B375DC88B312D4ED7FABD91A")
    public boolean initializeMulticastFiltering() {
        try 
        {
            mService.initializeMulticastFiltering();
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719032581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719032581;
        
        
            
            
        
             
        
    }

    
    public class WifiLock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.622 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.622 -0400", hash_original_field = "59251AD7EF4786A1A863CD24E536AB17", hash_generated_field = "A726660A8F3C406901F3D212C617E404")

        private IBinder mBinder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.622 -0400", hash_original_field = "DAC8A06C1EDF9825CDAF6DFCD18A7ADC", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

        private int mRefCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.623 -0400", hash_original_field = "2E26F41B503854D2664C327E649E3CAE", hash_generated_field = "3AD78D1D4CE6492B77426188DE5C8EB6")

        int mLockType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.623 -0400", hash_original_field = "2027736A79052BCC8F6250B2A1BACD52", hash_generated_field = "EEB06CC18CFEB1CEBC8608AACD58D0B5")

        private boolean mRefCounted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.623 -0400", hash_original_field = "AD25B113814807D236AFB0F5095B0005", hash_generated_field = "CC6ABDC2865C3E48C44DCFBA12BDB07C")

        private boolean mHeld;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.623 -0400", hash_original_field = "33F0FDFE72CD4D291DF24A21567DB5C9", hash_generated_field = "C5BF497580D66C18B0028C0F7134DDF3")

        private WorkSource mWorkSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.623 -0400", hash_original_method = "044CDC682150D26B37DC0497B735DA49", hash_generated_method = "1273DB766F5BD50415DCCD366CA34B18")
        private  WifiLock(int lockType, String tag) {
            mTag = tag;
            mLockType = lockType;
            mBinder = new Binder();
            mRefCount = 0;
            mRefCounted = true;
            mHeld = false;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.625 -0400", hash_original_method = "208DCD1288F5AC0918E067B51EC18B17", hash_generated_method = "65E26F92BF8B055DD079D734668F50A8")
        public void acquire() {
            {
                {
                    try 
                    {
                        mService.acquireWifiLock(mBinder, mLockType, mTag, mWorkSource);
                        {
                            Object var1C3BCBC89D915D09A29A9D7ECF62293F_40472527 = (WifiManager.this);
                            {
                                {
                                    mService.releaseWifiLock(mBinder);
                                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                                            "Exceeded maximum number of wifi locks");
                                } 
                            } 
                        } 
                    } 
                    catch (RemoteException ignore)
                    { }
                    mHeld = true;
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.626 -0400", hash_original_method = "EEC110369AFED5315DDFD7D45F992208", hash_generated_method = "77896A33E6D20961C3B0AC7A6A3352AA")
        public void release() {
            {
                {
                    try 
                    {
                        mService.releaseWifiLock(mBinder);
                        {
                            Object var1C3BCBC89D915D09A29A9D7ECF62293F_632888635 = (WifiManager.this);
                        } 
                    } 
                    catch (RemoteException ignore)
                    { }
                    mHeld = false;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("WifiLock under-locked " + mTag);
                } 
            } 
            
            
                
                    
                        
                        
                            
                        
                    
                    
                    
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.626 -0400", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "91B8A28629F935F303A73D2F07650B69")
        public void setReferenceCounted(boolean refCounted) {
            mRefCounted = refCounted;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.627 -0400", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "053BD3F52B751D2EA7376238BAE711D1")
        public boolean isHeld() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_328827436 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_328827436;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.627 -0400", hash_original_method = "7C62BA62C0C3A7C1DC2FB1EDC51DE805", hash_generated_method = "75A866648E4DDB46906D89F31D861899")
        public void setWorkSource(WorkSource ws) {
            {
                {
                    boolean varDCFAF0E9E34CB8562A3C2873888A5A3D_1549711482 = (ws != null && ws.size() == 0);
                    {
                        ws = null;
                    } 
                } 
                boolean changed = true;
                {
                    mWorkSource = null;
                } 
                {
                    changed = mWorkSource != null;
                    mWorkSource = new WorkSource(ws);
                } 
                {
                    changed = mWorkSource.diff(ws);
                    {
                        mWorkSource.set(ws);
                    } 
                } 
                {
                    try 
                    {
                        mService.updateWifiLockWorkSource(mBinder, mWorkSource);
                    } 
                    catch (RemoteException e)
                    { }
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.628 -0400", hash_original_method = "30E303CA91E967AFDBED5B1FC9CE8E64", hash_generated_method = "64CB1D2A5BC4566C6CC2414D86BB32E8")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_38032510 = null; 
            String s1;
            String s2;
            String s3;
            {
                s1 = Integer.toHexString(System.identityHashCode(this));
                s2 = mHeld ? "held; " : "";
                {
                    s3 = "refcounted: refcount = " + mRefCount;
                } 
                {
                    s3 = "not refcounted";
                } 
                varB4EAC82CA7396A68D541C85D26508E83_38032510 = "WifiLock{ " + s1 + "; " + s2 + s3 + " }";
            } 
            varB4EAC82CA7396A68D541C85D26508E83_38032510.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_38032510;
            
            
            
                
                
                
                    
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.629 -0400", hash_original_method = "CDAA53D98D74A433929787E6E7DF605C", hash_generated_method = "09602999C844EFDFD1F602FDBAFAFD64")
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            {
                {
                    try 
                    {
                        mService.releaseWifiLock(mBinder);
                        {
                            Object var1C3BCBC89D915D09A29A9D7ECF62293F_2135552691 = (WifiManager.this);
                        } 
                    } 
                    catch (RemoteException ignore)
                    { }
                } 
            } 
            
            
            
                
                    
                        
                        
                            
                        
                    
                    
                
            
        }

        
    }


    
    public class MulticastLock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.629 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.629 -0400", hash_original_field = "59251AD7EF4786A1A863CD24E536AB17", hash_generated_field = "A726660A8F3C406901F3D212C617E404")

        private IBinder mBinder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.629 -0400", hash_original_field = "DAC8A06C1EDF9825CDAF6DFCD18A7ADC", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

        private int mRefCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.629 -0400", hash_original_field = "2027736A79052BCC8F6250B2A1BACD52", hash_generated_field = "EEB06CC18CFEB1CEBC8608AACD58D0B5")

        private boolean mRefCounted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.629 -0400", hash_original_field = "AD25B113814807D236AFB0F5095B0005", hash_generated_field = "CC6ABDC2865C3E48C44DCFBA12BDB07C")

        private boolean mHeld;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.629 -0400", hash_original_method = "DEAA1CCFF83554B98BCA4D411D463199", hash_generated_method = "A1769D3129EB80B6FA9D01C9F3980BAA")
        private  MulticastLock(String tag) {
            mTag = tag;
            mBinder = new Binder();
            mRefCount = 0;
            mRefCounted = true;
            mHeld = false;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.630 -0400", hash_original_method = "130A969831975A68066B20EB1F9033A3", hash_generated_method = "A0E3BAD65476A10A1B5DD8608B5A1D17")
        public void acquire() {
            {
                {
                    try 
                    {
                        mService.acquireMulticastLock(mBinder, mTag);
                        {
                            Object var1C3BCBC89D915D09A29A9D7ECF62293F_727092354 = (WifiManager.this);
                            {
                                {
                                    mService.releaseMulticastLock();
                                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                                        "Exceeded maximum number of wifi locks");
                                } 
                            } 
                        } 
                    } 
                    catch (RemoteException ignore)
                    { }
                    mHeld = true;
                } 
            } 
            
            
                
                    
                        
                        
                            
                                
                                
                                        
                            
                            
                        
                    
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.630 -0400", hash_original_method = "325730E7689E55EAB909A58356E01384", hash_generated_method = "876E9359BD3F35D37E01F7C898469E9B")
        public void release() {
            {
                {
                    try 
                    {
                        mService.releaseMulticastLock();
                        {
                            Object var1C3BCBC89D915D09A29A9D7ECF62293F_1501692526 = (WifiManager.this);
                        } 
                    } 
                    catch (RemoteException ignore)
                    { }
                    mHeld = false;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("MulticastLock under-locked "
                            + mTag);
                } 
            } 
            
            
                
                    
                        
                        
                            
                        
                    
                    
                    
                
                
                    
                            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.631 -0400", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "91B8A28629F935F303A73D2F07650B69")
        public void setReferenceCounted(boolean refCounted) {
            mRefCounted = refCounted;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.631 -0400", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "DBFD1B6DEF05B891CDCE1F061B678416")
        public boolean isHeld() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1217122041 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1217122041;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.632 -0400", hash_original_method = "98C6FF6ECD72200F1F4D177BCA8A2AA1", hash_generated_method = "6B587E81FCB9512814A17360A324A078")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_270887821 = null; 
            String s1;
            String s2;
            String s3;
            {
                s1 = Integer.toHexString(System.identityHashCode(this));
                s2 = mHeld ? "held; " : "";
                {
                    s3 = "refcounted: refcount = " + mRefCount;
                } 
                {
                    s3 = "not refcounted";
                } 
                varB4EAC82CA7396A68D541C85D26508E83_270887821 = "MulticastLock{ " + s1 + "; " + s2 + s3 + " }";
            } 
            varB4EAC82CA7396A68D541C85D26508E83_270887821.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_270887821;
            
            
            
                
                
                
                    
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_method = "EEB5ECA4A52575C705D77F616153B22D", hash_generated_method = "AC7C69579F80CDA3C53C84523B03E575")
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            setReferenceCounted(false);
            release();
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_field = "D73D0D86C1025EFB856EDFE0FF5B7D26", hash_generated_field = "A61CFE599DE64B58698AA201FC982324")

    public static final int ERROR_AUTHENTICATING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_field = "9A24D92AC8A9E1B7D5A312FBA6C3FD34", hash_generated_field = "9799DA49B75F0D0576BFFBB0C76088EE")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_STATE_CHANGED_ACTION =
        "android.net.wifi.WIFI_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_field = "0944A2A65F601749B29178FEA703796B", hash_generated_field = "46567CB4BEB3DFB368FE4F8E475FB949")

    public static final String EXTRA_WIFI_STATE = "wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_field = "7833C0EE32998283D8317C32D9B3E7E3", hash_generated_field = "D54DDD27C0FABD3E72B4463F8467DD8F")

    public static final String EXTRA_PREVIOUS_WIFI_STATE = "previous_wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_field = "405CA49F40DDE4B13E9AC46791CA857F", hash_generated_field = "FE60C14FEA4D57BF2093A689913470B9")

    public static final int WIFI_STATE_DISABLING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_field = "F3D1FDE24320FB177F2FEC055432E5A9", hash_generated_field = "6A5366DF6585701D33781E3066B4AFA8")

    public static final int WIFI_STATE_DISABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_field = "7ED33E4EFFAB0957B139A4FBB46B1007", hash_generated_field = "F2ADABF7F2992B3ED65D27E20283D1F6")

    public static final int WIFI_STATE_ENABLING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_field = "5AAFCB32A97D94C3DF5549300190AE52", hash_generated_field = "06DDD34F33E45C8F663664CD911FF5AB")

    public static final int WIFI_STATE_ENABLED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_field = "20E5381E72985E573686190569CE5784", hash_generated_field = "E8AFD6E713201D2BE9CCD062C6A47AEA")

    public static final int WIFI_STATE_UNKNOWN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.633 -0400", hash_original_field = "3BE3DE3FFDA26AE538EAEBF3BB37528D", hash_generated_field = "705EDD303DB61EC718572FA5275D3C5A")

    public static final String WIFI_AP_STATE_CHANGED_ACTION =
        "android.net.wifi.WIFI_AP_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "78A247A8B44054497886DF62817F280D", hash_generated_field = "92AFA518C48CABAA417E28328E2D9063")

    public static final String EXTRA_WIFI_AP_STATE = "wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "3EF091900F15377421FA68C70BDA39AA", hash_generated_field = "7C2F550793EA245C07443AC5F1ED3AF6")

    public static final String EXTRA_PREVIOUS_WIFI_AP_STATE = "previous_wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "01B486AD62C331C8F0575BAA722E72EB", hash_generated_field = "209F5C5C2CDCF7B6F64BD4ED77AD042C")

    public static final int WIFI_AP_STATE_DISABLING = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "363357D0E2171D4C81373BD6ECFBD40A", hash_generated_field = "3A49281391657B7405283CBCE0E99B88")

    public static final int WIFI_AP_STATE_DISABLED = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "B17617B0A7DD8AFB4D8AFFDC300E98F9", hash_generated_field = "43E8773A0C034F3EDE7247F857A9B19E")

    public static final int WIFI_AP_STATE_ENABLING = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "A7F8AAEF17D7E999529D1B444EDFEED8", hash_generated_field = "597700F8A65905DB8E975F1D1E5F3DA6")

    public static final int WIFI_AP_STATE_ENABLED = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "AE13D766030DC8EE1A5D3EE767A9D04F", hash_generated_field = "A8488BD2ECBA6883D2DB38AE89ACE4F5")

    public static final int WIFI_AP_STATE_FAILED = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "1A198E48F79AE8725FF0D5C807F4ED19", hash_generated_field = "C77032707377A2B11B3B6B5DEFFE1311")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SUPPLICANT_CONNECTION_CHANGE_ACTION =
        "android.net.wifi.supplicant.CONNECTION_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "59E876250F9DB64F3DF776B93F9FEE46", hash_generated_field = "CDBC8B7CF4D0CA98D9425D824E922C3A")

    public static final String EXTRA_SUPPLICANT_CONNECTED = "connected";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "807BAA441D8390622A11EE235111390C", hash_generated_field = "B8648E4BFBAEF813252FD594CC108B4D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String NETWORK_STATE_CHANGED_ACTION = "android.net.wifi.STATE_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "ACAA90A79946019658CF4D2C0E90FC45", hash_generated_field = "422031D57C1A9E39521E008A0CBF3B3C")

    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "E82CEDA6F1000F5BB1A0C0E74BEEBCC9", hash_generated_field = "BF57671FDC2B9ABDFAF5D8AEA7BAA947")

    public static final String EXTRA_BSSID = "bssid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "C6DEB388FDA6ECEC13A8E9F9E931E5F6", hash_generated_field = "53C2244BE022BE4A381D06DA518EB76B")

    public static final String EXTRA_WIFI_INFO = "wifiInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "8942D46952F7066FEEB3511650A276FF", hash_generated_field = "D73D816A0B7FCFD432AA984E977AC22C")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SUPPLICANT_STATE_CHANGED_ACTION =
        "android.net.wifi.supplicant.STATE_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "E872A937F83834A9AD2CB1EFACA97397", hash_generated_field = "34AA826E3AF97AB38DB470F1C5654E68")

    public static final String EXTRA_NEW_STATE = "newState";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "3F8713876D6EE32D16E68249621C644E", hash_generated_field = "DE620C91519E2A376661E1B4006EAACA")

    public static final String EXTRA_SUPPLICANT_ERROR = "supplicantError";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "76A1C57BFAA36783CA0F2362FDCDD9D2", hash_generated_field = "8B73608A4EF89D78B6901DFA0665D165")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ERROR_ACTION = "android.net.wifi.ERROR";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "50472CF4F7672EB8868BF194FAA83042", hash_generated_field = "FA40DA21A3D0B77445C4852C84BE80AE")

    public static final String EXTRA_ERROR_CODE = "errorCode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "061DFF13C86BBDB544631213B8DC3B64", hash_generated_field = "2784A14BBCACF543186CCAAD68AC111C")

    public static final int WPS_OVERLAP_ERROR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "97D33284D99C36BAA3E4DDED69B4902F", hash_generated_field = "3DEB0A15DB5D2EDEE13E62DA3FC221C7")

    public static final String CONFIGURED_NETWORKS_CHANGED_ACTION =
        "android.net.wifi.CONFIGURED_NETWORKS_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "7F6E9185E4434BAD74AF662AE13977F6", hash_generated_field = "FB9CA3626A316B66033D491508ED5D88")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "1BF034FB8FF23CB493A7570E76E707B3", hash_generated_field = "C71F973F8B385841B02BE2C761218AEF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String RSSI_CHANGED_ACTION = "android.net.wifi.RSSI_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "32681E7B259952DABBFA332463B2E186", hash_generated_field = "F6576C7FACD2AA843A12F433031DB417")

    public static final String EXTRA_NEW_RSSI = "newRssi";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "54C389AE7454612FCBE99FC3790B8420", hash_generated_field = "4236F79C5A13A06E052A218C87FCD7AA")

    public static final String LINK_CONFIGURATION_CHANGED_ACTION =
        "android.net.wifi.LINK_CONFIGURATION_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "DAC37E4448A17DAA0BDB854C0225CA4C", hash_generated_field = "B2AF7393288899F9C62599EE162CC59A")

    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "7DFD46BB73461CD7286B9FDCCCA83168", hash_generated_field = "2EE887A583B9775AF34213DD8E61A00E")

    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "D3B8BEB61E404158A7530123E8D2B90B", hash_generated_field = "0325C95FCCE4B351CA7FEB67F6B7BA12")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String NETWORK_IDS_CHANGED_ACTION = "android.net.wifi.NETWORK_IDS_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "9D0493DF677AC43D136AF1B2A9906E7A", hash_generated_field = "55C17055111CE4074EEDA5CECF2B3757")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK_WIFI_NETWORK = "android.net.wifi.PICK_WIFI_NETWORK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.634 -0400", hash_original_field = "EE31A5071A8FFC8C237208177037337D", hash_generated_field = "165D11A1ECFD913E5C1ECF94299A477E")

    public static final int WIFI_MODE_FULL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "6AF2EF647228F3AFFA250FBF39A821A2", hash_generated_field = "94C5D29C1CE510F135890C372BE94396")

    public static final int WIFI_MODE_SCAN_ONLY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "5594AE1D7ED5804C1F81383076E59588", hash_generated_field = "F3AB5F19FC3DF915800D3B2F6E33706C")

    public static final int WIFI_MODE_FULL_HIGH_PERF = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "F81929FFFE83BD457D7742224C8B0457", hash_generated_field = "9F9088C65BD4F1789D8C8FDAB77015A8")

    private static final int MIN_RSSI = -100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "0A05ECF66C34A06419B23B745B0D45B0", hash_generated_field = "7DF91D8D2EC01CB1BE1AE4CAFCD0F309")

    private static final int MAX_RSSI = -55;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "F1CCB588F4099EFB4AC3B8F9C9324E97", hash_generated_field = "B84D769DCD709B183890B60DF3C274DA")

    public static final int WIFI_FREQUENCY_BAND_AUTO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "231C9D37A8817B4D3E118BEE7D5B371A", hash_generated_field = "F498C8314733151CD8E82921B0C4E22C")

    public static final int WIFI_FREQUENCY_BAND_5GHZ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "9730084C49D6A21C62927C1102B8D657", hash_generated_field = "6A1155A1B59CAD32A0FAC3FE219F29D2")

    public static final int WIFI_FREQUENCY_BAND_2GHZ = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "515162F4F8CFA5B14D2FE52C022E4BE3", hash_generated_field = "9B58465EB0D92245EC9CA4D811AEC5DD")

    public static final int DATA_ACTIVITY_NOTIFICATION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "6837AC5BB2753B6857C2C1DC403A0EB3", hash_generated_field = "F4CC6307DC2FF1A2B8CB7457E8B5AD9E")

    public static final int DATA_ACTIVITY_NONE         = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "FCAF43A79A1C904023D22A7AA61F7556", hash_generated_field = "B4DF8C490A9544C3C8D4B30926E0CD7E")

    public static final int DATA_ACTIVITY_IN           = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "2DC49AD01499C1665F43DA1A6F98AC48", hash_generated_field = "E3EC39EDBEEB9E8C0DC13BD46CB864BE")

    public static final int DATA_ACTIVITY_OUT          = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "960AF15D25F61CDA2363A2691565008A", hash_generated_field = "08F2BE8A202C8F8B111FD96D48B71285")

    public static final int DATA_ACTIVITY_INOUT        = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "1A512A00EB52378D4A10EF2AA242C735", hash_generated_field = "A46B2DFFFC241E78B7C771A4BAE78A6E")

    private static final int MAX_ACTIVE_LOCKS = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "646E42B947A8F7B418092CED9A6F4C1F", hash_generated_field = "5A67FC0349394E3625D9712DFC2DD495")

    public static final int CMD_CONNECT_NETWORK             = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "8B1A0832B35C196C0DF7D0CC76CF0AE0", hash_generated_field = "46529F28CB12A06C7F56C09018C641A0")

    public static final int CMD_FORGET_NETWORK              = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "AFBB98EEEF662FFF692214621B6A1DB3", hash_generated_field = "6B8553C6C496218E9F37E094D517F7E5")

    public static final int CMD_SAVE_NETWORK                = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "D91E8B64BF9FF96B110F55329B508315", hash_generated_field = "3FB85837ABE02F19E22F86C7FD9A7CB9")

    public static final int CMD_START_WPS                   = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "16E0E8180823F20E47D9A58EF1BFC579", hash_generated_field = "5A520D736A3DF8FA576C9E8034E02305")

    public static final int CMD_DISABLE_NETWORK             = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "FBCED99560CDF828EDED1A164C8ED672", hash_generated_field = "9BB6A17346ACCF1C252A49990A8E5790")

    public static final int CMD_WPS_COMPLETED               = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "4649341BB0476ACEB21B2F7C7CE8CF57", hash_generated_field = "ECCBA1FF030DC0DEEA34AAE6ED0A8AD8")

    public static final int CMD_ENABLE_TRAFFIC_STATS_POLL   = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.635 -0400", hash_original_field = "7BF3E1A2A9B4D47471730828319ECBF1", hash_generated_field = "7A5F8E8BF9878485F2FEE42B8FB5E475")

    public static final int CMD_TRAFFIC_STATS_POLL          = 22;
}

