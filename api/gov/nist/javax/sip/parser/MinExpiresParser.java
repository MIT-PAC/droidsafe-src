package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.MinExpires;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class MinExpiresParser extends HeaderParser {

    /**
     * Creates a new instance of MinExpiresParser
     * @param minExpires the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.895 -0500", hash_original_method = "958EB85119CB55ADB0187595D23A4161", hash_generated_method = "E55476DDF68DBFC1439A8D56777E9891")
    public MinExpiresParser(String minExpires) {
        super(minExpires);
    }

    /**
     * Cosntructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.896 -0500", hash_original_method = "C5E703E21CCA5CEB1F1840058DFBE664", hash_generated_method = "1ED21FC5F85A8561A6553F3965D7FD3A")
    protected MinExpiresParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (MinExpiresParser)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.897 -0500", hash_original_method = "67C1C5FB3D4E718484F296CD0580B923", hash_generated_method = "E4FB769FEDC02FEA8A2364FC8AD6FAE5")
    public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("MinExpiresParser.parse");
        MinExpires minExpires = new MinExpires();
        try {
            headerName(TokenTypes.MIN_EXPIRES);

            minExpires.setHeaderName(SIPHeaderNames.MIN_EXPIRES);

            String number = this.lexer.number();
            try {
                minExpires.setExpires(Integer.parseInt(number));
            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }
            this.lexer.SPorHT();

            this.lexer.match('\n');

            return minExpires;
        } finally {
            if (debug)
                dbg_leave("MinExpiresParser.parse");
        }
    }

    
}

