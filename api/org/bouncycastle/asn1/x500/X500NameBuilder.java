package org.bouncycastle.asn1.x500;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public class X500NameBuilder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.744 -0400", hash_original_field = "66F6181BCB4CFF4CD38FBC804A036DB6", hash_generated_field = "C522E2D6076698825F4E82735A8D3025")

    private X500NameStyle template;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.744 -0400", hash_original_field = "E72CD27D6F5E6EA66835054F74B68BD5", hash_generated_field = "675045CFA58337E15285151041709C32")

    private Vector rdns = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.745 -0400", hash_original_method = "D0728342E4979FB5B75C971FD31579AF", hash_generated_method = "C5F092BBA326550A9DB00A2B96B75883")
    public  X500NameBuilder(X500NameStyle template) {
        this.template = template;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.745 -0400", hash_original_method = "B523CEAB6DE32883E9365149ACA12057", hash_generated_method = "F17AF5BBB36B0858C9EC789CF493FE54")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, String value) {
        addTaint(value.getTaint());
        addTaint(oid.getTaint());
        this.addRDN(oid, template.stringToValue(oid, value));
X500NameBuilder var72A74007B2BE62B849F475C7BDA4658B_128951762 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_128951762.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_128951762;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.745 -0400", hash_original_method = "8590615114869FAEC1B946165AEDD39D", hash_generated_method = "535F9A31AE7548C8B73E71C6742E9820")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, ASN1Encodable value) {
        addTaint(value.getTaint());
        addTaint(oid.getTaint());
        rdns.addElement(new RDN(oid, value));
X500NameBuilder var72A74007B2BE62B849F475C7BDA4658B_529135937 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_529135937.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_529135937;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.746 -0400", hash_original_method = "3E5E6DF77AF598ABE6D42C6639692F78", hash_generated_method = "375AFC401EFFC0E7322B3DE5B5C23616")
    public X500NameBuilder addRDN(AttributeTypeAndValue attrTAndV) {
        addTaint(attrTAndV.getTaint());
        rdns.addElement(new RDN(attrTAndV));
X500NameBuilder var72A74007B2BE62B849F475C7BDA4658B_1031688153 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1031688153.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1031688153;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.746 -0400", hash_original_method = "273A600B6E97E185C3AB8807EACFE39D", hash_generated_method = "7BE1D00183B696CA2D6474A65E5386F8")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, String[] values) {
        addTaint(values[0].getTaint());
        addTaint(oids[0].getTaint());
        ASN1Encodable[] vals = new ASN1Encodable[values.length];
for(int i = 0;i != vals.length;i++)
        {
            vals[i] = template.stringToValue(oids[i], values[i]);
        } 
X500NameBuilder varD7F2C29827E72CD1BB5CBC1E148ADA09_1508163441 =         addMultiValuedRDN(oids, vals);
        varD7F2C29827E72CD1BB5CBC1E148ADA09_1508163441.addTaint(taint);
        return varD7F2C29827E72CD1BB5CBC1E148ADA09_1508163441;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.747 -0400", hash_original_method = "19CADD9F3E05278519C8972C40F988FF", hash_generated_method = "32D48F0AE6D2A0A57C7760B363D7210B")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, ASN1Encodable[] values) {
        addTaint(values[0].getTaint());
        addTaint(oids[0].getTaint());
        AttributeTypeAndValue[] avs = new AttributeTypeAndValue[oids.length];
for(int i = 0;i != oids.length;i++)
        {
            avs[i] = new AttributeTypeAndValue(oids[i], values[i]);
        } 
X500NameBuilder var9D2F985167BE7E1703BB252DA3E09BD5_640486827 =         addMultiValuedRDN(avs);
        var9D2F985167BE7E1703BB252DA3E09BD5_640486827.addTaint(taint);
        return var9D2F985167BE7E1703BB252DA3E09BD5_640486827;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.747 -0400", hash_original_method = "3AFEEFAA1A94C00426001446F3A2411A", hash_generated_method = "7D37C96148CC0EB63C7CCEF254CB23F8")
    public X500NameBuilder addMultiValuedRDN(AttributeTypeAndValue[] attrTAndVs) {
        addTaint(attrTAndVs[0].getTaint());
        rdns.addElement(new RDN(attrTAndVs));
X500NameBuilder var72A74007B2BE62B849F475C7BDA4658B_2082907630 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2082907630.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2082907630;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.748 -0400", hash_original_method = "6DE1D9D13ABB402C9E6AC772336CF9FE", hash_generated_method = "CF630A12A00A8B3AB478C867A5C3150F")
    public X500Name build() {
        RDN[] vals = new RDN[rdns.size()];
for(int i = 0;i != vals.length;i++)
        {
            vals[i] = (RDN)rdns.elementAt(i);
        } 
X500Name var25250835424566A0FA42053F485F38F1_704518468 =         new X500Name(template, vals);
        var25250835424566A0FA42053F485F38F1_704518468.addTaint(taint);
        return var25250835424566A0FA42053F485F38F1_704518468;
        
        
        
        
            
        
        
    }

    
}

