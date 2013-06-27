package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class PriorityParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.987 -0400", hash_original_method = "3761C7DAE2C27B7066194088DE84B020", hash_generated_method = "9BE707ABFEAC5474F38DAD743E30A97D")
    public  PriorityParser(String priority) {
        super(priority);
        addTaint(priority.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.987 -0400", hash_original_method = "2FA6157C959FDD566822D2465D62D365", hash_generated_method = "12837E715683B7A7200A42CDA1F47E2E")
    protected  PriorityParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.999 -0400", hash_original_method = "9ECC1E43903CC22F0322E70EF9078767", hash_generated_method = "0C309AC44BFC32CC30D1874A159B0950")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1483452113 = null; //Variable for return #1
        dbg_enter("PriorityParser.parse");
        Priority priority;
        priority = new Priority();
        try 
        {
            headerName(TokenTypes.PRIORITY);
            priority.setHeaderName(SIPHeaderNames.PRIORITY);
            this.lexer.SPorHT();
            priority.setPriority(this.lexer.ttokenSafe());
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_1483452113 = priority;
        } //End block
        finally 
        {
            dbg_leave("PriorityParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1483452113.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1483452113;
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("PriorityParser.parse");
        //Priority priority = new Priority();
        //try {
            //headerName(TokenTypes.PRIORITY);
            //priority.setHeaderName(SIPHeaderNames.PRIORITY);
            //this.lexer.SPorHT();
            //priority.setPriority(this.lexer.ttokenSafe());
            //this.lexer.SPorHT();
            //this.lexer.match('\n');
            //return priority;
        //} finally {
            //if (debug)
                //dbg_leave("PriorityParser.parse");
        //}
    }

    
        public static void main(String args[]) throws ParseException {
        String p[] = {
            "Priority: 8;a\n"
            };
        for (int i = 0; i < p.length; i++ ) {
        PriorityParser parser =
          new PriorityParser(p[i]);
        Priority prio= (Priority) parser.parse();
        System.out.println("encoded = " + prio.encode());
    }
    }

    
}

