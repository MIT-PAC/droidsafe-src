package junit.framework;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ComparisonFailure extends AssertionFailedError {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.226 -0400", hash_original_field = "BB4B57D7E956460E6D759FC7C2E6FDB6", hash_generated_field = "194DC4631B521844DC7E733F29E17760")

    private String fExpected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.227 -0400", hash_original_field = "872399F4BC16A5EACED0C95CD3A4F589", hash_generated_field = "D387207F706FEEB200179E2FB1A3B44E")

    private String fActual;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.227 -0400", hash_original_method = "7454800965A05A4B5CEDE9BB116D75F0", hash_generated_method = "DAC7EBAB7B1F20E35BBDB9396400A80F")
    public  ComparisonFailure(String message, String expected, String actual) {
        super (message);
        addTaint(message.getTaint());
        fExpected= expected;
        fActual= actual;
        // ---------- Original Method ----------
        //fExpected= expected;
        //fActual= actual;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.228 -0400", hash_original_method = "1EFB8D5295B5347F7A8CE202919A7B5C", hash_generated_method = "6C47BADE488711B2C89E5E85D2E36D00")
    public String getMessage() {
        if(fExpected == null || fActual == null)        
        {
String varD64A67D7D5D7823A65708DE660105249_848764049 =         Assert.format(super.getMessage(), fExpected, fActual);
        varD64A67D7D5D7823A65708DE660105249_848764049.addTaint(taint);
        return varD64A67D7D5D7823A65708DE660105249_848764049;
        }
        int end = Math.min(fExpected.length(), fActual.length());
        int i = 0;
for(;i < end;i++)
        {
            if(fExpected.charAt(i) != fActual.charAt(i))            
            break;
        } //End block
        int j = fExpected.length()-1;
        int k = fActual.length()-1;
for(;k >= i && j >= i;k--,j--)
        {
            if(fExpected.charAt(j) != fActual.charAt(k))            
            break;
        } //End block
        String actual;
        String expected;
        if(j < i && k < i)        
        {
            expected= fExpected;
            actual= fActual;
        } //End block
        else
        {
            expected= fExpected.substring(i, j+1);
            actual= fActual.substring(i, k+1);
            if(i <= end && i > 0)            
            {
                expected= "..."+expected;
                actual= "..."+actual;
            } //End block
            if(j < fExpected.length()-1)            
            expected= expected+"...";
            if(k < fActual.length()-1)            
            actual= actual+"...";
        } //End block
String var1F5A835AA8B0791E81C10658E69A20BF_1918632045 =         Assert.format(super.getMessage(), expected, actual);
        var1F5A835AA8B0791E81C10658E69A20BF_1918632045.addTaint(taint);
        return var1F5A835AA8B0791E81C10658E69A20BF_1918632045;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

