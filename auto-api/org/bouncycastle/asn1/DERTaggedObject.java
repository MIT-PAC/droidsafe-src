package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class DERTaggedObject extends ASN1TaggedObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.727 -0400", hash_original_method = "B8C39F3F8493AE66929508E836F6CEF7", hash_generated_method = "230426B03BBA046B547576F29EBAA2AC")
    public  DERTaggedObject(
        int             tagNo,
        DEREncodable    obj) {
        super(tagNo, obj);
        addTaint(tagNo);
        addTaint(obj.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.728 -0400", hash_original_method = "D15475FEA6616F6A5D6AAE500D0E135A", hash_generated_method = "FDF0AF027625038EEC5DE043C7EA45A4")
    public  DERTaggedObject(
        boolean         explicit,
        int             tagNo,
        DEREncodable    obj) {
        super(explicit, tagNo, obj);
        addTaint(explicit);
        addTaint(tagNo);
        addTaint(obj.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.728 -0400", hash_original_method = "14B57626E7341DE57616D6DE76633AEC", hash_generated_method = "047746C21F73F9D85EBAAF772E64E012")
    public  DERTaggedObject(
        int             tagNo) {
        super(false, tagNo, new DERSequence());
        addTaint(tagNo);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.729 -0400", hash_original_method = "B5277AF27C85DE4A4669302802507303", hash_generated_method = "B741812F56EC7F207E86496A35AB4BDB")
     void encode(
        DEROutputStream  out) throws IOException {
        {
            byte[] bytes = obj.getDERObject().getEncoded(DER);
            {
                out.writeEncoded(CONSTRUCTED | TAGGED, tagNo, bytes);
            } 
            {
                int flags;
                {
                    flags = CONSTRUCTED | TAGGED;
                } 
                {
                    flags = TAGGED;
                } 
                out.writeTag(flags, tagNo);
                out.write(bytes, 1, bytes.length - 1);
            } 
        } 
        {
            out.writeEncoded(CONSTRUCTED | TAGGED, tagNo, ZERO_BYTES);
        } 
        addTaint(out.getTaint());
        
        
        
            
            
            
                
            
            
            
                
                
                
                    
                
                
                
                    
                
                
                
            
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.730 -0400", hash_original_field = "D91077190958F29EB6E06E2F51FAE62D", hash_generated_field = "DC855D7D38FB2BD504042CC7CEABD828")

    private static final byte[] ZERO_BYTES = new byte[0];
}

