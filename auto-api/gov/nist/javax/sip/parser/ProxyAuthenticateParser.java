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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.480 -0400", hash_original_method = "581BDEBBD299AB0E5135A7CDD0C8C9B1", hash_generated_method = "9C99F0123E55451FCA57EEB4F13C3683")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyAuthenticateParser(String proxyAuthenticate) {
        super(proxyAuthenticate);
        dsTaint.addTaint(proxyAuthenticate);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.480 -0400", hash_original_method = "31FFFD362F12BC1F7E1E79481AA610B2", hash_generated_method = "A5F048BE65E0E408013D8EAC881EA412")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ProxyAuthenticateParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.481 -0400", hash_original_method = "EBFDF03354240070ED50C53BEBC6AA29", hash_generated_method = "0C7F61F3280DB42C45860A20FD035ED1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.PROXY_AUTHENTICATE);
        ProxyAuthenticate proxyAuthenticate;
        proxyAuthenticate = new ProxyAuthenticate();
        super.parse(proxyAuthenticate);
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //headerName(TokenTypes.PROXY_AUTHENTICATE);
        //ProxyAuthenticate proxyAuthenticate = new ProxyAuthenticate();
        //super.parse(proxyAuthenticate);
        //return proxyAuthenticate;
    }

    
}

