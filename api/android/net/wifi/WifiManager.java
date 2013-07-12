package android.net.wifi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.033 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "DB1464CA9C87828D9D93BD784121DA8C")

    IWifiManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.034 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.034 -0400", hash_original_field = "515CEC5C60BFB489FCE4D019DF434BA7", hash_generated_field = "D601BE33010BF0FF8F79216654DBC58D")

    private int mActiveLockCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.034 -0400", hash_original_field = "5FD29322753C3A7384C678B13BEFD72D", hash_generated_field = "C8DF611874A1503E325C16431857C1F2")

    private AsyncChannel mAsyncChannel = new AsyncChannel();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.035 -0400", hash_original_method = "45AC664258FD08C08C588B627CDDFFBC", hash_generated_method = "B4F1E9EA15C43234D8FE3A9CE9AF5CBA")
    public  WifiManager(IWifiManager service, Handler handler) {
        mService = service;
        mHandler = handler;
        // ---------- Original Method ----------
        //mService = service;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.035 -0400", hash_original_method = "7B7EDD72C806D0E7DC8642CC316AA722", hash_generated_method = "1BE5E7BEEB700F4F2A7FE24DD1AC5171")
    public List<WifiConfiguration> getConfiguredNetworks() {
        try 
        {
List<WifiConfiguration> var4F88E0AB1FAFC9504D31144C9834BCBC_302264394 =             mService.getConfiguredNetworks();
            var4F88E0AB1FAFC9504D31144C9834BCBC_302264394.addTaint(taint);
            return var4F88E0AB1FAFC9504D31144C9834BCBC_302264394;
        } //End block
        catch (RemoteException e)
        {
List<WifiConfiguration> var540C13E9E156B687226421B24F2DF178_1715874205 =             null;
            var540C13E9E156B687226421B24F2DF178_1715874205.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1715874205;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getConfiguredNetworks();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.036 -0400", hash_original_method = "FC0AD51F5109F6EE6B896159A6BE091E", hash_generated_method = "AA3DADA9718F862C5F58DE91AC716D53")
    public int addNetwork(WifiConfiguration config) {
        addTaint(config.getTaint());
    if(config == null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2033626626 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679394838 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679394838;
        } //End block
        config.networkId = -1;
        int varC1C5E035E8D95985B9800E271455F437_1402399803 = (addOrUpdateNetwork(config));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1919242882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1919242882;
        // ---------- Original Method ----------
        //if (config == null) {
            //return -1;
        //}
        //config.networkId = -1;
        //return addOrUpdateNetwork(config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.036 -0400", hash_original_method = "BAE559B7BC959F87E1981FBD6EC47DF5", hash_generated_method = "7C6B6AD5B58A871183277108AFA2AF49")
    public int updateNetwork(WifiConfiguration config) {
        addTaint(config.getTaint());
    if(config == null || config.networkId < 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1001171274 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784430552 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784430552;
        } //End block
        int varC1C5E035E8D95985B9800E271455F437_284304172 = (addOrUpdateNetwork(config));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1899158035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1899158035;
        // ---------- Original Method ----------
        //if (config == null || config.networkId < 0) {
            //return -1;
        //}
        //return addOrUpdateNetwork(config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.036 -0400", hash_original_method = "E64504FDFA81026BF4EAE79A420D3010", hash_generated_method = "E1C22F0AECE1A9BCC5C0B9EA10075AEA")
    private int addOrUpdateNetwork(WifiConfiguration config) {
        addTaint(config.getTaint());
        try 
        {
            int varDECE89ACD3A11BE8062E2E75EE60ED08_1405500063 = (mService.addOrUpdateNetwork(config));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383801022 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383801022;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2137686139 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085814065 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085814065;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.addOrUpdateNetwork(config);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.037 -0400", hash_original_method = "C55861B25E581745B3C6351405363685", hash_generated_method = "2EFFA6505205B492D4D93E01C9F090CA")
    public boolean removeNetwork(int netId) {
        addTaint(netId);
        try 
        {
            boolean var6B07C45DCB6CCB41DCA24C3BC88383F2_2092824274 = (mService.removeNetwork(netId));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97183058 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_97183058;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1008752708 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682819128 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_682819128;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.removeNetwork(netId);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.037 -0400", hash_original_method = "A063D2F3A1A45A8B2BB20D41F98AEB1B", hash_generated_method = "023DB0D92C4B237A05F007707A2E72A9")
    public boolean enableNetwork(int netId, boolean disableOthers) {
        addTaint(disableOthers);
        addTaint(netId);
        try 
        {
            boolean varA1C31F584B760D1424F1E6692105D579_1889180103 = (mService.enableNetwork(netId, disableOthers));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098698338 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098698338;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_517614029 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_214113042 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_214113042;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.enableNetwork(netId, disableOthers);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.038 -0400", hash_original_method = "630BE7480BA2E95DA9CEC1F52BBE219A", hash_generated_method = "C41DB2053690444FD1A729E2984C8850")
    public boolean disableNetwork(int netId) {
        addTaint(netId);
        try 
        {
            boolean var1993053558E4FE4C474056782C19D982_2142379502 = (mService.disableNetwork(netId));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1756919505 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1756919505;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1218858869 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1215639012 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1215639012;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.disableNetwork(netId);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.038 -0400", hash_original_method = "4C2FCF871904470A4665E52D44D62875", hash_generated_method = "1BA8F87A87CA4418688E41CB10EB2A97")
    public void disableNetwork(int netId, int reason) {
        addTaint(reason);
        addTaint(netId);
        mAsyncChannel.sendMessage(CMD_DISABLE_NETWORK, netId, reason);
        // ---------- Original Method ----------
        //mAsyncChannel.sendMessage(CMD_DISABLE_NETWORK, netId, reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.039 -0400", hash_original_method = "13D7026BA6E2310038D9CCEC7D1F5CA4", hash_generated_method = "0FFE0D994AD01EAEC8F8FB90740E5B41")
    public boolean disconnect() {
        try 
        {
            mService.disconnect();
            boolean varB326B5062B2F0E69046810717534CB09_632150731 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1289048000 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1289048000;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1172420148 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1571480090 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1571480090;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.disconnect();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.039 -0400", hash_original_method = "AD9DD9C3B4130EB49C99A6BF92BCA383", hash_generated_method = "2E30E106863593951A82BAF9671D01E4")
    public boolean reconnect() {
        try 
        {
            mService.reconnect();
            boolean varB326B5062B2F0E69046810717534CB09_1668330561 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_73794861 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_73794861;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_612983378 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_213864427 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_213864427;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.reconnect();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.039 -0400", hash_original_method = "4462A23EEF44DC4F050ECB7EA4566A65", hash_generated_method = "2F70DA3F5E588D62B352AD70B88CDEAB")
    public boolean reassociate() {
        try 
        {
            mService.reassociate();
            boolean varB326B5062B2F0E69046810717534CB09_871683992 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1883221479 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1883221479;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1250367496 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181814561 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_181814561;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.reassociate();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.040 -0400", hash_original_method = "44FE7083E78F583BB16CDAFA3EBE6F36", hash_generated_method = "50731D5461917BDD9415711B31ECFEE0")
    public boolean pingSupplicant() {
    if(mService == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_218344104 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1367767681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1367767681;
        }
        try 
        {
            boolean var2FA21A90D885B88AD93ADB5FDF7246A2_361759339 = (mService.pingSupplicant());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2009945965 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2009945965;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_2025976758 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_450117042 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_450117042;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.040 -0400", hash_original_method = "F8088016DD577DAE90193BD2B16E77E5", hash_generated_method = "32534300B2995799F26971150691289B")
    public boolean startScan() {
        try 
        {
            mService.startScan(false);
            boolean varB326B5062B2F0E69046810717534CB09_320695214 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_896474363 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_896474363;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_735372945 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302899810 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_302899810;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.startScan(false);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.041 -0400", hash_original_method = "1BECDA97215EAB893F9C0F926E7877B4", hash_generated_method = "351AAA0840636C62541C2AE6C4A705F7")
    public boolean startScanActive() {
        try 
        {
            mService.startScan(true);
            boolean varB326B5062B2F0E69046810717534CB09_1104433869 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120814470 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120814470;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_926839918 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098532947 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098532947;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.startScan(true);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.041 -0400", hash_original_method = "8E854EE6D7B979BB188C54EFD6BB6717", hash_generated_method = "5F78B80FEDFC972F047FB5F65D5501A6")
    public WifiInfo getConnectionInfo() {
        try 
        {
WifiInfo var5705730BFC480D0E115D28CF547AA341_1300538183 =             mService.getConnectionInfo();
            var5705730BFC480D0E115D28CF547AA341_1300538183.addTaint(taint);
            return var5705730BFC480D0E115D28CF547AA341_1300538183;
        } //End block
        catch (RemoteException e)
        {
WifiInfo var540C13E9E156B687226421B24F2DF178_1158204716 =             null;
            var540C13E9E156B687226421B24F2DF178_1158204716.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1158204716;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getConnectionInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.041 -0400", hash_original_method = "ADD60A4DA3445A3E968EB713F725E5F1", hash_generated_method = "00C8747EABD27155AF2FA48CAECB30E2")
    public List<ScanResult> getScanResults() {
        try 
        {
List<ScanResult> varDA562D6FE80BAE8CA65C00F581C14445_1239450207 =             mService.getScanResults();
            varDA562D6FE80BAE8CA65C00F581C14445_1239450207.addTaint(taint);
            return varDA562D6FE80BAE8CA65C00F581C14445_1239450207;
        } //End block
        catch (RemoteException e)
        {
List<ScanResult> var540C13E9E156B687226421B24F2DF178_1838093116 =             null;
            var540C13E9E156B687226421B24F2DF178_1838093116.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1838093116;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getScanResults();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.042 -0400", hash_original_method = "D1E32319AD181FF60DD93B5B2DB831F1", hash_generated_method = "5562EE0F9E988BE80CE44E5A6CA193E8")
    public boolean saveConfiguration() {
        try 
        {
            boolean var2C617EC4E42A92E0074105B18F95650E_77679846 = (mService.saveConfiguration());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1329071179 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1329071179;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_256132062 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2066328629 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2066328629;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.saveConfiguration();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.042 -0400", hash_original_method = "9549A9F9433914F9E55F5CC34183554C", hash_generated_method = "AB8215AB2A46AFE10B080E75EED6B225")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.043 -0400", hash_original_method = "4B6C5827C7D51FB40ECD8DD67D760E19", hash_generated_method = "780648C0C390E84DC57B3D184EDCD094")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.043 -0400", hash_original_method = "481BDDBC9D497285776974614BBC7D82", hash_generated_method = "E01A8CFF7EDA2EA4D15CE9E68D868465")
    public int getFrequencyBand() {
        try 
        {
            int var717522526F6DCF9BC53B4B1C7DA1C250_2019927086 = (mService.getFrequencyBand());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1362502188 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1362502188;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_93022449 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366535569 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366535569;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getFrequencyBand();
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.044 -0400", hash_original_method = "F73D127A0D43FAD1AD9DBA6A689AC70A", hash_generated_method = "C7931DD69E3F56BA0A9C40B72007A4FF")
    public boolean isDualBandSupported() {
        try 
        {
            boolean varEAAC367DCCD52A845F65255FF7683621_496716737 = (mService.isDualBandSupported());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270948246 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_270948246;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_606504089 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_490604137 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_490604137;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.isDualBandSupported();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.044 -0400", hash_original_method = "711DEA09870DB7E049F72B7F8BEBC0A1", hash_generated_method = "DD1D54A18691012B10716337B9803A37")
    public DhcpInfo getDhcpInfo() {
        try 
        {
DhcpInfo var7F156C3E06F3DD8F97345C4B0AD9B9CB_1602847910 =             mService.getDhcpInfo();
            var7F156C3E06F3DD8F97345C4B0AD9B9CB_1602847910.addTaint(taint);
            return var7F156C3E06F3DD8F97345C4B0AD9B9CB_1602847910;
        } //End block
        catch (RemoteException e)
        {
DhcpInfo var540C13E9E156B687226421B24F2DF178_174145401 =             null;
            var540C13E9E156B687226421B24F2DF178_174145401.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_174145401;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getDhcpInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.045 -0400", hash_original_method = "B9430AD639DDE3004B577A4BF40EB18B", hash_generated_method = "60E86A3673C5DE2FA70ECBEA686F326A")
    public boolean setWifiEnabled(boolean enabled) {
        addTaint(enabled);
        try 
        {
            boolean varBA7F2CCA3EE31C1A94DA0BEE5B8C6AEB_1708039350 = (mService.setWifiEnabled(enabled));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_818531612 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_818531612;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_645287603 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394350691 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394350691;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.setWifiEnabled(enabled);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.045 -0400", hash_original_method = "661FA885AE58B8C5231BF7DCF436505F", hash_generated_method = "06BC3843ACB3399AC80C76FDAA33A919")
    public int getWifiState() {
        try 
        {
            int varCD3132D86DB75414323C23431124E8FE_267967746 = (mService.getWifiEnabledState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897235845 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897235845;
        } //End block
        catch (RemoteException e)
        {
            int var6D01601C9C9E20C43DFDDFE008E5E522_1145945659 = (WIFI_STATE_UNKNOWN);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644043963 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644043963;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getWifiEnabledState();
        //} catch (RemoteException e) {
            //return WIFI_STATE_UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.045 -0400", hash_original_method = "D7F0AFD1306EBF22F34F7E014A2C9B11", hash_generated_method = "62C09CC3777B3A3E45589A070E9D78B0")
    public boolean isWifiEnabled() {
        boolean varDEB3A887086CF2643222589D79401497_1095941191 = (getWifiState() == WIFI_STATE_ENABLED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_183913386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_183913386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.047 -0400", hash_original_method = "2BFE81971E8D979C3ECBD7F543427F67", hash_generated_method = "0F6D353C555A3C6A5F0523B91B626F01")
    public boolean setWifiApEnabled(WifiConfiguration wifiConfig, boolean enabled) {
        addTaint(enabled);
        addTaint(wifiConfig.getTaint());
        try 
        {
            mService.setWifiApEnabled(wifiConfig, enabled);
            boolean varB326B5062B2F0E69046810717534CB09_831975173 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647413651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_647413651;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1355345839 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1862184437 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1862184437;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setWifiApEnabled(wifiConfig, enabled);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.047 -0400", hash_original_method = "B0BA72D208162E33734DF133F2E7F6AA", hash_generated_method = "F29535585214E0249D11DF7C87F79013")
    public int getWifiApState() {
        try 
        {
            int varD8CD85E85B7114B7C946D7366D0D5A87_329839102 = (mService.getWifiApEnabledState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_742497914 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_742497914;
        } //End block
        catch (RemoteException e)
        {
            int var838CE68F82E46116D81DE0525785B96B_1058140732 = (WIFI_AP_STATE_FAILED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378890229 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378890229;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getWifiApEnabledState();
        //} catch (RemoteException e) {
            //return WIFI_AP_STATE_FAILED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.048 -0400", hash_original_method = "657EB8B0A945E7FD7BA91E2539A322BE", hash_generated_method = "0BE6112A9DAC8B320E91289B8A22E2B2")
    public boolean isWifiApEnabled() {
        boolean var2AD5E4D3AFB8F4B8AA800AF5E27BBAE9_1544039026 = (getWifiApState() == WIFI_AP_STATE_ENABLED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_926627675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_926627675;
        // ---------- Original Method ----------
        //return getWifiApState() == WIFI_AP_STATE_ENABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.048 -0400", hash_original_method = "99407E6898AC76390D3E229EC6CF35C4", hash_generated_method = "4368CCACC279051EBFED1141EB6D29A9")
    public WifiConfiguration getWifiApConfiguration() {
        try 
        {
WifiConfiguration var5445B0BDAF6A8DA52A529FEF1AED454F_482759189 =             mService.getWifiApConfiguration();
            var5445B0BDAF6A8DA52A529FEF1AED454F_482759189.addTaint(taint);
            return var5445B0BDAF6A8DA52A529FEF1AED454F_482759189;
        } //End block
        catch (RemoteException e)
        {
WifiConfiguration var540C13E9E156B687226421B24F2DF178_397283688 =             null;
            var540C13E9E156B687226421B24F2DF178_397283688.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_397283688;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getWifiApConfiguration();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.049 -0400", hash_original_method = "32645F13A37CD40BEF3F9464116D1367", hash_generated_method = "53DCFEA2BF8A595ED05BC3424DF106D4")
    public boolean setWifiApConfiguration(WifiConfiguration wifiConfig) {
        addTaint(wifiConfig.getTaint());
        try 
        {
            mService.setWifiApConfiguration(wifiConfig);
            boolean varB326B5062B2F0E69046810717534CB09_985545833 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333415471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333415471;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1862202874 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_4209258 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_4209258;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setWifiApConfiguration(wifiConfig);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.049 -0400", hash_original_method = "F505CF72442DFA261366294723957A53", hash_generated_method = "68ED0A62A9E39BCAB4AD8F226B98F0F0")
    public boolean startWifi() {
        try 
        {
            mService.startWifi();
            boolean varB326B5062B2F0E69046810717534CB09_191888812 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2062019607 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2062019607;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1940837604 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632446769 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_632446769;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.startWifi();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.056 -0400", hash_original_method = "F7F977701F133D0F59F048A53A2C698B", hash_generated_method = "6A567EE0C072435F8A1B99793A1AD23A")
    public boolean stopWifi() {
        try 
        {
            mService.stopWifi();
            boolean varB326B5062B2F0E69046810717534CB09_1869303276 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1821570390 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1821570390;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_949178681 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1125365920 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1125365920;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.stopWifi();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.058 -0400", hash_original_method = "6E01C15F4CA49AC218CA465537508537", hash_generated_method = "0E6D5D7F2A44A20EA74FEF2DAC79F45B")
    public boolean addToBlacklist(String bssid) {
        addTaint(bssid.getTaint());
        try 
        {
            mService.addToBlacklist(bssid);
            boolean varB326B5062B2F0E69046810717534CB09_1425223978 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704169324 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_704169324;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_799814816 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439204098 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_439204098;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.addToBlacklist(bssid);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.058 -0400", hash_original_method = "614FAF75AF873709E1677408EE18D7B6", hash_generated_method = "C82CDB475D67825DC37BF8EAB0BCC30C")
    public boolean clearBlacklist() {
        try 
        {
            mService.clearBlacklist();
            boolean varB326B5062B2F0E69046810717534CB09_168278345 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_324942412 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_324942412;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_449429851 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113151166 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113151166;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.clearBlacklist();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.059 -0400", hash_original_method = "F93FD4BCC6C0F6B375A42EEFE25B9408", hash_generated_method = "F0745431211788A9F31DAC89ED140603")
    public void asyncConnect(Context srcContext, Handler srcHandler) {
        addTaint(srcHandler.getTaint());
        addTaint(srcContext.getTaint());
        mAsyncChannel.connect(srcContext, srcHandler, getMessenger());
        // ---------- Original Method ----------
        //mAsyncChannel.connect(srcContext, srcHandler, getMessenger());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.059 -0400", hash_original_method = "B69D8EEDABB0031125B40805CA5F91D8", hash_generated_method = "FEE6B5B517EB6F3402902C4D90A6915C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.059 -0400", hash_original_method = "9464671A8FCBA7A99848867493116AAD", hash_generated_method = "BF2CCD32967AD1DD1F5BC178139A1AAD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.060 -0400", hash_original_method = "210177ED8E63F9C12E442B1614E4B9E7", hash_generated_method = "99E91FEBF569488B60C7CFA0FD7C1CC9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.060 -0400", hash_original_method = "A04E73224B607EFF8F851CD080EF29BA", hash_generated_method = "54A1E6A6F717307C4C85F9C2E17F9960")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.060 -0400", hash_original_method = "CB69F89B2E3E5728AFF3169858F2154E", hash_generated_method = "7E7690C8BFC0C5E0E1D371EC87A08CCB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.061 -0400", hash_original_method = "A358F8361C96DABE1A63B04B5804B3F5", hash_generated_method = "1B570C8FD5756EAD2C087C8A9DC488A7")
    public Messenger getMessenger() {
        try 
        {
Messenger varF7929FC05940900E4513D8262C8E2654_1376102411 =             mService.getMessenger();
            varF7929FC05940900E4513D8262C8E2654_1376102411.addTaint(taint);
            return varF7929FC05940900E4513D8262C8E2654_1376102411;
        } //End block
        catch (RemoteException e)
        {
Messenger var540C13E9E156B687226421B24F2DF178_500328549 =             null;
            var540C13E9E156B687226421B24F2DF178_500328549.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_500328549;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getMessenger();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.061 -0400", hash_original_method = "F47F46BF01C13AECFB0A8E0A7BCA30AB", hash_generated_method = "2BAA578F0A220BCADCE7BDCAEBF3BF42")
    public String getConfigFile() {
        try 
        {
String varB42BB982F8EC56A555249A2A6B239AC0_1373196259 =             mService.getConfigFile();
            varB42BB982F8EC56A555249A2A6B239AC0_1373196259.addTaint(taint);
            return varB42BB982F8EC56A555249A2A6B239AC0_1373196259;
        } //End block
        catch (RemoteException e)
        {
String var540C13E9E156B687226421B24F2DF178_531947760 =             null;
            var540C13E9E156B687226421B24F2DF178_531947760.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_531947760;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getConfigFile();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.061 -0400", hash_original_method = "77C6D00CEFBA51FBEDF42525D5CAF8B4", hash_generated_method = "24DE656520B266486C9A621E99C83580")
    public WifiLock createWifiLock(int lockType, String tag) {
        addTaint(tag.getTaint());
        addTaint(lockType);
WifiLock var780FF626E0BEB022C692CAF9DB88BC6C_1183655991 =         new WifiLock(lockType, tag);
        var780FF626E0BEB022C692CAF9DB88BC6C_1183655991.addTaint(taint);
        return var780FF626E0BEB022C692CAF9DB88BC6C_1183655991;
        // ---------- Original Method ----------
        //return new WifiLock(lockType, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.062 -0400", hash_original_method = "F25A7BAA745FE3E1539A4ACAD2E402AC", hash_generated_method = "B025A855A50603519E150DA824562D5B")
    public WifiLock createWifiLock(String tag) {
        addTaint(tag.getTaint());
WifiLock var1515066542E695DE079F7D0491648C60_1426440408 =         new WifiLock(WIFI_MODE_FULL, tag);
        var1515066542E695DE079F7D0491648C60_1426440408.addTaint(taint);
        return var1515066542E695DE079F7D0491648C60_1426440408;
        // ---------- Original Method ----------
        //return new WifiLock(WIFI_MODE_FULL, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.062 -0400", hash_original_method = "90BF24DBA9F26B31ED84B0CABBF9287E", hash_generated_method = "DE4C67DF8C75F4A135B7EEC12C136FA1")
    public MulticastLock createMulticastLock(String tag) {
        addTaint(tag.getTaint());
MulticastLock varF7F0BDC4D2B91B78614D3DAAA6856880_1080501056 =         new MulticastLock(tag);
        varF7F0BDC4D2B91B78614D3DAAA6856880_1080501056.addTaint(taint);
        return varF7F0BDC4D2B91B78614D3DAAA6856880_1080501056;
        // ---------- Original Method ----------
        //return new MulticastLock(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.063 -0400", hash_original_method = "36EA363278EADF8446AD30BF262D8211", hash_generated_method = "873D4FEA97DF2FBED73BEA12BF71617E")
    public boolean isMulticastEnabled() {
        try 
        {
            boolean varD730F55F40FFB516E40037129275C513_174792012 = (mService.isMulticastEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57196074 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_57196074;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_778594661 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510094757 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_510094757;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.isMulticastEnabled();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.063 -0400", hash_original_method = "03CE776E3230E83E55C388557E1A9516", hash_generated_method = "21210D73C5F24B242A3EFF18F164091A")
    public boolean initializeMulticastFiltering() {
        try 
        {
            mService.initializeMulticastFiltering();
            boolean varB326B5062B2F0E69046810717534CB09_1517252879 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060128363 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060128363;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_986018612 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1357742224 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1357742224;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.064 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.064 -0400", hash_original_field = "59251AD7EF4786A1A863CD24E536AB17", hash_generated_field = "A726660A8F3C406901F3D212C617E404")

        private IBinder mBinder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.064 -0400", hash_original_field = "DAC8A06C1EDF9825CDAF6DFCD18A7ADC", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

        private int mRefCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.064 -0400", hash_original_field = "2E26F41B503854D2664C327E649E3CAE", hash_generated_field = "3AD78D1D4CE6492B77426188DE5C8EB6")

        int mLockType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.064 -0400", hash_original_field = "2027736A79052BCC8F6250B2A1BACD52", hash_generated_field = "EEB06CC18CFEB1CEBC8608AACD58D0B5")

        private boolean mRefCounted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.064 -0400", hash_original_field = "AD25B113814807D236AFB0F5095B0005", hash_generated_field = "CC6ABDC2865C3E48C44DCFBA12BDB07C")

        private boolean mHeld;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.064 -0400", hash_original_field = "33F0FDFE72CD4D291DF24A21567DB5C9", hash_generated_field = "C5BF497580D66C18B0028C0F7134DDF3")

        private WorkSource mWorkSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.065 -0400", hash_original_method = "044CDC682150D26B37DC0497B735DA49", hash_generated_method = "1273DB766F5BD50415DCCD366CA34B18")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.065 -0400", hash_original_method = "208DCD1288F5AC0918E067B51EC18B17", hash_generated_method = "ACEEF1A1BE875CBAD99876B25054B0BE")
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
                                UnsupportedOperationException var6FB6F703E86436697EADCF1E3CEE23D9_297012759 = new UnsupportedOperationException(
                                            "Exceeded maximum number of wifi locks");
                                var6FB6F703E86436697EADCF1E3CEE23D9_297012759.addTaint(taint);
                                throw var6FB6F703E86436697EADCF1E3CEE23D9_297012759;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.066 -0400", hash_original_method = "EEC110369AFED5315DDFD7D45F992208", hash_generated_method = "54B4CEF8295CB664F94AAFF0C8DA90A4")
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
                    RuntimeException varC201BD43267ABC9990F7A44596550D06_387457608 = new RuntimeException("WifiLock under-locked " + mTag);
                    varC201BD43267ABC9990F7A44596550D06_387457608.addTaint(taint);
                    throw varC201BD43267ABC9990F7A44596550D06_387457608;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.067 -0400", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "91B8A28629F935F303A73D2F07650B69")
        public void setReferenceCounted(boolean refCounted) {
            mRefCounted = refCounted;
            // ---------- Original Method ----------
            //mRefCounted = refCounted;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.067 -0400", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "CED683671336ADD60ADF0070EFA84B8B")
        public boolean isHeld() {
            synchronized
(mBinder)            {
                boolean varAD25B113814807D236AFB0F5095B0005_2034488550 = (mHeld);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089645769 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089645769;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.068 -0400", hash_original_method = "7C62BA62C0C3A7C1DC2FB1EDC51DE805", hash_generated_method = "77121D7B133841530807150DBFF1D3DB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.069 -0400", hash_original_method = "30E303CA91E967AFDBED5B1FC9CE8E64", hash_generated_method = "01EE9D6CC6E0685EA5EFA7C323AD4FC1")
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
String varF6BD25B17478B3615FCC3F9239B0D36D_168058607 =                 "WifiLock{ " + s1 + "; " + s2 + s3 + " }";
                varF6BD25B17478B3615FCC3F9239B0D36D_168058607.addTaint(taint);
                return varF6BD25B17478B3615FCC3F9239B0D36D_168058607;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.069 -0400", hash_original_method = "CDAA53D98D74A433929787E6E7DF605C", hash_generated_method = "6715256FE3F91AE0459CB3C1E10A46D0")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.070 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.070 -0400", hash_original_field = "59251AD7EF4786A1A863CD24E536AB17", hash_generated_field = "A726660A8F3C406901F3D212C617E404")

        private IBinder mBinder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.070 -0400", hash_original_field = "DAC8A06C1EDF9825CDAF6DFCD18A7ADC", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

        private int mRefCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.070 -0400", hash_original_field = "2027736A79052BCC8F6250B2A1BACD52", hash_generated_field = "EEB06CC18CFEB1CEBC8608AACD58D0B5")

        private boolean mRefCounted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.070 -0400", hash_original_field = "AD25B113814807D236AFB0F5095B0005", hash_generated_field = "CC6ABDC2865C3E48C44DCFBA12BDB07C")

        private boolean mHeld;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.071 -0400", hash_original_method = "DEAA1CCFF83554B98BCA4D411D463199", hash_generated_method = "A1769D3129EB80B6FA9D01C9F3980BAA")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.071 -0400", hash_original_method = "130A969831975A68066B20EB1F9033A3", hash_generated_method = "53967664B334B7C7376D3F784E1A0771")
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
                                UnsupportedOperationException var6FB6F703E86436697EADCF1E3CEE23D9_89367631 = new UnsupportedOperationException(
                                        "Exceeded maximum number of wifi locks");
                                var6FB6F703E86436697EADCF1E3CEE23D9_89367631.addTaint(taint);
                                throw var6FB6F703E86436697EADCF1E3CEE23D9_89367631;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.072 -0400", hash_original_method = "325730E7689E55EAB909A58356E01384", hash_generated_method = "BECC5313DEA64B96DD7135AC533C3750")
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
                    RuntimeException varBAC7FC4092273E4A09516AB353844518_1876759934 = new RuntimeException("MulticastLock under-locked "
                            + mTag);
                    varBAC7FC4092273E4A09516AB353844518_1876759934.addTaint(taint);
                    throw varBAC7FC4092273E4A09516AB353844518_1876759934;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.072 -0400", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "91B8A28629F935F303A73D2F07650B69")
        public void setReferenceCounted(boolean refCounted) {
            mRefCounted = refCounted;
            // ---------- Original Method ----------
            //mRefCounted = refCounted;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.072 -0400", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "590C0545E5AAADF6EC395A742191F190")
        public boolean isHeld() {
            synchronized
(mBinder)            {
                boolean varAD25B113814807D236AFB0F5095B0005_423236792 = (mHeld);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1145976071 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1145976071;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mBinder) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.073 -0400", hash_original_method = "98C6FF6ECD72200F1F4D177BCA8A2AA1", hash_generated_method = "884E4F4462BC6630F7D40BD75B42C757")
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
String var1932DB5234F23C2D55EBC21AE51F4029_931917990 =                 "MulticastLock{ " + s1 + "; " + s2 + s3 + " }";
                var1932DB5234F23C2D55EBC21AE51F4029_931917990.addTaint(taint);
                return var1932DB5234F23C2D55EBC21AE51F4029_931917990;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.073 -0400", hash_original_method = "EEB5ECA4A52575C705D77F616153B22D", hash_generated_method = "AC7C69579F80CDA3C53C84523B03E575")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.073 -0400", hash_original_field = "D73D0D86C1025EFB856EDFE0FF5B7D26", hash_generated_field = "A61CFE599DE64B58698AA201FC982324")

    public static final int ERROR_AUTHENTICATING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.073 -0400", hash_original_field = "9A24D92AC8A9E1B7D5A312FBA6C3FD34", hash_generated_field = "9799DA49B75F0D0576BFFBB0C76088EE")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_STATE_CHANGED_ACTION =
        "android.net.wifi.WIFI_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "0944A2A65F601749B29178FEA703796B", hash_generated_field = "46567CB4BEB3DFB368FE4F8E475FB949")

    public static final String EXTRA_WIFI_STATE = "wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "7833C0EE32998283D8317C32D9B3E7E3", hash_generated_field = "D54DDD27C0FABD3E72B4463F8467DD8F")

    public static final String EXTRA_PREVIOUS_WIFI_STATE = "previous_wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "405CA49F40DDE4B13E9AC46791CA857F", hash_generated_field = "FE60C14FEA4D57BF2093A689913470B9")

    public static final int WIFI_STATE_DISABLING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "F3D1FDE24320FB177F2FEC055432E5A9", hash_generated_field = "6A5366DF6585701D33781E3066B4AFA8")

    public static final int WIFI_STATE_DISABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "7ED33E4EFFAB0957B139A4FBB46B1007", hash_generated_field = "F2ADABF7F2992B3ED65D27E20283D1F6")

    public static final int WIFI_STATE_ENABLING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "5AAFCB32A97D94C3DF5549300190AE52", hash_generated_field = "06DDD34F33E45C8F663664CD911FF5AB")

    public static final int WIFI_STATE_ENABLED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "20E5381E72985E573686190569CE5784", hash_generated_field = "E8AFD6E713201D2BE9CCD062C6A47AEA")

    public static final int WIFI_STATE_UNKNOWN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "3BE3DE3FFDA26AE538EAEBF3BB37528D", hash_generated_field = "705EDD303DB61EC718572FA5275D3C5A")

    public static final String WIFI_AP_STATE_CHANGED_ACTION =
        "android.net.wifi.WIFI_AP_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "78A247A8B44054497886DF62817F280D", hash_generated_field = "92AFA518C48CABAA417E28328E2D9063")

    public static final String EXTRA_WIFI_AP_STATE = "wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "3EF091900F15377421FA68C70BDA39AA", hash_generated_field = "7C2F550793EA245C07443AC5F1ED3AF6")

    public static final String EXTRA_PREVIOUS_WIFI_AP_STATE = "previous_wifi_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "01B486AD62C331C8F0575BAA722E72EB", hash_generated_field = "209F5C5C2CDCF7B6F64BD4ED77AD042C")

    public static final int WIFI_AP_STATE_DISABLING = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "363357D0E2171D4C81373BD6ECFBD40A", hash_generated_field = "3A49281391657B7405283CBCE0E99B88")

    public static final int WIFI_AP_STATE_DISABLED = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "B17617B0A7DD8AFB4D8AFFDC300E98F9", hash_generated_field = "43E8773A0C034F3EDE7247F857A9B19E")

    public static final int WIFI_AP_STATE_ENABLING = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "A7F8AAEF17D7E999529D1B444EDFEED8", hash_generated_field = "597700F8A65905DB8E975F1D1E5F3DA6")

    public static final int WIFI_AP_STATE_ENABLED = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "AE13D766030DC8EE1A5D3EE767A9D04F", hash_generated_field = "A8488BD2ECBA6883D2DB38AE89ACE4F5")

    public static final int WIFI_AP_STATE_FAILED = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.074 -0400", hash_original_field = "1A198E48F79AE8725FF0D5C807F4ED19", hash_generated_field = "C77032707377A2B11B3B6B5DEFFE1311")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SUPPLICANT_CONNECTION_CHANGE_ACTION =
        "android.net.wifi.supplicant.CONNECTION_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "59E876250F9DB64F3DF776B93F9FEE46", hash_generated_field = "CDBC8B7CF4D0CA98D9425D824E922C3A")

    public static final String EXTRA_SUPPLICANT_CONNECTED = "connected";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "807BAA441D8390622A11EE235111390C", hash_generated_field = "B8648E4BFBAEF813252FD594CC108B4D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String NETWORK_STATE_CHANGED_ACTION = "android.net.wifi.STATE_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "ACAA90A79946019658CF4D2C0E90FC45", hash_generated_field = "422031D57C1A9E39521E008A0CBF3B3C")

    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "E82CEDA6F1000F5BB1A0C0E74BEEBCC9", hash_generated_field = "BF57671FDC2B9ABDFAF5D8AEA7BAA947")

    public static final String EXTRA_BSSID = "bssid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "C6DEB388FDA6ECEC13A8E9F9E931E5F6", hash_generated_field = "53C2244BE022BE4A381D06DA518EB76B")

    public static final String EXTRA_WIFI_INFO = "wifiInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "8942D46952F7066FEEB3511650A276FF", hash_generated_field = "D73D816A0B7FCFD432AA984E977AC22C")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SUPPLICANT_STATE_CHANGED_ACTION =
        "android.net.wifi.supplicant.STATE_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "E872A937F83834A9AD2CB1EFACA97397", hash_generated_field = "34AA826E3AF97AB38DB470F1C5654E68")

    public static final String EXTRA_NEW_STATE = "newState";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "3F8713876D6EE32D16E68249621C644E", hash_generated_field = "DE620C91519E2A376661E1B4006EAACA")

    public static final String EXTRA_SUPPLICANT_ERROR = "supplicantError";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "76A1C57BFAA36783CA0F2362FDCDD9D2", hash_generated_field = "8B73608A4EF89D78B6901DFA0665D165")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ERROR_ACTION = "android.net.wifi.ERROR";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "50472CF4F7672EB8868BF194FAA83042", hash_generated_field = "FA40DA21A3D0B77445C4852C84BE80AE")

    public static final String EXTRA_ERROR_CODE = "errorCode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "061DFF13C86BBDB544631213B8DC3B64", hash_generated_field = "2784A14BBCACF543186CCAAD68AC111C")

    public static final int WPS_OVERLAP_ERROR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "97D33284D99C36BAA3E4DDED69B4902F", hash_generated_field = "3DEB0A15DB5D2EDEE13E62DA3FC221C7")

    public static final String CONFIGURED_NETWORKS_CHANGED_ACTION =
        "android.net.wifi.CONFIGURED_NETWORKS_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "7F6E9185E4434BAD74AF662AE13977F6", hash_generated_field = "FB9CA3626A316B66033D491508ED5D88")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.075 -0400", hash_original_field = "1BF034FB8FF23CB493A7570E76E707B3", hash_generated_field = "C71F973F8B385841B02BE2C761218AEF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String RSSI_CHANGED_ACTION = "android.net.wifi.RSSI_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "32681E7B259952DABBFA332463B2E186", hash_generated_field = "F6576C7FACD2AA843A12F433031DB417")

    public static final String EXTRA_NEW_RSSI = "newRssi";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "54C389AE7454612FCBE99FC3790B8420", hash_generated_field = "4236F79C5A13A06E052A218C87FCD7AA")

    public static final String LINK_CONFIGURATION_CHANGED_ACTION =
        "android.net.wifi.LINK_CONFIGURATION_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "DAC37E4448A17DAA0BDB854C0225CA4C", hash_generated_field = "B2AF7393288899F9C62599EE162CC59A")

    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "7DFD46BB73461CD7286B9FDCCCA83168", hash_generated_field = "2EE887A583B9775AF34213DD8E61A00E")

    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "D3B8BEB61E404158A7530123E8D2B90B", hash_generated_field = "0325C95FCCE4B351CA7FEB67F6B7BA12")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String NETWORK_IDS_CHANGED_ACTION = "android.net.wifi.NETWORK_IDS_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "9D0493DF677AC43D136AF1B2A9906E7A", hash_generated_field = "55C17055111CE4074EEDA5CECF2B3757")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK_WIFI_NETWORK = "android.net.wifi.PICK_WIFI_NETWORK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "EE31A5071A8FFC8C237208177037337D", hash_generated_field = "165D11A1ECFD913E5C1ECF94299A477E")

    public static final int WIFI_MODE_FULL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "6AF2EF647228F3AFFA250FBF39A821A2", hash_generated_field = "94C5D29C1CE510F135890C372BE94396")

    public static final int WIFI_MODE_SCAN_ONLY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "5594AE1D7ED5804C1F81383076E59588", hash_generated_field = "F3AB5F19FC3DF915800D3B2F6E33706C")

    public static final int WIFI_MODE_FULL_HIGH_PERF = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "F81929FFFE83BD457D7742224C8B0457", hash_generated_field = "9F9088C65BD4F1789D8C8FDAB77015A8")

    private static final int MIN_RSSI = -100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "0A05ECF66C34A06419B23B745B0D45B0", hash_generated_field = "7DF91D8D2EC01CB1BE1AE4CAFCD0F309")

    private static final int MAX_RSSI = -55;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "F1CCB588F4099EFB4AC3B8F9C9324E97", hash_generated_field = "B84D769DCD709B183890B60DF3C274DA")

    public static final int WIFI_FREQUENCY_BAND_AUTO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "231C9D37A8817B4D3E118BEE7D5B371A", hash_generated_field = "F498C8314733151CD8E82921B0C4E22C")

    public static final int WIFI_FREQUENCY_BAND_5GHZ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "9730084C49D6A21C62927C1102B8D657", hash_generated_field = "6A1155A1B59CAD32A0FAC3FE219F29D2")

    public static final int WIFI_FREQUENCY_BAND_2GHZ = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.076 -0400", hash_original_field = "515162F4F8CFA5B14D2FE52C022E4BE3", hash_generated_field = "9B58465EB0D92245EC9CA4D811AEC5DD")

    public static final int DATA_ACTIVITY_NOTIFICATION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "6837AC5BB2753B6857C2C1DC403A0EB3", hash_generated_field = "F4CC6307DC2FF1A2B8CB7457E8B5AD9E")

    public static final int DATA_ACTIVITY_NONE         = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "FCAF43A79A1C904023D22A7AA61F7556", hash_generated_field = "B4DF8C490A9544C3C8D4B30926E0CD7E")

    public static final int DATA_ACTIVITY_IN           = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "2DC49AD01499C1665F43DA1A6F98AC48", hash_generated_field = "E3EC39EDBEEB9E8C0DC13BD46CB864BE")

    public static final int DATA_ACTIVITY_OUT          = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "960AF15D25F61CDA2363A2691565008A", hash_generated_field = "08F2BE8A202C8F8B111FD96D48B71285")

    public static final int DATA_ACTIVITY_INOUT        = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "1A512A00EB52378D4A10EF2AA242C735", hash_generated_field = "A46B2DFFFC241E78B7C771A4BAE78A6E")

    private static final int MAX_ACTIVE_LOCKS = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "646E42B947A8F7B418092CED9A6F4C1F", hash_generated_field = "5A67FC0349394E3625D9712DFC2DD495")

    public static final int CMD_CONNECT_NETWORK             = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "8B1A0832B35C196C0DF7D0CC76CF0AE0", hash_generated_field = "46529F28CB12A06C7F56C09018C641A0")

    public static final int CMD_FORGET_NETWORK              = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "AFBB98EEEF662FFF692214621B6A1DB3", hash_generated_field = "6B8553C6C496218E9F37E094D517F7E5")

    public static final int CMD_SAVE_NETWORK                = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "D91E8B64BF9FF96B110F55329B508315", hash_generated_field = "3FB85837ABE02F19E22F86C7FD9A7CB9")

    public static final int CMD_START_WPS                   = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "16E0E8180823F20E47D9A58EF1BFC579", hash_generated_field = "5A520D736A3DF8FA576C9E8034E02305")

    public static final int CMD_DISABLE_NETWORK             = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "FBCED99560CDF828EDED1A164C8ED672", hash_generated_field = "9BB6A17346ACCF1C252A49990A8E5790")

    public static final int CMD_WPS_COMPLETED               = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "4649341BB0476ACEB21B2F7C7CE8CF57", hash_generated_field = "ECCBA1FF030DC0DEEA34AAE6ED0A8AD8")

    public static final int CMD_ENABLE_TRAFFIC_STATS_POLL   = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.077 -0400", hash_original_field = "7BF3E1A2A9B4D47471730828319ECBF1", hash_generated_field = "7A5F8E8BF9878485F2FEE42B8FB5E475")

    public static final int CMD_TRAFFIC_STATS_POLL          = 22;
}

