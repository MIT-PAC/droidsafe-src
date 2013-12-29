package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.Event;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class EventParser extends ParametersParser {

    /**
     * Creates a new instance of EventParser
     * @param event the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.044 -0500", hash_original_method = "50E5FEDABD0DAB8D49656909229ED832", hash_generated_method = "18A6F7B0EAF97290D9636286869ADF38")
    public EventParser(String event) {
        super(event);
    }

    /**
     * Cosntructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.045 -0500", hash_original_method = "D3468855FFD30B89A817AFCB4CE0E283", hash_generated_method = "D8A4D2DD23E414727FD9AF6706C434D1")
    protected EventParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (Event object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.047 -0500", hash_original_method = "DF7492B0F439F0DD586A6D33E917DC2B", hash_generated_method = "B734B4B662C13F070FD40044895D7CED")
    public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("EventParser.parse");

        try {
            headerName(TokenTypes.EVENT);
            this.lexer.SPorHT();

            Event event = new Event();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            String value = token.getTokenValue();

            event.setEventType(value);
            super.parse(event);

            this.lexer.SPorHT();
            this.lexer.match('\n');

            return event;

        } catch (ParseException ex) {
            throw createParseException(ex.getMessage());
        } finally {
            if (debug)
                dbg_leave("EventParser.parse");
        }
    }

    
}

