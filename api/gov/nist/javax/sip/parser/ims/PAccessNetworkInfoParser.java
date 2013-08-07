package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PAccessNetworkInfo;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PAccessNetworkInfoParser extends HeaderParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.854 -0400", hash_original_method = "6DB4AD794C60B8862A83AFB0C9C82A92", hash_generated_method = "0626EAFE4B05112392B453E5EB07C05A")
    public  PAccessNetworkInfoParser(String accessNetwork) {
        super(accessNetwork);
        addTaint(accessNetwork.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.855 -0400", hash_original_method = "3B0D9C588403AF5495F889BAEC6E0FEE", hash_generated_method = "68D1D3CFA3C0BDE696C93371CF1A8F52")
    protected  PAccessNetworkInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.856 -0400", hash_original_method = "0BB1DE6FBD7AB2CBAE3BF43510D39D52", hash_generated_method = "4351C39E6B86766A9A3C1F38F392C35B")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("AccessNetworkInfoParser.parse");
        try 
        {
            headerName(TokenTypes.P_ACCESS_NETWORK_INFO);
            PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
            accessNetworkInfo.setHeaderName(SIPHeaderNamesIms.P_ACCESS_NETWORK_INFO);
            this.lexer.SPorHT();
            lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            accessNetworkInfo.setAccessType(token.getTokenValue());
            this.lexer.SPorHT();
            while
(lexer.lookAhead(0) == ';')            
            {
                this.lexer.match(';');
                this.lexer.SPorHT();
                NameValue nv = super.nameValue('=');
                accessNetworkInfo.setParameter(nv);
                this.lexer.SPorHT();
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader varD15244C320EF41E0D4A4D9B428353746_164806250 =             accessNetworkInfo;
            varD15244C320EF41E0D4A4D9B428353746_164806250.addTaint(taint);
            return varD15244C320EF41E0D4A4D9B428353746_164806250;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("AccessNetworkInfoParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

