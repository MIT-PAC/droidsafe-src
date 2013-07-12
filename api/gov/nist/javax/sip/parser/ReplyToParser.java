package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;

public class ReplyToParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.639 -0400", hash_original_method = "9C582C13750EA226F05F84BEF0F6DC1F", hash_generated_method = "86B19DC3FD9B8F368590E97E406B0072")
    public  ReplyToParser(String replyTo) {
        super(replyTo);
        addTaint(replyTo.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.640 -0400", hash_original_method = "967233BE7821B2A8956B876F99751025", hash_generated_method = "19F2EEC8AD38743A11849920D66E8CC9")
    protected  ReplyToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.640 -0400", hash_original_method = "92CC6877DF7B50AD61B75778CFB22735", hash_generated_method = "DAE083853F9701A296AE46E6426D2BB3")
    public SIPHeader parse() throws ParseException {
        ReplyTo replyTo = new ReplyTo();
    if(debug)        
        dbg_enter("ReplyTo.parse");
        try 
        {
            headerName(TokenTypes.REPLY_TO);
            replyTo.setHeaderName(SIPHeaderNames.REPLY_TO);
            super.parse(replyTo);
SIPHeader var43C4044FC3C522AE3C13CF309B9542DA_267948682 =             replyTo;
            var43C4044FC3C522AE3C13CF309B9542DA_267948682.addTaint(taint);
            return var43C4044FC3C522AE3C13CF309B9542DA_267948682;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("ReplyTo.parse");
        } 
        
        
        
            
        
            
            
            
            
        
            
                
        
    }

    
}

