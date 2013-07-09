package android.view.textservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public final class SpellCheckerSubtype implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.426 -0400", hash_original_field = "DB752714D7C5597F6D4538948E3D4382", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private int mSubtypeHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.426 -0400", hash_original_field = "AE10E74C5B8FF193877E0EC967173BB0", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private int mSubtypeNameResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.426 -0400", hash_original_field = "62668E4A833F1CB4D52D80EE2676B489", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private String mSubtypeLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.426 -0400", hash_original_field = "925770EC9378B8FB525692C9358CB66A", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private String mSubtypeExtraValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.427 -0400", hash_original_method = "3A30DA6D8D85E7F9D6AFF40F9B2BC528", hash_generated_method = "980FDD3E96F63120DD6D6A74E5B9D797")
    public  SpellCheckerSubtype(int nameId, String locale, String extraValue) {
        mSubtypeNameResId = nameId;
        mSubtypeLocale = locale != null ? locale : "";
        mSubtypeExtraValue = extraValue != null ? extraValue : "";
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.427 -0400", hash_original_method = "3B75B8CFEB6B6700A7C113FAE634CC5F", hash_generated_method = "39C8675410726AB5491DA3D839BFB49B")
      SpellCheckerSubtype(Parcel source) {
        String s;
        mSubtypeNameResId = source.readInt();
        s = source.readString();
        mSubtypeLocale = s != null ? s : "";
        s = source.readString();
        mSubtypeExtraValue = s != null ? s : "";
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.428 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "319174AA90FD630D84FCA7B4EA7DD7F5")
    public int getNameResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178787360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178787360;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.429 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "DF4B442544914F130EFC2238EB2DD498")
    public String getLocale() {
        String varB4EAC82CA7396A68D541C85D26508E83_906748603 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_906748603 = mSubtypeLocale;
        varB4EAC82CA7396A68D541C85D26508E83_906748603.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_906748603;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.429 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "717B5FF7A957D694E3D90DA573FB92D1")
    public String getExtraValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1227683657 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1227683657 = mSubtypeExtraValue;
        varB4EAC82CA7396A68D541C85D26508E83_1227683657.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1227683657;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.430 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "B3E072097D5E0183DE239DDF3B19FE86")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_99091248 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_99091248;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.430 -0400", hash_original_method = "214F55EDB23FD4CF8A5A66E21291C440", hash_generated_method = "867C3012DA2FAB47AA6699F2BB3DC0BA")
    @Override
    public boolean equals(Object o) {
        {
            SpellCheckerSubtype subtype = (SpellCheckerSubtype) o;
            boolean var538F1E8380A7611B70298788CBA49C83_1093676465 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue())));
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_491079279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_491079279;
        
        
            
            
                
                
                
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.432 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "BCF5F33EB62D8E4F09B6615ACC8807C2")
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1040235140 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_98503635 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_116236274 = null; 
        final Locale locale = constructLocaleFromString(mSubtypeLocale);
        String localeStr;
        localeStr = locale.getDisplayName();
        localeStr = mSubtypeLocale;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1040235140 = localeStr;
        } 
        final CharSequence subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        {
            boolean var8CAF5C55CF3F150CA75A24E410BC500C_536742496 = (!TextUtils.isEmpty(subtypeName));
            {
                varB4EAC82CA7396A68D541C85D26508E83_98503635 = String.format(subtypeName.toString(), localeStr);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_116236274 = localeStr;
            } 
        } 
        addTaint(context.getTaint());
        addTaint(packageName.getTaint());
        addTaint(appInfo.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1005119763; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1005119763 = varB4EAC82CA7396A68D541C85D26508E83_1040235140;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1005119763 = varB4EAC82CA7396A68D541C85D26508E83_98503635;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1005119763 = varB4EAC82CA7396A68D541C85D26508E83_116236274;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1005119763.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1005119763;
        
        
        
        
            
        
        
                
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.432 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "46204327F298FBDCBDBE5678F579F817")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283664332 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283664332;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.432 -0400", hash_original_method = "AC1CB8559B86122857E11C69298B0C2C", hash_generated_method = "00FB40818FD117654118A6E5FA9705C0")
    @Override
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeInt(mSubtypeNameResId);
        dest.writeString(mSubtypeLocale);
        dest.writeString(mSubtypeExtraValue);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int hashCodeInternal(String locale, String extraValue) {
        return Arrays.hashCode(new Object[] {locale, extraValue});
    }

    
    @DSModeled(DSC.SAFE)
    public static List<SpellCheckerSubtype> sort(Context context, int flags, SpellCheckerInfo sci,
            List<SpellCheckerSubtype> subtypeList) {
        if (sci == null) return subtypeList;
        final HashSet<SpellCheckerSubtype> subtypesSet = new HashSet<SpellCheckerSubtype>(
                subtypeList);
        final ArrayList<SpellCheckerSubtype> sortedList = new ArrayList<SpellCheckerSubtype>();
        int N = sci.getSubtypeCount();
        for (int i = 0; i < N; ++i) {
            SpellCheckerSubtype subtype = sci.getSubtypeAt(i);
            if (subtypesSet.contains(subtype)) {
                sortedList.add(subtype);
                subtypesSet.remove(subtype);
            }
        }
        for (SpellCheckerSubtype subtype: subtypesSet) {
            sortedList.add(subtype);
        }
        return sortedList;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.433 -0400", hash_original_field = "5A5854B9FB29CE0EBE5D9E127472BB34", hash_generated_field = "964CF97E5D9081BC2EF059D5B5A4010C")

    public static final Parcelable.Creator<SpellCheckerSubtype> CREATOR
            = new Parcelable.Creator<SpellCheckerSubtype>() {
        @Override
        public SpellCheckerSubtype createFromParcel(Parcel source) {
            return new SpellCheckerSubtype(source);
        }

        @Override
        public SpellCheckerSubtype[] newArray(int size) {
            return new SpellCheckerSubtype[size];
        }
    };
    
}

