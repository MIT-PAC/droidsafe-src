package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public interface ToHeader extends HeaderAddress, Header, Parameters {
    String NAME = "To";

    String getTag();
    void setTag(String tag) throws ParseException;
    boolean hasTag();
    void removeTag();

    String getDisplayName();
    String getUserAtHostPort();
}
