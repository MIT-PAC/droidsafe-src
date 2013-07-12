package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.AlertInfo;
import gov.nist.javax.sip.header.AlertInfoList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;
import java.text.ParseException;

public class AlertInfoParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.823 -0400", hash_original_method = "D981F7025F52BA8E1CEDC583E21B710C", hash_generated_method = "41BACA132BB4D5A2EA759A0E45FC23E8")
    public  AlertInfoParser(String alertInfo) {
        super(alertInfo);
        addTaint(alertInfo.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.824 -0400", hash_original_method = "FBB9329DBFDB9634284D1CD105BFF940", hash_generated_method = "FD6C3DC5F66F572DD8205BD78C09C230")
    protected  AlertInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:39.825 -0400", hash_original_method = "01178CDB4B591AEEFEAB9C463FFB7ADD", hash_generated_method = "B41EEC215F548ED826A737D47B357C15")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("AlertInfoParser.parse");
        AlertInfoList list = new AlertInfoList();
        try 
        {
            headerName(TokenTypes.ALERT_INFO);
            while
(lexer.lookAhead(0) != '\n')            
            {
                AlertInfo alertInfo = new AlertInfo();
                alertInfo.setHeaderName(SIPHeaderNames.ALERT_INFO);
                URLParser urlParser;
                GenericURI uri;
                do {
                    {
                        this.lexer.SPorHT();
    if(this.lexer.lookAhead(0) == '<')                        
                        {
                            this.lexer.match('<');
                            urlParser = new URLParser((Lexer) this.lexer);
                            uri = urlParser.uriReference( true );
                            alertInfo.setAlertInfo(uri);
                            this.lexer.match('>');
                        } 
                        else
                        {
                            String alertInfoStr = this.lexer.byteStringNoSemicolon();
                            alertInfo.setAlertInfo(alertInfoStr);
                        } 
                        this.lexer.SPorHT();
                        super.parse(alertInfo);
                        list.add(alertInfo);
    if(lexer.lookAhead(0) == ',')                        
                        {
                            this.lexer.match(',');
                        } 
                        else
                        break;
                    } 
} while (true);
            } 
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_1109355496 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1109355496.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1109355496;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("AlertInfoParser.parse");
        } 
        
        
    }

    
}

