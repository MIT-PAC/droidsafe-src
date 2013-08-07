package android.content.pm;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class InstrumentationInfo extends PackageItemInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.103 -0400", hash_original_field = "902CE642754F5EF10E3B0BAE67BA3A9F", hash_generated_field = "9C75B713060FA6BE08EF6725E9B4E7D0")

    public String targetPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.103 -0400", hash_original_field = "B9D3D046443CF690C6E6E502A0944706", hash_generated_field = "0B4DFCC25C52DF28B36617C8AC8E4427")

    public String sourceDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.103 -0400", hash_original_field = "406ED47D4AD3665513B29BD8BAD659ED", hash_generated_field = "72C784EC94EBBBC972EFE50E9D71D5EE")

    public String publicSourceDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.103 -0400", hash_original_field = "3453EE04AC0CD17C3918C22D09103B5B", hash_generated_field = "052BC408B8ED9FFD83EAA19D8E7278C2")

    public String dataDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.103 -0400", hash_original_field = "383F230A439138EADE87337855ED46BD", hash_generated_field = "0DA308DB0A30EC1E1D8EA3A5BBA153E4")

    public String nativeLibraryDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.103 -0400", hash_original_field = "72D8951C8FD220910B7EC81A591A4CB0", hash_generated_field = "C185AE02F38DA84178A242CF2731DD2E")

    public boolean handleProfiling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.103 -0400", hash_original_field = "AD5BE08F1C282DA1509B9F51A1940D11", hash_generated_field = "BB79529C955BCF773AA8708113671616")

    public boolean functionalTest;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.104 -0400", hash_original_method = "34F974A68EBB10BE10D867312E044FDF", hash_generated_method = "9D87916FE1B410C75B139D4D86872585")
    public  InstrumentationInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.104 -0400", hash_original_method = "33EE44CD2D02810ECD9B8B62FE0C07D7", hash_generated_method = "AFC7FE66768242E37E2CE00A88493C9A")
    public  InstrumentationInfo(InstrumentationInfo orig) {
        super(orig);
        targetPackage = orig.targetPackage;
        sourceDir = orig.sourceDir;
        publicSourceDir = orig.publicSourceDir;
        dataDir = orig.dataDir;
        nativeLibraryDir = orig.nativeLibraryDir;
        handleProfiling = orig.handleProfiling;
        functionalTest = orig.functionalTest;
        // ---------- Original Method ----------
        //targetPackage = orig.targetPackage;
        //sourceDir = orig.sourceDir;
        //publicSourceDir = orig.publicSourceDir;
        //dataDir = orig.dataDir;
        //nativeLibraryDir = orig.nativeLibraryDir;
        //handleProfiling = orig.handleProfiling;
        //functionalTest = orig.functionalTest;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.105 -0400", hash_original_method = "2F2A6843358187D56B8BE4AE48B0B4F7", hash_generated_method = "A988E544A6BD820A11207748418CB6BB")
    private  InstrumentationInfo(Parcel source) {
        super(source);
        targetPackage = source.readString();
        sourceDir = source.readString();
        publicSourceDir = source.readString();
        dataDir = source.readString();
        nativeLibraryDir = source.readString();
        handleProfiling = source.readInt() != 0;
        functionalTest = source.readInt() != 0;
        // ---------- Original Method ----------
        //targetPackage = source.readString();
        //sourceDir = source.readString();
        //publicSourceDir = source.readString();
        //dataDir = source.readString();
        //nativeLibraryDir = source.readString();
        //handleProfiling = source.readInt() != 0;
        //functionalTest = source.readInt() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.108 -0400", hash_original_method = "B5CF3592446C27C5B1615F6776EEEE26", hash_generated_method = "6062B8D92B97DBFC4E521AB1C946DD2B")
    public String toString() {
String var2ACCEFA985DAEFA3B14D26B03FD6229E_266521971 =         "InstrumentationInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}";
        var2ACCEFA985DAEFA3B14D26B03FD6229E_266521971.addTaint(taint);
        return var2ACCEFA985DAEFA3B14D26B03FD6229E_266521971;
        // ---------- Original Method ----------
        //return "InstrumentationInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + packageName + "}";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.108 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "980ABF6BD21F4CB773FABA7F61ED74E0")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_65481941 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779080483 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779080483;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.108 -0400", hash_original_method = "6CE0B2B52F0EF507C684C63B39230F74", hash_generated_method = "EC7AF82F38E8F242EB7B9FB4CC12A385")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(targetPackage);
        dest.writeString(sourceDir);
        dest.writeString(publicSourceDir);
        dest.writeString(dataDir);
        dest.writeString(nativeLibraryDir);
        dest.writeInt((handleProfiling == false) ? 0 : 1);
        dest.writeInt((functionalTest == false) ? 0 : 1);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //dest.writeString(targetPackage);
        //dest.writeString(sourceDir);
        //dest.writeString(publicSourceDir);
        //dest.writeString(dataDir);
        //dest.writeString(nativeLibraryDir);
        //dest.writeInt((handleProfiling == false) ? 0 : 1);
        //dest.writeInt((functionalTest == false) ? 0 : 1);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.109 -0400", hash_original_field = "BA8A63A897F5E025416B15F18812752C", hash_generated_field = "A55C73249AB0FB01F9CA1AED98F25E65")

    public static final Parcelable.Creator<InstrumentationInfo> CREATOR
            = new Parcelable.Creator<InstrumentationInfo>() {
        public InstrumentationInfo createFromParcel(Parcel source) {
            return new InstrumentationInfo(source);
        }
        public InstrumentationInfo[] newArray(int size) {
            return new InstrumentationInfo[size];
        }
    };
    // orphaned legacy method
    public InstrumentationInfo createFromParcel(Parcel source) {
            return new InstrumentationInfo(source);
        }
    
    // orphaned legacy method
    public InstrumentationInfo[] newArray(int size) {
            return new InstrumentationInfo[size];
        }
    
}

