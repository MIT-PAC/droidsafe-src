/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Conditions Of Use
 *
 * This software was developed by employees of the National Institute of
 * Standards and Technology (NIST), an agency of the Federal Government.
 * Pursuant to title 15 Untied States Code Section 105, works of NIST
 * employees are not subject to copyright protection in the United States
 * and are considered to be in the public domain.  As a result, a formal
 * license is not needed to use the software.
 *
 * This software is provided by NIST as a service and is expressly
 * provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
 * OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
 * AND DATA ACCURACY.  NIST does not warrant or make any representations
 * regarding the use of the software or the results thereof, including but
 * not limited to the correctness, accuracy, reliability or usefulness of
 * the software.
 *
 * Permission to use this software is contingent upon your acceptance
 * of the terms of this agreement
 *
 * .
 *
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.ServerTransactionExt;
import gov.nist.javax.sip.SipProviderImpl;
import gov.nist.javax.sip.Utils;
import gov.nist.javax.sip.header.Expires;
import gov.nist.javax.sip.header.ParameterNames;
import gov.nist.javax.sip.header.RSeq;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;

import java.io.IOException;
import java.text.ParseException;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import javax.sip.Dialog;
import javax.sip.DialogState;
import javax.sip.DialogTerminatedEvent;
import javax.sip.ObjectInUseException;
import javax.sip.SipException;
import javax.sip.Timeout;
import javax.sip.TimeoutEvent;
import javax.sip.TransactionState;
import javax.sip.address.Hop;
import javax.sip.header.ContactHeader;
import javax.sip.header.ExpiresHeader;
import javax.sip.header.RSeqHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

public class SIPServerTransaction extends SIPTransaction implements ServerRequestInterface, javax.sip.ServerTransaction, ServerTransactionExt {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.015 -0500", hash_original_field = "963497B974E6F672E401E618EFCAAE43", hash_generated_field = "28502708C76D5DD6019AE19DD6820CAF")

    private int rseqNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.018 -0500", hash_original_field = "C983F8C9ADEED1FC926FE34D21877C06", hash_generated_field = "A6B60CB65DFBA45F2F3BF0217AB058D0")

    // Real RequestInterface to pass messages to
    private transient ServerRequestInterface requestOf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.021 -0500", hash_original_field = "02FEFC12EE952EA6E5826E0F4F66B973", hash_generated_field = "EB87748E422C08A91C21F30B889B25BC")

    private SIPDialog dialog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.024 -0500", hash_original_field = "F4C36CF5FA2B60E34573E3239C723E95", hash_generated_field = "1B65F4A63DBF291C8551F347E58C0645")

    private SIPResponse pendingReliableResponse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.027 -0500", hash_original_field = "D35D7575941299C7F53E9C3E2A8E299F", hash_generated_field = "F641CCD030A30F9AE3D3689D9113DD0E")

    private ProvisionalResponseTask provisionalResponseTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.030 -0500", hash_original_field = "A447BBE13E6CCA100D3DC92F9F2AB00F", hash_generated_field = "098BFE37ADED63A73A471007C93A0B9D")

    private boolean retransmissionAlertEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.033 -0500", hash_original_field = "9C5097851259C440BEA556FB875E2231", hash_generated_field = "8C7266D76A37BFC3977933B6EEA4448F")

    private RetransmissionAlertTimerTask retransmissionAlertTimerTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.036 -0500", hash_original_field = "275A7326232C7A15DA899690557CC9F0", hash_generated_field = "E5126B373C1F848FEA63F5658E5B5C6A")

    protected boolean isAckSeen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.038 -0500", hash_original_field = "1D32B297FCB0B06AB5588805F05D2EE8", hash_generated_field = "7878146F4B75217C90AD253031C2AB2F")

    private SIPClientTransaction pendingSubscribeTransaction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.041 -0500", hash_original_field = "E2F0CD0E25F7FD599B21D877A1759BD5", hash_generated_field = "BE6AC6CBDC82F6C7D74085E5CA0E7140")

    private SIPServerTransaction inviteTransaction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.043 -0500", hash_original_field = "8FC152EF8C5F0FAF2AE9577CAE28AD60", hash_generated_field = "D0DC33FA09DF277419E9D78A6DADBDC8")
    
    private Semaphore provisionalResponseSem = new Semaphore(1);

    /**
     * Creates a new server transaction.
     *
     * @param sipStack Transaction stack this transaction belongs to.
     * @param newChannelToUse Channel to encapsulate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.115 -0500", hash_original_method = "D29C36EF10CFF1709E916D648669409B", hash_generated_method = "C2F9DD9B3DC779CA372B2275183CC9ED")
    
protected SIPServerTransaction(SIPTransactionStack sipStack, MessageChannel newChannelToUse) {

        super(sipStack, newChannelToUse);

        if (sipStack.maxListenerResponseTime != -1) {
            sipStack.getTimer().schedule(new ListenerExecutionMaxTimer(),
                    sipStack.maxListenerResponseTime * 1000);
        }

        this.rseqNumber = (int) (Math.random() * 1000);
        // Only one outstanding request for a given server tx.

        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("Creating Server Transaction" + this.getBranchId());
            sipStack.getStackLogger().logStackTrace();
        }

    }

    /**
     * Send a response.
     *
     * @param transactionResponse -- the response to send
     *
     */

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.111 -0500", hash_original_method = "05CFFFBF5E08267473584C7C9C8831C7", hash_generated_method = "58824DA46BB8DAB7F26513A055B540C8")
    
private void sendResponse(SIPResponse transactionResponse) throws IOException {

        try {
            // RFC18.2.2. Sending Responses
            // The server transport uses the value of the top Via header field
            // in
            // order
            // to determine where to send a response.
            // It MUST follow the following process:
            // If the "sent-protocol" is a reliable transport
            // protocol such as TCP or SCTP,
            // or TLS over those, the response MUST be
            // sent using the existing connection
            // to the source of the original request
            // that created the transaction, if that connection is still open.
            if (isReliable()) {

                getMessageChannel().sendMessage(transactionResponse);

                // TODO If that connection attempt fails, the server SHOULD
                // use SRV 3263 procedures
                // for servers in order to determine the IP address
                // and port to open the connection and send the response to.

            } else {
                Via via = transactionResponse.getTopmostVia();
                String transport = via.getTransport();
                if (transport == null)
                    throw new IOException("missing transport!");
                // @@@ hagai Symmetric NAT support
                int port = via.getRPort();
                if (port == -1)
                    port = via.getPort();
                if (port == -1) {
                    if (transport.equalsIgnoreCase("TLS"))
                        port = 5061;
                    else
                        port = 5060;
                }

                // Otherwise, if the Via header field value contains a
                // "maddr" parameter, the response MUST be forwarded to
                // the address listed there, using the port indicated in
                // "sent-by",
                // or port 5060 if none is present. If the address is a
                // multicast
                // address, the response SHOULD be sent using
                // the TTL indicated in the "ttl" parameter, or with a
                // TTL of 1 if that parameter is not present.
                String host = null;
                if (via.getMAddr() != null) {
                    host = via.getMAddr();
                } else {
                    // Otherwise (for unreliable unicast transports),
                    // if the top Via has a "received" parameter, the response
                    // MUST
                    // be sent to the
                    // address in the "received" parameter, using the port
                    // indicated
                    // in the
                    // "sent-by" value, or using port 5060 if none is specified
                    // explicitly.
                    host = via.getParameter(Via.RECEIVED);
                    if (host == null) {
                        // Otherwise, if it is not receiver-tagged, the response
                        // MUST be
                        // sent to the address indicated by the "sent-by" value,
                        // using the procedures in Section 5
                        // RFC 3263 PROCEDURE TO BE DONE HERE
                        host = via.getHost();
                    }
                }

                Hop hop = sipStack.addressResolver.resolveAddress(new HopImpl(host, port,
                        transport));

                MessageChannel messageChannel = ((SIPTransactionStack) getSIPStack())
                        .createRawMessageChannel(this.getSipProvider().getListeningPoint(
                                hop.getTransport()).getIPAddress(), this.getPort(), hop);
                if (messageChannel != null)
                    messageChannel.sendMessage(transactionResponse);
                else
                    throw new IOException("Could not create a message channel for " + hop);

            }
        } finally {
            this.startTransactionTimer();
        }
    }

