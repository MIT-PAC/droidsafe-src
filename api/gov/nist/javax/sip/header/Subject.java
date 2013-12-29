package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.SubjectHeader;






public class Subject extends SIPHeader implements SubjectHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.828 -0500", hash_original_field = "94F423F3F6978A186151BAB9F3081E9D", hash_generated_field = "5A108BF1E2A98855AB05AF0A50CEDCDE")

    private static final long serialVersionUID = -6479220126758862528L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.829 -0500", hash_original_field = "05CF6DC5327609584327D4E74FDB9847", hash_generated_field = "FCF19B41C65ED3C233A6175A0183A3FB")

    protected String subject;

    /** Default Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.830 -0500", hash_original_method = "D63809B6DE8F5F47E85D84EB99E1AE5D", hash_generated_method = "15598A1FA38378CE2423367C317B39C1")
    public Subject() {
        super(SUBJECT);
    }

    /**
     * Generate the canonical form.
     * @return String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.831 -0500", hash_original_method = "3C6B7893125DF6EE8816C7C8DB5CA48D", hash_generated_method = "A1685D2E0097A430B598469A18E15C02")
    public String encodeBody() {
        if (subject != null) {
            return subject;
        } else {
            return "";
        }
    }

    /**
     * Sets the subject value of the SubjectHeader to the supplied string
     * subject value.
     *
     * @param subject - the new subject value of this header
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the subject value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.832 -0500", hash_original_method = "6F21748266641C905516C66889D7570C", hash_generated_method = "FE4249006EE752EF49B6DA890BC8F9B0")
    public void setSubject(String subject) throws ParseException {
        if (subject == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Subject, setSubject(), the subject parameter is null");
        this.subject = subject;
    }

    /**
     * Gets the subject value of SubjectHeader
     *
     * @return subject of SubjectHeader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.833 -0500", hash_original_method = "8EBD535E211A75BE78AF45361DF5913D", hash_generated_method = "8FE22A6343735A7D9BA6760DEE36A03C")
    public String getSubject() {
        return subject;
    }
}

