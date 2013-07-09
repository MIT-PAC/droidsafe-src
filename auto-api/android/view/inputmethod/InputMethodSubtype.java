package android.view.inputmethod;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.307 -0400", hash_original_field = "6B887E31A4611BC8CDB502D82236E7C6", hash_generated_field = "F8E8FA3061A103026C8298FB0F2648C7")

    private boolean mIsAuxiliary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.307 -0400", hash_original_field = "7F4C5EF5B1AF9A5A5C64C38289E3E3D3", hash_generated_field = "DF7B3D7F7849CD65A841EA756702E121")

    private boolean mOverridesImplicitlyEnabledSubtype;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.307 -0400", hash_original_field = "DB752714D7C5597F6D4538948E3D4382", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private int mSubtypeHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.307 -0400", hash_original_field = "E9CD3C1A08E60FD7C92E17FBDC1E9760", hash_generated_field = "C71D1FA43E13CD3282734DF2FF4408D8")

    private int mSubtypeIconResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.307 -0400", hash_original_field = "AE10E74C5B8FF193877E0EC967173BB0", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private int mSubtypeNameResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.307 -0400", hash_original_field = "62668E4A833F1CB4D52D80EE2676B489", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private String mSubtypeLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.307 -0400", hash_original_field = "33DCA0E766F52A803A4F474963A0D82D", hash_generated_field = "7ABE6DC269EBBCEC11D7611039EEBED9")

    private String mSubtypeMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.307 -0400", hash_original_field = "925770EC9378B8FB525692C9358CB66A", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private String mSubtypeExtraValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.307 -0400", hash_original_field = "3A7DFD37BBDDEB49979A0E51410BD10A", hash_generated_field = "ACB3C4EDF6306DA058D6D16426E9E9E7")

    private HashMap<String, String> mExtraValueHashMapCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.308 -0400", hash_original_method = "934D77263F2647B2A011D3A69C057C66", hash_generated_method = "A1C313608E5C8C95CC2FC190A61A2D0C")
    public  InputMethodSubtype(int nameId, int iconId, String locale, String mode, String extraValue,
            boolean isAuxiliary) {
        this(nameId, iconId, locale, mode, extraValue, isAuxiliary, false);
        addTaint(nameId);
        addTaint(iconId);
        addTaint(locale.getTaint());
        addTaint(mode.getTaint());
        addTaint(extraValue.getTaint());
        addTaint(isAuxiliary);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.308 -0400", hash_original_method = "26B76F41AAAA7EE2514381E3013D5A81", hash_generated_method = "E31B6D25CAAA843FDBFE6094AACFCEC0")
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
        
        
        
        
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.309 -0400", hash_original_method = "D71F12C4764A764AF688AE6184DB2ED2", hash_generated_method = "ACF11529AB7DB787C152AB2F8CF531D9")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.309 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "CCAD0FE8730DB214C5EBB9D487F4DE81")
    public int getNameResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118858909 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118858909;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.309 -0400", hash_original_method = "6A7C5EEB38C0091C7A516BA3C0FACD8B", hash_generated_method = "26D66CADB610F19BC5477320DE843B90")
    public int getIconResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177979212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177979212;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.310 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "2E2C73DBC5965751BCCCF754CE33A943")
    public String getLocale() {
        String varB4EAC82CA7396A68D541C85D26508E83_151532589 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_151532589 = mSubtypeLocale;
        varB4EAC82CA7396A68D541C85D26508E83_151532589.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_151532589;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.311 -0400", hash_original_method = "960AAB243B4CAAAE714C0B1CB581C452", hash_generated_method = "7660170892ED5C4A6722893C11297E81")
    public String getMode() {
        String varB4EAC82CA7396A68D541C85D26508E83_781565961 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_781565961 = mSubtypeMode;
        varB4EAC82CA7396A68D541C85D26508E83_781565961.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_781565961;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.311 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "0753F999D02A38C55D19F259ED27FF7A")
    public String getExtraValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_610797158 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_610797158 = mSubtypeExtraValue;
        varB4EAC82CA7396A68D541C85D26508E83_610797158.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_610797158;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.312 -0400", hash_original_method = "5D42329342BA940BF0C680758D792174", hash_generated_method = "252A70E067EBEE55A57B0A65DCDC9077")
    public boolean isAuxiliary() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988612886 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_988612886;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.312 -0400", hash_original_method = "77DDEB2A23977DBB23EB90699D4CDB8E", hash_generated_method = "C0FABFBDA891B3AC52C76F90829A3F1E")
    public boolean overridesImplicitlyEnabledSubtype() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1313823225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1313823225;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.313 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "98DA32BA374CCA3A567364163AC6C17A")
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1465500568 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_396399442 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_856985359 = null; 
        final Locale locale = constructLocaleFromString(mSubtypeLocale);
        String localeStr;
        localeStr = locale.getDisplayName();
        localeStr = mSubtypeLocale;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1465500568 = localeStr;
        } 
        final CharSequence subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        {
            boolean var8CAF5C55CF3F150CA75A24E410BC500C_1889135455 = (!TextUtils.isEmpty(subtypeName));
            {
                varB4EAC82CA7396A68D541C85D26508E83_396399442 = String.format(subtypeName.toString(), localeStr);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_856985359 = localeStr;
            } 
        } 
        addTaint(context.getTaint());
        addTaint(packageName.getTaint());
        addTaint(appInfo.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1910771352; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1910771352 = varB4EAC82CA7396A68D541C85D26508E83_1465500568;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1910771352 = varB4EAC82CA7396A68D541C85D26508E83_396399442;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1910771352 = varB4EAC82CA7396A68D541C85D26508E83_856985359;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1910771352.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1910771352;
        
        
        
        
            
        
        
                
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.313 -0400", hash_original_method = "2837AE7076837B91930C208632EE903B", hash_generated_method = "F364AB6D14FD1C7DE325F55EF6C2DCF3")
    private HashMap<String, String> getExtraValueHashMap() {
        HashMap<String, String> varB4EAC82CA7396A68D541C85D26508E83_1277042932 = null; 
        {
            mExtraValueHashMapCache = new HashMap<String, String>();
            final String[] pairs = mSubtypeExtraValue.split(EXTRA_VALUE_PAIR_SEPARATOR);
            final int N = pairs.length;
            {
                int i = 0;
                {
                    final String[] pair = pairs[i].split(EXTRA_VALUE_KEY_VALUE_SEPARATOR);
                    {
                        mExtraValueHashMapCache.put(pair[0], null);
                    } 
                    {
                        mExtraValueHashMapCache.put(pair[0], pair[1]);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1277042932 = mExtraValueHashMapCache;
        varB4EAC82CA7396A68D541C85D26508E83_1277042932.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1277042932;
        
        
            
            
            
            
                
                
                    
                
                    
                        
                    
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.314 -0400", hash_original_method = "92E492941FA288BA531CB37717D8F415", hash_generated_method = "1A813D36BA4DB8C5FF9C04D49EF9F091")
    public boolean containsExtraValueKey(String key) {
        boolean var879F87ED6CB8D534D2470D87EF542CAF_1705557598 = (getExtraValueHashMap().containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734723496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734723496;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.314 -0400", hash_original_method = "E26D6519ACBB2E66A4CA57F07B1B4B16", hash_generated_method = "3A3A0475DA7CDCF68D263FDEC3BFA227")
    public String getExtraValueOf(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1214442623 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1214442623 = getExtraValueHashMap().get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1214442623.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1214442623;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.314 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "484F41F9F9247A691725B55034CA1957")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_783004940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_783004940;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.315 -0400", hash_original_method = "0FAD58BA0D22A8990D6C7F18B4CA40E4", hash_generated_method = "3B156862B24AA120761C81162DE045F7")
    @Override
    public boolean equals(Object o) {
        {
            InputMethodSubtype subtype = (InputMethodSubtype) o;
            boolean varEEE5801028341F2EB0F803658C2232D1_528729713 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getMode().equals(getMode()))
                && (subtype.getIconResId() == getIconResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue()))
                && (subtype.isAuxiliary() == isAuxiliary()));
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693319410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693319410;
        
        
            
            
                
                
                
                
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.315 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "74859040AA224BC3A928144E94A3E15B")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_604522775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_604522775;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.316 -0400", hash_original_method = "C419DC818714EC441C397D1AF0BAA00C", hash_generated_method = "4DF859947683BD28549093E3BA115743")
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.316 -0400", hash_original_field = "FD70D5B6597BA4E41960E8E543899F2B", hash_generated_field = "0AA99DCA2CD79A11571781F4310E259D")

    private static final String TAG = InputMethodSubtype.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.316 -0400", hash_original_field = "DE020776BE334FC0AE5FDE74CF87BE11", hash_generated_field = "13FC4081C4F1C82C9C901E7C8DAAE61D")

    private static final String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.316 -0400", hash_original_field = "633819F0CE2FE910B1C0DC1AB3415993", hash_generated_field = "288DE97156AEA20FA476F272E7A6DA36")

    private static final String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.316 -0400", hash_original_field = "87C3F14D000790670A5C8909273086FE", hash_generated_field = "F6FA24A5E0DEFDBE30BDE6B1502A4BF4")

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

