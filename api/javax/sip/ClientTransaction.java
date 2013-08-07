package javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.address.Hop;
import javax.sip.message.Request;

public interface ClientTransaction extends Transaction {
    
    Request createAck() throws SipException;

    Request createCancel() throws SipException;
    void sendRequest() throws SipException;

    void alertIfStillInCallingStateBy(int count);

    Hop getNextHop();

    void setNotifyOnRetransmit(boolean notifyOnRetransmit);
}
