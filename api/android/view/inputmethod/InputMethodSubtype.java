package android.view.inputmethod;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.817 -0400", hash_original_field = "6B887E31A4611BC8CDB502D82236E7C6", hash_generated_field = "F8E8FA3061A103026C8298FB0F2648C7")

    private boolean mIsAuxiliary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.818 -0400", hash_original_field = "7F4C5EF5B1AF9A5A5C64C38289E3E3D3", hash_generated_field = "DF7B3D7F7849CD65A841EA756702E121")

    private boolean mOverridesImplicitlyEnabledSubtype;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.818 -0400", hash_original_field = "DB752714D7C5597F6D4538948E3D4382", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private int mSubtypeHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.818 -0400", hash_original_field = "E9CD3C1A08E60FD7C92E17FBDC1E9760", hash_generated_field = "C71D1FA43E13CD3282734DF2FF4408D8")

    private int mSubtypeIconResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.818 -0400", hash_original_field = "AE10E74C5B8FF193877E0EC967173BB0", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private int mSubtypeNameResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.818 -0400", hash_original_field = "62668E4A833F1CB4D52D80EE2676B489", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private String mSubtypeLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.818 -0400", hash_original_field = "33DCA0E766F52A803A4F474963A0D82D", hash_generated_field = "7ABE6DC269EBBCEC11D7611039EEBED9")

    private String mSubtypeMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.818 -0400", hash_original_field = "925770EC9378B8FB525692C9358CB66A", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private String mSubtypeExtraValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.818 -0400", hash_original_field = "3A7DFD37BBDDEB49979A0E51410BD10A", hash_generated_field = "ACB3C4EDF6306DA058D6D16426E9E9E7")

    private HashMap<String, String> mExtraValueHashMapCache;
    
    
    @DSModeled(DSC.BAN)
    public static InputMethodSubtype droidsafeObtainInputMethodSubtype() {
        InputMethodSubtype subtype = new InputMethodSubtype(0, 0, new String(), new String(), 
                                         new String(), false);
        return subtype;
    }
            
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.818 -0400", hash_original_method = "934D77263F2647B2A011D3A69C057C66", hash_generated_method = "4858F2C37D559F615970C0A29D470F18")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.820 -0400", hash_original_method = "26B76F41AAAA7EE2514381E3013D5A81", hash_generated_method = "E31B6D25CAAA843FDBFE6094AACFCEC0")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.822 -0400", hash_original_method = "D71F12C4764A764AF688AE6184DB2ED2", hash_generated_method = "ACF11529AB7DB787C152AB2F8CF531D9")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.822 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "E6CAF1A7B17D4BE8FFD918FCA4834860")
    public int getNameResId() {
        int varAE10E74C5B8FF193877E0EC967173BB0_170261988 = (mSubtypeNameResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819217238 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819217238;
        // ---------- Original Method ----------
        //return mSubtypeNameResId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.822 -0400", hash_original_method = "6A7C5EEB38C0091C7A516BA3C0FACD8B", hash_generated_method = "EB37C95D22442BF89CFAF099C95C2E43")
    public int getIconResId() {
        int varE9CD3C1A08E60FD7C92E17FBDC1E9760_844403651 = (mSubtypeIconResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1216251923 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1216251923;
        // ---------- Original Method ----------
        //return mSubtypeIconResId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.823 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "59379E43460B128D6C3AD885E424D408")
    public String getLocale() {
String varC07DAECEA29B71A30EF35B60B8076743_1891508585 =         mSubtypeLocale;
        varC07DAECEA29B71A30EF35B60B8076743_1891508585.addTaint(taint);
        return varC07DAECEA29B71A30EF35B60B8076743_1891508585;
        // ---------- Original Method ----------
        //return mSubtypeLocale;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.823 -0400", hash_original_method = "960AAB243B4CAAAE714C0B1CB581C452", hash_generated_method = "262EA251733A38BC7EF1A99E38618633")
    public String getMode() {
String varD8BB0738385C90441F5FD93457703855_1065913547 =         mSubtypeMode;
        varD8BB0738385C90441F5FD93457703855_1065913547.addTaint(taint);
        return varD8BB0738385C90441F5FD93457703855_1065913547;
        // ---------- Original Method ----------
        //return mSubtypeMode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.823 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "F4FA512EED209F0EB174616DB378D7C0")
    public String getExtraValue() {
String varD5103786A790F3D4881070784C5A1DFD_384361192 =         mSubtypeExtraValue;
        varD5103786A790F3D4881070784C5A1DFD_384361192.addTaint(taint);
        return varD5103786A790F3D4881070784C5A1DFD_384361192;
        // ---------- Original Method ----------
        //return mSubtypeExtraValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.823 -0400", hash_original_method = "5D42329342BA940BF0C680758D792174", hash_generated_method = "AAE3990710E90A288572EB3C1D722B5A")
    public boolean isAuxiliary() {
        boolean var6B887E31A4611BC8CDB502D82236E7C6_1887377538 = (mIsAuxiliary);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055356494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055356494;
        // ---------- Original Method ----------
        //return mIsAuxiliary;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.824 -0400", hash_original_method = "77DDEB2A23977DBB23EB90699D4CDB8E", hash_generated_method = "27B6725131076F4B04B91717850AABEE")
    public boolean overridesImplicitlyEnabledSubtype() {
        boolean var7F4C5EF5B1AF9A5A5C64C38289E3E3D3_1262252969 = (mOverridesImplicitlyEnabledSubtype);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068119190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068119190;
        // ---------- Original Method ----------
        //return mOverridesImplicitlyEnabledSubtype;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.824 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "C162DDEB8B6D627FF5235D40A8AA6D12")
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        addTaint(appInfo.getTaint());
        addTaint(packageName.getTaint());
        addTaint(context.getTaint());
        final Locale locale = constructLocaleFromString(mSubtypeLocale);
        final String localeStr = locale != null ? locale.getDisplayName() : mSubtypeLocale;
        if(mSubtypeNameResId == 0)        
        {
CharSequence varF1554E4544B9FE124AB662A8FBD78003_842971621 =             localeStr;
            varF1554E4544B9FE124AB662A8FBD78003_842971621.addTaint(taint);
            return varF1554E4544B9FE124AB662A8FBD78003_842971621;
        } //End block
        final CharSequence subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        if(!TextUtils.isEmpty(subtypeName))        
        {
CharSequence var5322360A9D2672FE8DDC97C43EADEEB5_272772984 =             String.format(subtypeName.toString(), localeStr);
            var5322360A9D2672FE8DDC97C43EADEEB5_272772984.addTaint(taint);
            return var5322360A9D2672FE8DDC97C43EADEEB5_272772984;
        } //End block
        else
        {
CharSequence varF1554E4544B9FE124AB662A8FBD78003_1680960415 =             localeStr;
            varF1554E4544B9FE124AB662A8FBD78003_1680960415.addTaint(taint);
            return varF1554E4544B9FE124AB662A8FBD78003_1680960415;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.824 -0400", hash_original_method = "2837AE7076837B91930C208632EE903B", hash_generated_method = "F0DA07CA3B712F6D38EE0DC0190F6B6E")
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
HashMap<String, String> var75B07F360A6A39A8B728D2DFD0DB271F_1026588436 =         mExtraValueHashMapCache;
        var75B07F360A6A39A8B728D2DFD0DB271F_1026588436.addTaint(taint);
        return var75B07F360A6A39A8B728D2DFD0DB271F_1026588436;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.825 -0400", hash_original_method = "92E492941FA288BA531CB37717D8F415", hash_generated_method = "707AC5C57FD882E9452B6377403C1F6B")
    public boolean containsExtraValueKey(String key) {
        addTaint(key.getTaint());
        boolean var4DC06D7EB4F8FE693966EEC9B5B8DE2B_362135146 = (getExtraValueHashMap().containsKey(key));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1590680848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1590680848;
        // ---------- Original Method ----------
        //return getExtraValueHashMap().containsKey(key);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.825 -0400", hash_original_method = "E26D6519ACBB2E66A4CA57F07B1B4B16", hash_generated_method = "BDE6820B59AAB199F12B9B9C60ADD34A")
    public String getExtraValueOf(String key) {
        addTaint(key.getTaint());
String var668958CC928CE427869ECE8B61534E65_564572761 =         getExtraValueHashMap().get(key);
        var668958CC928CE427869ECE8B61534E65_564572761.addTaint(taint);
        return var668958CC928CE427869ECE8B61534E65_564572761;
        // ---------- Original Method ----------
        //return getExtraValueHashMap().get(key);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.825 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "051534EC48CE4C8C8E7567B8B8F40A95")
    @Override
    public int hashCode() {
        int varDB752714D7C5597F6D4538948E3D4382_407331775 = (mSubtypeHashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128313907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128313907;
        // ---------- Original Method ----------
        //return mSubtypeHashCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.826 -0400", hash_original_method = "0FAD58BA0D22A8990D6C7F18B4CA40E4", hash_generated_method = "296C29715507A00C2D100AC33F1532A6")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o instanceof InputMethodSubtype)        
        {
            InputMethodSubtype subtype = (InputMethodSubtype) o;
            boolean var76564E1443E495D0553E5ED9438FD2AB_715738841 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getMode().equals(getMode()))
                && (subtype.getIconResId() == getIconResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue()))
                && (subtype.isAuxiliary() == isAuxiliary()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259873421 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259873421;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_672364587 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_406238288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_406238288;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.826 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "9C0E56B28F230B8E087CFEF26F8C37DD")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1430118468 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201013581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201013581;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.826 -0400", hash_original_method = "C419DC818714EC441C397D1AF0BAA00C", hash_generated_method = "21B80350FB24780FB690788355954CED")
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    private static int hashCodeInternal(String locale, String mode, String extraValue,
            boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype) {
        return Arrays.hashCode(new Object[] {locale, mode, extraValue, isAuxiliary,
                overridesImplicitlyEnabledSubtype});
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.827 -0400", hash_original_field = "FD70D5B6597BA4E41960E8E543899F2B", hash_generated_field = "0AA99DCA2CD79A11571781F4310E259D")

    private static final String TAG = InputMethodSubtype.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.828 -0400", hash_original_field = "DE020776BE334FC0AE5FDE74CF87BE11", hash_generated_field = "13FC4081C4F1C82C9C901E7C8DAAE61D")

    private static final String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.828 -0400", hash_original_field = "633819F0CE2FE910B1C0DC1AB3415993", hash_generated_field = "288DE97156AEA20FA476F272E7A6DA36")

    private static final String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.828 -0400", hash_original_field = "87C3F14D000790670A5C8909273086FE", hash_generated_field = "F6FA24A5E0DEFDBE30BDE6B1502A4BF4")

    public static final Parcelable.Creator<InputMethodSubtype> CREATOR
            = new Parcelable.Creator<InputMethodSubtype>() {
        @Override
        public InputMethodSubtype createFromParcel(Parcel source) {
            return new InputMethodSubtype(source);
        }

        @DSModeled(DSC.SAFE)
        @Override
        public InputMethodSubtype[] newArray(int size) {
            return new InputMethodSubtype[size];
        }
    };
}

