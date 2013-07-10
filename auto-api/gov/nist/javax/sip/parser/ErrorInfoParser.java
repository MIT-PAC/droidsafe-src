package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;

public class ErrorInfoParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.940 -0400", hash_original_method = "5AFF5330EA4A2771143BBB17EF4E79AC", hash_generated_method = "83D3B9F618EFC876DDE2B0F01045EEC6")
    public  ErrorInfoParser(String errorInfo) {
        super(errorInfo);
        addTaint(errorInfo.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.940 -0400", hash_original_method = "8F205A65B870DAE08BD525603424E427", hash_generated_method = "5E6090731FD6E4E3002E0DA957BD8102")
    protected  ErrorInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.942 -0400", hash_original_method = "A1D86D832E01EE0ED40EBBDB518014BA", hash_generated_method = "EBCF1238AE2BBD5FCD156C1D738901BD")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_106385511 = null; 
        dbg_enter("ErrorInfoParser.parse");
        ErrorInfoList list = new ErrorInfoList();
        try 
        {
            headerName(TokenTypes.ERROR_INFO);
            {
                boolean varA38820C66B6BCE71087D920E2767FF09_1559255356 = (lexer.lookAhead(0) != '\n');
                {
                    {
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
                        {
                            boolean var9AE54EB6EBAEA27AE99856C2C81EF714_1783998622 = (lexer.lookAhead(0) == ',');
                            {
                                this.lexer.match(',');
                            } 
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_106385511 = list;
        } 
        finally 
        {
            dbg_leave("ErrorInfoParser.parse");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_106385511.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_106385511;
        
        
    }

    
}

