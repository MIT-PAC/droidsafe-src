package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import gov.nist.javax.sip.stack.MessageChannel;
import gov.nist.javax.sip.stack.SIPTransaction;
import gov.nist.javax.sip.stack.SIPTransactionStack;
import gov.nist.javax.sip.stack.ServerRequestInterface;
import gov.nist.javax.sip.stack.ServerResponseInterface;
import gov.nist.javax.sip.stack.StackMessageFactory;

import javax.sip.TransactionState;






class NistSipMessageFactoryImpl implements StackMessageFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.224 -0500", hash_original_field = "03821C4D777C0A4AB8577E0C5F2371D6", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")


    private SipStackImpl sipStack;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.227 -0500", hash_original_method = "B4A348E139EC58BD28DD0F3A69B45AAD", hash_generated_method = "6F8E186CA749499C408261B2123CEEE7")
    public NistSipMessageFactoryImpl(SipStackImpl sipStackImpl) {
        this.sipStack = sipStackImpl;

    }

    /**
     * Construct a new SIP Server Request.
     * 
     * @param sipRequest
     *            is the SIPRequest from which the SIPServerRequest is to be
     *            constructed.
     * @param messageChannel
     *            is the MessageChannel abstraction for this SIPServerRequest.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.225 -0500", hash_original_method = "05D11288A97D40A10A9E1FF4BB412446", hash_generated_method = "E7183459344DDC1F8F41F20C87AC3E8F")
    public ServerRequestInterface newSIPServerRequest(SIPRequest sipRequest,
            MessageChannel messageChannel) {

        if (messageChannel == null || sipRequest == null) {
            throw new IllegalArgumentException("Null Arg!");
        }

        SipStackImpl theStack = (SipStackImpl) messageChannel.getSIPStack();
        DialogFilter retval = new DialogFilter(
                theStack);
        if (messageChannel instanceof SIPTransaction) {
            // If the transaction has already been created
            // then set the transaction channel.
            retval.transactionChannel = (SIPTransaction) messageChannel;
        }
        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
        if (retval.listeningPoint == null)
            return null;
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug(
                    "Returning request interface for "
                            + sipRequest.getFirstLine() + " " + retval
                            + " messageChannel = " + messageChannel);
        return retval;
    }

    /**
     * Generate a new server response for the stack.
     * 
     * @param sipResponse
     *            is the SIPRequest from which the SIPServerRequest is to be
     *            constructed.
     * @param messageChannel
     *            is the MessageChannel abstraction for this SIPServerResponse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.226 -0500", hash_original_method = "683DE9908ACD912FB40AB2EA7112FC1F", hash_generated_method = "5F837B5EEEF568F0D8B6971471D8B2EC")
    public ServerResponseInterface newSIPServerResponse(
            SIPResponse sipResponse, MessageChannel messageChannel) {
        SIPTransactionStack theStack = (SIPTransactionStack) messageChannel
                .getSIPStack();
        // Tr is null if a transaction is not mapped.
        SIPTransaction tr = (SIPTransaction) ((SIPTransactionStack) theStack)
                .findTransaction(sipResponse, false);
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug(
                    "Found Transaction " + tr + " for " + sipResponse);

        if (tr != null) {
            // Prune unhealthy responses early if handling statefully.
            // If the state has not yet been assigned then this is a
            // spurious response. This was moved up from the transaction
            // layer for efficiency.
            if (tr.getState() == null) {
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug(
                            "Dropping response - null transaction state");
                return null;
                // Ignore 1xx
            } else if (TransactionState.COMPLETED == tr.getState()
                    && sipResponse.getStatusCode() / 100 == 1) {
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug(
                            "Dropping response - late arriving "
                                    + sipResponse.getStatusCode());
                return null;
            }
        }

        DialogFilter retval = new DialogFilter(
                sipStack);

        retval.transactionChannel = tr;

        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
        return retval;
    }

    
}

