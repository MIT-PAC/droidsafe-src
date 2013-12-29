package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Debug;
import gov.nist.javax.sip.header.CSeq;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.message.SIPRequest;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class CSeqParser extends HeaderParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.967 -0500", hash_original_method = "315D7450D70C30EDB72AC7255664118E", hash_generated_method = "6AC381816EB47F5FD6DEBE09FEBCD220")
    public CSeqParser(String cseq) {
        super(cseq);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.968 -0500", hash_original_method = "8A2748B0467C573864DACC8328A787A7", hash_generated_method = "2668CBD343EFC1116D0F272E08A66E1B")
    protected CSeqParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.968 -0500", hash_original_method = "25983B4EEF6E8D8834C12C4F0FEB872C", hash_generated_method = "4684E7CFD9FCBDE598BF135EE34FE5DA")
    public SIPHeader parse() throws ParseException {
        try {
            CSeq c = new CSeq();

            this.lexer.match(TokenTypes.CSEQ);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            String number = this.lexer.number();
            c.setSeqNumber(Long.parseLong(number));
            this.lexer.SPorHT();
            String m = SIPRequest.getCannonicalName( method() );
            
            
            
            c.setMethod(m);
            this.lexer.SPorHT();
            this.lexer.match('\n');
            return c;
        } catch (NumberFormatException ex) {
            Debug.printStackTrace(ex);
            throw createParseException("Number format exception");
        } catch (InvalidArgumentException ex) {
            Debug.printStackTrace(ex);
            throw createParseException(ex.getMessage());
        }
    }

    
}

