package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.Utils;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.RecordRoute;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.Route;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.header.TimeStamp;
import gov.nist.javax.sip.header.To;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;

import java.io.IOException;
import java.text.ParseException;
import java.util.ListIterator;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import javax.sip.Dialog;
import javax.sip.DialogState;
import javax.sip.InvalidArgumentException;
import javax.sip.ObjectInUseException;
import javax.sip.SipException;
import javax.sip.Timeout;
import javax.sip.TimeoutEvent;
import javax.sip.TransactionState;
import javax.sip.address.Hop;
import javax.sip.address.SipURI;
import javax.sip.header.ExpiresHeader;
import javax.sip.header.RouteHeader;
import javax.sip.header.TimeStampHeader;
import javax.sip.message.Request;

public class SIPClientTransaction extends SIPTransaction implements ServerResponseInterface, javax.sip.ClientTransaction, gov.nist.javax.sip.ClientTransactionExt {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.931 -0500", hash_original_field = "58283386B675010F4891CF27E94157D3", hash_generated_field = "1487DE1D87B4F987EFCACDA15F312B17")

    // dialogs in the early state. These dialogs all have
    // the same call ID and same From tag but different to tags.

    private ConcurrentHashMap<String,SIPDialog> sipDialogs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.933 -0500", hash_original_field = "49DD22F94DF245317ED1A2BD8A02CFDB", hash_generated_field = "609F87DF574B03997F5F114A0B9D153C")

    private SIPRequest lastRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.936 -0500", hash_original_field = "D6A71000355B6BFBB50B46A66F901937", hash_generated_field = "EBCE51BBA382AA4A4CBC72431B4DD4F6")

    private int viaPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.938 -0500", hash_original_field = "4BA0D9B2BD51634788CE72CB007A32A1", hash_generated_field = "638E6682C500E41733363C20AADC9C2B")

    private String viaHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.941 -0500", hash_original_field = "65AD11AD54A2F67B68FF72DF0F0B9619", hash_generated_field = "D5BADECCFB140300052474F1FF053995")

    private transient ServerResponseInterface respondTo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.945 -0500", hash_original_field = "4CD2877ACCF9846A4F145B6AB6FC362C", hash_generated_field = "9DA006915F9968E7F19F133BB3970E72")

    private SIPDialog defaultDialog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.948 -0500", hash_original_field = "3566D4B8C0AEF966330B649D87EC260C", hash_generated_field = "B633077E034AF130A4E0928C373CBB0D")

    private Hop nextHop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.950 -0500", hash_original_field = "9C492E8F94C2A6777DDA6DBC2C27E513", hash_generated_field = "F8A9EE3383846FA140533EA0DC849D5A")

    private boolean notifyOnRetransmit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.953 -0500", hash_original_field = "36DCA919BF89F587B06884FD9CF79079", hash_generated_field = "3AFD3FC295AA4B6D90EAF77E52351862")

    private boolean timeoutIfStillInCallingState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.955 -0500", hash_original_field = "5AD8D84FA0FEEAB1970AAD286406ABD6", hash_generated_field = "5D7F837D171773BD9460FE3577E94E41")

    private int callingStateTimeoutCount;

