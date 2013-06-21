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
    private String mName;
    private int mVendorId;
    private int mProductId;
    private int mClass;
    private int mSubclass;
    private int mProtocol;
    private Parcelable[] mInterfaces;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.104 -0400", hash_original_method = "45BC6016FF6AF1FC93CB29968E3D6094", hash_generated_method = "606A6E0C669C67588179B15FEBA011D0")
    @DSModeled(DSC.SAFE)
    public UsbDevice(String name, int vendorId, int productId,
            int Class, int subClass, int protocol, Parcelable[] interfaces) {
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(subClass);
        dsTaint.addTaint(Class);
        dsTaint.addTaint(name);
        dsTaint.addTaint(interfaces[0].dsTaint);
        dsTaint.addTaint(vendorId);
        dsTaint.addTaint(productId);
        // ---------- Original Method ----------
        //mName = name;
        //mVendorId = vendorId;
        //mProductId = productId;
        //mClass = Class;
        //mSubclass = subClass;
        //mProtocol = protocol;
        //mInterfaces = interfaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.105 -0400", hash_original_method = "271D12AC1725A6D768ED59A731E22C7D", hash_generated_method = "01532D16C157A1FCACC7B38FC0FB4E62")
    @DSModeled(DSC.SAFE)
    public String getDeviceName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.105 -0400", hash_original_method = "0EB91F28C0A2FB6299B3C615FC2DAB8F", hash_generated_method = "285BBF32DA8DF80DD1D60B30C5BDA880")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDeviceId() {
        int varA8857A9530942E71AD2D2E23277CEDCC_1082660834 = (getDeviceId(mName));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getDeviceId(mName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.105 -0400", hash_original_method = "D8945A991BD9144132914298D2B7FC76", hash_generated_method = "EE928B1176ED231C802572AFD9D959B5")
    @DSModeled(DSC.SAFE)
    public int getVendorId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVendorId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.105 -0400", hash_original_method = "A32B17A7DCA377FC904869E22B60DAE0", hash_generated_method = "992E19C223E4CC78E890277EA1905D64")
    @DSModeled(DSC.SAFE)
    public int getProductId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mProductId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.106 -0400", hash_original_method = "45BD51C898E5D7F479BD37DC16F7713C", hash_generated_method = "3E936573041EC49101BE3000F0D6358C")
    @DSModeled(DSC.SAFE)
    public int getDeviceClass() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.106 -0400", hash_original_method = "13162F24DC75BB4BAAF33D909DA8EE5C", hash_generated_method = "D1AF811B33D333AA703E1305C21CE822")
    @DSModeled(DSC.SAFE)
    public int getDeviceSubclass() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.106 -0400", hash_original_method = "5B59FED3FAC8826DFB249AE836C6A83B", hash_generated_method = "0E05A856D852220D9258FB49AA676CE6")
    @DSModeled(DSC.SAFE)
    public int getDeviceProtocol() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.106 -0400", hash_original_method = "3245218866A20CE01DF5327E310A1077", hash_generated_method = "67E8F806B02F8DE12923166F74B6B2A1")
    @DSModeled(DSC.SAFE)
    public int getInterfaceCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInterfaces.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.106 -0400", hash_original_method = "CB4E75DEC838C411BA866F14CD6483BC", hash_generated_method = "207193BDB7F8C58A0065B914837E22F6")
    @DSModeled(DSC.SAFE)
    public UsbInterface getInterface(int index) {
        dsTaint.addTaint(index);
        return (UsbInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (UsbInterface)mInterfaces[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.107 -0400", hash_original_method = "053D020F017F8544B1264C0EDF41C58B", hash_generated_method = "77B6CB42BC6EBCE17B5BC6C9EA7EF7ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var7C479EDFFD7D76B266CB439F397AE616_1214112015 = (((UsbDevice)o).mName.equals(mName));
        } //End block
        {
            boolean varB1E37602933A99C8A8EBDC86026FEF60_360192199 = (((String)o).equals(mName));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o instanceof UsbDevice) {
            //return ((UsbDevice)o).mName.equals(mName);
        //} else if (o instanceof String) {
            //return ((String)o).equals(mName);
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.107 -0400", hash_original_method = "17C09B2A154A4C6FF6181DC76A163C25", hash_generated_method = "AE593062C5739ADBE4E133C57FEC56C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE33CD2BFD88356AD54767C2AF19C8D3F_1269836085 = (mName.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.107 -0400", hash_original_method = "E3858C7D4009824DA04CA335F7246ABC", hash_generated_method = "887744A5A59152AF8129547B6F0343AA")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "UsbDevice[mName=" + mName + ",mVendorId=" + mVendorId +
                //",mProductId=" + mProductId + ",mClass=" + mClass +
                //",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                //",mInterfaces=" + mInterfaces + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.107 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.108 -0400", hash_original_method = "A5AD5FD8C4031CD6304CBA4A2E71482A", hash_generated_method = "CFBAA9888F5791E74D27A2B8A4D55AF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeString(mName);
        parcel.writeInt(mVendorId);
        parcel.writeInt(mProductId);
        parcel.writeInt(mClass);
        parcel.writeInt(mSubclass);
        parcel.writeInt(mProtocol);
        parcel.writeParcelableArray(mInterfaces, 0);
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
        return DSUtils.UNKNOWN_STRING;
    }

    
    private static final String TAG = "UsbDevice";
    public static final Parcelable.Creator<UsbDevice> CREATOR = new Parcelable.Creator<UsbDevice>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.109 -0400", hash_original_method = "D327A311D3EFB3F1067E690218A60D9F", hash_generated_method = "812EE306ABCE151D2057F10D2AEF2220")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UsbDevice createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            String name;
            name = in.readString();
            int vendorId;
            vendorId = in.readInt();
            int productId;
            productId = in.readInt();
            int clasz;
            clasz = in.readInt();
            int subClass;
            subClass = in.readInt();
            int protocol;
            protocol = in.readInt();
            Parcelable[] interfaces;
            interfaces = in.readParcelableArray(UsbInterface.class.getClassLoader());
            UsbDevice varF1B806F952873A17D87B9C85613F557A_1946102199 = (new UsbDevice(name, vendorId, productId, clasz, subClass, protocol, interfaces));
            return (UsbDevice)dsTaint.getTaint();
            // ---------- Original Method ----------
            //String name = in.readString();
            //int vendorId = in.readInt();
            //int productId = in.readInt();
            //int clasz = in.readInt();
            //int subClass = in.readInt();
            //int protocol = in.readInt();
            //Parcelable[] interfaces = in.readParcelableArray(UsbInterface.class.getClassLoader());
            //return new UsbDevice(name, vendorId, productId, clasz, subClass, protocol, interfaces);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.109 -0400", hash_original_method = "9AFDCC8D49A8F5F38D1BB0EEBD878E9A", hash_generated_method = "CCF0B6AD03EB2D9E6B875FC0BD92E4FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UsbDevice[] newArray(int size) {
            dsTaint.addTaint(size);
            UsbDevice[] var6C73B3A734F9336C3AFFF3DB16D9FFF8_788450230 = (new UsbDevice[size]);
            return (UsbDevice[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UsbDevice[size];
        }

        
}; //Transformed anonymous class
}

