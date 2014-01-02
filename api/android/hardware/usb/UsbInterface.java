package android.hardware.usb;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class UsbInterface implements Parcelable {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.997 -0400", hash_original_field = "DFC34D6D0E087B75AAD32CD74CF57FEE", hash_generated_field = "EBD090A5A2DA9FF41ABEC28EE6AA86B7")

    public static final Parcelable.Creator<UsbInterface> CREATOR =
        new Parcelable.Creator<UsbInterface>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.592 -0500", hash_original_method = "3B04131A8CBD1CFB2F6A52BD485FA731", hash_generated_method = "3C5B6F42675DCCFE9B6FDF19FEC87935")
        
public UsbInterface createFromParcel(Parcel in) {
            int id = in.readInt();
            int Class = in.readInt();
            int subClass = in.readInt();
            int protocol = in.readInt();
            Parcelable[] endpoints = in.readParcelableArray(UsbEndpoint.class.getClassLoader());
            return new UsbInterface(id, Class, subClass, protocol, endpoints);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.595 -0500", hash_original_method = "97BF19E106D86A6196E457C3D6641932", hash_generated_method = "C998C4348C6131DCDBB1809D52C57D28")
        
public UsbInterface[] newArray(int size) {
            return new UsbInterface[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.555 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")


    private  int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.558 -0500", hash_original_field = "E48DAE8D69C6B9F32DD524643B0838E9", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private  int mClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.562 -0500", hash_original_field = "88AAB841F7488BB9CF08AD87A3444B8D", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private  int mSubclass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.566 -0500", hash_original_field = "BF6D6E32F709054B6B4FDE5CCC69DE06", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private  int mProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.569 -0500", hash_original_field = "181AA0D1186841A64C3F9F5DB4949F44", hash_generated_field = "B49B9B6BE06A0473117FBEFDB3198C46")

    private  Parcelable[] mEndpoints;

    /**
     * UsbInterface should only be instantiated by UsbService implementation
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.573 -0500", hash_original_method = "168A662ECD22EEAD4E32FE6198805EA1", hash_generated_method = "6C8AABDB23FCD56F16C601B818F2CCC3")
    
public UsbInterface(int id, int Class, int subClass, int protocol,
            Parcelable[] endpoints) {
        mId = id;
        mClass = Class;
        mSubclass = subClass;
        mProtocol = protocol;
        mEndpoints = endpoints;
    }

    /**
     * Returns the interface's ID field.
     * This is an integer that uniquely identifies the interface on the device.
     *
     * @return the interface's ID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.575 -0500", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "11DEA77066B2A20ED28C130805C2B9DE")
    
public int getId() {
        return mId;
    }

    /**
     * Returns the interface's class field.
     * Some useful constants for USB classes can be found in {@link UsbConstants}
     *
     * @return the interface's class
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.577 -0500", hash_original_method = "3020C5CBFA8B36FE57B171E2A093C23C", hash_generated_method = "F084F917BD36F5F150E5FEF414D76DE8")
    
public int getInterfaceClass() {
        return mClass;
    }

    /**
     * Returns the interface's subclass field.
     *
     * @return the interface's subclass
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.580 -0500", hash_original_method = "7088B4DB86E16F91D699838E45BCCE2E", hash_generated_method = "1E54D215BE7714F90AC262CB27F6163E")
    
public int getInterfaceSubclass() {
        return mSubclass;
    }

    /**
     * Returns the interface's protocol field.
     *
     * @return the interface's protocol
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.582 -0500", hash_original_method = "095D314DB549CF9B46225B9A82ECAABC", hash_generated_method = "B89BD7465AD9F4374B5CCBDAFF3E3223")
    
public int getInterfaceProtocol() {
        return mProtocol;
    }

    /**
     * Returns the number of {@link android.hardware.usb.UsbEndpoint}s this interface contains.
     *
     * @return the number of endpoints
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.584 -0500", hash_original_method = "B83541EC17993A78C7733C982BB94257", hash_generated_method = "3328415BA9D3C0CF5911E4537FAC5893")
    
public int getEndpointCount() {
        return mEndpoints.length;
    }

    /**
     * Returns the {@link android.hardware.usb.UsbEndpoint} at the given index.
     *
     * @return the endpoint
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.587 -0500", hash_original_method = "10BF694D0DC13FB211A1D4B783AFDCB8", hash_generated_method = "1E8D05651F37ECEF5B154A2425D3B720")
    
public UsbEndpoint getEndpoint(int index) {
        return (UsbEndpoint)mEndpoints[index];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.589 -0500", hash_original_method = "7DE8C5BE07836E58A7BC66D5916A69AB", hash_generated_method = "7C60BD9D81528D3AF7CD6AC0A8A5B7C6")
    
@Override
    public String toString() {
        return "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mEndpoints=" + mEndpoints + "]";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.601 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.605 -0500", hash_original_method = "F436F428B0571288036EC16237EC67B4", hash_generated_method = "545AE60A736357FB6D281EFE5B61CC5A")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mId);
        parcel.writeInt(mClass);
        parcel.writeInt(mSubclass);
        parcel.writeInt(mProtocol);
        parcel.writeParcelableArray(mEndpoints, 0);
   }
    // orphaned legacy method
    public UsbInterface createFromParcel(Parcel in) {
            int id = in.readInt();
            int Class = in.readInt();
            int subClass = in.readInt();
            int protocol = in.readInt();
            Parcelable[] endpoints = in.readParcelableArray(UsbEndpoint.class.getClassLoader());
            return new UsbInterface(id, Class, subClass, protocol, endpoints);
        }
    
    // orphaned legacy method
    public UsbInterface[] newArray(int size) {
            return new UsbInterface[size];
        }
    
}

