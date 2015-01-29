package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.Accept;
import gov.nist.javax.sip.header.AcceptList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class AcceptParser extends ParametersParser {

    /**
     * Creates a new instance of Accept Parser
     * @param accept  the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.156 -0500", hash_original_method = "E50D6CA61897C534ECF6BFE2E6C66EEB", hash_generated_method = "15E1CF64B509FE04077205B29E000359")
    
public AcceptParser(String accept) {
        super(accept);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.159 -0500", hash_original_method = "B0740C746A8D55CA7E1BAB3B373D9F3B", hash_generated_method = "B80F6663D72F35BA386A8FB8BACBFD9E")
    
protected AcceptParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the Accept  String header
     * @return SIPHeader (AcceptList  object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.162 -0500", hash_original_method = "4B990F83EF66D5D2EAA453ED852E8DC7", hash_generated_method = "A8C6BC8103293C709C8E18829559112E")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AcceptParser.parse");
        AcceptList list = new AcceptList();

        try {
            headerName(TokenTypes.ACCEPT);

            Accept accept = new Accept();
            accept.setHeaderName(SIPHeaderNames.ACCEPT);

            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token = lexer.getNextToken();
            accept.setContentType(token.getTokenValue());
            this.lexer.match('/');
            this.lexer.match(TokenTypes.ID);
            token = lexer.getNextToken();
            accept.setContentSubType(token.getTokenValue());
            this.lexer.SPorHT();

            super.parse(accept);
            list.add(accept);

            while (lexer.lookAhead(0) == ',') {
                this.lexer.match(',');
                this.lexer.SPorHT();

                accept = new Accept();

                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                accept.setContentType(token.getTokenValue());
                this.lexer.match('/');
                this.lexer.match(TokenTypes.ID);
                token = lexer.getNextToken();
                accept.setContentSubType(token.getTokenValue());
                this.lexer.SPorHT();
                super.parse(accept);
                list.add(accept);

            }
            return list;
        } finally {
            if (debug)
                dbg_leave("AcceptParser.parse");
        }
    }

    
}

