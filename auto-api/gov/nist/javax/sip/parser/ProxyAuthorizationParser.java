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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.429 -0400", hash_original_method = "CDA3ED04E7711730A0C66D18484FDB95", hash_generated_method = "A3AE2FC98E9EF6893ADC4D477F2329B5")
    public  ProxyAuthorizationParser(String proxyAuthorization) {
        super(proxyAuthorization);
        addTaint(proxyAuthorization.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.429 -0400", hash_original_method = "0B87CA7A37542B21EADB20D98FA713C9", hash_generated_method = "3905E0369F89EADC577BB6001B32327B")
    protected  ProxyAuthorizationParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.430 -0400", hash_original_method = "757B0B5247A462A428C431641FB2F7EC", hash_generated_method = "2AA5F5DC431F050F8C8CD06CF3B7EF7C")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_825944999 = null; //Variable for return #1
        headerName(TokenTypes.PROXY_AUTHORIZATION);
        ProxyAuthorization proxyAuth = new ProxyAuthorization();
        super.parse(proxyAuth);
        varB4EAC82CA7396A68D541C85D26508E83_825944999 = proxyAuth;
        varB4EAC82CA7396A68D541C85D26508E83_825944999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_825944999;
        // ---------- Original Method ----------
        //headerName(TokenTypes.PROXY_AUTHORIZATION);
        //ProxyAuthorization proxyAuth = new ProxyAuthorization();
        //super.parse(proxyAuth);
        //return proxyAuth;
    }

    
}

