package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class CertificateVerify extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.695 -0400", hash_original_field = "85F856059502E932D8205DEEF6195328", hash_generated_field = "01A16F1FF859CB019178D18F23D7E606")

    byte[] signedHash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.695 -0400", hash_original_method = "F3A93A83C93F754D4846FCC8297217FD", hash_generated_method = "F255FE883E27342B88010D13EC49A529")
    public  CertificateVerify(byte[] hash) {
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    "INTERNAL ERROR: incorrect certificate verify hash");
        } 
        this.signedHash = hash;
        length = hash.length + 2;
        
        
            
                    
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.695 -0400", hash_original_method = "C08A411708B1C45834DF498B4B831402", hash_generated_method = "5F1B02D0F4842152CB7D9377028A190B")
    public  CertificateVerify(HandshakeIODataStream in, int length) throws IOException {
        {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect CertificateVerify");
        } 
        {
            {
                boolean varE515780712A2A8C4B350FB23E27F935E_1826976075 = (in.readUint16() != length - 2);
                {
                    fatalAlert(AlertProtocol.DECODE_ERROR,
                        "DECODE ERROR: incorrect CertificateVerify");
                } 
            } 
            signedHash = in.read(length -2);
        } 
        this.length = length;
        
        
            
                    
        
            
                
                        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.696 -0400", hash_original_method = "8645B529D351D3837595463E8D8CA061", hash_generated_method = "F70AA12CE7564D027A14B98C1CEF61DA")
    @Override
    public void send(HandshakeIODataStream out) {
        {
            out.writeUint16(signedHash.length);
            out.write(signedHash);
        } 
        addTaint(out.getTaint());
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.696 -0400", hash_original_method = "78FC60AEF6831C8195D1932C8B8AE728", hash_generated_method = "FD0663B4D7B558BCEEA4EC82F246A4B2")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462321142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462321142;
        
        
    }

    
}