    /**
     * Sets the real RequestInterface this transaction encapsulates.
     *
     * @param newRequestOf RequestInterface to send messages to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.118 -0500", hash_original_method = "D3B4FF5E31929A9875E21530A6B99142", hash_generated_method = "21F58B246D891E34D6E83D7C68BBAC65")
    
public void setRequestInterface(ServerRequestInterface newRequestOf) {

        requestOf = newRequestOf;

    }

    /**
     * Returns this transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.120 -0500", hash_original_method = "BE06A4E585FD9A272717267C4A83F5CF", hash_generated_method = "0F266B709485A4ED00FA7B8DDF20021C")
    
public MessageChannel getResponseChannel() {

        return this;

    }
    
    /**
     * Determines if the message is a part of this transaction.
     *
     * @param messageToTest Message to check if it is part of this transaction.
     *
     * @return True if the message is part of this transaction, false if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.125 -0500", hash_original_method = "EE01791F9851138F67FFB678FE608E3C", hash_generated_method = "160069AE6A9F566D6F3EF4CBBCB5DC16")
    
public boolean isMessagePartOfTransaction(SIPMessage messageToTest) {

        // List of Via headers in the message to test
        ViaList viaHeaders;
        // Topmost Via header in the list
        Via topViaHeader;
        // Branch code in the topmost Via header
        String messageBranch;
        // Flags whether the select message is part of this transaction
        boolean transactionMatches;

        transactionMatches = false;

        String method = messageToTest.getCSeq().getMethod();
        // Invite Server transactions linger in the terminated state in the
        // transaction
        // table and are matched to compensate for
        // http://bugs.sipit.net/show_bug.cgi?id=769
        if ((method.equals(Request.INVITE) || !isTerminated())) {

            // Get the topmost Via header and its branch parameter
            viaHeaders = messageToTest.getViaHeaders();
            if (viaHeaders != null) {

                topViaHeader = (Via) viaHeaders.getFirst();
                messageBranch = topViaHeader.getBranch();
                if (messageBranch != null) {

                    // If the branch parameter exists but
                    // does not start with the magic cookie,
                    if (!messageBranch.toLowerCase().startsWith(
                            SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)) {

                        // Flags this as old
                        // (RFC2543-compatible) client
                        // version
                        messageBranch = null;

                    }

                }

                // If a new branch parameter exists,
                if (messageBranch != null && this.getBranch() != null) {
                    if (method.equals(Request.CANCEL)) {
                        // Cancel is handled as a special case because it
                        // shares the same same branch id of the invite
                        // that it is trying to cancel.
                        transactionMatches = this.getMethod().equals(Request.CANCEL)
                                && getBranch().equalsIgnoreCase(messageBranch)
                                && topViaHeader.getSentBy().equals(
                                        ((Via) getOriginalRequest().getViaHeaders().getFirst())
                                                .getSentBy());

                    } else {
                        // Matching server side transaction with only the
                        // branch parameter.
                        transactionMatches = getBranch().equalsIgnoreCase(messageBranch)
                                && topViaHeader.getSentBy().equals(
                                        ((Via) getOriginalRequest().getViaHeaders().getFirst())
                                                .getSentBy());

                    }

                } else {
                    // This is an RFC2543-compliant message; this code is here
                    // for backwards compatibility.
                    // It is a weak check.
                    // If RequestURI, To tag, From tag, CallID, CSeq number, and
                    // top Via headers are the same, the
                    // SIPMessage matches this transaction. An exception is for
                    // a CANCEL request, which is not deemed
                    // to be part of an otherwise-matching INVITE transaction.
                    String originalFromTag = super.fromTag;

                    String thisFromTag = messageToTest.getFrom().getTag();

                    boolean skipFrom = (originalFromTag == null || thisFromTag == null);

                    String originalToTag = super.toTag;

                    String thisToTag = messageToTest.getTo().getTag();

                    boolean skipTo = (originalToTag == null || thisToTag == null);
                    boolean isResponse = (messageToTest instanceof SIPResponse);
                    // Issue #96: special case handling for a CANCEL request -
                    // the CSeq method of the original request must
                    // be CANCEL for it to have a chance at matching.
                    if (messageToTest.getCSeq().getMethod().equalsIgnoreCase(Request.CANCEL)
                            && !getOriginalRequest().getCSeq().getMethod().equalsIgnoreCase(
                                    Request.CANCEL)) {
                        transactionMatches = false;
                    } else if ((isResponse || getOriginalRequest().getRequestURI().equals(
                            ((SIPRequest) messageToTest).getRequestURI()))
                            && (skipFrom || originalFromTag != null && originalFromTag.equalsIgnoreCase(thisFromTag))
                            && (skipTo || originalToTag != null && originalToTag.equalsIgnoreCase(thisToTag))
                            && getOriginalRequest().getCallId().getCallId().equalsIgnoreCase(
                                    messageToTest.getCallId().getCallId())
                            && getOriginalRequest().getCSeq().getSeqNumber() == messageToTest
                                    .getCSeq().getSeqNumber()
                            && ((!messageToTest.getCSeq().getMethod().equals(Request.CANCEL)) || getOriginalRequest()
                                    .getMethod().equals(messageToTest.getCSeq().getMethod()))
                            && topViaHeader.equals(getOriginalRequest().getViaHeaders()
                                    .getFirst())) {

                        transactionMatches = true;
                    }

                }

            }

        }
        return transactionMatches;

    }

    /**
     * Send out a trying response (only happens when the transaction is mapped). Otherwise the
     * transaction is not known to the stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.128 -0500", hash_original_method = "6CCC5EFA22CA085040CD9EF339EE900B", hash_generated_method = "3514BA2F00721A401864AF704468CAD9")
    
protected void map() {
        // note that TRYING is a pseudo-state for invite transactions

        TransactionState realState = getRealState();

        if (realState == null || realState == TransactionState.TRYING) {
            // JvB: Removed the condition 'dialog!=null'. Trying should also
            // be
            // sent by intermediate proxies. This fixes some TCK tests
            // null check added as the stack may be stopped.
            if (isInviteTransaction() && !this.isMapped && sipStack.getTimer() != null) {
                this.isMapped = true;
                // Schedule a timer to fire in 200 ms if the
                // TU did not send a trying in that time.
                sipStack.getTimer().schedule(new SendTrying(), 200);

            } else {
                isMapped = true;
            }
        }

        // Pull it out of the pending transactions list.
        sipStack.removePendingTransaction(this);
    }

    /**
     * Return true if the transaction is known to stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.131 -0500", hash_original_method = "7F46EDF7DD1A49A585957DF512054145", hash_generated_method = "C596EE2D8B85408E720192458559F297")
    
public boolean isTransactionMapped() {
        return this.isMapped;
    }

    /**
     * Process a new request message through this transaction. If necessary, this message will
     * also be passed onto the TU.
     *
     * @param transactionRequest Request to process.
     * @param sourceChannel Channel that received this message.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.136 -0500", hash_original_method = "56FAA78069677544853324F6F2B799B6", hash_generated_method = "216A2132B4FB2F46B568765550051767")
    
public void processRequest(SIPRequest transactionRequest, MessageChannel sourceChannel) {
        boolean toTu = false;

        // Can only process a single request directed to the
        // transaction at a time. For a given server transaction
        // the listener sees only one event at a time.

        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("processRequest: " + transactionRequest.getFirstLine());
            sipStack.getStackLogger().logDebug("tx state = " + this.getRealState());
        }

        try {

            // If this is the first request for this transaction,
            if (getRealState() == null) {
                // Save this request as the one this
                // transaction is handling
                setOriginalRequest(transactionRequest);
                this.setState(TransactionState.TRYING);
                toTu = true;
                this.setPassToListener();

                // Rsends the TRYING on retransmission of the request.
                if (isInviteTransaction() && this.isMapped) {
                    // JvB: also
                    // proxies need
                    // to do this

                    // Has side-effect of setting
                    // state to "Proceeding"
                    sendMessage(transactionRequest.createResponse(100, "Trying"));

                }
                // If an invite transaction is ACK'ed while in
                // the completed state,
            } else if (isInviteTransaction() && TransactionState.COMPLETED == getRealState()
                    && transactionRequest.getMethod().equals(Request.ACK)) {

                // @jvB bug fix
                this.setState(TransactionState.CONFIRMED);
                disableRetransmissionTimer();
                if (!isReliable()) {
                    enableTimeoutTimer(TIMER_I);

                } else {

                    this.setState(TransactionState.TERMINATED);

                }

                // JvB: For the purpose of testing a TI, added a property to
                // pass it anyway
                if (sipStack.isNon2XXAckPassedToListener()) {
                    // This is useful for test applications that want to see
                    // all messages.
                    requestOf.processRequest(transactionRequest, this);
                } else {
                    // According to RFC3261 Application should not Ack in
                    // CONFIRMED state
                    if (sipStack.isLoggingEnabled()) {
                        sipStack.getStackLogger().logDebug("ACK received for server Tx "
                                + this.getTransactionId() + " not delivering to application!");

                    }

                    this.semRelease();
                }
                return;

                // If we receive a retransmission of the original
                // request,
            } else if (transactionRequest.getMethod().equals(getOriginalRequest().getMethod())) {

                if (TransactionState.PROCEEDING == getRealState()
                        || TransactionState.COMPLETED == getRealState()) {
                    this.semRelease();
                    // Resend the last response to
                    // the client
                    if (lastResponse != null) {

                        // Send the message to the client
                        super.sendMessage(lastResponse);

                    }
                } else if (transactionRequest.getMethod().equals(Request.ACK)) {
                    // This is passed up to the TU to suppress
                    // retransmission of OK
                    if (requestOf != null)
                        requestOf.processRequest(transactionRequest, this);
                    else
                        this.semRelease();
                }
                if (sipStack.isLoggingEnabled())
                	sipStack.getStackLogger().logDebug("completed processing retransmitted request : "
                        + transactionRequest.getFirstLine() + this + " txState = "
                        + this.getState() + " lastResponse = " + this.getLastResponse());
                return;

            }

            // Pass message to the TU
            if (TransactionState.COMPLETED != getRealState()
                    && TransactionState.TERMINATED != getRealState() && requestOf != null) {
                if (getOriginalRequest().getMethod().equals(transactionRequest.getMethod())) {
                    // Only send original request to TU once!
                    if (toTu) {
                        requestOf.processRequest(transactionRequest, this);
                    } else
                        this.semRelease();
                } else {
                    if (requestOf != null)
                        requestOf.processRequest(transactionRequest, this);
                    else
                        this.semRelease();
                }
            } else {
                // This seems like a common bug so I am allowing it through!
                if (((SIPTransactionStack) getSIPStack()).isDialogCreated(getOriginalRequest()
                        .getMethod())
                        && getRealState() == TransactionState.TERMINATED
                        && transactionRequest.getMethod().equals(Request.ACK)
                        && requestOf != null) {
                    SIPDialog thisDialog = (SIPDialog) this.dialog;

                    if (thisDialog == null || !thisDialog.ackProcessed) {
                        // Filter out duplicate acks
                        if (thisDialog != null) {
                            thisDialog.ackReceived(transactionRequest);
                            thisDialog.ackProcessed = true;
                        }
                        requestOf.processRequest(transactionRequest, this);
                    } else {
                        this.semRelease();
                    }

                } else if (transactionRequest.getMethod().equals(Request.CANCEL)) {
                    if (sipStack.isLoggingEnabled())
                        sipStack.getStackLogger().logDebug("Too late to cancel Transaction");
                    this.semRelease();
                    // send OK and just ignore the CANCEL.
                    try {
                        this.sendMessage(transactionRequest.createResponse(Response.OK));
                    } catch (IOException ex) {
                        // Transaction is already terminated
                        // just ignore the IOException.
                    }
                }
                if (sipStack.isLoggingEnabled())
                	sipStack.getStackLogger().logDebug("Dropping request " + getRealState());
            }

        } catch (IOException e) {
        	if (sipStack.isLoggingEnabled())
        		sipStack.getStackLogger().logError("IOException " ,e);
            this.semRelease();
            this.raiseIOExceptionEvent();
        }

    }

    /**
     * Send a response message through this transactionand onto the client. The response drives
     * the state machine.
     *
     * @param messageToSend Response to process and send.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.143 -0500", hash_original_method = "2B73C982341966F86ADBEA04AC7851BC", hash_generated_method = "63B9ABBDB20CA604885970E2FA4A29CD")
    
public void sendMessage(SIPMessage messageToSend) throws IOException {
        try {
            // Message typecast as a response
            SIPResponse transactionResponse;
            // Status code of the response being sent to the client
            int statusCode;

            // Get the status code from the response
            transactionResponse = (SIPResponse) messageToSend;
            statusCode = transactionResponse.getStatusCode();

            try {
                // Provided we have set the banch id for this we set the BID for
                // the
                // outgoing via.
                if (this.getOriginalRequest().getTopmostVia().getBranch() != null)
                    transactionResponse.getTopmostVia().setBranch(this.getBranch());
                else
                    transactionResponse.getTopmostVia().removeParameter(ParameterNames.BRANCH);

                // Make the topmost via headers match identically for the
                // transaction rsponse.
                if (!this.getOriginalRequest().getTopmostVia().hasPort())
                    transactionResponse.getTopmostVia().removePort();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            // Method of the response does not match the request used to
            // create the transaction - transaction state does not change.
            if (!transactionResponse.getCSeq().getMethod().equals(
                    getOriginalRequest().getMethod())) {
                sendResponse(transactionResponse);
                return;
            }

            // If the TU sends a provisional response while in the
            // trying state,

            if (getRealState() == TransactionState.TRYING) {
                if (statusCode / 100 == 1) {
                    this.setState(TransactionState.PROCEEDING);
                } else if (200 <= statusCode && statusCode <= 699) {
                    // INVITE ST has TRYING as a Pseudo state
                    // (See issue 76). We are using the TRYING
                    // pseudo state invite Transactions
                    // to signal if the application
                    // has sent trying or not and hence this
                    // check is necessary.
                    if (!isInviteTransaction()) {
                        if (!isReliable()) {
                            // Linger in the completed state to catch
                            // retransmissions if the transport is not
                            // reliable.
                            this.setState(TransactionState.COMPLETED);
                            // Note that Timer J is only set for Unreliable
                            // transports -- see Issue 75.
                            /*
                             * From RFC 3261 Section 17.2.2 (non-invite server transaction)
                             *
                             * When the server transaction enters the "Completed" state, it MUST
                             * set Timer J to fire in 64*T1 seconds for unreliable transports, and
                             * zero seconds for reliable transports. While in the "Completed"
                             * state, the server transaction MUST pass the final response to the
                             * transport layer for retransmission whenever a retransmission of the
                             * request is received. Any other final responses passed by the TU to
                             * the server transaction MUST be discarded while in the "Completed"
                             * state. The server transaction remains in this state until Timer J
                             * fires, at which point it MUST transition to the "Terminated" state.
                             */
                            enableTimeoutTimer(TIMER_J);
                        } else {
                            this.setState(TransactionState.TERMINATED);
                        }
                    } else {
                        // This is the case for INVITE server transactions.
                        // essentially, it duplicates the code in the
                        // PROCEEDING case below. There is no TRYING state for INVITE
                        // transactions in the RFC. We are using it to signal whether the
                        // application has sent a provisional response or not. Hence
                        // this is treated the same as as Proceeding.
                        if (statusCode / 100 == 2) {
                            // Status code is 2xx means that the
                            // transaction transitions to TERMINATED
                            // for both Reliable as well as unreliable
                            // transports. Note that the dialog layer
                            // takes care of retransmitting 2xx final
                            // responses.
                            /*
                             * RFC 3261 Section 13.3.1.4 Note, however, that the INVITE server
                             * transaction will be destroyed as soon as it receives this final
                             * response and passes it to the transport. Therefore, it is necessary
                             * to periodically pass the response directly to the transport until
                             * the ACK arrives. The 2xx response is passed to the transport with
                             * an interval that starts at T1 seconds and doubles for each
                             * retransmission until it reaches T2 seconds (T1 and T2 are defined
                             * in Section 17). Response retransmissions cease when an ACK request
                             * for the response is received. This is independent of whatever
                             * transport protocols are used to send the response.
                             */
                            this.disableRetransmissionTimer();
                            this.disableTimeoutTimer();
                            this.collectionTime = TIMER_J;
                            this.setState(TransactionState.TERMINATED);
                            if (this.dialog != null)
                                this.dialog.setRetransmissionTicks();
                        } else {
                            // This an error final response.
                            this.setState(TransactionState.COMPLETED);
                            if (!isReliable()) {
                                /*
                                 * RFC 3261
                                 *
                                 * While in the "Proceeding" state, if the TU passes a response
                                 * with status code from 300 to 699 to the server transaction, the
                                 * response MUST be passed to the transport layer for
                                 * transmission, and the state machine MUST enter the "Completed"
                                 * state. For unreliable transports, timer G is set to fire in T1
                                 * seconds, and is not set to fire for reliable transports.
                                 */

                                enableRetransmissionTimer();

                            }
                            enableTimeoutTimer(TIMER_H);
                        }
                    }

                }

                // If the transaction is in the proceeding state,
            } else if (getRealState() == TransactionState.PROCEEDING) {

                if (isInviteTransaction()) {

                    // If the response is a failure message,
                    if (statusCode / 100 == 2) {
                        // Set up to catch returning ACKs
                        // The transaction lingers in the
                        // terminated state for some time
                        // to catch retransmitted INVITEs
                        this.disableRetransmissionTimer();
                        this.disableTimeoutTimer();
                        this.collectionTime = TIMER_J;
                        this.setState(TransactionState.TERMINATED);
                        if (this.dialog != null)
                            this.dialog.setRetransmissionTicks();

                    } else if (300 <= statusCode && statusCode <= 699) {

                        // Set up to catch returning ACKs
                        this.setState(TransactionState.COMPLETED);
                        if (!isReliable()) {
                            /*
                             * While in the "Proceeding" state, if the TU passes a response with
                             * status code from 300 to 699 to the server transaction, the response
                             * MUST be passed to the transport layer for transmission, and the
                             * state machine MUST enter the "Completed" state. For unreliable
                             * transports, timer G is set to fire in T1 seconds, and is not set to
                             * fire for reliable transports.
                             */

                            enableRetransmissionTimer();

                        }
                        enableTimeoutTimer(TIMER_H);

                    }

                    // If the transaction is not an invite transaction
                    // and this is a final response,
                } else if (200 <= statusCode && statusCode <= 699) {
                    // This is for Non-invite server transactions.

                    // Set up to retransmit this response,
                    // or terminate the transaction
                    this.setState(TransactionState.COMPLETED);
                    if (!isReliable()) {

                        disableRetransmissionTimer();
                        enableTimeoutTimer(TIMER_J);

                    } else {

                        this.setState(TransactionState.TERMINATED);

                    }

                }

                // If the transaction has already completed,
            } else if (TransactionState.COMPLETED == this.getRealState()) {

                return;
            }

            try {
                // Send the message to the client.
                // Record the last message sent out.
                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logDebug(
                            "sendMessage : tx = " + this + " getState = " + this.getState());
                }
                lastResponse = transactionResponse;
                this.sendResponse(transactionResponse);

            } catch (IOException e) {

                this.setState(TransactionState.TERMINATED);
                this.collectionTime = 0;
                throw e;

            }
        } finally {
            this.startTransactionTimer();
        }

    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.146 -0500", hash_original_method = "57D57213185EECDD5D38603D59833E46", hash_generated_method = "A70FDC2F6464B9B3774E51CBE10C1AD0")
    
