package org.apache.http.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;




public class ClientProtocolException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.071 -0500", hash_original_field = "462EACB3E829F46C6323C58C66DC2496", hash_generated_field = "849904E61BBB72520A629731F16C7F17")

    
    private static final long serialVersionUID = -5596590843227115865L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.071 -0500", hash_original_method = "3260DCF079E7C772EA6A90502130DC83", hash_generated_method = "679FD2C496E1A6B6BEF706416CA3D15F")
    public ClientProtocolException() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.072 -0500", hash_original_method = "98A3EFA06D403E8456E33B2220E5EB15", hash_generated_method = "B644FD530B41216E74AE8EC4DF1521AE")
    public ClientProtocolException(String s) {
        super(s);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.073 -0500", hash_original_method = "CE5566FA43618E2C322AA845802DCAD6", hash_generated_method = "D718F5176578EB652CC36E17D75FE886")
    public ClientProtocolException(Throwable cause) {
        initCause(cause);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.074 -0500", hash_original_method = "3D3F161C5740C8F0A7A6AC126178E78A", hash_generated_method = "62033BAF67972676DEC151E2A00F0CD5")
    public ClientProtocolException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }
}

