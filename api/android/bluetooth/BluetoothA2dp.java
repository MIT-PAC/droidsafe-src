package android.bluetooth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.696 -0400", hash_original_field = "CA257FD83AF4C9E6C265E05B6CDBF2DD", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.697 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "09949A1EC40DD93875E958A2CE8D0BE0")

    private IBluetoothA2dp mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.697 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private BluetoothAdapter mAdapter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.700 -0400", hash_original_method = "84AC70841E1DE8A91A25AE9B1E768BDD", hash_generated_method = "61A52A36C54FE64E224DA889A55AF216")
      BluetoothA2dp(Context mContext, ServiceListener l) {
        addTaint(mContext.getTaint());
        IBinder b = ServiceManager.getService(BluetoothA2dpService.BLUETOOTH_A2DP_SERVICE);
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
    if(b != null)        
        {
            mService = IBluetoothA2dp.Stub.asInterface(b);
    if(mServiceListener != null)            
            {
                mServiceListener.onServiceConnected(BluetoothProfile.A2DP, this);
            } 
        } 
        else
        {
            mService = null;
        } 
        
        
        
        
        
            
            
                
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.702 -0400", hash_original_method = "D3BF3BAE58FFF66435185BE94948ED76", hash_generated_method = "7E2810AC4BDE36569F993386C707233F")
     void close() {
        mServiceListener = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.703 -0400", hash_original_method = "700825FC4ECAB3A433DC66A7B0E84928", hash_generated_method = "6BC561424042308606A8829D537EAE7A")
    public boolean connect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("connect(" + device + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean varEBACDF479EAFFE2AD53D5370B5C3FBBE_78677819 = (mService.connect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697187786 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697187786;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1885548552 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748996623 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748996623;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_479508345 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_248187192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_248187192;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.704 -0400", hash_original_method = "55DF4D676FC35487D0748922C473702F", hash_generated_method = "4D7F455A28456AE27A8390AEAD6F600E")
    public boolean disconnect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("disconnect(" + device + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var42FFDFE107D001E4DD32E59464767CFF_69880066 = (mService.disconnect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1038614250 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1038614250;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1492513907 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1497828484 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1497828484;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_405886617 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988572837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_988572837;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.704 -0400", hash_original_method = "0ADED1F6ADFCC469E1E307997E79DBB8", hash_generated_method = "D959F70F7820BB7ED5D6549705A0D1F2")
    public List<BluetoothDevice> getConnectedDevices() {
    if(DBG)        
        log("getConnectedDevices()");
    if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> var0CBC70B0F206DDA9ED876FF389D40D78_1848198127 =                 mService.getConnectedDevices();
                var0CBC70B0F206DDA9ED876FF389D40D78_1848198127.addTaint(taint);
                return var0CBC70B0F206DDA9ED876FF389D40D78_1848198127;
            } 
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_871736586 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_871736586.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_871736586;
            } 
        } 
    if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1198343519 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1198343519.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1198343519;
        
        
        
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.705 -0400", hash_original_method = "EE46EB26B83008ABEDB21DB2056FFA88", hash_generated_method = "27120A3F3E69CDEC356A4A5950AE50F8")
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        addTaint(states[0]);
    if(DBG)        
        log("getDevicesMatchingStates()");
    if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> varD888D9FBE2025148D0FB51CF8CEE87E5_1427803289 =                 mService.getDevicesMatchingConnectionStates(states);
                varD888D9FBE2025148D0FB51CF8CEE87E5_1427803289.addTaint(taint);
                return varD888D9FBE2025148D0FB51CF8CEE87E5_1427803289;
            } 
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1852300823 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1852300823.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1852300823;
            } 
        } 
    if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_276723583 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_276723583.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_276723583;
        
        
        
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.706 -0400", hash_original_method = "B281ECAF166EAE88B310FDB0152ACEB7", hash_generated_method = "F045BC7264CAC545BA168299760AB20B")
    public int getConnectionState(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("getState(" + device + ")");
    if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                int var8DA78526B41CCAC0FE35CC7431643446_2060676814 = (mService.getConnectionState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782870951 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782870951;
            } 
            catch (RemoteException e)
            {
                int var6DC267D6C0363C5B94F222673460F45F_663569755 = (BluetoothProfile.STATE_DISCONNECTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2087871332 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2087871332;
            } 
        } 
    if(mService == null){ }        int var6DC267D6C0363C5B94F222673460F45F_1776766489 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621012990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621012990;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.706 -0400", hash_original_method = "2B40F2C1D807822C775F30BF280CDA0D", hash_generated_method = "0A196F5E1CC5AE77A67B6C2AA29B38A0")
    public boolean setPriority(BluetoothDevice device, int priority) {
        addTaint(priority);
        addTaint(device.getTaint());
    if(DBG)        
        log("setPriority(" + device + ", " + priority + ")");
    if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
    if(priority != BluetoothProfile.PRIORITY_OFF &&
                priority != BluetoothProfile.PRIORITY_ON)            
            {
                boolean var68934A3E9455FA72420237EB05902327_2048650482 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504024197 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_504024197;
            } 
            try 
            {
                boolean varC080112B655E626AEC73393AE044B4DD_286125260 = (mService.setPriority(device, priority));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155420714 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155420714;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_695791432 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1536222364 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1536222364;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_2135831059 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1903618292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1903618292;
        
        
        
            
            
                
              
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.707 -0400", hash_original_method = "23F2360BBDC60C257F7868DD2B8A1B81", hash_generated_method = "CB4A74313F901CFCD0A8B420B48E01BA")
    public int getPriority(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("getPriority(" + device + ")");
    if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                int var989DD7E44FB699D3F65CF049678ECBF2_843659785 = (mService.getPriority(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982166450 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982166450;
            } 
            catch (RemoteException e)
            {
                int var77236085A0BA5825CA2134406E964D5B_1148375010 = (BluetoothProfile.PRIORITY_OFF);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_657253919 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_657253919;
            } 
        } 
    if(mService == null){ }        int var77236085A0BA5825CA2134406E964D5B_342076919 = (BluetoothProfile.PRIORITY_OFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847279860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847279860;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.709 -0400", hash_original_method = "0A81AC976D9A0E28DF6B1DEC7E34C5D3", hash_generated_method = "E93C02D63A593BDD12D6BAFEC94413BA")
    public boolean isA2dpPlaying(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                boolean varEDFE4BB68AF8792931626E71685E8B42_1760613749 = (mService.isA2dpPlaying(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033783054 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033783054;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_846935888 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954153178 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954153178;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1921913573 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835428915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835428915;
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.710 -0400", hash_original_method = "FEE19D0C9AEE9A75BC73A57692A1B159", hash_generated_method = "8575254A81F16F35835EB711E992DD98")
    public boolean suspendSink(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                boolean varE92B4009E8F16D2C6006A12A949A6E7F_1795982306 = (mService.suspendSink(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101519371 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101519371;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_49773223 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1988115652 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1988115652;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_470698031 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130976413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130976413;
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.710 -0400", hash_original_method = "18AFE84D45293B01197D290EE720FEAA", hash_generated_method = "A753220B9C97FEF1777CB0BF5B021828")
    public boolean resumeSink(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(mService != null && isEnabled()
            && isValidDevice(device))        
        {
            try 
            {
                boolean var9DF31C17D20BD2809DBD580AE093D022_221685960 = (mService.resumeSink(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1081501691 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1081501691;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1960981441 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1266173009 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1266173009;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1228363692 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_386689049 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_386689049;
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.712 -0400", hash_original_method = "FF7FB4D142B82B6A187917634C749F84", hash_generated_method = "6CDB8A06C03130E303C5972C6CBBF187")
    public boolean shouldSendVolumeKeys(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(isEnabled() && isValidDevice(device))        
        {
            ParcelUuid[] uuids = device.getUuids();
    if(uuids == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_2005931569 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24644329 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_24644329;
            }
for(ParcelUuid uuid : uuids)
            {
    if(BluetoothUuid.isAvrcpTarget(uuid))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1947953284 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748036230 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748036230;
                } 
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1893919959 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112011651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112011651;
        
        
            
            
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.714 -0400", hash_original_method = "29CED80F2164214524C1FC1AF02F2B1A", hash_generated_method = "B1F47C33E0E8B6B4024236EE33B2EF56")
    public boolean allowIncomingConnect(BluetoothDevice device, boolean value) {
        addTaint(value);
        addTaint(device.getTaint());
    if(DBG)        
        log("allowIncomingConnect(" + device + ":" + value + ")");
        try 
        {
            boolean var0EDA640ACD066737AA0A6F2390A0185C_118644139 = (mService.allowIncomingConnect(device, value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143444335 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143444335;
        } 
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_529967010 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_860264792 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_860264792;
        } 
        
        
        
            
        
            
            
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.715 -0400", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "6DFE140901AFA8A0EBD0FE901A32D9FD")
    private boolean isEnabled() {
    if(mAdapter.getState() == BluetoothAdapter.STATE_ON)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_531274026 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1919388319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1919388319;
        }
        boolean var68934A3E9455FA72420237EB05902327_1158172703 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484881641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484881641;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.716 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "87267FE2C3818CDFA9B54E9E73A05B12")
    private boolean isValidDevice(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(device == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1031888309 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677045682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677045682;
        }
    if(BluetoothAdapter.checkBluetoothAddress(device.getAddress()))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_724295719 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670837274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670837274;
        }
        boolean var68934A3E9455FA72420237EB05902327_1289550092 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573685442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573685442;
        
        
        
        
    }

    
        private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.717 -0400", hash_original_field = "5B6C31FA9C83E6DC9196B06BC86C02C9", hash_generated_field = "E58C6B10C262D3DDCC0EFA1E2CD2ADBD")

    private static final String TAG = "BluetoothA2dp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.717 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.717 -0400", hash_original_field = "710FFCEDBB226F7143225EDB5CEA6D4C", hash_generated_field = "2C4FE2399AE2300A95A94B068FA50EDB")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.717 -0400", hash_original_field = "95B97BC08AE97748391B6C213B69D6ED", hash_generated_field = "B900F0837C67C4837BB08076612125E7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PLAYING_STATE_CHANGED =
        "android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.717 -0400", hash_original_field = "E3EB53455E6884860DCB779057FE340A", hash_generated_field = "92BD53792AEE35980F71CE5B967D3BBC")

    public static final int STATE_PLAYING   =  10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.717 -0400", hash_original_field = "65DF540099E17E30F1AC2FA7F157725D", hash_generated_field = "21A0703BC1A0A5C580A43C1F467A8E87")

    public static final int STATE_NOT_PLAYING   =  11;
}

