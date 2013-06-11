package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final int INSTALL_LOCATION_UNSPECIFIED = -1;
    public static final int INSTALL_LOCATION_AUTO = 0;
    public static final int INSTALL_LOCATION_INTERNAL_ONLY = 1;
    public static final int INSTALL_LOCATION_PREFER_EXTERNAL = 2;
    public int installLocation = INSTALL_LOCATION_INTERNAL_ONLY;
    public static final Parcelable.Creator<PackageInfo> CREATOR = new Parcelable.Creator<PackageInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.115 -0400", hash_original_method = "786D77E8B5ED4A451D329DFF278050D7", hash_generated_method = "3F3F93C48E734C77DC4731CA10268FFE")
        @DSModeled(DSC.SAFE)
        public PackageInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (PackageInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PackageInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.115 -0400", hash_original_method = "F6ABA3CA6C3536F47C5E2AFE49063321", hash_generated_method = "004568D6C9441F9FDF44642E6AA98422")
        @DSModeled(DSC.SAFE)
        public PackageInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (PackageInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PackageInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.115 -0400", hash_original_method = "28FD03AD36E70CA65DC12DAEBF4BAB2B", hash_generated_method = "3848A729D35A3CA9F3284F1FF68C244A")
    @DSModeled(DSC.SAFE)
    public PackageInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.116 -0400", hash_original_method = "22E0C1407EA1D1C66AB0B4BE22F88AA5", hash_generated_method = "B0B7B1DC69F5502090887A1E552EABC1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.116 -0400", hash_original_method = "F32D243E2D05219891E68C55116B54A4", hash_generated_method = "742541F5D5D4CEE9D69277F0FEF44443")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varA4C8D9946CECDC68209DEF3BD827F4C7_2042595052 = ("PackageInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "PackageInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + packageName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.116 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.117 -0400", hash_original_method = "F276E90711C385BB34A836DEED976429", hash_generated_method = "8F44199E8CE16676E10DE9DD2D17475D")
    @DSModeled(DSC.SAFE)
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

    
}


