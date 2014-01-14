package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;

public class MinSE extends ParametersHeader implements ExtensionHeader, MinSEHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.425 -0500", hash_original_field = "90F790E32C487DB6ED80B6C9C474A49E", hash_generated_field = "E1530D0326084B5B0CBC7960EB119C5D")

    public static final String NAME = "Min-SE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.428 -0500", hash_original_field = "7AEDC9BC4CFFED95927680DB7DC3DADB", hash_generated_field = "C1F49009315AF076AF05EE2867D3FDEF")

    private static final long serialVersionUID = 3134344915465784267L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.431 -0500", hash_original_field = "7DE0A8851440A5B5DF3C8E9357224077", hash_generated_field = "C13B9F005337F50619E5092E1337E1D0")

    public int expires;

    /** default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.435 -0500", hash_original_method = "FF95F949FD2A1D95680CD0A1163B2941", hash_generated_method = "4172B9FE86B01C0D3EF8B23A8BE967CF")
    
public MinSE() {
        super(NAME);
    }

    /**
     * Return canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.438 -0500", hash_original_method = "B1D6BF5FEA5681AEA45EA9D4CACD9FB8", hash_generated_method = "65DE6943DC8D1CBB326759FF376924A8")
    
public String encodeBody() {
        String retval = Integer.toString(expires); // seems overkill - but Expires did this.

        if (!parameters.isEmpty()) {
            retval += SEMICOLON + parameters.encode();
        }
        return retval;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.441 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "01B37E653FE76FEB916567082AAEE1D8")
    
public void setValue(String value) throws ParseException {
        // not implemented.
        throw new ParseException(value,0);

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
     * @since JAIN SIP v1.1
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.444 -0500", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "C2DB0E96C56A45B14BA4BCD03EAE8F48")
    
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
     * @since JAIN SIP v1.2
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.448 -0500", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "3F5B19873E25B9DE808B2BB108ADE6E6")
    
public void setExpires(int expires) throws InvalidArgumentException {
        if (expires < 0)
            throw new InvalidArgumentException("bad argument " + expires);
        this.expires = expires;
    }
}

