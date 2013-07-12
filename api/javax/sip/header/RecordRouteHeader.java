package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface RecordRouteHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Record-Route";
}
