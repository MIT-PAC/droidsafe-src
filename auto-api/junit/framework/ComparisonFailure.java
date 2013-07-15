package junit.framework;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.107 -0400", hash_original_method = "1EFB8D5295B5347F7A8CE202919A7B5C", hash_generated_method = "859786B2DEF9FD815FF10DE3920B3B30")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1659057444 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2041521029 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1659057444 = Assert.format(super.getMessage(), fExpected, fActual);
        int end = Math.min(fExpected.length(), fActual.length());
        int i = 0;
        {
            {
                boolean var15C9AED799E557CDAC29AD26D0BBB20D_1812002371 = (fExpected.charAt(i) != fActual.charAt(i));
            } 
        } 
        int j = fExpected.length()-1;
        int k = fActual.length()-1;
        {
            {
                boolean varCD81FA2AAF574344A714AF6F6D239009_65278260 = (fExpected.charAt(j) != fActual.charAt(k));
            } 
        } 
        String actual;
        String expected;
        {
            expected= fExpected;
            actual= fActual;
        } 
        {
            expected= fExpected.substring(i, j+1);
            actual= fActual.substring(i, k+1);
            {
                expected= "..."+expected;
                actual= "..."+actual;
            } 
            {
                boolean var657EA45215951A44D98D539B11C537A2_1364632461 = (j < fExpected.length()-1);
                expected= expected+"...";
            } 
            {
                boolean varE8DEE487D1D3D00863549A17BD3F7CC4_1666065305 = (k < fActual.length()-1);
                actual= actual+"...";
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2041521029 = Assert.format(super.getMessage(), expected, actual);
        String varA7E53CE21691AB073D9660D615818899_1926046335; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1926046335 = varB4EAC82CA7396A68D541C85D26508E83_1659057444;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1926046335 = varB4EAC82CA7396A68D541C85D26508E83_2041521029;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1926046335.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1926046335;
        
        
    }

    
}

