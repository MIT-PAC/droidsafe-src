package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.Reason;
import gov.nist.javax.sip.header.ReasonList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class ReasonParser extends ParametersParser {

    /**
     * Creates a new instance of ReasonParser
     * @param reason the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.865 -0500", hash_original_method = "B94DA4BEBB849BE0C94AD11E29C73BAF", hash_generated_method = "E4CAE05F1742E6F4D9EE56AAEC4DAE35")
    
public ReasonParser(String reason) {
        super(reason);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.868 -0500", hash_original_method = "A4DE926778D9613A22D41E6650D2AD81", hash_generated_method = "609B66F71635733EEC2627426CF3D849")
    
protected ReasonParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (ReasonParserList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.871 -0500", hash_original_method = "C924C06E3DD994AE91BBC5A8A54B9FE3", hash_generated_method = "DD675B4DB80B01CA747A2586227C4AFA")
    
public SIPHeader parse() throws ParseException {
        ReasonList reasonList = new ReasonList();
        if (debug)
            dbg_enter("ReasonParser.parse");

        try {
            headerName(TokenTypes.REASON);
            this.lexer.SPorHT();
            while (lexer.lookAhead(0) != '\n') {
                Reason reason = new Reason();
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                String value = token.getTokenValue();

                reason.setProtocol(value);
                super.parse(reason);
                reasonList.add(reason);
                if (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } else
                    this.lexer.SPorHT();

            }
        } finally {
            if (debug)
                dbg_leave("ReasonParser.parse");
        }

        return reasonList;
    }

    
}

