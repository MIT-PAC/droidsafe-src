package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
    public static final Parcelable.Creator<Configuration> CREATOR = new Parcelable.Creator<Configuration>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.343 -0400", hash_original_method = "B7AE2BD29BA06D5FD96DDCD2F4FC8C3D", hash_generated_method = "4C05CF0E6FC72437EF02AF30B8AC982E")
        @DSModeled(DSC.SAFE)
        public Configuration createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (Configuration)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Configuration(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.343 -0400", hash_original_method = "F7FE751AFE79D12D181783FF7A577854", hash_generated_method = "A578EC2B22F6AF088C2198E765456B6B")
        @DSModeled(DSC.SAFE)
        public Configuration[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Configuration[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Configuration[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.343 -0400", hash_original_method = "7E58BC7E066573DB3913F9DCCD9EE638", hash_generated_method = "9078F05F8E6245D47DAB0E7A1676E545")
    @DSModeled(DSC.SAFE)
    public Configuration() {
        setToDefaults();
        // ---------- Original Method ----------
        //setToDefaults();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.343 -0400", hash_original_method = "152BBD78ACB87D16BE4EC07F107E0DF8", hash_generated_method = "DE8C5700F1E6DEE33A6DD7378C0229AF")
    @DSModeled(DSC.SAFE)
    public Configuration(Configuration o) {
        dsTaint.addTaint(o.dsTaint);
        setTo(o);
        // ---------- Original Method ----------
        //setTo(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.344 -0400", hash_original_method = "8A45855DAEA6DBD5399558BF539AE2C5", hash_generated_method = "87E402074B479F69A72A862B91F67A8A")
    @DSModeled(DSC.SAFE)
    private Configuration(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        readFromParcel(source);
        // ---------- Original Method ----------
        //readFromParcel(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.344 -0400", hash_original_method = "7CF138C6ADBDA7579D8D5CA6B783C43E", hash_generated_method = "D43D31B557D745C0ACD87D85E93D405E")
    @DSModeled(DSC.SAFE)
    public boolean isLayoutSizeAtLeast(int size) {
        dsTaint.addTaint(size);
        int cur;
        cur = screenLayout&SCREENLAYOUT_SIZE_MASK;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int cur = screenLayout&SCREENLAYOUT_SIZE_MASK;
        //if (cur == SCREENLAYOUT_SIZE_UNDEFINED) return false;
        //return cur >= size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.344 -0400", hash_original_method = "0746F8F2DFB5C09A503AAF70E445D6DB", hash_generated_method = "F4C5EBFE6DF52812F61412CD664DFB62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTo(Configuration o) {
        dsTaint.addTaint(o.dsTaint);
        fontScale = o.fontScale;
        mcc = o.mcc;
        mnc = o.mnc;
        {
            locale = (Locale) o.locale.clone();
            textLayoutDirection = o.textLayoutDirection;
        } //End block
        userSetLocale = o.userSetLocale;
        touchscreen = o.touchscreen;
        keyboard = o.keyboard;
        keyboardHidden = o.keyboardHidden;
        hardKeyboardHidden = o.hardKeyboardHidden;
        navigation = o.navigation;
        navigationHidden = o.navigationHidden;
        orientation = o.orientation;
        screenLayout = o.screenLayout;
        uiMode = o.uiMode;
        screenWidthDp = o.screenWidthDp;
        screenHeightDp = o.screenHeightDp;
        smallestScreenWidthDp = o.smallestScreenWidthDp;
        compatScreenWidthDp = o.compatScreenWidthDp;
        compatScreenHeightDp = o.compatScreenHeightDp;
        compatSmallestScreenWidthDp = o.compatSmallestScreenWidthDp;
        seq = o.seq;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.345 -0400", hash_original_method = "D48CF32F0604807A2B9F35AE6E9C5375", hash_generated_method = "D062D026C90A09B60963BD09C8D0FDEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("{");
        sb.append(fontScale);
        sb.append(" ");
        sb.append(mcc);
        sb.append("mcc");
        sb.append(mnc);
        sb.append("mnc");
        {
            sb.append(" ");
            sb.append(locale);
        } //End block
        {
            sb.append(" (no locale)");
        } //End block
        //Begin case LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE 
        sb.append(" rtl");
        //End case LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE 
        //Begin case default 
        sb.append(" layoutdir=");
        //End case default 
        //Begin case default 
        sb.append(textLayoutDirection);
        //End case default 
        {
            sb.append(" sw");
            sb.append(smallestScreenWidthDp);
            sb.append("dp");
        } //End block
        {
            sb.append(" ?swdp");
        } //End block
        {
            sb.append(" w");
            sb.append(screenWidthDp);
            sb.append("dp");
        } //End block
        {
            sb.append(" ?wdp");
        } //End block
        {
            sb.append(" h");
            sb.append(screenHeightDp);
            sb.append("dp");
        } //End block
        {
            sb.append(" ?hdp");
        } //End block
        //Begin case SCREENLAYOUT_SIZE_UNDEFINED 
        sb.append(" ?lsize");
        //End case SCREENLAYOUT_SIZE_UNDEFINED 
        //Begin case SCREENLAYOUT_SIZE_SMALL 
        sb.append(" smll");
        //End case SCREENLAYOUT_SIZE_SMALL 
        //Begin case SCREENLAYOUT_SIZE_NORMAL 
        sb.append(" nrml");
        //End case SCREENLAYOUT_SIZE_NORMAL 
        //Begin case SCREENLAYOUT_SIZE_LARGE 
        sb.append(" lrg");
        //End case SCREENLAYOUT_SIZE_LARGE 
        //Begin case SCREENLAYOUT_SIZE_XLARGE 
        sb.append(" xlrg");
        //End case SCREENLAYOUT_SIZE_XLARGE 
        //Begin case default 
        sb.append(" layoutSize=");
        //End case default 
        //Begin case default 
        sb.append(screenLayout&SCREENLAYOUT_SIZE_MASK);
        //End case default 
        //Begin case SCREENLAYOUT_LONG_UNDEFINED 
        sb.append(" ?long");
        //End case SCREENLAYOUT_LONG_UNDEFINED 
        //Begin case SCREENLAYOUT_LONG_YES 
        sb.append(" long");
        //End case SCREENLAYOUT_LONG_YES 
        //Begin case default 
        sb.append(" layoutLong=");
        //End case default 
        //Begin case default 
        sb.append(screenLayout&SCREENLAYOUT_LONG_MASK);
        //End case default 
        //Begin case ORIENTATION_UNDEFINED 
        sb.append(" ?orien");
        //End case ORIENTATION_UNDEFINED 
        //Begin case ORIENTATION_LANDSCAPE 
        sb.append(" land");
        //End case ORIENTATION_LANDSCAPE 
        //Begin case ORIENTATION_PORTRAIT 
        sb.append(" port");
        //End case ORIENTATION_PORTRAIT 
        //Begin case default 
        sb.append(" orien=");
        //End case default 
        //Begin case default 
        sb.append(orientation);
        //End case default 
        //Begin case UI_MODE_TYPE_UNDEFINED 
        sb.append(" ?uimode");
        //End case UI_MODE_TYPE_UNDEFINED 
        //Begin case UI_MODE_TYPE_DESK 
        sb.append(" desk");
        //End case UI_MODE_TYPE_DESK 
        //Begin case UI_MODE_TYPE_CAR 
        sb.append(" car");
        //End case UI_MODE_TYPE_CAR 
        //Begin case UI_MODE_TYPE_TELEVISION 
        sb.append(" television");
        //End case UI_MODE_TYPE_TELEVISION 
        //Begin case default 
        sb.append(" uimode=");
        //End case default 
        //Begin case default 
        sb.append(uiMode&UI_MODE_TYPE_MASK);
        //End case default 
        //Begin case UI_MODE_NIGHT_UNDEFINED 
        sb.append(" ?night");
        //End case UI_MODE_NIGHT_UNDEFINED 
        //Begin case UI_MODE_NIGHT_YES 
        sb.append(" night");
        //End case UI_MODE_NIGHT_YES 
        //Begin case default 
        sb.append(" night=");
        //End case default 
        //Begin case default 
        sb.append(uiMode&UI_MODE_NIGHT_MASK);
        //End case default 
        //Begin case TOUCHSCREEN_UNDEFINED 
        sb.append(" ?touch");
        //End case TOUCHSCREEN_UNDEFINED 
        //Begin case TOUCHSCREEN_NOTOUCH 
        sb.append(" -touch");
        //End case TOUCHSCREEN_NOTOUCH 
        //Begin case TOUCHSCREEN_STYLUS 
        sb.append(" stylus");
        //End case TOUCHSCREEN_STYLUS 
        //Begin case TOUCHSCREEN_FINGER 
        sb.append(" finger");
        //End case TOUCHSCREEN_FINGER 
        //Begin case default 
        sb.append(" touch=");
        //End case default 
        //Begin case default 
        sb.append(touchscreen);
        //End case default 
        //Begin case KEYBOARD_UNDEFINED 
        sb.append(" ?keyb");
        //End case KEYBOARD_UNDEFINED 
        //Begin case KEYBOARD_NOKEYS 
        sb.append(" -keyb");
        //End case KEYBOARD_NOKEYS 
        //Begin case KEYBOARD_QWERTY 
        sb.append(" qwerty");
        //End case KEYBOARD_QWERTY 
        //Begin case KEYBOARD_12KEY 
        sb.append(" 12key");
        //End case KEYBOARD_12KEY 
        //Begin case default 
        sb.append(" keys=");
        //End case default 
        //Begin case default 
        sb.append(keyboard);
        //End case default 
        //Begin case KEYBOARDHIDDEN_UNDEFINED 
        sb.append("/?");
        //End case KEYBOARDHIDDEN_UNDEFINED 
        //Begin case KEYBOARDHIDDEN_NO 
        sb.append("/v");
        //End case KEYBOARDHIDDEN_NO 
        //Begin case KEYBOARDHIDDEN_YES 
        sb.append("/h");
        //End case KEYBOARDHIDDEN_YES 
        //Begin case KEYBOARDHIDDEN_SOFT 
        sb.append("/s");
        //End case KEYBOARDHIDDEN_SOFT 
        //Begin case default 
        sb.append("/");
        //End case default 
        //Begin case default 
        sb.append(keyboardHidden);
        //End case default 
        //Begin case HARDKEYBOARDHIDDEN_UNDEFINED 
        sb.append("/?");
        //End case HARDKEYBOARDHIDDEN_UNDEFINED 
        //Begin case HARDKEYBOARDHIDDEN_NO 
        sb.append("/v");
        //End case HARDKEYBOARDHIDDEN_NO 
        //Begin case HARDKEYBOARDHIDDEN_YES 
        sb.append("/h");
        //End case HARDKEYBOARDHIDDEN_YES 
        //Begin case default 
        sb.append("/");
        //End case default 
        //Begin case default 
        sb.append(hardKeyboardHidden);
        //End case default 
        //Begin case NAVIGATION_UNDEFINED 
        sb.append(" ?nav");
        //End case NAVIGATION_UNDEFINED 
        //Begin case NAVIGATION_NONAV 
        sb.append(" -nav");
        //End case NAVIGATION_NONAV 
        //Begin case NAVIGATION_DPAD 
        sb.append(" dpad");
        //End case NAVIGATION_DPAD 
        //Begin case NAVIGATION_TRACKBALL 
        sb.append(" tball");
        //End case NAVIGATION_TRACKBALL 
        //Begin case NAVIGATION_WHEEL 
        sb.append(" wheel");
        //End case NAVIGATION_WHEEL 
        //Begin case default 
        sb.append(" nav=");
        //End case default 
        //Begin case default 
        sb.append(navigation);
        //End case default 
        //Begin case NAVIGATIONHIDDEN_UNDEFINED 
        sb.append("/?");
        //End case NAVIGATIONHIDDEN_UNDEFINED 
        //Begin case NAVIGATIONHIDDEN_NO 
        sb.append("/v");
        //End case NAVIGATIONHIDDEN_NO 
        //Begin case NAVIGATIONHIDDEN_YES 
        sb.append("/h");
        //End case NAVIGATIONHIDDEN_YES 
        //Begin case default 
        sb.append("/");
        //End case default 
        //Begin case default 
        sb.append(navigationHidden);
        //End case default 
        {
            sb.append(" s.");
            sb.append(seq);
        } //End block
        sb.append('}');
        String var806458D832AB974D230FEE4CBBDBD390_1145301908 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.346 -0400", hash_original_method = "147ACC888212AB34BF4DFBA0C89EE45F", hash_generated_method = "0BBCD4786F96CECC46B436A414598828")
    @DSModeled(DSC.SAFE)
    public void setToDefaults() {
        fontScale = 1;
        mcc = mnc = 0;
        locale = null;
        userSetLocale = false;
        touchscreen = TOUCHSCREEN_UNDEFINED;
        keyboard = KEYBOARD_UNDEFINED;
        keyboardHidden = KEYBOARDHIDDEN_UNDEFINED;
        hardKeyboardHidden = HARDKEYBOARDHIDDEN_UNDEFINED;
        navigation = NAVIGATION_UNDEFINED;
        navigationHidden = NAVIGATIONHIDDEN_UNDEFINED;
        orientation = ORIENTATION_UNDEFINED;
        screenLayout = SCREENLAYOUT_SIZE_UNDEFINED;
        uiMode = UI_MODE_TYPE_UNDEFINED;
        screenWidthDp = compatScreenWidthDp = SCREEN_WIDTH_DP_UNDEFINED;
        screenHeightDp = compatScreenHeightDp = SCREEN_HEIGHT_DP_UNDEFINED;
        smallestScreenWidthDp = compatSmallestScreenWidthDp = SMALLEST_SCREEN_WIDTH_DP_UNDEFINED;
        textLayoutDirection = LocaleUtil.TEXT_LAYOUT_DIRECTION_LTR_DO_NOT_USE;
        seq = 0;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.346 -0400", hash_original_method = "7A9BC90479DED562CC828BA992C8D29B", hash_generated_method = "ADDF94EA72464C8008CF7034A20B1DDF")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void makeDefault() {
        setToDefaults();
        // ---------- Original Method ----------
        //setToDefaults();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.347 -0400", hash_original_method = "B89305EEF1411ADF7E3555A325399492", hash_generated_method = "73E560C8CFDED66D0123F02894B16AF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int updateFrom(Configuration delta) {
        dsTaint.addTaint(delta.dsTaint);
        int changed;
        changed = 0;
        {
            changed |= ActivityInfo.CONFIG_FONT_SCALE;
            fontScale = delta.fontScale;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_MCC;
            mcc = delta.mcc;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_MNC;
            mnc = delta.mnc;
        } //End block
        {
            boolean var4196EA4334D61313D1945CBA952C7DCB_1105437277 = (delta.locale != null
                && (locale == null || !locale.equals(delta.locale)));
            {
                changed |= ActivityInfo.CONFIG_LOCALE;
                locale = delta.locale != null
                    ? (Locale) delta.locale.clone() : null;
                textLayoutDirection = LocaleUtil.getLayoutDirectionFromLocale(locale);
            } //End block
        } //End collapsed parenthetic
        {
            userSetLocale = true;
            changed |= ActivityInfo.CONFIG_LOCALE;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_TOUCHSCREEN;
            touchscreen = delta.touchscreen;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_KEYBOARD;
            keyboard = delta.keyboard;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
            keyboardHidden = delta.keyboardHidden;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
            hardKeyboardHidden = delta.hardKeyboardHidden;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_NAVIGATION;
            navigation = delta.navigation;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
            navigationHidden = delta.navigationHidden;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_ORIENTATION;
            orientation = delta.orientation;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_SCREEN_LAYOUT;
            screenLayout = delta.screenLayout;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_UI_MODE;
            {
                uiMode = (uiMode&~UI_MODE_TYPE_MASK)
                        | (delta.uiMode&UI_MODE_TYPE_MASK);
            } //End block
            {
                uiMode = (uiMode&~UI_MODE_NIGHT_MASK)
                        | (delta.uiMode&UI_MODE_NIGHT_MASK);
            } //End block
        } //End block
        {
            changed |= ActivityInfo.CONFIG_SCREEN_SIZE;
            screenWidthDp = delta.screenWidthDp;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_SCREEN_SIZE;
            screenHeightDp = delta.screenHeightDp;
        } //End block
        {
            smallestScreenWidthDp = delta.smallestScreenWidthDp;
        } //End block
        {
            compatScreenWidthDp = delta.compatScreenWidthDp;
        } //End block
        {
            compatScreenHeightDp = delta.compatScreenHeightDp;
        } //End block
        {
            compatSmallestScreenWidthDp = delta.compatSmallestScreenWidthDp;
        } //End block
        {
            seq = delta.seq;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.348 -0400", hash_original_method = "386D1A4CE5F28E1920F878E4D6E46D78", hash_generated_method = "67FAC7478C6160A09D4C55C1FF458DE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int diff(Configuration delta) {
        dsTaint.addTaint(delta.dsTaint);
        int changed;
        changed = 0;
        {
            changed |= ActivityInfo.CONFIG_FONT_SCALE;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_MCC;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_MNC;
        } //End block
        {
            boolean var4196EA4334D61313D1945CBA952C7DCB_441845323 = (delta.locale != null
                && (locale == null || !locale.equals(delta.locale)));
            {
                changed |= ActivityInfo.CONFIG_LOCALE;
            } //End block
        } //End collapsed parenthetic
        {
            changed |= ActivityInfo.CONFIG_TOUCHSCREEN;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_KEYBOARD;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_NAVIGATION;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_ORIENTATION;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_SCREEN_LAYOUT;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_UI_MODE;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_SCREEN_SIZE;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_SCREEN_SIZE;
        } //End block
        {
            changed |= ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.348 -0400", hash_original_method = "C1EC99295C60E8CDF33A346200304D0A", hash_generated_method = "12670E839438D361F4B14561A2A8FD66")
    public static boolean needNewResources(int configChanges, int interestingChanges) {
        return (configChanges & (interestingChanges|ActivityInfo.CONFIG_FONT_SCALE)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.349 -0400", hash_original_method = "B2BFCC713F7EA940A38F0F416218BA87", hash_generated_method = "DDFA45FF813BA1A9FF9F4B3E137B8D8C")
    @DSModeled(DSC.SAFE)
    public boolean isOtherSeqNewer(Configuration other) {
        dsTaint.addTaint(other.dsTaint);
        int diff;
        diff = other.seq - seq;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other == null) {
            //return false;
        //}
        //if (other.seq == 0) {
            //return true;
        //}
        //if (seq == 0) {
            //return true;
        //}
        //int diff = other.seq - seq;
        //if (diff > 0x10000) {
            //return false;
        //}
        //return diff > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.349 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.349 -0400", hash_original_method = "1BC6CD0BF36648989C04BB1E69C07CD0", hash_generated_method = "8831B4413E30AF0EA71009C834230674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeFloat(fontScale);
        dest.writeInt(mcc);
        dest.writeInt(mnc);
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            dest.writeString(locale.getLanguage());
            dest.writeString(locale.getCountry());
            dest.writeString(locale.getVariant());
        } //End block
        {
            dest.writeInt(1);
        } //End block
        {
            dest.writeInt(0);
        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.350 -0400", hash_original_method = "D035835FD349CA35BBAA1421EFF90B4A", hash_generated_method = "9025CF01DA255D6433DC4A4CB4C91F12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        fontScale = source.readFloat();
        mcc = source.readInt();
        mnc = source.readInt();
        {
            boolean varFD16828A378FD83700BE97539951F787_1057003478 = (source.readInt() != 0);
            {
                locale = new Locale(source.readString(), source.readString(),
                    source.readString());
            } //End block
        } //End collapsed parenthetic
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.350 -0400", hash_original_method = "A5C14F26D7300C5E96037FF80E52AAB2", hash_generated_method = "4331B44C1C1C12D2A5845F67BEDED2C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Configuration that) {
        dsTaint.addTaint(that.dsTaint);
        int n;
        float a;
        a = this.fontScale;
        float b;
        b = that.fontScale;
        n = this.mcc - that.mcc;
        n = this.mnc - that.mnc;
        {
            n = this.locale.getLanguage().compareTo(that.locale.getLanguage());
            n = this.locale.getCountry().compareTo(that.locale.getCountry());
            n = this.locale.getVariant().compareTo(that.locale.getVariant());
        } //End block
        n = this.touchscreen - that.touchscreen;
        n = this.keyboard - that.keyboard;
        n = this.keyboardHidden - that.keyboardHidden;
        n = this.hardKeyboardHidden - that.hardKeyboardHidden;
        n = this.navigation - that.navigation;
        n = this.navigationHidden - that.navigationHidden;
        n = this.orientation - that.orientation;
        n = this.screenLayout - that.screenLayout;
        n = this.uiMode - that.uiMode;
        n = this.screenWidthDp - that.screenWidthDp;
        n = this.screenHeightDp - that.screenHeightDp;
        n = this.smallestScreenWidthDp - that.smallestScreenWidthDp;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.351 -0400", hash_original_method = "7EC3698B1B9649830BA1D150A7700ABF", hash_generated_method = "321ED79210747A271C64FD4BB4CA6C44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Configuration that) {
        dsTaint.addTaint(that.dsTaint);
        boolean var41C2CBFC55263D1C5596E781F8311FC6_1712116877 = (this.compareTo(that) == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (that == null) return false;
        //if (that == this) return true;
        //return this.compareTo(that) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.351 -0400", hash_original_method = "EE31E2EDAF6F402A909910F793361153", hash_generated_method = "79735E002919CD191768A4FB04AEA95E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object that) {
        dsTaint.addTaint(that.dsTaint);
        try 
        {
            boolean varD7DC298F5093D437BB12478685AA37AB_512886447 = (equals((Configuration)that));
        } //End block
        catch (ClassCastException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return equals((Configuration)that);
        //} catch (ClassCastException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.351 -0400", hash_original_method = "046D4D394490FA85ED827B86F99F4B68", hash_generated_method = "236F33CED7CAA218F14A41E8B8CE4B5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int result;
        result = 17;
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + Float.floatToIntBits(fontScale);
        //result = 31 * result + mcc;
        //result = 31 * result + mnc;
        //result = 31 * result + (locale != null ? locale.hashCode() : 0);
        //result = 31 * result + touchscreen;
        //result = 31 * result + keyboard;
        //result = 31 * result + keyboardHidden;
        //result = 31 * result + hardKeyboardHidden;
        //result = 31 * result + navigation;
        //result = 31 * result + navigationHidden;
        //result = 31 * result + orientation;
        //result = 31 * result + screenLayout;
        //result = 31 * result + uiMode;
        //result = 31 * result + screenWidthDp;
        //result = 31 * result + screenHeightDp;
        //result = 31 * result + smallestScreenWidthDp;
        //return result;
    }

    
}


