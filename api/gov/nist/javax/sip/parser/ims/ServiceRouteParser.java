package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.ServiceRoute;
import gov.nist.javax.sip.header.ims.ServiceRouteList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

public class ServiceRouteParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.341 -0400", hash_original_method = "C37E1CF835BF2C15063590E48C1460DA", hash_generated_method = "8C2B7AE6C87ECFA2AE553FECAD97617E")
    public  ServiceRouteParser(String serviceRoute) {
        super(serviceRoute);
        addTaint(serviceRoute.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.342 -0400", hash_original_method = "2EF38FE2F98AC9040691FDDD49315448", hash_generated_method = "40B8AF85BCDEC5F1C3B570E298922915")
    protected  ServiceRouteParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.371 -0400", hash_original_method = "8017C6E265731C6E1BE6E337AC0EFE2E", hash_generated_method = "BAD3BF165BDE7B422B9E2AD0A743E2E3")
    public SIPHeader parse() throws ParseException {
        ServiceRouteList serviceRouteList = new ServiceRouteList();
    if(debug)        
        dbg_enter("ServiceRouteParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.SERVICE_ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while
(true)            
            {
                ServiceRoute serviceRoute = new ServiceRoute();
                super.parse(serviceRoute);
                serviceRouteList.add(serviceRoute);
                this.lexer.SPorHT();
    if(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } //End block
                else
    if(lexer.lookAhead(0) == '\n')                
                break;
                else
                {
                java.text.ParseException var7805DD1445672D84C07E56FCC19D9765_1741341194 = createParseException("unexpected char");
                var7805DD1445672D84C07E56FCC19D9765_1741341194.addTaint(taint);
                throw var7805DD1445672D84C07E56FCC19D9765_1741341194;
                }
            } //End block
SIPHeader var15F59CE80F4A2D75F7C8D25CA28F4077_193185151 =             serviceRouteList;
            var15F59CE80F4A2D75F7C8D25CA28F4077_193185151.addTaint(taint);
            return var15F59CE80F4A2D75F7C8D25CA28F4077_193185151;
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("ServiceRouteParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

