package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.AuthenticationHeader;

import java.text.ParseException;





public abstract class ChallengeParser extends HeaderParser {

    /**
     * Constructor
     * @param String challenge  message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.978 -0500", hash_original_method = "0297ABBADD5BD655B8C4CB1A6717CB49", hash_generated_method = "839C6AD57343C084EB74731E43FFB334")
    protected ChallengeParser(String challenge) {
        super(challenge);
    }

    /**
     * Constructor
     * @param String challenge  message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.979 -0500", hash_original_method = "FE6E9A1011CEBAC8DED6715FCD76DE94", hash_generated_method = "1A860CFBC41B90F5507D1EE6C3314F82")
    protected ChallengeParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * Get the parameter of the challenge string
     * @return NameValue containing the parameter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.980 -0500", hash_original_method = "9DA7C681662806B106F4C258133C7994", hash_generated_method = "6546AA35598C4BC540E52130C96D42F4")
    protected void parseParameter(AuthenticationHeader header)
        throws ParseException {

        if (debug)
            dbg_enter("parseParameter");
        try {
            NameValue nv = this.nameValue('=');
            header.setParameter(nv);
        } finally {
            if (debug)
                dbg_leave("parseParameter");
        }

    }

    /**
     * parser the String message.
     * @param header - header structure to fill in.
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.981 -0500", hash_original_method = "B311542306ECD32A0F10ABE0BAAE80D2", hash_generated_method = "C756A705C3626349AFC522FCA146EF5D")
    public void parse(AuthenticationHeader header) throws ParseException {

        // the Scheme:
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        Token type = lexer.getNextToken();
        this.lexer.SPorHT();
        header.setScheme(type.getTokenValue());

        // The parameters:
        try {
            while (lexer.lookAhead(0) != '\n') {
                this.parseParameter(header);
                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
                if (la == '\n' || la == '\0')
                    break;
                this.lexer.match(',');
                this.lexer.SPorHT();
            }
        } catch (ParseException ex) {
            throw ex;
        }
    }

    
}

