package android.bluetooth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.025 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.025 -0400", hash_original_field = "CA257FD83AF4C9E6C265E05B6CDBF2DD", hash_generated_field = "6FCEA0ED39BC377BA765F514A42DFCE9")

    private ServiceListener mServiceListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.025 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "79B3CF63B286D2E971AC334B507D5268")

    private IBluetoothHeadset mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.025 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "367F0BC6BC216C571A7E906A286477DF")

    BluetoothAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.028 -0400", hash_original_field = "23D4610316C4691B804316E58CB7E31E", hash_generated_field = "4C31F5F998D805D73AB7E1E7A0C93298")

    private ServiceConnection mConnection = new ServiceConnection() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.026 -0400", hash_original_method = "49B1367FF57AEC89B6CC00CC921EF188", hash_generated_method = "532E4A3B79937596CBCD7192F81D6D7F")
        public void onServiceConnected(ComponentName className, IBinder service) {
            
            addTaint(service.getTaint());
            addTaint(className.getTaint());
    if(DBG)            
            Log.d(TAG, "Proxy object connected");
            mService = IBluetoothHeadset.Stub.asInterface(service);
    if(mServiceListener != null)            
            {
                mServiceListener.onServiceConnected(BluetoothProfile.HEADSET, BluetoothHeadset.this);
            } 
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.028 -0400", hash_original_method = "5E9993D21DC5F46D871DD6D0C9DF0475", hash_generated_method = "7DBE42B6E64652795380B3C13EBF01B1")
        public void onServiceDisconnected(ComponentName className) {
            
            addTaint(className.getTaint());
    if(DBG)            
            Log.d(TAG, "Proxy object disconnected");
            mService = null;
    if(mServiceListener != null)            
            {
                mServiceListener.onServiceDisconnected(BluetoothProfile.HEADSET);
            } 
            
            
            
            
                
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.029 -0400", hash_original_method = "B2E3A495C7EEB290E3194E45B33ED96D", hash_generated_method = "52FEF32AEBCAC4D7A8F3BB472E85F97E")
      BluetoothHeadset(Context context, ServiceListener l) {
        mContext = context;
        mServiceListener = l;
        mAdapter = BluetoothAdapter.getDefaultAdapter();
    if(!context.bindService(new Intent(IBluetoothHeadset.class.getName()), mConnection, 0))        
        {
        } 
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.029 -0400", hash_original_method = "072F8B79FA7D55AD4D16BF2975AA6259", hash_generated_method = "6DF1504F89700C5086B3540A658448C4")
    synchronized void close() {
    if(DBG)        
        log("close()");
    if(mConnection != null)        
        {
            mContext.unbindService(mConnection);
            mConnection = null;
        } 
        mServiceListener = null;
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.030 -0400", hash_original_method = "7284EC53ABB82E4A2B97F7B894F0105F", hash_generated_method = "75F584E031A919982C3FC4208C59E497")
    public boolean connect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("connect(" + device + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean varEBACDF479EAFFE2AD53D5370B5C3FBBE_790492916 = (mService.connect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483945597 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_483945597;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_148986716 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1298422293 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1298422293;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1527892487 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971171679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_971171679;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.031 -0400", hash_original_method = "4AB2501852FA35F2A69CDF567F29169A", hash_generated_method = "DACB4C5A08067F1653083D494F7501FB")
    public boolean disconnect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("disconnect(" + device + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var42FFDFE107D001E4DD32E59464767CFF_1939198596 = (mService.disconnect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1286897950 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1286897950;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1152327721 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060258297 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060258297;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_656496801 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116144765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_116144765;
        
        
        
            
            
                
            
              
              
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.032 -0400", hash_original_method = "49C359566F3934D08711C62C957BAB9A", hash_generated_method = "2A121EBA11A6B1E9C6A5625FBC08F683")
    public List<BluetoothDevice> getConnectedDevices() {
    if(DBG)        
        log("getConnectedDevices()");
    if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> var0CBC70B0F206DDA9ED876FF389D40D78_1637320394 =                 mService.getConnectedDevices();
                var0CBC70B0F206DDA9ED876FF389D40D78_1637320394.addTaint(taint);
                return var0CBC70B0F206DDA9ED876FF389D40D78_1637320394;
            } 
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1040884727 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1040884727.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1040884727;
            } 
        } 
    if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1332390242 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1332390242.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1332390242;
        
        
        
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.033 -0400", hash_original_method = "E177F9FA262CA684CC709DA528C57F1A", hash_generated_method = "3E03CFDCE7B3937DC4CC69083D2A10E8")
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) {
        addTaint(states[0]);
    if(DBG)        
        log("getDevicesMatchingStates()");
    if(mService != null && isEnabled())        
        {
            try 
            {
List<BluetoothDevice> varD888D9FBE2025148D0FB51CF8CEE87E5_1510561895 =                 mService.getDevicesMatchingConnectionStates(states);
                varD888D9FBE2025148D0FB51CF8CEE87E5_1510561895.addTaint(taint);
                return varD888D9FBE2025148D0FB51CF8CEE87E5_1510561895;
            } 
            catch (RemoteException e)
            {
List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1495564840 =                 new ArrayList<BluetoothDevice>();
                var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1495564840.addTaint(taint);
                return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1495564840;
            } 
        } 
    if(mService == null){ }List<BluetoothDevice> var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1788659153 =         new ArrayList<BluetoothDevice>();
        var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1788659153.addTaint(taint);
        return var0DD13883ABBA5DF8AB8CAFEE38A3B82C_1788659153;
        
        
        
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.033 -0400", hash_original_method = "1FDB9A860CA32B38F33F04C33CC0DC9B", hash_generated_method = "5071D6AC21F3C3AB8CB9AA27C028FA4D")
    public int getConnectionState(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("getConnectionState(" + device + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                int var8DA78526B41CCAC0FE35CC7431643446_757590783 = (mService.getConnectionState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1919095997 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1919095997;
            } 
            catch (RemoteException e)
            {
                int var6DC267D6C0363C5B94F222673460F45F_2032018110 = (BluetoothProfile.STATE_DISCONNECTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356030762 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356030762;
            } 
        } 
    if(mService == null){ }        int var6DC267D6C0363C5B94F222673460F45F_379948754 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412966590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412966590;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.034 -0400", hash_original_method = "F982CE0C4DEC9189A14DF4553C949192", hash_generated_method = "786C08A72702F174CE80A692F93FAA08")
    public boolean setPriority(BluetoothDevice device, int priority) {
        addTaint(priority);
        addTaint(device.getTaint());
    if(DBG)        
        log("setPriority(" + device + ", " + priority + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
    if(priority != BluetoothProfile.PRIORITY_OFF &&
                priority != BluetoothProfile.PRIORITY_ON)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1167304036 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_606589469 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_606589469;
            } 
            try 
            {
                boolean varC080112B655E626AEC73393AE044B4DD_1829761699 = (mService.setPriority(device, priority));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562779935 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_562779935;
            } 
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_890088799 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1463374542 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1463374542;
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1740177310 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_860378280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_860378280;
        
        
        
            
            
                
              
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.035 -0400", hash_original_method = "705F88F05E8E78847084743E12D945BD", hash_generated_method = "F063206B7CD34A7ECF7AB607C07C09C7")
    public int getPriority(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("getPriority(" + device + ")");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                int var989DD7E44FB699D3F65CF049678ECBF2_945957874 = (mService.getPriority(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987314405 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987314405;
            } 
            catch (RemoteException e)
            {
                int var3FE1174696877420FC87F195627E2B08_2073025084 = (PRIORITY_OFF);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602231782 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602231782;
            } 
        } 
    if(mService == null){ }        int var3FE1174696877420FC87F195627E2B08_1603865892 = (PRIORITY_OFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888264251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888264251;
        
        
        
            
            
                
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.036 -0400", hash_original_method = "27AD2A5F99F8BC607BCDEC817A66E20B", hash_generated_method = "9C899B8178244BE9AC19F2DC85A3FF53")
    public boolean startVoiceRecognition(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("startVoiceRecognition()");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var2E6278F99540BCA7BB6D7FB7EDBA4B95_269124278 = (mService.startVoiceRecognition(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1760133495 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1760133495;
            } 
            catch (RemoteException e)
            {
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_882683223 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186067362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186067362;
        
        
        
            
            
                
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.037 -0400", hash_original_method = "9C079C73E681F82F25C06C8EF6915217", hash_generated_method = "87FEF8C5536D5D200D102FCC08E3D0B0")
    public boolean stopVoiceRecognition(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("stopVoiceRecognition()");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean var3E7D8B85DCC3BFD70D55B81AD1DA2A5A_428033573 = (mService.stopVoiceRecognition(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_320956935 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_320956935;
            } 
            catch (RemoteException e)
            {
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_2066701550 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526451919 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526451919;
        
        
        
            
            
                
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.038 -0400", hash_original_method = "B8A3B3939435110554206CE07E152F67", hash_generated_method = "FBBA10F400821EF6DD967C9478C447CB")
    public boolean isAudioConnected(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("isAudioConnected()");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                boolean varAB65A4ED5379193BE2DD7328F35729EC_124307073 = (mService.isAudioConnected(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_159532561 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_159532561;
            } 
            catch (RemoteException e)
            {
            } 
        } 
    if(mService == null){ }        boolean var68934A3E9455FA72420237EB05902327_1929434764 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81321079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_81321079;
        
        
        
            
            
              
            
              
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.040 -0400", hash_original_method = "6F6D31332C45DEAF9F6DB793EAF6FAFC", hash_generated_method = "91B7195B4C514CE23108EEAD2B8183A8")
    public int getBatteryUsageHint(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("getBatteryUsageHint()");
    if(mService != null && isEnabled() &&
            isValidDevice(device))        
        {
            try 
            {
                int var7863C8B87099F4AC407F33ED733ED7D1_1913751189 = (mService.getBatteryUsageHint(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261098509 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261098509;
            } 
            catch (RemoteException e)
            {
            } 
        } 
    if(mService == null){ }        int var6BB61E3B7BCE0931DA574D19D1D82C88_701657716 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367708778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367708778;
        
        
        
            
            
                
            
                
            
        
        
        
    }

    
        public static boolean isBluetoothVoiceDialingEnabled(Context context) {
        return context.getResources().getBoolean(
                com.android.internal.R.bool.config_bluetooth_sco_off_call);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.041 -0400", hash_original_method = "2676E323C2C9765143A21FFE59CC6873", hash_generated_method = "AE7E89499182B3F2D43D0EDA55149667")
    public boolean cancelConnectThread() {
    if(DBG)        
        log("cancelConnectThread");
    if(mService != null && isEnabled())        
        {
            try 
            {
                boolean var8F612F355507F6BF9B63952A68F95EFA_218869867 = (mService.cancelConnectThread());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1501427133 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1501427133;
            } 
            catch (RemoteException e)
            {
            } 
        } 
        else
        {
    if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } 
        boolean var68934A3E9455FA72420237EB05902327_1697297309 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_579521953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_579521953;
        
        
        
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.042 -0400", hash_original_method = "EA55CECCBAC2EAE8EDC221C89634D263", hash_generated_method = "9F0082E9E78B4FD5CCA9F9900D02FAF9")
    public boolean acceptIncomingConnect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("acceptIncomingConnect");
    if(mService != null && isEnabled())        
        {
            try 
            {
                boolean varF9C28B6E1AE85E729C6653EF3E879483_152117360 = (mService.acceptIncomingConnect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1458815454 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1458815454;
            } 
            catch (RemoteException e)
            {
            } 
        } 
        else
        {
    if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } 
        boolean var68934A3E9455FA72420237EB05902327_1066579769 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045202418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045202418;
        
        
        
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.043 -0400", hash_original_method = "6D2538BEDFF897738BE4A0A290C33070", hash_generated_method = "0CD0C68FCC1432CBBF3E2138F201D641")
    public boolean createIncomingConnect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("createIncomingConnect");
    if(mService != null && isEnabled())        
        {
            try 
            {
                boolean var9F587C777B124F841E17D9332B80F45D_2788677 = (mService.createIncomingConnect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1530135115 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1530135115;
            } 
            catch (RemoteException e)
            {
            } 
        } 
        else
        {
    if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } 
        boolean var68934A3E9455FA72420237EB05902327_1833561775 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_278987777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_278987777;
        
        
        
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.044 -0400", hash_original_method = "4505463E5EDB411267D82D01A0F1D824", hash_generated_method = "453E85461D237C75836499555A3AF865")
    public boolean rejectIncomingConnect(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("rejectIncomingConnect");
    if(mService != null)        
        {
            try 
            {
                boolean var36ABF51603D76C34EF0882E468415E22_1330374371 = (mService.rejectIncomingConnect(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_800477816 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_800477816;
            } 
            catch (RemoteException e)
            {
            } 
        } 
        else
        {
    if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } 
        boolean var68934A3E9455FA72420237EB05902327_1738728677 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656113616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656113616;
        
        
        
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.046 -0400", hash_original_method = "A8F7BAC49E734C18D4B72E93D6F191D5", hash_generated_method = "B6DFC14069A80579D65E7905AFB6F99B")
    public boolean connectHeadsetInternal(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("connectHeadsetInternal");
    if(mService != null && isEnabled())        
        {
            try 
            {
                boolean var80E81716EE61B25591D10CB023BDFE66_2139208211 = (mService.connectHeadsetInternal(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1298607191 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1298607191;
            } 
            catch (RemoteException e)
            {
            } 
        } 
        else
        {
    if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } 
        boolean var68934A3E9455FA72420237EB05902327_1981197377 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394874502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394874502;
        
        
        
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.047 -0400", hash_original_method = "DE8B58BD5456FA1A62F7BE53852C68CF", hash_generated_method = "B39C1DC7DADAE0CDEB25982726B2D992")
    public boolean disconnectHeadsetInternal(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("disconnectHeadsetInternal");
    if(mService != null && !isDisabled())        
        {
            try 
            {
                boolean var83077D59398C4B52710A7457DD863D92_1889978480 = (mService.disconnectHeadsetInternal(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476278304 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476278304;
            } 
            catch (RemoteException e)
            {
            } 
        } 
        else
        {
    if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } 
        boolean var68934A3E9455FA72420237EB05902327_200660164 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1584486002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1584486002;
        
        
        
            
                 
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.050 -0400", hash_original_method = "04E80317E50A33841443E656AF5FDA5A", hash_generated_method = "2D5383C9F493D1CC3D7389D3B5D9E610")
    public boolean setAudioState(BluetoothDevice device, int state) {
        addTaint(state);
        addTaint(device.getTaint());
    if(DBG)        
        log("setAudioState");
    if(mService != null && !isDisabled())        
        {
            try 
            {
                boolean varBF88569449B60A1ACD0300E088CD75B8_1164300086 = (mService.setAudioState(device, state));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_72036773 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_72036773;
            } 
            catch (RemoteException e)
            {
            } 
        } 
        else
        {
    if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } 
        boolean var68934A3E9455FA72420237EB05902327_365109565 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713338546 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_713338546;
        
        
        
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.052 -0400", hash_original_method = "398E968FC0AE96999E6F1C9EB97CF08A", hash_generated_method = "C777D705BECCC7C459E2D406F06D8363")
    public int getAudioState(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("getAudioState");
    if(mService != null && !isDisabled())        
        {
            try 
            {
                int var0479FBBCDD1F5B972572050DA4E69457_1586899400 = (mService.getAudioState(device));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2078598117 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2078598117;
            } 
            catch (RemoteException e)
            {
            } 
        } 
        else
        {
    if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } 
        int var16ABE844BBE5415279E6F507178331F3_1624325043 = (BluetoothHeadset.STATE_AUDIO_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194535623 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194535623;
        
        
        
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.053 -0400", hash_original_method = "D15419F6AD1B4E28C80D3421F9F86FA4", hash_generated_method = "068B420607F0A2326C7823606A503065")
    public boolean startScoUsingVirtualVoiceCall(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("startScoUsingVirtualVoiceCall()");
    if(mService != null && isEnabled() && isValidDevice(device))        
        {
            try 
            {
                boolean var85C40956CD68A2208AA5DAC2B51BA147_1244661225 = (mService.startScoUsingVirtualVoiceCall(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368805436 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368805436;
            } 
            catch (RemoteException e)
            {
            } 
        } 
        else
        {
    if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } 
        boolean var68934A3E9455FA72420237EB05902327_2026745553 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1948013252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1948013252;
        
        
        
            
                
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.054 -0400", hash_original_method = "EC64256DA9DAF95A4E5DDEFAF84087E3", hash_generated_method = "30B71C461BE91FD09FC663A8B5FD109A")
    public boolean stopScoUsingVirtualVoiceCall(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(DBG)        
        log("stopScoUsingVirtualVoiceCall()");
    if(mService != null && isEnabled() && isValidDevice(device))        
        {
            try 
            {
                boolean var758ADF01BA34BA245EB8EA65B10A7BE8_1001334192 = (mService.stopScoUsingVirtualVoiceCall(device));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700284016 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700284016;
            } 
            catch (RemoteException e)
            {
            } 
        } 
        else
        {
    if(DBG)            
            Log.d(TAG, Log.getStackTraceString(new Throwable()));
        } 
        boolean var68934A3E9455FA72420237EB05902327_1859521326 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_129507014 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_129507014;
        
        
        
            
                
            
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.055 -0400", hash_original_method = "7937BC03D2C2DD83881BE0DF65C2C1C7", hash_generated_method = "ED576B239A4B45A5FE5BF5B969BDB9A8")
    private boolean isEnabled() {
    if(mAdapter.getState() == BluetoothAdapter.STATE_ON)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1088253654 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_56192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_56192;
        }
        boolean var68934A3E9455FA72420237EB05902327_2131323307 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136871304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136871304;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.056 -0400", hash_original_method = "7FB46929D91880D43466C28024A250A9", hash_generated_method = "B2A9871719C1AE2A52A393DB6D09D9F2")
    private boolean isDisabled() {
    if(mAdapter.getState() == BluetoothAdapter.STATE_OFF)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1721628095 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627235213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627235213;
        }
        boolean var68934A3E9455FA72420237EB05902327_1300450313 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1840978969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1840978969;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.057 -0400", hash_original_method = "EB67AF48F977D4A31E9F2F2B80A49421", hash_generated_method = "606F11ABA9E0C3F55ECA0CA50E149711")
    private boolean isValidDevice(BluetoothDevice device) {
        addTaint(device.getTaint());
    if(device == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_192809669 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_49654983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_49654983;
        }
    if(BluetoothAdapter.checkBluetoothAddress(device.getAddress()))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1946988378 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_823430932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_823430932;
        }
        boolean var68934A3E9455FA72420237EB05902327_2077925434 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_622866112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_622866112;
        
        
        
        
    }

    
        private static void log(String msg) {
        Log.d(TAG, msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.057 -0400", hash_original_field = "BD04568A92F85E35CB844729F0C3A798", hash_generated_field = "EBA83525E1B94BE4C4CA3565D8D3EE9E")

    private static final String TAG = "BluetoothHeadset";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.058 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.058 -0400", hash_original_field = "672D4AAD8CD014AE5995B93963202C29", hash_generated_field = "ABC03AE60B852A1C7718E9A970BD1536")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.058 -0400", hash_original_field = "940CAC348432C44F14F723D6076DE02B", hash_generated_field = "BB784B20611B5426CFF10690920EEB5C")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AUDIO_STATE_CHANGED =
        "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.058 -0400", hash_original_field = "D35AD240456BC66A2DEC71A77CFD72A4", hash_generated_field = "AC2698553492ED5B94B3EFA99003D861")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_VENDOR_SPECIFIC_HEADSET_EVENT =
            "android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.059 -0400", hash_original_field = "B6900C9E4FC9B76BDF6B5AB64B8BD668", hash_generated_field = "BDACDE0E26600FAE1AFF6AC736C7F543")

    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.059 -0400", hash_original_field = "826CFED59CA895C44072A6FA47D4A64C", hash_generated_field = "90CECD7CE6C28ECC4D03E1709BB66CBD")

    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.059 -0400", hash_original_field = "1242AAD6D44CD5550D7F75519D18C400", hash_generated_field = "4DE453250584C7FE6B64D6AD6C961CE8")

    public static final int AT_CMD_TYPE_READ = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.059 -0400", hash_original_field = "A6619D85A8C5882C0BF260C604A3C5D5", hash_generated_field = "2C2252AE507E225BC34F7AEA44E0AC49")

    public static final int AT_CMD_TYPE_TEST = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.059 -0400", hash_original_field = "28FCFB568CDA51D4B78DB7DEB8196ED6", hash_generated_field = "357B08A29D2379204652B128913E4928")

    public static final int AT_CMD_TYPE_SET = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.060 -0400", hash_original_field = "FB9B5054C0DE574D90887E1BA046CD58", hash_generated_field = "0A95BA5CB4DD042061A85BD7515A62D7")

    public static final int AT_CMD_TYPE_BASIC = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.060 -0400", hash_original_field = "B233DD7907877A2DE6CA78439C3700A9", hash_generated_field = "8A8D2B159027C806839DD114C91E3127")

    public static final int AT_CMD_TYPE_ACTION = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.060 -0400", hash_original_field = "B5852A50D1DD83F6A07B8B93DC3AF841", hash_generated_field = "51411B886A94D1180D892E92776C02D3")

    public static final String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_ARGS =
            "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_ARGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.060 -0400", hash_original_field = "3F90B9C504BA70C93A0D9FA927F5FC63", hash_generated_field = "B5553D0E6B97FD79EBA3C206E2FF693C")

    public static final String VENDOR_SPECIFIC_HEADSET_EVENT_COMPANY_ID_CATEGORY  =
            "android.bluetooth.headset.intent.category.companyid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.060 -0400", hash_original_field = "657D1FB2064FBDA2A6DCBF26DE4BA6AC", hash_generated_field = "0D469E671F848187A0CDC591A24EABA1")

    public static final int STATE_AUDIO_DISCONNECTED = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.060 -0400", hash_original_field = "D022E3BF246E2498ECFA4C1D3CB37450", hash_generated_field = "320FBFE32BF6DC544AAED5D9A84E5DBD")

    public static final int STATE_AUDIO_CONNECTING = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.060 -0400", hash_original_field = "0C92A4FE950C78554146B5C26212EFBA", hash_generated_field = "39ACE008F53ABD81B2D9586C9128E986")

    public static final int STATE_AUDIO_CONNECTED = 12;
}

