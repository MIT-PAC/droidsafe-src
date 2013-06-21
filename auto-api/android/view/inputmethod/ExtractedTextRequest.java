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

public class ExtractedTextRequest implements Parcelable {
    public int token;
    public int flags;
    public int hintMaxLines;
    public int hintMaxChars;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.305 -0400", hash_original_method = "B3613A839DF952821965B56B87CF15DD", hash_generated_method = "B3613A839DF952821965B56B87CF15DD")
        public ExtractedTextRequest ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.305 -0400", hash_original_method = "86DA45F615C261383D752E615DE3B691", hash_generated_method = "05D4323406EE0A2A33CE672414F1B089")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.305 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static final Parcelable.Creator<ExtractedTextRequest> CREATOR = new Parcelable.Creator<ExtractedTextRequest>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.305 -0400", hash_original_method = "30E3470F48B04522780245F06863DCB7", hash_generated_method = "57F6F7D12BC0C6C9CE698D340A511C06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ExtractedTextRequest createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ExtractedTextRequest res;
            res = new ExtractedTextRequest();
            res.token = source.readInt();
            res.flags = source.readInt();
            res.hintMaxLines = source.readInt();
            res.hintMaxChars = source.readInt();
            return (ExtractedTextRequest)dsTaint.getTaint();
            // ---------- Original Method ----------
            //ExtractedTextRequest res = new ExtractedTextRequest();
            //res.token = source.readInt();
            //res.flags = source.readInt();
            //res.hintMaxLines = source.readInt();
            //res.hintMaxChars = source.readInt();
            //return res;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.306 -0400", hash_original_method = "319315B697FC2583F1B96031A391A54D", hash_generated_method = "9F1E258ED13A78FF11EDFD6440ACBE9E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ExtractedTextRequest[] newArray(int size) {
            dsTaint.addTaint(size);
            ExtractedTextRequest[] var86E78B496F84ADC2A02E2F3E84295E42_2144861696 = (new ExtractedTextRequest[size]);
            return (ExtractedTextRequest[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ExtractedTextRequest[size];
        }

        
}; //Transformed anonymous class
}

