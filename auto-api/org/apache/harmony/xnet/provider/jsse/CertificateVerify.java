package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class CertificateVerify extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.509 -0400", hash_original_field = "85F856059502E932D8205DEEF6195328", hash_generated_field = "01A16F1FF859CB019178D18F23D7E606")

    byte[] signedHash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.509 -0400", hash_original_method = "F3A93A83C93F754D4846FCC8297217FD", hash_generated_method = "F255FE883E27342B88010D13EC49A529")
    public  CertificateVerify(byte[] hash) {
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    "INTERNAL ERROR: incorrect certificate verify hash");
        } //End block
        this.signedHash = hash;
        length = hash.length + 2;
        // ---------- Original Method ----------
        //if (hash == null || hash.length == 0) {
            //fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    //"INTERNAL ERROR: incorrect certificate verify hash");
        //}
        //this.signedHash = hash;
        //length = hash.length + 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.510 -0400", hash_original_method = "C08A411708B1C45834DF498B4B831402", hash_generated_method = "23D7C6D018FDBCD8DE834568B7A73CD9")
    public  CertificateVerify(HandshakeIODataStream in, int length) throws IOException {
        {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect CertificateVerify");
        } //End block
        {
            {
                boolean varE515780712A2A8C4B350FB23E27F935E_1787188337 = (in.readUint16() != length - 2);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.511 -0400", hash_original_method = "8645B529D351D3837595463E8D8CA061", hash_generated_method = "F70AA12CE7564D027A14B98C1CEF61DA")
    @Override
    public void send(HandshakeIODataStream out) {
        {
            out.writeUint16(signedHash.length);
            out.write(signedHash);
        } //End block
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //if (signedHash.length != 0) {
            //out.writeUint16(signedHash.length);
            //out.write(signedHash);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.511 -0400", hash_original_method = "78FC60AEF6831C8195D1932C8B8AE728", hash_generated_method = "CBE33699A466E2C1ACC444F8A295BA3A")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319258711 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319258711;
        // ---------- Original Method ----------
        //return Handshake.CERTIFICATE_VERIFY;
    }

    
}

