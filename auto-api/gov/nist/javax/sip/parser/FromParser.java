package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

public class FromParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.282 -0400", hash_original_method = "959F9668B577E560A18D35872EBA8497", hash_generated_method = "3517542B12E2EA2DFEB5E7637469CC47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FromParser(String from) {
        super(from);
        dsTaint.addTaint(from);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.282 -0400", hash_original_method = "CEE001D4136BA6038E80B22CA8F776D5", hash_generated_method = "676597B87D8DC1381A3669D418C3F563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected FromParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.283 -0400", hash_original_method = "090BCBCCA2A0D46A805C56D0690187FF", hash_generated_method = "1A312C077EE8280A8A7E422D7834E3A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        From from;
        from = new From();
        this.lexer.match(TokenTypes.FROM);
        this.lexer.SPorHT();
        this.lexer.match(':');
        this.lexer.SPorHT();
        super.parse(from);
        this.lexer.match('\n');
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //From from = new From();
        //this.lexer.match(TokenTypes.FROM);
        //this.lexer.SPorHT();
        //this.lexer.match(':');
        //this.lexer.SPorHT();
        //super.parse(from);
        //this.lexer.match('\n');
        //return from;
    }

    
}

