package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public final class InputMethodSubtype implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.425 -0400", hash_original_field = "6B887E31A4611BC8CDB502D82236E7C6", hash_generated_field = "F8E8FA3061A103026C8298FB0F2648C7")

    private boolean mIsAuxiliary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.425 -0400", hash_original_field = "7F4C5EF5B1AF9A5A5C64C38289E3E3D3", hash_generated_field = "DF7B3D7F7849CD65A841EA756702E121")

    private boolean mOverridesImplicitlyEnabledSubtype;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.425 -0400", hash_original_field = "DB752714D7C5597F6D4538948E3D4382", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private int mSubtypeHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.425 -0400", hash_original_field = "E9CD3C1A08E60FD7C92E17FBDC1E9760", hash_generated_field = "C71D1FA43E13CD3282734DF2FF4408D8")

    private int mSubtypeIconResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.425 -0400", hash_original_field = "AE10E74C5B8FF193877E0EC967173BB0", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private int mSubtypeNameResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.425 -0400", hash_original_field = "62668E4A833F1CB4D52D80EE2676B489", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private String mSubtypeLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.425 -0400", hash_original_field = "33DCA0E766F52A803A4F474963A0D82D", hash_generated_field = "7ABE6DC269EBBCEC11D7611039EEBED9")

    private String mSubtypeMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.425 -0400", hash_original_field = "925770EC9378B8FB525692C9358CB66A", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private String mSubtypeExtraValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.425 -0400", hash_original_field = "3A7DFD37BBDDEB49979A0E51410BD10A", hash_generated_field = "ACB3C4EDF6306DA058D6D16426E9E9E7")

    private HashMap<String, String> mExtraValueHashMapCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.431 -0400", hash_original_method = "934D77263F2647B2A011D3A69C057C66", hash_generated_method = "A1C313608E5C8C95CC2FC190A61A2D0C")
    public  InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue,
            boolean isAuxiliary) {
        this(nameId, iconId, locale, mode, extraValue, isAuxiliary, false);
        addTaint(nameId);
        addTaint(iconId);
        addTaint(locale.getTaint());
        addTaint(mode.getTaint());
        addTaint(extraValue.getTaint());
        addTaint(isAuxiliary);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.431 -0400", hash_original_method = "26B76F41AAAA7EE2514381E3013D5A81", hash_generated_method = "E31B6D25CAAA843FDBFE6094AACFCEC0")
    public  InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue,
            boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype) {
        mSubtypeNameResId = nameId;
        mSubtypeIconResId = iconId;
        mSubtypeLocale = locale != null ? locale : "";
        mSubtypeMode = mode != null ? mode : "";
        mSubtypeExtraValue = extraValue != null ? extraValue : "";
        mIsAuxiliary = isAuxiliary;
        mOverridesImplicitlyEnabledSubtype = overridesImplicitlyEnabledSubtype;
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeMode, mSubtypeExtraValue,
                mIsAuxiliary, mOverridesImplicitlyEnabledSubtype);
        // ---------- Original Method ----------
        //mSubtypeNameResId = nameId;
        //mSubtypeIconResId = iconId;
        //mSubtypeLocale = locale != null ? locale : "";
        //mSubtypeMode = mode != null ? mode : "";
        //mSubtypeExtraValue = extraValue != null ? extraValue : "";
        //mIsAuxiliary = isAuxiliary;
        //mOverridesImplicitlyEnabledSubtype = overridesImplicitlyEnabledSubtype;
        //mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeMode, mSubtypeExtraValue,
                //mIsAuxiliary, mOverridesImplicitlyEnabledSubtype);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.440 -0400", hash_original_method = "D71F12C4764A764AF688AE6184DB2ED2", hash_generated_method = "ACF11529AB7DB787C152AB2F8CF531D9")
      InputMethodSubtype(Parcel source) {
        String s;
        mSubtypeNameResId = source.readInt();
        mSubtypeIconResId = source.readInt();
        s = source.readString();
        mSubtypeLocale = s != null ? s : "";
        s = source.readString();
        mSubtypeMode = s != null ? s : "";
        s = source.readString();
        mSubtypeExtraValue = s != null ? s : "";
        mIsAuxiliary = (source.readInt() == 1);
        mOverridesImplicitlyEnabledSubtype = (source.readInt() == 1);
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeMode, mSubtypeExtraValue,
                mIsAuxiliary, mOverridesImplicitlyEnabledSubtype);
        // ---------- Original Method ----------
        //String s;
        //mSubtypeNameResId = source.readInt();
        //mSubtypeIconResId = source.readInt();
        //s = source.readString();
        //mSubtypeLocale = s != null ? s : "";
        //s = source.readString();
        //mSubtypeMode = s != null ? s : "";
        //s = source.readString();
        //mSubtypeExtraValue = s != null ? s : "";
        //mIsAuxiliary = (source.readInt() == 1);
        //mOverridesImplicitlyEnabledSubtype = (source.readInt() == 1);
        //mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeMode, mSubtypeExtraValue,
                //mIsAuxiliary, mOverridesImplicitlyEnabledSubtype);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.441 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "C49C7C0C296A801DCEB3B3AC5C52604D")
    public int getNameResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495295043 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495295043;
        // ---------- Original Method ----------
        //return mSubtypeNameResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.441 -0400", hash_original_method = "6A7C5EEB38C0091C7A516BA3C0FACD8B", hash_generated_method = "8A3CC6043FF953BE818604E9CD134FA4")
    public int getIconResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883913393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883913393;
        // ---------- Original Method ----------
        //return mSubtypeIconResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.441 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "CB2BBA7CA922FB64E3E636C59CD7F4FB")
    public String getLocale() {
        String varB4EAC82CA7396A68D541C85D26508E83_680470435 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_680470435 = mSubtypeLocale;
        varB4EAC82CA7396A68D541C85D26508E83_680470435.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680470435;
        // ---------- Original Method ----------
        //return mSubtypeLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.442 -0400", hash_original_method = "960AAB243B4CAAAE714C0B1CB581C452", hash_generated_method = "5F5C67745CC3571871446F2727DEF8FB")
    public String getMode() {
        String varB4EAC82CA7396A68D541C85D26508E83_2024918254 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2024918254 = mSubtypeMode;
        varB4EAC82CA7396A68D541C85D26508E83_2024918254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2024918254;
        // ---------- Original Method ----------
        //return mSubtypeMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.442 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "863DF2B38A319A3E0CBFF3E0907D313E")
    public String getExtraValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_347908995 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_347908995 = mSubtypeExtraValue;
        varB4EAC82CA7396A68D541C85D26508E83_347908995.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_347908995;
        // ---------- Original Method ----------
        //return mSubtypeExtraValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.445 -0400", hash_original_method = "5D42329342BA940BF0C680758D792174", hash_generated_method = "9966E9C56986430C07D49F730DDC8D1C")
    public boolean isAuxiliary() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1585329704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1585329704;
        // ---------- Original Method ----------
        //return mIsAuxiliary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.446 -0400", hash_original_method = "77DDEB2A23977DBB23EB90699D4CDB8E", hash_generated_method = "7C3E0C8D4E5989872E5963E621FBF500")
    public boolean overridesImplicitlyEnabledSubtype() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500464859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500464859;
        // ---------- Original Method ----------
        //return mOverridesImplicitlyEnabledSubtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.459 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "7018D352CBC78C886808687EC4CA3FD6")
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1826812075 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1465406308 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1857341850 = null; //Variable for return #3
        Locale locale;
        locale = constructLocaleFromString(mSubtypeLocale);
        String localeStr;
        localeStr = locale.getDisplayName();
        localeStr = mSubtypeLocale;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1826812075 = localeStr;
        } //End block
        CharSequence subtypeName;
        subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        {
            boolean var8CAF5C55CF3F150CA75A24E410BC500C_985736632 = (!TextUtils.isEmpty(subtypeName));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1465406308 = String.format(subtypeName.toString(), localeStr);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1857341850 = localeStr;
            } //End block
        } //End collapsed parenthetic
        addTaint(context.getTaint());
        addTaint(packageName.getTaint());
        addTaint(appInfo.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1440133035; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1440133035 = varB4EAC82CA7396A68D541C85D26508E83_1826812075;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1440133035 = varB4EAC82CA7396A68D541C85D26508E83_1465406308;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1440133035 = varB4EAC82CA7396A68D541C85D26508E83_1857341850;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1440133035.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1440133035;
        // ---------- Original Method ----------
        //final Locale locale = constructLocaleFromString(mSubtypeLocale);
        //final String localeStr = locale != null ? locale.getDisplayName() : mSubtypeLocale;
        //if (mSubtypeNameResId == 0) {
            //return localeStr;
        //}
        //final CharSequence subtypeName = context.getPackageManager().getText(
                //packageName, mSubtypeNameResId, appInfo);
        //if (!TextUtils.isEmpty(subtypeName)) {
            //return String.format(subtypeName.toString(), localeStr);
        //} else {
            //return localeStr;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.461 -0400", hash_original_method = "2837AE7076837B91930C208632EE903B", hash_generated_method = "D99F0AD6200A53EE82B1B64D2CE385A2")
    private HashMap<String, String> getExtraValueHashMap() {
        HashMap<String, String> varB4EAC82CA7396A68D541C85D26508E83_558245375 = null; //Variable for return #1
        {
            mExtraValueHashMapCache = new HashMap<String, String>();
            String[] pairs;
            pairs = mSubtypeExtraValue.split(EXTRA_VALUE_PAIR_SEPARATOR);
            int N;
            N = pairs.length;
            {
                int i;
                i = 0;
                {
                    String[] pair;
                    pair = pairs[i].split(EXTRA_VALUE_KEY_VALUE_SEPARATOR);
                    {
                        mExtraValueHashMapCache.put(pair[0], null);
                    } //End block
                    {
                        mExtraValueHashMapCache.put(pair[0], pair[1]);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_558245375 = mExtraValueHashMapCache;
        varB4EAC82CA7396A68D541C85D26508E83_558245375.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_558245375;
        // ---------- Original Method ----------
        //if (mExtraValueHashMapCache == null) {
            //mExtraValueHashMapCache = new HashMap<String, String>();
            //final String[] pairs = mSubtypeExtraValue.split(EXTRA_VALUE_PAIR_SEPARATOR);
            //final int N = pairs.length;
            //for (int i = 0; i < N; ++i) {
                //final String[] pair = pairs[i].split(EXTRA_VALUE_KEY_VALUE_SEPARATOR);
                //if (pair.length == 1) {
                    //mExtraValueHashMapCache.put(pair[0], null);
                //} else if (pair.length > 1) {
                    //if (pair.length > 2) {
                        //Slog.w(TAG, "ExtraValue has two or more '='s");
                    //}
                    //mExtraValueHashMapCache.put(pair[0], pair[1]);
                //}
            //}
        //}
        //return mExtraValueHashMapCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.461 -0400", hash_original_method = "92E492941FA288BA531CB37717D8F415", hash_generated_method = "EDA0FEAD2732EF2B04C2AA2B21C95027")
    public boolean containsExtraValueKey(String key) {
        boolean var879F87ED6CB8D534D2470D87EF542CAF_11562158 = (getExtraValueHashMap().containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895111474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_895111474;
        // ---------- Original Method ----------
        //return getExtraValueHashMap().containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.462 -0400", hash_original_method = "E26D6519ACBB2E66A4CA57F07B1B4B16", hash_generated_method = "EE828C0C725B38E1194E7F61DE75DDD2")
    public String getExtraValueOf(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1474920255 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1474920255 = getExtraValueHashMap().get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1474920255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1474920255;
        // ---------- Original Method ----------
        //return getExtraValueHashMap().get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.462 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "773D5F227A1995F2A95A8004AFBA50D1")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375048001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375048001;
        // ---------- Original Method ----------
        //return mSubtypeHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.464 -0400", hash_original_method = "0FAD58BA0D22A8990D6C7F18B4CA40E4", hash_generated_method = "17D5740855143997B0949E32ED052753")
    @Override
    public boolean equals(Object o) {
        {
            InputMethodSubtype subtype;
            subtype = (InputMethodSubtype) o;
            boolean varEEE5801028341F2EB0F803658C2232D1_1874209434 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getMode().equals(getMode()))
                && (subtype.getIconResId() == getIconResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue()))
                && (subtype.isAuxiliary() == isAuxiliary()));
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179425158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179425158;
        // ---------- Original Method ----------
        //if (o instanceof InputMethodSubtype) {
            //InputMethodSubtype subtype = (InputMethodSubtype) o;
            //return (subtype.hashCode() == hashCode())
                //&& (subtype.getNameResId() == getNameResId())
                //&& (subtype.getMode().equals(getMode()))
                //&& (subtype.getIconResId() == getIconResId())
                //&& (subtype.getLocale().equals(getLocale()))
                //&& (subtype.getExtraValue().equals(getExtraValue()))
                //&& (subtype.isAuxiliary() == isAuxiliary());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.476 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ECF9B5A7F93CF2EFC04A2DC6F7A8C577")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499411717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499411717;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.477 -0400", hash_original_method = "C419DC818714EC441C397D1AF0BAA00C", hash_generated_method = "4DF859947683BD28549093E3BA115743")
    @Override
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeInt(mSubtypeNameResId);
        dest.writeInt(mSubtypeIconResId);
        dest.writeString(mSubtypeLocale);
        dest.writeString(mSubtypeMode);
        dest.writeString(mSubtypeExtraValue);
        dest.writeInt(mIsAuxiliary ? 1 : 0);
        dest.writeInt(mOverridesImplicitlyEnabledSubtype ? 1 : 0);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //dest.writeInt(mSubtypeNameResId);
        //dest.writeInt(mSubtypeIconResId);
        //dest.writeString(mSubtypeLocale);
        //dest.writeString(mSubtypeMode);
        //dest.writeString(mSubtypeExtraValue);
        //dest.writeInt(mIsAuxiliary ? 1 : 0);
        //dest.writeInt(mOverridesImplicitlyEnabledSubtype ? 1 : 0);
    }

    
        private static Locale constructLocaleFromString(String localeStr) {
        if (TextUtils.isEmpty(localeStr))
            return null;
        String[] localeParams = localeStr.split("_", 3);
        if (localeParams.length == 1) {
            return new Locale(localeParams[0]);
        } else if (localeParams.length == 2) {
            return new Locale(localeParams[0], localeParams[1]);
        } else if (localeParams.length == 3) {
            return new Locale(localeParams[0], localeParams[1], localeParams[2]);
        }
        return null;
    }

    
        private static int hashCodeInternal(String locale, String mode, String extraValue,
            boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype) {
        return Arrays.hashCode(new Object[] {locale, mode, extraValue, isAuxiliary,
                overridesImplicitlyEnabledSubtype});
    }

    
        public static List<InputMethodSubtype> sort(Context context, int flags, InputMethodInfo imi,
            List<InputMethodSubtype> subtypeList) {
        if (imi == null) return subtypeList;
        final HashSet<InputMethodSubtype> inputSubtypesSet = new HashSet<InputMethodSubtype>(
                subtypeList);
        final ArrayList<InputMethodSubtype> sortedList = new ArrayList<InputMethodSubtype>();
        int N = imi.getSubtypeCount();
        for (int i = 0; i < N; ++i) {
            InputMethodSubtype subtype = imi.getSubtypeAt(i);
            if (inputSubtypesSet.contains(subtype)) {
                sortedList.add(subtype);
                inputSubtypesSet.remove(subtype);
            }
        }
        for (InputMethodSubtype subtype: inputSubtypesSet) {
            sortedList.add(subtype);
        }
        return sortedList;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.489 -0400", hash_original_field = "FD70D5B6597BA4E41960E8E543899F2B", hash_generated_field = "46E5A51A75D7FC110C25F64595568BC9")

    private static String TAG = InputMethodSubtype.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.489 -0400", hash_original_field = "DE020776BE334FC0AE5FDE74CF87BE11", hash_generated_field = "34238EAB4D36315585ED09B527DCA605")

    private static String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.489 -0400", hash_original_field = "633819F0CE2FE910B1C0DC1AB3415993", hash_generated_field = "4B59D81114A3CEEA7C6FDE144A27F326")

    private static String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.489 -0400", hash_original_field = "87C3F14D000790670A5C8909273086FE", hash_generated_field = "F6FA24A5E0DEFDBE30BDE6B1502A4BF4")

    public static final Parcelable.Creator<InputMethodSubtype> CREATOR
            = new Parcelable.Creator<InputMethodSubtype>() {
        @Override
        public InputMethodSubtype createFromParcel(Parcel source) {
            return new InputMethodSubtype(source);
        }

        @Override
        public InputMethodSubtype[] newArray(int size) {
            return new InputMethodSubtype[size];
        }
    };
}

