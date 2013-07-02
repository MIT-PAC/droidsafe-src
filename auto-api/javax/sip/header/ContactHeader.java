package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public interface ContactHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Contact";

    int getExpires();
    void setExpires(int expires) throws InvalidArgumentException;

    float getQValue();
    void setQValue(float qValue) throws InvalidArgumentException;

    boolean isWildCard();
    void setWildCard();
    void setWildCardFlag(boolean wildCardFlag);
}
