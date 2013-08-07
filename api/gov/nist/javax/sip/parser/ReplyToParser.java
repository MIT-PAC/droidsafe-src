package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ReplyTo;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ReplyToParser extends AddressParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.530 -0400", hash_original_method = "9C582C13750EA226F05F84BEF0F6DC1F", hash_generated_method = "86B19DC3FD9B8F368590E97E406B0072")
    public  ReplyToParser(String replyTo) {
        super(replyTo);
        addTaint(replyTo.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.531 -0400", hash_original_method = "967233BE7821B2A8956B876F99751025", hash_generated_method = "19F2EEC8AD38743A11849920D66E8CC9")
    protected  ReplyToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.532 -0400", hash_original_method = "92CC6877DF7B50AD61B75778CFB22735", hash_generated_method = "9E0ECDE3A79354DFF09ADD206E72161A")
    public SIPHeader parse() throws ParseException {
        ReplyTo replyTo = new ReplyTo();
        if(debug)        
        dbg_enter("ReplyTo.parse");
        try 
        {
            headerName(TokenTypes.REPLY_TO);
            replyTo.setHeaderName(SIPHeaderNames.REPLY_TO);
            super.parse(replyTo);
SIPHeader var43C4044FC3C522AE3C13CF309B9542DA_238898102 =             replyTo;
            var43C4044FC3C522AE3C13CF309B9542DA_238898102.addTaint(taint);
            return var43C4044FC3C522AE3C13CF309B9542DA_238898102;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("ReplyTo.parse");
        } //End block
        // ---------- Original Method ----------
        //ReplyTo replyTo = new ReplyTo();
        //if (debug)
            //dbg_enter("ReplyTo.parse");
        //try {
            //headerName(TokenTypes.REPLY_TO);
            //replyTo.setHeaderName(SIPHeaderNames.REPLY_TO);
            //super.parse(replyTo);
            //return replyTo;
        //} finally {
            //if (debug)
                //dbg_leave("ReplyTo.parse");
        //}
    }

    
}

