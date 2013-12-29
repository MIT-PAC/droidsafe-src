package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ProxyAuthenticate;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ProxyAuthenticateParser extends ChallengeParser {

    /**
     * Constructor
     * @param proxyAuthenticate message to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.182 -0500", hash_original_method = "581BDEBBD299AB0E5135A7CDD0C8C9B1", hash_generated_method = "787F5B20A8028E6D2D8DA7552C2C58CC")
    public ProxyAuthenticateParser(String proxyAuthenticate) {
        super(proxyAuthenticate);
    }

    /**
     * Cosntructor
     * @param Lexer lexer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.183 -0500", hash_original_method = "31FFFD362F12BC1F7E1E79481AA610B2", hash_generated_method = "21804429EDEC909F70939E89C9EE6CC1")
    protected ProxyAuthenticateParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (ProxyAuthenticate object)
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.184 -0500", hash_original_method = "EBFDF03354240070ED50C53BEBC6AA29", hash_generated_method = "EC8949E43E6219B41CA57D2AB2395ACE")
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.PROXY_AUTHENTICATE);
        ProxyAuthenticate proxyAuthenticate = new ProxyAuthenticate();
        super.parse(proxyAuthenticate);
        return proxyAuthenticate;
    }

    
}

