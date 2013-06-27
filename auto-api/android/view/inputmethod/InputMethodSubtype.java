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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.266 -0400", hash_original_field = "6B887E31A4611BC8CDB502D82236E7C6", hash_generated_field = "F8E8FA3061A103026C8298FB0F2648C7")

    private boolean mIsAuxiliary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.266 -0400", hash_original_field = "7F4C5EF5B1AF9A5A5C64C38289E3E3D3", hash_generated_field = "DF7B3D7F7849CD65A841EA756702E121")

    private boolean mOverridesImplicitlyEnabledSubtype;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.267 -0400", hash_original_field = "DB752714D7C5597F6D4538948E3D4382", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private int mSubtypeHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.267 -0400", hash_original_field = "E9CD3C1A08E60FD7C92E17FBDC1E9760", hash_generated_field = "C71D1FA43E13CD3282734DF2FF4408D8")

    private int mSubtypeIconResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.267 -0400", hash_original_field = "AE10E74C5B8FF193877E0EC967173BB0", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private int mSubtypeNameResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.267 -0400", hash_original_field = "62668E4A833F1CB4D52D80EE2676B489", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private String mSubtypeLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.267 -0400", hash_original_field = "33DCA0E766F52A803A4F474963A0D82D", hash_generated_field = "7ABE6DC269EBBCEC11D7611039EEBED9")

    private String mSubtypeMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.267 -0400", hash_original_field = "925770EC9378B8FB525692C9358CB66A", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private String mSubtypeExtraValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.267 -0400", hash_original_field = "3A7DFD37BBDDEB49979A0E51410BD10A", hash_generated_field = "ACB3C4EDF6306DA058D6D16426E9E9E7")

    private HashMap<String, String> mExtraValueHashMapCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.280 -0400", hash_original_method = "934D77263F2647B2A011D3A69C057C66", hash_generated_method = "A1C313608E5C8C95CC2FC190A61A2D0C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.282 -0400", hash_original_method = "26B76F41AAAA7EE2514381E3013D5A81", hash_generated_method = "E31B6D25CAAA843FDBFE6094AACFCEC0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.283 -0400", hash_original_method = "D71F12C4764A764AF688AE6184DB2ED2", hash_generated_method = "ACF11529AB7DB787C152AB2F8CF531D9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.291 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "B7A983398135C7801747DDFA844AC3D0")
    public int getNameResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602087636 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602087636;
        // ---------- Original Method ----------
        //return mSubtypeNameResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.292 -0400", hash_original_method = "6A7C5EEB38C0091C7A516BA3C0FACD8B", hash_generated_method = "EC5C430488D3A796E255F969937D99FF")
    public int getIconResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914163852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914163852;
        // ---------- Original Method ----------
        //return mSubtypeIconResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.292 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "AFD309EADAA557C6BFC63B364DBF63A7")
    public String getLocale() {
        String varB4EAC82CA7396A68D541C85D26508E83_1095499530 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1095499530 = mSubtypeLocale;
        varB4EAC82CA7396A68D541C85D26508E83_1095499530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1095499530;
        // ---------- Original Method ----------
        //return mSubtypeLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.297 -0400", hash_original_method = "960AAB243B4CAAAE714C0B1CB581C452", hash_generated_method = "E9F7C1E7DA12C7C6E9BEE2618BF10B36")
    public String getMode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1666354542 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1666354542 = mSubtypeMode;
        varB4EAC82CA7396A68D541C85D26508E83_1666354542.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1666354542;
        // ---------- Original Method ----------
        //return mSubtypeMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.312 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "63065A0C3BCC0522E308068ADD401B45")
    public String getExtraValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_819952851 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_819952851 = mSubtypeExtraValue;
        varB4EAC82CA7396A68D541C85D26508E83_819952851.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_819952851;
        // ---------- Original Method ----------
        //return mSubtypeExtraValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.312 -0400", hash_original_method = "5D42329342BA940BF0C680758D792174", hash_generated_method = "07085059709D7726D469CEE4436923E3")
    public boolean isAuxiliary() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1154096806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1154096806;
        // ---------- Original Method ----------
        //return mIsAuxiliary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.313 -0400", hash_original_method = "77DDEB2A23977DBB23EB90699D4CDB8E", hash_generated_method = "FC8B791E70AEF36AFB42D8523A898603")
    public boolean overridesImplicitlyEnabledSubtype() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58670418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_58670418;
        // ---------- Original Method ----------
        //return mOverridesImplicitlyEnabledSubtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.313 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "AA58BC3C482FB58941C4E66ABE2CA200")
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_324667667 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1264777146 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1882368957 = null; //Variable for return #3
        Locale locale;
        locale = constructLocaleFromString(mSubtypeLocale);
        String localeStr;
        localeStr = locale.getDisplayName();
        localeStr = mSubtypeLocale;
        {
            varB4EAC82CA7396A68D541C85D26508E83_324667667 = localeStr;
        } //End block
        CharSequence subtypeName;
        subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        {
            boolean var8CAF5C55CF3F150CA75A24E410BC500C_2147456539 = (!TextUtils.isEmpty(subtypeName));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1264777146 = String.format(subtypeName.toString(), localeStr);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1882368957 = localeStr;
            } //End block
        } //End collapsed parenthetic
        addTaint(context.getTaint());
        addTaint(packageName.getTaint());
        addTaint(appInfo.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_150140759; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_150140759 = varB4EAC82CA7396A68D541C85D26508E83_324667667;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_150140759 = varB4EAC82CA7396A68D541C85D26508E83_1264777146;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_150140759 = varB4EAC82CA7396A68D541C85D26508E83_1882368957;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_150140759.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_150140759;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.315 -0400", hash_original_method = "2837AE7076837B91930C208632EE903B", hash_generated_method = "F1112EA605D69DF0A5A0184C08C17972")
    private HashMap<String, String> getExtraValueHashMap() {
        HashMap<String, String> varB4EAC82CA7396A68D541C85D26508E83_2113613946 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_2113613946 = mExtraValueHashMapCache;
        varB4EAC82CA7396A68D541C85D26508E83_2113613946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2113613946;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.315 -0400", hash_original_method = "92E492941FA288BA531CB37717D8F415", hash_generated_method = "0C38C2CF840C631669391A276078C7F8")
    public boolean containsExtraValueKey(String key) {
        boolean var879F87ED6CB8D534D2470D87EF542CAF_162274826 = (getExtraValueHashMap().containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796288745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_796288745;
        // ---------- Original Method ----------
        //return getExtraValueHashMap().containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.320 -0400", hash_original_method = "E26D6519ACBB2E66A4CA57F07B1B4B16", hash_generated_method = "38EBC3C4D0AB667EAE20C86F503DAA43")
    public String getExtraValueOf(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_464793509 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_464793509 = getExtraValueHashMap().get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_464793509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_464793509;
        // ---------- Original Method ----------
        //return getExtraValueHashMap().get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.320 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "EFEAECF5B31042985C103198E3E480D5")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1253293909 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1253293909;
        // ---------- Original Method ----------
        //return mSubtypeHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.337 -0400", hash_original_method = "0FAD58BA0D22A8990D6C7F18B4CA40E4", hash_generated_method = "E48D1CCBBCBA17D6042CD95DB98CE8D4")
    @Override
    public boolean equals(Object o) {
        {
            InputMethodSubtype subtype;
            subtype = (InputMethodSubtype) o;
            boolean varEEE5801028341F2EB0F803658C2232D1_182312621 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getMode().equals(getMode()))
                && (subtype.getIconResId() == getIconResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue()))
                && (subtype.isAuxiliary() == isAuxiliary()));
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1286748452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1286748452;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.337 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "63BD912A750A86CA5356C116D1A04718")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040300948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040300948;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.338 -0400", hash_original_method = "C419DC818714EC441C397D1AF0BAA00C", hash_generated_method = "4DF859947683BD28549093E3BA115743")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.340 -0400", hash_original_field = "FD70D5B6597BA4E41960E8E543899F2B", hash_generated_field = "46E5A51A75D7FC110C25F64595568BC9")

    private static String TAG = InputMethodSubtype.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.340 -0400", hash_original_field = "DE020776BE334FC0AE5FDE74CF87BE11", hash_generated_field = "34238EAB4D36315585ED09B527DCA605")

    private static String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.340 -0400", hash_original_field = "633819F0CE2FE910B1C0DC1AB3415993", hash_generated_field = "4B59D81114A3CEEA7C6FDE144A27F326")

    private static String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.340 -0400", hash_original_field = "87C3F14D000790670A5C8909273086FE", hash_generated_field = "F6FA24A5E0DEFDBE30BDE6B1502A4BF4")

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

