package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;
import javax.sip.*;

public class RAckParser extends HeaderParser {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.520 -0400", hash_original_method = "35CA8C822A17FE233ECB2E3810B4D5A5", hash_generated_method = "204EAA0FF73FCB80B592091AB94B2072")
    public  RAckParser(String rack) {
        super(rack);
        addTaint(rack.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.520 -0400", hash_original_method = "8178ADDB9459B460DE70CCF5467A1FD6", hash_generated_method = "68F94D595AD7B884EA33EDFE3B3CF328")
    protected  RAckParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.552 -0400", hash_original_method = "D7A41CF31988627D95B578BB3BBF9822", hash_generated_method = "A7A63C2815DD13AB21D79ECE4FABF1B7")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("RAckParser.parse");
        RAck rack = new RAck();
        try 
        {
            headerName(TokenTypes.RACK);
            rack.setHeaderName(SIPHeaderNames.RACK);
            try 
            {
                String number = this.lexer.number();
                rack.setRSequenceNumber(Long.parseLong(number));
                this.lexer.SPorHT();
                number = this.lexer.number();
                rack.setCSequenceNumber(Long.parseLong(number));
                this.lexer.SPorHT();
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                rack.setMethod(token.getTokenValue());
            } //End block
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_164644043 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_164644043.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_164644043;
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var55285630369F90A1D1B24F624C06D15F_487214637 =             rack;
            var55285630369F90A1D1B24F624C06D15F_487214637.addTaint(taint);
            return var55285630369F90A1D1B24F624C06D15F_487214637;
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("RAckParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

