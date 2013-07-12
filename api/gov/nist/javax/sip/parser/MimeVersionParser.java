package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;
import javax.sip.*;

public class MimeVersionParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.846 -0400", hash_original_method = "25EDC565C62A5EB92B68AF9D2AE96AEA", hash_generated_method = "61EF8513FB01478CF0DBB78AFE1EC056")
    public  MimeVersionParser(String mimeVersion) {
        super(mimeVersion);
        addTaint(mimeVersion.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.847 -0400", hash_original_method = "931DCFE817B53A973ED5D85AA9B55841", hash_generated_method = "6511C9A06A99E68915FA6E59B17CA6E4")
    protected  MimeVersionParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.877 -0400", hash_original_method = "5451311C0FC76A3AF05558D3E031ACC9", hash_generated_method = "B06441E4359C2C89137187D3587F5A63")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("MimeVersionParser.parse");
        MimeVersion mimeVersion = new MimeVersion();
        try 
        {
            headerName(TokenTypes.MIME_VERSION);
            mimeVersion.setHeaderName(SIPHeaderNames.MIME_VERSION);
            try 
            {
                String majorVersion = this.lexer.number();
                mimeVersion.setMajorVersion(Integer.parseInt(majorVersion));
                this.lexer.match('.');
                String minorVersion = this.lexer.number();
                mimeVersion.setMinorVersion(Integer.parseInt(minorVersion));
            } 
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_213284106 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_213284106.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_213284106;
            } 
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var1D087FC59F135838A55A37D08589B761_429799429 =             mimeVersion;
            var1D087FC59F135838A55A37D08589B761_429799429.addTaint(taint);
            return var1D087FC59F135838A55A37D08589B761_429799429;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("MimeVersionParser.parse");
        } 
        
        
    }

    
}

