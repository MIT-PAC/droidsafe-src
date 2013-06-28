package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class AuthorizationParser extends ChallengeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.779 -0400", hash_original_method = "4106C62632F233034B416151FC55AB70", hash_generated_method = "3092B0DAC3CDE6D170500DA230757B69")
    public  AuthorizationParser(String authorization) {
        super(authorization);
        addTaint(authorization.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.779 -0400", hash_original_method = "7F449A569D89A06236BD64E3F6673F37", hash_generated_method = "00443B949EC1F60812EEABFFF68A8C76")
    protected  AuthorizationParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.779 -0400", hash_original_method = "EB9857D021AE5F251F44C2032AC6D5E3", hash_generated_method = "0719CDF3B53CE390F32964B27D0AA425")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_920081962 = null; //Variable for return #1
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.AUTHORIZATION);
            Authorization auth = new Authorization();
            super.parse(auth);
            varB4EAC82CA7396A68D541C85D26508E83_920081962 = auth;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_920081962.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_920081962;
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

