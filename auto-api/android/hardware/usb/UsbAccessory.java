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
import android.util.Log;

public class UsbAccessory implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.812 -0400", hash_original_field = "6D6C47A5EB4751EE95A0B83ED231F29F", hash_generated_field = "FB8FA14B444DCDECB7E1F2DE256B790B")

    private String mManufacturer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.812 -0400", hash_original_field = "E9F27DD04F1F9F18E074C35BBF2786B6", hash_generated_field = "35458D5F083D1893A2F645F3B2CF5FC8")

    private String mModel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.812 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.813 -0400", hash_original_field = "31DABD0EACF4143CCA942BDEEA018E36", hash_generated_field = "AC3A255360E36E7AB143ED8BE7D264A7")

    private String mVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.813 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "E9F1A1B9306C90FC7C133E78A4DA2C70")

    private String mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.813 -0400", hash_original_field = "8CC0BA4F3132C785BD42D542F7CA8632", hash_generated_field = "FBBAA9495E4F4854D260B36E22AD653D")

    private String mSerial;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.838 -0400", hash_original_method = "7CD9FDFE8EAEAE0E43B9A1D60D60D495", hash_generated_method = "2BD440FEB3D93B660A14AFD3D7FACE44")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.839 -0400", hash_original_method = "D12B07FB292F613652E291AA784D1EC3", hash_generated_method = "85F4E0DF4FB13ED6AAC867EA2394FF31")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.840 -0400", hash_original_method = "EECC97019E28DA07B84EC558152DCFEE", hash_generated_method = "3622AA5DBF38C24F4E359DB16CAF54B0")
    public String getManufacturer() {
        String varB4EAC82CA7396A68D541C85D26508E83_1533840571 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1533840571 = mManufacturer;
        varB4EAC82CA7396A68D541C85D26508E83_1533840571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1533840571;
        // ---------- Original Method ----------
        //return mManufacturer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.841 -0400", hash_original_method = "375C14568C2F8D8E7E614D0D011D7B99", hash_generated_method = "7AA0177A65709F6D70663D4595ED27E4")
    public String getModel() {
        String varB4EAC82CA7396A68D541C85D26508E83_1295642635 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1295642635 = mModel;
        varB4EAC82CA7396A68D541C85D26508E83_1295642635.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1295642635;
        // ---------- Original Method ----------
        //return mModel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.847 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "3A376D0BBA962BF0D379C0AE4682621C")
    public String getDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_481012318 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_481012318 = mDescription;
        varB4EAC82CA7396A68D541C85D26508E83_481012318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_481012318;
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.848 -0400", hash_original_method = "F243A33CF0A3D0D255225863927F4698", hash_generated_method = "1877BC85B9A0954C539A3D151B6FA4BE")
    public String getVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1624640580 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1624640580 = mVersion;
        varB4EAC82CA7396A68D541C85D26508E83_1624640580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1624640580;
        // ---------- Original Method ----------
        //return mVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.851 -0400", hash_original_method = "8CFE2355A63AF986F8238800728B9A56", hash_generated_method = "5EC92B9BC1D6F1D72C963D7FCABEF853")
    public String getUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_896748232 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_896748232 = mUri;
        varB4EAC82CA7396A68D541C85D26508E83_896748232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_896748232;
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.855 -0400", hash_original_method = "E1067F8A99D04B6FDB11E19036F1F2CD", hash_generated_method = "1987584004D859934D338346059EE73C")
    public String getSerial() {
        String varB4EAC82CA7396A68D541C85D26508E83_177382858 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_177382858 = mSerial;
        varB4EAC82CA7396A68D541C85D26508E83_177382858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_177382858;
        // ---------- Original Method ----------
        //return mSerial;
    }

    
        private static boolean compare(String s1, String s2) {
        if (s1 == null) return (s2 == null);
        return s1.equals(s2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.875 -0400", hash_original_method = "865A8510E9F7675674A503A19BC93814", hash_generated_method = "57A55FDFCFB75BB5797ABA2DFF4F1586")
    @Override
    public boolean equals(Object obj) {
        {
            UsbAccessory accessory;
            accessory = (UsbAccessory)obj;
            boolean varA895D95C7854CC8CC90C4D356421ADA3_1481251718 = ((compare(mManufacturer, accessory.getManufacturer()) &&
                    compare(mModel, accessory.getModel()) &&
                    compare(mDescription, accessory.getDescription()) &&
                    compare(mVersion, accessory.getVersion()) &&
                    compare(mUri, accessory.getUri()) &&
                    compare(mSerial, accessory.getSerial())));
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1134732929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1134732929;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.877 -0400", hash_original_method = "1CBDEBF34085121F316849C19724C53C", hash_generated_method = "C935EBC6B57E9BC67B2E13CFF485E483")
    @Override
    public int hashCode() {
        int var9F95CCB73C326710698733DF7B6AA12D_1212888757 = (((mManufacturer == null ? 0 : mManufacturer.hashCode()) ^
                (mModel == null ? 0 : mModel.hashCode()) ^
                (mDescription == null ? 0 : mDescription.hashCode()) ^
                (mVersion == null ? 0 : mVersion.hashCode()) ^
                (mUri == null ? 0 : mUri.hashCode()) ^
                (mSerial == null ? 0 : mSerial.hashCode()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269303189 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269303189;
        // ---------- Original Method ----------
        //return ((mManufacturer == null ? 0 : mManufacturer.hashCode()) ^
                //(mModel == null ? 0 : mModel.hashCode()) ^
                //(mDescription == null ? 0 : mDescription.hashCode()) ^
                //(mVersion == null ? 0 : mVersion.hashCode()) ^
                //(mUri == null ? 0 : mUri.hashCode()) ^
                //(mSerial == null ? 0 : mSerial.hashCode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.883 -0400", hash_original_method = "95290F8A4A72A3956B1D8FB9C7186754", hash_generated_method = "F743FA357112144988C50A871F9CE366")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1985771227 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1985771227 = "UsbAccessory[mManufacturer=" + mManufacturer +
                            ", mModel=" + mModel +
                            ", mDescription=" + mDescription +
                            ", mVersion=" + mVersion +
                            ", mUri=" + mUri +
                            ", mSerial=" + mSerial + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1985771227.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1985771227;
        // ---------- Original Method ----------
        //return "UsbAccessory[mManufacturer=" + mManufacturer +
                            //", mModel=" + mModel +
                            //", mDescription=" + mDescription +
                            //", mVersion=" + mVersion +
                            //", mUri=" + mUri +
                            //", mSerial=" + mSerial + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.883 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "267F11DC4995700264E85B28E70B1684")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975397852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975397852;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.892 -0400", hash_original_method = "5A34BF0EEFA04466D13EE884FC2C2BC9", hash_generated_method = "C3A9FCA09014C62D67343683D3BF908C")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mManufacturer);
        parcel.writeString(mModel);
        parcel.writeString(mDescription);
        parcel.writeString(mVersion);
        parcel.writeString(mUri);
        parcel.writeString(mSerial);
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //parcel.writeString(mManufacturer);
        //parcel.writeString(mModel);
        //parcel.writeString(mDescription);
        //parcel.writeString(mVersion);
        //parcel.writeString(mUri);
        //parcel.writeString(mSerial);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.892 -0400", hash_original_field = "570257644692EF1791FD6BF594DCB4C3", hash_generated_field = "992E4C9AB67678303464136AA79DC380")

    private static String TAG = "UsbAccessory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.893 -0400", hash_original_field = "A3A2DE3014AFDD086B0F9108E7253288", hash_generated_field = "41EBB7534711D99912BB3375E9A3165A")

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
}

