package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class SIPETagParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.691 -0400", hash_original_method = "25835348DC7AD8FF740039B9BA0B006A", hash_generated_method = "DABC58F2C7A881669DD1F6CF1A3EEE88")
    public  SIPETagParser(String etag) {
        super(etag);
        addTaint(etag.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.692 -0400", hash_original_method = "03B2B3729732C2927273E5D90D52F99B", hash_generated_method = "35AB74E80C2FDF719C633AF0774FB236")
    protected  SIPETagParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.692 -0400", hash_original_method = "2EFAB9CD472E8A9D51A90FC23F3B4B08", hash_generated_method = "CF935A934ADF36AE991DF4C2DC062A24")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("SIPEtag.parse");
        SIPETag sipEtag = new SIPETag();
        try 
        {
            headerName(TokenTypes.SIP_ETAG);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            sipEtag.setETag(token.getTokenValue());
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var178ED0D9475F8DE2B44830603C2DF01C_1841033299 =             sipEtag;
            var178ED0D9475F8DE2B44830603C2DF01C_1841033299.addTaint(taint);
            return var178ED0D9475F8DE2B44830603C2DF01C_1841033299;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("SIPEtag.parse");
        } //End block
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

