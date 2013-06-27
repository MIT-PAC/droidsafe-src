package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class Finished extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.988 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

    private byte[] data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.989 -0400", hash_original_method = "5B583BB83679498D2C51EBF7375CF750", hash_generated_method = "DEE02002D3BDD8388F58700661F5D064")
    public  Finished(byte[] bytes) {
        data = bytes;
        length = data.length;
        // ---------- Original Method ----------
        //data = bytes;
        //length = data.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.995 -0400", hash_original_method = "7020D64852F49C66B1A4A40108BB938F", hash_generated_method = "6E9E687D6826CC3B1B68A22DAFF1A558")
    public  Finished(HandshakeIODataStream in, int length) throws IOException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.995 -0400", hash_original_method = "E175A61E2BD704850DF6197D24D9CB45", hash_generated_method = "27D8B06A697018A4A77F745BD690F19D")
    @Override
    public void send(HandshakeIODataStream out) {
        out.write(data);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.write(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.995 -0400", hash_original_method = "52E15100C019416DBC0E10E00C79BB89", hash_generated_method = "210AE35FEE7F0C1C60BD60514630B3E4")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745312223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745312223;
        // ---------- Original Method ----------
        //return Handshake.FINISHED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.996 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "A6F8E6F8012FF91BFCF95C577DDDB693")
    public byte[] getData() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1141795969 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1141795969;
        // ---------- Original Method ----------
        //return data;
    }

    
}

