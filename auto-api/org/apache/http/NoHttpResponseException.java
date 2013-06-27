package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class NoHttpResponseException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.551 -0400", hash_original_method = "51433E3131C29EA8B44042173638BB72", hash_generated_method = "688C705B577B8CD6856E2BDA45269CDB")
    public  NoHttpResponseException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.551 -0400", hash_original_field = "1F595A2C8486AA3BCD5C22BF706492CF", hash_generated_field = "4EFAE426B340568C1681B39B56660D33")

    private static long serialVersionUID = -7658940387386078766L;
}

