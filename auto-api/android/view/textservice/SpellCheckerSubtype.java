package android.view.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final int mSubtypeHashCode;
    private final int mSubtypeNameResId;
    private final String mSubtypeLocale;
    private final String mSubtypeExtraValue;
    public static final Parcelable.Creator<SpellCheckerSubtype> CREATOR = new Parcelable.Creator<SpellCheckerSubtype>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.549 -0400", hash_original_method = "0AEF6B6A73DAA67659A967ED2D4E69A6", hash_generated_method = "BF77A9F0CDECCDDF4AB4A6A2DEA3133B")
        @DSModeled(DSC.SAFE)
        @Override
        public SpellCheckerSubtype createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (SpellCheckerSubtype)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SpellCheckerSubtype(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.549 -0400", hash_original_method = "D3DF61D23BE3223F4B9216C6941BE85D", hash_generated_method = "EE751A15A584136609BD2B691477CE69")
        @DSModeled(DSC.SAFE)
        @Override
        public SpellCheckerSubtype[] newArray(int size) {
            dsTaint.addTaint(size);
            return (SpellCheckerSubtype[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SpellCheckerSubtype[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.549 -0400", hash_original_method = "3A30DA6D8D85E7F9D6AFF40F9B2BC528", hash_generated_method = "3F4EC38C111F2FD6E0410C22E1840740")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckerSubtype(int nameId, String locale, String extraValue) {
        dsTaint.addTaint(locale);
        dsTaint.addTaint(nameId);
        dsTaint.addTaint(extraValue);
        mSubtypeLocale = locale != null ? locale : "";
        mSubtypeExtraValue = extraValue != null ? extraValue : "";
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
        // ---------- Original Method ----------
        //mSubtypeNameResId = nameId;
        //mSubtypeLocale = locale != null ? locale : "";
        //mSubtypeExtraValue = extraValue != null ? extraValue : "";
        //mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.550 -0400", hash_original_method = "3B75B8CFEB6B6700A7C113FAE634CC5F", hash_generated_method = "C304AFF670F29D4FC227B0817AB74CC2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.550 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "3FF94D9438A4B284459924B034566E5B")
    @DSModeled(DSC.SAFE)
    public int getNameResId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubtypeNameResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.550 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "D01FDD9250E580BE0855A53008716A33")
    @DSModeled(DSC.SAFE)
    public String getLocale() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubtypeLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.550 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "ED1B98745750EEA591066B1EC51CA186")
    @DSModeled(DSC.SAFE)
    public String getExtraValue() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubtypeExtraValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.550 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "BD4A8457417A8B46714BB64338F0D52F")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubtypeHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.550 -0400", hash_original_method = "214F55EDB23FD4CF8A5A66E21291C440", hash_generated_method = "09FFC78E0FEC4AFC882497AAC99EE6E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            SpellCheckerSubtype subtype;
            subtype = (SpellCheckerSubtype) o;
            boolean var538F1E8380A7611B70298788CBA49C83_675419509 = ((subtype.hashCode() == hashCode())
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.550 -0400", hash_original_method = "8E1C6298EB66C275DF3380320723757A", hash_generated_method = "00886CCFD2ACF85F97C590A1DA3F58CC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.550 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "7EE791888996068C1331142A15267517")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(appInfo.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        final Locale locale;
        locale = constructLocaleFromString(mSubtypeLocale);
        final String localeStr;
        localeStr = locale.getDisplayName();
        localeStr = mSubtypeLocale;
        final CharSequence subtypeName;
        subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        {
            boolean var8CAF5C55CF3F150CA75A24E410BC500C_109119813 = (!TextUtils.isEmpty(subtypeName));
            {
                CharSequence varCAE59473585162B683314F148AA41B15_708825923 = (String.format(subtypeName.toString(), localeStr));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.551 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.551 -0400", hash_original_method = "AC1CB8559B86122857E11C69298B0C2C", hash_generated_method = "77BFA4B8C8724DB00A9B898E417B691D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.551 -0400", hash_original_method = "C3EB8F3C38068CB5E6BC8AD1B82B692A", hash_generated_method = "AAC5CB824032748E2936F1FF72846D35")
    private static int hashCodeInternal(String locale, String extraValue) {
        return Arrays.hashCode(new Object[] {locale, extraValue});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.551 -0400", hash_original_method = "A5A1976DCF128376F1184597AC290A44", hash_generated_method = "2C785E0CA169EEA5E6624DA603EF3D85")
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

    
}


