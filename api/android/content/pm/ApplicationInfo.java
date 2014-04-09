package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.Collator;
import java.util.Comparator;

import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ApplicationInfo extends PackageItemInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.456 -0500", hash_original_field = "1C12CC5812F37AE9DD1D75B7D551FC1B", hash_generated_field = "561B89510C1340BB2679DFD17733782E")

    public static final int FLAG_SYSTEM = 1<<0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.458 -0500", hash_original_field = "A43BCF3937826449F060F8E85F3CE5F2", hash_generated_field = "EE54BF92D243C0288C8E9E957E104677")

    public static final int FLAG_DEBUGGABLE = 1<<1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.460 -0500", hash_original_field = "00FD34E175F98418EA1B670DE1524516", hash_generated_field = "BC40B8D55072FF40693BDC49545E6C18")

    public static final int FLAG_HAS_CODE = 1<<2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.463 -0500", hash_original_field = "79934051296144ABC17B261BC506F0B0", hash_generated_field = "FF21B6E642F6567E74B21AEF93B2043D")

    public static final int FLAG_PERSISTENT = 1<<3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.465 -0500", hash_original_field = "5CBD9A1AA2A69C23D0F0A89B76677246", hash_generated_field = "95980F82CE0AB24920417B16AB68F432")

    public static final int FLAG_FACTORY_TEST = 1<<4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.467 -0500", hash_original_field = "DF8850A80B12385E3C9B41027DC348A5", hash_generated_field = "D4B205D9EB2807DCF2F1D48F0470DF0B")

    public static final int FLAG_ALLOW_TASK_REPARENTING = 1<<5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.470 -0500", hash_original_field = "D13B66C075275191CF94CF9D2C725376", hash_generated_field = "31E61829EAC7EAAAB69D432AD97EDA1F")

    public static final int FLAG_ALLOW_CLEAR_USER_DATA = 1<<6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.472 -0500", hash_original_field = "6A4BB46CE05E01C00DEB8D04D75AD3C5", hash_generated_field = "49188CE3B61F6C625A08DDCCAA341AF5")

    public static final int FLAG_UPDATED_SYSTEM_APP = 1<<7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.475 -0500", hash_original_field = "267B4867900C31A44DF32E33E4EDCCB7", hash_generated_field = "0DE4AD43A482D068FDE133ECDB159AD3")

    public static final int FLAG_TEST_ONLY = 1<<8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.477 -0500", hash_original_field = "98F5E43546755D52BEF6AA2D5E053546", hash_generated_field = "3B5615EFFBCAD74CE7B993C4BFB06B16")

    public static final int FLAG_SUPPORTS_SMALL_SCREENS = 1<<9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.480 -0500", hash_original_field = "6961ABD67066D7F16CA51C81CA678F30", hash_generated_field = "1EE945F09F9FCD7239F78EFD55C9DC27")

    public static final int FLAG_SUPPORTS_NORMAL_SCREENS = 1<<10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.482 -0500", hash_original_field = "D3142A387D48A83B593792F13000D6A4", hash_generated_field = "0C511A79CF791047910BD5D9DC913AEC")

    public static final int FLAG_SUPPORTS_LARGE_SCREENS = 1<<11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.484 -0500", hash_original_field = "5C856E575D0ED285F7B6A23F062A3F29", hash_generated_field = "CC61FBA4D931769E282B43D310D29B45")

    public static final int FLAG_RESIZEABLE_FOR_SCREENS = 1<<12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.487 -0500", hash_original_field = "C20C38436FCF0D5E4277EB46F73C0938", hash_generated_field = "6B4CC4FED7D79FD3FD7554999709E4E8")

    public static final int FLAG_SUPPORTS_SCREEN_DENSITIES = 1<<13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.489 -0500", hash_original_field = "3965D073534748176020223063C577EA", hash_generated_field = "432528B929508471FBF64EB051199C99")

    public static final int FLAG_VM_SAFE_MODE = 1<<14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.491 -0500", hash_original_field = "5B41F3A3341476825D31A00370A0E3AB", hash_generated_field = "73DED9E8FD1D91D05214FCC2A4C48FF6")

    public static final int FLAG_ALLOW_BACKUP = 1<<15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.494 -0500", hash_original_field = "29B149AC905D580BA8C64F58C767E47B", hash_generated_field = "6546037CBD2A9570306DAE14154B2128")

    public static final int FLAG_KILL_AFTER_RESTORE = 1<<16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.497 -0500", hash_original_field = "1381BE110A72CC66B0F99C47D15F4775", hash_generated_field = "CC4E7B20CE2E0DEEA70F56BA4A71271F")

    public static final int FLAG_RESTORE_ANY_VERSION = 1<<17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.499 -0500", hash_original_field = "0D09ABBB0B12A0545570B827AA18C4D7", hash_generated_field = "39130497A3475AB9A20D6FEBBA9B17D7")

    public static final int FLAG_EXTERNAL_STORAGE = 1<<18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.501 -0500", hash_original_field = "BE6502D4739612DDA3AD7073C70C86E2", hash_generated_field = "D4C9FE84AF96EFE53263803181F07688")

    public static final int FLAG_SUPPORTS_XLARGE_SCREENS = 1<<19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.504 -0500", hash_original_field = "C37CDD102E76B078BE2DDE3A7AF0137C", hash_generated_field = "09F14C138A9D31BF1F310241B027CC07")

    public static final int FLAG_LARGE_HEAP = 1<<20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.506 -0500", hash_original_field = "269CFD4A966551488535B2AD9906766A", hash_generated_field = "7FEF6F66294ECCDB2E301D891A63D4C8")

    public static final int FLAG_STOPPED = 1<<21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.509 -0500", hash_original_field = "01DEEFA0C555C36975DEDB3A1536EF4E", hash_generated_field = "025A9F3C74125C95135DC8E8E224561D")

    public static final int FLAG_FORWARD_LOCK = 1<<29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.513 -0500", hash_original_field = "15864ED133B6E9B00F15608F3AD2E93B", hash_generated_field = "EA2624B5DD97ED42F552E6C89FF62141")

    public static final int FLAG_CANT_SAVE_STATE = 1<<28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.325 -0400", hash_original_field = "27679CB9E03B26BB40EA68FDAAA78442", hash_generated_field = "568E85AC1E6B72D14B17D5DBAD6478F9")

    public static final Parcelable.Creator<ApplicationInfo> CREATOR
            = new Parcelable.Creator<ApplicationInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.576 -0500", hash_original_method = "003CCA274078E72A658F6344F93CD336", hash_generated_method = "3C762487FC20080045E5B7AEE44AC9FA")
        
