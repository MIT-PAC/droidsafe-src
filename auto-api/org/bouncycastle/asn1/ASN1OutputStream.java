package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class ASN1OutputStream extends DEROutputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.611 -0400", hash_original_method = "B585D0D3F95079429B677B297C18775F", hash_generated_method = "00A0261A7777AD39511D06B15A8D0B1C")
    public  ASN1OutputStream(
        OutputStream    os) {
        super(os);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.612 -0400", hash_original_method = "7E9399FEF1C678E926DDEA0139F7BC7D", hash_generated_method = "716FAB82EB097A01E1ECF640D58D876E")
    public void writeObject(
        Object    obj) throws IOException {
        {
            writeNull();
        } //End block
        {
            ((DERObject)obj).encode(this);
        } //End block
        {
            ((DEREncodable)obj).getDERObject().encode(this);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("object not ASN1Encodable");
        } //End block
        addTaint(obj.getTaint());
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

