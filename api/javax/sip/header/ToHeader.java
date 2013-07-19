package javax.sip.header;

// Droidsafe Imports
import java.text.ParseException;

public interface ToHeader extends HeaderAddress, Header, Parameters {
    String NAME = "To";

    String getTag();
    void setTag(String tag) throws ParseException;
    boolean hasTag();
    void removeTag();

    String getDisplayName();
    String getUserAtHostPort();
}
