package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.SecurityServerList;
import gov.nist.javax.sip.header.ims.SecurityServer;

public class SecurityServerParser extends SecurityAgreeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.223 -0400", hash_original_method = "EBB6BB53A10E0F1A8657B34A448B18C2", hash_generated_method = "CCEEACA957F6E42F53D7C327B0BCEDBF")
    public  SecurityServerParser(String security) {
        super(security);
        addTaint(security.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.223 -0400", hash_original_method = "D5BEE34024C115E4BF9000E8D6C9EF40", hash_generated_method = "475290DD4470C2BA91A31245AAE1D823")
    protected  SecurityServerParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.223 -0400", hash_original_method = "D13B425AB735200FDF4CA1BC2B455C90", hash_generated_method = "81B6095ED8E8FF8E4CFFE38C79099776")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_889714700 = null; 
        dbg_enter("SecuriryServer parse");
        try 
        {
            headerName(TokenTypes.SECURITY_SERVER);
            SecurityServer secServer = new SecurityServer();
            SecurityServerList secServerList = (SecurityServerList) super.parse(secServer);
            varB4EAC82CA7396A68D541C85D26508E83_889714700 = secServerList;
        } 
        finally 
        {
            dbg_leave("SecuriryServer parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_889714700.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_889714700;
        
        
        
            
            
            
                
            
        
            
        
    }

    
}

