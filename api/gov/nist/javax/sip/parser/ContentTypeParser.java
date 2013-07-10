package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ContentTypeParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.912 -0400", hash_original_method = "AC2B50BA9F98FE0D35E93AB411532CED", hash_generated_method = "947A255A2E43F450BF732116A9038526")
    public  ContentTypeParser(String contentType) {
        super(contentType);
        addTaint(contentType.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.912 -0400", hash_original_method = "9BAC92854D082DF9DDE50098E692CCEB", hash_generated_method = "33C6ACBCFC1C53EB6403F2BED8015A51")
    protected  ContentTypeParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.913 -0400", hash_original_method = "8AB392911FDE1F0164CFD7A5CB623621", hash_generated_method = "7CAC65BA79E5276114C59920A522C66C")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1326962734 = null; 
        ContentType contentType = new ContentType();
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
        } 
        finally 
        {
            dbg_leave("ContentTypeParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1326962734 = contentType;
        varB4EAC82CA7396A68D541C85D26508E83_1326962734.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1326962734;
        
        
    }

    
}

