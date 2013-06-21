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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.504 -0400", hash_original_method = "9C582C13750EA226F05F84BEF0F6DC1F", hash_generated_method = "B81FE292043D97561C0FB2C022C025AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReplyToParser(String replyTo) {
        super(replyTo);
        dsTaint.addTaint(replyTo);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.504 -0400", hash_original_method = "967233BE7821B2A8956B876F99751025", hash_generated_method = "485C99C28F7E3EA769958300F35CE235")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ReplyToParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.504 -0400", hash_original_method = "92CC6877DF7B50AD61B75778CFB22735", hash_generated_method = "F4822FEC2942BAE289C981632A30881A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        ReplyTo replyTo;
        replyTo = new ReplyTo();
        dbg_enter("ReplyTo.parse");
        try 
        {
            headerName(TokenTypes.REPLY_TO);
            replyTo.setHeaderName(SIPHeaderNames.REPLY_TO);
            super.parse(replyTo);
        } //End block
        finally 
        {
            dbg_leave("ReplyTo.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

