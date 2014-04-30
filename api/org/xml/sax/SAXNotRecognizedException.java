package org.xml.sax;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SAXNotRecognizedException extends SAXException {

    /**
     * Default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.581 -0500", hash_original_method = "2CF643FEC5E16E9FDCFBAF4C08D87D85", hash_generated_method = "E512291726A01C2EA0534C297FA49C24")
    
public SAXNotRecognizedException ()
    {
    }

    /**
     * Construct a new exception with the given message.
     *
     * @param message The text message of the exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.583 -0500", hash_original_method = "84A25E65A73DED1248F34FD8C53BD2A1", hash_generated_method = "412AEC39F7625D9BD34A4DF4F1D28F5C")
    
public SAXNotRecognizedException (String message)
    {
    super(message);
    }
    
}

