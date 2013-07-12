package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class ProxyRequireParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.504 -0400", hash_original_method = "5FB5567CF156CEA2F5335691822C90DD", hash_generated_method = "C6DDB63A7E80EC8542F2F90711E95456")
    public  ProxyRequireParser(String require) {
        super(require);
        addTaint(require.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.505 -0400", hash_original_method = "234BDD3530202548153433053521557F", hash_generated_method = "AF1665D0ED8B9465A6299ECE846D143E")
    protected  ProxyRequireParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.507 -0400", hash_original_method = "3B22313394D07BEF3A6E95D38DEA0C1A", hash_generated_method = "F3B65BA78E118F0B92F0DC63005A6A21")
    public SIPHeader parse() throws ParseException {
        ProxyRequireList list = new ProxyRequireList();
    if(debug)        
        dbg_enter("ProxyRequireParser.parse");
        try 
        {
            headerName(TokenTypes.PROXY_REQUIRE);
            while
(lexer.lookAhead(0) != '\n')            
            {
                ProxyRequire r = new ProxyRequire();
                r.setHeaderName(SIPHeaderNames.PROXY_REQUIRE);
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                r.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();
                list.add(r);
                while
(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    r = new ProxyRequire();
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    r.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();
                    list.add(r);
                } 
            } 
        } 
        finally 
        {
    if(debug)            
            dbg_leave("ProxyRequireParser.parse");
        } 
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_1850235612 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1850235612.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1850235612;
        
        
    }

    
}

