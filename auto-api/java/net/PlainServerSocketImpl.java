package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketOptions;

public class PlainServerSocketImpl extends PlainSocketImpl {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.024 -0400", hash_original_method = "CB92FA37CCF842A0A29D6A265F149C47", hash_generated_method = "B39DF470BED074E64F0FF7F3AC8F71B2")
    @DSModeled(DSC.SAFE)
    public PlainServerSocketImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.024 -0400", hash_original_method = "188CEC52BC9D693EB11C74D723EB792B", hash_generated_method = "998952B304609C5CB683B394AF3B6FC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PlainServerSocketImpl(FileDescriptor fd) {
        super(fd);
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.024 -0400", hash_original_method = "76AEC2BC7D7414BFD7FB8B5DC8DD0C2B", hash_generated_method = "DC30BDDB0AE28EBBF47EF8806567D349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void create(boolean isStreaming) throws IOException {
        dsTaint.addTaint(isStreaming);
        super.create(isStreaming);
        {
            setOption(SocketOptions.SO_REUSEADDR, Boolean.TRUE);
        } //End block
        // ---------- Original Method ----------
        //super.create(isStreaming);
        //if (isStreaming) {
            //setOption(SocketOptions.SO_REUSEADDR, Boolean.TRUE);
        //}
    }

    
}

