package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class CompletionInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.113 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "CF2A5FB7C7BB55BD451D113BD690151D")

    private long mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.113 -0400", hash_original_field = "2A02BDE12D932CD9DCA97106D487F8F5", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

    private int mPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.113 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.113 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "35633BB7C9814BC2D57023D255065F26")

    private CharSequence mLabel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.114 -0400", hash_original_method = "38A4F60AF5C7022C0469BD89E2BC1895", hash_generated_method = "D6B60C1928D87BD96AB25374114499A6")
    public  CompletionInfo(long id, int index, CharSequence text) {
        mId = id;
        mPosition = index;
        mText = text;
        mLabel = null;
        // ---------- Original Method ----------
        //mId = id;
        //mPosition = index;
        //mText = text;
        //mLabel = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.115 -0400", hash_original_method = "D296F749900FBC5242D181AA06D4E27C", hash_generated_method = "667A7C128440F1F71DE8EF37E7CD55D5")
    public  CompletionInfo(long id, int index, CharSequence text, CharSequence label) {
        mId = id;
        mPosition = index;
        mText = text;
        mLabel = label;
        // ---------- Original Method ----------
        //mId = id;
        //mPosition = index;
        //mText = text;
        //mLabel = label;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.116 -0400", hash_original_method = "2F837EEA33DB685519494240B032A81B", hash_generated_method = "C11433F17D9EF2D0AE8DAB57B3FD60E2")
    private  CompletionInfo(Parcel source) {
        mId = source.readLong();
        mPosition = source.readInt();
        mText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        mLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        // ---------- Original Method ----------
        //mId = source.readLong();
        //mPosition = source.readInt();
        //mText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        //mLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.116 -0400", hash_original_method = "6AF16C815DE6FE4144432EF99CDC825B", hash_generated_method = "6C258E16FC11F3D1249214261BE6AC9D")
    public long getId() {
        long var6AC7F06B6413A1BE9C136DC7DF0D2B60_62654707 = (mId);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1369112411 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1369112411;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.116 -0400", hash_original_method = "88750DD9C7394A9CF6B657A7AF77F3EB", hash_generated_method = "FAA33287CF070BEA32544BD9A66924BC")
    public int getPosition() {
        int var2A02BDE12D932CD9DCA97106D487F8F5_1893337940 = (mPosition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153456756 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153456756;
        // ---------- Original Method ----------
        //return mPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.117 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "236F8DE10A43651A4A0A8C2A3052086D")
    public CharSequence getText() {
CharSequence var7F7ECB4B14362FFBA020956966B29A66_1319221010 =         mText;
        var7F7ECB4B14362FFBA020956966B29A66_1319221010.addTaint(taint);
        return var7F7ECB4B14362FFBA020956966B29A66_1319221010;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.117 -0400", hash_original_method = "4A1E1E1996A16BAAC783C4D4608DA412", hash_generated_method = "319C665B31581E14A632456789B104F5")
    public CharSequence getLabel() {
CharSequence var21E4126FD2EB7A90E0B7B540C066F29D_1142272326 =         mLabel;
        var21E4126FD2EB7A90E0B7B540C066F29D_1142272326.addTaint(taint);
        return var21E4126FD2EB7A90E0B7B540C066F29D_1142272326;
        // ---------- Original Method ----------
        //return mLabel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.117 -0400", hash_original_method = "3B6D1C61D70E52042FDD9DC9240A1E79", hash_generated_method = "D2F2ABF99F0E9C3571D7B0CE85EBC81A")
    @Override
    public String toString() {
String var589E935FF15E9B2705C963D280AA9F32_2100949058 =         "CompletionInfo{#" + mPosition + " \"" + mText
                + "\" id=" + mId + " label=" + mLabel + "}";
        var589E935FF15E9B2705C963D280AA9F32_2100949058.addTaint(taint);
        return var589E935FF15E9B2705C963D280AA9F32_2100949058;
        // ---------- Original Method ----------
        //return "CompletionInfo{#" + mPosition + " \"" + mText
                //+ "\" id=" + mId + " label=" + mLabel + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.118 -0400", hash_original_method = "9E5F84EC05F73AE374617C14B6E91B86", hash_generated_method = "9879AA80B6B83FF505E7B4F125A8C8EE")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeLong(mId);
        dest.writeInt(mPosition);
        TextUtils.writeToParcel(mText, dest, flags);
        TextUtils.writeToParcel(mLabel, dest, flags);
        // ---------- Original Method ----------
        //dest.writeLong(mId);
        //dest.writeInt(mPosition);
        //TextUtils.writeToParcel(mText, dest, flags);
        //TextUtils.writeToParcel(mLabel, dest, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.118 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D7F237E5B29F86CF2B5B95A0D37EFF74")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_447244446 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1343859793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1343859793;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.118 -0400", hash_original_field = "31621134870CBAE679681892F3003DDF", hash_generated_field = "B610E87A4A96E260678AA4BA5F15A953")

    public static final Parcelable.Creator<CompletionInfo> CREATOR
            = new Parcelable.Creator<CompletionInfo>() {
        public CompletionInfo createFromParcel(Parcel source) {
            return new CompletionInfo(source);
        }

        public CompletionInfo[] newArray(int size) {
            return new CompletionInfo[size];
        }
    };
    // orphaned legacy method
    public CompletionInfo createFromParcel(Parcel source) {
            return new CompletionInfo(source);
        }
    
    // orphaned legacy method
    public CompletionInfo[] newArray(int size) {
            return new CompletionInfo[size];
        }
    
}

