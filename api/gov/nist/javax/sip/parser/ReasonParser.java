package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class ReasonParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.587 -0400", hash_original_method = "B94DA4BEBB849BE0C94AD11E29C73BAF", hash_generated_method = "EDC34466B4D5E43E48DF312EA7F6443B")
    public  ReasonParser(String reason) {
        super(reason);
        addTaint(reason.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.587 -0400", hash_original_method = "A4DE926778D9613A22D41E6650D2AD81", hash_generated_method = "8D67B45EB50722CA9321C66B020DC197")
    protected  ReasonParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.588 -0400", hash_original_method = "C924C06E3DD994AE91BBC5A8A54B9FE3", hash_generated_method = "7C2FD66AD304091769ADC1AC9B8964C5")
    public SIPHeader parse() throws ParseException {
        ReasonList reasonList = new ReasonList();
    if(debug)        
        dbg_enter("ReasonParser.parse");
        try 
        {
            headerName(TokenTypes.REASON);
            this.lexer.SPorHT();
            while
(lexer.lookAhead(0) != '\n')            
            {
                Reason reason = new Reason();
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                String value = token.getTokenValue();
                reason.setProtocol(value);
                super.parse(reason);
                reasonList.add(reason);
    if(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } 
                else
                this.lexer.SPorHT();
            } 
        } 
        finally 
        {
    if(debug)            
            dbg_leave("ReasonParser.parse");
        } 
SIPHeader varBCECBDE203391D642885C62773929FAF_150420032 =         reasonList;
        varBCECBDE203391D642885C62773929FAF_150420032.addTaint(taint);
        return varBCECBDE203391D642885C62773929FAF_150420032;
        
        
    }

    
}

