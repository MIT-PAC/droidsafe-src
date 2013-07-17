package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public class X500NameBuilder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.355 -0400", hash_original_field = "66F6181BCB4CFF4CD38FBC804A036DB6", hash_generated_field = "C522E2D6076698825F4E82735A8D3025")

    private X500NameStyle template;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.355 -0400", hash_original_field = "E72CD27D6F5E6EA66835054F74B68BD5", hash_generated_field = "675045CFA58337E15285151041709C32")

    private Vector rdns = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.355 -0400", hash_original_method = "D0728342E4979FB5B75C971FD31579AF", hash_generated_method = "C5F092BBA326550A9DB00A2B96B75883")
    public  X500NameBuilder(X500NameStyle template) {
        this.template = template;
        // ---------- Original Method ----------
        //this.template = template;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.355 -0400", hash_original_method = "B523CEAB6DE32883E9365149ACA12057", hash_generated_method = "2B743260B0BFC4476AFDF84BB75613F8")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, String value) {
        addTaint(value.getTaint());
        addTaint(oid.getTaint());
        this.addRDN(oid, template.stringToValue(oid, value));
X500NameBuilder var72A74007B2BE62B849F475C7BDA4658B_917958275 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_917958275.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_917958275;
        // ---------- Original Method ----------
        //this.addRDN(oid, template.stringToValue(oid, value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.356 -0400", hash_original_method = "8590615114869FAEC1B946165AEDD39D", hash_generated_method = "49C94339F6F30F1566910E4A8CD966DC")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, ASN1Encodable value) {
        addTaint(value.getTaint());
        addTaint(oid.getTaint());
        rdns.addElement(new RDN(oid, value));
X500NameBuilder var72A74007B2BE62B849F475C7BDA4658B_342162469 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_342162469.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_342162469;
        // ---------- Original Method ----------
        //rdns.addElement(new RDN(oid, value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.357 -0400", hash_original_method = "3E5E6DF77AF598ABE6D42C6639692F78", hash_generated_method = "D3CA89ECF9478E525D52A6749E0CC425")
    public X500NameBuilder addRDN(AttributeTypeAndValue attrTAndV) {
        addTaint(attrTAndV.getTaint());
        rdns.addElement(new RDN(attrTAndV));
X500NameBuilder var72A74007B2BE62B849F475C7BDA4658B_2034072650 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2034072650.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2034072650;
        // ---------- Original Method ----------
        //rdns.addElement(new RDN(attrTAndV));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.358 -0400", hash_original_method = "273A600B6E97E185C3AB8807EACFE39D", hash_generated_method = "63183CC342D6DFEF24E436C54EFB684C")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, String[] values) {
        addTaint(values[0].getTaint());
        addTaint(oids[0].getTaint());
        ASN1Encodable[] vals = new ASN1Encodable[values.length];
for(int i = 0;i != vals.length;i++)
        {
            vals[i] = template.stringToValue(oids[i], values[i]);
        } //End block
X500NameBuilder varD7F2C29827E72CD1BB5CBC1E148ADA09_256534313 =         addMultiValuedRDN(oids, vals);
        varD7F2C29827E72CD1BB5CBC1E148ADA09_256534313.addTaint(taint);
        return varD7F2C29827E72CD1BB5CBC1E148ADA09_256534313;
        // ---------- Original Method ----------
        //ASN1Encodable[] vals = new ASN1Encodable[values.length];
        //for (int i = 0; i != vals.length; i++)
        //{
            //vals[i] = template.stringToValue(oids[i], values[i]);
        //}
        //return addMultiValuedRDN(oids, vals);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.359 -0400", hash_original_method = "19CADD9F3E05278519C8972C40F988FF", hash_generated_method = "1CA399EBD7171BF52A5B7751F2DC4E80")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, ASN1Encodable[] values) {
        addTaint(values[0].getTaint());
        addTaint(oids[0].getTaint());
        AttributeTypeAndValue[] avs = new AttributeTypeAndValue[oids.length];
for(int i = 0;i != oids.length;i++)
        {
            avs[i] = new AttributeTypeAndValue(oids[i], values[i]);
        } //End block
X500NameBuilder var9D2F985167BE7E1703BB252DA3E09BD5_1318826750 =         addMultiValuedRDN(avs);
        var9D2F985167BE7E1703BB252DA3E09BD5_1318826750.addTaint(taint);
        return var9D2F985167BE7E1703BB252DA3E09BD5_1318826750;
        // ---------- Original Method ----------
        //AttributeTypeAndValue[] avs = new AttributeTypeAndValue[oids.length];
        //for (int i = 0; i != oids.length; i++)
        //{
            //avs[i] = new AttributeTypeAndValue(oids[i], values[i]);
        //}
        //return addMultiValuedRDN(avs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.360 -0400", hash_original_method = "3AFEEFAA1A94C00426001446F3A2411A", hash_generated_method = "0BAC768399AC430D8B7DCDEF8BD148A3")
    public X500NameBuilder addMultiValuedRDN(AttributeTypeAndValue[] attrTAndVs) {
        addTaint(attrTAndVs[0].getTaint());
        rdns.addElement(new RDN(attrTAndVs));
X500NameBuilder var72A74007B2BE62B849F475C7BDA4658B_1820682172 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1820682172.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1820682172;
        // ---------- Original Method ----------
        //rdns.addElement(new RDN(attrTAndVs));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.361 -0400", hash_original_method = "6DE1D9D13ABB402C9E6AC772336CF9FE", hash_generated_method = "8AAD0F42580B5CF0FA58CA68AAD0A1D6")
    public X500Name build() {
        RDN[] vals = new RDN[rdns.size()];
for(int i = 0;i != vals.length;i++)
        {
            vals[i] = (RDN)rdns.elementAt(i);
        } //End block
X500Name var25250835424566A0FA42053F485F38F1_1355162799 =         new X500Name(template, vals);
        var25250835424566A0FA42053F485F38F1_1355162799.addTaint(taint);
        return var25250835424566A0FA42053F485F38F1_1355162799;
        // ---------- Original Method ----------
        //RDN[] vals = new RDN[rdns.size()];
        //for (int i = 0; i != vals.length; i++)
        //{
            //vals[i] = (RDN)rdns.elementAt(i);
        //}
        //return new X500Name(template, vals);
    }

    
}

