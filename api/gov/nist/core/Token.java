package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Token {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.769 -0400", hash_original_field = "6128148BC7C7ABD76B32789D4962F7E4", hash_generated_field = "C77B34F76A2CC5C947F29741403A7131")

    protected String tokenValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.769 -0400", hash_original_field = "8AD8E5E81876016A6C09C70732B348B6", hash_generated_field = "F0395CC17E558AE085EB3B981B512AD9")

    protected int tokenType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.769 -0400", hash_original_method = "012AA2A69575899162813BAC8BEE7E0E", hash_generated_method = "012AA2A69575899162813BAC8BEE7E0E")
    public Token ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.769 -0400", hash_original_method = "F8E0993DCB6F03EA51553585BFE853D1", hash_generated_method = "66B06FB06E7F41CAEDBBB26C9D238D84")
    public String getTokenValue() {
String var0600CCE74E82F278073532E200D26585_1816704663 =         this.tokenValue;
        var0600CCE74E82F278073532E200D26585_1816704663.addTaint(taint);
        return var0600CCE74E82F278073532E200D26585_1816704663;
        // ---------- Original Method ----------
        //return this.tokenValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.769 -0400", hash_original_method = "2E47E29049C2BF1025243EAE8896F2F1", hash_generated_method = "4EDF82FBCF1B2646A6E30D59F6E729A4")
    public int getTokenType() {
        int var911E338A08566519078DB8EFCFA85416_1079724165 = (this.tokenType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342746870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342746870;
        // ---------- Original Method ----------
        //return this.tokenType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.770 -0400", hash_original_method = "C6D43B0C1DADE24AF5766A64C57BCE8F", hash_generated_method = "C5CC2A2F9FA904582A5C10558BC8931F")
    public String toString() {
String var64066EF1C65CB8E05B04CAAD03F9ED81_1981245734 =         "tokenValue = " + tokenValue + "/tokenType = " + tokenType;
        var64066EF1C65CB8E05B04CAAD03F9ED81_1981245734.addTaint(taint);
        return var64066EF1C65CB8E05B04CAAD03F9ED81_1981245734;
        // ---------- Original Method ----------
        //return "tokenValue = " + tokenValue + "/tokenType = " + tokenType;
    }

    
}

