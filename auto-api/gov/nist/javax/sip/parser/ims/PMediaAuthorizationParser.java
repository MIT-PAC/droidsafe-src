package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import gov.nist.javax.sip.header.ims.PMediaAuthorizationList;
import gov.nist.javax.sip.header.ims.PMediaAuthorization;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

public class PMediaAuthorizationParser extends HeaderParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.153 -0400", hash_original_method = "FCF1A64239185FEE2932A543D4AD92F3", hash_generated_method = "7EAFE3DE02D9D17DF2E0738E9BDD2152")
    public  PMediaAuthorizationParser(String mediaAuthorization) {
        super(mediaAuthorization);
        addTaint(mediaAuthorization.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.154 -0400", hash_original_method = "D716B8B267E7C915523592278E20949F", hash_generated_method = "DC168B067E61EC34E3696FA9D6B2308B")
    public  PMediaAuthorizationParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.154 -0400", hash_original_method = "C50B4E6383FAF29D7342642FAF098C0C", hash_generated_method = "33684F9DF6CFF754B66F5E3EA80FF9E9")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1990667297 = null; 
        PMediaAuthorizationList mediaAuthorizationList = new PMediaAuthorizationList();
        dbg_enter("MediaAuthorizationParser.parse");
        try 
        {
            headerName(TokenTypes.P_MEDIA_AUTHORIZATION);
            PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
            mediaAuthorization.setHeaderName(SIPHeaderNamesIms.P_MEDIA_AUTHORIZATION);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1308816488 = (lexer.lookAhead(0) != '\n');
                {
                    this.lexer.match(TokenTypes.ID);
                    Token token = lexer.getNextToken();
                    try 
                    {
                        mediaAuthorization.setMediaAuthorizationToken(token.getTokenValue());
                    } 
                    catch (InvalidArgumentException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw createParseException(e.getMessage());
                    } 
                    mediaAuthorizationList.add(mediaAuthorization);
                    this.lexer.SPorHT();
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_2053718354 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            mediaAuthorization = new PMediaAuthorization();
                        } 
                    } 
                    this.lexer.SPorHT();
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1990667297 = mediaAuthorizationList;
        } 
        finally 
        {
            dbg_leave("MediaAuthorizationParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1990667297.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1990667297;
        
        
    }

    
}

