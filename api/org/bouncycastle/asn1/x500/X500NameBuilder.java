package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Vector;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;




public class X500NameBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.966 -0500", hash_original_field = "866BD9E66D99F4BF56DC40C90281A097", hash_generated_field = "C522E2D6076698825F4E82735A8D3025")

    private X500NameStyle template;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.967 -0500", hash_original_field = "9B9E60D2D8A91575450B58AD3A07D9D1", hash_generated_field = "675045CFA58337E15285151041709C32")

    private Vector rdns = new Vector();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.968 -0500", hash_original_method = "D0728342E4979FB5B75C971FD31579AF", hash_generated_method = "40B8C2B38C9CAA95803581E45B699AF5")
    public X500NameBuilder(X500NameStyle template)
    {
        this.template = template;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.968 -0500", hash_original_method = "B523CEAB6DE32883E9365149ACA12057", hash_generated_method = "43C69577DD12505E2B20348E102A62CB")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, String value)
    {
        this.addRDN(oid, template.stringToValue(oid, value));

        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.969 -0500", hash_original_method = "8590615114869FAEC1B946165AEDD39D", hash_generated_method = "16F3A9FC05AE0E7479155BA5E5228EAC")
    public X500NameBuilder addRDN(ASN1ObjectIdentifier oid, ASN1Encodable value)
    {
        rdns.addElement(new RDN(oid, value));

        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.970 -0500", hash_original_method = "3E5E6DF77AF598ABE6D42C6639692F78", hash_generated_method = "128DE6E6292771C13BBBF44E09F4B0E1")
    public X500NameBuilder addRDN(AttributeTypeAndValue attrTAndV)
    {
        rdns.addElement(new RDN(attrTAndV));

        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.971 -0500", hash_original_method = "273A600B6E97E185C3AB8807EACFE39D", hash_generated_method = "E33BF2B8380AFB28ECDEF4E267FA961F")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, String[] values)
    {
        ASN1Encodable[] vals = new ASN1Encodable[values.length];

        for (int i = 0; i != vals.length; i++)
        {
            vals[i] = template.stringToValue(oids[i], values[i]);
        }

        return addMultiValuedRDN(oids, vals);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.971 -0500", hash_original_method = "19CADD9F3E05278519C8972C40F988FF", hash_generated_method = "59C9A03541B96C024582176D3552BD49")
    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] oids, ASN1Encodable[] values)
    {
        AttributeTypeAndValue[] avs = new AttributeTypeAndValue[oids.length];

        for (int i = 0; i != oids.length; i++)
        {
            avs[i] = new AttributeTypeAndValue(oids[i], values[i]);
        }

        return addMultiValuedRDN(avs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.972 -0500", hash_original_method = "3AFEEFAA1A94C00426001446F3A2411A", hash_generated_method = "7C59DB9E49AB80B3A7E80128714DFD76")
    public X500NameBuilder addMultiValuedRDN(AttributeTypeAndValue[] attrTAndVs)
    {
        rdns.addElement(new RDN(attrTAndVs));

        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.973 -0500", hash_original_method = "6DE1D9D13ABB402C9E6AC772336CF9FE", hash_generated_method = "96537ECB8419F95BACE58C70F204F56C")
    public X500Name build()
    {
        RDN[] vals = new RDN[rdns.size()];

        for (int i = 0; i != vals.length; i++)
        {
            vals[i] = (RDN)rdns.elementAt(i);
        }

        return new X500Name(template, vals);
    }

    
}

