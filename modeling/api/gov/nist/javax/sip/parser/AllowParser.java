package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.Allow;
import gov.nist.javax.sip.header.AllowList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class AllowParser extends HeaderParser {

    /**
     * Creates a new instance of AllowParser
     * @param allow the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.776 -0500", hash_original_method = "A24A575FAE973D160C4E5E7D0F1284A3", hash_generated_method = "EF7557F2CCEC32B947EEF5A8EF2D1C54")
    
public AllowParser(String allow) {
        super(allow);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.778 -0500", hash_original_method = "A8034B0A3FEDB25038322A25EEE239D9", hash_generated_method = "BC8C9D82A96C4E4BCAE6875470964D0D")
    
protected AllowParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the Allow String header
     * @return SIPHeader (AllowList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.781 -0500", hash_original_method = "EEEC9A9B7336175FA90CC43255548EC9", hash_generated_method = "A6283962EC4BC9718A7AF6E989D32E51")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AllowParser.parse");
        AllowList list = new AllowList();

        try {
            headerName(TokenTypes.ALLOW);

            Allow allow = new Allow();
            allow.setHeaderName(SIPHeaderNames.ALLOW);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            allow.setMethod(token.getTokenValue());

            list.add(allow);
            this.lexer.SPorHT();
            while (lexer.lookAhead(0) == ',') {
                this.lexer.match(',');
                this.lexer.SPorHT();

                allow = new Allow();
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                allow.setMethod(token.getTokenValue());

                list.add(allow);
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match('\n');

            return list;
        } finally {
            if (debug)
                dbg_leave("AllowParser.parse");
        }
    }

    
}

