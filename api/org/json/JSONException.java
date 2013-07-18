package org.json;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

public class JSONException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.329 -0400", hash_original_method = "D7D56E71DBC1CB75BB9A8A89BF06234E", hash_generated_method = "F5CC0B0C7C84C28DA2AB6A2CEC56BC3E")
    public  JSONException(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
}

