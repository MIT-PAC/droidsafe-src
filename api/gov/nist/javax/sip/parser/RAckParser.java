package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.core.Token;
import gov.nist.javax.sip.header.RAck;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RAckParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.387 -0400", hash_original_method = "35CA8C822A17FE233ECB2E3810B4D5A5", hash_generated_method = "204EAA0FF73FCB80B592091AB94B2072")
    public  RAckParser(String rack) {
        super(rack);
        addTaint(rack.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.387 -0400", hash_original_method = "8178ADDB9459B460DE70CCF5467A1FD6", hash_generated_method = "68F94D595AD7B884EA33EDFE3B3CF328")
    protected  RAckParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.418 -0400", hash_original_method = "D7A41CF31988627D95B578BB3BBF9822", hash_generated_method = "B15B0917C344D9FE09462EFA69B32B6D")
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
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1746762640 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_1746762640.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_1746762640;
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var55285630369F90A1D1B24F624C06D15F_1809096590 =             rack;
            var55285630369F90A1D1B24F624C06D15F_1809096590.addTaint(taint);
            return var55285630369F90A1D1B24F624C06D15F_1809096590;
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

