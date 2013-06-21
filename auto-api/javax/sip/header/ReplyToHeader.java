package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface ReplyToHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Reply-To";

    String getDisplayName();
}
