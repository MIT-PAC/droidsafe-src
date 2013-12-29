package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.ContentType;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ContentTypeParser extends ParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.131 -0500", hash_original_method = "AC2B50BA9F98FE0D35E93AB411532CED", hash_generated_method = "8853D48156FDF97CCE04CBAD97151AFA")
    public ContentTypeParser(String contentType) {
        super(contentType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.132 -0500", hash_original_method = "9BAC92854D082DF9DDE50098E692CCEB", hash_generated_method = "4B830429CB4DA676244A8943495CA499")
    protected ContentTypeParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.133 -0500", hash_original_method = "8AB392911FDE1F0164CFD7A5CB623621", hash_generated_method = "53101BC80A8F7CB589F7ED4DF56D64D5")
    public SIPHeader parse() throws ParseException {

        ContentType contentType = new ContentType();
        if (debug)
            dbg_enter("ContentTypeParser.parse");

        try {
            this.headerName(TokenTypes.CONTENT_TYPE);

            // The type:
            lexer.match(TokenTypes.ID);
            Token type = lexer.getNextToken();
            this.lexer.SPorHT();
            contentType.setContentType(type.getTokenValue());

            // The sub-type:
            lexer.match('/');
            lexer.match(TokenTypes.ID);
            Token subType = lexer.getNextToken();
            this.lexer.SPorHT();
            contentType.setContentSubType(subType.getTokenValue());
            super.parse(contentType);
            this.lexer.match('\n');
        } finally {
            if (debug)
                dbg_leave("ContentTypeParser.parse");
        }
        return contentType;

    }

    
}

