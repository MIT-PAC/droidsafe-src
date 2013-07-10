package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;

public class ReplyToParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.485 -0400", hash_original_method = "9C582C13750EA226F05F84BEF0F6DC1F", hash_generated_method = "86B19DC3FD9B8F368590E97E406B0072")
    public  ReplyToParser(String replyTo) {
        super(replyTo);
        addTaint(replyTo.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.485 -0400", hash_original_method = "967233BE7821B2A8956B876F99751025", hash_generated_method = "19F2EEC8AD38743A11849920D66E8CC9")
    protected  ReplyToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.485 -0400", hash_original_method = "92CC6877DF7B50AD61B75778CFB22735", hash_generated_method = "B70152F3169707DF43086BB7F9BA60AA")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1203175020 = null; 
        ReplyTo replyTo = new ReplyTo();
        dbg_enter("ReplyTo.parse");
        try 
        {
            headerName(TokenTypes.REPLY_TO);
            replyTo.setHeaderName(SIPHeaderNames.REPLY_TO);
            super.parse(replyTo);
            varB4EAC82CA7396A68D541C85D26508E83_1203175020 = replyTo;
        } 
        finally 
        {
            dbg_leave("ReplyTo.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1203175020.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1203175020;
        
        
        
            
        
            
            
            
            
        
            
                
        
    }

    
}

