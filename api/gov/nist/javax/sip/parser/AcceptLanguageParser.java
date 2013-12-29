package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.AcceptLanguage;
import gov.nist.javax.sip.header.AcceptLanguageList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class AcceptLanguageParser extends HeaderParser {

    /**
     * Constructor
     * @param acceptLanguage AcceptLanguage message to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.937 -0500", hash_original_method = "4ECD6586A5A6ED08B6159E7C6D7079C1", hash_generated_method = "EE8103F532F2D46D3610970D092C3ECB")
    public AcceptLanguageParser(String acceptLanguage) {
        super(acceptLanguage);
    }

    /**
     * Constructor
     * @param lexer Lexer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.938 -0500", hash_original_method = "8738AF37C5C1AC35B7D6DAA26504D715", hash_generated_method = "D6E006301BCD32DC14D27238F2F9D49E")
    protected AcceptLanguageParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (AcceptLanguage object)
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.940 -0500", hash_original_method = "FB0497E5D9550DB51E743204446EFE6C", hash_generated_method = "E71308111C5DA8DA3F027CA04BAFE3A4")
    public SIPHeader parse() throws ParseException {
        AcceptLanguageList acceptLanguageList = new AcceptLanguageList();
        if (debug)
            dbg_enter("AcceptLanguageParser.parse");

        try {
            headerName(TokenTypes.ACCEPT_LANGUAGE);

            while (lexer.lookAhead(0) != '\n') {
                AcceptLanguage acceptLanguage = new AcceptLanguage();
                acceptLanguage.setHeaderName(SIPHeaderNames.ACCEPT_LANGUAGE);
                if (lexer.lookAhead(0) != ';') {
                    // Content-Coding:
                    lexer.match(TokenTypes.ID);
                    Token value = lexer.getNextToken();
                    acceptLanguage.setLanguageRange(value.getTokenValue());
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
                        float fl = Float.parseFloat(value.getTokenValue());
                        acceptLanguage.setQValue(fl);
                    } catch (NumberFormatException ex) {
                        throw createParseException(ex.getMessage());
                    } catch (InvalidArgumentException ex) {
                        throw createParseException(ex.getMessage());
                    }
                    this.lexer.SPorHT();
                }

                acceptLanguageList.add(acceptLanguage);
                if (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } else
                    this.lexer.SPorHT();

            }
        } finally {
            if (debug)
                dbg_leave("AcceptLanguageParser.parse");
        }

        return acceptLanguageList;
    }

    
}

