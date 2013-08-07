package javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

public interface OptionTag {
    String getOptionTag();
    void setOptionTag(String optionTag) throws ParseException;
}
