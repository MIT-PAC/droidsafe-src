package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.SecurityServer;
import gov.nist.javax.sip.header.ims.SecurityServerList;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class SecurityServerParser extends SecurityAgreeParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.437 -0500", hash_original_method = "EBB6BB53A10E0F1A8657B34A448B18C2", hash_generated_method = "7C2E1023BF6F576BC6CDDFE6A3FEB166")
    public SecurityServerParser(String security)
    {
        super(security);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.438 -0500", hash_original_method = "D5BEE34024C115E4BF9000E8D6C9EF40", hash_generated_method = "EEB75102CECAD9A8F20F13BE679E0D93")
    protected SecurityServerParser(Lexer lexer)
    {
        super(lexer);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.439 -0500", hash_original_method = "D13B425AB735200FDF4CA1BC2B455C90", hash_generated_method = "C08FDC6EBC402FDB0F433393CD66E10C")
    public SIPHeader parse() throws ParseException
    {
        dbg_enter("SecuriryServer parse");
        try {

            headerName(TokenTypes.SECURITY_SERVER);
            SecurityServer secServer = new SecurityServer();
            SecurityServerList secServerList =
                (SecurityServerList) super.parse(secServer);
            return secServerList;

        } finally {
            dbg_leave("SecuriryServer parse");
        }
    }

    
}

