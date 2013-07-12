package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;

public class RouteParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.740 -0400", hash_original_method = "DFF32A898CEC13D94295FA47E9C2EAB3", hash_generated_method = "CCB142AF0640712F5A880BE1E74E344B")
    public  RouteParser(String route) {
        super(route);
        addTaint(route.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.740 -0400", hash_original_method = "65EBCE19E35091936305B392D8A407A4", hash_generated_method = "D86A25C00424C247C99545F5C2ADE94D")
    protected  RouteParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.763 -0400", hash_original_method = "E0D86A54342F3A96677BD3492DB07E61", hash_generated_method = "E8558E0786C3416AEADFF37184C197C5")
    public SIPHeader parse() throws ParseException {
        RouteList routeList = new RouteList();
    if(debug)        
        dbg_enter("parse");
        try 
        {
            this.lexer.match(TokenTypes.ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while
(true)            
            {
                Route route = new Route();
                super.parse(route);
                routeList.add(route);
                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
    if(la == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } 
                else
    if(la == '\n')                
                break;
                else
                {
                java.text.ParseException var7805DD1445672D84C07E56FCC19D9765_1577031262 = createParseException("unexpected char");
                var7805DD1445672D84C07E56FCC19D9765_1577031262.addTaint(taint);
                throw var7805DD1445672D84C07E56FCC19D9765_1577031262;
                }
            } 
SIPHeader varDD4D761079CF45381591ED9272C87190_323177663 =             routeList;
            varDD4D761079CF45381591ED9272C87190_323177663.addTaint(taint);
            return varDD4D761079CF45381591ED9272C87190_323177663;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("parse");
        } 
        
        
    }

    
}

