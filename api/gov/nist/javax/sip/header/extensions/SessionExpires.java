package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;






public final class SessionExpires extends ParametersHeader implements ExtensionHeader, SessionExpiresHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.303 -0500", hash_original_field = "CEB119FCACDF4D481F20CDDF5652D7FC", hash_generated_field = "F2330FF32F2F9FA993B883D22A1E4D56")

    private static final long serialVersionUID = 8765762413224043300L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.308 -0500", hash_original_field = "340EDEBA959DE6DBD975BB1CD62E6D95", hash_generated_field = "440D53375B5C86D3B1C0A993DC1D1A5F")

    public static final String NAME = "Session-Expires";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.314 -0500", hash_original_field = "6E7627EDCB50E34DBA9497D1A292DDEE", hash_generated_field = "D51D2CDCC34D9E34598982CCDA37DCD7")


    public static final String REFRESHER = "refresher";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.310 -0500", hash_original_field = "7DE0A8851440A5B5DF3C8E9357224077", hash_generated_field = "C13B9F005337F50619E5092E1337E1D0")


    public int expires;
    /** default Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.317 -0500", hash_original_method = "A8246024A4BBDCEF318DB7F6B74C4E64", hash_generated_method = "C0E3824F3D5FC3EED24B81C128C28905")
    
public SessionExpires() {
        super(NAME);
    }

    /**
     * Gets the expires value of the SessionExpiresHeader. This expires value is
     * relative time.
     *
     *
     *
     * @return the expires value of the ExpiresHeader.
     *
     * @since JAIN SIP v1.1
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.320 -0500", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "C2DB0E96C56A45B14BA4BCD03EAE8F48")
    
public int getExpires() {
        return expires;
    }

    /**
     * Sets the relative expires value of the SessionExpiresHeader.
     * The expires value MUST be greater than zero and MUST be
     * less than 2**31.
     *
     * @param expires - the new expires value
     *
     * @throws InvalidArgumentException if supplied value is less than zero.
     *
     * @since JAIN SIP v1.1
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.324 -0500", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "3F5B19873E25B9DE808B2BB108ADE6E6")
    
public void setExpires(int expires) throws InvalidArgumentException {
        if (expires < 0)
            throw new InvalidArgumentException("bad argument " + expires);
        this.expires = expires;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.327 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "01B37E653FE76FEB916567082AAEE1D8")
    
public void setValue(String value) throws ParseException {
        // not implemented.
        throw new ParseException(value,0);

    }

    /**
     * Encode the header content into a String.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.330 -0500", hash_original_method = "B1D6BF5FEA5681AEA45EA9D4CACD9FB8", hash_generated_method = "673E4F7B4FF2676DD37E8389FD4B4F4A")
    
protected String encodeBody() {

        String retval = Integer.toString(expires);

        if (!parameters.isEmpty()) {
            retval += SEMICOLON + parameters.encode();
        }
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.333 -0500", hash_original_method = "5E6D9C5D9628C8E8194658511D516C38", hash_generated_method = "BB8DC8EBE538A7A7DEF77BD5D772D77B")
    
public String getRefresher() {
       return parameters.getParameter(REFRESHER);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.336 -0500", hash_original_method = "B765158B109DFF1FFF87124C5A68F884", hash_generated_method = "5CECA0706DCAF95C84A4F5B129D5278D")
    
public void setRefresher(String refresher) {
        this.parameters.set(REFRESHER,refresher);
    }
}

