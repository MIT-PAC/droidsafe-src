package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DOMException extends RuntimeException {
    public short   code;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.402 -0400", hash_original_method = "0AC2D186CABB78D2BA6332ECA7EA8409", hash_generated_method = "715723F48AAA277645B79ED126C11E89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DOMException(short code, String message) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(code);
        // ---------- Original Method ----------
        //this.code = code;
    }

    
    public static final short INDEX_SIZE_ERR            = 1;
    public static final short DOMSTRING_SIZE_ERR        = 2;
    public static final short HIERARCHY_REQUEST_ERR     = 3;
    public static final short WRONG_DOCUMENT_ERR        = 4;
    public static final short INVALID_CHARACTER_ERR     = 5;
    public static final short NO_DATA_ALLOWED_ERR       = 6;
    public static final short NO_MODIFICATION_ALLOWED_ERR = 7;
    public static final short NOT_FOUND_ERR             = 8;
    public static final short NOT_SUPPORTED_ERR         = 9;
    public static final short INUSE_ATTRIBUTE_ERR       = 10;
    public static final short INVALID_STATE_ERR         = 11;
    public static final short SYNTAX_ERR                = 12;
    public static final short INVALID_MODIFICATION_ERR  = 13;
    public static final short NAMESPACE_ERR             = 14;
    public static final short INVALID_ACCESS_ERR        = 15;
    public static final short VALIDATION_ERR            = 16;
    public static final short TYPE_MISMATCH_ERR         = 17;
}