    /**
     * Creates a new client transaction.
     * 
     * @param newSIPStack Transaction stack this transaction belongs to.
     * @param newChannelToUse Channel to encapsulate.
     * @return the created client transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.968 -0500", hash_original_method = "7433B8F0086E8DE587CA3684570FA4BD", hash_generated_method = "2018AF2AD2E4969987BE9EBAB6C8F47A")
    
protected SIPClientTransaction(SIPTransactionStack newSIPStack, MessageChannel newChannelToUse) {
        super(newSIPStack, newChannelToUse);
        // Create a random branch parameter for this transaction
        // setBranch( SIPConstants.BRANCH_MAGIC_COOKIE +
        // Integer.toHexString( hashCode( ) ) );
        setBranch(Utils.getInstance().generateBranchId());
        this.messageProcessor = newChannelToUse.messageProcessor;
        this.setEncapsulatedChannel(newChannelToUse);
        this.notifyOnRetransmit = false;
        this.timeoutIfStillInCallingState = false;

        // This semaphore guards the listener from being
        // re-entered for this transaction. That is
        // for a give tx, the listener is called at most
        // once with an outstanding request.

        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("Creating clientTransaction " + this);
            sipStack.getStackLogger().logStackTrace();
        }
        // this.startTransactionTimer();
        this.sipDialogs = new ConcurrentHashMap();
    }

    /**
     * Sets the real ResponseInterface this transaction encapsulates.
     * 
     * @param newRespondTo ResponseInterface to send messages to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.971 -0500", hash_original_method = "A499701B9B92E6B9F8BD35BBCEA7DB79", hash_generated_method = "F73C5307D17B8945C733B02534BA0F7D")
    
public void setResponseInterface(ServerResponseInterface newRespondTo) {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(
                    "Setting response interface for " + this + " to " + newRespondTo);
            if (newRespondTo == null) {
                sipStack.getStackLogger().logStackTrace();
                sipStack.getStackLogger().logDebug("WARNING -- setting to null!");
            }
        }

        respondTo = newRespondTo;

    }

    /**
     * Returns this transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.974 -0500", hash_original_method = "2565B9EE896335E27EEEABBB213A9C77", hash_generated_method = "52A37846A02A7017E22F7016E885C2EF")
    
public MessageChannel getRequestChannel() {

        return this;

    }

    /**
     * Deterines if the message is a part of this transaction.
     * 
     * @param messageToTest Message to check if it is part of this transaction.
     * 
     * @return true if the message is part of this transaction, false if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.977 -0500", hash_original_method = "C99C4952C168074F3FBA7AB2C1372665", hash_generated_method = "F33ED7C3E1DB2DC82243B965350B6674")
    
public boolean isMessagePartOfTransaction(SIPMessage messageToTest) {

        // List of Via headers in the message to test
        ViaList viaHeaders = messageToTest.getViaHeaders();
        // Flags whether the select message is part of this transaction
        boolean transactionMatches;
        String messageBranch = ((Via) viaHeaders.getFirst()).getBranch();
        boolean rfc3261Compliant = getBranch() != null
                && messageBranch != null
                && getBranch().toLowerCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)
                && messageBranch.toLowerCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE);

        transactionMatches = false;
        if (TransactionState.COMPLETED == this.getState()) {
            if (rfc3261Compliant) {
                transactionMatches = getBranch().equalsIgnoreCase(
                        ((Via) viaHeaders.getFirst()).getBranch())
                        && getMethod().equals(messageToTest.getCSeq().getMethod());
            } else {
                transactionMatches = getBranch().equals(messageToTest.getTransactionId());
            }
        } else if (!isTerminated()) {
            if (rfc3261Compliant) {
                if (viaHeaders != null) {
                    // If the branch parameter is the
                    // same as this transaction and the method is the same,
                    if (getBranch().equalsIgnoreCase(((Via) viaHeaders.getFirst()).getBranch())) {
                        transactionMatches = getOriginalRequest().getCSeq().getMethod().equals(
                                messageToTest.getCSeq().getMethod());

                    }
                }
            } else {
                // not RFC 3261 compliant.
                if (getBranch() != null) {
                    transactionMatches = getBranch().equalsIgnoreCase(
                            messageToTest.getTransactionId());
                } else {
                    transactionMatches = getOriginalRequest().getTransactionId()
                            .equalsIgnoreCase(messageToTest.getTransactionId());
                }

            }

        }
        return transactionMatches;

    }

    /**
     * Send a request message through this transaction and onto the client.
     * 
     * @param messageToSend Request to process and send.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.981 -0500", hash_original_method = "1DFD8968C3CA232EAF5E448E3048EE02", hash_generated_method = "4218F1362D3FAC8D5423CCE43D04CC05")
    
public void sendMessage(SIPMessage messageToSend) throws IOException {

        try {
            // Message typecast as a request
            SIPRequest transactionRequest;

            transactionRequest = (SIPRequest) messageToSend;

            // Set the branch id for the top via header.
            Via topVia = (Via) transactionRequest.getViaHeaders().getFirst();
            // Tack on a branch identifier to match responses.
            try {
                topVia.setBranch(getBranch());
            } catch (java.text.ParseException ex) {
            }

            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("Sending Message " + messageToSend);
                sipStack.getStackLogger().logDebug("TransactionState " + this.getState());
            }
            // If this is the first request for this transaction,
            if (TransactionState.PROCEEDING == getState()
                    || TransactionState.CALLING == getState()) {

                // If this is a TU-generated ACK request,
                if (transactionRequest.getMethod().equals(Request.ACK)) {

                    // Send directly to the underlying
                    // transport and close this transaction
                    if (isReliable()) {
                        this.setState(TransactionState.TERMINATED);
                    } else {
                        this.setState(TransactionState.COMPLETED);
                    }
                    // BUGBUG -- This suppresses sending the ACK uncomment this
                    // to
                    // test 4xx retransmission
                    // if (transactionRequest.getMethod() != Request.ACK)
                    super.sendMessage(transactionRequest);
                    return;

                }

            }
            try {

                // Send the message to the server
                lastRequest = transactionRequest;
                if (getState() == null) {
                    // Save this request as the one this transaction
                    // is handling
                    setOriginalRequest(transactionRequest);
                    // Change to trying/calling state
                    // Set state first to avoid race condition..

                    if (transactionRequest.getMethod().equals(Request.INVITE)) {
                        this.setState(TransactionState.CALLING);
                    } else if (transactionRequest.getMethod().equals(Request.ACK)) {
                        // Acks are never retransmitted.
                        this.setState(TransactionState.TERMINATED);
                    } else {
                        this.setState(TransactionState.TRYING);
                    }
                    if (!isReliable()) {
                        enableRetransmissionTimer();
                    }
                    if (isInviteTransaction()) {
                        enableTimeoutTimer(TIMER_B);
                    } else {
                        enableTimeoutTimer(TIMER_F);
                    }
                }
                // BUGBUG This supresses sending ACKS -- uncomment to test
                // 4xx retransmission.
                // if (transactionRequest.getMethod() != Request.ACK)
                super.sendMessage(transactionRequest);

            } catch (IOException e) {

                this.setState(TransactionState.TERMINATED);
                throw e;

            }
        } finally {
            this.isMapped = true;
            this.startTransactionTimer();

        }

    }

    /**
     * Process a new response message through this transaction. If necessary, this message will
     * also be passed onto the TU.
     * 
     * @param transactionResponse Response to process.
     * @param sourceChannel Channel that received this message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.984 -0500", hash_original_method = "27FC8E987828EB63A48AA2B14048F41C", hash_generated_method = "8F28EC71A380BCA40C14376432A1A42D")
    
public synchronized void processResponse(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog dialog) {

        // If the state has not yet been assigned then this is a
        // spurious response.

        if (getState() == null)
            return;

        // Ignore 1xx
        if ((TransactionState.COMPLETED == this.getState() || TransactionState.TERMINATED == this
                .getState())
                && transactionResponse.getStatusCode() / 100 == 1) {
            return;
        }

        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(
                    "processing " + transactionResponse.getFirstLine() + "current state = "
                            + getState());
            sipStack.getStackLogger().logDebug("dialog = " + dialog);
        }

        this.lastResponse = transactionResponse;

        /*
         * JvB: this is now duplicate with code in the other processResponse
         * 
         * if (dialog != null && transactionResponse.getStatusCode() != 100 &&
         * (transactionResponse.getTo().getTag() != null || sipStack .isRfc2543Supported())) { //
         * add the route before you process the response. dialog.setLastResponse(this,
         * transactionResponse); this.setDialog(dialog, transactionResponse.getDialogId(false)); }
         */

