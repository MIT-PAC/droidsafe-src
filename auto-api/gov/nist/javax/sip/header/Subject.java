package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class Subject extends SIPHeader implements SubjectHeader {
    protected String subject;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.421 -0400", hash_original_method = "D63809B6DE8F5F47E85D84EB99E1AE5D", hash_generated_method = "FC1BF9AC217CC58F50D5E1F25B779F09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Subject() {
        super(SUBJECT);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.421 -0400", hash_original_method = "3C6B7893125DF6EE8816C7C8DB5CA48D", hash_generated_method = "747BE100CFE44272CB16AB2651E501F3")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (subject != null) {
            //return subject;
        //} else {
            //return "";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.421 -0400", hash_original_method = "6F21748266641C905516C66889D7570C", hash_generated_method = "4A621134026FF87FAF8BE08F838C10F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSubject(String subject) throws ParseException {
        dsTaint.addTaint(subject);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Subject, setSubject(), the subject parameter is null");
        // ---------- Original Method ----------
        //if (subject == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " Subject, setSubject(), the subject parameter is null");
        //this.subject = subject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.421 -0400", hash_original_method = "8EBD535E211A75BE78AF45361DF5913D", hash_generated_method = "1CBF5089990C3FF7B2066DB75932B201")
    @DSModeled(DSC.SAFE)
    public String getSubject() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return subject;
    }

    
    private static final long serialVersionUID = -6479220126758862528L;
}

