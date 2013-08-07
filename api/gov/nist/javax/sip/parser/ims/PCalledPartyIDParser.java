package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PCalledPartyID;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PCalledPartyIDParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.888 -0400", hash_original_method = "5A210D10F0DA09D81C9A40BA3A0E0BA0", hash_generated_method = "BBD7965D346BF1D7806D7ABC42DEB4ED")
    public  PCalledPartyIDParser(String calledPartyID) {
        super(calledPartyID);
        addTaint(calledPartyID.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.888 -0400", hash_original_method = "A63723B4A16B3DEC36752AB85CAA4736", hash_generated_method = "1A433AD9ED26F8AC88F7689284675C35")
    protected  PCalledPartyIDParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.888 -0400", hash_original_method = "C43CF84ED746DD134AB177C7FEFB3286", hash_generated_method = "163F44A407A4C9510A65BBC7112614A3")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("PCalledPartyIDParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.P_CALLED_PARTY_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            PCalledPartyID calledPartyID = new PCalledPartyID();
            super.parse(calledPartyID);
SIPHeader var7CED634B91969C8974B3C449C1A23580_1491025041 =             calledPartyID;
            var7CED634B91969C8974B3C449C1A23580_1491025041.addTaint(taint);
            return var7CED634B91969C8974B3C449C1A23580_1491025041;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("PCalledPartyIDParser.parse");
        } //End block
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

