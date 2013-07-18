package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

import droidsafe.annotations.DSGenerator;

public class SecurityClient extends SecurityAgree implements SecurityClientHeader, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.454 -0400", hash_original_method = "2DC95595D33B318EDF43269B772F4B7E", hash_generated_method = "9FEC82225A678A3ED2A2EA564F83724D")
    public  SecurityClient() {
        super(SecurityClientHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.455 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "0839A59636F98EA831ADA7932182705B")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_530936546 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_530936546.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_530936546;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

