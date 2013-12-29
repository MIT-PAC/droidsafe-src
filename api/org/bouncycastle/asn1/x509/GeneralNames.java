package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;




public class GeneralNames extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.003 -0500", hash_original_method = "AFA92D82B845809211E4A674A6437E54", hash_generated_method = "641D9D1CEA70BD86DA319CB4CEF0729E")
    public static GeneralNames getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof GeneralNames)
        {
            return (GeneralNames)obj;
        }

        if (obj instanceof ASN1Sequence)
        {
            return new GeneralNames((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.004 -0500", hash_original_method = "FC1A9B1EF53747E4942B8480ACF62116", hash_generated_method = "7BB41391DEB0EFE96EF91CC43F1B33CC")
    public static GeneralNames getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.002 -0500", hash_original_field = "2BF486B8767A83B78F9206C9E8A7F2C3", hash_generated_field = "74CEDC81B0DB27B07D173878E0284C60")

    private  GeneralName[] names;

    /**
     * Construct a GeneralNames object containing one GeneralName.
     * 
     * @param name the name to be contained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.006 -0500", hash_original_method = "F51AA332BBC1C75C23F2395E3D593569", hash_generated_method = "9E31B1ED0C5667E1322EC7487E2BAA63")
    public GeneralNames(
        GeneralName  name)
    {
        this.names = new GeneralName[] { name };
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.006 -0500", hash_original_method = "6F12A07D09CAFA480B0283A3B9FED616", hash_generated_method = "0D55207A95467BDDB8662D60B00D9666")
    public GeneralNames(
        ASN1Sequence  seq)
    {
        this.names = new GeneralName[seq.size()];

        for (int i = 0; i != seq.size(); i++)
        {
            names[i] = GeneralName.getInstance(seq.getObjectAt(i));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.007 -0500", hash_original_method = "9AED96B400BA543408C9F5E967093153", hash_generated_method = "8FFB3E9FE7CEABA55D269E9232783EE2")
    public GeneralName[] getNames()
    {
        GeneralName[] tmp = new GeneralName[names.length];

        System.arraycopy(names, 0, tmp, 0, names.length);

        return tmp;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     * GeneralNames ::= SEQUENCE SIZE {1..MAX} OF GeneralName
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.008 -0500", hash_original_method = "04D00D35531AB013A64ACFCEB501C4EE", hash_generated_method = "6F0EF33E6233A04DD6B41216653EE65D")
    public DERObject toASN1Object()
    {
        return new DERSequence(names);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.009 -0500", hash_original_method = "7DDFA5C3E7762D6D39ED7DFFF0863845", hash_generated_method = "7DF9CFC8C5E0FD58B275A4A168000EA9")
    public String toString()
    {
        StringBuffer  buf = new StringBuffer();
        String        sep = System.getProperty("line.separator");

        buf.append("GeneralNames:");
        buf.append(sep);

        for (int i = 0; i != names.length; i++)
        {
            buf.append("    ");
            buf.append(names[i]);
            buf.append(sep);
        }
        return buf.toString();
    }

    
}

