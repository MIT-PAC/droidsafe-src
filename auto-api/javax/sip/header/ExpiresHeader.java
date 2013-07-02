package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public interface ExpiresHeader extends Header {
    String NAME = "Expires";

    int getExpires();
    void setExpires(int expires) throws InvalidArgumentException;
}
