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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.214 -0400", hash_original_method = "895CB1F94322718A75CF3FC7407A7622", hash_generated_method = "895CB1F94322718A75CF3FC7407A7622")
    public X509NameEntryConverter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.215 -0400", hash_original_method = "0820E5B6790D0EF76EEAF699A8A71CD6", hash_generated_method = "981ACBF21402C8CCDC46E49986CF78CF")
    protected DERObject convertHexEncoded(
        String  str,
        int     off) throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_492139827 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_492139827 = aIn.readObject();
        addTaint(str.getTaint());
        addTaint(off);
        varB4EAC82CA7396A68D541C85D26508E83_492139827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_492139827;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.215 -0400", hash_original_method = "499FF8BD25CE956701C5B1F46FEEC51A", hash_generated_method = "96D4E27988371013C3B88DE26E8AE7F6")
    protected boolean canBePrintable(
        String  str) {
        boolean varE4B9094FDD502E0BF184965135189B5D_1002111993 = (DERPrintableString.isPrintableString(str));
        addTaint(str.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1185851904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1185851904;
        // ---------- Original Method ----------
        //return DERPrintableString.isPrintableString(str);
    }

    
    public abstract DERObject getConvertedValue(DERObjectIdentifier oid, String value);

    
}

