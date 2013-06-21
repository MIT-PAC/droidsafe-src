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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.732 -0400", hash_original_method = "25FD33E3054230667E9A8F92C1B17418", hash_generated_method = "342D2A44D257EB16D195F5D231D382C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReferencesParser(String references) {
        super(references);
        dsTaint.addTaint(references);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.733 -0400", hash_original_method = "CBAD07AA72F20B2B658D118EA3760591", hash_generated_method = "1570C61613B3025F168726C4D18AB0C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ReferencesParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.733 -0400", hash_original_method = "9AD39421D9E40B39389DA2F4797EEA52", hash_generated_method = "0F2171D70FB779FF25A874C97C7BC1DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
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
        } //End block
        finally 
        {
            dbg_leave("ReferencesParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

