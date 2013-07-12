package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.RecordRoute;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

public class RecordRouteParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.597 -0400", hash_original_method = "C40758F2332745C9DEB0B2D886E345CA", hash_generated_method = "859F58793738CCE6071390F952D8FAE8")
    public  RecordRouteParser(String recordRoute) {
        super(recordRoute);
        addTaint(recordRoute.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.598 -0400", hash_original_method = "3F2826642C5FF479B9C6E3756897DB2B", hash_generated_method = "519B4B40D18E6A19225855187561F20F")
    protected  RecordRouteParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.618 -0400", hash_original_method = "C9CC1BA66A01768C307588A1D8322CF7", hash_generated_method = "A7FA18A80C5BB0B06A214FEA372706E6")
    public SIPHeader parse() throws ParseException {
        RecordRouteList recordRouteList = new RecordRouteList();
    if(debug)        
        dbg_enter("RecordRouteParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.RECORD_ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while
(true)            
            {
                RecordRoute recordRoute = new RecordRoute();
                super.parse(recordRoute);
                recordRouteList.add(recordRoute);
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
                java.text.ParseException var7805DD1445672D84C07E56FCC19D9765_1479150031 = createParseException("unexpected char");
                var7805DD1445672D84C07E56FCC19D9765_1479150031.addTaint(taint);
                throw var7805DD1445672D84C07E56FCC19D9765_1479150031;
                }
            } 
SIPHeader var077967A4BC62D9D4F59D10D83D22AC95_2071440331 =             recordRouteList;
            var077967A4BC62D9D4F59D10D83D22AC95_2071440331.addTaint(taint);
            return var077967A4BC62D9D4F59D10D83D22AC95_2071440331;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("RecordRouteParser.parse");
        } 
        
        
    }

    
}

