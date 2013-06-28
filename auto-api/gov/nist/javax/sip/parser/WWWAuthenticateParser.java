package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;

public class WWWAuthenticateParser extends ChallengeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.966 -0400", hash_original_method = "6138AB6ABE323397A90992BBA6CE68F7", hash_generated_method = "DFAFC5424B5FCEDA507EF61D6EC4EE97")
    public  WWWAuthenticateParser(String wwwAuthenticate) {
        super(wwwAuthenticate);
        addTaint(wwwAuthenticate.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.967 -0400", hash_original_method = "3C6BB1F0E541627B3210DAEB9F57410E", hash_generated_method = "E9EEE9E934149667B1F4EEFCD7537F23")
    protected  WWWAuthenticateParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.967 -0400", hash_original_method = "21D63394A7F5FCF103E716C1D0FF5141", hash_generated_method = "B1F0858FC7074D7A63534BEDB6D523E9")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_626553035 = null; //Variable for return #1
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.WWW_AUTHENTICATE);
            WWWAuthenticate wwwAuthenticate = new WWWAuthenticate();
            super.parse(wwwAuthenticate);
            varB4EAC82CA7396A68D541C85D26508E83_626553035 = wwwAuthenticate;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_626553035.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_626553035;
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("parse");
        //try {
            //headerName(TokenTypes.WWW_AUTHENTICATE);
            //WWWAuthenticate wwwAuthenticate = new WWWAuthenticate();
            //super.parse(wwwAuthenticate);
            //return wwwAuthenticate;
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
    }

    
}

