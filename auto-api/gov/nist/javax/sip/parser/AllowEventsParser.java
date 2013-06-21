package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class AllowEventsParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.232 -0400", hash_original_method = "B8B57389921DBA1CC2428437DFD404AC", hash_generated_method = "698C5D597078081ED62DB9871D32923F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AllowEventsParser(String allowEvents) {
        super(allowEvents);
        dsTaint.addTaint(allowEvents);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.232 -0400", hash_original_method = "53ECD40448666EF39463E8A30244C2E7", hash_generated_method = "DECAC95866A66A8CCF0DAC733990B998")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AllowEventsParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.233 -0400", hash_original_method = "457BF63FCB5F5743303EA5CCFBD04779", hash_generated_method = "3D87166FEE049F40274B1ECF3CFA3807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("AllowEventsParser.parse");
        AllowEventsList list;
        list = new AllowEventsList();
        try 
        {
            headerName(TokenTypes.ALLOW_EVENTS);
            AllowEvents allowEvents;
            allowEvents = new AllowEvents();
            allowEvents.setHeaderName(SIPHeaderNames.ALLOW_EVENTS);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            allowEvents.setEventType(token.getTokenValue());
            list.add(allowEvents);
            this.lexer.SPorHT();
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_1874205516 = (lexer.lookAhead(0) == ',');
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    allowEvents = new AllowEvents();
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    allowEvents.setEventType(token.getTokenValue());
                    list.add(allowEvents);
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
            this.lexer.SPorHT();
            this.lexer.match('\n');
        } //End block
        finally 
        {
            dbg_leave("AllowEventsParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

