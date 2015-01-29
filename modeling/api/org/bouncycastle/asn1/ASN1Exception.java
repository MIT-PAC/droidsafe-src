package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class ASN1Exception extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.887 -0500", hash_original_field = "E65D4B046C7E75D4305AF1275FC1F72B", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.890 -0500", hash_original_method = "723A1DBA8406751CA0BE121F0D1A9151", hash_generated_method = "723A1DBA8406751CA0BE121F0D1A9151")
    
ASN1Exception(String message)
    {
        super(message);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.892 -0500", hash_original_method = "D17952479D481E219D9ED9BCF5D089F2", hash_generated_method = "D17952479D481E219D9ED9BCF5D089F2")
    
ASN1Exception(String message, Throwable cause)
    {
        super(message);
        this.cause = cause;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.894 -0500", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "7216169927F14A6BA3457BBD72FD53B3")
    
public Throwable getCause()
    {
        return cause;
    }
    
}

