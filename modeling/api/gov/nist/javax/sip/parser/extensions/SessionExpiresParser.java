package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.extensions.SessionExpires;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;



public class SessionExpiresParser extends ParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.668 -0500", hash_original_method = "ACF0B386A0ED030CE5A2288D5CFBE065", hash_generated_method = "DFED83E799D9A1AD52ED7EBAF73FEBA3")
    
public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Session-Expires: 30\n",
                "Session-Expires: 45;refresher=uac\n",
            };

        for (int i = 0; i < to.length; i++) {
            SessionExpiresParser tp = new SessionExpiresParser(to[i]);
            SessionExpires t = (SessionExpires) tp.parse();
            System.out.println("encoded = " + t.encode());
            System.out.println("\ntime=" + t.getExpires() );
            if ( t.getParameter("refresher") != null)
                System.out.println("refresher=" + t.getParameter("refresher") );

        }
    }

    /**
     * protected constructor.
     * @param text is the text of the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.659 -0500", hash_original_method = "7C2BC7AE1B8B283C846DFC926BD1514D", hash_generated_method = "92EF66FA79735F35EDE6624461D41772")
    
public SessionExpiresParser(String text) {
        super(text);
    }

    /**
     * constructor.
     * @param lexer is the lexer passed in from the enclosing parser.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.663 -0500", hash_original_method = "821EB3B546274960D96C2E7F96AD190B", hash_generated_method = "6C33EA0CDB15BB74218B48878EB8E3FE")
    
protected SessionExpiresParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * Parse the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.665 -0500", hash_original_method = "3CD97DF13D6C3B595D5C8777AA80A144", hash_generated_method = "077DF7ACA3749BD5DB16CC648425AF0D")
    
public SIPHeader parse() throws ParseException {
        SessionExpires se = new SessionExpires();
        if (debug)
            dbg_enter("parse");
        try {
            headerName(TokenTypes.SESSIONEXPIRES_TO);

            String nextId = lexer.getNextId();

            try {
                int delta = Integer.parseInt(nextId);
                se.setExpires(delta);
            } catch (NumberFormatException ex) {
                throw createParseException("bad integer format");
            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }
            // May have parameters...
            this.lexer.SPorHT();
            super.parse(se);
            return se;

        } finally {
            if (debug)
                dbg_leave("parse");
        }

    }

    
}

