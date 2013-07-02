package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface ReplyToHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Reply-To";

    String getDisplayName();
}
