package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.util.Strings;

public abstract class X509NameEntryConverter {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.224 -0400", hash_original_method = "895CB1F94322718A75CF3FC7407A7622", hash_generated_method = "895CB1F94322718A75CF3FC7407A7622")
    public X509NameEntryConverter ()
    {
        //Synthesized constructor
    }
    /**
     * Convert an inline encoded hex string rendition of an ASN.1
     * object back into its corresponding ASN.1 object.
     * 
     * @param str the hex encoded object
     * @param off the index at which the encoding starts
     * @return the decoded object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.842 -0500", hash_original_method = "0820E5B6790D0EF76EEAF699A8A71CD6", hash_generated_method = "B12D65C7B715CC71B06DD7953345660F")
    
protected DERObject convertHexEncoded(
        String  str,
        int     off)
        throws IOException
    {
        str = Strings.toLowerCase(str);
        byte[] data = new byte[(str.length() - off) / 2];
        for (int index = 0; index != data.length; index++)
        {
            char left = str.charAt((index * 2) + off);
            char right = str.charAt((index * 2) + off + 1);
            
            if (left < 'a')
            {
                data[index] = (byte)((left - '0') << 4);
            }
            else
            {
                data[index] = (byte)((left - 'a' + 10) << 4);
            }
            if (right < 'a')
            {
                data[index] |= (byte)(right - '0');
            }
            else
            {
                data[index] |= (byte)(right - 'a' + 10);
            }
        }

        ASN1InputStream aIn = new ASN1InputStream(data);
                                            
        return aIn.readObject();
    }
    
    /**
     * return true if the passed in String can be represented without
     * loss as a PrintableString, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.844 -0500", hash_original_method = "499FF8BD25CE956701C5B1F46FEEC51A", hash_generated_method = "FB6B49193A56B436EEBE084386601EFE")
    
protected boolean canBePrintable(
        String  str)
    {
        return DERPrintableString.isPrintableString(str);
    }
    
    /**
     * Convert the passed in String value into the appropriate ASN.1
     * encoded object.
     * 
     * @param oid the oid associated with the value in the DN.
     * @param value the value of the particular DN component.
     * @return the ASN.1 equivalent for the value.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.847 -0500", hash_original_method = "D0B42605F54F436BA6550A9164C86416", hash_generated_method = "0F05FF416A244E97C0B0AD580B10BB3B")
    
public abstract DERObject getConvertedValue(DERObjectIdentifier oid, String value);
    
}

