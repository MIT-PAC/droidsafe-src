package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.ProxyRequireHeader;






public class ProxyRequire extends SIPHeader implements ProxyRequireHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.624 -0500", hash_original_field = "1E87E4F799B2271111225028953CC6D5", hash_generated_field = "EA994B24C6A518D84FF4C741C559C547")

    private static final long serialVersionUID = -3269274234851067893L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.627 -0500", hash_original_field = "C47D1E13159584343BDF40043CEB3AB4", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;

    /**
     * Default  Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.631 -0500", hash_original_method = "313262BBE47BF259092F8848A4D13338", hash_generated_method = "285B287E7C11CBCB6E456C35E2CB8B48")
    
public ProxyRequire() {
        super(PROXY_REQUIRE);
    }

    /** Constructor
     * @param s String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.634 -0500", hash_original_method = "3BC392B937FA3D9900D8752B431D0DD9", hash_generated_method = "C2CEE6687AAFA29EE710F17BEE3B71E8")
    
public ProxyRequire(String s) {
        super(PROXY_REQUIRE);
        optionTag = s;
    }

    /**
     * Encode in canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.637 -0500", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "3E11F84AAB428D962C364CC48C7D950E")
    
public String encodeBody() {
        return optionTag;
    }

    /**
     * Sets the option tag value to the new supplied <var>optionTag</var>
     * parameter.
     *
     * @param optionTag - the new string value of the option tag.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the optionTag value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.641 -0500", hash_original_method = "DE0D7BEB729218B451469620CB6256C4", hash_generated_method = "2F59206FFB4479E501DDFE703581CF8B")
    
public void setOptionTag(String optionTag) throws ParseException {
        if (optionTag == null)
            throw new NullPointerException("JAIN-SIP Exception, ProxyRequire, setOptionTag(), the optionTag parameter is null");
        this.optionTag = optionTag;
    }

    /**
     * Gets the option tag of this OptionTag class.
     *
     * @return the string that identifies the option tag value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.644 -0500", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "3633D701492785C9119138C7D9BDC157")
    
public String getOptionTag() {
        return optionTag;
    }
}

