package android.view.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.692 -0400", hash_original_field = "DB752714D7C5597F6D4538948E3D4382", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private int mSubtypeHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.692 -0400", hash_original_field = "AE10E74C5B8FF193877E0EC967173BB0", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private int mSubtypeNameResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.692 -0400", hash_original_field = "62668E4A833F1CB4D52D80EE2676B489", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private String mSubtypeLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.692 -0400", hash_original_field = "925770EC9378B8FB525692C9358CB66A", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private String mSubtypeExtraValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.693 -0400", hash_original_method = "3A30DA6D8D85E7F9D6AFF40F9B2BC528", hash_generated_method = "980FDD3E96F63120DD6D6A74E5B9D797")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.694 -0400", hash_original_method = "3B75B8CFEB6B6700A7C113FAE634CC5F", hash_generated_method = "39C8675410726AB5491DA3D839BFB49B")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.694 -0400", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "AC82A8C2D49AE9EB184DFF13734E1FB8")
    public int getNameResId() {
        int varAE10E74C5B8FF193877E0EC967173BB0_1603886517 = (mSubtypeNameResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429810748 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429810748;
        // ---------- Original Method ----------
        //return mSubtypeNameResId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.695 -0400", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "D01DBF6D6D376B6D30787DFD8DC52D71")
    public String getLocale() {
String varC07DAECEA29B71A30EF35B60B8076743_613725145 =         mSubtypeLocale;
        varC07DAECEA29B71A30EF35B60B8076743_613725145.addTaint(taint);
        return varC07DAECEA29B71A30EF35B60B8076743_613725145;
        // ---------- Original Method ----------
        //return mSubtypeLocale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.695 -0400", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "1F0D4AF48C43292B6BA72816FD55FAF3")
    public String getExtraValue() {
String varD5103786A790F3D4881070784C5A1DFD_1744972808 =         mSubtypeExtraValue;
        varD5103786A790F3D4881070784C5A1DFD_1744972808.addTaint(taint);
        return varD5103786A790F3D4881070784C5A1DFD_1744972808;
        // ---------- Original Method ----------
        //return mSubtypeExtraValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.695 -0400", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "0C8A6580D494B9E9B209E73370D10DE5")
    @Override
    public int hashCode() {
        int varDB752714D7C5597F6D4538948E3D4382_1626087767 = (mSubtypeHashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119904680 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119904680;
        // ---------- Original Method ----------
        //return mSubtypeHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.695 -0400", hash_original_method = "214F55EDB23FD4CF8A5A66E21291C440", hash_generated_method = "4C00EA60753F03A30028A6DAEF7DC831")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o instanceof SpellCheckerSubtype)        
        {
            SpellCheckerSubtype subtype = (SpellCheckerSubtype) o;
            boolean var4174AC03594A871CC98E9C72F0B7DAE8_1691047885 = ((subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue())));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1567888576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1567888576;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_847610590 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595679631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_595679631;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.696 -0400", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "6A9E9A4AC6891F9B2DB22C35B0A450F2")
    public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        addTaint(appInfo.getTaint());
        addTaint(packageName.getTaint());
        addTaint(context.getTaint());
        final Locale locale = constructLocaleFromString(mSubtypeLocale);
        final String localeStr = locale != null ? locale.getDisplayName() : mSubtypeLocale;
    if(mSubtypeNameResId == 0)        
        {
CharSequence varF1554E4544B9FE124AB662A8FBD78003_214628802 =             localeStr;
            varF1554E4544B9FE124AB662A8FBD78003_214628802.addTaint(taint);
            return varF1554E4544B9FE124AB662A8FBD78003_214628802;
        } //End block
        final CharSequence subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
    if(!TextUtils.isEmpty(subtypeName))        
        {
CharSequence var5322360A9D2672FE8DDC97C43EADEEB5_502149167 =             String.format(subtypeName.toString(), localeStr);
            var5322360A9D2672FE8DDC97C43EADEEB5_502149167.addTaint(taint);
            return var5322360A9D2672FE8DDC97C43EADEEB5_502149167;
        } //End block
        else
        {
CharSequence varF1554E4544B9FE124AB662A8FBD78003_1365447033 =             localeStr;
            varF1554E4544B9FE124AB662A8FBD78003_1365447033.addTaint(taint);
            return varF1554E4544B9FE124AB662A8FBD78003_1365447033;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.697 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7030F884C49101934438E31F495F81DA")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_726254633 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497789590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497789590;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.697 -0400", hash_original_method = "AC1CB8559B86122857E11C69298B0C2C", hash_generated_method = "63DAF4D2DF6DCF4D5AAA97C477D14334")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.698 -0400", hash_original_field = "5A5854B9FB29CE0EBE5D9E127472BB34", hash_generated_field = "964CF97E5D9081BC2EF059D5B5A4010C")

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

