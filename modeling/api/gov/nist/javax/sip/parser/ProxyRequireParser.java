package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.ProxyRequire;
import gov.nist.javax.sip.header.ProxyRequireList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ProxyRequireParser extends HeaderParser {

    /**
     * Creates a new instance of ProxyRequireParser
     * @param require the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.436 -0500", hash_original_method = "5FB5567CF156CEA2F5335691822C90DD", hash_generated_method = "B368D6282366BEBE3AE8D6F6FEDFEAE5")
    
public ProxyRequireParser(String require) {
        super(require);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.439 -0500", hash_original_method = "234BDD3530202548153433053521557F", hash_generated_method = "76856878298F809419B89DA37C1537E1")
    
protected ProxyRequireParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (ProxyRequireList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.442 -0500", hash_original_method = "3B22313394D07BEF3A6E95D38DEA0C1A", hash_generated_method = "1BF4A279C7A74A72E14E010698496E4D")
    
public SIPHeader parse() throws ParseException {
        ProxyRequireList list = new ProxyRequireList();
        if (debug)
            dbg_enter("ProxyRequireParser.parse");

        try {
            headerName(TokenTypes.PROXY_REQUIRE);

            while (lexer.lookAhead(0) != '\n') {
                ProxyRequire r = new ProxyRequire();
                r.setHeaderName(SIPHeaderNames.PROXY_REQUIRE);

                // Parsing the option tag
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                r.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();

                list.add(r);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    r = new ProxyRequire();

                    // Parsing the option tag
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    r.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();

                    list.add(r);
                }

            }
        } finally {
            if (debug)
                dbg_leave("ProxyRequireParser.parse");
        }

        return list;
    }

    
}

