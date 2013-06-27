package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class BEROutputStream extends DEROutputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.887 -0400", hash_original_method = "39D0C914F21422AAB9B31B993D1339D0", hash_generated_method = "2E1AD530EE03F76D94D0C878B5450800")
    public  BEROutputStream(
        OutputStream    os) {
        super(os);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.887 -0400", hash_original_method = "7A7F2C3481471D2C873255AD36ADBA85", hash_generated_method = "2084CFAA3755388DF569C3588D7B5E66")
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
            if (DroidSafeAndroidRuntime.control) throw new IOException("object not BEREncodable");
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
            //throw new IOException("object not BEREncodable");
        //}
    }

    
}

