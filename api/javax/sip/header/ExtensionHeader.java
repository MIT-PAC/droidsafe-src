package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public interface ExtensionHeader extends Header {
    String getValue();
    void setValue(String value) throws ParseException;
}
