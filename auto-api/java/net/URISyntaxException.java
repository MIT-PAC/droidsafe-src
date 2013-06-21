package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class URISyntaxException extends Exception {
    private String input;
    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.273 -0400", hash_original_method = "97528CB9DDAE82ED090B6E0F20E64C52", hash_generated_method = "FA55A320BC1877C54790F96D33D51D60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URISyntaxException(String input, String reason, int index) {
        super(reason);
        dsTaint.addTaint(index);
        dsTaint.addTaint(input);
        dsTaint.addTaint(reason);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (input == null || reason == null) {
            //throw new NullPointerException();
        //}
        //if (index < -1) {
            //throw new IllegalArgumentException();
        //}
        //this.input = input;
        //this.index = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.274 -0400", hash_original_method = "9E8506F7D035742973E1D45F72C781FB", hash_generated_method = "C927EDCCAD6D337B20A4A3C7E5400561")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URISyntaxException(String input, String reason) {
        super(reason);
        dsTaint.addTaint(input);
        dsTaint.addTaint(reason);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        index = -1;
        // ---------- Original Method ----------
        //if (input == null || reason == null) {
            //throw new NullPointerException();
        //}
        //this.input = input;
        //index = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.274 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "48B0F5CEF7537869A6C46DF0BD2A31DE")
    @DSModeled(DSC.SAFE)
    public int getIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.274 -0400", hash_original_method = "D4B65418D906ACD682013E7ACC1989F7", hash_generated_method = "D3855E592B571AACE9F302EB155E0397")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getReason() {
        String var49F0BD35F9E41BF3367B5B4196D58AAC_477967094 = (super.getMessage());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.getMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.274 -0400", hash_original_method = "DF4880B690A0BCFCB8F3C337A75DD5A0", hash_generated_method = "38C74D8F0F131E7E60E47275B9D686C2")
    @DSModeled(DSC.SAFE)
    public String getInput() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return input;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.274 -0400", hash_original_method = "2C0C7C544BFDCEB0F806A466417CE15E", hash_generated_method = "20CC1582239B61F7B927B8596BC3C324")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessage() {
        String reason;
        reason = super.getMessage();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String reason = super.getMessage();
        //if (index != -1) {
            //return reason + " at index " + index + ": " + input;
        //}
        //return reason + ": " + input;
    }

    
    private static final long serialVersionUID = 2137979680897488891L;
}

