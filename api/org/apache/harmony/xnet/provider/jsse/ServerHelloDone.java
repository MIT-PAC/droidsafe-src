package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;





public class ServerHelloDone extends Message {

    /**
     * Creates outbound message
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.147 -0500", hash_original_method = "452B2923DC2D49E8C5C850D6FAC160F0", hash_generated_method = "F059B6B18159C31869399583D28BD4E6")
    
public ServerHelloDone() {
    }

    /**
     * Creates inbound message
     * @param in
     * @param length
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.149 -0500", hash_original_method = "80970884A2E49299D172B83B85177CAF", hash_generated_method = "67923345C9A98253BC505F1A153CFB5F")
    
public ServerHelloDone(HandshakeIODataStream in, int length)
            throws IOException {
        if (length != 0) {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHelloDone");
        }
    }

    /**
     * Sends message
     * @param out
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.151 -0500", hash_original_method = "52BF089D22903982B0C882C52DE70EC3", hash_generated_method = "3B749C8EC23DB82A54E30BDF71BEA1E8")
    
@Override
    public void send(HandshakeIODataStream out) {
    }

    /**
     * Returns message length
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.154 -0500", hash_original_method = "7AF5A4434AA58EF13D06038DF32CDF19", hash_generated_method = "E790735BA5A7D8C4474CBC6F75D30A60")
    
@Override
    public int length() {
        return 0;
    }

    /**
     * Returns message type
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.156 -0500", hash_original_method = "240B7202464892A2DF96B887945F5E1E", hash_generated_method = "A0E00FA3BA2BE0429305ED009F10FC4A")
    
@Override
    public int getType() {
        return Handshake.SERVER_HELLO_DONE;
    }

    
}

