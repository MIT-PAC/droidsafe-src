package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;
import java.text.Collator;
import java.util.Comparator;

public class ApplicationInfo extends PackageItemInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.025 -0400", hash_original_field = "076F9A985964BB9FD17F8637C357D2C5", hash_generated_field = "7AA799578052361E8AB8F2E0B535D75E")

    public String taskAffinity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "4B65CA0F8B76E7181A12BF1FABC48532", hash_generated_field = "3670CE1CBA400C10EB64B3D7DD616511")

    public String permission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

    public String processName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "868D31C10A710A0DF272DC0EA267B5A9")

    public String className;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "392A6E47A749448B7E51283719BBB183", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "F484570D7CF557020E11ACE406901B10", hash_generated_field = "A97FD2465AC4AAA472175729CDE0BBF3")

    public int theme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "22F6A05885EB816DB79C0D6423640130", hash_generated_field = "A18919A2EB4F93BEDB25A3DD4CCA0724")

    public String manageSpaceActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "6F4A4CAA4205BB5168B9F50D98ED27C3", hash_generated_field = "95E392B1DD2EC5417AE8D3DAF0F6037B")

    public String backupAgentName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "BC63366481A204D80153970F9D4FBA5D", hash_generated_field = "9FF841B59BE996A97456D758065D4280")

    public int uiOptions = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "A2DE4DC9BF3F5C77CEAC5EB31F506512", hash_generated_field = "7F748806FE2A7B689528B11446BBCFAD")

    public int flags = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "13A562157DF0AD3C6B6A642A26B92CBF", hash_generated_field = "04E16A94C9ACEC761C099F572C9ACA2E")

    public int requiresSmallestWidthDp = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "F2C6A1F0A9917D25914461A6D605F0FE", hash_generated_field = "414C12C8D4EBC7FEA48FF4F1F93E9547")

    public int compatibleWidthLimitDp = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "D7DCFFDF8CE7FD495E7AFEB99A06EBE8", hash_generated_field = "15494D973706418EC9343241E1FDE6C9")

    public int largestWidthLimitDp = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "B9D3D046443CF690C6E6E502A0944706", hash_generated_field = "0B4DFCC25C52DF28B36617C8AC8E4427")

    public String sourceDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "406ED47D4AD3665513B29BD8BAD659ED", hash_generated_field = "72C784EC94EBBBC972EFE50E9D71D5EE")

    public String publicSourceDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "9E07682390D7C6EAF76CF0B83CA9F83A", hash_generated_field = "BA274A50421E44C83C7038CCC679B3EE")

    public String[] resourceDirs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "5D25393DA78288E091E8ADBBE496AE71", hash_generated_field = "0423742747407F89ED1EF5B1BA503E1D")

    public String[] sharedLibraryFiles;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "3453EE04AC0CD17C3918C22D09103B5B", hash_generated_field = "052BC408B8ED9FFD83EAA19D8E7278C2")

    public String dataDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.026 -0400", hash_original_field = "383F230A439138EADE87337855ED46BD", hash_generated_field = "0DA308DB0A30EC1E1D8EA3A5BBA153E4")

    public String nativeLibraryDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.027 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

    public int uid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.027 -0400", hash_original_field = "6099B90F1E5E8B48541E9B6E6B9E7C89", hash_generated_field = "DE276FFFF96E9BBB61DBAEEE723C24D9")

    public int targetSdkVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.027 -0400", hash_original_field = "34CF7D88530CECE9FD068A5118796419", hash_generated_field = "1F483398D0B87CDABAB06F6BA44B73E7")

    public boolean enabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.027 -0400", hash_original_field = "F4B9552957D9DAE2E68686A30ECBAA6E", hash_generated_field = "2410A7C33D4ACBCBBA9190581ADA4DAA")

    public int enabledSetting = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.027 -0400", hash_original_field = "27512C516B6F0C86F45B9BE2D8C62FA3", hash_generated_field = "2333742CA8D6B082D8F24AF42F03F0F2")

    public int installLocation = PackageInfo.INSTALL_LOCATION_UNSPECIFIED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.027 -0400", hash_original_method = "5A2EFBCC396F3478953F6D70829229DF", hash_generated_method = "1C6DF293A3C6120BEE22B701113A526F")
    public  ApplicationInfo() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.028 -0400", hash_original_method = "69807CD533357E6E6EA42F47263369C0", hash_generated_method = "BCC4B11EB196481D0369739814A0B547")
    public  ApplicationInfo(ApplicationInfo orig) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.029 -0400", hash_original_method = "C34B9C3D6C69EB97D4130A1E4D235BF1", hash_generated_method = "F179328CBBE4B5CAEB27A180DC76F14A")
    private  ApplicationInfo(Parcel source) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.031 -0400", hash_original_method = "7729FD0B554CDA849A4BAB68A5483EB9", hash_generated_method = "DFD1713A32A22D84DBE2DAC40FA5D44C")
    public void dump(Printer pw, String prefix) {
        super.dumpFront(pw, prefix);
        {
            pw.println(prefix + "className=" + className);
        } 
        {
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
        {
            {
                pw.println(prefix + "publicSourceDir=" + publicSourceDir);
            } 
        } 
        {
            boolean varA39FE0691770EDFA5F3A53BAF72DCA47_1995935493 = (!sourceDir.equals(publicSourceDir));
            {
                pw.println(prefix + "publicSourceDir=" + publicSourceDir);
            } 
        } 
        {
            pw.println(prefix + "resourceDirs=" + resourceDirs);
        } 
        pw.println(prefix + "dataDir=" + dataDir);
        {
            pw.println(prefix + "sharedLibraryFiles=" + sharedLibraryFiles);
        } 
        pw.println(prefix + "enabled=" + enabled + " targetSdkVersion=" + targetSdkVersion);
        {
            pw.println(prefix + "manageSpaceActivityName="+manageSpaceActivityName);
        } 
        {
            pw.println(prefix + "description=0x"+Integer.toHexString(descriptionRes));
        } 
        {
            pw.println(prefix + "uiOptions=0x" + Integer.toHexString(uiOptions));
        } 
        super.dumpBack(pw, prefix);
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.031 -0400", hash_original_method = "D921E47CA861D6D48D77FD8F7E62A49D", hash_generated_method = "E0A5D1BE4C1DEF5A95E89144073D75A5")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1173495920 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1173495920 = "ApplicationInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1173495920.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1173495920;
        
        
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.032 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "52C4727BC1249B5A858450DC32C06349")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222543023 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222543023;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.032 -0400", hash_original_method = "49D8EFBAED7609827DD9A53B007B084F", hash_generated_method = "EEDB4DFAF4BFE909E9A17CDF429FF481")
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
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.033 -0400", hash_original_method = "91D0630D593C0E5EFA5BB0A713D23C43", hash_generated_method = "1840FC54C260A413B6B8147EE8F12A64")
    public CharSequence loadDescription(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_318759780 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1349553499 = null; 
        {
            CharSequence label = pm.getText(packageName, descriptionRes, this);
            {
                varB4EAC82CA7396A68D541C85D26508E83_318759780 = label;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1349553499 = null;
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1445299619; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1445299619 = varB4EAC82CA7396A68D541C85D26508E83_318759780;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1445299619 = varB4EAC82CA7396A68D541C85D26508E83_1349553499;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1445299619.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1445299619;
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.034 -0400", hash_original_method = "110E01A7854D6A7CF0C047806FCA3437", hash_generated_method = "4260BDBF7ADA9DD58BFC26F5C7BE7B86")
    public void disableCompatibilityMode() {
        flags |= (FLAG_SUPPORTS_LARGE_SCREENS | FLAG_SUPPORTS_NORMAL_SCREENS |
                FLAG_SUPPORTS_SMALL_SCREENS | FLAG_RESIZEABLE_FOR_SCREENS |
                FLAG_SUPPORTS_SCREEN_DENSITIES | FLAG_SUPPORTS_XLARGE_SCREENS);
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.034 -0400", hash_original_method = "ED007A8BD44C2C8CDC7AE52AC1ADD2C8", hash_generated_method = "CF726BE4778AAFAB4DC395EA366B3406")
    @Override
    protected Drawable loadDefaultIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1965995407 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1823957055 = null; 
        {
            boolean var13DA2665C8125DDFC7DD4BE22BB98026_1334275947 = ((flags & FLAG_EXTERNAL_STORAGE) != 0
                && isPackageUnavailable(pm));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1965995407 = Resources.getSystem().getDrawable(
                    com.android.internal.R.drawable.sym_app_on_sd_unavailable_icon);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1823957055 = pm.getDefaultActivityIcon();
        addTaint(pm.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_600421369; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_600421369 = varB4EAC82CA7396A68D541C85D26508E83_1965995407;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_600421369 = varB4EAC82CA7396A68D541C85D26508E83_1823957055;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_600421369.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_600421369;
        
        
                
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.035 -0400", hash_original_method = "B87914FC2F221448B9EDC9CCD205939A", hash_generated_method = "3E95C40D7950B49700C19D513BCBE4E9")
    private boolean isPackageUnavailable(PackageManager pm) {
        try 
        {
            boolean varFBE29452BA58067126DA01DC2AF37A99_1533056949 = (pm.getPackageInfo(packageName, 0) == null);
        } 
        catch (NameNotFoundException ex)
        { }
        addTaint(pm.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1079495921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1079495921;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.036 -0400", hash_original_method = "4CB14D4C822DE3694FE375457E968E4C", hash_generated_method = "DF7239491F3F41C6C0EEAA612D23020A")
    @Override
    protected ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_317503253 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_317503253 = this;
        varB4EAC82CA7396A68D541C85D26508E83_317503253.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_317503253;
        
        
    }

    
    public static class DisplayNameComparator implements Comparator<ApplicationInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.036 -0400", hash_original_field = "8535BFF02E263AB07820336F2B6CBE9E", hash_generated_field = "0F522A2F9FEC0AE6C7C0EFB2E65868E6")

        private final Collator sCollator = Collator.getInstance();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.036 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "B9590FAB3CF140F08C9CD4E0309ED58A")

        private PackageManager mPM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.036 -0400", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "00B9637435B2DF20319BD9D174F2475F")
        public  DisplayNameComparator(PackageManager pm) {
            mPM = pm;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_method = "C6664C7947CB4F50D04FE5C6FED7BB23", hash_generated_method = "4FED9395EB7A339EADBFEDD9E3B9FAEA")
        public final int compare(ApplicationInfo aa, ApplicationInfo ab) {
            CharSequence sa = mPM.getApplicationLabel(aa);
            {
                sa = aa.packageName;
            } 
            CharSequence sb = mPM.getApplicationLabel(ab);
            {
                sb = ab.packageName;
            } 
            int var84BDFD4BCC4C054E649C7A0FEE1F21B0_410938845 = (sCollator.compare(sa.toString(), sb.toString()));
            addTaint(aa.getTaint());
            addTaint(ab.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130535451 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130535451;
            
            
            
                
            
            
            
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "B3B1D4B1C738ACA200B0F7A4AC9E3684", hash_generated_field = "561B89510C1340BB2679DFD17733782E")

    public static final int FLAG_SYSTEM = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "5A995FBC03EC3F3DED672E8BA12D9B8A", hash_generated_field = "EE54BF92D243C0288C8E9E957E104677")

    public static final int FLAG_DEBUGGABLE = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "F2F669463E756BED5DA20181C8132FDE", hash_generated_field = "BC40B8D55072FF40693BDC49545E6C18")

    public static final int FLAG_HAS_CODE = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "6B123A5A8B59CAB78DD1EEC4288FA6A8", hash_generated_field = "FF21B6E642F6567E74B21AEF93B2043D")

    public static final int FLAG_PERSISTENT = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "7215DD8199E42F51E8A12A7835D9F4CD", hash_generated_field = "95980F82CE0AB24920417B16AB68F432")

    public static final int FLAG_FACTORY_TEST = 1<<4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "54A9BB311BCCBD07C1D19673E2627927", hash_generated_field = "D4B205D9EB2807DCF2F1D48F0470DF0B")

    public static final int FLAG_ALLOW_TASK_REPARENTING = 1<<5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "C4C555B318626F61932695F53F3237BD", hash_generated_field = "31E61829EAC7EAAAB69D432AD97EDA1F")

    public static final int FLAG_ALLOW_CLEAR_USER_DATA = 1<<6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "C68301AE24CDBA520BAFA286D4C2F4C6", hash_generated_field = "49188CE3B61F6C625A08DDCCAA341AF5")

    public static final int FLAG_UPDATED_SYSTEM_APP = 1<<7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "983177EDB7F527E09365058B60360EB3", hash_generated_field = "0DE4AD43A482D068FDE133ECDB159AD3")

    public static final int FLAG_TEST_ONLY = 1<<8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "CD5933594B16B647907BA92282B2E660", hash_generated_field = "3B5615EFFBCAD74CE7B993C4BFB06B16")

    public static final int FLAG_SUPPORTS_SMALL_SCREENS = 1<<9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "1C986E4DDC7FC0362EDFD8FB4DD53770", hash_generated_field = "1EE945F09F9FCD7239F78EFD55C9DC27")

    public static final int FLAG_SUPPORTS_NORMAL_SCREENS = 1<<10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "E46CF23D11BAE5EA06FEC740C00759E4", hash_generated_field = "0C511A79CF791047910BD5D9DC913AEC")

    public static final int FLAG_SUPPORTS_LARGE_SCREENS = 1<<11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.037 -0400", hash_original_field = "E9364A243F671A8D7F1AFFCFD5B69694", hash_generated_field = "CC61FBA4D931769E282B43D310D29B45")

    public static final int FLAG_RESIZEABLE_FOR_SCREENS = 1<<12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "528EC8B80920D750010F96A2F0D2E7E5", hash_generated_field = "6B4CC4FED7D79FD3FD7554999709E4E8")

    public static final int FLAG_SUPPORTS_SCREEN_DENSITIES = 1<<13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "4B3A52ED29A529F30CE91EC03F18A02D", hash_generated_field = "432528B929508471FBF64EB051199C99")

    public static final int FLAG_VM_SAFE_MODE = 1<<14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "AC62B909493D2C847207B02E822FC43A", hash_generated_field = "73DED9E8FD1D91D05214FCC2A4C48FF6")

    public static final int FLAG_ALLOW_BACKUP = 1<<15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "95F6F0A221248D98AAEB3E63B4648FFA", hash_generated_field = "6546037CBD2A9570306DAE14154B2128")

    public static final int FLAG_KILL_AFTER_RESTORE = 1<<16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "D8B317B1E62EBB001F1E0A27DDE3B8CA", hash_generated_field = "CC4E7B20CE2E0DEEA70F56BA4A71271F")

    public static final int FLAG_RESTORE_ANY_VERSION = 1<<17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "EB081E1D87BC4874096255DEADAA68B6", hash_generated_field = "39130497A3475AB9A20D6FEBBA9B17D7")

    public static final int FLAG_EXTERNAL_STORAGE = 1<<18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "7608F02946C83E323B8B344F79198AAA", hash_generated_field = "D4C9FE84AF96EFE53263803181F07688")

    public static final int FLAG_SUPPORTS_XLARGE_SCREENS = 1<<19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "1859F6C19E053096FB0C4F3C99EF3D63", hash_generated_field = "09F14C138A9D31BF1F310241B027CC07")

    public static final int FLAG_LARGE_HEAP = 1<<20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "25F9B3AD3D0E7DF552DF2715E0B4312E", hash_generated_field = "7FEF6F66294ECCDB2E301D891A63D4C8")

    public static final int FLAG_STOPPED = 1<<21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "E3B3E2963F36042088799AA925FE34E8", hash_generated_field = "025A9F3C74125C95135DC8E8E224561D")

    public static final int FLAG_FORWARD_LOCK = 1<<29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "6EC758B28115A0066B9D495261B3C7C8", hash_generated_field = "EA2624B5DD97ED42F552E6C89FF62141")

    public static final int FLAG_CANT_SAVE_STATE = 1<<28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.038 -0400", hash_original_field = "27679CB9E03B26BB40EA68FDAAA78442", hash_generated_field = "568E85AC1E6B72D14B17D5DBAD6478F9")

    public static final Parcelable.Creator<ApplicationInfo> CREATOR
            = new Parcelable.Creator<ApplicationInfo>() {
        public ApplicationInfo createFromParcel(Parcel source) {
            return new ApplicationInfo(source);
        }
        public ApplicationInfo[] newArray(int size) {
            return new ApplicationInfo[size];
        }
    };
    
    public ApplicationInfo createFromParcel(Parcel source) {
            return new ApplicationInfo(source);
        }
    
    
    public ApplicationInfo[] newArray(int size) {
            return new ApplicationInfo[size];
        }
    
}

