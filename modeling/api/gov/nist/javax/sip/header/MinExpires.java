package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.MinExpiresHeader;

public class MinExpires extends SIPHeader implements MinExpiresHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.322 -0500", hash_original_field = "8056CF48D84797B73842BAD69BACFA04", hash_generated_field = "54DFFD072C6FF45C93B222EE008E242A")

    private static final long serialVersionUID = 7001828209606095801L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.329 -0500", hash_original_field = "7DE0A8851440A5B5DF3C8E9357224077", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;

    /** default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.337 -0500", hash_original_method = "E220E899B716906991999B2A4C081552", hash_generated_method = "5E2FB99412D48084AF18A0C77A12C1BC")
    
public MinExpires() {
        super(NAME);
    }

    /**
     * Return canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.342 -0500", hash_original_method = "D42EEF06048E7D77F00EA781D2005D33", hash_generated_method = "343763C1113C4F113A0A68A2E7C4805B")
    
public String encodeBody() {
        return Integer.toString(expires);
    }

    /**
     * Gets the expires value of the ExpiresHeader. This expires value is
     * relative time.
     *
     * @return the expires value of the ExpiresHeader.
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.348 -0500", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "C2DB0E96C56A45B14BA4BCD03EAE8F48")
    
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
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.356 -0500", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "3F5B19873E25B9DE808B2BB108ADE6E6")
    
public void setExpires(int expires) throws InvalidArgumentException {
        if (expires < 0)
            throw new InvalidArgumentException("bad argument " + expires);
        this.expires = expires;
    }
}

