package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Enumeration;

public class BERSet extends DERSet {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.908 -0400", hash_original_method = "3B0CACFC7D97D5B3260958CA327C2CC2", hash_generated_method = "F2D7951BF96B2D911C0F933229D9518A")
    public  BERSet() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.917 -0400", hash_original_method = "58A8309A1516CB825A1DBAF515FA0A22", hash_generated_method = "1CCB56D2DD10F9EC3289A5C5F3AAB4A4")
    public  BERSet(
        DEREncodable    obj) {
        super(obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.918 -0400", hash_original_method = "863ECA664105F25F4F85CEE28355E9A1", hash_generated_method = "8B5CBD105D93B7CFE9D6196BB30EF466")
    public  BERSet(
        ASN1EncodableVector   v) {
        super(v, false);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.918 -0400", hash_original_method = "EA203440C88579BB4F9E161A0FFE3946", hash_generated_method = "F2E6BCA4D6706B4F0CCC1717683CE026")
      BERSet(
        ASN1EncodableVector  v,
        boolean              needsSorting) {
        super(v, needsSorting);
        addTaint(v.getTaint());
        addTaint(needsSorting);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.918 -0400", hash_original_method = "F901566FF0371DE323597B13C49C1024", hash_generated_method = "E3CE0BBC18BB7D3E3169C5A5A9229916")
     void encode(
        DEROutputStream out) throws IOException {
        {
            out.write(SET | CONSTRUCTED);
            out.write(0x80);
            Enumeration e;
            e = getObjects();
            {
                boolean varE6301E07393E7C92A45A62612E875EEF_942667947 = (e.hasMoreElements());
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
            //out.write(SET | CONSTRUCTED);
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

