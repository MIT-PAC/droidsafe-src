package javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface RecordRouteHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Record-Route";
}
