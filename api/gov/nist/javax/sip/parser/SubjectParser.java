package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.Subject;

import java.text.ParseException;





public class SubjectParser extends HeaderParser {

    /**
     * Creates a new instance of SubjectParser
     * @param subject the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.475 -0500", hash_original_method = "9E40B472DD9B461ACD98BE83100C34CB", hash_generated_method = "6CE253272E113F090E23F22A83149CD1")
    public SubjectParser(String subject) {
        super(subject);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.476 -0500", hash_original_method = "105C510EC26F8BC32BFFFC46FA511F27", hash_generated_method = "70AF6E45538F134B3DE5717DF9E91913")
    protected SubjectParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (Subject object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.477 -0500", hash_original_method = "F2D8E65DBCC7717EF7411B874638ABFB", hash_generated_method = "9A93F1DB537FA91FD6F040A691AADCE3")
    public SIPHeader parse() throws ParseException {
        Subject subject = new Subject();
        if (debug)
            dbg_enter("SubjectParser.parse");

        try {
            headerName(TokenTypes.SUBJECT);

            this.lexer.SPorHT();

            String s = this.lexer.getRest();
            subject.setSubject(s.trim());

        } finally {
            if (debug)
                dbg_leave("SubjectParser.parse");
        }

        return subject;
    }

    
}

