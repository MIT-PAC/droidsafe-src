package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

public class ASN1ObjectIdentifier extends DERObjectIdentifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.706 -0400", hash_original_method = "5D809321835D0BA25C10E4492B1A0DC6", hash_generated_method = "DAACAE5FD40E4B46E7C6A20CFC027519")
    public  ASN1ObjectIdentifier(String identifier) {
        super(identifier);
        addTaint(identifier.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.707 -0400", hash_original_method = "EF822DF50E24A8FAE333A23CFFE3D191", hash_generated_method = "800270272E59DBE5A948B225A5E9BCB1")
      ASN1ObjectIdentifier(byte[] bytes) {
        super(bytes);
        addTaint(bytes[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.708 -0400", hash_original_method = "DFE7160E8E684D8D4AB128F02145CDAB", hash_generated_method = "16F15444E3E9F2ABD2A6076C32CABD42")
    public ASN1ObjectIdentifier branch(String branchID) {
        addTaint(branchID.getTaint());
ASN1ObjectIdentifier varC7F61766DA32F36DBFEE874FD403E015_1021939832 =         new ASN1ObjectIdentifier(getId() + "." + branchID);
        varC7F61766DA32F36DBFEE874FD403E015_1021939832.addTaint(taint);
        return varC7F61766DA32F36DBFEE874FD403E015_1021939832;
        // ---------- Original Method ----------
        //return new ASN1ObjectIdentifier(getId() + "." + branchID);
    }

    
}

