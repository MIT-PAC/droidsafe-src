package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.769 -0400", hash_original_method = "FCF1A64239185FEE2932A543D4AD92F3", hash_generated_method = "B6CAC083565524789D141A8924120139")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PMediaAuthorizationParser(String mediaAuthorization) {
        super(mediaAuthorization);
        dsTaint.addTaint(mediaAuthorization);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.769 -0400", hash_original_method = "D716B8B267E7C915523592278E20949F", hash_generated_method = "3A2FF3FEE0EEADE369FB50ADF3DAE434")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PMediaAuthorizationParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.770 -0400", hash_original_method = "C50B4E6383FAF29D7342642FAF098C0C", hash_generated_method = "C1D6E321CB616EFCA0E70074FB4FFC95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        PMediaAuthorizationList mediaAuthorizationList;
        mediaAuthorizationList = new PMediaAuthorizationList();
        dbg_enter("MediaAuthorizationParser.parse");
        try 
        {
            headerName(TokenTypes.P_MEDIA_AUTHORIZATION);
            PMediaAuthorization mediaAuthorization;
            mediaAuthorization = new PMediaAuthorization();
            mediaAuthorization.setHeaderName(SIPHeaderNamesIms.P_MEDIA_AUTHORIZATION);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1692356148 = (lexer.lookAhead(0) != '\n');
                {
                    this.lexer.match(TokenTypes.ID);
                    Token token;
                    token = lexer.getNextToken();
                    try 
                    {
                        mediaAuthorization.setMediaAuthorizationToken(token.getTokenValue());
                    } //End block
                    catch (InvalidArgumentException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw createParseException(e.getMessage());
                    } //End block
                    mediaAuthorizationList.add(mediaAuthorization);
                    this.lexer.SPorHT();
                    {
                        boolean var7DC6EF7D2962860F171D1CEF6887AFF5_1009655466 = (lexer.lookAhead(0) == ',');
                        {
                            this.lexer.match(',');
                            mediaAuthorization = new PMediaAuthorization();
                        } //End block
                    } //End collapsed parenthetic
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("MediaAuthorizationParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

