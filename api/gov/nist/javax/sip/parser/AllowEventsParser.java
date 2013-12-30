package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.AllowEvents;
import gov.nist.javax.sip.header.AllowEventsList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class AllowEventsParser extends HeaderParser {

    /**
     * Creates a new instance of AllowEventsParser
     * @param allowEvents the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.110 -0500", hash_original_method = "B8B57389921DBA1CC2428437DFD404AC", hash_generated_method = "BA87E322AB32D77DC767F35C91B4FDB3")
    
public AllowEventsParser(String allowEvents) {
        super(allowEvents);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.113 -0500", hash_original_method = "53ECD40448666EF39463E8A30244C2E7", hash_generated_method = "958CE1F57150E5C71320DD5AEA3202BC")
    
protected AllowEventsParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the AllowEvents String header
     * @return SIPHeader (AllowEventsList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.117 -0500", hash_original_method = "457BF63FCB5F5743303EA5CCFBD04779", hash_generated_method = "3C6470CF292E197FFE72DA0E47EA6081")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AllowEventsParser.parse");
        AllowEventsList list = new AllowEventsList();

        try {
            headerName(TokenTypes.ALLOW_EVENTS);

            AllowEvents allowEvents = new AllowEvents();
            allowEvents.setHeaderName(SIPHeaderNames.ALLOW_EVENTS);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            allowEvents.setEventType(token.getTokenValue());

            list.add(allowEvents);
            this.lexer.SPorHT();
            while (lexer.lookAhead(0) == ',') {
                this.lexer.match(',');
                this.lexer.SPorHT();

                allowEvents = new AllowEvents();
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                allowEvents.setEventType(token.getTokenValue());

                list.add(allowEvents);
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match('\n');

            return list;
        } finally {
            if (debug)
                dbg_leave("AllowEventsParser.parse");
        }
    }

    
}

