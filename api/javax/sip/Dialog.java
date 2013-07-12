package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Iterator;
import javax.sip.address.Address;
import javax.sip.header.CallIdHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

public interface Dialog extends Serializable {
    Object getApplicationData();
    void setApplicationData(Object applicationData);

    CallIdHeader getCallId();
    String getDialogId();

    
    Transaction getFirstTransaction();

    Address getLocalParty();

    
    int getLocalSequenceNumber();

    long getLocalSeqNumber();

    String getLocalTag();

    Address getRemoteParty();

    
    int getRemoteSequenceNumber();

    long getRemoteSeqNumber();

    String getRemoteTag();

    Address getRemoteTarget();

    Iterator getRouteSet();

    SipProvider getSipProvider();

    DialogState getState();

    boolean isSecure();

    boolean isServer();

    void delete();

    void incrementLocalSequenceNumber();

    Request createRequest(String method) throws SipException;
    Request createAck(long cseq) throws InvalidArgumentException, SipException;
    Request createPrack(Response relResponse)
            throws DialogDoesNotExistException, SipException;
    Response createReliableProvisionalResponse(int statusCode)
            throws InvalidArgumentException, SipException;


    void sendRequest(ClientTransaction clientTransaction)
            throws TransactionDoesNotExistException, SipException;
    void sendAck(Request ackRequest) throws SipException;
    void sendReliableProvisionalResponse(Response relResponse)
            throws SipException;

    void setBackToBackUserAgent();

    void terminateOnBye(boolean terminateFlag) throws SipException;
}
