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
    private long mId;
    private int mPosition;
    private CharSequence mText;
    private CharSequence mLabel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.252 -0400", hash_original_method = "38A4F60AF5C7022C0469BD89E2BC1895", hash_generated_method = "3E3B41533FE18F3B7DE0D0E9CDDBAEEC")
    @DSModeled(DSC.SAFE)
    public CompletionInfo(long id, int index, CharSequence text) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        mLabel = null;
        // ---------- Original Method ----------
        //mId = id;
        //mPosition = index;
        //mText = text;
        //mLabel = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.254 -0400", hash_original_method = "D296F749900FBC5242D181AA06D4E27C", hash_generated_method = "50EE54C5F534AB93EF533A38AE0E437E")
    @DSModeled(DSC.SAFE)
    public CompletionInfo(long id, int index, CharSequence text, CharSequence label) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(label);
        // ---------- Original Method ----------
        //mId = id;
        //mPosition = index;
        //mText = text;
        //mLabel = label;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.255 -0400", hash_original_method = "2F837EEA33DB685519494240B032A81B", hash_generated_method = "19FF85AF4AC30287AC1AB4A5E55CEC3B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.256 -0400", hash_original_method = "6AF16C815DE6FE4144432EF99CDC825B", hash_generated_method = "E23715533D6628CBD96806BF5597A6A8")
    @DSModeled(DSC.SAFE)
    public long getId() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.257 -0400", hash_original_method = "88750DD9C7394A9CF6B657A7AF77F3EB", hash_generated_method = "B3BC07947F302446F21F2D4E9F5636A5")
    @DSModeled(DSC.SAFE)
    public int getPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.258 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "0EE8DAE8D11C9C0940FB60F3DE0E7055")
    @DSModeled(DSC.SAFE)
    public CharSequence getText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.258 -0400", hash_original_method = "4A1E1E1996A16BAAC783C4D4608DA412", hash_generated_method = "3F4CEAAC80A4B62C4184CCA717B673A4")
    @DSModeled(DSC.SAFE)
    public CharSequence getLabel() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mLabel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.258 -0400", hash_original_method = "3B6D1C61D70E52042FDD9DC9240A1E79", hash_generated_method = "2F52C2750BDB294D6EDDD4B00C3DDFAB")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "CompletionInfo{#" + mPosition + " \"" + mText
                //+ "\" id=" + mId + " label=" + mLabel + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.259 -0400", hash_original_method = "9E5F84EC05F73AE374617C14B6E91B86", hash_generated_method = "D6B00245B5EE0DCEFC0ACDB3F5DE688A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.259 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static final Parcelable.Creator<CompletionInfo> CREATOR = new Parcelable.Creator<CompletionInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.259 -0400", hash_original_method = "3E9AF51E6B6E69C18FAD3C8C0C4128B0", hash_generated_method = "B6DD6C613C32F4CF1670D358DC953BCA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CompletionInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            CompletionInfo var86A08D731EF63EBAB49A89F5BFBF2570_1794371546 = (new CompletionInfo(source));
            return (CompletionInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CompletionInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.259 -0400", hash_original_method = "9EBF5EB5FCCD856E192DB9AAF0B8CB87", hash_generated_method = "9DAB6DCA227F2A7452D0D8DDA1AF4662")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CompletionInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            CompletionInfo[] var6C3A750964179FAEE45CBDB1AEAC8FFF_841543126 = (new CompletionInfo[size]);
            return (CompletionInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CompletionInfo[size];
        }

        
}; //Transformed anonymous class
}

