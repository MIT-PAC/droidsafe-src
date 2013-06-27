package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ServerHelloDone extends Message {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.933 -0400", hash_original_method = "452B2923DC2D49E8C5C850D6FAC160F0", hash_generated_method = "444AAD10FB3A2E0EE274ED19A66E35AB")
    public  ServerHelloDone() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.933 -0400", hash_original_method = "80970884A2E49299D172B83B85177CAF", hash_generated_method = "80A121A8A02E111E47EA9FD819469AFC")
    public  ServerHelloDone(HandshakeIODataStream in, int length) throws IOException {
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHelloDone");
        } //End block
        addTaint(in.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //if (length != 0) {
            //fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHelloDone");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.934 -0400", hash_original_method = "52BF089D22903982B0C882C52DE70EC3", hash_generated_method = "9633694D7184296AF73D33CE8CCEA8FC")
    @Override
    public void send(HandshakeIODataStream out) {
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.934 -0400", hash_original_method = "7AF5A4434AA58EF13D06038DF32CDF19", hash_generated_method = "FACF438018ED8FF518341573F0DB9628")
    @Override
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37493187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37493187;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.935 -0400", hash_original_method = "240B7202464892A2DF96B887945F5E1E", hash_generated_method = "B9C2274E1BD5447C8519E2818D3A6CA7")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049141383 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049141383;
        // ---------- Original Method ----------
        //return Handshake.SERVER_HELLO_DONE;
    }

    
}

