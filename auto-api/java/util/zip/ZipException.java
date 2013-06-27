package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ZipException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.841 -0400", hash_original_method = "2167A1F4D125B524620850E643449987", hash_generated_method = "26CDA45503C3CB1EA8909514B5B7B27F")
    public  ZipException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.841 -0400", hash_original_method = "594D1061F67CD3EF6F4592503B4204F0", hash_generated_method = "578ACCD10E461F8BB245A2FF358B352E")
    public  ZipException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.841 -0400", hash_original_field = "F6F5B28DF01D2886A1A2A304D964ABD6", hash_generated_field = "F2CB8A20242F60F18A70B206F77A6D8B")

    private static long serialVersionUID = 8000196834066748623L;
}

