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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.082 -0400", hash_original_method = "B94DA4BEBB849BE0C94AD11E29C73BAF", hash_generated_method = "EDC34466B4D5E43E48DF312EA7F6443B")
    public  ReasonParser(String reason) {
        super(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.082 -0400", hash_original_method = "A4DE926778D9613A22D41E6650D2AD81", hash_generated_method = "8D67B45EB50722CA9321C66B020DC197")
    protected  ReasonParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.084 -0400", hash_original_method = "C924C06E3DD994AE91BBC5A8A54B9FE3", hash_generated_method = "E00E0C7B786C6EF22F18F512D1B0FB4A")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_886026888 = null; //Variable for return #1
        ReasonList reasonList;
        reasonList = new ReasonList();
        dbg_enter("ReasonParser.parse");
        try 
        {
            headerName(TokenTypes.REASON);
            this.lexer.SPorHT();
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1726130032 = (lexer.lookAhead(0) != '\n');
                {
                    Reason reason;
                    reason = new Reason();
                    this.lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    String value;
                    value = token.getTokenValue();
                    reason.setProtocol(value);
                    super.parse(reason);
                    reasonList.add(reason);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_1230884675 = (lexer.lookAhead(0) == ',');
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
        varB4EAC82CA7396A68D541C85D26508E83_886026888 = reasonList;
        varB4EAC82CA7396A68D541C85D26508E83_886026888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_886026888;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

