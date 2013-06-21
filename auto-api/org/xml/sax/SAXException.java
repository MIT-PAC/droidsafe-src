package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SAXException extends Exception {
    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.419 -0400", hash_original_method = "D831304643C6F5E396859CE263E8CD25", hash_generated_method = "AAA5AC1F47C13D6FA9C3251A3CA70252")
    @DSModeled(DSC.SAFE)
    public SAXException() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.419 -0400", hash_original_method = "0B6772DEF84C5953639B673A22CD2D87", hash_generated_method = "45829325A27728ACF23771C3B2817394")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXException(String message) {
        super(message);
        dsTaint.addTaint(message);
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.419 -0400", hash_original_method = "6C46F13EAE6D974667959E2EC15AB51C", hash_generated_method = "424444ED436C73215B0898958EB201D7")
    @DSModeled(DSC.SAFE)
    public SAXException(Exception e) {
        dsTaint.addTaint(e.dsTaint);
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.420 -0400", hash_original_method = "DAF90944A95CF29FF719B165EE1D8D20", hash_generated_method = "E0096A91608823C151256BECA6BC2A5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXException(String message, Exception e) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(e.dsTaint);
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.420 -0400", hash_original_method = "7F1A7B3B4DC8BE54F069CECA78CE108B", hash_generated_method = "12994449DE09B97F809C358BEAE61F06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMessage() {
        String message;
        message = super.getMessage();
        {
            String var408515ED3D09EC3C3B76800C4BFC9C6C_1597693619 = (exception.getMessage());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.420 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "2C3AFB92F97725E71A554ACC471B64B4")
    @DSModeled(DSC.SAFE)
    public Exception getException() {
        return (Exception)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.420 -0400", hash_original_method = "0BE493810C06D201F4519F1260F94FAA", hash_generated_method = "021572A0B1922D8897567DF419418CA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        {
            String varA3533D9289262C61FDFAE19883C309DF_459451168 = (exception.toString());
        } //End block
        {
            String var7713ADB6B04D250CDCDF8326BCEB2624_1759446591 = (super.toString());
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

