package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;






public class DERPrintableString extends ASN1Object implements DERString {
    // END android-changed

    /**
     * return a printable string from the passed in object.
     * 
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.993 -0500", hash_original_method = "4F12096C38BCDA8D0B0ADB1A10621873", hash_generated_method = "46BF8502A0780062C31B3FCC1E56EE66")
    
public static DERPrintableString getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERPrintableString)
        {
            return (DERPrintableString)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return a Printable String from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.996 -0500", hash_original_method = "8275EE32BCCE17353F3A834E5964BC07", hash_generated_method = "5158DA518C05644C6505F41869B629A4")
    
public static DERPrintableString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DERPrintableString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERPrintableString(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    /**
     * return true if the passed in String can be represented without
     * loss as a PrintableString, false otherwise.
     *
     * @return true if in printable set, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.020 -0500", hash_original_method = "E2804213A15C7C07F46CB2E618D71482", hash_generated_method = "AC6054920B969DAC032737EDD2E0E314")
    
public static boolean isPrintableString(
        String  str)
    {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);

            if (ch > 0x007f)
            {
                return false;
            }

            if ('a' <= ch && ch <= 'z')
            {
                continue;
            }

            if ('A' <= ch && ch <= 'Z')
            {
                continue;
            }

            if ('0' <= ch && ch <= '9')
            {
                continue;
            }

            switch (ch)
            {
            case ' ':
            case '\'':
            case '(':
            case ')':
            case '+':
            case '-':
            case '.':
            case ':':
            case '=':
            case '?':
            case '/':
            case ',':
                continue;
            }

            return false;
        }

        return true;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.991 -0500", hash_original_field = "38EA5C212184AA9651934368805B840B", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private  String string;

    /**
     * basic constructor - byte encoded string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.999 -0500", hash_original_method = "D997DB152CB96E2AA3DC66ADB95C73B5", hash_generated_method = "F0EA5E0760204A91896476B04A2980E9")
    
public DERPrintableString(
        byte[]   string)
    {
        char[]  cs = new char[string.length];

        for (int i = 0; i != cs.length; i++)
        {
            cs[i] = (char)(string[i] & 0xff);
        }

        // BEGIN android-changed
        this.string = new String(cs).intern();
        // END android-changed
    }

    /**
     * basic constructor - this does not validate the string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.002 -0500", hash_original_method = "6FDBF9EC620F477F9D8DC023E90C58AD", hash_generated_method = "9ACD1C5CF5F459930C6C406F234C487D")
    
public DERPrintableString(
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
     * contains characters that should not be in a PrintableString.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.004 -0500", hash_original_method = "884AB42617499DD6D6AA2A57724A994F", hash_generated_method = "BE1F609E6F40D0045833715E2FE0E9CD")
    
public DERPrintableString(
        String   string,
        boolean  validate)
    {
        if (validate && !isPrintableString(string))
        {
            throw new IllegalArgumentException("string contains illegal characters");
        }

        // BEGIN android-changed
        this.string = string.intern();
        // END android-changed
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.007 -0500", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "0799D80CD18A4A810496E9156E8785AE")
    
public String getString()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.009 -0500", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "E08E3842D09F2B484542E23BCDDE2DBB")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.011 -0500", hash_original_method = "84DAFF7719AC505908CDD70F6E92DE78", hash_generated_method = "84DAFF7719AC505908CDD70F6E92DE78")
    
void encode(
        DEROutputStream  out)
        throws IOException
    {
        out.writeEncoded(PRINTABLE_STRING, this.getOctets());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.013 -0500", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "54F3A64DBCC65B097BA7A8E0BB1579E9")
    
public int hashCode()
    {
        return this.getString().hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.015 -0500", hash_original_method = "356EB8B61A96F4A47C607B567EAD3298", hash_generated_method = "356EB8B61A96F4A47C607B567EAD3298")
    
boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof DERPrintableString))
        {
            return false;
        }

        DERPrintableString  s = (DERPrintableString)o;

        return this.getString().equals(s.getString());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.017 -0500", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "2D11779E0451E86157AACAD10BFF2E34")
    
public String toString()
    {
        return string;
    }

    
}

