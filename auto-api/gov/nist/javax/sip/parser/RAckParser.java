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
import javax.sip.*;

public class RAckParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.069 -0400", hash_original_method = "35CA8C822A17FE233ECB2E3810B4D5A5", hash_generated_method = "204EAA0FF73FCB80B592091AB94B2072")
    public  RAckParser(String rack) {
        super(rack);
        addTaint(rack.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.069 -0400", hash_original_method = "8178ADDB9459B460DE70CCF5467A1FD6", hash_generated_method = "68F94D595AD7B884EA33EDFE3B3CF328")
    protected  RAckParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.126 -0400", hash_original_method = "D7A41CF31988627D95B578BB3BBF9822", hash_generated_method = "C8AE6FD1A19192CB8890FB4845A8A27C")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_628155733 = null; //Variable for return #1
        dbg_enter("RAckParser.parse");
        RAck rack;
        rack = new RAck();
        try 
        {
            headerName(TokenTypes.RACK);
            rack.setHeaderName(SIPHeaderNames.RACK);
            try 
            {
                String number;
                number = this.lexer.number();
                rack.setRSequenceNumber(Long.parseLong(number));
                this.lexer.SPorHT();
                number = this.lexer.number();
                rack.setCSequenceNumber(Long.parseLong(number));
                this.lexer.SPorHT();
                this.lexer.match(TokenTypes.ID);
                Token token;
                token = lexer.getNextToken();
                rack.setMethod(token.getTokenValue());
            } //End block
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_628155733 = rack;
        } //End block
        finally 
        {
            dbg_leave("RAckParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_628155733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_628155733;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