public String getViaHost() {

        return getMessageChannel().getViaHost();

    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.149 -0500", hash_original_method = "AE83C408493AD4624CBF388A7C2A34C7", hash_generated_method = "4DE4E4B89E54F9033F5751611FA22907")
    
public int getViaPort() {

        return getMessageChannel().getViaPort();

    }

    /**
     * Called by the transaction stack when a retransmission timer fires. This retransmits the
     * last response when the retransmission filter is enabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.152 -0500", hash_original_method = "E1523787F7609795EF3E130FC3FDDFF0", hash_generated_method = "6C0D31C155D5B9A6CE5EB79BF44C1A6B")
    
protected void fireRetransmissionTimer() {

        try {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("fireRetransmissionTimer() -- ");
            }
            // Resend the last response sent by this transaction
            if (isInviteTransaction() && lastResponse != null) {
                // null can happen if this is terminating when the timer fires.
                if (!this.retransmissionAlertEnabled || sipStack.isTransactionPendingAck(this) ) {
                    // Retransmit last response until ack.
                    if (lastResponse.getStatusCode() / 100 > 2 && !this.isAckSeen)
                        super.sendMessage(lastResponse);
                } else {
                    // alert the application to retransmit the last response
                    SipProviderImpl sipProvider = (SipProviderImpl) this.getSipProvider();
                    TimeoutEvent txTimeout = new TimeoutEvent(sipProvider, this,
                            Timeout.RETRANSMIT);
                    sipProvider.handleEvent(txTimeout, this);
                }

            }
        } catch (IOException e) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logException(e);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);

        }

    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.155 -0500", hash_original_method = "0BCA3A7152B5F6366E7B8E296683796F", hash_generated_method = "67A050C3B1EE539A0EB15B41B4BC4A5F")
    
private void fireReliableResponseRetransmissionTimer() {
        try {

            super.sendMessage(this.pendingReliableResponse);

        } catch (IOException e) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logException(e);
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);

        }
    }

    /**
     * Called by the transaction stack when a timeout timer fires.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.159 -0500", hash_original_method = "5968CF2AF2A16738BF27A6383A99288B", hash_generated_method = "9F3213A87FABDFF7CE0416771E73B4C1")
    
protected void fireTimeoutTimer() {

        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("SIPServerTransaction.fireTimeoutTimer this = " + this
                    + " current state = " + this.getRealState() + " method = "
                    + this.getOriginalRequest().getMethod());

        if ( this.getMethod().equals(Request.INVITE) && sipStack.removeTransactionPendingAck(this) ) {
            if ( sipStack.isLoggingEnabled() ) {
                sipStack.getStackLogger().logDebug("Found tx pending ACK - returning");
            }
            return;
            
        }
        SIPDialog dialog = (SIPDialog) this.dialog;
        if (((SIPTransactionStack) getSIPStack()).isDialogCreated(this.getOriginalRequest()
                .getMethod())
                && (TransactionState.CALLING == this.getRealState() || TransactionState.TRYING == this
                        .getRealState())) {
            dialog.setState(SIPDialog.TERMINATED_STATE);
        } else if (getOriginalRequest().getMethod().equals(Request.BYE)) {
            if (dialog != null && dialog.isTerminatedOnBye())
                dialog.setState(SIPDialog.TERMINATED_STATE);
        }

        if (TransactionState.COMPLETED == this.getRealState() && isInviteTransaction()) {
            raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
            this.setState(TransactionState.TERMINATED);
            sipStack.removeTransaction(this);

        } else if (TransactionState.COMPLETED == this.getRealState() && !isInviteTransaction()) {
            this.setState(TransactionState.TERMINATED);
            sipStack.removeTransaction(this);

        } else if (TransactionState.CONFIRMED == this.getRealState() && isInviteTransaction()) {
            // TIMER_I should not generate a timeout
            // exception to the application when the
            // Invite transaction is in Confirmed state.
            // Just transition to Terminated state.
            this.setState(TransactionState.TERMINATED);
            sipStack.removeTransaction(this);
        } else if (!isInviteTransaction()
                && (TransactionState.COMPLETED == this.getRealState() || TransactionState.CONFIRMED == this
                        .getRealState())) {
            this.setState(TransactionState.TERMINATED);
        } else if (isInviteTransaction() && TransactionState.TERMINATED == this.getRealState()) {
            // This state could be reached when retransmitting

            raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
            if (dialog != null)
                dialog.setState(SIPDialog.TERMINATED_STATE);
        }

    }

    /**
     * Get the last response.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.162 -0500", hash_original_method = "025E14F038A1EDFF743C73F970E03870", hash_generated_method = "E4142FBCF67ABA0096A56A3990E0FF25")
    
public SIPResponse getLastResponse() {
        return this.lastResponse;
    }

    /**
     * Set the original request.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.165 -0500", hash_original_method = "2F3F0F5B57F408B788FCEFEE82B8B33E", hash_generated_method = "52D59F136EE7C17FD840FC7C5147670D")
    
public void setOriginalRequest(SIPRequest originalRequest) {
        super.setOriginalRequest(originalRequest);

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.sip.ServerTransaction#sendResponse(javax.sip.message.Response)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.171 -0500", hash_original_method = "2923FE4F478A1D65305B36AFA83919C7", hash_generated_method = "EF7B6FD11206A1F77F99601E63442206")
    
public void sendResponse(Response response) throws SipException {
        SIPResponse sipResponse = (SIPResponse) response;

        SIPDialog dialog = this.dialog;
        if (response == null)
            throw new NullPointerException("null response");

        try {
            sipResponse.checkHeaders();
        } catch (ParseException ex) {
            throw new SipException(ex.getMessage());
        }

        // check for meaningful response.
        if (!sipResponse.getCSeq().getMethod().equals(this.getMethod())) {
            throw new SipException(
                    "CSeq method does not match Request method of request that created the tx.");
        }

        /*
         * 200-class responses to SUBSCRIBE requests also MUST contain an "Expires" header. The
         * period of time in the response MAY be shorter but MUST NOT be longer than specified in
         * the request.
         */
        if (this.getMethod().equals(Request.SUBSCRIBE) && response.getStatusCode() / 100 == 2) {

            if (response.getHeader(ExpiresHeader.NAME) == null) {
                throw new SipException("Expires header is mandatory in 2xx response of SUBSCRIBE");
            } else {
                Expires requestExpires = (Expires) this.getOriginalRequest().getExpires();
                Expires responseExpires = (Expires) response.getExpires();
                /*
                 * If no "Expires" header is present in a SUBSCRIBE request, the implied default
                 * is defined by the event package being used.
                 */
                if (requestExpires != null
                        && responseExpires.getExpires() > requestExpires.getExpires()) {
                    throw new SipException(
                            "Response Expires time exceeds request Expires time : See RFC 3265 3.1.1");
                }
            }

        }

        // Check for mandatory header.
        if (sipResponse.getStatusCode() == 200
                && sipResponse.getCSeq().getMethod().equals(Request.INVITE)
                && sipResponse.getHeader(ContactHeader.NAME) == null)
            throw new SipException("Contact Header is mandatory for the OK to the INVITE");

        if (!this.isMessagePartOfTransaction((SIPMessage) response)) {
            throw new SipException("Response does not belong to this transaction.");
        }

        // Fix up the response if the dialog has already been established.
        try {
            /*
             * The UAS MAY send a final response to the initial request before
             * having received PRACKs for all unacknowledged reliable provisional responses,
             * unless the final response is 2xx and any of the unacknowledged reliable provisional
             * responses contained a session description. In that case, it MUST NOT send a final
             * response until those provisional responses are acknowledged.
             */
            if (this.pendingReliableResponse != null
                    && this.getDialog() != null 
                    && this.getState() != TransactionState.TERMINATED
                    && ((SIPResponse)response).getContentTypeHeader() != null 
                    && response.getStatusCode() / 100 == 2
                    && ((SIPResponse)response).getContentTypeHeader().getContentType()
                            .equalsIgnoreCase("application")
                    && ((SIPResponse)response).getContentTypeHeader().getContentSubType()
                            .equalsIgnoreCase("sdp")) {
                try {
                    boolean acquired = this.provisionalResponseSem.tryAcquire(1,TimeUnit.SECONDS);
                    if (!acquired ) {
                        throw new SipException("cannot send response -- unacked povisional");
                    }
                } catch (Exception ex) {
                    this.sipStack.getStackLogger().logError("Could not acquire PRACK sem ", ex);
                }
            } else {
                // Sending the final response cancels the
                // pending response task.
                if (this.pendingReliableResponse != null && sipResponse.isFinalResponse()) {
                    this.provisionalResponseTask.cancel();
                    this.provisionalResponseTask = null;
                }
            }

            // Dialog checks. These make sure that the response
            // being sent makes sense.
            if (dialog != null) {
                if (sipResponse.getStatusCode() / 100 == 2
                        && sipStack.isDialogCreated(sipResponse.getCSeq().getMethod())) {
                    if (dialog.getLocalTag() == null && sipResponse.getTo().getTag() == null) {
                        // Trying to send final response and user forgot to set
                        // to
                        // tag on the response -- be nice and assign the tag for
                        // the user.
                        sipResponse.getTo().setTag(Utils.getInstance().generateTag());
                    } else if (dialog.getLocalTag() != null && sipResponse.getToTag() == null) {
                        sipResponse.setToTag(dialog.getLocalTag());
                    } else if (dialog.getLocalTag() != null && sipResponse.getToTag() != null
                            && !dialog.getLocalTag().equals(sipResponse.getToTag())) {
                        throw new SipException("Tag mismatch dialogTag is "
                                + dialog.getLocalTag() + " responseTag is "
                                + sipResponse.getToTag());
                    }
                }

                if (!sipResponse.getCallId().getCallId().equals(dialog.getCallId().getCallId())) {
                    throw new SipException("Dialog mismatch!");
                }
            }

            // Backward compatibility slippery slope....
            // Only set the from tag in the response when the
            // incoming request has a from tag.
            String fromTag = ((SIPRequest) this.getRequest()).getFrom().getTag();
            if (fromTag != null && sipResponse.getFromTag() != null
                    && !sipResponse.getFromTag().equals(fromTag)) {
                throw new SipException("From tag of request does not match response from tag");
            } else if (fromTag != null) {
                sipResponse.getFrom().setTag(fromTag);
            } else {
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug("WARNING -- Null From tag in request!!");
            }

            // See if the dialog needs to be inserted into the dialog table
            // or if the state of the dialog needs to be changed.
            if (dialog != null && response.getStatusCode() != 100) {
                dialog.setResponseTags(sipResponse);
                DialogState oldState = dialog.getState();
                dialog.setLastResponse(this, (SIPResponse) response);
                if (oldState == null && dialog.getState() == DialogState.TERMINATED) {
                    DialogTerminatedEvent event = new DialogTerminatedEvent(dialog
                            .getSipProvider(), dialog);

                    // Provide notification to the listener that the dialog has
                    // ended.
                    dialog.getSipProvider().handleEvent(event, this);

                }

            } else if (dialog == null && this.getMethod().equals(Request.INVITE)
                    && this.retransmissionAlertEnabled
                    && this.retransmissionAlertTimerTask == null
                    && response.getStatusCode() / 100 == 2) {
                String dialogId = ((SIPResponse) response).getDialogId(true);

                this.retransmissionAlertTimerTask = new RetransmissionAlertTimerTask(dialogId);
                sipStack.retransmissionAlertTransactions.put(dialogId, this);
                sipStack.getTimer().schedule(this.retransmissionAlertTimerTask, 0,
                        SIPTransactionStack.BASE_TIMER_INTERVAL);

            }

            // Send message after possibly inserting the Dialog
            // into the dialog table to avoid a possible race condition.

            this.sendMessage((SIPResponse) response);
            
            if ( dialog != null ) {
                dialog.startRetransmitTimer(this, (SIPResponse)response);
            }

        } catch (IOException ex) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logException(ex);
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
            throw new SipException(ex.getMessage());
        } catch (java.text.ParseException ex1) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logException(ex1);
            this.setState(TransactionState.TERMINATED);
            throw new SipException(ex1.getMessage());
        }
    }

    /**
     * Return the book-keeping information that we actually use.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.175 -0500", hash_original_method = "094652DDD499EE6CA69CC6BEDE88479D", hash_generated_method = "A7235364D32441046E530C9F3B39BFA7")
    
private TransactionState getRealState() {
        return super.getState();
    }

    /**
     * Return the current transaction state according to the RFC 3261 transaction state machine.
     * Invite transactions do not have a trying state. We just use this as a pseudo state for
     * processing requests.
     *
     * @return the state of the transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.178 -0500", hash_original_method = "1CF9EDD0CC0B815CCCB8459FE319457E", hash_generated_method = "02478797440CC9523F07C2C49AB7D7EF")
    
public TransactionState getState() {
        // Trying is a pseudo state for INVITE transactions.
        if (this.isInviteTransaction() && TransactionState.TRYING == super.getState())
            return TransactionState.PROCEEDING;
        else
            return super.getState();
    }

    /**
     * Sets a timeout after which the connection is closed (provided the server does not use the
     * connection for outgoing requests in this time period) and calls the superclass to set
     * state.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.181 -0500", hash_original_method = "64016F2524A7B9A8D94F9FFA297FAA00", hash_generated_method = "A0D4BF22970D80FC6420EF04646B0688")
    
public void setState(TransactionState newState) {
        // Set this timer for connection caching
        // of incoming connections.
        if (newState == TransactionState.TERMINATED && this.isReliable()
                && (!getSIPStack().cacheServerConnections)) {
            // Set a time after which the connection
            // is closed.
            this.collectionTime = TIMER_J;
        }

        super.setState(newState);

    }

    /**
     * Start the timer task.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.183 -0500", hash_original_method = "058740AD5F567A2FC597464136294293", hash_generated_method = "980DF0E9E18C364226261C2853199BDC")
    
protected void startTransactionTimer() {
        if (this.transactionTimerStarted.compareAndSet(false, true)) {
        	if (sipStack.getTimer() != null) {
                // The timer is set to null when the Stack is
                // shutting down.
                TimerTask myTimer = new TransactionTimer();
                sipStack.getTimer().schedule(myTimer, BASE_TIMER_INTERVAL, BASE_TIMER_INTERVAL);
            }
        }        
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.187 -0500", hash_original_method = "169DE8D7E50E65E71C46333CC9B26BAF", hash_generated_method = "CA12B20F8D17D68CAEC2B9956BA0E4B6")
    
public boolean equals(Object other) {
        if (!other.getClass().equals(this.getClass())) {
            return false;
        }
        SIPServerTransaction sst = (SIPServerTransaction) other;
        return this.getBranch().equalsIgnoreCase(sst.getBranch());
    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nist.javax.sip.stack.SIPTransaction#getDialog()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.189 -0500", hash_original_method = "BF9D0C52E87E80DCC85E6728CE121EFC", hash_generated_method = "D0A44FFD54D208F05147B22151E1B389")
    
public Dialog getDialog() {

        return this.dialog;
    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nist.javax.sip.stack.SIPTransaction#setDialog(gov.nist.javax.sip.stack.SIPDialog,
     *      gov.nist.javax.sip.message.SIPMessage)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.192 -0500", hash_original_method = "7270FFD660AE92D45E417229D33FB869", hash_generated_method = "F643F0B4FF28D260B67672F39447B755")
    
public void setDialog(SIPDialog sipDialog, String dialogId) {
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("setDialog " + this + " dialog = " + sipDialog);
        this.dialog = sipDialog;
        if (dialogId != null)
            this.dialog.setAssigned();
        if (this.retransmissionAlertEnabled && this.retransmissionAlertTimerTask != null) {
            this.retransmissionAlertTimerTask.cancel();
            if (this.retransmissionAlertTimerTask.dialogId != null) {
                sipStack.retransmissionAlertTransactions
                        .remove(this.retransmissionAlertTimerTask.dialogId);
            }
            this.retransmissionAlertTimerTask = null;
        }

        this.retransmissionAlertEnabled = false;

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.sip.Transaction#terminate()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.196 -0500", hash_original_method = "2BF0F9BA137AD2AD36F3D6B0DBFD2123", hash_generated_method = "9EC1122B15A3EA9F27F10EDA1496C959")
    
public void terminate() throws ObjectInUseException {
        this.setState(TransactionState.TERMINATED);
        if (this.retransmissionAlertTimerTask != null) {
            this.retransmissionAlertTimerTask.cancel();
            if (retransmissionAlertTimerTask.dialogId != null) {
                this.sipStack.retransmissionAlertTransactions
                        .remove(retransmissionAlertTimerTask.dialogId);
            }
            this.retransmissionAlertTimerTask = null;

        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.200 -0500", hash_original_method = "113CF757EF1C74D90A992F25B2E0E550", hash_generated_method = "434082E526ECF99AF8F5B0757CDC0646")
    
protected void sendReliableProvisionalResponse(Response relResponse) throws SipException {

        /*
         * After the first reliable provisional response for a request has been acknowledged, the
         * UAS MAY send additional reliable provisional responses. The UAS MUST NOT send a second
         * reliable provisional response until the first is acknowledged.
         */
        if (this.pendingReliableResponse != null) {
            throw new SipException("Unacknowledged response");

        } else
            this.pendingReliableResponse = (SIPResponse) relResponse;
        /*
         * In addition, it MUST contain a Require header field containing the option tag 100rel,
         * and MUST include an RSeq header field.
         */
        RSeq rseq = (RSeq) relResponse.getHeader(RSeqHeader.NAME);
        if (relResponse.getHeader(RSeqHeader.NAME) == null) {
            rseq = new RSeq();
            relResponse.setHeader(rseq);
        }

        try {
            this.rseqNumber++;
            rseq.setSeqNumber(this.rseqNumber);

            // start the timer task which will retransmit the reliable response
            // until the PRACK is received
            this.lastResponse = (SIPResponse) relResponse;
            if ( this.getDialog() != null ) {
                boolean acquired = this.provisionalResponseSem.tryAcquire(1, TimeUnit.SECONDS);
                if (!acquired) {
                    throw new SipException("Unacknowledged response");
                }
            }
            this.sendMessage((SIPMessage) relResponse);
            this.provisionalResponseTask = new ProvisionalResponseTask();
            this.sipStack.getTimer().schedule(provisionalResponseTask, 0,
                    SIPTransactionStack.BASE_TIMER_INTERVAL);

        } catch (Exception ex) {
            InternalErrorHandler.handleException(ex);
        }

    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.203 -0500", hash_original_method = "423AF4ABBE12E54C6351754EACC47E3E", hash_generated_method = "640C2177F8D62C23EBB70FAD97BBEF3B")
    
