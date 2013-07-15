package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class NumberParseException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.422 -0400", hash_original_field = "2A8BCE4C57FBA6E1E2136D9DB057B722", hash_generated_field = "84B9E028BBF2DC9E5382F00380C2F272")

    private ErrorType errorType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.422 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")

    private String message;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.423 -0400", hash_original_method = "E3BFB23E8C79BF87D1C5A9FB2A377F86", hash_generated_method = "3806F73A468A4900F06EBC218AF22D9C")
    public  NumberParseException(ErrorType errorType, String message) {
        super(message);
        this.message = message;
        this.errorType = errorType;
        // ---------- Original Method ----------
        //this.message = message;
        //this.errorType = errorType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.423 -0400", hash_original_method = "D589126B13584B530A9FB2F071914799", hash_generated_method = "56108EC99249D9264E5EE1C2E5761ACE")
    public ErrorType getErrorType() {
ErrorType var5A5A63BBE4A031A8D09DACEEAC4789E0_1243480726 =         errorType;
        var5A5A63BBE4A031A8D09DACEEAC4789E0_1243480726.addTaint(taint);
        return var5A5A63BBE4A031A8D09DACEEAC4789E0_1243480726;
        // ---------- Original Method ----------
        //return errorType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.424 -0400", hash_original_method = "6D8405A96F8D5D279CAA6C0BAAB6D3AE", hash_generated_method = "EFE89206D80608AE24E2188CC0671F1B")
    @Override
    public String toString() {
String varB31E1C29748E3ED94F8E603CD6A25C02_727789877 =         "Error type: " + errorType + ". " + message;
        varB31E1C29748E3ED94F8E603CD6A25C02_727789877.addTaint(taint);
        return varB31E1C29748E3ED94F8E603CD6A25C02_727789877;
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

