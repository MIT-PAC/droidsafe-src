package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InputStream;

public class ClosedInputStream extends InputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.931 -0400", hash_original_method = "B0C9BD21CF08AD8B980B25A5B2E5F6EA", hash_generated_method = "B0C9BD21CF08AD8B980B25A5B2E5F6EA")
    public ClosedInputStream ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.932 -0400", hash_original_method = "7FDC5668BF104D2F1DB6279D6F3A1179", hash_generated_method = "F4C9BF3308ECEAAEB97D27613F61E96C")
    @Override
    public int read() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120441665 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120441665;
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.932 -0400", hash_original_field = "3FC7AEA16F858453A8776923652F30F3", hash_generated_field = "17CFB99BA7C6F24407F33DDCE858C876")

    public static final ClosedInputStream CLOSED_INPUT_STREAM = new ClosedInputStream();
}

