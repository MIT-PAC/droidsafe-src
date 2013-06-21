package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class AuthenticationInfoParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.240 -0400", hash_original_method = "F28ABF8CFF04CC1C57BCD4E014C95C2B", hash_generated_method = "08D0677B7E4EB7DEC6B9C3628357E7D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticationInfoParser(String authenticationInfo) {
        super(authenticationInfo);
        dsTaint.addTaint(authenticationInfo);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.240 -0400", hash_original_method = "49A5BC0E10B199942A909086CCB53299", hash_generated_method = "D9BF86E801A4C23185442256E89FF254")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AuthenticationInfoParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.240 -0400", hash_original_method = "2DCD0228D3AB6B3B6D80756266EB3403", hash_generated_method = "054505AD1919BC2770197C3646953C26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("AuthenticationInfoParser.parse");
        try 
        {
            headerName(TokenTypes.AUTHENTICATION_INFO);
            AuthenticationInfo authenticationInfo;
            authenticationInfo = new AuthenticationInfo();
            authenticationInfo.setHeaderName(
                SIPHeaderNames.AUTHENTICATION_INFO);
            this.lexer.SPorHT();
            NameValue nv;
            nv = super.nameValue();
            authenticationInfo.setParameter(nv);
            this.lexer.SPorHT();
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_1823441509 = (lexer.lookAhead(0) == ',');
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    nv = super.nameValue();
                    authenticationInfo.setParameter(nv);
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
            this.lexer.SPorHT();
        } //End block
        finally 
        {
            dbg_leave("AuthenticationInfoParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

