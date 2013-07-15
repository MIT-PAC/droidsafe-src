package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import libcore.io.Streams;

public class CertificateRequest extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.685 -0400", hash_original_field = "47617F57A86FC255D167A5F32EFFC3AA", hash_generated_field = "052660BD096960D182ED14500388945C")

    byte[] certificate_types;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.685 -0400", hash_original_field = "5AD3D6B54128C59A99FF8D5F12375A4F", hash_generated_field = "F3AC0C1FF54FCE6FAA264A8694502CB6")

    X500Principal[] certificate_authorities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.685 -0400", hash_original_field = "D14A8022B085F9EF19D479CBDD581127", hash_generated_field = "57B17EE84C64E0E68D855EB8B1E7E056")

    private String[] types;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.685 -0400", hash_original_field = "EE768EC4320CD6EEEBB223A7802A86E6", hash_generated_field = "B2462DD7293A0BAC46631DF777D44309")

    private byte[][] encoded_principals;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.686 -0400", hash_original_method = "CB3C7AA59A60FE20BA988C0CAC39DBAA", hash_generated_method = "410896C434A3B473102747D5326C28FF")
    public  CertificateRequest(byte[] certificate_types,
                              X509Certificate[] accepted) {
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    "CertificateRequest: array of certificate authority certificates is null");
        } 
        this.certificate_types = certificate_types;
        int totalPrincipalsLength = 0;
        certificate_authorities = new X500Principal[accepted.length];
        encoded_principals = new byte[accepted.length][];
        {
            int i = 0;
            {
                certificate_authorities[i] = accepted[i].getIssuerX500Principal();
                encoded_principals[i] = certificate_authorities[i].getEncoded();
                totalPrincipalsLength += encoded_principals[i].length + 2;
            } 
        } 
        length = 3 + certificate_types.length + totalPrincipalsLength;
        
        
            
                    
        
        
        
        
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.687 -0400", hash_original_method = "D10E4DAB13CE1708B5021E84302588D4", hash_generated_method = "BCFA5994C03DC39A23B688B00181F6D3")
    public  CertificateRequest(HandshakeIODataStream in, int length) throws IOException {
        int size = in.readUint8();
        certificate_types = new byte[size];
        Streams.readFully(in, certificate_types);
        size = in.readUint16();
        int totalPrincipalsLength = 0;
        int principalLength = 0;
        ArrayList<X500Principal> principals = new ArrayList<X500Principal>();
        {
            principalLength = in.readUint16();
            principals.add(new X500Principal(in));
            totalPrincipalsLength += 2;
            totalPrincipalsLength += principalLength;
        } 
        certificate_authorities = principals.toArray(new X500Principal[principals.size()]);
        this.length = 3 + certificate_types.length + totalPrincipalsLength;
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect CertificateRequest");
        } 
        addTaint(in.getTaint());
        addTaint(length);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.687 -0400", hash_original_method = "B75D6FC2C98C385FE0F3914F9044B1F0", hash_generated_method = "BEEC4C05D20B7D4C18D0F0662BFF6347")
    @Override
    public void send(HandshakeIODataStream out) {
        out.writeUint8(certificate_types.length);
        {
            int i = 0;
            {
                out.write(certificate_types[i]);
            } 
        } 
        int authoritiesLength = 0;
        {
            int i = 0;
            {
                authoritiesLength += encoded_principals[i].length +2;
            } 
        } 
        out.writeUint16(authoritiesLength);
        {
            int i = 0;
            {
                out.writeUint16(encoded_principals[i].length);
                out.write(encoded_principals[i]);
            } 
        } 
        addTaint(out.getTaint());
        
        
        
            
        
        
        
            
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.688 -0400", hash_original_method = "B8B86D3685160AFFAE5E6FB9770B1A60", hash_generated_method = "441A33537A00212AF1F25A5A668C155F")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82311652 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82311652;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.689 -0400", hash_original_method = "9259963BD630FBE5E6BDCDC2C1D8D491", hash_generated_method = "C0CB551440C153BC5B0D9FDF6B5FED8A")
    public String[] getTypesAsString() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_11877252 = null; 
        {
            types = new String[certificate_types.length];
            {
                int i = 0;
                {
                    String type = CipherSuite.getClientKeyType(certificate_types[i]);
                    {
                        fatalAlert(AlertProtocol.DECODE_ERROR,
                            "DECODE ERROR: incorrect CertificateRequest");
                    } 
                    types[i] = type;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_11877252 = types;
        varB4EAC82CA7396A68D541C85D26508E83_11877252.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_11877252;
        
        
            
            
                
                
                    
                            
                
                
            
        
        
    }

    
}

