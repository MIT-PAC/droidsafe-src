package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.SecurityVerify;
import gov.nist.javax.sip.header.ims.SecurityVerifyList;

public class SecurityVerifyParser extends SecurityAgreeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.229 -0400", hash_original_method = "BCFA55D46A541D95C3FC5F794766C9E2", hash_generated_method = "337A1AF37D0033800B875D00B549A93B")
    public  SecurityVerifyParser(String security) {
        super(security);
        addTaint(security.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.229 -0400", hash_original_method = "DBB46518F45FFBB63E0CEF5174A1D8CA", hash_generated_method = "54704F2AE7D7B1EB9D6B3709AD237588")
    protected  SecurityVerifyParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.230 -0400", hash_original_method = "AF5E151367487D790A8CFB3D3D9DB14C", hash_generated_method = "43C0E4E3D30B26852A5318E5E00643F9")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1442906326 = null; //Variable for return #1
        dbg_enter("SecuriryVerify parse");
        try 
        {
            headerName(TokenTypes.SECURITY_VERIFY);
            SecurityVerify secVerify = new SecurityVerify();
            SecurityVerifyList secVerifyList = (SecurityVerifyList) super.parse(secVerify);
            varB4EAC82CA7396A68D541C85D26508E83_1442906326 = secVerifyList;
        } //End block
        finally 
        {
            dbg_leave("SecuriryVerify parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1442906326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1442906326;
        // ---------- Original Method ----------
        //dbg_enter("SecuriryVerify parse");
        //try {
            //headerName(TokenTypes.SECURITY_VERIFY);
            //SecurityVerify secVerify = new SecurityVerify();
            //SecurityVerifyList secVerifyList =
                //(SecurityVerifyList) super.parse(secVerify);
            //return secVerifyList;
        //} finally {
            //dbg_leave("SecuriryVerify parse");
        //}
    }

    
}

