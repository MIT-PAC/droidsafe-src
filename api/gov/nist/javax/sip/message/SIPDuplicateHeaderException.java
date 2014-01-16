package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

public class SIPDuplicateHeaderException extends ParseException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.960 -0500", hash_original_field = "0323EB4E0D255756D236E330F2B2BAFB", hash_generated_field = "1CF6B23B11C04227AE0D306881B8A32C")

    private static final long serialVersionUID = 8241107266407879291L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.963 -0500", hash_original_field = "EC37AFF31FBF9EE8C49132F07EB0F32A", hash_generated_field = "DEA203A7A81C763AC07A6499FA517016")

    protected SIPHeader sipHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.966 -0500", hash_original_field = "788242283F58A2359ABCFCC146D1CC65", hash_generated_field = "86237427033BC6809F24E6EB9253E570")

    protected SIPMessage sipMessage;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.968 -0500", hash_original_method = "C7110F542E7C86523593AC1F47E9C6EF", hash_generated_method = "02F33437832C04B777F555761C875C37")
    
public SIPDuplicateHeaderException(String msg) {
        super(msg, 0);
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.971 -0500", hash_original_method = "33B1FEC769A0D2DAFD3ECF3DA486EB50", hash_generated_method = "00AC7631EA1C96FD896CB35A07F89415")
    
public SIPMessage getSIPMessage() {
        return sipMessage;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.973 -0500", hash_original_method = "41260058ED6F5F8ADF876F4D655653A8", hash_generated_method = "E56BBB0A45EFA923F47E5B0ABB0E355A")
    
public SIPHeader getSIPHeader() {
        return sipHeader;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.976 -0500", hash_original_method = "E64CE5D80349BACB9139631838659CEE", hash_generated_method = "7825D615E40148CA41856A8D50F0D453")
    
public void setSIPHeader(SIPHeader sipHeader) {
        this.sipHeader = sipHeader;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:36.979 -0500", hash_original_method = "04933E08E06609AAF868A53B1081ADDB", hash_generated_method = "E0FD9CE4E67129E1E8D4497E616601BC")
    
public void setSIPMessage(SIPMessage sipMessage) {
        this.sipMessage = sipMessage;
    }
}

