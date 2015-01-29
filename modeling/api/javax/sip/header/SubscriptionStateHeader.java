package javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;

public interface SubscriptionStateHeader extends ExpiresHeader, Parameters {
    String NAME = "Subscription-State";

    String DEACTIVATED = "Deactivated";
    String GIVE_UP = "Give-Up";
    String NO_RESOURCE = "No-Resource";
    String PROBATION = "Probation";
    String REJECTED = "Rejected";
    String TIMEOUT = "Timeout";
    String UNKNOWN = "Unknown";

    String ACTIVE = "Active";
    String PENDING = "Pending";
    String TERMINATED = "Terminated";

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getReasonCode();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setReasonCode(String reasonCode) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getRetryAfter();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setRetryAfter(int retryAfter) throws InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getState();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setState(String state) throws ParseException;
}
