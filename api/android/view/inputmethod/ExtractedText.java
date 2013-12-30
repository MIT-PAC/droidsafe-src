package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;





public class ExtractedText implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.282 -0500", hash_original_field = "80B526FEBE61133EA608E91D9679B87E", hash_generated_field = "DF17605A93346144B114D0FDC38BDBBD")

    public static final int FLAG_SINGLE_LINE = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.285 -0500", hash_original_field = "09995656725D9F080C05214FA3629E57", hash_generated_field = "68ECBBCA75B50FB53EB411BFB1A7518D")

    public static final int FLAG_SELECTING = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.496 -0400", hash_original_field = "44C9A9B8D068505B70A3CBF636C42424", hash_generated_field = "D4D8686744A23F17CF49DABA688B4F58")

    public static final Parcelable.Creator<ExtractedText> CREATOR = new Parcelable.Creator<ExtractedText>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.293 -0500", hash_original_method = "18101586B08022B99EB45311C1C523FD", hash_generated_method = "AB02832255F8A327D782CE0206CC612C")
        
public ExtractedText createFromParcel(Parcel source) {
            ExtractedText res = new ExtractedText();
            res.text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.startOffset = source.readInt();
            res.partialStartOffset = source.readInt();
            res.partialEndOffset = source.readInt();
            res.selectionStart = source.readInt();
            res.selectionEnd = source.readInt();
            res.flags = source.readInt();
            return res;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.297 -0500", hash_original_method = "08A229B5C05188B284B4FFB2EEA9E9D1", hash_generated_method = "57108DE3A3653536DD65BFE5CEE376AD")
        
public ExtractedText[] newArray(int size) {
            return new ExtractedText[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.269 -0500", hash_original_field = "0F26345BF87C16C80BAC76779863E330", hash_generated_field = "1FDF02F5FA00FB650C53E54E20AF7723")

    public CharSequence text;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.271 -0500", hash_original_field = "3053AE28FD6A737B173D51BE714DBF68", hash_generated_field = "7E929A0F69B60DC7EFD88D8819CECAA7")

    public int startOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.273 -0500", hash_original_field = "EBB5B2CB824343089EA2505D0AC2D855", hash_generated_field = "043C4E8F99B49D0DE040EE505C23B869")

    public int partialStartOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.276 -0500", hash_original_field = "D909AEEECDA2A1D29544D2E681D682CC", hash_generated_field = "437814B82FC87BC94E0139E3569F2A19")

    public int partialEndOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.278 -0500", hash_original_field = "2DFC5CBF71EF798279C8DDB239200299", hash_generated_field = "B1CD15942574F084BC3B2CD1155E537D")

    public int selectionStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.280 -0500", hash_original_field = "ED642EF166BA021BB759477247F88DFE", hash_generated_field = "4B080BDB86374DAA165914D729BC2F0E")

    public int selectionEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.288 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.481 -0400", hash_original_method = "B20DB5D63D0394BA39DC79D6F40BFDA5", hash_generated_method = "B20DB5D63D0394BA39DC79D6F40BFDA5")
    public ExtractedText ()
    {
        //Synthesized constructor
    }
    
    /**
     * Used to package this object into a {@link Parcel}.
     * 
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.290 -0500", hash_original_method = "A6AF00275518DDDF6E9928CFE924AB5A", hash_generated_method = "707566131ABE4CF22C40F7FC7C5D5B8D")
    
public void writeToParcel(Parcel dest, int flags) {
        TextUtils.writeToParcel(text, dest, flags);
        dest.writeInt(startOffset);
        dest.writeInt(partialStartOffset);
        dest.writeInt(partialEndOffset);
        dest.writeInt(selectionStart);
        dest.writeInt(selectionEnd);
        dest.writeInt(this.flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.301 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public ExtractedText createFromParcel(Parcel source) {
            ExtractedText res = new ExtractedText();
            res.text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.startOffset = source.readInt();
            res.partialStartOffset = source.readInt();
            res.partialEndOffset = source.readInt();
            res.selectionStart = source.readInt();
            res.selectionEnd = source.readInt();
            res.flags = source.readInt();
            return res;
        }
    
    // orphaned legacy method
    public ExtractedText[] newArray(int size) {
            return new ExtractedText[size];
        }
    
}

