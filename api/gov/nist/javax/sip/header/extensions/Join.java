package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.CallIdentifier;
import gov.nist.javax.sip.header.ParameterNames;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

public class Join extends ParametersHeader implements ExtensionHeader, JoinHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.557 -0500", hash_original_field = "E6B96B7B2E8CADE387321F27BACCAA93", hash_generated_field = "6CB5FD5185865CE37770D9CE36F56865")

    private static final long serialVersionUID = -840116548918120056L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.560 -0500", hash_original_field = "CDBFF050B2B67BB7CC5B9089286D87C5", hash_generated_field = "13095D8F107AFC77A4F003D089C600F0")

    public static final String NAME = "Join";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.563 -0500", hash_original_field = "C3E358E95D23A99C47CBD56EDD5BB931", hash_generated_field = "64120D09C2B0721B310316A22E4103F4")

    public CallIdentifier callIdentifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.566 -0500", hash_original_field = "2657C3812CAC2EE2FF30C5C628C0A470", hash_generated_field = "B530B3F06EB2C57DA5D10CD3EC3286F9")

    public String callId;

    /**
     * Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.571 -0500", hash_original_method = "87F4B3791A773FA2D819A20B11BB86DF", hash_generated_method = "44EA0F517AE602FB270366BA1C98296E")
    
public Join() {
        super(NAME);
    }

    /** Constructor given the call Identifier.
     *@param callId string call identifier (should be localid@host)
     *@throws IllegalArgumentException if call identifier is bad.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.574 -0500", hash_original_method = "873C342CB455582A93D9F186CC2FD1CC", hash_generated_method = "6E34DA137FD858BD9DCA6A3EDA6DD1CE")
    
public Join(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
    }

    /**
     * Encode the body part of this header (i.e. leave out the hdrName).
     * @return String encoded body part of the header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.577 -0500", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "F6623F8B06A9D28FCFE1C4FAAFEFBC6B")
    
public String encodeBody() {
        if (callId == null)
            return null;
        else {
            String retVal = callId;
            if (!parameters.isEmpty()) {
                retVal += SEMICOLON + parameters.encode();
            }
            return retVal;
        }
    }

    /**
     * get the CallId field. This does the same thing as encodeBody
     *
     * @return String the encoded body part of the
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.580 -0500", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "EB02B081C7AB467A549CA8E38E41CE27")
    
public String getCallId() {
        return callId;
    }

    /**
     * get the call Identifer member.
     * @return CallIdentifier
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.583 -0500", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "C8B313DEC7DDBD2EFB9A879CEC727321")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.586 -0500", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "8471C18A0AD98C031ABDA3235B75C9D6")
    
public void setCallId(String cid) {
        callId = cid;
    }

    /**
     * Set the callIdentifier member.
     * @param cid CallIdentifier to set (localId@host).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.589 -0500", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "8C57EF6685D66892FD895EA8EE8FA534")
    
public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
    }

    /**
     * Get the to-tag parameter from the address parm list.
     * @return tag field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.592 -0500", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "9B46F74E8C8C30CE21AE359FB62FDCB3")
    
public String getToTag() {
        if (parameters == null)
            return null;
        return getParameter(ParameterNames.TO_TAG);
    }
    /**
     * Set the to-tag member
     * @param t tag to set. From tags are mandatory.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.596 -0500", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "8DE719DBE9EC1F07E605730C5C1B3F28")
    
public void setToTag(String t) throws ParseException {
        if (t == null)
            throw new NullPointerException("null tag ");
        else if (t.trim().equals(""))
            throw new ParseException("bad tag", 0);
        this.setParameter(ParameterNames.TO_TAG, t);
    }
    /** Boolean function
     * @return true if the Tag exist
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.599 -0500", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "CAE9266E5A14EABAAFFFFF8B47C20EF4")
    
public boolean hasToTag() {
        return hasParameter(ParameterNames.TO_TAG);
    }

    /** remove Tag member
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.602 -0500", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "D4FE196EFDC8540DC58A2E6EE0804DA1")
    
public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
    }
    /**
     * Get the from-tag parameter from the address parm list.
     * @return tag field
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.605 -0500", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "413B2174881AB8CE80D6FB02F74DDF67")
    
public String getFromTag() {
        if (parameters == null)
            return null;
        return getParameter(ParameterNames.FROM_TAG);
    }
    /**
     * Set the to-tag member
     * @param t tag to set. From tags are mandatory.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.608 -0500", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "ADF7723D3D721310CAD4F8EE5F6AA9F1")
    
public void setFromTag(String t) throws ParseException {
        if (t == null)
            throw new NullPointerException("null tag ");
        else if (t.trim().equals(""))
            throw new ParseException("bad tag", 0);
        this.setParameter(ParameterNames.FROM_TAG, t);
    }
    /** Boolean function
     * @return true if the Tag exist
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.611 -0500", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "B6B9664ACA374B7893607D0B90FFC14C")
    
public boolean hasFromTag() {
        return hasParameter(ParameterNames.FROM_TAG);
    }

    /** remove Tag member
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.614 -0500", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "1EE47D848BBB7593578BC72C9E94FD3C")
    
public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.617 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "01B37E653FE76FEB916567082AAEE1D8")
    
public void setValue(String value) throws ParseException {
        // not implemented.
        throw new ParseException(value,0);

    }
}

