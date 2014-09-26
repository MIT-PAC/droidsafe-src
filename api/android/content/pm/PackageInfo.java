package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class PackageInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.763 -0500", hash_original_field = "161FDE75E013CEBD9EA008B9E9176008", hash_generated_field = "0F203621F53B1B2EA90833CEFB6BEB3B")

    public static final int INSTALL_LOCATION_UNSPECIFIED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.765 -0500", hash_original_field = "68192AAEDA08DDEB8F003FA564938DB3", hash_generated_field = "4D087E37A6920CF65FE363AF46AD308E")

    public static final int INSTALL_LOCATION_AUTO = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.767 -0500", hash_original_field = "81C6FDE749357FF13010C98546460EA6", hash_generated_field = "D2E4BAC1DA989E17364F5ADFDEF83835")

    public static final int INSTALL_LOCATION_INTERNAL_ONLY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.770 -0500", hash_original_field = "5958F702CE9F1967ECAAE1434C202027", hash_generated_field = "E18053DEAC495A89587A7E1EB40ABB53")

    public static final int INSTALL_LOCATION_PREFER_EXTERNAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.206 -0400", hash_original_field = "3676B37582820E634C5227E750D371BA", hash_generated_field = "6EBFD47FD18233A724DCD5D4272CB702")

    public static final Parcelable.Creator<PackageInfo> CREATOR
            = new Parcelable.Creator<PackageInfo>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.785 -0500", hash_original_method = "786D77E8B5ED4A451D329DFF278050D7", hash_generated_method = "1AFC4410E5D3886AD2895E03A805C344")
        
