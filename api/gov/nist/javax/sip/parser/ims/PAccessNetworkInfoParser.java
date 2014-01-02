package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.340 -0500", hash_original_method = "6DB4AD794C60B8862A83AFB0C9C82A92", hash_generated_method = "960DD40D8B0EFCA08D0C8B036F4B827B")
    
public PAccessNetworkInfoParser(String accessNetwork) {

        super(accessNetwork);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.343 -0500", hash_original_method = "3B0D9C588403AF5495F889BAEC6E0FEE", hash_generated_method = "FDC0497ADED185D8FDAB60A275375039")
    
protected PAccessNetworkInfoParser(Lexer lexer) {
        super(lexer);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.346 -0500", hash_original_method = "0BB1DE6FBD7AB2CBAE3BF43510D39D52", hash_generated_method = "DDF76B56C03A40D5E75E3774146FF54D")
    
public SIPHeader parse() throws ParseException
    {

        if (debug)
            dbg_enter("AccessNetworkInfoParser.parse");
        try {
            headerName(TokenTypes.P_ACCESS_NETWORK_INFO);
            PAccessNetworkInfo accessNetworkInfo = new PAccessNetworkInfo();
            accessNetworkInfo.setHeaderName(SIPHeaderNamesIms.P_ACCESS_NETWORK_INFO);

            this.lexer.SPorHT();
            lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            accessNetworkInfo.setAccessType(token.getTokenValue());

            this.lexer.SPorHT();
            while (lexer.lookAhead(0) == ';') {
                this.lexer.match(';');
                this.lexer.SPorHT();

                NameValue nv = super.nameValue('=');
                accessNetworkInfo.setParameter(nv);
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match('\n');


            return accessNetworkInfo;
        } finally {
            if (debug)
                dbg_leave("AccessNetworkInfoParser.parse");
        }

    }

    
}

