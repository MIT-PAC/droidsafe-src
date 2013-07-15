package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class UsbAccessory implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.824 -0400", hash_original_field = "6D6C47A5EB4751EE95A0B83ED231F29F", hash_generated_field = "FB8FA14B444DCDECB7E1F2DE256B790B")

    private String mManufacturer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.824 -0400", hash_original_field = "E9F27DD04F1F9F18E074C35BBF2786B6", hash_generated_field = "35458D5F083D1893A2F645F3B2CF5FC8")

    private String mModel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.824 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.824 -0400", hash_original_field = "31DABD0EACF4143CCA942BDEEA018E36", hash_generated_field = "AC3A255360E36E7AB143ED8BE7D264A7")

    private String mVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.825 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "E9F1A1B9306C90FC7C133E78A4DA2C70")

    private String mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.825 -0400", hash_original_field = "8CC0BA4F3132C785BD42D542F7CA8632", hash_generated_field = "FBBAA9495E4F4854D260B36E22AD653D")

    private String mSerial;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.826 -0400", hash_original_method = "7CD9FDFE8EAEAE0E43B9A1D60D60D495", hash_generated_method = "2BD440FEB3D93B660A14AFD3D7FACE44")
    public  UsbAccessory(String manufacturer, String model, String description,
            String version, String uri, String serial) {
        mManufacturer = manufacturer;
        mModel = model;
        mDescription = description;
        mVersion = version;
        mUri = uri;
        mSerial = serial;
        // ---------- Original Method ----------
        //mManufacturer = manufacturer;
        //mModel = model;
        //mDescription = description;
        //mVersion = version;
        //mUri = uri;
        //mSerial = serial;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.827 -0400", hash_original_method = "D12B07FB292F613652E291AA784D1EC3", hash_generated_method = "85F4E0DF4FB13ED6AAC867EA2394FF31")
    public  UsbAccessory(String[] strings) {
        mManufacturer = strings[0];
        mModel = strings[1];
        mDescription = strings[2];
        mVersion = strings[3];
        mUri = strings[4];
        mSerial = strings[5];
        // ---------- Original Method ----------
        //mManufacturer = strings[0];
        //mModel = strings[1];
        //mDescription = strings[2];
        //mVersion = strings[3];
        //mUri = strings[4];
        //mSerial = strings[5];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.828 -0400", hash_original_method = "EECC97019E28DA07B84EC558152DCFEE", hash_generated_method = "4F21BFF7308B265731AC613B585E37F2")
    public String getManufacturer() {
String var0ECB07420AF35AAB20D55CC70C2C2AD7_1095880607 =         mManufacturer;
        var0ECB07420AF35AAB20D55CC70C2C2AD7_1095880607.addTaint(taint);
        return var0ECB07420AF35AAB20D55CC70C2C2AD7_1095880607;
        // ---------- Original Method ----------
        //return mManufacturer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.828 -0400", hash_original_method = "375C14568C2F8D8E7E614D0D011D7B99", hash_generated_method = "2F0BE72DBFA8A7E9D51CF063D7BB0A90")
    public String getModel() {
String varEB806B55FD5A3C4DED9D2B3BF6B66983_232126279 =         mModel;
        varEB806B55FD5A3C4DED9D2B3BF6B66983_232126279.addTaint(taint);
        return varEB806B55FD5A3C4DED9D2B3BF6B66983_232126279;
        // ---------- Original Method ----------
        //return mModel;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.829 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "FD6A8F42F87A053B54D90A44BD618914")
    public String getDescription() {
String var2094894B2BDB1315AACD05A5CC5702EE_1760051629 =         mDescription;
        var2094894B2BDB1315AACD05A5CC5702EE_1760051629.addTaint(taint);
        return var2094894B2BDB1315AACD05A5CC5702EE_1760051629;
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.829 -0400", hash_original_method = "F243A33CF0A3D0D255225863927F4698", hash_generated_method = "F481D57D4C87FCECD9ECE7A0771F8CF8")
    public String getVersion() {
String var7C264A52E5E2FA14380A2B33BFB45951_1154758156 =         mVersion;
        var7C264A52E5E2FA14380A2B33BFB45951_1154758156.addTaint(taint);
        return var7C264A52E5E2FA14380A2B33BFB45951_1154758156;
        // ---------- Original Method ----------
        //return mVersion;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.830 -0400", hash_original_method = "8CFE2355A63AF986F8238800728B9A56", hash_generated_method = "B5976F44A78DCAED2F9D274ABBFF58ED")
    public String getUri() {
String var7D41D50876117CE5D7DFAD684A455037_1909949082 =         mUri;
        var7D41D50876117CE5D7DFAD684A455037_1909949082.addTaint(taint);
        return var7D41D50876117CE5D7DFAD684A455037_1909949082;
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.830 -0400", hash_original_method = "E1067F8A99D04B6FDB11E19036F1F2CD", hash_generated_method = "82F15E9196BFF09BB19876ECD87D6946")
    public String getSerial() {
String var1445B1C0309D4AB287DFD42BFC40DFCD_1897648201 =         mSerial;
        var1445B1C0309D4AB287DFD42BFC40DFCD_1897648201.addTaint(taint);
        return var1445B1C0309D4AB287DFD42BFC40DFCD_1897648201;
        // ---------- Original Method ----------
        //return mSerial;
    }

    
        private static boolean compare(String s1, String s2) {
        if (s1 == null) return (s2 == null);
        return s1.equals(s2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.831 -0400", hash_original_method = "865A8510E9F7675674A503A19BC93814", hash_generated_method = "66A90DA5395BF2EC77F841C71695094E")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj instanceof UsbAccessory)        
        {
            UsbAccessory accessory = (UsbAccessory)obj;
            boolean varC1E4C1287847D2AEC8020CDD60FAA51E_1197287921 = ((compare(mManufacturer, accessory.getManufacturer()) &&
                    compare(mModel, accessory.getModel()) &&
                    compare(mDescription, accessory.getDescription()) &&
                    compare(mVersion, accessory.getVersion()) &&
                    compare(mUri, accessory.getUri()) &&
                    compare(mSerial, accessory.getSerial())));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339030001 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_339030001;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1861564016 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_536346879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_536346879;
        // ---------- Original Method ----------
        //if (obj instanceof UsbAccessory) {
            //UsbAccessory accessory = (UsbAccessory)obj;
            //return (compare(mManufacturer, accessory.getManufacturer()) &&
                    //compare(mModel, accessory.getModel()) &&
                    //compare(mDescription, accessory.getDescription()) &&
                    //compare(mVersion, accessory.getVersion()) &&
                    //compare(mUri, accessory.getUri()) &&
                    //compare(mSerial, accessory.getSerial()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.831 -0400", hash_original_method = "1CBDEBF34085121F316849C19724C53C", hash_generated_method = "6D57D31DD96111A7112CB565B667F2C7")
    @Override
    public int hashCode() {
        int varCA9B0BEA131295A14B5D3B285DC7DA12_1064402103 = (((mManufacturer == null ? 0 : mManufacturer.hashCode()) ^
                (mModel == null ? 0 : mModel.hashCode()) ^
                (mDescription == null ? 0 : mDescription.hashCode()) ^
                (mVersion == null ? 0 : mVersion.hashCode()) ^
                (mUri == null ? 0 : mUri.hashCode()) ^
                (mSerial == null ? 0 : mSerial.hashCode())));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009425550 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009425550;
        // ---------- Original Method ----------
        //return ((mManufacturer == null ? 0 : mManufacturer.hashCode()) ^
                //(mModel == null ? 0 : mModel.hashCode()) ^
                //(mDescription == null ? 0 : mDescription.hashCode()) ^
                //(mVersion == null ? 0 : mVersion.hashCode()) ^
                //(mUri == null ? 0 : mUri.hashCode()) ^
                //(mSerial == null ? 0 : mSerial.hashCode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.832 -0400", hash_original_method = "95290F8A4A72A3956B1D8FB9C7186754", hash_generated_method = "3A5977F03DA41911B8A0C56F28C1AF4E")
    @Override
    public String toString() {
String var1683DFD77A14FECD8D736DE9F8F7443E_2141598040 =         "UsbAccessory[mManufacturer=" + mManufacturer +
                            ", mModel=" + mModel +
                            ", mDescription=" + mDescription +
                            ", mVersion=" + mVersion +
                            ", mUri=" + mUri +
                            ", mSerial=" + mSerial + "]";
        var1683DFD77A14FECD8D736DE9F8F7443E_2141598040.addTaint(taint);
        return var1683DFD77A14FECD8D736DE9F8F7443E_2141598040;
        // ---------- Original Method ----------
        //return "UsbAccessory[mManufacturer=" + mManufacturer +
                            //", mModel=" + mModel +
                            //", mDescription=" + mDescription +
                            //", mVersion=" + mVersion +
                            //", mUri=" + mUri +
                            //", mSerial=" + mSerial + "]";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.832 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "CDB4CB5F6FBF7D376B80121D8A1281F3")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1037352497 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153278860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153278860;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.832 -0400", hash_original_method = "5A34BF0EEFA04466D13EE884FC2C2BC9", hash_generated_method = "CFD35AC5BF2CC74E007BD8C1D9D88B43")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeString(mManufacturer);
        parcel.writeString(mModel);
        parcel.writeString(mDescription);
        parcel.writeString(mVersion);
        parcel.writeString(mUri);
        parcel.writeString(mSerial);
        // ---------- Original Method ----------
        //parcel.writeString(mManufacturer);
        //parcel.writeString(mModel);
        //parcel.writeString(mDescription);
        //parcel.writeString(mVersion);
        //parcel.writeString(mUri);
        //parcel.writeString(mSerial);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.833 -0400", hash_original_field = "570257644692EF1791FD6BF594DCB4C3", hash_generated_field = "4B6F95A3D2EDF4F6797837364626E316")

    private static final String TAG = "UsbAccessory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.833 -0400", hash_original_field = "A3A2DE3014AFDD086B0F9108E7253288", hash_generated_field = "41EBB7534711D99912BB3375E9A3165A")

    public static final Parcelable.Creator<UsbAccessory> CREATOR =
        new Parcelable.Creator<UsbAccessory>() {
        public UsbAccessory createFromParcel(Parcel in) {
            String manufacturer = in.readString();
            String model = in.readString();
            String description = in.readString();
            String version = in.readString();
            String uri = in.readString();
            String serial = in.readString();
            return new UsbAccessory(manufacturer, model, description, version, uri, serial);
        }

        public UsbAccessory[] newArray(int size) {
            return new UsbAccessory[size];
        }
    };
    // orphaned legacy method
    public UsbAccessory createFromParcel(Parcel in) {
            String manufacturer = in.readString();
            String model = in.readString();
            String description = in.readString();
            String version = in.readString();
            String uri = in.readString();
            String serial = in.readString();
            return new UsbAccessory(manufacturer, model, description, version, uri, serial);
        }
    
    // orphaned legacy method
    public UsbAccessory[] newArray(int size) {
            return new UsbAccessory[size];
        }
    
}

