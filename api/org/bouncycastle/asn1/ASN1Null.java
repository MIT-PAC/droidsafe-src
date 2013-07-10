package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public abstract class ASN1Null extends ASN1Object {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.904 -0400", hash_original_method = "D0FE59B1A9D3F66BFB745D7E961EAD28", hash_generated_method = "14E33D4578D52777E859D4C899DF0B5C")
      ASN1Null() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.905 -0400", hash_original_method = "8B33772CC706A3F76B2A9FE6D8E11F7C", hash_generated_method = "25414A0AAD01024AD7CD107963745B14")
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336430895 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336430895;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.905 -0400", hash_original_method = "7109287BD38944677651878D40817EF4", hash_generated_method = "AE6072F712C02B33B867CE88C833591A")
     boolean asn1Equals(
        DERObject o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1095114113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1095114113;
        
        
        
            
        
        
    }

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.905 -0400", hash_original_method = "BBD03FB924B892CEE23A9F439923567F", hash_generated_method = "B478C0BB2E2A10F710228B2991AAF1A4")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_921908257 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_921908257 = "NULL";
        varB4EAC82CA7396A68D541C85D26508E83_921908257.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_921908257;
        
        
    }

    
}

