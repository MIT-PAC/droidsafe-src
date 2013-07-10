package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class AuthenticationInfoParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.760 -0400", hash_original_method = "F28ABF8CFF04CC1C57BCD4E014C95C2B", hash_generated_method = "4D29FE7F36335FA05C3B36A828DB26AC")
    public  AuthenticationInfoParser(String authenticationInfo) {
        super(authenticationInfo);
        addTaint(authenticationInfo.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.761 -0400", hash_original_method = "49A5BC0E10B199942A909086CCB53299", hash_generated_method = "F575724D8379F4722AEB97946F517A74")
    protected  AuthenticationInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.761 -0400", hash_original_method = "2DCD0228D3AB6B3B6D80756266EB3403", hash_generated_method = "51F7D366B375741C38F2D2F70D5A5142")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1733581164 = null; 
        dbg_enter("AuthenticationInfoParser.parse");
        try 
        {
            headerName(TokenTypes.AUTHENTICATION_INFO);
            AuthenticationInfo authenticationInfo = new AuthenticationInfo();
            authenticationInfo.setHeaderName(
                SIPHeaderNames.AUTHENTICATION_INFO);
            this.lexer.SPorHT();
            NameValue nv = super.nameValue();
            authenticationInfo.setParameter(nv);
            this.lexer.SPorHT();
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_260085178 = (lexer.lookAhead(0) == ',');
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    nv = super.nameValue();
                    authenticationInfo.setParameter(nv);
                    this.lexer.SPorHT();
                } 
            } 
            this.lexer.SPorHT();
            varB4EAC82CA7396A68D541C85D26508E83_1733581164 = authenticationInfo;
        } 
        finally 
        {
            dbg_leave("AuthenticationInfoParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1733581164.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1733581164;
        
        
    }

    
}

