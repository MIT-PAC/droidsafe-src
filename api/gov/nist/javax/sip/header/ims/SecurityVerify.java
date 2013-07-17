package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;

public class SecurityVerify extends SecurityAgree implements SecurityVerifyHeader, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.484 -0400", hash_original_method = "EFF056AEE5121CFCE6CEB606B41C2105", hash_generated_method = "935DFFD4E3137451F48E9CD2120E6F2A")
    public  SecurityVerify() {
        super(SecurityVerifyHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.485 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "7573E3AF83167846055D79D2313B079B")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1462935368 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1462935368.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1462935368;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

