package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.header.RecordRoute;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RecordRouteParser extends AddressParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.476 -0400", hash_original_method = "C40758F2332745C9DEB0B2D886E345CA", hash_generated_method = "859F58793738CCE6071390F952D8FAE8")
    public  RecordRouteParser(String recordRoute) {
        super(recordRoute);
        addTaint(recordRoute.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.477 -0400", hash_original_method = "3F2826642C5FF479B9C6E3756897DB2B", hash_generated_method = "519B4B40D18E6A19225855187561F20F")
    protected  RecordRouteParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.504 -0400", hash_original_method = "C9CC1BA66A01768C307588A1D8322CF7", hash_generated_method = "B4998478D8B42F7983FB27B5F8EC3E68")
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
                } //End block
                else
                if(la == '\n')                
                break;
                else
                {
                java.text.ParseException var7805DD1445672D84C07E56FCC19D9765_735621879 = createParseException("unexpected char");
                var7805DD1445672D84C07E56FCC19D9765_735621879.addTaint(taint);
                throw var7805DD1445672D84C07E56FCC19D9765_735621879;
                }
            } //End block
SIPHeader var077967A4BC62D9D4F59D10D83D22AC95_369330219 =             recordRouteList;
            var077967A4BC62D9D4F59D10D83D22AC95_369330219.addTaint(taint);
            return var077967A4BC62D9D4F59D10D83D22AC95_369330219;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("RecordRouteParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

