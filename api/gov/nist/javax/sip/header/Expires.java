package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;

public class Expires extends SIPHeader implements javax.sip.header.ExpiresHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.497 -0500", hash_original_field = "7AEDC9BC4CFFED95927680DB7DC3DADB", hash_generated_field = "C1F49009315AF076AF05EE2867D3FDEF")

    private static final long serialVersionUID = 3134344915465784267L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.501 -0500", hash_original_field = "7DE0A8851440A5B5DF3C8E9357224077", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;

    /** default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.506 -0500", hash_original_method = "0542B72E4A4F7744BB9DEA78B33603A7", hash_generated_method = "5594EB26944264DAECACD6792E4A320F")
    
public Expires() {
        super(NAME);
    }

    /**
     * Return canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.511 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.515 -0500", hash_original_method = "D18BC4E3774CF43CFCD5002AEFE6A6EE", hash_generated_method = "FDB2CC22AF9BA8D9AA8F72C6C5DD1A51")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        return buffer.append(expires);
    }

    /**
     * Gets the expires value of the ExpiresHeader. This expires value is
     *
     * relative time.
     *
     *
     *
     * @return the expires value of the ExpiresHeader.
     *
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.520 -0500", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "C2DB0E96C56A45B14BA4BCD03EAE8F48")
    
public int getExpires() {
        return expires;
    }

    /**
     * Sets the relative expires value of the ExpiresHeader.
     * The expires value MUST be greater than zero and MUST be
     * less than 2**31.
     *
     * @param expires - the new expires value of this ExpiresHeader
     *
     * @throws InvalidArgumentException if supplied value is less than zero.
     *
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.525 -0500", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "3F5B19873E25B9DE808B2BB108ADE6E6")
    
public void setExpires(int expires) throws InvalidArgumentException {
        if (expires < 0)
            throw new InvalidArgumentException("bad argument " + expires);
        this.expires = expires;
    }
}

