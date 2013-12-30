package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class FromParser extends AddressParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.144 -0500", hash_original_method = "959F9668B577E560A18D35872EBA8497", hash_generated_method = "DF129E064D80DD6A8B30715E246A8087")
    
public FromParser(String from) {
        super(from);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.147 -0500", hash_original_method = "CEE001D4136BA6038E80B22CA8F776D5", hash_generated_method = "E80F44F126E580BE7CA4EE573ECB23DE")
    
protected FromParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.149 -0500", hash_original_method = "090BCBCCA2A0D46A805C56D0690187FF", hash_generated_method = "D033270B6AE8A19F0E36352366DEA22E")
    
public SIPHeader parse() throws ParseException {

        From from = new From();

        this.lexer.match(TokenTypes.FROM);
        this.lexer.SPorHT();
        this.lexer.match(':');
        this.lexer.SPorHT();
        super.parse(from);
        this.lexer.match('\n');
        return from;
    }

    
}

