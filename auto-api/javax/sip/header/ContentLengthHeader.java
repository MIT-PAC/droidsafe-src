package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public interface ContentLengthHeader extends Header {
    String NAME = "Content-Length";

    int getContentLength();
    void setContentLength(int contentLength) throws InvalidArgumentException;
}
