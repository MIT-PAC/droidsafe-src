package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ActivityInfo extends ComponentInfo implements Parcelable {
    public int theme;
    public int launchMode;
    public String permission;
    public String taskAffinity;
    public String targetActivity;
    public int flags;
    public int screenOrientation = SCREEN_ORIENTATION_UNSPECIFIED;
    public int configChanges;
    public int softInputMode;
    public int uiOptions = 0;
    
    public ActivityInfo(){
	}

    
    public ActivityInfo(ActivityInfo orig){
		super(orig);
		addTaint(orig.getTaint());
		/*
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
		*/
	}

    
    private ActivityInfo(Parcel source) {
    	super(source);
        addTaint(source.readInt()); //theme
        addTaint(source.readInt()); //launchMode
        permission = source.readString();
        //addTaint(source.readString().getTaint()); //permission
        taskAffinity = source.readString();
        //addTaint(source.readString().getTaint()); //taskAffinity
        targetActivity = source.readString();
        //addTaint(source.readString().getTaint()); //targetActivity
        addTaint(source.readInt()); //flags
        addTaint(source.readInt()); //screenOrientation
        addTaint(source.readInt()); //configChanges
        addTaint(source.readInt()); //softInputMode
        addTaint(source.readInt()); //uiOptions
    }

    
    public static int activityInfoConfigToNative(int input){
		return input;
		// Original method
		/*
		{
        int output = 0;
        for (int i=0; i<CONFIG_NATIVE_BITS.length; i++) {
            if ((input&(1<<i)) != 0) {
                output |= CONFIG_NATIVE_BITS[i];
            }
        }
        return output;
    }
		*/
	}

    
    public int getRealConfigChanged(){
		// Original method
		/*
		{
        return applicationInfo.targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB_MR2
                ? (configChanges | ActivityInfo.CONFIG_SCREEN_SIZE
                        | ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE)
                : configChanges;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SPEC)
    public final int getThemeResource() {
        return getTaintInt();
    }

    
    public void dump(Printer pw, String prefix){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public String toString(){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		// Original method
		/*
		{
        return "ActivityInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
    }
		*/
	}

    
    public int describeContents(){
		// Original method
		/*
		{
        return 0;
    }
		*/
		return 0;
	}

    
    public void writeToParcel(Parcel dest, int parcelableFlags){
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
		// Original method
		/*
		{
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
    }
		*/
		//Return nothing
	}

    
    public static final int LAUNCH_MULTIPLE = 0;
    public static final int LAUNCH_SINGLE_TOP = 1;
    public static final int LAUNCH_SINGLE_TASK = 2;
    public static final int LAUNCH_SINGLE_INSTANCE = 3;
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
    public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;
    public static final Parcelable.Creator<ActivityInfo> CREATOR
            = new Parcelable.Creator<ActivityInfo>() {
        public ActivityInfo createFromParcel(Parcel source) {
            return new ActivityInfo(source);
        }
        public ActivityInfo[] newArray(int size) {
            return new ActivityInfo[size];
        }
    };
    // orphaned legacy field
    public String parentActivityName;
    
}

