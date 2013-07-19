package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import gov.nist.core.Token;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.PMediaAuthorization;
import gov.nist.javax.sip.header.ims.PMediaAuthorizationList;
import gov.nist.javax.sip.header.ims.SIPHeaderNamesIms;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;

import droidsafe.annotations.DSGenerator;

public class PMediaAuthorizationParser extends HeaderParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.928 -0400", hash_original_method = "FCF1A64239185FEE2932A543D4AD92F3", hash_generated_method = "7EAFE3DE02D9D17DF2E0738E9BDD2152")
    public  PMediaAuthorizationParser(String mediaAuthorization) {
        super(mediaAuthorization);
        addTaint(mediaAuthorization.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.929 -0400", hash_original_method = "D716B8B267E7C915523592278E20949F", hash_generated_method = "DC168B067E61EC34E3696FA9D6B2308B")
    public  PMediaAuthorizationParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.960 -0400", hash_original_method = "C50B4E6383FAF29D7342642FAF098C0C", hash_generated_method = "F9603AEF00FC7A69DC5B6194A8B5483F")
    public SIPHeader parse() throws ParseException {
        PMediaAuthorizationList mediaAuthorizationList = new PMediaAuthorizationList();
        if(debug)        
        dbg_enter("MediaAuthorizationParser.parse");
        try 
        {
            headerName(TokenTypes.P_MEDIA_AUTHORIZATION);
            PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
            mediaAuthorization.setHeaderName(SIPHeaderNamesIms.P_MEDIA_AUTHORIZATION);
            while
(lexer.lookAhead(0) != '\n')            
            {
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                try 
                {
                    mediaAuthorization.setMediaAuthorizationToken(token.getTokenValue());
                } //End block
                catch (InvalidArgumentException e)
                {
                    java.text.ParseException var1B38A553A6CA651B5F935142A3D93863_1582205114 = createParseException(e.getMessage());
                    var1B38A553A6CA651B5F935142A3D93863_1582205114.addTaint(taint);
                    throw var1B38A553A6CA651B5F935142A3D93863_1582205114;
                } //End block
                mediaAuthorizationList.add(mediaAuthorization);
                this.lexer.SPorHT();
                if(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    mediaAuthorization = new PMediaAuthorization();
                } //End block
                this.lexer.SPorHT();
            } //End block
SIPHeader var3BA054D97AF854A274CBD64A3C9397B9_168034000 =             mediaAuthorizationList;
            var3BA054D97AF854A274CBD64A3C9397B9_168034000.addTaint(taint);
            return var3BA054D97AF854A274CBD64A3C9397B9_168034000;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("MediaAuthorizationParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

