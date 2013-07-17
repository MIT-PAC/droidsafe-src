package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.util.Strings;
import java.io.IOException;

public abstract class X509NameEntryConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.224 -0400", hash_original_method = "895CB1F94322718A75CF3FC7407A7622", hash_generated_method = "895CB1F94322718A75CF3FC7407A7622")
    public X509NameEntryConverter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.226 -0400", hash_original_method = "0820E5B6790D0EF76EEAF699A8A71CD6", hash_generated_method = "8477775AC7080D7C945B87A2E3A8E21A")
    protected DERObject convertHexEncoded(
        String  str,
        int     off) throws IOException {
        addTaint(off);
        addTaint(str.getTaint());
        str = Strings.toLowerCase(str);
        byte[] data = new byte[(str.length() - off) / 2];
for(int index = 0;index != data.length;index++)
        {
            char left = str.charAt((index * 2) + off);
            char right = str.charAt((index * 2) + off + 1);
            if(left < 'a')            
            {
                data[index] = (byte)((left - '0') << 4);
            } //End block
            else
            {
                data[index] = (byte)((left - 'a' + 10) << 4);
            } //End block
            if(right < 'a')            
            {
                data[index] |= (byte)(right - '0');
            } //End block
            else
            {
                data[index] |= (byte)(right - 'a' + 10);
            } //End block
        } //End block
        ASN1InputStream aIn = new ASN1InputStream(data);
DERObject var744C7B728C1BF7AC9370DA8D8B9598D6_1588751565 =         aIn.readObject();
        var744C7B728C1BF7AC9370DA8D8B9598D6_1588751565.addTaint(taint);
        return var744C7B728C1BF7AC9370DA8D8B9598D6_1588751565;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.226 -0400", hash_original_method = "499FF8BD25CE956701C5B1F46FEEC51A", hash_generated_method = "36BB837EE06C3E79A237C8D0C2E4C78C")
    protected boolean canBePrintable(
        String  str) {
        addTaint(str.getTaint());
        boolean varF6C770A90D6BB561B31334BDADDD9A35_1079507882 = (DERPrintableString.isPrintableString(str));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1920306047 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1920306047;
        // ---------- Original Method ----------
        //return DERPrintableString.isPrintableString(str);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract DERObject getConvertedValue(DERObjectIdentifier oid, String value);

    
}

