package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InstantiationError extends IncompatibleClassChangeError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.804 -0400", hash_original_method = "0CADFA7EDCF977E1C3E40BA09A641E39", hash_generated_method = "FBD8BFBFF8541964AECF4F628B71A9C5")
    public  InstantiationError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.805 -0400", hash_original_method = "023CF4960A8F6AD78560985CF4A496AC", hash_generated_method = "96ED0A295193144E3FB5C2522C000545")
    public  InstantiationError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.805 -0400", hash_original_method = "715FEA28AECD396E352AFBA27C6E8A8B", hash_generated_method = "BA45D5D1D52442F141113654F97DA41A")
      InstantiationError(Class<?> clazz) {
        super(clazz.getName());
        addTaint(clazz.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.805 -0400", hash_original_field = "7D153DF0BEE2E24363226F18BDF3D92F", hash_generated_field = "0334A42793BEE8296DDF4EA8D0113F6F")

    private static long serialVersionUID = -4885810657349421204L;
}

