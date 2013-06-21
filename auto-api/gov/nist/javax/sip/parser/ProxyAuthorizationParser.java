package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ProxyAuthorizationParser extends ChallengeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.483 -0400", hash_original_method = "CDA3ED04E7711730A0C66D18484FDB95", hash_generated_method = "1CA1E2551D0769F63AC0CD3809723F88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyAuthorizationParser(String proxyAuthorization) {
        super(proxyAuthorization);
        dsTaint.addTaint(proxyAuthorization);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.483 -0400", hash_original_method = "0B87CA7A37542B21EADB20D98FA713C9", hash_generated_method = "FF728405EACF2D712517C20FB3ADEABB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ProxyAuthorizationParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.484 -0400", hash_original_method = "757B0B5247A462A428C431641FB2F7EC", hash_generated_method = "EDF4F61D07197873797BD8EA73F3FC2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.PROXY_AUTHORIZATION);
        ProxyAuthorization proxyAuth;
        proxyAuth = new ProxyAuthorization();
        super.parse(proxyAuth);
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //headerName(TokenTypes.PROXY_AUTHORIZATION);
        //ProxyAuthorization proxyAuth = new ProxyAuthorization();
        //super.parse(proxyAuth);
        //return proxyAuth;
    }

    
}

