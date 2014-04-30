package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Token {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.640 -0500", hash_original_field = "23C3E0283D4D235B339E995101067645", hash_generated_field = "C77B34F76A2CC5C947F29741403A7131")

    protected String tokenValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.643 -0500", hash_original_field = "11897B6FBEC133640CD512C597C6E8D2", hash_generated_field = "F0395CC17E558AE085EB3B981B512AD9")

    protected int tokenType;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.769 -0400", hash_original_method = "012AA2A69575899162813BAC8BEE7E0E", hash_generated_method = "012AA2A69575899162813BAC8BEE7E0E")
    public Token ()
    {
        //Synthesized constructor
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.646 -0500", hash_original_method = "F8E0993DCB6F03EA51553585BFE853D1", hash_generated_method = "533C8633E655E7579C5DD232FE33D589")
    
public String getTokenValue() {
        return this.tokenValue;
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.648 -0500", hash_original_method = "2E47E29049C2BF1025243EAE8896F2F1", hash_generated_method = "20EEA98441E03C0E3CC7D4750EB89469")
    
public int getTokenType() {
        return this.tokenType;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.650 -0500", hash_original_method = "C6D43B0C1DADE24AF5766A64C57BCE8F", hash_generated_method = "2702F52C02A299FAC089A21D2A5235E8")
    
public String toString() {
        return "tokenValue = " + tokenValue + "/tokenType = " + tokenType;
    }
    
}

