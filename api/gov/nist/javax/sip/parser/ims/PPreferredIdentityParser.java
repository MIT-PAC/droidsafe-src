package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PPreferredIdentity;
import gov.nist.javax.sip.parser.AddressParametersParser;

public class PPreferredIdentityParser extends AddressParametersParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.966 -0400", hash_original_method = "8ED0FE4D0D4A9A77E1D41482CCFB6634", hash_generated_method = "DBF0A9D95EDCEC6B14DFAC227F725239")
    public  PPreferredIdentityParser(String preferredIdentity) {
        super(preferredIdentity);
        addTaint(preferredIdentity.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.967 -0400", hash_original_method = "2C53019D290466621D2FD15449F6C503", hash_generated_method = "339C412A68840273039D5CCE3419F4E9")
    protected  PPreferredIdentityParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.967 -0400", hash_original_method = "CA1397CFDA33B56E4743CDCAB79EF328", hash_generated_method = "6802833FE7FEF66BEA27629694D9101A")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("PreferredIdentityParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.P_PREFERRED_IDENTITY);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            PPreferredIdentity p = new PPreferredIdentity();
            super.parse( p );
SIPHeader var74E4690D9F2A026504928C017944E149_2092085067 =             p;
            var74E4690D9F2A026504928C017944E149_2092085067.addTaint(taint);
            return var74E4690D9F2A026504928C017944E149_2092085067;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("PreferredIdentityParser.parse");
        } //End block
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

