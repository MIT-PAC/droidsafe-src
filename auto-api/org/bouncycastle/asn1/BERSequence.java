package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Enumeration;

public class BERSequence extends DERSequence {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.141 -0400", hash_original_method = "0D9B441EA6B4B8E8347B85C87EDD1299", hash_generated_method = "38F8802BC4E63A6F40E9106AA50F9EE8")
    public  BERSequence() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.141 -0400", hash_original_method = "F58B9D9CAFA6022E13B23B504AFBA49E", hash_generated_method = "803A1FB234C8055199B4B5FAA7E4F404")
    public  BERSequence(
        DEREncodable    obj) {
        super(obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.142 -0400", hash_original_method = "77CDCB3AD1301C069F2E513DC8F21CC0", hash_generated_method = "A03269D753C89CA227C1BD314125E29E")
    public  BERSequence(
        ASN1EncodableVector   v) {
        super(v);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.142 -0400", hash_original_method = "02357BA9FDB8523F9B8A86E245A5D94B", hash_generated_method = "95385E2D88CD195F4DA12A218E23BBF8")
     void encode(
        DEROutputStream out) throws IOException {
        {
            out.write(SEQUENCE | CONSTRUCTED);
            out.write(0x80);
            Enumeration e = getObjects();
            {
                boolean varE6301E07393E7C92A45A62612E875EEF_1022627225 = (e.hasMoreElements());
                {
                    out.writeObject(e.nextElement());
                } //End block
            } //End collapsed parenthetic
            out.write(0x00);
            out.write(0x00);
        } //End block
        {
            super.encode(out);
        } //End block
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //if (out instanceof ASN1OutputStream || out instanceof BEROutputStream)
        //{
            //out.write(SEQUENCE | CONSTRUCTED);
            //out.write(0x80);
            //Enumeration e = getObjects();
            //while (e.hasMoreElements())
            //{
                //out.writeObject(e.nextElement());
            //}
            //out.write(0x00);
            //out.write(0x00);
        //}
        //else
        //{
            //super.encode(out);
        //}
    }

    
}

