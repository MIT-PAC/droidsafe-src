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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.498 -0400", hash_original_method = "B94DA4BEBB849BE0C94AD11E29C73BAF", hash_generated_method = "5404B7785AD224CABCB2EB3A8FF38B3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReasonParser(String reason) {
        super(reason);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.498 -0400", hash_original_method = "A4DE926778D9613A22D41E6650D2AD81", hash_generated_method = "644ED76FAB8BDC8613EF6921AD6E2C0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ReasonParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.498 -0400", hash_original_method = "C924C06E3DD994AE91BBC5A8A54B9FE3", hash_generated_method = "54588C4423A307FDA1EE51415E33F7B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        ReasonList reasonList;
        reasonList = new ReasonList();
        dbg_enter("ReasonParser.parse");
        try 
        {
            headerName(TokenTypes.REASON);
            this.lexer.SPorHT();
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_414797351 = (lexer.lookAhead(0) != '\n');
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
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_338661674 = (lexer.lookAhead(0) == ',');
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
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

