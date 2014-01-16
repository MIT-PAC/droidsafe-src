package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class CompletionInfo implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.274 -0400", hash_original_field = "31621134870CBAE679681892F3003DDF", hash_generated_field = "B610E87A4A96E260678AA4BA5F15A953")

    public static final Parcelable.Creator<CompletionInfo> CREATOR
            = new Parcelable.Creator<CompletionInfo>() {
    	
        public CompletionInfo createFromParcel(Parcel source) {
        	addTaint(source.getTaint());
            return new CompletionInfo(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.134 -0500", hash_original_method = "9EBF5EB5FCCD856E192DB9AAF0B8CB87", hash_generated_method = "144ACBE0ECB989A2411C7B29B3FC804E")
        
public CompletionInfo[] newArray(int size) {
            return new CompletionInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.099 -0500", hash_original_field = "52AFBBC2CD3BAB47936915EE533B9C32", hash_generated_field = "CF2A5FB7C7BB55BD451D113BD690151D")

    private  long mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.101 -0500", hash_original_field = "4EE731A4D843C99A130C2ED24E5FDDEA", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

    private  int mPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.104 -0500", hash_original_field = "A59BBC07E5E46996D793B2F37E80BD24", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private  CharSequence mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.106 -0500", hash_original_field = "3688992A2E5C86A7BA94DE38FB1043D1", hash_generated_field = "35633BB7C9814BC2D57023D255065F26")

    private  CharSequence mLabel;

    /**
     * Create a simple completion with just text, no label.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.108 -0500", hash_original_method = "38A4F60AF5C7022C0469BD89E2BC1895", hash_generated_method = "045043271B86F52234688B4AF50F6AD1")
    
public CompletionInfo(long id, int index, CharSequence text) {
        mId = id;
        mPosition = index;
        mText = text;
        mLabel = null;
    }

    /**
     * Create a full completion with both text and label.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.111 -0500", hash_original_method = "D296F749900FBC5242D181AA06D4E27C", hash_generated_method = "CF60C697F2C4C7E7F70C896F2825A3FA")
    
public CompletionInfo(long id, int index, CharSequence text, CharSequence label) {
        mId = id;
        mPosition = index;
        mText = text;
        mLabel = label;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.114 -0500", hash_original_method = "2F837EEA33DB685519494240B032A81B", hash_generated_method = "8865555D59E011AE2F343A4AFB517F20")
    
private CompletionInfo(Parcel source) {
        mId = source.readLong();
        mPosition = source.readInt();
        mText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        mLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }
    
    /**
     * Return the abstract identifier for this completion, typically
     * corresponding to the id associated with it in the original adapter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.117 -0500", hash_original_method = "6AF16C815DE6FE4144432EF99CDC825B", hash_generated_method = "2AC5D8EEAADC6329A2ECEA8ACD04E2AF")
    
public long getId() {
        return mId;
    }
    
    /**
     * Return the original position of this completion, typically
     * corresponding to its position in the original adapter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.120 -0500", hash_original_method = "88750DD9C7394A9CF6B657A7AF77F3EB", hash_generated_method = "3D08F75A7598BA1F4BA734B82B3D54E3")
    
public int getPosition() {
        return mPosition;
    }
    
    /**
     * Return the actual text associated with this completion.  This is the
     * real text that will be inserted into the editor if the user selects it.
     */
    @DSComment("no actions")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.122 -0500", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "3C5AE00E10DCE5E04049FCC58EEF7C48")
    
public CharSequence getText() {
        return mText;
    }
    
    /**
     * Return the user-visible label for the completion, or null if the plain
     * text should be shown.  If non-null, this will be what the user sees as
     * the completion option instead of the actual text.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.124 -0500", hash_original_method = "4A1E1E1996A16BAAC783C4D4608DA412", hash_generated_method = "BF2D8CE2895BA065BC033E2D2EA0072E")
    
public CharSequence getLabel() {
        return mLabel;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.126 -0500", hash_original_method = "3B6D1C61D70E52042FDD9DC9240A1E79", hash_generated_method = "55BB63A6EC3B3C0821629E09253CFB6A")
    
@Override
    public String toString() {
        return "CompletionInfo{#" + mPosition + " \"" + mText
                + "\" id=" + mId + " label=" + mLabel + "}";
    }

    /**
     * Used to package this object into a {@link Parcel}.
     *
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.129 -0500", hash_original_method = "9E5F84EC05F73AE374617C14B6E91B86", hash_generated_method = "9377A1A9D88A52D4256ECA929657229D")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mId);
        dest.writeInt(mPosition);
        TextUtils.writeToParcel(mText, dest, flags);
        TextUtils.writeToParcel(mLabel, dest, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:19.139 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    /*
    // orphaned legacy method
    public CompletionInfo createFromParcel(Parcel source) {
            return new CompletionInfo(source);
        }
    
    // orphaned legacy method
    public CompletionInfo[] newArray(int size) {
            return new CompletionInfo[size];
        }
    */
}

