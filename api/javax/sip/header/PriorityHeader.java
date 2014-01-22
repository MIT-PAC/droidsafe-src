package javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

public interface PriorityHeader extends Header {
    String NAME = "Priority";

    String NON_URGENT = "Non-Urgent";
    String NORMAL = "Normal";
    String URGENT = "Urgent";
    String EMERGENCY = "Emergency";

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getPriority();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setPriority(String priority) throws ParseException;
}
