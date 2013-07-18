package android.bluetooth;

// Droidsafe Imports
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

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
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public final class BluetoothAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.993 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "40876FBB70C48F89ADB2F95E8DF8AB42")

    private IBluetooth mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.994 -0400", hash_original_field = "4897335790D5679094DD492969ED75AA", hash_generated_field = "4E8B81D96B452AEF852F97E41FBCDFCC")

    private Handler mServiceRecordHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.994 -0400", hash_original_method = "5CDBAADAD73677B9DBA69CD49D17E787", hash_generated_method = "8B970260DC247EBB28E12BF3BB9CECD0")
    public  BluetoothAdapter(IBluetooth service) {
        if(service == null)        
        {
            IllegalArgumentException varF7AC7A3C61DFD44AABDCE9021F9BE9CA_1492067650 = new IllegalArgumentException("service is null");
            varF7AC7A3C61DFD44AABDCE9021F9BE9CA_1492067650.addTaint(taint);
            throw varF7AC7A3C61DFD44AABDCE9021F9BE9CA_1492067650;
        } //End block
        mService = service;
        mServiceRecordHandler = null;
        // ---------- Original Method ----------
        //if (service == null) {
            //throw new IllegalArgumentException("service is null");
        //}
        //mService = service;
        //mServiceRecordHandler = null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.996 -0400", hash_original_method = "BAA9CF7F2ACFCBAB9569C2DACFA96981", hash_generated_method = "3BC90A8B06DAF9BCEA7C32471E4C702E")
    public BluetoothDevice getRemoteDevice(String address) {
        addTaint(address.getTaint());
BluetoothDevice varA8C88F08C60970168666AAFC50FDB9D0_236867484 =         new BluetoothDevice(address);
        varA8C88F08C60970168666AAFC50FDB9D0_236867484.addTaint(taint);
        return varA8C88F08C60970168666AAFC50FDB9D0_236867484;
        // ---------- Original Method ----------
        //return new BluetoothDevice(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.997 -0400", hash_original_method = "D4868B88346C10F14C8F7C77B49B5DE2", hash_generated_method = "299819F3926B71687D82C491ABF71C5D")
    public boolean isEnabled() {
        try 
        {
            boolean var4983BE3E160A6114C5F2C1168FF31C99_1320302306 = (mService.isEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496271794 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496271794;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_411909298 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_856004892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_856004892;
        // ---------- Original Method ----------
        //try {
            //return mService.isEnabled();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.998 -0400", hash_original_method = "FCF9C6106F07630DEF71CB873FCC3D8F", hash_generated_method = "2E79D02AF31D3DDD6D03E2464CF4DF09")
    public int getState() {
        try 
        {
            int var2B334D76CCE2BDB5B78F0D5680DAE99D_1302249195 = (mService.getBluetoothState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092441262 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092441262;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var086B7832E6E767B5DF57BC1BEDB6288B_105724569 = (STATE_OFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670929556 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670929556;
        // ---------- Original Method ----------
        //try {
            //return mService.getBluetoothState();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return STATE_OFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.999 -0400", hash_original_method = "F70C75CE8A3147FA6677C79F04CF4B02", hash_generated_method = "D0E832C0B2EF7AB5695D9591199C5161")
    public boolean enable() {
        try 
        {
            boolean var751005C663F7670EFA072318E4BBB147_449543422 = (mService.enable());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1878467241 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1878467241;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_140205075 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485255051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485255051;
        // ---------- Original Method ----------
        //try {
            //return mService.enable();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.000 -0400", hash_original_method = "DC1BB7EEB209838517C27214CEB71072", hash_generated_method = "432FD1A21A5A1F3B1C7CE99E84D6DC24")
    public boolean disable() {
        try 
        {
            boolean var68FC723498B7A5700A03664DED0CF2BB_929086429 = (mService.disable(true));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671559379 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671559379;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1664642898 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1478561008 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1478561008;
        // ---------- Original Method ----------
        //try {
            //return mService.disable(true);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.001 -0400", hash_original_method = "45FE79E8525553C566F03D519E5189F4", hash_generated_method = "07BF2263BAC66E71269921CA2CFF0C92")
    public String getAddress() {
        try 
        {
String var13828B60C28DDCB10C9E298867AD149C_1978199561 =             mService.getAddress();
            var13828B60C28DDCB10C9E298867AD149C_1978199561.addTaint(taint);
            return var13828B60C28DDCB10C9E298867AD149C_1978199561;
        } //End block
        catch (RemoteException e)
        {
        } //End block
String var540C13E9E156B687226421B24F2DF178_1372111249 =         null;
        var540C13E9E156B687226421B24F2DF178_1372111249.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1372111249;
        // ---------- Original Method ----------
        //try {
            //return mService.getAddress();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.002 -0400", hash_original_method = "AA5C06C383156A346DC521053F89AB2B", hash_generated_method = "F2F2D76E6DB90B0A350D730DBCCA137D")
    public String getName() {
        try 
        {
String varACE59E9AE3E1C25ADA45C88057569C87_1449226774 =             mService.getName();
            varACE59E9AE3E1C25ADA45C88057569C87_1449226774.addTaint(taint);
            return varACE59E9AE3E1C25ADA45C88057569C87_1449226774;
        } //End block
        catch (RemoteException e)
        {
        } //End block
String var540C13E9E156B687226421B24F2DF178_1442591724 =         null;
        var540C13E9E156B687226421B24F2DF178_1442591724.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1442591724;
        // ---------- Original Method ----------
        //try {
            //return mService.getName();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.003 -0400", hash_original_method = "1404BBF93844A5B6047C7A268CEA1843", hash_generated_method = "3736097BA2785F54E57CE7FC0E2B8A89")
    public ParcelUuid[] getUuids() {
        if(getState() != STATE_ON)        
        {
ParcelUuid[] var540C13E9E156B687226421B24F2DF178_1159898855 =         null;
        var540C13E9E156B687226421B24F2DF178_1159898855.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1159898855;
        }
        try 
        {
ParcelUuid[] var0D176EA231D9DB2C5E0E841429622377_455157475 =             mService.getUuids();
            var0D176EA231D9DB2C5E0E841429622377_455157475.addTaint(taint);
            return var0D176EA231D9DB2C5E0E841429622377_455157475;
        } //End block
        catch (RemoteException e)
        {
        } //End block
ParcelUuid[] var540C13E9E156B687226421B24F2DF178_1745016148 =         null;
        var540C13E9E156B687226421B24F2DF178_1745016148.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1745016148;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return null;
        //try {
            //return mService.getUuids();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.003 -0400", hash_original_method = "08F81801C25A11FE898E4D65E015413F", hash_generated_method = "59741371900B0360B8F2F6FCFF20955F")
    public boolean setName(String name) {
        addTaint(name.getTaint());
        if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_874803047 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1548600958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1548600958;
        }
        try 
        {
            boolean var63E72F5F92D563AB016C0EC31405D265_1005238416 = (mService.setName(name));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855786619 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_855786619;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1498540653 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322089108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322089108;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //try {
            //return mService.setName(name);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.004 -0400", hash_original_method = "76CF52E29182798DA67FD15A9B155F30", hash_generated_method = "5CEB29684D98BBDE2FC5B261BA29ABCD")
    public int getScanMode() {
        if(getState() != STATE_ON)        
        {
        int varA1CEDDAA20CDBA863194C58B2CFCC7E4_151982041 = (SCAN_MODE_NONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142964030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142964030;
        }
        try 
        {
            int varB8CA5B84998AE66751392A9E3BE1DBAF_391051271 = (mService.getScanMode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108889481 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108889481;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int varA1CEDDAA20CDBA863194C58B2CFCC7E4_1423840246 = (SCAN_MODE_NONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630243660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630243660;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return SCAN_MODE_NONE;
        //try {
            //return mService.getScanMode();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return SCAN_MODE_NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.005 -0400", hash_original_method = "EAE2AE792A5A03E2A7F346C251F56DAF", hash_generated_method = "3836BDE25B638DE1A6B698C33D44F8B4")
    public boolean setScanMode(int mode, int duration) {
        addTaint(duration);
        addTaint(mode);
        if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1401923018 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1413436863 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1413436863;
        }
        try 
        {
            boolean var7B1D24A9A4CCC6C7243AB0FC62CDCE43_1924916999 = (mService.setScanMode(mode, duration));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1655358346 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1655358346;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2145361780 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_848192378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_848192378;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //try {
            //return mService.setScanMode(mode, duration);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.006 -0400", hash_original_method = "5FA36C89B86406F549228E4F23C31FB5", hash_generated_method = "6C90D87F8D3D742BB03486F4CF8CEAB5")
    public boolean setScanMode(int mode) {
        addTaint(mode);
        if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1831417279 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628345432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628345432;
        }
        boolean varDD38457F8B656D9E612A212409C7808F_1670043724 = (setScanMode(mode, 120));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1492297521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1492297521;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //return setScanMode(mode, 120);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.006 -0400", hash_original_method = "9BECEF34E1AD2659C72AC1024F8DAE1C", hash_generated_method = "5D29E8F74712BBF3C6AE67D6203A916C")
    public int getDiscoverableTimeout() {
        if(getState() != STATE_ON)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1467045327 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001230515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001230515;
        }
        try 
        {
            int varE1B8738345572D0901B5E0CC725A1459_1072203506 = (mService.getDiscoverableTimeout());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466159171 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466159171;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_971743469 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099784479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099784479;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return -1;
        //try {
            //return mService.getDiscoverableTimeout();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.007 -0400", hash_original_method = "040DE868F00C15E58DE726DEE9429CA3", hash_generated_method = "6F690F9072FD88D289A99A2F0A554F2A")
    public void setDiscoverableTimeout(int timeout) {
        addTaint(timeout);
        if(getState() != STATE_ON)        
        return;
        try 
        {
            mService.setDiscoverableTimeout(timeout);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return;
        //try {
            //mService.setDiscoverableTimeout(timeout);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.008 -0400", hash_original_method = "10268AD378D15FC8A51253E10EC3C6B2", hash_generated_method = "B9D7352B657CF65D674E3BDFC3C5E3CD")
    public boolean startDiscovery() {
        if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1791844300 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2114537898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2114537898;
        }
        try 
        {
            boolean varBF99621D08455D541D00830742175B6A_189125761 = (mService.startDiscovery());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687224999 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687224999;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1414015657 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744950777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_744950777;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //try {
            //return mService.startDiscovery();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.010 -0400", hash_original_method = "63E67EB5C61EED8D2B51A1BF56472E25", hash_generated_method = "844EA85CE80DE5945AC810EE92FB2B3B")
    public boolean cancelDiscovery() {
        if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_685631944 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179263484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179263484;
        }
        try 
        {
            boolean var24B8C58BBFE355AF38874A0571AD14D5_1813911660 = (mService.cancelDiscovery());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742065399 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_742065399;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_338734802 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194331882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_194331882;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //try {
            //return mService.cancelDiscovery();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.011 -0400", hash_original_method = "C88946A48EEE076D7E3C1C6C5F371E49", hash_generated_method = "2E55BF93DCF74FF13634E323329BF91A")
    public boolean isDiscovering() {
        if(getState() != STATE_ON)        
        {
        boolean var68934A3E9455FA72420237EB05902327_196859093 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1388993706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1388993706;
        }
        try 
        {
            boolean var780562F0150B90F23E039B9FA6E9FCCF_598487516 = (mService.isDiscovering());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114614253 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_114614253;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_695909818 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1880465529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1880465529;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return false;
        //try {
            //return mService.isDiscovering();
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.011 -0400", hash_original_method = "A20534464E90E0C8E439D633BB81432E", hash_generated_method = "51C8AE64CD9AC174D35DE61E69B42C79")
    public Set<BluetoothDevice> getBondedDevices() {
        if(getState() != STATE_ON)        
        {
Set<BluetoothDevice> var7CC87EB030EA04400B2D3AFB878F1678_2134220653 =             toDeviceSet(new String[0]);
            var7CC87EB030EA04400B2D3AFB878F1678_2134220653.addTaint(taint);
            return var7CC87EB030EA04400B2D3AFB878F1678_2134220653;
        } //End block
        try 
        {
Set<BluetoothDevice> varE2359B343EAAD093229952EED1A0151C_20785153 =             toDeviceSet(mService.listBonds());
            varE2359B343EAAD093229952EED1A0151C_20785153.addTaint(taint);
            return varE2359B343EAAD093229952EED1A0151C_20785153;
        } //End block
        catch (RemoteException e)
        {
        } //End block
Set<BluetoothDevice> var540C13E9E156B687226421B24F2DF178_1711038359 =         null;
        var540C13E9E156B687226421B24F2DF178_1711038359.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1711038359;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) {
            //return toDeviceSet(new String[0]);
        //}
        //try {
            //return toDeviceSet(mService.listBonds());
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.012 -0400", hash_original_method = "456CF28BE83652F494DDCF30722C3BAD", hash_generated_method = "6D74CDA586A6A6929A99DD4D6C6393C2")
    public int getConnectionState() {
        if(getState() != STATE_ON)        
        {
        int var1F640F1F529317692947FAA04DB1C39E_340587578 = (BluetoothAdapter.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1682124541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1682124541;
        }
        try 
        {
            int var89BBF539AAAFA06798B9D48DA63C267B_1842123831 = (mService.getAdapterConnectionState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462662169 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462662169;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var1F640F1F529317692947FAA04DB1C39E_509801105 = (BluetoothAdapter.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257629540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257629540;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return BluetoothAdapter.STATE_DISCONNECTED;
        //try {
            //return mService.getAdapterConnectionState();
        //} catch (RemoteException e) {Log.e(TAG, "getConnectionState:", e);}
        //return BluetoothAdapter.STATE_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.014 -0400", hash_original_method = "0796F6753B11E4CA7CEE3403756A4526", hash_generated_method = "08D9396C44984E65C20C27F543EC59BA")
    public int getProfileConnectionState(int profile) {
        addTaint(profile);
        if(getState() != STATE_ON)        
        {
        int var6DC267D6C0363C5B94F222673460F45F_1199378388 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038690141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038690141;
        }
        try 
        {
            int var0CA70D65B3B1B1B80DBB7215C5CEEE86_1344122406 = (mService.getProfileConnectionState(profile));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_482099709 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_482099709;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var6DC267D6C0363C5B94F222673460F45F_1895566464 = (BluetoothProfile.STATE_DISCONNECTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413223218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413223218;
        // ---------- Original Method ----------
        //if (getState() != STATE_ON) return BluetoothProfile.STATE_DISCONNECTED;
        //try {
            //return mService.getProfileConnectionState(profile);
        //} catch (RemoteException e) {
            //Log.e(TAG, "getProfileConnectionState:", e);
        //}
        //return BluetoothProfile.STATE_DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.016 -0400", hash_original_method = "71D512ADABDF23669C5DC04339CD42B4", hash_generated_method = "763899B078D53F38B1F8221607D200A1")
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
            } //End block
            catch (IOException e)
            {
            } //End block
            socket.mSocket.throwErrnoNative(errno);
        } //End block
BluetoothServerSocket varA63412D4E099639C1BBCBDC8D705186B_1991734853 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_1991734853.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_1991734853;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.018 -0400", hash_original_method = "89D65DC00BFA81C813C9155DE20CC833", hash_generated_method = "67285F78739E16E6E3A44D13B90856A6")
    public BluetoothServerSocket listenUsingRfcommWithServiceRecord(String name, UUID uuid) throws IOException {
        addTaint(uuid.getTaint());
        addTaint(name.getTaint());
BluetoothServerSocket var3EE707F51EA2594385CD32B6F83259E2_1441070260 =         createNewRfcommSocketAndRecord(name, uuid, true, true);
        var3EE707F51EA2594385CD32B6F83259E2_1441070260.addTaint(taint);
        return var3EE707F51EA2594385CD32B6F83259E2_1441070260;
        // ---------- Original Method ----------
        //return createNewRfcommSocketAndRecord(name, uuid, true, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.019 -0400", hash_original_method = "67A9DCDB5D1364F0197D124A8C117BDF", hash_generated_method = "A900FA48479FE0DAC230605702BFEA99")
    public BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord(String name, UUID uuid) throws IOException {
        addTaint(uuid.getTaint());
        addTaint(name.getTaint());
BluetoothServerSocket var05024ABE095066C27AB01BCCC3793A7A_886547672 =         createNewRfcommSocketAndRecord(name, uuid, false, false);
        var05024ABE095066C27AB01BCCC3793A7A_886547672.addTaint(taint);
        return var05024ABE095066C27AB01BCCC3793A7A_886547672;
        // ---------- Original Method ----------
        //return createNewRfcommSocketAndRecord(name, uuid, false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.019 -0400", hash_original_method = "D75F65DB3EAF8C02EDFD121756834A36", hash_generated_method = "743449FCB39D75F1140BA5474469BF8D")
    public BluetoothServerSocket listenUsingEncryptedRfcommWithServiceRecord(
            String name, UUID uuid) throws IOException {
        addTaint(uuid.getTaint());
        addTaint(name.getTaint());
BluetoothServerSocket varA840502DB9CC6BBE7D7E5732FE39C01F_2062017337 =         createNewRfcommSocketAndRecord(name, uuid, false, true);
        varA840502DB9CC6BBE7D7E5732FE39C01F_2062017337.addTaint(taint);
        return varA840502DB9CC6BBE7D7E5732FE39C01F_2062017337;
        // ---------- Original Method ----------
        //return createNewRfcommSocketAndRecord(name, uuid, false, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.022 -0400", hash_original_method = "ABCD96E52C8B56B2C4BF1A6AB6CFAB37", hash_generated_method = "43A3937F4C2CE3B437A6FAD4AA6BD063")
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
                IOException var817A124666112FE225ECD899E78D5369_1239343807 = new IOException("No available channels");
                var817A124666112FE225ECD899E78D5369_1239343807.addTaint(taint);
                throw var817A124666112FE225ECD899E78D5369_1239343807;
            } //End block
            socket = new BluetoothServerSocket(
                    BluetoothSocket.TYPE_RFCOMM, auth, encrypt, channel);
            errno = socket.mSocket.bindListen();
            if(errno == 0)            
            {
                if(DBG)                
                Log.d(TAG, "listening on RFCOMM channel " + channel);
                break;
            } //End block
            else
            if(errno == BluetoothSocket.EADDRINUSE)            
            {
                if(DBG)                
                Log.d(TAG, "RFCOMM channel " + channel + " in use");
                try 
                {
                    socket.close();
                } //End block
                catch (IOException e)
                {
                } //End block
                continue;
            } //End block
            else
            {
                try 
                {
                    socket.close();
                } //End block
                catch (IOException e)
                {
                } //End block
                socket.mSocket.throwErrnoNative(errno);
            } //End block
        } //End block
        int handle = -1;
        try 
        {
            handle = mService.addRfcommServiceRecord(name, new ParcelUuid(uuid), channel,
                    new Binder());
        } //End block
        catch (RemoteException e)
        {
        } //End block
        if(handle == -1)        
        {
            try 
            {
                socket.close();
            } //End block
            catch (IOException e)
            {
            } //End block
            IOException var49D6C1F0F64242D5209A78D1088C7196_444949901 = new IOException("Not able to register SDP record for " + name);
            var49D6C1F0F64242D5209A78D1088C7196_444949901.addTaint(taint);
            throw var49D6C1F0F64242D5209A78D1088C7196_444949901;
        } //End block
        if(mServiceRecordHandler == null)        
        {
            mServiceRecordHandler = new Handler(Looper.getMainLooper()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.022 -0400", hash_original_method = "FF0612DF3BD9B7FF527D2060CCF1E773", hash_generated_method = "0BD5BF60733B3D8A3685E449CA69EB68")
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            int handle = msg.what;
            try 
            {
                if(DBG)                
                Log.d(TAG, "Removing service record " +
                                           Integer.toHexString(handle));
                mService.removeServiceRecord(handle);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            // ---------- Original Method ----------
            //int handle = msg.what;
            //try {
                            //if (DBG) Log.d(TAG, "Removing service record " +
                                           //Integer.toHexString(handle));
                            //mService.removeServiceRecord(handle);
                        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        }
};
        } //End block
        socket.setCloseHandler(mServiceRecordHandler, handle);
BluetoothServerSocket varA63412D4E099639C1BBCBDC8D705186B_1266025259 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_1266025259.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_1266025259;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.025 -0400", hash_original_method = "27EC1A367A39F94DC128CEF34B5C5DD2", hash_generated_method = "F1E9DF02B9C75AB3EAC4C07A70E95838")
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
            } //End block
            catch (IOException e)
            {
            } //End block
            socket.mSocket.throwErrnoNative(errno);
        } //End block
BluetoothServerSocket varA63412D4E099639C1BBCBDC8D705186B_1122783218 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_1122783218.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_1122783218;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.027 -0400", hash_original_method = "7C75ECDC8A8B7963B0A9DF6AD0038A85", hash_generated_method = "E75BC1EF0793F2F36C80BDBE96DD31DE")
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
            } //End block
            catch (IOException e)
            {
            } //End block
            socket.mSocket.throwErrnoNative(errno);
        } //End block
BluetoothServerSocket varA63412D4E099639C1BBCBDC8D705186B_589566989 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_589566989.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_589566989;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.029 -0400", hash_original_method = "ABFDDF29A52D91D363C001D4DD695916", hash_generated_method = "0CB505FA4E3626542B103BFEA9ABBC73")
    public Pair<byte[], byte[]> readOutOfBandData() {
        if(getState() != STATE_ON)        
        {
Pair<byte[], byte[]> var540C13E9E156B687226421B24F2DF178_244445897 =         null;
        var540C13E9E156B687226421B24F2DF178_244445897.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_244445897;
        }
        try 
        {
            byte[] hash;
            byte[] randomizer;
            byte[] ret = mService.readOutOfBandData();
            if(ret  == null || ret.length != 32)            
            {
Pair<byte[], byte[]> var540C13E9E156B687226421B24F2DF178_589643905 =             null;
            var540C13E9E156B687226421B24F2DF178_589643905.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_589643905;
            }
            hash = Arrays.copyOfRange(ret, 0, 16);
            randomizer = Arrays.copyOfRange(ret, 16, 32);
            if(DBG)            
            {
                Log.d(TAG, "readOutOfBandData:" + Arrays.toString(hash) +
                  ":" + Arrays.toString(randomizer));
            } //End block
Pair<byte[], byte[]> varA95A3D48A90C7F180DAC8D6CC18BFF1D_1080737529 =             new Pair<byte[], byte[]>(hash, randomizer);
            varA95A3D48A90C7F180DAC8D6CC18BFF1D_1080737529.addTaint(taint);
            return varA95A3D48A90C7F180DAC8D6CC18BFF1D_1080737529;
        } //End block
        catch (RemoteException e)
        {
        } //End block
Pair<byte[], byte[]> var540C13E9E156B687226421B24F2DF178_8562257 =         null;
        var540C13E9E156B687226421B24F2DF178_8562257.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_8562257;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.031 -0400", hash_original_method = "7E4371B1FE17235BDA29BC99978F2247", hash_generated_method = "8A5DE5A8CA70649D1A2FF7FD54C6D1EA")
    public boolean getProfileProxy(Context context, BluetoothProfile.ServiceListener listener,
                                   int profile) {
        addTaint(profile);
        addTaint(listener.getTaint());
        addTaint(context.getTaint());
        if(context == null || listener == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1014691844 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113870369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113870369;
        }
        if(profile == BluetoothProfile.HEADSET)        
        {
            BluetoothHeadset headset = new BluetoothHeadset(context, listener);
            boolean varB326B5062B2F0E69046810717534CB09_1954476487 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_692242755 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_692242755;
        } //End block
        else
        if(profile == BluetoothProfile.A2DP)        
        {
            BluetoothA2dp a2dp = new BluetoothA2dp(context, listener);
            boolean varB326B5062B2F0E69046810717534CB09_1920809976 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1927603767 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1927603767;
        } //End block
        else
        if(profile == BluetoothProfile.INPUT_DEVICE)        
        {
            BluetoothInputDevice iDev = new BluetoothInputDevice(context, listener);
            boolean varB326B5062B2F0E69046810717534CB09_1023040694 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1536278455 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1536278455;
        } //End block
        else
        if(profile == BluetoothProfile.PAN)        
        {
            BluetoothPan pan = new BluetoothPan(context, listener);
            boolean varB326B5062B2F0E69046810717534CB09_355390469 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_846353400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_846353400;
        } //End block
        else
        if(profile == BluetoothProfile.HEALTH)        
        {
            BluetoothHealth health = new BluetoothHealth(context, listener);
            boolean varB326B5062B2F0E69046810717534CB09_1606105346 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710042 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_710042;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_576002819 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115740077 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115740077;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.032 -0400", hash_original_method = "C3F4A021A34A1F5D994F708A9A411E49", hash_generated_method = "CAB6AE6FD56BC92B5E5FDAFA853F0AF8")
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.033 -0400", hash_original_method = "A99B511CC77AEC21CDC5C0D9EF322DC5", hash_generated_method = "89143B50C0E9A69A09B0A0DD8328B046")
    public boolean changeApplicationBluetoothState(boolean on,
                                                   BluetoothStateChangeCallback callback) {
        addTaint(callback.getTaint());
        addTaint(on);
        if(callback == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_102613749 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316140474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316140474;
        }
        try 
        {
            boolean var296BD035DD8DE34572CEB9D119011347_1514137863 = (mService.changeApplicationBluetoothState(on, new
                    StateChangeCallbackWrapper(callback), new Binder()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975497045 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_975497045;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1552004252 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628503920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_628503920;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.034 -0400", hash_original_method = "513CC86480EBB28E1771EE0ECDF9AF42", hash_generated_method = "31456BEC3B2C4EA87F75E8BC3A6BDE11")
    private Set<BluetoothDevice> toDeviceSet(String[] addresses) {
        addTaint(addresses[0].getTaint());
        Set<BluetoothDevice> devices = new HashSet<BluetoothDevice>(addresses.length);
for(int i = 0;i < addresses.length;i++)
        {
            devices.add(getRemoteDevice(addresses[i]));
        } //End block
Set<BluetoothDevice> var32AED13893C8FE4C204BFFE342C4B1B8_1874773146 =         Collections.unmodifiableSet(devices);
        var32AED13893C8FE4C204BFFE342C4B1B8_1874773146.addTaint(taint);
        return var32AED13893C8FE4C204BFFE342C4B1B8_1874773146;
        // ---------- Original Method ----------
        //Set<BluetoothDevice> devices = new HashSet<BluetoothDevice>(addresses.length);
        //for (int i = 0; i < addresses.length; i++) {
            //devices.add(getRemoteDevice(addresses[i]));
        //}
        //return Collections.unmodifiableSet(devices);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.036 -0400", hash_original_field = "56278F1BC8E273243C72753A9B24D943", hash_generated_field = "1480456E24B96E56BF1C53CE053D6C57")

        private LinkedList<Integer> mChannels;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.036 -0400", hash_original_field = "6D1083D630EED7814896F0D75349A34B", hash_generated_field = "318090B38C1325AB0A6BDE7565479F55")

        private UUID mUuid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.037 -0400", hash_original_method = "28D5B18AE357E7C373AB413DE32AB5A2", hash_generated_method = "42EE177EE930235F899EEB09E2052EC9")
        public  RfcommChannelPicker(UUID uuid) {
            synchronized
(RfcommChannelPicker.class)            {
                if(sChannels == null)                
                {
                    sChannels = new LinkedList<Integer>();
for(int i = 1;i <= BluetoothSocket.MAX_RFCOMM_CHANNEL;i++)
                    {
                        sChannels.addLast(new Integer(i));
                    } //End block
for(int reserved : RESERVED_RFCOMM_CHANNELS)
                    {
                        sChannels.remove(new Integer(reserved));
                    } //End block
                    sRandom = new Random();
                } //End block
                mChannels = (LinkedList<Integer>)sChannels.clone();
            } //End block
            mUuid = uuid;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.038 -0400", hash_original_method = "81BCBA018F169CE48612651EBB944AF7", hash_generated_method = "D8D364D5C120A52B17E9FE00279B9113")
        public int nextChannel() {
            if(mChannels.size() == 0)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_494550957 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310688881 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310688881;
            } //End block
            int varA376C04E532E2783FDA95959A08257BE_1240213465 = (mChannels.remove(sRandom.nextInt(mChannels.size())));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345014743 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345014743;
            // ---------- Original Method ----------
            //if (mChannels.size() == 0) {
                //return -1;
            //}
            //return mChannels.remove(sRandom.nextInt(mChannels.size()));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.038 -0400", hash_original_field = "85DCCAEA585C9B4E6F240D0A0175374A", hash_generated_field = "A260FC333D7D19144D063EA361E7F085")

        private static final int[] RESERVED_RFCOMM_CHANNELS = new int[] {
            10,  
            11,  
            12,  
            19,  
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.038 -0400", hash_original_field = "31E97CDBA7EFB3E4452049029D3BD620", hash_generated_field = "EAB378A7CC265D715759023A5AA5F13F")

        private static LinkedList<Integer> sChannels;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.038 -0400", hash_original_field = "DA6A95610AF6CFF99C6F1D09E1E56D06", hash_generated_field = "62AF39559879372551FBEA5130DF03B8")

        private static Random sRandom;
    }


    
    public class StateChangeCallbackWrapper extends IBluetoothStateChangeCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.039 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "A57455FF422F35D91E260F65043C7D89")

        private BluetoothStateChangeCallback mCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.040 -0400", hash_original_method = "A0CF36872107300FB780BF535F8F7268", hash_generated_method = "752E88FB50F1EB2CC75629594B1B73B5")
          StateChangeCallbackWrapper(BluetoothStateChangeCallback
                callback) {
            mCallback = callback;
            // ---------- Original Method ----------
            //mCallback = callback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.041 -0400", hash_original_method = "A0576354509BA338556525A396FF4F6A", hash_generated_method = "B57E300F8427C46DB1C911A50605A193")
        @Override
        public void onBluetoothStateChange(boolean on) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(on);
            mCallback.onBluetoothStateChange(on);
            // ---------- Original Method ----------
            //mCallback.onBluetoothStateChange(on);
        }

        
    }


    
    public interface BluetoothStateChangeCallback {
        public void onBluetoothStateChange(boolean on);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.042 -0400", hash_original_field = "E5B219C7FEED88DB7F5399CF079A118F", hash_generated_field = "FFFD667AA4E6F86F94D79F85ECFC7E6D")

    private static final String TAG = "BluetoothAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.042 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.042 -0400", hash_original_field = "5AB9C566BA0BF4C0BC165F176F8A6669", hash_generated_field = "6AF8DDE3A6777A538F89C7DEB17C8CE1")

    public static final int ERROR = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.042 -0400", hash_original_field = "3AB282C61CADC4E1F512891196CC6E2C", hash_generated_field = "5A65F3D9BB4DC5EE1ACABB74F4D18B98")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_STATE_CHANGED =
            "android.bluetooth.adapter.action.STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.042 -0400", hash_original_field = "B19E90743E46DF6F2A6518E33FAFE704", hash_generated_field = "3A8F0DB6CD97AEFE65404050A24D57D6")

    public static final String EXTRA_STATE =
            "android.bluetooth.adapter.extra.STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.043 -0400", hash_original_field = "D33E66DF36BC6E913E9B0A30A31CAFD9", hash_generated_field = "098410645A4730D25E72FBEEA0EBA213")

    public static final String EXTRA_PREVIOUS_STATE =
            "android.bluetooth.adapter.extra.PREVIOUS_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.043 -0400", hash_original_field = "F2BA1189D66798C5C9E28C3F0E29AAEF", hash_generated_field = "2492744ADB13576C94E35244EFC60698")

    public static final int STATE_OFF = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.043 -0400", hash_original_field = "605D5F48DA9575FBAD04C22948B589ED", hash_generated_field = "45415AACDC0741F932680326DAEA7F57")

    public static final int STATE_TURNING_ON = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.044 -0400", hash_original_field = "2823B51CEBD1F668B2D995E1B1631DE2", hash_generated_field = "340CAEE29AEFA1ABD8C4C313C4031A11")

    public static final int STATE_ON = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.044 -0400", hash_original_field = "AD9E665D9D9EE8B9123C20C0E39477EF", hash_generated_field = "91D0FBAD29D8289C8DA9131914260E33")

    public static final int STATE_TURNING_OFF = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.044 -0400", hash_original_field = "C7838C3AA721CFD286AF6DFE48A16AB1", hash_generated_field = "E66A7598AB7D1F40474FB8CB4B9F29EC")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_REQUEST_DISCOVERABLE =
            "android.bluetooth.adapter.action.REQUEST_DISCOVERABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.044 -0400", hash_original_field = "3D26FB4A99C70F031C238F081ADA951A", hash_generated_field = "C3FF7E67DDBDF7B18E42691E003AD77D")

    public static final String EXTRA_DISCOVERABLE_DURATION =
            "android.bluetooth.adapter.extra.DISCOVERABLE_DURATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.045 -0400", hash_original_field = "EC25ECA9455F985693786E1F8AB53CFF", hash_generated_field = "8BE216E12192E77765DCF2441EA0666F")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_REQUEST_ENABLE =
            "android.bluetooth.adapter.action.REQUEST_ENABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.045 -0400", hash_original_field = "A51D0480E64772A55B460C63900F3963", hash_generated_field = "6018A97AE0B0501F7D8F354A46F12C4A")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCAN_MODE_CHANGED =
            "android.bluetooth.adapter.action.SCAN_MODE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.045 -0400", hash_original_field = "E605E9682827A4B0A7412B7F2C71DDA9", hash_generated_field = "E3AFC80C21F6F85837BE05DF19B0CF20")

    public static final String EXTRA_SCAN_MODE = "android.bluetooth.adapter.extra.SCAN_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.045 -0400", hash_original_field = "A3BC40D09C9B188BA7CF938F189E0FC3", hash_generated_field = "517F6F861E87657DEE5840B6E4814935")

    public static final String EXTRA_PREVIOUS_SCAN_MODE =
            "android.bluetooth.adapter.extra.PREVIOUS_SCAN_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.045 -0400", hash_original_field = "DDCBE28C85DE1AF89DE31E4FEF94BCB9", hash_generated_field = "BC414FEE775A8ACF5083694FB05C9DAD")

    public static final int SCAN_MODE_NONE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.045 -0400", hash_original_field = "DD7046A2D1B48ECB2578F6FAFE3033E3", hash_generated_field = "9A2023C029A688C61AF0AFB65BB59898")

    public static final int SCAN_MODE_CONNECTABLE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.045 -0400", hash_original_field = "306ADEE0D99C10D2C3F1DBCC28CE1031", hash_generated_field = "84C8E5952616DC34E8514798F84FF7CC")

    public static final int SCAN_MODE_CONNECTABLE_DISCOVERABLE = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.046 -0400", hash_original_field = "D993C840F07CBC812EC7C8EF0555F0B9", hash_generated_field = "2FFDB6078656359E095CF8DDA030577E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DISCOVERY_STARTED =
            "android.bluetooth.adapter.action.DISCOVERY_STARTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.046 -0400", hash_original_field = "CAE947F91A835371C3BC0C6DFCF14D7A", hash_generated_field = "C7669A14687A25449EC9A09E5FF5CB75")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DISCOVERY_FINISHED =
            "android.bluetooth.adapter.action.DISCOVERY_FINISHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.046 -0400", hash_original_field = "C3194CF52F26B3ECD3376886AC513B6A", hash_generated_field = "EEA8D509F766113EFBE364F807BA0A7F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_LOCAL_NAME_CHANGED =
            "android.bluetooth.adapter.action.LOCAL_NAME_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.046 -0400", hash_original_field = "473D77A718344FC564A43A3F835ABC09", hash_generated_field = "7052E6CE58614BD821917BC7308EEA5A")

    public static final String EXTRA_LOCAL_NAME = "android.bluetooth.adapter.extra.LOCAL_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.046 -0400", hash_original_field = "EFF2719457B3D26AC78B8F8219CB95B2", hash_generated_field = "922348319A52FBC21E79D50738C951E7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_STATE_CHANGED =
        "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.046 -0400", hash_original_field = "E46BA6434A04E096D6171CDD7C97AE62", hash_generated_field = "1D3AAB8543C4C934AB7CEF233BD62CE4")

    public static final String EXTRA_CONNECTION_STATE =
        "android.bluetooth.adapter.extra.CONNECTION_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.046 -0400", hash_original_field = "407A73B6D95C44B7D5905E0A6913F591", hash_generated_field = "CB9396A90BE9EE705FF77742B2727CEA")

    public static final String EXTRA_PREVIOUS_CONNECTION_STATE =
          "android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.046 -0400", hash_original_field = "2D50E5D85E482FA800E087638A951161", hash_generated_field = "84173E1866F23EE943EF8008ED8CFAFC")

    public static final int STATE_DISCONNECTED  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.046 -0400", hash_original_field = "D535FF7624C6447AFFCBE6542703375F", hash_generated_field = "8CB4E5E77EC98D8CA7B9ED27A25245FB")

    public static final int STATE_CONNECTING    = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.046 -0400", hash_original_field = "C08867EE19B193B18FAEE380F460DEBA", hash_generated_field = "3F851151E1E65F1A69352C1A55C34451")

    public static final int STATE_CONNECTED     = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.047 -0400", hash_original_field = "679A7218E870C82A9EAE6C14FFDE108F", hash_generated_field = "CDC0147D8DF471B389406236B4CDE4C6")

    public static final int STATE_DISCONNECTING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.047 -0400", hash_original_field = "C7432917623607E06320445454C2A3B8", hash_generated_field = "3D6035B10EF8E7EF00722E60E1BC0101")

    public static final String BLUETOOTH_SERVICE = "bluetooth";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.047 -0400", hash_original_field = "65464FBE0B2850776189D4464C82B733", hash_generated_field = "4E1CB78F3E71AAE2C4C5EEAF9B65762C")

    private static final int ADDRESS_LENGTH = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.047 -0400", hash_original_field = "A437836ADAE531779FE0DF7D1A772174", hash_generated_field = "774AD1565F074633E7FB49926516258A")

    private static BluetoothAdapter sAdapter;
}

