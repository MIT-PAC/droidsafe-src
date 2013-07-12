package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class AuthorizationParser extends ChallengeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.874 -0400", hash_original_method = "4106C62632F233034B416151FC55AB70", hash_generated_method = "3092B0DAC3CDE6D170500DA230757B69")
    public  AuthorizationParser(String authorization) {
        super(authorization);
        addTaint(authorization.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.875 -0400", hash_original_method = "7F449A569D89A06236BD64E3F6673F37", hash_generated_method = "00443B949EC1F60812EEABFFF68A8C76")
    protected  AuthorizationParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.877 -0400", hash_original_method = "EB9857D021AE5F251F44C2032AC6D5E3", hash_generated_method = "384C13E1863AFA3006496435A13696A7")
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.AUTHORIZATION);
            Authorization auth = new Authorization();
            super.parse(auth);
SIPHeader varFE2A4E660D0434D283705BEC4309B2E4_544947949 =             auth;
            varFE2A4E660D0434D283705BEC4309B2E4_544947949.addTaint(taint);
            return varFE2A4E660D0434D283705BEC4309B2E4_544947949;
        } 
        finally 
        {
            dbg_leave("parse");
        } 
        
        
        
            
            
            
            
        
            
        
    }

    
}

