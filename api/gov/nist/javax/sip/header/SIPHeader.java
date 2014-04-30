package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class SIPHeader extends SIPObject implements SIPHeaderNames, javax.sip.header.Header, HeaderExt {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.599 -0500", hash_original_field = "BD66DD28721A718F4DADB56502A74024", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;

    /** Value of the header.
    */

    /** Constructor
     * @param hname String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.602 -0500", hash_original_method = "FE673D693BAC70694CA41EF39D92900D", hash_generated_method = "EF32D01F9A2196EDCD78C3F3646D4BF5")
    
protected SIPHeader(String hname) {
        headerName = hname;
    }

    /** Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.605 -0500", hash_original_method = "1EA533F6110BBCB8F937FFE2E4A5C224", hash_generated_method = "559A2A19463DD7B6887E75F28598268E")
    
public SIPHeader() {
    }

    /**
     * Name of the SIPHeader
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.608 -0500", hash_original_method = "62BB7D98AC3AE2D1B44BF4A9C83BFCEA", hash_generated_method = "8D7B8212F3DDA267E3A24EF98F5AC7A2")
    
public String getHeaderName() {
        return headerName;
    }

    /** Alias for getHaderName above.
    *
    *@return String headerName
    *
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.611 -0500", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "F3F8F203B82F62163ACC77D3355FEA39")
    
public String getName() {
        return this.headerName;
    }

    /**
         * Set the name of the header .
         * @param hdrname String to set
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.614 -0500", hash_original_method = "B4EB4BB0337C6A7359D4335CEE5552C5", hash_generated_method = "5E07DF2C68BF0EDDFF371214128D2B66")
    
public void setHeaderName(String hdrname) {
        headerName = hdrname;
    }

    /** Get the header value (i.e. what follows the name:).
    * This merely goes through and lops off the portion that follows
    * the headerName:
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.618 -0500", hash_original_method = "4978FCECCFF9CE458180DF94EDCE0642", hash_generated_method = "FCB193E0683631BB976684F1A86447F1")
    
public String getHeaderValue() {
        String encodedHdr = null;
        try {
            encodedHdr = this.encode();
        } catch (Exception ex) {
            return null;
        }
        StringBuffer buffer = new StringBuffer(encodedHdr);
        while (buffer.length() > 0 && buffer.charAt(0) != ':') {
            buffer.deleteCharAt(0);
        }
        if (buffer.length() > 0)
            buffer.deleteCharAt(0);
        return buffer.toString().trim();
    }

    /** Return false if this is not a header list
    * (SIPHeaderList overrrides this method).
    *@return false
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.622 -0500", hash_original_method = "1CB55F4681FA88A1D00C1CC7A8265E42", hash_generated_method = "698A31F3F4CCD6B850F585DE39620084")
    
public boolean isHeaderList() {
        return false;
    }

    /** Encode this header into canonical form.
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.625 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.628 -0500", hash_original_method = "D602371A78852934DC2C93C46C0FD81D", hash_generated_method = "33AE2F2ABAB3936D183AC9F429E12959")
    
public StringBuffer encode(StringBuffer buffer) {
        buffer.append(this.headerName).append(COLON).append(SP);
        this.encodeBody(buffer);
        buffer.append(NEWLINE);
        return buffer;
    }

    /** Encode the body of this header (the stuff that follows headerName).
    * A.K.A headerValue.
    */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.631 -0500", hash_original_method = "174EBB1808D17B56AB5E004277B62194", hash_generated_method = "67C6A1D41F49045B75F8C639C65C4404")
    
protected abstract String encodeBody();

    /** Encode the body of this header in the given buffer.
     * Default implementation calls encodeBody();
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.634 -0500", hash_original_method = "112FD4376D79389C2460FE6A980E7021", hash_generated_method = "C2FBC8B466424D6A5EC6C31025CEB4A3")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        return buffer.append(encodeBody());
    }

    /** Alias for getHeaderValue.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.637 -0500", hash_original_method = "B7F53CD18FD7F00B77483EF4A0589C59", hash_generated_method = "FE4CCB69A52E6D45457CE3913B02387C")
    
public String getValue() {
        return this.getHeaderValue();
    }

    /**
     * This is a pretty simple hashCode but satisfies requirements.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.640 -0500", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "684C0BABDAF236671E858A8C4C737032")
    
public int hashCode() {
        return this.headerName.hashCode();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.643 -0500", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "EF12A656DE467EE951401443200E525A")
    
public final String toString() {
        return this.encode();
    }
    
}

