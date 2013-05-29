package android.content.res;
import droidsafe.annotations.*;
import droidsafe.helpers.*;
import android.content.pm.ActivityInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.LocaleUtil;
import java.util.Locale;
public final class Configuration implements Parcelable, Comparable<Configuration> {
    public float fontScale;
    public int mcc;
    public int mnc;
    public Locale locale;
    public boolean userSetLocale;
    public static final int SCREENLAYOUT_SIZE_MASK = 0x0f;
    public static final int SCREENLAYOUT_SIZE_UNDEFINED = 0x00;
    public static final int SCREENLAYOUT_SIZE_SMALL = 0x01;
    public static final int SCREENLAYOUT_SIZE_NORMAL = 0x02;
    public static final int SCREENLAYOUT_SIZE_LARGE = 0x03;
    public static final int SCREENLAYOUT_SIZE_XLARGE = 0x04;
    public static final int SCREENLAYOUT_LONG_MASK = 0x30;
    public static final int SCREENLAYOUT_LONG_UNDEFINED = 0x00;
    public static final int SCREENLAYOUT_LONG_NO = 0x10;
    public static final int SCREENLAYOUT_LONG_YES = 0x20;
    public static final int SCREENLAYOUT_COMPAT_NEEDED = 0x10000000;
    public int screenLayout;
    public boolean isLayoutSizeAtLeast(int size) {
        int cur = screenLayout&SCREENLAYOUT_SIZE_MASK;
        if (cur == SCREENLAYOUT_SIZE_UNDEFINED) return false;
        return cur >= size;
    }
    public static final int TOUCHSCREEN_UNDEFINED = 0;
    public static final int TOUCHSCREEN_NOTOUCH = 1;
    public static final int TOUCHSCREEN_STYLUS = 2;
    public static final int TOUCHSCREEN_FINGER = 3;
    public int touchscreen;
    public static final int KEYBOARD_UNDEFINED = 0;
    public static final int KEYBOARD_NOKEYS = 1;
    public static final int KEYBOARD_QWERTY = 2;
    public static final int KEYBOARD_12KEY = 3;
    public int keyboard;
    public static final int KEYBOARDHIDDEN_UNDEFINED = 0;
    public static final int KEYBOARDHIDDEN_NO = 1;
    public static final int KEYBOARDHIDDEN_YES = 2;
    public static final int KEYBOARDHIDDEN_SOFT = 3;
    public int keyboardHidden;
    public static final int HARDKEYBOARDHIDDEN_UNDEFINED = 0;
    public static final int HARDKEYBOARDHIDDEN_NO = 1;
    public static final int HARDKEYBOARDHIDDEN_YES = 2;
    public int hardKeyboardHidden;
    public static final int NAVIGATION_UNDEFINED = 0;
    public static final int NAVIGATION_NONAV = 1;
    public static final int NAVIGATION_DPAD = 2;
    public static final int NAVIGATION_TRACKBALL = 3;
    public static final int NAVIGATION_WHEEL = 4;
    public int navigation;
    public static final int NAVIGATIONHIDDEN_UNDEFINED = 0;
    public static final int NAVIGATIONHIDDEN_NO = 1;
    public static final int NAVIGATIONHIDDEN_YES = 2;
    public int navigationHidden;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIENTATION_PORTRAIT = 1;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_SQUARE = 3;
    public int orientation;
    public static final int UI_MODE_TYPE_MASK = 0x0f;
    public static final int UI_MODE_TYPE_UNDEFINED = 0x00;
    public static final int UI_MODE_TYPE_NORMAL = 0x01;
    public static final int UI_MODE_TYPE_DESK = 0x02;
    public static final int UI_MODE_TYPE_CAR = 0x03;
    public static final int UI_MODE_TYPE_TELEVISION = 0x04;
    public static final int UI_MODE_NIGHT_MASK = 0x30;
    public static final int UI_MODE_NIGHT_UNDEFINED = 0x00;
    public static final int UI_MODE_NIGHT_NO = 0x10;
    public static final int UI_MODE_NIGHT_YES = 0x20;
    public int uiMode;
    public static final int SCREEN_WIDTH_DP_UNDEFINED = 0;
    public int screenWidthDp;
    public static final int SCREEN_HEIGHT_DP_UNDEFINED = 0;
    public int screenHeightDp;
    public static final int SMALLEST_SCREEN_WIDTH_DP_UNDEFINED = 0;
    public int smallestScreenWidthDp;
    public int compatScreenWidthDp;
    public int compatScreenHeightDp;
    public int compatSmallestScreenWidthDp;
    public int textLayoutDirection;
    public int seq;
    
    @DSModeled
    public Configuration() {
        setToDefaults();
    }
    
    @DSModeled
    public Configuration(Configuration o) {
        setTo(o);
    }
    
