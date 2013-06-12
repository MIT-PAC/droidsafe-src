package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SAXException extends Exception {
    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.164 -0400", hash_original_method = "D831304643C6F5E396859CE263E8CD25", hash_generated_method = "CD7FB0B288B9FCFD1E3FAC84C96D4C2A")
    @DSModeled(DSC.SAFE)
    public SAXException() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.164 -0400", hash_original_method = "0B6772DEF84C5953639B673A22CD2D87", hash_generated_method = "D4800CB67AE44A3925F20808ED9C59D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXException(String message) {
        super(message);
        dsTaint.addTaint(message);
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.164 -0400", hash_original_method = "6C46F13EAE6D974667959E2EC15AB51C", hash_generated_method = "38BB0502A3399C15C114829DE551BAC3")
    @DSModeled(DSC.SAFE)
    public SAXException(Exception e) {
        dsTaint.addTaint(e.dsTaint);
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.164 -0400", hash_original_method = "DAF90944A95CF29FF719B165EE1D8D20", hash_generated_method = "37254C4E218D747092A332998BB336FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXException(String message, Exception e) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(e.dsTaint);
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.165 -0400", hash_original_method = "7F1A7B3B4DC8BE54F069CECA78CE108B", hash_generated_method = "FDED9D899DA08E828815D6D24E9DCB11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMessage() {
        String message;
        message = super.getMessage();
        {
            String var408515ED3D09EC3C3B76800C4BFC9C6C_1029453901 = (exception.getMessage());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String message = super.getMessage();
        //if (message == null && exception != null) {
        //return exception.getMessage();
    //} else {
        //return message;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.165 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "480DA5B9FE4C29D6DEE813D9A0F3DD36")
    @DSModeled(DSC.SAFE)
    public Exception getException() {
        return (Exception)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.165 -0400", hash_original_method = "0BE493810C06D201F4519F1260F94FAA", hash_generated_method = "FF82B7E31CBF4106372F5392F9ED37B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        {
            String varA3533D9289262C61FDFAE19883C309DF_725803483 = (exception.toString());
        } //End block
        {
            String var7713ADB6B04D250CDCDF8326BCEB2624_358857823 = (super.toString());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (exception != null) {
        //return exception.toString();
    //} else {
        //return super.toString();
    //}
    }

    
}


