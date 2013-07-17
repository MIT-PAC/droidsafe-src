package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class PackageInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.196 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.197 -0400", hash_original_field = "20583DCF173525A78F726EF45329C5AE", hash_generated_field = "633586CD38C7D215AD864A667A1C18CF")

    public int versionCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.197 -0400", hash_original_field = "5D1418B1E5EA6E10A5F930B3910C211F", hash_generated_field = "EEA0B1F7208882129090C0B1A92C4FA5")

    public String versionName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.197 -0400", hash_original_field = "ADCAD492D72B947B116C279DDD667454", hash_generated_field = "0CBF1AE1C1B1426C5A3D2E906A3CEC64")

    public String sharedUserId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.197 -0400", hash_original_field = "9BF180CF80D1AB84A1FA37F664553B08", hash_generated_field = "1595BEF827B40CD90B3BE963FC75F857")

    public int sharedUserLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.197 -0400", hash_original_field = "15CA13E1529EAD87820F354B3BC6598E", hash_generated_field = "89C41A1178051ADE4F3D6AE74553DD49")

    public ApplicationInfo applicationInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.198 -0400", hash_original_field = "C81F580630865800FD319A2F592F36B8", hash_generated_field = "601DDCA94CAB53CEB312AFBC9281DF25")

    public long firstInstallTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.198 -0400", hash_original_field = "34635AE52863B6F106A6490644A4C5BB", hash_generated_field = "A95446251D1AE4EA56EFB2C9A3F19811")

    public long lastUpdateTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.198 -0400", hash_original_field = "77DBC042260703938C8CA627F28C6CF5", hash_generated_field = "CDC95A780119BA6CC7281D85ECF39444")

    public int[] gids;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.198 -0400", hash_original_field = "609F88983635A66FE4C8570AFEE066E0", hash_generated_field = "85F14F08C0DB89FF167531F496781C32")

    public ActivityInfo[] activities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.199 -0400", hash_original_field = "32AB90C836B8DF619C5CACEBFA708C12", hash_generated_field = "D6C7C0B10B95B8BDD23A0F1924F17D0F")

    public ActivityInfo[] receivers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.199 -0400", hash_original_field = "10CD395CF71C18328C863C08E78F3FD0", hash_generated_field = "A417ECEA987B43A66995543781BA665E")

    public ServiceInfo[] services;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.199 -0400", hash_original_field = "29D247EE74C64366386D8D549C17162D", hash_generated_field = "BB68F1CB36FB4E56A847A41ADA363F02")

    public ProviderInfo[] providers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.199 -0400", hash_original_field = "226B63B3906F785BD9DD4A7BB1DF1058", hash_generated_field = "491996F0CD599ED57BD3668CA35444D0")

    public InstrumentationInfo[] instrumentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.199 -0400", hash_original_field = "41275A535677F79FF347E01BC530C176", hash_generated_field = "FCA9F76104FD8DA46F911F21118FD944")

    public PermissionInfo[] permissions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.199 -0400", hash_original_field = "7BBB786E9D112D8A5331DE4BCB27694B", hash_generated_field = "1F32520F4281E13C795915309EA3A039")

    public String[] requestedPermissions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.200 -0400", hash_original_field = "006FCD4EB57C9714AEDE6BB66938A9A6", hash_generated_field = "1FA2AB1E24E331CC0E00415466BB845A")

    public Signature[] signatures;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.200 -0400", hash_original_field = "852299C2C5D6B622069772F07BA6AF47", hash_generated_field = "CE81E6378F8C3BBDE69EF88410050EFA")

    public ConfigurationInfo[] configPreferences;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.200 -0400", hash_original_field = "F0FD8946CF5385B5AEBB1B8FCC882314", hash_generated_field = "66583495413918CB8F9A3F490928C154")

    public FeatureInfo[] reqFeatures;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.200 -0400", hash_original_field = "F9538D669E9DE35C017D94F04AB57979", hash_generated_field = "14BEDEA2ECA84B620D76427C9356D933")

    public int installLocation = INSTALL_LOCATION_INTERNAL_ONLY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.200 -0400", hash_original_method = "28FD03AD36E70CA65DC12DAEBF4BAB2B", hash_generated_method = "2F8FDFAA3E5302C1D2777402917BDB61")
    public  PackageInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.204 -0400", hash_original_method = "22E0C1407EA1D1C66AB0B4BE22F88AA5", hash_generated_method = "24E27603321263DEFB9ACAA2DE1B9D64")
    private  PackageInfo(Parcel source) {
        packageName = source.readString();
        versionCode = source.readInt();
        versionName = source.readString();
        sharedUserId = source.readString();
        sharedUserLabel = source.readInt();
        int hasApp = source.readInt();
        if(hasApp != 0)        
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.205 -0400", hash_original_method = "F32D243E2D05219891E68C55116B54A4", hash_generated_method = "447E8123FBD08FFF4A018CF82E5E0DF1")
    public String toString() {
String var9D4D38907310CF3324EC3BF27408EE69_58181118 =         "PackageInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}";
        var9D4D38907310CF3324EC3BF27408EE69_58181118.addTaint(taint);
        return var9D4D38907310CF3324EC3BF27408EE69_58181118;
        // ---------- Original Method ----------
        //return "PackageInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + packageName + "}";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.205 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4F6A9E1CCF36ED5062995607598B374B")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1995045637 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1680104800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1680104800;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.206 -0400", hash_original_method = "F276E90711C385BB34A836DEED976429", hash_generated_method = "7A486A0EA4ABCE82D358DC1E71E364C1")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        dest.writeString(packageName);
        dest.writeInt(versionCode);
        dest.writeString(versionName);
        dest.writeString(sharedUserId);
        dest.writeInt(sharedUserLabel);
        if(applicationInfo != null)        
        {
            dest.writeInt(1);
            applicationInfo.writeToParcel(dest, parcelableFlags);
        } //End block
        else
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.206 -0400", hash_original_field = "E3EB587080D668DBF15D55B4DBB91177", hash_generated_field = "0F203621F53B1B2EA90833CEFB6BEB3B")

    public static final int INSTALL_LOCATION_UNSPECIFIED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.206 -0400", hash_original_field = "DF89DE77581F5B465EE7D9D41DD90842", hash_generated_field = "4D087E37A6920CF65FE363AF46AD308E")

    public static final int INSTALL_LOCATION_AUTO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.206 -0400", hash_original_field = "3A0C1542C148EFBAB21CAF69754901E4", hash_generated_field = "D2E4BAC1DA989E17364F5ADFDEF83835")

    public static final int INSTALL_LOCATION_INTERNAL_ONLY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.206 -0400", hash_original_field = "BC75DFA5206E2B7AA30160AC97D3E543", hash_generated_field = "E18053DEAC495A89587A7E1EB40ABB53")

    public static final int INSTALL_LOCATION_PREFER_EXTERNAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.206 -0400", hash_original_field = "3676B37582820E634C5227E750D371BA", hash_generated_field = "6EBFD47FD18233A724DCD5D4272CB702")

    public static final Parcelable.Creator<PackageInfo> CREATOR
            = new Parcelable.Creator<PackageInfo>() {
        public PackageInfo createFromParcel(Parcel source) {
            return new PackageInfo(source);
        }

        public PackageInfo[] newArray(int size) {
            return new PackageInfo[size];
        }
    };
    // orphaned legacy method
    public PackageInfo createFromParcel(Parcel source) {
            return new PackageInfo(source);
        }
    
    // orphaned legacy method
    public PackageInfo[] newArray(int size) {
            return new PackageInfo[size];
        }
    
}

