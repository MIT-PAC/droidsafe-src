package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class UnsupportedParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.465 -0400", hash_original_method = "A2BE521086BBB92362B9FD64733842A2", hash_generated_method = "7809126EFAC73A571FF3B7A48A899ADF")
    public  UnsupportedParser(String unsupported) {
        super(unsupported);
        addTaint(unsupported.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.466 -0400", hash_original_method = "FB5DFA63EA36D3A5606EA09CE2E82C0B", hash_generated_method = "8674C2FC274DA68E9AAEFD11180FC307")
    protected  UnsupportedParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.468 -0400", hash_original_method = "9F68B71E39A8D368C1910EB63F18B506", hash_generated_method = "0940571BF6D9DE45380214A6EDE7AB3F")
    public SIPHeader parse() throws ParseException {
        UnsupportedList unsupportedList = new UnsupportedList();
    if(debug)        
        dbg_enter("UnsupportedParser.parse");
        try 
        {
            headerName(TokenTypes.UNSUPPORTED);
            while
(lexer.lookAhead(0) != '\n')            
            {
                this.lexer.SPorHT();
                Unsupported unsupported = new Unsupported();
                unsupported.setHeaderName(SIPHeaderNames.UNSUPPORTED);
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                unsupported.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();
                unsupportedList.add(unsupported);
                while
(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    unsupported = new Unsupported();
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    unsupported.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();
                    unsupportedList.add(unsupported);
                } //End block
            } //End block
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("UnsupportedParser.parse");
        } //End block
SIPHeader var0D178A71459F746090513430AFB4C58D_352697426 =         unsupportedList;
        var0D178A71459F746090513430AFB4C58D_352697426.addTaint(taint);
        return var0D178A71459F746090513430AFB4C58D_352697426;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

