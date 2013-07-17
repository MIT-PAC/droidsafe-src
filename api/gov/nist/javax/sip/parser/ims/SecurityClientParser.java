package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.SecurityClient;
import gov.nist.javax.sip.header.ims.SecurityClientList;

public class SecurityClientParser extends SecurityAgreeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.128 -0400", hash_original_method = "E2D388149FE9736EADC08BE8FFBB13F8", hash_generated_method = "338363101D37C6DD7911DD28C276ACE3")
    public  SecurityClientParser(String security) {
        super(security);
        addTaint(security.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.128 -0400", hash_original_method = "B40BF36519F1C74126A52BAB65D2C065", hash_generated_method = "730B14938AD7118FD56495E86859CCE3")
    protected  SecurityClientParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.129 -0400", hash_original_method = "318B353FBE96AE207EFBEBC9BA5B16DF", hash_generated_method = "F7F9D190F098C1B20EB97BBC1ED1B6BF")
    public SIPHeader parse() throws ParseException {
        dbg_enter("SecuriryClient parse");
        try 
        {
            headerName(TokenTypes.SECURITY_CLIENT);
            SecurityClient secClient = new SecurityClient();
            SecurityClientList secClientList = (SecurityClientList) super.parse(secClient);
SIPHeader var33F97F0534ED87D4698193390FEFEC61_717530937 =             secClientList;
            var33F97F0534ED87D4698193390FEFEC61_717530937.addTaint(taint);
            return var33F97F0534ED87D4698193390FEFEC61_717530937;
        } //End block
        finally 
        {
            dbg_leave("SecuriryClient parse");
        } //End block
        // ---------- Original Method ----------
        //dbg_enter("SecuriryClient parse");
        //try {
            //headerName(TokenTypes.SECURITY_CLIENT);
            //SecurityClient secClient = new SecurityClient();
            //SecurityClientList secClientList =
                //(SecurityClientList) super.parse(secClient);
            //return secClientList;
        //} finally {
            //dbg_leave("SecuriryClient parse");
        //}
    }

    
}

