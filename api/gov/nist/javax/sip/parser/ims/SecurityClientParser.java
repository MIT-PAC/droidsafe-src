package gov.nist.javax.sip.parser.ims;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.306 -0400", hash_original_method = "E2D388149FE9736EADC08BE8FFBB13F8", hash_generated_method = "338363101D37C6DD7911DD28C276ACE3")
    public  SecurityClientParser(String security) {
        super(security);
        addTaint(security.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.306 -0400", hash_original_method = "B40BF36519F1C74126A52BAB65D2C065", hash_generated_method = "730B14938AD7118FD56495E86859CCE3")
    protected  SecurityClientParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.307 -0400", hash_original_method = "318B353FBE96AE207EFBEBC9BA5B16DF", hash_generated_method = "99112419201FE4580D58D2A7B9294E47")
    public SIPHeader parse() throws ParseException {
        dbg_enter("SecuriryClient parse");
        try 
        {
            headerName(TokenTypes.SECURITY_CLIENT);
            SecurityClient secClient = new SecurityClient();
            SecurityClientList secClientList = (SecurityClientList) super.parse(secClient);
SIPHeader var33F97F0534ED87D4698193390FEFEC61_1207043080 =             secClientList;
            var33F97F0534ED87D4698193390FEFEC61_1207043080.addTaint(taint);
            return var33F97F0534ED87D4698193390FEFEC61_1207043080;
        } 
        finally 
        {
            dbg_leave("SecuriryClient parse");
        } 
        
        
        
            
            
            
                
            
        
            
        
    }

    
}

