package android.net;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ParseException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.055 -0400", hash_original_field = "D1FC8EAF36937BE0C3BA8CFE0A2C1BFE", hash_generated_field = "B6455F851CF376B6C7FE8E70467FED32")

    public String response;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.055 -0400", hash_original_method = "E43EF8DD9693C1DC19D1ACB3B5C49985", hash_generated_method = "705A6C04EF6F9F6860332A406292052E")
      ParseException(String response) {
        this.response = response;
        // ---------- Original Method ----------
        //this.response = response;
    }

    
}

