package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;






public class DERUniversalString extends ASN1Object implements DERString {
    
    /**
     * return a Universal String from the passed in object.
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.631 -0500", hash_original_method = "A2264301282F179B15A49422DAD87BE5", hash_generated_method = "42E7EF7BB28ACB385C54C908984F900A")
    public static DERUniversalString getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERUniversalString)
        {
            return (DERUniversalString)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return a Universal String from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.632 -0500", hash_original_method = "C62DFE68CBFB4F437D54BE1C75A8C517", hash_generated_method = "5FD3F70B83BBA2E53A89D9CD37907CE1")
    public static DERUniversalString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DERUniversalString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERUniversalString(((ASN1OctetString)o).getOctets());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.629 -0500", hash_original_field = "93CC79680ED66E97963A0FAE96507423", hash_generated_field = "4F8597255A63B9818A65C2C1EBCFBC6D")

    private static final char[]  table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.630 -0500", hash_original_field = "4DFAD1EC9079C516825D3C67F76850BC", hash_generated_field = "F26C5AE8BA7ACEC7B1EA4DA4444275F5")

    private byte[] string;

    /**
     * basic constructor - byte encoded string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.633 -0500", hash_original_method = "2B92FC0148DCC3B768EB41AB12E19E0C", hash_generated_method = "397D8CBBFFC1277FCB8600FD8B313BD9")
    public DERUniversalString(
        byte[]   string)
    {
        this.string = string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.634 -0500", hash_original_method = "C8AC92EF6B951363C15B3CD0868FB9EA", hash_generated_method = "625EEA01CAE8F289CBA884F5FAC598F2")
    public String getString()
    {
        StringBuffer    buf = new StringBuffer("#");
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();
        ASN1OutputStream            aOut = new ASN1OutputStream(bOut);
        
        try
        {
            aOut.writeObject(this);
        }
        catch (IOException e)
        {
           throw new RuntimeException("internal error encoding BitString");
        }
        
        byte[]    string = bOut.toByteArray();
        
        for (int i = 0; i != string.length; i++)
        {
            buf.append(table[(string[i] >>> 4) & 0xf]);
            buf.append(table[string[i] & 0xf]);
        }
        
        return buf.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.635 -0500", hash_original_method = "79F534E26CC8382FAA66B4080878D117", hash_generated_method = "797E25846E0761235375940A5544E1B9")
    public String toString()
    {
        return getString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.635 -0500", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "94D2EF08EA4C68EF88007C34B3811270")
    public byte[] getOctets()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.636 -0500", hash_original_method = "7109223BA8B3755943761B0801F71200", hash_generated_method = "7109223BA8B3755943761B0801F71200")
    void encode(
        DEROutputStream  out)
        throws IOException
    {
        out.writeEncoded(UNIVERSAL_STRING, this.getOctets());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.637 -0500", hash_original_method = "2C48DF670B2A84721AF2DD998EBDD99A", hash_generated_method = "2C48DF670B2A84721AF2DD998EBDD99A")
    boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof DERUniversalString))
        {
            return false;
        }

        return this.getString().equals(((DERUniversalString)o).getString());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.638 -0500", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "54F3A64DBCC65B097BA7A8E0BB1579E9")
    public int hashCode()
    {
        return this.getString().hashCode();
    }
}

