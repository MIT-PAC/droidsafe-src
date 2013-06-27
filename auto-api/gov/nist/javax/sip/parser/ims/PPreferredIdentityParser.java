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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.634 -0400", hash_original_method = "8ED0FE4D0D4A9A77E1D41482CCFB6634", hash_generated_method = "DBF0A9D95EDCEC6B14DFAC227F725239")
    public  PPreferredIdentityParser(String preferredIdentity) {
        super(preferredIdentity);
        addTaint(preferredIdentity.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.634 -0400", hash_original_method = "2C53019D290466621D2FD15449F6C503", hash_generated_method = "339C412A68840273039D5CCE3419F4E9")
    protected  PPreferredIdentityParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.685 -0400", hash_original_method = "CA1397CFDA33B56E4743CDCAB79EF328", hash_generated_method = "3BEB0829B01E08F0CDC1A6333A9206A6")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_233065674 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_233065674 = p;
        } //End block
        finally 
        {
            dbg_leave("PreferredIdentityParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_233065674.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_233065674;
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

