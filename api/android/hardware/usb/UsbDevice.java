package android.hardware.usb;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

import droidsafe.helpers.DSUtils;

public class UsbDevice implements Parcelable {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.392 -0500", hash_original_method = "7F8EF1C27C5AE21AB1088F14F434A92C", hash_generated_method = "A7BF8DD9C7306154D5B028F33AA15BF7")
    
public static int getDeviceId(String name) {
        return native_get_device_id(name);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.394 -0500", hash_original_method = "0B1D8D7119DB0F719A696608105FBEDD", hash_generated_method = "756AC1269842843CDE20F5642049F998")
    
public static String getDeviceName(int id) {
        return native_get_device_name(id);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_get_device_id(String name) {
        return name.getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String native_get_device_name(int id) {
            String str = new String();
            str.addTaint(id);
            return str;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.326 -0500", hash_original_field = "4E5F892C05B53768683DDD3E619455EF", hash_generated_field = "DAD861C32930D3C3DB9711543F4CBDEA")

    private static final String TAG = "UsbDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.923 -0400", hash_original_field = "623DE101C192EB47E22D3D874CA85384", hash_generated_field = "A89610AE47A5F75950EAB1C2A2C5993E")

    public static final Parcelable.Creator<UsbDevice> CREATOR =
        new Parcelable.Creator<UsbDevice>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.379 -0500", hash_original_method = "D327A311D3EFB3F1067E690218A60D9F", hash_generated_method = "5A696985A3716699EDC1B67C001A6FEA")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.381 -0500", hash_original_method = "9AFDCC8D49A8F5F38D1BB0EEBD878E9A", hash_generated_method = "27096EB43C4C78D86003FF5BA06FBC2F")
        
public UsbDevice[] newArray(int size) {
            return new UsbDevice[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.329 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private  String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.331 -0500", hash_original_field = "D7E1DC8FE0C3BD6E57749648942B2A85", hash_generated_field = "5A1C737B3F08366BB701627450ACF389")

    private  int mVendorId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.333 -0500", hash_original_field = "26541772F305BE069BB8F3AFF7F8A100", hash_generated_field = "0983DEB124753543C3C906C91F06874F")

    private  int mProductId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.336 -0500", hash_original_field = "E48DAE8D69C6B9F32DD524643B0838E9", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private  int mClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.338 -0500", hash_original_field = "88AAB841F7488BB9CF08AD87A3444B8D", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private  int mSubclass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.341 -0500", hash_original_field = "BF6D6E32F709054B6B4FDE5CCC69DE06", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private  int mProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.343 -0500", hash_original_field = "2D8FBFB3680D7FFA2F57733FA71FB57C", hash_generated_field = "80BA38A6BB3E15CA7B72700E2D0A4A7D")

    private  Parcelable[] mInterfaces;

    /**
     * UsbDevice should only be instantiated by UsbService implementation
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.346 -0500", hash_original_method = "45BC6016FF6AF1FC93CB29968E3D6094", hash_generated_method = "8C6450F27ABCD1768B785745608D6B12")
    
public UsbDevice(String name, int vendorId, int productId,
            int Class, int subClass, int protocol, Parcelable[] interfaces) {
        mName = name;
        mVendorId = vendorId;
        mProductId = productId;
        mClass = Class;
        mSubclass = subClass;
        mProtocol = protocol;
        mInterfaces = interfaces;
    }

    /**
     * Returns the name of the device.
     * In the standard implementation, this is the path of the device file
     * for the device in the usbfs file system.
     *
     * @return the device name
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.348 -0500", hash_original_method = "271D12AC1725A6D768ED59A731E22C7D", hash_generated_method = "3EE741987A434FDB0854AEB95B80D98F")
    
public String getDeviceName() {
        return mName;
    }

    /**
     * Returns a unique integer ID for the device.
     * This is a convenience for clients that want to use an integer to represent
     * the device, rather than the device name.
     * IDs are not persistent across USB disconnects.
     *
     * @return the device ID
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.351 -0500", hash_original_method = "0EB91F28C0A2FB6299B3C615FC2DAB8F", hash_generated_method = "4108A2652D872038C575F5727F42E5E7")
    
public int getDeviceId() {
        return getDeviceId(mName);
    }

    /**
     * Returns a vendor ID for the device.
     *
     * @return the device vendor ID
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.353 -0500", hash_original_method = "D8945A991BD9144132914298D2B7FC76", hash_generated_method = "98EA9FF5FF332A765E686BECCB6371AA")
    
public int getVendorId() {
        return mVendorId;
    }

    /**
     * Returns a product ID for the device.
     *
     * @return the device product ID
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.356 -0500", hash_original_method = "A32B17A7DCA377FC904869E22B60DAE0", hash_generated_method = "DF28FBA234EC28068AA4BD8D0CAC7C02")
    
public int getProductId() {
        return mProductId;
    }

    /**
     * Returns the devices's class field.
     * Some useful constants for USB device classes can be found in {@link UsbConstants}.
     *
     * @return the devices's class
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.358 -0500", hash_original_method = "45BD51C898E5D7F479BD37DC16F7713C", hash_generated_method = "325BDE3ADCAFFADE7A1A58C2634CE183")
    
public int getDeviceClass() {
        return mClass;
    }

    /**
     * Returns the device's subclass field.
     *
     * @return the device's subclass
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.360 -0500", hash_original_method = "13162F24DC75BB4BAAF33D909DA8EE5C", hash_generated_method = "268A6215797FD156D76520DB1E1FF73B")
    
public int getDeviceSubclass() {
        return mSubclass;
    }

    /**
     * Returns the device's protocol field.
     *
     * @return the device's protocol
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.362 -0500", hash_original_method = "5B59FED3FAC8826DFB249AE836C6A83B", hash_generated_method = "6E1CE4ED99CE4D43CFEBB08FAA436587")
    
public int getDeviceProtocol() {
        return mProtocol;
    }

    /**
     * Returns the number of {@link UsbInterface}s this device contains.
     *
     * @return the number of interfaces
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.364 -0500", hash_original_method = "3245218866A20CE01DF5327E310A1077", hash_generated_method = "E8A6CBD2B612FD9DC1216D9B94D13985")
    
public int getInterfaceCount() {
        return mInterfaces.length;
    }

    /**
     * Returns the {@link UsbInterface} at the given index.
     *
     * @return the interface
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.367 -0500", hash_original_method = "CB4E75DEC838C411BA866F14CD6483BC", hash_generated_method = "2D5A2E543EB86D5F4B6053F3764CC764")
    
public UsbInterface getInterface(int index) {
        return (UsbInterface)mInterfaces[index];
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.370 -0500", hash_original_method = "053D020F017F8544B1264C0EDF41C58B", hash_generated_method = "CF243685F1C2203BC85BFA3438511ABD")
    
@Override
    public boolean equals(Object o) {
        if (o instanceof UsbDevice) {
            return ((UsbDevice)o).mName.equals(mName);
        } else if (o instanceof String) {
            return ((String)o).equals(mName);
        } else {
            return false;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.372 -0500", hash_original_method = "17C09B2A154A4C6FF6181DC76A163C25", hash_generated_method = "D08FDA8297B9047E5245AB71990901C9")
    
@Override
    public int hashCode() {
        return mName.hashCode();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.375 -0500", hash_original_method = "E3858C7D4009824DA04CA335F7246ABC", hash_generated_method = "99C0920EDEB23ADC303333C842F8DB85")
    
@Override
    public String toString() {
        return "UsbDevice[mName=" + mName + ",mVendorId=" + mVendorId +
                ",mProductId=" + mProductId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mInterfaces=" + mInterfaces + "]";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.387 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.389 -0500", hash_original_method = "A5AD5FD8C4031CD6304CBA4A2E71482A", hash_generated_method = "CB1AC94BB1CD413657CC4A3E820266E8")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mName);
        parcel.writeInt(mVendorId);
        parcel.writeInt(mProductId);
        parcel.writeInt(mClass);
        parcel.writeInt(mSubclass);
        parcel.writeInt(mProtocol);
        parcel.writeParcelableArray(mInterfaces, 0);
   }
    // orphaned legacy method
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
    
    // orphaned legacy method
    public UsbDevice[] newArray(int size) {
            return new UsbDevice[size];
        }
    
}

