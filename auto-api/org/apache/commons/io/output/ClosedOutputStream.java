package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class ClosedOutputStream extends OutputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.648 -0400", hash_original_method = "712DB5B8F90CF6B35FA504E528B088F9", hash_generated_method = "712DB5B8F90CF6B35FA504E528B088F9")
    public ClosedOutputStream ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.648 -0400", hash_original_method = "E42F4A3BC6073DDBB791DEFDBE00CF19", hash_generated_method = "99E8D8E1E489969A9C29EBDAD555FFE3")
    @Override
    public void write(int b) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("write(" + b + ") failed: stream is closed");
        addTaint(b);
        // ---------- Original Method ----------
        //throw new IOException("write(" + b + ") failed: stream is closed");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.648 -0400", hash_original_field = "A8E14414F1A26B93AD14EA81ADD2AC2B", hash_generated_field = "8BD9C88FE3DAF296E746B8872518A91D")

    public static final ClosedOutputStream CLOSED_OUTPUT_STREAM = new ClosedOutputStream();
}

