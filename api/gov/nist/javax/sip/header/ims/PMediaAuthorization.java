package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;

public class PMediaAuthorization extends SIPHeader implements PMediaAuthorizationHeader, SIPHeaderNamesIms, ExtensionHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.477 -0500", hash_original_field = "43CA5A3D590A5DF8FAFBBD5DCA9D0320", hash_generated_field = "C8D1FC4D9437199DDCE4D93F76EFB759")

    private static final long serialVersionUID = -6463630258703731133L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.481 -0500", hash_original_field = "D62A227FC11FEBF54000A08B450667DF", hash_generated_field = "630027C1E843254DD22AA3F89157CD43")

    private String token;

    /**
     * Constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.485 -0500", hash_original_method = "33816D631C77F21B21E54BBEFDA2795C", hash_generated_method = "0EC23627570F35559E8563A7FA0CCD73")
    
public PMediaAuthorization()
    {
        super(P_MEDIA_AUTHORIZATION);
    }

    /**
     * Get the media authorization token.
     *
     * @return token
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.489 -0500", hash_original_method = "F23C2C2B4085CBC596D4F9DFFD38C718", hash_generated_method = "438276A336E04D9381C3BC15180EBF44")
    
public String getToken()
    {
        return token;
    }

    /**
     * Set the media authorization token.
     *
     * @param token - media authorization token to set
     * @throws InvalidArgumentException - if token is null or empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.492 -0500", hash_original_method = "0F12B8FB487852A4D61415942AC9447A", hash_generated_method = "275144988FF7DFDBD2C1E84E5D950272")
    
public void setMediaAuthorizationToken(String token) throws InvalidArgumentException
    {
        if (token == null || token.length() == 0)
            throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");

        this.token = token;
    }

    /**
     * Encode header
     * @return the header content
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.496 -0500", hash_original_method = "724D317C37CE304AAB82EB39D5595B30", hash_generated_method = "8D6F8EEEF695A8E783AE8E4AF6ECFFF7")
    
protected String encodeBody()
    {
        return token;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.499 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException (value,0);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.503 -0500", hash_original_method = "5CA94E0EC768C322B947B50479A5582B", hash_generated_method = "EEF2157BE89A4D7754C29C6E8430EA4A")
    
public boolean equals(Object other)
    {
        if (other instanceof PMediaAuthorizationHeader)
        {
            final PMediaAuthorizationHeader o = (PMediaAuthorizationHeader) other;
            return this.getToken().equals(o.getToken());
        }
        return false;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.506 -0500", hash_original_method = "8A557E19577FD47CE8C49FDC6C46D11C", hash_generated_method = "13CC34B5541E09E525D4D041AA7E9180")
    
public Object clone() {
        PMediaAuthorization retval = (PMediaAuthorization) super.clone();
        if (this.token != null)
            retval.token = this.token;
        return retval;
    }
}

