package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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



public class PMediaAuthorizationParser extends HeaderParser implements TokenTypes {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.330 -0500", hash_original_method = "FCF1A64239185FEE2932A543D4AD92F3", hash_generated_method = "7076EF27D1A806996BF96E20BCFDDDAB")
    public PMediaAuthorizationParser(String mediaAuthorization)
    {
        super(mediaAuthorization);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.331 -0500", hash_original_method = "D716B8B267E7C915523592278E20949F", hash_generated_method = "9CB0257D27E600B178817B419E9D596A")
    public PMediaAuthorizationParser(Lexer lexer)
    {
        super(lexer);

    }





    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.332 -0500", hash_original_method = "C50B4E6383FAF29D7342642FAF098C0C", hash_generated_method = "4C19F066CE139EC60B58D83360855BBF")
    public SIPHeader parse() throws ParseException
    {
        PMediaAuthorizationList mediaAuthorizationList = new PMediaAuthorizationList();

        if (debug)
            dbg_enter("MediaAuthorizationParser.parse");


        try
        {
            headerName(TokenTypes.P_MEDIA_AUTHORIZATION);

            PMediaAuthorization mediaAuthorization = new PMediaAuthorization();
            mediaAuthorization.setHeaderName(SIPHeaderNamesIms.P_MEDIA_AUTHORIZATION);

            while (lexer.lookAhead(0) != '\n')
            {
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                try {
                    mediaAuthorization.setMediaAuthorizationToken(token.getTokenValue());
                } catch (InvalidArgumentException e) {
                    throw createParseException(e.getMessage());
                }
                mediaAuthorizationList.add(mediaAuthorization);

                this.lexer.SPorHT();
                if (lexer.lookAhead(0) == ',')
                {
                    this.lexer.match(',');
                    mediaAuthorization = new PMediaAuthorization();
                }
                this.lexer.SPorHT();
            }

            return mediaAuthorizationList;

        }
        finally
        {
            if (debug)
                dbg_leave("MediaAuthorizationParser.parse");
        }

    }

    
}

