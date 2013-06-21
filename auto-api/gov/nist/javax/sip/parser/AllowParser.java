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

public class AllowParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.235 -0400", hash_original_method = "A24A575FAE973D160C4E5E7D0F1284A3", hash_generated_method = "BE3DFB605DB4C9310F7CC7CEC8362F53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AllowParser(String allow) {
        super(allow);
        dsTaint.addTaint(allow);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.236 -0400", hash_original_method = "A8034B0A3FEDB25038322A25EEE239D9", hash_generated_method = "0FD6D13F4795E4340CF1FC3757013FC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AllowParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.236 -0400", hash_original_method = "EEEC9A9B7336175FA90CC43255548EC9", hash_generated_method = "8B8322C1E78377CC0945D68FFEDCD7A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("AllowParser.parse");
        AllowList list;
        list = new AllowList();
        try 
        {
            headerName(TokenTypes.ALLOW);
            Allow allow;
            allow = new Allow();
            allow.setHeaderName(SIPHeaderNames.ALLOW);
            this.lexer.SPorHT();
            this.lexer.match(TokenTypes.ID);
            Token token;
            token = lexer.getNextToken();
            allow.setMethod(token.getTokenValue());
            list.add(allow);
            this.lexer.SPorHT();
            {
                boolean var3D7F80AAA4BB4C7E5B5AFC820C1FE6A4_1574996815 = (lexer.lookAhead(0) == ',');
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    allow = new Allow();
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    allow.setMethod(token.getTokenValue());
                    list.add(allow);
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
            this.lexer.SPorHT();
            this.lexer.match('\n');
        } //End block
        finally 
        {
            dbg_leave("AllowParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

