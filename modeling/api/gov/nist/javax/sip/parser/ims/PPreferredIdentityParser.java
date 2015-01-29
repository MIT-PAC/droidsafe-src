package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PPreferredIdentity;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PPreferredIdentityParser extends AddressParametersParser implements TokenTypes {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.039 -0500", hash_original_method = "8ED0FE4D0D4A9A77E1D41482CCFB6634", hash_generated_method = "2306C5CBD5443CF536BD6B749689E57F")
    
public PPreferredIdentityParser(String preferredIdentity) {
        super(preferredIdentity);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.042 -0500", hash_original_method = "2C53019D290466621D2FD15449F6C503", hash_generated_method = "6123A25EEE5F74D91D8175CE78424B12")
    
protected PPreferredIdentityParser(Lexer lexer) {
        super(lexer);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.044 -0500", hash_original_method = "CA1397CFDA33B56E4743CDCAB79EF328", hash_generated_method = "C869D00DA2D3BAD085666A18D8F4D8E4")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("PreferredIdentityParser.parse");

        try {
            this.lexer.match(TokenTypes.P_PREFERRED_IDENTITY);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();

            PPreferredIdentity p = new PPreferredIdentity();
            super.parse( p );
            return p;
        } finally {
            if (debug)
                dbg_leave("PreferredIdentityParser.parse");
            }


    }

    
}

