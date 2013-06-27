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

public class SIPIfMatchParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.159 -0400", hash_original_method = "58C73D632C90677B10301C6C3F2EA3A6", hash_generated_method = "D36D57F754DDFBB2D2D1B6545FE05766")
    public  SIPIfMatchParser(String etag) {
        super(etag);
        addTaint(etag.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.159 -0400", hash_original_method = "EF4950625B84E18FA318F1BE4AE7C3DD", hash_generated_method = "171AF033935E7415D801A5713DA8219F")
    protected  SIPIfMatchParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.160 -0400", hash_original_method = "3E32D858B03BB295FC48CF43F0845DFE", hash_generated_method = "51436C4D90B60277AAEC3115F6C10E92")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_847694252 = null; //Variable for return #1
        dbg_enter("SIPIfMatch.parse");
        SIPIfMatch sipIfMatch;
        sipIfMatch = new SIPIfMatch();
        try 
        {
            headerName(TokenTypes.SIP_IF_MATCH);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            sipIfMatch.setETag(token.getTokenValue());
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_847694252 = sipIfMatch;
        } //End block
        finally 
        {
            dbg_leave("SIPIfMatch.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_847694252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_847694252;
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("SIPIfMatch.parse");
        //SIPIfMatch sipIfMatch = new SIPIfMatch();
        //try {
            //headerName(TokenTypes.SIP_IF_MATCH);
            //this.lexer.SPorHT();
            //this.lexer.match(TokenTypes.ID);
            //Token token = lexer.getNextToken();
            //sipIfMatch.setETag(token.getTokenValue());
            //this.lexer.SPorHT();
            //this.lexer.match('\n');
            //return sipIfMatch;
        //} finally {
            //if (debug)
                //dbg_leave("SIPIfMatch.parse");
        //}
    }

    
}

