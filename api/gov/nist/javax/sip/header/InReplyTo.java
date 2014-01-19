package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.InReplyToHeader;

public class InReplyTo extends SIPHeader implements InReplyToHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.019 -0500", hash_original_field = "AFF195C241CC5D9225281404651EAF7E", hash_generated_field = "62113CBAA9CAEBCC0941329C8D032899")

    private static final long serialVersionUID = 1682602905733508890L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.022 -0500", hash_original_field = "7C5A227E6B12204579E17E8F0B16DA14", hash_generated_field = "F2A7BDC27E688B3BD5C6A8CB27C2DD56")

    protected CallIdentifier callId;

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.026 -0500", hash_original_method = "561B527F5C5623362D2C0AB5E9627468", hash_generated_method = "0D2F2FAA86EA541868D67EC13712D252")
    
public InReplyTo() {
        super(IN_REPLY_TO);
    }

    /** constructor
     * @param cid CallIdentifier to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.029 -0500", hash_original_method = "92FFE21441DA37C601278DB74C30EBCA", hash_generated_method = "D30072DEC5F5EE465A02624F296EC24E")
    
public InReplyTo(CallIdentifier cid) {
        super(IN_REPLY_TO);
        callId = cid;
    }

    /**
     * Sets the Call-Id of the InReplyToHeader. The CallId parameter uniquely
     * identifies a serious of messages within a dialogue.
     *
     * @param callId - the string value of the Call-Id of this InReplyToHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the callId value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.032 -0500", hash_original_method = "AFE760D92C6B99B9817A49FA1C34A82C", hash_generated_method = "9D8FE62A016C73753A52899DB31A0D65")
    
public void setCallId(String callId) throws ParseException {
        try {
            this.callId = new CallIdentifier(callId);
        } catch (Exception e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    /**
     * Returns the Call-Id of InReplyToHeader. The CallId parameter uniquely
     * identifies a series of messages within a dialogue.
     *
     * @return the String value of the Call-Id of this InReplyToHeader
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.035 -0500", hash_original_method = "EA32F9E304DDFDAAFD9F10122A085C03", hash_generated_method = "A952B60519D5B869F2A62588038F424D")
    
public String getCallId() {
        if (callId == null)
            return null;
        return callId.encode();
    }

    /**
         * Generate canonical form of the header.
         * @return String
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.037 -0500", hash_original_method = "64901279DBD4FD22B1D7FC340D43545B", hash_generated_method = "2E0993C1A54FED366A83F6457E46B83A")
    
public String encodeBody() {
        return callId.encode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.040 -0500", hash_original_method = "AACC864B78324D30A82E58DDECBB4AB7", hash_generated_method = "0E509C6DC96842CC80268F9E3A3514AD")
    
public Object clone() {
        InReplyTo retval = (InReplyTo) super.clone();
        if (this.callId != null)
            retval.callId = (CallIdentifier) this.callId.clone();
        return retval;
    }
}

