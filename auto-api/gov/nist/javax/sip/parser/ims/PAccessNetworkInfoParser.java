package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.PAccessNetworkInfo;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.core.Token;
import gov.nist.core.NameValue;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;

public class PAccessNetworkInfoParser extends HeaderParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.749 -0400", hash_original_method = "6DB4AD794C60B8862A83AFB0C9C82A92", hash_generated_method = "5AE52B7648A92522F32F1EDC15CCE625")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAccessNetworkInfoParser(String accessNetwork) {
        super(accessNetwork);
        dsTaint.addTaint(accessNetwork);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.750 -0400", hash_original_method = "3B0D9C588403AF5495F889BAEC6E0FEE", hash_generated_method = "9E0FDC71988841AB8CB87DB13791425A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PAccessNetworkInfoParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.750 -0400", hash_original_method = "0BB1DE6FBD7AB2CBAE3BF43510D39D52", hash_generated_method = "7C199D2F912CE675B8BB1F37FDC044EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("AccessNetworkInfoParser.parse");
        try 
        {
            headerName(TokenTypes.P_ACCESS_NETWORK_INFO);
            PAccessNetworkInfo accessNetworkInfo;
            accessNetworkInfo = new PAccessNetworkInfo();
            accessNetworkInfo.setHeaderName(SIPHeaderNamesIms.P_ACCESS_NETWORK_INFO);
            this.lexer.SPorHT();
            lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            accessNetworkInfo.setAccessType(token.getTokenValue());
            this.lexer.SPorHT();
            {
                boolean var23D2B54EEDE70417D1C6C30933AF4A72_173398952 = (lexer.lookAhead(0) == ';');
                {
                    this.lexer.match(';');
                    this.lexer.SPorHT();
                    NameValue nv;
                    nv = super.nameValue('=');
                    accessNetworkInfo.setParameter(nv);
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
            this.lexer.SPorHT();
            this.lexer.match('\n');
        } //End block
        finally 
        {
            dbg_leave("AccessNetworkInfoParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

