package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import java.util.Iterator;

public interface Parameters {
    String getParameter(String name);
    void setParameter(String name, String value) throws ParseException;

    Iterator getParameterNames();
    void removeParameter(String name);
}
