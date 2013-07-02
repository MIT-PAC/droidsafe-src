package android.hardware.usb;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.io.FileDescriptor;

public class UsbDevice implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.295 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.296 -0400", hash_original_field = "0C697C350A03A7E88A6376DE08D4E014", hash_generated_field = "5A1C737B3F08366BB701627450ACF389")

    private int mVendorId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.296 -0400", hash_original_field = "D83984F84CEEC24EF6A3FCCFE377A0CC", hash_generated_field = "0983DEB124753543C3C906C91F06874F")

    private int mProductId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.296 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private int mClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.296 -0400", hash_original_field = "A9A6C203C9D6DBFDB68228B9097B885C", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private int mSubclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.296 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private int mProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.296 -0400", hash_original_field = "28ECEE9E94DD840432DC0C85D4935748", hash_generated_field = "80BA38A6BB3E15CA7B72700E2D0A4A7D")

    private Parcelable[] mInterfaces;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.297 -0400", hash_original_method = "45BC6016FF6AF1FC93CB29968E3D6094", hash_generated_method = "8529F1E5A00AA508A928D720A5DD870E")
    public  UsbDevice(String name, int vendorId, int productId,
            int Class, int subClass, int protocol, Parcelable[] interfaces) {
        mName = name;
        mVendorId = vendorId;
        mProductId = productId;
        mClass = Class;
        mSubclass = subClass;
        mProtocol = protocol;
        mInterfaces = interfaces;
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.301 -0400", hash_original_method = "271D12AC1725A6D768ED59A731E22C7D", hash_generated_method = "AA54C5CBB579D0B4923B509FC91875CA")
    public String getDeviceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_70879612 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_70879612 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_70879612.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_70879612;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.302 -0400", hash_original_method = "0EB91F28C0A2FB6299B3C615FC2DAB8F", hash_generated_method = "F16C99D8674EC30E8BFECFB4D8EFAE2E")
    public int getDeviceId() {
        int varA8857A9530942E71AD2D2E23277CEDCC_584792309 = (getDeviceId(mName));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1110451729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1110451729;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.302 -0400", hash_original_method = "D8945A991BD9144132914298D2B7FC76", hash_generated_method = "3B1DDD75853AEC7269EEA03ABEFAA5F0")
    public int getVendorId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_65908523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_65908523;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.303 -0400", hash_original_method = "A32B17A7DCA377FC904869E22B60DAE0", hash_generated_method = "5432E662FCEA6C3E2B74E6212D7E2578")
    public int getProductId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542604130 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542604130;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.304 -0400", hash_original_method = "45BD51C898E5D7F479BD37DC16F7713C", hash_generated_method = "30EE2E4DA60C54E2DEDBE97EB6D4FEFF")
    public int getDeviceClass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696742178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696742178;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.305 -0400", hash_original_method = "13162F24DC75BB4BAAF33D909DA8EE5C", hash_generated_method = "C8E19173EDC151E90B6C6A0BE15F3A33")
    public int getDeviceSubclass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303085836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303085836;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.305 -0400", hash_original_method = "5B59FED3FAC8826DFB249AE836C6A83B", hash_generated_method = "DE4FC4862581C3F05C62012C29C44B1E")
    public int getDeviceProtocol() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168074742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168074742;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.306 -0400", hash_original_method = "3245218866A20CE01DF5327E310A1077", hash_generated_method = "3141E714236F0771C3F6750FB75E19D0")
    public int getInterfaceCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659155172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659155172;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.308 -0400", hash_original_method = "CB4E75DEC838C411BA866F14CD6483BC", hash_generated_method = "53B1C9F6329E2263ADE47F9EB3510BA2")
    public UsbInterface getInterface(int index) {
        UsbInterface varB4EAC82CA7396A68D541C85D26508E83_301246933 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_301246933 = (UsbInterface)mInterfaces[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_301246933.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_301246933;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.310 -0400", hash_original_method = "053D020F017F8544B1264C0EDF41C58B", hash_generated_method = "7C2B7BDE12B2D0CDA7B0AEE11D4C214B")
    @Override
    public boolean equals(Object o) {
        {
            boolean var7C479EDFFD7D76B266CB439F397AE616_1841451247 = (((UsbDevice)o).mName.equals(mName));
        } 
        {
            boolean varB1E37602933A99C8A8EBDC86026FEF60_1332406073 = (((String)o).equals(mName));
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355888578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355888578;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.311 -0400", hash_original_method = "17C09B2A154A4C6FF6181DC76A163C25", hash_generated_method = "8AFFE9029C0217A65E083C0DE074B043")
    @Override
    public int hashCode() {
        int varE33CD2BFD88356AD54767C2AF19C8D3F_1909662709 = (mName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_551447285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_551447285;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.314 -0400", hash_original_method = "E3858C7D4009824DA04CA335F7246ABC", hash_generated_method = "104E75B48507CF6C7F51A1FE1A9C7ED0")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_947486827 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_947486827 = "UsbDevice[mName=" + mName + ",mVendorId=" + mVendorId +
                ",mProductId=" + mProductId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mInterfaces=" + mInterfaces + "]";
        varB4EAC82CA7396A68D541C85D26508E83_947486827.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_947486827;
        
        
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.315 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F2C64ACC8EB63A56AAC129A37D5EFBD3")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_823831425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_823831425;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.316 -0400", hash_original_method = "A5AD5FD8C4031CD6304CBA4A2E71482A", hash_generated_method = "E35452365AF7F9FDC78FE95B13D10804")
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
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static int getDeviceId(String name) {
        return native_get_device_id(name);
    }

    
    @DSModeled(DSC.SAFE)
    public static String getDeviceName(int id) {
        return native_get_device_name(id);
    }

    
    private static int native_get_device_id(String name) {
        return DSUtils.UNKNOWN_INT;
    }

    
    private static String native_get_device_name(int id) {
        	return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.318 -0400", hash_original_field = "9B47FB106BAFC251566582F4F8FE8EB8", hash_generated_field = "DAD861C32930D3C3DB9711543F4CBDEA")

    private static final String TAG = "UsbDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.319 -0400", hash_original_field = "623DE101C192EB47E22D3D874CA85384", hash_generated_field = "A89610AE47A5F75950EAB1C2A2C5993E")

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
    
}

