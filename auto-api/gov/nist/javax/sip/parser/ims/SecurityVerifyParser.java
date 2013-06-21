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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.794 -0400", hash_original_method = "BCFA55D46A541D95C3FC5F794766C9E2", hash_generated_method = "BD11BEFDE8DE28F3D1A1B25D7C5478C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityVerifyParser(String security) {
        super(security);
        dsTaint.addTaint(security);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.794 -0400", hash_original_method = "DBB46518F45FFBB63E0CEF5174A1D8CA", hash_generated_method = "A3310783DB9CCEA9B86FDF30EB0BB636")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SecurityVerifyParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.794 -0400", hash_original_method = "AF5E151367487D790A8CFB3D3D9DB14C", hash_generated_method = "8110F00B9A3135E8FBBB96EC74936BD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("SecuriryVerify parse");
        try 
        {
            headerName(TokenTypes.SECURITY_VERIFY);
            SecurityVerify secVerify;
            secVerify = new SecurityVerify();
            SecurityVerifyList secVerifyList;
            secVerifyList = (SecurityVerifyList) super.parse(secVerify);
        } //End block
        finally 
        {
            dbg_leave("SecuriryVerify parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

