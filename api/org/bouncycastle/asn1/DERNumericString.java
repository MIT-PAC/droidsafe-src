package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class DERNumericString extends ASN1Object implements DERString {

    /**
     * return a Numeric string from the passed in object
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.795 -0500", hash_original_method = "6F91E8D60F41A74ED45E31085B26D476", hash_generated_method = "77871AD71F0D1C75B481FEEC7A5D770D")
    
public static DERNumericString getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERNumericString)
        {
            return (DERNumericString)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return an Numeric String from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.798 -0500", hash_original_method = "218C3368C5D83E9A6AE098098C904908", hash_generated_method = "C2F038823603F63E5405CEB61514AA64")
    
public static DERNumericString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DERNumericString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERNumericString(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    /**
     * Return true if the string can be represented as a NumericString ('0'..'9', ' ')
     *
     * @param str string to validate.
     * @return true if numeric, fale otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.820 -0500", hash_original_method = "049F8D965694C2AF1DDE3DF681E296F3", hash_generated_method = "39CF216D327B4F6D26F037E3F187D898")
    
public static boolean isNumericString(
        String  str)
    {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);

            if (ch > 0x007f)
            {
                return false;
            }

            if (('0' <= ch && ch <= '9') || ch == ' ')
            {
                continue;
            }

            return false;
        }

        return true;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.792 -0500", hash_original_field = "38EA5C212184AA9651934368805B840B", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String  string;

    /**
     * basic constructor - with bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.800 -0500", hash_original_method = "68F5D78267A661375BFA3ED79E149992", hash_generated_method = "DE868654A0553D24B157BE03977F1B47")
    
public DERNumericString(
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
     * basic constructor -  without validation..
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.803 -0500", hash_original_method = "4A4CC31A466FEB81F134844B7BA257FB", hash_generated_method = "A284F3000955EDE6C1F2FA90BBFBB1AB")
    
public DERNumericString(
        String   string)
    {
        this(string, false);
    }

    /**
     * Constructor with optional validation.
     *
     * @param string the base string to wrap.
     * @param validate whether or not to check the string.
     * @throws IllegalArgumentException if validate is true and the string
     * contains characters that should not be in a NumericString.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.805 -0500", hash_original_method = "E352C3D2266CB71465C2437206485D10", hash_generated_method = "A05A1B742AA66A70821529E59154F5CB")
    
public DERNumericString(
        String   string,
        boolean  validate)
    {
        if (validate && !isNumericString(string))
        {
            throw new IllegalArgumentException("string contains illegal characters");
        }

        this.string = string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.808 -0500", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "0799D80CD18A4A810496E9156E8785AE")
    
public String getString()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.810 -0500", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "2D11779E0451E86157AACAD10BFF2E34")
    
public String toString()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.812 -0500", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "E08E3842D09F2B484542E23BCDDE2DBB")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.814 -0500", hash_original_method = "9CAFE2F99C4AA1A810005CA2021DBA5F", hash_generated_method = "9CAFE2F99C4AA1A810005CA2021DBA5F")
    
void encode(
        DEROutputStream  out)
        throws IOException
    {
        out.writeEncoded(NUMERIC_STRING, this.getOctets());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.816 -0500", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "54F3A64DBCC65B097BA7A8E0BB1579E9")
    
public int hashCode()
    {
        return this.getString().hashCode();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.818 -0500", hash_original_method = "8BA017E030540263DAC8EBF952EA3B45", hash_generated_method = "8BA017E030540263DAC8EBF952EA3B45")
    
boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof DERNumericString))
        {
            return false;
        }

        DERNumericString  s = (DERNumericString)o;

        return this.getString().equals(s.getString());
    }
    
}

