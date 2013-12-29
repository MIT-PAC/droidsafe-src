package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.SecurityVerify;
import gov.nist.javax.sip.header.ims.SecurityVerifyList;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class SecurityVerifyParser extends SecurityAgreeParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.449 -0500", hash_original_method = "BCFA55D46A541D95C3FC5F794766C9E2", hash_generated_method = "215709E5DA8185B8D887FDC7FF36B6DA")
    public SecurityVerifyParser(String security)
    {
        super(security);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.450 -0500", hash_original_method = "DBB46518F45FFBB63E0CEF5174A1D8CA", hash_generated_method = "893DDCC42ECDD670233430935D77FA09")
    protected SecurityVerifyParser(Lexer lexer)
    {
        super(lexer);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.451 -0500", hash_original_method = "AF5E151367487D790A8CFB3D3D9DB14C", hash_generated_method = "9D64D0E16BF52D887433A80A17CB5C0B")
    public SIPHeader parse() throws ParseException
    {
        dbg_enter("SecuriryVerify parse");
        try {

            headerName(TokenTypes.SECURITY_VERIFY);
            SecurityVerify secVerify = new SecurityVerify();
            SecurityVerifyList secVerifyList =
                (SecurityVerifyList) super.parse(secVerify);
            return secVerifyList;

        } finally {
            dbg_leave("SecuriryVerify parse");
        }
    }

    
}

