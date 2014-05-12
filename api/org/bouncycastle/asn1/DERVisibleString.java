package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class DERVisibleString extends ASN1Object implements DERString {

    /**
     * return a Visible String from the passed in object.
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.079 -0500", hash_original_method = "D50034F7292D7ABDF49FD18578914EC8", hash_generated_method = "699FA18B448369B2239F623EEEA6161F")
    
public static DERVisibleString getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERVisibleString)
        {
            return (DERVisibleString)obj;
        }

        if (obj instanceof ASN1OctetString)
        {
            return new DERVisibleString(((ASN1OctetString)obj).getOctets());
        }

        if (obj instanceof ASN1TaggedObject)
        {
            return getInstance(((ASN1TaggedObject)obj).getObject());
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return a Visible String from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.082 -0500", hash_original_method = "2EFE6A1E8906E1AD703F5E97360BF918", hash_generated_method = "6B9EED9AA1C89840002FAE3C3DE90D6C")
    
public static DERVisibleString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(obj.getObject());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.077 -0500", hash_original_field = "38EA5C212184AA9651934368805B840B", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String  string;

    /**
     * basic constructor - byte encoded string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.085 -0500", hash_original_method = "9E5952D16AC98B93920C8F7137608462", hash_generated_method = "48C38B1B54C01E20F4C98507966DFE33")
    
public DERVisibleString(
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
     * basic constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.088 -0500", hash_original_method = "C35105E6557DD0D425C7A0BF0E564EC8", hash_generated_method = "3ECA2CF87CFA02F9286592F404811F30")
    
public DERVisibleString(
        String   string)
    {
        this.string = string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.091 -0500", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "0799D80CD18A4A810496E9156E8785AE")
    
public String getString()
    {
        return string;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.093 -0500", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "2D11779E0451E86157AACAD10BFF2E34")
    
public String toString()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.095 -0500", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "E08E3842D09F2B484542E23BCDDE2DBB")
    
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

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.097 -0500", hash_original_method = "EDEDEE2045D008C87CEA62CE5CC5E8C6", hash_generated_method = "EDEDEE2045D008C87CEA62CE5CC5E8C6")
    
void encode(
        DEROutputStream  out)
        throws IOException
    {
        out.writeEncoded(VISIBLE_STRING, this.getOctets());
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.099 -0500", hash_original_method = "D3E4E4BB0C90F60625E75FAD6BCA1138", hash_generated_method = "D3E4E4BB0C90F60625E75FAD6BCA1138")
    
boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof DERVisibleString))
        {
            return false;
        }

        return this.getString().equals(((DERVisibleString)o).getString());
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.101 -0500", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "54F3A64DBCC65B097BA7A8E0BB1579E9")
    
public int hashCode()
    {
        return this.getString().hashCode();
    }
    
}

