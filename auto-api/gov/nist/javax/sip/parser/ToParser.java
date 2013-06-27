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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.259 -0400", hash_original_method = "C8F2641055D76DBC203D7F98D786CB89", hash_generated_method = "88793D27788E97D3A4BDFC1C76A5832E")
    public  ToParser(String to) {
        super(to);
        addTaint(to.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.259 -0400", hash_original_method = "F0F7A8E65FEB47CEDC2639617287C00D", hash_generated_method = "417100FA4B28FEC2CE41545F8246BD45")
    protected  ToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.260 -0400", hash_original_method = "9D8B9A06C15E6D7FEEEC143ED65417C6", hash_generated_method = "8C425954E2ABA8EA022E978BFE534044")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_45154117 = null; //Variable for return #1
        headerName(TokenTypes.TO);
        To to;
        to = new To();
        super.parse(to);
        this.lexer.match('\n');
        varB4EAC82CA7396A68D541C85D26508E83_45154117 = to;
        varB4EAC82CA7396A68D541C85D26508E83_45154117.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_45154117;
        // ---------- Original Method ----------
        //headerName(TokenTypes.TO);
        //To to = new To();
        //super.parse(to);
        //this.lexer.match('\n');
        //return to;
    }

    
}

