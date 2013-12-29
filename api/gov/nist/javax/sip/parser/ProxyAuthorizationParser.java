package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ProxyAuthorization;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ProxyAuthorizationParser extends ChallengeParser {

    /**
     * Constructor
     * @param proxyAuthorization --  header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.402 -0500", hash_original_method = "CDA3ED04E7711730A0C66D18484FDB95", hash_generated_method = "DBB0443BF016DCA27D5FE6F58FF8AC8F")
    public ProxyAuthorizationParser(String proxyAuthorization) {
        super(proxyAuthorization);
    }

    /**
     * Cosntructor
     * @param Lexer lexer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.403 -0500", hash_original_method = "0B87CA7A37542B21EADB20D98FA713C9", hash_generated_method = "DC30F8CF0A7C6AE65C54D088EB0BE26A")
    protected ProxyAuthorizationParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (ProxyAuthenticate object)
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.404 -0500", hash_original_method = "757B0B5247A462A428C431641FB2F7EC", hash_generated_method = "01D5C22C4DBCD3465D3B96462517B329")
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.PROXY_AUTHORIZATION);
        ProxyAuthorization proxyAuth = new ProxyAuthorization();
        super.parse(proxyAuth);
        return proxyAuth;
    }

    
}

