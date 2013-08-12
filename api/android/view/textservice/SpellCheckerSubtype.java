package android.view.textservice;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;





public final class SpellCheckerSubtype implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.970 -0400", hash_original_field = "DB752714D7C5597F6D4538948E3D4382", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private int mSubtypeHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.970 -0400", hash_original_field = "AE10E74C5B8FF193877E0EC967173BB0", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private int mSubtypeNameResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.970 -0400", hash_original_field = "62668E4A833F1CB4D52D80EE2676B489", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private String mSubtypeLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.970 -0400", hash_original_field = "925770EC9378B8FB525692C9358CB66A", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private String mSubtypeExtraValue;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.971 -0400", hash_original_method = "3A30DA6D8D85E7F9D6AFF40F9B2BC528", hash_generated_method = "980FDD3E96F63120DD6D6A74E5B9D797")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.971 -0400", hash_original_method = "3B75B8CFEB6B6700A7C113FAE634CC5F", hash_generated_method = "39C8675410726AB5491DA3D839BFB49B")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.972 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "0C2CA0EA9956023A46DE2C75DE78E30A")
    public int getNameResId() {
        int varAE10E74C5B8FF193877E0EC967173BB0_900751823 = (mSubtypeNameResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587818654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587818654;
        // ---------- Original Method ----------
        //return mSubtypeNameResId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.972 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "74E7FA1D7904B9BDDB407EAA2D8AE499")
    public String getLocale() {
String varC07DAECEA29B71A30EF35B60B8076743_1117941380 =         mSubtypeLocale;
        varC07DAECEA29B71A30EF35B60B8076743_1117941380.addTaint(taint);
        return varC07DAECEA29B71A30EF35B60B8076743_1117941380;
        // ---------- Original Method ----------
        //return mSubtypeLocale;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.972 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "7813AFB956983C2089A6150BDDCBC04B")
    public String getExtraValue() {
String varD5103786A790F3D4881070784C5A1DFD_2136825052 =         mSubtypeExtraValue;
        varD5103786A790F3D4881070784C5A1DFD_2136825052.addTaint(taint);
        return varD5103786A790F3D4881070784C5A1DFD_2136825052;
        // ---------- Original Method ----------
        //return mSubtypeExtraValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.972 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "8D787C6446B42CDAD9D6C357559E1EA1")
    @Override
    public int hashCode() {
        int varDB752714D7C5597F6D4538948E3D4382_1158358254 = (mSubtypeHashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490818500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490818500;
        // ---------- Original Method ----------
        //return mSubtypeHashCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.973 -0400", hash_original_method = "214F55EDB23FD4CF8A5A66E21291C440", hash_generated_method = "AA7CB7A8C4CE63FB91D0C4DE8266CFB3")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o instanceof SpellCheckerSubtype)        
        {
            SpellCheckerSubtype subtype = (SpellCheckerSubtype) o;
            boolean var4174AC03594A871CC98E9C72F0B7DAE8_971123923 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue())));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043872722 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043872722;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2107255660 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_706933476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_706933476;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.974 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "5D26566A761275671ACB096D2007E123")
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        addTaint(appInfo.getTaint());
        addTaint(packageName.getTaint());
        addTaint(context.getTaint());
        final Locale locale = constructLocaleFromString(mSubtypeLocale);
        final String localeStr = locale != null ? locale.getDisplayName() : mSubtypeLocale;
        if(mSubtypeNameResId == 0)        
        {
CharSequence varF1554E4544B9FE124AB662A8FBD78003_1603052318 =             localeStr;
            varF1554E4544B9FE124AB662A8FBD78003_1603052318.addTaint(taint);
            return varF1554E4544B9FE124AB662A8FBD78003_1603052318;
        } //End block
        final CharSequence subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        if(!TextUtils.isEmpty(subtypeName))        
        {
CharSequence var5322360A9D2672FE8DDC97C43EADEEB5_679147424 =             String.format(subtypeName.toString(), localeStr);
            var5322360A9D2672FE8DDC97C43EADEEB5_679147424.addTaint(taint);
            return var5322360A9D2672FE8DDC97C43EADEEB5_679147424;
        } //End block
        else
        {
CharSequence varF1554E4544B9FE124AB662A8FBD78003_1831196585 =             localeStr;
            varF1554E4544B9FE124AB662A8FBD78003_1831196585.addTaint(taint);
            return varF1554E4544B9FE124AB662A8FBD78003_1831196585;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.975 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E2407F1524FF40BCF56DDB45117724DA")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2056639377 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334783180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334783180;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.975 -0400", hash_original_method = "AC1CB8559B86122857E11C69298B0C2C", hash_generated_method = "63DAF4D2DF6DCF4D5AAA97C477D14334")
    @Override
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        dest.writeInt(mSubtypeNameResId);
        dest.writeString(mSubtypeLocale);
        dest.writeString(mSubtypeExtraValue);
        // ---------- Original Method ----------
        //dest.writeInt(mSubtypeNameResId);
        //dest.writeString(mSubtypeLocale);
        //dest.writeString(mSubtypeExtraValue);
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.976 -0400", hash_original_field = "5A5854B9FB29CE0EBE5D9E127472BB34", hash_generated_field = "964CF97E5D9081BC2EF059D5B5A4010C")

    public static final Parcelable.Creator<SpellCheckerSubtype> CREATOR
            = new Parcelable.Creator<SpellCheckerSubtype>() {
        @DSModeled(DSC.SAFE)
        @Override
        public SpellCheckerSubtype createFromParcel(Parcel source) {
            return new SpellCheckerSubtype(source);
        }

        @DSModeled(DSC.SAFE)
        @Override
        public SpellCheckerSubtype[] newArray(int size) {
            return new SpellCheckerSubtype[size];
        }
    };
}

