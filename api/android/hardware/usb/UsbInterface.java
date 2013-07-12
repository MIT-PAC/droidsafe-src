package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class UsbInterface implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.935 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.935 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private int mClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.935 -0400", hash_original_field = "A9A6C203C9D6DBFDB68228B9097B885C", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private int mSubclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.935 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private int mProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.935 -0400", hash_original_field = "AFC13E9D3BA7D47873423EE17B74D3A6", hash_generated_field = "B49B9B6BE06A0473117FBEFDB3198C46")

    private Parcelable[] mEndpoints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.936 -0400", hash_original_method = "168A662ECD22EEAD4E32FE6198805EA1", hash_generated_method = "8F9AB190C4EE06AFF7C7B49CDD5F34F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.937 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "35DCE1202F840C39E3175385D2F2FC9C")
    public int getId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_549159475 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587316519 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587316519;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.937 -0400", hash_original_method = "3020C5CBFA8B36FE57B171E2A093C23C", hash_generated_method = "1F8508C2F4EB7F63D322EB2F08EF772A")
    public int getInterfaceClass() {
        int var3C06167D41E761EA62261D0BFD22DD5C_1284629420 = (mClass);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051384495 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051384495;
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.938 -0400", hash_original_method = "7088B4DB86E16F91D699838E45BCCE2E", hash_generated_method = "9869F0B67E84E917363228594E59E701")
    public int getInterfaceSubclass() {
        int varA9A6C203C9D6DBFDB68228B9097B885C_1292122227 = (mSubclass);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952731733 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952731733;
        // ---------- Original Method ----------
        //return mSubclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.938 -0400", hash_original_method = "095D314DB549CF9B46225B9A82ECAABC", hash_generated_method = "83B902D7C1BAC7E6BDE1170013FFD3BE")
    public int getInterfaceProtocol() {
        int var9EA70B4691A5C944EE5FCEFBDDAC80E7_750757715 = (mProtocol);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744525324 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744525324;
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.938 -0400", hash_original_method = "B83541EC17993A78C7733C982BB94257", hash_generated_method = "371BDC2412CB5A6B6B2C25D37516507A")
    public int getEndpointCount() {
        int var87FFD3733DF9207D981FE58BA941876A_404429375 = (mEndpoints.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448885849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448885849;
        // ---------- Original Method ----------
        //return mEndpoints.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.939 -0400", hash_original_method = "10BF694D0DC13FB211A1D4B783AFDCB8", hash_generated_method = "9DE64B69D672593611DB662A80757EB6")
    public UsbEndpoint getEndpoint(int index) {
        addTaint(index);
UsbEndpoint varA407008022ECD3C933AE6F87B83AAD4B_763083434 =         (UsbEndpoint)mEndpoints[index];
        varA407008022ECD3C933AE6F87B83AAD4B_763083434.addTaint(taint);
        return varA407008022ECD3C933AE6F87B83AAD4B_763083434;
        // ---------- Original Method ----------
        //return (UsbEndpoint)mEndpoints[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.939 -0400", hash_original_method = "7DE8C5BE07836E58A7BC66D5916A69AB", hash_generated_method = "18AAFD56DA6002228F8FAC3928CBEA5F")
    @Override
    public String toString() {
String var03783B3D2CD3446423B1AFCBB32FF247_1988905852 =         "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mEndpoints=" + mEndpoints + "]";
        var03783B3D2CD3446423B1AFCBB32FF247_1988905852.addTaint(taint);
        return var03783B3D2CD3446423B1AFCBB32FF247_1988905852;
        // ---------- Original Method ----------
        //return "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                //",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                //",mEndpoints=" + mEndpoints + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.940 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A6589745D44952168240D55D44836531")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1114104227 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422368451 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422368451;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.940 -0400", hash_original_method = "F436F428B0571288036EC16237EC67B4", hash_generated_method = "22099E68D9F4D6FAD98B0A39473FA21E")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeInt(mId);
        parcel.writeInt(mClass);
        parcel.writeInt(mSubclass);
        parcel.writeInt(mProtocol);
        parcel.writeParcelableArray(mEndpoints, 0);
        // ---------- Original Method ----------
        //parcel.writeInt(mId);
        //parcel.writeInt(mClass);
        //parcel.writeInt(mSubclass);
        //parcel.writeInt(mProtocol);
        //parcel.writeParcelableArray(mEndpoints, 0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.940 -0400", hash_original_field = "DFC34D6D0E087B75AAD32CD74CF57FEE", hash_generated_field = "EBD090A5A2DA9FF41ABEC28EE6AA86B7")

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