public ApplicationInfo createFromParcel(Parcel source) {
            return new ApplicationInfo(source);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.579 -0500", hash_original_method = "0FDCEA825DAB3FB1D09759A4F0D45766", hash_generated_method = "82D927860F8207E5554F1E3F6A006335")
        
public ApplicationInfo[] newArray(int size) {
            return new ApplicationInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.436 -0500", hash_original_field = "1496746C771ADF266B3C98437087C3C9", hash_generated_field = "7AA799578052361E8AB8F2E0B535D75E")

    public String taskAffinity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.439 -0500", hash_original_field = "6CAD99B186075AF38B34666A3804B23C", hash_generated_field = "3670CE1CBA400C10EB64B3D7DD616511")

    public String permission;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.441 -0500", hash_original_field = "182AC29DC74CEB0C6C89C5576E47A4DD", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

    public String processName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.443 -0500", hash_original_field = "CA6BE7A479C5F3E68F3687DBA3A4A48F", hash_generated_field = "868D31C10A710A0DF272DC0EA267B5A9")

    public String className;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.445 -0500", hash_original_field = "1C23F3ABB5154D4340D3FAF2DBF4B754", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.447 -0500", hash_original_field = "45D39EA345E2D2EE1A81DB875640D024", hash_generated_field = "A97FD2465AC4AAA472175729CDE0BBF3")

    public int theme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.449 -0500", hash_original_field = "C89ED4A6A525D1BE3F7674B7530AEFF6", hash_generated_field = "A18919A2EB4F93BEDB25A3DD4CCA0724")

    public String manageSpaceActivityName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.451 -0500", hash_original_field = "D272B8EB3163B9550EC60DAA005B1E8D", hash_generated_field = "95E392B1DD2EC5417AE8D3DAF0F6037B")

    public String backupAgentName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.453 -0500", hash_original_field = "847777BDD2DCF34920040D6850615B57", hash_generated_field = "9FF841B59BE996A97456D758065D4280")

    public int uiOptions = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.515 -0500", hash_original_field = "FF9ED529AE279887A3BA77124643D233", hash_generated_field = "7F748806FE2A7B689528B11446BBCFAD")

    public int flags = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.517 -0500", hash_original_field = "342A355A4D1542CCE1007DED042033A3", hash_generated_field = "04E16A94C9ACEC761C099F572C9ACA2E")

    public int requiresSmallestWidthDp = 0;
    
    public static class DisplayNameComparator implements Comparator<ApplicationInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.557 -0500", hash_original_field = "EE5E44F3B728B272AD02D50E8F128A4E", hash_generated_field = "0F522A2F9FEC0AE6C7C0EFB2E65868E6")

        private final Collator   sCollator = Collator.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.559 -0500", hash_original_field = "D7E1102720CC9E76648EB86B25CA5216", hash_generated_field = "B9590FAB3CF140F08C9CD4E0309ED58A")

        private PackageManager   mPM;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.552 -0500", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "93A18F8F07DA31EBC88951995E1C514A")
        
public DisplayNameComparator(PackageManager pm) {
            mPM = pm;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.555 -0500", hash_original_method = "C6664C7947CB4F50D04FE5C6FED7BB23", hash_generated_method = "DC052F221A6D5BA2E3ED923354036FA6")
        
public final int compare(ApplicationInfo aa, ApplicationInfo ab) {
            CharSequence  sa = mPM.getApplicationLabel(aa);
            if (sa == null) {
                sa = aa.packageName;
            }
            CharSequence  sb = mPM.getApplicationLabel(ab);
            if (sb == null) {
                sb = ab.packageName;
            }
            
            return sCollator.compare(sa.toString(), sb.toString());
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.519 -0500", hash_original_field = "6C3409B065DC3A460DA44F1C646826DF", hash_generated_field = "414C12C8D4EBC7FEA48FF4F1F93E9547")

    public int compatibleWidthLimitDp = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.521 -0500", hash_original_field = "D181E0A38752FD75D85C873CE5507619", hash_generated_field = "15494D973706418EC9343241E1FDE6C9")

    public int largestWidthLimitDp = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.523 -0500", hash_original_field = "A8389DF99A9675FDA1974874284E7B15", hash_generated_field = "0B4DFCC25C52DF28B36617C8AC8E4427")

    public String sourceDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.526 -0500", hash_original_field = "8945F799C01F09B53280EFF9A71F39C5", hash_generated_field = "72C784EC94EBBBC972EFE50E9D71D5EE")

    public String publicSourceDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.528 -0500", hash_original_field = "413B9A3D703A85725D88E4B22D727179", hash_generated_field = "BA274A50421E44C83C7038CCC679B3EE")

    public String[] resourceDirs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.530 -0500", hash_original_field = "328C737DDF922E778823822E8FEFA15F", hash_generated_field = "0423742747407F89ED1EF5B1BA503E1D")

    public String[] sharedLibraryFiles;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.532 -0500", hash_original_field = "7F6CF3A9271EE00B41A116BE001193FA", hash_generated_field = "052BC408B8ED9FFD83EAA19D8E7278C2")

    public String dataDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.534 -0500", hash_original_field = "C996DE29DA44618ECCF72C2550AC8EF8", hash_generated_field = "0DA308DB0A30EC1E1D8EA3A5BBA153E4")

    public String nativeLibraryDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.536 -0500", hash_original_field = "12FA9B6FF5DE3157A8BC781F3445534B", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

    public int uid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.539 -0500", hash_original_field = "6C1842C610E85CE5AAB422B21DE084EE", hash_generated_field = "DE276FFFF96E9BBB61DBAEEE723C24D9")

    public int targetSdkVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.541 -0500", hash_original_field = "F820890665F7FBF0C08C507B72EF4704", hash_generated_field = "1F483398D0B87CDABAB06F6BA44B73E7")

    public boolean enabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.543 -0500", hash_original_field = "FA5ADEA939428D7E0F6770BC5299379C", hash_generated_field = "2410A7C33D4ACBCBBA9190581ADA4DAA")

    public int enabledSetting = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.545 -0500", hash_original_field = "B6CB937DAA58FAE13222917ADE62AE39", hash_generated_field = "2333742CA8D6B082D8F24AF42F03F0F2")

    public int installLocation = PackageInfo.INSTALL_LOCATION_UNSPECIFIED;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.563 -0500", hash_original_method = "5A2EFBCC396F3478953F6D70829229DF", hash_generated_method = "AA119110F11F1B5175C63CF83D4EA78E")
    
public ApplicationInfo() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.566 -0500", hash_original_method = "69807CD533357E6E6EA42F47263369C0", hash_generated_method = "46E4442D0521954BD7D5050DF16D0B82")
    
public ApplicationInfo(ApplicationInfo orig) {
        super(orig);
        taskAffinity = orig.taskAffinity;
        permission = orig.permission;
        processName = orig.processName;
        className = orig.className;
        theme = orig.theme;
        flags = orig.flags;
        requiresSmallestWidthDp = orig.requiresSmallestWidthDp;
        compatibleWidthLimitDp = orig.compatibleWidthLimitDp;
        largestWidthLimitDp = orig.largestWidthLimitDp;
        sourceDir = orig.sourceDir;
        publicSourceDir = orig.publicSourceDir;
        nativeLibraryDir = orig.nativeLibraryDir;
        resourceDirs = orig.resourceDirs;
        sharedLibraryFiles = orig.sharedLibraryFiles;
        dataDir = orig.dataDir;
        uid = orig.uid;
        targetSdkVersion = orig.targetSdkVersion;
        enabled = orig.enabled;
        enabledSetting = orig.enabledSetting;
        installLocation = orig.installLocation;
        manageSpaceActivityName = orig.manageSpaceActivityName;
        descriptionRes = orig.descriptionRes;
        uiOptions = orig.uiOptions;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.585 -0500", hash_original_method = "C34B9C3D6C69EB97D4130A1E4D235BF1", hash_generated_method = "CB49085873BDD4D3068D6247FD14417E")
    
private ApplicationInfo(Parcel source) {
        super(source);
        taskAffinity = source.readString();
        permission = source.readString();
        processName = source.readString();
        className = source.readString();
        theme = source.readInt();
        flags = source.readInt();
        requiresSmallestWidthDp = source.readInt();
        compatibleWidthLimitDp = source.readInt();
        largestWidthLimitDp = source.readInt();
        sourceDir = source.readString();
        publicSourceDir = source.readString();
        nativeLibraryDir = source.readString();
        resourceDirs = source.readStringArray();
        sharedLibraryFiles = source.readStringArray();
        dataDir = source.readString();
        uid = source.readInt();
        targetSdkVersion = source.readInt();
        enabled = source.readInt() != 0;
        enabledSetting = source.readInt();
        installLocation = source.readInt();
        manageSpaceActivityName = source.readString();
        backupAgentName = source.readString();
        descriptionRes = source.readInt();
        uiOptions = source.readInt();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.548 -0500", hash_original_method = "7729FD0B554CDA849A4BAB68A5483EB9", hash_generated_method = "52336D759D5C914B52234733CC0B0C45")
    
public void dump(Printer pw, String prefix) {
        super.dumpFront(pw, prefix);
        if (className != null) {
            pw.println(prefix + "className=" + className);
        }
        if (permission != null) {
            pw.println(prefix + "permission=" + permission);
        }
        pw.println(prefix + "processName=" + processName);
        pw.println(prefix + "taskAffinity=" + taskAffinity);
        pw.println(prefix + "uid=" + uid + " flags=0x" + Integer.toHexString(flags)
                + " theme=0x" + Integer.toHexString(theme));
        pw.println(prefix + "requiresSmallestWidthDp=" + requiresSmallestWidthDp
                + " compatibleWidthLimitDp=" + compatibleWidthLimitDp
                + " largestWidthLimitDp=" + largestWidthLimitDp);
        pw.println(prefix + "sourceDir=" + sourceDir);
        if (sourceDir == null) {
            if (publicSourceDir != null) {
                pw.println(prefix + "publicSourceDir=" + publicSourceDir);
            }
        } else if (!sourceDir.equals(publicSourceDir)) {
            pw.println(prefix + "publicSourceDir=" + publicSourceDir);
        }
        if (resourceDirs != null) {
            pw.println(prefix + "resourceDirs=" + resourceDirs);
        }
        pw.println(prefix + "dataDir=" + dataDir);
        if (sharedLibraryFiles != null) {
            pw.println(prefix + "sharedLibraryFiles=" + sharedLibraryFiles);
        }
        pw.println(prefix + "enabled=" + enabled + " targetSdkVersion=" + targetSdkVersion);
        if (manageSpaceActivityName != null) {
            pw.println(prefix + "manageSpaceActivityName="+manageSpaceActivityName);
        }
        if (descriptionRes != 0) {
            pw.println(prefix + "description=0x"+Integer.toHexString(descriptionRes));
        }
        if (uiOptions != 0) {
            pw.println(prefix + "uiOptions=0x" + Integer.toHexString(uiOptions));
        }
        super.dumpBack(pw, prefix);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.568 -0500", hash_original_method = "D921E47CA861D6D48D77FD8F7E62A49D", hash_generated_method = "C53B78FE209B276ED2DA690C8798F7FA")
    
public String toString() {
        return "ApplicationInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.570 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.573 -0500", hash_original_method = "49D8EFBAED7609827DD9A53B007B084F", hash_generated_method = "8F8C492A119A988ADD1E603678C7B1CB")
    
public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(taskAffinity);
        dest.writeString(permission);
        dest.writeString(processName);
        dest.writeString(className);
        dest.writeInt(theme);
        dest.writeInt(flags);
        dest.writeInt(requiresSmallestWidthDp);
        dest.writeInt(compatibleWidthLimitDp);
        dest.writeInt(largestWidthLimitDp);
        dest.writeString(sourceDir);
        dest.writeString(publicSourceDir);
        dest.writeString(nativeLibraryDir);
        dest.writeStringArray(resourceDirs);
        dest.writeStringArray(sharedLibraryFiles);
        dest.writeString(dataDir);
        dest.writeInt(uid);
        dest.writeInt(targetSdkVersion);
        dest.writeInt(enabled ? 1 : 0);
        dest.writeInt(enabledSetting);
        dest.writeInt(installLocation);
        dest.writeString(manageSpaceActivityName);
        dest.writeString(backupAgentName);
        dest.writeInt(descriptionRes);
        dest.writeInt(uiOptions);
    }

    /**
     * Retrieve the textual description of the application.  This
     * will call back on the given PackageManager to load the description from
     * the application.
     *
     * @param pm A PackageManager from which the label can be loaded; usually
     * the PackageManager from which you originally retrieved this item.
     *
     * @return Returns a CharSequence containing the application's description.
     * If there is no description, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.587 -0500", hash_original_method = "91D0630D593C0E5EFA5BB0A713D23C43", hash_generated_method = "C03ECE1CEE103510DDBEBF92F73191AD")
    
public CharSequence loadDescription(PackageManager pm) {
        if (descriptionRes != 0) {
            CharSequence label = pm.getText(packageName, descriptionRes, this);
            if (label != null) {
                return label;
            }
        }
        return null;
    }

    /**
     * Disable compatibility mode
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.589 -0500", hash_original_method = "110E01A7854D6A7CF0C047806FCA3437", hash_generated_method = "F6E9C644430F59BB04DB8C2BD0F0560C")
    
public void disableCompatibilityMode() {
        flags |= (FLAG_SUPPORTS_LARGE_SCREENS | FLAG_SUPPORTS_NORMAL_SCREENS |
                FLAG_SUPPORTS_SMALL_SCREENS | FLAG_RESIZEABLE_FOR_SCREENS |
                FLAG_SUPPORTS_SCREEN_DENSITIES | FLAG_SUPPORTS_XLARGE_SCREENS);
    }
    
    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.592 -0500", hash_original_method = "ED007A8BD44C2C8CDC7AE52AC1ADD2C8", hash_generated_method = "A0B4CD7A51C40B055E10A8F2385B7A21")
    
@Override protected Drawable loadDefaultIcon(PackageManager pm) {
        if ((flags & FLAG_EXTERNAL_STORAGE) != 0
                && isPackageUnavailable(pm)) {
            return Resources.getSystem().getDrawable(
                    com.android.internal.R.drawable.sym_app_on_sd_unavailable_icon);
        }
        return pm.getDefaultActivityIcon();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.594 -0500", hash_original_method = "B87914FC2F221448B9EDC9CCD205939A", hash_generated_method = "6EC09BA6BCF8464DA9AF02492ED90BEF")
    
private boolean isPackageUnavailable(PackageManager pm) {
        try {
            return pm.getPackageInfo(packageName, 0).getTaintBoolean();
        } catch (NameNotFoundException ex) {
            return true;
        }
    }
    
    /**
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:59.596 -0500", hash_original_method = "4CB14D4C822DE3694FE375457E968E4C", hash_generated_method = "4E111D174133403CA93D9B272F2965D8")
    
@Override protected ApplicationInfo getApplicationInfo() {
        return this;
    }
    // orphaned legacy method
    public ApplicationInfo createFromParcel(Parcel source) {
            return new ApplicationInfo(source);
        }
    
    // orphaned legacy method
    public ApplicationInfo[] newArray(int size) {
            return new ApplicationInfo[size];
        }
    
}

