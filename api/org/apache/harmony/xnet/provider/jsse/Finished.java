package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class Finished extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.389 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

    private byte[] data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.390 -0400", hash_original_method = "5B583BB83679498D2C51EBF7375CF750", hash_generated_method = "DEE02002D3BDD8388F58700661F5D064")
    public  Finished(byte[] bytes) {
        data = bytes;
        length = data.length;
        // ---------- Original Method ----------
        //data = bytes;
        //length = data.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.390 -0400", hash_original_method = "7020D64852F49C66B1A4A40108BB938F", hash_generated_method = "EE1678930FDE2B65E42F76EF853A8CD8")
    public  Finished(HandshakeIODataStream in, int length) throws IOException {
    if(length == 12 || length == 36)        
        {
            data = in.read(length);
            this.length = data.length;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.391 -0400", hash_original_method = "E175A61E2BD704850DF6197D24D9CB45", hash_generated_method = "3AF954A43EB4DEE1FD736921D9EBCACC")
    @Override
    public void send(HandshakeIODataStream out) {
        addTaint(out.getTaint());
        out.write(data);
        // ---------- Original Method ----------
        //out.write(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.391 -0400", hash_original_method = "52E15100C019416DBC0E10E00C79BB89", hash_generated_method = "FC07633EDF89C4A1719BE1976A79FD4C")
    @Override
    public int getType() {
        int varF13F0093D69CD897D417E8793FD77359_805806413 = (Handshake.FINISHED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917211898 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917211898;
        // ---------- Original Method ----------
        //return Handshake.FINISHED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.391 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "D139A159EE16E8BE17BA82DDECDCE423")
    public byte[] getData() {
        byte[] var8D777F385D3DFEC8815D20F7496026DC_1443464434 = (data);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1471737831 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1471737831;
        // ---------- Original Method ----------
        //return data;
    }

    
}

