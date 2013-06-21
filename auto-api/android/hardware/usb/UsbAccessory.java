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
    private String mManufacturer;
    private String mModel;
    private String mDescription;
    private String mVersion;
    private String mUri;
    private String mSerial;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.094 -0400", hash_original_method = "7CD9FDFE8EAEAE0E43B9A1D60D60D495", hash_generated_method = "8611F109A6A0B6E55E153D16B332B21C")
    @DSModeled(DSC.SAFE)
    public UsbAccessory(String manufacturer, String model, String description,
            String version, String uri, String serial) {
        dsTaint.addTaint(model);
        dsTaint.addTaint(description);
        dsTaint.addTaint(manufacturer);
        dsTaint.addTaint(serial);
        dsTaint.addTaint(uri);
        dsTaint.addTaint(version);
        // ---------- Original Method ----------
        //mManufacturer = manufacturer;
        //mModel = model;
        //mDescription = description;
        //mVersion = version;
        //mUri = uri;
        //mSerial = serial;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.094 -0400", hash_original_method = "D12B07FB292F613652E291AA784D1EC3", hash_generated_method = "1667F0F38D2719F353376251DDC10A6E")
    @DSModeled(DSC.SAFE)
    public UsbAccessory(String[] strings) {
        dsTaint.addTaint(strings[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.094 -0400", hash_original_method = "EECC97019E28DA07B84EC558152DCFEE", hash_generated_method = "F2544B25CB975FB8E358B6EDE25AF210")
    @DSModeled(DSC.SAFE)
    public String getManufacturer() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mManufacturer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.094 -0400", hash_original_method = "375C14568C2F8D8E7E614D0D011D7B99", hash_generated_method = "913AB9182925C98C03BE9CA8A6E03FD7")
    @DSModeled(DSC.SAFE)
    public String getModel() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mModel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.095 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "BC3429D7F0ECDAE789A87366823AC07A")
    @DSModeled(DSC.SAFE)
    public String getDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.095 -0400", hash_original_method = "F243A33CF0A3D0D255225863927F4698", hash_generated_method = "777DFCD106E3106F1E80C80523B0DC19")
    @DSModeled(DSC.SAFE)
    public String getVersion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.095 -0400", hash_original_method = "8CFE2355A63AF986F8238800728B9A56", hash_generated_method = "36F9F01BDF8C1E780DC4CE690AE60CF0")
    @DSModeled(DSC.SAFE)
    public String getUri() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.095 -0400", hash_original_method = "E1067F8A99D04B6FDB11E19036F1F2CD", hash_generated_method = "3FD23AB3CE9B214C7DA50220FBE51CE5")
    @DSModeled(DSC.SAFE)
    public String getSerial() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSerial;
    }

    
        private static boolean compare(String s1, String s2) {
        if (s1 == null) return (s2 == null);
        return s1.equals(s2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.096 -0400", hash_original_method = "865A8510E9F7675674A503A19BC93814", hash_generated_method = "18B7B018BF1E5C3C5F0B876DF6978447")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            UsbAccessory accessory;
            accessory = (UsbAccessory)obj;
            boolean varA895D95C7854CC8CC90C4D356421ADA3_1655569482 = ((compare(mManufacturer, accessory.getManufacturer()) &&
                    compare(mModel, accessory.getModel()) &&
                    compare(mDescription, accessory.getDescription()) &&
                    compare(mVersion, accessory.getVersion()) &&
                    compare(mUri, accessory.getUri()) &&
                    compare(mSerial, accessory.getSerial())));
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.096 -0400", hash_original_method = "1CBDEBF34085121F316849C19724C53C", hash_generated_method = "1783518A1EBFF5666A8A082FAC2E92E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var9F95CCB73C326710698733DF7B6AA12D_1289758585 = (((mManufacturer == null ? 0 : mManufacturer.hashCode()) ^
                (mModel == null ? 0 : mModel.hashCode()) ^
                (mDescription == null ? 0 : mDescription.hashCode()) ^
                (mVersion == null ? 0 : mVersion.hashCode()) ^
                (mUri == null ? 0 : mUri.hashCode()) ^
                (mSerial == null ? 0 : mSerial.hashCode()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((mManufacturer == null ? 0 : mManufacturer.hashCode()) ^
                //(mModel == null ? 0 : mModel.hashCode()) ^
                //(mDescription == null ? 0 : mDescription.hashCode()) ^
                //(mVersion == null ? 0 : mVersion.hashCode()) ^
                //(mUri == null ? 0 : mUri.hashCode()) ^
                //(mSerial == null ? 0 : mSerial.hashCode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.096 -0400", hash_original_method = "95290F8A4A72A3956B1D8FB9C7186754", hash_generated_method = "71C1E25C747951CE0B52EABA1E7F0039")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "UsbAccessory[mManufacturer=" + mManufacturer +
                            //", mModel=" + mModel +
                            //", mDescription=" + mDescription +
                            //", mVersion=" + mVersion +
                            //", mUri=" + mUri +
                            //", mSerial=" + mSerial + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.097 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.098 -0400", hash_original_method = "5A34BF0EEFA04466D13EE884FC2C2BC9", hash_generated_method = "FEF1DF999D12DD04914B493E72FA76EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
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

    
    private static final String TAG = "UsbAccessory";
    public static final Parcelable.Creator<UsbAccessory> CREATOR = new Parcelable.Creator<UsbAccessory>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.099 -0400", hash_original_method = "6F67C421F05E1058937DFFE9EA4CB05C", hash_generated_method = "2650B4BECEC6F6FF7DCF327112FF9755")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UsbAccessory createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            String manufacturer;
            manufacturer = in.readString();
            String model;
            model = in.readString();
            String description;
            description = in.readString();
            String version;
            version = in.readString();
            String uri;
            uri = in.readString();
            String serial;
            serial = in.readString();
            UsbAccessory var4ECF89EED46F595EA6B3AAAEC4A6073C_924007658 = (new UsbAccessory(manufacturer, model, description, version, uri, serial));
            return (UsbAccessory)dsTaint.getTaint();
            // ---------- Original Method ----------
            //String manufacturer = in.readString();
            //String model = in.readString();
            //String description = in.readString();
            //String version = in.readString();
            //String uri = in.readString();
            //String serial = in.readString();
            //return new UsbAccessory(manufacturer, model, description, version, uri, serial);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.099 -0400", hash_original_method = "12C12D51EF30A5A3011766433171A0C7", hash_generated_method = "B6B83CB61B4D29B894EE86ACA185B45C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UsbAccessory[] newArray(int size) {
            dsTaint.addTaint(size);
            UsbAccessory[] var0454EACC0E42D16277C6FFE3371A2A84_1295727614 = (new UsbAccessory[size]);
            return (UsbAccessory[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UsbAccessory[size];
        }

        
}; //Transformed anonymous class
}

