package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.AlertInfo;
import gov.nist.javax.sip.header.AlertInfoList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import java.text.ParseException;

public class AlertInfoParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.228 -0400", hash_original_method = "D981F7025F52BA8E1CEDC583E21B710C", hash_generated_method = "D8020D0DE98BA046F7FF2558402C47F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AlertInfoParser(String alertInfo) {
        super(alertInfo);
        dsTaint.addTaint(alertInfo);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.228 -0400", hash_original_method = "FBB9329DBFDB9634284D1CD105BFF940", hash_generated_method = "225393D2F1DAD5C4AA811F50B313DD06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AlertInfoParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.229 -0400", hash_original_method = "01178CDB4B591AEEFEAB9C463FFB7ADD", hash_generated_method = "04F92FD32646FB07947023E9A36C6FE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("AlertInfoParser.parse");
        AlertInfoList list;
        list = new AlertInfoList();
        try 
        {
            headerName(TokenTypes.ALERT_INFO);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_918729206 = (lexer.lookAhead(0) != '\n');
                {
                    AlertInfo alertInfo;
                    alertInfo = new AlertInfo();
                    alertInfo.setHeaderName(SIPHeaderNames.ALERT_INFO);
                    URLParser urlParser;
                    GenericURI uri;
                    {
                        this.lexer.SPorHT();
                        {
                            boolean varE004C7CB8B05EEA814FA2754FBC458B9_1718964791 = (this.lexer.lookAhead(0) == '<');
                            {
                                this.lexer.match('<');
                                urlParser = new URLParser((Lexer) this.lexer);
                                uri = urlParser.uriReference( true );
                                alertInfo.setAlertInfo(uri);
                                this.lexer.match('>');
                            } //End block
                            {
                                String alertInfoStr;
                                alertInfoStr = this.lexer.byteStringNoSemicolon();
                                alertInfo.setAlertInfo(alertInfoStr);
                            } //End block
                        } //End collapsed parenthetic
                        this.lexer.SPorHT();
                        super.parse(alertInfo);
                        list.add(alertInfo);
                        {
                            boolean var9AE54EB6EBAEA27AE99856C2C81EF714_1598851220 = (lexer.lookAhead(0) == ',');
                            {
                                this.lexer.match(',');
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("AlertInfoParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

