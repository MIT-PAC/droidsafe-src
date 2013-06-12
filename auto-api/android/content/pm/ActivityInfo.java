package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ActivityInfo extends ComponentInfo implements Parcelable {
    public int theme;
    public static final int LAUNCH_MULTIPLE = 0;
    public static final int LAUNCH_SINGLE_TOP = 1;
    public static final int LAUNCH_SINGLE_TASK = 2;
    public static final int LAUNCH_SINGLE_INSTANCE = 3;
    public int launchMode;
    public String permission;
    public String taskAffinity;
    public String targetActivity;
    public static final int FLAG_MULTIPROCESS = 0x0001;
    public static final int FLAG_FINISH_ON_TASK_LAUNCH = 0x0002;
    public static final int FLAG_CLEAR_TASK_ON_LAUNCH = 0x0004;
    public static final int FLAG_ALWAYS_RETAIN_TASK_STATE = 0x0008;
    public static final int FLAG_STATE_NOT_NEEDED = 0x0010;
    public static final int FLAG_EXCLUDE_FROM_RECENTS = 0x0020;
    public static final int FLAG_ALLOW_TASK_REPARENTING = 0x0040;
    public static final int FLAG_NO_HISTORY = 0x0080;
    public static final int FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS = 0x0100;
    public static final int FLAG_HARDWARE_ACCELERATED = 0x0200;
    public static final int FLAG_IMMERSIVE = 0x0400;
    public int flags;
    public static final int SCREEN_ORIENTATION_UNSPECIFIED = -1;
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 0;
    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    public static final int SCREEN_ORIENTATION_USER = 2;
    public static final int SCREEN_ORIENTATION_BEHIND = 3;
    public static final int SCREEN_ORIENTATION_SENSOR = 4;
    public static final int SCREEN_ORIENTATION_NOSENSOR = 5;
    public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
    public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
    public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8;
    public static final int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9;
    public static final int SCREEN_ORIENTATION_FULL_SENSOR = 10;
    public int screenOrientation = SCREEN_ORIENTATION_UNSPECIFIED;
    public static final int CONFIG_MCC = 0x0001;
    public static final int CONFIG_MNC = 0x0002;
    public static final int CONFIG_LOCALE = 0x0004;
    public static final int CONFIG_TOUCHSCREEN = 0x0008;
    public static final int CONFIG_KEYBOARD = 0x0010;
    public static final int CONFIG_KEYBOARD_HIDDEN = 0x0020;
    public static final int CONFIG_NAVIGATION = 0x0040;
    public static final int CONFIG_ORIENTATION = 0x0080;
    public static final int CONFIG_SCREEN_LAYOUT = 0x0100;
    public static final int CONFIG_UI_MODE = 0x0200;
    public static final int CONFIG_SCREEN_SIZE = 0x0400;
    public static final int CONFIG_SMALLEST_SCREEN_SIZE = 0x0800;
    public static final int CONFIG_FONT_SCALE = 0x40000000;
    public static int[] CONFIG_NATIVE_BITS = new int[] {
        0x0001, 
        0x0002, 
        0x0004, 
        0x0008, 
        0x0010, 
        0x0020, 
        0x0040, 
        0x0080, 
        0x0800, 
        0x1000, 
        0x0200, 
        0x2000, 
    };
    public int configChanges;
    public int softInputMode;
    public int uiOptions = 0;
    public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;
    public static final Parcelable.Creator<ActivityInfo> CREATOR = new Parcelable.Creator<ActivityInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.814 -0400", hash_original_method = "7881E2AE5504281E1113E4204713DBE5", hash_generated_method = "AE9AE914E425469112549975055E5C6F")
        @DSModeled(DSC.SAFE)
        public ActivityInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (ActivityInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ActivityInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.814 -0400", hash_original_method = "55042204736C415254FD6A445E807C5C", hash_generated_method = "E760A9B15DCA039785A21EF1CF8D6784")
        @DSModeled(DSC.SAFE)
        public ActivityInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ActivityInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ActivityInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.814 -0400", hash_original_method = "AADA555071E489A7B136029649F29F63", hash_generated_method = "9E70C68B9887592D59FEEF7F7700D3D4")
    @DSModeled(DSC.SAFE)
    public ActivityInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.814 -0400", hash_original_method = "4FD441668078A896A91515A186821C6A", hash_generated_method = "E5DDA5921EFF6EE97CBFB10D93748190")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActivityInfo(ActivityInfo orig) {
        super(orig);
        dsTaint.addTaint(orig.dsTaint);
        theme = orig.theme;
        launchMode = orig.launchMode;
        permission = orig.permission;
        taskAffinity = orig.taskAffinity;
        targetActivity = orig.targetActivity;
        flags = orig.flags;
        screenOrientation = orig.screenOrientation;
        configChanges = orig.configChanges;
        softInputMode = orig.softInputMode;
        uiOptions = orig.uiOptions;
        // ---------- Original Method ----------
        //theme = orig.theme;
        //launchMode = orig.launchMode;
        //permission = orig.permission;
        //taskAffinity = orig.taskAffinity;
        //targetActivity = orig.targetActivity;
        //flags = orig.flags;
        //screenOrientation = orig.screenOrientation;
        //configChanges = orig.configChanges;
        //softInputMode = orig.softInputMode;
        //uiOptions = orig.uiOptions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.815 -0400", hash_original_method = "BC25ED8BD045A23681F3CDE53EF4296B", hash_generated_method = "EA4DC6F03038837975CB2D14A1F192FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ActivityInfo(Parcel source) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
        theme = source.readInt();
        launchMode = source.readInt();
        permission = source.readString();
        taskAffinity = source.readString();
        targetActivity = source.readString();
        flags = source.readInt();
        screenOrientation = source.readInt();
        configChanges = source.readInt();
        softInputMode = source.readInt();
        uiOptions = source.readInt();
        // ---------- Original Method ----------
        //theme = source.readInt();
        //launchMode = source.readInt();
        //permission = source.readString();
        //taskAffinity = source.readString();
        //targetActivity = source.readString();
        //flags = source.readInt();
        //screenOrientation = source.readInt();
        //configChanges = source.readInt();
        //softInputMode = source.readInt();
        //uiOptions = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.815 -0400", hash_original_method = "C07DEDE9C3F530AB4B741282ACF39C55", hash_generated_method = "F8E93384A437C7284764054AA9855E71")
    public static int activityInfoConfigToNative(int input) {
        int output = 0;
        for (int i=0; i<CONFIG_NATIVE_BITS.length; i++) {
            if ((input&(1<<i)) != 0) {
                output |= CONFIG_NATIVE_BITS[i];
            }
        }
        return output;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.815 -0400", hash_original_method = "2220B48CFCD1F70E454B4F27BFE80BE1", hash_generated_method = "6A36B1DD7F46C113A23DB69690E6F735")
    @DSModeled(DSC.SAFE)
    public int getRealConfigChanged() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return applicationInfo.targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB_MR2
                //? (configChanges | ActivityInfo.CONFIG_SCREEN_SIZE
                        //| ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE)
                //: configChanges;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.816 -0400", hash_original_method = "49F7EEB7DFDAB588B69DE97F89E77EAC", hash_generated_method = "8D898DF19C9C1C6AD77597D2AEFA55F7")
    @DSModeled(DSC.SAFE)
    public final int getThemeResource() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return theme != 0 ? theme : applicationInfo.theme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.816 -0400", hash_original_method = "0EA21654C0B5D84D36E2F9B8C286493E", hash_generated_method = "CA2CAA5692BA42FA1B69D4B4AF126331")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        super.dumpFront(pw, prefix);
        {
            pw.println(prefix + "permission=" + permission);
        } //End block
        pw.println(prefix + "taskAffinity=" + taskAffinity
                + " targetActivity=" + targetActivity);
        {
            pw.println(prefix + "launchMode=" + launchMode
                    + " flags=0x" + Integer.toHexString(flags)
                    + " theme=0x" + Integer.toHexString(theme));
        } //End block
        {
            pw.println(prefix + "screenOrientation=" + screenOrientation
                    + " configChanges=0x" + Integer.toHexString(configChanges)
                    + " softInputMode=0x" + Integer.toHexString(softInputMode));
        } //End block
        {
            pw.println(prefix + " uiOptions=0x" + Integer.toHexString(uiOptions));
        } //End block
        super.dumpBack(pw, prefix);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.816 -0400", hash_original_method = "B913D35C681ED2748C3576E23600DB3E", hash_generated_method = "B61F0FEB7B6410CF82B36B1EDAEB585D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var9DB3A741CB7CB892609070B737E1C25D_1449530019 = ("ActivityInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ActivityInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.817 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.817 -0400", hash_original_method = "0DBABFC7118E214F01D60FEE309F0914", hash_generated_method = "9A77AB31B0C07A3CB380E2E9AB185D5A")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        super.writeToParcel(dest, parcelableFlags);
        dest.writeInt(theme);
        dest.writeInt(launchMode);
        dest.writeString(permission);
        dest.writeString(taskAffinity);
        dest.writeString(targetActivity);
        dest.writeInt(flags);
        dest.writeInt(screenOrientation);
        dest.writeInt(configChanges);
        dest.writeInt(softInputMode);
        dest.writeInt(uiOptions);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //dest.writeInt(theme);
        //dest.writeInt(launchMode);
        //dest.writeString(permission);
        //dest.writeString(taskAffinity);
        //dest.writeString(targetActivity);
        //dest.writeInt(flags);
        //dest.writeInt(screenOrientation);
        //dest.writeInt(configChanges);
        //dest.writeInt(softInputMode);
        //dest.writeInt(uiOptions);
    }

    
}


