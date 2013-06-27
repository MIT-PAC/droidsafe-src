package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.Reason;
import gov.nist.javax.sip.header.ReasonList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.extensions.References;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.ParametersParser;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

public class ReferencesParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.520 -0400", hash_original_method = "25FD33E3054230667E9A8F92C1B17418", hash_generated_method = "CD6E7E32788BACC1EB2EED70743A8412")
    public  ReferencesParser(String references) {
        super(references);
        addTaint(references.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.520 -0400", hash_original_method = "CBAD07AA72F20B2B658D118EA3760591", hash_generated_method = "C2171F8AF6C79D90DB92DCAE037087DC")
    protected  ReferencesParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.530 -0400", hash_original_method = "9AD39421D9E40B39389DA2F4797EEA52", hash_generated_method = "C980E36C423F9B089E5467B4629A6E49")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_280580128 = null; //Variable for return #1
        dbg_enter("ReasonParser.parse");
        try 
        {
            headerName(TokenTypes.REFERENCES);
            References references;
            references = new References();
            this.lexer.SPorHT();
            String callId;
            callId = lexer.byteStringNoSemicolon();
            references.setCallId(callId);
            super.parse(references);
            varB4EAC82CA7396A68D541C85D26508E83_280580128 = references;
        } //End block
        finally 
        {
            dbg_leave("ReferencesParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_280580128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_280580128;
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("ReasonParser.parse");
        //try {
            //headerName(TokenTypes.REFERENCES);
            //References references= new References();
            //this.lexer.SPorHT();
            //String callId = lexer.byteStringNoSemicolon();
            //references.setCallId(callId);
            //super.parse(references);
            //return references;
       //} finally {
            //if (debug)
                //dbg_leave("ReferencesParser.parse");
        //}
    }

    
}

