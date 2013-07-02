package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.SecurityClient;
import gov.nist.javax.sip.header.ims.SecurityClientList;

public class SecurityClientParser extends SecurityAgreeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.218 -0400", hash_original_method = "E2D388149FE9736EADC08BE8FFBB13F8", hash_generated_method = "338363101D37C6DD7911DD28C276ACE3")
    public  SecurityClientParser(String security) {
        super(security);
        addTaint(security.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.218 -0400", hash_original_method = "B40BF36519F1C74126A52BAB65D2C065", hash_generated_method = "730B14938AD7118FD56495E86859CCE3")
    protected  SecurityClientParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.219 -0400", hash_original_method = "318B353FBE96AE207EFBEBC9BA5B16DF", hash_generated_method = "C4A611EDD9CD0B4CB8C04DE1B5E1A459")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1998959311 = null; 
        dbg_enter("SecuriryClient parse");
        try 
        {
            headerName(TokenTypes.SECURITY_CLIENT);
            SecurityClient secClient = new SecurityClient();
            SecurityClientList secClientList = (SecurityClientList) super.parse(secClient);
            varB4EAC82CA7396A68D541C85D26508E83_1998959311 = secClientList;
        } 
        finally 
        {
            dbg_leave("SecuriryClient parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1998959311.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1998959311;
        
        
        
            
            
            
                
            
        
            
        
    }

    
}

