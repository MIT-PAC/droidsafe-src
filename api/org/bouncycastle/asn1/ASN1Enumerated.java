package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

public class ASN1Enumerated extends DEREnumerated {
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.662 -0500", hash_original_method = "21C60C1A5AA0865B59F345279A6EA8BF", hash_generated_method = "21C60C1A5AA0865B59F345279A6EA8BF")
    
ASN1Enumerated(byte[] bytes)
    {
        super(bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.664 -0500", hash_original_method = "7B433ECBA08A5BBD92F98E49D15E8F41", hash_generated_method = "9B7A58266A5BDDB476408BED9A43C65B")
    
public ASN1Enumerated(BigInteger value)
    {
        super(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.667 -0500", hash_original_method = "AB030E25D9BC2A8CAF201556A98FD5C6", hash_generated_method = "4D767F2CD9171820E4EF4506D6279756")
    
public ASN1Enumerated(int value)
    {
        super(value);
    }
    
}

