package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CancellationException extends IllegalStateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.509 -0400", hash_original_method = "C0676E9FE520D18F322700EE730819D6", hash_generated_method = "916A68EDA76ED1B1D1A06764902B741C")
    public  CancellationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.510 -0400", hash_original_method = "6CF19E73C026523F689130FF9C39751C", hash_generated_method = "4F7BCB4868E4EDC72471C86B6E141ECD")
    public  CancellationException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.510 -0400", hash_original_field = "33B8929E8217D4A61170AD88264CD7B1", hash_generated_field = "EE01F37139029D3BCEDEB3F0679BB033")

    private static long serialVersionUID = -9202173006928992231L;
}

