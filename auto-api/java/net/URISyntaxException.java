package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class URISyntaxException extends Exception {
    private static final long serialVersionUID = 2137979680897488891L;
    private String input;
    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.392 -0400", hash_original_method = "97528CB9DDAE82ED090B6E0F20E64C52", hash_generated_method = "135E426E620098C802B1A2475982D1DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URISyntaxException(String input, String reason, int index) {
        super(reason);
        dsTaint.addTaint(input);
        dsTaint.addTaint(index);
        dsTaint.addTaint(reason);
        {
            throw new NullPointerException();
        } //End block
        {
            throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.392 -0400", hash_original_method = "9E8506F7D035742973E1D45F72C781FB", hash_generated_method = "C75FEC609FEB977536495BAD43D67B1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URISyntaxException(String input, String reason) {
        super(reason);
        dsTaint.addTaint(input);
        dsTaint.addTaint(reason);
        {
            throw new NullPointerException();
        } //End block
        index = -1;
        // ---------- Original Method ----------
        //if (input == null || reason == null) {
            //throw new NullPointerException();
        //}
        //this.input = input;
        //index = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.392 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "08CD09DBA98285AA197C5060C4AAF1F5")
    @DSModeled(DSC.SAFE)
    public int getIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.392 -0400", hash_original_method = "D4B65418D906ACD682013E7ACC1989F7", hash_generated_method = "A79642F3AF90EA5E418056E926B5690B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getReason() {
        String var49F0BD35F9E41BF3367B5B4196D58AAC_791871429 = (super.getMessage());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.getMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.392 -0400", hash_original_method = "DF4880B690A0BCFCB8F3C337A75DD5A0", hash_generated_method = "672571E3A976FEA694821AC69029C398")
    @DSModeled(DSC.SAFE)
    public String getInput() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return input;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.392 -0400", hash_original_method = "2C0C7C544BFDCEB0F806A466417CE15E", hash_generated_method = "1D3C3CDF32270CE94430B0A42D223949")
    @DSModeled(DSC.SAFE)
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

    
}


