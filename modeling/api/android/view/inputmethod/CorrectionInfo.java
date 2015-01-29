package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class CorrectionInfo implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.293 -0400", hash_original_field = "0802A0FE3EDE98511D93025B888127A6", hash_generated_field = "545C65D572FA367719FAFB5FF700B68D")

    public static final Parcelable.Creator<CorrectionInfo> CREATOR
            = new Parcelable.Creator<CorrectionInfo>() {
    	
        @DSSafe(DSCat.SAFE_OTHERS)
        public CorrectionInfo createFromParcel(Parcel source) {
    		addTaint(source.getTaint());
    		CorrectionInfo retVal = new CorrectionInfo(source);
    		retVal.addTaint(getTaint());
            return retVal;
        }
        
        public CorrectionInfo[] newArray(int size) {
        	addTaint(size);
            return new CorrectionInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.766 -0500", hash_original_field = "824ACE8F55518F51C4ECB112DA3987C7", hash_generated_field = "F358652CEEA6BACE7E593752AA27CBE6")

    private  int mOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.768 -0500", hash_original_field = "A88490DDD674A7C89508260F108DEC9B", hash_generated_field = "21F81963919AD1B6FEAE170B2FD8DF2A")

    private  CharSequence mOldText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.771 -0500", hash_original_field = "2D575539D9A4161C40F1F3347F6E1F96", hash_generated_field = "919C489EB83DD5B1D70C52520AF2491D")

    private  CharSequence mNewText;

    /**
     * @param offset The offset in the edited text where the old and new text start.
     * @param oldText The old text that has been replaced.
     * @param newText The replacement text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.773 -0500", hash_original_method = "4BC4C4C6E34B6ABB755CFB5627F6324D", hash_generated_method = "6799C5DCFB8A4B0543183A3C81BF3584")
    
public CorrectionInfo(int offset, CharSequence oldText, CharSequence newText) {
        mOffset = offset;
        mOldText = oldText;
        mNewText = newText;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.776 -0500", hash_original_method = "ACB844101F7B730F0891325C0B2B59C5", hash_generated_method = "D49883314DCB4296A37CDB623298E2DD")
    
private CorrectionInfo(Parcel source) {
        mOffset = source.readInt();
        mOldText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        mNewText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }

    /**
     * Return the offset position of this correction in the text. Both the {@link #getOldText()} and
     * {@link #getNewText()} start at this offset.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.778 -0500", hash_original_method = "FB2FFBF84EFDF3FAC1DB07E1BCD653F5", hash_generated_method = "6F0A4A5FCF19E7C347B9315FF86C0189")
    
public int getOffset() {
        return mOffset;
    }

    /**
     * Return the text that has actually been typed by the user, and which has been corrected.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.780 -0500", hash_original_method = "B5F6375A5B3C1F7513E2C762D0A387DE", hash_generated_method = "120CF55EBB2F568B5E24FB54C3274BD2")
    
public CharSequence getOldText() {
        return mOldText;
    }

    /**
     * Return the new text that corrects what was typed by the user.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.782 -0500", hash_original_method = "A44877BB52BDCF0EDD87983832FB9E30", hash_generated_method = "161EFAB57732DEAC597AF92B819C9B2C")
    
public CharSequence getNewText() {
        return mNewText;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.785 -0500", hash_original_method = "7D587C528DCE451F3ED32B059F93B063", hash_generated_method = "C69486CC7183B40E68E5B690FD2DB57C")
    
@Override
    public String toString() {
        return "CorrectionInfo{#" + mOffset + " \"" + mOldText + "\" -> \"" + mNewText + "\"}";
    }

    /**
     * Used to package this object into a {@link Parcel}.
     *
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.788 -0500", hash_original_method = "4D2AAA8E4AD44FCBAED8BA48A77A4AE0", hash_generated_method = "C7C6E988E3C15E289C9FB58447E14EBA")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mOffset);
        TextUtils.writeToParcel(mOldText, dest, flags);
        TextUtils.writeToParcel(mNewText, dest, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:21.798 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    
    /*
    // orphaned legacy method
    public CorrectionInfo createFromParcel(Parcel source) {
            return new CorrectionInfo(source);
        }
    
    // orphaned legacy method
    public CorrectionInfo[] newArray(int size) {
            return new CorrectionInfo[size];
        }
    */
}

