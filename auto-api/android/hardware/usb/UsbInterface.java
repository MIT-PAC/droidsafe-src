package android.hardware.usb;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class UsbInterface implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.402 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.402 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private int mClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.402 -0400", hash_original_field = "A9A6C203C9D6DBFDB68228B9097B885C", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private int mSubclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.402 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private int mProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.403 -0400", hash_original_field = "AFC13E9D3BA7D47873423EE17B74D3A6", hash_generated_field = "B49B9B6BE06A0473117FBEFDB3198C46")

    private Parcelable[] mEndpoints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.404 -0400", hash_original_method = "168A662ECD22EEAD4E32FE6198805EA1", hash_generated_method = "8F9AB190C4EE06AFF7C7B49CDD5F34F3")
    public  UsbInterface(int id, int Class, int subClass, int protocol,
            Parcelable[] endpoints) {
        mId = id;
        mClass = Class;
        mSubclass = subClass;
        mProtocol = protocol;
        mEndpoints = endpoints;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.405 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "A914320FB227E4B93580AD1BA779F201")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_278422975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_278422975;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.406 -0400", hash_original_method = "3020C5CBFA8B36FE57B171E2A093C23C", hash_generated_method = "B90079066E2E13782304249DD0A877E6")
    public int getInterfaceClass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385677667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385677667;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.407 -0400", hash_original_method = "7088B4DB86E16F91D699838E45BCCE2E", hash_generated_method = "197A31D5E722018503C1FED561F23CAF")
    public int getInterfaceSubclass() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872494321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872494321;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.408 -0400", hash_original_method = "095D314DB549CF9B46225B9A82ECAABC", hash_generated_method = "F2EE365E64701DAECC67E81FC495C876")
    public int getInterfaceProtocol() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_136791105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_136791105;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.409 -0400", hash_original_method = "B83541EC17993A78C7733C982BB94257", hash_generated_method = "88398824FDD90194D56B170019F0B6E5")
    public int getEndpointCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958982457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958982457;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.412 -0400", hash_original_method = "10BF694D0DC13FB211A1D4B783AFDCB8", hash_generated_method = "AE9EC531BCCFA0520A4E105EBE3BA485")
    public UsbEndpoint getEndpoint(int index) {
        UsbEndpoint varB4EAC82CA7396A68D541C85D26508E83_197389977 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_197389977 = (UsbEndpoint)mEndpoints[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_197389977.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_197389977;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.414 -0400", hash_original_method = "7DE8C5BE07836E58A7BC66D5916A69AB", hash_generated_method = "A8FF3481CC5256F83F3EC51569ECBFD1")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_233391511 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_233391511 = "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mEndpoints=" + mEndpoints + "]";
        varB4EAC82CA7396A68D541C85D26508E83_233391511.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_233391511;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.415 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5B64A557DD28C808A108FEA92486D257")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327129201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327129201;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.416 -0400", hash_original_method = "F436F428B0571288036EC16237EC67B4", hash_generated_method = "B7C66E9FB57121378E76AEC341D03987")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mId);
        parcel.writeInt(mClass);
        parcel.writeInt(mSubclass);
        parcel.writeInt(mProtocol);
        parcel.writeParcelableArray(mEndpoints, 0);
        addTaint(parcel.getTaint());
        addTaint(flags);
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.417 -0400", hash_original_field = "DFC34D6D0E087B75AAD32CD74CF57FEE", hash_generated_field = "EBD090A5A2DA9FF41ABEC28EE6AA86B7")

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
    
}

