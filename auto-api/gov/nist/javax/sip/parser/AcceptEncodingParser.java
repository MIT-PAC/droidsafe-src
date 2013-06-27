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
import javax.sip.*;

public class AcceptEncodingParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.063 -0400", hash_original_method = "865E86FA800E1D68F0770AD3080D258F", hash_generated_method = "F0F93EB7D3971DD3BFB62EE12CA6FFF8")
    public  AcceptEncodingParser(String acceptEncoding) {
        super(acceptEncoding);
        addTaint(acceptEncoding.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.063 -0400", hash_original_method = "2A31652D0F06752F063CE4D7769684DB", hash_generated_method = "275A392B40423395F120EDEEAEEEC6CC")
    protected  AcceptEncodingParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.075 -0400", hash_original_method = "A9DB3F83816CED00173237937952E9D8", hash_generated_method = "713EFBA6C8DECD073E326E47E9DF2299")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1364093314 = null; //Variable for return #1
        AcceptEncodingList acceptEncodingList;
        acceptEncodingList = new AcceptEncodingList();
        dbg_enter("AcceptEncodingParser.parse");
        try 
        {
            headerName(TokenTypes.ACCEPT_ENCODING);
            {
                boolean var1FFD4C60FBFDEA303315F5CA0F26F4D7_64018153 = (lexer.lookAhead(0) == '\n');
                {
                    AcceptEncoding acceptEncoding;
                    acceptEncoding = new AcceptEncoding();
                    acceptEncodingList.add(acceptEncoding);
                } //End block
                {
                    {
                        boolean varEE7E52664D9AD5CC0BCC54974CA397F5_152705445 = (lexer.lookAhead(0) != '\n');
                        {
                            AcceptEncoding acceptEncoding;
                            acceptEncoding = new AcceptEncoding();
                            {
                                boolean varD42C1A55C19AAEC8287557F1254134A8_457746099 = (lexer.lookAhead(0) != ';');
                                {
                                    lexer.match(TokenTypes.ID);
                                    Token value;
                                    value = lexer.getNextToken();
                                    acceptEncoding.setEncoding(value.getTokenValue());
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean varE91A1AFB3AE8E5E9730856A1A36B3A33_737072264 = (lexer.lookAhead(0) == ';');
                                {
                                    this.lexer.match(';');
                                    this.lexer.SPorHT();
                                    this.lexer.match('q');
                                    this.lexer.SPorHT();
                                    this.lexer.match('=');
                                    this.lexer.SPorHT();
                                    lexer.match(TokenTypes.ID);
                                    Token value;
                                    value = lexer.getNextToken();
                                    try 
                                    {
                                        float qv;
                                        qv = Float.parseFloat(value.getTokenValue());
                                        acceptEncoding.setQValue(qv);
                                    } //End block
                                    catch (NumberFormatException ex)
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                                    } //End block
                                    catch (InvalidArgumentException ex)
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                                    } //End block
                                    this.lexer.SPorHT();
                                } //End block
                            } //End collapsed parenthetic
                            acceptEncodingList.add(acceptEncoding);
                            {
                                boolean varBB8B123DF79A8601AA2894E0E9CB4B5B_1754430504 = (lexer.lookAhead(0) == ',');
                                {
                                    this.lexer.match(',');
                                    this.lexer.SPorHT();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1364093314 = acceptEncodingList;
        } //End block
        finally 
        {
            dbg_leave("AcceptEncodingParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1364093314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1364093314;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

