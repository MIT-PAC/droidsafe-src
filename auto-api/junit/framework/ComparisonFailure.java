package junit.framework;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ComparisonFailure extends AssertionFailedError {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.633 -0400", hash_original_field = "BB4B57D7E956460E6D759FC7C2E6FDB6", hash_generated_field = "194DC4631B521844DC7E733F29E17760")

    private String fExpected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.633 -0400", hash_original_field = "872399F4BC16A5EACED0C95CD3A4F589", hash_generated_field = "D387207F706FEEB200179E2FB1A3B44E")

    private String fActual;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.634 -0400", hash_original_method = "7454800965A05A4B5CEDE9BB116D75F0", hash_generated_method = "84CB3F500EB81999B66F1C65182D9738")
    public  ComparisonFailure(String message, String expected, String actual) {
        super (message);
        fExpected= expected;
        fActual= actual;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //fExpected= expected;
        //fActual= actual;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.635 -0400", hash_original_method = "1EFB8D5295B5347F7A8CE202919A7B5C", hash_generated_method = "5597E54D3548E5BD3AA7009632FEA50E")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_459441410 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_32414385 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_459441410 = Assert.format(super.getMessage(), fExpected, fActual);
        int end;
        end = Math.min(fExpected.length(), fActual.length());
        int i;
        i = 0;
        {
            {
                boolean var15C9AED799E557CDAC29AD26D0BBB20D_16032090 = (fExpected.charAt(i) != fActual.charAt(i));
            } //End collapsed parenthetic
        } //End block
        int j;
        j = fExpected.length()-1;
        int k;
        k = fActual.length()-1;
        {
            {
                boolean varCD81FA2AAF574344A714AF6F6D239009_1504580091 = (fExpected.charAt(j) != fActual.charAt(k));
            } //End collapsed parenthetic
        } //End block
        String actual, expected;
        {
            expected= fExpected;
            actual= fActual;
        } //End block
        {
            expected= fExpected.substring(i, j+1);
            actual= fActual.substring(i, k+1);
            {
                expected= "..."+expected;
                actual= "..."+actual;
            } //End block
            {
                boolean var657EA45215951A44D98D539B11C537A2_1676079869 = (j < fExpected.length()-1);
                expected= expected+"...";
            } //End collapsed parenthetic
            {
                boolean varE8DEE487D1D3D00863549A17BD3F7CC4_969158185 = (k < fActual.length()-1);
                actual= actual+"...";
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_32414385 = Assert.format(super.getMessage(), expected, actual);
        String varA7E53CE21691AB073D9660D615818899_1274284309; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1274284309 = varB4EAC82CA7396A68D541C85D26508E83_459441410;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1274284309 = varB4EAC82CA7396A68D541C85D26508E83_32414385;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1274284309.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1274284309;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

