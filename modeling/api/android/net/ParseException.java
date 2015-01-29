package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ParseException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.012 -0500", hash_original_field = "98D89A15FF083E6E1A92EFA045F3BE29", hash_generated_field = "B6455F851CF376B6C7FE8E70467FED32")

    public String response;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.014 -0500", hash_original_method = "E43EF8DD9693C1DC19D1ACB3B5C49985", hash_generated_method = "E43EF8DD9693C1DC19D1ACB3B5C49985")
    
ParseException(String response) {
        this.response = response;
    }
    
}

