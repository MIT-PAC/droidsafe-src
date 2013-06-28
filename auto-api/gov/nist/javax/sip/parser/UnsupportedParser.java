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

public class UnsupportedParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.918 -0400", hash_original_method = "A2BE521086BBB92362B9FD64733842A2", hash_generated_method = "7809126EFAC73A571FF3B7A48A899ADF")
    public  UnsupportedParser(String unsupported) {
        super(unsupported);
        addTaint(unsupported.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.919 -0400", hash_original_method = "FB5DFA63EA36D3A5606EA09CE2E82C0B", hash_generated_method = "8674C2FC274DA68E9AAEFD11180FC307")
    protected  UnsupportedParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.920 -0400", hash_original_method = "9F68B71E39A8D368C1910EB63F18B506", hash_generated_method = "E8377DAE56E24A6227C89F60F5095F1B")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1228854723 = null; //Variable for return #1
        UnsupportedList unsupportedList = new UnsupportedList();
        dbg_enter("UnsupportedParser.parse");
        try 
        {
            headerName(TokenTypes.UNSUPPORTED);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1994623341 = (lexer.lookAhead(0) != '\n');
                {
                    this.lexer.SPorHT();
                    Unsupported unsupported = new Unsupported();
                    unsupported.setHeaderName(SIPHeaderNames.UNSUPPORTED);
                    this.lexer.match(TokenTypes.ID);
                    Token token = lexer.getNextToken();
                    unsupported.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();
                    unsupportedList.add(unsupported);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_1765754189 = (lexer.lookAhead(0) == ',');
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
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("UnsupportedParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1228854723 = unsupportedList;
        varB4EAC82CA7396A68D541C85D26508E83_1228854723.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1228854723;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

