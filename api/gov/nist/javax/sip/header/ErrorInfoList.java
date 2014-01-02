package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ErrorInfoHeader;






public class ErrorInfoList extends SIPHeaderList<ErrorInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.195 -0500", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.204 -0500", hash_original_method = "BE8380000E3CB2DA0A370B790F9454ED", hash_generated_method = "3D4DC9EEAD92566346F6E429E5110470")
    
public ErrorInfoList() {
        super(ErrorInfo.class, ErrorInfoHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:53.199 -0500", hash_original_method = "DEBEF33CFB4944E55BD5A9FB315B228C", hash_generated_method = "FF06FB136A220D2966F87D546FDCCD26")
    
public Object clone() {
        ErrorInfoList retval = new ErrorInfoList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

