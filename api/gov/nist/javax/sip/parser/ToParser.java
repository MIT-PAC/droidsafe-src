package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.To;

import java.text.ParseException;





public class ToParser extends AddressParametersParser {

    /**
     * Creates new ToParser
     * @param to String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.517 -0500", hash_original_method = "C8F2641055D76DBC203D7F98D786CB89", hash_generated_method = "6AB1917E5D38181612CA9773841B44C8")
    
public ToParser(String to) {
        super(to);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.520 -0500", hash_original_method = "F0F7A8E65FEB47CEDC2639617287C00D", hash_generated_method = "98DD0BD65F935E86F6F5C6B42325D778")
    
protected ToParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.523 -0500", hash_original_method = "9D8B9A06C15E6D7FEEEC143ED65417C6", hash_generated_method = "56B203DDA03B91EF1A4851FA40EEFA46")
    
public SIPHeader parse() throws ParseException {

        headerName(TokenTypes.TO);
        To to = new To();
        super.parse(to);
        this.lexer.match('\n');        
        return to;
    }

    
}

