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

public class ProxyRequireParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.488 -0400", hash_original_method = "5FB5567CF156CEA2F5335691822C90DD", hash_generated_method = "BAB90A150F07562291A995D7D652A7EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyRequireParser(String require) {
        super(require);
        dsTaint.addTaint(require);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.488 -0400", hash_original_method = "234BDD3530202548153433053521557F", hash_generated_method = "DD0408EC7F040C35ADA2797C28DC6AE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ProxyRequireParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.489 -0400", hash_original_method = "3B22313394D07BEF3A6E95D38DEA0C1A", hash_generated_method = "23821FF621E41622F174309836FBC0BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        ProxyRequireList list;
        list = new ProxyRequireList();
        dbg_enter("ProxyRequireParser.parse");
        try 
        {
            headerName(TokenTypes.PROXY_REQUIRE);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_2084755040 = (lexer.lookAhead(0) != '\n');
                {
                    ProxyRequire r;
                    r = new ProxyRequire();
                    r.setHeaderName(SIPHeaderNames.PROXY_REQUIRE);
                    this.lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    r.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();
                    list.add(r);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_112605974 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                            r = new ProxyRequire();
                            this.lexer.match(TokenTypes.ID);
                            token = lexer.getNextToken();
                            r.setOptionTag(token.getTokenValue());
                            this.lexer.SPorHT();
                            list.add(r);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("ProxyRequireParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

