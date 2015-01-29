package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.SupportedHeader;

public class SupportedList extends SIPHeaderList<Supported> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.326 -0500", hash_original_field = "60F99A78E5B2FF695A67313219F4D128", hash_generated_field = "C52F2E011560C6C75D9803CFE79F0EF9")

    private static final long serialVersionUID = -4539299544895602367L;

    /** Default Constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.332 -0500", hash_original_method = "C97E7EF6FC87A3A068AC23349CE0B329", hash_generated_method = "449CCB7BBAB41719FEBF68A37CC4F1F1")
    
public SupportedList() {
        super(Supported.class, SupportedHeader.NAME);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.329 -0500", hash_original_method = "45CDCD8BD327539AF66457D00250AD24", hash_generated_method = "C3200F0BDF449E1CE6CD60D79D684063")
    
public Object clone() {
        SupportedList retval = new SupportedList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

