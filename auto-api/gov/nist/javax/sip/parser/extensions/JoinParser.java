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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.538 -0400", hash_original_method = "EF4712E80A9A6595AD0A1CEA8AD509AD", hash_generated_method = "EF8DC95B7DED73A2DB702514426B3451")
    public  JoinParser(String callID) {
        super(callID);
        addTaint(callID.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.544 -0400", hash_original_method = "C3C0BEC6FC6BFB3701BC82718709C143", hash_generated_method = "90BF5F94E161A6ABC76322A48650D9FD")
    protected  JoinParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.551 -0400", hash_original_method = "66B10ECC601C3201E5F156FEACCA3B45", hash_generated_method = "1DC77D61580392663056B114CFF4E116")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1266116161 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1266116161 = join;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1266116161.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1266116161;
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

