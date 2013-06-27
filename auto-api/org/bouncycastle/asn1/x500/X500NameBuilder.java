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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.762 -0400", hash_original_field = "66F6181BCB4CFF4CD38FBC804A036DB6", hash_generated_field = "C522E2D6076698825F4E82735A8D3025")

    private X500NameStyle template;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.763 -0400", hash_original_field = "E72CD27D6F5E6EA66835054F74B68BD5", hash_generated_field = "675045CFA58337E15285151041709C32")

    private Vector rdns = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.763 -0400", hash_original_method = "D0728342E4979FB5B75C971FD31579AF", hash_generated_method = "C5F092BBA326550A9DB00A2B96B75883")
    public  X500NameBuilder(X500NameStyle template) {
        this.template = template;
        // ---------- Original Method ----------
        //this.template = template;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.771 -0400", hash_original_method = "B523CEAB6DE32883E9365149ACA12057", hash_generated_method = "3D238F681844B4209BF8754CA4D2B547")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, String value) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_212316272 = null; //Variable for return #1
        this.addRDN(oid, template.stringToValue(oid, value));
        varB4EAC82CA7396A68D541C85D26508E83_212316272 = this;
        addTaint(oid.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_212316272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_212316272;
        // ---------- Original Method ----------
        //this.addRDN(oid, template.stringToValue(oid, value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.773 -0400", hash_original_method = "8590615114869FAEC1B946165AEDD39D", hash_generated_method = "DEFCEEA2BFFE954B0B3D6DB671BFE906")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, ASN1Encodable value) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_1301223788 = null; //Variable for return #1
        rdns.addElement(new RDN(oid, value));
        varB4EAC82CA7396A68D541C85D26508E83_1301223788 = this;
        addTaint(oid.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1301223788.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1301223788;
        // ---------- Original Method ----------
        //rdns.addElement(new RDN(oid, value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.775 -0400", hash_original_method = "3E5E6DF77AF598ABE6D42C6639692F78", hash_generated_method = "1FB9479B8E74C65522F9113E51880C50")
    public X500NameBuilder addRDN(AttributeTypeAndValue attrTAndV) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_1007424556 = null; //Variable for return #1
        rdns.addElement(new RDN(attrTAndV));
        varB4EAC82CA7396A68D541C85D26508E83_1007424556 = this;
        addTaint(attrTAndV.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1007424556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1007424556;
        // ---------- Original Method ----------
        //rdns.addElement(new RDN(attrTAndV));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.776 -0400", hash_original_method = "273A600B6E97E185C3AB8807EACFE39D", hash_generated_method = "6013746886B4C4021A50FF3BF8EFD119")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, String[] values) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_1979485207 = null; //Variable for return #1
        ASN1Encodable[] vals;
        vals = new ASN1Encodable[values.length];
        {
            int i;
            i = 0;
            {
                vals[i] = template.stringToValue(oids[i], values[i]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1979485207 = addMultiValuedRDN(oids, vals);
        addTaint(oids[0].getTaint());
        addTaint(values[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1979485207.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1979485207;
        // ---------- Original Method ----------
        //ASN1Encodable[] vals = new ASN1Encodable[values.length];
        //for (int i = 0; i != vals.length; i++)
        //{
            //vals[i] = template.stringToValue(oids[i], values[i]);
        //}
        //return addMultiValuedRDN(oids, vals);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.777 -0400", hash_original_method = "19CADD9F3E05278519C8972C40F988FF", hash_generated_method = "0BF4A323646EC4789E538F4C07FE4D17")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, ASN1Encodable[] values) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_549230728 = null; //Variable for return #1
        AttributeTypeAndValue[] avs;
        avs = new AttributeTypeAndValue[oids.length];
        {
            int i;
            i = 0;
            {
                avs[i] = new AttributeTypeAndValue(oids[i], values[i]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_549230728 = addMultiValuedRDN(avs);
        addTaint(oids[0].getTaint());
        addTaint(values[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_549230728.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_549230728;
        // ---------- Original Method ----------
        //AttributeTypeAndValue[] avs = new AttributeTypeAndValue[oids.length];
        //for (int i = 0; i != oids.length; i++)
        //{
            //avs[i] = new AttributeTypeAndValue(oids[i], values[i]);
        //}
        //return addMultiValuedRDN(avs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.781 -0400", hash_original_method = "3AFEEFAA1A94C00426001446F3A2411A", hash_generated_method = "41C6728B0D3BAFE75BDF92EE138D51C1")
    public X500NameBuilder addMultiValuedRDN(AttributeTypeAndValue[] attrTAndVs) {
        X500NameBuilder varB4EAC82CA7396A68D541C85D26508E83_858216272 = null; //Variable for return #1
        rdns.addElement(new RDN(attrTAndVs));
        varB4EAC82CA7396A68D541C85D26508E83_858216272 = this;
        addTaint(attrTAndVs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_858216272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_858216272;
        // ---------- Original Method ----------
        //rdns.addElement(new RDN(attrTAndVs));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.792 -0400", hash_original_method = "6DE1D9D13ABB402C9E6AC772336CF9FE", hash_generated_method = "E2383A6A6411FEE57639E4C2A1AC2A6F")
    public X500Name build() {
        X500Name varB4EAC82CA7396A68D541C85D26508E83_913242046 = null; //Variable for return #1
        RDN[] vals;
        vals = new RDN[rdns.size()];
        {
            int i;
            i = 0;
            {
                vals[i] = (RDN)rdns.elementAt(i);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_913242046 = new X500Name(template, vals);
        varB4EAC82CA7396A68D541C85D26508E83_913242046.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_913242046;
        // ---------- Original Method ----------
        //RDN[] vals = new RDN[rdns.size()];
        //for (int i = 0; i != vals.length; i++)
        //{
            //vals[i] = (RDN)rdns.elementAt(i);
        //}
        //return new X500Name(template, vals);
    }

    
}

