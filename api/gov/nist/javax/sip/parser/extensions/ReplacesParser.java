package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;

public class ReplacesParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.926 -0400", hash_original_method = "F53F10172FA8BD8FD32B526A24946E78", hash_generated_method = "368EEDE79D60B6F140654B7800BA2E08")
    public  ReplacesParser(String callID) {
        super(callID);
        addTaint(callID.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.930 -0400", hash_original_method = "668CF87BAE793626F7B81C622AF1AD1A", hash_generated_method = "4434B90B2946AD9E5DAAEF47B7AD1FBA")
    protected  ReplacesParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.934 -0400", hash_original_method = "C779AD4EE203E642C9A6B93773CE1027", hash_generated_method = "4B9CBB7DA6130E212C7A7CEFE7ED9738")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.REPLACES_TO);
            Replaces replaces = new Replaces();
            this.lexer.SPorHT();
            String callId = lexer.byteStringNoSemicolon();
            this.lexer.SPorHT();
            super.parse(replaces);
            replaces.setCallId(callId);
SIPHeader varC6183C02DA53C65BFA5F0C5E1854FB03_25942051 =             replaces;
            varC6183C02DA53C65BFA5F0C5E1854FB03_25942051.addTaint(taint);
            return varC6183C02DA53C65BFA5F0C5E1854FB03_25942051;
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

