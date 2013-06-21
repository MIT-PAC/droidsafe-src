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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.279 -0400", hash_original_method = "50E5FEDABD0DAB8D49656909229ED832", hash_generated_method = "8BF8AC1868E30A5BE47F2A9ED1881679")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EventParser(String event) {
        super(event);
        dsTaint.addTaint(event);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.279 -0400", hash_original_method = "D3468855FFD30B89A817AFCB4CE0E283", hash_generated_method = "70AA7AC497CBB91C44C868774D71A57E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected EventParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.279 -0400", hash_original_method = "DF7492B0F439F0DD586A6D33E917DC2B", hash_generated_method = "FAA9AB2E73FABC2CAD9EA8C112D37DE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
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
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        finally 
        {
            dbg_leave("EventParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