	@DSModeled(DSC.SAFE)
    public void setTo(Configuration o) {
	    dsTaint.addTaint(o.dsTaint);
    }
	
	@DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
    }
    
	@DSModeled(DSC.SAFE)
    public void setToDefaults() {
    }
	
    @Deprecated public void makeDefault() {
        setToDefaults();
    }
    
	@DSModeled
    public int updateFrom(Configuration delta) {
        dsTaint.addTaint(delta.dsTaint);
        return dsTaint.getTaintInt();
    }
    
    public int diff(Configuration delta) {
        int changed = 0;
        if (delta.fontScale > 0 && fontScale != delta.fontScale) {
            changed |= ActivityInfo.CONFIG_FONT_SCALE;
        }
        if (delta.mcc != 0 && mcc != delta.mcc) {
            changed |= ActivityInfo.CONFIG_MCC;
        }
        if (delta.mnc != 0 && mnc != delta.mnc) {
            changed |= ActivityInfo.CONFIG_MNC;
        }
        if (delta.locale != null
                && (locale == null || !locale.equals(delta.locale))) {
            changed |= ActivityInfo.CONFIG_LOCALE;
        }
        if (delta.touchscreen != TOUCHSCREEN_UNDEFINED
                && touchscreen != delta.touchscreen) {
            changed |= ActivityInfo.CONFIG_TOUCHSCREEN;
        }
        if (delta.keyboard != KEYBOARD_UNDEFINED
                && keyboard != delta.keyboard) {
            changed |= ActivityInfo.CONFIG_KEYBOARD;
        }
        if (delta.keyboardHidden != KEYBOARDHIDDEN_UNDEFINED
                && keyboardHidden != delta.keyboardHidden) {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
        }
        if (delta.hardKeyboardHidden != HARDKEYBOARDHIDDEN_UNDEFINED
                && hardKeyboardHidden != delta.hardKeyboardHidden) {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
        }
        if (delta.navigation != NAVIGATION_UNDEFINED
                && navigation != delta.navigation) {
            changed |= ActivityInfo.CONFIG_NAVIGATION;
        }
        if (delta.navigationHidden != NAVIGATIONHIDDEN_UNDEFINED
                && navigationHidden != delta.navigationHidden) {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
        }
        if (delta.orientation != ORIENTATION_UNDEFINED
                && orientation != delta.orientation) {
            changed |= ActivityInfo.CONFIG_ORIENTATION;
        }
        if (delta.screenLayout != SCREENLAYOUT_SIZE_UNDEFINED
                && screenLayout != delta.screenLayout) {
            changed |= ActivityInfo.CONFIG_SCREEN_LAYOUT;
        }
        if (delta.uiMode != (UI_MODE_TYPE_UNDEFINED|UI_MODE_NIGHT_UNDEFINED)
                && uiMode != delta.uiMode) {
            changed |= ActivityInfo.CONFIG_UI_MODE;
        }
        if (delta.screenWidthDp != SCREEN_WIDTH_DP_UNDEFINED
                && screenWidthDp != delta.screenWidthDp) {
            changed |= ActivityInfo.CONFIG_SCREEN_SIZE;
        }
        if (delta.screenHeightDp != SCREEN_HEIGHT_DP_UNDEFINED
                && screenHeightDp != delta.screenHeightDp) {
            changed |= ActivityInfo.CONFIG_SCREEN_SIZE;
        }
        if (delta.smallestScreenWidthDp != SMALLEST_SCREEN_WIDTH_DP_UNDEFINED
                && smallestScreenWidthDp != delta.smallestScreenWidthDp) {
            changed |= ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE;
        }
        return changed;
    }
    public static boolean needNewResources(int configChanges, int interestingChanges) {
        return (configChanges & (interestingChanges|ActivityInfo.CONFIG_FONT_SCALE)) != 0;
    }
    public boolean isOtherSeqNewer(Configuration other) {
        if (other == null) {
            return false;
        }
        if (other.seq == 0) {
            return true;
        }
        if (seq == 0) {
            return true;
        }
        int diff = other.seq - seq;
        if (diff > 0x10000) {
            return false;
        }
        return diff > 0;
    }
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(fontScale);
        dest.writeInt(mcc);
        dest.writeInt(mnc);
        if (locale == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(locale.getLanguage());
            dest.writeString(locale.getCountry());
            dest.writeString(locale.getVariant());
        }
        if(userSetLocale) {
            dest.writeInt(1);
        } else {
            dest.writeInt(0);
        }
        dest.writeInt(touchscreen);
        dest.writeInt(keyboard);
        dest.writeInt(keyboardHidden);
        dest.writeInt(hardKeyboardHidden);
        dest.writeInt(navigation);
        dest.writeInt(navigationHidden);
        dest.writeInt(orientation);
        dest.writeInt(screenLayout);
        dest.writeInt(uiMode);
        dest.writeInt(screenWidthDp);
        dest.writeInt(screenHeightDp);
        dest.writeInt(smallestScreenWidthDp);
        dest.writeInt(compatScreenWidthDp);
        dest.writeInt(compatScreenHeightDp);
        dest.writeInt(compatSmallestScreenWidthDp);
        dest.writeInt(textLayoutDirection);
        dest.writeInt(seq);
    }
    public void readFromParcel(Parcel source) {
        fontScale = source.readFloat();
        mcc = source.readInt();
        mnc = source.readInt();
        if (source.readInt() != 0) {
            locale = new Locale(source.readString(), source.readString(),
                    source.readString());
        }
        userSetLocale = (source.readInt()==1);
        touchscreen = source.readInt();
        keyboard = source.readInt();
        keyboardHidden = source.readInt();
        hardKeyboardHidden = source.readInt();
        navigation = source.readInt();
        navigationHidden = source.readInt();
        orientation = source.readInt();
        screenLayout = source.readInt();
        uiMode = source.readInt();
        screenWidthDp = source.readInt();
        screenHeightDp = source.readInt();
        smallestScreenWidthDp = source.readInt();
        compatScreenWidthDp = source.readInt();
        compatScreenHeightDp = source.readInt();
        compatSmallestScreenWidthDp = source.readInt();
        textLayoutDirection = source.readInt();
        seq = source.readInt();
    }
    
    /** replacing anonymous inner class */
    private static class MyCreator implements Parcelable.Creator<Configuration> {
        @DSModeled
        public MyCreator() {
            
        }
        public Configuration createFromParcel(Parcel source) {
            return new Configuration(source);
        }
        public Configuration[] newArray(int size) {
            return new Configuration[size];
        }
    }
    
    public static final Parcelable.Creator<Configuration> CREATOR = new MyCreator();
    
    private Configuration(Parcel source) {
        readFromParcel(source);
    }
    public int compareTo(Configuration that) {
        int n;
        float a = this.fontScale;
        float b = that.fontScale;
        if (a < b) return -1;
        if (a > b) return 1;
        n = this.mcc - that.mcc;
        if (n != 0) return n;
        n = this.mnc - that.mnc;
        if (n != 0) return n;
        if (this.locale == null) {
            if (that.locale != null) return 1;
        } else if (that.locale == null) {
            return -1;
        } else {
            n = this.locale.getLanguage().compareTo(that.locale.getLanguage());
            if (n != 0) return n;
            n = this.locale.getCountry().compareTo(that.locale.getCountry());
            if (n != 0) return n;
            n = this.locale.getVariant().compareTo(that.locale.getVariant());
            if (n != 0) return n;
        }
        n = this.touchscreen - that.touchscreen;
        if (n != 0) return n;
        n = this.keyboard - that.keyboard;
        if (n != 0) return n;
        n = this.keyboardHidden - that.keyboardHidden;
        if (n != 0) return n;
        n = this.hardKeyboardHidden - that.hardKeyboardHidden;
        if (n != 0) return n;
        n = this.navigation - that.navigation;
        if (n != 0) return n;
        n = this.navigationHidden - that.navigationHidden;
        if (n != 0) return n;
        n = this.orientation - that.orientation;
        if (n != 0) return n;
        n = this.screenLayout - that.screenLayout;
        if (n != 0) return n;
        n = this.uiMode - that.uiMode;
        if (n != 0) return n;
        n = this.screenWidthDp - that.screenWidthDp;
        if (n != 0) return n;
        n = this.screenHeightDp - that.screenHeightDp;
        if (n != 0) return n;
        n = this.smallestScreenWidthDp - that.smallestScreenWidthDp;
        return n;
    }
    public boolean equals(Configuration that) {
        if (that == null) return false;
        if (that == this) return true;
        return this.compareTo(that) == 0;
    }
    public boolean equals(Object that) {
        try {
            return equals((Configuration)that);
        } catch (ClassCastException e) {
        }
        return false;
    }
    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.floatToIntBits(fontScale);
        result = 31 * result + mcc;
        result = 31 * result + mnc;
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        result = 31 * result + touchscreen;
        result = 31 * result + keyboard;
        result = 31 * result + keyboardHidden;
        result = 31 * result + hardKeyboardHidden;
        result = 31 * result + navigation;
        result = 31 * result + navigationHidden;
        result = 31 * result + orientation;
        result = 31 * result + screenLayout;
        result = 31 * result + uiMode;
        result = 31 * result + screenWidthDp;
        result = 31 * result + screenHeightDp;
        result = 31 * result + smallestScreenWidthDp;
        return result;
    }
}
