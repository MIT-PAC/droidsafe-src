package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.SecurityServerList;
import gov.nist.javax.sip.header.ims.SecurityServer;

public class SecurityServerParser extends SecurityAgreeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.136 -0400", hash_original_method = "EBB6BB53A10E0F1A8657B34A448B18C2", hash_generated_method = "CCEEACA957F6E42F53D7C327B0BCEDBF")
    public  SecurityServerParser(String security) {
        super(security);
        addTaint(security.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.137 -0400", hash_original_method = "D5BEE34024C115E4BF9000E8D6C9EF40", hash_generated_method = "475290DD4470C2BA91A31245AAE1D823")
    protected  SecurityServerParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.137 -0400", hash_original_method = "D13B425AB735200FDF4CA1BC2B455C90", hash_generated_method = "E9FDCC6A5057D3DE31A98B715A08315D")
    public SIPHeader parse() throws ParseException {
        dbg_enter("SecuriryServer parse");
        try 
        {
            headerName(TokenTypes.SECURITY_SERVER);
            SecurityServer secServer = new SecurityServer();
            SecurityServerList secServerList = (SecurityServerList) super.parse(secServer);
SIPHeader varDB403FA0ABA7A17094DA8787E6D0FF7C_1079728869 =             secServerList;
            varDB403FA0ABA7A17094DA8787E6D0FF7C_1079728869.addTaint(taint);
            return varDB403FA0ABA7A17094DA8787E6D0FF7C_1079728869;
        } //End block
        finally 
        {
            dbg_leave("SecuriryServer parse");
        } //End block
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

