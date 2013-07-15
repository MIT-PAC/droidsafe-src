package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

public final class BluetoothDevice implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.932 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "C679AE506A0300BA50CA43522D6BE5D0")

    private String mAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.933 -0400", hash_original_method = "01E6ABA43F371BE96DE0741E69CF2696", hash_generated_method = "EF6B3CF652C2AEE712EAF521BDD9C74D")
      BluetoothDevice(String address) {
        getService();
    if(!BluetoothAdapter.checkBluetoothAddress(address))        
        {
            IllegalArgumentException varE67265FB8801BE31F02550447FBF83C5_946872924 = new IllegalArgumentException(address + " is not a valid Bluetooth address");
            varE67265FB8801BE31F02550447FBF83C5_946872924.addTaint(taint);
            throw varE67265FB8801BE31F02550447FBF83C5_946872924;
        } //End block
        mAddress = address;
        // ---------- Original Method ----------
        //getService();
        //if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            //throw new IllegalArgumentException(address + " is not a valid Bluetooth address");
        //}
        //mAddress = address;
    }

    
        static IBluetooth getService() {
        synchronized (BluetoothDevice.class) {
            if (sService == null) {
                IBinder b = ServiceManager.getService(BluetoothAdapter.BLUETOOTH_SERVICE);
                if (b == null) {
                    throw new RuntimeException("Bluetooth service not available");
                }
                sService = IBluetooth.Stub.asInterface(b);
            }
        }
        return sService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.934 -0400", hash_original_method = "DA80DFD3FFE970A9DEF6CBF59BD17BFE", hash_generated_method = "FDA0F825EB16922AD966F483FB117C73")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o instanceof BluetoothDevice)        
        {
            boolean varDF3A9DF469E4AB88AF0A09B1CB129AEF_1443383076 = (mAddress.equals(((BluetoothDevice)o).getAddress()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708819541 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708819541;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_450535760 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1405240165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1405240165;
        // ---------- Original Method ----------
        //if (o instanceof BluetoothDevice) {
            //return mAddress.equals(((BluetoothDevice)o).getAddress());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.934 -0400", hash_original_method = "7AEEB42D289D7509B50F97CB867AEDF2", hash_generated_method = "2B2AEBDA7ADB71E9B9138484458B00F9")
    @Override
    public int hashCode() {
        int varA9E8B8927CF26DCEA6E353AA06EEA20C_2076840719 = (mAddress.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316731093 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316731093;
        // ---------- Original Method ----------
        //return mAddress.hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.935 -0400", hash_original_method = "4F994B6046AF4A420304240B51CB4CC6", hash_generated_method = "467F4A6FDA2142F46CBC885C55853276")
    @Override
    public String toString() {
String var86CD3BA5FA0F42F72E695A9A747D1E23_1328521609 =         mAddress;
        var86CD3BA5FA0F42F72E695A9A747D1E23_1328521609.addTaint(taint);
        return var86CD3BA5FA0F42F72E695A9A747D1E23_1328521609;
        // ---------- Original Method ----------
        //return mAddress;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.936 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "EB137144806BAE344BF906269D5A5F13")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1188079088 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837629300 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837629300;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.937 -0400", hash_original_method = "355A6B197E6D06E20E4355217F5ABC70", hash_generated_method = "B224F390558DE4FC885DFB7647E05F2E")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeString(mAddress);
        // ---------- Original Method ----------
        //out.writeString(mAddress);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.937 -0400", hash_original_method = "BD85A48E5B7DC741C80D75F9CC9D3A4A", hash_generated_method = "DF539C16499B1FDDA64AF5930C29F33C")
    public String getAddress() {
String var86CD3BA5FA0F42F72E695A9A747D1E23_1851937889 =         mAddress;
        var86CD3BA5FA0F42F72E695A9A747D1E23_1851937889.addTaint(taint);
        return var86CD3BA5FA0F42F72E695A9A747D1E23_1851937889;
        // ---------- Original Method ----------
        //return mAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.938 -0400", hash_original_method = "027728A71FD2E55E5703A638CB89EB2E", hash_generated_method = "25F6D896C3CD4280D29914C8D576F34E")
    public String getName() {
        try 
        {
String var39C60B58BB36A1EA0045E5B5DA83F1EC_1803169695 =             sService.getRemoteName(mAddress);
            var39C60B58BB36A1EA0045E5B5DA83F1EC_1803169695.addTaint(taint);
            return var39C60B58BB36A1EA0045E5B5DA83F1EC_1803169695;
        } //End block
        catch (RemoteException e)
        {
        } //End block
String var540C13E9E156B687226421B24F2DF178_786328722 =         null;
        var540C13E9E156B687226421B24F2DF178_786328722.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_786328722;
        // ---------- Original Method ----------
        //try {
            //return sService.getRemoteName(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.938 -0400", hash_original_method = "3D31424D7A0639D60E5B5097A46F207C", hash_generated_method = "DE0749972411E0CB89010C0C9A013E19")
    public String getAlias() {
        try 
        {
String var0398EF1B43F91CA785537736ABE2ED46_1173817709 =             sService.getRemoteAlias(mAddress);
            var0398EF1B43F91CA785537736ABE2ED46_1173817709.addTaint(taint);
            return var0398EF1B43F91CA785537736ABE2ED46_1173817709;
        } //End block
        catch (RemoteException e)
        {
        } //End block
String var540C13E9E156B687226421B24F2DF178_2098127399 =         null;
        var540C13E9E156B687226421B24F2DF178_2098127399.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2098127399;
        // ---------- Original Method ----------
        //try {
            //return sService.getRemoteAlias(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.939 -0400", hash_original_method = "49B51B4B037A5C39323EEFF06458ED35", hash_generated_method = "17D40FD89778165421789DAE45809D15")
    public boolean setAlias(String alias) {
        addTaint(alias.getTaint());
        try 
        {
            boolean var0A1A1DD7BAC6842FB2B0D01B96A0AAF9_1664652324 = (sService.setRemoteAlias(mAddress, alias));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1119271550 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1119271550;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_531485828 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863495544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_863495544;
        // ---------- Original Method ----------
        //try {
            //return sService.setRemoteAlias(mAddress, alias);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.940 -0400", hash_original_method = "0C2F081FEB58CFB1BA7C24E91B419B7D", hash_generated_method = "6FF3C60E5E3F9BA97F283C7560FFE5B3")
    public String getAliasName() {
        String name = getAlias();
    if(name == null)        
        {
            name = getName();
        } //End block
String varB017984728AC60AD1F0BF8734F33F15C_799491511 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_799491511.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_799491511;
        // ---------- Original Method ----------
        //String name = getAlias();
        //if (name == null) {
            //name = getName();
        //}
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.940 -0400", hash_original_method = "7ABDE8D07F07F9433B847CB6022477DB", hash_generated_method = "E8711239A5BDFAEE039D4C3D0EF99F01")
    public boolean createBond() {
        try 
        {
            boolean var5EB42A4759F61DFA16034D0D2717776D_1396401799 = (sService.createBond(mAddress));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1878369595 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1878369595;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_763794209 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052675342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052675342;
        // ---------- Original Method ----------
        //try {
            //return sService.createBond(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.941 -0400", hash_original_method = "211570B5CDF01B6AE01B8C3D0317F2CB", hash_generated_method = "12AC8B9670E471632BDC39B91F9EE381")
    public boolean createBondOutOfBand(byte[] hash, byte[] randomizer) {
        addTaint(randomizer[0]);
        addTaint(hash[0]);
        try 
        {
            boolean var4D398AA0BEEAF59118216F1E49568210_1466881983 = (sService.createBondOutOfBand(mAddress, hash, randomizer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691256020 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_691256020;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1980958553 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109854123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109854123;
        // ---------- Original Method ----------
        //try {
            //return sService.createBondOutOfBand(mAddress, hash, randomizer);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.942 -0400", hash_original_method = "575E29F4E8B829BD0D23FAC1ADF3E1AA", hash_generated_method = "B77ADDF4248135C032EC65F175B4EBBB")
    public boolean setDeviceOutOfBandData(byte[] hash, byte[] randomizer) {
        addTaint(randomizer[0]);
        addTaint(hash[0]);
        try 
        {
            boolean var01CD2DCACA03CBD8B0199B2FC54BD793_1421345132 = (sService.setDeviceOutOfBandData(mAddress, hash, randomizer));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_621590656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_621590656;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_572297282 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120558328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120558328;
        // ---------- Original Method ----------
        //try {
        //return sService.setDeviceOutOfBandData(mAddress, hash, randomizer);
      //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.942 -0400", hash_original_method = "0C0048A8FF7823EF43482AC4C17114D5", hash_generated_method = "51B14B576CD60421580887027A1A838D")
    public boolean cancelBondProcess() {
        try 
        {
            boolean var5252B4C1B338D35AA8A26E794F29099C_21529600 = (sService.cancelBondProcess(mAddress));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963298296 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_963298296;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_825915306 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018537137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018537137;
        // ---------- Original Method ----------
        //try {
            //return sService.cancelBondProcess(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.944 -0400", hash_original_method = "2ABE478EBB53F919726366CC411EDF02", hash_generated_method = "A05E74FDA2AF945D237D9E707456EB4C")
    public boolean removeBond() {
        try 
        {
            boolean varBFDB4F660EB9BB7B26B0A07BDBA790FB_161823996 = (sService.removeBond(mAddress));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761966109 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761966109;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1090046674 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648169164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648169164;
        // ---------- Original Method ----------
        //try {
            //return sService.removeBond(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.946 -0400", hash_original_method = "D50E996B702CE09ED98935B433818740", hash_generated_method = "DD717E74A64B9E7A6A4063F876793B00")
    public int getBondState() {
        try 
        {
            int varDEE79427C15407FC965D649DA1DC6E1B_1415677969 = (sService.getBondState(mAddress));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371846856 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371846856;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var2F66889696AE5222714908CC98415C61_315891909 = (BOND_NONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726360968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726360968;
        // ---------- Original Method ----------
        //try {
            //return sService.getBondState(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return BOND_NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.950 -0400", hash_original_method = "EF524B188F92A45A25D7F167D0B007CD", hash_generated_method = "8D038B9F4FC259CE77552A41AE0E35D2")
    public BluetoothClass getBluetoothClass() {
        try 
        {
            int classInt = sService.getRemoteClass(mAddress);
    if(classInt == BluetoothClass.ERROR)            
            {
BluetoothClass var540C13E9E156B687226421B24F2DF178_162951357 =             null;
            var540C13E9E156B687226421B24F2DF178_162951357.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_162951357;
            }
BluetoothClass var2C5CBDF34B46E0AB38DF55312ECD30C0_1944230576 =             new BluetoothClass(classInt);
            var2C5CBDF34B46E0AB38DF55312ECD30C0_1944230576.addTaint(taint);
            return var2C5CBDF34B46E0AB38DF55312ECD30C0_1944230576;
        } //End block
        catch (RemoteException e)
        {
        } //End block
BluetoothClass var540C13E9E156B687226421B24F2DF178_1382778058 =         null;
        var540C13E9E156B687226421B24F2DF178_1382778058.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1382778058;
        // ---------- Original Method ----------
        //try {
            //int classInt = sService.getRemoteClass(mAddress);
            //if (classInt == BluetoothClass.ERROR) return null;
            //return new BluetoothClass(classInt);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.951 -0400", hash_original_method = "31D115AB32A31FB0B9AF4C26A4E47F46", hash_generated_method = "AE800EFA43C4FEF543EA673007B75E5A")
    public boolean getTrustState() {
        try 
        {
            boolean varCA45BABF78C38018E5FF4C9840392839_1965773919 = (sService.getTrustState(mAddress));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660808524 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660808524;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1484894986 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1782805812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1782805812;
        // ---------- Original Method ----------
        //try {
            //return sService.getTrustState(mAddress);
        //} catch (RemoteException e) {
            //Log.e(TAG, "", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.952 -0400", hash_original_method = "9D6C6E6815AA7950FF362F094CFFC963", hash_generated_method = "386B82BB4415AF85545C7B71BD569E02")
    public boolean setTrust(boolean value) {
        addTaint(value);
        try 
        {
            boolean var5DF7253D86EF8E61EEBE50A60183FF70_46961951 = (sService.setTrust(mAddress, value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855317996 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_855317996;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_585379021 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940416213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_940416213;
        // ---------- Original Method ----------
        //try {
            //return sService.setTrust(mAddress, value);
        //} catch (RemoteException e) {
            //Log.e(TAG, "", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.953 -0400", hash_original_method = "E2768C133840A39718DB537E54814CD2", hash_generated_method = "8EB784EF20F4C82C2CE1F792C51414BC")
    public ParcelUuid[] getUuids() {
        try 
        {
ParcelUuid[] var6164875C28B4D961813685F77B9ACCA1_755883806 =             sService.getRemoteUuids(mAddress);
            var6164875C28B4D961813685F77B9ACCA1_755883806.addTaint(taint);
            return var6164875C28B4D961813685F77B9ACCA1_755883806;
        } //End block
        catch (RemoteException e)
        {
        } //End block
ParcelUuid[] var540C13E9E156B687226421B24F2DF178_356979172 =         null;
        var540C13E9E156B687226421B24F2DF178_356979172.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_356979172;
        // ---------- Original Method ----------
        //try {
            //return sService.getRemoteUuids(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.954 -0400", hash_original_method = "DEDB39F51E4B34081515EA0E29E542CE", hash_generated_method = "A816984B1441CD1C04DB3ED329E59F67")
    public boolean fetchUuidsWithSdp() {
        try 
        {
            boolean var0572CACE0A927DB21D8501D181B6C76D_355266787 = (sService.fetchRemoteUuids(mAddress, null, null));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631157383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631157383;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_311484018 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1894170770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1894170770;
        // ---------- Original Method ----------
        //try {
            //return sService.fetchRemoteUuids(mAddress, null, null);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.955 -0400", hash_original_method = "3159A609DA44BB79D68A9974B9B6A655", hash_generated_method = "3BA2BDD59CAB8995328EBC14C7DC9503")
    public int getServiceChannel(ParcelUuid uuid) {
        addTaint(uuid.getTaint());
        try 
        {
            int var483E071A1E400A39FB72104BE290D456_346258235 = (sService.getRemoteServiceChannel(mAddress, uuid));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_792667200 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_792667200;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var84B9707FE12756F266CFF8AC31791AE1_227892514 = (BluetoothDevice.ERROR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679478669 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679478669;
        // ---------- Original Method ----------
        //try {
             //return sService.getRemoteServiceChannel(mAddress, uuid);
         //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return BluetoothDevice.ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.956 -0400", hash_original_method = "0C2B72A87477D43DC574495BFD9C1EAD", hash_generated_method = "79A3C8BF77BDBE1161ABC04DFC88CEE5")
    public boolean setPin(byte[] pin) {
        addTaint(pin[0]);
        try 
        {
            boolean var086B2AA6E7AB6766605609FE44193CC3_1529354594 = (sService.setPin(mAddress, pin));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978834045 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_978834045;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1811980429 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1530088278 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1530088278;
        // ---------- Original Method ----------
        //try {
            //return sService.setPin(mAddress, pin);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.957 -0400", hash_original_method = "3609F7C358721757CCD34D699F0B8CE9", hash_generated_method = "6EEF4D07212432525F92A4DBBAF6F5C8")
    public boolean setPasskey(int passkey) {
        addTaint(passkey);
        try 
        {
            boolean var2247FB259A51B550D5D5913C921346E2_352836539 = (sService.setPasskey(mAddress, passkey));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363810727 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363810727;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_505663679 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268793940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_268793940;
        // ---------- Original Method ----------
        //try {
            //return sService.setPasskey(mAddress, passkey);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.958 -0400", hash_original_method = "C6032CF5D33EF2ED9DD2C95EBB11B5A2", hash_generated_method = "A0DC7DD4FA6DBEBC091F246704A7F28A")
    public boolean setPairingConfirmation(boolean confirm) {
        addTaint(confirm);
        try 
        {
            boolean var275C38C30487404B0918F1F96051F8EB_1043011850 = (sService.setPairingConfirmation(mAddress, confirm));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_976355519 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_976355519;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_711509794 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111755413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111755413;
        // ---------- Original Method ----------
        //try {
            //return sService.setPairingConfirmation(mAddress, confirm);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.958 -0400", hash_original_method = "23E27132155361CD962933565A6A609F", hash_generated_method = "C7E2EF3C50104DBD3FD43E3A5DFF4F5B")
    public boolean setRemoteOutOfBandData() {
        try 
        {
            boolean varBF89126B9A4B638C218D31DDE50FECC3_41318241 = (sService.setRemoteOutOfBandData(mAddress));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526943278 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526943278;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1060281862 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1360780463 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1360780463;
        // ---------- Original Method ----------
        //try {
          //return sService.setRemoteOutOfBandData(mAddress);
      //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.959 -0400", hash_original_method = "52E8DE9DDBFDE18365F513F918590AAC", hash_generated_method = "433FBE3F23B8306EF0FE5770C4115CCA")
    public boolean cancelPairingUserInput() {
        try 
        {
            boolean var4D7882AAC54982D72B995A506397F911_363636210 = (sService.cancelPairingUserInput(mAddress));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713659185 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713659185;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_915713343 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962967129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962967129;
        // ---------- Original Method ----------
        //try {
            //return sService.cancelPairingUserInput(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.960 -0400", hash_original_method = "C1B670BF8E55A118E70A73AF396353BD", hash_generated_method = "FCFA9598483114B638F718FA395E2872")
    public boolean isBluetoothDock() {
        try 
        {
            boolean varAC8D0385B4CA5290F8879C6C8C1F5D2A_1405582154 = (sService.isBluetoothDock(mAddress));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207567927 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_207567927;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1222736315 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_735321198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_735321198;
        // ---------- Original Method ----------
        //try {
            //return sService.isBluetoothDock(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.960 -0400", hash_original_method = "98EAE836400D818BB4CCAFDB9F3FE0E9", hash_generated_method = "7BA3C0F8FE27818D6C922F34B1E0E367")
    public BluetoothSocket createRfcommSocket(int channel) throws IOException {
        addTaint(channel);
BluetoothSocket var51C775BCD1F1E517CEC48364C2A98EB3_1354960144 =         new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, true, true, this, channel,
                null);
        var51C775BCD1F1E517CEC48364C2A98EB3_1354960144.addTaint(taint);
        return var51C775BCD1F1E517CEC48364C2A98EB3_1354960144;
        // ---------- Original Method ----------
        //return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, true, true, this, channel,
                //null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.961 -0400", hash_original_method = "673893485928B830B2C44FE0F9C84083", hash_generated_method = "55CC81C99429B60F3F47BD9A41981B14")
    public BluetoothSocket createRfcommSocketToServiceRecord(UUID uuid) throws IOException {
        addTaint(uuid.getTaint());
BluetoothSocket var4416FFD61C38CA98B2101475556EB072_1197502932 =         new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, true, true, this, -1,
                new ParcelUuid(uuid));
        var4416FFD61C38CA98B2101475556EB072_1197502932.addTaint(taint);
        return var4416FFD61C38CA98B2101475556EB072_1197502932;
        // ---------- Original Method ----------
        //return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, true, true, this, -1,
                //new ParcelUuid(uuid));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.961 -0400", hash_original_method = "8A29B36723BF3024D765B326A6835F52", hash_generated_method = "3B018AE33E5B2C450058EF088E1A94B1")
    public BluetoothSocket createInsecureRfcommSocketToServiceRecord(UUID uuid) throws IOException {
        addTaint(uuid.getTaint());
BluetoothSocket var73C70BFE9204F8F5C0EF762AD73861F3_189281424 =         new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, false, false, this, -1,
                new ParcelUuid(uuid));
        var73C70BFE9204F8F5C0EF762AD73861F3_189281424.addTaint(taint);
        return var73C70BFE9204F8F5C0EF762AD73861F3_189281424;
        // ---------- Original Method ----------
        //return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, false, false, this, -1,
                //new ParcelUuid(uuid));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.961 -0400", hash_original_method = "65B6B4065AE19FE91B1B928AB482A400", hash_generated_method = "F9F3E3B368A3AFF57648EBA7C30CCBFE")
    public BluetoothSocket createInsecureRfcommSocket(int port) throws IOException {
        addTaint(port);
BluetoothSocket varECB7EF97AD866D9F177972C6A2DD32DD_1886695609 =         new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, false, false, this, port,
                null);
        varECB7EF97AD866D9F177972C6A2DD32DD_1886695609.addTaint(taint);
        return varECB7EF97AD866D9F177972C6A2DD32DD_1886695609;
        // ---------- Original Method ----------
        //return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, false, false, this, port,
                //null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.962 -0400", hash_original_method = "A2683B7D001B6D4367715042EC6C96CC", hash_generated_method = "E47A2E5F17511D9AA639963D0E4F01FE")
    public BluetoothSocket createScoSocket() throws IOException {
BluetoothSocket varCBE45E1CC339E38D120332CED93F6CAC_945091167 =         new BluetoothSocket(BluetoothSocket.TYPE_SCO, -1, true, true, this, -1, null);
        varCBE45E1CC339E38D120332CED93F6CAC_945091167.addTaint(taint);
        return varCBE45E1CC339E38D120332CED93F6CAC_945091167;
        // ---------- Original Method ----------
        //return new BluetoothSocket(BluetoothSocket.TYPE_SCO, -1, true, true, this, -1, null);
    }

    
        public static byte[] convertPinToBytes(String pin) {
        if (pin == null) {
            return null;
        }
        byte[] pinBytes;
        try {
            pinBytes = pin.getBytes("UTF-8");
        } catch (UnsupportedEncodingException uee) {
            Log.e(TAG, "UTF-8 not supported?!?");  
            return null;
        }
        if (pinBytes.length <= 0 || pinBytes.length > 16) {
            return null;
        }
        return pinBytes;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.962 -0400", hash_original_field = "4AAC13FB8862BF07AEEB6CCCC3620F9E", hash_generated_field = "56404D337E5A358E74D107F5362299C0")

    private static final String TAG = "BluetoothDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.962 -0400", hash_original_field = "5AB9C566BA0BF4C0BC165F176F8A6669", hash_generated_field = "6AF8DDE3A6777A538F89C7DEB17C8CE1")

    public static final int ERROR = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.962 -0400", hash_original_field = "9990CC5E5B46A0467F78E09F64900566", hash_generated_field = "CC84698E9A3F505958068BCFEDC1DC21")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_FOUND =
            "android.bluetooth.device.action.FOUND";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.963 -0400", hash_original_field = "520EFCEC8B0165192E7C3CE2E7A0F704", hash_generated_field = "8AAF232769CD19DC423585CDE6D13E58")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DISAPPEARED =
            "android.bluetooth.device.action.DISAPPEARED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.963 -0400", hash_original_field = "BE5E6B9104CD7DC6952757A7B42DE437", hash_generated_field = "FED039F1A07FD22EF11BAA6C2D42367B")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CLASS_CHANGED =
            "android.bluetooth.device.action.CLASS_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.963 -0400", hash_original_field = "410D5F342FADEB3DD9C6EB5A273C4C47", hash_generated_field = "3EA28AF16B411BF0A8FEE73EF953E4B3")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ACL_CONNECTED =
            "android.bluetooth.device.action.ACL_CONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.963 -0400", hash_original_field = "307D376C14125D4FEDA4C190EE504864", hash_generated_field = "3554F5DEA2DBAF437F4A80AE347DB5ED")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ACL_DISCONNECT_REQUESTED =
            "android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.963 -0400", hash_original_field = "0F561115483465C0D3CB1A998D08E733", hash_generated_field = "3DBD02811765575C6CA7BD8A9931CD4A")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ACL_DISCONNECTED =
            "android.bluetooth.device.action.ACL_DISCONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.963 -0400", hash_original_field = "3B1993C1839F25B1B1BD61F13061D6B9", hash_generated_field = "016E52AC9FCFF7E766426978C91648EE")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NAME_CHANGED =
            "android.bluetooth.device.action.NAME_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.963 -0400", hash_original_field = "344C9141840878DD7BEFA54D1D321F05", hash_generated_field = "A1126C42D7E9B72F441A5DB67E7DFA0C")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BOND_STATE_CHANGED =
            "android.bluetooth.device.action.BOND_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.963 -0400", hash_original_field = "017F832E6FED22CBF0ACE9594A88FC7F", hash_generated_field = "30AF2264E5D341E15F5421C9E8946DB3")

    public static final String EXTRA_DEVICE = "android.bluetooth.device.extra.DEVICE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.963 -0400", hash_original_field = "D95A1A1A9AEBFE911830F788053BC38B", hash_generated_field = "0275E45EA81E0F34B48E2CFAC9208AA7")

    public static final String EXTRA_NAME = "android.bluetooth.device.extra.NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.964 -0400", hash_original_field = "73321E25DFE1D1BB25B189C6E02615AB", hash_generated_field = "5FFDC1C615410E85BEE058B01505C415")

    public static final String EXTRA_RSSI = "android.bluetooth.device.extra.RSSI";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.964 -0400", hash_original_field = "799B15A20449F7C4C3C623B6E24E9BB7", hash_generated_field = "0B8F1097ACE49FF2FE92D295B330C945")

    public static final String EXTRA_CLASS = "android.bluetooth.device.extra.CLASS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.964 -0400", hash_original_field = "6FF4817D3CFC5B84FF2CB8D66DEEDA56", hash_generated_field = "F74422703F4629CF9E21B0910D89E4E1")

    public static final String EXTRA_BOND_STATE = "android.bluetooth.device.extra.BOND_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.964 -0400", hash_original_field = "F979A3440CC7487E850757B1CA631C2E", hash_generated_field = "D1160470D82FAF8A08FCFE8C151F9AD6")

    public static final String EXTRA_PREVIOUS_BOND_STATE =
            "android.bluetooth.device.extra.PREVIOUS_BOND_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.964 -0400", hash_original_field = "518E5C01FBB5E0C786A8377E759923F5", hash_generated_field = "0CDC0FEFDF97CC31246B7A4ED35988A9")

    public static final int BOND_NONE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.964 -0400", hash_original_field = "AE6ECF84CDDBAB2E10C745A489944125", hash_generated_field = "FFC46D2D401FEEC969455B5830EF2FBF")

    public static final int BOND_BONDING = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.964 -0400", hash_original_field = "1C1CA28E3FBDA69EB716C637E8355FAB", hash_generated_field = "8A8CCC3ED5A2B080DB1FCAB9BCD5ED7B")

    public static final int BOND_BONDED = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.964 -0400", hash_original_field = "998E6CC313D366974017388EC1E5340F", hash_generated_field = "AA6F32BD9B0C4442647CCA9501B603AC")

    public static final String EXTRA_REASON = "android.bluetooth.device.extra.REASON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.965 -0400", hash_original_field = "1B99409C89C43313C2C42F7310A88FE0", hash_generated_field = "F789A73DACB5CAB1875DFEE053C5249D")

    public static final String EXTRA_PAIRING_VARIANT =
            "android.bluetooth.device.extra.PAIRING_VARIANT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.965 -0400", hash_original_field = "60993428534B093D6864D857B4210F52", hash_generated_field = "06EFF6EE188208B5D6DA27B05863A587")

    public static final String EXTRA_PAIRING_KEY = "android.bluetooth.device.extra.PAIRING_KEY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.965 -0400", hash_original_field = "DFF88DA68778A3389A63C88B04933BCD", hash_generated_field = "E952ED271908E1C567F82857231C9C45")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_UUID =
            "android.bluetooth.device.action.UUID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.965 -0400", hash_original_field = "860740A2547DAD787A814BCF34CE7A61", hash_generated_field = "5C175007B58518656175511EB997C39D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NAME_FAILED =
            "android.bluetooth.device.action.NAME_FAILED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.965 -0400", hash_original_field = "7C67F1E6C85E9F98A0072D2BDA74C3B8", hash_generated_field = "A255D1D6DC5A95D39F27FFB41250F214")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PAIRING_REQUEST =
            "android.bluetooth.device.action.PAIRING_REQUEST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.966 -0400", hash_original_field = "DB6783BD06396323F4FCF3118A901D65", hash_generated_field = "A3C01E7EDB4A98C364524CEB0953DB6F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PAIRING_CANCEL =
            "android.bluetooth.device.action.PAIRING_CANCEL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.966 -0400", hash_original_field = "5C6A63CCEC406921ED229D92C640CC44", hash_generated_field = "61430413A16DD760E9391A133DCDACF6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_ACCESS_REQUEST =
            "android.bluetooth.device.action.CONNECTION_ACCESS_REQUEST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.966 -0400", hash_original_field = "8434D3885C4512BC1291EDA93E9F49F0", hash_generated_field = "752165CCA7617776DBEB3E09143BB5DC")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_ACCESS_REPLY =
            "android.bluetooth.device.action.CONNECTION_ACCESS_REPLY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.966 -0400", hash_original_field = "C60C99B127713EC7C539CDC5A5513CE7", hash_generated_field = "95337666F7DCC1F11183D2CA4A2862FF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_ACCESS_CANCEL =
            "android.bluetooth.device.action.CONNECTION_ACCESS_CANCEL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.966 -0400", hash_original_field = "1ECB40368DB3505A08CFF6F30D400413", hash_generated_field = "03F720811CE25FFB681F78056FAF7880")

    public static final String EXTRA_ACCESS_REQUEST_TYPE =
        "android.bluetooth.device.extra.ACCESS_REQUEST_TYPE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.967 -0400", hash_original_field = "3AB593E7F7C5A04384FBE1C308A38528", hash_generated_field = "9D5A24B8B8752C28A2576C8B3B255196")

    public static final int REQUEST_TYPE_PROFILE_CONNECTION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.967 -0400", hash_original_field = "1387A961107046D1D5C0AF0A788387C3", hash_generated_field = "8B588420585076DE71C81EF5F52F758F")

    public static final int REQUEST_TYPE_PHONEBOOK_ACCESS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.967 -0400", hash_original_field = "86F32EBF9544F1167FD3E6A050F6E432", hash_generated_field = "CB09234F8DB8A5944B2863FBC4C9A56F")

    public static final String EXTRA_PACKAGE_NAME = "android.bluetooth.device.extra.PACKAGE_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.967 -0400", hash_original_field = "75DCC28F92B90DD5657545F3812B9CC0", hash_generated_field = "238C2029F5FEBE702D24C51CD2B3CD61")

    public static final String EXTRA_CLASS_NAME = "android.bluetooth.device.extra.CLASS_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.967 -0400", hash_original_field = "C59EBBB2C7DA51580702A05CF5C18608", hash_generated_field = "86A5B73016B42925DBEA2AE2BB2F9C71")

    public static final String EXTRA_CONNECTION_ACCESS_RESULT =
        "android.bluetooth.device.extra.CONNECTION_ACCESS_RESULT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.967 -0400", hash_original_field = "8F76C7B5CE0B748865791CFEBBFCA99A", hash_generated_field = "BA86304A135D5C4ED091C4E2EF31C347")

    public static final int CONNECTION_ACCESS_YES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.968 -0400", hash_original_field = "8B273791D872CC5067F5FC6540E7721C", hash_generated_field = "53DD467645EBD5C12A40E7ED122AC1B8")

    public static final int CONNECTION_ACCESS_NO = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.968 -0400", hash_original_field = "64CECBA93A7CE93B858DEC71DB1817F0", hash_generated_field = "513D19DA01C7D694B4E6F2C3767C785E")

    public static final String EXTRA_ALWAYS_ALLOWED =
        "android.bluetooth.device.extra.ALWAYS_ALLOWED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.968 -0400", hash_original_field = "B42D1DD033BF87AF1C315AE00AED77FF", hash_generated_field = "A161A3950BFED84C7629E217BABEAD5D")

    public static final int BOND_SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.968 -0400", hash_original_field = "38FF28D6197F9106C1D81969F9BBB069", hash_generated_field = "B8DAA73E26E42DC403271DEAE4ADC762")

    public static final int UNBOND_REASON_AUTH_FAILED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.968 -0400", hash_original_field = "1DB144DC14F509A558A7A62BCC75280D", hash_generated_field = "E846B4B9AD5EAB830BC7B62CABF3C03C")

    public static final int UNBOND_REASON_AUTH_REJECTED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.968 -0400", hash_original_field = "D317B00D2E85F35138ECEDA41F976D6E", hash_generated_field = "AEFE8CCB30D19D2E6BC0C9C08BD3F1D7")

    public static final int UNBOND_REASON_AUTH_CANCELED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.968 -0400", hash_original_field = "8108A333CF52C78B9109931B0A7D1932", hash_generated_field = "9CDFD5DE9A4A71BE1DAF134EC5641A51")

    public static final int UNBOND_REASON_REMOTE_DEVICE_DOWN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.968 -0400", hash_original_field = "C65CE275521BB208F0FE413C31F77EBB", hash_generated_field = "916950BAB80A1434167B19F1E37E5BC0")

    public static final int UNBOND_REASON_DISCOVERY_IN_PROGRESS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.968 -0400", hash_original_field = "04B25B26B5A2AF20320BC1C367CB58CA", hash_generated_field = "F06644268169653EE0227EBC163D060C")

    public static final int UNBOND_REASON_AUTH_TIMEOUT = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.968 -0400", hash_original_field = "F1FE387E98D73143330206EADD35DBFE", hash_generated_field = "ACC256ABE8A1A3C85BCEC1E8CE122192")

    public static final int UNBOND_REASON_REPEATED_ATTEMPTS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.969 -0400", hash_original_field = "FF49F25F50368C4EDC8545EC90AB58E6", hash_generated_field = "4CDECB927EAFFE0F47859DF55EC902A4")

    public static final int UNBOND_REASON_REMOTE_AUTH_CANCELED = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.969 -0400", hash_original_field = "FAE4903E416F047C1D40AD0BD80F6D04", hash_generated_field = "A8E8D4B38BED3D6C11339900C1B21168")

    public static final int UNBOND_REASON_REMOVED = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.969 -0400", hash_original_field = "D1D74B75B18EB4496C7E58542B505490", hash_generated_field = "FAF1B177681A1566A51B58850BEB6E02")

    public static final int PAIRING_VARIANT_PIN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.969 -0400", hash_original_field = "6C724DE5B006A3F73FB913A994F6961F", hash_generated_field = "17898A0C3457A46EED8AC954601C4A7B")

    public static final int PAIRING_VARIANT_PASSKEY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.969 -0400", hash_original_field = "EE022AF33835899B08064EE2A57146E9", hash_generated_field = "04B5A34CCD218E6B0DF17F80208DF9E4")

    public static final int PAIRING_VARIANT_PASSKEY_CONFIRMATION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.969 -0400", hash_original_field = "DB27483441752407BECD41C6D3907A2A", hash_generated_field = "F16890B141E8D6D03D7595708D020B46")

    public static final int PAIRING_VARIANT_CONSENT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.969 -0400", hash_original_field = "0BDFCC5F1DD1AE04CDCFF4E41F605DBF", hash_generated_field = "28AE463F9A73EEC5B6370E6E23631CEF")

    public static final int PAIRING_VARIANT_DISPLAY_PASSKEY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.970 -0400", hash_original_field = "FB2EE0BECF5664110D32522FFEFF0A66", hash_generated_field = "7D5CE3CA462576238F59528ABDFBFFFF")

    public static final int PAIRING_VARIANT_DISPLAY_PIN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.970 -0400", hash_original_field = "8682EC4CA5A8EA713DFF936F099CEC9E", hash_generated_field = "C7131CC89C1F9C9DA4AA81E60DC825EF")

    public static final int PAIRING_VARIANT_OOB_CONSENT = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.970 -0400", hash_original_field = "0ED63EA53E74CA55827685B883E2F542", hash_generated_field = "3FD4E265FDA480EC06269FDD7BB1835C")

    public static final String EXTRA_UUID = "android.bluetooth.device.extra.UUID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.970 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "EF6C161DCF4991D50ACC704D0B154E87")

    private static IBluetooth sService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.970 -0400", hash_original_field = "805C2A0D29EE0E340AA50FC4D7B2BA5A", hash_generated_field = "DC29E2B18FDC52581EFA562E0AD2A0AB")

    public static final Parcelable.Creator<BluetoothDevice> CREATOR =
            new Parcelable.Creator<BluetoothDevice>() {
        public BluetoothDevice createFromParcel(Parcel in) {
            return new BluetoothDevice(in.readString());
        }
        public BluetoothDevice[] newArray(int size) {
            return new BluetoothDevice[size];
        }
    };
}

