package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ContentTypeParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.353 -0400", hash_original_method = "AC2B50BA9F98FE0D35E93AB411532CED", hash_generated_method = "947A255A2E43F450BF732116A9038526")
    public  ContentTypeParser(String contentType) {
        super(contentType);
        addTaint(contentType.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.354 -0400", hash_original_method = "9BAC92854D082DF9DDE50098E692CCEB", hash_generated_method = "33C6ACBCFC1C53EB6403F2BED8015A51")
    protected  ContentTypeParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.356 -0400", hash_original_method = "8AB392911FDE1F0164CFD7A5CB623621", hash_generated_method = "B957E99D42FD3C29A0C7ABF27B960EB1")
    public SIPHeader parse() throws ParseException {
        ContentType contentType = new ContentType();
    if(debug)        
        dbg_enter("ContentTypeParser.parse");
        try 
        {
            this.headerName(TokenTypes.CONTENT_TYPE);
            lexer.match(TokenTypes.ID);
            Token type = lexer.getNextToken();
            this.lexer.SPorHT();
            contentType.setContentType(type.getTokenValue());
            lexer.match('/');
            lexer.match(TokenTypes.ID);
            Token subType = lexer.getNextToken();
            this.lexer.SPorHT();
            contentType.setContentSubType(subType.getTokenValue());
            super.parse(contentType);
            this.lexer.match('\n');
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("ContentTypeParser.parse");
        } //End block
SIPHeader var1F9BE0A83D9F0F30EFF7E238CEE615C0_1606729253 =         contentType;
        var1F9BE0A83D9F0F30EFF7E238CEE615C0_1606729253.addTaint(taint);
        return var1F9BE0A83D9F0F30EFF7E238CEE615C0_1606729253;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

