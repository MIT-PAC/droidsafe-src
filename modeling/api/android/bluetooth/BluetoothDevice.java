package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public final class BluetoothDevice implements Parcelable {

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.730 -0500", hash_original_method = "B0796CDCCC198F5133D1C780F27F0FFA", hash_generated_method = "A33AAC12BB252B20DAA5E7A5619BAA78")
    
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

    /**
     * Check that a pin is valid and convert to byte array.
     *
     * Bluetooth pin's are 1 to 16 bytes of UTF-8 characters.
     * @param pin pin as java String
     * @return the pin code as a UTF-8 byte array, or null if it is an invalid
     *         Bluetooth pin.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.816 -0500", hash_original_method = "7283B730E23CF76E918B6507D245B3B6", hash_generated_method = "743A7251449C0A32C2DFA041DA0279BF")
    
public static byte[] convertPinToBytes(String pin) {
        if (pin == null) {
            return null;
        }
        byte[] pinBytes;
        try {
            pinBytes = pin.getBytes("UTF-8");
        } catch (UnsupportedEncodingException uee) {
            Log.e(TAG, "UTF-8 not supported?!?");  // this should not happen
            return null;
        }
        if (pinBytes.length <= 0 || pinBytes.length > 16) {
            return null;
        }
        return pinBytes;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.591 -0500", hash_original_field = "05875E3642EB2950C6E7795FFFAEA2C1", hash_generated_field = "56404D337E5A358E74D107F5362299C0")

    private static final String TAG = "BluetoothDevice";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.593 -0500", hash_original_field = "84E830C145C042EC11E2544A046AA563", hash_generated_field = "6AF8DDE3A6777A538F89C7DEB17C8CE1")

    public static final int ERROR = Integer.MIN_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.595 -0500", hash_original_field = "1D1AEB7A2B1FF4E42FC3E6C0702E262F", hash_generated_field = "1A0BB74203DCB52D074D1ACBAC576678")

     // TODO: Change API to not broadcast RSSI if not available (incoming connection)
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_FOUND =
            "android.bluetooth.device.action.FOUND";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.598 -0500", hash_original_field = "931716C876DE9C3E5E5D65A912687A1C", hash_generated_field = "8AAF232769CD19DC423585CDE6D13E58")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DISAPPEARED =
            "android.bluetooth.device.action.DISAPPEARED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.601 -0500", hash_original_field = "BE14264C61577728E670596A2D2045E6", hash_generated_field = "FED039F1A07FD22EF11BAA6C2D42367B")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CLASS_CHANGED =
            "android.bluetooth.device.action.CLASS_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.603 -0500", hash_original_field = "EC851C6946108799C20F4C06806DCFFB", hash_generated_field = "3EA28AF16B411BF0A8FEE73EF953E4B3")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ACL_CONNECTED =
            "android.bluetooth.device.action.ACL_CONNECTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.606 -0500", hash_original_field = "5332D24965DB516807C03A4A906FAEC6", hash_generated_field = "3554F5DEA2DBAF437F4A80AE347DB5ED")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ACL_DISCONNECT_REQUESTED =
            "android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.608 -0500", hash_original_field = "C032D9D400F4044DAA8319440D8DE7A8", hash_generated_field = "3DBD02811765575C6CA7BD8A9931CD4A")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ACL_DISCONNECTED =
            "android.bluetooth.device.action.ACL_DISCONNECTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.611 -0500", hash_original_field = "B8E3957F61A3D7D5D5749C729AE64292", hash_generated_field = "016E52AC9FCFF7E766426978C91648EE")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NAME_CHANGED =
            "android.bluetooth.device.action.NAME_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.613 -0500", hash_original_field = "270B614AD517325CB950B175219A807F", hash_generated_field = "66859F0DCC013D8E8A68978114D95D79")

    // Note: When EXTRA_BOND_STATE is BOND_NONE then this will also
    // contain a hidden extra field EXTRA_REASON with the result code.
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BOND_STATE_CHANGED =
            "android.bluetooth.device.action.BOND_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.616 -0500", hash_original_field = "DC21C53386F7539EDC5B786AF144D686", hash_generated_field = "30AF2264E5D341E15F5421C9E8946DB3")

    public static final String EXTRA_DEVICE = "android.bluetooth.device.extra.DEVICE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.618 -0500", hash_original_field = "FEF18B0F6B6F5DF079E467FB03C82BC4", hash_generated_field = "0275E45EA81E0F34B48E2CFAC9208AA7")

    public static final String EXTRA_NAME = "android.bluetooth.device.extra.NAME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.620 -0500", hash_original_field = "6658F7EA7A463B5A5C8537CF8A308D70", hash_generated_field = "5FFDC1C615410E85BEE058B01505C415")

    public static final String EXTRA_RSSI = "android.bluetooth.device.extra.RSSI";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.622 -0500", hash_original_field = "DC9C67B6B0F2E1C08D397032F169C157", hash_generated_field = "0B8F1097ACE49FF2FE92D295B330C945")

    public static final String EXTRA_CLASS = "android.bluetooth.device.extra.CLASS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.625 -0500", hash_original_field = "C2CAA7DD2E56BCEFE1C94C4BA0B53CD6", hash_generated_field = "F74422703F4629CF9E21B0910D89E4E1")

    public static final String EXTRA_BOND_STATE = "android.bluetooth.device.extra.BOND_STATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.628 -0500", hash_original_field = "C55196D35633A2EFB2BF924F9C87BD70", hash_generated_field = "D1160470D82FAF8A08FCFE8C151F9AD6")

    public static final String EXTRA_PREVIOUS_BOND_STATE =
            "android.bluetooth.device.extra.PREVIOUS_BOND_STATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.630 -0500", hash_original_field = "76C54FA12392850EA08B0461030CC930", hash_generated_field = "0CDC0FEFDF97CC31246B7A4ED35988A9")

    public static final int BOND_NONE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.633 -0500", hash_original_field = "770FA56A672881D108A052F3F0DD0865", hash_generated_field = "FFC46D2D401FEEC969455B5830EF2FBF")

    public static final int BOND_BONDING = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.635 -0500", hash_original_field = "014AC302A91F59A2A368B97C7BB6290A", hash_generated_field = "8A8CCC3ED5A2B080DB1FCAB9BCD5ED7B")

    public static final int BOND_BONDED = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.637 -0500", hash_original_field = "18EE306710DC8991BCC62BBF9ACCB5A3", hash_generated_field = "AA6F32BD9B0C4442647CCA9501B603AC")

    public static final String EXTRA_REASON = "android.bluetooth.device.extra.REASON";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.640 -0500", hash_original_field = "5888AE626701BFBC64E64583AA2FB28E", hash_generated_field = "F789A73DACB5CAB1875DFEE053C5249D")

    public static final String EXTRA_PAIRING_VARIANT =
            "android.bluetooth.device.extra.PAIRING_VARIANT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.642 -0500", hash_original_field = "9710777821B06FD09F4E7BE406614C42", hash_generated_field = "06EFF6EE188208B5D6DA27B05863A587")

    public static final String EXTRA_PAIRING_KEY = "android.bluetooth.device.extra.PAIRING_KEY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.644 -0500", hash_original_field = "C55CACC9F900788F0D5E7079F34365B1", hash_generated_field = "E952ED271908E1C567F82857231C9C45")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_UUID =
            "android.bluetooth.device.action.UUID";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.647 -0500", hash_original_field = "ACE1EFB508D9E88BD58404BA6CE65DE3", hash_generated_field = "29ECA85730E339F464D5ABFF42311E76")

    //TODO: is this actually useful?
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NAME_FAILED =
            "android.bluetooth.device.action.NAME_FAILED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.649 -0500", hash_original_field = "7A58BE2117E043E3D9FC2C4DA34A897A", hash_generated_field = "A255D1D6DC5A95D39F27FFB41250F214")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PAIRING_REQUEST =
            "android.bluetooth.device.action.PAIRING_REQUEST";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.652 -0500", hash_original_field = "57DD8065FAA1F85BEC070BFD640F6C31", hash_generated_field = "A3C01E7EDB4A98C364524CEB0953DB6F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PAIRING_CANCEL =
            "android.bluetooth.device.action.PAIRING_CANCEL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.655 -0500", hash_original_field = "FE7B1214C6835D9242B20C5B4D8A660F", hash_generated_field = "61430413A16DD760E9391A133DCDACF6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_ACCESS_REQUEST =
            "android.bluetooth.device.action.CONNECTION_ACCESS_REQUEST";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.657 -0500", hash_original_field = "AFDDDD89B7D89129EAC28722A2500D58", hash_generated_field = "752165CCA7617776DBEB3E09143BB5DC")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_ACCESS_REPLY =
            "android.bluetooth.device.action.CONNECTION_ACCESS_REPLY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.660 -0500", hash_original_field = "ED5C1B4B555B4CB3E5ADC744D8CC3600", hash_generated_field = "95337666F7DCC1F11183D2CA4A2862FF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONNECTION_ACCESS_CANCEL =
            "android.bluetooth.device.action.CONNECTION_ACCESS_CANCEL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.662 -0500", hash_original_field = "02EB6C8715E030DB80901E54C3730BBC", hash_generated_field = "03F720811CE25FFB681F78056FAF7880")

    public static final String EXTRA_ACCESS_REQUEST_TYPE =
        "android.bluetooth.device.extra.ACCESS_REQUEST_TYPE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.664 -0500", hash_original_field = "6F7E7684DC6CC15D2BF92079CD444932", hash_generated_field = "9D5A24B8B8752C28A2576C8B3B255196")

    public static final int REQUEST_TYPE_PROFILE_CONNECTION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.666 -0500", hash_original_field = "C56B8D9FBBB2C624BE3E96B8F035A8F3", hash_generated_field = "8B588420585076DE71C81EF5F52F758F")

    public static final int REQUEST_TYPE_PHONEBOOK_ACCESS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.669 -0500", hash_original_field = "72C44A097EFD4A7CF2A06F8EE90D964F", hash_generated_field = "CB09234F8DB8A5944B2863FBC4C9A56F")

    public static final String EXTRA_PACKAGE_NAME = "android.bluetooth.device.extra.PACKAGE_NAME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.671 -0500", hash_original_field = "A2CCD6CADB34EE3910C6D7B541194FB7", hash_generated_field = "238C2029F5FEBE702D24C51CD2B3CD61")

    public static final String EXTRA_CLASS_NAME = "android.bluetooth.device.extra.CLASS_NAME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.674 -0500", hash_original_field = "621A6C2CE1B5028EF12F8E23F198E3F7", hash_generated_field = "86A5B73016B42925DBEA2AE2BB2F9C71")

    public static final String EXTRA_CONNECTION_ACCESS_RESULT =
        "android.bluetooth.device.extra.CONNECTION_ACCESS_RESULT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.676 -0500", hash_original_field = "B90D4A5B6709873DA1290AE1D224B57C", hash_generated_field = "BA86304A135D5C4ED091C4E2EF31C347")

    public static final int CONNECTION_ACCESS_YES = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.679 -0500", hash_original_field = "C6AA36FBE87725C9DC1FB87BC64F9EE1", hash_generated_field = "53DD467645EBD5C12A40E7ED122AC1B8")

    public static final int CONNECTION_ACCESS_NO = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.681 -0500", hash_original_field = "7EDE92C4827F32BB5E9C6EC00337C2AE", hash_generated_field = "513D19DA01C7D694B4E6F2C3767C785E")

    public static final String EXTRA_ALWAYS_ALLOWED =
        "android.bluetooth.device.extra.ALWAYS_ALLOWED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.684 -0500", hash_original_field = "971C951F75104E9D09EB1CAE5E6C2A85", hash_generated_field = "A161A3950BFED84C7629E217BABEAD5D")

    public static final int BOND_SUCCESS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.686 -0500", hash_original_field = "1F8D6840BE2D675C20970622C20FA5DE", hash_generated_field = "B8DAA73E26E42DC403271DEAE4ADC762")

    public static final int UNBOND_REASON_AUTH_FAILED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.688 -0500", hash_original_field = "967EC0FF20B700AEFF1F8BEB55B7A0F4", hash_generated_field = "E846B4B9AD5EAB830BC7B62CABF3C03C")

    public static final int UNBOND_REASON_AUTH_REJECTED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.691 -0500", hash_original_field = "9D121169A2E72D66E33405CC8A92DB78", hash_generated_field = "AEFE8CCB30D19D2E6BC0C9C08BD3F1D7")

    public static final int UNBOND_REASON_AUTH_CANCELED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.693 -0500", hash_original_field = "0960DC722078AB14CE4D599B5F129565", hash_generated_field = "9CDFD5DE9A4A71BE1DAF134EC5641A51")

    public static final int UNBOND_REASON_REMOTE_DEVICE_DOWN = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.695 -0500", hash_original_field = "1DC77176C902D863BD86BB9BC27AA9C8", hash_generated_field = "916950BAB80A1434167B19F1E37E5BC0")

    public static final int UNBOND_REASON_DISCOVERY_IN_PROGRESS = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.698 -0500", hash_original_field = "53B2AF779DA53D0BCBAEE1639E6B2B78", hash_generated_field = "F06644268169653EE0227EBC163D060C")

    public static final int UNBOND_REASON_AUTH_TIMEOUT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.700 -0500", hash_original_field = "4775B0CC60FAD9F2EAD0ED7212D8E4B2", hash_generated_field = "ACC256ABE8A1A3C85BCEC1E8CE122192")

    public static final int UNBOND_REASON_REPEATED_ATTEMPTS = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.702 -0500", hash_original_field = "814A9EBC004033F17FD953B05561C80E", hash_generated_field = "4CDECB927EAFFE0F47859DF55EC902A4")

    public static final int UNBOND_REASON_REMOTE_AUTH_CANCELED = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.705 -0500", hash_original_field = "16860CC425C2F9B918F0C4CF3D689196", hash_generated_field = "A8E8D4B38BED3D6C11339900C1B21168")

    public static final int UNBOND_REASON_REMOVED = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.707 -0500", hash_original_field = "E9FDBECB8FC5D2C3B0D3B09D8855D429", hash_generated_field = "FAF1B177681A1566A51B58850BEB6E02")

    public static final int PAIRING_VARIANT_PIN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.709 -0500", hash_original_field = "0313AE887433BF9BB18A65194FD5F270", hash_generated_field = "17898A0C3457A46EED8AC954601C4A7B")

    public static final int PAIRING_VARIANT_PASSKEY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.711 -0500", hash_original_field = "463126F6F4E4220521FC7F0A007227E9", hash_generated_field = "04B5A34CCD218E6B0DF17F80208DF9E4")

    public static final int PAIRING_VARIANT_PASSKEY_CONFIRMATION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.713 -0500", hash_original_field = "E18B0C24A87F77CB502DA2A420CBE033", hash_generated_field = "F16890B141E8D6D03D7595708D020B46")

    public static final int PAIRING_VARIANT_CONSENT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.716 -0500", hash_original_field = "2A606BFE2565F3BB9CF1FD9E5D1D3046", hash_generated_field = "28AE463F9A73EEC5B6370E6E23631CEF")

    public static final int PAIRING_VARIANT_DISPLAY_PASSKEY = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.719 -0500", hash_original_field = "E163EB8BE5920636D5670ADED79401C5", hash_generated_field = "7D5CE3CA462576238F59528ABDFBFFFF")

    public static final int PAIRING_VARIANT_DISPLAY_PIN = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.721 -0500", hash_original_field = "439582565D182CC1B2670743CEC7E839", hash_generated_field = "C7131CC89C1F9C9DA4AA81E60DC825EF")

    public static final int PAIRING_VARIANT_OOB_CONSENT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.723 -0500", hash_original_field = "5CBC32392F7E2CF60F9118A39492269F", hash_generated_field = "3FD4E265FDA480EC06269FDD7BB1835C")

    public static final String EXTRA_UUID = "android.bluetooth.device.extra.UUID";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.725 -0500", hash_original_field = "DAAF96B0F46D925261C401E63934266A", hash_generated_field = "EF6C161DCF4991D50ACC704D0B154E87")

    private static IBluetooth sService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.214 -0400", hash_original_field = "805C2A0D29EE0E340AA50FC4D7B2BA5A", hash_generated_field = "DC29E2B18FDC52581EFA562E0AD2A0AB")

    public static final Parcelable.Creator<BluetoothDevice> CREATOR =
            new Parcelable.Creator<BluetoothDevice>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.745 -0500", hash_original_method = "D012F0D6259F922F17728A0868DC817A", hash_generated_method = "E009A7829B0C84C12ADE75D532E2482E")
        
public BluetoothDevice createFromParcel(Parcel in) {
            return new BluetoothDevice(in.readString());
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.747 -0500", hash_original_method = "8BCAF01D794E08EA29BE93F5B1CF772C", hash_generated_method = "15FC2B6A98658578B8318443B9C9DC1B")
        
public BluetoothDevice[] newArray(int size) {
            return new BluetoothDevice[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.728 -0500", hash_original_field = "64574F15B680D9134BA948BCFB67DAB8", hash_generated_field = "C679AE506A0300BA50CA43522D6BE5D0")

    private  String mAddress;

    /**
     * Create a new BluetoothDevice
     * Bluetooth MAC address must be upper case, such as "00:11:22:33:AA:BB",
     * and is validated in this constructor.
     * @param address valid Bluetooth MAC address
     * @throws RuntimeException Bluetooth is not available on this platform
     * @throws IllegalArgumentException address is invalid
     * @hide
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.733 -0500", hash_original_method = "01E6ABA43F371BE96DE0741E69CF2696", hash_generated_method = "14317736164C3BE368BCBD12F4A080C4")
    
BluetoothDevice(String address) {
        getService();  // ensures sService is initialized
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            throw new IllegalArgumentException(address + " is not a valid Bluetooth address");
        }

        mAddress = address;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.735 -0500", hash_original_method = "DA80DFD3FFE970A9DEF6CBF59BD17BFE", hash_generated_method = "72DB427A9D6C92E324E11E59ED03FE54")
    
@Override
    public boolean equals(Object o) {
        if (o instanceof BluetoothDevice) {
            return mAddress.equals(((BluetoothDevice)o).getAddress());
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.737 -0500", hash_original_method = "7AEEB42D289D7509B50F97CB867AEDF2", hash_generated_method = "023B404E9C6EB592569CA62A5425AEF0")
    
@Override
    public int hashCode() {
        return mAddress.hashCode();
    }

    /**
     * Returns a string representation of this BluetoothDevice.
     * <p>Currently this is the Bluetooth hardware address, for example
     * "00:11:22:AA:BB:CC". However, you should always use {@link #getAddress}
     * if you explicitly require the Bluetooth hardware address in case the
     * {@link #toString} representation changes in the future.
     * @return string representation of this BluetoothDevice
     */
    @DSSource({DSSourceKind.BLUETOOTH})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.739 -0500", hash_original_method = "4F994B6046AF4A420304240B51CB4CC6", hash_generated_method = "16B0D7E7F85DDCED65B3F6C6B71A2104")
    
@Override
    public String toString() {
        return mAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.741 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.751 -0500", hash_original_method = "355A6B197E6D06E20E4355217F5ABC70", hash_generated_method = "B418A6E93F68338F54440004D2846E35")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeString(mAddress);
    }

    /**
     * Returns the hardware address of this BluetoothDevice.
     * <p> For example, "00:11:22:AA:BB:CC".
     * @return Bluetooth hardware address as string
     */
    @DSComment("Bluetooth subsystem")
    @DSSpec(DSCat.BLUETOOTH)
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.753 -0500", hash_original_method = "BD85A48E5B7DC741C80D75F9CC9D3A4A", hash_generated_method = "B33AAC87BF1F03A01C58BBB4B9D198BA")
    
public String getAddress() {
        return mAddress;
    }

    /**
     * Get the friendly Bluetooth name of the remote device.
     *
     * <p>The local adapter will automatically retrieve remote names when
     * performing a device scan, and will cache them. This method just returns
     * the name for this device from the cache.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH}
     *
     * @return the Bluetooth name, or null if there was a problem.
     */
    @DSComment("Bluetooth subsystem")
    @DSSpec(DSCat.BLUETOOTH)
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.756 -0500", hash_original_method = "027728A71FD2E55E5703A638CB89EB2E", hash_generated_method = "03266511763C6208D924449D71AFD630")
    
public String getName() {
        try {
            return sService.getRemoteName(mAddress);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return null;
    }

    /**
     * Get the Bluetooth alias of the remote device.
     * <p>Alias is the locally modified name of a remote device.
     *
     * @return the Bluetooth alias, or null if no alias or there was a problem
     * @hide
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.758 -0500", hash_original_method = "3D31424D7A0639D60E5B5097A46F207C", hash_generated_method = "2EE8E3E90EC1E2E0F61A5525062E4CF3")
    
public String getAlias() {
        try {
            return sService.getRemoteAlias(mAddress);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return null;
    }

    /**
     * Set the Bluetooth alias of the remote device.
     * <p>Alias is the locally modified name of a remote device.
     * <p>This methoid overwrites the alias. The changed
     * alias is saved in the local storage so that the change
     * is preserved over power cycle.
     *
     * @return true on success, false on error
     * @hide
     */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.761 -0500", hash_original_method = "49B51B4B037A5C39323EEFF06458ED35", hash_generated_method = "D3810794ECDDB2BC914673A78C4946E4")
    
public boolean setAlias(String alias) {
        try {
            return sService.setRemoteAlias(mAddress, alias);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /**
     * Get the Bluetooth alias of the remote device.
     * If Alias is null, get the Bluetooth name instead.
     * @see #getAlias()
     * @see #getName()
     *
     * @return the Bluetooth alias, or null if no alias or there was a problem
     * @hide
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.763 -0500", hash_original_method = "0C2F081FEB58CFB1BA7C24E91B419B7D", hash_generated_method = "DB72A4F603C952981DE2BFF87D6EED47")
    
public String getAliasName() {
        String name = getAlias();
        if (name == null) {
            name = getName();
        }
        return name;
    }

    /**
     * Start the bonding (pairing) process with the remote device.
     * <p>This is an asynchronous call, it will return immediately. Register
     * for {@link #ACTION_BOND_STATE_CHANGED} intents to be notified when
     * the bonding process completes, and its result.
     * <p>Android system services will handle the necessary user interactions
     * to confirm and complete the bonding process.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}.
     *
     * @return false on immediate error, true if bonding will begin
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.765 -0500", hash_original_method = "7ABDE8D07F07F9433B847CB6022477DB", hash_generated_method = "31096D68D0CE1B521AB2184AB0FD04BA")
    
public boolean createBond() {
        try {
            return sService.createBond(mAddress);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /**
     * Start the bonding (pairing) process with the remote device using the
     * Out Of Band mechanism.
     *
     * <p>This is an asynchronous call, it will return immediately. Register
     * for {@link #ACTION_BOND_STATE_CHANGED} intents to be notified when
     * the bonding process completes, and its result.
     *
     * <p>Android system services will handle the necessary user interactions
     * to confirm and complete the bonding process.
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}.
     *
     * @param hash - Simple Secure pairing hash
     * @param randomizer - The random key obtained using OOB
     * @return false on immediate error, true if bonding will begin
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.767 -0500", hash_original_method = "211570B5CDF01B6AE01B8C3D0317F2CB", hash_generated_method = "49B72E7E4EFA84C886E154FEFFAEFA4F")
    
public boolean createBondOutOfBand(byte[] hash, byte[] randomizer) {
        try {
            return sService.createBondOutOfBand(mAddress, hash, randomizer);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /**
     * Set the Out Of Band data for a remote device to be used later
     * in the pairing mechanism. Users can obtain this data through other
     * trusted channels
     *
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}.
     *
     * @param hash Simple Secure pairing hash
     * @param randomizer The random key obtained using OOB
     * @return false on error; true otherwise
     *
     * @hide
     */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.769 -0500", hash_original_method = "575E29F4E8B829BD0D23FAC1ADF3E1AA", hash_generated_method = "0FD91C76CC239AE9D325C5A16A1AC0EA")
    
public boolean setDeviceOutOfBandData(byte[] hash, byte[] randomizer) {
      try {
        return sService.setDeviceOutOfBandData(mAddress, hash, randomizer);
      } catch (RemoteException e) {Log.e(TAG, "", e);}
      return false;
    }

    /**
     * Cancel an in-progress bonding request started with {@link #createBond}.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}.
     *
     * @return true on success, false on error
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.771 -0500", hash_original_method = "0C0048A8FF7823EF43482AC4C17114D5", hash_generated_method = "66FF142346DD2A7694BEC2E340567D34")
    
public boolean cancelBondProcess() {
        try {
            return sService.cancelBondProcess(mAddress);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /**
     * Remove bond (pairing) with the remote device.
     * <p>Delete the link key associated with the remote device, and
     * immediately terminate connections to that device that require
     * authentication and encryption.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}.
     *
     * @return true on success, false on error
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.774 -0500", hash_original_method = "2ABE478EBB53F919726366CC411EDF02", hash_generated_method = "1B9F5E9B1D2AAD34755846AF0512C3AF")
    
public boolean removeBond() {
        try {
            return sService.removeBond(mAddress);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /**
     * Get the bond state of the remote device.
     * <p>Possible values for the bond state are:
     * {@link #BOND_NONE},
     * {@link #BOND_BONDING},
     * {@link #BOND_BONDED}.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH}.
     *
     * @return the bond state
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.776 -0500", hash_original_method = "D50E996B702CE09ED98935B433818740", hash_generated_method = "47677619F8047B60B331881D889DB095")
    
public int getBondState() {
        try {
            return sService.getBondState(mAddress);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return BOND_NONE;
    }

    /**
     * Get the Bluetooth class of the remote device.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH}.
     *
     * @return Bluetooth class object, or null on error
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.778 -0500", hash_original_method = "EF524B188F92A45A25D7F167D0B007CD", hash_generated_method = "606BE01F26AE57DF7424D259FE021A15")
    
public BluetoothClass getBluetoothClass() {
        try {
            int classInt = sService.getRemoteClass(mAddress);
            if (classInt == BluetoothClass.ERROR) return null;
            return new BluetoothClass(classInt);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return null;
    }

    /**
     * Get trust state of a remote device.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH}.
     * @hide
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.780 -0500", hash_original_method = "31D115AB32A31FB0B9AF4C26A4E47F46", hash_generated_method = "4B587BBBC66E72ED4F4AB596316D99DA")
    
public boolean getTrustState() {
        try {
            return sService.getTrustState(mAddress);
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
        }
        return false;
    }

    /**
     * Set trust state for a remote device.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}.
     * @param value the trust state value (true or false)
     * @hide
     */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.782 -0500", hash_original_method = "9D6C6E6815AA7950FF362F094CFFC963", hash_generated_method = "AD53A2C49882C6ABA4958F8AC4CE81C3")
    
public boolean setTrust(boolean value) {
        try {
            return sService.setTrust(mAddress, value);
        } catch (RemoteException e) {
            Log.e(TAG, "", e);
        }
        return false;
    }

    /**
     * Returns the supported features (UUIDs) of the remote device.
     *
     * <p>This method does not start a service discovery procedure to retrieve the UUIDs
     * from the remote device. Instead, the local cached copy of the service
     * UUIDs are returned.
     * <p>Use {@link #fetchUuidsWithSdp} if fresh UUIDs are desired.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH}.
     *
     * @return the supported features (UUIDs) of the remote device,
     *         or null on error
     */
     @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.784 -0500", hash_original_method = "E2768C133840A39718DB537E54814CD2", hash_generated_method = "B12153184F9917E4F49FD19D65566AED")
    
public ParcelUuid[] getUuids() {
        try {
            return sService.getRemoteUuids(mAddress);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return null;
    }

     /**
      * Perform a service discovery on the remote device to get the UUIDs supported.
      *
      * <p>This API is asynchronous and {@link #ACTION_UUID} intent is sent,
      * with the UUIDs supported by the remote end. If there is an error
      * in getting the SDP records or if the process takes a long time,
      * {@link #ACTION_UUID} intent is sent with the UUIDs that is currently
      * present in the cache. Clients should use the {@link #getUuids} to get UUIDs
      * if service discovery is not to be performed.
      * <p>Requires {@link android.Manifest.permission#BLUETOOTH}.
      *
      * @return False if the sanity check fails, True if the process
      *               of initiating an ACL connection to the remote device
      *               was started.
      */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.787 -0500", hash_original_method = "DEDB39F51E4B34081515EA0E29E542CE", hash_generated_method = "EF037476199BFFCF41F25D5D81D2B865")
    
public boolean fetchUuidsWithSdp() {
        try {
            return sService.fetchRemoteUuids(mAddress, null, null);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /** @hide */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.789 -0500", hash_original_method = "3159A609DA44BB79D68A9974B9B6A655", hash_generated_method = "5FD4CD50B43F54C95F3BCF9051C672A2")
    
public int getServiceChannel(ParcelUuid uuid) {
         try {
             return sService.getRemoteServiceChannel(mAddress, uuid);
         } catch (RemoteException e) {Log.e(TAG, "", e);}
         return BluetoothDevice.ERROR;
    }

    /** @hide */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.792 -0500", hash_original_method = "0C2B72A87477D43DC574495BFD9C1EAD", hash_generated_method = "816AD6BBB0E8282107AFC008EE067402")
    
public boolean setPin(byte[] pin) {
        try {
            return sService.setPin(mAddress, pin);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /** @hide */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.794 -0500", hash_original_method = "3609F7C358721757CCD34D699F0B8CE9", hash_generated_method = "0C9973A558CCA5B990771D2A1F4AB0B9")
    
public boolean setPasskey(int passkey) {
        try {
            return sService.setPasskey(mAddress, passkey);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /** @hide */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.796 -0500", hash_original_method = "C6032CF5D33EF2ED9DD2C95EBB11B5A2", hash_generated_method = "3931AE93EDEE42FE0690EC92CE6549A3")
    
public boolean setPairingConfirmation(boolean confirm) {
        try {
            return sService.setPairingConfirmation(mAddress, confirm);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.798 -0500", hash_original_method = "23E27132155361CD962933565A6A609F", hash_generated_method = "76421AE2F51E3BCD358C92C6CCDA9EAB")
    
public boolean setRemoteOutOfBandData() {
        try {
          return sService.setRemoteOutOfBandData(mAddress);
      } catch (RemoteException e) {Log.e(TAG, "", e);}
      return false;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.800 -0500", hash_original_method = "52E8DE9DDBFDE18365F513F918590AAC", hash_generated_method = "76A0AB4FCAE6923C828F82776ABDAAD5")
    
public boolean cancelPairingUserInput() {
        try {
            return sService.cancelPairingUserInput(mAddress);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.802 -0500", hash_original_method = "C1B670BF8E55A118E70A73AF396353BD", hash_generated_method = "32EE8CB875BF61814EC1D0A8E406F483")
    
public boolean isBluetoothDock() {
        try {
            return sService.isBluetoothDock(mAddress);
        } catch (RemoteException e) {Log.e(TAG, "", e);}
        return false;
    }

    /**
     * Create an RFCOMM {@link BluetoothSocket} ready to start a secure
     * outgoing connection to this remote device on given channel.
     * <p>The remote device will be authenticated and communication on this
     * socket will be encrypted.
     * <p> Use this socket only if an authenticated socket link is possible.
     * Authentication refers to the authentication of the link key to
     * prevent man-in-the-middle type of attacks.
     * For example, for Bluetooth 2.1 devices, if any of the devices does not
     * have an input and output capability or just has the ability to
     * display a numeric key, a secure socket connection is not possible.
     * In such a case, use {#link createInsecureRfcommSocket}.
     * For more details, refer to the Security Model section 5.2 (vol 3) of
     * Bluetooth Core Specification version 2.1 + EDR.
     * <p>Use {@link BluetoothSocket#connect} to initiate the outgoing
     * connection.
     * <p>Valid RFCOMM channels are in range 1 to 30.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH}
     *
     * @param channel RFCOMM channel to connect to
     * @return a RFCOMM BluetoothServerSocket ready for an outgoing connection
     * @throws IOException on error, for example Bluetooth not available, or
     *                     insufficient permissions
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.804 -0500", hash_original_method = "98EAE836400D818BB4CCAFDB9F3FE0E9", hash_generated_method = "EA65A8DEDA8B5ADECAB14F42F8F3B0E3")
    
public BluetoothSocket createRfcommSocket(int channel) throws IOException {
        return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, true, true, this, channel,
                null);
    }

    /**
     * Create an RFCOMM {@link BluetoothSocket} ready to start a secure
     * outgoing connection to this remote device using SDP lookup of uuid.
     * <p>This is designed to be used with {@link
     * BluetoothAdapter#listenUsingRfcommWithServiceRecord} for peer-peer
     * Bluetooth applications.
     * <p>Use {@link BluetoothSocket#connect} to initiate the outgoing
     * connection. This will also perform an SDP lookup of the given uuid to
     * determine which channel to connect to.
     * <p>The remote device will be authenticated and communication on this
     * socket will be encrypted.
     * <p> Use this socket only if an authenticated socket link is possible.
     * Authentication refers to the authentication of the link key to
     * prevent man-in-the-middle type of attacks.
     * For example, for Bluetooth 2.1 devices, if any of the devices does not
     * have an input and output capability or just has the ability to
     * display a numeric key, a secure socket connection is not possible.
     * In such a case, use {#link createInsecureRfcommSocketToServiceRecord}.
     * For more details, refer to the Security Model section 5.2 (vol 3) of
     * Bluetooth Core Specification version 2.1 + EDR.
     * <p>Hint: If you are connecting to a Bluetooth serial board then try
     * using the well-known SPP UUID 00001101-0000-1000-8000-00805F9B34FB.
     * However if you are connecting to an Android peer then please generate
     * your own unique UUID.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH}
     *
     * @param uuid service record uuid to lookup RFCOMM channel
     * @return a RFCOMM BluetoothServerSocket ready for an outgoing connection
     * @throws IOException on error, for example Bluetooth not available, or
     *                     insufficient permissions
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.807 -0500", hash_original_method = "673893485928B830B2C44FE0F9C84083", hash_generated_method = "5BE9B56F4BC1B1370A02B6C0D91EC204")
    
public BluetoothSocket createRfcommSocketToServiceRecord(UUID uuid) throws IOException {
        return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, true, true, this, -1,
                new ParcelUuid(uuid));
    }

    /**
     * Create an RFCOMM {@link BluetoothSocket} socket ready to start an insecure
     * outgoing connection to this remote device using SDP lookup of uuid.
     * <p> The communication channel will not have an authenticated link key
     * i.e it will be subject to man-in-the-middle attacks. For Bluetooth 2.1
     * devices, the link key will be encrypted, as encryption is mandatory.
     * For legacy devices (pre Bluetooth 2.1 devices) the link key will
     * be not be encrypted. Use {@link #createRfcommSocketToServiceRecord} if an
     * encrypted and authenticated communication channel is desired.
     * <p>This is designed to be used with {@link
     * BluetoothAdapter#listenUsingInsecureRfcommWithServiceRecord} for peer-peer
     * Bluetooth applications.
     * <p>Use {@link BluetoothSocket#connect} to initiate the outgoing
     * connection. This will also perform an SDP lookup of the given uuid to
     * determine which channel to connect to.
     * <p>The remote device will be authenticated and communication on this
     * socket will be encrypted.
     * <p>Hint: If you are connecting to a Bluetooth serial board then try
     * using the well-known SPP UUID 00001101-0000-1000-8000-00805F9B34FB.
     * However if you are connecting to an Android peer then please generate
     * your own unique UUID.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH}
     *
     * @param uuid service record uuid to lookup RFCOMM channel
     * @return a RFCOMM BluetoothServerSocket ready for an outgoing connection
     * @throws IOException on error, for example Bluetooth not available, or
     *                     insufficient permissions
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.809 -0500", hash_original_method = "8A29B36723BF3024D765B326A6835F52", hash_generated_method = "62AF1E5BC115AE5A45150C83091842DC")
    
public BluetoothSocket createInsecureRfcommSocketToServiceRecord(UUID uuid) throws IOException {
        return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, false, false, this, -1,
                new ParcelUuid(uuid));
    }

    /**
     * Construct an insecure RFCOMM socket ready to start an outgoing
     * connection.
     * Call #connect on the returned #BluetoothSocket to begin the connection.
     * The remote device will not be authenticated and communication on this
     * socket will not be encrypted.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
     *
     * @param port    remote port
     * @return An RFCOMM BluetoothSocket
     * @throws IOException On error, for example Bluetooth not available, or
     *                     insufficient permissions.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.812 -0500", hash_original_method = "65B6B4065AE19FE91B1B928AB482A400", hash_generated_method = "71AEB3BEE2F3E7D1122DD81BB89F9271")
    
public BluetoothSocket createInsecureRfcommSocket(int port) throws IOException {
        return new BluetoothSocket(BluetoothSocket.TYPE_RFCOMM, -1, false, false, this, port,
                null);
    }

    /**
     * Construct a SCO socket ready to start an outgoing connection.
     * Call #connect on the returned #BluetoothSocket to begin the connection.
     * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
     *
     * @return a SCO BluetoothSocket
     * @throws IOException on error, for example Bluetooth not available, or
     *                     insufficient permissions.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:31.814 -0500", hash_original_method = "A2683B7D001B6D4367715042EC6C96CC", hash_generated_method = "852B1160805F25EAF20E722B91991687")
    
public BluetoothSocket createScoSocket() throws IOException {
        return new BluetoothSocket(BluetoothSocket.TYPE_SCO, -1, true, true, this, -1, null);
    }
}

