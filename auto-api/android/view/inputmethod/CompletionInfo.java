package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class CompletionInfo implements Parcelable {
    private final long mId;
    private final int mPosition;
    private final CharSequence mText;
    private final CharSequence mLabel;
    public static final Parcelable.Creator<CompletionInfo> CREATOR = new Parcelable.Creator<CompletionInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.053 -0400", hash_original_method = "3E9AF51E6B6E69C18FAD3C8C0C4128B0", hash_generated_method = "36AD0CD0BD5294BF85AA26AA269F8F99")
        @DSModeled(DSC.SAFE)
        public CompletionInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (CompletionInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CompletionInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.053 -0400", hash_original_method = "9EBF5EB5FCCD856E192DB9AAF0B8CB87", hash_generated_method = "563E08ADE0C3A6B3088D1CB52FFAEEAE")
        @DSModeled(DSC.SAFE)
        public CompletionInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (CompletionInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CompletionInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.053 -0400", hash_original_method = "38A4F60AF5C7022C0469BD89E2BC1895", hash_generated_method = "ABC7D1FC7AE38EFE939857E2B219E0E4")
    @DSModeled(DSC.SAFE)
    public CompletionInfo(long id, int index, CharSequence text) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(index);
        dsTaint.addTaint(text);
        mLabel = null;
        // ---------- Original Method ----------
        //mId = id;
        //mPosition = index;
        //mText = text;
        //mLabel = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.053 -0400", hash_original_method = "D296F749900FBC5242D181AA06D4E27C", hash_generated_method = "C3AAD0443CCB6F209F26BDB31B48F7B7")
    @DSModeled(DSC.SAFE)
    public CompletionInfo(long id, int index, CharSequence text, CharSequence label) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(index);
        dsTaint.addTaint(text);
        dsTaint.addTaint(label);
        // ---------- Original Method ----------
        //mId = id;
        //mPosition = index;
        //mText = text;
        //mLabel = label;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.053 -0400", hash_original_method = "2F837EEA33DB685519494240B032A81B", hash_generated_method = "0F2FB9DB2C8DE119A3C963B7CF3C3821")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CompletionInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.053 -0400", hash_original_method = "6AF16C815DE6FE4144432EF99CDC825B", hash_generated_method = "9711EEEC56228717A16799841D114BDD")
    @DSModeled(DSC.SAFE)
    public long getId() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.053 -0400", hash_original_method = "88750DD9C7394A9CF6B657A7AF77F3EB", hash_generated_method = "581EAA441C9BFE1C4A555E2FA2D2F0E0")
    @DSModeled(DSC.SAFE)
    public int getPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.054 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "928F7BAE9EC962F9C33EAB96518969CD")
    @DSModeled(DSC.SAFE)
    public CharSequence getText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.054 -0400", hash_original_method = "4A1E1E1996A16BAAC783C4D4608DA412", hash_generated_method = "89416D521A5944D040EB08BCF518263B")
    @DSModeled(DSC.SAFE)
    public CharSequence getLabel() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mLabel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.054 -0400", hash_original_method = "3B6D1C61D70E52042FDD9DC9240A1E79", hash_generated_method = "D70AFB7A3DF473E6B266F3A38F8C59E9")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "CompletionInfo{#" + mPosition + " \"" + mText
                //+ "\" id=" + mId + " label=" + mLabel + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.054 -0400", hash_original_method = "9E5F84EC05F73AE374617C14B6E91B86", hash_generated_method = "7EF1BDAC40EBAAA6A9E06B67DB4AD52A")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.054 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
}


