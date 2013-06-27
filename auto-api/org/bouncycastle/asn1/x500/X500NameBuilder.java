package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public class X500NameBuilder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.671 -0400", hash_original_field = "66F6181BCB4CFF4CD38FBC804A036DB6", hash_generated_field = "C522E2D6076698825F4E82735A8D3025")

    private X500NameStyle template;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.671 -0400", hash_original_field = "E72CD27D6F5E6EA66835054F74B68BD5", hash_generated_field = "675045CFA58337E15285151041709C32")

    private Vector rdns = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.682 -0400", hash_original_method = "D0728342E4979FB5B75C971FD31579AF", hash_generated_method = "C5F092BBA326550A9DB00A2B96B75883")
    public  X500NameBuilder(X500NameStyle template) {
        this.template = template;
        // ---------- Original Method ----------
        //this.template = template;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.683 -0400", hash_original_method = "B523CEAB6DE32883E9365149ACA12057", hash_generated_method = "0A9A29928C3F72CBE08FED11789C02B3")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, String value) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_917203044 = null; //Variable for return #1
        this.addRDN(oid, template.stringToValue(oid, value));
        varB4EAC82CA7396A68D541C85D26508E83_917203044 = this;
        addTaint(oid.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_917203044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_917203044;
        // ---------- Original Method ----------
        //this.addRDN(oid, template.stringToValue(oid, value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.691 -0400", hash_original_method = "8590615114869FAEC1B946165AEDD39D", hash_generated_method = "EB55D2C620C829CCE6E5A431654C94B9")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, ASN1Encodable value) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_886117856 = null; //Variable for return #1
        rdns.addElement(new RDN(oid, value));
        varB4EAC82CA7396A68D541C85D26508E83_886117856 = this;
        addTaint(oid.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_886117856.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_886117856;
        // ---------- Original Method ----------
        //rdns.addElement(new RDN(oid, value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.692 -0400", hash_original_method = "3E5E6DF77AF598ABE6D42C6639692F78", hash_generated_method = "C59FE52F19D8AB352837F52A0DE60E03")
    public X500NameBuilder addRDN(AttributeTypeAndValue attrTAndV) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_781442858 = null; //Variable for return #1
        rdns.addElement(new RDN(attrTAndV));
        varB4EAC82CA7396A68D541C85D26508E83_781442858 = this;
        addTaint(attrTAndV.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_781442858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_781442858;
        // ---------- Original Method ----------
        //rdns.addElement(new RDN(attrTAndV));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.692 -0400", hash_original_method = "273A600B6E97E185C3AB8807EACFE39D", hash_generated_method = "C8A739A5ECA89B40E7F4993363D96988")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, String[] values) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_609274189 = null; //Variable for return #1
        ASN1Encodable[] vals;
        vals = new ASN1Encodable[values.length];
        {
            int i;
            i = 0;
            {
                vals[i] = template.stringToValue(oids[i], values[i]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_609274189 = addMultiValuedRDN(oids, vals);
        addTaint(oids[0].getTaint());
        addTaint(values[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_609274189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_609274189;
        // ---------- Original Method ----------
        //ASN1Encodable[] vals = new ASN1Encodable[values.length];
        //for (int i = 0; i != vals.length; i++)
        //{
            //vals[i] = template.stringToValue(oids[i], values[i]);
        //}
        //return addMultiValuedRDN(oids, vals);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.693 -0400", hash_original_method = "19CADD9F3E05278519C8972C40F988FF", hash_generated_method = "15438253970480708BCB0ABF0C999635")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, ASN1Encodable[] values) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_246152630 = null; //Variable for return #1
        AttributeTypeAndValue[] avs;
        avs = new AttributeTypeAndValue[oids.length];
        {
            int i;
            i = 0;
            {
                avs[i] = new AttributeTypeAndValue(oids[i], values[i]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_246152630 = addMultiValuedRDN(avs);
        addTaint(oids[0].getTaint());
        addTaint(values[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_246152630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_246152630;
        // ---------- Original Method ----------
        //AttributeTypeAndValue[] avs = new AttributeTypeAndValue[oids.length];
        //for (int i = 0; i != oids.length; i++)
        //{
            //avs[i] = new AttributeTypeAndValue(oids[i], values[i]);
        //}
        //return addMultiValuedRDN(avs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.693 -0400", hash_original_method = "3AFEEFAA1A94C00426001446F3A2411A", hash_generated_method = "C8EA9726EF9C67A5D741873059996A41")
    public X500NameBuilder addMultiValuedRDN(AttributeTypeAndValue[] attrTAndVs) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_1662995806 = null; //Variable for return #1
        rdns.addElement(new RDN(attrTAndVs));
        varB4EAC82CA7396A68D541C85D26508E83_1662995806 = this;
        addTaint(attrTAndVs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1662995806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1662995806;
        // ---------- Original Method ----------
        //rdns.addElement(new RDN(attrTAndVs));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.694 -0400", hash_original_method = "6DE1D9D13ABB402C9E6AC772336CF9FE", hash_generated_method = "AF7FC77DA363481D02F4F8528230BBF6")
    public X500Name build() {
        X500Name varB4EAC82CA7396A68D541C85D26508E83_1523157516 = null; //Variable for return #1
        RDN[] vals;
        vals = new RDN[rdns.size()];
        {
            int i;
            i = 0;
            {
                vals[i] = (RDN)rdns.elementAt(i);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1523157516 = new X500Name(template, vals);
        varB4EAC82CA7396A68D541C85D26508E83_1523157516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1523157516;
        // ---------- Original Method ----------
        //RDN[] vals = new RDN[rdns.size()];
        //for (int i = 0; i != vals.length; i++)
        //{
            //vals[i] = (RDN)rdns.elementAt(i);
        //}
        //return new X500Name(template, vals);
    }

    
}

