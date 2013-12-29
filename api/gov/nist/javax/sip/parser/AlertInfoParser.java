package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.AlertInfo;
import gov.nist.javax.sip.header.AlertInfoList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class AlertInfoParser extends ParametersParser {

    /**
     * Creates a new instance of AlertInfo Parser
     * @param alertInfo  the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.265 -0500", hash_original_method = "D981F7025F52BA8E1CEDC583E21B710C", hash_generated_method = "73D70348B5426E6EBABB75233918596A")
    public AlertInfoParser(String alertInfo) {
        super(alertInfo);
    }

    /**
     * Constructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.266 -0500", hash_original_method = "FBB9329DBFDB9634284D1CD105BFF940", hash_generated_method = "C79A8175C763825EB46434CC8CBFE342")
    protected AlertInfoParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the AlertInfo  String header
     * @return SIPHeader (AlertInfoList  object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:11.267 -0500", hash_original_method = "01178CDB4B591AEEFEAB9C463FFB7ADD", hash_generated_method = "418D49F31C51CDC7D2171D64670F814D")
    public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("AlertInfoParser.parse");
        AlertInfoList list = new AlertInfoList();

        try {
            headerName(TokenTypes.ALERT_INFO);

            while (lexer.lookAhead(0) != '\n') {
                AlertInfo alertInfo = new AlertInfo();
                alertInfo.setHeaderName(SIPHeaderNames.ALERT_INFO);
                URLParser urlParser;
                GenericURI uri;

                do {
	                this.lexer.SPorHT();
	                if (this.lexer.lookAhead(0) == '<') {
	                    this.lexer.match('<');
	                    urlParser = new URLParser((Lexer) this.lexer);
	                    uri = urlParser.uriReference( true );
	                    alertInfo.setAlertInfo(uri);
	                    this.lexer.match('>');
	                } else {
	                	/* This is non standard for Polycom support. 
	                	 * I know it is bad grammar but please do not remove. mranga 
	                	 */
	                	String alertInfoStr = this.lexer.byteStringNoSemicolon();
	                	alertInfo.setAlertInfo(alertInfoStr);
	                }
	                	
	                this.lexer.SPorHT();
	
	                super.parse(alertInfo);
	                list.add(alertInfo);
	                
	                if ( lexer.lookAhead(0) == ',' ) {
	                	this.lexer.match(',');
	                } else break;
                } while (true);
            }
            return list;
        } finally {
            if (debug)
                dbg_leave("AlertInfoParser.parse");
        }
    }

    
}

