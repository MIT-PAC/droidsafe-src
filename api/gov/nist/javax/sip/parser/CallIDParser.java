package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.*;

public class CallIDParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.931 -0400", hash_original_method = "F1036F08BD30FBFF0AA178D5C9E11EFA", hash_generated_method = "9EC9E27A01CA541D68B2882987190249")
    public  CallIDParser(String callID) {
        super(callID);
        addTaint(callID.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.931 -0400", hash_original_method = "02CCA397F58454A50D3B0688C937A37B", hash_generated_method = "AF7C53B2BE10E4C6A0A946D5BDF02341")
    protected  CallIDParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.932 -0400", hash_original_method = "1EBE66F04307D347AFA5B564B58F8AB6", hash_generated_method = "B5431CA1C1FC5FA22EF1337B89628BD9")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("parse");
        try 
        {
            this.lexer.match(TokenTypes.CALL_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            CallID callID = new CallID();
            this.lexer.SPorHT();
            String rest = lexer.getRest();
            callID.setCallId(rest.trim());
SIPHeader var78FF8E1F035AA2C6723D427F9EA7BFA5_1760027421 =             callID;
            var78FF8E1F035AA2C6723D427F9EA7BFA5_1760027421.addTaint(taint);
            return var78FF8E1F035AA2C6723D427F9EA7BFA5_1760027421;
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("parse");
        } //End block
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

