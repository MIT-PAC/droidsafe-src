package javax.sip.header;

// Droidsafe Imports
import java.text.ParseException;

public interface ExtensionHeader extends Header {
    String getValue();
    void setValue(String value) throws ParseException;
}
