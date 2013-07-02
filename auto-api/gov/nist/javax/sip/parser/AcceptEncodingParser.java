package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;
import javax.sip.*;

public class AcceptEncodingParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.629 -0400", hash_original_method = "865E86FA800E1D68F0770AD3080D258F", hash_generated_method = "F0F93EB7D3971DD3BFB62EE12CA6FFF8")
    public  AcceptEncodingParser(String acceptEncoding) {
        super(acceptEncoding);
        addTaint(acceptEncoding.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.629 -0400", hash_original_method = "2A31652D0F06752F063CE4D7769684DB", hash_generated_method = "275A392B40423395F120EDEEAEEEC6CC")
    protected  AcceptEncodingParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.630 -0400", hash_original_method = "A9DB3F83816CED00173237937952E9D8", hash_generated_method = "CAF88BBB745F9600D227D51D5AFB85BE")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1991795899 = null; 
        AcceptEncodingList acceptEncodingList = new AcceptEncodingList();
        dbg_enter("AcceptEncodingParser.parse");
        try 
        {
            headerName(TokenTypes.ACCEPT_ENCODING);
            {
                boolean var1FFD4C60FBFDEA303315F5CA0F26F4D7_1986262421 = (lexer.lookAhead(0) == '\n');
                {
                    AcceptEncoding acceptEncoding = new AcceptEncoding();
                    acceptEncodingList.add(acceptEncoding);
                } 
                {
                    {
                        boolean varEE7E52664D9AD5CC0BCC54974CA397F5_1832733343 = (lexer.lookAhead(0) != '\n');
                        {
                            AcceptEncoding acceptEncoding = new AcceptEncoding();
                            {
                                boolean varD42C1A55C19AAEC8287557F1254134A8_347381359 = (lexer.lookAhead(0) != ';');
                                {
                                    lexer.match(TokenTypes.ID);
                                    Token value = lexer.getNextToken();
                                    acceptEncoding.setEncoding(value.getTokenValue());
                                } 
                            } 
                            {
                                boolean varE91A1AFB3AE8E5E9730856A1A36B3A33_1831577870 = (lexer.lookAhead(0) == ';');
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
                                    } 
                                    catch (NumberFormatException ex)
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                                    } 
                                    catch (InvalidArgumentException ex)
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                                    } 
                                    this.lexer.SPorHT();
                                } 
                            } 
                            acceptEncodingList.add(acceptEncoding);
                            {
                                boolean varBB8B123DF79A8601AA2894E0E9CB4B5B_1565643070 = (lexer.lookAhead(0) == ',');
                                {
                                    this.lexer.match(',');
                                    this.lexer.SPorHT();
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1991795899 = acceptEncodingList;
        } 
        finally 
        {
            dbg_leave("AcceptEncodingParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1991795899.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1991795899;
        
        
    }

    
}

