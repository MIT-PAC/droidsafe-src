package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public class FormatFlagsConversionMismatchException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.268 -0400", hash_original_field = "8FA14CDD754F91CC6554C9E71929CCE7", hash_generated_field = "30060080FF41A1FD21A71F3606BA90A8")

    private String f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.269 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private char c;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.269 -0400", hash_original_method = "23601B02BC801B28ADE07C396E4C34FF", hash_generated_method = "85CD4B7F28E08D8B666BFBE164887DF4")
    public  FormatFlagsConversionMismatchException(String f, char c) {
    if(f == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_896511251 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_896511251.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_896511251;
        } //End block
        this.f = f;
        this.c = c;
        // ---------- Original Method ----------
        //if (f == null) {
            //throw new NullPointerException();
        //}
        //this.f = f;
        //this.c = c;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.270 -0400", hash_original_method = "3582970EABB5B296536802E98213C512", hash_generated_method = "D3C85269D730606279F5540085BAA141")
    public String getFlags() {
String varABE3CFB53FE4A79F34CB25BC80BFD6E2_506279381 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_506279381.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_506279381;
        // ---------- Original Method ----------
        //return f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.271 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "E8F8E5D68BBC4F1265532209D1120BC6")
    public char getConversion() {
        char var4A8A08F09D37B73795649038408B5F33_932052600 = (c);
                char varA87DEB01C5F539E6BDA34829C8EF2368_254056850 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_254056850;
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.271 -0400", hash_original_method = "767287C022ACF72AAFFBED8242F4CC5C", hash_generated_method = "CC67C65914AE7D84978BB5BFDE9B6568")
    @Override
    public String getMessage() {
String var37755124A685A15B45C910E82B838DFB_2071540048 =         "%" + c + " does not support '" + f + "'";
        var37755124A685A15B45C910E82B838DFB_2071540048.addTaint(taint);
        return var37755124A685A15B45C910E82B838DFB_2071540048;
        // ---------- Original Method ----------
        //return "%" + c + " does not support '" + f + "'";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.271 -0400", hash_original_field = "1F0F21A332DEDA3F6DA0D475FFB6DF85", hash_generated_field = "7B2DE80EAB584F9CC96F84F00ED41767")

    private static final long serialVersionUID = 19120414L;
}