        try {
            if (isInviteTransaction())
                inviteClientTransaction(transactionResponse, sourceChannel, dialog);
            else
                nonInviteClientTransaction(transactionResponse, sourceChannel, dialog);
        } catch (IOException ex) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logException(ex);
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        }
    }

    /**
     * Implements the state machine for invite client transactions.
     * 
     * <pre>
     *                   
     *                    
     *                     
     *                      
     *                      
     *                                                         |Request from TU
     *                                                         |send request
     *                                     Timer E             V
     *                                     send request  +-----------+
     *                                         +---------|           |-------------------+
     *                                         |         |  Trying   |  Timer F          |
     *                                         +--------&gt;|           |  or Transport Err.|
     *                                                   +-----------+  inform TU        |
     *                                      200-699         |  |                         |
     *                                      resp. to TU     |  |1xx                      |
     *                                      +---------------+  |resp. to TU              |
     *                                      |                  |                         |
     *                                      |   Timer E        V       Timer F           |
     *                                      |   send req +-----------+ or Transport Err. |
     *                                      |  +---------|           | inform TU         |
     *                                      |  |         |Proceeding |------------------&gt;|
     *                                      |  +--------&gt;|           |-----+             |
     *                                      |            +-----------+     |1xx          |
     *                                      |              |      &circ;        |resp to TU   |
     *                                      | 200-699      |      +--------+             |
     *                                      | resp. to TU  |                             |
     *                                      |              |                             |
     *                                      |              V                             |
     *                                      |            +-----------+                   |
     *                                      |            |           |                   |
     *                                      |            | Completed |                   |
     *                                      |            |           |                   |
     *                                      |            +-----------+                   |
     *                                      |              &circ;   |                         |
     *                                      |              |   | Timer K                 |
     *                                      +--------------+   | -                       |
     *                                                         |                         |
     *                                                         V                         |
     *                                   NOTE:           +-----------+                   |
     *                                                   |           |                   |
     *                               transitions         | Terminated|&lt;------------------+
     *                               labeled with        |           |
     *                               the event           +-----------+
     *                               over the action
     *                               to take
     *                      
     *                                       Figure 6: non-INVITE client transaction
     *                      
     *                      
     *                     
     *                    
     * </pre>
     * 
     * @param transactionResponse -- transaction response received.
     * @param sourceChannel - source channel on which the response was received.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.988 -0500", hash_original_method = "ADF3D75C6ADD47CBC6B3D63B5D3998CF", hash_generated_method = "0877A94654B2780C0441D1B234A42B9A")
    
private void nonInviteClientTransaction(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog sipDialog) throws IOException {
        int statusCode = transactionResponse.getStatusCode();
        if (TransactionState.TRYING == this.getState()) {
            if (statusCode / 100 == 1) {
                this.setState(TransactionState.PROCEEDING);
                enableRetransmissionTimer(MAXIMUM_RETRANSMISSION_TICK_COUNT);
                enableTimeoutTimer(TIMER_F);
                // According to RFC, the TU has to be informed on
                // this transition.
                if (respondTo != null) {
                    respondTo.processResponse(transactionResponse, this, sipDialog);
                } else {
                    this.semRelease();
                }
            } else if (200 <= statusCode && statusCode <= 699) {
                // Send the response up to the TU.
                if (respondTo != null) {
                    respondTo.processResponse(transactionResponse, this, sipDialog);
                } else {
                    this.semRelease();
                }
                if (!isReliable()) {
                    this.setState(TransactionState.COMPLETED);
                    enableTimeoutTimer(TIMER_K);
                } else {
                    this.setState(TransactionState.TERMINATED);
                }
            }
        } else if (TransactionState.PROCEEDING == this.getState()) {
            if (statusCode / 100 == 1) {
                if (respondTo != null) {
                    respondTo.processResponse(transactionResponse, this, sipDialog);
                } else {
                    this.semRelease();
                }
            } else if (200 <= statusCode && statusCode <= 699) {
                if (respondTo != null) {
                    respondTo.processResponse(transactionResponse, this, sipDialog);
                } else {
                    this.semRelease();
                }
                disableRetransmissionTimer();
                disableTimeoutTimer();
                if (!isReliable()) {
                    this.setState(TransactionState.COMPLETED);
                    enableTimeoutTimer(TIMER_K);
                } else {
                    this.setState(TransactionState.TERMINATED);
                }
            }
        } else {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug(
                        " Not sending response to TU! " + getState());
            }
            this.semRelease();
        }
    }

    /**
     * Implements the state machine for invite client transactions.
     * 
     * <pre>
     *                   
     *                    
     *                     
     *                      
     *                      
     *                                                     |INVITE from TU
     *                                   Timer A fires     |INVITE sent
     *                                   Reset A,          V                      Timer B fires
     *                                   INVITE sent +-----------+                or Transport Err.
     *                                     +---------|           |---------------+inform TU
     *                                     |         |  Calling  |               |
     *                                     +--------&gt;|           |--------------&gt;|
     *                                               +-----------+ 2xx           |
     *                                                  |  |       2xx to TU     |
     *                                                  |  |1xx                  |
     *                          300-699 +---------------+  |1xx to TU            |
     *                         ACK sent |                  |                     |
     *                      resp. to TU |  1xx             V                     |
     *                                  |  1xx to TU  -----------+               |
     *                                  |  +---------|           |               |
     *                                  |  |         |Proceeding |--------------&gt;|
     *                                  |  +--------&gt;|           | 2xx           |
     *                                  |            +-----------+ 2xx to TU     |
     *                                  |       300-699    |                     |
     *                                  |       ACK sent,  |                     |
     *                                  |       resp. to TU|                     |
     *                                  |                  |                     |      NOTE:
     *                                  |  300-699         V                     |
     *                                  |  ACK sent  +-----------+Transport Err. |  transitions
     *                                  |  +---------|           |Inform TU      |  labeled with
     *                                  |  |         | Completed |--------------&gt;|  the event
     *                                  |  +--------&gt;|           |               |  over the action
     *                                  |            +-----------+               |  to take
     *                                  |              &circ;   |                     |
     *                                  |              |   | Timer D fires       |
     *                                  +--------------+   | -                   |
     *                                                     |                     |
     *                                                     V                     |
     *                                               +-----------+               |
     *                                               |           |               |
     *                                               | Terminated|&lt;--------------+
     *                                               |           |
     *                                               +-----------+
     *                      
     *                      
     *                     
     *                    
     * </pre>
     * 
     * @param transactionResponse -- transaction response received.
     * @param sourceChannel - source channel on which the response was received.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.993 -0500", hash_original_method = "C74AAAAD68DF1265333F033333BC207B", hash_generated_method = "3EB99BFD5E7B84123E5B644CCCED444B")
    
private void inviteClientTransaction(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog dialog) throws IOException {
        int statusCode = transactionResponse.getStatusCode();
       
        if (TransactionState.TERMINATED == this.getState()) {
            boolean ackAlreadySent = false;
            if (dialog != null && dialog.isAckSeen() && dialog.getLastAckSent() != null) {
                if (dialog.getLastAckSent().getCSeq().getSeqNumber() == transactionResponse.getCSeq()
                        .getSeqNumber()
                        && transactionResponse.getFromTag().equals(
                                dialog.getLastAckSent().getFromTag())) {
                    // the last ack sent corresponded to this response
                    ackAlreadySent = true;
                }
            }
            // retransmit the ACK for this response.
            if (dialog!= null && ackAlreadySent
                    && transactionResponse.getCSeq().getMethod().equals(dialog.getMethod())) {
                try {
                    // Found the dialog - resend the ACK and
                    // dont pass up the null transaction
                    if (sipStack.isLoggingEnabled())
                        sipStack.getStackLogger().logDebug("resending ACK");

                    dialog.resendAck();
                } catch (SipException ex) {
                    // What to do here ?? kill the dialog?
                }
            }

            this.semRelease();
            return;
        } else if (TransactionState.CALLING == this.getState()) {
            if (statusCode / 100 == 2) {

                // JvB: do this ~before~ calling the application, to avoid
                // retransmissions
                // of the INVITE after app sends ACK
                disableRetransmissionTimer();
                disableTimeoutTimer();
                this.setState(TransactionState.TERMINATED);

                // 200 responses are always seen by TU.
                if (respondTo != null)
                    respondTo.processResponse(transactionResponse, this, dialog);
                else {
                    this.semRelease();
                }

            } else if (statusCode / 100 == 1) {
                disableRetransmissionTimer();
                disableTimeoutTimer();
                this.setState(TransactionState.PROCEEDING);

                if (respondTo != null)
                    respondTo.processResponse(transactionResponse, this, dialog);
                else {
                    this.semRelease();
                }

            } else if (300 <= statusCode && statusCode <= 699) {
                // Send back an ACK request

                try {
                    sendMessage((SIPRequest) createErrorAck());

                } catch (Exception ex) {
                    sipStack.getStackLogger().logError(
                            "Unexpected Exception sending ACK -- sending error AcK ", ex);

                }

                /*
                 * When in either the "Calling" or "Proceeding" states, reception of response with
                 * status code from 300-699 MUST cause the client transaction to transition to
                 * "Completed". The client transaction MUST pass the received response up to the
                 * TU, and the client transaction MUST generate an ACK request.
                 */

                if (respondTo != null) {
                    respondTo.processResponse(transactionResponse, this, dialog);
                } else {
                    this.semRelease();
                }

                if (this.getDialog() != null &&  ((SIPDialog)this.getDialog()).isBackToBackUserAgent()) {
                    ((SIPDialog) this.getDialog()).releaseAckSem();
                }

                if (!isReliable()) {
                    this.setState(TransactionState.COMPLETED);
                    enableTimeoutTimer(TIMER_D);
                } else {
                    // Proceed immediately to the TERMINATED state.
                    this.setState(TransactionState.TERMINATED);
                }
            }
        } else if (TransactionState.PROCEEDING == this.getState()) {
            if (statusCode / 100 == 1) {
                if (respondTo != null) {
                    respondTo.processResponse(transactionResponse, this, dialog);
                } else {
                    this.semRelease();
                }
            } else if (statusCode / 100 == 2) {
                this.setState(TransactionState.TERMINATED);
                if (respondTo != null) {
                    respondTo.processResponse(transactionResponse, this, dialog);
                } else {
                    this.semRelease();
                }

            } else if (300 <= statusCode && statusCode <= 699) {
                // Send back an ACK request
                try {
                    sendMessage((SIPRequest) createErrorAck());
                } catch (Exception ex) {
                    InternalErrorHandler.handleException(ex);
                }

                if (this.getDialog() != null) {
                    ((SIPDialog) this.getDialog()).releaseAckSem();
                }
                // JvB: update state before passing to app
                if (!isReliable()) {
                    this.setState(TransactionState.COMPLETED);
                    this.enableTimeoutTimer(TIMER_D);
                } else {
                    this.setState(TransactionState.TERMINATED);
                }

                // Pass up to the TU for processing.
                if (respondTo != null)
                    respondTo.processResponse(transactionResponse, this, dialog);
                else {
                    this.semRelease();
                }

                // JvB: duplicate with line 874
                // if (!isReliable()) {
                // enableTimeoutTimer(TIMER_D);
                // }
            }
        } else if (TransactionState.COMPLETED == this.getState()) {
            if (300 <= statusCode && statusCode <= 699) {
                // Send back an ACK request
                try {
                    sendMessage((SIPRequest) createErrorAck());
                } catch (Exception ex) {
                    InternalErrorHandler.handleException(ex);
                } finally {
                    this.semRelease();
                }
            }

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.ClientTransaction#sendRequest()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.998 -0500", hash_original_method = "9C1F15FBE6A7795E5EE0D6BE4F94BCBE", hash_generated_method = "E6564F2955B5D9CD84E08D528F5AB8E2")
    
public void sendRequest() throws SipException {
        SIPRequest sipRequest = this.getOriginalRequest();

        if (this.getState() != null)
            throw new SipException("Request already sent");

        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("sendRequest() " + sipRequest);
        }

        try {
            sipRequest.checkHeaders();
        } catch (ParseException ex) {
        	if (sipStack.isLoggingEnabled())
        		sipStack.getStackLogger().logError("missing required header");
            throw new SipException(ex.getMessage());
        }

        if (getMethod().equals(Request.SUBSCRIBE)
                && sipRequest.getHeader(ExpiresHeader.NAME) == null) {
            /*
             * If no "Expires" header is present in a SUBSCRIBE request, the implied default is
             * defined by the event package being used.
             * 
             */
        	if (sipStack.isLoggingEnabled())
        		sipStack.getStackLogger().logWarning(
                    "Expires header missing in outgoing subscribe --"
                            + " Notifier will assume implied value on event package");
        }
        try {
            /*
             * This check is removed because it causes problems for load balancers ( See issue
             * 136) reported by Raghav Ramesh ( BT )
             * 
             */
            if (this.getOriginalRequest().getMethod().equals(Request.CANCEL)
                    && sipStack.isCancelClientTransactionChecked()) {
                SIPClientTransaction ct = (SIPClientTransaction) sipStack.findCancelTransaction(
                        this.getOriginalRequest(), false);
                if (ct == null) {
                    /*
                     * If the original request has generated a final response, the CANCEL SHOULD
                     * NOT be sent, as it is an effective no-op, since CANCEL has no effect on
                     * requests that have already generated a final response.
                     */
                    throw new SipException("Could not find original tx to cancel. RFC 3261 9.1");
                } else if (ct.getState() == null) {
                    throw new SipException(
                            "State is null no provisional response yet -- cannot cancel RFC 3261 9.1");
                } else if (!ct.getMethod().equals(Request.INVITE)) {
                    throw new SipException("Cannot cancel non-invite requests RFC 3261 9.1");
                }
            } else

            if (this.getOriginalRequest().getMethod().equals(Request.BYE)
                    || this.getOriginalRequest().getMethod().equals(Request.NOTIFY)) {
                SIPDialog dialog = sipStack.getDialog(this.getOriginalRequest()
                        .getDialogId(false));
                // I want to behave like a user agent so send the BYE using the
                // Dialog
                if (this.getSipProvider().isAutomaticDialogSupportEnabled() && dialog != null) {
                    throw new SipException(
                            "Dialog is present and AutomaticDialogSupport is enabled for "
                                    + " the provider -- Send the Request using the Dialog.sendRequest(transaction)");
                }
            }
            // Only map this after the fist request is sent out.
            if (this.getMethod().equals(Request.INVITE)) {
                SIPDialog dialog = this.getDefaultDialog();

                if (dialog != null && dialog.isBackToBackUserAgent()) {
                    // Block sending re-INVITE till we see the ACK.
                    if ( ! dialog.takeAckSem() ) {
                        throw new SipException ("Failed to take ACK semaphore");
                    }

                }
            }
            this.isMapped = true;
            this.sendMessage(sipRequest);

        } catch (IOException ex) {
            this.setState(TransactionState.TERMINATED);
            throw new SipException("IO Error sending request", ex);

        }

    }

    /**
     * Called by the transaction stack when a retransmission timer fires.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.002 -0500", hash_original_method = "328DA368C3B0C5FF79EC2B4ACE66A1A9", hash_generated_method = "C9E59CBA897C530A6A55F5DD7BEEA99A")
    
protected void fireRetransmissionTimer() {

        try {

            // Resend the last request sent
            if (this.getState() == null || !this.isMapped)
                return;

            boolean inv = isInviteTransaction();
            TransactionState s = this.getState();

            // JvB: INVITE CTs only retransmit in CALLING, non-INVITE in both TRYING and
            // PROCEEDING
            // Bug-fix for non-INVITE transactions not retransmitted when 1xx response received
            if ((inv && TransactionState.CALLING == s)
                    || (!inv && (TransactionState.TRYING == s || TransactionState.PROCEEDING == s))) {
                // If the retransmission filter is disabled then
                // retransmission of the INVITE is the application
                // responsibility.

                if (lastRequest != null) {
                    if (sipStack.generateTimeStampHeader
                            && lastRequest.getHeader(TimeStampHeader.NAME) != null) {
                        long milisec = System.currentTimeMillis();
                        TimeStamp timeStamp = new TimeStamp();
                        try {
                            timeStamp.setTimeStamp(milisec);
                        } catch (InvalidArgumentException ex) {
                            InternalErrorHandler.handleException(ex);
                        }
                        lastRequest.setHeader(timeStamp);
                    }
                    super.sendMessage(lastRequest);
                    if (this.notifyOnRetransmit) {
                        TimeoutEvent txTimeout = new TimeoutEvent(this.getSipProvider(), this,
                                Timeout.RETRANSMIT);
                        this.getSipProvider().handleEvent(txTimeout, this);
                    }
                    if (this.timeoutIfStillInCallingState
                            && this.getState() == TransactionState.CALLING) {
                        this.callingStateTimeoutCount--;
                        if (callingStateTimeoutCount == 0) {
                            TimeoutEvent timeoutEvent = new TimeoutEvent(this.getSipProvider(),
                                    this, Timeout.RETRANSMIT);
                            this.getSipProvider().handleEvent(timeoutEvent, this);
                            this.timeoutIfStillInCallingState = false;
                        }

                    }
                }

            }
        } catch (IOException e) {
            this.raiseIOExceptionEvent();
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        }

    }

    /**
     * Called by the transaction stack when a timeout timer fires.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.005 -0500", hash_original_method = "F0DB4D0E841E14FF88BA6095928288BF", hash_generated_method = "694195C523131C2F5C607CBD71DBBD1C")
    
protected void fireTimeoutTimer() {

        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("fireTimeoutTimer " + this);

        SIPDialog dialog = (SIPDialog) this.getDialog();
        if (TransactionState.CALLING == this.getState()
                || TransactionState.TRYING == this.getState()
                || TransactionState.PROCEEDING == this.getState()) {
            // Timeout occured. If this is asociated with a transaction
            // creation then kill the dialog.
            if (dialog != null
                    && (dialog.getState() == null || dialog.getState() == DialogState.EARLY)) {
                if (((SIPTransactionStack) getSIPStack()).isDialogCreated(this
                        .getOriginalRequest().getMethod())) {
                    // If this is a re-invite we do not delete the dialog even
                    // if the
                    // reinvite times out. Else
                    // terminate the enclosing dialog.
                    dialog.delete();
                }
            } else if (dialog != null) {
                // Guard against the case of BYE time out.

                if (getOriginalRequest().getMethod().equalsIgnoreCase(Request.BYE)
                        && dialog.isTerminatedOnBye()) {
                    // Terminate the associated dialog on BYE Timeout.
                    dialog.delete();
                }
            }
        }
        if (TransactionState.COMPLETED != this.getState()) {
            raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
            // Got a timeout error on a cancel.
            if (this.getOriginalRequest().getMethod().equalsIgnoreCase(Request.CANCEL)) {
                SIPClientTransaction inviteTx = (SIPClientTransaction) this.getOriginalRequest()
                        .getInviteTransaction();
                if (inviteTx != null
                        && ((inviteTx.getState() == TransactionState.CALLING || inviteTx
                                .getState() == TransactionState.PROCEEDING))
                        && inviteTx.getDialog() != null) {
                    /*
                     * A proxy server should have started TIMER C and take care of the Termination
                     * using transaction.terminate() by itself (i.e. this is not the job of the
                     * stack at this point but we do it to be nice.
                     */
                    inviteTx.setState(TransactionState.TERMINATED);

                }
            }

        } else {
            this.setState(TransactionState.TERMINATED);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.ClientTransaction#createCancel()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.008 -0500", hash_original_method = "2914559B80386C20A981D1BD82B7352B", hash_generated_method = "A21D87919D52D9CBE60F4041F8BFD612")
    
public Request createCancel() throws SipException {
        SIPRequest originalRequest = this.getOriginalRequest();
        if (originalRequest == null)
            throw new SipException("Bad state " + getState());
        if (!originalRequest.getMethod().equals(Request.INVITE))
            throw new SipException("Only INIVTE may be cancelled");

        if (originalRequest.getMethod().equalsIgnoreCase(Request.ACK))
            throw new SipException("Cannot Cancel ACK!");
        else {
            SIPRequest cancelRequest = originalRequest.createCancelRequest();
            cancelRequest.setInviteTransaction(this);
            return cancelRequest;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.ClientTransaction#createAck()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.013 -0500", hash_original_method = "59092618FB848453FA0559AC58047778", hash_generated_method = "194F8DAA60D5DA096C3626DF64E87588")
    
public Request createAck() throws SipException {
        SIPRequest originalRequest = this.getOriginalRequest();
        if (originalRequest == null)
            throw new SipException("bad state " + getState());
        if (getMethod().equalsIgnoreCase(Request.ACK)) {
            throw new SipException("Cannot ACK an ACK!");
        } else if (lastResponse == null) {
            throw new SipException("bad Transaction state");
        } else if (lastResponse.getStatusCode() < 200) {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("lastResponse = " + lastResponse);
            }
            throw new SipException("Cannot ACK a provisional response!");
        }
        SIPRequest ackRequest = originalRequest.createAckRequest((To) lastResponse.getTo());
        // Pull the record route headers from the last reesponse.
        RecordRouteList recordRouteList = lastResponse.getRecordRouteHeaders();
        if (recordRouteList == null) {
            // If the record route list is null then we can
            // construct the ACK from the specified contact header.
            // Note the 3xx check here because 3xx is a redirect.
            // The contact header for the 3xx is the redirected
            // location so we cannot use that to construct the
            // request URI.
            if (lastResponse.getContactHeaders() != null
                    && lastResponse.getStatusCode() / 100 != 3) {
                Contact contact = (Contact) lastResponse.getContactHeaders().getFirst();
                javax.sip.address.URI uri = (javax.sip.address.URI) contact.getAddress().getURI()
                        .clone();
                ackRequest.setRequestURI(uri);
            }
            return ackRequest;
        }

        ackRequest.removeHeader(RouteHeader.NAME);
        RouteList routeList = new RouteList();
        // start at the end of the list and walk backwards
        ListIterator<RecordRoute> li = recordRouteList.listIterator(recordRouteList.size());
        while (li.hasPrevious()) {
            RecordRoute rr = (RecordRoute) li.previous();

            Route route = new Route();
            route.setAddress((AddressImpl) ((AddressImpl) rr.getAddress()).clone());
            route.setParameters((NameValueList) rr.getParameters().clone());
            routeList.add(route);
        }

        Contact contact = null;
        if (lastResponse.getContactHeaders() != null) {
            contact = (Contact) lastResponse.getContactHeaders().getFirst();
        }

        if (!((SipURI) ((Route) routeList.getFirst()).getAddress().getURI()).hasLrParam()) {

            // Contact may not yet be there (bug reported by Andreas B).

            Route route = null;
            if (contact != null) {
                route = new Route();
                route.setAddress((AddressImpl) ((AddressImpl) (contact.getAddress())).clone());
            }

            Route firstRoute = (Route) routeList.getFirst();
            routeList.removeFirst();
            javax.sip.address.URI uri = firstRoute.getAddress().getURI();
            ackRequest.setRequestURI(uri);

            if (route != null)
                routeList.add(route);

            ackRequest.addHeader(routeList);
        } else {
            if (contact != null) {
                javax.sip.address.URI uri = (javax.sip.address.URI) contact.getAddress().getURI()
                        .clone();
                ackRequest.setRequestURI(uri);
                ackRequest.addHeader(routeList);
            }
        }
        return ackRequest;

    }

    /*
     * Creates an ACK for an error response, according to RFC3261 section 17.1.1.3
     * 
     * Note that this is different from an ACK for 2xx
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.016 -0500", hash_original_method = "C777E21FF4216BC8A7ADE1EB27ADDE8D", hash_generated_method = "1106CF9D033B224BB717BD53D35FD0EB")
    
private final Request createErrorAck() throws SipException, ParseException {
        SIPRequest originalRequest = this.getOriginalRequest();
        if (originalRequest == null)
            throw new SipException("bad state " + getState());
        if (!getMethod().equals(Request.INVITE)) {
            throw new SipException("Can only ACK an INVITE!");
        } else if (lastResponse == null) {
            throw new SipException("bad Transaction state");
        } else if (lastResponse.getStatusCode() < 200) {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("lastResponse = " + lastResponse);
            }
            throw new SipException("Cannot ACK a provisional response!");
        }
        return originalRequest.createErrorAck((To) lastResponse.getTo());
    }

    /**
     * Set the port of the recipient.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.019 -0500", hash_original_method = "FADEF945106DA805CF02027B2BE28020", hash_generated_method = "69B62B2783825261FFFD670703A28D6D")
    
protected void setViaPort(int port) {
        this.viaPort = port;
    }

    /**
     * Set the port of the recipient.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.022 -0500", hash_original_method = "0E538A29C97CB223EF1CD12A71C73074", hash_generated_method = "6DF11C0EA4BA366B574256E72409BF02")
    
protected void setViaHost(String host) {
        this.viaHost = host;
    }

    /**
     * Get the port of the recipient.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.024 -0500", hash_original_method = "133D8E60A07873D19335FF91037EC663", hash_generated_method = "47E8349AAEDCC463643334B5373A918E")
    
public int getViaPort() {
        return this.viaPort;
    }

    /**
     * Get the host of the recipient.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.027 -0500", hash_original_method = "BFF3BD5D9B7619BE758B5D7001336743", hash_generated_method = "039119DB2163C31C729A57BCE7626576")
    
public String getViaHost() {
        return this.viaHost;
    }

    /**
     * get the via header for an outgoing request.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.029 -0500", hash_original_method = "0750F8DA140E6BEE450B9743ACFD7E44", hash_generated_method = "9C92BA4FD41355353691977C36D2DA21")
    
public Via getOutgoingViaHeader() {
        return this.getMessageProcessor().getViaHeader();
    }

    /**
     * This is called by the stack after a non-invite client transaction goes to completed state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.032 -0500", hash_original_method = "B250DD181A3373E2CC04255377753F31", hash_generated_method = "66E28C27DA9C4D6709862FD4742C6441")
    
public void clearState() {
        // reduce the state to minimum
        // This assumes that the application will not need
        // to access the request once the transaction is
        // completed.
        // TODO -- revisit this - results in a null pointer
        // occuring occasionally.
        // this.lastRequest = null;
        // this.originalRequest = null;
        // this.lastResponse = null;
    }

    /**
     * Sets a timeout after which the connection is closed (provided the server does not use the
     * connection for outgoing requests in this time period) and calls the superclass to set
     * state.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.035 -0500", hash_original_method = "513C7C1329620A072B43100259C2C5F6", hash_generated_method = "DA1A7D4A616512B8A2170ABC61DA0D9D")
    
public void setState(TransactionState newState) {
        // Set this timer for connection caching
        // of incoming connections.
        if (newState == TransactionState.TERMINATED && this.isReliable()
                && (!getSIPStack().cacheClientConnections)) {
            // Set a time after which the connection
            // is closed.
            this.collectionTime = TIMER_J;

        }
        if (super.getState() != TransactionState.COMPLETED
                && (newState == TransactionState.COMPLETED || newState == TransactionState.TERMINATED)) {
            sipStack.decrementActiveClientTransactionCount();
        }
        super.setState(newState);
    }

    /**
     * Start the timer task.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.037 -0500", hash_original_method = "8AD9FEC5ADB8A6F1DFBB290459716C8C", hash_generated_method = "7C0DBF937F45AF34490E16CDFA0E724E")
    
protected  void startTransactionTimer() {
        if (this.transactionTimerStarted.compareAndSet(false, true)) {
	        TimerTask myTimer = new TransactionTimer();
	        if ( sipStack.getTimer() != null ) {
	            sipStack.getTimer().schedule(myTimer, BASE_TIMER_INTERVAL, BASE_TIMER_INTERVAL);
	        }
        }
    }

    /*
     * Terminate a transaction. This marks the tx as terminated The tx scanner will run and remove
     * the tx. (non-Javadoc)
     * 
     * @see javax.sip.Transaction#terminate()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.040 -0500", hash_original_method = "ACD8113ABC5B192A943EAFBD5656CA38", hash_generated_method = "D52B63D32C55DE721F6C07A8E1F15598")
    
public void terminate() throws ObjectInUseException {
        this.setState(TransactionState.TERMINATED);

    }

    /**
     * Check if the From tag of the response matches the from tag of the original message. A
     * Response with a tag mismatch should be dropped if a Dialog has been created for the
     * original request.
     * 
     * @param sipResponse the response to check.
     * @return true if the check passes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.043 -0500", hash_original_method = "8BA63F6111F6111C9CE6504A86A67BA3", hash_generated_method = "3E6435A5A93E05E491F006FC4E37176A")
    
public boolean checkFromTag(SIPResponse sipResponse) {
        String originalFromTag = ((SIPRequest) this.getRequest()).getFromTag();
        if (this.defaultDialog != null) {
            if (originalFromTag == null ^ sipResponse.getFrom().getTag() == null) {
            	if (sipStack.isLoggingEnabled())
            		sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                return false;
            }
            if (originalFromTag != null
                    && !originalFromTag.equalsIgnoreCase(sipResponse.getFrom().getTag())) {
            	if (sipStack.isLoggingEnabled())
            		sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                return false;
            }
        }
        return true;

    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.nist.javax.sip.stack.ServerResponseInterface#processResponse(gov.nist.javax.sip.message.SIPResponse,
     *      gov.nist.javax.sip.stack.MessageChannel)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.047 -0500", hash_original_method = "38065D3AA78F19CFA0459E8A308EC067", hash_generated_method = "2822CB128B646821D5C13237EF91297F")
    
public void processResponse(SIPResponse sipResponse, MessageChannel incomingChannel) {

        // If a dialog has already been created for this response,
        // pass it up.
        SIPDialog dialog = null;
        String method = sipResponse.getCSeq().getMethod();
        String dialogId = sipResponse.getDialogId(false);
        if (method.equals(Request.CANCEL) && lastRequest != null) {
            // JvB for CANCEL: use invite CT in CANCEL request to get dialog
            // (instead of stripping tag)
            SIPClientTransaction ict = (SIPClientTransaction) lastRequest.getInviteTransaction();
            if (ict != null) {
                dialog = ict.defaultDialog;
            }
        } else {
            dialog = this.getDialog(dialogId);
        }

        // JvB: Check all conditions required for creating a new Dialog
        if (dialog == null) {
            int code = sipResponse.getStatusCode();
            if ((code > 100 && code < 300)
            /* skip 100 (may have a to tag */
            && (sipResponse.getToTag() != null || sipStack.isRfc2543Supported())
                    && sipStack.isDialogCreated(method)) {

                /*
                 * Dialog cannot be found for the response. This must be a forked response. no
                 * dialog assigned to this response but a default dialog has been assigned. Note
                 * that if automatic dialog support is configured then a default dialog is always
                 * created.
                 */

                synchronized (this) {
                    /*
                     * We need synchronization here because two responses may compete for the
                     * default dialog simultaneously
                     */
                    if (defaultDialog != null) {
                        if (sipResponse.getFromTag() != null) {
                            SIPResponse dialogResponse = defaultDialog.getLastResponse();
                            String defaultDialogId = defaultDialog.getDialogId();
                            if (dialogResponse == null
                                    || (method.equals(Request.SUBSCRIBE)
                                            && dialogResponse.getCSeq().getMethod().equals(
                                                    Request.NOTIFY) && defaultDialogId
                                            .equals(dialogId))) {
                                // The default dialog has not been claimed yet.
                                defaultDialog.setLastResponse(this, sipResponse);
                                dialog = defaultDialog;
                            } else {
                                /*
                                 * check if we have created one previously (happens in the case of
                                 * REINVITE processing. JvB: should not happen, this.defaultDialog
                                 * should then get set in Dialog#sendRequest line 1662
                                 */

                                dialog = sipStack.getDialog(dialogId);
                                if (dialog == null) {
                                    if (defaultDialog.isAssigned()) {
                                        /*
                                         * Nop we dont have one. so go ahead and allocate a new
                                         * one.
                                         */
                                        dialog = sipStack.createDialog(this, sipResponse);

                                    }
                                }

                            }
                            if ( dialog != null ) {
                                this.setDialog(dialog, dialog.getDialogId());
                            } else {
                                sipStack.getStackLogger().logError("dialog is unexpectedly null",new NullPointerException());
                            }
                        } else {
                            throw new RuntimeException("Response without from-tag");
                        }
                    } else {
                        // Need to create a new Dialog, this becomes default
                        // JvB: not sure if this ever gets executed
                        if (sipStack.isAutomaticDialogSupportEnabled) {
                            dialog = sipStack.createDialog(this, sipResponse);
                            this.setDialog(dialog, dialog.getDialogId());
                        }
                    }
                } // synchronized
            } else {
                dialog = defaultDialog;
            }
        } else {
            dialog.setLastResponse(this, sipResponse);
        }
        this.processResponse(sipResponse, incomingChannel, dialog);
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.nist.javax.sip.stack.SIPTransaction#getDialog()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.050 -0500", hash_original_method = "A455A41B989A73F91883A443A89AF007", hash_generated_method = "FD23868559BDFE18A1336D5F8FE31CBF")
    
