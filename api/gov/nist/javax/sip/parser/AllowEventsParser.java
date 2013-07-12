package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class AllowEventsParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.834 -0400", hash_original_method = "B8B57389921DBA1CC2428437DFD404AC", hash_generated_method = "5AC91EE0056EEBBD86FC067D51E73555")
    public  AllowEventsParser(String allowEvents) {
        super(allowEvents);
        addTaint(allowEvents.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.834 -0400", hash_original_method = "53ECD40448666EF39463E8A30244C2E7", hash_generated_method = "8FDDFDAA1BA9889E2ED576BBB1A6320C")
    protected  AllowEventsParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.835 -0400", hash_original_method = "457BF63FCB5F5743303EA5CCFBD04779", hash_generated_method = "BE4A73278E655A778F2B996D35C62025")
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
            } 
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_1047217430 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1047217430.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1047217430;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("AllowEventsParser.parse");
        } 
        
        
    }

    
}

