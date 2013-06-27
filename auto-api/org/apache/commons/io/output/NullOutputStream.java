package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class NullOutputStream extends OutputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.484 -0400", hash_original_method = "71D212501999CE3853E127EBBB4ABD24", hash_generated_method = "71D212501999CE3853E127EBBB4ABD24")
    public NullOutputStream ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.485 -0400", hash_original_method = "6E71F74AE8E714A009EC36E9EAC6B88D", hash_generated_method = "80E2AA9AA0A5E40F9A3E1390E07C48B2")
    @Override
    public void write(byte[] b, int off, int len) {
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.485 -0400", hash_original_method = "074160D8FBF16E881F1835AE7B894602", hash_generated_method = "A0A41554A799D17D7F8CC13E20744EEA")
    @Override
    public void write(int b) {
        addTaint(b);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.486 -0400", hash_original_method = "14210D7CE620CE82255795453724F2AF", hash_generated_method = "2C7AFD2F1BA8FF9EB58342799B0D3374")
    @Override
    public void write(byte[] b) throws IOException {
        addTaint(b[0]);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.486 -0400", hash_original_field = "661DF324C98CC487B2E0C6F5913DCBBE", hash_generated_field = "F2F32214441D6EF38003298AF8948EEE")

    public static final NullOutputStream NULL_OUTPUT_STREAM = new NullOutputStream();
}

