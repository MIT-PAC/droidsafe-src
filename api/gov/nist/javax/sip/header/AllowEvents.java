package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;






public final class AllowEvents extends SIPHeader implements javax.sip.header.AllowEventsHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.760 -0500", hash_original_field = "E0457E9B6122AB6EB61F0CA98E9F08B0", hash_generated_field = "AC25BA32AE0E1E6630D2239F784D525D")

    private static final long serialVersionUID = 617962431813193114L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.761 -0500", hash_original_field = "1BD057D2E2E93DC292EFB1B66D4C32FA", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;

    /** default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.763 -0500", hash_original_method = "B300CC10915D88E488A895EA20EE2A09", hash_generated_method = "3F78B17A57F39E6EC2308911F306E996")
    public AllowEvents() {
        super(ALLOW_EVENTS);
    }

    /** constructor
     * @param m String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.764 -0500", hash_original_method = "5D2656FB66C7C3040E5BEE12ACA7E341", hash_generated_method = "97E6D15C6AA0160E4B0A42BEC0188179")
    public AllowEvents(String m) {
        super(ALLOW_EVENTS);
        eventType = m;
    }

    /**
     * Sets the eventType defined in this AllowEventsHeader.
     *
     * @param eventType - the String defining the method supported
     * in this AllowEventsHeader
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the Strings defining the eventType supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.765 -0500", hash_original_method = "A10AD710FF1C0BA35C48E4F204BD5CD1", hash_generated_method = "993BB5F3478F63B8DB1FB881816A2F73")
    public void setEventType(String eventType) throws ParseException {
        if (eventType == null)
            throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "AllowEvents, setEventType(), the eventType parameter is null");
        this.eventType = eventType;
    }

    /**
     * Gets the eventType of the AllowEventsHeader.
     *
     * @return the String object identifing the eventTypes of AllowEventsHeader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.767 -0500", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "0EA18A09E98FC5671017BB747A3A08BC")
    public String getEventType() {
        return eventType;
    }

    /** Return body encoded in canonical form.
        * @return body encoded as a string.
        */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:50.768 -0500", hash_original_method = "895FBB9B6BA00626F6F635DDC47F48B7", hash_generated_method = "5A04B31D95F8294D7A375311360DCE87")
    protected String encodeBody() {
        return eventType;
    }
}

