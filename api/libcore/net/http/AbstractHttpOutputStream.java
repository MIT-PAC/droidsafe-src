package libcore.net.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;




abstract class AbstractHttpOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.894 -0400", hash_original_field = "349E686330723975502E9EF4F939A5AC", hash_generated_field = "BA207E645FA463C53A82992C378F82FC")

    protected boolean closed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.894 -0400", hash_original_method = "2835FA09B3F183CC926451AC7D6D78D7", hash_generated_method = "2835FA09B3F183CC926451AC7D6D78D7")
    public AbstractHttpOutputStream ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.894 -0400", hash_original_method = "BEB37A4CC4B7ECAA5E509CB7A19DC490", hash_generated_method = "5D54B0DD1123451877E2B94FE771801B")
    @Override
    public final void write(int data) throws IOException {
        addTaint(data);
        write(new byte[] { (byte) data });
        // ---------- Original Method ----------
        //write(new byte[] { (byte) data });
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.895 -0400", hash_original_method = "9C8C395306DF0EF2B124A9030249421B", hash_generated_method = "0A739AAA2F448DA9623927F8026ADDD1")
    protected final void checkNotClosed() throws IOException {
        if(closed)        
        {
            IOException var8D1E5C4B5F667C4541A761B82D8E7D19_1244902571 = new IOException("stream closed");
            var8D1E5C4B5F667C4541A761B82D8E7D19_1244902571.addTaint(taint);
            throw var8D1E5C4B5F667C4541A761B82D8E7D19_1244902571;
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("stream closed");
        //}
    }

    
}

