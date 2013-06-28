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

public class ReasonParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.460 -0400", hash_original_method = "B94DA4BEBB849BE0C94AD11E29C73BAF", hash_generated_method = "EDC34466B4D5E43E48DF312EA7F6443B")
    public  ReasonParser(String reason) {
        super(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.461 -0400", hash_original_method = "A4DE926778D9613A22D41E6650D2AD81", hash_generated_method = "8D67B45EB50722CA9321C66B020DC197")
    protected  ReasonParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.462 -0400", hash_original_method = "C924C06E3DD994AE91BBC5A8A54B9FE3", hash_generated_method = "8B9053FD32F2629367B0E22DB67C3D1A")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1265284498 = null; //Variable for return #1
        ReasonList reasonList = new ReasonList();
        dbg_enter("ReasonParser.parse");
        try 
        {
            headerName(TokenTypes.REASON);
            this.lexer.SPorHT();
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1492340339 = (lexer.lookAhead(0) != '\n');
                {
                    Reason reason = new Reason();
                    this.lexer.match(TokenTypes.ID);
                    Token token = lexer.getNextToken();
                    String value = token.getTokenValue();
                    reason.setProtocol(value);
                    super.parse(reason);
                    reasonList.add(reason);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_782096095 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                        } //End block
                        this.lexer.SPorHT();
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("ReasonParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1265284498 = reasonList;
        varB4EAC82CA7396A68D541C85D26508E83_1265284498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1265284498;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

