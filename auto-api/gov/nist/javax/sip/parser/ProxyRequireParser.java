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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.012 -0400", hash_original_method = "5FB5567CF156CEA2F5335691822C90DD", hash_generated_method = "C6DDB63A7E80EC8542F2F90711E95456")
    public  ProxyRequireParser(String require) {
        super(require);
        addTaint(require.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.023 -0400", hash_original_method = "234BDD3530202548153433053521557F", hash_generated_method = "AF1665D0ED8B9465A6299ECE846D143E")
    protected  ProxyRequireParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.032 -0400", hash_original_method = "3B22313394D07BEF3A6E95D38DEA0C1A", hash_generated_method = "4E346C0E338B98F64CAFEF94F93929D4")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_316137528 = null; //Variable for return #1
        ProxyRequireList list;
        list = new ProxyRequireList();
        dbg_enter("ProxyRequireParser.parse");
        try 
        {
            headerName(TokenTypes.PROXY_REQUIRE);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1597017439 = (lexer.lookAhead(0) != '\n');
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
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_1307693106 = (lexer.lookAhead(0) == ',');
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
        varB4EAC82CA7396A68D541C85D26508E83_316137528 = list;
        varB4EAC82CA7396A68D541C85D26508E83_316137528.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_316137528;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

