package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface ReferToHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Refer-To";
}
