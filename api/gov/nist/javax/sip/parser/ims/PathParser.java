package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.Path;
import gov.nist.javax.sip.header.ims.PathList;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PathParser extends AddressParametersParser implements TokenTypes {

    /**
     * Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.344 -0500", hash_original_method = "7A079BF63C48031C1D75ACF959BDA24D", hash_generated_method = "E119292C8F5D62110AF1CE0ACF0B5286")
    public PathParser(String path) {
        super(path);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.345 -0500", hash_original_method = "91CE1B5A663F1BD7DA26A8D59664C334", hash_generated_method = "CA70901F113022FD0A4D747653931086")
    protected PathParser(Lexer lexer) {
        super(lexer);

    }




    /**
     * parse the String message and generate the RecordRoute List Object
     * @return SIPHeader the RecordRoute List object
     * @throws ParseException if errors occur during the parsing
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.347 -0500", hash_original_method = "F1314A453C93E830C24484946DC25942", hash_generated_method = "08FB4211899015991841F25F84138047")
    public SIPHeader parse() throws ParseException {

        PathList pathList = new PathList();

        if (debug)
            dbg_enter("PathParser.parse");

        try {
            this.lexer.match(TokenTypes.PATH);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while (true) {
                Path path = new Path();
                super.parse(path);
                pathList.add(path);
                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
                if (la == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } else if (la == '\n')
                    break;
                else
                    throw createParseException("unexpected char");
            }
            return pathList;
        } finally {
            if (debug)
                dbg_leave("PathParser.parse");
        }

    }

    
}

