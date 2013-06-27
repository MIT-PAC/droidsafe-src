package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.util.Strings;
import java.io.IOException;

public abstract class X509NameEntryConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.258 -0400", hash_original_method = "895CB1F94322718A75CF3FC7407A7622", hash_generated_method = "895CB1F94322718A75CF3FC7407A7622")
    public X509NameEntryConverter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.270 -0400", hash_original_method = "0820E5B6790D0EF76EEAF699A8A71CD6", hash_generated_method = "204D8000B84E26DAA591774CEF0D95FC")
    protected DERObject convertHexEncoded(
        String  str,
        int     off) throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_591924584 = null; //Variable for return #1
        str = Strings.toLowerCase(str);
        byte[] data;
        data = new byte[(str.length() - off) / 2];
        {
            int index;
            index = 0;
            {
                char left;
                left = str.charAt((index * 2) + off);
                char right;
                right = str.charAt((index * 2) + off + 1);
                {
                    data[index] = (byte)((left - '0') << 4);
                } //End block
                {
                    data[index] = (byte)((left - 'a' + 10) << 4);
                } //End block
                {
                    data[index] |= (byte)(right - '0');
                } //End block
                {
                    data[index] |= (byte)(right - 'a' + 10);
                } //End block
            } //End block
        } //End collapsed parenthetic
        ASN1InputStream aIn;
        aIn = new ASN1InputStream(data);
        varB4EAC82CA7396A68D541C85D26508E83_591924584 = aIn.readObject();
        addTaint(str.getTaint());
        addTaint(off);
        varB4EAC82CA7396A68D541C85D26508E83_591924584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_591924584;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.271 -0400", hash_original_method = "499FF8BD25CE956701C5B1F46FEEC51A", hash_generated_method = "8065471F1493EF20765438E483349A5D")
    protected boolean canBePrintable(
        String  str) {
        boolean varE4B9094FDD502E0BF184965135189B5D_1650707977 = (DERPrintableString.isPrintableString(str));
        addTaint(str.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1872546820 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1872546820;
        // ---------- Original Method ----------
        //return DERPrintableString.isPrintableString(str);
    }

    
    public abstract DERObject getConvertedValue(DERObjectIdentifier oid, String value);

    
}

