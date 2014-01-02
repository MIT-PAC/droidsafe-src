package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.Priority;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class PriorityParser extends HeaderParser {


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.758 -0500", hash_original_method = "51E7844EB1273E617B8B582DCB60EC10", hash_generated_method = "F5C833114C4CE4271AA879098931B4FF")
    
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

    /**
     * Creates a new instance of PriorityParser
     * @param priority the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.750 -0500", hash_original_method = "3761C7DAE2C27B7066194088DE84B020", hash_generated_method = "3601634849E64E856B23C314F6C2C339")
    
public PriorityParser(String priority) {
        super(priority);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.753 -0500", hash_original_method = "2FA6157C959FDD566822D2465D62D365", hash_generated_method = "36D4536737F1ED2F82CFD81E439399E1")
    
protected PriorityParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String header
     * @return SIPHeader (Priority object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.755 -0500", hash_original_method = "9ECC1E43903CC22F0322E70EF9078767", hash_generated_method = "9F820FD965DB8142D9F1DF748042CEC5")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("PriorityParser.parse");
        Priority priority = new Priority();
        try {
            headerName(TokenTypes.PRIORITY);

            priority.setHeaderName(SIPHeaderNames.PRIORITY);

            this.lexer.SPorHT();
            /*this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();

            priority.setPriority(token.getTokenValue());
            */
            // This is in violation of the RFC but
            // let us be generous in what we accept.
            priority.setPriority(this.lexer.ttokenSafe());

            this.lexer.SPorHT();
            this.lexer.match('\n');

            return priority;
        } finally {
            if (debug)
                dbg_leave("PriorityParser.parse");
        }
    }

    
}

