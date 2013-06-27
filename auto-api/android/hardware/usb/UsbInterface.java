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

public class UsbInterface implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.369 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.369 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private int mClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.369 -0400", hash_original_field = "A9A6C203C9D6DBFDB68228B9097B885C", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private int mSubclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.369 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private int mProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.369 -0400", hash_original_field = "AFC13E9D3BA7D47873423EE17B74D3A6", hash_generated_field = "B49B9B6BE06A0473117FBEFDB3198C46")

    private Parcelable[] mEndpoints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.370 -0400", hash_original_method = "168A662ECD22EEAD4E32FE6198805EA1", hash_generated_method = "8F9AB190C4EE06AFF7C7B49CDD5F34F3")
    public  UsbInterface(int id, int Class, int subClass, int protocol,
            Parcelable[] endpoints) {
        mId = id;
        mClass = Class;
        mSubclass = subClass;
        mProtocol = protocol;
        mEndpoints = endpoints;
        // ---------- Original Method ----------
        //mId = id;
        //mClass = Class;
        //mSubclass = subClass;
        //mProtocol = protocol;
        //mEndpoints = endpoints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.371 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "A5E3AE98757A4208C8EBB853B3CF93D0")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_217778985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_217778985;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.371 -0400", hash_original_method = "3020C5CBFA8B36FE57B171E2A093C23C", hash_generated_method = "E9241CF452BE0CC3C89653FC0CF8C340")
    public int getInterfaceClass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679266624 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679266624;
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.384 -0400", hash_original_method = "7088B4DB86E16F91D699838E45BCCE2E", hash_generated_method = "8E7890FB9DF0CA8E99DE45E6620BC2C0")
    public int getInterfaceSubclass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944376773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944376773;
        // ---------- Original Method ----------
        //return mSubclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.384 -0400", hash_original_method = "095D314DB549CF9B46225B9A82ECAABC", hash_generated_method = "A37D48CFD497C43F1CCFF046E2D7F12C")
    public int getInterfaceProtocol() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1438554820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1438554820;
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.385 -0400", hash_original_method = "B83541EC17993A78C7733C982BB94257", hash_generated_method = "FBC805AB3CA012CA6E624C5BC528D58E")
    public int getEndpointCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131261681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131261681;
        // ---------- Original Method ----------
        //return mEndpoints.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.386 -0400", hash_original_method = "10BF694D0DC13FB211A1D4B783AFDCB8", hash_generated_method = "648CF63196450BA57021A39B54E82365")
    public UsbEndpoint getEndpoint(int index) {
        UsbEndpoint varB4EAC82CA7396A68D541C85D26508E83_603393096 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_603393096 = (UsbEndpoint)mEndpoints[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_603393096.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_603393096;
        // ---------- Original Method ----------
        //return (UsbEndpoint)mEndpoints[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.409 -0400", hash_original_method = "7DE8C5BE07836E58A7BC66D5916A69AB", hash_generated_method = "137CD667E7E76467E41D432CE92832B8")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_988740476 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_988740476 = "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mEndpoints=" + mEndpoints + "]";
        varB4EAC82CA7396A68D541C85D26508E83_988740476.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_988740476;
        // ---------- Original Method ----------
        //return "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                //",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                //",mEndpoints=" + mEndpoints + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.422 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "08303588C5A7445E9E3E97830086DB10")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593899970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593899970;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.423 -0400", hash_original_method = "F436F428B0571288036EC16237EC67B4", hash_generated_method = "B7C66E9FB57121378E76AEC341D03987")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mId);
        parcel.writeInt(mClass);
        parcel.writeInt(mSubclass);
        parcel.writeInt(mProtocol);
        parcel.writeParcelableArray(mEndpoints, 0);
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //parcel.writeInt(mId);
        //parcel.writeInt(mClass);
        //parcel.writeInt(mSubclass);
        //parcel.writeInt(mProtocol);
        //parcel.writeParcelableArray(mEndpoints, 0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.424 -0400", hash_original_field = "DFC34D6D0E087B75AAD32CD74CF57FEE", hash_generated_field = "EBD090A5A2DA9FF41ABEC28EE6AA86B7")

    public static final Parcelable.Creator<UsbInterface> CREATOR =
        new Parcelable.Creator<UsbInterface>() {
        public UsbInterface createFromParcel(Parcel in) {
            int id = in.readInt();
            int Class = in.readInt();
            int subClass = in.readInt();
            int protocol = in.readInt();
            Parcelable[] endpoints = in.readParcelableArray(UsbEndpoint.class.getClassLoader());
            return new UsbInterface(id, Class, subClass, protocol, endpoints);
        }

        public UsbInterface[] newArray(int size) {
            return new UsbInterface[size];
        }
    };
}

