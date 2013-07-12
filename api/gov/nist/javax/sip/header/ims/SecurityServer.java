package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;

public class SecurityServer extends SecurityAgree implements SecurityServerHeader, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.200 -0400", hash_original_method = "33339D36120DC8E0BA97A29C8E334060", hash_generated_method = "6B6F3D712D088254BBF54C8DDD3A6787")
    public  SecurityServer() {
        super(SecurityServerHeader.NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.200 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "CA689BE5FA62C56088D5898730522559")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_398229742 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_398229742.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_398229742;
        
        
    }

    
}

