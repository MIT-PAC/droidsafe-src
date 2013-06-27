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

public class EventParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.731 -0400", hash_original_method = "50E5FEDABD0DAB8D49656909229ED832", hash_generated_method = "8C401A9349282DEAE8DDE7C582DC6819")
    public  EventParser(String event) {
        super(event);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.731 -0400", hash_original_method = "D3468855FFD30B89A817AFCB4CE0E283", hash_generated_method = "5F9356AEB1E32F1B037B6F9ECBCE6D31")
    protected  EventParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.738 -0400", hash_original_method = "DF7492B0F439F0DD586A6D33E917DC2B", hash_generated_method = "90175DD83C7C62FC09C97B70AC7CC052")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1423834743 = null; //Variable for return #1
        dbg_enter("EventParser.parse");
        try 
        {
            headerName(TokenTypes.EVENT);
            this.lexer.SPorHT();
            Event event;
            event = new Event();
            this.lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            String value;
            value = token.getTokenValue();
            event.setEventType(value);
            super.parse(event);
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_1423834743 = event;
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        finally 
        {
            dbg_leave("EventParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1423834743.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1423834743;
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("EventParser.parse");
        //try {
            //headerName(TokenTypes.EVENT);
            //this.lexer.SPorHT();
            //Event event = new Event();
            //this.lexer.match(TokenTypes.ID);
            //Token token = lexer.getNextToken();
            //String value = token.getTokenValue();
            //event.setEventType(value);
            //super.parse(event);
            //this.lexer.SPorHT();
            //this.lexer.match('\n');
            //return event;
        //} catch (ParseException ex) {
            //throw createParseException(ex.getMessage());
        //} finally {
            //if (debug)
                //dbg_leave("EventParser.parse");
        //}
    }

    
}

