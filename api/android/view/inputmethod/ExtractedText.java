package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;





public class ExtractedText implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.478 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "1FDF02F5FA00FB650C53E54E20AF7723")

    public CharSequence text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.478 -0400", hash_original_field = "DF3801651EC3A9BB226F2B2893F649E4", hash_generated_field = "7E929A0F69B60DC7EFD88D8819CECAA7")

    public int startOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.478 -0400", hash_original_field = "71C9E9D0E43BBA3BE5FC1EACF914FE15", hash_generated_field = "043C4E8F99B49D0DE040EE505C23B869")

    public int partialStartOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.479 -0400", hash_original_field = "DE078720D40B6A05B1DC762F027F0E62", hash_generated_field = "437814B82FC87BC94E0139E3569F2A19")

    public int partialEndOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.479 -0400", hash_original_field = "EF6B73FBB3CC3FCEE9E812AC246BA63D", hash_generated_field = "B1CD15942574F084BC3B2CD1155E537D")

    public int selectionStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.480 -0400", hash_original_field = "453AA4673DE8CCC7C9242083699986B2", hash_generated_field = "4B080BDB86374DAA165914D729BC2F0E")

    public int selectionEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.480 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.481 -0400", hash_original_method = "B20DB5D63D0394BA39DC79D6F40BFDA5", hash_generated_method = "B20DB5D63D0394BA39DC79D6F40BFDA5")
    public ExtractedText ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.486 -0400", hash_original_method = "A6AF00275518DDDF6E9928CFE924AB5A", hash_generated_method = "715647F01C73B113049CD52DBE4C68B1")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.493 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BC1CD3EDAE203FA12B14BFA222F7A173")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1476900814 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206684783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206684783;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.494 -0400", hash_original_field = "1EEAF8A204DF147FC8E2E412B29503AD", hash_generated_field = "DF17605A93346144B114D0FDC38BDBBD")

    public static final int FLAG_SINGLE_LINE = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.495 -0400", hash_original_field = "1D78FEFCDD6CABA8E5A9C16B18D715CC", hash_generated_field = "68ECBBCA75B50FB53EB411BFB1A7518D")

    public static final int FLAG_SELECTING = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.496 -0400", hash_original_field = "44C9A9B8D068505B70A3CBF636C42424", hash_generated_field = "D4D8686744A23F17CF49DABA688B4F58")

    public static final Parcelable.Creator<ExtractedText> CREATOR = new Parcelable.Creator<ExtractedText>() {
        @DSModeled(DSC.SAFE)
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

        @DSModeled(DSC.SAFE)
        public ExtractedText[] newArray(int size) {
            return new ExtractedText[size];
        }
    };
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

