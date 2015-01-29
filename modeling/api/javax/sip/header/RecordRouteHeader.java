package javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface RecordRouteHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Record-Route";
}
