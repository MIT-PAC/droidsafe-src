package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    public int screenLayout;
    public int touchscreen;
    public int keyboard;
    public int keyboardHidden;
    public int hardKeyboardHidden;
    public int navigation;
    public int navigationHidden;
    public int orientation;
    public int uiMode;
    public int screenWidthDp;
    public int screenHeightDp;
    public int smallestScreenWidthDp;
    public int compatScreenWidthDp;
    public int compatScreenHeightDp;
    public int compatSmallestScreenWidthDp;
    public int textLayoutDirection;
    public int seq;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.259 -0400", hash_original_method = "7E58BC7E066573DB3913F9DCCD9EE638", hash_generated_method = "91F3585416146E7055FAB87D152FFB0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Configuration() {
        setToDefaults();
        // ---------- Original Method ----------
        //setToDefaults();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.260 -0400", hash_original_method = "152BBD78ACB87D16BE4EC07F107E0DF8", hash_generated_method = "79E76709EA1FBDEB11AFBFF2A230EC0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Configuration(Configuration o) {
        dsTaint.addTaint(o.dsTaint);
        setTo(o);
        // ---------- Original Method ----------
        //setTo(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.260 -0400", hash_original_method = "8A45855DAEA6DBD5399558BF539AE2C5", hash_generated_method = "1D7D44ECBDD7776B4380D8625DD634E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Configuration(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        readFromParcel(source);
        // ---------- Original Method ----------
        //readFromParcel(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.260 -0400", hash_original_method = "7CF138C6ADBDA7579D8D5CA6B783C43E", hash_generated_method = "3CF15574DD043DD4D082255B6F3E6B24")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.261 -0400", hash_original_method = "0746F8F2DFB5C09A503AAF70E445D6DB", hash_generated_method = "63827422F90FAA78635F4D4F523F6817")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.262 -0400", hash_original_method = "D48CF32F0604807A2B9F35AE6E9C5375", hash_generated_method = "A3B17DE6DC5279FF3919AB7B1E1BD5F1")
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
        String var806458D832AB974D230FEE4CBBDBD390_798228683 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.263 -0400", hash_original_method = "147ACC888212AB34BF4DFBA0C89EE45F", hash_generated_method = "C9CB6755A580929C7AAF213990A1EEFA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.263 -0400", hash_original_method = "7A9BC90479DED562CC828BA992C8D29B", hash_generated_method = "F4925C1856E621330FA07AC8612E16F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void makeDefault() {
        setToDefaults();
        // ---------- Original Method ----------
        //setToDefaults();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.265 -0400", hash_original_method = "B89305EEF1411ADF7E3555A325399492", hash_generated_method = "A671277B67AEC0FBBFF614C0B3AD7D7A")
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
            boolean var4196EA4334D61313D1945CBA952C7DCB_979089115 = (delta.locale != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.266 -0400", hash_original_method = "386D1A4CE5F28E1920F878E4D6E46D78", hash_generated_method = "3D345519C25734D0E3F889674E872077")
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
            boolean var4196EA4334D61313D1945CBA952C7DCB_51212107 = (delta.locale != null
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

    
        public static boolean needNewResources(int configChanges, int interestingChanges) {
        return (configChanges & (interestingChanges|ActivityInfo.CONFIG_FONT_SCALE)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.266 -0400", hash_original_method = "B2BFCC713F7EA940A38F0F416218BA87", hash_generated_method = "C586541F00A8501345E1CDCF30908A46")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.267 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.267 -0400", hash_original_method = "1BC6CD0BF36648989C04BB1E69C07CD0", hash_generated_method = "9E8CC42190B6B639FBCD39328B7B13CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.268 -0400", hash_original_method = "D035835FD349CA35BBAA1421EFF90B4A", hash_generated_method = "F20E4CB5729EEB7E3BC7BE97DEDE7A23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        fontScale = source.readFloat();
        mcc = source.readInt();
        mnc = source.readInt();
        {
            boolean varFD16828A378FD83700BE97539951F787_527560487 = (source.readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.269 -0400", hash_original_method = "A5C14F26D7300C5E96037FF80E52AAB2", hash_generated_method = "65438DCA57CDD32034611EC4EF734F00")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.271 -0400", hash_original_method = "7EC3698B1B9649830BA1D150A7700ABF", hash_generated_method = "31BC3010D8143F5B93514A2C06BAFC93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Configuration that) {
        dsTaint.addTaint(that.dsTaint);
        {
            boolean var264A9522C72B4B1AC5C8FEC213FC9A77_2146428713 = (that == this);
        } //End collapsed parenthetic
        boolean var41C2CBFC55263D1C5596E781F8311FC6_737722615 = (this.compareTo(that) == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (that == null) return false;
        //if (that == this) return true;
        //return this.compareTo(that) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.271 -0400", hash_original_method = "EE31E2EDAF6F402A909910F793361153", hash_generated_method = "DDC4176980BFF108156C6B996511A11B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object that) {
        dsTaint.addTaint(that.dsTaint);
        try 
        {
            boolean varD7DC298F5093D437BB12478685AA37AB_211026443 = (equals((Configuration)that));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.272 -0400", hash_original_method = "046D4D394490FA85ED827B86F99F4B68", hash_generated_method = "3FDE2602D2FD1A71EBE5C6C4263D21D6")
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
    public static final int TOUCHSCREEN_UNDEFINED = 0;
    public static final int TOUCHSCREEN_NOTOUCH = 1;
    public static final int TOUCHSCREEN_STYLUS = 2;
    public static final int TOUCHSCREEN_FINGER = 3;
    public static final int KEYBOARD_UNDEFINED = 0;
    public static final int KEYBOARD_NOKEYS = 1;
    public static final int KEYBOARD_QWERTY = 2;
    public static final int KEYBOARD_12KEY = 3;
    public static final int KEYBOARDHIDDEN_UNDEFINED = 0;
    public static final int KEYBOARDHIDDEN_NO = 1;
    public static final int KEYBOARDHIDDEN_YES = 2;
    public static final int KEYBOARDHIDDEN_SOFT = 3;
    public static final int HARDKEYBOARDHIDDEN_UNDEFINED = 0;
    public static final int HARDKEYBOARDHIDDEN_NO = 1;
    public static final int HARDKEYBOARDHIDDEN_YES = 2;
    public static final int NAVIGATION_UNDEFINED = 0;
    public static final int NAVIGATION_NONAV = 1;
    public static final int NAVIGATION_DPAD = 2;
    public static final int NAVIGATION_TRACKBALL = 3;
    public static final int NAVIGATION_WHEEL = 4;
    public static final int NAVIGATIONHIDDEN_UNDEFINED = 0;
    public static final int NAVIGATIONHIDDEN_NO = 1;
    public static final int NAVIGATIONHIDDEN_YES = 2;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIENTATION_PORTRAIT = 1;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_SQUARE = 3;
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
    public static final int SCREEN_WIDTH_DP_UNDEFINED = 0;
    public static final int SCREEN_HEIGHT_DP_UNDEFINED = 0;
    public static final int SMALLEST_SCREEN_WIDTH_DP_UNDEFINED = 0;
    public static final Parcelable.Creator<Configuration> CREATOR = new Parcelable.Creator<Configuration>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.274 -0400", hash_original_method = "B7AE2BD29BA06D5FD96DDCD2F4FC8C3D", hash_generated_method = "7323FDEAA721686E179AE69DDD428494")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Configuration createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            Configuration var9AC601A6C0AE5B309B645AE53E6C315E_1197997599 = (new Configuration(source));
            return (Configuration)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Configuration(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.274 -0400", hash_original_method = "F7FE751AFE79D12D181783FF7A577854", hash_generated_method = "A4A7A2ECED8C1DCFA36076101051E365")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Configuration[] newArray(int size) {
            dsTaint.addTaint(size);
            Configuration[] var094D483B2FB672CC8B96EECA0F1856B6_238525272 = (new Configuration[size]);
            return (Configuration[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Configuration[size];
        }

        
}; //Transformed anonymous class
}

