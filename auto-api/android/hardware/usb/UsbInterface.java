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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.944 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.954 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private int mClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.954 -0400", hash_original_field = "A9A6C203C9D6DBFDB68228B9097B885C", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private int mSubclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.954 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private int mProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.955 -0400", hash_original_field = "AFC13E9D3BA7D47873423EE17B74D3A6", hash_generated_field = "B49B9B6BE06A0473117FBEFDB3198C46")

    private Parcelable[] mEndpoints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.956 -0400", hash_original_method = "168A662ECD22EEAD4E32FE6198805EA1", hash_generated_method = "8F9AB190C4EE06AFF7C7B49CDD5F34F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.957 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "6A13FE25294477A33D0590D1F379AE8A")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349457212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349457212;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.957 -0400", hash_original_method = "3020C5CBFA8B36FE57B171E2A093C23C", hash_generated_method = "0F8B69C5F6C327D9B710BB4028B22F69")
    public int getInterfaceClass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_982278795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_982278795;
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.957 -0400", hash_original_method = "7088B4DB86E16F91D699838E45BCCE2E", hash_generated_method = "F484616293579A9C8A7516A5DA8A9DF6")
    public int getInterfaceSubclass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026583970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026583970;
        // ---------- Original Method ----------
        //return mSubclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.973 -0400", hash_original_method = "095D314DB549CF9B46225B9A82ECAABC", hash_generated_method = "B91C865609AFCCB04A455310422BC08E")
    public int getInterfaceProtocol() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81822619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81822619;
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.974 -0400", hash_original_method = "B83541EC17993A78C7733C982BB94257", hash_generated_method = "C6B4E74D7C4E343D958840340D503068")
    public int getEndpointCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184501729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184501729;
        // ---------- Original Method ----------
        //return mEndpoints.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.975 -0400", hash_original_method = "10BF694D0DC13FB211A1D4B783AFDCB8", hash_generated_method = "782D93436B7E305899E0648525E2DBA7")
    public UsbEndpoint getEndpoint(int index) {
        UsbEndpoint varB4EAC82CA7396A68D541C85D26508E83_392477797 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_392477797 = (UsbEndpoint)mEndpoints[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_392477797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_392477797;
        // ---------- Original Method ----------
        //return (UsbEndpoint)mEndpoints[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.977 -0400", hash_original_method = "7DE8C5BE07836E58A7BC66D5916A69AB", hash_generated_method = "EB809EE346AD17A9A682A4CEB304A2A6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1048845209 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1048845209 = "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mEndpoints=" + mEndpoints + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1048845209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1048845209;
        // ---------- Original Method ----------
        //return "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                //",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                //",mEndpoints=" + mEndpoints + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.981 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5183733801BE8941E7E87690AC6147E5")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470635804 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470635804;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.995 -0400", hash_original_method = "F436F428B0571288036EC16237EC67B4", hash_generated_method = "B7C66E9FB57121378E76AEC341D03987")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.996 -0400", hash_original_field = "DFC34D6D0E087B75AAD32CD74CF57FEE", hash_generated_field = "EBD090A5A2DA9FF41ABEC28EE6AA86B7")

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

