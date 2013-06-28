package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SecurityException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.661 -0400", hash_original_method = "0D8A79337436926212C4E8DACFE6A955", hash_generated_method = "49F62E2C6329A19237B5CEBA0FFCFB90")
    public  SecurityException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.661 -0400", hash_original_method = "35201AC9E2F0540A3FCA08DB4F71F2A3", hash_generated_method = "2B5388A512F651617E228BD4D9459369")
    public  SecurityException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.662 -0400", hash_original_method = "6D3B8DD6DA516F6B2B4EBB83E8379AAA", hash_generated_method = "58D1E8D930F28A5D739BE261B38FB0C2")
    public  SecurityException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.662 -0400", hash_original_method = "B0CE861A38AC7D57FFFB507001C97872", hash_generated_method = "8D1AEA529C4E516EB04747A04E4A10C9")
    public  SecurityException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.662 -0400", hash_original_field = "F5233592FF7BEAE80A28C621DBE0D7A3", hash_generated_field = "713BC78E703E562CFBF2DBB2AB4EDF1A")

    private static final long serialVersionUID = 6878364983674394167L;
}

