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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.530 -0400", hash_original_method = "F1036F08BD30FBFF0AA178D5C9E11EFA", hash_generated_method = "9EC9E27A01CA541D68B2882987190249")
    public  CallIDParser(String callID) {
        super(callID);
        addTaint(callID.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.535 -0400", hash_original_method = "02CCA397F58454A50D3B0688C937A37B", hash_generated_method = "AF7C53B2BE10E4C6A0A946D5BDF02341")
    protected  CallIDParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.540 -0400", hash_original_method = "1EBE66F04307D347AFA5B564B58F8AB6", hash_generated_method = "5E00880CA987E3070BE1FC1790F96F4E")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1226315980 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1226315980 = callID;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1226315980.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226315980;
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

