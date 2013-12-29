package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.MimeVersion;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;





public class MimeVersionParser extends HeaderParser {

    /**
     * Creates a new instance of MimeVersionParser
     * @param mimeVersion the header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.964 -0500", hash_original_method = "25EDC565C62A5EB92B68AF9D2AE96AEA", hash_generated_method = "51200390BBF441DEE63E131BE870C15B")
    public MimeVersionParser(String mimeVersion) {
        super(mimeVersion);
    }

    /**
     * Cosntructor
     * @param lexer the lexer to use to parse the header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.965 -0500", hash_original_method = "931DCFE817B53A973ED5D85AA9B55841", hash_generated_method = "2503BB1D1913D5F776009D687E3F6086")
    protected MimeVersionParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the String message
     * @return SIPHeader (MimeVersion object)
     * @throws SIPParseException if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:07.966 -0500", hash_original_method = "5451311C0FC76A3AF05558D3E031ACC9", hash_generated_method = "FE186EAE434EB3A5D7066811DBEC7D9B")
    public SIPHeader parse() throws ParseException {

        if (debug)
            dbg_enter("MimeVersionParser.parse");
        MimeVersion mimeVersion = new MimeVersion();
        try {
            headerName(TokenTypes.MIME_VERSION);

            mimeVersion.setHeaderName(SIPHeaderNames.MIME_VERSION);

            try {
                String majorVersion = this.lexer.number();
                mimeVersion.setMajorVersion(Integer.parseInt(majorVersion));
                this.lexer.match('.');
                String minorVersion = this.lexer.number();
                mimeVersion.setMinorVersion(Integer.parseInt(minorVersion));

            } catch (InvalidArgumentException ex) {
                throw createParseException(ex.getMessage());
            }
            this.lexer.SPorHT();

            this.lexer.match('\n');

            return mimeVersion;
        } finally {
            if (debug)
                dbg_leave("MimeVersionParser.parse");
        }
    }

    
}

