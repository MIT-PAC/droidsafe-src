package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Calendar;

public interface DateHeader extends Header {
    String NAME = "Date";

    Calendar getDate();
    void setDate(Calendar date);
}
