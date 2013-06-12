package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ExtractedText implements Parcelable {
    public CharSequence text;
    public int startOffset;
    public int partialStartOffset;
    public int partialEndOffset;
    public int selectionStart;
    public int selectionEnd;
    public static final int FLAG_SINGLE_LINE = 0x0001;
    public static final int FLAG_SELECTING = 0x0002;
    public int flags;
    public static final Parcelable.Creator<ExtractedText> CREATOR = new Parcelable.Creator<ExtractedText>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.083 -0400", hash_original_method = "18101586B08022B99EB45311C1C523FD", hash_generated_method = "EEA556AAB3BAE9E372FF982654056C5E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ExtractedText createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ExtractedText res;
            res = new ExtractedText();
            res.text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.startOffset = source.readInt();
            res.partialStartOffset = source.readInt();
            res.partialEndOffset = source.readInt();
            res.selectionStart = source.readInt();
            res.selectionEnd = source.readInt();
            res.flags = source.readInt();
            return (ExtractedText)dsTaint.getTaint();
            // ---------- Original Method ----------
            //ExtractedText res = new ExtractedText();
            //res.text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            //res.startOffset = source.readInt();
            //res.partialStartOffset = source.readInt();
            //res.partialEndOffset = source.readInt();
            //res.selectionStart = source.readInt();
            //res.selectionEnd = source.readInt();
            //res.flags = source.readInt();
            //return res;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.083 -0400", hash_original_method = "08A229B5C05188B284B4FFB2EEA9E9D1", hash_generated_method = "2B6747436F6AF28D8DA89AEAAB7EC317")
        @DSModeled(DSC.SAFE)
        public ExtractedText[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ExtractedText[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ExtractedText[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.083 -0400", hash_original_method = "A6AF00275518DDDF6E9928CFE924AB5A", hash_generated_method = "28FC3B470AABE969052D6D398AA9C5FD")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        TextUtils.writeToParcel(text, dest, flags);
        dest.writeInt(startOffset);
        dest.writeInt(partialStartOffset);
        dest.writeInt(partialEndOffset);
        dest.writeInt(selectionStart);
        dest.writeInt(selectionEnd);
        dest.writeInt(this.flags);
        // ---------- Original Method ----------
        //TextUtils.writeToParcel(text, dest, flags);
        //dest.writeInt(startOffset);
        //dest.writeInt(partialStartOffset);
        //dest.writeInt(partialEndOffset);
        //dest.writeInt(selectionStart);
        //dest.writeInt(selectionEnd);
        //dest.writeInt(this.flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.083 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
}


