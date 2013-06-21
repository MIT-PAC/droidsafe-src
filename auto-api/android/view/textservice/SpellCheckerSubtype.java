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
    private int mSubtypeHashCode;
    private int mSubtypeNameResId;
    private String mSubtypeLocale;
    private String mSubtypeExtraValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.489 -0400", hash_original_method = "3A30DA6D8D85E7F9D6AFF40F9B2BC528", hash_generated_method = "6B36E49182B031C967B8CBC632FC8505")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckerSubtype(int nameId, String locale, String extraValue) {
        dsTaint.addTaint(locale);
        dsTaint.addTaint(extraValue);
        dsTaint.addTaint(nameId);
        mSubtypeLocale = locale != null ? locale : "";
        mSubtypeExtraValue = extraValue != null ? extraValue : "";
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
        // ---------- Original Method ----------
        //mSubtypeNameResId = nameId;
        //mSubtypeLocale = locale != null ? locale : "";
        //mSubtypeExtraValue = extraValue != null ? extraValue : "";
        //mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.489 -0400", hash_original_method = "3B75B8CFEB6B6700A7C113FAE634CC5F", hash_generated_method = "AA90D9190432F36806B4339A67EDC338")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SpellCheckerSubtype(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.489 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "37337A9AFC76FC1E81E9B30E314C814B")
    @DSModeled(DSC.SAFE)
    public int getNameResId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubtypeNameResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.489 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "1219AB9E48D6018F12BF32489CFB6E96")
    @DSModeled(DSC.SAFE)
    public String getLocale() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubtypeLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.489 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "CF80BB26064D7C68FD3101C0093934BF")
    @DSModeled(DSC.SAFE)
    public String getExtraValue() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubtypeExtraValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.489 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "4CA7B61DD6C24A0D261C105B01E498F3")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubtypeHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.490 -0400", hash_original_method = "214F55EDB23FD4CF8A5A66E21291C440", hash_generated_method = "12380B3CD540449319F8EEE5E50E709C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            SpellCheckerSubtype subtype;
            subtype = (SpellCheckerSubtype) o;
            boolean var538F1E8380A7611B70298788CBA49C83_270894614 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue())));
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.490 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "C7A9C4F23E04234E592806310A8403CB")
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
            boolean var8CAF5C55CF3F150CA75A24E410BC500C_1186191678 = (!TextUtils.isEmpty(subtypeName));
            {
                CharSequence varCAE59473585162B683314F148AA41B15_1938101915 = (String.format(subtypeName.toString(), localeStr));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.490 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.491 -0400", hash_original_method = "AC1CB8559B86122857E11C69298B0C2C", hash_generated_method = "09D6EBBB4EE431BCE298B8D72D12F8E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mSubtypeNameResId);
        dest.writeString(mSubtypeLocale);
        dest.writeString(mSubtypeExtraValue);
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

    
    public static final Parcelable.Creator<SpellCheckerSubtype> CREATOR = new Parcelable.Creator<SpellCheckerSubtype>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.491 -0400", hash_original_method = "0AEF6B6A73DAA67659A967ED2D4E69A6", hash_generated_method = "9DC95988670C73EA13D215ACECA3EAB7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SpellCheckerSubtype createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            SpellCheckerSubtype var5334CF28BA03EAA209A23276FCA58031_4619118 = (new SpellCheckerSubtype(source));
            return (SpellCheckerSubtype)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SpellCheckerSubtype(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.491 -0400", hash_original_method = "D3DF61D23BE3223F4B9216C6941BE85D", hash_generated_method = "9504F6E423580C121605F7EDF66BDC43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SpellCheckerSubtype[] newArray(int size) {
            dsTaint.addTaint(size);
            SpellCheckerSubtype[] varC10633F5DAA703B1A079D4D3E0A3F529_1894260993 = (new SpellCheckerSubtype[size]);
            return (SpellCheckerSubtype[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SpellCheckerSubtype[size];
        }

        
}; //Transformed anonymous class
}

