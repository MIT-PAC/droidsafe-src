package javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface ReferToHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Refer-To";
}
