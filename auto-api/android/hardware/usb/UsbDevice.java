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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.163 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.163 -0400", hash_original_field = "0C697C350A03A7E88A6376DE08D4E014", hash_generated_field = "5A1C737B3F08366BB701627450ACF389")

    private int mVendorId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.163 -0400", hash_original_field = "D83984F84CEEC24EF6A3FCCFE377A0CC", hash_generated_field = "0983DEB124753543C3C906C91F06874F")

    private int mProductId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.163 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private int mClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.163 -0400", hash_original_field = "A9A6C203C9D6DBFDB68228B9097B885C", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private int mSubclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.163 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private int mProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.163 -0400", hash_original_field = "28ECEE9E94DD840432DC0C85D4935748", hash_generated_field = "80BA38A6BB3E15CA7B72700E2D0A4A7D")

    private Parcelable[] mInterfaces;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.177 -0400", hash_original_method = "45BC6016FF6AF1FC93CB29968E3D6094", hash_generated_method = "8529F1E5A00AA508A928D720A5DD870E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.187 -0400", hash_original_method = "271D12AC1725A6D768ED59A731E22C7D", hash_generated_method = "B19DF6BD4BAF06171FDE518F6F62C774")
    public String getDeviceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_518729095 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_518729095 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_518729095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_518729095;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.187 -0400", hash_original_method = "0EB91F28C0A2FB6299B3C615FC2DAB8F", hash_generated_method = "C3711399E1F5C834DD85B7F44A880B1A")
    public int getDeviceId() {
        int varA8857A9530942E71AD2D2E23277CEDCC_499634721 = (getDeviceId(mName));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279891855 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279891855;
        // ---------- Original Method ----------
        //return getDeviceId(mName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.187 -0400", hash_original_method = "D8945A991BD9144132914298D2B7FC76", hash_generated_method = "25D5A0B28DD81D6DCBE2B154A2D20279")
    public int getVendorId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318153357 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318153357;
        // ---------- Original Method ----------
        //return mVendorId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.188 -0400", hash_original_method = "A32B17A7DCA377FC904869E22B60DAE0", hash_generated_method = "313804FA9DD8427E8D3E201495CF438C")
    public int getProductId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546510627 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546510627;
        // ---------- Original Method ----------
        //return mProductId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.189 -0400", hash_original_method = "45BD51C898E5D7F479BD37DC16F7713C", hash_generated_method = "2D91BC7EC37F5BA0BA26A1B97727376A")
    public int getDeviceClass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_511725283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_511725283;
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.189 -0400", hash_original_method = "13162F24DC75BB4BAAF33D909DA8EE5C", hash_generated_method = "4E25C52ECEE7B45A8CC6A642A545547C")
    public int getDeviceSubclass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947133158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947133158;
        // ---------- Original Method ----------
        //return mSubclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.208 -0400", hash_original_method = "5B59FED3FAC8826DFB249AE836C6A83B", hash_generated_method = "C929AD2AC9507A8301F411CA5B9E4A99")
    public int getDeviceProtocol() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484672528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484672528;
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.208 -0400", hash_original_method = "3245218866A20CE01DF5327E310A1077", hash_generated_method = "A4473F771B5330B9101E8B7D819934EB")
    public int getInterfaceCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2091710529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2091710529;
        // ---------- Original Method ----------
        //return mInterfaces.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.209 -0400", hash_original_method = "CB4E75DEC838C411BA866F14CD6483BC", hash_generated_method = "B4206C77191227C8E03248D1DC465437")
    public UsbInterface getInterface(int index) {
        UsbInterface varB4EAC82CA7396A68D541C85D26508E83_848889361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_848889361 = (UsbInterface)mInterfaces[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_848889361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_848889361;
        // ---------- Original Method ----------
        //return (UsbInterface)mInterfaces[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.210 -0400", hash_original_method = "053D020F017F8544B1264C0EDF41C58B", hash_generated_method = "33C55FE1130548F8C6BFF7A60A1DBBC5")
    @Override
    public boolean equals(Object o) {
        {
            boolean var7C479EDFFD7D76B266CB439F397AE616_1483909775 = (((UsbDevice)o).mName.equals(mName));
        } //End block
        {
            boolean varB1E37602933A99C8A8EBDC86026FEF60_397447231 = (((String)o).equals(mName));
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1644600543 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1644600543;
        // ---------- Original Method ----------
        //if (o instanceof UsbDevice) {
            //return ((UsbDevice)o).mName.equals(mName);
        //} else if (o instanceof String) {
            //return ((String)o).equals(mName);
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.210 -0400", hash_original_method = "17C09B2A154A4C6FF6181DC76A163C25", hash_generated_method = "70DF338D57C53543C30AA2729B61039F")
    @Override
    public int hashCode() {
        int varE33CD2BFD88356AD54767C2AF19C8D3F_1357703317 = (mName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1871087117 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1871087117;
        // ---------- Original Method ----------
        //return mName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.232 -0400", hash_original_method = "E3858C7D4009824DA04CA335F7246ABC", hash_generated_method = "11AED36393AC553DC52851730EA4E535")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1430692421 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1430692421 = "UsbDevice[mName=" + mName + ",mVendorId=" + mVendorId +
                ",mProductId=" + mProductId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mInterfaces=" + mInterfaces + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1430692421.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1430692421;
        // ---------- Original Method ----------
        //return "UsbDevice[mName=" + mName + ",mVendorId=" + mVendorId +
                //",mProductId=" + mProductId + ",mClass=" + mClass +
                //",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                //",mInterfaces=" + mInterfaces + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.233 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E2D32708FB25B7789331793405A7BF96")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953144079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953144079;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.234 -0400", hash_original_method = "A5AD5FD8C4031CD6304CBA4A2E71482A", hash_generated_method = "E35452365AF7F9FDC78FE95B13D10804")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.249 -0400", hash_original_field = "9B47FB106BAFC251566582F4F8FE8EB8", hash_generated_field = "108DA87CA9043C1B278CC9AE284F8C18")

    private static String TAG = "UsbDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.249 -0400", hash_original_field = "623DE101C192EB47E22D3D874CA85384", hash_generated_field = "A89610AE47A5F75950EAB1C2A2C5993E")

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

