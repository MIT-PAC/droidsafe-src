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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.401 -0400", hash_original_method = "B8B57389921DBA1CC2428437DFD404AC", hash_generated_method = "5AC91EE0056EEBBD86FC067D51E73555")
    public  AllowEventsParser(String allowEvents) {
        super(allowEvents);
        addTaint(allowEvents.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.401 -0400", hash_original_method = "53ECD40448666EF39463E8A30244C2E7", hash_generated_method = "8FDDFDAA1BA9889E2ED576BBB1A6320C")
    protected  AllowEventsParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.402 -0400", hash_original_method = "457BF63FCB5F5743303EA5CCFBD04779", hash_generated_method = "C5E792C63C882B74C45E0D5E039BE939")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_206456562 = null; //Variable for return #1
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
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_1621441163 = (lexer.lookAhead(0) == ',');
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
            varB4EAC82CA7396A68D541C85D26508E83_206456562 = list;
        } //End block
        finally 
        {
            dbg_leave("AllowEventsParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_206456562.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_206456562;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

