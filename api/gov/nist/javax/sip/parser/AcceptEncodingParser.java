package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.AcceptEncoding;
import gov.nist.javax.sip.header.AcceptEncodingList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class AcceptEncodingParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.518 -0400", hash_original_method = "865E86FA800E1D68F0770AD3080D258F", hash_generated_method = "F0F93EB7D3971DD3BFB62EE12CA6FFF8")
    public  AcceptEncodingParser(String acceptEncoding) {
        super(acceptEncoding);
        addTaint(acceptEncoding.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.519 -0400", hash_original_method = "2A31652D0F06752F063CE4D7769684DB", hash_generated_method = "275A392B40423395F120EDEEAEEEC6CC")
    protected  AcceptEncodingParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.635 -0400", hash_original_method = "A9DB3F83816CED00173237937952E9D8", hash_generated_method = "654297546EECD69A97871CBD5796F63B")
    public SIPHeader parse() throws ParseException {
        AcceptEncodingList acceptEncodingList = new AcceptEncodingList();
        if(debug)        
        dbg_enter("AcceptEncodingParser.parse");
        try 
        {
            headerName(TokenTypes.ACCEPT_ENCODING);
            if(lexer.lookAhead(0) == '\n')            
            {
                AcceptEncoding acceptEncoding = new AcceptEncoding();
                acceptEncodingList.add(acceptEncoding);
            } //End block
            else
            {
                while
(lexer.lookAhead(0) != '\n')                
                {
                    AcceptEncoding acceptEncoding = new AcceptEncoding();
                    if(lexer.lookAhead(0) != ';')                    
                    {
                        lexer.match(TokenTypes.ID);
                        Token value = lexer.getNextToken();
                        acceptEncoding.setEncoding(value.getTokenValue());
                    } //End block
                    while
(lexer.lookAhead(0) == ';')                    
                    {
                        this.lexer.match(';');
                        this.lexer.SPorHT();
                        this.lexer.match('q');
                        this.lexer.SPorHT();
                        this.lexer.match('=');
                        this.lexer.SPorHT();
                        lexer.match(TokenTypes.ID);
                        Token value = lexer.getNextToken();
                        try 
                        {
                            float qv = Float.parseFloat(value.getTokenValue());
                            acceptEncoding.setQValue(qv);
                        } //End block
                        catch (NumberFormatException ex)
                        {
                            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_246692630 = createParseException(ex.getMessage());
                            varB8C80F72F95BF6A850D07F4EC5726C09_246692630.addTaint(taint);
                            throw varB8C80F72F95BF6A850D07F4EC5726C09_246692630;
                        } //End block
                        catch (InvalidArgumentException ex)
                        {
                            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1491396015 = createParseException(ex.getMessage());
                            varB8C80F72F95BF6A850D07F4EC5726C09_1491396015.addTaint(taint);
                            throw varB8C80F72F95BF6A850D07F4EC5726C09_1491396015;
                        } //End block
                        this.lexer.SPorHT();
                    } //End block
                    acceptEncodingList.add(acceptEncoding);
                    if(lexer.lookAhead(0) == ',')                    
                    {
                        this.lexer.match(',');
                        this.lexer.SPorHT();
                    } //End block
                } //End block
            } //End block
SIPHeader var684A86F9D58202A886EBCEE5BAF09496_1267139365 =             acceptEncodingList;
            var684A86F9D58202A886EBCEE5BAF09496_1267139365.addTaint(taint);
            return var684A86F9D58202A886EBCEE5BAF09496_1267139365;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("AcceptEncodingParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

