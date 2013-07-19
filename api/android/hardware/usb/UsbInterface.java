package android.hardware.usb;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class UsbInterface implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.991 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.991 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private int mClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.991 -0400", hash_original_field = "A9A6C203C9D6DBFDB68228B9097B885C", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private int mSubclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.991 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private int mProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.992 -0400", hash_original_field = "AFC13E9D3BA7D47873423EE17B74D3A6", hash_generated_field = "B49B9B6BE06A0473117FBEFDB3198C46")

    private Parcelable[] mEndpoints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.993 -0400", hash_original_method = "168A662ECD22EEAD4E32FE6198805EA1", hash_generated_method = "8F9AB190C4EE06AFF7C7B49CDD5F34F3")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.993 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "9E658AB1A0CF499C704DA8E15A06F21B")
    public int getId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_160361041 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765260407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765260407;
        // ---------- Original Method ----------
        //return mId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.994 -0400", hash_original_method = "3020C5CBFA8B36FE57B171E2A093C23C", hash_generated_method = "68F232DE23CDCAE2DA1CF40D4DC5BA64")
    public int getInterfaceClass() {
        int var3C06167D41E761EA62261D0BFD22DD5C_524549923 = (mClass);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122127985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122127985;
        // ---------- Original Method ----------
        //return mClass;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.994 -0400", hash_original_method = "7088B4DB86E16F91D699838E45BCCE2E", hash_generated_method = "DC875DD78BA1C80D35C0136A22D62E85")
    public int getInterfaceSubclass() {
        int varA9A6C203C9D6DBFDB68228B9097B885C_473618986 = (mSubclass);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1966296468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1966296468;
        // ---------- Original Method ----------
        //return mSubclass;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.994 -0400", hash_original_method = "095D314DB549CF9B46225B9A82ECAABC", hash_generated_method = "EB6A56ED7A193C6459065B7ADA35A4AE")
    public int getInterfaceProtocol() {
        int var9EA70B4691A5C944EE5FCEFBDDAC80E7_1026548712 = (mProtocol);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656356220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656356220;
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.995 -0400", hash_original_method = "B83541EC17993A78C7733C982BB94257", hash_generated_method = "0FDDF5F069C973B2715A2417CF879585")
    public int getEndpointCount() {
        int var87FFD3733DF9207D981FE58BA941876A_1744604990 = (mEndpoints.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1700886773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1700886773;
        // ---------- Original Method ----------
        //return mEndpoints.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.995 -0400", hash_original_method = "10BF694D0DC13FB211A1D4B783AFDCB8", hash_generated_method = "965AFB6C21EB30D1DA685F3974BAFEB5")
    public UsbEndpoint getEndpoint(int index) {
        addTaint(index);
UsbEndpoint varA407008022ECD3C933AE6F87B83AAD4B_848814924 =         (UsbEndpoint)mEndpoints[index];
        varA407008022ECD3C933AE6F87B83AAD4B_848814924.addTaint(taint);
        return varA407008022ECD3C933AE6F87B83AAD4B_848814924;
        // ---------- Original Method ----------
        //return (UsbEndpoint)mEndpoints[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.996 -0400", hash_original_method = "7DE8C5BE07836E58A7BC66D5916A69AB", hash_generated_method = "A833F26BF654BBE7D6EEB5FB0B36D932")
    @Override
    public String toString() {
String var03783B3D2CD3446423B1AFCBB32FF247_2127091 =         "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mEndpoints=" + mEndpoints + "]";
        var03783B3D2CD3446423B1AFCBB32FF247_2127091.addTaint(taint);
        return var03783B3D2CD3446423B1AFCBB32FF247_2127091;
        // ---------- Original Method ----------
        //return "UsbInterface[mId=" + mId + ",mClass=" + mClass +
                //",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                //",mEndpoints=" + mEndpoints + "]";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.996 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "965325DA84AD1A5EFF82A76A65714499")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1692287989 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425216883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425216883;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.997 -0400", hash_original_method = "F436F428B0571288036EC16237EC67B4", hash_generated_method = "22099E68D9F4D6FAD98B0A39473FA21E")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.997 -0400", hash_original_field = "DFC34D6D0E087B75AAD32CD74CF57FEE", hash_generated_field = "EBD090A5A2DA9FF41ABEC28EE6AA86B7")

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

