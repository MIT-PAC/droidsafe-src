package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class AuthorizationParser extends ChallengeParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.889 -0400", hash_original_method = "4106C62632F233034B416151FC55AB70", hash_generated_method = "3092B0DAC3CDE6D170500DA230757B69")
    public  AuthorizationParser(String authorization) {
        super(authorization);
        addTaint(authorization.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.890 -0400", hash_original_method = "7F449A569D89A06236BD64E3F6673F37", hash_generated_method = "00443B949EC1F60812EEABFFF68A8C76")
    protected  AuthorizationParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.891 -0400", hash_original_method = "EB9857D021AE5F251F44C2032AC6D5E3", hash_generated_method = "9EFDC96F6993BAC2EBD2F116927FCBF9")
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.AUTHORIZATION);
            Authorization auth = new Authorization();
            super.parse(auth);
SIPHeader varFE2A4E660D0434D283705BEC4309B2E4_1823073742 =             auth;
            varFE2A4E660D0434D283705BEC4309B2E4_1823073742.addTaint(taint);
            return varFE2A4E660D0434D283705BEC4309B2E4_1823073742;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        // ---------- Original Method ----------
        //dbg_enter("parse");
        //try {
            //headerName(TokenTypes.AUTHORIZATION);
            //Authorization auth = new Authorization();
            //super.parse(auth);
            //return auth;
        //} finally {
            //dbg_leave("parse");
        //}
    }

    
}

