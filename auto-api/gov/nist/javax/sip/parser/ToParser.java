package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.address.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;

public class ToParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.607 -0400", hash_original_method = "C8F2641055D76DBC203D7F98D786CB89", hash_generated_method = "7ED09F915C3CE6E7C63A9DE4E5BC09CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ToParser(String to) {
        super(to);
        dsTaint.addTaint(to);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.607 -0400", hash_original_method = "F0F7A8E65FEB47CEDC2639617287C00D", hash_generated_method = "B6463AF9B431D7EB6039DA8507701551")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ToParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.608 -0400", hash_original_method = "9D8B9A06C15E6D7FEEEC143ED65417C6", hash_generated_method = "AFCF5EA82554F49E74AEF11ACEA7EDE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.TO);
        To to;
        to = new To();
        super.parse(to);
        this.lexer.match('\n');
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //headerName(TokenTypes.TO);
        //To to = new To();
        //super.parse(to);
        //this.lexer.match('\n');
        //return to;
    }

    
}

