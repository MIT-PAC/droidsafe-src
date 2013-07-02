package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketOptions;

public class PlainServerSocketImpl extends PlainSocketImpl {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.575 -0400", hash_original_method = "CB92FA37CCF842A0A29D6A265F149C47", hash_generated_method = "B39DF470BED074E64F0FF7F3AC8F71B2")
    public  PlainServerSocketImpl() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.575 -0400", hash_original_method = "188CEC52BC9D693EB11C74D723EB792B", hash_generated_method = "79443F2EBF1404FA718A959E906BF2D0")
    public  PlainServerSocketImpl(FileDescriptor fd) {
        super(fd);
        addTaint(fd.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.576 -0400", hash_original_method = "76AEC2BC7D7414BFD7FB8B5DC8DD0C2B", hash_generated_method = "EC17B4C6AD5AA874D538B123440A0439")
    @Override
    protected void create(boolean isStreaming) throws IOException {
        super.create(isStreaming);
        {
            setOption(SocketOptions.SO_REUSEADDR, Boolean.TRUE);
        } 
        addTaint(isStreaming);
        
        
        
            
        
    }

    
}