public  Dialog getDialog() {
        // This is for backwards compatibility.
        Dialog retval = null;
        if (this.lastResponse != null && this.lastResponse.getFromTag() != null
                && this.lastResponse.getToTag() != null
                && this.lastResponse.getStatusCode() != 100) {
            String dialogId = this.lastResponse.getDialogId(false);
            retval = (Dialog) getDialog(dialogId);
        }

        if (retval == null) {
            retval = (Dialog) this.defaultDialog;

        }
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(
                    " sipDialogs =  " + sipDialogs + " default dialog " + this.defaultDialog
                            + " retval " + retval);
        }
        return retval;

    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.nist.javax.sip.stack.SIPTransaction#setDialog(gov.nist.javax.sip.stack.SIPDialog,
     *      gov.nist.javax.sip.message.SIPMessage)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.053 -0500", hash_original_method = "7CA3466B3B290C9233529520194EB8A2", hash_generated_method = "0C9B6900A90B5B2C0B76494AD7ADD1FE")
    
public SIPDialog getDialog(String dialogId) {
        SIPDialog retval = (SIPDialog) this.sipDialogs.get(dialogId);
        return retval;

    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.nist.javax.sip.stack.SIPTransaction#setDialog(gov.nist.javax.sip.stack.SIPDialog,
     *      gov.nist.javax.sip.message.SIPMessage)
     */
    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.056 -0500", hash_original_method = "9816411304542A0CA40176674DC457D1", hash_generated_method = "2023AC5D58B374E7D429DAC7185BF846")
    
