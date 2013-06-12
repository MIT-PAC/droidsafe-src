package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class NumberParseException extends Exception {
    private ErrorType errorType;
    private String message;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.234 -0400", hash_original_method = "E3BFB23E8C79BF87D1C5A9FB2A377F86", hash_generated_method = "4F0A4FC200B2BC31FEAE84AC703BCB19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NumberParseException(ErrorType errorType, String message) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(errorType.dsTaint);
        // ---------- Original Method ----------
        //this.message = message;
        //this.errorType = errorType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.234 -0400", hash_original_method = "D589126B13584B530A9FB2F071914799", hash_generated_method = "CF1BB90DF376ADF688BE679BA74A4559")
    @DSModeled(DSC.SAFE)
    public ErrorType getErrorType() {
        return (ErrorType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return errorType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.235 -0400", hash_original_method = "6D8405A96F8D5D279CAA6C0BAAB6D3AE", hash_generated_method = "546715C8C4E63B27AD9A60AC376B7C62")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Error type: " + errorType + ". " + message;
    }

    
    public enum ErrorType {
    INVALID_COUNTRY_CODE,
    NOT_A_NUMBER,
    TOO_SHORT_AFTER_IDD,
    TOO_SHORT_NSN,
    TOO_LONG,
  }

    
}


