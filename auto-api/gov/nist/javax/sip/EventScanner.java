package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import gov.nist.javax.sip.stack.*;
import gov.nist.javax.sip.message.*;
import javax.sip.message.*;
import javax.sip.*;
import gov.nist.core.ThreadAuditor;

class EventScanner implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.372 -0400", hash_original_field = "DC3583D0854933870215DB386EA8D30E", hash_generated_field = "14EA4271F1CA4E544DF5B6D3AACE226C")

    private boolean isStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.372 -0400", hash_original_field = "1FDC49C806523B6E8C1509C3BF8BDC31", hash_generated_field = "FA603FB92FA509FB776643125A3C791C")

    private int refCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.372 -0400", hash_original_field = "2F257C654F11384A90D2E638E4BD28E3", hash_generated_field = "3C5E83405A53D5FBE5E156D2F74AA766")

    private LinkedList pendingEvents = new LinkedList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.372 -0400", hash_original_field = "C33F74E52313CD1C332E99C7F2371316", hash_generated_field = "541298A2BEEF8B73EB205968B699A50C")

    private int[] eventMutex = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.373 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.373 -0400", hash_original_method = "ABAFBB618BA49E3B8625E32FADC601ED", hash_generated_method = "A36BDF82DB6A086DE7528373F1430B45")
    public  EventScanner(SipStackImpl sipStackImpl) {
        this.pendingEvents = new LinkedList();
        Thread myThread;
        myThread = new Thread(this);
        myThread.setDaemon(false);
        this.sipStack = sipStackImpl;
        myThread.setName("EventScannerThread");
        myThread.start();
        // ---------- Original Method ----------
        //this.pendingEvents = new LinkedList();
        //Thread myThread = new Thread(this);
        //myThread.setDaemon(false);
        //this.sipStack = sipStackImpl;
        //myThread.setName("EventScannerThread");
        //myThread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.373 -0400", hash_original_method = "ECD8E06DC4873A7C1CEDFF4BF8BB2937", hash_generated_method = "AD5B2262F75DA4EE43BEE7BD51AB7DD4")
    public void incrementRefcount() {
        // ---------- Original Method ----------
        //synchronized (eventMutex) {
            //this.refCount++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.374 -0400", hash_original_method = "A71B34BF35FB557BC1E9288C6E8DE3F6", hash_generated_method = "A232889EB4E9E59F028C60670251A3D1")
    public void addEvent(EventWrapper eventWrapper) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1214370788 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("addEvent " + eventWrapper);
        } //End collapsed parenthetic
        {
            pendingEvents.add(eventWrapper);
            eventMutex.notify();
        } //End block
        addTaint(eventWrapper.getTaint());
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
    		//sipStack.getStackLogger().logDebug("addEvent " + eventWrapper);
        //synchronized (this.eventMutex) {
            //pendingEvents.add(eventWrapper);
            //eventMutex.notify();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.432 -0400", hash_original_method = "66FF7F77E84125B131D0D04138A3FE42", hash_generated_method = "15CA8A14BEEE9ABAAAE16BAC0C02E8B7")
    public void stop() {
        {
            {
                isStopped = true;
                eventMutex.notify();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (eventMutex) {
            //if (this.refCount > 0)
                //this.refCount--;
            //if (this.refCount == 0) {
                //isStopped = true;
                //eventMutex.notify();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.432 -0400", hash_original_method = "F0E51D59DB287FD1630B012799B48A4C", hash_generated_method = "C66616AFD8AF33AAF409EA16B9D85E3F")
    public void forceStop() {
        {
            this.isStopped = true;
            this.refCount = 0;
            this.eventMutex.notify();
        } //End block
        // ---------- Original Method ----------
        //synchronized (this.eventMutex) {
            //this.isStopped = true;
            //this.refCount = 0;
            //this.eventMutex.notify();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.441 -0400", hash_original_method = "1FB221E344118E77FADF803461DF7CDF", hash_generated_method = "B93C124D944A15ADFDF31F44E8A22338")
    public void deliverEvent(EventWrapper eventWrapper) {
        EventObject sipEvent;
        sipEvent = eventWrapper.sipEvent;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1571448758 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "sipEvent = " + sipEvent + "source = "
                            + sipEvent.getSource());
        } //End collapsed parenthetic
        SipListener sipListener;
        sipListener = null;
        {
            sipListener = ((SipProviderImpl) sipEvent.getSource()).getSipListener();
        } //End block
        {
            sipListener = sipStack.getSipListener();
        } //End block
        {
            try 
            {
                SIPRequest sipRequest;
                sipRequest = (SIPRequest) ((RequestEvent) sipEvent)
                        .getRequest();
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_2130868455 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                            "deliverEvent : "
                                    + sipRequest.getFirstLine()
                                    + " transaction "
                                    + eventWrapper.transaction
                                    + " sipEvent.serverTx = "
                                    + ((RequestEvent) sipEvent)
                                            .getServerTransaction());
                    } //End block
                } //End collapsed parenthetic
                SIPServerTransaction tx;
                tx = (SIPServerTransaction) sipStack
                        .findTransaction(sipRequest, true);
                {
                    boolean varABA408BBD63BFCD59CB650AF6E82158B_1309613739 = (tx != null && !tx.passToListener());
                    {
                        {
                            boolean varC3B5E7671D1E2105E5AC4017D9693676_697531258 = (sipRequest.getMethod().equals(Request.ACK)
                            && tx.isInviteTransaction() &&
                            ( tx.getLastResponse().getStatusCode()/100 == 2 ||
                                sipStack.isNon2XXAckPassedToListener()));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_552208509 = (sipStack.isLoggingEnabled());
                                    sipStack
                                    .getStackLogger()
                                    .logDebug(
                                            "Detected broken client sending ACK with same branch! Passing...");
                                } //End collapsed parenthetic
                            } //End block
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1538052802 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug(
                                    "transaction already exists! " + tx);
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var7E0AF8DADF4AF1961B001AB80C9B77F2_1453006070 = (sipStack.findPendingTransaction(sipRequest) != null);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_916418911 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug(
                                "transaction already exists!!");
                            } //End collapsed parenthetic
                        } //End block
                        {
                            SIPServerTransaction st;
                            st = (SIPServerTransaction) eventWrapper.transaction;
                            sipStack.putPendingTransaction(st);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                sipRequest.setTransaction(eventWrapper.transaction);
                try 
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_42927325 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger()
                                .logDebug(
                                        "Calling listener "
                                                + sipRequest.getFirstLine());
                            sipStack.getStackLogger().logDebug(
                                "Calling listener " + eventWrapper.transaction);
                        } //End block
                    } //End collapsed parenthetic
                    sipListener.processRequest((RequestEvent) sipEvent);
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1332829787 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(
                                "Done processing Message "
                                        + sipRequest.getFirstLine());
                        } //End block
                    } //End collapsed parenthetic
                    {
                        SIPDialog dialog;
                        dialog = (SIPDialog) eventWrapper.transaction
                                .getDialog();
                        dialog.requestConsumed();
                    } //End block
                } //End block
                catch (Exception ex)
                {
                    sipStack.getStackLogger().logException(ex);
                } //End block
            } //End block
            finally 
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_289867610 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                            "Done processing Message "
                                    + ((SIPRequest) (((RequestEvent) sipEvent)
                                            .getRequest())).getFirstLine());
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var2083A76A6D8AF74603B62F2F49401901_561512819 = (eventWrapper.transaction != null
                        && ((SIPServerTransaction) eventWrapper.transaction)
                                .passToListener());
                    {
                        ((SIPServerTransaction) eventWrapper.transaction)
                            .releaseSem();
                    } //End block
                } //End collapsed parenthetic
                sipStack
                            .removePendingTransaction((SIPServerTransaction) eventWrapper.transaction);
                {
                    boolean varC6D1EA0FBA4A15D7C8B243CC1A9F2443_1730527564 = (eventWrapper.transaction.getOriginalRequest().getMethod()
                        .equals(Request.ACK));
                    {
                        eventWrapper.transaction
                            .setState(TransactionState.TERMINATED);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            try 
            {
                ResponseEvent responseEvent;
                responseEvent = (ResponseEvent) sipEvent;
                SIPResponse sipResponse;
                sipResponse = (SIPResponse) responseEvent
                        .getResponse();
                SIPDialog sipDialog;
                sipDialog = ((SIPDialog) responseEvent.getDialog());
                try 
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1157804972 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(
                                "Calling listener for "
                                        + sipResponse.getFirstLine());
                        } //End block
                    } //End collapsed parenthetic
                    {
                        SIPTransaction tx;
                        tx = eventWrapper.transaction;
                        {
                            tx.setPassToListener();
                        } //End block
                        sipListener.processResponse((ResponseEvent) sipEvent);
                    } //End block
                    {
                        boolean var7F4DBD75E39C7C0F71DEDD3AA5FA2992_1746388411 = ((sipDialog != null && (sipDialog.getState() == null || !sipDialog
                            .getState().equals(DialogState.TERMINATED)))
                            && (sipResponse.getStatusCode() == Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST || sipResponse
                                    .getStatusCode() == Response.REQUEST_TIMEOUT));
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1197585762 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                    "Removing dialog on 408 or 481 response");
                                } //End block
                            } //End collapsed parenthetic
                            sipDialog.doDeferredDelete();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varF75F1409CD905B3A8E1071A740610DAA_1155130897 = (sipResponse.getCSeq().getMethod()
                            .equals(Request.INVITE)
                            && sipDialog != null
                            && sipResponse.getStatusCode() == 200);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_2106948905 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                    "Warning! unacknowledged dialog. " + sipDialog.getState());
                                } //End block
                            } //End collapsed parenthetic
                            sipDialog.doDeferredDeleteIfNoAckSent(sipResponse.getCSeq().getSeqNumber());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (Exception ex)
                {
                    sipStack.getStackLogger().logException(ex);
                } //End block
                SIPClientTransaction ct;
                ct = (SIPClientTransaction) eventWrapper.transaction;
                {
                    boolean var3EE2000A6C965E993857D46DE0969DC5_621789812 = (ct != null
                        && TransactionState.COMPLETED == ct.getState()
                        && ct.getOriginalRequest() != null
                        && !ct.getOriginalRequest().getMethod().equals(
                                Request.INVITE));
                    {
                        ct.clearState();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                {
                    boolean var3BD50EFD7081DE4BDD6DBC4E580257A7_265905652 = (eventWrapper.transaction != null
                        && eventWrapper.transaction.passToListener());
                    {
                        eventWrapper.transaction.releaseSem();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            try 
            {
                sipListener.processTimeout((TimeoutEvent) sipEvent);
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
        } //End block
        {
            try 
            {
                {
                    ((SipListenerExt)sipListener).processDialogTimeout((DialogTimeoutEvent) sipEvent);
                } //End block
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
        } //End block
        {
            try 
            {
                sipListener.processIOException((IOExceptionEvent) sipEvent);
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
        } //End block
        {
            try 
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_347374093 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                            "About to deliver transactionTerminatedEvent");
                        sipStack.getStackLogger().logDebug(
                            "tx = "
                                    + ((TransactionTerminatedEvent) sipEvent)
                                            .getClientTransaction());
                        sipStack.getStackLogger().logDebug(
                            "tx = "
                                    + ((TransactionTerminatedEvent) sipEvent)
                                            .getServerTransaction());
                    } //End block
                } //End collapsed parenthetic
                sipListener
                            .processTransactionTerminated((TransactionTerminatedEvent) sipEvent);
            } //End block
            catch (AbstractMethodError ame)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1057827494 = (sipStack.isLoggingEnabled());
                    sipStack
                        .getStackLogger()
                        .logWarning(
                                "Unable to call sipListener.processTransactionTerminated");
                } //End collapsed parenthetic
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
        } //End block
        {
            try 
            {
                sipListener
                            .processDialogTerminated((DialogTerminatedEvent) sipEvent);
            } //End block
            catch (AbstractMethodError ame)
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_444972978 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logWarning(
                        "Unable to call sipListener.processDialogTerminated");
                } //End collapsed parenthetic
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
        } //End block
        {
            sipStack.getStackLogger().logFatalError("bad event" + sipEvent);
        } //End block
        addTaint(eventWrapper.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.446 -0400", hash_original_method = "5CCAE779A521C5AA39F7D74A098F474A", hash_generated_method = "4F701CA20BA1D890A47E0209494CCA34")
    public void run() {
        try 
        {
            ThreadAuditor.ThreadHandle threadHandle;
            threadHandle = sipStack.getThreadAuditor().addCurrentThread();
            {
                EventWrapper eventWrapper;
                eventWrapper = null;
                LinkedList eventsToDeliver;
                {
                    {
                        boolean var4F290D24366D7BE53D8AD1AE0ED7AC69_730855915 = (pendingEvents.isEmpty());
                        {
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_7544043 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug(
                                        "Stopped event scanner!!");
                                } //End collapsed parenthetic
                            } //End block
                            try 
                            {
                                threadHandle.ping();
                                eventMutex.wait(threadHandle.getPingIntervalInMillisecs());
                            } //End block
                            catch (InterruptedException ex)
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1685167001 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug("Interrupted!");
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    eventsToDeliver = pendingEvents;
                    pendingEvents = new LinkedList();
                } //End block
                ListIterator iterator;
                iterator = eventsToDeliver.listIterator();
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_1270896140 = (iterator.hasNext());
                    {
                        eventWrapper = (EventWrapper) iterator.next();
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1904558807 = (sipStack.isLoggingEnabled());
                            {
                                sipStack.getStackLogger().logDebug(
                                "Processing " + eventWrapper + "nevents "
                                        + eventsToDeliver.size());
                            } //End block
                        } //End collapsed parenthetic
                        try 
                        {
                            deliverEvent(eventWrapper);
                        } //End block
                        catch (Exception e)
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_829113226 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logError(
                                    "Unexpected exception caught while delivering event -- carrying on bravely", e);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_2118412039 = (sipStack.isLoggingEnabled());
                {
                    {
                        sipStack.getStackLogger().logFatalError("Event scanner exited abnormally");
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

