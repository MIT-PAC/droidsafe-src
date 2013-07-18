package java.util;

// Droidsafe Imports
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class FormatFlagsConversionMismatchException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.916 -0400", hash_original_field = "8FA14CDD754F91CC6554C9E71929CCE7", hash_generated_field = "30060080FF41A1FD21A71F3606BA90A8")

    private String f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.917 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "1C2A715F26687AFA5A80889E5E367C56")

    private char c;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.918 -0400", hash_original_method = "23601B02BC801B28ADE07C396E4C34FF", hash_generated_method = "5CB148B7EA562562C47959962F8109B6")
    public  FormatFlagsConversionMismatchException(String f, char c) {
        if(f == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1477220177 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1477220177.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1477220177;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.918 -0400", hash_original_method = "3582970EABB5B296536802E98213C512", hash_generated_method = "08E0F956FACE7F340A0435E62EE906B0")
    public String getFlags() {
String varABE3CFB53FE4A79F34CB25BC80BFD6E2_1743127822 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_1743127822.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1743127822;
        // ---------- Original Method ----------
        //return f;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.918 -0400", hash_original_method = "FF899ECAAB1B8C040FEF5324FAB8D93B", hash_generated_method = "8C2C298EEE8BBC2A812BA71980554AD5")
    public char getConversion() {
        char var4A8A08F09D37B73795649038408B5F33_224100456 = (c);
                char varA87DEB01C5F539E6BDA34829C8EF2368_2015516383 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2015516383;
        // ---------- Original Method ----------
        //return c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.919 -0400", hash_original_method = "767287C022ACF72AAFFBED8242F4CC5C", hash_generated_method = "307C58FA4973CD65788B4B79F751FB37")
    @Override
    public String getMessage() {
String var37755124A685A15B45C910E82B838DFB_1337993535 =         "%" + c + " does not support '" + f + "'";
        var37755124A685A15B45C910E82B838DFB_1337993535.addTaint(taint);
        return var37755124A685A15B45C910E82B838DFB_1337993535;
        // ---------- Original Method ----------
        //return "%" + c + " does not support '" + f + "'";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.919 -0400", hash_original_field = "1F0F21A332DEDA3F6DA0D475FFB6DF85", hash_generated_field = "7B2DE80EAB584F9CC96F84F00ED41767")

    private static final long serialVersionUID = 19120414L;
}

