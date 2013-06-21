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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.314 -0400", hash_original_method = "25EDC565C62A5EB92B68AF9D2AE96AEA", hash_generated_method = "876D5476CC179C5563F94111A60933C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MimeVersionParser(String mimeVersion) {
        super(mimeVersion);
        dsTaint.addTaint(mimeVersion);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.314 -0400", hash_original_method = "931DCFE817B53A973ED5D85AA9B55841", hash_generated_method = "7DC990576C76157DE928ADE6049C9192")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MimeVersionParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.314 -0400", hash_original_method = "5451311C0FC76A3AF05558D3E031ACC9", hash_generated_method = "B79404C1C65CEA212E50A66989DA16CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("MimeVersionParser.parse");
        MimeVersion mimeVersion;
        mimeVersion = new MimeVersion();
        try 
        {
            headerName(TokenTypes.MIME_VERSION);
            mimeVersion.setHeaderName(SIPHeaderNames.MIME_VERSION);
            try 
            {
                String majorVersion;
                majorVersion = this.lexer.number();
                mimeVersion.setMajorVersion(Integer.parseInt(majorVersion));
                this.lexer.match('.');
                String minorVersion;
                minorVersion = this.lexer.number();
                mimeVersion.setMinorVersion(Integer.parseInt(minorVersion));
            } //End block
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            this.lexer.SPorHT();
            this.lexer.match('\n');
        } //End block
        finally 
        {
            dbg_leave("MimeVersionParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

