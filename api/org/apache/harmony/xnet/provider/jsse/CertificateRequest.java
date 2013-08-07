package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.security.auth.x500.X500Principal;

import libcore.io.Streams;





public class CertificateRequest extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.995 -0400", hash_original_field = "47617F57A86FC255D167A5F32EFFC3AA", hash_generated_field = "052660BD096960D182ED14500388945C")

    byte[] certificate_types;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.995 -0400", hash_original_field = "5AD3D6B54128C59A99FF8D5F12375A4F", hash_generated_field = "F3AC0C1FF54FCE6FAA264A8694502CB6")

    X500Principal[] certificate_authorities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.995 -0400", hash_original_field = "D14A8022B085F9EF19D479CBDD581127", hash_generated_field = "57B17EE84C64E0E68D855EB8B1E7E056")

    private String[] types;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.995 -0400", hash_original_field = "EE768EC4320CD6EEEBB223A7802A86E6", hash_generated_field = "B2462DD7293A0BAC46631DF777D44309")

    private byte[][] encoded_principals;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.996 -0400", hash_original_method = "CB3C7AA59A60FE20BA988C0CAC39DBAA", hash_generated_method = "CD1CBFCEA640E9282495A7EF0CE397D2")
    public  CertificateRequest(byte[] certificate_types,
                              X509Certificate[] accepted) {
        if(accepted == null)        
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    "CertificateRequest: array of certificate authority certificates is null");
        } //End block
        this.certificate_types = certificate_types;
        int totalPrincipalsLength = 0;
        certificate_authorities = new X500Principal[accepted.length];
        encoded_principals = new byte[accepted.length][];
for(int i = 0;i < accepted.length;i++)
        {
            certificate_authorities[i] = accepted[i].getIssuerX500Principal();
            encoded_principals[i] = certificate_authorities[i].getEncoded();
            totalPrincipalsLength += encoded_principals[i].length + 2;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.998 -0400", hash_original_method = "D10E4DAB13CE1708B5021E84302588D4", hash_generated_method = "7EB0F58B7E9A9640D6ADA6B783F73FF2")
    public  CertificateRequest(HandshakeIODataStream in, int length) throws IOException {
        addTaint(length);
        addTaint(in.getTaint());
        int size = in.readUint8();
        certificate_types = new byte[size];
        Streams.readFully(in, certificate_types);
        size = in.readUint16();
        int totalPrincipalsLength = 0;
        int principalLength = 0;
        ArrayList<X500Principal> principals = new ArrayList<X500Principal>();
        while
(totalPrincipalsLength < size)        
        {
            principalLength = in.readUint16();
            principals.add(new X500Principal(in));
            totalPrincipalsLength += 2;
            totalPrincipalsLength += principalLength;
        } //End block
        certificate_authorities = principals.toArray(new X500Principal[principals.size()]);
        this.length = 3 + certificate_types.length + totalPrincipalsLength;
        if(this.length != length)        
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect CertificateRequest");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.999 -0400", hash_original_method = "B75D6FC2C98C385FE0F3914F9044B1F0", hash_generated_method = "D9B0E49081A3BE31065801DEB7A1559F")
    @Override
    public void send(HandshakeIODataStream out) {
        addTaint(out.getTaint());
        out.writeUint8(certificate_types.length);
for(int i = 0;i < certificate_types.length;i++)
        {
            out.write(certificate_types[i]);
        } //End block
        int authoritiesLength = 0;
for(int i = 0;i < certificate_authorities.length;i++)
        {
            authoritiesLength += encoded_principals[i].length +2;
        } //End block
        out.writeUint16(authoritiesLength);
for(int i = 0;i < certificate_authorities.length;i++)
        {
            out.writeUint16(encoded_principals[i].length);
            out.write(encoded_principals[i]);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.999 -0400", hash_original_method = "B8B86D3685160AFFAE5E6FB9770B1A60", hash_generated_method = "F338158252D872698C0B6E5A84FBBCC7")
    @Override
    public int getType() {
        int var48CC83B2C5275A6D72C60DF405E239BC_620692541 = (Handshake.CERTIFICATE_REQUEST);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672358770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672358770;
        // ---------- Original Method ----------
        //return Handshake.CERTIFICATE_REQUEST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.000 -0400", hash_original_method = "9259963BD630FBE5E6BDCDC2C1D8D491", hash_generated_method = "88668BD2221A25254F6B800119E697B8")
    public String[] getTypesAsString() {
        if(types == null)        
        {
            types = new String[certificate_types.length];
for(int i = 0;i < types.length;i++)
            {
                String type = CipherSuite.getClientKeyType(certificate_types[i]);
                if(type == null)                
                {
                    fatalAlert(AlertProtocol.DECODE_ERROR,
                            "DECODE ERROR: incorrect CertificateRequest");
                } //End block
                types[i] = type;
            } //End block
        } //End block
String[] var3594B614C10CC2B651EA0D169ACAF4A6_2110820467 =         types;
        var3594B614C10CC2B651EA0D169ACAF4A6_2110820467.addTaint(taint);
        return var3594B614C10CC2B651EA0D169ACAF4A6_2110820467;
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

