package android.hardware.usb;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;




import droidsafe.helpers.DSUtils;

public class UsbDevice implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.910 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.910 -0400", hash_original_field = "0C697C350A03A7E88A6376DE08D4E014", hash_generated_field = "5A1C737B3F08366BB701627450ACF389")

    private int mVendorId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.910 -0400", hash_original_field = "D83984F84CEEC24EF6A3FCCFE377A0CC", hash_generated_field = "0983DEB124753543C3C906C91F06874F")

    private int mProductId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.910 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "6544EE8866FC2E4C41A3A39948F7A47D")

    private int mClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.910 -0400", hash_original_field = "A9A6C203C9D6DBFDB68228B9097B885C", hash_generated_field = "386FD9F32DD2599D0A74CB186915FD00")

    private int mSubclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.910 -0400", hash_original_field = "9EA70B4691A5C944EE5FCEFBDDAC80E7", hash_generated_field = "BD72DCA469F4DB69DDE6AF7E2750E607")

    private int mProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.911 -0400", hash_original_field = "28ECEE9E94DD840432DC0C85D4935748", hash_generated_field = "80BA38A6BB3E15CA7B72700E2D0A4A7D")

    private Parcelable[] mInterfaces;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.912 -0400", hash_original_method = "45BC6016FF6AF1FC93CB29968E3D6094", hash_generated_method = "8529F1E5A00AA508A928D720A5DD870E")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.915 -0400", hash_original_method = "271D12AC1725A6D768ED59A731E22C7D", hash_generated_method = "E5D25FD995B702A5D9E3369A7E42CA14")
    public String getDeviceName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_1352656028 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_1352656028.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_1352656028;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.915 -0400", hash_original_method = "0EB91F28C0A2FB6299B3C615FC2DAB8F", hash_generated_method = "5630FE0ADFE3465E4ECEBC1D63177AB6")
    public int getDeviceId() {
        int varD16BE95D43BBDC17821928ECA9EA5B22_743367737 = (getDeviceId(mName));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84058910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84058910;
        // ---------- Original Method ----------
        //return getDeviceId(mName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.916 -0400", hash_original_method = "D8945A991BD9144132914298D2B7FC76", hash_generated_method = "807486556B86A993274243F98556416F")
    public int getVendorId() {
        int var0C697C350A03A7E88A6376DE08D4E014_11273209 = (mVendorId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193774815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193774815;
        // ---------- Original Method ----------
        //return mVendorId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.916 -0400", hash_original_method = "A32B17A7DCA377FC904869E22B60DAE0", hash_generated_method = "B14E22518A50951527C07D58239F11F6")
    public int getProductId() {
        int varD83984F84CEEC24EF6A3FCCFE377A0CC_1313397200 = (mProductId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974575230 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974575230;
        // ---------- Original Method ----------
        //return mProductId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.917 -0400", hash_original_method = "45BD51C898E5D7F479BD37DC16F7713C", hash_generated_method = "2F5F78F6D3FE9696D1941CD98B424FDE")
    public int getDeviceClass() {
        int var3C06167D41E761EA62261D0BFD22DD5C_629584427 = (mClass);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650585507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650585507;
        // ---------- Original Method ----------
        //return mClass;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.917 -0400", hash_original_method = "13162F24DC75BB4BAAF33D909DA8EE5C", hash_generated_method = "3297BF7E327FC509F0C6720C968713DA")
    public int getDeviceSubclass() {
        int varA9A6C203C9D6DBFDB68228B9097B885C_1304394296 = (mSubclass);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562931806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562931806;
        // ---------- Original Method ----------
        //return mSubclass;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.918 -0400", hash_original_method = "5B59FED3FAC8826DFB249AE836C6A83B", hash_generated_method = "F06FED3E140523564D25CBC7C3C05B9A")
    public int getDeviceProtocol() {
        int var9EA70B4691A5C944EE5FCEFBDDAC80E7_881776799 = (mProtocol);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972219518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972219518;
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.918 -0400", hash_original_method = "3245218866A20CE01DF5327E310A1077", hash_generated_method = "202361D4BC5B43CB101A51026E9E2944")
    public int getInterfaceCount() {
        int var7EA4F1DED4594980DF738F95F96A720C_700531562 = (mInterfaces.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280974600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280974600;
        // ---------- Original Method ----------
        //return mInterfaces.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.918 -0400", hash_original_method = "CB4E75DEC838C411BA866F14CD6483BC", hash_generated_method = "3EC7E95A256EFD93B00DDDE8968B2DE6")
    public UsbInterface getInterface(int index) {
        addTaint(index);
UsbInterface varE38340EB36987638594051ED4588C1E3_1171252426 =         (UsbInterface)mInterfaces[index];
        varE38340EB36987638594051ED4588C1E3_1171252426.addTaint(taint);
        return varE38340EB36987638594051ED4588C1E3_1171252426;
        // ---------- Original Method ----------
        //return (UsbInterface)mInterfaces[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.919 -0400", hash_original_method = "053D020F017F8544B1264C0EDF41C58B", hash_generated_method = "38DCE4447F32AA302CD8903DEEC3E362")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o instanceof UsbDevice)        
        {
            boolean varE3D8BB648ED1CF48194F7DE30AAB0184_423191949 = (((UsbDevice)o).mName.equals(mName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717212550 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_717212550;
        } //End block
        else
        if(o instanceof String)        
        {
            boolean var891800E06980D3343D44655769B9CF7A_1062055787 = (((String)o).equals(mName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246122775 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_246122775;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_2013338750 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453632584 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_453632584;
        } //End block
        // ---------- Original Method ----------
        //if (o instanceof UsbDevice) {
            //return ((UsbDevice)o).mName.equals(mName);
        //} else if (o instanceof String) {
            //return ((String)o).equals(mName);
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.920 -0400", hash_original_method = "17C09B2A154A4C6FF6181DC76A163C25", hash_generated_method = "FCD5ADB77C99352405204B1745709B9D")
    @Override
    public int hashCode() {
        int varFF56FBCF4A9C85EF1FCAE75D5EFC9557_487984407 = (mName.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603007060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603007060;
        // ---------- Original Method ----------
        //return mName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.921 -0400", hash_original_method = "E3858C7D4009824DA04CA335F7246ABC", hash_generated_method = "2222FA2C27C9D091F0D05091905CABC6")
    @Override
    public String toString() {
String var698D883E8B5EB48E4AB16093FCE6D05D_2046203710 =         "UsbDevice[mName=" + mName + ",mVendorId=" + mVendorId +
                ",mProductId=" + mProductId + ",mClass=" + mClass +
                ",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                ",mInterfaces=" + mInterfaces + "]";
        var698D883E8B5EB48E4AB16093FCE6D05D_2046203710.addTaint(taint);
        return var698D883E8B5EB48E4AB16093FCE6D05D_2046203710;
        // ---------- Original Method ----------
        //return "UsbDevice[mName=" + mName + ",mVendorId=" + mVendorId +
                //",mProductId=" + mProductId + ",mClass=" + mClass +
                //",mSubclass=" + mSubclass + ",mProtocol=" + mProtocol +
                //",mInterfaces=" + mInterfaces + "]";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.921 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "01D937AA5605E4CD3D3F4F5E96A76B38")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1056619672 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594942970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594942970;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.922 -0400", hash_original_method = "A5AD5FD8C4031CD6304CBA4A2E71482A", hash_generated_method = "ECB709092CE861032D77A4FA768460F2")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
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

    
    @DSModeled(DSC.SAFE)
    private static int native_get_device_id(String name) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static String native_get_device_name(int id) {
        	return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.923 -0400", hash_original_field = "9B47FB106BAFC251566582F4F8FE8EB8", hash_generated_field = "DAD861C32930D3C3DB9711543F4CBDEA")

    private static final String TAG = "UsbDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.923 -0400", hash_original_field = "623DE101C192EB47E22D3D874CA85384", hash_generated_field = "A89610AE47A5F75950EAB1C2A2C5993E")

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

