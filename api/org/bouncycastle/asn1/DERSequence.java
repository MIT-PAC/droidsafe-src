package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;

public class DERSequence extends ASN1Sequence {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.177 -0400", hash_original_method = "B1D7F8D200E7560B8E505C8DEB6A735D", hash_generated_method = "DE383D98243C35C2EE2100E102854830")
    public  DERSequence() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.178 -0400", hash_original_method = "02EB65A37D4D288F16E2D066B80A09B0", hash_generated_method = "73DBB9CE6A7AE6E78AE85BEB85DE358B")
    public  DERSequence(
        DEREncodable    obj) {
        addTaint(obj.getTaint());
        this.addObject(obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.178 -0400", hash_original_method = "74532D23F47B58A7B943BD7A29A6F5A5", hash_generated_method = "C6325B232843E170FD5D9D0524113B84")
    public  DERSequence(
        ASN1EncodableVector   v) {
        addTaint(v.getTaint());
for(int i = 0;i != v.size();i++)
        {
            this.addObject(v.get(i));
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.178 -0400", hash_original_method = "6C44128901F5187598F8352DD3C74981", hash_generated_method = "7DA2B3217D3A5F071D14C57F6BFE268F")
    public  DERSequence(
        ASN1Encodable[]   a) {
        addTaint(a[0].getTaint());
for(int i = 0;i != a.length;i++)
        {
            this.addObject(a[i]);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.179 -0400", hash_original_method = "EB6AC1866581E5FE18FBF3DDAE772D4D", hash_generated_method = "F795A4A35B62312F1F15DA1D8E8B6F4F")
     void encode(
        DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        DEROutputStream dOut = new DEROutputStream(bOut);
        Enumeration e = this.getObjects();
        while
(e.hasMoreElements())        
        {
            Object obj = e.nextElement();
            dOut.writeObject(obj);
        } 
        dOut.close();
        byte[] bytes = bOut.toByteArray();
        out.writeEncoded(SEQUENCE | CONSTRUCTED, bytes);
        
        
        
        
        
        
            
            
        
        
        
        
    }

    
}

