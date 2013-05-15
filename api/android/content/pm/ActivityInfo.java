/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.content.pm;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ActivityInfo extends ComponentInfo
        implements Parcelable {
	private DSTaintObject dsTaint = new DSTaintObject();
    /**
     * A style resource identifier (in the package's resources) of this
     * activity's theme.  From the "theme" attribute or, if not set, 0.
     */
    public int theme;
    
    /**
     * Constant corresponding to <code>standard</code> in
     * the {@link android.R.attr#launchMode} attribute.
     */
    public static final int LAUNCH_MULTIPLE = 0;
    /**
     * Constant corresponding to <code>singleTop</code> in
     * the {@link android.R.attr#launchMode} attribute.
     */
    public static final int LAUNCH_SINGLE_TOP = 1;
    /**
     * Constant corresponding to <code>singleTask</code> in
     * the {@link android.R.attr#launchMode} attribute.
     */
    public static final int LAUNCH_SINGLE_TASK = 2;
    /**
     * Constant corresponding to <code>singleInstance</code> in
     * the {@link android.R.attr#launchMode} attribute.
     */
    public static final int LAUNCH_SINGLE_INSTANCE = 3;
    /**
     * The launch mode style requested by the activity.  From the
     * {@link android.R.attr#launchMode} attribute, one of
     * {@link #LAUNCH_MULTIPLE},
     * {@link #LAUNCH_SINGLE_TOP}, {@link #LAUNCH_SINGLE_TASK}, or 
     * {@link #LAUNCH_SINGLE_INSTANCE}.
     */
    public int launchMode;
    
    /**
     * Optional name of a permission required to be able to access this
     * Activity.  From the "permission" attribute.
     */
    public String permission;
    
    /**
     * The affinity this activity has for another task in the system.  The
     * string here is the name of the task, often the package name of the
     * overall package.  If null, the activity has no affinity.  Set from the
     * {@link android.R.attr#taskAffinity} attribute.
     */
    public String taskAffinity;
    
    /**
     * If this is an activity alias, this is the real activity class to run
     * for it.  Otherwise, this is null.
     */
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
        0x0001, // MNC
        0x0002, // MCC
        0x0004, // LOCALE
        0x0008, // TOUCH SCREEN
        0x0010, // KEYBOARD
        0x0020, // KEYBOARD HIDDEN
        0x0040, // NAVIGATION
        0x0080, // ORIENTATION
        0x0800, // SCREEN LAYOUT
        0x1000, // UI MODE
        0x0200, // SCREEN SIZE
        0x2000, // SMALLEST SCREEN SIZE
    };
    /** @hide
     * Convert Java change bits to native.
     */
    @DSModeled(DSC.SAFE)
    public static int activityInfoConfigToNative(int input) {
        int output = 0;
        for (int i=0; i<CONFIG_NATIVE_BITS.length; i++) {
            if ((input&(1<<i)) != 0) {
                output |= CONFIG_NATIVE_BITS[i];
            }
        }
        return output;
    }

    @DSModeled
    public int getRealConfigChanged() {
    	return dsTaint.getTaintInt();
    }

    public int configChanges;
    
    public int softInputMode;

    public int uiOptions = 0;

    public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;

    @DSModeled(DSC.SAFE)
    public ActivityInfo() {
    }

    @DSModeled(DSC.SAFE)
    public ActivityInfo(ActivityInfo orig) {
        dsTaint.addTaint(orig.dsTaint);
    }
    
    /**
     * Return the theme resource identifier to use for this activity.  If
     * the activity defines a theme, that is used; else, the application
     * theme is used.
     * 
     * @return The theme associated with this activity.
     */
    @DSModeled
    public final int getThemeResource() {
        return dsTaint.getTaintInt();
    }

    @DSModeled
    public void dump(Printer pw, String prefix) {
    	pw.println(this.toString());
    	pw.println(prefix);
    }
    
    @DSModeled
    public String toString() {
        return dsTaint.getTaintString();
    }

    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return 0;
    }

    @DSModeled
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeInt(parcelableFlags);
        dest.writeValue(this); 
    }

    public static final Parcelable.Creator<ActivityInfo> CREATOR
            = new Parcelable.Creator<ActivityInfo>() {
        public ActivityInfo createFromParcel(Parcel source) {
            return new ActivityInfo(source);
        }
        public ActivityInfo[] newArray(int size) {
            return new ActivityInfo[size];
        }
    };

    private ActivityInfo(Parcel source) {
    	super(source);
        dsTaint.addTaint(source.readInt());
        dsTaint.addTaint(source.readInt());
        dsTaint.addTaint(source.readString());
        dsTaint.addTaint(source.readString());
        dsTaint.addTaint(source.readString());
        dsTaint.addTaint(source.readInt());
        dsTaint.addTaint(source.readInt());
        dsTaint.addTaint(source.readInt());
        dsTaint.addTaint(source.readInt());
        dsTaint.addTaint(source.readInt());
    }
}
