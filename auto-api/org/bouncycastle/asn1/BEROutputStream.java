package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class BEROutputStream extends DEROutputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.131 -0400", hash_original_method = "39D0C914F21422AAB9B31B993D1339D0", hash_generated_method = "2E1AD530EE03F76D94D0C878B5450800")
    public  BEROutputStream(
        OutputStream    os) {
        super(os);
        addTaint(os.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.132 -0400", hash_original_method = "7A7F2C3481471D2C873255AD36ADBA85", hash_generated_method = "2084CFAA3755388DF569C3588D7B5E66")
    public void writeObject(
        Object    obj) throws IOException {
        {
            writeNull();
        } 
        {
            ((DERObject)obj).encode(this);
        } 
        {
            ((DEREncodable)obj).getDERObject().encode(this);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("object not BEREncodable");
        } 
        addTaint(obj.getTaint());
        
        
        
            
        
        
        
            
        
        
        
            
        
        
        
            
        
    }

    
}

