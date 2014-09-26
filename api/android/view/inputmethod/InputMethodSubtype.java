package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Slog;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class InputMethodSubtype implements Parcelable {
    
    public static InputMethodSubtype droidsafeObtainInputMethodSubtype() {
        InputMethodSubtype subtype = new InputMethodSubtype(0, 0, new String(), new String(), 
                                         new String(), false);
        return subtype;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.012 -0500", hash_original_method = "8E1C6298EB66C275DF3380320723757A", hash_generated_method = "FE94C4A8FECD84D683885278E012F460")
    
private static Locale constructLocaleFromString(String localeStr) {
        if (TextUtils.isEmpty(localeStr))
            return null;
        String[] localeParams = localeStr.split("_", 3);
        // The length of localeStr is guaranteed to always return a 1 <= value <= 3
        // because localeStr is not empty.
        if (localeParams.length == 1) {
            return new Locale(localeParams[0]);
        } else if (localeParams.length == 2) {
            return new Locale(localeParams[0], localeParams[1]);
        } else if (localeParams.length == 3) {
            return new Locale(localeParams[0], localeParams[1], localeParams[2]);
        }
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.015 -0500", hash_original_method = "4A7415607D92CC247A3DAF0EC13356B4", hash_generated_method = "50EE231AEB9608260A776569CA36A115")
    
private static int hashCodeInternal(String locale, String mode, String extraValue,
            boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype) {
        return Arrays.hashCode(new Object[] {locale, mode, extraValue, isAuxiliary,
                overridesImplicitlyEnabledSubtype});
    }

    /**
     * Sort the list of InputMethodSubtype
     * @param context Context will be used for getting localized strings from IME
     * @param flags Flags for the sort order
     * @param imi InputMethodInfo of which subtypes are subject to be sorted
     * @param subtypeList List of InputMethodSubtype which will be sorted
     * @return Sorted list of subtypes
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.018 -0500", hash_original_method = "087397511909414364D6379E0DA93FA7", hash_generated_method = "D5EA3A8DD5A081129A60AA2627E71EC7")
    
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
        // If subtypes in inputSubtypesSet remain, that means these subtypes are not
        // contained in imi, so the remaining subtypes will be appended.
        for (InputMethodSubtype subtype: inputSubtypesSet) {
            sortedList.add(subtype);
        }
        return sortedList;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.927 -0500", hash_original_field = "82460CF4DC2527BE3B4E4055FA4F3DA5", hash_generated_field = "0AA99DCA2CD79A11571781F4310E259D")

    private static final String TAG = InputMethodSubtype.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.930 -0500", hash_original_field = "0FC81C3EE322D71CB113950B72F9E279", hash_generated_field = "13FC4081C4F1C82C9C901E7C8DAAE61D")

    private static final String EXTRA_VALUE_PAIR_SEPARATOR = ",";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.933 -0500", hash_original_field = "34A88BAA552FA4A3484CBC39F38AE386", hash_generated_field = "288DE97156AEA20FA476F272E7A6DA36")

    private static final String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.828 -0400", hash_original_field = "87C3F14D000790670A5C8909273086FE", hash_generated_field = "F6FA24A5E0DEFDBE30BDE6B1502A4BF4")

    public static final Parcelable.Creator<InputMethodSubtype> CREATOR
            = new Parcelable.Creator<InputMethodSubtype>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.004 -0500", hash_original_method = "B6933BA3396E8ADA7C6D5A78A0591156", hash_generated_method = "9F2DD4F025FBBB072F5052734A2C8779")
        
@Override
        public InputMethodSubtype createFromParcel(Parcel source) {
            return new InputMethodSubtype(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.007 -0500", hash_original_method = "CB1A359C1F692790B2DF069F132E022F", hash_generated_method = "F00446094207D48B698D85292507329E")
        
@Override
        public InputMethodSubtype[] newArray(int size) {
            return new InputMethodSubtype[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.935 -0500", hash_original_field = "E696D958865128B29DF1F55D51A08032", hash_generated_field = "F8E8FA3061A103026C8298FB0F2648C7")

    private  boolean mIsAuxiliary;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.937 -0500", hash_original_field = "7CD331AB2A4CBBC5A487FB7B5A32FCFE", hash_generated_field = "DF7B3D7F7849CD65A841EA756702E121")

    private  boolean mOverridesImplicitlyEnabledSubtype;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.940 -0500", hash_original_field = "622071262F8C7323916A08E8A5FE5B0F", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private  int mSubtypeHashCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.942 -0500", hash_original_field = "6F224FFE87891E2E5E05EA10FD4FAB57", hash_generated_field = "C71D1FA43E13CD3282734DF2FF4408D8")

    private  int mSubtypeIconResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.945 -0500", hash_original_field = "4B8E567964882234BB978E7260845CFE", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private  int mSubtypeNameResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.947 -0500", hash_original_field = "90577A26519101012AB8C79E4EBE45D5", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private  String mSubtypeLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.950 -0500", hash_original_field = "15FC2680021C3FBD69E43FBEEB19C5A9", hash_generated_field = "7ABE6DC269EBBCEC11D7611039EEBED9")

    private  String mSubtypeMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.952 -0500", hash_original_field = "5A1BB8126BCD812601DD28966BD5A486", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private  String mSubtypeExtraValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.955 -0500", hash_original_field = "C1AF3DCEBB4C3E4D9C3075963EE88AEA", hash_generated_field = "ACB3C4EDF6306DA058D6D16426E9E9E7")

    private HashMap<String, String> mExtraValueHashMapCache;

    /**
     * Constructor
     * @param nameId The name of the subtype
     * @param iconId The icon of the subtype
     * @param locale The locale supported by the subtype
     * @param mode The mode supported by the subtype
     * @param extraValue The extra value of the subtype
     * @param isAuxiliary true when this subtype is one shot subtype.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.958 -0500", hash_original_method = "934D77263F2647B2A011D3A69C057C66", hash_generated_method = "591582BF2069FBE1C0D3E099A3A1A4FF")
    
public InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue,
            boolean isAuxiliary) {
        this(nameId, iconId, locale, mode, extraValue, isAuxiliary, false);
    }

    /**
     * Constructor
     * @param nameId The name of the subtype
     * @param iconId The icon of the subtype
     * @param locale The locale supported by the subtype
     * @param mode The mode supported by the subtype
     * @param extraValue The extra value of the subtype
     * @param isAuxiliary true when this subtype is one shot subtype.
     * @param overridesImplicitlyEnabledSubtype true when this subtype should be selected by default
     * if no other subtypes are selected explicitly. Note that a subtype with this parameter being
     * true will not be shown in the subtypes list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.961 -0500", hash_original_method = "26B76F41AAAA7EE2514381E3013D5A81", hash_generated_method = "ED3E1CFCAE94222F7C5C18BB3ADB2D37")
    
public InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue,
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
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.963 -0500", hash_original_method = "D71F12C4764A764AF688AE6184DB2ED2", hash_generated_method = "D71F12C4764A764AF688AE6184DB2ED2")
    
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
    }

    /**
     * @return the name of the subtype
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.966 -0500", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "26CBCDA99AD203B4314FE6FE708C7FDB")
    
public int getNameResId() {
        return mSubtypeNameResId;
    }

    /**
     * @return the icon of the subtype
     */
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.968 -0500", hash_original_method = "6A7C5EEB38C0091C7A516BA3C0FACD8B", hash_generated_method = "351869723AD00AED2B9F8013B9ED025F")
    
public int getIconResId() {
        return mSubtypeIconResId;
    }

    /**
     * @return the locale of the subtype
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.970 -0500", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "EE03D54FF1419549D24B5FD49A307399")
    
public String getLocale() {
        return mSubtypeLocale;
    }

    /**
     * @return the mode of the subtype
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.972 -0500", hash_original_method = "960AAB243B4CAAAE714C0B1CB581C452", hash_generated_method = "93344719B3FF4933F2530358A8074478")
    
public String getMode() {
        return mSubtypeMode;
    }

    /**
     * @return the extra value of the subtype
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.975 -0500", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "B0B48211E788C5E773FA1B3FFFFC18D8")
    
public String getExtraValue() {
        return mSubtypeExtraValue;
    }

    /**
     * @return true if this subtype is one shot subtype. One shot subtype will not be shown in the
     * ime switch list when this subtype is implicitly enabled. The framework will never
     * switch the current ime to this subtype by switchToLastInputMethod in InputMethodManager.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.977 -0500", hash_original_method = "5D42329342BA940BF0C680758D792174", hash_generated_method = "C035E533465AA7EB5230335F059A2767")
    
public boolean isAuxiliary() {
        return mIsAuxiliary;
    }

    /**
     * @return true when this subtype is selected by default if no other subtypes are selected
     * explicitly. Note that a subtype that returns true will not be shown in the subtypes list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.979 -0500", hash_original_method = "77DDEB2A23977DBB23EB90699D4CDB8E", hash_generated_method = "B5D5DDE1E4830727820572D17CA7BAB8")
    
public boolean overridesImplicitlyEnabledSubtype() {
        return mOverridesImplicitlyEnabledSubtype;
    }

    /**
     * @param context Context will be used for getting Locale and PackageManager.
     * @param packageName The package name of the IME
     * @param appInfo The application info of the IME
     * @return a display name for this subtype. The string resource of the label (mSubtypeNameResId)
     * can have only one %s in it. If there is, the %s part will be replaced with the locale's
     * display name by the formatter. If there is not, this method simply returns the string
     * specified by mSubtypeNameResId. If mSubtypeNameResId is not specified (== 0), it's up to the
     * framework to generate an appropriate display name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.982 -0500", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "D9FE477B4AE71540ABA1B09AB9219FF9")
    
public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        final Locale locale = constructLocaleFromString(mSubtypeLocale);
        final String localeStr = locale != null ? locale.getDisplayName() : mSubtypeLocale;
        if (mSubtypeNameResId == 0) {
            return localeStr;
        }
        final CharSequence subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        if (!TextUtils.isEmpty(subtypeName)) {
            return String.format(subtypeName.toString(), localeStr);
        } else {
            return localeStr;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.985 -0500", hash_original_method = "2837AE7076837B91930C208632EE903B", hash_generated_method = "C3F39841AA3B2F76CC38931C9CF61386")
    
private HashMap<String, String> getExtraValueHashMap() {
        if (mExtraValueHashMapCache == null) {
            mExtraValueHashMapCache = new HashMap<String, String>();
            final String[] pairs = mSubtypeExtraValue.split(EXTRA_VALUE_PAIR_SEPARATOR);
            final int N = pairs.length;
            for (int i = 0; i < N; ++i) {
                final String[] pair = pairs[i].split(EXTRA_VALUE_KEY_VALUE_SEPARATOR);
                if (pair.length == 1) {
                    mExtraValueHashMapCache.put(pair[0], null);
                } else if (pair.length > 1) {
                    if (pair.length > 2) {
                        Slog.w(TAG, "ExtraValue has two or more '='s");
                    }
                    mExtraValueHashMapCache.put(pair[0], pair[1]);
                }
            }
        }
        return mExtraValueHashMapCache;
    }

    /**
     * The string of ExtraValue in subtype should be defined as follows:
     * example: key0,key1=value1,key2,key3,key4=value4
     * @param key the key of extra value
     * @return the subtype contains specified the extra value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.987 -0500", hash_original_method = "92E492941FA288BA531CB37717D8F415", hash_generated_method = "E85CF5068CC3E55B410D6E17B50952A4")
    
public boolean containsExtraValueKey(String key) {
        return getExtraValueHashMap().containsKey(key);
    }

    /**
     * The string of ExtraValue in subtype should be defined as follows:
     * example: key0,key1=value1,key2,key3,key4=value4
     * @param key the key of extra value
     * @return the value of the specified key
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.989 -0500", hash_original_method = "E26D6519ACBB2E66A4CA57F07B1B4B16", hash_generated_method = "4E08F5BE11E9A72E0AF217B013CACB68")
    
public String getExtraValueOf(String key) {
        return getExtraValueHashMap().get(key);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.992 -0500", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "59CD8717BAF0B810679FFE0F1F02958C")
    
@Override
    public int hashCode() {
        return mSubtypeHashCode;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.995 -0500", hash_original_method = "0FAD58BA0D22A8990D6C7F18B4CA40E4", hash_generated_method = "C468BA013018BFA449F9D6D42B1B0BF1")
    
@Override
    public boolean equals(Object o) {
        if (o instanceof InputMethodSubtype) {
            InputMethodSubtype subtype = (InputMethodSubtype) o;
            return (subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getMode().equals(getMode()))
                && (subtype.getIconResId() == getIconResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue()))
                && (subtype.isAuxiliary() == isAuxiliary());
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.997 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.000 -0500", hash_original_method = "C419DC818714EC441C397D1AF0BAA00C", hash_generated_method = "67FF9EB92B26B4B14DE1AFEAF50A881D")
    
@Override
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeInt(mSubtypeNameResId);
        dest.writeInt(mSubtypeIconResId);
        dest.writeString(mSubtypeLocale);
        dest.writeString(mSubtypeMode);
        dest.writeString(mSubtypeExtraValue);
        dest.writeInt(mIsAuxiliary ? 1 : 0);
        dest.writeInt(mOverridesImplicitlyEnabledSubtype ? 1 : 0);
    }
}

