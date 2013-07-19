package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.header.MimeVersion;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MimeVersionParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.814 -0400", hash_original_method = "25EDC565C62A5EB92B68AF9D2AE96AEA", hash_generated_method = "61EF8513FB01478CF0DBB78AFE1EC056")
    public  MimeVersionParser(String mimeVersion) {
        super(mimeVersion);
        addTaint(mimeVersion.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.814 -0400", hash_original_method = "931DCFE817B53A973ED5D85AA9B55841", hash_generated_method = "6511C9A06A99E68915FA6E59B17CA6E4")
    protected  MimeVersionParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.838 -0400", hash_original_method = "5451311C0FC76A3AF05558D3E031ACC9", hash_generated_method = "C1158B3DB7C917163FF14CFBF804609D")
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
            } //End block
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_2105141851 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_2105141851.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_2105141851;
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var1D087FC59F135838A55A37D08589B761_19366537 =             mimeVersion;
            var1D087FC59F135838A55A37D08589B761_19366537.addTaint(taint);
            return var1D087FC59F135838A55A37D08589B761_19366537;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("MimeVersionParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

