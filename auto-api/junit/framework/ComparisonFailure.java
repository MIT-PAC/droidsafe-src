package junit.framework;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ComparisonFailure extends AssertionFailedError {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.106 -0400", hash_original_field = "BB4B57D7E956460E6D759FC7C2E6FDB6", hash_generated_field = "194DC4631B521844DC7E733F29E17760")

    private String fExpected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.106 -0400", hash_original_field = "872399F4BC16A5EACED0C95CD3A4F589", hash_generated_field = "D387207F706FEEB200179E2FB1A3B44E")

    private String fActual;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.106 -0400", hash_original_method = "7454800965A05A4B5CEDE9BB116D75F0", hash_generated_method = "84CB3F500EB81999B66F1C65182D9738")
    public  ComparisonFailure(String message, String expected, String actual) {
        super (message);
        fExpected= expected;
        fActual= actual;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //fExpected= expected;
        //fActual= actual;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.107 -0400", hash_original_method = "1EFB8D5295B5347F7A8CE202919A7B5C", hash_generated_method = "859786B2DEF9FD815FF10DE3920B3B30")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1659057444 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2041521029 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1659057444 = Assert.format(super.getMessage(), fExpected, fActual);
        int end = Math.min(fExpected.length(), fActual.length());
        int i = 0;
        {
            {
                boolean var15C9AED799E557CDAC29AD26D0BBB20D_1812002371 = (fExpected.charAt(i) != fActual.charAt(i));
            } //End collapsed parenthetic
        } //End block
        int j = fExpected.length()-1;
        int k = fActual.length()-1;
        {
            {
                boolean varCD81FA2AAF574344A714AF6F6D239009_65278260 = (fExpected.charAt(j) != fActual.charAt(k));
            } //End collapsed parenthetic
        } //End block
        String actual;
        String expected;
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
                boolean var657EA45215951A44D98D539B11C537A2_1364632461 = (j < fExpected.length()-1);
                expected= expected+"...";
            } //End collapsed parenthetic
            {
                boolean varE8DEE487D1D3D00863549A17BD3F7CC4_1666065305 = (k < fActual.length()-1);
                actual= actual+"...";
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2041521029 = Assert.format(super.getMessage(), expected, actual);
        String varA7E53CE21691AB073D9660D615818899_1926046335; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1926046335 = varB4EAC82CA7396A68D541C85D26508E83_1659057444;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1926046335 = varB4EAC82CA7396A68D541C85D26508E83_2041521029;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1926046335.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1926046335;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

