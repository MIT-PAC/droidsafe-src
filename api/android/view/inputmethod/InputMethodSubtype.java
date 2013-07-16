package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.543 -0400", hash_original_field = "6B887E31A4611BC8CDB502D82236E7C6", hash_generated_field = "F8E8FA3061A103026C8298FB0F2648C7")

    private boolean mIsAuxiliary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.543 -0400", hash_original_field = "7F4C5EF5B1AF9A5A5C64C38289E3E3D3", hash_generated_field = "DF7B3D7F7849CD65A841EA756702E121")

    private boolean mOverridesImplicitlyEnabledSubtype;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.543 -0400", hash_original_field = "DB752714D7C5597F6D4538948E3D4382", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private int mSubtypeHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.543 -0400", hash_original_field = "E9CD3C1A08E60FD7C92E17FBDC1E9760", hash_generated_field = "C71D1FA43E13CD3282734DF2FF4408D8")

    private int mSubtypeIconResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.544 -0400", hash_original_field = "AE10E74C5B8FF193877E0EC967173BB0", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private int mSubtypeNameResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.544 -0400", hash_original_field = "62668E4A833F1CB4D52D80EE2676B489", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private String mSubtypeLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.544 -0400", hash_original_field = "33DCA0E766F52A803A4F474963A0D82D", hash_generated_field = "7ABE6DC269EBBCEC11D7611039EEBED9")

    private String mSubtypeMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.544 -0400", hash_original_field = "925770EC9378B8FB525692C9358CB66A", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private String mSubtypeExtraValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.544 -0400", hash_original_field = "3A7DFD37BBDDEB49979A0E51410BD10A", hash_generated_field = "ACB3C4EDF6306DA058D6D16426E9E9E7")

    private HashMap<String, String> mExtraValueHashMapCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.545 -0400", hash_original_method = "934D77263F2647B2A011D3A69C057C66", hash_generated_method = "4858F2C37D559F615970C0A29D470F18")
    public  InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue,
            boolean isAuxiliary) {
        this(nameId, iconId, locale, mode, extraValue, isAuxiliary, false);
        addTaint(isAuxiliary);
        addTaint(extraValue.getTaint());
        addTaint(mode.getTaint());
        addTaint(locale.getTaint());
        addTaint(iconId);
        addTaint(nameId);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.546 -0400", hash_original_method = "26B76F41AAAA7EE2514381E3013D5A81", hash_generated_method = "E31B6D25CAAA843FDBFE6094AACFCEC0")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.548 -0400", hash_original_method = "D71F12C4764A764AF688AE6184DB2ED2", hash_generated_method = "ACF11529AB7DB787C152AB2F8CF531D9")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.548 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "0D9B1104FEEFBD39EFFB9E71A80CD7C4")
    public int getNameResId() {
        int varAE10E74C5B8FF193877E0EC967173BB0_815970770 = (mSubtypeNameResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659125201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659125201;
        // ---------- Original Method ----------
        //return mSubtypeNameResId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.548 -0400", hash_original_method = "6A7C5EEB38C0091C7A516BA3C0FACD8B", hash_generated_method = "CD54B767FE4F998F50065417BF3CE770")
    public int getIconResId() {
        int varE9CD3C1A08E60FD7C92E17FBDC1E9760_1299918071 = (mSubtypeIconResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139014619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139014619;
        // ---------- Original Method ----------
        //return mSubtypeIconResId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.548 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "0B42D5B0CD6EC1C750855756C6160389")
    public String getLocale() {
String varC07DAECEA29B71A30EF35B60B8076743_107890345 =         mSubtypeLocale;
        varC07DAECEA29B71A30EF35B60B8076743_107890345.addTaint(taint);
        return varC07DAECEA29B71A30EF35B60B8076743_107890345;
        // ---------- Original Method ----------
        //return mSubtypeLocale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.549 -0400", hash_original_method = "960AAB243B4CAAAE714C0B1CB581C452", hash_generated_method = "D88512DC888FD3F1B37E72A248FF016D")
    public String getMode() {
String varD8BB0738385C90441F5FD93457703855_1595531610 =         mSubtypeMode;
        varD8BB0738385C90441F5FD93457703855_1595531610.addTaint(taint);
        return varD8BB0738385C90441F5FD93457703855_1595531610;
        // ---------- Original Method ----------
        //return mSubtypeMode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.549 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "6EF56AE3D043203C6319E53202BB5334")
    public String getExtraValue() {
String varD5103786A790F3D4881070784C5A1DFD_1720036130 =         mSubtypeExtraValue;
        varD5103786A790F3D4881070784C5A1DFD_1720036130.addTaint(taint);
        return varD5103786A790F3D4881070784C5A1DFD_1720036130;
        // ---------- Original Method ----------
        //return mSubtypeExtraValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.549 -0400", hash_original_method = "5D42329342BA940BF0C680758D792174", hash_generated_method = "4DAA53CC63088DB7C60413B25F229934")
    public boolean isAuxiliary() {
        boolean var6B887E31A4611BC8CDB502D82236E7C6_1204371502 = (mIsAuxiliary);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1237969884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1237969884;
        // ---------- Original Method ----------
        //return mIsAuxiliary;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.549 -0400", hash_original_method = "77DDEB2A23977DBB23EB90699D4CDB8E", hash_generated_method = "B6AC5DADBFA6B72B90CC722EE5EA6A51")
    public boolean overridesImplicitlyEnabledSubtype() {
        boolean var7F4C5EF5B1AF9A5A5C64C38289E3E3D3_1696382447 = (mOverridesImplicitlyEnabledSubtype);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1848974230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1848974230;
        // ---------- Original Method ----------
        //return mOverridesImplicitlyEnabledSubtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.550 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "114F815CE73F07CFA96E017C5C944E71")
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        addTaint(appInfo.getTaint());
        addTaint(packageName.getTaint());
        addTaint(context.getTaint());
        final Locale locale = constructLocaleFromString(mSubtypeLocale);
        final String localeStr = locale != null ? locale.getDisplayName() : mSubtypeLocale;
    if(mSubtypeNameResId == 0)        
        {
CharSequence varF1554E4544B9FE124AB662A8FBD78003_220952035 =             localeStr;
            varF1554E4544B9FE124AB662A8FBD78003_220952035.addTaint(taint);
            return varF1554E4544B9FE124AB662A8FBD78003_220952035;
        } //End block
        final CharSequence subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
    if(!TextUtils.isEmpty(subtypeName))        
        {
CharSequence var5322360A9D2672FE8DDC97C43EADEEB5_1270529117 =             String.format(subtypeName.toString(), localeStr);
            var5322360A9D2672FE8DDC97C43EADEEB5_1270529117.addTaint(taint);
            return var5322360A9D2672FE8DDC97C43EADEEB5_1270529117;
        } //End block
        else
        {
CharSequence varF1554E4544B9FE124AB662A8FBD78003_1814681993 =             localeStr;
            varF1554E4544B9FE124AB662A8FBD78003_1814681993.addTaint(taint);
            return varF1554E4544B9FE124AB662A8FBD78003_1814681993;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.550 -0400", hash_original_method = "2837AE7076837B91930C208632EE903B", hash_generated_method = "4A4165E9F9972EE14B88F89F44FF4B82")
    private HashMap<String, String> getExtraValueHashMap() {
    if(mExtraValueHashMapCache == null)        
        {
            mExtraValueHashMapCache = new HashMap<String, String>();
            final String[] pairs = mSubtypeExtraValue.split(EXTRA_VALUE_PAIR_SEPARATOR);
            final int N = pairs.length;
for(int i = 0;i < N;++i)
            {
                final String[] pair = pairs[i].split(EXTRA_VALUE_KEY_VALUE_SEPARATOR);
    if(pair.length == 1)                
                {
                    mExtraValueHashMapCache.put(pair[0], null);
                } //End block
                else
    if(pair.length > 1)                
                {
    if(pair.length > 2)                    
                    {
                    } //End block
                    mExtraValueHashMapCache.put(pair[0], pair[1]);
                } //End block
            } //End block
        } //End block
HashMap<String, String> var75B07F360A6A39A8B728D2DFD0DB271F_65369480 =         mExtraValueHashMapCache;
        var75B07F360A6A39A8B728D2DFD0DB271F_65369480.addTaint(taint);
        return var75B07F360A6A39A8B728D2DFD0DB271F_65369480;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.551 -0400", hash_original_method = "92E492941FA288BA531CB37717D8F415", hash_generated_method = "AA2E5A64C6D62C396350F6979D320695")
    public boolean containsExtraValueKey(String key) {
        addTaint(key.getTaint());
        boolean var4DC06D7EB4F8FE693966EEC9B5B8DE2B_376402542 = (getExtraValueHashMap().containsKey(key));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829462453 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_829462453;
        // ---------- Original Method ----------
        //return getExtraValueHashMap().containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.551 -0400", hash_original_method = "E26D6519ACBB2E66A4CA57F07B1B4B16", hash_generated_method = "31FAEC7A2E0EEB521A5C65B875D4AFBE")
    public String getExtraValueOf(String key) {
        addTaint(key.getTaint());
String var668958CC928CE427869ECE8B61534E65_1270859244 =         getExtraValueHashMap().get(key);
        var668958CC928CE427869ECE8B61534E65_1270859244.addTaint(taint);
        return var668958CC928CE427869ECE8B61534E65_1270859244;
        // ---------- Original Method ----------
        //return getExtraValueHashMap().get(key);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.551 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "631E4C9F4A72B229D76EA5FBC46221C6")
    @Override
    public int hashCode() {
        int varDB752714D7C5597F6D4538948E3D4382_1689178413 = (mSubtypeHashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127815469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127815469;
        // ---------- Original Method ----------
        //return mSubtypeHashCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.552 -0400", hash_original_method = "0FAD58BA0D22A8990D6C7F18B4CA40E4", hash_generated_method = "053ADC64CB809C1B1CDC185F6E27B57A")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o instanceof InputMethodSubtype)        
        {
            InputMethodSubtype subtype = (InputMethodSubtype) o;
            boolean var76564E1443E495D0553E5ED9438FD2AB_1497881521 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getMode().equals(getMode()))
                && (subtype.getIconResId() == getIconResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue()))
                && (subtype.isAuxiliary() == isAuxiliary()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068907956 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068907956;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1669444149 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_260637905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_260637905;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.552 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "EABE1CB476FED5E74F7EB3102F0F038B")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1327169532 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1692794767 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1692794767;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.552 -0400", hash_original_method = "C419DC818714EC441C397D1AF0BAA00C", hash_generated_method = "21B80350FB24780FB690788355954CED")
    @Override
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
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

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.553 -0400", hash_original_field = "FD70D5B6597BA4E41960E8E543899F2B", hash_generated_field = "0AA99DCA2CD79A11571781F4310E259D")

    private static final String TAG = InputMethodSubtype.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.554 -0400", hash_original_field = "DE020776BE334FC0AE5FDE74CF87BE11", hash_generated_field = "13FC4081C4F1C82C9C901E7C8DAAE61D")

    private static final String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.554 -0400", hash_original_field = "633819F0CE2FE910B1C0DC1AB3415993", hash_generated_field = "288DE97156AEA20FA476F272E7A6DA36")

    private static final String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.554 -0400", hash_original_field = "87C3F14D000790670A5C8909273086FE", hash_generated_field = "F6FA24A5E0DEFDBE30BDE6B1502A4BF4")

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

