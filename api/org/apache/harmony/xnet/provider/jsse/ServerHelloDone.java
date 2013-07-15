package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class ServerHelloDone extends Message {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.649 -0400", hash_original_method = "452B2923DC2D49E8C5C850D6FAC160F0", hash_generated_method = "444AAD10FB3A2E0EE274ED19A66E35AB")
    public  ServerHelloDone() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.650 -0400", hash_original_method = "80970884A2E49299D172B83B85177CAF", hash_generated_method = "5EA7237B4BD759A89661CA21FF8F1DE9")
    public  ServerHelloDone(HandshakeIODataStream in, int length) throws IOException {
        addTaint(length);
        addTaint(in.getTaint());
    if(length != 0)        
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHelloDone");
        } //End block
        // ---------- Original Method ----------
        //if (length != 0) {
            //fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHelloDone");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.650 -0400", hash_original_method = "52BF089D22903982B0C882C52DE70EC3", hash_generated_method = "9633694D7184296AF73D33CE8CCEA8FC")
    @Override
    public void send(HandshakeIODataStream out) {
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.650 -0400", hash_original_method = "7AF5A4434AA58EF13D06038DF32CDF19", hash_generated_method = "FD7D6D7F42EC484CA0E43E3E46554E9F")
    @Override
    public int length() {
        int varCFCD208495D565EF66E7DFF9F98764DA_634464463 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331116997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331116997;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.650 -0400", hash_original_method = "240B7202464892A2DF96B887945F5E1E", hash_generated_method = "DF732CF17546370672198576161616FF")
    @Override
    public int getType() {
        int var556587E6CE00AC843A402484A772013A_59867704 = (Handshake.SERVER_HELLO_DONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_95606235 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_95606235;
        // ---------- Original Method ----------
        //return Handshake.SERVER_HELLO_DONE;
    }

    
}

