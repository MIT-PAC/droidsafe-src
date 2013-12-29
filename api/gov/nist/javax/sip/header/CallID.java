package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.CallIdHeader;






public class CallID extends SIPHeader implements javax.sip.header.CallIdHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.500 -0500", hash_original_field = "BBF05D189D1F032E78C83ACEFDCFF095", hash_generated_field = "BD88EAFB9547FBFAAD4836DB7C0DFC77")

    private static final long serialVersionUID = -6463630258703731156L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.501 -0500", hash_original_field = "C3E358E95D23A99C47CBD56EDD5BB931", hash_generated_field = "8FC7908A513558296E298532350EE885")

    protected CallIdentifier callIdentifier;

    /**
     * Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.503 -0500", hash_original_method = "253D83F9785581049F0DE9229A1A9A12", hash_generated_method = "978E2112F7179924505FE3D3DE4CD1D1")
    public CallID() {
        super(NAME);
    }

    /** Constructor given the call Identifier.
     *@param callId string call identifier (should be localid@host)
     *@throws IllegalArgumentException if call identifier is bad.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.516 -0500", hash_original_method = "931206B362DAA8816F4CAAC363313ED6", hash_generated_method = "4B3EE4E7881127C7066351763919FE37")
    public CallID(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     *
     * CallIDs are compared case-insensitively
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.505 -0500", hash_original_method = "90F237F3A3B37E6D3BD3A71F3DAA1462", hash_generated_method = "B846D960AFE8184FB667FC98070AC245")
    public boolean equals( Object other ) {

        if (this==other) return true;

        if (other instanceof CallIdHeader) {
            final CallIdHeader o = (CallIdHeader) other;
            return this.getCallId().equalsIgnoreCase( o.getCallId() );
        }
        return false;
    }


    /**
     * Encode the body part of this header (i.e. leave out the hdrName).
     *@return String encoded body part of the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.506 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.508 -0500", hash_original_method = "FA90F4B44CEDD454BFF7BD5B8D6838EA", hash_generated_method = "9FCC92F43282799BCEC86451311EC048")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        if (callIdentifier != null)
            callIdentifier.encode(buffer);

        return buffer;
    }

    /**
     * get the CallId field. This does the same thing as
     * encodeBody
     * @return String the encoded body part of the
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.509 -0500", hash_original_method = "E18AC147BDD8255E722D716AAB46B0FD", hash_generated_method = "4E663843DA892E10C352B3ED8EA40396")
    public String getCallId() {
        return encodeBody();
    }

    /**
     * get the call Identifer member.
     * @return CallIdentifier
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.511 -0500", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "C8B313DEC7DDBD2EFB9A879CEC727321")
    public CallIdentifier getCallIdentifer() {
        return callIdentifier;
    }

    /**
     * set the CallId field
     * @param cid String to set. This is the body part of the Call-Id
     *  header. It must have the form localId@host or localId.
     * @throws IllegalArgumentException if cid is null, not a token, or is
     * not a token@token.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.512 -0500", hash_original_method = "CCC70F9489E78808F4B3E55A9B08CA23", hash_generated_method = "918E8B46AA64E38E035BD3C33D2AE941")
    public void setCallId(String cid) throws ParseException {
        try {
            callIdentifier = new CallIdentifier(cid);
        } catch (IllegalArgumentException ex) {
            throw new ParseException(cid, 0);
        }
    }

    /**
     * Set the callIdentifier member.
     * @param cid CallIdentifier to set (localId@host).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.514 -0500", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "8C57EF6685D66892FD895EA8EE8FA534")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.517 -0500", hash_original_method = "6EEF27DF9C05DE559BD56269DDD0A6F4", hash_generated_method = "13F8CA078061623A0A9E1921D4E02B58")
    public Object clone() {
        CallID retval = (CallID) super.clone();
        if (this.callIdentifier != null)
            retval.callIdentifier = (CallIdentifier) this.callIdentifier.clone();
        return retval;
    }
}

