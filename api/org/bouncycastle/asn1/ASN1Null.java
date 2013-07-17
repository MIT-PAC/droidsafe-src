package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public abstract class ASN1Null extends ASN1Object {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.689 -0400", hash_original_method = "D0FE59B1A9D3F66BFB745D7E961EAD28", hash_generated_method = "14E33D4578D52777E859D4C899DF0B5C")
      ASN1Null() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.689 -0400", hash_original_method = "8B33772CC706A3F76B2A9FE6D8E11F7C", hash_generated_method = "D2C9B667B31F1A7A5991DB8CE1B3B445")
    public int hashCode() {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1278341582 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229602694 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229602694;
        // ---------- Original Method ----------
        //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.690 -0400", hash_original_method = "7109287BD38944677651878D40817EF4", hash_generated_method = "72DC53859821F6018815B95CFC5EED81")
     boolean asn1Equals(
        DERObject o) {
        addTaint(o.getTaint());
        if(!(o instanceof ASN1Null))        
        {
            boolean var68934A3E9455FA72420237EB05902327_571619629 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181238875 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_181238875;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1993758301 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013800811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013800811;
        // ---------- Original Method ----------
        //if (!(o instanceof ASN1Null))
        //{
            //return false;
        //}
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    abstract void encode(DEROutputStream out)
        throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.690 -0400", hash_original_method = "BBD03FB924B892CEE23A9F439923567F", hash_generated_method = "55FEEE854E7CAEF2A95E1AF98704EE96")
    public String toString() {
String var33D29D752C3932DEA56761DD803BA922_963726459 =         "NULL";
        var33D29D752C3932DEA56761DD803BA922_963726459.addTaint(taint);
        return var33D29D752C3932DEA56761DD803BA922_963726459;
        // ---------- Original Method ----------
        //return "NULL";
    }

    
}

