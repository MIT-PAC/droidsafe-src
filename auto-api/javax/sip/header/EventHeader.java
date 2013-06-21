package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public interface EventHeader extends Header, Parameters {
    String NAME = "Event";

    String getEventId();
    void setEventId(String eventId) throws ParseException;

    String getEventType();
    void setEventType(String eventType) throws ParseException;
}
