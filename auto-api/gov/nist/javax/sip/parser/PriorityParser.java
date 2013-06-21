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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.478 -0400", hash_original_method = "3761C7DAE2C27B7066194088DE84B020", hash_generated_method = "A773F87ED6BBD66F238DA15E1B5D2A0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PriorityParser(String priority) {
        super(priority);
        dsTaint.addTaint(priority);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.478 -0400", hash_original_method = "2FA6157C959FDD566822D2465D62D365", hash_generated_method = "21222094F52DC3F8D42EED0A6C8872DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PriorityParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.478 -0400", hash_original_method = "9ECC1E43903CC22F0322E70EF9078767", hash_generated_method = "1D9498C78F28A53DA5024C470FCA32A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
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
        } //End block
        finally 
        {
            dbg_leave("PriorityParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

