package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.RecordRoute;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

public class RecordRouteParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.140 -0400", hash_original_method = "C40758F2332745C9DEB0B2D886E345CA", hash_generated_method = "859F58793738CCE6071390F952D8FAE8")
    public  RecordRouteParser(String recordRoute) {
        super(recordRoute);
        addTaint(recordRoute.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.145 -0400", hash_original_method = "3F2826642C5FF479B9C6E3756897DB2B", hash_generated_method = "519B4B40D18E6A19225855187561F20F")
    protected  RecordRouteParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.155 -0400", hash_original_method = "C9CC1BA66A01768C307588A1D8322CF7", hash_generated_method = "C501E6ECBEF60DB1CD43CD8B122B435E")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1366192769 = null; //Variable for return #1
        RecordRouteList recordRouteList;
        recordRouteList = new RecordRouteList();
        dbg_enter("RecordRouteParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.RECORD_ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            {
                RecordRoute recordRoute;
                recordRoute = new RecordRoute();
                super.parse(recordRoute);
                recordRouteList.add(recordRoute);
                this.lexer.SPorHT();
                char la;
                la = lexer.lookAhead(0);
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } //End block
                if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1366192769 = recordRouteList;
        } //End block
        finally 
        {
            dbg_leave("RecordRouteParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1366192769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1366192769;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

