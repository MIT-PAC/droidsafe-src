package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class DERNull extends ASN1Null {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.626 -0500", hash_original_field = "9DCC5709B6FABB0499927A3054EF1968", hash_generated_field = "BCDA123C54265156D82C94A2B76E09D3")

    public static final DERNull INSTANCE = new DERNull();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.628 -0500", hash_original_field = "7455396CE9CE8A3063FA0F4F79E212A8", hash_generated_field = "934335CBA6DEFFFB24BA758BD29A9D23")

    private static final byte[]  zeroBytes = new byte[0];
    // END android-changed

    // BEGIN android-changed
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.631 -0500", hash_original_method = "99B54E5156DA58D37DF99A37E5693124", hash_generated_method = "0320D726E6AAAD1B47BECB90C90AD692")
    
protected DERNull()
    // END android-changed
    {
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.633 -0500", hash_original_method = "ACDC3B7B82E2509D0E7268C448CC95AD", hash_generated_method = "ACDC3B7B82E2509D0E7268C448CC95AD")
    
void encode(
        DEROutputStream  out)
        throws IOException
    {
        out.writeEncoded(NULL, zeroBytes);
    }
}

