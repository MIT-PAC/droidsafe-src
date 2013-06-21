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

public class ExtractedText implements Parcelable {
    public CharSequence text;
    public int startOffset;
    public int partialStartOffset;
    public int partialEndOffset;
    public int selectionStart;
    public int selectionEnd;
    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.301 -0400", hash_original_method = "BEA53DE278B9F84ED6DEF219BC81D175", hash_generated_method = "BEA53DE278B9F84ED6DEF219BC81D175")
        public ExtractedText ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.302 -0400", hash_original_method = "A6AF00275518DDDF6E9928CFE924AB5A", hash_generated_method = "CF084F3C08B1121C318A4490E70EC6D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.302 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static final int FLAG_SINGLE_LINE = 0x0001;
    public static final int FLAG_SELECTING = 0x0002;
    public static final Parcelable.Creator<ExtractedText> CREATOR = new Parcelable.Creator<ExtractedText>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.302 -0400", hash_original_method = "18101586B08022B99EB45311C1C523FD", hash_generated_method = "E7173809B530D3491DCC867E2F69D934")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.303 -0400", hash_original_method = "08A229B5C05188B284B4FFB2EEA9E9D1", hash_generated_method = "054FEF03DCADBAD08142F64CA52E3F28")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ExtractedText[] newArray(int size) {
            dsTaint.addTaint(size);
            ExtractedText[] var098D5F7B58AD044EFEF73DE8DF148A5B_1694155197 = (new ExtractedText[size]);
            return (ExtractedText[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ExtractedText[size];
        }

        
}; //Transformed anonymous class
}

