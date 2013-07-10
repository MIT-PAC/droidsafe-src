package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;

public interface OptionTag {
    String getOptionTag();
    void setOptionTag(String optionTag) throws ParseException;
}
