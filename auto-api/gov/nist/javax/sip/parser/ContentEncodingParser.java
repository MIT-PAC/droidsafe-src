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

public class ContentEncodingParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.857 -0400", hash_original_method = "025E1AD213DC2532673CB1D1FC75B1CC", hash_generated_method = "FFAAEC346361910DA318E1B0118C932F")
    public  ContentEncodingParser(String contentEncoding) {
        super(contentEncoding);
        addTaint(contentEncoding.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.857 -0400", hash_original_method = "15007428AB3C93C7C47122E74B782E26", hash_generated_method = "AF577344E81FCFEAE8DA389C0D71631C")
    protected  ContentEncodingParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.858 -0400", hash_original_method = "8ACC6861A4ACA970AEBA8CCFE6984687", hash_generated_method = "010FF5F01DF80BAEBF9AA8E9DB474252")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1976187923 = null; //Variable for return #1
        dbg_enter("ContentEncodingParser.parse");
        ContentEncodingList list = new ContentEncodingList();
        try 
        {
            headerName(TokenTypes.CONTENT_ENCODING);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1493154467 = (lexer.lookAhead(0) != '\n');
                {
                    ContentEncoding cl = new ContentEncoding();
                    cl.setHeaderName(SIPHeaderNames.CONTENT_ENCODING);
                    this.lexer.SPorHT();
                    this.lexer.match(TokenTypes.ID);
                    Token token = lexer.getNextToken();
                    cl.setEncoding(token.getTokenValue());
                    this.lexer.SPorHT();
                    list.add(cl);
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_908905682 = (lexer.lookAhead(0) == ',');
                        {
                            cl = new ContentEncoding();
                            this.lexer.match(',');
                            this.lexer.SPorHT();
                            this.lexer.match(TokenTypes.ID);
                            this.lexer.SPorHT();
                            token = lexer.getNextToken();
                            cl.setEncoding(token.getTokenValue());
                            this.lexer.SPorHT();
                            list.add(cl);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1976187923 = list;
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
        } //End block
        finally 
        {
            dbg_leave("ContentEncodingParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1976187923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1976187923;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

