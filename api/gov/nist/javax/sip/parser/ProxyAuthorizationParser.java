package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ProxyAuthorizationParser extends ChallengeParser {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.475 -0400", hash_original_method = "CDA3ED04E7711730A0C66D18484FDB95", hash_generated_method = "A3AE2FC98E9EF6893ADC4D477F2329B5")
    public  ProxyAuthorizationParser(String proxyAuthorization) {
        super(proxyAuthorization);
        addTaint(proxyAuthorization.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.475 -0400", hash_original_method = "0B87CA7A37542B21EADB20D98FA713C9", hash_generated_method = "3905E0369F89EADC577BB6001B32327B")
    protected  ProxyAuthorizationParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.476 -0400", hash_original_method = "757B0B5247A462A428C431641FB2F7EC", hash_generated_method = "4528E9ABC7A3FD7D439B75050EA2482C")
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.PROXY_AUTHORIZATION);
        ProxyAuthorization proxyAuth = new ProxyAuthorization();
        super.parse(proxyAuth);
SIPHeader var4099AE2502A0C7554C07AA80DE221214_136736614 =         proxyAuth;
        var4099AE2502A0C7554C07AA80DE221214_136736614.addTaint(taint);
        return var4099AE2502A0C7554C07AA80DE221214_136736614;
        // ---------- Original Method ----------
        //headerName(TokenTypes.PROXY_AUTHORIZATION);
        //ProxyAuthorization proxyAuth = new ProxyAuthorization();
        //super.parse(proxyAuth);
        //return proxyAuth;
    }

    
}

