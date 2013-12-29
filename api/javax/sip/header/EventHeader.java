package javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

public interface EventHeader extends Header, Parameters {
    String NAME = "Event";

    String getEventId();
    void setEventId(String eventId) throws ParseException;

    String getEventType();
    void setEventType(String eventType) throws ParseException;
}
