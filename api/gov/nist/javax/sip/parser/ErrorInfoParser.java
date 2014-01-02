package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.ErrorInfo;
import gov.nist.javax.sip.header.ErrorInfoList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class ErrorInfoParser extends ParametersParser {

    /**
     * Creates a new instance of ErrorInfoParser
     * @param errorInfo the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:44.997 -0500", hash_original_method = "5AFF5330EA4A2771143BBB17EF4E79AC", hash_generated_method = "78E52953AC1E5604BF9C3F2A580E0082")
    
public ErrorInfoParser(String errorInfo) {
        super(errorInfo);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.000 -0500", hash_original_method = "8F205A65B870DAE08BD525603424E427", hash_generated_method = "AA9562D41C05A7B0A724CBC57A219E55")
    
protected ErrorInfoParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the ErrorInfo String header
     * @return SIPHeader (ErrorInfoList object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.003 -0500", hash_original_method = "A1D86D832E01EE0ED40EBBDB518014BA", hash_generated_method = "A6F4EBCC052261AD4E1FC5AB5064FB3F")
    
public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("ErrorInfoParser.parse");
        ErrorInfoList list = new ErrorInfoList();

        try {
            headerName(TokenTypes.ERROR_INFO);

            while (lexer.lookAhead(0) != '\n') {
            	do {
	                ErrorInfo errorInfo = new ErrorInfo();
	                errorInfo.setHeaderName(SIPHeaderNames.ERROR_INFO);
	
	                this.lexer.SPorHT();
	                this.lexer.match('<');
	                URLParser urlParser = new URLParser((Lexer) this.lexer);
	                GenericURI uri = urlParser.uriReference( true );
	                errorInfo.setErrorInfo(uri);
	                this.lexer.match('>');
	                this.lexer.SPorHT();
	
	                super.parse(errorInfo);
	                list.add(errorInfo);
	                
	                if ( lexer.lookAhead(0) == ',' ) {
	                	this.lexer.match(',');
	                } else break;
            	} while (true);
            }

            return list;
        } finally {
            if (debug)
                dbg_leave("ErrorInfoParser.parse");
        }
    }

    
}

