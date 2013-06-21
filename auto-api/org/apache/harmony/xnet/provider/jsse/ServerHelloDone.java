package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ServerHelloDone extends Message {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.382 -0400", hash_original_method = "452B2923DC2D49E8C5C850D6FAC160F0", hash_generated_method = "444AAD10FB3A2E0EE274ED19A66E35AB")
    @DSModeled(DSC.SAFE)
    public ServerHelloDone() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.383 -0400", hash_original_method = "80970884A2E49299D172B83B85177CAF", hash_generated_method = "177FE2AF3A88A59AC796F109C08CFDDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerHelloDone(HandshakeIODataStream in, int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(in.dsTaint);
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHelloDone");
        } //End block
        // ---------- Original Method ----------
        //if (length != 0) {
            //fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHelloDone");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.383 -0400", hash_original_method = "52BF089D22903982B0C882C52DE70EC3", hash_generated_method = "C9E4AF73B58712C9BE513C6A867C9358")
    @DSModeled(DSC.SAFE)
    @Override
    public void send(HandshakeIODataStream out) {
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.383 -0400", hash_original_method = "7AF5A4434AA58EF13D06038DF32CDF19", hash_generated_method = "A69344124627572D3750A114CF5A4DD3")
    @DSModeled(DSC.SAFE)
    @Override
    public int length() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.383 -0400", hash_original_method = "240B7202464892A2DF96B887945F5E1E", hash_generated_method = "5F2DF2B04FBEB34C233A7C0473D380B8")
    @DSModeled(DSC.SAFE)
    @Override
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Handshake.SERVER_HELLO_DONE;
    }

    
}

