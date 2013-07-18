package org.apache.http;

// Droidsafe Imports
import java.io.IOException;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class MalformedChunkCodingException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.171 -0400", hash_original_method = "FCD38A0808C3727AA87EA7F46AEF4310", hash_generated_method = "D8DAA721D0F103887C1D4E860770EBE7")
    public  MalformedChunkCodingException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.171 -0400", hash_original_method = "8529106FFAE0E25F63F016FC3AC665F8", hash_generated_method = "93F27E7A1054A90EC78E05053E38911D")
    public  MalformedChunkCodingException(final String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.171 -0400", hash_original_field = "74506B138BB0517E4AA9398D3ACB866D", hash_generated_field = "C0AED9106A819C192C378EFE5282CFEA")

    private static final long serialVersionUID = 2158560246948994524L;
}

