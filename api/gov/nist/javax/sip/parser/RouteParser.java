package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.Route;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;





public class RouteParser extends AddressParametersParser {

    /**
     * Constructor
     * @param route message to parse to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.550 -0500", hash_original_method = "DFF32A898CEC13D94295FA47E9C2EAB3", hash_generated_method = "17AEE4635166A568E66ACB92B9E2737B")
    
public RouteParser(String route) {
        super(route);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.553 -0500", hash_original_method = "65EBCE19E35091936305B392D8A407A4", hash_generated_method = "98E9130EB13A843499A914C9155B8783")
    
protected RouteParser(Lexer lexer) {
        super(lexer);
    }

    /** parse the String message and generate the Route List Object
     * @return SIPHeader the Route List object
     * @throws SIPParseException if errors occur during the parsing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.556 -0500", hash_original_method = "E0D86A54342F3A96677BD3492DB07E61", hash_generated_method = "3BC2E46FCD45BBF5CB5F5ACFF64F945A")
    
public SIPHeader parse() throws ParseException {
        RouteList routeList = new RouteList();
        if (debug)
            dbg_enter("parse");

        try {
            this.lexer.match(TokenTypes.ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while (true) {
                Route route = new Route();
                super.parse(route);
                routeList.add(route);
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
            return routeList;
        } finally {
            if (debug)
                dbg_leave("parse");
        }

    }

    
}

