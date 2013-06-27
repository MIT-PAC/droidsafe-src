package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.io.FileDescriptor;

public class UsbDevice implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.778 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.778 -0400", hash_original_field = "0C697C350A03A7E88A6376DE08D4E014", hash_generated_field = "5A1C737B3F08366BB701627450ACF389")

    private int mVendorId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.778 -0400", hash_original_field = "D83984F84CEEC24EF6A3FCCFE377A0CC", hash_generated_field = "0983DEB124753543C3C906C91F06874F")

    private int mProductId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.778 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private int mClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.778 -0400", hash_original_field = "A9A6C203C9D6DBFDB68228B9097B885C", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private int mSubclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.791 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private int mProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.791 -0400", hash_original_field = "28ECEE9E94DD840432DC0C85D4935748", hash_generated_field = "80BA38A6BB3E15CA7B72700E2D0A4A7D")

    private Parcelable[] mInterfaces;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.793 -0400", hash_original_method = "45BC6016FF6AF1FC93CB29968E3D6094", hash_generated_method = "8529F1E5A00AA508A928D720A5DD870E")
    public  UsbDevice(String name, int vendorId, int productId,
            int Class, int subClass, int protocol, Parcelable[] interfaces) {
        mName = name;
        mVendorId = vendorId;
        mProductId = productId;
        mClass = Class;
        mSubclass = subClass;
        mProtocol = protocol;
        mInterfaces = interfaces;
        // ---------- Original Method ----------
        //mName = name;
        //mVendorId = vendorId;
        //mProductId = productId;
        //mClass = Class;
        //mSubclass = subClass;
        //mProtocol = protocol;
        //mInterfaces = interfaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.794 -0400", hash_original_method = "271D12AC1725A6D768ED59A731E22C7D", hash_generated_method = "850A174F94ACDD89E3B59F4229325BA8")
    public String getDeviceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_781958362 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_781958362 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_781958362.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_781958362;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.805 -0400", hash_original_method = "0EB91F28C0A2FB6299B3C615FC2DAB8F", hash_generated_method = "013D549F130B12725FC25D6FFE30249A")
    public int getDeviceId() {
        int varA8857A9530942E71AD2D2E23277CEDCC_1372745128 = (getDeviceId(mName));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590098377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590098377;
        // ---------- Original Method ----------
        //return getDeviceId(mName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.806 -0400", hash_original_method = "D8945A991BD9144132914298D2B7FC76", hash_generated_method = "4E668266ACFD623552EF211E70C09BB9")
    public int getVendorId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574234679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574234679;
        // ---------- Original Method ----------
        //return mVendorId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.806 -0400", hash_original_method = "A32B17A7DCA377FC904869E22B60DAE0", hash_generated_method = "D45A84EC1583EC378673FF0574E0BEAF")
    public int getProductId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833236913 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833236913;
        // ---------- Original Method ----------
        //return mProductId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.810 -0400", hash_original_method = "45BD51C898E5D7F479BD37DC16F7713C", hash_generated_method = "A4261695DFF4BB26EE12D865D8CDECD6")
    public int getDeviceClass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1508205490 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1508205490;
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.810 -0400", hash_original_method = "13162F24DC75BB4BAAF33D909DA8EE5C", hash_generated_method = "9EAA7C4E6E0E19978B548413E731F9F8")
    public int getDeviceSubclass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516928040 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516928040;
        // ---------- Original Method ----------
        //return mSubclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.814 -0400", hash_original_method = "5B59FED3FAC8826DFB249AE836C6A83B", hash_generated_method = "DF96FFF0683031DBAC4ECE8A23A09EBD")
    public int getDeviceProtocol() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562828311 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562828311;
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.815 -0400", hash_original_method = "3245218866A20CE01DF5327E310A1077", hash_generated_method = "27DA9F6C4D578B75081B9373F5756944")
    public int getInterfaceCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366114226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366114226;
        // ---------- Original Method ----------
        //return mInterfaces.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.831 -0400", hash_original_method = "CB4E75DEC838C411BA866F14CD6483BC", hash_generated_method = "A6DDB0DA0416F8B7F00E0F2B93F25157")
    public UsbInterface getInterface(int index) {
        UsbInterface varB4EAC82CA7396A68D541C85D26508E83_544961022 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_544961022 = (UsbInterface)mInterfaces[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_544961022.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_544961022;
        // ---------- Original Method ----------
        //return (UsbInterface)mInterfaces[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.833 -0400", hash_original_method = "053D020F017F8544B1264C0EDF41C58B", hash_generated_method = "88719A2C14D9D80B71E864A254552313")
    @Override
    public boolean equals(Object o) {
        {
            boolean var7C479EDFFD7D76B266CB439F397AE616_388502476 = (((UsbDevice)o).mName.equals(mName));
        } //End block
        {
            boolean varB1E37602933A99C8A8EBDC86026FEF60_1593631339 = (((String)o).equals(mName));
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113138740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113138740;
        // ---------- Original Method ----------
        //if (o instanceof UsbDevice) {
            //return ((UsbDevice)o).mName.equals(mName);
        //} else if (o instanceof String) {
            //return ((String)o).equals(mName);
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.833 -0400", hash_original_method = "17C09B2A154A4C6FF6181DC76A163C25", hash_generated_method = "60D936E7A8F46C25580C1CFFE914E146")
    @Override
    public int hashCode() {
        int varE33CD2BFD88356AD54767C2AF19C8D3F_475029605 = (mName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049438512 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049438512;
        // ---------- Original Method ----------
        //return mName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.835 -0400", hash_original_method = "E3858C7D4009824DA04CA335F7246ABC", hash_generated_method = "A3937A4D4F1405184E4F552659785370")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2111658415 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2111658415 = "UsbDevice[mName=" + mName + ",mVendorId=" + mVendorId +
                ",mProductId=" + mProductId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mInterfaces=" + mInterfaces + "]";
        varB4EAC82CA7396A68D541C85D26508E83_2111658415.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2111658415;
        // ---------- Original Method ----------
        //return "UsbDevice[mName=" + mName + ",mVendorId=" + mVendorId +
                //",mProductId=" + mProductId + ",mClass=" + mClass +
                //",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                //",mInterfaces=" + mInterfaces + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.835 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A5AA92649CF02DE216A277B39416035C")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347455793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347455793;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.852 -0400", hash_original_method = "A5AD5FD8C4031CD6304CBA4A2E71482A", hash_generated_method = "E35452365AF7F9FDC78FE95B13D10804")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mName);
        parcel.writeInt(mVendorId);
        parcel.writeInt(mProductId);
        parcel.writeInt(mClass);
        parcel.writeInt(mSubclass);
        parcel.writeInt(mProtocol);
        parcel.writeParcelableArray(mInterfaces, 0);
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //parcel.writeString(mName);
        //parcel.writeInt(mVendorId);
        //parcel.writeInt(mProductId);
        //parcel.writeInt(mClass);
        //parcel.writeInt(mSubclass);
        //parcel.writeInt(mProtocol);
        //parcel.writeParcelableArray(mInterfaces, 0);
    }

    
        public static int getDeviceId(String name) {
        return native_get_device_id(name);
    }

    
        public static String getDeviceName(int id) {
        return native_get_device_name(id);
    }

    
        private static int native_get_device_id(String name) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static String native_get_device_name(int id) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.871 -0400", hash_original_field = "9B47FB106BAFC251566582F4F8FE8EB8", hash_generated_field = "108DA87CA9043C1B278CC9AE284F8C18")

    private static String TAG = "UsbDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.871 -0400", hash_original_field = "623DE101C192EB47E22D3D874CA85384", hash_generated_field = "A89610AE47A5F75950EAB1C2A2C5993E")

    public static final Parcelable.Creator<UsbDevice> CREATOR =
        new Parcelable.Creator<UsbDevice>() {
        public UsbDevice createFromParcel(Parcel in) {
            String name = in.readString();
            int vendorId = in.readInt();
            int productId = in.readInt();
            int clasz = in.readInt();
            int subClass = in.readInt();
            int protocol = in.readInt();
            Parcelable[] interfaces = in.readParcelableArray(UsbInterface.class.getClassLoader());
            return new UsbDevice(name, vendorId, productId, clasz, subClass, protocol, interfaces);
        }

        public UsbDevice[] newArray(int size) {
            return new UsbDevice[size];
        }
    };
}

