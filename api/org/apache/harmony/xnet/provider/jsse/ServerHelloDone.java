package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;





public class ServerHelloDone extends Message {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.910 -0400", hash_original_method = "452B2923DC2D49E8C5C850D6FAC160F0", hash_generated_method = "444AAD10FB3A2E0EE274ED19A66E35AB")
    public  ServerHelloDone() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.911 -0400", hash_original_method = "80970884A2E49299D172B83B85177CAF", hash_generated_method = "5EA7237B4BD759A89661CA21FF8F1DE9")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.911 -0400", hash_original_method = "52BF089D22903982B0C882C52DE70EC3", hash_generated_method = "9633694D7184296AF73D33CE8CCEA8FC")
    @Override
    public void send(HandshakeIODataStream out) {
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.912 -0400", hash_original_method = "7AF5A4434AA58EF13D06038DF32CDF19", hash_generated_method = "E1867B0F9A8159466A187EC2D89204BA")
    @Override
    public int length() {
        int varCFCD208495D565EF66E7DFF9F98764DA_596527236 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352900681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352900681;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.912 -0400", hash_original_method = "240B7202464892A2DF96B887945F5E1E", hash_generated_method = "2AEAC2712E55C2327EC0BB31C9892816")
    @Override
    public int getType() {
        int var556587E6CE00AC843A402484A772013A_1167100964 = (Handshake.SERVER_HELLO_DONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2116405407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2116405407;
        // ---------- Original Method ----------
        //return Handshake.SERVER_HELLO_DONE;
    }

    
}

