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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.768 -0400", hash_original_method = "C37E1CF835BF2C15063590E48C1460DA", hash_generated_method = "8C2B7AE6C87ECFA2AE553FECAD97617E")
    public  ServiceRouteParser(String serviceRoute) {
        super(serviceRoute);
        addTaint(serviceRoute.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.768 -0400", hash_original_method = "2EF38FE2F98AC9040691FDDD49315448", hash_generated_method = "40B8AF85BCDEC5F1C3B570E298922915")
    protected  ServiceRouteParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.779 -0400", hash_original_method = "8017C6E265731C6E1BE6E337AC0EFE2E", hash_generated_method = "9E6CF3E55BC64E72FDA90E3A03253258")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_593361771 = null; //Variable for return #1
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
                    boolean varFAA47A806C2A7754F7408D0DC0C208DE_644199961 = (lexer.lookAhead(0) == ',');
                    {
                        this.lexer.match(',');
                        this.lexer.SPorHT();
                    } //End block
                    {
                        boolean var91663D5DD0C5A7E21E3D02876DD48380_1448399248 = (lexer.lookAhead(0) == '\n');
                        if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char");
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_593361771 = serviceRouteList;
        } //End block
        finally 
        {
            dbg_leave("ServiceRouteParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_593361771.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_593361771;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

