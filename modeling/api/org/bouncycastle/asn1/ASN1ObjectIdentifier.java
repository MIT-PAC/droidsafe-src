package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ASN1ObjectIdentifier extends DERObjectIdentifier {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.415 -0500", hash_original_method = "5D809321835D0BA25C10E4492B1A0DC6", hash_generated_method = "4665652E2FE877E0070EA68356496488")
    
public ASN1ObjectIdentifier(String identifier)
    {
        super(identifier);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.418 -0500", hash_original_method = "EF822DF50E24A8FAE333A23CFFE3D191", hash_generated_method = "EF822DF50E24A8FAE333A23CFFE3D191")
    
ASN1ObjectIdentifier(byte[] bytes)
    {
        super(bytes);
    }

    /**
     * Return an OID that creates a branch under the current one.
     *
     * @param branchID node numbers for the new branch.
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.420 -0500", hash_original_method = "DFE7160E8E684D8D4AB128F02145CDAB", hash_generated_method = "0B925BD0C9CC8EC1BBB8E1FCE9A08FB2")
    
public ASN1ObjectIdentifier branch(String branchID)
    {
        return new ASN1ObjectIdentifier(getId() + "." + branchID);
    }
    
}

