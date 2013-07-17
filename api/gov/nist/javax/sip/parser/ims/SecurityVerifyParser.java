package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.150 -0400", hash_original_method = "BCFA55D46A541D95C3FC5F794766C9E2", hash_generated_method = "337A1AF37D0033800B875D00B549A93B")
    public  SecurityVerifyParser(String security) {
        super(security);
        addTaint(security.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.151 -0400", hash_original_method = "DBB46518F45FFBB63E0CEF5174A1D8CA", hash_generated_method = "54704F2AE7D7B1EB9D6B3709AD237588")
    protected  SecurityVerifyParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.152 -0400", hash_original_method = "AF5E151367487D790A8CFB3D3D9DB14C", hash_generated_method = "2C2AF99B28D232C761CAF34A3167E7DE")
    public SIPHeader parse() throws ParseException {
        dbg_enter("SecuriryVerify parse");
        try 
        {
            headerName(TokenTypes.SECURITY_VERIFY);
            SecurityVerify secVerify = new SecurityVerify();
            SecurityVerifyList secVerifyList = (SecurityVerifyList) super.parse(secVerify);
SIPHeader var876F10E1BE6B90CF9FF5833E171F5271_1474128679 =             secVerifyList;
            var876F10E1BE6B90CF9FF5833E171F5271_1474128679.addTaint(taint);
            return var876F10E1BE6B90CF9FF5833E171F5271_1474128679;
        } //End block
        finally 
        {
            dbg_leave("SecuriryVerify parse");
        } //End block
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

