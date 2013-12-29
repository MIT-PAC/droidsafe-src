package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;



public class PlainServerSocketImpl extends PlainSocketImpl {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.963 -0500", hash_original_method = "CB92FA37CCF842A0A29D6A265F149C47", hash_generated_method = "8358F680F9D52E3259C8D1FCC816F95B")
    public PlainServerSocketImpl() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.963 -0500", hash_original_method = "188CEC52BC9D693EB11C74D723EB792B", hash_generated_method = "391C9D44B19A74797BC113CF7EE3DF0C")
    public PlainServerSocketImpl(FileDescriptor fd) {
        super(fd);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.964 -0500", hash_original_method = "76AEC2BC7D7414BFD7FB8B5DC8DD0C2B", hash_generated_method = "9EFEF6DC5395C4E32A8858AF6636850F")
    @Override
protected void create(boolean isStreaming) throws IOException {
        super.create(isStreaming);
        if (isStreaming) {
            setOption(SocketOptions.SO_REUSEADDR, Boolean.TRUE);
        }
    }

    
}

