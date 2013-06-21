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
    protected boolean closed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.057 -0400", hash_original_method = "660987567E9729E012396F4A68CFDBA3", hash_generated_method = "660987567E9729E012396F4A68CFDBA3")
        public AbstractHttpOutputStream ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.057 -0400", hash_original_method = "BEB37A4CC4B7ECAA5E509CB7A19DC490", hash_generated_method = "1904859845F1C617BE62F7F8B2B0F9E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void write(int data) throws IOException {
        dsTaint.addTaint(data);
        write(new byte[] { (byte) data });
        // ---------- Original Method ----------
        //write(new byte[] { (byte) data });
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.058 -0400", hash_original_method = "9C8C395306DF0EF2B124A9030249421B", hash_generated_method = "7ED5824944EAAD3891275A558A397A99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

