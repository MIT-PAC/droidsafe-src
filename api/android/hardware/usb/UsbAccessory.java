package android.hardware.usb;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class UsbAccessory implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.861 -0400", hash_original_field = "6D6C47A5EB4751EE95A0B83ED231F29F", hash_generated_field = "FB8FA14B444DCDECB7E1F2DE256B790B")

    private String mManufacturer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.861 -0400", hash_original_field = "E9F27DD04F1F9F18E074C35BBF2786B6", hash_generated_field = "35458D5F083D1893A2F645F3B2CF5FC8")

    private String mModel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.861 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.861 -0400", hash_original_field = "31DABD0EACF4143CCA942BDEEA018E36", hash_generated_field = "AC3A255360E36E7AB143ED8BE7D264A7")

    private String mVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.861 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "E9F1A1B9306C90FC7C133E78A4DA2C70")

    private String mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.862 -0400", hash_original_field = "8CC0BA4F3132C785BD42D542F7CA8632", hash_generated_field = "FBBAA9495E4F4854D260B36E22AD653D")

    private String mSerial;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.863 -0400", hash_original_method = "7CD9FDFE8EAEAE0E43B9A1D60D60D495", hash_generated_method = "2BD440FEB3D93B660A14AFD3D7FACE44")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.864 -0400", hash_original_method = "D12B07FB292F613652E291AA784D1EC3", hash_generated_method = "85F4E0DF4FB13ED6AAC867EA2394FF31")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.865 -0400", hash_original_method = "EECC97019E28DA07B84EC558152DCFEE", hash_generated_method = "2E02D7119F9047248DAAA57FB78211DE")
    public String getManufacturer() {
String var0ECB07420AF35AAB20D55CC70C2C2AD7_1309633635 =         mManufacturer;
        var0ECB07420AF35AAB20D55CC70C2C2AD7_1309633635.addTaint(taint);
        return var0ECB07420AF35AAB20D55CC70C2C2AD7_1309633635;
        // ---------- Original Method ----------
        //return mManufacturer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.865 -0400", hash_original_method = "375C14568C2F8D8E7E614D0D011D7B99", hash_generated_method = "E2FCDC02CF4F60DFCA9E9DFE4DCCC4B5")
    public String getModel() {
String varEB806B55FD5A3C4DED9D2B3BF6B66983_156630100 =         mModel;
        varEB806B55FD5A3C4DED9D2B3BF6B66983_156630100.addTaint(taint);
        return varEB806B55FD5A3C4DED9D2B3BF6B66983_156630100;
        // ---------- Original Method ----------
        //return mModel;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.866 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "D6A4ECD257B71D06A1003B314574A983")
    public String getDescription() {
String var2094894B2BDB1315AACD05A5CC5702EE_1425559440 =         mDescription;
        var2094894B2BDB1315AACD05A5CC5702EE_1425559440.addTaint(taint);
        return var2094894B2BDB1315AACD05A5CC5702EE_1425559440;
        // ---------- Original Method ----------
        //return mDescription;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.866 -0400", hash_original_method = "F243A33CF0A3D0D255225863927F4698", hash_generated_method = "68097040A8D1366F65E8A7D84D21C47F")
    public String getVersion() {
String var7C264A52E5E2FA14380A2B33BFB45951_1401902465 =         mVersion;
        var7C264A52E5E2FA14380A2B33BFB45951_1401902465.addTaint(taint);
        return var7C264A52E5E2FA14380A2B33BFB45951_1401902465;
        // ---------- Original Method ----------
        //return mVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.866 -0400", hash_original_method = "8CFE2355A63AF986F8238800728B9A56", hash_generated_method = "93D561F0FC39B3F67D2AC21A64C31579")
    public String getUri() {
String var7D41D50876117CE5D7DFAD684A455037_1334504862 =         mUri;
        var7D41D50876117CE5D7DFAD684A455037_1334504862.addTaint(taint);
        return var7D41D50876117CE5D7DFAD684A455037_1334504862;
        // ---------- Original Method ----------
        //return mUri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.867 -0400", hash_original_method = "E1067F8A99D04B6FDB11E19036F1F2CD", hash_generated_method = "491D0D1695A731E1DAA12D2BF407D3CE")
    public String getSerial() {
String var1445B1C0309D4AB287DFD42BFC40DFCD_483751696 =         mSerial;
        var1445B1C0309D4AB287DFD42BFC40DFCD_483751696.addTaint(taint);
        return var1445B1C0309D4AB287DFD42BFC40DFCD_483751696;
        // ---------- Original Method ----------
        //return mSerial;
    }

    
    @DSModeled(DSC.BAN)
    private static boolean compare(String s1, String s2) {
        if (s1 == null) return (s2 == null);
        return s1.equals(s2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.868 -0400", hash_original_method = "865A8510E9F7675674A503A19BC93814", hash_generated_method = "85E37B2A0895FFA070005067954D4652")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj instanceof UsbAccessory)        
        {
            UsbAccessory accessory = (UsbAccessory)obj;
            boolean varC1E4C1287847D2AEC8020CDD60FAA51E_416965591 = ((compare(mManufacturer, accessory.getManufacturer()) &&
                    compare(mModel, accessory.getModel()) &&
                    compare(mDescription, accessory.getDescription()) &&
                    compare(mVersion, accessory.getVersion()) &&
                    compare(mUri, accessory.getUri()) &&
                    compare(mSerial, accessory.getSerial())));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1280700678 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1280700678;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1497885925 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447361130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447361130;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.870 -0400", hash_original_method = "1CBDEBF34085121F316849C19724C53C", hash_generated_method = "D5E00BFCFC375ED64BE5EFD692BE81A0")
    @Override
    public int hashCode() {
        int varCA9B0BEA131295A14B5D3B285DC7DA12_518644333 = (((mManufacturer == null ? 0 : mManufacturer.hashCode()) ^
                (mModel == null ? 0 : mModel.hashCode()) ^
                (mDescription == null ? 0 : mDescription.hashCode()) ^
                (mVersion == null ? 0 : mVersion.hashCode()) ^
                (mUri == null ? 0 : mUri.hashCode()) ^
                (mSerial == null ? 0 : mSerial.hashCode())));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418647103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418647103;
        // ---------- Original Method ----------
        //return ((mManufacturer == null ? 0 : mManufacturer.hashCode()) ^
                //(mModel == null ? 0 : mModel.hashCode()) ^
                //(mDescription == null ? 0 : mDescription.hashCode()) ^
                //(mVersion == null ? 0 : mVersion.hashCode()) ^
                //(mUri == null ? 0 : mUri.hashCode()) ^
                //(mSerial == null ? 0 : mSerial.hashCode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.872 -0400", hash_original_method = "95290F8A4A72A3956B1D8FB9C7186754", hash_generated_method = "1662A710D450EC2EA3B44434545BE265")
    @Override
    public String toString() {
String var1683DFD77A14FECD8D736DE9F8F7443E_35388079 =         "UsbAccessory[mManufacturer=" + mManufacturer +
                            ", mModel=" + mModel +
                            ", mDescription=" + mDescription +
                            ", mVersion=" + mVersion +
                            ", mUri=" + mUri +
                            ", mSerial=" + mSerial + "]";
        var1683DFD77A14FECD8D736DE9F8F7443E_35388079.addTaint(taint);
        return var1683DFD77A14FECD8D736DE9F8F7443E_35388079;
        // ---------- Original Method ----------
        //return "UsbAccessory[mManufacturer=" + mManufacturer +
                            //", mModel=" + mModel +
                            //", mDescription=" + mDescription +
                            //", mVersion=" + mVersion +
                            //", mUri=" + mUri +
                            //", mSerial=" + mSerial + "]";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.872 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E508EFF01BDA20B64063C378EAFC6644")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_221174179 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981225882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981225882;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.873 -0400", hash_original_method = "5A34BF0EEFA04466D13EE884FC2C2BC9", hash_generated_method = "CFD35AC5BF2CC74E007BD8C1D9D88B43")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.873 -0400", hash_original_field = "570257644692EF1791FD6BF594DCB4C3", hash_generated_field = "4B6F95A3D2EDF4F6797837364626E316")

    private static final String TAG = "UsbAccessory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.873 -0400", hash_original_field = "A3A2DE3014AFDD086B0F9108E7253288", hash_generated_field = "41EBB7534711D99912BB3375E9A3165A")

    public static final Parcelable.Creator<UsbAccessory> CREATOR =
        new Parcelable.Creator<UsbAccessory>() {
        @DSModeled(DSC.SAFE)
        public UsbAccessory createFromParcel(Parcel in) {
            String manufacturer = in.readString();
            String model = in.readString();
            String description = in.readString();
            String version = in.readString();
            String uri = in.readString();
            String serial = in.readString();
            return new UsbAccessory(manufacturer, model, description, version, uri, serial);
        }

        @DSModeled(DSC.SAFE)
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

