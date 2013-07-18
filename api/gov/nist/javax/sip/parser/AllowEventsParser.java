package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.core.Token;
import gov.nist.javax.sip.header.AllowEvents;
import gov.nist.javax.sip.header.AllowEventsList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AllowEventsParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.855 -0400", hash_original_method = "B8B57389921DBA1CC2428437DFD404AC", hash_generated_method = "5AC91EE0056EEBBD86FC067D51E73555")
    public  AllowEventsParser(String allowEvents) {
        super(allowEvents);
        addTaint(allowEvents.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.855 -0400", hash_original_method = "53ECD40448666EF39463E8A30244C2E7", hash_generated_method = "8FDDFDAA1BA9889E2ED576BBB1A6320C")
    protected  AllowEventsParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.856 -0400", hash_original_method = "457BF63FCB5F5743303EA5CCFBD04779", hash_generated_method = "1409FBD88678D108B77D3E38F58BEAFD")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("AllowEventsParser.parse");
        AllowEventsList list = new AllowEventsList();
        try 
        {
            headerName(TokenTypes.ALLOW_EVENTS);
            AllowEvents allowEvents = new AllowEvents();
            allowEvents.setHeaderName(SIPHeaderNames.ALLOW_EVENTS);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            allowEvents.setEventType(token.getTokenValue());
            list.add(allowEvents);
            this.lexer.SPorHT();
            while
(lexer.lookAhead(0) == ',')            
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
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_1920119137 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1920119137.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1920119137;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("AllowEventsParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

