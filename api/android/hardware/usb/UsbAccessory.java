package android.hardware.usb;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class UsbAccessory implements Parcelable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.616 -0500", hash_original_method = "D8D7DCC3B2A32D762DF452DE7CB7EB2F", hash_generated_method = "B3C5A47D500FA218ED91A35F692E94AD")
    
private static boolean compare(String s1, String s2) {
        if (s1 == null) return (s2 == null);
        return s1.equals(s2);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.574 -0500", hash_original_field = "62629DFD2FD8B3C654386FF34BCC6F2B", hash_generated_field = "4B6F95A3D2EDF4F6797837364626E316")

    private static final String TAG = "UsbAccessory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.873 -0400", hash_original_field = "A3A2DE3014AFDD086B0F9108E7253288", hash_generated_field = "41EBB7534711D99912BB3375E9A3165A")

    public static final Parcelable.Creator<UsbAccessory> CREATOR =
        new Parcelable.Creator<UsbAccessory>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.629 -0500", hash_original_method = "6F67C421F05E1058937DFFE9EA4CB05C", hash_generated_method = "C10BB6B8EBC3AECC52AD543516F712C3")
        
public UsbAccessory createFromParcel(Parcel in) {
            String manufacturer = in.readString();
            String model = in.readString();
            String description = in.readString();
            String version = in.readString();
            String uri = in.readString();
            String serial = in.readString();
            return new UsbAccessory(manufacturer, model, description, version, uri, serial);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.632 -0500", hash_original_method = "12C12D51EF30A5A3011766433171A0C7", hash_generated_method = "27BE6D27C2983FA3AB426B6C70279FF5")
        
public UsbAccessory[] newArray(int size) {
            return new UsbAccessory[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.577 -0500", hash_original_field = "FAC2F85538315F855B4418F994096B5B", hash_generated_field = "FB8FA14B444DCDECB7E1F2DE256B790B")

    private  String mManufacturer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.580 -0500", hash_original_field = "30F6FA923CB98DBE04C90A0F74F44429", hash_generated_field = "35458D5F083D1893A2F645F3B2CF5FC8")

    private  String mModel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.582 -0500", hash_original_field = "6FC53B81BF2A7EC21138D42F363D7B9A", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private  String mDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.584 -0500", hash_original_field = "BEB2EC516DDBAAA95FFA667FE90CB933", hash_generated_field = "AC3A255360E36E7AB143ED8BE7D264A7")

    private  String mVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.587 -0500", hash_original_field = "BA70E00DFD0E7FE38CE5D2F28F5B3217", hash_generated_field = "E9F1A1B9306C90FC7C133E78A4DA2C70")

    private  String mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.591 -0500", hash_original_field = "901F9F0ED5447A3A20EE9BD888F629D8", hash_generated_field = "FBBAA9495E4F4854D260B36E22AD653D")

    private  String mSerial;

    /**
     * UsbAccessory should only be instantiated by UsbService implementation
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.594 -0500", hash_original_method = "7CD9FDFE8EAEAE0E43B9A1D60D60D495", hash_generated_method = "DD31A186A9214AD12BC5569857DBF8AD")
    
public UsbAccessory(String manufacturer, String model, String description,
            String version, String uri, String serial) {
        mManufacturer = manufacturer;
        mModel = model;
        mDescription = description;
        mVersion = version;
        mUri = uri;
        mSerial = serial;
    }

    /**
     * UsbAccessory should only be instantiated by UsbService implementation
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.597 -0500", hash_original_method = "D12B07FB292F613652E291AA784D1EC3", hash_generated_method = "D8C9F48800D894749D82032175A77F99")
    
public UsbAccessory(String[] strings) {
        mManufacturer = strings[0];
        mModel = strings[1];
        mDescription = strings[2];
        mVersion = strings[3];
        mUri = strings[4];
        mSerial = strings[5];
    }

    /**
     * Returns the manufacturer name of the accessory.
     *
     * @return the accessory manufacturer
     */
    @DSComment("Harvesting information")
    @DSSpec(DSCat.SECURITY)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.599 -0500", hash_original_method = "EECC97019E28DA07B84EC558152DCFEE", hash_generated_method = "7CCE616C67D625A2F8B03A75DB370317")
    
public String getManufacturer() {
        return mManufacturer;
    }

    /**
     * Returns the model name of the accessory.
     *
     * @return the accessory model
     */
    @DSComment("Harvesting information")
    @DSSpec(DSCat.SECURITY)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.602 -0500", hash_original_method = "375C14568C2F8D8E7E614D0D011D7B99", hash_generated_method = "752E2DA19C07CEE5F9299D0BA677AA36")
    
public String getModel() {
        return mModel;
    }

    /**
     * Returns a user visible description of the accessory.
     *
     * @return the accessory description
     */
    @DSComment("Harvesting information")
    @DSSpec(DSCat.SECURITY)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.605 -0500", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "C24A704C1B7693A32CE618B690D2C768")
    
public String getDescription() {
        return mDescription;
    }

    /**
     * Returns the version of the accessory.
     *
     * @return the accessory version
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.608 -0500", hash_original_method = "F243A33CF0A3D0D255225863927F4698", hash_generated_method = "B59C42D60FB8E974EFBE76E7358E83C9")
    
public String getVersion() {
        return mVersion;
    }

    /**
     * Returns the URI for the accessory.
     * This is an optional URI that might show information about the accessory
     * or provide the option to download an application for the accessory
     *
     * @return the accessory URI
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.611 -0500", hash_original_method = "8CFE2355A63AF986F8238800728B9A56", hash_generated_method = "A7E9854BF5F0A123051DDAB526B34F7B")
    
public String getUri() {
        return mUri;
    }

    /**
     * Returns the unique serial number for the accessory.
     * This is an optional serial number that can be used to differentiate
     * between individual accessories of the same model and manufacturer
     *
     * @return the unique serial number
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.613 -0500", hash_original_method = "E1067F8A99D04B6FDB11E19036F1F2CD", hash_generated_method = "3ADF45C3AD144FC96F44D18D05C2BBC0")
    
public String getSerial() {
        return mSerial;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.619 -0500", hash_original_method = "865A8510E9F7675674A503A19BC93814", hash_generated_method = "86E73AA91ED7758821BE20F4136738A2")
    
@Override
    public boolean equals(Object obj) {
        if (obj instanceof UsbAccessory) {
            UsbAccessory accessory = (UsbAccessory)obj;
            return (compare(mManufacturer, accessory.getManufacturer()) &&
                    compare(mModel, accessory.getModel()) &&
                    compare(mDescription, accessory.getDescription()) &&
                    compare(mVersion, accessory.getVersion()) &&
                    compare(mUri, accessory.getUri()) &&
                    compare(mSerial, accessory.getSerial()));
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.623 -0500", hash_original_method = "1CBDEBF34085121F316849C19724C53C", hash_generated_method = "5C80FF58431243E02BE55854CFABBACA")
    
@Override
    public int hashCode() {
        return ((mManufacturer == null ? 0 : mManufacturer.hashCode()) ^
                (mModel == null ? 0 : mModel.hashCode()) ^
                (mDescription == null ? 0 : mDescription.hashCode()) ^
                (mVersion == null ? 0 : mVersion.hashCode()) ^
                (mUri == null ? 0 : mUri.hashCode()) ^
                (mSerial == null ? 0 : mSerial.hashCode()));
    }

    @DSComment("Harvesting information")
    @DSSpec(DSCat.SECURITY)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.625 -0500", hash_original_method = "95290F8A4A72A3956B1D8FB9C7186754", hash_generated_method = "1C0C4DEDC2B1D558B41C1B01F2E7B4B1")
    
@Override
    public String toString() {
        return "UsbAccessory[mManufacturer=" + mManufacturer +
                            ", mModel=" + mModel +
                            ", mDescription=" + mDescription +
                            ", mVersion=" + mVersion +
                            ", mUri=" + mUri +
                            ", mSerial=" + mSerial + "]";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.639 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.641 -0500", hash_original_method = "5A34BF0EEFA04466D13EE884FC2C2BC9", hash_generated_method = "755C814F154EC65D66239041F56A7BB7")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mManufacturer);
        parcel.writeString(mModel);
        parcel.writeString(mDescription);
        parcel.writeString(mVersion);
        parcel.writeString(mUri);
        parcel.writeString(mSerial);
   }
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

