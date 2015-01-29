package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.SubscriptionStateHeader;

public class SubscriptionState extends ParametersHeader implements SubscriptionStateHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.891 -0500", hash_original_field = "FC6F73D4FCCE146C2D665D958140F476", hash_generated_field = "144874CA1FE0DC42636F7A1FA58F02E8")

    private static final long serialVersionUID = -6673833053927258745L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.894 -0500", hash_original_field = "7DE0A8851440A5B5DF3C8E9357224077", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.897 -0500", hash_original_field = "D8F5B56D50AED74E4DA7FAD8D8709B7B", hash_generated_field = "BD8E0AD83785DE0B9BF49A5DC728A1DF")

    protected int retryAfter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.900 -0500", hash_original_field = "5BCA0DFB9BCF9A03E2888C74EE9C7E51", hash_generated_field = "C30D27B07549FD0A64778D166C0E4BE6")

    protected String reasonCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.903 -0500", hash_original_field = "F2D6F101C8039513205723AC944011E6", hash_generated_field = "A196649679D02C3121333ABA58C9AA8D")

    protected String state;

    /** Creates a new instance of SubscriptionState */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.906 -0500", hash_original_method = "2AE8767260EE49A022E5D260FFA8A02D", hash_generated_method = "BCB85E6C5BD5F2DE055E2E90D28EE64A")
    
public SubscriptionState() {
        super(SIPHeaderNames.SUBSCRIPTION_STATE);
        expires = -1;
        retryAfter = -1;
    }

    /**
    * Sets the relative expires value of the SubscriptionStateHeader. The
    * expires value MUST be greater than zero and MUST be less than 2**31.
    *
    * @param expires - the new expires value of this SubscriptionStateHeader.
    * @throws InvalidArgumentException if supplied value is less than zero.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.909 -0500", hash_original_method = "7314EC394325F26B79C36E58D3FDBB1D", hash_generated_method = "EED02870BB9793253701518B78E6108B")
    
public void setExpires(int expires) throws InvalidArgumentException {
        if (expires < 0)
            throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setExpires(), the expires parameter is  < 0");
        this.expires = expires;
    }

    /**
     * Gets the expires value of the SubscriptionStateHeader. This expires value is
     * relative time.
     *
     * @return the expires value of the SubscriptionStateHeader.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.912 -0500", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "C2DB0E96C56A45B14BA4BCD03EAE8F48")
    
public int getExpires() {
        return expires;
    }

    /**
     * Sets the retry after value of the SubscriptionStateHeader. The retry after value
     * MUST be greater than zero and MUST be less than 2**31.
     *
     * @param retryAfter - the new retry after value of this SubscriptionStateHeader
     * @throws InvalidArgumentException if supplied value is less than zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.915 -0500", hash_original_method = "50CA09FDB5676EA1DD99646C83E4C5FC", hash_generated_method = "AEC4C51661C224EE3E1D559E250D8BC2")
    
public void setRetryAfter(int retryAfter) throws InvalidArgumentException {
        if (retryAfter <= 0)
            throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setRetryAfter(), the retryAfter parameter is <=0");
        this.retryAfter = retryAfter;
    }

    /**
     * Gets the retry after value of the SubscriptionStateHeader. This retry after
     * value is relative time.
     *
     * @return the retry after value of the SubscriptionStateHeader.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.918 -0500", hash_original_method = "8B40198517FC200CD43F6E0235CB55DB", hash_generated_method = "97B3E052FF156B2FAC86954C12C54635")
    
public int getRetryAfter() {
        return retryAfter;
    }

    /**
     * Gets the reason code of SubscriptionStateHeader.
     *
     * @return the comment of this SubscriptionStateHeader, return null if no reason code
     * is available.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.920 -0500", hash_original_method = "307A7F7469164C10B67FE98D6B3BB448", hash_generated_method = "9FDDDDDB1BCB6B405B64EFFCB7D3083A")
    
public String getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the reason code value of the SubscriptionStateHeader.
     *
     * @param reasonCode - the new reason code string value of the SubscriptionStateHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the reason code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.924 -0500", hash_original_method = "F3FEA6AFF4A02AB2AF0C89DB66C639D9", hash_generated_method = "5E37D2317153742CD396CA5C34A9A48E")
    
public void setReasonCode(String reasonCode) throws ParseException {
        if (reasonCode == null)
            throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setReasonCode(), the reasonCode parameter is null");
        this.reasonCode = reasonCode;
    }

    /**
     * Gets the state of SubscriptionStateHeader.
     *
     * @return the state of this SubscriptionStateHeader.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.927 -0500", hash_original_method = "B507B0FDA436CA05802CD34EFC971C76", hash_generated_method = "06A5D9D137B27B4E68453D4FAD90CDBF")
    
public String getState() {
        return state;
    }

    /**
     * Sets the state value of the SubscriptionStateHeader.
     *
     * @param state - the new state string value of the SubscriptionStateHeader.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.929 -0500", hash_original_method = "26B14BBE6685B3C70475DE487DDF5C68", hash_generated_method = "380F6919ED2A722BB3458FA0C479D899")
    
public void setState(String state) throws ParseException {
        if (state == null)
            throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setState(), the state parameter is null");
        this.state = state;
    }

    /** Just the encoded body of the header.
     * @return the string encoded header body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.932 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.935 -0500", hash_original_method = "612E9F6C82A7EBFF3AE59409AADEC810", hash_generated_method = "203EAA6F17077A624A3E2423E7110FDD")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        if (state != null)
            buffer.append(state);
        if (reasonCode != null)
            buffer.append(";reason=").append(reasonCode);
        if (expires != -1)
            buffer.append(";expires=").append(expires);
        if (retryAfter != -1)
            buffer.append(";retry-after=").append(retryAfter);

        if (!parameters.isEmpty()) {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        }
        return buffer;
    }
}

