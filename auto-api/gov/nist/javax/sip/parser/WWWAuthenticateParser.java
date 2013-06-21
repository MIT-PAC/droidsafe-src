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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.711 -0400", hash_original_method = "6138AB6ABE323397A90992BBA6CE68F7", hash_generated_method = "B99FBE499130392D2BC937124E9C463A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WWWAuthenticateParser(String wwwAuthenticate) {
        super(wwwAuthenticate);
        dsTaint.addTaint(wwwAuthenticate);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.712 -0400", hash_original_method = "3C6BB1F0E541627B3210DAEB9F57410E", hash_generated_method = "191E665202AE6168565E89DFC977D3A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected WWWAuthenticateParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.712 -0400", hash_original_method = "21D63394A7F5FCF103E716C1D0FF5141", hash_generated_method = "0430A4E8DBB735E8D39311FA670F1C3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.WWW_AUTHENTICATE);
            WWWAuthenticate wwwAuthenticate;
            wwwAuthenticate = new WWWAuthenticate();
            super.parse(wwwAuthenticate);
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

