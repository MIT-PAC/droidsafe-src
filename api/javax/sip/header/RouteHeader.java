package javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface RouteHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Route";
}
