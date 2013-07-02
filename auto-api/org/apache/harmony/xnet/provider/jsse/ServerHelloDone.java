package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class ServerHelloDone extends Message {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.265 -0400", hash_original_method = "452B2923DC2D49E8C5C850D6FAC160F0", hash_generated_method = "444AAD10FB3A2E0EE274ED19A66E35AB")
    public  ServerHelloDone() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.266 -0400", hash_original_method = "80970884A2E49299D172B83B85177CAF", hash_generated_method = "80A121A8A02E111E47EA9FD819469AFC")
    public  ServerHelloDone(HandshakeIODataStream in, int length) throws IOException {
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHelloDone");
        } 
        addTaint(in.getTaint());
        addTaint(length);
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.266 -0400", hash_original_method = "52BF089D22903982B0C882C52DE70EC3", hash_generated_method = "9633694D7184296AF73D33CE8CCEA8FC")
    @Override
    public void send(HandshakeIODataStream out) {
        addTaint(out.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.266 -0400", hash_original_method = "7AF5A4434AA58EF13D06038DF32CDF19", hash_generated_method = "30DE5B81F73D88DBB78C123DA5291CA2")
    @Override
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_698173394 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_698173394;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.267 -0400", hash_original_method = "240B7202464892A2DF96B887945F5E1E", hash_generated_method = "EBAF91FC9A67F6009ECC77D4727A04B4")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_336253099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_336253099;
        
        
    }

    
}

