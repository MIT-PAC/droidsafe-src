package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
    private static final String TAG = "BluetoothDevice";
    public static final int ERROR = Integer.MIN_VALUE;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_FOUND =
            "android.bluetooth.device.action.FOUND";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DISAPPEARED =
            "android.bluetooth.device.action.DISAPPEARED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CLASS_CHANGED =
            "android.bluetooth.device.action.CLASS_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ACL_CONNECTED =
            "android.bluetooth.device.action.ACL_CONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ACL_DISCONNECT_REQUESTED =
            "android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ACL_DISCONNECTED =
            "android.bluetooth.device.action.ACL_DISCONNECTED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NAME_CHANGED =
            "android.bluetooth.device.action.NAME_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BOND_STATE_CHANGED =
            "android.bluetooth.device.action.BOND_STATE_CHANGED";
    public static final String EXTRA_DEVICE = "android.bluetooth.device.extra.DEVICE";
    public static final String EXTRA_NAME = "android.bluetooth.device.extra.NAME";
    public static final String EXTRA_RSSI = "android.bluetooth.device.extra.RSSI";
    public static final String EXTRA_CLASS = "android.bluetooth.device.extra.CLASS";
    public static final String EXTRA_BOND_STATE = "android.bluetooth.device.extra.BOND_STATE";
    public static final String EXTRA_PREVIOUS_BOND_STATE =
            "android.bluetooth.device.extra.PREVIOUS_BOND_STATE";
    public static final int BOND_NONE = 10;
    public static final int BOND_BONDING = 11;
    public static final int BOND_BONDED = 12;
    public static final String EXTRA_REASON = "android.bluetooth.device.extra.REASON";
    public static final String EXTRA_PAIRING_VARIANT =
            "android.bluetooth.device.extra.PAIRING_VARIANT";
    public static final String EXTRA_PAIRING_KEY = "android.bluetooth.device.extra.PAIRING_KEY";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_UUID =
            "android.bluetooth.device.action.UUID";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NAME_FAILED =
            "android.bluetooth.device.action.NAME_FAILED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PAIRING_REQUEST =
            "android.bluetooth.device.action.PAIRING_REQUEST";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PAIRING_CANCEL =
            "android.bluetooth.device.action.PAIRING_CANCEL";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_ACCESS_REQUEST =
            "android.bluetooth.device.action.CONNECTION_ACCESS_REQUEST";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_ACCESS_REPLY =
            "android.bluetooth.device.action.CONNECTION_ACCESS_REPLY";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_ACCESS_CANCEL =
            "android.bluetooth.device.action.CONNECTION_ACCESS_CANCEL";
    public static final String EXTRA_ACCESS_REQUEST_TYPE =
        "android.bluetooth.device.extra.ACCESS_REQUEST_TYPE";
    public static final int REQUEST_TYPE_PROFILE_CONNECTION = 1;
    public static final int REQUEST_TYPE_PHONEBOOK_ACCESS = 2;
    public static final String EXTRA_PACKAGE_NAME = "android.bluetooth.device.extra.PACKAGE_NAME";
    public static final String EXTRA_CLASS_NAME = "android.bluetooth.device.extra.CLASS_NAME";
    public static final String EXTRA_CONNECTION_ACCESS_RESULT =
        "android.bluetooth.device.extra.CONNECTION_ACCESS_RESULT";
    public static final int CONNECTION_ACCESS_YES = 1;
    public static final int CONNECTION_ACCESS_NO = 2;
    public static final String EXTRA_ALWAYS_ALLOWED =
        "android.bluetooth.device.extra.ALWAYS_ALLOWED";
    public static final int BOND_SUCCESS = 0;
    public static final int UNBOND_REASON_AUTH_FAILED = 1;
    public static final int UNBOND_REASON_AUTH_REJECTED = 2;
    public static final int UNBOND_REASON_AUTH_CANCELED = 3;
    public static final int UNBOND_REASON_REMOTE_DEVICE_DOWN = 4;
    public static final int UNBOND_REASON_DISCOVERY_IN_PROGRESS = 5;
    public static final int UNBOND_REASON_AUTH_TIMEOUT = 6;
    public static final int UNBOND_REASON_REPEATED_ATTEMPTS = 7;
    public static final int UNBOND_REASON_REMOTE_AUTH_CANCELED = 8;
    public static final int UNBOND_REASON_REMOVED = 9;
    public static final int PAIRING_VARIANT_PIN = 0;
    public static final int PAIRING_VARIANT_PASSKEY = 1;
    public static final int PAIRING_VARIANT_PASSKEY_CONFIRMATION = 2;
    public static final int PAIRING_VARIANT_CONSENT = 3;
    public static final int PAIRING_VARIANT_DISPLAY_PASSKEY = 4;
    public static final int PAIRING_VARIANT_DISPLAY_PIN = 5;
    public static final int PAIRING_VARIANT_OOB_CONSENT = 6;
    public static final String EXTRA_UUID = "android.bluetooth.device.extra.UUID";
    private static IBluetooth sService;
    private final String mAddress;
    public static final Parcelable.Creator<BluetoothDevice> CREATOR = new Parcelable.Creator<BluetoothDevice>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.102 -0400", hash_original_method = "D012F0D6259F922F17728A0868DC817A", hash_generated_method = "DC9F0573C759BD5A848E77B4AEF73235")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BluetoothDevice createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            BluetoothDevice var63E0EF375A73533D1AC1DFDD9C9CCA02_1637012367 = (new BluetoothDevice(in.readString()));
            return (BluetoothDevice)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BluetoothDevice(in.readString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.102 -0400", hash_original_method = "8BCAF01D794E08EA29BE93F5B1CF772C", hash_generated_method = "942219EA3BD8EF729DD7BC9C54C1454C")
        @DSModeled(DSC.SAFE)
        public BluetoothDevice[] newArray(int size) {
            dsTaint.addTaint(size);
            return (BluetoothDevice[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BluetoothDevice[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.103 -0400", hash_original_method = "01E6ABA43F371BE96DE0741E69CF2696", hash_generated_method = "6AFAAD371440E2BBED18FD8E8C75934C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     BluetoothDevice(String address) {
        dsTaint.addTaint(address);
        getService();
        {
            boolean varD73B4433999E31B5BD12C61E2C084961_109647470 = (!BluetoothAdapter.checkBluetoothAddress(address));
            {
                throw new IllegalArgumentException(address + " is not a valid Bluetooth address");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //getService();
        //if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            //throw new IllegalArgumentException(address + " is not a valid Bluetooth address");
        //}
        //mAddress = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.103 -0400", hash_original_method = "B0796CDCCC198F5133D1C780F27F0FFA", hash_generated_method = "A33AAC12BB252B20DAA5E7A5619BAA78")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.103 -0400", hash_original_method = "DA80DFD3FFE970A9DEF6CBF59BD17BFE", hash_generated_method = "B459BB5758DAFD67A8790320564EEC69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var8D8910C65D868943981CE0BFEF9487E0_1261287978 = (mAddress.equals(((BluetoothDevice)o).getAddress()));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o instanceof BluetoothDevice) {
            //return mAddress.equals(((BluetoothDevice)o).getAddress());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.104 -0400", hash_original_method = "7AEEB42D289D7509B50F97CB867AEDF2", hash_generated_method = "E56A67ABE6E03D4EBFA4016C8F4E361F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var9CCD53BFBFD87D55CF50049B51E74EFD_1281256240 = (mAddress.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAddress.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.104 -0400", hash_original_method = "4F994B6046AF4A420304240B51CB4CC6", hash_generated_method = "D733B797694AA503C7A00B906DCF707A")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.104 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.105 -0400", hash_original_method = "355A6B197E6D06E20E4355217F5ABC70", hash_generated_method = "41377EC47AB5E83C6FEAAEBB51922904")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeString(mAddress);
        // ---------- Original Method ----------
        //out.writeString(mAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.105 -0400", hash_original_method = "BD85A48E5B7DC741C80D75F9CC9D3A4A", hash_generated_method = "CEE0C74AAC42055E89B7991FA8704299")
    @DSModeled(DSC.SAFE)
    public String getAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.105 -0400", hash_original_method = "027728A71FD2E55E5703A638CB89EB2E", hash_generated_method = "5857046BFC32C43476765FAEBA66A77B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        try 
        {
            String var53E8650BD4BF89FE00BA6931138BD87C_1325860437 = (sService.getRemoteName(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return sService.getRemoteName(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.106 -0400", hash_original_method = "3D31424D7A0639D60E5B5097A46F207C", hash_generated_method = "7216611B477F6A4F6AA3D135FFE836D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAlias() {
        try 
        {
            String var75C920E477BF723306EC211332CF0D98_638927250 = (sService.getRemoteAlias(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return sService.getRemoteAlias(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.106 -0400", hash_original_method = "49B51B4B037A5C39323EEFF06458ED35", hash_generated_method = "453E34DD6E011FADD257624CA3C92528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setAlias(String alias) {
        dsTaint.addTaint(alias);
        try 
        {
            boolean var538A43DC7ED1D693FA589F3D281623E5_1327049588 = (sService.setRemoteAlias(mAddress, alias));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.setRemoteAlias(mAddress, alias);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.106 -0400", hash_original_method = "0C2F081FEB58CFB1BA7C24E91B419B7D", hash_generated_method = "0BF00191568B219A099515ED75EC2E69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAliasName() {
        String name;
        name = getAlias();
        {
            name = getName();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String name = getAlias();
        //if (name == null) {
            //name = getName();
        //}
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.107 -0400", hash_original_method = "7ABDE8D07F07F9433B847CB6022477DB", hash_generated_method = "E8FBBD4286B9F9003294E40E60AE0679")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean createBond() {
        try 
        {
            boolean var3DE2205B57B519117333561C3657A159_95166425 = (sService.createBond(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.createBond(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.107 -0400", hash_original_method = "211570B5CDF01B6AE01B8C3D0317F2CB", hash_generated_method = "6848DEA86E2BDCCFA196AAA814A4F00A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean createBondOutOfBand(byte[] hash, byte[] randomizer) {
        dsTaint.addTaint(hash);
        dsTaint.addTaint(randomizer);
        try 
        {
            boolean var2DA5BF6569279AD61AA382EACDC6FFAE_937092718 = (sService.createBondOutOfBand(mAddress, hash, randomizer));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.createBondOutOfBand(mAddress, hash, randomizer);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.107 -0400", hash_original_method = "575E29F4E8B829BD0D23FAC1ADF3E1AA", hash_generated_method = "9CCDCCA4DBA345824664B26C2B2ADF1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setDeviceOutOfBandData(byte[] hash, byte[] randomizer) {
        dsTaint.addTaint(hash);
        dsTaint.addTaint(randomizer);
        try 
        {
            boolean var0D5F39B40F6B146B1CFEC7F2F2D57947_1353601563 = (sService.setDeviceOutOfBandData(mAddress, hash, randomizer));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
        //return sService.setDeviceOutOfBandData(mAddress, hash, randomizer);
      //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.108 -0400", hash_original_method = "0C0048A8FF7823EF43482AC4C17114D5", hash_generated_method = "9A3BD575E5288BF17667FF2D87D4D865")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean cancelBondProcess() {
        try 
        {
            boolean var5E6931FB1278859E05DAAF08C893FA2C_2024832111 = (sService.cancelBondProcess(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.cancelBondProcess(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.108 -0400", hash_original_method = "2ABE478EBB53F919726366CC411EDF02", hash_generated_method = "D71F8A21CF8986E4DD82C3C0671D3A09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeBond() {
        try 
        {
            boolean var90C729B71BEF214ADAB4645FAEFFD0C6_18088878 = (sService.removeBond(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.removeBond(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.108 -0400", hash_original_method = "D50E996B702CE09ED98935B433818740", hash_generated_method = "B0E7EC1E34F4B3C5876824F9EEF4A8DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBondState() {
        try 
        {
            int var8569A444E8A2A055559F3F95521052BF_1952724681 = (sService.getBondState(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return sService.getBondState(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return BOND_NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.109 -0400", hash_original_method = "EF524B188F92A45A25D7F167D0B007CD", hash_generated_method = "6AD93CA36D7E15BED9F5454DF10A890A")
    @DSModeled(DSC.SAFE)
    public BluetoothClass getBluetoothClass() {
        try 
        {
            int classInt;
            classInt = sService.getRemoteClass(mAddress);
        } //End block
        catch (RemoteException e)
        { }
        return (BluetoothClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //int classInt = sService.getRemoteClass(mAddress);
            //if (classInt == BluetoothClass.ERROR) return null;
            //return new BluetoothClass(classInt);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.109 -0400", hash_original_method = "31D115AB32A31FB0B9AF4C26A4E47F46", hash_generated_method = "E5C019949125A6F0ED3CD9C707BDC624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getTrustState() {
        try 
        {
            boolean varD7C59CBCCAC8E294A7FB5CE3C0C5DBD5_22815701 = (sService.getTrustState(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.getTrustState(mAddress);
        //} catch (RemoteException e) {
            //Log.e(TAG, "", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.109 -0400", hash_original_method = "9D6C6E6815AA7950FF362F094CFFC963", hash_generated_method = "5FDF96878A7662A72EB65080E51D64C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setTrust(boolean value) {
        dsTaint.addTaint(value);
        try 
        {
            boolean varB0EA81C5E72633EFE5AF71D6D17FFE5D_561241006 = (sService.setTrust(mAddress, value));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.setTrust(mAddress, value);
        //} catch (RemoteException e) {
            //Log.e(TAG, "", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.110 -0400", hash_original_method = "E2768C133840A39718DB537E54814CD2", hash_generated_method = "70626A7EA896979F6A70F374938A7827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParcelUuid[] getUuids() {
        try 
        {
            ParcelUuid[] var3EBE410A0F58C24C84B16E99E8FE9EF1_167598388 = (sService.getRemoteUuids(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return (ParcelUuid[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return sService.getRemoteUuids(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.110 -0400", hash_original_method = "DEDB39F51E4B34081515EA0E29E542CE", hash_generated_method = "9E632A55A37D1311561E8084675BCB79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean fetchUuidsWithSdp() {
        try 
        {
            boolean var85A88A6C42154ED984EAE3508DFA734B_1101662222 = (sService.fetchRemoteUuids(mAddress, null, null));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.fetchRemoteUuids(mAddress, null, null);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.110 -0400", hash_original_method = "3159A609DA44BB79D68A9974B9B6A655", hash_generated_method = "8FF20F86FCFC73449C0678EA5E180B93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getServiceChannel(ParcelUuid uuid) {
        dsTaint.addTaint(uuid.dsTaint);
        try 
        {
            int var881FE11A29C862568E524F89FDCE45C8_1792238212 = (sService.getRemoteServiceChannel(mAddress, uuid));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
             //return sService.getRemoteServiceChannel(mAddress, uuid);
         //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return BluetoothDevice.ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.111 -0400", hash_original_method = "0C2B72A87477D43DC574495BFD9C1EAD", hash_generated_method = "06715DFB49310404FE249375E93893C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setPin(byte[] pin) {
        dsTaint.addTaint(pin);
        try 
        {
            boolean var52AB39FBF2097900F1667EDE8F52C241_904594651 = (sService.setPin(mAddress, pin));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.setPin(mAddress, pin);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.111 -0400", hash_original_method = "3609F7C358721757CCD34D699F0B8CE9", hash_generated_method = "6A588181A71E8F03C8B8D5AD1D7B7606")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setPasskey(int passkey) {
        dsTaint.addTaint(passkey);
        try 
        {
            boolean varC31D09ED39F0E4C979A474459A34B4E7_297292636 = (sService.setPasskey(mAddress, passkey));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.setPasskey(mAddress, passkey);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.111 -0400", hash_original_method = "C6032CF5D33EF2ED9DD2C95EBB11B5A2", hash_generated_method = "255F12296095272BE2AC9258DB50A142")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setPairingConfirmation(boolean confirm) {
        dsTaint.addTaint(confirm);
        try 
        {
            boolean var2EC1E46C46D4CC2BF015EC3F5C3392A7_86752586 = (sService.setPairingConfirmation(mAddress, confirm));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.setPairingConfirmation(mAddress, confirm);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.112 -0400", hash_original_method = "23E27132155361CD962933565A6A609F", hash_generated_method = "F386C70A86CD1CA78167C1AFF3A292A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setRemoteOutOfBandData() {
        try 
        {
            boolean var8C66F14D875AAB2FA96425EBEC320680_1162577571 = (sService.setRemoteOutOfBandData(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
          //return sService.setRemoteOutOfBandData(mAddress);
      //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.112 -0400", hash_original_method = "52E8DE9DDBFDE18365F513F918590AAC", hash_generated_method = "E867C5EAD4ECA388A565FE280835EF8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean cancelPairingUserInput() {
        try 
        {
            boolean var6C1C9639525B689D57D1ED1BE29481A3_1879981742 = (sService.cancelPairingUserInput(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.cancelPairingUserInput(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.112 -0400", hash_original_method = "C1B670BF8E55A118E70A73AF396353BD", hash_generated_method = "4D509DB391EC7D90C47286883A0F5C92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBluetoothDock() {
        try 
        {
            boolean var062412069D2201F7F30D32A5F0C69914_1323821706 = (sService.isBluetoothDock(mAddress));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sService.isBluetoothDock(mAddress);
        //} catch (RemoteException e) {Log.e(TAG, "", e);}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.113 -0400", hash_original_method = "98EAE836400D818BB4CCAFDB9F3FE0E9", hash_generated_method = "82950125167F5236F99C8F5555530052")
    @DSModeled(DSC.SAFE)
    public BluetoothSocket createRfcommSocket(int channel) throws IOException {
        dsTaint.addTaint(channel);
        return (BluetoothSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, true, true, this, channel,
                //null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.113 -0400", hash_original_method = "673893485928B830B2C44FE0F9C84083", hash_generated_method = "4A5112B3698A0F4E37E96EAAA702A5C5")
    @DSModeled(DSC.SAFE)
    public BluetoothSocket createRfcommSocketToServiceRecord(UUID uuid) throws IOException {
        dsTaint.addTaint(uuid.dsTaint);
        return (BluetoothSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, true, true, this, -1,
                //new ParcelUuid(uuid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.113 -0400", hash_original_method = "8A29B36723BF3024D765B326A6835F52", hash_generated_method = "E10D54FFEE51AB0EB924D110187EEB6F")
    @DSModeled(DSC.SAFE)
    public BluetoothSocket createInsecureRfcommSocketToServiceRecord(UUID uuid) throws IOException {
        dsTaint.addTaint(uuid.dsTaint);
        return (BluetoothSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, false, false, this, -1,
                //new ParcelUuid(uuid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.114 -0400", hash_original_method = "65B6B4065AE19FE91B1B928AB482A400", hash_generated_method = "2CCCED676F645AF3BC91EEA73942710D")
    @DSModeled(DSC.SAFE)
    public BluetoothSocket createInsecureRfcommSocket(int port) throws IOException {
        dsTaint.addTaint(port);
        return (BluetoothSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, false, false, this, port,
                //null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.114 -0400", hash_original_method = "A2683B7D001B6D4367715042EC6C96CC", hash_generated_method = "618824591DC255E8122276E84C4569A1")
    @DSModeled(DSC.SAFE)
    public BluetoothSocket createScoSocket() throws IOException {
        return (BluetoothSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BluetoothSocket(BluetoothSocket.TYPE_SCO, -1, true, true, this, -1, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.114 -0400", hash_original_method = "7283B730E23CF76E918B6507D245B3B6", hash_generated_method = "A850F0727BC2E4B5B9A61C8C5DE5E922")
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

    
}


