package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.EventHeader;

public class Event extends ParametersHeader implements EventHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.852 -0500", hash_original_field = "36F7AB18CF9D759821771C54779BA5E9", hash_generated_field = "63F6460E52154D5BD98308ED4780F1F5")

    private static final long serialVersionUID = -6458387810431874841L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.857 -0500", hash_original_field = "1BD057D2E2E93DC292EFB1B66D4C32FA", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;

    /**
     * Creates a new instance of Event
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.862 -0500", hash_original_method = "4CF8CB38A5AC53FB99D6035A88D058D2", hash_generated_method = "B69A43EE6162F9A2F92FB3768A16E282")
    
public Event() {
        super(EVENT);
    }

    /**
    * Sets the eventType to the newly supplied eventType string.
    *
    * @param eventType - the  new string defining the eventType supported
    * in this EventHeader
    * @throws ParseException which signals that an error has been reached
    * unexpectedly while parsing the eventType value.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.867 -0500", hash_original_method = "BF3A0863A1B04A86A1E3BEB9A70A1FC1", hash_generated_method = "9C62B624F6EB6472253DFE0BB9209493")
    
public void setEventType(String eventType) throws ParseException {
        if (eventType == null)
            throw new NullPointerException(" the eventType is null");
        this.eventType = eventType;
    }

    /**
     * Gets the eventType of the EventHeader.
     *
     * @return the string object identifing the eventType of EventHeader.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.871 -0500", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "0EA18A09E98FC5671017BB747A3A08BC")
    
public String getEventType() {
        return eventType;
    }

    /**
     * Sets the id to the newly supplied <var>eventId</var> string.
     *
     * @param eventId - the new string defining the eventId of this EventHeader
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the eventId value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.876 -0500", hash_original_method = "4973DD9F7CE5F7FF3C7544616AFD9DF0", hash_generated_method = "85005A61E68972AB85960F4D176DA017")
    
public void setEventId(String eventId) throws ParseException {
        if (eventId == null)
            throw new NullPointerException(" the eventId parameter is null");
        setParameter(ParameterNames.ID, eventId);
    }

    /**
     * Gets the id of the EventHeader. This method may return null if the
     * "eventId" is not set.
     * @return the string object identifing the eventId of EventHeader.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.881 -0500", hash_original_method = "19BA40738893C0C7644CB14978576CB8", hash_generated_method = "15EB387290D0A8B14FD17B7B631A33F1")
    
public String getEventId() {
        return getParameter(ParameterNames.ID);
    }

    /**
     * Encode in canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.885 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.889 -0500", hash_original_method = "0038FEB21AC4FB99162300562E578118", hash_generated_method = "6607B41DBC6A0BA69D6456E42348E8DD")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        if (eventType != null)
            buffer.append(eventType);

        if (!parameters.isEmpty()) {
            buffer.append(SEMICOLON);
            this.parameters.encode(buffer);
        }
        return buffer;
    }

    /**
     *  Return true if the given event header matches the supplied one.
     *
     * @param matchTarget -- event header to match against.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.894 -0500", hash_original_method = "597DA81ECE5B3A826C9242118BC9B66A", hash_generated_method = "DF60004764989C0E51379AF5C59BB06F")
    
public boolean match(Event matchTarget) {
        if (matchTarget.eventType == null && this.eventType != null)
            return false;
        else if (matchTarget.eventType != null && this.eventType == null)
            return false;
        else if (this.eventType == null && matchTarget.eventType == null)
            return false;
        else if (getEventId() == null && matchTarget.getEventId() != null)
            return false;
        else if (getEventId() != null && matchTarget.getEventId() == null)
            return false;
        return matchTarget.eventType.equalsIgnoreCase(this.eventType)
            && ((this.getEventId() == matchTarget.getEventId())
                || this.getEventId().equalsIgnoreCase(matchTarget.getEventId()));
    }
}

