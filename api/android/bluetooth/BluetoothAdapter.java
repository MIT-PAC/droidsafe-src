package android.bluetooth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.784 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "40876FBB70C48F89ADB2F95E8DF8AB42")

    private IBluetooth mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.784 -0400", hash_original_field = "4897335790D5679094DD492969ED75AA", hash_generated_field = "4E8B81D96B452AEF852F97E41FBCDFCC")

    private Handler mServiceRecordHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.785 -0400", hash_original_method = "5CDBAADAD73677B9DBA69CD49D17E787", hash_generated_method = "923A0760BE4D3531596C9DB925E2D2B6")
    public  BluetoothAdapter(IBluetooth service) {
    if(service == null)        
        {
            IllegalArgumentException varF7AC7A3C61DFD44AABDCE9021F9BE9CA_1940487524 = new IllegalArgumentException("service is null");
            varF7AC7A3C61DFD44AABDCE9021F9BE9CA_1940487524.addTaint(taint);
            throw varF7AC7A3C61DFD44AABDCE9021F9BE9CA_1940487524;
        } 
        mService = service;
        mServiceRecordHandler = null;
        
        
            
        
        
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.786 -0400", hash_original_method = "BAA9CF7F2ACFCBAB9569C2DACFA96981", hash_generated_method = "86B3F89BC38F3F39DA36E623397E6007")
    public BluetoothDevice getRemoteDevice(String address) {
        addTaint(address.getTaint());
BluetoothDevice varA8C88F08C60970168666AAFC50FDB9D0_1464391150 =         new BluetoothDevice(address);
        varA8C88F08C60970168666AAFC50FDB9D0_1464391150.addTaint(taint);
        return varA8C88F08C60970168666AAFC50FDB9D0_1464391150;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.786 -0400", hash_original_method = "D4868B88346C10F14C8F7C77B49B5DE2", hash_generated_method = "AB18FF8EC5A8CBF1942C7BDAF52FC3E6")
    public boolean isEnabled() {
        try 
        {
            boolean var4983BE3E160A6114C5F2C1168FF31C99_2030784217 = (mService.isEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1991810434 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1991810434;
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_1429411820 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1937774792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1937774792;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.787 -0400", hash_original_method = "FCF9C6106F07630DEF71CB873FCC3D8F", hash_generated_method = "ABC08D7B243226204C0356164FC28166")
    public int getState() {
        try 
        {
            int var2B334D76CCE2BDB5B78F0D5680DAE99D_97055548 = (mService.getBluetoothState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_417988140 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_417988140;
        } 
        catch (RemoteException e)
        {
        } 
        int var086B7832E6E767B5DF57BC1BEDB6288B_1213754562 = (STATE_OFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983784865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983784865;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.787 -0400", hash_original_method = "F70C75CE8A3147FA6677C79F04CF4B02", hash_generated_method = "69415A9479C0544C9431B9054ECBF7E4")
    public boolean enable() {
        try 
        {
            boolean var751005C663F7670EFA072318E4BBB147_1668461992 = (mService.enable());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2109747924 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2109747924;
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_651403542 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225842628 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225842628;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.788 -0400", hash_original_method = "DC1BB7EEB209838517C27214CEB71072", hash_generated_method = "239C362B792AD50168F717BC5F8E690F")
    public boolean disable() {
        try 
        {
            boolean var68FC723498B7A5700A03664DED0CF2BB_1469625830 = (mService.disable(true));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286050418 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_286050418;
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_1671738374 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197911321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197911321;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.788 -0400", hash_original_method = "45FE79E8525553C566F03D519E5189F4", hash_generated_method = "0E24EEE7A66CC2D050F7E530DECD0631")
    public String getAddress() {
        try 
        {
String var13828B60C28DDCB10C9E298867AD149C_908272689 =             mService.getAddress();
            var13828B60C28DDCB10C9E298867AD149C_908272689.addTaint(taint);
            return var13828B60C28DDCB10C9E298867AD149C_908272689;
        } 
        catch (RemoteException e)
        {
        } 
String var540C13E9E156B687226421B24F2DF178_944633816 =         null;
        var540C13E9E156B687226421B24F2DF178_944633816.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_944633816;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.789 -0400", hash_original_method = "AA5C06C383156A346DC521053F89AB2B", hash_generated_method = "BE226CD4A7D4F2CBA72628A080C9BA08")
    public String getName() {
        try 
        {
String varACE59E9AE3E1C25ADA45C88057569C87_1258861353 =             mService.getName();
            varACE59E9AE3E1C25ADA45C88057569C87_1258861353.addTaint(taint);
            return varACE59E9AE3E1C25ADA45C88057569C87_1258861353;
        } 
        catch (RemoteException e)
        {
        } 
String var540C13E9E156B687226421B24F2DF178_1370791727 =         null;
        var540C13E9E156B687226421B24F2DF178_1370791727.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1370791727;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.789 -0400", hash_original_method = "1404BBF93844A5B6047C7A268CEA1843", hash_generated_method = "0C31E0B774F96704A0D0CE7034A2860A")
    public ParcelUuid[] getUuids() {
    if(getState() != STATE_ON)        
        {
ParcelUuid[] var540C13E9E156B687226421B24F2DF178_1039407764 =         null;
        var540C13E9E156B687226421B24F2DF178_1039407764.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1039407764;
        }
        try 
        {
ParcelUuid[] var0D176EA231D9DB2C5E0E841429622377_1301266822 =             mService.getUuids();
            var0D176EA231D9DB2C5E0E841429622377_1301266822.addTaint(taint);
            return var0D176EA231D9DB2C5E0E841429622377_1301266822;
        } 
        catch (RemoteException e)
        {
        } 
ParcelUuid[] var540C13E9E156B687226421B24F2DF178_1281316479 =         null;
        var540C13E9E156B687226421B24F2DF178_1281316479.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1281316479;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.790 -0400", hash_original_method = "08F81801C25A11FE898E4D65E015413F", hash_generated_method = "29EB08C025E89A95B6FDE0DEE0D2DC58")
    public boolean setName(String name) {
        addTaint(name.getTaint());
    if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1725776651 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_992571578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_992571578;
        }
        try 
        {
            boolean var63E72F5F92D563AB016C0EC31405D265_1506350438 = (mService.setName(name));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001768080 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001768080;
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_1105710514 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236696423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236696423;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.790 -0400", hash_original_method = "76CF52E29182798DA67FD15A9B155F30", hash_generated_method = "B46C19092DBDD80865BFD2DA258B71B5")
    public int getScanMode() {
    if(getState() != STATE_ON)        
        {
        int varA1CEDDAA20CDBA863194C58B2CFCC7E4_405994016 = (SCAN_MODE_NONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685731977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685731977;
        }
        try 
        {
            int varB8CA5B84998AE66751392A9E3BE1DBAF_805561208 = (mService.getScanMode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1783379949 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1783379949;
        } 
        catch (RemoteException e)
        {
        } 
        int varA1CEDDAA20CDBA863194C58B2CFCC7E4_616959187 = (SCAN_MODE_NONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979336810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979336810;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.791 -0400", hash_original_method = "EAE2AE792A5A03E2A7F346C251F56DAF", hash_generated_method = "43A948623B5EC5D585B32F56341E1F92")
    public boolean setScanMode(int mode, int duration) {
        addTaint(duration);
        addTaint(mode);
    if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1120864262 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822528279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822528279;
        }
        try 
        {
            boolean var7B1D24A9A4CCC6C7243AB0FC62CDCE43_1363432017 = (mService.setScanMode(mode, duration));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595072502 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_595072502;
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_1100317486 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956351717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956351717;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.792 -0400", hash_original_method = "5FA36C89B86406F549228E4F23C31FB5", hash_generated_method = "6216D631D8444261FB748A4A43DAF490")
    public boolean setScanMode(int mode) {
        addTaint(mode);
    if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_534651698 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1015374096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1015374096;
        }
        boolean varDD38457F8B656D9E612A212409C7808F_359053713 = (setScanMode(mode, 120));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1800709641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1800709641;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.793 -0400", hash_original_method = "9BECEF34E1AD2659C72AC1024F8DAE1C", hash_generated_method = "4D4577CA6FA01953F91456936E2C4EF3")
    public int getDiscoverableTimeout() {
    if(getState() != STATE_ON)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_528597124 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228572325 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228572325;
        }
        try 
        {
            int varE1B8738345572D0901B5E0CC725A1459_537272134 = (mService.getDiscoverableTimeout());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1843276882 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1843276882;
        } 
        catch (RemoteException e)
        {
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1959012278 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088368368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088368368;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.794 -0400", hash_original_method = "040DE868F00C15E58DE726DEE9429CA3", hash_generated_method = "6F690F9072FD88D289A99A2F0A554F2A")
    public void setDiscoverableTimeout(int timeout) {
        addTaint(timeout);
    if(getState() != STATE_ON)        
        return;
        try 
        {
            mService.setDiscoverableTimeout(timeout);
        } 
        catch (RemoteException e)
        {
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.795 -0400", hash_original_method = "10268AD378D15FC8A51253E10EC3C6B2", hash_generated_method = "361FFF7E685022084A57ACFAB0A0003E")
    public boolean startDiscovery() {
    if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2078491195 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025988142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025988142;
        }
        try 
        {
            boolean varBF99621D08455D541D00830742175B6A_2069242641 = (mService.startDiscovery());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106112520 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_106112520;
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_1070004902 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591300229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_591300229;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.795 -0400", hash_original_method = "63E67EB5C61EED8D2B51A1BF56472E25", hash_generated_method = "C6D46E6791ED6D3B95B15B8B3E836389")
    public boolean cancelDiscovery() {
    if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1866617693 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98853795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98853795;
        }
        try 
        {
            boolean var24B8C58BBFE355AF38874A0571AD14D5_116257979 = (mService.cancelDiscovery());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1943892718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1943892718;
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_1570585957 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1100317268 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1100317268;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.796 -0400", hash_original_method = "C88946A48EEE076D7E3C1C6C5F371E49", hash_generated_method = "835634C82FCDA99AE0F142D693142820")
    public boolean isDiscovering() {
    if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_499452799 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796732964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796732964;
        }
        try 
        {
            boolean var780562F0150B90F23E039B9FA6E9FCCF_1483687877 = (mService.isDiscovering());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476795664 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_476795664;
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_22728054 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1093308129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1093308129;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.797 -0400", hash_original_method = "A20534464E90E0C8E439D633BB81432E", hash_generated_method = "C57039D5E3FC2514761B586670FAD87E")
    public Set<BluetoothDevice> getBondedDevices() {
    if(getState() != STATE_ON)        
        {
Set<BluetoothDevice> var7CC87EB030EA04400B2D3AFB878F1678_232625021 =             toDeviceSet(new String[0]);
            var7CC87EB030EA04400B2D3AFB878F1678_232625021.addTaint(taint);
            return var7CC87EB030EA04400B2D3AFB878F1678_232625021;
        } 
        try 
        {
Set<BluetoothDevice> varE2359B343EAAD093229952EED1A0151C_372950434 =             toDeviceSet(mService.listBonds());
            varE2359B343EAAD093229952EED1A0151C_372950434.addTaint(taint);
            return varE2359B343EAAD093229952EED1A0151C_372950434;
        } 
        catch (RemoteException e)
        {
        } 
Set<BluetoothDevice> var540C13E9E156B687226421B24F2DF178_1094162639 =         null;
        var540C13E9E156B687226421B24F2DF178_1094162639.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1094162639;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.797 -0400", hash_original_method = "456CF28BE83652F494DDCF30722C3BAD", hash_generated_method = "4CB0E60624939BDE3B604484FF3C4536")
    public int getConnectionState() {
    if(getState() != STATE_ON)        
        {
        int var1F640F1F529317692947FAA04DB1C39E_579390056 = (BluetoothAdapter.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790900071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790900071;
        }
        try 
        {
            int var89BBF539AAAFA06798B9D48DA63C267B_1991261187 = (mService.getAdapterConnectionState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770557504 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770557504;
        } 
        catch (RemoteException e)
        {
        } 
        int var1F640F1F529317692947FAA04DB1C39E_1937625914 = (BluetoothAdapter.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_606937181 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_606937181;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.798 -0400", hash_original_method = "0796F6753B11E4CA7CEE3403756A4526", hash_generated_method = "79BDE8D0E515D031A9E6A30BB87966E1")
    public int getProfileConnectionState(int profile) {
        addTaint(profile);
    if(getState() != STATE_ON)        
        {
        int var6DC267D6C0363C5B94F222673460F45F_1525474352 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_244647902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_244647902;
        }
        try 
        {
            int var0CA70D65B3B1B1B80DBB7215C5CEEE86_1128493269 = (mService.getProfileConnectionState(profile));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925185870 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925185870;
        } 
        catch (RemoteException e)
        {
        } 
        int var6DC267D6C0363C5B94F222673460F45F_445726924 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099273692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099273692;
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.799 -0400", hash_original_method = "71D512ADABDF23669C5DC04339CD42B4", hash_generated_method = "573650EE5C87BE85A1674A58BE4878C6")
    public BluetoothServerSocket listenUsingRfcommOn(int channel) throws IOException {
        addTaint(channel);
        BluetoothServerSocket socket = new BluetoothServerSocket(
                BluetoothSocket.TYPE_RFCOMM, true, true, channel);
        int errno = socket.mSocket.bindListen();
    if(errno != 0)        
        {
            try 
            {
                socket.close();
            } 
            catch (IOException e)
            {
            } 
            socket.mSocket.throwErrnoNative(errno);
        } 
BluetoothServerSocket varA63412D4E099639C1BBCBDC8D705186B_1475293279 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_1475293279.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_1475293279;
        
        
                
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.799 -0400", hash_original_method = "89D65DC00BFA81C813C9155DE20CC833", hash_generated_method = "8463FB4D0054A9C06346A0A072E4C955")
    public BluetoothServerSocket listenUsingRfcommWithServiceRecord(String name, UUID uuid) throws IOException {
        addTaint(uuid.getTaint());
        addTaint(name.getTaint());
BluetoothServerSocket var3EE707F51EA2594385CD32B6F83259E2_746920688 =         createNewRfcommSocketAndRecord(name, uuid, true, true);
        var3EE707F51EA2594385CD32B6F83259E2_746920688.addTaint(taint);
        return var3EE707F51EA2594385CD32B6F83259E2_746920688;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.800 -0400", hash_original_method = "67A9DCDB5D1364F0197D124A8C117BDF", hash_generated_method = "CB63F3E655D905F0F042BC049A7379F0")
    public BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord(String name, UUID uuid) throws IOException {
        addTaint(uuid.getTaint());
        addTaint(name.getTaint());
BluetoothServerSocket var05024ABE095066C27AB01BCCC3793A7A_83500723 =         createNewRfcommSocketAndRecord(name, uuid, false, false);
        var05024ABE095066C27AB01BCCC3793A7A_83500723.addTaint(taint);
        return var05024ABE095066C27AB01BCCC3793A7A_83500723;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.800 -0400", hash_original_method = "D75F65DB3EAF8C02EDFD121756834A36", hash_generated_method = "39FA326CAF899F858C9DDFDC5C9EFC58")
    public BluetoothServerSocket listenUsingEncryptedRfcommWithServiceRecord(
            String name, UUID uuid) throws IOException {
        addTaint(uuid.getTaint());
        addTaint(name.getTaint());
BluetoothServerSocket varA840502DB9CC6BBE7D7E5732FE39C01F_943970754 =         createNewRfcommSocketAndRecord(name, uuid, false, true);
        varA840502DB9CC6BBE7D7E5732FE39C01F_943970754.addTaint(taint);
        return varA840502DB9CC6BBE7D7E5732FE39C01F_943970754;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.803 -0400", hash_original_method = "ABCD96E52C8B56B2C4BF1A6AB6CFAB37", hash_generated_method = "02873EF7028AED1C4A82AC8B909B0F6A")
    private BluetoothServerSocket createNewRfcommSocketAndRecord(String name, UUID uuid,
            boolean auth, boolean encrypt) throws IOException {
        addTaint(encrypt);
        addTaint(auth);
        addTaint(uuid.getTaint());
        addTaint(name.getTaint());
        RfcommChannelPicker picker = new RfcommChannelPicker(uuid);
        BluetoothServerSocket socket;
        int channel;
        int errno;
        while
(true)        
        {
            channel = picker.nextChannel();
    if(channel == -1)            
            {
                IOException var817A124666112FE225ECD899E78D5369_1454719248 = new IOException("No available channels");
                var817A124666112FE225ECD899E78D5369_1454719248.addTaint(taint);
                throw var817A124666112FE225ECD899E78D5369_1454719248;
            } 
            socket = new BluetoothServerSocket(
                    BluetoothSocket.TYPE_RFCOMM, auth, encrypt, channel);
            errno = socket.mSocket.bindListen();
    if(errno == 0)            
            {
    if(DBG)                
                Log.d(TAG, "listening on RFCOMM channel " + channel);
                break;
            } 
            else
    if(errno == BluetoothSocket.EADDRINUSE)            
            {
    if(DBG)                
                Log.d(TAG, "RFCOMM channel " + channel + " in use");
                try 
                {
                    socket.close();
                } 
                catch (IOException e)
                {
                } 
                continue;
            } 
            else
            {
                try 
                {
                    socket.close();
                } 
                catch (IOException e)
                {
                } 
                socket.mSocket.throwErrnoNative(errno);
            } 
        } 
        int handle = -1;
        try 
        {
            handle = mService.addRfcommServiceRecord(name, new ParcelUuid(uuid), channel,
                    new Binder());
        } 
        catch (RemoteException e)
        {
        } 
    if(handle == -1)        
        {
            try 
            {
                socket.close();
            } 
            catch (IOException e)
            {
            } 
            IOException var49D6C1F0F64242D5209A78D1088C7196_586813036 = new IOException("Not able to register SDP record for " + name);
            var49D6C1F0F64242D5209A78D1088C7196_586813036.addTaint(taint);
            throw var49D6C1F0F64242D5209A78D1088C7196_586813036;
        } 
    if(mServiceRecordHandler == null)        
        {
            mServiceRecordHandler = new Handler(Looper.getMainLooper()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.803 -0400", hash_original_method = "FF0612DF3BD9B7FF527D2060CCF1E773", hash_generated_method = "0BD5BF60733B3D8A3685E449CA69EB68")
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            int handle = msg.what;
            try 
            {
    if(DBG)                
                Log.d(TAG, "Removing service record " +
                                           Integer.toHexString(handle));
                mService.removeServiceRecord(handle);
            } 
            catch (RemoteException e)
            {
            } 
            
            
            
                            
                                           
                            
                        
        }
};
        } 
        socket.setCloseHandler(mServiceRecordHandler, handle);
BluetoothServerSocket varA63412D4E099639C1BBCBDC8D705186B_1077095191 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_1077095191.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_1077095191;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.806 -0400", hash_original_method = "27EC1A367A39F94DC128CEF34B5C5DD2", hash_generated_method = "4BEAA1F297B13F9823AF4D4AE4CAEDFA")
    public BluetoothServerSocket listenUsingInsecureRfcommOn(int port) throws IOException {
        addTaint(port);
        BluetoothServerSocket socket = new BluetoothServerSocket(
                BluetoothSocket.TYPE_RFCOMM, false, false, port);
        int errno = socket.mSocket.bindListen();
    if(errno != 0)        
        {
            try 
            {
                socket.close();
            } 
            catch (IOException e)
            {
            } 
            socket.mSocket.throwErrnoNative(errno);
        } 
BluetoothServerSocket varA63412D4E099639C1BBCBDC8D705186B_721241557 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_721241557.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_721241557;
        
        
                
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.807 -0400", hash_original_method = "7C75ECDC8A8B7963B0A9DF6AD0038A85", hash_generated_method = "474EE2B8EEAC9D919EB313D7A3CCA5EA")
    public BluetoothServerSocket listenUsingEncryptedRfcommOn(int port) throws IOException {
        addTaint(port);
        BluetoothServerSocket socket = new BluetoothServerSocket(
                BluetoothSocket.TYPE_RFCOMM, false, true, port);
        int errno = socket.mSocket.bindListen();
    if(errno != 0)        
        {
            try 
            {
                socket.close();
            } 
            catch (IOException e)
            {
            } 
            socket.mSocket.throwErrnoNative(errno);
        } 
BluetoothServerSocket varA63412D4E099639C1BBCBDC8D705186B_480486913 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_480486913.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_480486913;
        
        
                
        
        
            
                
            
            
        
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.809 -0400", hash_original_method = "ABFDDF29A52D91D363C001D4DD695916", hash_generated_method = "317FC7E6C33326082EA2B0124556C22D")
    public Pair<byte[], byte[]> readOutOfBandData() {
    if(getState() != STATE_ON)        
        {
Pair<byte[], byte[]> var540C13E9E156B687226421B24F2DF178_1976253352 =         null;
        var540C13E9E156B687226421B24F2DF178_1976253352.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1976253352;
        }
        try 
        {
            byte[] hash;
            byte[] randomizer;
            byte[] ret = mService.readOutOfBandData();
    if(ret  == null || ret.length != 32)            
            {
Pair<byte[], byte[]> var540C13E9E156B687226421B24F2DF178_327803791 =             null;
            var540C13E9E156B687226421B24F2DF178_327803791.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_327803791;
            }
            hash = Arrays.copyOfRange(ret, 0, 16);
            randomizer = Arrays.copyOfRange(ret, 16, 32);
    if(DBG)            
            {
                Log.d(TAG, "readOutOfBandData:" + Arrays.toString(hash) +
                  ":" + Arrays.toString(randomizer));
            } 
Pair<byte[], byte[]> varA95A3D48A90C7F180DAC8D6CC18BFF1D_1448990941 =             new Pair<byte[], byte[]>(hash, randomizer);
            varA95A3D48A90C7F180DAC8D6CC18BFF1D_1448990941.addTaint(taint);
            return varA95A3D48A90C7F180DAC8D6CC18BFF1D_1448990941;
        } 
        catch (RemoteException e)
        {
        } 
Pair<byte[], byte[]> var540C13E9E156B687226421B24F2DF178_1962208414 =         null;
        var540C13E9E156B687226421B24F2DF178_1962208414.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1962208414;
        
        
        
            
            
            
            
            
            
            
                
                  
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.810 -0400", hash_original_method = "7E4371B1FE17235BDA29BC99978F2247", hash_generated_method = "70C37946DC61CEECC0D7001D47550471")
    public boolean getProfileProxy(Context context, BluetoothProfile.ServiceListener listener,
                                   int profile) {
        addTaint(profile);
        addTaint(listener.getTaint());
        addTaint(context.getTaint());
    if(context == null || listener == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1158852848 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252831546 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_252831546;
        }
    if(profile == BluetoothProfile.HEADSET)        
        {
            BluetoothHeadset headset = new BluetoothHeadset(context, listener);
            boolean varB326B5062B2F0E69046810717534CB09_1236519279 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_600059615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_600059615;
        } 
        else
    if(profile == BluetoothProfile.A2DP)        
        {
            BluetoothA2dp a2dp = new BluetoothA2dp(context, listener);
            boolean varB326B5062B2F0E69046810717534CB09_92225754 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822884463 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822884463;
        } 
        else
    if(profile == BluetoothProfile.INPUT_DEVICE)        
        {
            BluetoothInputDevice iDev = new BluetoothInputDevice(context, listener);
            boolean varB326B5062B2F0E69046810717534CB09_1013221796 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_84315332 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_84315332;
        } 
        else
    if(profile == BluetoothProfile.PAN)        
        {
            BluetoothPan pan = new BluetoothPan(context, listener);
            boolean varB326B5062B2F0E69046810717534CB09_2013499869 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_840828984 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_840828984;
        } 
        else
    if(profile == BluetoothProfile.HEALTH)        
        {
            BluetoothHealth health = new BluetoothHealth(context, listener);
            boolean varB326B5062B2F0E69046810717534CB09_1077506705 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533211852 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_533211852;
        } 
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_275528008 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2041920435 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2041920435;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.811 -0400", hash_original_method = "C3F4A021A34A1F5D994F708A9A411E49", hash_generated_method = "CAB6AE6FD56BC92B5E5FDAFA853F0AF8")
    public void closeProfileProxy(int profile, BluetoothProfile proxy) {
        addTaint(proxy.getTaint());
        addTaint(profile);
    if(proxy == null)        
        return;
switch(profile){
        case BluetoothProfile.HEADSET:
        BluetoothHeadset headset = (BluetoothHeadset)proxy;
        headset.close();
        break;
        case BluetoothProfile.A2DP:
        BluetoothA2dp a2dp = (BluetoothA2dp)proxy;
        a2dp.close();
        break;
        case BluetoothProfile.INPUT_DEVICE:
        BluetoothInputDevice iDev = (BluetoothInputDevice)proxy;
        iDev.close();
        break;
        case BluetoothProfile.PAN:
        BluetoothPan pan = (BluetoothPan)proxy;
        pan.close();
        break;
        case BluetoothProfile.HEALTH:
        BluetoothHealth health = (BluetoothHealth)proxy;
        health.close();
        break;
}
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.812 -0400", hash_original_method = "A99B511CC77AEC21CDC5C0D9EF322DC5", hash_generated_method = "729761C70BF3F8E015FC3DB7F48BBE7D")
    public boolean changeApplicationBluetoothState(boolean on,
                                                   BluetoothStateChangeCallback callback) {
        addTaint(callback.getTaint());
        addTaint(on);
    if(callback == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1245534136 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953524307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_953524307;
        }
        try 
        {
            boolean var296BD035DD8DE34572CEB9D119011347_2050898509 = (mService.changeApplicationBluetoothState(on, new
                    StateChangeCallbackWrapper(callback), new Binder()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_229050643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_229050643;
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_549666114 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_734031793 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_734031793;
        
        
        
            
                    
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.813 -0400", hash_original_method = "513CC86480EBB28E1771EE0ECDF9AF42", hash_generated_method = "2E8669C30D512882596E4B9A66EBC71E")
    private Set<BluetoothDevice> toDeviceSet(String[] addresses) {
        addTaint(addresses[0].getTaint());
        Set<BluetoothDevice> devices = new HashSet<BluetoothDevice>(addresses.length);
for(int i = 0;i < addresses.length;i++)
        {
            devices.add(getRemoteDevice(addresses[i]));
        } 
Set<BluetoothDevice> var32AED13893C8FE4C204BFFE342C4B1B8_1587652002 =         Collections.unmodifiableSet(devices);
        var32AED13893C8FE4C204BFFE342C4B1B8_1587652002.addTaint(taint);
        return var32AED13893C8FE4C204BFFE342C4B1B8_1587652002;
        
        
        
            
        
        
    }

    
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.815 -0400", hash_original_field = "56278F1BC8E273243C72753A9B24D943", hash_generated_field = "1480456E24B96E56BF1C53CE053D6C57")

        private LinkedList<Integer> mChannels;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.815 -0400", hash_original_field = "6D1083D630EED7814896F0D75349A34B", hash_generated_field = "318090B38C1325AB0A6BDE7565479F55")

        private UUID mUuid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.817 -0400", hash_original_method = "28D5B18AE357E7C373AB413DE32AB5A2", hash_generated_method = "42EE177EE930235F899EEB09E2052EC9")
        public  RfcommChannelPicker(UUID uuid) {
            synchronized
(RfcommChannelPicker.class)            {
    if(sChannels == null)                
                {
                    sChannels = new LinkedList<Integer>();
for(int i = 1;i <= BluetoothSocket.MAX_RFCOMM_CHANNEL;i++)
                    {
                        sChannels.addLast(new Integer(i));
                    } 
for(int reserved : RESERVED_RFCOMM_CHANNELS)
                    {
                        sChannels.remove(new Integer(reserved));
                    } 
                    sRandom = new Random();
                } 
                mChannels = (LinkedList<Integer>)sChannels.clone();
            } 
            mUuid = uuid;
            
            
                
                    
                    
                        
                    
                    
                        
                    
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.818 -0400", hash_original_method = "81BCBA018F169CE48612651EBB944AF7", hash_generated_method = "3186179F996C67C57DD91667E4BA8940")
        public int nextChannel() {
    if(mChannels.size() == 0)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_405291846 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888097334 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888097334;
            } 
            int varA376C04E532E2783FDA95959A08257BE_630023186 = (mChannels.remove(sRandom.nextInt(mChannels.size())));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799128873 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799128873;
            
            
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.818 -0400", hash_original_field = "85DCCAEA585C9B4E6F240D0A0175374A", hash_generated_field = "A260FC333D7D19144D063EA361E7F085")

        private static final int[] RESERVED_RFCOMM_CHANNELS = new int[] {
            10,  
            11,  
            12,  
            19,  
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.819 -0400", hash_original_field = "31E97CDBA7EFB3E4452049029D3BD620", hash_generated_field = "EAB378A7CC265D715759023A5AA5F13F")

        private static LinkedList<Integer> sChannels;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.819 -0400", hash_original_field = "DA6A95610AF6CFF99C6F1D09E1E56D06", hash_generated_field = "62AF39559879372551FBEA5130DF03B8")

        private static Random sRandom;
    }


    
    public class StateChangeCallbackWrapper extends IBluetoothStateChangeCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.819 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "A57455FF422F35D91E260F65043C7D89")

        private BluetoothStateChangeCallback mCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.819 -0400", hash_original_method = "A0CF36872107300FB780BF535F8F7268", hash_generated_method = "752E88FB50F1EB2CC75629594B1B73B5")
          StateChangeCallbackWrapper(BluetoothStateChangeCallback
                callback) {
            mCallback = callback;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.820 -0400", hash_original_method = "A0576354509BA338556525A396FF4F6A", hash_generated_method = "B57E300F8427C46DB1C911A50605A193")
        @Override
        public void onBluetoothStateChange(boolean on) {
            
            addTaint(on);
            mCallback.onBluetoothStateChange(on);
            
            
        }

        
    }


    
    public interface BluetoothStateChangeCallback {
        public void onBluetoothStateChange(boolean on);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.820 -0400", hash_original_field = "E5B219C7FEED88DB7F5399CF079A118F", hash_generated_field = "FFFD667AA4E6F86F94D79F85ECFC7E6D")

    private static final String TAG = "BluetoothAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.820 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.821 -0400", hash_original_field = "5AB9C566BA0BF4C0BC165F176F8A6669", hash_generated_field = "6AF8DDE3A6777A538F89C7DEB17C8CE1")

    public static final int ERROR = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.821 -0400", hash_original_field = "3AB282C61CADC4E1F512891196CC6E2C", hash_generated_field = "5A65F3D9BB4DC5EE1ACABB74F4D18B98")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_STATE_CHANGED =
            "android.bluetooth.adapter.action.STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.821 -0400", hash_original_field = "B19E90743E46DF6F2A6518E33FAFE704", hash_generated_field = "3A8F0DB6CD97AEFE65404050A24D57D6")

    public static final String EXTRA_STATE =
            "android.bluetooth.adapter.extra.STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.821 -0400", hash_original_field = "D33E66DF36BC6E913E9B0A30A31CAFD9", hash_generated_field = "098410645A4730D25E72FBEEA0EBA213")

    public static final String EXTRA_PREVIOUS_STATE =
            "android.bluetooth.adapter.extra.PREVIOUS_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.821 -0400", hash_original_field = "F2BA1189D66798C5C9E28C3F0E29AAEF", hash_generated_field = "2492744ADB13576C94E35244EFC60698")

    public static final int STATE_OFF = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.821 -0400", hash_original_field = "605D5F48DA9575FBAD04C22948B589ED", hash_generated_field = "45415AACDC0741F932680326DAEA7F57")

    public static final int STATE_TURNING_ON = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.821 -0400", hash_original_field = "2823B51CEBD1F668B2D995E1B1631DE2", hash_generated_field = "340CAEE29AEFA1ABD8C4C313C4031A11")

    public static final int STATE_ON = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.821 -0400", hash_original_field = "AD9E665D9D9EE8B9123C20C0E39477EF", hash_generated_field = "91D0FBAD29D8289C8DA9131914260E33")

    public static final int STATE_TURNING_OFF = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.822 -0400", hash_original_field = "C7838C3AA721CFD286AF6DFE48A16AB1", hash_generated_field = "E66A7598AB7D1F40474FB8CB4B9F29EC")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_REQUEST_DISCOVERABLE =
            "android.bluetooth.adapter.action.REQUEST_DISCOVERABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.822 -0400", hash_original_field = "3D26FB4A99C70F031C238F081ADA951A", hash_generated_field = "C3FF7E67DDBDF7B18E42691E003AD77D")

    public static final String EXTRA_DISCOVERABLE_DURATION =
            "android.bluetooth.adapter.extra.DISCOVERABLE_DURATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.822 -0400", hash_original_field = "EC25ECA9455F985693786E1F8AB53CFF", hash_generated_field = "8BE216E12192E77765DCF2441EA0666F")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_REQUEST_ENABLE =
            "android.bluetooth.adapter.action.REQUEST_ENABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.822 -0400", hash_original_field = "A51D0480E64772A55B460C63900F3963", hash_generated_field = "6018A97AE0B0501F7D8F354A46F12C4A")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCAN_MODE_CHANGED =
            "android.bluetooth.adapter.action.SCAN_MODE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.822 -0400", hash_original_field = "E605E9682827A4B0A7412B7F2C71DDA9", hash_generated_field = "E3AFC80C21F6F85837BE05DF19B0CF20")

    public static final String EXTRA_SCAN_MODE = "android.bluetooth.adapter.extra.SCAN_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.822 -0400", hash_original_field = "A3BC40D09C9B188BA7CF938F189E0FC3", hash_generated_field = "517F6F861E87657DEE5840B6E4814935")

    public static final String EXTRA_PREVIOUS_SCAN_MODE =
            "android.bluetooth.adapter.extra.PREVIOUS_SCAN_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.822 -0400", hash_original_field = "DDCBE28C85DE1AF89DE31E4FEF94BCB9", hash_generated_field = "BC414FEE775A8ACF5083694FB05C9DAD")

    public static final int SCAN_MODE_NONE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.822 -0400", hash_original_field = "DD7046A2D1B48ECB2578F6FAFE3033E3", hash_generated_field = "9A2023C029A688C61AF0AFB65BB59898")

    public static final int SCAN_MODE_CONNECTABLE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.823 -0400", hash_original_field = "306ADEE0D99C10D2C3F1DBCC28CE1031", hash_generated_field = "84C8E5952616DC34E8514798F84FF7CC")

    public static final int SCAN_MODE_CONNECTABLE_DISCOVERABLE = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.823 -0400", hash_original_field = "D993C840F07CBC812EC7C8EF0555F0B9", hash_generated_field = "2FFDB6078656359E095CF8DDA030577E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DISCOVERY_STARTED =
            "android.bluetooth.adapter.action.DISCOVERY_STARTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.823 -0400", hash_original_field = "CAE947F91A835371C3BC0C6DFCF14D7A", hash_generated_field = "C7669A14687A25449EC9A09E5FF5CB75")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DISCOVERY_FINISHED =
            "android.bluetooth.adapter.action.DISCOVERY_FINISHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.823 -0400", hash_original_field = "C3194CF52F26B3ECD3376886AC513B6A", hash_generated_field = "EEA8D509F766113EFBE364F807BA0A7F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_LOCAL_NAME_CHANGED =
            "android.bluetooth.adapter.action.LOCAL_NAME_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.823 -0400", hash_original_field = "473D77A718344FC564A43A3F835ABC09", hash_generated_field = "7052E6CE58614BD821917BC7308EEA5A")

    public static final String EXTRA_LOCAL_NAME = "android.bluetooth.adapter.extra.LOCAL_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.823 -0400", hash_original_field = "EFF2719457B3D26AC78B8F8219CB95B2", hash_generated_field = "922348319A52FBC21E79D50738C951E7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.823 -0400", hash_original_field = "E46BA6434A04E096D6171CDD7C97AE62", hash_generated_field = "1D3AAB8543C4C934AB7CEF233BD62CE4")

    public static final String EXTRA_CONNECTION_STATE =
        "android.bluetooth.adapter.extra.CONNECTION_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.823 -0400", hash_original_field = "407A73B6D95C44B7D5905E0A6913F591", hash_generated_field = "CB9396A90BE9EE705FF77742B2727CEA")

    public static final String EXTRA_PREVIOUS_CONNECTION_STATE =
          "android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.824 -0400", hash_original_field = "2D50E5D85E482FA800E087638A951161", hash_generated_field = "84173E1866F23EE943EF8008ED8CFAFC")

    public static final int STATE_DISCONNECTED  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.824 -0400", hash_original_field = "D535FF7624C6447AFFCBE6542703375F", hash_generated_field = "8CB4E5E77EC98D8CA7B9ED27A25245FB")

    public static final int STATE_CONNECTING    = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.824 -0400", hash_original_field = "C08867EE19B193B18FAEE380F460DEBA", hash_generated_field = "3F851151E1E65F1A69352C1A55C34451")

    public static final int STATE_CONNECTED     = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.824 -0400", hash_original_field = "679A7218E870C82A9EAE6C14FFDE108F", hash_generated_field = "CDC0147D8DF471B389406236B4CDE4C6")

    public static final int STATE_DISCONNECTING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.824 -0400", hash_original_field = "C7432917623607E06320445454C2A3B8", hash_generated_field = "3D6035B10EF8E7EF00722E60E1BC0101")

    public static final String BLUETOOTH_SERVICE = "bluetooth";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.824 -0400", hash_original_field = "65464FBE0B2850776189D4464C82B733", hash_generated_field = "4E1CB78F3E71AAE2C4C5EEAF9B65762C")

    private static final int ADDRESS_LENGTH = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.824 -0400", hash_original_field = "A437836ADAE531779FE0DF7D1A772174", hash_generated_field = "774AD1565F074633E7FB49926516258A")

    private static BluetoothAdapter sAdapter;
}

