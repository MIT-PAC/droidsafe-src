package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;

public class ReplyToParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.485 -0400", hash_original_method = "9C582C13750EA226F05F84BEF0F6DC1F", hash_generated_method = "86B19DC3FD9B8F368590E97E406B0072")
    public  ReplyToParser(String replyTo) {
        super(replyTo);
        addTaint(replyTo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.485 -0400", hash_original_method = "967233BE7821B2A8956B876F99751025", hash_generated_method = "19F2EEC8AD38743A11849920D66E8CC9")
    protected  ReplyToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.485 -0400", hash_original_method = "92CC6877DF7B50AD61B75778CFB22735", hash_generated_method = "B70152F3169707DF43086BB7F9BA60AA")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1203175020 = null; //Variable for return #1
        ReplyTo replyTo = new ReplyTo();
        dbg_enter("ReplyTo.parse");
        try 
        {
            headerName(TokenTypes.REPLY_TO);
            replyTo.setHeaderName(SIPHeaderNames.REPLY_TO);
            super.parse(replyTo);
            varB4EAC82CA7396A68D541C85D26508E83_1203175020 = replyTo;
        } //End block
        finally 
        {
            dbg_leave("ReplyTo.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1203175020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1203175020;
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

