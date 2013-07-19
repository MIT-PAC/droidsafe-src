package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;
import java.io.OutputStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ASN1OutputStream extends DEROutputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.742 -0400", hash_original_method = "B585D0D3F95079429B677B297C18775F", hash_generated_method = "00A0261A7777AD39511D06B15A8D0B1C")
    public  ASN1OutputStream(
        OutputStream    os) {
        super(os);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.743 -0400", hash_original_method = "7E9399FEF1C678E926DDEA0139F7BC7D", hash_generated_method = "AC1E5C048E11C5E92B989F21AB1C7E49")
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
            IOException var4B2854F72E86283DC406E84332783267_822908526 = new IOException("object not ASN1Encodable");
            var4B2854F72E86283DC406E84332783267_822908526.addTaint(taint);
            throw var4B2854F72E86283DC406E84332783267_822908526;
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
            //throw new IOException("object not ASN1Encodable");
        //}
    }

    
}

