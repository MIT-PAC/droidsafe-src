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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.520 -0400", hash_original_method = "DFF32A898CEC13D94295FA47E9C2EAB3", hash_generated_method = "1E50361E0E92D60B864580297B7C8B0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RouteParser(String route) {
        super(route);
        dsTaint.addTaint(route);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.521 -0400", hash_original_method = "65EBCE19E35091936305B392D8A407A4", hash_generated_method = "F518C396E8B7BE1182F7C0309CD8390C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected RouteParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.523 -0400", hash_original_method = "E0D86A54342F3A96677BD3492DB07E61", hash_generated_method = "21AE3AC03294003D53E6B781918946BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
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
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

