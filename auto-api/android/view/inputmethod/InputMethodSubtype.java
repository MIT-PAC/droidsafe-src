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
    private boolean mIsAuxiliary;
    private boolean mOverridesImplicitlyEnabledSubtype;
    private int mSubtypeHashCode;
    private int mSubtypeIconResId;
    private int mSubtypeNameResId;
    private String mSubtypeLocale;
    private String mSubtypeMode;
    private String mSubtypeExtraValue;
    private HashMap<String, String> mExtraValueHashMapCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.425 -0400", hash_original_method = "934D77263F2647B2A011D3A69C057C66", hash_generated_method = "704DBC6D72D88CCA76F32A966AB771FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue,
            boolean isAuxiliary) {
        this(nameId, iconId, locale, mode, extraValue, isAuxiliary, false);
        dsTaint.addTaint(locale);
        dsTaint.addTaint(isAuxiliary);
        dsTaint.addTaint(iconId);
        dsTaint.addTaint(extraValue);
        dsTaint.addTaint(nameId);
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.425 -0400", hash_original_method = "26B76F41AAAA7EE2514381E3013D5A81", hash_generated_method = "09739C2E07965821F555CE0B5978DFF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue,
            boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype) {
        dsTaint.addTaint(locale);
        dsTaint.addTaint(isAuxiliary);
        dsTaint.addTaint(iconId);
        dsTaint.addTaint(overridesImplicitlyEnabledSubtype);
        dsTaint.addTaint(extraValue);
        dsTaint.addTaint(nameId);
        dsTaint.addTaint(mode);
        mSubtypeLocale = locale != null ? locale : "";
        mSubtypeMode = mode != null ? mode : "";
        mSubtypeExtraValue = extraValue != null ? extraValue : "";
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.425 -0400", hash_original_method = "D71F12C4764A764AF688AE6184DB2ED2", hash_generated_method = "0F131AA321D523A590464FD27196E5A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InputMethodSubtype(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.426 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "37337A9AFC76FC1E81E9B30E314C814B")
    @DSModeled(DSC.SAFE)
    public int getNameResId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubtypeNameResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.426 -0400", hash_original_method = "6A7C5EEB38C0091C7A516BA3C0FACD8B", hash_generated_method = "CD9868C030CD1DF17D2F8697194724F1")
    @DSModeled(DSC.SAFE)
    public int getIconResId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubtypeIconResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.426 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "1219AB9E48D6018F12BF32489CFB6E96")
    @DSModeled(DSC.SAFE)
    public String getLocale() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubtypeLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.426 -0400", hash_original_method = "960AAB243B4CAAAE714C0B1CB581C452", hash_generated_method = "0D05ACFDA972FF5517C482429275EB73")
    @DSModeled(DSC.SAFE)
    public String getMode() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubtypeMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.426 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "CF80BB26064D7C68FD3101C0093934BF")
    @DSModeled(DSC.SAFE)
    public String getExtraValue() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubtypeExtraValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.426 -0400", hash_original_method = "5D42329342BA940BF0C680758D792174", hash_generated_method = "CDBE77E700A9676226E60525ADCC2C25")
    @DSModeled(DSC.SAFE)
    public boolean isAuxiliary() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsAuxiliary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.427 -0400", hash_original_method = "77DDEB2A23977DBB23EB90699D4CDB8E", hash_generated_method = "F5806FEBA4AAE97DB7ED5C46898C8262")
    @DSModeled(DSC.SAFE)
    public boolean overridesImplicitlyEnabledSubtype() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mOverridesImplicitlyEnabledSubtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.427 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "A6C4FA932DF0AEC03FB51AB708748BD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(appInfo.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        Locale locale;
        locale = constructLocaleFromString(mSubtypeLocale);
        String localeStr;
        localeStr = locale.getDisplayName();
        localeStr = mSubtypeLocale;
        CharSequence subtypeName;
        subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        {
            boolean var8CAF5C55CF3F150CA75A24E410BC500C_1816803830 = (!TextUtils.isEmpty(subtypeName));
            {
                CharSequence varCAE59473585162B683314F148AA41B15_952610022 = (String.format(subtypeName.toString(), localeStr));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.427 -0400", hash_original_method = "2837AE7076837B91930C208632EE903B", hash_generated_method = "29667D350A11E7A10420CECA4C378A28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HashMap<String, String> getExtraValueHashMap() {
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
        return (HashMap<String, String>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.427 -0400", hash_original_method = "92E492941FA288BA531CB37717D8F415", hash_generated_method = "BE14FD0A112D32756689420BC472893D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsExtraValueKey(String key) {
        dsTaint.addTaint(key);
        boolean var879F87ED6CB8D534D2470D87EF542CAF_2126928851 = (getExtraValueHashMap().containsKey(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getExtraValueHashMap().containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.428 -0400", hash_original_method = "E26D6519ACBB2E66A4CA57F07B1B4B16", hash_generated_method = "CCEB8730D95FF6B690F97FBFFFDC7253")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getExtraValueOf(String key) {
        dsTaint.addTaint(key);
        String var367573E1AB8C5B04B333B3939DD3457A_590700604 = (getExtraValueHashMap().get(key));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getExtraValueHashMap().get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.428 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "4CA7B61DD6C24A0D261C105B01E498F3")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubtypeHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.428 -0400", hash_original_method = "0FAD58BA0D22A8990D6C7F18B4CA40E4", hash_generated_method = "5FD471020D106250D8D1C8B107C6EC68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            InputMethodSubtype subtype;
            subtype = (InputMethodSubtype) o;
            boolean varEEE5801028341F2EB0F803658C2232D1_1113471759 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getMode().equals(getMode()))
                && (subtype.getIconResId() == getIconResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue()))
                && (subtype.isAuxiliary() == isAuxiliary()));
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.428 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.428 -0400", hash_original_method = "C419DC818714EC441C397D1AF0BAA00C", hash_generated_method = "559CB95516D996C2D224851670A4594B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mSubtypeNameResId);
        dest.writeInt(mSubtypeIconResId);
        dest.writeString(mSubtypeLocale);
        dest.writeString(mSubtypeMode);
        dest.writeString(mSubtypeExtraValue);
        dest.writeInt(mIsAuxiliary ? 1 : 0);
        dest.writeInt(mOverridesImplicitlyEnabledSubtype ? 1 : 0);
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

    
    private static final String TAG = InputMethodSubtype.class.getSimpleName();
    private static final String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    private static final String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    public static final Parcelable.Creator<InputMethodSubtype> CREATOR = new Parcelable.Creator<InputMethodSubtype>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.429 -0400", hash_original_method = "B6933BA3396E8ADA7C6D5A78A0591156", hash_generated_method = "88C15A4F9781EF7BDEADEB6F6ED1CBA9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public InputMethodSubtype createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            InputMethodSubtype var8685DF45FF24A7FF0BC741D8A7B3CACF_1335779586 = (new InputMethodSubtype(source));
            return (InputMethodSubtype)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputMethodSubtype(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.429 -0400", hash_original_method = "CB1A359C1F692790B2DF069F132E022F", hash_generated_method = "941D8C95D19F1FF93616CF3887D68249")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public InputMethodSubtype[] newArray(int size) {
            dsTaint.addTaint(size);
            InputMethodSubtype[] var284374D8C8EBF8AFA259DAE44C85E7DB_1250032433 = (new InputMethodSubtype[size]);
            return (InputMethodSubtype[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputMethodSubtype[size];
        }

        
}; //Transformed anonymous class
}

