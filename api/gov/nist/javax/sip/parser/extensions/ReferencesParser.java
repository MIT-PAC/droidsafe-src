package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.814 -0400", hash_original_method = "25FD33E3054230667E9A8F92C1B17418", hash_generated_method = "CD6E7E32788BACC1EB2EED70743A8412")
    public  ReferencesParser(String references) {
        super(references);
        addTaint(references.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.821 -0400", hash_original_method = "CBAD07AA72F20B2B658D118EA3760591", hash_generated_method = "C2171F8AF6C79D90DB92DCAE037087DC")
    protected  ReferencesParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.827 -0400", hash_original_method = "9AD39421D9E40B39389DA2F4797EEA52", hash_generated_method = "BF6FFB020A3CC1578B2155D272CF334D")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("ReasonParser.parse");
        try 
        {
            headerName(TokenTypes.REFERENCES);
            References references = new References();
            this.lexer.SPorHT();
            String callId = lexer.byteStringNoSemicolon();
            references.setCallId(callId);
            super.parse(references);
SIPHeader var311DB9309688CA05C9943FE1AD747745_1505286406 =             references;
            var311DB9309688CA05C9943FE1AD747745_1505286406.addTaint(taint);
            return var311DB9309688CA05C9943FE1AD747745_1505286406;
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("ReferencesParser.parse");
        } //End block
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

