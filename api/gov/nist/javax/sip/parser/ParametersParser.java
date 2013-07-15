package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public abstract class ParametersParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.948 -0400", hash_original_method = "8DB209633D35B91A05910E58BFF524C0", hash_generated_method = "60EECF453E8AEF1F96199531012AB464")
    protected  ParametersParser(Lexer lexer) {
        super((Lexer) lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.948 -0400", hash_original_method = "1337D3E6D061A128A8E8534FBF59A488", hash_generated_method = "C4F88D2E99DE3DC3430895330CA3BC8E")
    protected  ParametersParser(String buffer) {
        super(buffer);
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.948 -0400", hash_original_method = "D7D1ED3794D3EF5845398404979DE69B", hash_generated_method = "776F3D8F5F4BDE4004E634BC09BAD823")
    protected void parse(ParametersHeader parametersHeader) throws ParseException {
        addTaint(parametersHeader.getTaint());
        this.lexer.SPorHT();
        while
(lexer.lookAhead(0) == ';')        
        {
            this.lexer.consume(1);
            this.lexer.SPorHT();
            NameValue nv = nameValue();
            parametersHeader.setParameter(nv);
            this.lexer.SPorHT();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.949 -0400", hash_original_method = "F0B8EED12E7201B6D65F9EE76F7129AE", hash_generated_method = "703A9073FDCC74319A70A8CB40B735B8")
    protected void parseNameValueList(ParametersHeader parametersHeader) throws ParseException {
        addTaint(parametersHeader.getTaint());
        parametersHeader.removeParameters();
        while
(true)        
        {
            this.lexer.SPorHT();
            NameValue nv = nameValue();
            parametersHeader.setParameter(nv.getName(), (String) nv.getValueAsObject());
            this.lexer.SPorHT();
    if(lexer.lookAhead(0) != ';')            
            break;
            else
            lexer.consume(1);
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

