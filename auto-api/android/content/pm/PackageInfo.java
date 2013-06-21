package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class PackageInfo implements Parcelable {
    public String packageName;
    public int versionCode;
    public String versionName;
    public String sharedUserId;
    public int sharedUserLabel;
    public ApplicationInfo applicationInfo;
    public long firstInstallTime;
    public long lastUpdateTime;
    public int[] gids;
    public ActivityInfo[] activities;
    public ActivityInfo[] receivers;
    public ServiceInfo[] services;
    public ProviderInfo[] providers;
    public InstrumentationInfo[] instrumentation;
    public PermissionInfo[] permissions;
    public String[] requestedPermissions;
    public Signature[] signatures;
    public ConfigurationInfo[] configPreferences;
    public FeatureInfo[] reqFeatures;
    public int installLocation = INSTALL_LOCATION_INTERNAL_ONLY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.063 -0400", hash_original_method = "28FD03AD36E70CA65DC12DAEBF4BAB2B", hash_generated_method = "2F8FDFAA3E5302C1D2777402917BDB61")
    @DSModeled(DSC.SAFE)
    public PackageInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.064 -0400", hash_original_method = "22E0C1407EA1D1C66AB0B4BE22F88AA5", hash_generated_method = "7079240D89C102FA2476722B95F07EF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private PackageInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        packageName = source.readString();
        versionCode = source.readInt();
        versionName = source.readString();
        sharedUserId = source.readString();
        sharedUserLabel = source.readInt();
        int hasApp;
        hasApp = source.readInt();
        {
            applicationInfo = ApplicationInfo.CREATOR.createFromParcel(source);
        } //End block
        firstInstallTime = source.readLong();
        lastUpdateTime = source.readLong();
        gids = source.createIntArray();
        activities = source.createTypedArray(ActivityInfo.CREATOR);
        receivers = source.createTypedArray(ActivityInfo.CREATOR);
        services = source.createTypedArray(ServiceInfo.CREATOR);
        providers = source.createTypedArray(ProviderInfo.CREATOR);
        instrumentation = source.createTypedArray(InstrumentationInfo.CREATOR);
        permissions = source.createTypedArray(PermissionInfo.CREATOR);
        requestedPermissions = source.createStringArray();
        signatures = source.createTypedArray(Signature.CREATOR);
        configPreferences = source.createTypedArray(ConfigurationInfo.CREATOR);
        reqFeatures = source.createTypedArray(FeatureInfo.CREATOR);
        installLocation = source.readInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.065 -0400", hash_original_method = "F32D243E2D05219891E68C55116B54A4", hash_generated_method = "0E4E71E907F4CC780D259CCA79975455")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varA4C8D9946CECDC68209DEF3BD827F4C7_841287001 = ("PackageInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "PackageInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + packageName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.065 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.066 -0400", hash_original_method = "F276E90711C385BB34A836DEED976429", hash_generated_method = "6673270B45EAD0C33C1454F7B1093F10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(packageName);
        dest.writeInt(versionCode);
        dest.writeString(versionName);
        dest.writeString(sharedUserId);
        dest.writeInt(sharedUserLabel);
        {
            dest.writeInt(1);
            applicationInfo.writeToParcel(dest, parcelableFlags);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        dest.writeLong(firstInstallTime);
        dest.writeLong(lastUpdateTime);
        dest.writeIntArray(gids);
        dest.writeTypedArray(activities, parcelableFlags);
        dest.writeTypedArray(receivers, parcelableFlags);
        dest.writeTypedArray(services, parcelableFlags);
        dest.writeTypedArray(providers, parcelableFlags);
        dest.writeTypedArray(instrumentation, parcelableFlags);
        dest.writeTypedArray(permissions, parcelableFlags);
        dest.writeStringArray(requestedPermissions);
        dest.writeTypedArray(signatures, parcelableFlags);
        dest.writeTypedArray(configPreferences, parcelableFlags);
        dest.writeTypedArray(reqFeatures, parcelableFlags);
        dest.writeInt(installLocation);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final int INSTALL_LOCATION_UNSPECIFIED = -1;
    public static final int INSTALL_LOCATION_AUTO = 0;
    public static final int INSTALL_LOCATION_INTERNAL_ONLY = 1;
    public static final int INSTALL_LOCATION_PREFER_EXTERNAL = 2;
    public static final Parcelable.Creator<PackageInfo> CREATOR = new Parcelable.Creator<PackageInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.067 -0400", hash_original_method = "786D77E8B5ED4A451D329DFF278050D7", hash_generated_method = "D2CA2AF3B5DDEF0FDE7A96AB2111040F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PackageInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            PackageInfo varB7444A8C2CC149CED10A962BD32973D3_1431551493 = (new PackageInfo(source));
            return (PackageInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PackageInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.068 -0400", hash_original_method = "F6ABA3CA6C3536F47C5E2AFE49063321", hash_generated_method = "AAB2705E6D426627E5D6B9D66C06FCCA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PackageInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            PackageInfo[] var589F8DA9F5B3351FB26B61CBB3AD9594_1801125009 = (new PackageInfo[size]);
            return (PackageInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PackageInfo[size];
        }

        
}; //Transformed anonymous class
}

