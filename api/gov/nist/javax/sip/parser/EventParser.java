package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class EventParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.437 -0400", hash_original_method = "50E5FEDABD0DAB8D49656909229ED832", hash_generated_method = "8C401A9349282DEAE8DDE7C582DC6819")
    public  EventParser(String event) {
        super(event);
        addTaint(event.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.438 -0400", hash_original_method = "D3468855FFD30B89A817AFCB4CE0E283", hash_generated_method = "5F9356AEB1E32F1B037B6F9ECBCE6D31")
    protected  EventParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.466 -0400", hash_original_method = "DF7492B0F439F0DD586A6D33E917DC2B", hash_generated_method = "582BF14FDFE8BE5E6F55A8C73DD8D340")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("EventParser.parse");
        try 
        {
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
SIPHeader var3162E7A4A1E5D72F1058A9B39A6A8738_1318595037 =             event;
            var3162E7A4A1E5D72F1058A9B39A6A8738_1318595037.addTaint(taint);
            return var3162E7A4A1E5D72F1058A9B39A6A8738_1318595037;
        } 
        catch (ParseException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1457525522 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_1457525522.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_1457525522;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("EventParser.parse");
        } 
        
        
            
        
            
            
            
            
            
            
            
            
            
            
            
        
            
        
            
                
        
    }

    
}

