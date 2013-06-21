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

public final class CorrectionInfo implements Parcelable {
    private int mOffset;
    private CharSequence mOldText;
    private CharSequence mNewText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.263 -0400", hash_original_method = "4BC4C4C6E34B6ABB755CFB5627F6324D", hash_generated_method = "620A7D9FD65EA5773BAAFB307C195749")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.263 -0400", hash_original_method = "ACB844101F7B730F0891325C0B2B59C5", hash_generated_method = "1536921EA2218BA7536A5003AA27669E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.264 -0400", hash_original_method = "FB2FFBF84EFDF3FAC1DB07E1BCD653F5", hash_generated_method = "9AB13B7E5CADB926E9C75A8CBCD1DA16")
    @DSModeled(DSC.SAFE)
    public int getOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.264 -0400", hash_original_method = "B5F6375A5B3C1F7513E2C762D0A387DE", hash_generated_method = "070C1F6447D72DA2D7EBCA57B9C9E84A")
    @DSModeled(DSC.SAFE)
    public CharSequence getOldText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mOldText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.264 -0400", hash_original_method = "A44877BB52BDCF0EDD87983832FB9E30", hash_generated_method = "91EA70ADFBEBE4DC931123720C107412")
    @DSModeled(DSC.SAFE)
    public CharSequence getNewText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mNewText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.264 -0400", hash_original_method = "7D587C528DCE451F3ED32B059F93B063", hash_generated_method = "27CA768136A0809772D74D7D3DBF057A")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "CorrectionInfo{#" + mOffset + " \"" + mOldText + "\" -> \"" + mNewText + "\"}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.264 -0400", hash_original_method = "4D2AAA8E4AD44FCBAED8BA48A77A4AE0", hash_generated_method = "B8DDA5316A88C5F9DF036C7AC341B10A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mOffset);
        TextUtils.writeToParcel(mOldText, dest, flags);
        TextUtils.writeToParcel(mNewText, dest, flags);
        // ---------- Original Method ----------
        //dest.writeInt(mOffset);
        //TextUtils.writeToParcel(mOldText, dest, flags);
        //TextUtils.writeToParcel(mNewText, dest, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.264 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static final Parcelable.Creator<CorrectionInfo> CREATOR = new Parcelable.Creator<CorrectionInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.265 -0400", hash_original_method = "7FBA179BFE899DE2EAD21D1B67E0C7B7", hash_generated_method = "F96F43A3F960F6B04C3852F33AE283DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CorrectionInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            CorrectionInfo var6659D7BE9E8F66151D38FFFDFB5C7B51_952922267 = (new CorrectionInfo(source));
            return (CorrectionInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CorrectionInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.265 -0400", hash_original_method = "694EA4E4926FF6744E474A780E882CB2", hash_generated_method = "4F07EBD60FC1FE1E3EC77523D8F23B76")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CorrectionInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            CorrectionInfo[] var7AA1F631615DADB03633C337B8567783_487433471 = (new CorrectionInfo[size]);
            return (CorrectionInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CorrectionInfo[size];
        }

        
}; //Transformed anonymous class
}

