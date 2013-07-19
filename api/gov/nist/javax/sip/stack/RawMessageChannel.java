package gov.nist.javax.sip.stack;

// Droidsafe Imports
import gov.nist.javax.sip.message.SIPMessage;

public interface RawMessageChannel {

    public abstract void processMessage(SIPMessage sipMessage) throws Exception ;

}
