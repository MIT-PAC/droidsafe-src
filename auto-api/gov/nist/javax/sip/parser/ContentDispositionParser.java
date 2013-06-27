package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class ContentDispositionParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.611 -0400", hash_original_method = "04008A13B0A5E88C87B63AAF08ED822A", hash_generated_method = "690DFA335DDBFB3F5251BBC4962C114D")
    public  ContentDispositionParser(String contentDisposition) {
        super(contentDisposition);
        addTaint(contentDisposition.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.611 -0400", hash_original_method = "7D9894E3DD1592FE62F944EB2803724D", hash_generated_method = "523EE1F84C89EE7708D60186E2EC3461")
    protected  ContentDispositionParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.637 -0400", hash_original_method = "C25B69CBC1412EAEFB170FBF9B530EF5", hash_generated_method = "EF7C7E2ECF8756F4068BF5EC7BAB5BAF")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_146826747 = null; //Variable for return #1
        dbg_enter("ContentDispositionParser.parse");
        try 
        {
            headerName(TokenTypes.CONTENT_DISPOSITION);
            ContentDisposition cd;
            cd = new ContentDisposition();
            cd.setHeaderName(SIPHeaderNames.CONTENT_DISPOSITION);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            cd.setDispositionType(token.getTokenValue());
            this.lexer.SPorHT();
            super.parse(cd);
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_146826747 = cd;
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        finally 
        {
            dbg_leave("ContentDispositionParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_146826747.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_146826747;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

