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
import gov.nist.javax.sip.header.ims.SecurityServerList;
import gov.nist.javax.sip.header.ims.SecurityServer;

public class SecurityServerParser extends SecurityAgreeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.792 -0400", hash_original_method = "EBB6BB53A10E0F1A8657B34A448B18C2", hash_generated_method = "BC524B8876FFD5D48E3D56B8FA2EB98E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityServerParser(String security) {
        super(security);
        dsTaint.addTaint(security);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.792 -0400", hash_original_method = "D5BEE34024C115E4BF9000E8D6C9EF40", hash_generated_method = "83D4A7FD3D1CF602D48675C21168447D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SecurityServerParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.792 -0400", hash_original_method = "D13B425AB735200FDF4CA1BC2B455C90", hash_generated_method = "BCEA69655C6B54F53761735F3CBA96B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("SecuriryServer parse");
        try 
        {
            headerName(TokenTypes.SECURITY_SERVER);
            SecurityServer secServer;
            secServer = new SecurityServer();
            SecurityServerList secServerList;
            secServerList = (SecurityServerList) super.parse(secServer);
        } //End block
        finally 
        {
            dbg_leave("SecuriryServer parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //dbg_enter("SecuriryServer parse");
        //try {
            //headerName(TokenTypes.SECURITY_SERVER);
            //SecurityServer secServer = new SecurityServer();
            //SecurityServerList secServerList =
                //(SecurityServerList) super.parse(secServer);
            //return secServerList;
        //} finally {
            //dbg_leave("SecuriryServer parse");
        //}
    }

    
}

