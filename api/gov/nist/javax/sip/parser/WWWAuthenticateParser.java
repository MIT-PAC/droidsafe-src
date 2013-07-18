package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.WWWAuthenticate;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class WWWAuthenticateParser extends ChallengeParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.554 -0400", hash_original_method = "6138AB6ABE323397A90992BBA6CE68F7", hash_generated_method = "DFAFC5424B5FCEDA507EF61D6EC4EE97")
    public  WWWAuthenticateParser(String wwwAuthenticate) {
        super(wwwAuthenticate);
        addTaint(wwwAuthenticate.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.555 -0400", hash_original_method = "3C6BB1F0E541627B3210DAEB9F57410E", hash_generated_method = "E9EEE9E934149667B1F4EEFCD7537F23")
    protected  WWWAuthenticateParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.555 -0400", hash_original_method = "21D63394A7F5FCF103E716C1D0FF5141", hash_generated_method = "66FB4B03207845BB5C72D142937CF99D")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.WWW_AUTHENTICATE);
            WWWAuthenticate wwwAuthenticate = new WWWAuthenticate();
            super.parse(wwwAuthenticate);
SIPHeader varBCB9696E34DE6C6E990E36231F1734E3_1700765096 =             wwwAuthenticate;
            varBCB9696E34DE6C6E990E36231F1734E3_1700765096.addTaint(taint);
            return varBCB9696E34DE6C6E990E36231F1734E3_1700765096;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("parse");
        } //End block
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

