package javax.sip.address;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ListIterator;

import javax.sip.SipException;
import javax.sip.message.Request;

public interface Router {
    Hop getNextHop(Request request) throws SipException;
    ListIterator getNextHops(Request request);
    Hop getOutboundProxy();
}
