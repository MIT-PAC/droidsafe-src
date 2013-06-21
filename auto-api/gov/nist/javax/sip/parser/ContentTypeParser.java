package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ContentTypeParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.268 -0400", hash_original_method = "AC2B50BA9F98FE0D35E93AB411532CED", hash_generated_method = "5CDA71F8B40741B9742C22ECA6F13BE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentTypeParser(String contentType) {
        super(contentType);
        dsTaint.addTaint(contentType);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.269 -0400", hash_original_method = "9BAC92854D082DF9DDE50098E692CCEB", hash_generated_method = "DE99E24C39AF203B83C8DFA2C04AE655")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ContentTypeParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.269 -0400", hash_original_method = "8AB392911FDE1F0164CFD7A5CB623621", hash_generated_method = "3DC6EEDCE5CFF110CED898B2928C7279")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        ContentType contentType;
        contentType = new ContentType();
        dbg_enter("ContentTypeParser.parse");
        try 
        {
            this.headerName(TokenTypes.CONTENT_TYPE);
            lexer.match(TokenTypes.ID);
            Token type;
            type = lexer.getNextToken();
            this.lexer.SPorHT();
            contentType.setContentType(type.getTokenValue());
            lexer.match('/');
            lexer.match(TokenTypes.ID);
            Token subType;
            subType = lexer.getNextToken();
            this.lexer.SPorHT();
            contentType.setContentSubType(subType.getTokenValue());
            super.parse(contentType);
            this.lexer.match('\n');
        } //End block
        finally 
        {
            dbg_leave("ContentTypeParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

