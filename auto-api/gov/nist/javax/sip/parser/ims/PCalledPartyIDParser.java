package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.ims.PCalledPartyID;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import gov.nist.javax.sip.parser.AddressParametersParser;

public class PCalledPartyIDParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.701 -0400", hash_original_method = "5A210D10F0DA09D81C9A40BA3A0E0BA0", hash_generated_method = "BBD7965D346BF1D7806D7ABC42DEB4ED")
    public  PCalledPartyIDParser(String calledPartyID) {
        super(calledPartyID);
        addTaint(calledPartyID.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.702 -0400", hash_original_method = "A63723B4A16B3DEC36752AB85CAA4736", hash_generated_method = "1A433AD9ED26F8AC88F7689284675C35")
    protected  PCalledPartyIDParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.735 -0400", hash_original_method = "C43CF84ED746DD134AB177C7FEFB3286", hash_generated_method = "823C724D4CA46BB296AFBC53493FF7D4")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1017750941 = null; //Variable for return #1
        dbg_enter("PCalledPartyIDParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.P_CALLED_PARTY_ID);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            PCalledPartyID calledPartyID;
            calledPartyID = new PCalledPartyID();
            super.parse(calledPartyID);
            varB4EAC82CA7396A68D541C85D26508E83_1017750941 = calledPartyID;
        } //End block
        finally 
        {
            dbg_leave("PCalledPartyIDParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1017750941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1017750941;
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("PCalledPartyIDParser.parse");
        //try {
            //this.lexer.match(TokenTypes.P_CALLED_PARTY_ID);
            //this.lexer.SPorHT();
            //this.lexer.match(':');
            //this.lexer.SPorHT();
            //PCalledPartyID calledPartyID = new PCalledPartyID();
            //super.parse(calledPartyID);
            //return calledPartyID;
        //} finally {
            //if (debug)
                //dbg_leave("PCalledPartyIDParser.parse");
        //}
    }

    
}

