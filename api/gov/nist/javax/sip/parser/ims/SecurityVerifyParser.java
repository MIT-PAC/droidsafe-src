package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.SecurityVerify;
import gov.nist.javax.sip.header.ims.SecurityVerifyList;

public class SecurityVerifyParser extends SecurityAgreeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.329 -0400", hash_original_method = "BCFA55D46A541D95C3FC5F794766C9E2", hash_generated_method = "337A1AF37D0033800B875D00B549A93B")
    public  SecurityVerifyParser(String security) {
        super(security);
        addTaint(security.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.329 -0400", hash_original_method = "DBB46518F45FFBB63E0CEF5174A1D8CA", hash_generated_method = "54704F2AE7D7B1EB9D6B3709AD237588")
    protected  SecurityVerifyParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.330 -0400", hash_original_method = "AF5E151367487D790A8CFB3D3D9DB14C", hash_generated_method = "B0E58F642819875AC01A4071C992AE8D")
    public SIPHeader parse() throws ParseException {
        dbg_enter("SecuriryVerify parse");
        try 
        {
            headerName(TokenTypes.SECURITY_VERIFY);
            SecurityVerify secVerify = new SecurityVerify();
            SecurityVerifyList secVerifyList = (SecurityVerifyList) super.parse(secVerify);
SIPHeader var876F10E1BE6B90CF9FF5833E171F5271_1311033756 =             secVerifyList;
            var876F10E1BE6B90CF9FF5833E171F5271_1311033756.addTaint(taint);
            return var876F10E1BE6B90CF9FF5833E171F5271_1311033756;
        } 
        finally 
        {
            dbg_leave("SecuriryVerify parse");
        } 
        
        
        
            
            
            
                
            
        
            
        
    }

    
}

