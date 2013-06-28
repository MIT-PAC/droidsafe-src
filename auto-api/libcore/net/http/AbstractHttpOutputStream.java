package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

abstract class AbstractHttpOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.605 -0400", hash_original_field = "349E686330723975502E9EF4F939A5AC", hash_generated_field = "BA207E645FA463C53A82992C378F82FC")

    protected boolean closed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.605 -0400", hash_original_method = "2835FA09B3F183CC926451AC7D6D78D7", hash_generated_method = "2835FA09B3F183CC926451AC7D6D78D7")
    public AbstractHttpOutputStream ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.606 -0400", hash_original_method = "BEB37A4CC4B7ECAA5E509CB7A19DC490", hash_generated_method = "396AAE13669F56651BBE96A5280F663A")
    @Override
    public final void write(int data) throws IOException {
        write(new byte[] { (byte) data });
        addTaint(data);
        // ---------- Original Method ----------
        //write(new byte[] { (byte) data });
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.606 -0400", hash_original_method = "9C8C395306DF0EF2B124A9030249421B", hash_generated_method = "7ED5824944EAAD3891275A558A397A99")
    protected final void checkNotClosed() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("stream closed");
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("stream closed");
        //}
    }

    
}

