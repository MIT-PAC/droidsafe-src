package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public interface ContentTypeHeader extends Header, MediaType, Parameters {
    String NAME = "Content-Type";

    String getCharset();
    void setContentType(String contentType, String contentSubType)
            throws ParseException;
}
