package org.bouncycastle.asn1.x500;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public class X500NameBuilder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.472 -0400", hash_original_field = "66F6181BCB4CFF4CD38FBC804A036DB6", hash_generated_field = "C522E2D6076698825F4E82735A8D3025")

    private X500NameStyle template;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.472 -0400", hash_original_field = "E72CD27D6F5E6EA66835054F74B68BD5", hash_generated_field = "675045CFA58337E15285151041709C32")

    private Vector rdns = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.472 -0400", hash_original_method = "D0728342E4979FB5B75C971FD31579AF", hash_generated_method = "C5F092BBA326550A9DB00A2B96B75883")
    public  X500NameBuilder(X500NameStyle template) {
        this.template = template;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.473 -0400", hash_original_method = "B523CEAB6DE32883E9365149ACA12057", hash_generated_method = "FEFBF00B7B13A5E8CCDB71EF278EB994")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, String value) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_1882122043 = null; 
        this.addRDN(oid, template.stringToValue(oid, value));
        varB4EAC82CA7396A68D541C85D26508E83_1882122043 = this;
        addTaint(oid.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1882122043.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1882122043;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.474 -0400", hash_original_method = "8590615114869FAEC1B946165AEDD39D", hash_generated_method = "EA17DEEB816F87400E4A5C1FD3C65B1A")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, ASN1Encodable value) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_1412792157 = null; 
        rdns.addElement(new RDN(oid, value));
        varB4EAC82CA7396A68D541C85D26508E83_1412792157 = this;
        addTaint(oid.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1412792157.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1412792157;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.474 -0400", hash_original_method = "3E5E6DF77AF598ABE6D42C6639692F78", hash_generated_method = "20ED8FE0396FDA34C555A82702988DDF")
    public X500NameBuilder addRDN(AttributeTypeAndValue attrTAndV) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_254972966 = null; 
        rdns.addElement(new RDN(attrTAndV));
        varB4EAC82CA7396A68D541C85D26508E83_254972966 = this;
        addTaint(attrTAndV.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_254972966.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_254972966;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.476 -0400", hash_original_method = "273A600B6E97E185C3AB8807EACFE39D", hash_generated_method = "AC9C2F158B8682141206E5F20C21C1E4")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, String[] values) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_1204204876 = null; 
        ASN1Encodable[] vals = new ASN1Encodable[values.length];
        {
            int i = 0;
            {
                vals[i] = template.stringToValue(oids[i], values[i]);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1204204876 = addMultiValuedRDN(oids, vals);
        addTaint(oids[0].getTaint());
        addTaint(values[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1204204876.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1204204876;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.477 -0400", hash_original_method = "19CADD9F3E05278519C8972C40F988FF", hash_generated_method = "3DC9081DFA22D88700B63371D1748624")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, ASN1Encodable[] values) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_580863594 = null; 
        AttributeTypeAndValue[] avs = new AttributeTypeAndValue[oids.length];
        {
            int i = 0;
            {
                avs[i] = new AttributeTypeAndValue(oids[i], values[i]);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_580863594 = addMultiValuedRDN(avs);
        addTaint(oids[0].getTaint());
        addTaint(values[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_580863594.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_580863594;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.478 -0400", hash_original_method = "3AFEEFAA1A94C00426001446F3A2411A", hash_generated_method = "5E624A2347ACD13AAF1D376279126455")
    public X500NameBuilder addMultiValuedRDN(AttributeTypeAndValue[] attrTAndVs) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_1767579392 = null; 
        rdns.addElement(new RDN(attrTAndVs));
        varB4EAC82CA7396A68D541C85D26508E83_1767579392 = this;
        addTaint(attrTAndVs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1767579392.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1767579392;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.478 -0400", hash_original_method = "6DE1D9D13ABB402C9E6AC772336CF9FE", hash_generated_method = "8E60DD0E0C325910D6B74EFE51633993")
    public X500Name build() {
        X500Name varB4EAC82CA7396A68D541C85D26508E83_1752555101 = null; 
        RDN[] vals = new RDN[rdns.size()];
        {
            int i = 0;
            {
                vals[i] = (RDN)rdns.elementAt(i);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1752555101 = new X500Name(template, vals);
        varB4EAC82CA7396A68D541C85D26508E83_1752555101.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1752555101;
        
        
        
        
            
        
        
    }

    
}

