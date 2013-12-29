package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;





public abstract class ParametersParser extends HeaderParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.801 -0500", hash_original_method = "8DB209633D35B91A05910E58BFF524C0", hash_generated_method = "B4EA7A4D1C53C7F58B65509E918C9523")
    protected ParametersParser(Lexer lexer) {
        super((Lexer) lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.802 -0500", hash_original_method = "1337D3E6D061A128A8E8534FBF59A488", hash_generated_method = "FE9D561B0681BC9D95D2F8D43C9B4368")
    protected ParametersParser(String buffer) {
        super(buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.803 -0500", hash_original_method = "D7D1ED3794D3EF5845398404979DE69B", hash_generated_method = "CC715EC3C331B152762A1B190636D2C0")
    protected void parse(ParametersHeader parametersHeader)
        throws ParseException {
        this.lexer.SPorHT();
        while (lexer.lookAhead(0) == ';') {
            this.lexer.consume(1);
            // eat white space
            this.lexer.SPorHT();
            NameValue nv = nameValue();
            parametersHeader.setParameter(nv);
            // eat white space
            this.lexer.SPorHT();
        }
    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.804 -0500", hash_original_method = "F0B8EED12E7201B6D65F9EE76F7129AE", hash_generated_method = "B9F59CBD0CFF38B099A8D6A68132B4CC")
    protected void parseNameValueList(ParametersHeader parametersHeader)
        throws ParseException{
        parametersHeader.removeParameters();
        while (true) {
                this.lexer.SPorHT();
            NameValue nv = nameValue();
            parametersHeader.setParameter(nv.getName(), (String) nv.getValueAsObject());
            // eat white space
            this.lexer.SPorHT();
            if (lexer.lookAhead(0) != ';')  break;
            else lexer.consume(1);
        }
    }

    
}

