package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public class AutoCloseInputStream extends ProxyInputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.810 -0400", hash_original_method = "C01D66AAAB14EA4E4DF6A9979EF6E5B0", hash_generated_method = "1DF94A4FF4B902D30E23134716F70383")
    public  AutoCloseInputStream(InputStream in) {
        super(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.810 -0400", hash_original_method = "E9909FB3F008581898CAEA5C0FAA4CC7", hash_generated_method = "18C2D7E365518BCBC5884EE4E3021D9C")
    @Override
    public void close() throws IOException {
        in.close();
        in = new ClosedInputStream();
        // ---------- Original Method ----------
        //in.close();
        //in = new ClosedInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.810 -0400", hash_original_method = "1A943425CA4F660D14F7D119D0C80385", hash_generated_method = "069E8DA8FB0C0D57EFF55FBE4C2B199D")
    @Override
    protected void afterRead(int n) throws IOException {
        {
            close();
        } //End block
        addTaint(n);
        // ---------- Original Method ----------
        //if (n == -1) {
            //close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.811 -0400", hash_original_method = "2E21A04735F7B7DFBA8D51C21EAA3D5C", hash_generated_method = "1739E6BBD03654B983B913F30B6E5FDA")
    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
        // ---------- Original Method ----------
        //close();
        //super.finalize();
    }

    
}

