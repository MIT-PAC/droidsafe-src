package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ProxyAuthenticateParser extends ChallengeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.422 -0400", hash_original_method = "581BDEBBD299AB0E5135A7CDD0C8C9B1", hash_generated_method = "CF83D4E1378EBF47C4D5202332A2C120")
    public  ProxyAuthenticateParser(String proxyAuthenticate) {
        super(proxyAuthenticate);
        addTaint(proxyAuthenticate.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.422 -0400", hash_original_method = "31FFFD362F12BC1F7E1E79481AA610B2", hash_generated_method = "4EB66B1C980DD68F479690AB3A750989")
    protected  ProxyAuthenticateParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.423 -0400", hash_original_method = "EBFDF03354240070ED50C53BEBC6AA29", hash_generated_method = "5246D65E7EF5B907FAA70F6C49AA5F28")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1984404403 = null; //Variable for return #1
        headerName(TokenTypes.PROXY_AUTHENTICATE);
        ProxyAuthenticate proxyAuthenticate = new ProxyAuthenticate();
        super.parse(proxyAuthenticate);
        varB4EAC82CA7396A68D541C85D26508E83_1984404403 = proxyAuthenticate;
        varB4EAC82CA7396A68D541C85D26508E83_1984404403.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1984404403;
        // ---------- Original Method ----------
        //headerName(TokenTypes.PROXY_AUTHENTICATE);
        //ProxyAuthenticate proxyAuthenticate = new ProxyAuthenticate();
        //super.parse(proxyAuthenticate);
        //return proxyAuthenticate;
    }

    
}

