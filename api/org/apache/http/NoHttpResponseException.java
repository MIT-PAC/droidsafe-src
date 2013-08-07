package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;




public class NoHttpResponseException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.186 -0400", hash_original_method = "51433E3131C29EA8B44042173638BB72", hash_generated_method = "688C705B577B8CD6856E2BDA45269CDB")
    public  NoHttpResponseException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.186 -0400", hash_original_field = "1F595A2C8486AA3BCD5C22BF706492CF", hash_generated_field = "B4E44D7F3FB5052FBD548F2C3AF0E36F")

    private static final long serialVersionUID = -7658940387386078766L;
}

