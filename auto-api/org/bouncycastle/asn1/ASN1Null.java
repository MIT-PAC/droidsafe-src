package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class ASN1Null extends ASN1Object {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.683 -0400", hash_original_method = "D0FE59B1A9D3F66BFB745D7E961EAD28", hash_generated_method = "14E33D4578D52777E859D4C899DF0B5C")
      ASN1Null() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.684 -0400", hash_original_method = "8B33772CC706A3F76B2A9FE6D8E11F7C", hash_generated_method = "C1E8ED3DE5E9F6CFCD91FEBDB4C257F3")
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751268357 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751268357;
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.685 -0400", hash_original_method = "7109287BD38944677651878D40817EF4", hash_generated_method = "933F0125B2C0F1CD9D1CB71C889FDDB3")
     boolean asn1Equals(
        DERObject o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530411609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_530411609;
        // ---------- Original Method ----------
        //if (!(o instanceof ASN1Null))
        //{
            //return false;
        //}
        //return true;
    }

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.685 -0400", hash_original_method = "BBD03FB924B892CEE23A9F439923567F", hash_generated_method = "80E14486C8E87757310F008C1079C47D")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1870908153 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1870908153 = "NULL";
        varB4EAC82CA7396A68D541C85D26508E83_1870908153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1870908153;
        // ---------- Original Method ----------
        //return "NULL";
    }

    
}

