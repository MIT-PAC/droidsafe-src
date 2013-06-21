package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.message.Response;

public interface ServerTransaction extends Transaction {
    void sendResponse(Response response)
            throws SipException, InvalidArgumentException;

    void enableRetransmissionAlerts() throws SipException;

    ServerTransaction getCanceledInviteTransaction();
}
