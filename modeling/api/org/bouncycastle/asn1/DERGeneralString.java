package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class DERGeneralString extends ASN1Object implements DERString {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.311 -0500", hash_original_method = "0DDD2C729303DB5379ACD0D47288A821", hash_generated_method = "51CF3F22B9DFB7460CF105A86EC246BE")
    
public static DERGeneralString getInstance(
        Object obj) 
    {
        if (obj == null || obj instanceof DERGeneralString) 
        {
            return (DERGeneralString) obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: "
                + obj.getClass().getName());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.314 -0500", hash_original_method = "95A47A28AEF480CC73625BC7CE356E9A", hash_generated_method = "4FA080674D1B182F2C16D6185B8ABDF5")
    
public static DERGeneralString getInstance(
        ASN1TaggedObject obj, 
        boolean explicit) 
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DERGeneralString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERGeneralString(((ASN1OctetString)o).getOctets());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.309 -0500", hash_original_field = "38EA5C212184AA9651934368805B840B", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.317 -0500", hash_original_method = "E16C9AF2574A91241A7B16E43930D742", hash_generated_method = "617779D7A1ECDFB57E63879B37ACFD70")
    
public DERGeneralString(byte[] string) 
    {
        char[] cs = new char[string.length];
        for (int i = 0; i != cs.length; i++)
        {
            cs[i] = (char)(string[i] & 0xff);
        }
        this.string = new String(cs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.320 -0500", hash_original_method = "3F7BE61BE73D3159504C79D758BB363A", hash_generated_method = "594A494D2B970E4D7759E1BF35C213E5")
    
public DERGeneralString(String string) 
    {
        this.string = string;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.322 -0500", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "0799D80CD18A4A810496E9156E8785AE")
    
public String getString() 
    {
        return string;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.325 -0500", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "2D11779E0451E86157AACAD10BFF2E34")
    
public String toString()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.327 -0500", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "E08E3842D09F2B484542E23BCDDE2DBB")
    
public byte[] getOctets() 
    {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
        for (int i = 0; i != cs.length; i++) 
        {
            bs[i] = (byte) cs[i];
        }
        return bs;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.329 -0500", hash_original_method = "329E6E60BDC6BE9FAC4D8B36E2859F0E", hash_generated_method = "329E6E60BDC6BE9FAC4D8B36E2859F0E")
    
void encode(DEROutputStream out) 
        throws IOException 
    {
        out.writeEncoded(GENERAL_STRING, this.getOctets());
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.336 -0500", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "54F3A64DBCC65B097BA7A8E0BB1579E9")
    
public int hashCode() 
    {
        return this.getString().hashCode();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.339 -0500", hash_original_method = "790E2075BB1CC35320196C74CBC9C39A", hash_generated_method = "790E2075BB1CC35320196C74CBC9C39A")
    
boolean asn1Equals(DERObject o)
    {
        if (!(o instanceof DERGeneralString)) 
        {
            return false;
        }
        DERGeneralString s = (DERGeneralString) o;
        return this.getString().equals(s.getString());
    }
    
}

