package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;

public interface Encoding {
    String getEncoding();
    void setEncoding(String encoding) throws ParseException;
}
