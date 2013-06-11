package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ExtractedTextRequest implements Parcelable {
    public int token;
    public int flags;
    public int hintMaxLines;
    public int hintMaxChars;
    public static final Parcelable.Creator<ExtractedTextRequest> CREATOR = new Parcelable.Creator<ExtractedTextRequest>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.085 -0400", hash_original_method = "30E3470F48B04522780245F06863DCB7", hash_generated_method = "88836A7D2871294F06F10CE24B6D51FF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.085 -0400", hash_original_method = "319315B697FC2583F1B96031A391A54D", hash_generated_method = "16F9C2CF73A99B7019404A38630FD13D")
        @DSModeled(DSC.SAFE)
        public ExtractedTextRequest[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ExtractedTextRequest[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ExtractedTextRequest[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.085 -0400", hash_original_method = "86DA45F615C261383D752E615DE3B691", hash_generated_method = "4651391CA67F59BDC445264EBF38091E")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.085 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
}


