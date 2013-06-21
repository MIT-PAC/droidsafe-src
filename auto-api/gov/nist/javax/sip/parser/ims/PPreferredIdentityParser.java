package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PPreferredIdentity;
import gov.nist.javax.sip.parser.AddressParametersParser;

public class PPreferredIdentityParser extends AddressParametersParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.771 -0400", hash_original_method = "8ED0FE4D0D4A9A77E1D41482CCFB6634", hash_generated_method = "34031EA862226FAB20CB7958DCAD4732")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PPreferredIdentityParser(String preferredIdentity) {
        super(preferredIdentity);
        dsTaint.addTaint(preferredIdentity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.771 -0400", hash_original_method = "2C53019D290466621D2FD15449F6C503", hash_generated_method = "BDFFF6F36E19904B94F47C3B5A03D6F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PPreferredIdentityParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.771 -0400", hash_original_method = "CA1397CFDA33B56E4743CDCAB79EF328", hash_generated_method = "E8A4ACB1A4DABFB760350264CAD1D9B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("PreferredIdentityParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.P_PREFERRED_IDENTITY);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            PPreferredIdentity p;
            p = new PPreferredIdentity();
            super.parse( p );
        } //End block
        finally 
        {
            dbg_leave("PreferredIdentityParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("PreferredIdentityParser.parse");
        //try {
            //this.lexer.match(TokenTypes.P_PREFERRED_IDENTITY);
            //this.lexer.SPorHT();
            //this.lexer.match(':');
            //this.lexer.SPorHT();
            //PPreferredIdentity p = new PPreferredIdentity();
            //super.parse( p );
            //return p;
        //} finally {
            //if (debug)
                //dbg_leave("PreferredIdentityParser.parse");
            //}
    }

    
}

