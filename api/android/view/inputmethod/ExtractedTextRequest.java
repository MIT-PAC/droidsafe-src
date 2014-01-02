package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class ExtractedTextRequest implements Parcelable {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.520 -0400", hash_original_field = "53A29FDF1558849BDD50F7BFE3E6AF78", hash_generated_field = "85087F40266A407B120D89FE91BD8F5F")

    public static final Parcelable.Creator<ExtractedTextRequest> CREATOR
            = new Parcelable.Creator<ExtractedTextRequest>() {
    	@DSModeled(DSC.SAFE)
        public ExtractedTextRequest createFromParcel(Parcel source) {
    		addTaint(source.getTaint());
            ExtractedTextRequest res = new ExtractedTextRequest();
            res.token = source.readInt();
            res.flags = source.readInt();
            res.hintMaxLines = source.readInt();
            res.hintMaxChars = source.readInt();
            res.addTaint(taint);
            return res;
        }

        @DSModeled(DSC.SAFE)
        public ExtractedTextRequest[] newArray(int size) {
        	addTaint(size);
            return new ExtractedTextRequest[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.438 -0500", hash_original_field = "CC4646C896084A01EB744FD0C37DEC7D", hash_generated_field = "5EAD126FF3F63D06599D4B7FB9755E47")

    public int token;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.441 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.443 -0500", hash_original_field = "E5B86E7CCC0C842139AA89F7C286B48E", hash_generated_field = "663C68D6D79E01D67D2C496FA7BBC6BD")

    public int hintMaxLines;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.445 -0500", hash_original_field = "FBE75516DC69E5B8333798BB997720E2", hash_generated_field = "A2C5BC9C7324A9C64D4069D01D34363E")

    public int hintMaxChars;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.520 -0400", hash_original_method = "8B43E5E3CB5CAEC30CB660AE9DA9D566", hash_generated_method = "8B43E5E3CB5CAEC30CB660AE9DA9D566")
    public ExtractedTextRequest ()
    {
        //Synthesized constructor
    }
    
    /**
     * Used to package this object into a {@link Parcel}.
     * 
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.448 -0500", hash_original_method = "86DA45F615C261383D752E615DE3B691", hash_generated_method = "B769615C9C1C8B7AEAEBE623A7971ADB")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(token);
        dest.writeInt(this.flags);
        dest.writeInt(hintMaxLines);
        dest.writeInt(hintMaxChars);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.459 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    /*
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
    */
}

