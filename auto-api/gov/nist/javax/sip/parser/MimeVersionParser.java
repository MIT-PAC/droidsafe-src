package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;
import javax.sip.*;

public class MimeVersionParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.060 -0400", hash_original_method = "25EDC565C62A5EB92B68AF9D2AE96AEA", hash_generated_method = "61EF8513FB01478CF0DBB78AFE1EC056")
    public  MimeVersionParser(String mimeVersion) {
        super(mimeVersion);
        addTaint(mimeVersion.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.060 -0400", hash_original_method = "931DCFE817B53A973ED5D85AA9B55841", hash_generated_method = "6511C9A06A99E68915FA6E59B17CA6E4")
    protected  MimeVersionParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.061 -0400", hash_original_method = "5451311C0FC76A3AF05558D3E031ACC9", hash_generated_method = "79B5D597DAC056077C34DD8A51914821")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_846535718 = null; //Variable for return #1
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
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_846535718 = mimeVersion;
        } //End block
        finally 
        {
            dbg_leave("MimeVersionParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_846535718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_846535718;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

