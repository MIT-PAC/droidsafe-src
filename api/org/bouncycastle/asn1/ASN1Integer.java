package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;



public class ASN1Integer extends DERInteger {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.613 -0500", hash_original_method = "613C01CE307AF3B490E97733AD3FE791", hash_generated_method = "613C01CE307AF3B490E97733AD3FE791")
    ASN1Integer(byte[] bytes)
    {
        super(bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.614 -0500", hash_original_method = "CB189D129CFECCC017D2178A0D362A4E", hash_generated_method = "A54C808ECDFD51FFF97BE5F456F6474F")
    public ASN1Integer(BigInteger value)
    {
        super(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.615 -0500", hash_original_method = "DB40B6D8EC54F98D809A693D20FD592A", hash_generated_method = "489794C0EF5847BA66B577BA4FF57A1F")
    public ASN1Integer(int value)
    {
        super(value);
    }

    
}