public void setDialog(SIPDialog sipDialog, String dialogId) {
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug(
                    "setDialog: " + dialogId + "sipDialog = " + sipDialog);

        if (sipDialog == null) {
        	if (sipStack.isLoggingEnabled())
        		sipStack.getStackLogger().logError("NULL DIALOG!!");
            throw new NullPointerException("bad dialog null");
        }
        if (this.defaultDialog == null) {
            this.defaultDialog = sipDialog;
            if ( this.getMethod().equals(Request.INVITE) && this.getSIPStack().maxForkTime != 0) {
                this.getSIPStack().addForkedClientTransaction(this);
            }
        }
        if (dialogId != null && sipDialog.getDialogId() != null) {
            this.sipDialogs.put(dialogId, sipDialog);

        }

    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.059 -0500", hash_original_method = "EC86D15857564E1427115ADA6B1A0784", hash_generated_method = "21F9EDBC8D80BE52B8A821DB6AFCF3E9")
    
public SIPDialog getDefaultDialog() {
        return this.defaultDialog;
    }

    /**
     * Set the next hop ( if it has already been computed).
     * 
     * @param hop -- the hop that has been previously computed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.061 -0500", hash_original_method = "BBF8312DD6859DF11BA280D3CE71F333", hash_generated_method = "700D5A83C07E6D4AE6DDEA4F45ECA115")
    
public void setNextHop(Hop hop) {
        this.nextHop = hop;

    }

    /**
     * Reeturn the previously computed next hop (avoid computing it twice).
     * 
     * @return -- next hop previously computed.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.064 -0500", hash_original_method = "F8BB258224ADAD4254DDBC66AEC6C06F", hash_generated_method = "6CA26D0EC82CDBAA9FD6A788CFF1CBCE")
    
public Hop getNextHop() {
        return nextHop;
    }

    /**
     * Set this flag if you want your Listener to get Timeout.RETRANSMIT notifications each time a
     * retransmission occurs.
     * 
     * @param notifyOnRetransmit the notifyOnRetransmit to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.066 -0500", hash_original_method = "5A4A2DE6DA5EAFA8C9F9B9398CD98855", hash_generated_method = "0CF8CBD35E6918414B624445A15DE787")
    
public void setNotifyOnRetransmit(boolean notifyOnRetransmit) {
        this.notifyOnRetransmit = notifyOnRetransmit;
    }

    /**
     * @return the notifyOnRetransmit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.068 -0500", hash_original_method = "27ED93829BD70EC80C4ABB0868670759", hash_generated_method = "0EB80BE7FF1F58BF9A16CEF82D510702")
    
public boolean isNotifyOnRetransmit() {
        return notifyOnRetransmit;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:29.071 -0500", hash_original_method = "E7190C5FA03F5363EA136DFEC0492C73", hash_generated_method = "94CD9310101FC536FDF493096AEB5261")
    
public void alertIfStillInCallingStateBy(int count) {
        this.timeoutIfStillInCallingState = true;
        this.callingStateTimeoutCount = count;
    }
    
    public class TransactionTimer extends SIPStackTimerTask {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.958 -0500", hash_original_method = "7764BAFD5C7951E95371726125E892CE", hash_generated_method = "EEE3315EAAAE14F533BDF577209D76E6")
        
public TransactionTimer() {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:28.963 -0500", hash_original_method = "0968D865D1ED49C59C7D505E50E4DC62", hash_generated_method = "E2ED4187AC291A42C6E128BC0393CFC7")
        
protected void runTask() {
            SIPClientTransaction clientTransaction;
            SIPTransactionStack sipStack;
            clientTransaction = SIPClientTransaction.this;
            sipStack = clientTransaction.sipStack;

            // If the transaction has terminated,
            if (clientTransaction.isTerminated()) {

                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logDebug(
                            "removing  = " + clientTransaction + " isReliable "
                                    + clientTransaction.isReliable());
                }

                sipStack.removeTransaction(clientTransaction);

                try {
                    this.cancel();

                } catch (IllegalStateException ex) {
                    if (!sipStack.isAlive())
                        return;
                }

                // Client transaction terminated. Kill connection if
                // this is a TCP after the linger timer has expired.
                // The linger timer is needed to allow any pending requests to
                // return responses.
                if ((!sipStack.cacheClientConnections) && clientTransaction.isReliable()) {

                    int newUseCount = --clientTransaction.getMessageChannel().useCount;
                    if (newUseCount <= 0) {
                        // Let the connection linger for a while and then close
                        // it.
                        TimerTask myTimer = new LingerTimer();
                        sipStack.getTimer().schedule(myTimer,
                                SIPTransactionStack.CONNECTION_LINGER_TIME * 1000);
                    }

                } else {
                    // Cache the client connections so dont close the
                    // connection. This keeps the connection open permanently
                    // until the client disconnects.
                    if (sipStack.isLoggingEnabled() && clientTransaction.isReliable()) {
                       	int useCount = clientTransaction.getMessageChannel().useCount;
                       	if (sipStack.isLoggingEnabled())
                       		sipStack.getStackLogger().logDebug("Client Use Count = " + useCount);
                    }
                }

            } else {
                // If this transaction has not
                // terminated,
                // Fire the transaction timer.
                clientTransaction.fireTimer();

            }

        }
        
    }
    
}

