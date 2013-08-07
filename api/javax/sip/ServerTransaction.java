package javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.message.Response;

public interface ServerTransaction extends Transaction {
    void sendResponse(Response response)
            throws SipException, InvalidArgumentException;

    void enableRetransmissionAlerts() throws SipException;

    ServerTransaction getCanceledInviteTransaction();
}
