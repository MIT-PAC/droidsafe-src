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

public class DERSet extends ASN1Set {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.691 -0400", hash_original_method = "80B25DE2FCBFBCCF6E0A2A88A3316812", hash_generated_method = "E2F348A362CEF042606CF762BF3B5EB7")
    public  DERSet() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.691 -0400", hash_original_method = "80662AFE581998795E7545830F255DD3", hash_generated_method = "79746DB51BB0B91D61A6C1017F6FD9E3")
    public  DERSet(
        DEREncodable   obj) {
        this.addObject(obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //this.addObject(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.692 -0400", hash_original_method = "A9BFF2B058FC769C1F8C48EB1BA33880", hash_generated_method = "D4AE1ADA836B997AEC7153AB13E423E0")
    public  DERSet(
        ASN1EncodableVector   v) {
        this(v, true);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.692 -0400", hash_original_method = "DFBC1065284BB1C2F3C0505C2EF2AEEC", hash_generated_method = "1EDF2CEB32F2FAA331EE313E2622F9E7")
    public  DERSet(
        ASN1Encodable[]   a) {
        {
            int i = 0;
            {
                this.addObject(a[i]);
            } //End block
        } //End collapsed parenthetic
        this.sort();
        addTaint(a[0].getTaint());
        // ---------- Original Method ----------
        //for (int i = 0; i != a.length; i++)
        //{
            //this.addObject(a[i]);
        //}
        //this.sort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.692 -0400", hash_original_method = "90B6A9A913780E80B577423E4251EEF7", hash_generated_method = "3F7111540E4E9180828CE37D79B30EFC")
      DERSet(
        ASN1EncodableVector  v,
        boolean              needsSorting) {
        {
            int i = 0;
            boolean varC646FCC9A1C4B2837DAC7D6B1995FA10_859689900 = (i != v.size());
            {
                this.addObject(v.get(i));
            } //End block
        } //End collapsed parenthetic
        {
            this.sort();
        } //End block
        addTaint(v.getTaint());
        addTaint(needsSorting);
        // ---------- Original Method ----------
        //for (int i = 0; i != v.size(); i++)
        //{
            //this.addObject(v.get(i));
        //}
        //if (needsSorting)
        //{
            //this.sort();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.693 -0400", hash_original_method = "0C0574F6B6AA5F6F63D97835BA3FFE58", hash_generated_method = "25D28B64BBC122B2B4D3A0D7CE167AAF")
     void encode(
        DEROutputStream out) throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        DEROutputStream dOut = new DEROutputStream(bOut);
        Enumeration e = this.getObjects();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1440288914 = (e.hasMoreElements());
            {
                Object obj = e.nextElement();
                dOut.writeObject(obj);
            } //End block
        } //End collapsed parenthetic
        dOut.close();
        byte[] bytes = bOut.toByteArray();
        out.writeEncoded(SET | CONSTRUCTED, bytes);
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
        //out.writeEncoded(SET | CONSTRUCTED, bytes);
    }

    
}

