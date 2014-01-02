package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;






public class DERT61String extends ASN1Object implements DERString {

    /**
     * return a T61 string from the passed in object.
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.424 -0500", hash_original_method = "0481722D353CECA39D117CD4D6DCEE86", hash_generated_method = "FDA0CED15F067AAC7D95360E2FABCB7A")
    
public static DERT61String getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERT61String)
        {
            return (DERT61String)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return an T61 String from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.426 -0500", hash_original_method = "C6CB56523CAB4B252D35BC497BFDCC18", hash_generated_method = "4F2C61FC8A977CE4D0D165310F35CA4D")
    
public static DERT61String getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        DERObject o = obj.getObject();

        if (explicit)
        {
            return getInstance(o);
        }
        else
        {
            return new DERT61String(ASN1OctetString.getInstance(o).getOctets());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.421 -0500", hash_original_field = "38EA5C212184AA9651934368805B840B", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String  string;

    /**
     * basic constructor - with bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.429 -0500", hash_original_method = "729283B8151D354FE604ECA706D47EFD", hash_generated_method = "DE8287A4F40D38968B04F1334D63D5DE")
    
public DERT61String(
        byte[]   string)
    {
        char[]  cs = new char[string.length];

        for (int i = 0; i != cs.length; i++)
        {
            cs[i] = (char)(string[i] & 0xff);
        }

        this.string = new String(cs);
    }

    /**
     * basic constructor - with string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.433 -0500", hash_original_method = "0CF9010F1BDF3E8A972E72A6B339B40C", hash_generated_method = "3BCA17704ABF18AB1731F4800209D48D")
    
public DERT61String(
        String   string)
    {
        this.string = string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.435 -0500", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "0799D80CD18A4A810496E9156E8785AE")
    
public String getString()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.437 -0500", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "2D11779E0451E86157AACAD10BFF2E34")
    
public String toString()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.439 -0500", hash_original_method = "324AB1C41995E9982EA64A8881837CC9", hash_generated_method = "324AB1C41995E9982EA64A8881837CC9")
    
void encode(
        DEROutputStream  out)
        throws IOException
    {
        out.writeEncoded(T61_STRING, this.getOctets());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.441 -0500", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "E08E3842D09F2B484542E23BCDDE2DBB")
    
public byte[] getOctets()
    {
        char[]  cs = string.toCharArray();
        byte[]  bs = new byte[cs.length];

        for (int i = 0; i != cs.length; i++)
        {
            bs[i] = (byte)cs[i];
        }

        return bs; 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.443 -0500", hash_original_method = "E436607154A8EB2DA476BE28768351EE", hash_generated_method = "E436607154A8EB2DA476BE28768351EE")
    
boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof DERT61String))
        {
            return false;
        }

        return this.getString().equals(((DERT61String)o).getString());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.445 -0500", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "54F3A64DBCC65B097BA7A8E0BB1579E9")
    
public int hashCode()
    {
        return this.getString().hashCode();
    }

    
}

