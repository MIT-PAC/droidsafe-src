package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public interface SIPETagHeader extends ExtensionHeader {
    String NAME = "SIP-ETag";

    String getETag();
    void setETag(String etag) throws ParseException;
}
