package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class CertificateVerify extends Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.798 -0500", hash_original_field = "01A16F1FF859CB019178D18F23D7E606", hash_generated_field = "01A16F1FF859CB019178D18F23D7E606")

    byte[] signedHash;

    /**
     * Creates outbound message
     *
     * @param hash
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.801 -0500", hash_original_method = "F3A93A83C93F754D4846FCC8297217FD", hash_generated_method = "59A4FA9E9403F85D85E0377B015C2830")
    
public CertificateVerify(byte[] hash) {
        if (hash == null || hash.length == 0) {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    "INTERNAL ERROR: incorrect certificate verify hash");
        }
        this.signedHash = hash;
        length = hash.length + 2;
    }

    /**
     * Creates inbound message
     *
     * @param in
     * @param length
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.804 -0500", hash_original_method = "C08A411708B1C45834DF498B4B831402", hash_generated_method = "8348D54380A8F9D9486E166033DC9D2B")
    
public CertificateVerify(HandshakeIODataStream in, int length)
            throws IOException {
        if (length == 0) {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect CertificateVerify");
        } else {
            if (in.readUint16() != length - 2) {
                fatalAlert(AlertProtocol.DECODE_ERROR,
                        "DECODE ERROR: incorrect CertificateVerify");
            }
            signedHash = in.read(length -2);
        }
        this.length = length;
    }

    /**
     * Sends message
     *
     * @param out
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.806 -0500", hash_original_method = "8645B529D351D3837595463E8D8CA061", hash_generated_method = "36B01B2A1409B1CA07BD439ECEEB1973")
    
@Override
    public void send(HandshakeIODataStream out) {
        if (signedHash.length != 0) {
            out.writeUint16(signedHash.length);
            out.write(signedHash);
        }
    }

    /**
     * Returns message type
     *
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.808 -0500", hash_original_method = "78FC60AEF6831C8195D1932C8B8AE728", hash_generated_method = "E04DFD4841F171C32FE7096C4AA21589")
    
@Override
    public int getType() {
        return Handshake.CERTIFICATE_VERIFY;
    }
    
}

