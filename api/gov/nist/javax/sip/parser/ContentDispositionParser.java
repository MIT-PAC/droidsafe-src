package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.ContentDisposition;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ContentDispositionParser extends ParametersParser {

    /**
     * Creates a new instance of ContentDispositionParser
     * @param contentDisposition the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.284 -0500", hash_original_method = "04008A13B0A5E88C87B63AAF08ED822A", hash_generated_method = "1F99FB9C48EE9EEFAE67593C4664A6F1")
    
public ContentDispositionParser(String contentDisposition) {
        super(contentDisposition);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.288 -0500", hash_original_method = "7D9894E3DD1592FE62F944EB2803724D", hash_generated_method = "AD65E80CA37E68032C8E9C98D5A3DE29")
    
protected ContentDispositionParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the ContentDispositionHeader String header
     * @return SIPHeader (ContentDispositionList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.290 -0500", hash_original_method = "C25B69CBC1412EAEFB170FBF9B530EF5", hash_generated_method = "AD0F03654918E48BE3984210F2815FEB")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("ContentDispositionParser.parse");

        try {
            headerName(TokenTypes.CONTENT_DISPOSITION);

            ContentDisposition cd = new ContentDisposition();
            cd.setHeaderName(SIPHeaderNames.CONTENT_DISPOSITION);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);

            Token token = lexer.getNextToken();
            cd.setDispositionType(token.getTokenValue());
            this.lexer.SPorHT();
            super.parse(cd);

            this.lexer.SPorHT();
            this.lexer.match('\n');

            return cd;
        } catch (ParseException ex) {
            throw createParseException(ex.getMessage());
        } finally {
            if (debug)
                dbg_leave("ContentDispositionParser.parse");
        }
    }

    
}

