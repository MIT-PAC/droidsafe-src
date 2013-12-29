package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.AcceptEncoding;
import gov.nist.javax.sip.header.AcceptEncodingList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class AcceptEncodingParser extends HeaderParser {

    /**
     * Constructor
     * @param acceptEncoding message to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:09.929 -0500", hash_original_method = "865E86FA800E1D68F0770AD3080D258F", hash_generated_method = "F694C56F96A8F33310106F0BD29162EF")
    public AcceptEncodingParser(String acceptEncoding) {
        super(acceptEncoding);
    }

    /**
     * Constructor
     * @param lexer Lexer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:09.930 -0500", hash_original_method = "2A31652D0F06752F063CE4D7769684DB", hash_generated_method = "AD8AA37F18D7B3D7A069F41BA3415EFB")
    protected AcceptEncodingParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (AcceptEncoding object)
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:09.932 -0500", hash_original_method = "A9DB3F83816CED00173237937952E9D8", hash_generated_method = "F79B5A2E07ACD55A548C33C3CE214E10")
    public SIPHeader parse() throws ParseException {
        AcceptEncodingList acceptEncodingList = new AcceptEncodingList();
        if (debug)
            dbg_enter("AcceptEncodingParser.parse");

        try {
            headerName(TokenTypes.ACCEPT_ENCODING);
            // empty body is fine for this header.
            if (lexer.lookAhead(0) == '\n') {
                AcceptEncoding acceptEncoding = new AcceptEncoding();
                acceptEncodingList.add(acceptEncoding);
            } else {
                while (lexer.lookAhead(0) != '\n') {
                    AcceptEncoding acceptEncoding = new AcceptEncoding();
                    if (lexer.lookAhead(0) != ';') {
                        // Content-Coding:
                        lexer.match(TokenTypes.ID);
                        Token value = lexer.getNextToken();
                        acceptEncoding.setEncoding(value.getTokenValue());
                    }

                    while (lexer.lookAhead(0) == ';') {
                        this.lexer.match(';');
                        this.lexer.SPorHT();
                        this.lexer.match('q');
                        this.lexer.SPorHT();
                        this.lexer.match('=');
                        this.lexer.SPorHT();
                        lexer.match(TokenTypes.ID);
                        Token value = lexer.getNextToken();
                        try {
                            float qv = Float.parseFloat(value.getTokenValue());
                            acceptEncoding.setQValue(qv);
                        } catch (NumberFormatException ex) {
                            throw createParseException(ex.getMessage());
                        } catch (InvalidArgumentException ex) {
                            throw createParseException(ex.getMessage());
                        }
                        this.lexer.SPorHT();
                    }

                    acceptEncodingList.add(acceptEncoding);
                    if (lexer.lookAhead(0) == ',') {
                        this.lexer.match(',');
                        this.lexer.SPorHT();
                    }

                }
            }
            return acceptEncodingList;
        } finally {
            if (debug)
                dbg_leave("AcceptEncodingParser.parse");
        }
    }

    
}

