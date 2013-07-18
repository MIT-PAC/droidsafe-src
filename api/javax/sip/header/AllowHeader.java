package javax.sip.header;

// Droidsafe Imports
import java.text.ParseException;

public interface AllowHeader extends Header {
    String NAME = "Allow";

    String getMethod();
    void setMethod(String method) throws ParseException;
}
