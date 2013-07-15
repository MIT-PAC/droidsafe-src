package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.OutputStream;

public class BEROutputStream extends DEROutputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.807 -0400", hash_original_method = "39D0C914F21422AAB9B31B993D1339D0", hash_generated_method = "2E1AD530EE03F76D94D0C878B5450800")
    public  BEROutputStream(
        OutputStream    os) {
        super(os);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.807 -0400", hash_original_method = "7A7F2C3481471D2C873255AD36ADBA85", hash_generated_method = "1BFC8F7E9DA3D6320948FE9DDF671BB7")
    public void writeObject(
        Object    obj) throws IOException {
        addTaint(obj.getTaint());
    if(obj == null)        
        {
            writeNull();
        } //End block
        else
    if(obj instanceof DERObject)        
        {
            ((DERObject)obj).encode(this);
        } //End block
        else
    if(obj instanceof DEREncodable)        
        {
            ((DEREncodable)obj).getDERObject().encode(this);
        } //End block
        else
        {
            IOException varEECF85CB178F2D875DD0D1D0D76A67FF_642829034 = new IOException("object not BEREncodable");
            varEECF85CB178F2D875DD0D1D0D76A67FF_642829034.addTaint(taint);
            throw varEECF85CB178F2D875DD0D1D0D76A67FF_642829034;
        } //End block
        // ---------- Original Method ----------
        //if (obj == null)
        //{
            //writeNull();
        //}
        //else if (obj instanceof DERObject)
        //{
            //((DERObject)obj).encode(this);
        //}
        //else if (obj instanceof DEREncodable)
        //{
            //((DEREncodable)obj).getDERObject().encode(this);
        //}
        //else
        //{
            //throw new IOException("object not BEREncodable");
        //}
    }

    
}

