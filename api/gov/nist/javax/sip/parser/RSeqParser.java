package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.RSeq;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class RSeqParser extends HeaderParser {

    /**
     * Creates a new instance of RSeqParser
     * @param rseq the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.249 -0500", hash_original_method = "B348DC5283F0EBC54D9A2FF780CFD084", hash_generated_method = "188C7C000A6810285121AA6072D42B88")
    
public RSeqParser(String rseq) {
        super(rseq);
    }

    /**
     * Constructor
     * param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.252 -0500", hash_original_method = "5126E3858C9B58BEE1E09B9D0E5DEFC7", hash_generated_method = "52C17028BE9BD792DC9A8A38FCEFD704")
    
protected RSeqParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader ( RSeq object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.255 -0500", hash_original_method = "AB1A0262C7314394004DEB16F5DFE46A", hash_generated_method = "D1762E0FE3A1ABFA34284B038EB5FB15")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("RSeqParser.parse");
        RSeq rseq = new RSeq();
        try {
            headerName(TokenTypes.RSEQ);

            rseq.setHeaderName(SIPHeaderNames.RSEQ);

            String number = this.lexer.number();
            try {
                rseq.setSeqNumber(Long.parseLong(number));
            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }
            this.lexer.SPorHT();

            this.lexer.match('\n');

            return rseq;
        } finally {
            if (debug)
                dbg_leave("RSeqParser.parse");
        }
    }

    
}

