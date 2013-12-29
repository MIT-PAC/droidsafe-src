package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.RecordRoute;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class RecordRouteParser extends AddressParametersParser {

    /**
     * Constructor
     * @param recordRoute message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:09.992 -0500", hash_original_method = "C40758F2332745C9DEB0B2D886E345CA", hash_generated_method = "FFBBA40B58487D7DC5EF08EB4BF49B98")
    public RecordRouteParser(String recordRoute) {
        super(recordRoute);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:09.993 -0500", hash_original_method = "3F2826642C5FF479B9C6E3756897DB2B", hash_generated_method = "7C78A9716C5FEE99C42E739569DFADA1")
    protected RecordRouteParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message and generate the RecordRoute List Object
     * @return SIPHeader the RecordRoute List object
     * @throws ParseException if errors occur during the parsing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:09.994 -0500", hash_original_method = "C9CC1BA66A01768C307588A1D8322CF7", hash_generated_method = "EE9BF37411D5DC944E8278B3CFA690F7")
    public SIPHeader parse() throws ParseException {
        RecordRouteList recordRouteList = new RecordRouteList();

        if (debug)
            dbg_enter("RecordRouteParser.parse");

        try {
            this.lexer.match(TokenTypes.RECORD_ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while (true) {
                RecordRoute recordRoute = new RecordRoute();
                super.parse(recordRoute);
                recordRouteList.add(recordRoute);
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
            return recordRouteList;
        } finally {
            if (debug)
                dbg_leave("RecordRouteParser.parse");
        }

    }

    
}

