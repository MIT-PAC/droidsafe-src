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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.242 -0400", hash_original_method = "4106C62632F233034B416151FC55AB70", hash_generated_method = "5CC901C0D6F70254675520AE9B25A8F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthorizationParser(String authorization) {
        super(authorization);
        dsTaint.addTaint(authorization);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.242 -0400", hash_original_method = "7F449A569D89A06236BD64E3F6673F37", hash_generated_method = "EC6F65F8EFBA7B3F111FA7C7C65B8074")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AuthorizationParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.242 -0400", hash_original_method = "EB9857D021AE5F251F44C2032AC6D5E3", hash_generated_method = "AE66A2BD2FE0458E9FEBF823C2828310")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.AUTHORIZATION);
            Authorization auth;
            auth = new Authorization();
            super.parse(auth);
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

