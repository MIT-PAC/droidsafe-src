package junit.framework;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ComparisonFailure extends AssertionFailedError {
    private String fExpected;
    private String fActual;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.418 -0400", hash_original_method = "7454800965A05A4B5CEDE9BB116D75F0", hash_generated_method = "399560AEBAAB0FF8AEF07FF93DD8F2F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComparisonFailure(String message, String expected, String actual) {
        super (message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(expected);
        dsTaint.addTaint(actual);
        // ---------- Original Method ----------
        //fExpected= expected;
        //fActual= actual;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.421 -0400", hash_original_method = "1EFB8D5295B5347F7A8CE202919A7B5C", hash_generated_method = "20DA599651F60037AE4F7E1C5CDFAC74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMessage() {
        String var7F4C0EB3F57248C82CA033570A386280_225485542 = (Assert.format(super.getMessage(), fExpected, fActual));
        int end;
        end = Math.min(fExpected.length(), fActual.length());
        int i;
        i = 0;
        {
            {
                boolean var15C9AED799E557CDAC29AD26D0BBB20D_1687058069 = (fExpected.charAt(i) != fActual.charAt(i));
            } //End collapsed parenthetic
        } //End block
        int j;
        j = fExpected.length()-1;
        int k;
        k = fActual.length()-1;
        {
            {
                boolean varCD81FA2AAF574344A714AF6F6D239009_270827423 = (fExpected.charAt(j) != fActual.charAt(k));
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
                boolean var657EA45215951A44D98D539B11C537A2_2018119496 = (j < fExpected.length()-1);
                expected= expected+"...";
            } //End collapsed parenthetic
            {
                boolean varE8DEE487D1D3D00863549A17BD3F7CC4_1386682535 = (k < fActual.length()-1);
                actual= actual+"...";
            } //End collapsed parenthetic
        } //End block
        String varCD6DFFA4D348B9EA82B084A0FE1B0336_201413757 = (Assert.format(super.getMessage(), expected, actual));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

