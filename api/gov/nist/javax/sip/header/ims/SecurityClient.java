package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;

public class SecurityClient extends SecurityAgree implements SecurityClientHeader, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.194 -0400", hash_original_method = "2DC95595D33B318EDF43269B772F4B7E", hash_generated_method = "9FEC82225A678A3ED2A2EA564F83724D")
    public  SecurityClient() {
        super(SecurityClientHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.194 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "1E1185DBC7BAFC8D4792CCFA5C9F7FB3")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1539629631 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1539629631.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1539629631;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

