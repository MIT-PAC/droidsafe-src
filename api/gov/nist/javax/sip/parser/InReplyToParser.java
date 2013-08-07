package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.InReplyTo;
import gov.nist.javax.sip.header.InReplyToList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class InReplyToParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.719 -0400", hash_original_method = "7EE0A4AE96DC703284542932FE729FBB", hash_generated_method = "C9411351C1E5B676DB6F3A4FEAFDBC61")
    public  InReplyToParser(String inReplyTo) {
        super(inReplyTo);
        addTaint(inReplyTo.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.720 -0400", hash_original_method = "513EEBB38452DE199EDFA3069C858F5F", hash_generated_method = "CAE03DC805C508DE845B029D8069273B")
    protected  InReplyToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.722 -0400", hash_original_method = "A68E0921F08E40A4FFD6BCC285B4B760", hash_generated_method = "5873F96E143AC6E1E8509C89005D368A")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("InReplyToParser.parse");
        InReplyToList list = new InReplyToList();
        try 
        {
            headerName(TokenTypes.IN_REPLY_TO);
            while
(lexer.lookAhead(0) != '\n')            
            {
                InReplyTo inReplyTo = new InReplyTo();
                inReplyTo.setHeaderName(SIPHeaderNames.IN_REPLY_TO);
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                if(lexer.lookAhead(0) == '@')                
                {
                    this.lexer.match('@');
                    this.lexer.match(TokenTypes.ID);
                    Token secToken = lexer.getNextToken();
                    inReplyTo.setCallId(
                        token.getTokenValue() + "@" + secToken.getTokenValue());
                } //End block
                else
                {
                    inReplyTo.setCallId(token.getTokenValue());
                } //End block
                this.lexer.SPorHT();
                list.add(inReplyTo);
                while
(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    inReplyTo = new InReplyTo();
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    if(lexer.lookAhead(0) == '@')                    
                    {
                        this.lexer.match('@');
                        this.lexer.match(TokenTypes.ID);
                        Token secToken = lexer.getNextToken();
                        inReplyTo.setCallId(
                            token.getTokenValue()
                                + "@"
                                + secToken.getTokenValue());
                    } //End block
                    else
                    {
                        inReplyTo.setCallId(token.getTokenValue());
                    } //End block
                    list.add(inReplyTo);
                } //End block
            } //End block
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_1443709294 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1443709294.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1443709294;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("InReplyToParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

