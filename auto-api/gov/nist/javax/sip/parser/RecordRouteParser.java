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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.500 -0400", hash_original_method = "C40758F2332745C9DEB0B2D886E345CA", hash_generated_method = "B00CE56B8F1586BAB88479F808DA5938")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RecordRouteParser(String recordRoute) {
        super(recordRoute);
        dsTaint.addTaint(recordRoute);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.500 -0400", hash_original_method = "3F2826642C5FF479B9C6E3756897DB2B", hash_generated_method = "32107450BC49524CC5C73E7BB12B55DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected RecordRouteParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.500 -0400", hash_original_method = "C9CC1BA66A01768C307588A1D8322CF7", hash_generated_method = "4287D3E8B4DD83BB58F078FC0A8B13A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
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
        } //End block
        finally 
        {
            dbg_leave("RecordRouteParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

