package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import libcore.io.Streams;

public class CertificateRequest extends Message {
    byte[] certificate_types;
    X500Principal[] certificate_authorities;
    private String[] types;
    private byte[][] encoded_principals;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.554 -0400", hash_original_method = "CB3C7AA59A60FE20BA988C0CAC39DBAA", hash_generated_method = "436C528ED367131B946703189C6E919F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateRequest(byte[] certificate_types,
                              X509Certificate[] accepted) {
        dsTaint.addTaint(accepted[0].dsTaint);
        dsTaint.addTaint(certificate_types[0]);
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    "CertificateRequest: array of certificate authority certificates is null");
        } //End block
        int totalPrincipalsLength;
        totalPrincipalsLength = 0;
        certificate_authorities = new X500Principal[accepted.length];
        encoded_principals = new byte[accepted.length][];
        {
            int i;
            i = 0;
            {
                certificate_authorities[i] = accepted[i].getIssuerX500Principal();
                encoded_principals[i] = certificate_authorities[i].getEncoded();
                totalPrincipalsLength += encoded_principals[i].length + 2;
            } //End block
        } //End collapsed parenthetic
        length = 3 + certificate_types.length + totalPrincipalsLength;
        // ---------- Original Method ----------
        //if (accepted == null) {
            //fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    //"CertificateRequest: array of certificate authority certificates is null");
        //}
        //this.certificate_types = certificate_types;
        //int totalPrincipalsLength = 0;
        //certificate_authorities = new X500Principal[accepted.length];
        //encoded_principals = new byte[accepted.length][];
        //for (int i = 0; i < accepted.length; i++) {
            //certificate_authorities[i] = accepted[i].getIssuerX500Principal();
            //encoded_principals[i] = certificate_authorities[i].getEncoded();
            //totalPrincipalsLength += encoded_principals[i].length + 2;
        //}
        //length = 3 + certificate_types.length + totalPrincipalsLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.555 -0400", hash_original_method = "D10E4DAB13CE1708B5021E84302588D4", hash_generated_method = "A033D58B648E919C4D349B9CD2C2E338")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateRequest(HandshakeIODataStream in, int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(in.dsTaint);
        int size;
        size = in.readUint8();
        certificate_types = new byte[size];
        Streams.readFully(in, certificate_types);
        size = in.readUint16();
        int totalPrincipalsLength;
        totalPrincipalsLength = 0;
        int principalLength;
        principalLength = 0;
        ArrayList<X500Principal> principals;
        principals = new ArrayList<X500Principal>();
        {
            principalLength = in.readUint16();
            principals.add(new X500Principal(in));
            totalPrincipalsLength += 2;
            totalPrincipalsLength += principalLength;
        } //End block
        certificate_authorities = principals.toArray(new X500Principal[principals.size()]);
        this.length = 3 + certificate_types.length + totalPrincipalsLength;
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect CertificateRequest");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.556 -0400", hash_original_method = "B75D6FC2C98C385FE0F3914F9044B1F0", hash_generated_method = "3B0236484B1F935C7197A7FC0C61C1AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void send(HandshakeIODataStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.writeUint8(certificate_types.length);
        {
            int i;
            i = 0;
            {
                out.write(certificate_types[i]);
            } //End block
        } //End collapsed parenthetic
        int authoritiesLength;
        authoritiesLength = 0;
        {
            int i;
            i = 0;
            {
                authoritiesLength += encoded_principals[i].length +2;
            } //End block
        } //End collapsed parenthetic
        out.writeUint16(authoritiesLength);
        {
            int i;
            i = 0;
            {
                out.writeUint16(encoded_principals[i].length);
                out.write(encoded_principals[i]);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //out.writeUint8(certificate_types.length);
        //for (int i = 0; i < certificate_types.length; i++) {
            //out.write(certificate_types[i]);
        //}
        //int authoritiesLength = 0;
        //for (int i = 0; i < certificate_authorities.length; i++) {
            //authoritiesLength += encoded_principals[i].length +2;
        //}
        //out.writeUint16(authoritiesLength);
        //for (int i = 0; i < certificate_authorities.length; i++) {
            //out.writeUint16(encoded_principals[i].length);
            //out.write(encoded_principals[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.556 -0400", hash_original_method = "B8B86D3685160AFFAE5E6FB9770B1A60", hash_generated_method = "06C810E16D56FB658E0C6B9BCCB87E81")
    @DSModeled(DSC.SAFE)
    @Override
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Handshake.CERTIFICATE_REQUEST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.556 -0400", hash_original_method = "9259963BD630FBE5E6BDCDC2C1D8D491", hash_generated_method = "A000E00EAA70FBFF3686701EC3DBBA29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getTypesAsString() {
        {
            types = new String[certificate_types.length];
            {
                int i;
                i = 0;
                {
                    String type;
                    type = CipherSuite.getClientKeyType(certificate_types[i]);
                    {
                        fatalAlert(AlertProtocol.DECODE_ERROR,
                            "DECODE ERROR: incorrect CertificateRequest");
                    } //End block
                    types[i] = type;
                } //End block
            } //End collapsed parenthetic
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //if (types == null) {
            //types = new String[certificate_types.length];
            //for (int i = 0; i < types.length; i++) {
                //String type = CipherSuite.getClientKeyType(certificate_types[i]);
                //if (type == null) {
                    //fatalAlert(AlertProtocol.DECODE_ERROR,
                            //"DECODE ERROR: incorrect CertificateRequest");
                //}
                //types[i] = type;
            //}
        //}
        //return types;
    }

    
}

