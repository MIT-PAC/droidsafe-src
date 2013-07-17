package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ExtractedTextRequest implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.519 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "5EAD126FF3F63D06599D4B7FB9755E47")

    public int token;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.520 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.520 -0400", hash_original_field = "BF09D1D22D5BC042E42514EE686B692D", hash_generated_field = "663C68D6D79E01D67D2C496FA7BBC6BD")

    public int hintMaxLines;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.520 -0400", hash_original_field = "9FD73CEC6DA632587D658E70DB8938DF", hash_generated_field = "A2C5BC9C7324A9C64D4069D01D34363E")

    public int hintMaxChars;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.520 -0400", hash_original_method = "8B43E5E3CB5CAEC30CB660AE9DA9D566", hash_generated_method = "8B43E5E3CB5CAEC30CB660AE9DA9D566")
    public ExtractedTextRequest ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.520 -0400", hash_original_method = "86DA45F615C261383D752E615DE3B691", hash_generated_method = "7AA16D444AD1A93CB1DE944C2DFCC1F5")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(token);
        dest.writeInt(this.flags);
        dest.writeInt(hintMaxLines);
        dest.writeInt(hintMaxChars);
        // ---------- Original Method ----------
        //dest.writeInt(token);
        //dest.writeInt(this.flags);
        //dest.writeInt(hintMaxLines);
        //dest.writeInt(hintMaxChars);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.520 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8F90A1B0BEA6B841D42D95D7B1FDA8D5")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1115000162 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103851800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103851800;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.520 -0400", hash_original_field = "53A29FDF1558849BDD50F7BFE3E6AF78", hash_generated_field = "85087F40266A407B120D89FE91BD8F5F")

    public static final Parcelable.Creator<ExtractedTextRequest> CREATOR
            = new Parcelable.Creator<ExtractedTextRequest>() {
        public ExtractedTextRequest createFromParcel(Parcel source) {
            ExtractedTextRequest res = new ExtractedTextRequest();
            res.token = source.readInt();
            res.flags = source.readInt();
            res.hintMaxLines = source.readInt();
            res.hintMaxChars = source.readInt();
            return res;
        }

        public ExtractedTextRequest[] newArray(int size) {
            return new ExtractedTextRequest[size];
        }
    };
    // orphaned legacy method
    public ExtractedTextRequest createFromParcel(Parcel source) {
            ExtractedTextRequest res = new ExtractedTextRequest();
            res.token = source.readInt();
            res.flags = source.readInt();
            res.hintMaxLines = source.readInt();
            res.hintMaxChars = source.readInt();
            return res;
        }
    
    // orphaned legacy method
    public ExtractedTextRequest[] newArray(int size) {
            return new ExtractedTextRequest[size];
        }
    
}

