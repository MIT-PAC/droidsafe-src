package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParseException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.931 -0400", hash_original_field = "D1FC8EAF36937BE0C3BA8CFE0A2C1BFE", hash_generated_field = "B6455F851CF376B6C7FE8E70467FED32")

    public String response;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.932 -0400", hash_original_method = "E43EF8DD9693C1DC19D1ACB3B5C49985", hash_generated_method = "705A6C04EF6F9F6860332A406292052E")
      ParseException(String response) {
        this.response = response;
        // ---------- Original Method ----------
        //this.response = response;
    }

    
}

