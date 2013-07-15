package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public interface MediaType {
    String getContentSubType();
    void setContentSubType(String contentSubType) throws ParseException;

    String getContentType();
    void setContentType(String contentType) throws ParseException;
}
