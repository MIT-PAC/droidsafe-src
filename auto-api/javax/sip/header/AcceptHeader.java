package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public interface AcceptHeader extends Header, MediaType, Parameters {
    String NAME = "Accept";

    boolean allowsAllContentSubTypes();
    boolean allowsAllContentTypes();

    float getQValue();
    void setQValue(float qValue) throws InvalidArgumentException;
    boolean hasQValue();
    void removeQValue();
}
