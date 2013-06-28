package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;

public class DERSequence extends ASN1Sequence {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.673 -0400", hash_original_method = "B1D7F8D200E7560B8E505C8DEB6A735D", hash_generated_method = "DE383D98243C35C2EE2100E102854830")
    public  DERSequence() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.673 -0400", hash_original_method = "02EB65A37D4D288F16E2D066B80A09B0", hash_generated_method = "A05C7F32DE62BCC665A98FE5BB3E6856")
    public  DERSequence(
        DEREncodable    obj) {
        this.addObject(obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //this.addObject(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.674 -0400", hash_original_method = "74532D23F47B58A7B943BD7A29A6F5A5", hash_generated_method = "FD1D7DC6BC16E8751AAD0F7059A03CDE")
    public  DERSequence(
        ASN1EncodableVector   v) {
        {
            int i = 0;
            boolean varC646FCC9A1C4B2837DAC7D6B1995FA10_1218786749 = (i != v.size());
            {
                this.addObject(v.get(i));
            } //End block
        } //End collapsed parenthetic
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //for (int i = 0; i != v.size(); i++)
        //{
            //this.addObject(v.get(i));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.674 -0400", hash_original_method = "6C44128901F5187598F8352DD3C74981", hash_generated_method = "61F0AEC92F827327706314F6AA447047")
    public  DERSequence(
        ASN1Encodable[]   a) {
        {
            int i = 0;
            {
                this.addObject(a[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(a[0].getTaint());
        // ---------- Original Method ----------
        //for (int i = 0; i != a.length; i++)
        //{
            //this.addObject(a[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.675 -0400", hash_original_method = "EB6AC1866581E5FE18FBF3DDAE772D4D", hash_generated_method = "63B5A38A671EADDF7232F516F599D4B9")
     void encode(
        DEROutputStream out) throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        DEROutputStream dOut = new DEROutputStream(bOut);
        Enumeration e = this.getObjects();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_393508948 = (e.hasMoreElements());
            {
                Object obj = e.nextElement();
                dOut.writeObject(obj);
            } //End block
        } //End collapsed parenthetic
        dOut.close();
        byte[] bytes = bOut.toByteArray();
        out.writeEncoded(SEQUENCE | CONSTRUCTED, bytes);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
        //DEROutputStream         dOut = new DEROutputStream(bOut);
        //Enumeration             e = this.getObjects();
        //while (e.hasMoreElements())
        //{
            //Object    obj = e.nextElement();
            //dOut.writeObject(obj);
        //}
        //dOut.close();
        //byte[]  bytes = bOut.toByteArray();
        //out.writeEncoded(SEQUENCE | CONSTRUCTED, bytes);
    }

    
}

