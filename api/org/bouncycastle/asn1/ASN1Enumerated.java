package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

public class ASN1Enumerated extends DEREnumerated {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.538 -0400", hash_original_method = "21C60C1A5AA0865B59F345279A6EA8BF", hash_generated_method = "BDC61776DDBF1B8B80A4007221CFF0B9")
      ASN1Enumerated(byte[] bytes) {
        super(bytes);
        addTaint(bytes[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.538 -0400", hash_original_method = "7B433ECBA08A5BBD92F98E49D15E8F41", hash_generated_method = "2419982FDCDBD727B43582462A9FFF90")
    public  ASN1Enumerated(BigInteger value) {
        super(value);
        addTaint(value.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.539 -0400", hash_original_method = "AB030E25D9BC2A8CAF201556A98FD5C6", hash_generated_method = "91D1C94BD409E230DB9487E991D23405")
    public  ASN1Enumerated(int value) {
        super(value);
        addTaint(value);
        
    }

    
}

