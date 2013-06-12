package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class CorrectionInfo implements Parcelable {
    private final int mOffset;
    private final CharSequence mOldText;
    private final CharSequence mNewText;
    public static final Parcelable.Creator<CorrectionInfo> CREATOR = new Parcelable.Creator<CorrectionInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.056 -0400", hash_original_method = "7FBA179BFE899DE2EAD21D1B67E0C7B7", hash_generated_method = "B7EDB562F7EDC9D3FD4613D2AAC49DF7")
        @DSModeled(DSC.SAFE)
        public CorrectionInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (CorrectionInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CorrectionInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.056 -0400", hash_original_method = "694EA4E4926FF6744E474A780E882CB2", hash_generated_method = "70D5D77A8F405D75C40CAF2ABBC6C095")
        @DSModeled(DSC.SAFE)
        public CorrectionInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (CorrectionInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CorrectionInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.056 -0400", hash_original_method = "4BC4C4C6E34B6ABB755CFB5627F6324D", hash_generated_method = "4483E5192BA999C302D973B9AF38C813")
    @DSModeled(DSC.SAFE)
    public CorrectionInfo(int offset, CharSequence oldText, CharSequence newText) {
        dsTaint.addTaint(newText);
        dsTaint.addTaint(oldText);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //mOffset = offset;
        //mOldText = oldText;
        //mNewText = newText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.057 -0400", hash_original_method = "ACB844101F7B730F0891325C0B2B59C5", hash_generated_method = "F72B595310250ED7270083635E57C300")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CorrectionInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        mOffset = source.readInt();
        mOldText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        mNewText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        // ---------- Original Method ----------
        //mOffset = source.readInt();
        //mOldText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        //mNewText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.057 -0400", hash_original_method = "FB2FFBF84EFDF3FAC1DB07E1BCD653F5", hash_generated_method = "D97C94AF14F31D3DD2694C809A755F07")
    @DSModeled(DSC.SAFE)
    public int getOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.057 -0400", hash_original_method = "B5F6375A5B3C1F7513E2C762D0A387DE", hash_generated_method = "4A8689B5C924CDC6BE69F87A3F184DD0")
    @DSModeled(DSC.SAFE)
    public CharSequence getOldText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mOldText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.057 -0400", hash_original_method = "A44877BB52BDCF0EDD87983832FB9E30", hash_generated_method = "3B8876D69D0DD89C8E56DA020E0E78E6")
    @DSModeled(DSC.SAFE)
    public CharSequence getNewText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mNewText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.057 -0400", hash_original_method = "7D587C528DCE451F3ED32B059F93B063", hash_generated_method = "14FEB77548452F8570441A74273A35A4")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "CorrectionInfo{#" + mOffset + " \"" + mOldText + "\" -> \"" + mNewText + "\"}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.057 -0400", hash_original_method = "4D2AAA8E4AD44FCBAED8BA48A77A4AE0", hash_generated_method = "366208BA22632D0EE9B91AD0605F9968")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mOffset);
        TextUtils.writeToParcel(mOldText, dest, flags);
        TextUtils.writeToParcel(mNewText, dest, flags);
        // ---------- Original Method ----------
        //dest.writeInt(mOffset);
        //TextUtils.writeToParcel(mOldText, dest, flags);
        //TextUtils.writeToParcel(mNewText, dest, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.057 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
}


