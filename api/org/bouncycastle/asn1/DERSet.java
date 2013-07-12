package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;

public class DERSet extends ASN1Set {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.187 -0400", hash_original_method = "80B25DE2FCBFBCCF6E0A2A88A3316812", hash_generated_method = "E2F348A362CEF042606CF762BF3B5EB7")
    public  DERSet() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.187 -0400", hash_original_method = "80662AFE581998795E7545830F255DD3", hash_generated_method = "1AF6D4C764D9D30686464052997CC1BD")
    public  DERSet(
        DEREncodable   obj) {
        addTaint(obj.getTaint());
        this.addObject(obj);
        // ---------- Original Method ----------
        //this.addObject(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.187 -0400", hash_original_method = "A9BFF2B058FC769C1F8C48EB1BA33880", hash_generated_method = "D4AE1ADA836B997AEC7153AB13E423E0")
    public  DERSet(
        ASN1EncodableVector   v) {
        this(v, true);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.188 -0400", hash_original_method = "DFBC1065284BB1C2F3C0505C2EF2AEEC", hash_generated_method = "38CD7E0272B0BA2FF8EC000C6FE99F1B")
    public  DERSet(
        ASN1Encodable[]   a) {
        addTaint(a[0].getTaint());
for(int i = 0;i != a.length;i++)
        {
            this.addObject(a[i]);
        } //End block
        this.sort();
        // ---------- Original Method ----------
        //for (int i = 0; i != a.length; i++)
        //{
            //this.addObject(a[i]);
        //}
        //this.sort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.188 -0400", hash_original_method = "90B6A9A913780E80B577423E4251EEF7", hash_generated_method = "0320FB5F86DB4E0FC5C9616BE7D79277")
      DERSet(
        ASN1EncodableVector  v,
        boolean              needsSorting) {
        addTaint(needsSorting);
        addTaint(v.getTaint());
for(int i = 0;i != v.size();i++)
        {
            this.addObject(v.get(i));
        } //End block
    if(needsSorting)        
        {
            this.sort();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.188 -0400", hash_original_method = "0C0574F6B6AA5F6F63D97835BA3FFE58", hash_generated_method = "ACCF67678B0977E96B7C0E12CF3AFBB4")
     void encode(
        DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        DEROutputStream dOut = new DEROutputStream(bOut);
        Enumeration e = this.getObjects();
        while
(e.hasMoreElements())        
        {
            Object obj = e.nextElement();
            dOut.writeObject(obj);
        } //End block
        dOut.close();
        byte[] bytes = bOut.toByteArray();
        out.writeEncoded(SET | CONSTRUCTED, bytes);
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

