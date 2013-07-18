package java.net;

// Droidsafe Imports
import java.io.FileDescriptor;
import java.io.IOException;

import droidsafe.annotations.DSGenerator;

public class PlainServerSocketImpl extends PlainSocketImpl {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.066 -0400", hash_original_method = "CB92FA37CCF842A0A29D6A265F149C47", hash_generated_method = "B39DF470BED074E64F0FF7F3AC8F71B2")
    public  PlainServerSocketImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.066 -0400", hash_original_method = "188CEC52BC9D693EB11C74D723EB792B", hash_generated_method = "79443F2EBF1404FA718A959E906BF2D0")
    public  PlainServerSocketImpl(FileDescriptor fd) {
        super(fd);
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.066 -0400", hash_original_method = "76AEC2BC7D7414BFD7FB8B5DC8DD0C2B", hash_generated_method = "6C8C09DDE2460C3F13B1B7E8EF3A01C1")
    @Override
    protected void create(boolean isStreaming) throws IOException {
        addTaint(isStreaming);
        super.create(isStreaming);
        if(isStreaming)        
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

