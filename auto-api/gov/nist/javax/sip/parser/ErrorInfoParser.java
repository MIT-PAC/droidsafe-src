package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;

public class ErrorInfoParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.726 -0400", hash_original_method = "5AFF5330EA4A2771143BBB17EF4E79AC", hash_generated_method = "83D3B9F618EFC876DDE2B0F01045EEC6")
    public  ErrorInfoParser(String errorInfo) {
        super(errorInfo);
        addTaint(errorInfo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.726 -0400", hash_original_method = "8F205A65B870DAE08BD525603424E427", hash_generated_method = "5E6090731FD6E4E3002E0DA957BD8102")
    protected  ErrorInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:33.727 -0400", hash_original_method = "A1D86D832E01EE0ED40EBBDB518014BA", hash_generated_method = "5DEF3CE6C3A3691D49C3535107DB7D7F")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1418395132 = null; //Variable for return #1
        dbg_enter("ErrorInfoParser.parse");
        ErrorInfoList list;
        list = new ErrorInfoList();
        try 
        {
            headerName(TokenTypes.ERROR_INFO);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_595270544 = (lexer.lookAhead(0) != '\n');
                {
                    {
                        ErrorInfo errorInfo;
                        errorInfo = new ErrorInfo();
                        errorInfo.setHeaderName(SIPHeaderNames.ERROR_INFO);
                        this.lexer.SPorHT();
                        this.lexer.match('<');
                        URLParser urlParser;
                        urlParser = new URLParser((Lexer) this.lexer);
                        GenericURI uri;
                        uri = urlParser.uriReference( true );
                        errorInfo.setErrorInfo(uri);
                        this.lexer.match('>');
                        this.lexer.SPorHT();
                        super.parse(errorInfo);
                        list.add(errorInfo);
                        {
                            boolean var9AE54EB6EBAEA27AE99856C2C81EF714_31744289 = (lexer.lookAhead(0) == ',');
                            {
                                this.lexer.match(',');
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1418395132 = list;
        } //End block
        finally 
        {
            dbg_leave("ErrorInfoParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1418395132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1418395132;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

