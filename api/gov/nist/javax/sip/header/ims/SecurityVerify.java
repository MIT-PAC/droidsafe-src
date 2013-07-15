package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;

public class SecurityVerify extends SecurityAgree implements SecurityVerifyHeader, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.209 -0400", hash_original_method = "EFF056AEE5121CFCE6CEB606B41C2105", hash_generated_method = "935DFFD4E3137451F48E9CD2120E6F2A")
    public  SecurityVerify() {
        super(SecurityVerifyHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.209 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "4E8BF9B70003B5DC97BA648592E1AFCA")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_955346403 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_955346403.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_955346403;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

