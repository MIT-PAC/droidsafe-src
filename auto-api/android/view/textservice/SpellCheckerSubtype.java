package android.view.textservice;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public final class SpellCheckerSubtype implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.708 -0400", hash_original_field = "DB752714D7C5597F6D4538948E3D4382", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private int mSubtypeHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.708 -0400", hash_original_field = "AE10E74C5B8FF193877E0EC967173BB0", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private int mSubtypeNameResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.708 -0400", hash_original_field = "62668E4A833F1CB4D52D80EE2676B489", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private String mSubtypeLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.708 -0400", hash_original_field = "925770EC9378B8FB525692C9358CB66A", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private String mSubtypeExtraValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.708 -0400", hash_original_method = "3A30DA6D8D85E7F9D6AFF40F9B2BC528", hash_generated_method = "980FDD3E96F63120DD6D6A74E5B9D797")
    public  SpellCheckerSubtype(int nameId, String locale, String extraValue) {
        mSubtypeNameResId = nameId;
        mSubtypeLocale = locale != null ? locale : "";
        mSubtypeExtraValue = extraValue != null ? extraValue : "";
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
        // ---------- Original Method ----------
        //mSubtypeNameResId = nameId;
        //mSubtypeLocale = locale != null ? locale : "";
        //mSubtypeExtraValue = extraValue != null ? extraValue : "";
        //mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.709 -0400", hash_original_method = "3B75B8CFEB6B6700A7C113FAE634CC5F", hash_generated_method = "39C8675410726AB5491DA3D839BFB49B")
      SpellCheckerSubtype(Parcel source) {
        String s;
        mSubtypeNameResId = source.readInt();
        s = source.readString();
        mSubtypeLocale = s != null ? s : "";
        s = source.readString();
        mSubtypeExtraValue = s != null ? s : "";
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
        // ---------- Original Method ----------
        //String s;
        //mSubtypeNameResId = source.readInt();
        //s = source.readString();
        //mSubtypeLocale = s != null ? s : "";
        //s = source.readString();
        //mSubtypeExtraValue = s != null ? s : "";
        //mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.709 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "A96EB59DDDB768FA0E74BADFF77D5D58")
    public int getNameResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027708919 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027708919;
        // ---------- Original Method ----------
        //return mSubtypeNameResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.710 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "9E0A08213FEF4D64D793413E720B4FCE")
    public String getLocale() {
        String varB4EAC82CA7396A68D541C85D26508E83_550911277 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_550911277 = mSubtypeLocale;
        varB4EAC82CA7396A68D541C85D26508E83_550911277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_550911277;
        // ---------- Original Method ----------
        //return mSubtypeLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.710 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "4C4109C357089130DA957A0E07EA9540")
    public String getExtraValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1561119725 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1561119725 = mSubtypeExtraValue;
        varB4EAC82CA7396A68D541C85D26508E83_1561119725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1561119725;
        // ---------- Original Method ----------
        //return mSubtypeExtraValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.711 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "FE68AABFD976DD1F8F3581A454D39242")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134094399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134094399;
        // ---------- Original Method ----------
        //return mSubtypeHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.722 -0400", hash_original_method = "214F55EDB23FD4CF8A5A66E21291C440", hash_generated_method = "DC3F99B5B369128899B62A6048EB3247")
    @Override
    public boolean equals(Object o) {
        {
            SpellCheckerSubtype subtype;
            subtype = (SpellCheckerSubtype) o;
            boolean var538F1E8380A7611B70298788CBA49C83_1760205684 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue())));
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016846154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016846154;
        // ---------- Original Method ----------
        //if (o instanceof SpellCheckerSubtype) {
            //SpellCheckerSubtype subtype = (SpellCheckerSubtype) o;
            //return (subtype.hashCode() == hashCode())
                //&& (subtype.getNameResId() == getNameResId())
                //&& (subtype.getLocale().equals(getLocale()))
                //&& (subtype.getExtraValue().equals(getExtraValue()));
        //}
        //return false;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.724 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "CC3D3BC53A02C59BE4804C6B54ED2C68")
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_513178287 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_652984978 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_609641018 = null; //Variable for return #3
        Locale locale;
        locale = constructLocaleFromString(mSubtypeLocale);
        String localeStr;
        localeStr = locale.getDisplayName();
        localeStr = mSubtypeLocale;
        {
            varB4EAC82CA7396A68D541C85D26508E83_513178287 = localeStr;
        } //End block
        CharSequence subtypeName;
        subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        {
            boolean var8CAF5C55CF3F150CA75A24E410BC500C_559813323 = (!TextUtils.isEmpty(subtypeName));
            {
                varB4EAC82CA7396A68D541C85D26508E83_652984978 = String.format(subtypeName.toString(), localeStr);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_609641018 = localeStr;
            } //End block
        } //End collapsed parenthetic
        addTaint(context.getTaint());
        addTaint(packageName.getTaint());
        addTaint(appInfo.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_858605051; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_858605051 = varB4EAC82CA7396A68D541C85D26508E83_513178287;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_858605051 = varB4EAC82CA7396A68D541C85D26508E83_652984978;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_858605051 = varB4EAC82CA7396A68D541C85D26508E83_609641018;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_858605051.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_858605051;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.734 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2C0614F0C1142C0C8B90723F35E74031")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149737042 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149737042;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.742 -0400", hash_original_method = "AC1CB8559B86122857E11C69298B0C2C", hash_generated_method = "00FB40818FD117654118A6E5FA9705C0")
    @Override
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeInt(mSubtypeNameResId);
        dest.writeString(mSubtypeLocale);
        dest.writeString(mSubtypeExtraValue);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //dest.writeInt(mSubtypeNameResId);
        //dest.writeString(mSubtypeLocale);
        //dest.writeString(mSubtypeExtraValue);
    }

    
        private static int hashCodeInternal(String locale, String extraValue) {
        return Arrays.hashCode(new Object[] {locale, extraValue});
    }

    
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.743 -0400", hash_original_field = "5A5854B9FB29CE0EBE5D9E127472BB34", hash_generated_field = "964CF97E5D9081BC2EF059D5B5A4010C")

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

