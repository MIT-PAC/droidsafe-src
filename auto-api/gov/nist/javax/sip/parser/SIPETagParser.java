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

public class SIPETagParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.525 -0400", hash_original_method = "25835348DC7AD8FF740039B9BA0B006A", hash_generated_method = "27BCD399D6D3FB9482D9F8A4C8C0D3B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPETagParser(String etag) {
        super(etag);
        dsTaint.addTaint(etag);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.525 -0400", hash_original_method = "03B2B3729732C2927273E5D90D52F99B", hash_generated_method = "3F023EBC05107346D3DA023521330A11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SIPETagParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.526 -0400", hash_original_method = "2EFAB9CD472E8A9D51A90FC23F3B4B08", hash_generated_method = "7289F3F1A199A6FDA6F966E924D74D03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("SIPEtag.parse");
        SIPETag sipEtag;
        sipEtag = new SIPETag();
        try 
        {
            headerName(TokenTypes.SIP_ETAG);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            sipEtag.setETag(token.getTokenValue());
            this.lexer.SPorHT();
            this.lexer.match('\n');
        } //End block
        finally 
        {
            dbg_leave("SIPEtag.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("SIPEtag.parse");
        //SIPETag sipEtag = new SIPETag();
        //try {
            //headerName(TokenTypes.SIP_ETAG);
            //this.lexer.SPorHT();
            //this.lexer.match(TokenTypes.ID);
            //Token token = lexer.getNextToken();
            //sipEtag.setETag(token.getTokenValue());
            //this.lexer.SPorHT();
            //this.lexer.match('\n');
            //return sipEtag;
        //} finally {
            //if (debug)
                //dbg_leave("SIPEtag.parse");
        //}
    }

    
}