public SIPResponse getReliableProvisionalResponse() {

        return this.pendingReliableResponse;
    }

    /**
     * Cancel the retransmit timer for the provisional response task.
     *
     * @return true if the tx has seen the prack for the first time and false otherwise.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.206 -0500", hash_original_method = "C1242B9BCB6EB14AE3EB1BD030AE911A", hash_generated_method = "4CD7309F051D89ED6524E56E7F263BA4")
    
public boolean prackRecieved() {

        if (this.pendingReliableResponse == null)
            return false;
        if(provisionalResponseTask != null)
        	this.provisionalResponseTask.cancel();
        this.pendingReliableResponse = null;
        this.provisionalResponseSem.release();
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.sip.ServerTransaction#enableRetransmissionAlerts()
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.208 -0500", hash_original_method = "DB7E38B465064167DDC1111F92777A32", hash_generated_method = "8187256C0E5C7D3DD6976CA1F483088C")
    
public void enableRetransmissionAlerts() throws SipException {
        if (this.getDialog() != null)
            throw new SipException("Dialog associated with tx");

        else if (!this.getMethod().equals(Request.INVITE))
            throw new SipException("Request Method must be INVITE");

        this.retransmissionAlertEnabled = true;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.211 -0500", hash_original_method = "9CE3EB2FC8AC208C1528F5A08B1A1A7B", hash_generated_method = "3FEF9920E0082ADF49EAB8666F04B939")
    
public boolean isRetransmissionAlertEnabled() {
        return this.retransmissionAlertEnabled;
    }

    /**
     * Disable retransmission Alerts and cancel associated timers.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.214 -0500", hash_original_method = "FAB076B51BB167F6E440B2394399BC94", hash_generated_method = "59BBC0064F6CBC3308F4AC4293159A38")
    
public void disableRetransmissionAlerts() {
        if (this.retransmissionAlertTimerTask != null && this.retransmissionAlertEnabled) {
            this.retransmissionAlertTimerTask.cancel();
            this.retransmissionAlertEnabled = false;

            String dialogId = this.retransmissionAlertTimerTask.dialogId;
            if (dialogId != null) {
                sipStack.retransmissionAlertTransactions.remove(dialogId);
            }
            this.retransmissionAlertTimerTask = null;
        }
    }

    /**
     * This is book-keeping for retransmission filter management.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.217 -0500", hash_original_method = "157974C13DCC3CB54CBF1C9A15C7B6B6", hash_generated_method = "3EFE6CF23119AD686D4ADC0A55E9E3B1")
    
public void setAckSeen() {
        this.isAckSeen = true;
    }

    /**
     * This is book-keeping for retransmission filter management.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.220 -0500", hash_original_method = "C14F76EB0E4E278210A5D612100CE915", hash_generated_method = "DEA1A3687B9F4F4915E561F3434FE6CD")
    
public boolean ackSeen() {
        return this.isAckSeen;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.223 -0500", hash_original_method = "6AEC262895B13A63B164E8F6877168F2", hash_generated_method = "49B5B16EC88CC002895E5A6ED9D73028")
    
public void setMapped(boolean b) {
        this.isMapped = true;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.226 -0500", hash_original_method = "63F9C939BCFFEC59883E0EC5005B2509", hash_generated_method = "A42948BF7D5761B0711F8ED4DB78DE63")
    
public void setPendingSubscribe(SIPClientTransaction pendingSubscribeClientTx) {
        this.pendingSubscribeTransaction = pendingSubscribeClientTx;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.228 -0500", hash_original_method = "D9515C627E3EA8CE075BBF27F52FBA55", hash_generated_method = "182E116EF9A81A19AB148BA8648AE5FE")
    
public void releaseSem() {
        if (this.pendingSubscribeTransaction != null) {
            /*
             * When a notify is being processed we take a lock on the subscribe to avoid racing
             * with the OK of the subscribe.
             */
            pendingSubscribeTransaction.releaseSem();
        } else if (this.inviteTransaction != null && this.getMethod().equals(Request.CANCEL)) {
            /*
             * When a CANCEL is being processed we take a nested lock on the associated INVITE
             * server tx.
             */
            this.inviteTransaction.releaseSem();
        }
        super.releaseSem();
    }

    /**
     * The INVITE Server Transaction corresponding to a CANCEL Server Transaction.
     *
     * @param st -- the invite server tx corresponding to the cancel server transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.231 -0500", hash_original_method = "0E2D0772A5243821270857191F448BEA", hash_generated_method = "92BDB81F921E016320661D8E99EAD0ED")
    
public void setInviteTransaction(SIPServerTransaction st) {
        this.inviteTransaction = st;

    }

    /**
     * TODO -- this method has to be added to the api.
     *
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.234 -0500", hash_original_method = "3EE4598A64A5BA68559842E002FBD20B", hash_generated_method = "FE6249DD1F26D92474994C4EBED77908")
    
public SIPServerTransaction getCanceledInviteTransaction() {
        return this.inviteTransaction;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.238 -0500", hash_original_method = "22BE30BEEA580B63CB3DAB7D5C330535", hash_generated_method = "50F329B10CAC49AC8DBBF9AA70ACFB0C")
    
public void scheduleAckRemoval() throws IllegalStateException {
        if (this.getMethod() == null || !this.getMethod().equals(Request.ACK)) {
            throw new IllegalStateException("Method is null[" + (getMethod() == null)
                    + "] or method is not ACK[" + this.getMethod() + "]");
        }

        this.startTransactionTimer();
    }
    
    class RetransmissionAlertTimerTask extends SIPStackTimerTask {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.047 -0500", hash_original_field = "6D266ECB4501DB72D6B336432EF66FBE", hash_generated_field = "6D266ECB4501DB72D6B336432EF66FBE")

        String dialogId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.050 -0500", hash_original_field = "3C1309F344AFB4C7FE9A836B7928DA16", hash_generated_field = "3C1309F344AFB4C7FE9A836B7928DA16")

        int ticks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.053 -0500", hash_original_field = "6753930BED6039429702ABCC2D7DEDDB", hash_generated_field = "6753930BED6039429702ABCC2D7DEDDB")

        int ticksLeft;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.056 -0500", hash_original_method = "D09929C71A38D835F5CB9E6FA68F0FB4", hash_generated_method = "AB378ADD83B3ECF8A369023DED75C469")
        
public RetransmissionAlertTimerTask(String dialogId) {

            this.ticks = SIPTransaction.T1;
            this.ticksLeft = this.ticks;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.059 -0500", hash_original_method = "2AF4E8E71B0B58D5A8BFD9769A90D169", hash_generated_method = "22F78BB215E49069FCABA68513DC3034")
        
protected void runTask() {
            SIPServerTransaction serverTransaction = SIPServerTransaction.this;
            ticksLeft--;
            if (ticksLeft == -1) {
                serverTransaction.fireRetransmissionTimer();
                this.ticksLeft = 2 * ticks;
            }

        }
        
    }
    
    class ProvisionalResponseTask extends SIPStackTimerTask {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.064 -0500", hash_original_field = "3C1309F344AFB4C7FE9A836B7928DA16", hash_generated_field = "3C1309F344AFB4C7FE9A836B7928DA16")

        int ticks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.067 -0500", hash_original_field = "6753930BED6039429702ABCC2D7DEDDB", hash_generated_field = "6753930BED6039429702ABCC2D7DEDDB")

        int ticksLeft;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.071 -0500", hash_original_method = "7F2BA0B0C3F62E74BA1198F711026EF0", hash_generated_method = "34587EF63F9A5126FFAB258B87B4E028")
        
public ProvisionalResponseTask() {
            this.ticks = SIPTransaction.T1;
            this.ticksLeft = this.ticks;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.075 -0500", hash_original_method = "3BA43FFA8E7EB2E8FD814B03BC519869", hash_generated_method = "E101FE8C2579F450FA67C985CF827068")
        
protected void runTask() {
            SIPServerTransaction serverTransaction = SIPServerTransaction.this;
            /*
             * The reliable provisional response is passed to the transaction layer periodically
             * with an interval that starts at T1 seconds and doubles for each retransmission (T1
             * is defined in Section 17 of RFC 3261). Once passed to the server transaction, it is
             * added to an internal list of unacknowledged reliable provisional responses. The
             * transaction layer will forward each retransmission passed from the UAS core.
             *
             * This differs from retransmissions of 2xx responses, whose intervals cap at T2
             * seconds. This is because retransmissions of ACK are triggered on receipt of a 2xx,
             * but retransmissions of PRACK take place independently of reception of 1xx.
             */
            // If the transaction has terminated,
            if (serverTransaction.isTerminated()) {

                this.cancel();

            } else {
                ticksLeft--;
                if (ticksLeft == -1) {
                    serverTransaction.fireReliableResponseRetransmissionTimer();
                    this.ticksLeft = 2 * ticks;
                    this.ticks = this.ticksLeft;
                    // timer H MUST be set to fire in 64*T1 seconds for all transports. Timer H
                    // determines when the server
                    // transaction abandons retransmitting the response
                    if (this.ticksLeft >= SIPTransaction.TIMER_H) {
                        this.cancel();
                        setState(TERMINATED_STATE);
                        fireTimeoutTimer();
                    }
                }

            }

        }
        
    }
    
    class ListenerExecutionMaxTimer extends SIPStackTimerTask {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.080 -0500", hash_original_field = "5A6CDDF85083E892D7A9B40C9781E270", hash_generated_field = "5A6CDDF85083E892D7A9B40C9781E270")

        SIPServerTransaction serverTransaction = SIPServerTransaction.this;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.083 -0500", hash_original_method = "250D0DA46E4093885E0FDCBFA4428EAC", hash_generated_method = "250D0DA46E4093885E0FDCBFA4428EAC")
        
ListenerExecutionMaxTimer() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.086 -0500", hash_original_method = "FEDCDB906765008977DAE6268EB71EAC", hash_generated_method = "69A374297D96B156779863A762807FED")
        
protected void runTask() {
            try {
                if (serverTransaction.getState() == null) {
                    serverTransaction.terminate();
                    SIPTransactionStack sipStack = serverTransaction.getSIPStack();
                    sipStack.removePendingTransaction(serverTransaction);
                    sipStack.removeTransaction(serverTransaction);

                }
            } catch (Exception ex) {
                sipStack.getStackLogger().logError("unexpected exception", ex);
            }
        }
        
    }
    
    class SendTrying extends SIPStackTimerTask {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.091 -0500", hash_original_method = "C30DBC53FC262811E7ACF1B35A336493", hash_generated_method = "6F2C1D538B532D0AEE0940117B540AC2")
        
protected SendTrying() {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("scheduled timer for " + SIPServerTransaction.this);

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.095 -0500", hash_original_method = "F91C856C78DFF19E74F73B1B16259454", hash_generated_method = "25C846842B88BF9928B43BB8ABE49332")
        
protected void runTask() {
            SIPServerTransaction serverTransaction = SIPServerTransaction.this;

            TransactionState realState = serverTransaction.getRealState();

            if (realState == null || TransactionState.TRYING == realState) {
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug(" sending Trying current state = "
                            + serverTransaction.getRealState());
                try {
                    serverTransaction.sendMessage(serverTransaction.getOriginalRequest()
                            .createResponse(100, "Trying"));
                    if (sipStack.isLoggingEnabled())
                        sipStack.getStackLogger().logDebug(" trying sent "
                                + serverTransaction.getRealState());
                } catch (IOException ex) {
                    if (sipStack.isLoggingEnabled())
                        sipStack.getStackLogger().logError("IO error sending  TRYING");
                }
            }

        }
        
    }
    
    class TransactionTimer extends SIPStackTimerTask {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.101 -0500", hash_original_method = "3D8EFF77F5EF9F9762C1A26A2D305727", hash_generated_method = "92373B94C8CE015A6C223638EBD8E053")
        
public TransactionTimer() {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("TransactionTimer() : " + getTransactionId());
            }

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:18.104 -0500", hash_original_method = "707AEBEB940FDE7695E7CB675FB731EE", hash_generated_method = "8E54733C73CCD2202836064DD99DB0A9")
        
protected void runTask() {
            // If the transaction has terminated,
            if (isTerminated()) {
                // Keep the transaction hanging around in the transaction table
                // to catch the incoming ACK -- this is needed for tcp only.
                // Note that the transaction record is actually removed in
                // the connection linger timer.
                try {
                    this.cancel();
                } catch (IllegalStateException ex) {
                    if (!sipStack.isAlive())
                        return;
                }

                // Oneshot timer that garbage collects the SeverTransaction
                // after a scheduled amount of time. The linger timer allows
                // the client side of the tx to use the same connection to
                // send an ACK and prevents a race condition for creation
                // of new server tx
                TimerTask myTimer = new LingerTimer();

                sipStack.getTimer().schedule(myTimer,
                        SIPTransactionStack.CONNECTION_LINGER_TIME * 1000);

            } else {
                // Add to the fire list -- needs to be moved
                // outside the synchronized block to prevent
                // deadlock.
                fireTimer();

            }
        }
        
    }
    
}

