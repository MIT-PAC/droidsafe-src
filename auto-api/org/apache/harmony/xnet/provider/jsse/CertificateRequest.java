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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.512 -0400", hash_original_field = "47617F57A86FC255D167A5F32EFFC3AA", hash_generated_field = "052660BD096960D182ED14500388945C")

    byte[] certificate_types;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.512 -0400", hash_original_field = "5AD3D6B54128C59A99FF8D5F12375A4F", hash_generated_field = "F3AC0C1FF54FCE6FAA264A8694502CB6")

    X500Principal[] certificate_authorities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.512 -0400", hash_original_field = "D14A8022B085F9EF19D479CBDD581127", hash_generated_field = "57B17EE84C64E0E68D855EB8B1E7E056")

    private String[] types;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.512 -0400", hash_original_field = "EE768EC4320CD6EEEBB223A7802A86E6", hash_generated_field = "B2462DD7293A0BAC46631DF777D44309")

    private byte[][] encoded_principals;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.513 -0400", hash_original_method = "CB3C7AA59A60FE20BA988C0CAC39DBAA", hash_generated_method = "599881C223FBFE886D056798216AE41D")
    public  CertificateRequest(byte[] certificate_types,
                              X509Certificate[] accepted) {
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    "CertificateRequest: array of certificate authority certificates is null");
        } //End block
        this.certificate_types = certificate_types;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.514 -0400", hash_original_method = "D10E4DAB13CE1708B5021E84302588D4", hash_generated_method = "5061075ABBC3140A6FF3666CF06C906E")
    public  CertificateRequest(HandshakeIODataStream in, int length) throws IOException {
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
        addTaint(in.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.516 -0400", hash_original_method = "B75D6FC2C98C385FE0F3914F9044B1F0", hash_generated_method = "C39069470324B83626C2187F626417DC")
    @Override
    public void send(HandshakeIODataStream out) {
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
        addTaint(out.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.528 -0400", hash_original_method = "B8B86D3685160AFFAE5E6FB9770B1A60", hash_generated_method = "86F83BD5D67C8C44D8A098B23F883253")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357512733 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357512733;
        // ---------- Original Method ----------
        //return Handshake.CERTIFICATE_REQUEST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.529 -0400", hash_original_method = "9259963BD630FBE5E6BDCDC2C1D8D491", hash_generated_method = "A4E03C5957202D4CC7AB8704276336D9")
    public String[] getTypesAsString() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_752690185 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_752690185 = types;
        varB4EAC82CA7396A68D541C85D26508E83_752690185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_752690185;
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