public PackageInfo createFromParcel(Parcel source) {
            return new PackageInfo(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.787 -0500", hash_original_method = "F6ABA3CA6C3536F47C5E2AFE49063321", hash_generated_method = "10108D768367744D018765B838D2FF34")
        
public PackageInfo[] newArray(int size) {
            return new PackageInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.722 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.724 -0500", hash_original_field = "708674EE83B3902AD54087084C765D12", hash_generated_field = "633586CD38C7D215AD864A667A1C18CF")

    public int versionCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.726 -0500", hash_original_field = "9175B9FC553484970738C58868380292", hash_generated_field = "EEA0B1F7208882129090C0B1A92C4FA5")

    public String versionName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.728 -0500", hash_original_field = "6648CBA69F40DB7977B58FC3E3F69993", hash_generated_field = "0CBF1AE1C1B1426C5A3D2E906A3CEC64")

    public String sharedUserId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.730 -0500", hash_original_field = "BF59D6D0F58CB79F6D76E4B8B43ACC3D", hash_generated_field = "1595BEF827B40CD90B3BE963FC75F857")

    public int sharedUserLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.733 -0500", hash_original_field = "E1F5069A4C4BF89A2D890A883EC45793", hash_generated_field = "89C41A1178051ADE4F3D6AE74553DD49")

    public ApplicationInfo applicationInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.735 -0500", hash_original_field = "6B6567FE414D5D1FE5C88FFE702EEEDB", hash_generated_field = "601DDCA94CAB53CEB312AFBC9281DF25")

    public long firstInstallTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.737 -0500", hash_original_field = "357B404F32323702F25D563FFF0505BF", hash_generated_field = "A95446251D1AE4EA56EFB2C9A3F19811")

    public long lastUpdateTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.740 -0500", hash_original_field = "54C577A65DD30DDDFB9215D4CF28DB70", hash_generated_field = "CDC95A780119BA6CC7281D85ECF39444")

    public int[] gids;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.742 -0500", hash_original_field = "99A71B20149E52F34AED96141E6ED472", hash_generated_field = "85F14F08C0DB89FF167531F496781C32")

    public ActivityInfo[] activities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.744 -0500", hash_original_field = "89CD9B4B25A657075F1CE0E6122487A9", hash_generated_field = "D6C7C0B10B95B8BDD23A0F1924F17D0F")

    public ActivityInfo[] receivers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.746 -0500", hash_original_field = "FDC320EE089858AA3FE60F4480217DCF", hash_generated_field = "A417ECEA987B43A66995543781BA665E")

    public ServiceInfo[] services;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.748 -0500", hash_original_field = "03E7E51F2D53AA7312F5A5A182713002", hash_generated_field = "BB68F1CB36FB4E56A847A41ADA363F02")

    public ProviderInfo[] providers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.750 -0500", hash_original_field = "F1F8E1D1E3062E21E35DA85C155B85CA", hash_generated_field = "491996F0CD599ED57BD3668CA35444D0")

    public InstrumentationInfo[] instrumentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.752 -0500", hash_original_field = "15865F4017A239DA5CAD24729E5513DC", hash_generated_field = "FCA9F76104FD8DA46F911F21118FD944")

    public PermissionInfo[] permissions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.754 -0500", hash_original_field = "C28885D6653D1CBA0D52F39AD25348D7", hash_generated_field = "1F32520F4281E13C795915309EA3A039")

    public String[] requestedPermissions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.756 -0500", hash_original_field = "DDB734CE9CBF98955891FE32F24FA88A", hash_generated_field = "1FA2AB1E24E331CC0E00415466BB845A")

    public Signature[] signatures;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.758 -0500", hash_original_field = "73A5F96511E7D8C7AA6A9419C7937A42", hash_generated_field = "CE81E6378F8C3BBDE69EF88410050EFA")

    public ConfigurationInfo[] configPreferences;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.760 -0500", hash_original_field = "EAA403CDF749FA5209369299A59D862D", hash_generated_field = "66583495413918CB8F9A3F490928C154")

    public FeatureInfo[] reqFeatures;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.772 -0500", hash_original_field = "9E724E821C2727008D23FE4B4C13CEB9", hash_generated_field = "14BEDEA2ECA84B620D76427C9356D933")

    public int installLocation = INSTALL_LOCATION_INTERNAL_ONLY;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.774 -0500", hash_original_method = "28FD03AD36E70CA65DC12DAEBF4BAB2B", hash_generated_method = "C51A23F157275D7AF9F27C62F2349ED2")
    
public PackageInfo() {
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.793 -0500", hash_original_method = "22E0C1407EA1D1C66AB0B4BE22F88AA5", hash_generated_method = "14944209C7BBB4C708E44F4A3B4CBA12")
    
private PackageInfo(Parcel source) {
        packageName = source.readString();
        versionCode = source.readInt();
        versionName = source.readString();
        sharedUserId = source.readString();
        sharedUserLabel = source.readInt();
        int hasApp = source.readInt();
        if (hasApp != 0) {
            applicationInfo = ApplicationInfo.CREATOR.createFromParcel(source);
        }
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
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.776 -0500", hash_original_method = "F32D243E2D05219891E68C55116B54A4", hash_generated_method = "34DA449058A22C7CC9DE3A01D3016779")
    
public String toString() {
        return "PackageInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.778 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.782 -0500", hash_original_method = "F276E90711C385BB34A836DEED976429", hash_generated_method = "BDF5CD297C710E4FFFF333A3F9B79189")
    
public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeString(packageName);
        dest.writeInt(versionCode);
        dest.writeString(versionName);
        dest.writeString(sharedUserId);
        dest.writeInt(sharedUserLabel);
        if (applicationInfo != null) {
            dest.writeInt(1);
            applicationInfo.writeToParcel(dest, parcelableFlags);
        } else {
            dest.writeInt(0);
        }
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
    }
    // orphaned legacy method
    public PackageInfo createFromParcel(Parcel source) {
            return new PackageInfo(source);
        }
    
    // orphaned legacy method
    public PackageInfo[] newArray(int size) {
            return new PackageInfo[size];
        }
    
}

