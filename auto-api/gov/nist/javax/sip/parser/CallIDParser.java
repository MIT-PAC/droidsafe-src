package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.*;

public class CallIDParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.246 -0400", hash_original_method = "F1036F08BD30FBFF0AA178D5C9E11EFA", hash_generated_method = "E8047EC926202E46375707A38DBEDA51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallIDParser(String callID) {
        super(callID);
        dsTaint.addTaint(callID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.246 -0400", hash_original_method = "02CCA397F58454A50D3B0688C937A37B", hash_generated_method = "B428D189DEA67A22CB3E2383D72BD60F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected CallIDParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.246 -0400", hash_original_method = "1EBE66F04307D347AFA5B564B58F8AB6", hash_generated_method = "980E32A13CE2F2CB1984F1CE450611B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try 
        {
            this.lexer.match(TokenTypes.CALL_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            CallID callID;
            callID = new CallID();
            this.lexer.SPorHT();
            String rest;
            rest = lexer.getRest();
            callID.setCallId(rest.trim());
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
            //this.lexer.match(TokenTypes.CALL_ID);
            //this.lexer.SPorHT();
            //this.lexer.match(':');
            //this.lexer.SPorHT();
            //CallID callID = new CallID();
            //this.lexer.SPorHT();
            //String rest = lexer.getRest();
            //callID.setCallId(rest.trim());
            //return callID;
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
    }

    
}

