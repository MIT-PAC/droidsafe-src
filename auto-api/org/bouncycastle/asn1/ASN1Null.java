package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class ASN1Null extends ASN1Object {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.558 -0400", hash_original_method = "D0FE59B1A9D3F66BFB745D7E961EAD28", hash_generated_method = "14E33D4578D52777E859D4C899DF0B5C")
      ASN1Null() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.558 -0400", hash_original_method = "8B33772CC706A3F76B2A9FE6D8E11F7C", hash_generated_method = "31941988DA6205C3741AC97D7863C8F5")
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_451162605 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_451162605;
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.558 -0400", hash_original_method = "7109287BD38944677651878D40817EF4", hash_generated_method = "B089EBA6B311E8BC5B0B249A693FDC23")
     boolean asn1Equals(
        DERObject o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1172874897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1172874897;
        // ---------- Original Method ----------
        //if (!(o instanceof ASN1Null))
        //{
            //return false;
        //}
        //return true;
    }

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.559 -0400", hash_original_method = "BBD03FB924B892CEE23A9F439923567F", hash_generated_method = "993D0BDB244EC99F4EB8D5699B8F5B63")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_635484572 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_635484572 = "NULL";
        varB4EAC82CA7396A68D541C85D26508E83_635484572.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_635484572;
        // ---------- Original Method ----------
        //return "NULL";
    }

    
}

