package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.bouncycastle.util.Strings;

public class DERUTF8String extends ASN1Object implements DERString {

    /**
     * return an UTF8 string from the passed in object.
     * 
     * @exception IllegalArgumentException
     *                if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.528 -0500", hash_original_method = "14DA9FCD00C72F151E2D12941D253A27", hash_generated_method = "9ACCC526DC5D1FFBA8AB8F362F2F1681")
    
public static DERUTF8String getInstance(Object obj)
    {
        if (obj == null || obj instanceof DERUTF8String)
        {
            return (DERUTF8String)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: "
                + obj.getClass().getName());
    }

    /**
     * return an UTF8 String from a tagged object.
     * 
     * @param obj
     *            the tagged object holding the object we want
     * @param explicit
     *            true if the object is meant to be explicitly tagged false
     *            otherwise.
     * @exception IllegalArgumentException
     *                if the tagged object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.530 -0500", hash_original_method = "F255F440FA22832530D818EC1A496EE2", hash_generated_method = "D7D67789E8B99304FDBF53585EF446BB")
    
public static DERUTF8String getInstance(
        ASN1TaggedObject obj,
        boolean explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DERUTF8String)
        {
            return getInstance(o);
        }
        else
        {
            return new DERUTF8String(ASN1OctetString.getInstance(o).getOctets());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.526 -0500", hash_original_field = "38EA5C212184AA9651934368805B840B", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;

    /**
     * basic constructor - byte encoded string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.533 -0500", hash_original_method = "B56B53BD15659EE05E587584D616ACE1", hash_generated_method = "65A4634DAC905FE070215383502C77FD")
    
public DERUTF8String(byte[] string)
    {
        try
        {
            this.string = Strings.fromUTF8ByteArray(string);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new IllegalArgumentException("UTF8 encoding invalid");
        }
    }

    /**
     * basic constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.536 -0500", hash_original_method = "87C8A077EBDA5677CBB631FE5690C6A7", hash_generated_method = "043699194C5F2F154388F06B2B11E104")
    
public DERUTF8String(String string)
    {
        this.string = string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.538 -0500", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "0799D80CD18A4A810496E9156E8785AE")
    
public String getString()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.541 -0500", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "2D11779E0451E86157AACAD10BFF2E34")
    
public String toString()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.543 -0500", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "54F3A64DBCC65B097BA7A8E0BB1579E9")
    
public int hashCode()
    {
        return this.getString().hashCode();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.545 -0500", hash_original_method = "DF88B5FE85EAF9BB2061A4AEA787A839", hash_generated_method = "DF88B5FE85EAF9BB2061A4AEA787A839")
    
boolean asn1Equals(DERObject o)
    {
        if (!(o instanceof DERUTF8String))
        {
            return false;
        }

        DERUTF8String s = (DERUTF8String)o;

        return this.getString().equals(s.getString());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.547 -0500", hash_original_method = "6841F545C98612C1AFE91CE39DFBA4FF", hash_generated_method = "6841F545C98612C1AFE91CE39DFBA4FF")
    
void encode(DEROutputStream out)
        throws IOException
    {
        out.writeEncoded(UTF8_STRING, Strings.toUTF8ByteArray(string));
    }
    
}

