package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class Finished extends Message {
    private byte[] data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.768 -0400", hash_original_method = "5B583BB83679498D2C51EBF7375CF750", hash_generated_method = "E46EBBDC426006928CCF863159980550")
    @DSModeled(DSC.SAFE)
    public Finished(byte[] bytes) {
        dsTaint.addTaint(bytes[0]);
        length = data.length;
        // ---------- Original Method ----------
        //data = bytes;
        //length = data.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.769 -0400", hash_original_method = "7020D64852F49C66B1A4A40108BB938F", hash_generated_method = "1B0CE456FB6114B5568EED3720C77D56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Finished(HandshakeIODataStream in, int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(in.dsTaint);
        {
            data = in.read(length);
            this.length = data.length;
        } //End block
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect Finished");
        } //End block
        // ---------- Original Method ----------
        //if (length == 12 || length == 36) {
            //data = in.read(length);
            //this.length = data.length;
        //} else {
            //fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect Finished");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.769 -0400", hash_original_method = "E175A61E2BD704850DF6197D24D9CB45", hash_generated_method = "5066A1B86602D5CC953AFC29A99F8EF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void send(HandshakeIODataStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.write(data);
        // ---------- Original Method ----------
        //out.write(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.769 -0400", hash_original_method = "52E15100C019416DBC0E10E00C79BB89", hash_generated_method = "422D7CBDA9CAAD9920C5A3099186E7A4")
    @DSModeled(DSC.SAFE)
    @Override
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Handshake.FINISHED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.769 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "6EEE43E3F084A3C1D039E7773AC85B77")
    @DSModeled(DSC.SAFE)
    public byte[] getData() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return data;
    }

    
}

