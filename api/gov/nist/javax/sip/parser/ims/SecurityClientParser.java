package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.SecurityClient;
import gov.nist.javax.sip.header.ims.SecurityClientList;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class SecurityClientParser extends SecurityAgreeParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.290 -0500", hash_original_method = "E2D388149FE9736EADC08BE8FFBB13F8", hash_generated_method = "2903E4AB8997FB87EFFDCF4957C6E94F")
    public SecurityClientParser(String security)
    {
        super(security);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.291 -0500", hash_original_method = "B40BF36519F1C74126A52BAB65D2C065", hash_generated_method = "BD894119187217F5A8D8DBDA47000B50")
    protected SecurityClientParser(Lexer lexer)
    {
        super(lexer);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.293 -0500", hash_original_method = "318B353FBE96AE207EFBEBC9BA5B16DF", hash_generated_method = "A5E9FC3073E997E10CFBE9567FAF2104")
    public SIPHeader parse() throws ParseException
    {
        dbg_enter("SecuriryClient parse");
        try {

            headerName(TokenTypes.SECURITY_CLIENT);
            SecurityClient secClient = new SecurityClient();
            SecurityClientList secClientList =
                (SecurityClientList) super.parse(secClient);
            return secClientList;


        } finally {
            dbg_leave("SecuriryClient parse");
        }
    }

    
}

