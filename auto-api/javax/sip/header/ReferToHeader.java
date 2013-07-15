package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface ReferToHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Refer-To";
}
