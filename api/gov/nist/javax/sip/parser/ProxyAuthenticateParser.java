package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.header.ProxyAuthenticate;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ProxyAuthenticateParser extends ChallengeParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.347 -0400", hash_original_method = "581BDEBBD299AB0E5135A7CDD0C8C9B1", hash_generated_method = "CF83D4E1378EBF47C4D5202332A2C120")
    public  ProxyAuthenticateParser(String proxyAuthenticate) {
        super(proxyAuthenticate);
        addTaint(proxyAuthenticate.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.348 -0400", hash_original_method = "31FFFD362F12BC1F7E1E79481AA610B2", hash_generated_method = "4EB66B1C980DD68F479690AB3A750989")
    protected  ProxyAuthenticateParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.349 -0400", hash_original_method = "EBFDF03354240070ED50C53BEBC6AA29", hash_generated_method = "D1AD74C25B1A331CCF801D067770D44B")
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.PROXY_AUTHENTICATE);
        ProxyAuthenticate proxyAuthenticate = new ProxyAuthenticate();
        super.parse(proxyAuthenticate);
SIPHeader var4031BD8BE5A0F3F4514FF0093E626D68_627333191 =         proxyAuthenticate;
        var4031BD8BE5A0F3F4514FF0093E626D68_627333191.addTaint(taint);
        return var4031BD8BE5A0F3F4514FF0093E626D68_627333191;
        // ---------- Original Method ----------
        //headerName(TokenTypes.PROXY_AUTHENTICATE);
        //ProxyAuthenticate proxyAuthenticate = new ProxyAuthenticate();
        //super.parse(proxyAuthenticate);
        //return proxyAuthenticate;
    }

    
}

