package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.ContentEncoding;
import gov.nist.javax.sip.header.ContentEncodingList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ContentEncodingParser extends HeaderParser {

    /**
     * Creates a new instance of ContentEncodingParser
     * @param contentEncoding the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.960 -0500", hash_original_method = "025E1AD213DC2532673CB1D1FC75B1CC", hash_generated_method = "AF9BD842838DEB26BE1BF73447B9C978")
    
public ContentEncodingParser(String contentEncoding) {
        super(contentEncoding);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.963 -0500", hash_original_method = "15007428AB3C93C7C47122E74B782E26", hash_generated_method = "4F38E4650F7DEAEE468A52EC2980675D")
    
protected ContentEncodingParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the ContentEncodingHeader String header
     * @return SIPHeader (ContentEncodingList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.966 -0500", hash_original_method = "8ACC6861A4ACA970AEBA8CCFE6984687", hash_generated_method = "7B1E5B53927553375DCF3987967EF71D")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("ContentEncodingParser.parse");
        ContentEncodingList list = new ContentEncodingList();

        try {
            headerName(TokenTypes.CONTENT_ENCODING);

            while (lexer.lookAhead(0) != '\n') {
                ContentEncoding cl = new ContentEncoding();
                cl.setHeaderName(SIPHeaderNames.CONTENT_ENCODING);

                this.lexer.SPorHT();
                this.lexer.match(TokenTypes.ID);

                Token token = lexer.getNextToken();
                cl.setEncoding(token.getTokenValue());

                this.lexer.SPorHT();
                list.add(cl);

                while (lexer.lookAhead(0) == ',') {
                    cl = new ContentEncoding();
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    this.lexer.match(TokenTypes.ID);
                    this.lexer.SPorHT();
                    token = lexer.getNextToken();
                    cl.setEncoding(token.getTokenValue());
                    this.lexer.SPorHT();
                    list.add(cl);
                }
            }

            return list;
        } catch (ParseException ex) {
            throw createParseException(ex.getMessage());
        } finally {
            if (debug)
                dbg_leave("ContentEncodingParser.parse");
        }
    }

    
}

