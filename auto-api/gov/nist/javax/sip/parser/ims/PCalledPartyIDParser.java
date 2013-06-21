package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.PCalledPartyID;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import gov.nist.javax.sip.parser.AddressParametersParser;

public class PCalledPartyIDParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.757 -0400", hash_original_method = "5A210D10F0DA09D81C9A40BA3A0E0BA0", hash_generated_method = "D4B67959E5BCD890FB667B9F8F71453A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PCalledPartyIDParser(String calledPartyID) {
        super(calledPartyID);
        dsTaint.addTaint(calledPartyID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.758 -0400", hash_original_method = "A63723B4A16B3DEC36752AB85CAA4736", hash_generated_method = "1181E3C16EA1F97A01CEB6542F42D0BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PCalledPartyIDParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.758 -0400", hash_original_method = "C43CF84ED746DD134AB177C7FEFB3286", hash_generated_method = "8744C8147ED80A3C63DBED4EE9EE5E8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("PCalledPartyIDParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.P_CALLED_PARTY_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            PCalledPartyID calledPartyID;
            calledPartyID = new PCalledPartyID();
            super.parse(calledPartyID);
        } //End block
        finally 
        {
            dbg_leave("PCalledPartyIDParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("PCalledPartyIDParser.parse");
        //try {
            //this.lexer.match(TokenTypes.P_CALLED_PARTY_ID);
            //this.lexer.SPorHT();
            //this.lexer.match(':');
            //this.lexer.SPorHT();
            //PCalledPartyID calledPartyID = new PCalledPartyID();
            //super.parse(calledPartyID);
            //return calledPartyID;
        //} finally {
            //if (debug)
                //dbg_leave("PCalledPartyIDParser.parse");
        //}
    }

    
}

