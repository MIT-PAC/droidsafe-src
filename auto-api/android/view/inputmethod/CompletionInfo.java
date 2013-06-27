package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class CompletionInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.926 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "CF2A5FB7C7BB55BD451D113BD690151D")

    private long mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.926 -0400", hash_original_field = "2A02BDE12D932CD9DCA97106D487F8F5", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

    private int mPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.926 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.926 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "35633BB7C9814BC2D57023D255065F26")

    private CharSequence mLabel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.927 -0400", hash_original_method = "38A4F60AF5C7022C0469BD89E2BC1895", hash_generated_method = "D6B60C1928D87BD96AB25374114499A6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.927 -0400", hash_original_method = "D296F749900FBC5242D181AA06D4E27C", hash_generated_method = "667A7C128440F1F71DE8EF37E7CD55D5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.936 -0400", hash_original_method = "2F837EEA33DB685519494240B032A81B", hash_generated_method = "C11433F17D9EF2D0AE8DAB57B3FD60E2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.937 -0400", hash_original_method = "6AF16C815DE6FE4144432EF99CDC825B", hash_generated_method = "EE9927DA6FE2F45F4A293E204E2BAC65")
    public long getId() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1661313293 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1661313293;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.937 -0400", hash_original_method = "88750DD9C7394A9CF6B657A7AF77F3EB", hash_generated_method = "E55F03B061E91F06C0A056E54E65C77A")
    public int getPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574013877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574013877;
        // ---------- Original Method ----------
        //return mPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.938 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "8FF4AE2EEF9B1E79623017CDBF9707B2")
    public CharSequence getText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1073794961 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1073794961 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_1073794961.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1073794961;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.938 -0400", hash_original_method = "4A1E1E1996A16BAAC783C4D4608DA412", hash_generated_method = "8330779FE9E912D5A9BA678B3A26A6F4")
    public CharSequence getLabel() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1285978627 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1285978627 = mLabel;
        varB4EAC82CA7396A68D541C85D26508E83_1285978627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1285978627;
        // ---------- Original Method ----------
        //return mLabel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.946 -0400", hash_original_method = "3B6D1C61D70E52042FDD9DC9240A1E79", hash_generated_method = "58481F3036AFF2BDC441A946DABC52F0")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1099218843 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1099218843 = "CompletionInfo{#" + mPosition + " \"" + mText
                + "\" id=" + mId + " label=" + mLabel + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1099218843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1099218843;
        // ---------- Original Method ----------
        //return "CompletionInfo{#" + mPosition + " \"" + mText
                //+ "\" id=" + mId + " label=" + mLabel + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.949 -0400", hash_original_method = "9E5F84EC05F73AE374617C14B6E91B86", hash_generated_method = "4AC83D29BE9EAA1CCEF4AB2AE1E93383")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mId);
        dest.writeInt(mPosition);
        TextUtils.writeToParcel(mText, dest, flags);
        TextUtils.writeToParcel(mLabel, dest, flags);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeLong(mId);
        //dest.writeInt(mPosition);
        //TextUtils.writeToParcel(mText, dest, flags);
        //TextUtils.writeToParcel(mLabel, dest, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.957 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8ECC05CB473AB35FDB4D00F59D8D41A9")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129355874 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129355874;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.957 -0400", hash_original_field = "31621134870CBAE679681892F3003DDF", hash_generated_field = "B610E87A4A96E260678AA4BA5F15A953")

    public static final Parcelable.Creator<CompletionInfo> CREATOR
            = new Parcelable.Creator<CompletionInfo>() {
        public CompletionInfo createFromParcel(Parcel source) {
            return new CompletionInfo(source);
        }

        public CompletionInfo[] newArray(int size) {
            return new CompletionInfo[size];
        }
    };
}

