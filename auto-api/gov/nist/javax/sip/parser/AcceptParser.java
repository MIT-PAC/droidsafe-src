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

public class AcceptParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.214 -0400", hash_original_method = "E50D6CA61897C534ECF6BFE2E6C66EEB", hash_generated_method = "CC8506FA02E7BB2FCB9571AB33D0025F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptParser(String accept) {
        super(accept);
        dsTaint.addTaint(accept);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.214 -0400", hash_original_method = "B0740C746A8D55CA7E1BAB3B373D9F3B", hash_generated_method = "C7E2C2000B701AD607A5BCE74EC6C22D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AcceptParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.215 -0400", hash_original_method = "4B990F83EF66D5D2EAA453ED852E8DC7", hash_generated_method = "A9A9E36258E3CF51A9560B230FA28F8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("AcceptParser.parse");
        AcceptList list;
        list = new AcceptList();
        try 
        {
            headerName(TokenTypes.ACCEPT);
            Accept accept;
            accept = new Accept();
            accept.setHeaderName(SIPHeaderNames.ACCEPT);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            accept.setContentType(token.getTokenValue());
            this.lexer.match('/');
            this.lexer.match(TokenTypes.ID);
            token = lexer.getNextToken();
            accept.setContentSubType(token.getTokenValue());
            this.lexer.SPorHT();
            super.parse(accept);
            list.add(accept);
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_272372750 = (lexer.lookAhead(0) == ',');
                {
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
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("AcceptParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

