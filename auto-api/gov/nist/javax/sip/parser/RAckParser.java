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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.493 -0400", hash_original_method = "35CA8C822A17FE233ECB2E3810B4D5A5", hash_generated_method = "3741135C8886618123E779697CADBB09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RAckParser(String rack) {
        super(rack);
        dsTaint.addTaint(rack);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.493 -0400", hash_original_method = "8178ADDB9459B460DE70CCF5467A1FD6", hash_generated_method = "3F2EE4B215BEE7C12212F5C965483A70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected RAckParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.494 -0400", hash_original_method = "D7A41CF31988627D95B578BB3BBF9822", hash_generated_method = "C8EFB7C696C1CFB2849E60A7073A8334")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
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
        } //End block
        finally 
        {
            dbg_leave("RAckParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

