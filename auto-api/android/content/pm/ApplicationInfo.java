package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    public String taskAffinity;
    public String permission;
    public String processName;
    public String className;
    public int descriptionRes;
    public int theme;
    public String manageSpaceActivityName;
    public String backupAgentName;
    public int uiOptions = 0;
    public int flags = 0;
    public int requiresSmallestWidthDp = 0;
    public int compatibleWidthLimitDp = 0;
    public int largestWidthLimitDp = 0;
    public String sourceDir;
    public String publicSourceDir;
    public String[] resourceDirs;
    public String[] sharedLibraryFiles;
    public String dataDir;
    public String nativeLibraryDir;
    public int uid;
    public int targetSdkVersion;
    public boolean enabled = true;
    public int enabledSetting = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    public int installLocation = PackageInfo.INSTALL_LOCATION_UNSPECIFIED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.678 -0400", hash_original_method = "5A2EFBCC396F3478953F6D70829229DF", hash_generated_method = "1C6DF293A3C6120BEE22B701113A526F")
    @DSModeled(DSC.SAFE)
    public ApplicationInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.680 -0400", hash_original_method = "69807CD533357E6E6EA42F47263369C0", hash_generated_method = "0725935283EE8529D25E34B166FD6E60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ApplicationInfo(ApplicationInfo orig) {
        super(orig);
        dsTaint.addTaint(orig.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.681 -0400", hash_original_method = "C34B9C3D6C69EB97D4130A1E4D235BF1", hash_generated_method = "6029F46C4FFC5B0994B91D54B26CE6BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ApplicationInfo(Parcel source) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.681 -0400", hash_original_method = "7729FD0B554CDA849A4BAB68A5483EB9", hash_generated_method = "03CCACB3895F7C881AAE18D2DCA6ECD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        super.dumpFront(pw, prefix);
        {
            pw.println(prefix + "className=" + className);
        } //End block
        {
            pw.println(prefix + "permission=" + permission);
        } //End block
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
            } //End block
        } //End block
        {
            boolean varA39FE0691770EDFA5F3A53BAF72DCA47_424336005 = (!sourceDir.equals(publicSourceDir));
            {
                pw.println(prefix + "publicSourceDir=" + publicSourceDir);
            } //End block
        } //End collapsed parenthetic
        {
            pw.println(prefix + "resourceDirs=" + resourceDirs);
        } //End block
        pw.println(prefix + "dataDir=" + dataDir);
        {
            pw.println(prefix + "sharedLibraryFiles=" + sharedLibraryFiles);
        } //End block
        pw.println(prefix + "enabled=" + enabled + " targetSdkVersion=" + targetSdkVersion);
        {
            pw.println(prefix + "manageSpaceActivityName="+manageSpaceActivityName);
        } //End block
        {
            pw.println(prefix + "description=0x"+Integer.toHexString(descriptionRes));
        } //End block
        {
            pw.println(prefix + "uiOptions=0x" + Integer.toHexString(uiOptions));
        } //End block
        super.dumpBack(pw, prefix);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.682 -0400", hash_original_method = "D921E47CA861D6D48D77FD8F7E62A49D", hash_generated_method = "6BFDFC464154DC08388C6A87292E3D9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var8944A9E0E8E465E19CA3070CA4B9F59C_976025889 = ("ApplicationInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ApplicationInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + packageName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.682 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.683 -0400", hash_original_method = "49D8EFBAED7609827DD9A53B007B084F", hash_generated_method = "1EE6FF0AA56412DC1617D29C3A4F1CCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.683 -0400", hash_original_method = "91D0630D593C0E5EFA5BB0A713D23C43", hash_generated_method = "96264638DDCD4719644E571FACEB69CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadDescription(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        {
            CharSequence label;
            label = pm.getText(packageName, descriptionRes, this);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (descriptionRes != 0) {
            //CharSequence label = pm.getText(packageName, descriptionRes, this);
            //if (label != null) {
                //return label;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.683 -0400", hash_original_method = "110E01A7854D6A7CF0C047806FCA3437", hash_generated_method = "4260BDBF7ADA9DD58BFC26F5C7BE7B86")
    @DSModeled(DSC.SAFE)
    public void disableCompatibilityMode() {
        flags |= (FLAG_SUPPORTS_LARGE_SCREENS | FLAG_SUPPORTS_NORMAL_SCREENS |
                FLAG_SUPPORTS_SMALL_SCREENS | FLAG_RESIZEABLE_FOR_SCREENS |
                FLAG_SUPPORTS_SCREEN_DENSITIES | FLAG_SUPPORTS_XLARGE_SCREENS);
        // ---------- Original Method ----------
        //flags |= (FLAG_SUPPORTS_LARGE_SCREENS | FLAG_SUPPORTS_NORMAL_SCREENS |
                //FLAG_SUPPORTS_SMALL_SCREENS | FLAG_RESIZEABLE_FOR_SCREENS |
                //FLAG_SUPPORTS_SCREEN_DENSITIES | FLAG_SUPPORTS_XLARGE_SCREENS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.685 -0400", hash_original_method = "ED007A8BD44C2C8CDC7AE52AC1ADD2C8", hash_generated_method = "6203F9C0E86D8D8FDED45C5209899763")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Drawable loadDefaultIcon(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        {
            boolean var13DA2665C8125DDFC7DD4BE22BB98026_132455432 = ((flags & FLAG_EXTERNAL_STORAGE) != 0
                && isPackageUnavailable(pm));
            {
                Drawable varBB53B30523FEF81543B978E2690FB3FD_1226164526 = (Resources.getSystem().getDrawable(
                    com.android.internal.R.drawable.sym_app_on_sd_unavailable_icon));
            } //End block
        } //End collapsed parenthetic
        Drawable var0DE00E38B87CF4E9B9F8F8B0CA523BE3_1892054797 = (pm.getDefaultActivityIcon());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ((flags & FLAG_EXTERNAL_STORAGE) != 0
                //&& isPackageUnavailable(pm)) {
            //return Resources.getSystem().getDrawable(
                    //com.android.internal.R.drawable.sym_app_on_sd_unavailable_icon);
        //}
        //return pm.getDefaultActivityIcon();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.686 -0400", hash_original_method = "B87914FC2F221448B9EDC9CCD205939A", hash_generated_method = "76EB3E0E64AEDEFB832B7DFF3DDB1A3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isPackageUnavailable(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        try 
        {
            boolean varFBE29452BA58067126DA01DC2AF37A99_4439519 = (pm.getPackageInfo(packageName, 0) == null);
        } //End block
        catch (NameNotFoundException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return pm.getPackageInfo(packageName, 0) == null;
        //} catch (NameNotFoundException ex) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.687 -0400", hash_original_method = "4CB14D4C822DE3694FE375457E968E4C", hash_generated_method = "6C43792031E6DA027DEABE4A0D61704B")
    @DSModeled(DSC.SAFE)
    @Override
    protected ApplicationInfo getApplicationInfo() {
        return (ApplicationInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    public static class DisplayNameComparator implements Comparator<ApplicationInfo> {
        private Collator   sCollator = Collator.getInstance();
        private PackageManager   mPM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.688 -0400", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "AF5A9D42CCA5BEF178298CF4EA0D30B4")
        @DSModeled(DSC.SAFE)
        public DisplayNameComparator(PackageManager pm) {
            dsTaint.addTaint(pm.dsTaint);
            // ---------- Original Method ----------
            //mPM = pm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.690 -0400", hash_original_method = "C6664C7947CB4F50D04FE5C6FED7BB23", hash_generated_method = "CEC3C822AF2EB066F56CA05A586A6E3A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int compare(ApplicationInfo aa, ApplicationInfo ab) {
            dsTaint.addTaint(aa.dsTaint);
            dsTaint.addTaint(ab.dsTaint);
            CharSequence sa;
            sa = mPM.getApplicationLabel(aa);
            {
                sa = aa.packageName;
            } //End block
            CharSequence sb;
            sb = mPM.getApplicationLabel(ab);
            {
                sb = ab.packageName;
            } //End block
            int var84BDFD4BCC4C054E649C7A0FEE1F21B0_1464486211 = (sCollator.compare(sa.toString(), sb.toString()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //CharSequence  sa = mPM.getApplicationLabel(aa);
            //if (sa == null) {
                //sa = aa.packageName;
            //}
            //CharSequence  sb = mPM.getApplicationLabel(ab);
            //if (sb == null) {
                //sb = ab.packageName;
            //}
            //return sCollator.compare(sa.toString(), sb.toString());
        }

        
    }


    
    public static final int FLAG_SYSTEM = 1<<0;
    public static final int FLAG_DEBUGGABLE = 1<<1;
    public static final int FLAG_HAS_CODE = 1<<2;
    public static final int FLAG_PERSISTENT = 1<<3;
    public static final int FLAG_FACTORY_TEST = 1<<4;
    public static final int FLAG_ALLOW_TASK_REPARENTING = 1<<5;
    public static final int FLAG_ALLOW_CLEAR_USER_DATA = 1<<6;
    public static final int FLAG_UPDATED_SYSTEM_APP = 1<<7;
    public static final int FLAG_TEST_ONLY = 1<<8;
    public static final int FLAG_SUPPORTS_SMALL_SCREENS = 1<<9;
    public static final int FLAG_SUPPORTS_NORMAL_SCREENS = 1<<10;
    public static final int FLAG_SUPPORTS_LARGE_SCREENS = 1<<11;
    public static final int FLAG_RESIZEABLE_FOR_SCREENS = 1<<12;
    public static final int FLAG_SUPPORTS_SCREEN_DENSITIES = 1<<13;
    public static final int FLAG_VM_SAFE_MODE = 1<<14;
    public static final int FLAG_ALLOW_BACKUP = 1<<15;
    public static final int FLAG_KILL_AFTER_RESTORE = 1<<16;
    public static final int FLAG_RESTORE_ANY_VERSION = 1<<17;
    public static final int FLAG_EXTERNAL_STORAGE = 1<<18;
    public static final int FLAG_SUPPORTS_XLARGE_SCREENS = 1<<19;
    public static final int FLAG_LARGE_HEAP = 1<<20;
    public static final int FLAG_STOPPED = 1<<21;
    public static final int FLAG_FORWARD_LOCK = 1<<29;
    public static final int FLAG_CANT_SAVE_STATE = 1<<28;
    public static final Parcelable.Creator<ApplicationInfo> CREATOR = new Parcelable.Creator<ApplicationInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.692 -0400", hash_original_method = "003CCA274078E72A658F6344F93CD336", hash_generated_method = "AE15F798D79B879BFADBDB74E865BAA8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ApplicationInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ApplicationInfo var196FE5D83B4FB939E270A057EA5A8B1D_1708291638 = (new ApplicationInfo(source));
            return (ApplicationInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ApplicationInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.692 -0400", hash_original_method = "0FDCEA825DAB3FB1D09759A4F0D45766", hash_generated_method = "1DB613F1ECF1172FA38432724F3D7607")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ApplicationInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            ApplicationInfo[] var0E76EE4652FE463DD4214102AAC26FC3_1778454175 = (new ApplicationInfo[size]);
            return (ApplicationInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ApplicationInfo[size];
        }

        
}; //Transformed anonymous class
}

