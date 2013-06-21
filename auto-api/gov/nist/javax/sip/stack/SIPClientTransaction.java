package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.ListIterator;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLPeerUnverifiedException;
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
    private ConcurrentHashMap<String,SIPDialog> sipDialogs;
    private SIPRequest lastRequest;
    private int viaPort;
    private String viaHost;
    private transient ServerResponseInterface respondTo;
    private SIPDialog defaultDialog;
    private Hop nextHop;
    private boolean notifyOnRetransmit;
    private boolean timeoutIfStillInCallingState;
    private int callingStateTimeoutCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.109 -0400", hash_original_method = "7433B8F0086E8DE587CA3684570FA4BD", hash_generated_method = "C44D88A6AA4544720CAD9DCB3E410337")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SIPClientTransaction(SIPTransactionStack newSIPStack, MessageChannel newChannelToUse) {
        super(newSIPStack, newChannelToUse);
        dsTaint.addTaint(newChannelToUse.dsTaint);
        dsTaint.addTaint(newSIPStack.dsTaint);
        setBranch(Utils.getInstance().generateBranchId());
        this.messageProcessor = newChannelToUse.messageProcessor;
        this.setEncapsulatedChannel(newChannelToUse);
        this.notifyOnRetransmit = false;
        this.timeoutIfStillInCallingState = false;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_217436837 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Creating clientTransaction " + this);
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        this.sipDialogs = new ConcurrentHashMap();
        // ---------- Original Method ----------
        //setBranch(Utils.getInstance().generateBranchId());
        //this.messageProcessor = newChannelToUse.messageProcessor;
        //this.setEncapsulatedChannel(newChannelToUse);
        //this.notifyOnRetransmit = false;
        //this.timeoutIfStillInCallingState = false;
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("Creating clientTransaction " + this);
            //sipStack.getStackLogger().logStackTrace();
        //}
        //this.sipDialogs = new ConcurrentHashMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.110 -0400", hash_original_method = "A499701B9B92E6B9F8BD35BBCEA7DB79", hash_generated_method = "67D87B48D7639438598E24B171FAFD2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setResponseInterface(ServerResponseInterface newRespondTo) {
        dsTaint.addTaint(newRespondTo.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_865559729 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "Setting response interface for " + this + " to " + newRespondTo);
                {
                    sipStack.getStackLogger().logStackTrace();
                    sipStack.getStackLogger().logDebug("WARNING -- setting to null!");
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug(
                    //"Setting response interface for " + this + " to " + newRespondTo);
            //if (newRespondTo == null) {
                //sipStack.getStackLogger().logStackTrace();
                //sipStack.getStackLogger().logDebug("WARNING -- setting to null!");
            //}
        //}
        //respondTo = newRespondTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.110 -0400", hash_original_method = "2565B9EE896335E27EEEABBB213A9C77", hash_generated_method = "990E80A4E7B0E7C2C124329DEE7A74CE")
    @DSModeled(DSC.SAFE)
    public MessageChannel getRequestChannel() {
        return (MessageChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.111 -0400", hash_original_method = "C99C4952C168074F3FBA7AB2C1372665", hash_generated_method = "EFE7502D74722660AC54315C4F9AAD6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMessagePartOfTransaction(SIPMessage messageToTest) {
        dsTaint.addTaint(messageToTest.dsTaint);
        ViaList viaHeaders;
        viaHeaders = messageToTest.getViaHeaders();
        boolean transactionMatches;
        String messageBranch;
        messageBranch = ((Via) viaHeaders.getFirst()).getBranch();
        boolean rfc3261Compliant;
        rfc3261Compliant = getBranch() != null
                && messageBranch != null
                && getBranch().toLowerCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)
                && messageBranch.toLowerCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE);
        transactionMatches = false;
        {
            boolean var2F79CB4BCABBD5F3A433F945127DDBD2_818666421 = (TransactionState.COMPLETED == this.getState());
            {
                {
                    transactionMatches = getBranch().equalsIgnoreCase(
                        ((Via) viaHeaders.getFirst()).getBranch())
                        && getMethod().equals(messageToTest.getCSeq().getMethod());
                } //End block
                {
                    transactionMatches = getBranch().equals(messageToTest.getTransactionId());
                } //End block
            } //End block
            {
                boolean var4F6CD6D8A31BF3B11E9F83A356F12FC6_600505440 = (!isTerminated());
                {
                    {
                        {
                            {
                                boolean var5CEA4B7C3D6656CEEE85E8A7100BD5A9_32199850 = (getBranch().equalsIgnoreCase(((Via) viaHeaders.getFirst()).getBranch()));
                                {
                                    transactionMatches = getOriginalRequest().getCSeq().getMethod().equals(
                                messageToTest.getCSeq().getMethod());
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    {
                        {
                            boolean var96AF238F72E19E08C6B3BF39DB7BF3FD_1372154290 = (getBranch() != null);
                            {
                                transactionMatches = getBranch().equalsIgnoreCase(
                            messageToTest.getTransactionId());
                            } //End block
                            {
                                transactionMatches = getOriginalRequest().getTransactionId()
                            .equalsIgnoreCase(messageToTest.getTransactionId());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.111 -0400", hash_original_method = "1DFD8968C3CA232EAF5E448E3048EE02", hash_generated_method = "5291780EC59DBEE3B2C24D39379A53C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(SIPMessage messageToSend) throws IOException {
        dsTaint.addTaint(messageToSend.dsTaint);
        try 
        {
            SIPRequest transactionRequest;
            transactionRequest = (SIPRequest) messageToSend;
            Via topVia;
            topVia = (Via) transactionRequest.getViaHeaders().getFirst();
            try 
            {
                topVia.setBranch(getBranch());
            } //End block
            catch (java.text.ParseException ex)
            { }
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1451089412 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("Sending Message " + messageToSend);
                    sipStack.getStackLogger().logDebug("TransactionState " + this.getState());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var219D65251EB1FDB59693C07BE2A172E8_40761052 = (TransactionState.PROCEEDING == getState()
                    || TransactionState.CALLING == getState());
                {
                    {
                        boolean var8D053AB4B3CFB63570DCA353E515296A_616729330 = (transactionRequest.getMethod().equals(Request.ACK));
                        {
                            {
                                boolean varAA2EB0E74B91BC9EF1AAA23EA709EFB9_1162516970 = (isReliable());
                                {
                                    this.setState(TransactionState.TERMINATED);
                                } //End block
                                {
                                    this.setState(TransactionState.COMPLETED);
                                } //End block
                            } //End collapsed parenthetic
                            super.sendMessage(transactionRequest);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            try 
            {
                lastRequest = transactionRequest;
                {
                    boolean varC69030881E0CB32D3F6B7D9BAF47F033_1534167296 = (getState() == null);
                    {
                        setOriginalRequest(transactionRequest);
                        {
                            boolean varF62BD1B6240A1DE079CC44210FB08681_636728897 = (transactionRequest.getMethod().equals(Request.INVITE));
                            {
                                this.setState(TransactionState.CALLING);
                            } //End block
                            {
                                boolean var9E22013ED427D36FC8A42917F8A06467_1022190229 = (transactionRequest.getMethod().equals(Request.ACK));
                                {
                                    this.setState(TransactionState.TERMINATED);
                                } //End block
                                {
                                    this.setState(TransactionState.TRYING);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                        {
                            boolean var6400A483252621139629FC45C6113F96_2141599580 = (!isReliable());
                            {
                                enableRetransmissionTimer();
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var90CDBC638C52197AEFD58A39118A4F7B_1640690366 = (isInviteTransaction());
                            {
                                enableTimeoutTimer(TIMER_B);
                            } //End block
                            {
                                enableTimeoutTimer(TIMER_F);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                super.sendMessage(transactionRequest);
            } //End block
            catch (IOException e)
            {
                this.setState(TransactionState.TERMINATED);
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
        } //End block
        finally 
        {
            this.isMapped = true;
            this.startTransactionTimer();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.112 -0400", hash_original_method = "27FC8E987828EB63A48AA2B14048F41C", hash_generated_method = "DE26D96FAB47D0F4E7635A7E562B23E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void processResponse(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog dialog) {
        dsTaint.addTaint(transactionResponse.dsTaint);
        dsTaint.addTaint(dialog.dsTaint);
        dsTaint.addTaint(sourceChannel.dsTaint);
        {
            boolean varE76D73BC71B270FCC7DC9D3198957423_947055130 = (getState() == null);
        } //End collapsed parenthetic
        {
            boolean varA2852360A07253ACD3CD7CE5D8204CAB_1038542144 = ((TransactionState.COMPLETED == this.getState() || TransactionState.TERMINATED == this
                .getState())
                && transactionResponse.getStatusCode() / 100 == 1);
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2017729276 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "processing " + transactionResponse.getFirstLine() + "current state = "
                            + getState());
                sipStack.getStackLogger().logDebug("dialog = " + dialog);
            } //End block
        } //End collapsed parenthetic
        this.lastResponse = transactionResponse;
        try 
        {
            {
                boolean varF126D802AC06D34E85E28E6209C2BC97_752460009 = (isInviteTransaction());
                inviteClientTransaction(transactionResponse, sourceChannel, dialog);
                nonInviteClientTransaction(transactionResponse, sourceChannel, dialog);
            } //End collapsed parenthetic
        } //End block
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1494652653 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } //End collapsed parenthetic
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.112 -0400", hash_original_method = "ADF3D75C6ADD47CBC6B3D63B5D3998CF", hash_generated_method = "9C3BAA5E125477F7ADB745B6EC70CB56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nonInviteClientTransaction(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog sipDialog) throws IOException {
        dsTaint.addTaint(sipDialog.dsTaint);
        dsTaint.addTaint(transactionResponse.dsTaint);
        dsTaint.addTaint(sourceChannel.dsTaint);
        int statusCode;
        statusCode = transactionResponse.getStatusCode();
        {
            boolean varC968CD9C1FC4F438A611F7A7272EB280_219904323 = (TransactionState.TRYING == this.getState());
            {
                {
                    this.setState(TransactionState.PROCEEDING);
                    enableRetransmissionTimer(MAXIMUM_RETRANSMISSION_TICK_COUNT);
                    enableTimeoutTimer(TIMER_F);
                    {
                        respondTo.processResponse(transactionResponse, this, sipDialog);
                    } //End block
                    {
                        this.semRelease();
                    } //End block
                } //End block
                {
                    {
                        respondTo.processResponse(transactionResponse, this, sipDialog);
                    } //End block
                    {
                        this.semRelease();
                    } //End block
                    {
                        boolean varE50099A69BBB2F1277A12DA84DAC7141_1082173237 = (!isReliable());
                        {
                            this.setState(TransactionState.COMPLETED);
                            enableTimeoutTimer(TIMER_K);
                        } //End block
                        {
                            this.setState(TransactionState.TERMINATED);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                boolean varDE96CE40FAB1EC19FEE71BD4FF3FF6A4_1104879300 = (TransactionState.PROCEEDING == this.getState());
                {
                    {
                        {
                            respondTo.processResponse(transactionResponse, this, sipDialog);
                        } //End block
                        {
                            this.semRelease();
                        } //End block
                    } //End block
                    {
                        {
                            respondTo.processResponse(transactionResponse, this, sipDialog);
                        } //End block
                        {
                            this.semRelease();
                        } //End block
                        disableRetransmissionTimer();
                        disableTimeoutTimer();
                        {
                            boolean var6400A483252621139629FC45C6113F96_432617800 = (!isReliable());
                            {
                                this.setState(TransactionState.COMPLETED);
                                enableTimeoutTimer(TIMER_K);
                            } //End block
                            {
                                this.setState(TransactionState.TERMINATED);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1838042334 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(
                        " Not sending response to TU! " + getState());
                        } //End block
                    } //End collapsed parenthetic
                    this.semRelease();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.114 -0400", hash_original_method = "C74AAAAD68DF1265333F033333BC207B", hash_generated_method = "D84F54C95C3487908B6452190EFBDB1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void inviteClientTransaction(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog dialog) throws IOException {
        dsTaint.addTaint(transactionResponse.dsTaint);
        dsTaint.addTaint(dialog.dsTaint);
        dsTaint.addTaint(sourceChannel.dsTaint);
        int statusCode;
        statusCode = transactionResponse.getStatusCode();
        {
            boolean var3E1810922DAA236CCE1F0B7509376A43_2112353010 = (TransactionState.TERMINATED == this.getState());
            {
                boolean ackAlreadySent;
                ackAlreadySent = false;
                {
                    boolean var19306E120BE9D264E51B259436F37B29_716423558 = (dialog != null && dialog.isAckSeen() && dialog.getLastAckSent() != null);
                    {
                        {
                            boolean varBF822AAB6CF61DD6130DC2E8CF7B1D87_389051939 = (dialog.getLastAckSent().getCSeq().getSeqNumber() == transactionResponse.getCSeq()
                        .getSeqNumber()
                        && transactionResponse.getFromTag().equals(
                                dialog.getLastAckSent().getFromTag()));
                            {
                                ackAlreadySent = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varEC1CFF0A2A82B6BD98A9B67A0D47F0E0_1884966587 = (dialog!= null && ackAlreadySent
                    && transactionResponse.getCSeq().getMethod().equals(dialog.getMethod()));
                    {
                        try 
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1614083515 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("resending ACK");
                            } //End collapsed parenthetic
                            dialog.resendAck();
                        } //End block
                        catch (SipException ex)
                        { }
                    } //End block
                } //End collapsed parenthetic
                this.semRelease();
            } //End block
            {
                boolean var6AABC11187F015DBC15DBF91F29746C6_825635746 = (TransactionState.CALLING == this.getState());
                {
                    {
                        disableRetransmissionTimer();
                        disableTimeoutTimer();
                        this.setState(TransactionState.TERMINATED);
                        respondTo.processResponse(transactionResponse, this, dialog);
                        {
                            this.semRelease();
                        } //End block
                    } //End block
                    {
                        disableRetransmissionTimer();
                        disableTimeoutTimer();
                        this.setState(TransactionState.PROCEEDING);
                        respondTo.processResponse(transactionResponse, this, dialog);
                        {
                            this.semRelease();
                        } //End block
                    } //End block
                    {
                        try 
                        {
                            sendMessage((SIPRequest) createErrorAck());
                        } //End block
                        catch (Exception ex)
                        {
                            sipStack.getStackLogger().logError(
                            "Unexpected Exception sending ACK -- sending error AcK ", ex);
                        } //End block
                        {
                            respondTo.processResponse(transactionResponse, this, dialog);
                        } //End block
                        {
                            this.semRelease();
                        } //End block
                        {
                            boolean varEE55C49A27AE3B7CBFE2F02F6CDDC5E9_1389883141 = (this.getDialog() != null &&  ((SIPDialog)this.getDialog()).isBackToBackUserAgent());
                            {
                                ((SIPDialog) this.getDialog()).releaseAckSem();
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var6400A483252621139629FC45C6113F96_451709981 = (!isReliable());
                            {
                                this.setState(TransactionState.COMPLETED);
                                enableTimeoutTimer(TIMER_D);
                            } //End block
                            {
                                this.setState(TransactionState.TERMINATED);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                {
                    boolean varD4C99897269968D7787452ACF03B2454_1979191951 = (TransactionState.PROCEEDING == this.getState());
                    {
                        {
                            {
                                respondTo.processResponse(transactionResponse, this, dialog);
                            } //End block
                            {
                                this.semRelease();
                            } //End block
                        } //End block
                        {
                            this.setState(TransactionState.TERMINATED);
                            {
                                respondTo.processResponse(transactionResponse, this, dialog);
                            } //End block
                            {
                                this.semRelease();
                            } //End block
                        } //End block
                        {
                            try 
                            {
                                sendMessage((SIPRequest) createErrorAck());
                            } //End block
                            catch (Exception ex)
                            {
                                InternalErrorHandler.handleException(ex);
                            } //End block
                            {
                                boolean var21341DE354DBCBD7F5D753D406CC2DD6_548684148 = (this.getDialog() != null);
                                {
                                    ((SIPDialog) this.getDialog()).releaseAckSem();
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var22210305B3706CCEBD8C0B502050721F_1019351801 = (!isReliable());
                                {
                                    this.setState(TransactionState.COMPLETED);
                                    this.enableTimeoutTimer(TIMER_D);
                                } //End block
                                {
                                    this.setState(TransactionState.TERMINATED);
                                } //End block
                            } //End collapsed parenthetic
                            respondTo.processResponse(transactionResponse, this, dialog);
                            {
                                this.semRelease();
                            } //End block
                        } //End block
                    } //End block
                    {
                        boolean var8C1A7878C3537DB42D996A959ACB223D_377077932 = (TransactionState.COMPLETED == this.getState());
                        {
                            {
                                try 
                                {
                                    sendMessage((SIPRequest) createErrorAck());
                                } //End block
                                catch (Exception ex)
                                {
                                    InternalErrorHandler.handleException(ex);
                                } //End block
                                finally 
                                {
                                    this.semRelease();
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.115 -0400", hash_original_method = "9C1F15FBE6A7795E5EE0D6BE4F94BCBE", hash_generated_method = "FCF735A4A276E6B02DDC4B09FB2F05D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendRequest() throws SipException {
        SIPRequest sipRequest;
        sipRequest = this.getOriginalRequest();
        {
            boolean var5F3B63336C4433C300EDF029038A6C22_1021632039 = (this.getState() != null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Request already sent");
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2103713566 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("sendRequest() " + sipRequest);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            sipRequest.checkHeaders();
        } //End block
        catch (ParseException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1583112174 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError("missing required header");
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex.getMessage());
        } //End block
        {
            boolean var820257507A310D8AF36355A9AD2BA48D_1757939641 = (getMethod().equals(Request.SUBSCRIBE)
                && sipRequest.getHeader(ExpiresHeader.NAME) == null);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1574334443 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logWarning(
                    "Expires header missing in outgoing subscribe --"
                            + " Notifier will assume implied value on event package");
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var318B68FE13188E5CF00AFCF6916271A5_531116443 = (this.getOriginalRequest().getMethod().equals(Request.CANCEL)
                    && sipStack.isCancelClientTransactionChecked());
                {
                    SIPClientTransaction ct;
                    ct = (SIPClientTransaction) sipStack.findCancelTransaction(
                        this.getOriginalRequest(), false);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("Could not find original tx to cancel. RFC 3261 9.1");
                    } //End block
                    {
                        boolean varEA0B50AF0098703E4B38DDE85F0C6921_353665503 = (ct.getState() == null);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SipException(
                            "State is null no provisional response yet -- cannot cancel RFC 3261 9.1");
                        } //End block
                        {
                            boolean varA13443824E4796F0FD53BAC050780DAB_1364077365 = (!ct.getMethod().equals(Request.INVITE));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot cancel non-invite requests RFC 3261 9.1");
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varD4977AF0B5B23F4157209F1FCE74E90F_1317680621 = (this.getOriginalRequest().getMethod().equals(Request.BYE)
                    || this.getOriginalRequest().getMethod().equals(Request.NOTIFY));
                    {
                        SIPDialog dialog;
                        dialog = sipStack.getDialog(this.getOriginalRequest()
                        .getDialogId(false));
                        {
                            boolean var8ABAC142ED80BB89B4590C8EA00C5515_686211712 = (this.getSipProvider().isAutomaticDialogSupportEnabled() && dialog != null);
                            {
                                if (DroidSafeAndroidRuntime.control) throw new SipException(
                            "Dialog is present and AutomaticDialogSupport is enabled for "
                                    + " the provider -- Send the Request using the Dialog.sendRequest(transaction)");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                boolean var812EAB2B90D4924E111DE9ACDFD47D2D_677315645 = (this.getMethod().equals(Request.INVITE));
                {
                    SIPDialog dialog;
                    dialog = this.getDefaultDialog();
                    {
                        boolean varC7B62845BBFBCF228194AFDC8EE17A0F_661547576 = (dialog != null && dialog.isBackToBackUserAgent());
                        {
                            {
                                boolean var0AAD1CBCC17317BC020B7366C0E43AD5_478216412 = (! dialog.takeAckSem());
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new SipException ("Failed to take ACK semaphore");
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            this.isMapped = true;
            this.sendMessage(sipRequest);
        } //End block
        catch (IOException ex)
        {
            this.setState(TransactionState.TERMINATED);
            if (DroidSafeAndroidRuntime.control) throw new SipException("IO Error sending request", ex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.115 -0400", hash_original_method = "328DA368C3B0C5FF79EC2B4ACE66A1A9", hash_generated_method = "8F6E9BD5D01E63DB6F8E2E841813DDAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fireRetransmissionTimer() {
        try 
        {
            {
                boolean varF34F8E24C31250F5E4052AC1FB7D63CE_1241232858 = (this.getState() == null || !this.isMapped);
            } //End collapsed parenthetic
            boolean inv;
            inv = isInviteTransaction();
            TransactionState s;
            s = this.getState();
            {
                {
                    {
                        boolean var362664B439C1234CDC3CE46AD8B5EC7F_1725661092 = (sipStack.generateTimeStampHeader
                            && lastRequest.getHeader(TimeStampHeader.NAME) != null);
                        {
                            long milisec;
                            milisec = System.currentTimeMillis();
                            TimeStamp timeStamp;
                            timeStamp = new TimeStamp();
                            try 
                            {
                                timeStamp.setTimeStamp(milisec);
                            } //End block
                            catch (InvalidArgumentException ex)
                            {
                                InternalErrorHandler.handleException(ex);
                            } //End block
                            lastRequest.setHeader(timeStamp);
                        } //End block
                    } //End collapsed parenthetic
                    super.sendMessage(lastRequest);
                    {
                        TimeoutEvent txTimeout;
                        txTimeout = new TimeoutEvent(this.getSipProvider(), this,
                                Timeout.RETRANSMIT);
                        this.getSipProvider().handleEvent(txTimeout, this);
                    } //End block
                    {
                        boolean var55B500A3FDF003CB88EA4E921DECAEA2_1280691143 = (this.timeoutIfStillInCallingState
                            && this.getState() == TransactionState.CALLING);
                        {
                            {
                                TimeoutEvent timeoutEvent;
                                timeoutEvent = new TimeoutEvent(this.getSipProvider(),
                                    this, Timeout.RETRANSMIT);
                                this.getSipProvider().handleEvent(timeoutEvent, this);
                                this.timeoutIfStillInCallingState = false;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        catch (IOException e)
        {
            this.raiseIOExceptionEvent();
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.116 -0400", hash_original_method = "F0DB4D0E841E14FF88BA6095928288BF", hash_generated_method = "C2CB7C4055A2B99C687625C87B85095F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fireTimeoutTimer() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1460570049 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("fireTimeoutTimer " + this);
        } //End collapsed parenthetic
        SIPDialog dialog;
        dialog = (SIPDialog) this.getDialog();
        {
            boolean varC9F46915C5C0D473164D5D23DADB13DA_1408631956 = (TransactionState.CALLING == this.getState()
                || TransactionState.TRYING == this.getState()
                || TransactionState.PROCEEDING == this.getState());
            {
                {
                    boolean var55AB3B53A0926BE91060C867235A4DEA_321082040 = (dialog != null
                    && (dialog.getState() == null || dialog.getState() == DialogState.EARLY));
                    {
                        {
                            boolean var242BDFFA40347198F760BB7493B3A654_1482857700 = (((SIPTransactionStack) getSIPStack()).isDialogCreated(this
                        .getOriginalRequest().getMethod()));
                            {
                                dialog.delete();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean varC79FCB4848976BFC5400B5E95B3F8ACB_1344270043 = (getOriginalRequest().getMethod().equalsIgnoreCase(Request.BYE)
                        && dialog.isTerminatedOnBye());
                            {
                                dialog.delete();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var58BB9C9C8854A0CE328AD570113B87D4_1528719523 = (TransactionState.COMPLETED != this.getState());
            {
                raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
                {
                    boolean var70A6005E7B48E353B69F5438AD3CE0FC_1721261839 = (this.getOriginalRequest().getMethod().equalsIgnoreCase(Request.CANCEL));
                    {
                        SIPClientTransaction inviteTx;
                        inviteTx = (SIPClientTransaction) this.getOriginalRequest()
                        .getInviteTransaction();
                        {
                            boolean varC3A7C39326E116DEB20C0C14912483B7_659230198 = (inviteTx != null
                        && ((inviteTx.getState() == TransactionState.CALLING || inviteTx
                                .getState() == TransactionState.PROCEEDING))
                        && inviteTx.getDialog() != null);
                            {
                                inviteTx.setState(TransactionState.TERMINATED);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                this.setState(TransactionState.TERMINATED);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.116 -0400", hash_original_method = "2914559B80386C20A981D1BD82B7352B", hash_generated_method = "46174D87E0E288D7A8458B81511A4B3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Request createCancel() throws SipException {
        SIPRequest originalRequest;
        originalRequest = this.getOriginalRequest();
        if (DroidSafeAndroidRuntime.control) throw new SipException("Bad state " + getState());
        {
            boolean var360DD8E773A2E8A5ED1271BA39E980C5_53100937 = (!originalRequest.getMethod().equals(Request.INVITE));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Only INIVTE may be cancelled");
        } //End collapsed parenthetic
        {
            boolean var324A2F774D9632F9564E3561EDEA142B_355966987 = (originalRequest.getMethod().equalsIgnoreCase(Request.ACK));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot Cancel ACK!");
            {
                SIPRequest cancelRequest;
                cancelRequest = originalRequest.createCancelRequest();
                cancelRequest.setInviteTransaction(this);
            } //End block
        } //End collapsed parenthetic
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPRequest originalRequest = this.getOriginalRequest();
        //if (originalRequest == null)
            //throw new SipException("Bad state " + getState());
        //if (!originalRequest.getMethod().equals(Request.INVITE))
            //throw new SipException("Only INIVTE may be cancelled");
        //if (originalRequest.getMethod().equalsIgnoreCase(Request.ACK))
            //throw new SipException("Cannot Cancel ACK!");
        //else {
            //SIPRequest cancelRequest = originalRequest.createCancelRequest();
            //cancelRequest.setInviteTransaction(this);
            //return cancelRequest;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.117 -0400", hash_original_method = "59092618FB848453FA0559AC58047778", hash_generated_method = "1B7C51C877C6D5C7CCCFE9C2F107C809")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Request createAck() throws SipException {
        SIPRequest originalRequest;
        originalRequest = this.getOriginalRequest();
        if (DroidSafeAndroidRuntime.control) throw new SipException("bad state " + getState());
        {
            boolean var23CDF0CAAEDB841CA67299E2DE2D191F_688651109 = (getMethod().equalsIgnoreCase(Request.ACK));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot ACK an ACK!");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("bad Transaction state");
            } //End block
            {
                boolean var012D721CAF7801CBBD1DCFB98FA22683_1252449231 = (lastResponse.getStatusCode() < 200);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1848838988 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("lastResponse = " + lastResponse);
                        } //End block
                    } //End collapsed parenthetic
                    if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot ACK a provisional response!");
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        SIPRequest ackRequest;
        ackRequest = originalRequest.createAckRequest((To) lastResponse.getTo());
        RecordRouteList recordRouteList;
        recordRouteList = lastResponse.getRecordRouteHeaders();
        {
            {
                boolean var7DAFF59FCF080B5E5F9653EE735BA443_1398768635 = (lastResponse.getContactHeaders() != null
                    && lastResponse.getStatusCode() / 100 != 3);
                {
                    Contact contact;
                    contact = (Contact) lastResponse.getContactHeaders().getFirst();
                    javax.sip.address.URI uri;
                    uri = (javax.sip.address.URI) contact.getAddress().getURI()
                        .clone();
                    ackRequest.setRequestURI(uri);
                } //End block
            } //End collapsed parenthetic
        } //End block
        ackRequest.removeHeader(RouteHeader.NAME);
        RouteList routeList;
        routeList = new RouteList();
        ListIterator<RecordRoute> li;
        li = recordRouteList.listIterator(recordRouteList.size());
        {
            boolean var34E820506DA7A52D1D64148C53A15353_153022925 = (li.hasPrevious());
            {
                RecordRoute rr;
                rr = (RecordRoute) li.previous();
                Route route;
                route = new Route();
                route.setAddress((AddressImpl) ((AddressImpl) rr.getAddress()).clone());
                route.setParameters((NameValueList) rr.getParameters().clone());
                routeList.add(route);
            } //End block
        } //End collapsed parenthetic
        Contact contact;
        contact = null;
        {
            boolean var782AA6724CEB5153F134EFA15DEC0D09_1981339524 = (lastResponse.getContactHeaders() != null);
            {
                contact = (Contact) lastResponse.getContactHeaders().getFirst();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var70FEFC8E2B4A4EA64B93BD56266D6258_482624780 = (!((SipURI) ((Route) routeList.getFirst()).getAddress().getURI()).hasLrParam());
            {
                Route route;
                route = null;
                {
                    route = new Route();
                    route.setAddress((AddressImpl) ((AddressImpl) (contact.getAddress())).clone());
                } //End block
                Route firstRoute;
                firstRoute = (Route) routeList.getFirst();
                routeList.removeFirst();
                javax.sip.address.URI uri;
                uri = firstRoute.getAddress().getURI();
                ackRequest.setRequestURI(uri);
                routeList.add(route);
                ackRequest.addHeader(routeList);
            } //End block
            {
                {
                    javax.sip.address.URI uri;
                    uri = (javax.sip.address.URI) contact.getAddress().getURI()
                        .clone();
                    ackRequest.setRequestURI(uri);
                    ackRequest.addHeader(routeList);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.118 -0400", hash_original_method = "C777E21FF4216BC8A7ADE1EB27ADDE8D", hash_generated_method = "696BC3669FA6267C2BCA82C759905783")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final Request createErrorAck() throws SipException, ParseException {
        SIPRequest originalRequest;
        originalRequest = this.getOriginalRequest();
        if (DroidSafeAndroidRuntime.control) throw new SipException("bad state " + getState());
        {
            boolean var023D4CF241B205BA58114F71AFE92AC0_544862391 = (!getMethod().equals(Request.INVITE));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Can only ACK an INVITE!");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("bad Transaction state");
            } //End block
            {
                boolean var012D721CAF7801CBBD1DCFB98FA22683_1409582265 = (lastResponse.getStatusCode() < 200);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_156302957 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("lastResponse = " + lastResponse);
                        } //End block
                    } //End collapsed parenthetic
                    if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot ACK a provisional response!");
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        Request var36AC265F232BCFCAED291BD2A76FDA11_1721739737 = (originalRequest.createErrorAck((To) lastResponse.getTo()));
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPRequest originalRequest = this.getOriginalRequest();
        //if (originalRequest == null)
            //throw new SipException("bad state " + getState());
        //if (!getMethod().equals(Request.INVITE)) {
            //throw new SipException("Can only ACK an INVITE!");
        //} else if (lastResponse == null) {
            //throw new SipException("bad Transaction state");
        //} else if (lastResponse.getStatusCode() < 200) {
            //if (sipStack.isLoggingEnabled()) {
                //sipStack.getStackLogger().logDebug("lastResponse = " + lastResponse);
            //}
            //throw new SipException("Cannot ACK a provisional response!");
        //}
        //return originalRequest.createErrorAck((To) lastResponse.getTo());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.118 -0400", hash_original_method = "FADEF945106DA805CF02027B2BE28020", hash_generated_method = "F973EE699216313E78C83E89C6AB6A7D")
    @DSModeled(DSC.SAFE)
    protected void setViaPort(int port) {
        dsTaint.addTaint(port);
        // ---------- Original Method ----------
        //this.viaPort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.118 -0400", hash_original_method = "0E538A29C97CB223EF1CD12A71C73074", hash_generated_method = "473F00553EB2338CEBA5560332DF9F94")
    @DSModeled(DSC.SAFE)
    protected void setViaHost(String host) {
        dsTaint.addTaint(host);
        // ---------- Original Method ----------
        //this.viaHost = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.118 -0400", hash_original_method = "133D8E60A07873D19335FF91037EC663", hash_generated_method = "0346C235AE4F53BA1577BA4E8EF9DFE9")
    @DSModeled(DSC.SAFE)
    public int getViaPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.viaPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.118 -0400", hash_original_method = "BFF3BD5D9B7619BE758B5D7001336743", hash_generated_method = "C85CA9A51AD9B48EA9BA29EBC8CDFE1E")
    @DSModeled(DSC.SAFE)
    public String getViaHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.viaHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.119 -0400", hash_original_method = "0750F8DA140E6BEE450B9743ACFD7E44", hash_generated_method = "72B645E45E8DB27222083F555752D05C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Via getOutgoingViaHeader() {
        Via var0771DE3D57E5E384CF0D2173DD027079_1431529149 = (this.getMessageProcessor().getViaHeader());
        return (Via)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.getMessageProcessor().getViaHeader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.119 -0400", hash_original_method = "B250DD181A3373E2CC04255377753F31", hash_generated_method = "6CCA103991603EF3F3C26F3C09E7F13D")
    @DSModeled(DSC.SAFE)
    public void clearState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.119 -0400", hash_original_method = "513C7C1329620A072B43100259C2C5F6", hash_generated_method = "B68F402A512E2977B17695FFA4767FE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setState(TransactionState newState) {
        dsTaint.addTaint(newState.dsTaint);
        {
            boolean var91759660CDF9DD647AB086394E273AE8_1671038232 = (newState == TransactionState.TERMINATED && this.isReliable()
                && (!getSIPStack().cacheClientConnections));
            {
                this.collectionTime = TIMER_J;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var11BA604ADA2BF23D3E29AB36D807FF0A_551083555 = (super.getState() != TransactionState.COMPLETED
                && (newState == TransactionState.COMPLETED || newState == TransactionState.TERMINATED));
            {
                sipStack.decrementActiveClientTransactionCount();
            } //End block
        } //End collapsed parenthetic
        super.setState(newState);
        // ---------- Original Method ----------
        //if (newState == TransactionState.TERMINATED && this.isReliable()
                //&& (!getSIPStack().cacheClientConnections)) {
            //this.collectionTime = TIMER_J;
        //}
        //if (super.getState() != TransactionState.COMPLETED
                //&& (newState == TransactionState.COMPLETED || newState == TransactionState.TERMINATED)) {
            //sipStack.decrementActiveClientTransactionCount();
        //}
        //super.setState(newState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.119 -0400", hash_original_method = "8AD9FEC5ADB8A6F1DFBB290459716C8C", hash_generated_method = "3C645E200CE7084D564F13AF0A95481D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void startTransactionTimer() {
        {
            boolean var388A148DB1BAAE2BABBFD1571EA90BBF_1487599077 = (this.transactionTimerStarted.compareAndSet(false, true));
            {
                TimerTask myTimer;
                myTimer = new TransactionTimer();
                {
                    boolean var7F2874EE26E943E6FA8451457423E55A_1052154822 = (sipStack.getTimer() != null);
                    {
                        sipStack.getTimer().schedule(myTimer, BASE_TIMER_INTERVAL, BASE_TIMER_INTERVAL);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (this.transactionTimerStarted.compareAndSet(false, true)) {
	        //TimerTask myTimer = new TransactionTimer();
	        //if ( sipStack.getTimer() != null ) {
	            //sipStack.getTimer().schedule(myTimer, BASE_TIMER_INTERVAL, BASE_TIMER_INTERVAL);
	        //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.119 -0400", hash_original_method = "ACD8113ABC5B192A943EAFBD5656CA38", hash_generated_method = "9600A5B5EE9B39E2643E3ED4DD70BFBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void terminate() throws ObjectInUseException {
        this.setState(TransactionState.TERMINATED);
        // ---------- Original Method ----------
        //this.setState(TransactionState.TERMINATED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.120 -0400", hash_original_method = "8BA63F6111F6111C9CE6504A86A67BA3", hash_generated_method = "CD71B3C9AF8C067F7A9E02F9FD7B7EC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean checkFromTag(SIPResponse sipResponse) {
        dsTaint.addTaint(sipResponse.dsTaint);
        String originalFromTag;
        originalFromTag = ((SIPRequest) this.getRequest()).getFromTag();
        {
            {
                boolean var99721F8958DA05D67BDFDECFF1356658_1738817731 = (originalFromTag == null ^ sipResponse.getFrom().getTag() == null);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1522779742 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var711AEDA4725A65E5F56D20EAEDEFABA8_472451208 = (originalFromTag != null
                    && !originalFromTag.equalsIgnoreCase(sipResponse.getFrom().getTag()));
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1645997230 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String originalFromTag = ((SIPRequest) this.getRequest()).getFromTag();
        //if (this.defaultDialog != null) {
            //if (originalFromTag == null ^ sipResponse.getFrom().getTag() == null) {
            	//if (sipStack.isLoggingEnabled())
            		//sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                //return false;
            //}
            //if (originalFromTag != null
                    //&& !originalFromTag.equalsIgnoreCase(sipResponse.getFrom().getTag())) {
            	//if (sipStack.isLoggingEnabled())
            		//sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.121 -0400", hash_original_method = "38065D3AA78F19CFA0459E8A308EC067", hash_generated_method = "AF7C6D99D77FC91E4BAD1CFA66A69069")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processResponse(SIPResponse sipResponse, MessageChannel incomingChannel) {
        dsTaint.addTaint(incomingChannel.dsTaint);
        dsTaint.addTaint(sipResponse.dsTaint);
        SIPDialog dialog;
        dialog = null;
        String method;
        method = sipResponse.getCSeq().getMethod();
        String dialogId;
        dialogId = sipResponse.getDialogId(false);
        {
            boolean varF84B7A52F01098BB8D5530B7462524E7_1367569426 = (method.equals(Request.CANCEL) && lastRequest != null);
            {
                SIPClientTransaction ict;
                ict = (SIPClientTransaction) lastRequest.getInviteTransaction();
                {
                    dialog = ict.defaultDialog;
                } //End block
            } //End block
            {
                dialog = this.getDialog(dialogId);
            } //End block
        } //End collapsed parenthetic
        {
            int code;
            code = sipResponse.getStatusCode();
            {
                boolean var67A22D552074C073387137665D71377F_971947112 = ((code > 100 && code < 300)
            && (sipResponse.getToTag() != null || sipStack.isRfc2543Supported())
                    && sipStack.isDialogCreated(method));
                {
                    {
                        {
                            {
                                boolean varDFA55FC60A34539A3B46D425D6F76E02_874592125 = (sipResponse.getFromTag() != null);
                                {
                                    SIPResponse dialogResponse;
                                    dialogResponse = defaultDialog.getLastResponse();
                                    String defaultDialogId;
                                    defaultDialogId = defaultDialog.getDialogId();
                                    {
                                        boolean varB75661995D0822CE25D549C01EA47284_1860797015 = (dialogResponse == null
                                    || (method.equals(Request.SUBSCRIBE)
                                            && dialogResponse.getCSeq().getMethod().equals(
                                                    Request.NOTIFY) && defaultDialogId
                                            .equals(dialogId)));
                                        {
                                            defaultDialog.setLastResponse(this, sipResponse);
                                            dialog = defaultDialog;
                                        } //End block
                                        {
                                            dialog = sipStack.getDialog(dialogId);
                                            {
                                                {
                                                    boolean var5EE64698204564FF6C92AF522DB71698_1304943605 = (defaultDialog.isAssigned());
                                                    {
                                                        dialog = sipStack.createDialog(this, sipResponse);
                                                    } //End block
                                                } //End collapsed parenthetic
                                            } //End block
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        this.setDialog(dialog, dialog.getDialogId());
                                    } //End block
                                    {
                                        sipStack.getStackLogger().logError("dialog is unexpectedly null",new NullPointerException());
                                    } //End block
                                } //End block
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Response without from-tag");
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                dialog = sipStack.createDialog(this, sipResponse);
                                this.setDialog(dialog, dialog.getDialogId());
                            } //End block
                        } //End block
                    } //End block
                } //End block
                {
                    dialog = defaultDialog;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            dialog.setLastResponse(this, sipResponse);
        } //End block
        this.processResponse(sipResponse, incomingChannel, dialog);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.121 -0400", hash_original_method = "A455A41B989A73F91883A443A89AF007", hash_generated_method = "60F1B6A74AC15841DA680ED06E9EC52E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Dialog getDialog() {
        Dialog retval;
        retval = null;
        {
            boolean var2BC280353718DAEB81C02AFB0812A34C_1570856561 = (this.lastResponse != null && this.lastResponse.getFromTag() != null
                && this.lastResponse.getToTag() != null
                && this.lastResponse.getStatusCode() != 100);
            {
                String dialogId;
                dialogId = this.lastResponse.getDialogId(false);
                retval = (Dialog) getDialog(dialogId);
            } //End block
        } //End collapsed parenthetic
        {
            retval = (Dialog) this.defaultDialog;
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1815637184 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    " sipDialogs =  " + sipDialogs + " default dialog " + this.defaultDialog
                            + " retval " + retval);
            } //End block
        } //End collapsed parenthetic
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Dialog retval = null;
        //if (this.lastResponse != null && this.lastResponse.getFromTag() != null
                //&& this.lastResponse.getToTag() != null
                //&& this.lastResponse.getStatusCode() != 100) {
            //String dialogId = this.lastResponse.getDialogId(false);
            //retval = (Dialog) getDialog(dialogId);
        //}
        //if (retval == null) {
            //retval = (Dialog) this.defaultDialog;
        //}
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug(
                    //" sipDialogs =  " + sipDialogs + " default dialog " + this.defaultDialog
                            //+ " retval " + retval);
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.122 -0400", hash_original_method = "7CA3466B3B290C9233529520194EB8A2", hash_generated_method = "EA0297475E18E444357A6C9F62E68806")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDialog getDialog(String dialogId) {
        dsTaint.addTaint(dialogId);
        SIPDialog retval;
        retval = (SIPDialog) this.sipDialogs.get(dialogId);
        return (SIPDialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPDialog retval = (SIPDialog) this.sipDialogs.get(dialogId);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.122 -0400", hash_original_method = "9816411304542A0CA40176674DC457D1", hash_generated_method = "CEFDC660902946361B05196E521C3EBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDialog(SIPDialog sipDialog, String dialogId) {
        dsTaint.addTaint(sipDialog.dsTaint);
        dsTaint.addTaint(dialogId);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1084156255 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "setDialog: " + dialogId + "sipDialog = " + sipDialog);
        } //End collapsed parenthetic
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_437767635 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError("NULL DIALOG!!");
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad dialog null");
        } //End block
        {
            {
                boolean varED64600D3E444F188F7A3A5A4ABEAEFC_1538528773 = (this.getMethod().equals(Request.INVITE) && this.getSIPStack().maxForkTime != 0);
                {
                    this.getSIPStack().addForkedClientTransaction(this);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varDFE46D77BD33F7C2E2FA045C1E3DB93A_431999976 = (dialogId != null && sipDialog.getDialogId() != null);
            {
                this.sipDialogs.put(dialogId, sipDialog);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug(
                    //"setDialog: " + dialogId + "sipDialog = " + sipDialog);
        //if (sipDialog == null) {
        	//if (sipStack.isLoggingEnabled())
        		//sipStack.getStackLogger().logError("NULL DIALOG!!");
            //throw new NullPointerException("bad dialog null");
        //}
        //if (this.defaultDialog == null) {
            //this.defaultDialog = sipDialog;
            //if ( this.getMethod().equals(Request.INVITE) && this.getSIPStack().maxForkTime != 0) {
                //this.getSIPStack().addForkedClientTransaction(this);
            //}
        //}
        //if (dialogId != null && sipDialog.getDialogId() != null) {
            //this.sipDialogs.put(dialogId, sipDialog);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.122 -0400", hash_original_method = "EC86D15857564E1427115ADA6B1A0784", hash_generated_method = "5E00D58450A66BF00AFC5D006E9D6C5F")
    @DSModeled(DSC.SAFE)
    public SIPDialog getDefaultDialog() {
        return (SIPDialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.defaultDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.122 -0400", hash_original_method = "BBF8312DD6859DF11BA280D3CE71F333", hash_generated_method = "7ED441567EB838E37723950664D135E3")
    @DSModeled(DSC.SAFE)
    public void setNextHop(Hop hop) {
        dsTaint.addTaint(hop.dsTaint);
        // ---------- Original Method ----------
        //this.nextHop = hop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.123 -0400", hash_original_method = "F8BB258224ADAD4254DDBC66AEC6C06F", hash_generated_method = "DD36B27798CBA3F9723B50327BCDE65C")
    @DSModeled(DSC.SAFE)
    public Hop getNextHop() {
        return (Hop)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return nextHop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.123 -0400", hash_original_method = "5A4A2DE6DA5EAFA8C9F9B9398CD98855", hash_generated_method = "18E5239BC553EE93E9E1CC743710CE5C")
    @DSModeled(DSC.SAFE)
    public void setNotifyOnRetransmit(boolean notifyOnRetransmit) {
        dsTaint.addTaint(notifyOnRetransmit);
        // ---------- Original Method ----------
        //this.notifyOnRetransmit = notifyOnRetransmit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.123 -0400", hash_original_method = "27ED93829BD70EC80C4ABB0868670759", hash_generated_method = "ED31311D2D9B6CAF0556246F66CD7FFC")
    @DSModeled(DSC.SAFE)
    public boolean isNotifyOnRetransmit() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return notifyOnRetransmit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.123 -0400", hash_original_method = "E7190C5FA03F5363EA136DFEC0492C73", hash_generated_method = "6BE81D2829D429EB2052A2520FEC3EBF")
    @DSModeled(DSC.SAFE)
    public void alertIfStillInCallingStateBy(int count) {
        dsTaint.addTaint(count);
        this.timeoutIfStillInCallingState = true;
        // ---------- Original Method ----------
        //this.timeoutIfStillInCallingState = true;
        //this.callingStateTimeoutCount = count;
    }

    
    public class TransactionTimer extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.123 -0400", hash_original_method = "7764BAFD5C7951E95371726125E892CE", hash_generated_method = "33DB74724AFAD3CA3F59EFA77CA701E3")
        @DSModeled(DSC.SAFE)
        public TransactionTimer() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.124 -0400", hash_original_method = "0968D865D1ED49C59C7D505E50E4DC62", hash_generated_method = "A3DE3DA2F9663E84A0A23882F043A752")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            SIPClientTransaction clientTransaction;
            SIPTransactionStack sipStack;
            clientTransaction = SIPClientTransaction.this;
            sipStack = clientTransaction.sipStack;
            {
                boolean var9F4C96123B1B2399496D6DB2BFC9D362_1130983871 = (clientTransaction.isTerminated());
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_2049044774 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(
                            "removing  = " + clientTransaction + " isReliable "
                                    + clientTransaction.isReliable());
                        } //End block
                    } //End collapsed parenthetic
                    sipStack.removeTransaction(clientTransaction);
                    try 
                    {
                        this.cancel();
                    } //End block
                    catch (IllegalStateException ex)
                    {
                        {
                            boolean var5D283AADF1997C78E711029DD9E27848_237279070 = (!sipStack.isAlive());
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var5EAB7D490A2004CB739C2EE1D432A355_766479336 = ((!sipStack.cacheClientConnections) && clientTransaction.isReliable());
                        {
                            int newUseCount;
                            newUseCount = --clientTransaction.getMessageChannel().useCount;
                            {
                                TimerTask myTimer;
                                myTimer = new LingerTimer();
                                sipStack.getTimer().schedule(myTimer,
                                SIPTransactionStack.CONNECTION_LINGER_TIME * 1000);
                            } //End block
                        } //End block
                        {
                            {
                                boolean var019DA47345C39D3ADBD663314E9F0EF1_1707501241 = (sipStack.isLoggingEnabled() && clientTransaction.isReliable());
                                {
                                    int useCount;
                                    useCount = clientTransaction.getMessageChannel().useCount;
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1239676627 = (sipStack.isLoggingEnabled());
                                        sipStack.getStackLogger().logDebug("Client Use Count = " + useCount);
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    clientTransaction.fireTimer();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
}

