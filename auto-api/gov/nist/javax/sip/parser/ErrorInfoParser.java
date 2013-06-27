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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.731 -0400", hash_original_method = "5AFF5330EA4A2771143BBB17EF4E79AC", hash_generated_method = "83D3B9F618EFC876DDE2B0F01045EEC6")
    public  ErrorInfoParser(String errorInfo) {
        super(errorInfo);
        addTaint(errorInfo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.732 -0400", hash_original_method = "8F205A65B870DAE08BD525603424E427", hash_generated_method = "5E6090731FD6E4E3002E0DA957BD8102")
    protected  ErrorInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.741 -0400", hash_original_method = "A1D86D832E01EE0ED40EBBDB518014BA", hash_generated_method = "EDDA19B848D5AA7D80FC8551AF32C834")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_523699585 = null; //Variable for return #1
        dbg_enter("ErrorInfoParser.parse");
        ErrorInfoList list;
        list = new ErrorInfoList();
        try 
        {
            headerName(TokenTypes.ERROR_INFO);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_807644852 = (lexer.lookAhead(0) != '\n');
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
                            boolean var9AE54EB6EBAEA27AE99856C2C81EF714_1005119201 = (lexer.lookAhead(0) == ',');
                            {
                                this.lexer.match(',');
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_523699585 = list;
        } //End block
        finally 
        {
            dbg_leave("ErrorInfoParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_523699585.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_523699585;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

