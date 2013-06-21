package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class CertificateVerify extends Message {
    byte[] signedHash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.559 -0400", hash_original_method = "F3A93A83C93F754D4846FCC8297217FD", hash_generated_method = "AA545C34DFA5790885C3769FF54C5C7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateVerify(byte[] hash) {
        dsTaint.addTaint(hash[0]);
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    "INTERNAL ERROR: incorrect certificate verify hash");
        } //End block
        length = hash.length + 2;
        // ---------- Original Method ----------
        //if (hash == null || hash.length == 0) {
            //fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    //"INTERNAL ERROR: incorrect certificate verify hash");
        //}
        //this.signedHash = hash;
        //length = hash.length + 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.559 -0400", hash_original_method = "C08A411708B1C45834DF498B4B831402", hash_generated_method = "81CB59CBD27791881C0BC48E6C13B0D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateVerify(HandshakeIODataStream in, int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(in.dsTaint);
        {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect CertificateVerify");
        } //End block
        {
            {
                boolean varE515780712A2A8C4B350FB23E27F935E_1763106278 = (in.readUint16() != length - 2);
                {
                    fatalAlert(AlertProtocol.DECODE_ERROR,
                        "DECODE ERROR: incorrect CertificateVerify");
                } //End block
            } //End collapsed parenthetic
            signedHash = in.read(length -2);
        } //End block
        this.length = length;
        // ---------- Original Method ----------
        //if (length == 0) {
            //fatalAlert(AlertProtocol.DECODE_ERROR,
                    //"DECODE ERROR: incorrect CertificateVerify");
        //} else {
            //if (in.readUint16() != length - 2) {
                //fatalAlert(AlertProtocol.DECODE_ERROR,
                        //"DECODE ERROR: incorrect CertificateVerify");
            //}
            //signedHash = in.read(length -2);
        //}
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.560 -0400", hash_original_method = "8645B529D351D3837595463E8D8CA061", hash_generated_method = "A9B976A497E2633EC9056CA77D113794")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void send(HandshakeIODataStream out) {
        dsTaint.addTaint(out.dsTaint);
        {
            out.writeUint16(signedHash.length);
            out.write(signedHash);
        } //End block
        // ---------- Original Method ----------
        //if (signedHash.length != 0) {
            //out.writeUint16(signedHash.length);
            //out.write(signedHash);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.560 -0400", hash_original_method = "78FC60AEF6831C8195D1932C8B8AE728", hash_generated_method = "3BCCD96A539824A3D1787C9295E9E867")
    @DSModeled(DSC.SAFE)
    @Override
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Handshake.CERTIFICATE_VERIFY;
    }

    
}

