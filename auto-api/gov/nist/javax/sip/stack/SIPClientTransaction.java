package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.842 -0400", hash_original_field = "9D1B3F5D17ED1B162A9028E26EB002CF", hash_generated_field = "4FD467E2912A8CCA6B0DF0BC8D0D1212")

    private ConcurrentHashMap<String,SIPDialog> sipDialogs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.842 -0400", hash_original_field = "F4C9163F3B67F1BAF07814D81D1A5BFF", hash_generated_field = "609F87DF574B03997F5F114A0B9D153C")

    private SIPRequest lastRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.843 -0400", hash_original_field = "9FF65E805E77272D5E272AE178834E8E", hash_generated_field = "EBCE51BBA382AA4A4CBC72431B4DD4F6")

    private int viaPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.843 -0400", hash_original_field = "08E65A0B18A72698816D81C11CBA7C86", hash_generated_field = "638E6682C500E41733363C20AADC9C2B")

    private String viaHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.843 -0400", hash_original_field = "C2F5B0984A31E2BF00C102C547210A78", hash_generated_field = "D5BADECCFB140300052474F1FF053995")

    private transient ServerResponseInterface respondTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.843 -0400", hash_original_field = "F86AD9818A501BA0007B6D4CB23A57E7", hash_generated_field = "9DA006915F9968E7F19F133BB3970E72")

    private SIPDialog defaultDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.843 -0400", hash_original_field = "75129D9368F303477B6712550E089B5E", hash_generated_field = "B633077E034AF130A4E0928C373CBB0D")

    private Hop nextHop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.843 -0400", hash_original_field = "A6A57E5FB85DB2354843F5CFC0F10126", hash_generated_field = "F8A9EE3383846FA140533EA0DC849D5A")

    private boolean notifyOnRetransmit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.843 -0400", hash_original_field = "3375F1DE75A740A2863FD66BD8AF168D", hash_generated_field = "3AFD3FC295AA4B6D90EAF77E52351862")

    private boolean timeoutIfStillInCallingState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.843 -0400", hash_original_field = "E6FA2A24AC6D7E8AC19BEC7E11CB1C83", hash_generated_field = "5D7F837D171773BD9460FE3577E94E41")

    private int callingStateTimeoutCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.844 -0400", hash_original_method = "7433B8F0086E8DE587CA3684570FA4BD", hash_generated_method = "F446C8378D46C4C591943F6C4453D6BE")
    protected  SIPClientTransaction(SIPTransactionStack newSIPStack, MessageChannel newChannelToUse) {
        super(newSIPStack, newChannelToUse);
        setBranch(Utils.getInstance().generateBranchId());
        this.messageProcessor = newChannelToUse.messageProcessor;
        this.setEncapsulatedChannel(newChannelToUse);
        this.notifyOnRetransmit = false;
        this.timeoutIfStillInCallingState = false;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1842544249 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Creating clientTransaction " + this);
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
        this.sipDialogs = new ConcurrentHashMap();
        addTaint(newSIPStack.getTaint());
        addTaint(newChannelToUse.getTaint());
        
        
        
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.844 -0400", hash_original_method = "A499701B9B92E6B9F8BD35BBCEA7DB79", hash_generated_method = "E8641FFD5DB306D377A8EE6DEF3BC1FC")
    public void setResponseInterface(ServerResponseInterface newRespondTo) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1575599783 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "Setting response interface for " + this + " to " + newRespondTo);
                {
                    sipStack.getStackLogger().logStackTrace();
                    sipStack.getStackLogger().logDebug("WARNING -- setting to null!");
                } 
            } 
        } 
        respondTo = newRespondTo;
        
        
            
                    
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.845 -0400", hash_original_method = "2565B9EE896335E27EEEABBB213A9C77", hash_generated_method = "D69DCCD30D92186EAEE5FFE761A8AECE")
    public MessageChannel getRequestChannel() {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_348289229 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_348289229 = this;
        varB4EAC82CA7396A68D541C85D26508E83_348289229.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_348289229;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.846 -0400", hash_original_method = "C99C4952C168074F3FBA7AB2C1372665", hash_generated_method = "BB32765329D0C34389A1BB5FD9FAC807")
    public boolean isMessagePartOfTransaction(SIPMessage messageToTest) {
        ViaList viaHeaders = messageToTest.getViaHeaders();
        boolean transactionMatches;
        String messageBranch = ((Via) viaHeaders.getFirst()).getBranch();
        boolean rfc3261Compliant = getBranch() != null
                && messageBranch != null
                && getBranch().toLowerCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)
                && messageBranch.toLowerCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE);
        transactionMatches = false;
        {
            boolean var2F79CB4BCABBD5F3A433F945127DDBD2_256928596 = (TransactionState.COMPLETED == this.getState());
            {
                {
                    transactionMatches = getBranch().equalsIgnoreCase(
                        ((Via) viaHeaders.getFirst()).getBranch())
                        && getMethod().equals(messageToTest.getCSeq().getMethod());
                } 
                {
                    transactionMatches = getBranch().equals(messageToTest.getTransactionId());
                } 
            } 
            {
                boolean var4F6CD6D8A31BF3B11E9F83A356F12FC6_1054347131 = (!isTerminated());
                {
                    {
                        {
                            {
                                boolean var5CEA4B7C3D6656CEEE85E8A7100BD5A9_151084922 = (getBranch().equalsIgnoreCase(((Via) viaHeaders.getFirst()).getBranch()));
                                {
                                    transactionMatches = getOriginalRequest().getCSeq().getMethod().equals(
                                messageToTest.getCSeq().getMethod());
                                } 
                            } 
                        } 
                    } 
                    {
                        {
                            boolean var96AF238F72E19E08C6B3BF39DB7BF3FD_675446482 = (getBranch() != null);
                            {
                                transactionMatches = getBranch().equalsIgnoreCase(
                            messageToTest.getTransactionId());
                            } 
                            {
                                transactionMatches = getOriginalRequest().getTransactionId()
                            .equalsIgnoreCase(messageToTest.getTransactionId());
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(messageToTest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580865364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_580865364;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.848 -0400", hash_original_method = "1DFD8968C3CA232EAF5E448E3048EE02", hash_generated_method = "3A5EBD8897E07D41E94C88C8DFB4AF86")
    public void sendMessage(SIPMessage messageToSend) throws IOException {
        try 
        {
            SIPRequest transactionRequest;
            transactionRequest = (SIPRequest) messageToSend;
            Via topVia = (Via) transactionRequest.getViaHeaders().getFirst();
            try 
            {
                topVia.setBranch(getBranch());
            } 
            catch (java.text.ParseException ex)
            { }
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1765670466 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("Sending Message " + messageToSend);
                    sipStack.getStackLogger().logDebug("TransactionState " + this.getState());
                } 
            } 
            {
                boolean var219D65251EB1FDB59693C07BE2A172E8_1046523431 = (TransactionState.PROCEEDING == getState()
                    || TransactionState.CALLING == getState());
                {
                    {
                        boolean var8D053AB4B3CFB63570DCA353E515296A_499813063 = (transactionRequest.getMethod().equals(Request.ACK));
                        {
                            {
                                boolean varAA2EB0E74B91BC9EF1AAA23EA709EFB9_7724632 = (isReliable());
                                {
                                    this.setState(TransactionState.TERMINATED);
                                } 
                                {
                                    this.setState(TransactionState.COMPLETED);
                                } 
                            } 
                            super.sendMessage(transactionRequest);
                        } 
                    } 
                } 
            } 
            try 
            {
                lastRequest = transactionRequest;
                {
                    boolean varC69030881E0CB32D3F6B7D9BAF47F033_1846400794 = (getState() == null);
                    {
                        setOriginalRequest(transactionRequest);
                        {
                            boolean varF62BD1B6240A1DE079CC44210FB08681_84114852 = (transactionRequest.getMethod().equals(Request.INVITE));
                            {
                                this.setState(TransactionState.CALLING);
                            } 
                            {
                                boolean var9E22013ED427D36FC8A42917F8A06467_674238166 = (transactionRequest.getMethod().equals(Request.ACK));
                                {
                                    this.setState(TransactionState.TERMINATED);
                                } 
                                {
                                    this.setState(TransactionState.TRYING);
                                } 
                            } 
                        } 
                        {
                            boolean var6400A483252621139629FC45C6113F96_364783528 = (!isReliable());
                            {
                                enableRetransmissionTimer();
                            } 
                        } 
                        {
                            boolean var90CDBC638C52197AEFD58A39118A4F7B_2050071033 = (isInviteTransaction());
                            {
                                enableTimeoutTimer(TIMER_B);
                            } 
                            {
                                enableTimeoutTimer(TIMER_F);
                            } 
                        } 
                    } 
                } 
                super.sendMessage(transactionRequest);
            } 
            catch (IOException e)
            {
                this.setState(TransactionState.TERMINATED);
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
        } 
        finally 
        {
            this.isMapped = true;
            this.startTransactionTimer();
        } 
        addTaint(messageToSend.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.848 -0400", hash_original_method = "27FC8E987828EB63A48AA2B14048F41C", hash_generated_method = "3D1096A3D4A282E096D7DA9D75B42BEF")
    public synchronized void processResponse(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog dialog) {
        {
            boolean varE76D73BC71B270FCC7DC9D3198957423_2002543046 = (getState() == null);
        } 
        {
            boolean varA2852360A07253ACD3CD7CE5D8204CAB_1687348799 = ((TransactionState.COMPLETED == this.getState() || TransactionState.TERMINATED == this
                .getState())
                && transactionResponse.getStatusCode() / 100 == 1);
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1423688598 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "processing " + transactionResponse.getFirstLine() + "current state = "
                            + getState());
                sipStack.getStackLogger().logDebug("dialog = " + dialog);
            } 
        } 
        this.lastResponse = transactionResponse;
        try 
        {
            {
                boolean varF126D802AC06D34E85E28E6209C2BC97_1586648462 = (isInviteTransaction());
                inviteClientTransaction(transactionResponse, sourceChannel, dialog);
                nonInviteClientTransaction(transactionResponse, sourceChannel, dialog);
            } 
        } 
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_187077538 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } 
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } 
        addTaint(transactionResponse.getTaint());
        addTaint(sourceChannel.getTaint());
        addTaint(dialog.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.849 -0400", hash_original_method = "ADF3D75C6ADD47CBC6B3D63B5D3998CF", hash_generated_method = "651404ED2F0910E528C2497A0A312777")
    private void nonInviteClientTransaction(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog sipDialog) throws IOException {
        int statusCode = transactionResponse.getStatusCode();
        {
            boolean varC968CD9C1FC4F438A611F7A7272EB280_33901212 = (TransactionState.TRYING == this.getState());
            {
                {
                    this.setState(TransactionState.PROCEEDING);
                    enableRetransmissionTimer(MAXIMUM_RETRANSMISSION_TICK_COUNT);
                    enableTimeoutTimer(TIMER_F);
                    {
                        respondTo.processResponse(transactionResponse, this, sipDialog);
                    } 
                    {
                        this.semRelease();
                    } 
                } 
                {
                    {
                        respondTo.processResponse(transactionResponse, this, sipDialog);
                    } 
                    {
                        this.semRelease();
                    } 
                    {
                        boolean varE50099A69BBB2F1277A12DA84DAC7141_905691852 = (!isReliable());
                        {
                            this.setState(TransactionState.COMPLETED);
                            enableTimeoutTimer(TIMER_K);
                        } 
                        {
                            this.setState(TransactionState.TERMINATED);
                        } 
                    } 
                } 
            } 
            {
                boolean varDE96CE40FAB1EC19FEE71BD4FF3FF6A4_1470872836 = (TransactionState.PROCEEDING == this.getState());
                {
                    {
                        {
                            respondTo.processResponse(transactionResponse, this, sipDialog);
                        } 
                        {
                            this.semRelease();
                        } 
                    } 
                    {
                        {
                            respondTo.processResponse(transactionResponse, this, sipDialog);
                        } 
                        {
                            this.semRelease();
                        } 
                        disableRetransmissionTimer();
                        disableTimeoutTimer();
                        {
                            boolean var6400A483252621139629FC45C6113F96_1517077882 = (!isReliable());
                            {
                                this.setState(TransactionState.COMPLETED);
                                enableTimeoutTimer(TIMER_K);
                            } 
                            {
                                this.setState(TransactionState.TERMINATED);
                            } 
                        } 
                    } 
                } 
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1293562285 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(
                        " Not sending response to TU! " + getState());
                        } 
                    } 
                    this.semRelease();
                } 
            } 
        } 
        addTaint(transactionResponse.getTaint());
        addTaint(sourceChannel.getTaint());
        addTaint(sipDialog.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.851 -0400", hash_original_method = "C74AAAAD68DF1265333F033333BC207B", hash_generated_method = "48B14FB587173ADBC0E7297941C080EA")
    private void inviteClientTransaction(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog dialog) throws IOException {
        int statusCode = transactionResponse.getStatusCode();
        {
            boolean var3E1810922DAA236CCE1F0B7509376A43_1298411574 = (TransactionState.TERMINATED == this.getState());
            {
                boolean ackAlreadySent = false;
                {
                    boolean var19306E120BE9D264E51B259436F37B29_1284546219 = (dialog != null && dialog.isAckSeen() && dialog.getLastAckSent() != null);
                    {
                        {
                            boolean varBF822AAB6CF61DD6130DC2E8CF7B1D87_1236414419 = (dialog.getLastAckSent().getCSeq().getSeqNumber() == transactionResponse.getCSeq()
                        .getSeqNumber()
                        && transactionResponse.getFromTag().equals(
                                dialog.getLastAckSent().getFromTag()));
                            {
                                ackAlreadySent = true;
                            } 
                        } 
                    } 
                } 
                {
                    boolean varEC1CFF0A2A82B6BD98A9B67A0D47F0E0_1021017169 = (dialog!= null && ackAlreadySent
                    && transactionResponse.getCSeq().getMethod().equals(dialog.getMethod()));
                    {
                        try 
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1462398066 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("resending ACK");
                            } 
                            dialog.resendAck();
                        } 
                        catch (SipException ex)
                        { }
                    } 
                } 
                this.semRelease();
            } 
            {
                boolean var6AABC11187F015DBC15DBF91F29746C6_439038760 = (TransactionState.CALLING == this.getState());
                {
                    {
                        disableRetransmissionTimer();
                        disableTimeoutTimer();
                        this.setState(TransactionState.TERMINATED);
                        respondTo.processResponse(transactionResponse, this, dialog);
                        {
                            this.semRelease();
                        } 
                    } 
                    {
                        disableRetransmissionTimer();
                        disableTimeoutTimer();
                        this.setState(TransactionState.PROCEEDING);
                        respondTo.processResponse(transactionResponse, this, dialog);
                        {
                            this.semRelease();
                        } 
                    } 
                    {
                        try 
                        {
                            sendMessage((SIPRequest) createErrorAck());
                        } 
                        catch (Exception ex)
                        {
                            sipStack.getStackLogger().logError(
                            "Unexpected Exception sending ACK -- sending error AcK ", ex);
                        } 
                        {
                            respondTo.processResponse(transactionResponse, this, dialog);
                        } 
                        {
                            this.semRelease();
                        } 
                        {
                            boolean varEE55C49A27AE3B7CBFE2F02F6CDDC5E9_149296173 = (this.getDialog() != null &&  ((SIPDialog)this.getDialog()).isBackToBackUserAgent());
                            {
                                ((SIPDialog) this.getDialog()).releaseAckSem();
                            } 
                        } 
                        {
                            boolean var6400A483252621139629FC45C6113F96_1268000651 = (!isReliable());
                            {
                                this.setState(TransactionState.COMPLETED);
                                enableTimeoutTimer(TIMER_D);
                            } 
                            {
                                this.setState(TransactionState.TERMINATED);
                            } 
                        } 
                    } 
                } 
                {
                    boolean varD4C99897269968D7787452ACF03B2454_1093265368 = (TransactionState.PROCEEDING == this.getState());
                    {
                        {
                            {
                                respondTo.processResponse(transactionResponse, this, dialog);
                            } 
                            {
                                this.semRelease();
                            } 
                        } 
                        {
                            this.setState(TransactionState.TERMINATED);
                            {
                                respondTo.processResponse(transactionResponse, this, dialog);
                            } 
                            {
                                this.semRelease();
                            } 
                        } 
                        {
                            try 
                            {
                                sendMessage((SIPRequest) createErrorAck());
                            } 
                            catch (Exception ex)
                            {
                                InternalErrorHandler.handleException(ex);
                            } 
                            {
                                boolean var21341DE354DBCBD7F5D753D406CC2DD6_1519963627 = (this.getDialog() != null);
                                {
                                    ((SIPDialog) this.getDialog()).releaseAckSem();
                                } 
                            } 
                            {
                                boolean var22210305B3706CCEBD8C0B502050721F_1038007628 = (!isReliable());
                                {
                                    this.setState(TransactionState.COMPLETED);
                                    this.enableTimeoutTimer(TIMER_D);
                                } 
                                {
                                    this.setState(TransactionState.TERMINATED);
                                } 
                            } 
                            respondTo.processResponse(transactionResponse, this, dialog);
                            {
                                this.semRelease();
                            } 
                        } 
                    } 
                    {
                        boolean var8C1A7878C3537DB42D996A959ACB223D_1529548908 = (TransactionState.COMPLETED == this.getState());
                        {
                            {
                                try 
                                {
                                    sendMessage((SIPRequest) createErrorAck());
                                } 
                                catch (Exception ex)
                                {
                                    InternalErrorHandler.handleException(ex);
                                } 
                                finally 
                                {
                                    this.semRelease();
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(transactionResponse.getTaint());
        addTaint(sourceChannel.getTaint());
        addTaint(dialog.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.852 -0400", hash_original_method = "9C1F15FBE6A7795E5EE0D6BE4F94BCBE", hash_generated_method = "C7AE6160A0BDDFE2AC116513040C9556")
    public void sendRequest() throws SipException {
        SIPRequest sipRequest = this.getOriginalRequest();
        {
            boolean var5F3B63336C4433C300EDF029038A6C22_1999617907 = (this.getState() != null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Request already sent");
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1835181098 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("sendRequest() " + sipRequest);
            } 
        } 
        try 
        {
            sipRequest.checkHeaders();
        } 
        catch (ParseException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1755021939 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError("missing required header");
            } 
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex.getMessage());
        } 
        {
            boolean var820257507A310D8AF36355A9AD2BA48D_179899700 = (getMethod().equals(Request.SUBSCRIBE)
                && sipRequest.getHeader(ExpiresHeader.NAME) == null);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_754870698 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logWarning(
                    "Expires header missing in outgoing subscribe --"
                            + " Notifier will assume implied value on event package");
                } 
            } 
        } 
        try 
        {
            {
                boolean var318B68FE13188E5CF00AFCF6916271A5_1387827013 = (this.getOriginalRequest().getMethod().equals(Request.CANCEL)
                    && sipStack.isCancelClientTransactionChecked());
                {
                    SIPClientTransaction ct = (SIPClientTransaction) sipStack.findCancelTransaction(
                        this.getOriginalRequest(), false);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("Could not find original tx to cancel. RFC 3261 9.1");
                    } 
                    {
                        boolean varEA0B50AF0098703E4B38DDE85F0C6921_1321353767 = (ct.getState() == null);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SipException(
                            "State is null no provisional response yet -- cannot cancel RFC 3261 9.1");
                        } 
                        {
                            boolean varA13443824E4796F0FD53BAC050780DAB_2042315791 = (!ct.getMethod().equals(Request.INVITE));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot cancel non-invite requests RFC 3261 9.1");
                            } 
                        } 
                    } 
                } 
                {
                    boolean varD4977AF0B5B23F4157209F1FCE74E90F_571176772 = (this.getOriginalRequest().getMethod().equals(Request.BYE)
                    || this.getOriginalRequest().getMethod().equals(Request.NOTIFY));
                    {
                        SIPDialog dialog = sipStack.getDialog(this.getOriginalRequest()
                        .getDialogId(false));
                        {
                            boolean var8ABAC142ED80BB89B4590C8EA00C5515_99729284 = (this.getSipProvider().isAutomaticDialogSupportEnabled() && dialog != null);
                            {
                                if (DroidSafeAndroidRuntime.control) throw new SipException(
                            "Dialog is present and AutomaticDialogSupport is enabled for "
                                    + " the provider -- Send the Request using the Dialog.sendRequest(transaction)");
                            } 
                        } 
                    } 
                } 
            } 
            {
                boolean var812EAB2B90D4924E111DE9ACDFD47D2D_1335581572 = (this.getMethod().equals(Request.INVITE));
                {
                    SIPDialog dialog = this.getDefaultDialog();
                    {
                        boolean varC7B62845BBFBCF228194AFDC8EE17A0F_1032760168 = (dialog != null && dialog.isBackToBackUserAgent());
                        {
                            {
                                boolean var0AAD1CBCC17317BC020B7366C0E43AD5_1245357346 = (! dialog.takeAckSem());
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new SipException ("Failed to take ACK semaphore");
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            this.isMapped = true;
            this.sendMessage(sipRequest);
        } 
        catch (IOException ex)
        {
            this.setState(TransactionState.TERMINATED);
            if (DroidSafeAndroidRuntime.control) throw new SipException("IO Error sending request", ex);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.853 -0400", hash_original_method = "328DA368C3B0C5FF79EC2B4ACE66A1A9", hash_generated_method = "4D36646588B7DF0BA30205F525E06B2A")
    protected void fireRetransmissionTimer() {
        try 
        {
            {
                boolean varF34F8E24C31250F5E4052AC1FB7D63CE_1777611433 = (this.getState() == null || !this.isMapped);
            } 
            boolean inv = isInviteTransaction();
            TransactionState s = this.getState();
            {
                {
                    {
                        boolean var362664B439C1234CDC3CE46AD8B5EC7F_864979444 = (sipStack.generateTimeStampHeader
                            && lastRequest.getHeader(TimeStampHeader.NAME) != null);
                        {
                            long milisec = System.currentTimeMillis();
                            TimeStamp timeStamp = new TimeStamp();
                            try 
                            {
                                timeStamp.setTimeStamp(milisec);
                            } 
                            catch (InvalidArgumentException ex)
                            {
                                InternalErrorHandler.handleException(ex);
                            } 
                            lastRequest.setHeader(timeStamp);
                        } 
                    } 
                    super.sendMessage(lastRequest);
                    {
                        TimeoutEvent txTimeout = new TimeoutEvent(this.getSipProvider(), this,
                                Timeout.RETRANSMIT);
                        this.getSipProvider().handleEvent(txTimeout, this);
                    } 
                    {
                        boolean var55B500A3FDF003CB88EA4E921DECAEA2_2057216452 = (this.timeoutIfStillInCallingState
                            && this.getState() == TransactionState.CALLING);
                        {
                            {
                                TimeoutEvent timeoutEvent = new TimeoutEvent(this.getSipProvider(),
                                    this, Timeout.RETRANSMIT);
                                this.getSipProvider().handleEvent(timeoutEvent, this);
                                this.timeoutIfStillInCallingState = false;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        catch (IOException e)
        {
            this.raiseIOExceptionEvent();
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.854 -0400", hash_original_method = "F0DB4D0E841E14FF88BA6095928288BF", hash_generated_method = "17445719A176F04EA0B67C9E19CA5AFC")
    protected void fireTimeoutTimer() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_160594403 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("fireTimeoutTimer " + this);
        } 
        SIPDialog dialog = (SIPDialog) this.getDialog();
        {
            boolean varC9F46915C5C0D473164D5D23DADB13DA_806829303 = (TransactionState.CALLING == this.getState()
                || TransactionState.TRYING == this.getState()
                || TransactionState.PROCEEDING == this.getState());
            {
                {
                    boolean var55AB3B53A0926BE91060C867235A4DEA_1335956097 = (dialog != null
                    && (dialog.getState() == null || dialog.getState() == DialogState.EARLY));
                    {
                        {
                            boolean var242BDFFA40347198F760BB7493B3A654_416819508 = (((SIPTransactionStack) getSIPStack()).isDialogCreated(this
                        .getOriginalRequest().getMethod()));
                            {
                                dialog.delete();
                            } 
                        } 
                    } 
                    {
                        {
                            boolean varC79FCB4848976BFC5400B5E95B3F8ACB_1907856795 = (getOriginalRequest().getMethod().equalsIgnoreCase(Request.BYE)
                        && dialog.isTerminatedOnBye());
                            {
                                dialog.delete();
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean var58BB9C9C8854A0CE328AD570113B87D4_25094033 = (TransactionState.COMPLETED != this.getState());
            {
                raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
                {
                    boolean var70A6005E7B48E353B69F5438AD3CE0FC_1513809806 = (this.getOriginalRequest().getMethod().equalsIgnoreCase(Request.CANCEL));
                    {
                        SIPClientTransaction inviteTx = (SIPClientTransaction) this.getOriginalRequest()
                        .getInviteTransaction();
                        {
                            boolean varC3A7C39326E116DEB20C0C14912483B7_264081271 = (inviteTx != null
                        && ((inviteTx.getState() == TransactionState.CALLING || inviteTx
                                .getState() == TransactionState.PROCEEDING))
                        && inviteTx.getDialog() != null);
                            {
                                inviteTx.setState(TransactionState.TERMINATED);
                            } 
                        } 
                    } 
                } 
            } 
            {
                this.setState(TransactionState.TERMINATED);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.855 -0400", hash_original_method = "2914559B80386C20A981D1BD82B7352B", hash_generated_method = "A75C791D348328209BDF890BB0626AFB")
    public Request createCancel() throws SipException {
        Request varB4EAC82CA7396A68D541C85D26508E83_1237645086 = null; 
        SIPRequest originalRequest = this.getOriginalRequest();
        if (DroidSafeAndroidRuntime.control) throw new SipException("Bad state " + getState());
        {
            boolean var360DD8E773A2E8A5ED1271BA39E980C5_142073595 = (!originalRequest.getMethod().equals(Request.INVITE));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Only INIVTE may be cancelled");
        } 
        {
            boolean var324A2F774D9632F9564E3561EDEA142B_2056330753 = (originalRequest.getMethod().equalsIgnoreCase(Request.ACK));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot Cancel ACK!");
            {
                SIPRequest cancelRequest = originalRequest.createCancelRequest();
                cancelRequest.setInviteTransaction(this);
                varB4EAC82CA7396A68D541C85D26508E83_1237645086 = cancelRequest;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1237645086.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1237645086;
        
        
        
            
        
            
        
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.856 -0400", hash_original_method = "59092618FB848453FA0559AC58047778", hash_generated_method = "04B1CAEAD29F36EC6CD52FB89ED09F59")
    public Request createAck() throws SipException {
        Request varB4EAC82CA7396A68D541C85D26508E83_895711128 = null; 
        Request varB4EAC82CA7396A68D541C85D26508E83_1867027082 = null; 
        SIPRequest originalRequest = this.getOriginalRequest();
        if (DroidSafeAndroidRuntime.control) throw new SipException("bad state " + getState());
        {
            boolean var23CDF0CAAEDB841CA67299E2DE2D191F_2030671781 = (getMethod().equalsIgnoreCase(Request.ACK));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot ACK an ACK!");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("bad Transaction state");
            } 
            {
                boolean var012D721CAF7801CBBD1DCFB98FA22683_701587943 = (lastResponse.getStatusCode() < 200);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_123673236 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("lastResponse = " + lastResponse);
                        } 
                    } 
                    if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot ACK a provisional response!");
                } 
            } 
        } 
        SIPRequest ackRequest = originalRequest.createAckRequest((To) lastResponse.getTo());
        RecordRouteList recordRouteList = lastResponse.getRecordRouteHeaders();
        {
            {
                boolean var7DAFF59FCF080B5E5F9653EE735BA443_1315934044 = (lastResponse.getContactHeaders() != null
                    && lastResponse.getStatusCode() / 100 != 3);
                {
                    Contact contact = (Contact) lastResponse.getContactHeaders().getFirst();
                    javax.sip.address.URI uri = (javax.sip.address.URI) contact.getAddress().getURI()
                        .clone();
                    ackRequest.setRequestURI(uri);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_895711128 = ackRequest;
        } 
        ackRequest.removeHeader(RouteHeader.NAME);
        RouteList routeList = new RouteList();
        ListIterator<RecordRoute> li = recordRouteList.listIterator(recordRouteList.size());
        {
            boolean var34E820506DA7A52D1D64148C53A15353_1681592694 = (li.hasPrevious());
            {
                RecordRoute rr = (RecordRoute) li.previous();
                Route route = new Route();
                route.setAddress((AddressImpl) ((AddressImpl) rr.getAddress()).clone());
                route.setParameters((NameValueList) rr.getParameters().clone());
                routeList.add(route);
            } 
        } 
        Contact contact = null;
        {
            boolean var782AA6724CEB5153F134EFA15DEC0D09_256624262 = (lastResponse.getContactHeaders() != null);
            {
                contact = (Contact) lastResponse.getContactHeaders().getFirst();
            } 
        } 
        {
            boolean var70FEFC8E2B4A4EA64B93BD56266D6258_71530969 = (!((SipURI) ((Route) routeList.getFirst()).getAddress().getURI()).hasLrParam());
            {
                Route route = null;
                {
                    route = new Route();
                    route.setAddress((AddressImpl) ((AddressImpl) (contact.getAddress())).clone());
                } 
                Route firstRoute = (Route) routeList.getFirst();
                routeList.removeFirst();
                javax.sip.address.URI uri = firstRoute.getAddress().getURI();
                ackRequest.setRequestURI(uri);
                routeList.add(route);
                ackRequest.addHeader(routeList);
            } 
            {
                {
                    javax.sip.address.URI uri = (javax.sip.address.URI) contact.getAddress().getURI()
                        .clone();
                    ackRequest.setRequestURI(uri);
                    ackRequest.addHeader(routeList);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1867027082 = ackRequest;
        Request varA7E53CE21691AB073D9660D615818899_1312207272; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1312207272 = varB4EAC82CA7396A68D541C85D26508E83_895711128;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1312207272 = varB4EAC82CA7396A68D541C85D26508E83_1867027082;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1312207272.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1312207272;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.858 -0400", hash_original_method = "C777E21FF4216BC8A7ADE1EB27ADDE8D", hash_generated_method = "BC37F83AC36252D869488BEB315EBD34")
    private final Request createErrorAck() throws SipException, ParseException {
        Request varB4EAC82CA7396A68D541C85D26508E83_1452087137 = null; 
        SIPRequest originalRequest = this.getOriginalRequest();
        if (DroidSafeAndroidRuntime.control) throw new SipException("bad state " + getState());
        {
            boolean var023D4CF241B205BA58114F71AFE92AC0_962924174 = (!getMethod().equals(Request.INVITE));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Can only ACK an INVITE!");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("bad Transaction state");
            } 
            {
                boolean var012D721CAF7801CBBD1DCFB98FA22683_197687384 = (lastResponse.getStatusCode() < 200);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1766808607 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("lastResponse = " + lastResponse);
                        } 
                    } 
                    if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot ACK a provisional response!");
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1452087137 = originalRequest.createErrorAck((To) lastResponse.getTo());
        varB4EAC82CA7396A68D541C85D26508E83_1452087137.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1452087137;
        
        
        
            
        
            
        
            
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.858 -0400", hash_original_method = "FADEF945106DA805CF02027B2BE28020", hash_generated_method = "F178A79F5020E3C9AEE90D08526F030A")
    protected void setViaPort(int port) {
        this.viaPort = port;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.859 -0400", hash_original_method = "0E538A29C97CB223EF1CD12A71C73074", hash_generated_method = "49F7B6C2EB4C3BA81CAAD6672E78455A")
    protected void setViaHost(String host) {
        this.viaHost = host;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.860 -0400", hash_original_method = "133D8E60A07873D19335FF91037EC663", hash_generated_method = "8C77084F83DA956A35960506093E182B")
    public int getViaPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352251860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352251860;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.861 -0400", hash_original_method = "BFF3BD5D9B7619BE758B5D7001336743", hash_generated_method = "D1F80CE8A4F06E1593140477F8FF4212")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1180059923 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1180059923 = this.viaHost;
        varB4EAC82CA7396A68D541C85D26508E83_1180059923.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1180059923;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.862 -0400", hash_original_method = "0750F8DA140E6BEE450B9743ACFD7E44", hash_generated_method = "8B7B430C1E555C5C659815C463E99DE8")
    public Via getOutgoingViaHeader() {
        Via varB4EAC82CA7396A68D541C85D26508E83_1463720794 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1463720794 = this.getMessageProcessor().getViaHeader();
        varB4EAC82CA7396A68D541C85D26508E83_1463720794.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1463720794;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.862 -0400", hash_original_method = "B250DD181A3373E2CC04255377753F31", hash_generated_method = "6CCA103991603EF3F3C26F3C09E7F13D")
    public void clearState() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.863 -0400", hash_original_method = "513C7C1329620A072B43100259C2C5F6", hash_generated_method = "C8772C8140D34BF7D58E5CDDA47C0806")
    public void setState(TransactionState newState) {
        {
            boolean var91759660CDF9DD647AB086394E273AE8_1348855061 = (newState == TransactionState.TERMINATED && this.isReliable()
                && (!getSIPStack().cacheClientConnections));
            {
                this.collectionTime = TIMER_J;
            } 
        } 
        {
            boolean var11BA604ADA2BF23D3E29AB36D807FF0A_696116030 = (super.getState() != TransactionState.COMPLETED
                && (newState == TransactionState.COMPLETED || newState == TransactionState.TERMINATED));
            {
                sipStack.decrementActiveClientTransactionCount();
            } 
        } 
        super.setState(newState);
        addTaint(newState.getTaint());
        
        
                
            
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.863 -0400", hash_original_method = "8AD9FEC5ADB8A6F1DFBB290459716C8C", hash_generated_method = "56FA4BF6844E9394FB9599F5741A706F")
    protected void startTransactionTimer() {
        {
            boolean var388A148DB1BAAE2BABBFD1571EA90BBF_1245703764 = (this.transactionTimerStarted.compareAndSet(false, true));
            {
                TimerTask myTimer = new TransactionTimer();
                {
                    boolean var7F2874EE26E943E6FA8451457423E55A_461204763 = (sipStack.getTimer() != null);
                    {
                        sipStack.getTimer().schedule(myTimer, BASE_TIMER_INTERVAL, BASE_TIMER_INTERVAL);
                    } 
                } 
            } 
        } 
        
        
	        
	        
	            
	        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.863 -0400", hash_original_method = "ACD8113ABC5B192A943EAFBD5656CA38", hash_generated_method = "9600A5B5EE9B39E2643E3ED4DD70BFBE")
    public void terminate() throws ObjectInUseException {
        this.setState(TransactionState.TERMINATED);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.864 -0400", hash_original_method = "8BA63F6111F6111C9CE6504A86A67BA3", hash_generated_method = "D42D32F61180476985CA663F977A74BB")
    public boolean checkFromTag(SIPResponse sipResponse) {
        String originalFromTag = ((SIPRequest) this.getRequest()).getFromTag();
        {
            {
                boolean var99721F8958DA05D67BDFDECFF1356658_1929502404 = (originalFromTag == null ^ sipResponse.getFrom().getTag() == null);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1177927698 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                    } 
                } 
            } 
            {
                boolean var711AEDA4725A65E5F56D20EAEDEFABA8_1383471510 = (originalFromTag != null
                    && !originalFromTag.equalsIgnoreCase(sipResponse.getFrom().getTag()));
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_9543370 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                    } 
                } 
            } 
        } 
        addTaint(sipResponse.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533488416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_533488416;
        
        
        
            
            	
            		
                
            
            
                    
            	
            		
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.865 -0400", hash_original_method = "38065D3AA78F19CFA0459E8A308EC067", hash_generated_method = "21B193EB0A917E60B9D8F049F1715C34")
    public void processResponse(SIPResponse sipResponse, MessageChannel incomingChannel) {
        SIPDialog dialog = null;
        String method = sipResponse.getCSeq().getMethod();
        String dialogId = sipResponse.getDialogId(false);
        {
            boolean varF84B7A52F01098BB8D5530B7462524E7_401770345 = (method.equals(Request.CANCEL) && lastRequest != null);
            {
                SIPClientTransaction ict = (SIPClientTransaction) lastRequest.getInviteTransaction();
                {
                    dialog = ict.defaultDialog;
                } 
            } 
            {
                dialog = this.getDialog(dialogId);
            } 
        } 
        {
            int code = sipResponse.getStatusCode();
            {
                boolean var67A22D552074C073387137665D71377F_1294521064 = ((code > 100 && code < 300)
            && (sipResponse.getToTag() != null || sipStack.isRfc2543Supported())
                    && sipStack.isDialogCreated(method));
                {
                    {
                        {
                            {
                                boolean varDFA55FC60A34539A3B46D425D6F76E02_485834914 = (sipResponse.getFromTag() != null);
                                {
                                    SIPResponse dialogResponse = defaultDialog.getLastResponse();
                                    String defaultDialogId = defaultDialog.getDialogId();
                                    {
                                        boolean varB75661995D0822CE25D549C01EA47284_360774002 = (dialogResponse == null
                                    || (method.equals(Request.SUBSCRIBE)
                                            && dialogResponse.getCSeq().getMethod().equals(
                                                    Request.NOTIFY) && defaultDialogId
                                            .equals(dialogId)));
                                        {
                                            defaultDialog.setLastResponse(this, sipResponse);
                                            dialog = defaultDialog;
                                        } 
                                        {
                                            dialog = sipStack.getDialog(dialogId);
                                            {
                                                {
                                                    boolean var5EE64698204564FF6C92AF522DB71698_251840601 = (defaultDialog.isAssigned());
                                                    {
                                                        dialog = sipStack.createDialog(this, sipResponse);
                                                    } 
                                                } 
                                            } 
                                        } 
                                    } 
                                    {
                                        this.setDialog(dialog, dialog.getDialogId());
                                    } 
                                    {
                                        sipStack.getStackLogger().logError("dialog is unexpectedly null",new NullPointerException());
                                    } 
                                } 
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Response without from-tag");
                                } 
                            } 
                        } 
                        {
                            {
                                dialog = sipStack.createDialog(this, sipResponse);
                                this.setDialog(dialog, dialog.getDialogId());
                            } 
                        } 
                    } 
                } 
                {
                    dialog = defaultDialog;
                } 
            } 
        } 
        {
            dialog.setLastResponse(this, sipResponse);
        } 
        this.processResponse(sipResponse, incomingChannel, dialog);
        addTaint(sipResponse.getTaint());
        addTaint(incomingChannel.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.866 -0400", hash_original_method = "A455A41B989A73F91883A443A89AF007", hash_generated_method = "5F73A26A6308399094A4C1C93C20FED2")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_536246645 = null; 
        Dialog retval = null;
        {
            boolean var2BC280353718DAEB81C02AFB0812A34C_660957359 = (this.lastResponse != null && this.lastResponse.getFromTag() != null
                && this.lastResponse.getToTag() != null
                && this.lastResponse.getStatusCode() != 100);
            {
                String dialogId = this.lastResponse.getDialogId(false);
                retval = (Dialog) getDialog(dialogId);
            } 
        } 
        {
            retval = (Dialog) this.defaultDialog;
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_604497788 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    " sipDialogs =  " + sipDialogs + " default dialog " + this.defaultDialog
                            + " retval " + retval);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_536246645 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_536246645.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_536246645;
        
        
        
                
                
            
            
        
        
            
        
        
            
                    
                            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.866 -0400", hash_original_method = "7CA3466B3B290C9233529520194EB8A2", hash_generated_method = "E9867FC55CF23B5B494CF60420FE0443")
    public SIPDialog getDialog(String dialogId) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_1573724677 = null; 
        SIPDialog retval = (SIPDialog) this.sipDialogs.get(dialogId);
        varB4EAC82CA7396A68D541C85D26508E83_1573724677 = retval;
        addTaint(dialogId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1573724677.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1573724677;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.867 -0400", hash_original_method = "9816411304542A0CA40176674DC457D1", hash_generated_method = "0BB01056B4A7B998D3B93A46966A75E3")
    public void setDialog(SIPDialog sipDialog, String dialogId) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1363463741 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "setDialog: " + dialogId + "sipDialog = " + sipDialog);
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_82394585 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError("NULL DIALOG!!");
            } 
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad dialog null");
        } 
        {
            this.defaultDialog = sipDialog;
            {
                boolean varED64600D3E444F188F7A3A5A4ABEAEFC_253416233 = (this.getMethod().equals(Request.INVITE) && this.getSIPStack().maxForkTime != 0);
                {
                    this.getSIPStack().addForkedClientTransaction(this);
                } 
            } 
        } 
        {
            boolean varDFE46D77BD33F7C2E2FA045C1E3DB93A_250017046 = (dialogId != null && sipDialog.getDialogId() != null);
            {
                this.sipDialogs.put(dialogId, sipDialog);
            } 
        } 
        addTaint(dialogId.getTaint());
        
        
            
                    
        
        	
        		
            
        
        
            
            
                
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.868 -0400", hash_original_method = "EC86D15857564E1427115ADA6B1A0784", hash_generated_method = "EE151DE6D324A4457E6B3A186C2225BA")
    public SIPDialog getDefaultDialog() {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_720144889 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_720144889 = this.defaultDialog;
        varB4EAC82CA7396A68D541C85D26508E83_720144889.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_720144889;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.868 -0400", hash_original_method = "BBF8312DD6859DF11BA280D3CE71F333", hash_generated_method = "92C54DFEBE82A33476818E16370481AA")
    public void setNextHop(Hop hop) {
        this.nextHop = hop;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.869 -0400", hash_original_method = "F8BB258224ADAD4254DDBC66AEC6C06F", hash_generated_method = "3CC82D22DD0301AF2188B1BF69AFA1C5")
    public Hop getNextHop() {
        Hop varB4EAC82CA7396A68D541C85D26508E83_1724255273 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1724255273 = nextHop;
        varB4EAC82CA7396A68D541C85D26508E83_1724255273.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1724255273;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.870 -0400", hash_original_method = "5A4A2DE6DA5EAFA8C9F9B9398CD98855", hash_generated_method = "77796E2667351045720A96FACE4561A1")
    public void setNotifyOnRetransmit(boolean notifyOnRetransmit) {
        this.notifyOnRetransmit = notifyOnRetransmit;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.871 -0400", hash_original_method = "27ED93829BD70EC80C4ABB0868670759", hash_generated_method = "239AE61043A588344AC71DE585340D5E")
    public boolean isNotifyOnRetransmit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355440538 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_355440538;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.871 -0400", hash_original_method = "E7190C5FA03F5363EA136DFEC0492C73", hash_generated_method = "A815816922C53FB5571D66EB4D353EEE")
    public void alertIfStillInCallingStateBy(int count) {
        this.timeoutIfStillInCallingState = true;
        this.callingStateTimeoutCount = count;
        
        
        
    }

    
    public class TransactionTimer extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.871 -0400", hash_original_method = "7764BAFD5C7951E95371726125E892CE", hash_generated_method = "33DB74724AFAD3CA3F59EFA77CA701E3")
        public  TransactionTimer() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.872 -0400", hash_original_method = "0968D865D1ED49C59C7D505E50E4DC62", hash_generated_method = "836956424E1B777B31F09CAD4358D70B")
        protected void runTask() {
            SIPClientTransaction clientTransaction;
            SIPTransactionStack sipStack;
            clientTransaction = SIPClientTransaction.this;
            sipStack = clientTransaction.sipStack;
            {
                boolean var9F4C96123B1B2399496D6DB2BFC9D362_1803987616 = (clientTransaction.isTerminated());
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_2027936106 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(
                            "removing  = " + clientTransaction + " isReliable "
                                    + clientTransaction.isReliable());
                        } 
                    } 
                    sipStack.removeTransaction(clientTransaction);
                    try 
                    {
                        this.cancel();
                    } 
                    catch (IllegalStateException ex)
                    {
                        {
                            boolean var5D283AADF1997C78E711029DD9E27848_77344600 = (!sipStack.isAlive());
                        } 
                    } 
                    {
                        boolean var5EAB7D490A2004CB739C2EE1D432A355_174925954 = ((!sipStack.cacheClientConnections) && clientTransaction.isReliable());
                        {
                            int newUseCount = --clientTransaction.getMessageChannel().useCount;
                            {
                                TimerTask myTimer = new LingerTimer();
                                sipStack.getTimer().schedule(myTimer,
                                SIPTransactionStack.CONNECTION_LINGER_TIME * 1000);
                            } 
                        } 
                        {
                            {
                                boolean var019DA47345C39D3ADBD663314E9F0EF1_130021181 = (sipStack.isLoggingEnabled() && clientTransaction.isReliable());
                                {
                                    int useCount = clientTransaction.getMessageChannel().useCount;
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1526467814 = (sipStack.isLoggingEnabled());
                                        sipStack.getStackLogger().logDebug("Client Use Count = " + useCount);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    clientTransaction.fireTimer();
                } 
            } 
            
            
        }

        
    }


    
}

