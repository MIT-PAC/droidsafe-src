package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class SIPIfMatchParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.702 -0400", hash_original_method = "58C73D632C90677B10301C6C3F2EA3A6", hash_generated_method = "D36D57F754DDFBB2D2D1B6545FE05766")
    public  SIPIfMatchParser(String etag) {
        super(etag);
        addTaint(etag.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.703 -0400", hash_original_method = "EF4950625B84E18FA318F1BE4AE7C3DD", hash_generated_method = "171AF033935E7415D801A5713DA8219F")
    protected  SIPIfMatchParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.704 -0400", hash_original_method = "3E32D858B03BB295FC48CF43F0845DFE", hash_generated_method = "2B958C49FC9D4F37E1FD45E829ABF93D")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("SIPIfMatch.parse");
        SIPIfMatch sipIfMatch = new SIPIfMatch();
        try 
        {
            headerName(TokenTypes.SIP_IF_MATCH);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            sipIfMatch.setETag(token.getTokenValue());
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var2AC239437004089F4FD3A73D32258A23_231988708 =             sipIfMatch;
            var2AC239437004089F4FD3A73D32258A23_231988708.addTaint(taint);
            return var2AC239437004089F4FD3A73D32258A23_231988708;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("SIPIfMatch.parse");
        } //End block
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

