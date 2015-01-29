package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.CallID;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class CallIDParser extends HeaderParser {

    /**
     * Creates new CallIDParser
     * @param callID message to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.712 -0500", hash_original_method = "F1036F08BD30FBFF0AA178D5C9E11EFA", hash_generated_method = "E874AAF50216E03F55E0EAFE623DD815")
    
public CallIDParser(String callID) {
        super(callID);
    }

    /**
     * Constructor
     * @param lexer Lexer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.714 -0500", hash_original_method = "02CCA397F58454A50D3B0688C937A37B", hash_generated_method = "508256DDC8A7C0AD9C7E80A9715C3993")
    
protected CallIDParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (CallID object)
     * @throws ParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.718 -0500", hash_original_method = "1EBE66F04307D347AFA5B564B58F8AB6", hash_generated_method = "75BECFF3C44A6D33DCB9B0932C91E676")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("parse");
        try {
            this.lexer.match(TokenTypes.CALL_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();

            CallID callID = new CallID();

            this.lexer.SPorHT();
            String rest = lexer.getRest();
            callID.setCallId(rest.trim());
            return callID;
        } finally {
            if (debug)
                dbg_leave("parse");
        }
    }

    
}

