package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public interface MimeVersionHeader extends Header {
    String NAME = "MIME-Version";

    int getMajorVersion();
    void setMajorVersion(int majorVersion) throws InvalidArgumentException;

    int getMinorVersion();
    void setMinorVersion(int minorVersion) throws InvalidArgumentException;
}
