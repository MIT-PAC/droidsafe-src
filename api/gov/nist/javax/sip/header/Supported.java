package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.SupportedHeader;

public class Supported extends SIPHeader implements SupportedHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.094 -0500", hash_original_field = "7197556C98CD7192E6A00806270D0BD9", hash_generated_field = "D3D7272B6F01E32B817268E9A8B320BF")

    private static final long serialVersionUID = -7679667592702854542L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.097 -0500", hash_original_field = "C47D1E13159584343BDF40043CEB3AB4", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;

    /**
     * default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.101 -0500", hash_original_method = "5230DF363A4CA66C4A13E103BCE72C7C", hash_generated_method = "DA6B84DAE57BCABDF40552B8614BA9EB")
    
public Supported() {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = null;
    }

    /**
     * Constructor
     * @param option_tag String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.105 -0500", hash_original_method = "22E9310B7938D206E4E2944ECFF36AB1", hash_generated_method = "1ED08BB97BADF69037FCF15E3FD0406B")
    
public Supported(String option_tag) {
        super(SIPHeaderNames.SUPPORTED);
        optionTag = option_tag;
    }

    /**
     * Return canonical form of the header.
     * @return encoded header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.108 -0500", hash_original_method = "6B2B571AE4F377CE25FA9B4608683BF5", hash_generated_method = "285A23FFDABA1DF6F6F9408346D12FBB")
    
public String encode() {
        String retval = headerName + COLON;
        if (optionTag != null)
            retval += SP + optionTag;
        retval += NEWLINE;
        return retval;
    }

    /**
     * Just the encoded body of the header.
     * @return the string encoded header body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.112 -0500", hash_original_method = "CAE88651ED9FF39412B77E9D96C77B38", hash_generated_method = "79A792DE7E8750FA6A50549E86B079B3")
    
public String encodeBody() {
        return optionTag != null ? optionTag : "";
    }

    /**
     * Sets the option tag value to the new supplied <var>optionTag</var>
     * parameter.
     *
     * @param optionTag - the new string value of the option tag.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the optionTag value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.116 -0500", hash_original_method = "0B1E7641398A7F9C5ED01BA7A61C72A2", hash_generated_method = "D0F8D4EC1B0241D173AADADAB4B97522")
    
public void setOptionTag(String optionTag) throws ParseException {
        if (optionTag == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, Supported, "
                    + "setOptionTag(), the optionTag parameter is null");
        this.optionTag = optionTag;
    }

    /**
     * Gets the option tag of this OptionTag class.
     *
     * @return the string that identifies the option tag value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.119 -0500", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "3633D701492785C9119138C7D9BDC157")
    
public String getOptionTag() {
        return optionTag;
    }
}

