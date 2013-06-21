package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public interface AllowHeader extends Header {
    String NAME = "Allow";

    String getMethod();
    void setMethod(String method) throws ParseException;
}
