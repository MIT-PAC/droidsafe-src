package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class AuthenticationInfoParser extends ParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.879 -0400", hash_original_method = "F28ABF8CFF04CC1C57BCD4E014C95C2B", hash_generated_method = "4D29FE7F36335FA05C3B36A828DB26AC")
    public  AuthenticationInfoParser(String authenticationInfo) {
        super(authenticationInfo);
        addTaint(authenticationInfo.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.879 -0400", hash_original_method = "49A5BC0E10B199942A909086CCB53299", hash_generated_method = "F575724D8379F4722AEB97946F517A74")
    protected  AuthenticationInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.880 -0400", hash_original_method = "2DCD0228D3AB6B3B6D80756266EB3403", hash_generated_method = "04CEC3F71304E1DA8334F764367421BA")
    public SIPHeader parse() throws ParseException {
        if(debug)        
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
            while
(lexer.lookAhead(0) == ',')            
            {
                this.lexer.match(',');
                this.lexer.SPorHT();
                nv = super.nameValue();
                authenticationInfo.setParameter(nv);
                this.lexer.SPorHT();
            } //End block
            this.lexer.SPorHT();
SIPHeader varFF3FCF7C032A2921E9A441AC36AB5087_535158606 =             authenticationInfo;
            varFF3FCF7C032A2921E9A441AC36AB5087_535158606.addTaint(taint);
            return varFF3FCF7C032A2921E9A441AC36AB5087_535158606;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("AuthenticationInfoParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

