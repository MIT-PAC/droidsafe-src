package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.To;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ToParser extends AddressParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.056 -0400", hash_original_method = "C8F2641055D76DBC203D7F98D786CB89", hash_generated_method = "88793D27788E97D3A4BDFC1C76A5832E")
    public  ToParser(String to) {
        super(to);
        addTaint(to.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.057 -0400", hash_original_method = "F0F7A8E65FEB47CEDC2639617287C00D", hash_generated_method = "417100FA4B28FEC2CE41545F8246BD45")
    protected  ToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.057 -0400", hash_original_method = "9D8B9A06C15E6D7FEEEC143ED65417C6", hash_generated_method = "2210BE01A3EC505D2265B58C4570587E")
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.TO);
        To to = new To();
        super.parse(to);
        this.lexer.match('\n');
SIPHeader var26633470D0AEBDC975B85A12020B47EA_766286223 =         to;
        var26633470D0AEBDC975B85A12020B47EA_766286223.addTaint(taint);
        return var26633470D0AEBDC975B85A12020B47EA_766286223;
        // ---------- Original Method ----------
        //headerName(TokenTypes.TO);
        //To to = new To();
        //super.parse(to);
        //this.lexer.match('\n');
        //return to;
    }

    
}

