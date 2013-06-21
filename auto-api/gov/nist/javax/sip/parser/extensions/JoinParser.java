package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;

public class JoinParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.725 -0400", hash_original_method = "EF4712E80A9A6595AD0A1CEA8AD509AD", hash_generated_method = "CDF6A48276075E73604D2ACB1D501CDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JoinParser(String callID) {
        super(callID);
        dsTaint.addTaint(callID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.726 -0400", hash_original_method = "C3C0BEC6FC6BFB3701BC82718709C143", hash_generated_method = "D8FC03AE8A03E796605C307E54443867")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected JoinParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.726 -0400", hash_original_method = "66B10ECC601C3201E5F156FEACCA3B45", hash_generated_method = "DCAC1BEECD21075D16E1579CA3AC1B2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.JOIN_TO);
            Join join;
            join = new Join();
            this.lexer.SPorHT();
            String callId;
            callId = lexer.byteStringNoSemicolon();
            this.lexer.SPorHT();
            super.parse(join);
            join.setCallId(callId);
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
            //headerName(TokenTypes.JOIN_TO);
            //Join join = new Join();
            //this.lexer.SPorHT();
            //String callId = lexer.byteStringNoSemicolon();
            //this.lexer.SPorHT();
            //super.parse(join);
            //join.setCallId(callId);
            //return join;
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
    }

    
        public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Join: 12345th5z8z\n",
                "Join: 12345th5z8z;to-tag=tozght6-45;from-tag=fromzght789-337-2\n",
            };
        for (int i = 0; i < to.length; i++) {
            JoinParser tp = new JoinParser(to[i]);
            Join t = (Join) tp.parse();
            System.out.println("Parsing => " + to[i]);
            System.out.print("encoded = " + t.encode() + "==> ");
            System.out.println("callId " + t.getCallId() + " from-tag=" + t.getFromTag()
                    + " to-tag=" + t.getToTag()) ;
        }
    }

    
}

