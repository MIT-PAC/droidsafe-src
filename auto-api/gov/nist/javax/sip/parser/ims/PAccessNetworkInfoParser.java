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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.588 -0400", hash_original_method = "6DB4AD794C60B8862A83AFB0C9C82A92", hash_generated_method = "0626EAFE4B05112392B453E5EB07C05A")
    public  PAccessNetworkInfoParser(String accessNetwork) {
        super(accessNetwork);
        addTaint(accessNetwork.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.588 -0400", hash_original_method = "3B0D9C588403AF5495F889BAEC6E0FEE", hash_generated_method = "68D1D3CFA3C0BDE696C93371CF1A8F52")
    protected  PAccessNetworkInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.595 -0400", hash_original_method = "0BB1DE6FBD7AB2CBAE3BF43510D39D52", hash_generated_method = "003585C682C32B44207587FA9ACC02BA")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1994411065 = null; //Variable for return #1
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
                boolean var23D2B54EEDE70417D1C6C30933AF4A72_922019781 = (lexer.lookAhead(0) == ';');
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
            varB4EAC82CA7396A68D541C85D26508E83_1994411065 = accessNetworkInfo;
        } //End block
        finally 
        {
            dbg_leave("AccessNetworkInfoParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1994411065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1994411065;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

