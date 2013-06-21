package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public interface MaxForwardsHeader extends Header {
    String NAME = "Max-Forwards";

    void decrementMaxForwards() throws TooManyHopsException;

    int getMaxForwards();
    void setMaxForwards(int maxForwards) throws InvalidArgumentException;

    boolean hasReachedZero();
}
