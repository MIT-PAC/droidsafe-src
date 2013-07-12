package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ASN1ObjectIdentifier extends DERObjectIdentifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.605 -0400", hash_original_method = "5D809321835D0BA25C10E4492B1A0DC6", hash_generated_method = "DAACAE5FD40E4B46E7C6A20CFC027519")
    public  ASN1ObjectIdentifier(String identifier) {
        super(identifier);
        addTaint(identifier.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.606 -0400", hash_original_method = "EF822DF50E24A8FAE333A23CFFE3D191", hash_generated_method = "800270272E59DBE5A948B225A5E9BCB1")
      ASN1ObjectIdentifier(byte[] bytes) {
        super(bytes);
        addTaint(bytes[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.606 -0400", hash_original_method = "DFE7160E8E684D8D4AB128F02145CDAB", hash_generated_method = "C9B3A98C1DB1F6AF941CB708F20195DF")
    public ASN1ObjectIdentifier branch(String branchID) {
        addTaint(branchID.getTaint());
ASN1ObjectIdentifier varC7F61766DA32F36DBFEE874FD403E015_1395532900 =         new ASN1ObjectIdentifier(getId() + "." + branchID);
        varC7F61766DA32F36DBFEE874FD403E015_1395532900.addTaint(taint);
        return varC7F61766DA32F36DBFEE874FD403E015_1395532900;
        
        
    }

    
}

