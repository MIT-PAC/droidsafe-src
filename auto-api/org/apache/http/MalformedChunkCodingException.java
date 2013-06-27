package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class MalformedChunkCodingException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.598 -0400", hash_original_method = "FCD38A0808C3727AA87EA7F46AEF4310", hash_generated_method = "D8DAA721D0F103887C1D4E860770EBE7")
    public  MalformedChunkCodingException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.599 -0400", hash_original_method = "8529106FFAE0E25F63F016FC3AC665F8", hash_generated_method = "93F27E7A1054A90EC78E05053E38911D")
    public  MalformedChunkCodingException(final String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.599 -0400", hash_original_field = "74506B138BB0517E4AA9398D3ACB866D", hash_generated_field = "7BD318E17FC14CC512C544149E461F62")

    private static long serialVersionUID = 2158560246948994524L;
}

