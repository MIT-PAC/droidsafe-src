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

public class InReplyToParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.293 -0400", hash_original_method = "7EE0A4AE96DC703284542932FE729FBB", hash_generated_method = "A3514B2B364F9EA382DC73BF027C49E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InReplyToParser(String inReplyTo) {
        super(inReplyTo);
        dsTaint.addTaint(inReplyTo);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.293 -0400", hash_original_method = "513EEBB38452DE199EDFA3069C858F5F", hash_generated_method = "60234777BEA7E6BF18770AE8CD12852F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected InReplyToParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.294 -0400", hash_original_method = "A68E0921F08E40A4FFD6BCC285B4B760", hash_generated_method = "096AF39B5F99BB5629C350BEA95FBEE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("InReplyToParser.parse");
        InReplyToList list;
        list = new InReplyToList();
        try 
        {
            headerName(TokenTypes.IN_REPLY_TO);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1925458736 = (lexer.lookAhead(0) != '\n');
                {
                    InReplyTo inReplyTo;
                    inReplyTo = new InReplyTo();
                    inReplyTo.setHeaderName(SIPHeaderNames.IN_REPLY_TO);
                    this.lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    {
                        boolean var699A6109F8CE540D45AC4B4945B92F1A_1367318540 = (lexer.lookAhead(0) == '@');
                        {
                            this.lexer.match('@');
                            this.lexer.match(TokenTypes.ID);
                            Token secToken;
                            secToken = lexer.getNextToken();
                            inReplyTo.setCallId(
                        token.getTokenValue() + "@" + secToken.getTokenValue());
                        } //End block
                        {
                            inReplyTo.setCallId(token.getTokenValue());
                        } //End block
                    } //End collapsed parenthetic
                    this.lexer.SPorHT();
                    list.add(inReplyTo);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_379268134 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                            inReplyTo = new InReplyTo();
                            this.lexer.match(TokenTypes.ID);
                            token = lexer.getNextToken();
                            {
                                boolean var511BDD56B0BEFD5779ABAF457BF7910F_1611607697 = (lexer.lookAhead(0) == '@');
                                {
                                    this.lexer.match('@');
                                    this.lexer.match(TokenTypes.ID);
                                    Token secToken;
                                    secToken = lexer.getNextToken();
                                    inReplyTo.setCallId(
                            token.getTokenValue()
                                + "@"
                                + secToken.getTokenValue());
                                } //End block
                                {
                                    inReplyTo.setCallId(token.getTokenValue());
                                } //End block
                            } //End collapsed parenthetic
                            list.add(inReplyTo);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("InReplyToParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

