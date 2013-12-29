package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.InReplyTo;
import gov.nist.javax.sip.header.InReplyToList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class InReplyToParser extends HeaderParser {

    /**
     * Creates a new instance of InReplyToParser
     * @param inReplyTo the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.249 -0500", hash_original_method = "7EE0A4AE96DC703284542932FE729FBB", hash_generated_method = "D9BAA364E4896897364EC470C55B144D")
    public InReplyToParser(String inReplyTo) {
        super(inReplyTo);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.251 -0500", hash_original_method = "513EEBB38452DE199EDFA3069C858F5F", hash_generated_method = "0D8B268B46F9A92E6178751B56CF0C2D")
    protected InReplyToParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (InReplyToList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.252 -0500", hash_original_method = "A68E0921F08E40A4FFD6BCC285B4B760", hash_generated_method = "8F8FF4F55B417D9FC34E9B3BBDC89DB8")
    public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("InReplyToParser.parse");
        InReplyToList list = new InReplyToList();

        try {
            headerName(TokenTypes.IN_REPLY_TO);

            while (lexer.lookAhead(0) != '\n') {
                InReplyTo inReplyTo = new InReplyTo();
                inReplyTo.setHeaderName(SIPHeaderNames.IN_REPLY_TO);

                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                if (lexer.lookAhead(0) == '@') {
                    this.lexer.match('@');
                    this.lexer.match(TokenTypes.ID);
                    Token secToken = lexer.getNextToken();
                    inReplyTo.setCallId(
                        token.getTokenValue() + "@" + secToken.getTokenValue());
                } else {
                    inReplyTo.setCallId(token.getTokenValue());
                }

                this.lexer.SPorHT();

                list.add(inReplyTo);

                while (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();

                    inReplyTo = new InReplyTo();

                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    if (lexer.lookAhead(0) == '@') {
                        this.lexer.match('@');
                        this.lexer.match(TokenTypes.ID);
                        Token secToken = lexer.getNextToken();
                        inReplyTo.setCallId(
                            token.getTokenValue()
                                + "@"
                                + secToken.getTokenValue());
                    } else {
                        inReplyTo.setCallId(token.getTokenValue());
                    }

                    list.add(inReplyTo);
                }
            }

            return list;
        } finally {
            if (debug)
                dbg_leave("InReplyToParser.parse");
        }
    }

    
}

