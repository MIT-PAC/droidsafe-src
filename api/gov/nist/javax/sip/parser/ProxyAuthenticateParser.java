package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ProxyAuthenticateParser extends ChallengeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.468 -0400", hash_original_method = "581BDEBBD299AB0E5135A7CDD0C8C9B1", hash_generated_method = "CF83D4E1378EBF47C4D5202332A2C120")
    public  ProxyAuthenticateParser(String proxyAuthenticate) {
        super(proxyAuthenticate);
        addTaint(proxyAuthenticate.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.468 -0400", hash_original_method = "31FFFD362F12BC1F7E1E79481AA610B2", hash_generated_method = "4EB66B1C980DD68F479690AB3A750989")
    protected  ProxyAuthenticateParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.468 -0400", hash_original_method = "EBFDF03354240070ED50C53BEBC6AA29", hash_generated_method = "8694D63A39CA05254E393AD440DED2B7")
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.PROXY_AUTHENTICATE);
        ProxyAuthenticate proxyAuthenticate = new ProxyAuthenticate();
        super.parse(proxyAuthenticate);
SIPHeader var4031BD8BE5A0F3F4514FF0093E626D68_784789598 =         proxyAuthenticate;
        var4031BD8BE5A0F3F4514FF0093E626D68_784789598.addTaint(taint);
        return var4031BD8BE5A0F3F4514FF0093E626D68_784789598;
        // ---------- Original Method ----------
        //headerName(TokenTypes.PROXY_AUTHENTICATE);
        //ProxyAuthenticate proxyAuthenticate = new ProxyAuthenticate();
        //super.parse(proxyAuthenticate);
        //return proxyAuthenticate;
    }

    
}

