package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;

import java.text.ParseException;

import javax.sip.address.URI;

public final class AlertInfo extends ParametersHeader implements javax.sip.header.AlertInfoHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.653 -0500", hash_original_field = "1F6F5F8CFA970F2BE3A0A49C9F0A19C2", hash_generated_field = "837DE0F76A5BA789D54E73518AECF665")

    private static final long serialVersionUID = 4159657362051508719L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.656 -0500", hash_original_field = "301DE89A58C4FF637054844336681A92", hash_generated_field = "D17BDF81091C1074F22AD5D363A1EFEF")

    protected GenericURI uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.658 -0500", hash_original_field = "38EA5C212184AA9651934368805B840B", hash_generated_field = "0515D9B755A4065CCD98BBCCA2A45812")

    protected String string;

    /** Constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.661 -0500", hash_original_method = "573DE3A32F61321788993C5785A09259", hash_generated_method = "05A7F92A5AB73275159FE69FD9E5483B")
    
public AlertInfo() {
        super(NAME);
    }

    /**
     * Return value encoding in canonical form.
     * @return The value of the header in canonical encoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.664 -0500", hash_original_method = "9B65437FA923D12CE9D4363AF11C8369", hash_generated_method = "36C0011C3F6F96837C4E739DA193138A")
    
protected String encodeBody() {
        StringBuffer encoding = new StringBuffer();
        if (uri != null) {
            encoding.append(LESS_THAN).append(uri.encode()).append(GREATER_THAN);
        } else if (string != null) {
            encoding.append(string);
        }
        if (!parameters.isEmpty()) {
            encoding.append(SEMICOLON).append(parameters.encode());
        }
        return encoding.toString();
    }

    /**
     * Set the uri member
     * @param uri URI to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.668 -0500", hash_original_method = "9100B3E97C317A9574634DF51E7BF148", hash_generated_method = "D3796A99E50AFFB90EE2F19BC2689C74")
    
public void setAlertInfo(URI uri) {
        this.uri = (GenericURI) uri;
    }

    /**
     * Set the string member
     * @param string String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.671 -0500", hash_original_method = "70582DF127DE5708E4C226DA4F1719D4", hash_generated_method = "4E7C6F6E6E0E6D95722E08A5BD841A0D")
    
public void setAlertInfo(String string) {
        this.string = string;
    }

    /**
     * Returns the AlertInfo value of this AlertInfoHeader.
     * @return the URI representing the AlertInfo.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.674 -0500", hash_original_method = "93EE3BCFF83F692256BB0B6CBD3B0531", hash_generated_method = "86B2B9C9E6BD7076302C64C37D62828F")
    
public URI getAlertInfo() {
        URI alertInfoUri = null;

        if (this.uri != null) {
            alertInfoUri = (URI) this.uri;
        } else {
            try {
                alertInfoUri = (URI) new GenericURI(string);
            } catch (ParseException e) {
                ;  // Eat the exception.
            }
        }

        return alertInfoUri;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.677 -0500", hash_original_method = "1467211F1910FD2BE16563F269CB9AF0", hash_generated_method = "4EF7F7ED3C3686C4A2C99E6B354F282C")
    
public Object clone() {
        AlertInfo retval = (AlertInfo) super.clone();
        if (this.uri != null) {
            retval.uri = (GenericURI) this.uri.clone();
        } else if (this.string != null) {
            retval.string = this.string;
        }
        return retval;
    }
}

