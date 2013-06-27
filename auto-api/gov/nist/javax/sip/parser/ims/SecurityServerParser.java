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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.836 -0400", hash_original_method = "EBB6BB53A10E0F1A8657B34A448B18C2", hash_generated_method = "CCEEACA957F6E42F53D7C327B0BCEDBF")
    public  SecurityServerParser(String security) {
        super(security);
        addTaint(security.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.836 -0400", hash_original_method = "D5BEE34024C115E4BF9000E8D6C9EF40", hash_generated_method = "475290DD4470C2BA91A31245AAE1D823")
    protected  SecurityServerParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.837 -0400", hash_original_method = "D13B425AB735200FDF4CA1BC2B455C90", hash_generated_method = "8DBD1DEDDCA5D45F5B9BD19E07DDF6B9")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_20294604 = null; //Variable for return #1
        dbg_enter("SecuriryServer parse");
        try 
        {
            headerName(TokenTypes.SECURITY_SERVER);
            SecurityServer secServer;
            secServer = new SecurityServer();
            SecurityServerList secServerList;
            secServerList = (SecurityServerList) super.parse(secServer);
            varB4EAC82CA7396A68D541C85D26508E83_20294604 = secServerList;
        } //End block
        finally 
        {
            dbg_leave("SecuriryServer parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_20294604.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_20294604;
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

