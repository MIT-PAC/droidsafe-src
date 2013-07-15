package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class CorrectionInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.129 -0400", hash_original_field = "E8439EB32866F13AD7ABD06DB4A15343", hash_generated_field = "F358652CEEA6BACE7E593752AA27CBE6")

    private int mOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.129 -0400", hash_original_field = "584DB9839E8990DC7A624740F928A86B", hash_generated_field = "21F81963919AD1B6FEAE170B2FD8DF2A")

    private CharSequence mOldText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.129 -0400", hash_original_field = "E3FE29B0EC2FDC3E4AC20859BAA967E2", hash_generated_field = "919C489EB83DD5B1D70C52520AF2491D")

    private CharSequence mNewText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.130 -0400", hash_original_method = "4BC4C4C6E34B6ABB755CFB5627F6324D", hash_generated_method = "EA69ED117B11915946ED99C129695DDB")
    public  CorrectionInfo(int offset, CharSequence oldText, CharSequence newText) {
        mOffset = offset;
        mOldText = oldText;
        mNewText = newText;
        // ---------- Original Method ----------
        //mOffset = offset;
        //mOldText = oldText;
        //mNewText = newText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.131 -0400", hash_original_method = "ACB844101F7B730F0891325C0B2B59C5", hash_generated_method = "B20EB25A9119C4194DCBE441924D46CF")
    private  CorrectionInfo(Parcel source) {
        mOffset = source.readInt();
        mOldText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        mNewText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        // ---------- Original Method ----------
        //mOffset = source.readInt();
        //mOldText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        //mNewText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.131 -0400", hash_original_method = "FB2FFBF84EFDF3FAC1DB07E1BCD653F5", hash_generated_method = "6AA44B8DA7FB9AC41899BC53BB6D2342")
    public int getOffset() {
        int varE8439EB32866F13AD7ABD06DB4A15343_169425279 = (mOffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_708203819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_708203819;
        // ---------- Original Method ----------
        //return mOffset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.131 -0400", hash_original_method = "B5F6375A5B3C1F7513E2C762D0A387DE", hash_generated_method = "FE9609E01ED1061D647A34255E897898")
    public CharSequence getOldText() {
CharSequence varCB42793B5FCD16AD78A843462295CF9F_1004545862 =         mOldText;
        varCB42793B5FCD16AD78A843462295CF9F_1004545862.addTaint(taint);
        return varCB42793B5FCD16AD78A843462295CF9F_1004545862;
        // ---------- Original Method ----------
        //return mOldText;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.132 -0400", hash_original_method = "A44877BB52BDCF0EDD87983832FB9E30", hash_generated_method = "9045AEE0A2A2BC1B53CA23C6247990F8")
    public CharSequence getNewText() {
CharSequence var4418CD7C5DA1D77AC17AEFF7277BF87B_1022450188 =         mNewText;
        var4418CD7C5DA1D77AC17AEFF7277BF87B_1022450188.addTaint(taint);
        return var4418CD7C5DA1D77AC17AEFF7277BF87B_1022450188;
        // ---------- Original Method ----------
        //return mNewText;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.132 -0400", hash_original_method = "7D587C528DCE451F3ED32B059F93B063", hash_generated_method = "11AD46D8E5A246997038FAA58BFBF879")
    @Override
    public String toString() {
String var9F600BFBE887033823CFD91DDDB01734_640177648 =         "CorrectionInfo{#" + mOffset + " \"" + mOldText + "\" -> \"" + mNewText + "\"}";
        var9F600BFBE887033823CFD91DDDB01734_640177648.addTaint(taint);
        return var9F600BFBE887033823CFD91DDDB01734_640177648;
        // ---------- Original Method ----------
        //return "CorrectionInfo{#" + mOffset + " \"" + mOldText + "\" -> \"" + mNewText + "\"}";
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.132 -0400", hash_original_method = "4D2AAA8E4AD44FCBAED8BA48A77A4AE0", hash_generated_method = "2CA872B42EA1D19B21FAAF912A382EF1")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mOffset);
        TextUtils.writeToParcel(mOldText, dest, flags);
        TextUtils.writeToParcel(mNewText, dest, flags);
        // ---------- Original Method ----------
        //dest.writeInt(mOffset);
        //TextUtils.writeToParcel(mOldText, dest, flags);
        //TextUtils.writeToParcel(mNewText, dest, flags);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.133 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5FA035387D624748C5BCA0465E86147C")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1680695332 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222936522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222936522;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.133 -0400", hash_original_field = "0802A0FE3EDE98511D93025B888127A6", hash_generated_field = "545C65D572FA367719FAFB5FF700B68D")

    public static final Parcelable.Creator<CorrectionInfo> CREATOR
            = new Parcelable.Creator<CorrectionInfo>() {
        public CorrectionInfo createFromParcel(Parcel source) {
            return new CorrectionInfo(source);
        }

        public CorrectionInfo[] newArray(int size) {
            return new CorrectionInfo[size];
        }
    };
    // orphaned legacy method
    public CorrectionInfo createFromParcel(Parcel source) {
            return new CorrectionInfo(source);
        }
    
    // orphaned legacy method
    public CorrectionInfo[] newArray(int size) {
            return new CorrectionInfo[size];
        }
    
}

