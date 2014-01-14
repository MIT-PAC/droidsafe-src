package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

public class Unsupported extends SIPHeader implements javax.sip.header.UnsupportedHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.549 -0500", hash_original_field = "63FC33D91B036DDB5D1EE03493BC37C8", hash_generated_field = "E6F62805C9FB301CFBA40BB42552946D")

    private static final long serialVersionUID = -2479414149440236199L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.552 -0500", hash_original_field = "C47D1E13159584343BDF40043CEB3AB4", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;

    /** Default Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.555 -0500", hash_original_method = "7F4BD1C3AF5762ECCF124F3A56ADDC67", hash_generated_method = "C7539E168CCF8644EA352FC2FA7CBB57")
    
public Unsupported() {
        super(NAME);
    }

    /** Constructor
     * @param ot String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.558 -0500", hash_original_method = "91BBA837F044D0A0A4874364E40F6125", hash_generated_method = "11CA3027313799B12E4ADD3BD57AD068")
    
public Unsupported(String ot) {
        super(NAME);
        optionTag = ot;
    }

    /**
     * Return a canonical value.
     * @return String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.561 -0500", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "3E11F84AAB428D962C364CC48C7D950E")
    
public String encodeBody() {
        return optionTag;
    }

    /** get the option tag field
     * @return option Tag field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.564 -0500", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "3633D701492785C9119138C7D9BDC157")
    
public String getOptionTag() {
        return optionTag;
    }

    /**
     * Set the option member
     * @param o String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.567 -0500", hash_original_method = "3B18B091D01592A1C9601DEA63572A7E", hash_generated_method = "824D28BA3B3DCAF8F04AFCDD32A81971")
    
public void setOptionTag(String o) throws ParseException {
        if (o == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Unsupported, setOptionTag(), The option tag parameter is null");
        optionTag = o;
    }
}

