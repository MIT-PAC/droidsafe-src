package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;

public interface SubjectHeader extends Header {
    String NAME = "Subject";

    String getSubject();
    void setSubject(String subject) throws ParseException;
}
