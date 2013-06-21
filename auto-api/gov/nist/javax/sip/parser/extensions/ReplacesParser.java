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

public class ReplacesParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.743 -0400", hash_original_method = "F53F10172FA8BD8FD32B526A24946E78", hash_generated_method = "29BD8B60C540ABB44CDB9CB99FB62A24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReplacesParser(String callID) {
        super(callID);
        dsTaint.addTaint(callID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.743 -0400", hash_original_method = "668CF87BAE793626F7B81C622AF1AD1A", hash_generated_method = "AF3FB0D3008F985E1063B5E4061D546B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ReplacesParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.743 -0400", hash_original_method = "C779AD4EE203E642C9A6B93773CE1027", hash_generated_method = "8E2A82E4D2CAD735D7D4BD5B50B197D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.REPLACES_TO);
            Replaces replaces;
            replaces = new Replaces();
            this.lexer.SPorHT();
            String callId;
            callId = lexer.byteStringNoSemicolon();
            this.lexer.SPorHT();
            super.parse(replaces);
            replaces.setCallId(callId);
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
            //headerName(TokenTypes.REPLACES_TO);
            //Replaces replaces = new Replaces();
            //this.lexer.SPorHT();
            //String callId = lexer.byteStringNoSemicolon();
            //this.lexer.SPorHT();
            //super.parse(replaces);
            //replaces.setCallId(callId);
            //return replaces;
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
    }

    
        public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Replaces: 12345th5z8z\n",
                "Replaces: 12345th5z8z;to-tag=tozght6-45;from-tag=fromzght789-337-2\n",
            };
        for (int i = 0; i < to.length; i++) {
            ReplacesParser tp = new ReplacesParser(to[i]);
            Replaces t = (Replaces) tp.parse();
            System.out.println("Parsing => " + to[i]);
            System.out.print("encoded = " + t.encode() + "==> ");
            System.out.println("callId " + t.getCallId() + " from-tag=" + t.getFromTag()
                    + " to-tag=" + t.getToTag()) ;
        }
    }

    
}

