package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.Header;
import javax.sip.header.HeaderAddress;

public interface PProfileKeyHeader extends HeaderAddress, Header{

    public final static String NAME = "P-Profile-Key";

}
