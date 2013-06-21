package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.SecurityClient;
import gov.nist.javax.sip.header.ims.SecurityClientList;

public class SecurityClientParser extends SecurityAgreeParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.789 -0400", hash_original_method = "E2D388149FE9736EADC08BE8FFBB13F8", hash_generated_method = "203E41B63D25478CAAE73D23DD6E30E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityClientParser(String security) {
        super(security);
        dsTaint.addTaint(security);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.789 -0400", hash_original_method = "B40BF36519F1C74126A52BAB65D2C065", hash_generated_method = "F41CD64DB55421B7E197188BA7182EE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SecurityClientParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.789 -0400", hash_original_method = "318B353FBE96AE207EFBEBC9BA5B16DF", hash_generated_method = "F490C136D38D45296D202B65621D5A77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("SecuriryClient parse");
        try 
        {
            headerName(TokenTypes.SECURITY_CLIENT);
            SecurityClient secClient;
            secClient = new SecurityClient();
            SecurityClientList secClientList;
            secClientList = (SecurityClientList) super.parse(secClient);
        } //End block
        finally 
        {
            dbg_leave("SecuriryClient parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //dbg_enter("SecuriryClient parse");
        //try {
            //headerName(TokenTypes.SECURITY_CLIENT);
            //SecurityClient secClient = new SecurityClient();
            //SecurityClientList secClientList =
                //(SecurityClientList) super.parse(secClient);
            //return secClientList;
        //} finally {
            //dbg_leave("SecuriryClient parse");
        //}
    }

    
}

