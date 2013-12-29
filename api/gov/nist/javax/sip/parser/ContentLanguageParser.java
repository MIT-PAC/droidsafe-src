package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.ContentLanguage;
import gov.nist.javax.sip.header.ContentLanguageList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ContentLanguageParser extends HeaderParser {

    /**
     * Creates a new instance of ContentLanguageParser
     * @param contentLanguage the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.576 -0500", hash_original_method = "0E099EDE885EEFB21F71B8A7B980DD82", hash_generated_method = "605D64B29EFC9BDFE12926D99E84F3C2")
    public ContentLanguageParser(String contentLanguage) {
        super(contentLanguage);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.577 -0500", hash_original_method = "2896A247DEE95FE46B57871751B12905", hash_generated_method = "296F5A82687ABB6E21DC8977C8B93294")
    protected ContentLanguageParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the ContentLanguageHeader String header
     * @return SIPHeader (ContentLanguageList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.578 -0500", hash_original_method = "B9174D052A2AFCDDC5C88393A2D6AF07", hash_generated_method = "93C05A9EFE7836DF946A7635EBAB7C31")
    public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("ContentLanguageParser.parse");
        ContentLanguageList list = new ContentLanguageList();

        try {
            headerName(TokenTypes.CONTENT_LANGUAGE);

            while (lexer.lookAhead(0) != '\n') {
                this.lexer.SPorHT();
                this.lexer.match(TokenTypes.ID);

                Token token = lexer.getNextToken();
                ContentLanguage cl = new ContentLanguage( token.getTokenValue() );
                this.lexer.SPorHT();
                list.add(cl);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    this.lexer.match(TokenTypes.ID);
                    this.lexer.SPorHT();
                    token = lexer.getNextToken();
                    cl = new ContentLanguage( token.getTokenValue() );
                    this.lexer.SPorHT();
                    list.add(cl);
                }
            }

            return list;
        } catch (ParseException ex) {
            throw createParseException(ex.getMessage());
        } finally {
            if (debug)
                dbg_leave("ContentLanguageParser.parse");
        }
    }

    
}

