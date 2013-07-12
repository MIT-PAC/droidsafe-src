package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Token {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.807 -0400", hash_original_field = "6128148BC7C7ABD76B32789D4962F7E4", hash_generated_field = "C77B34F76A2CC5C947F29741403A7131")

    protected String tokenValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.807 -0400", hash_original_field = "8AD8E5E81876016A6C09C70732B348B6", hash_generated_field = "F0395CC17E558AE085EB3B981B512AD9")

    protected int tokenType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.807 -0400", hash_original_method = "012AA2A69575899162813BAC8BEE7E0E", hash_generated_method = "012AA2A69575899162813BAC8BEE7E0E")
    public Token ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.808 -0400", hash_original_method = "F8E0993DCB6F03EA51553585BFE853D1", hash_generated_method = "504804A928DAFE08C02A7205F03B1943")
    public String getTokenValue() {
String var0600CCE74E82F278073532E200D26585_232309637 =         this.tokenValue;
        var0600CCE74E82F278073532E200D26585_232309637.addTaint(taint);
        return var0600CCE74E82F278073532E200D26585_232309637;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.808 -0400", hash_original_method = "2E47E29049C2BF1025243EAE8896F2F1", hash_generated_method = "63EB6B41FEA17B294AB38EC3BB2231AD")
    public int getTokenType() {
        int var911E338A08566519078DB8EFCFA85416_1386009461 = (this.tokenType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992838030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992838030;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.808 -0400", hash_original_method = "C6D43B0C1DADE24AF5766A64C57BCE8F", hash_generated_method = "ED6660656B44BDE56F6324DCE1E6F66E")
    public String toString() {
String var64066EF1C65CB8E05B04CAAD03F9ED81_2082748451 =         "tokenValue = " + tokenValue + "/tokenType = " + tokenType;
        var64066EF1C65CB8E05B04CAAD03F9ED81_2082748451.addTaint(taint);
        return var64066EF1C65CB8E05B04CAAD03F9ED81_2082748451;
        
        
    }

    
}

