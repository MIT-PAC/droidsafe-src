package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PCalledPartyID;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PCalledPartyIDParser extends AddressParametersParser {


    /**
     * Constructor
     * @param calledPartyID content to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.397 -0500", hash_original_method = "5A210D10F0DA09D81C9A40BA3A0E0BA0", hash_generated_method = "66A8FA36A0BE912E2ADBDD75A95B6D6E")
    public PCalledPartyIDParser(String calledPartyID)
    {
        super(calledPartyID);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.398 -0500", hash_original_method = "A63723B4A16B3DEC36752AB85CAA4736", hash_generated_method = "22E86D98B90E722D62114E5933F00E10")
    protected PCalledPartyIDParser(Lexer lexer)
    {
        super(lexer);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.399 -0500", hash_original_method = "C43CF84ED746DD134AB177C7FEFB3286", hash_generated_method = "4358D3325089A8632047E3720C843C52")
    public SIPHeader parse() throws ParseException
    {

        if (debug)
            dbg_enter("PCalledPartyIDParser.parse");

        try {
            this.lexer.match(TokenTypes.P_CALLED_PARTY_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();

            PCalledPartyID calledPartyID = new PCalledPartyID();
            super.parse(calledPartyID);

            return calledPartyID;

        } finally {
            if (debug)
                dbg_leave("PCalledPartyIDParser.parse");
        }

    }

    
}

