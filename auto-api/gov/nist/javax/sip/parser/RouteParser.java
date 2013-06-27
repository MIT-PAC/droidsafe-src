package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;

public class RouteParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.104 -0400", hash_original_method = "DFF32A898CEC13D94295FA47E9C2EAB3", hash_generated_method = "CCB142AF0640712F5A880BE1E74E344B")
    public  RouteParser(String route) {
        super(route);
        addTaint(route.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.104 -0400", hash_original_method = "65EBCE19E35091936305B392D8A407A4", hash_generated_method = "D86A25C00424C247C99545F5C2ADE94D")
    protected  RouteParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.150 -0400", hash_original_method = "E0D86A54342F3A96677BD3492DB07E61", hash_generated_method = "7D876065C7A3EB692C921C421165C02F")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_636010328 = null; //Variable for return #1
        RouteList routeList;
        routeList = new RouteList();
        dbg_enter("parse");
        try 
        {
            this.lexer.match(TokenTypes.ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            {
                Route route;
                route = new Route();
                super.parse(route);
                routeList.add(route);
                this.lexer.SPorHT();
                char la;
                la = lexer.lookAhead(0);
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } //End block
                if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_636010328 = routeList;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_636010328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_636010328;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

