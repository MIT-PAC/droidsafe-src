package javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

public interface AllowEventsHeader extends Header {
    String NAME = "Allow-Events";

    String getEventType();
    void setEventType(String eventType) throws ParseException;
}
