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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.527 -0400", hash_original_method = "58C73D632C90677B10301C6C3F2EA3A6", hash_generated_method = "BEF196D61AF3C5DFBEA699EC8BC74C2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPIfMatchParser(String etag) {
        super(etag);
        dsTaint.addTaint(etag);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.527 -0400", hash_original_method = "EF4950625B84E18FA318F1BE4AE7C3DD", hash_generated_method = "8B4585F963F55AAC6E8670F4B957A9F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SIPIfMatchParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.528 -0400", hash_original_method = "3E32D858B03BB295FC48CF43F0845DFE", hash_generated_method = "BEFC4545BE7A3AC2EADD9B02D5A31EEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
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
        } //End block
        finally 
        {
            dbg_leave("SIPIfMatch.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

