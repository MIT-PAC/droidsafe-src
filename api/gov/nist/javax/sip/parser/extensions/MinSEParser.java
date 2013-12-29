package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.extensions.MinSE;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;



public class MinSEParser extends ParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.612 -0500", hash_original_method = "E86AEAD7B8387926D56101FBEC7503CC", hash_generated_method = "B34AA48A5669AD803EF9C175D6C00B3F")
    public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Min-SE: 30\n",
                "Min-SE: 45;some-param=somevalue\n",
            };

        for (int i = 0; i < to.length; i++) {
            MinSEParser tp = new MinSEParser(to[i]);
            MinSE t = (MinSE) tp.parse();
            System.out.println("encoded = " + t.encode());
            System.out.println("\ntime=" + t.getExpires() );
            if ( t.getParameter("some-param") != null)
                System.out.println("some-param=" + t.getParameter("some-param") );

        }
    }

    /**
     * protected constructor.
     * @param text is the text of the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.609 -0500", hash_original_method = "4E326F54C0BC2C416F3292ADC3B64C39", hash_generated_method = "128FBADAA8C8D7A254214D2F18043CEA")
    public MinSEParser(String text) {
        super(text);
    }

    /**
     * constructor.
     * @param lexer is the lexer passed in from the enclosing parser.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.610 -0500", hash_original_method = "B8B8CA8DFA565E816EE248A435214726", hash_generated_method = "6B38DB421A09124EF569232382ED930E")
    protected MinSEParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * Parse the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.611 -0500", hash_original_method = "528678E8CA90A52E25DB45830845A36C", hash_generated_method = "E5C8943AA23C175AD9456952BB0A5717")
    public SIPHeader parse() throws ParseException {
        MinSE minse = new MinSE();
        if (debug)
            dbg_enter("parse");
        try {
            headerName(TokenTypes.MINSE_TO);

            String nextId = lexer.getNextId();
            try {
                int delta = Integer.parseInt(nextId);
                minse.setExpires(delta);
            } catch (NumberFormatException ex) {
                throw createParseException("bad integer format");
            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }
            this.lexer.SPorHT();
            super.parse(minse);
            return minse;

        } finally {
            if (debug)
                dbg_leave("parse");
        }

    }

    
}

