package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public abstract class ParametersParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.322 -0400", hash_original_method = "8DB209633D35B91A05910E58BFF524C0", hash_generated_method = "C22970C23C16C87EF57174D558EC4EEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ParametersParser(Lexer lexer) {
        super((Lexer) lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.322 -0400", hash_original_method = "1337D3E6D061A128A8E8534FBF59A488", hash_generated_method = "8B3D30E2FCE5A7064FF9711069E91AFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ParametersParser(String buffer) {
        super(buffer);
        dsTaint.addTaint(buffer);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.323 -0400", hash_original_method = "D7D1ED3794D3EF5845398404979DE69B", hash_generated_method = "4BB1F13F8CAE40AE758BCAABD902F44A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parse(ParametersHeader parametersHeader) throws ParseException {
        dsTaint.addTaint(parametersHeader.dsTaint);
        this.lexer.SPorHT();
        {
            boolean var96A32AC0A30F05473A254B92D685A530_2122138708 = (lexer.lookAhead(0) == ';');
            {
                this.lexer.consume(1);
                this.lexer.SPorHT();
                NameValue nv;
                nv = nameValue();
                parametersHeader.setParameter(nv);
                this.lexer.SPorHT();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.lexer.SPorHT();
        //while (lexer.lookAhead(0) == ';') {
            //this.lexer.consume(1);
            //this.lexer.SPorHT();
            //NameValue nv = nameValue();
            //parametersHeader.setParameter(nv);
            //this.lexer.SPorHT();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.323 -0400", hash_original_method = "F0B8EED12E7201B6D65F9EE76F7129AE", hash_generated_method = "92E4AD71C2AC572086067F7616F213C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseNameValueList(ParametersHeader parametersHeader) throws ParseException {
        dsTaint.addTaint(parametersHeader.dsTaint);
        parametersHeader.removeParameters();
        {
            this.lexer.SPorHT();
            NameValue nv;
            nv = nameValue();
            parametersHeader.setParameter(nv.getName(), (String) nv.getValueAsObject());
            this.lexer.SPorHT();
            {
                boolean var541BF3F506176B4EBE1E71D770C209F8_745080219 = (lexer.lookAhead(0) != ';');
                lexer.consume(1);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //parametersHeader.removeParameters();
        //while (true) {
                //this.lexer.SPorHT();
            //NameValue nv = nameValue();
            //parametersHeader.setParameter(nv.getName(), (String) nv.getValueAsObject());
            //this.lexer.SPorHT();
            //if (lexer.lookAhead(0) != ';')  break;
            //else lexer.consume(1);
        //}
    }

    
}

