package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.ServiceRoute;
import gov.nist.javax.sip.header.ims.ServiceRouteList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

public class ServiceRouteParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.796 -0400", hash_original_method = "C37E1CF835BF2C15063590E48C1460DA", hash_generated_method = "BE517D61D63FDB59041F2C16D985C30E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceRouteParser(String serviceRoute) {
        super(serviceRoute);
        dsTaint.addTaint(serviceRoute);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.796 -0400", hash_original_method = "2EF38FE2F98AC9040691FDDD49315448", hash_generated_method = "3C73CAE5FE88E06D54EDA662BEA55933")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ServiceRouteParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.797 -0400", hash_original_method = "8017C6E265731C6E1BE6E337AC0EFE2E", hash_generated_method = "13153F45662717EDDE570BEBB21165F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        ServiceRouteList serviceRouteList;
        serviceRouteList = new ServiceRouteList();
        dbg_enter("ServiceRouteParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.SERVICE_ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            {
                ServiceRoute serviceRoute;
                serviceRoute = new ServiceRoute();
                super.parse(serviceRoute);
                serviceRouteList.add(serviceRoute);
                this.lexer.SPorHT();
                {
                    boolean varFAA47A806C2A7754F7408D0DC0C208DE_528279857 = (lexer.lookAhead(0) == ',');
                    {
                        this.lexer.match(',');
                        this.lexer.SPorHT();
                    } //End block
                    {
                        boolean var91663D5DD0C5A7E21E3D02876DD48380_1603959536 = (lexer.lookAhead(0) == '\n');
                        if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char");
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            dbg_leave("ServiceRouteParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

