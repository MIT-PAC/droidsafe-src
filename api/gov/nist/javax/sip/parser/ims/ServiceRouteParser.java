package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.ServiceRoute;
import gov.nist.javax.sip.header.ims.ServiceRouteList;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class ServiceRouteParser extends AddressParametersParser {

    /**
     * Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.424 -0500", hash_original_method = "C37E1CF835BF2C15063590E48C1460DA", hash_generated_method = "91A3AC21788F4F2D74D630BBAC81C226")
    public ServiceRouteParser(String serviceRoute) {
        super(serviceRoute);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.425 -0500", hash_original_method = "2EF38FE2F98AC9040691FDDD49315448", hash_generated_method = "F725CBBE4C5294C57AEDE6D3999AC866")
    protected ServiceRouteParser(Lexer lexer) {
        super(lexer);

    }




    /**
     * parse the String message and generate the RecordRoute List Object
     * @return SIPHeader the RecordRoute List object
     * @throws ParseException if errors occur during the parsing
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.426 -0500", hash_original_method = "8017C6E265731C6E1BE6E337AC0EFE2E", hash_generated_method = "4B7330DFC58E357A5D1DD143C737CB5A")
    public SIPHeader parse() throws ParseException {
        ServiceRouteList serviceRouteList = new ServiceRouteList();

        if (debug)
            dbg_enter("ServiceRouteParser.parse");

        try {
            this.lexer.match(TokenTypes.SERVICE_ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while (true) {
                ServiceRoute serviceRoute = new ServiceRoute();
                super.parse(serviceRoute);
                serviceRouteList.add(serviceRoute);
                this.lexer.SPorHT();
                if (lexer.lookAhead(0) == ',') {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } else if (lexer.lookAhead(0) == '\n')
                    break;
                else
                    throw createParseException("unexpected char");
            }
            return serviceRouteList;
        } finally {
            if (debug)
                dbg_leave("ServiceRouteParser.parse");
        }

    }

    
}

