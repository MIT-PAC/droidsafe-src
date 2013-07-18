package javax.sip.header;

// Droidsafe Imports
import java.text.ParseException;

public interface SubjectHeader extends Header {
    String NAME = "Subject";

    String getSubject();
    void setSubject(String subject) throws ParseException;
}
