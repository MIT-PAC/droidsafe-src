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
    private boolean isStopped;
    private int refCount;
    private LinkedList pendingEvents = new LinkedList();
    private int[] eventMutex = { 0 };
    private SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.129 -0400", hash_original_method = "ABAFBB618BA49E3B8625E32FADC601ED", hash_generated_method = "1462E764EAE629E9AAD85E982B95740F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EventScanner(SipStackImpl sipStackImpl) {
        dsTaint.addTaint(sipStackImpl.dsTaint);
        this.pendingEvents = new LinkedList();
        Thread myThread;
        myThread = new Thread(this);
        myThread.setDaemon(false);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.129 -0400", hash_original_method = "ECD8E06DC4873A7C1CEDFF4BF8BB2937", hash_generated_method = "AD5B2262F75DA4EE43BEE7BD51AB7DD4")
    @DSModeled(DSC.SAFE)
    public void incrementRefcount() {
        // ---------- Original Method ----------
        //synchronized (eventMutex) {
            //this.refCount++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.130 -0400", hash_original_method = "A71B34BF35FB557BC1E9288C6E8DE3F6", hash_generated_method = "3D12B866F50D7469EA8DF164BD057B67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addEvent(EventWrapper eventWrapper) {
        dsTaint.addTaint(eventWrapper.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1176188979 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("addEvent " + eventWrapper);
        } //End collapsed parenthetic
        {
            pendingEvents.add(eventWrapper);
            eventMutex.notify();
        } //End block
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
    		//sipStack.getStackLogger().logDebug("addEvent " + eventWrapper);
        //synchronized (this.eventMutex) {
            //pendingEvents.add(eventWrapper);
            //eventMutex.notify();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.130 -0400", hash_original_method = "66FF7F77E84125B131D0D04138A3FE42", hash_generated_method = "15CA8A14BEEE9ABAAAE16BAC0C02E8B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.130 -0400", hash_original_method = "F0E51D59DB287FD1630B012799B48A4C", hash_generated_method = "C66616AFD8AF33AAF409EA16B9D85E3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.132 -0400", hash_original_method = "1FB221E344118E77FADF803461DF7CDF", hash_generated_method = "C98898C8BFBE9206CA714EB71CA9644B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deliverEvent(EventWrapper eventWrapper) {
        dsTaint.addTaint(eventWrapper.dsTaint);
        EventObject sipEvent;
        sipEvent = eventWrapper.sipEvent;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1907887235 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_916804007 = (sipStack.isLoggingEnabled());
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
                    boolean varABA408BBD63BFCD59CB650AF6E82158B_1789968415 = (tx != null && !tx.passToListener());
                    {
                        {
                            boolean varC3B5E7671D1E2105E5AC4017D9693676_1598449635 = (sipRequest.getMethod().equals(Request.ACK)
                            && tx.isInviteTransaction() &&
                            ( tx.getLastResponse().getStatusCode()/100 == 2 ||
                                sipStack.isNon2XXAckPassedToListener()));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1957373183 = (sipStack.isLoggingEnabled());
                                    sipStack
                                    .getStackLogger()
                                    .logDebug(
                                            "Detected broken client sending ACK with same branch! Passing...");
                                } //End collapsed parenthetic
                            } //End block
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_283158396 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug(
                                    "transaction already exists! " + tx);
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var7E0AF8DADF4AF1961B001AB80C9B77F2_283631975 = (sipStack.findPendingTransaction(sipRequest) != null);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1040713134 = (sipStack.isLoggingEnabled());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1304465957 = (sipStack.isLoggingEnabled());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_468978914 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_141989741 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                            "Done processing Message "
                                    + ((SIPRequest) (((RequestEvent) sipEvent)
                                            .getRequest())).getFirstLine());
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var2083A76A6D8AF74603B62F2F49401901_862483816 = (eventWrapper.transaction != null
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
                    boolean varC6D1EA0FBA4A15D7C8B243CC1A9F2443_487622977 = (eventWrapper.transaction.getOriginalRequest().getMethod()
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1285820126 = (sipStack.isLoggingEnabled());
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
                        boolean var7F4DBD75E39C7C0F71DEDD3AA5FA2992_1769178353 = ((sipDialog != null && (sipDialog.getState() == null || !sipDialog
                            .getState().equals(DialogState.TERMINATED)))
                            && (sipResponse.getStatusCode() == Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST || sipResponse
                                    .getStatusCode() == Response.REQUEST_TIMEOUT));
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1096019219 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                    "Removing dialog on 408 or 481 response");
                                } //End block
                            } //End collapsed parenthetic
                            sipDialog.doDeferredDelete();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varF75F1409CD905B3A8E1071A740610DAA_253152126 = (sipResponse.getCSeq().getMethod()
                            .equals(Request.INVITE)
                            && sipDialog != null
                            && sipResponse.getStatusCode() == 200);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1223421188 = (sipStack.isLoggingEnabled());
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
                    boolean var3EE2000A6C965E993857D46DE0969DC5_74870611 = (ct != null
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
                    boolean var3BD50EFD7081DE4BDD6DBC4E580257A7_1809811416 = (eventWrapper.transaction != null
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_2035761894 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_431051070 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1394584026 = (sipStack.isLoggingEnabled());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.133 -0400", hash_original_method = "5CCAE779A521C5AA39F7D74A098F474A", hash_generated_method = "C8B514E32C8FA0446D250BB2C2009968")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                        boolean var4F290D24366D7BE53D8AD1AE0ED7AC69_1661715401 = (pendingEvents.isEmpty());
                        {
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1111943750 = (sipStack.isLoggingEnabled());
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
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1079558468 = (sipStack.isLoggingEnabled());
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
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_586895426 = (iterator.hasNext());
                    {
                        eventWrapper = (EventWrapper) iterator.next();
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1299966456 = (sipStack.isLoggingEnabled());
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
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_424864683 = (sipStack.isLoggingEnabled());
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_586641463 = (sipStack.isLoggingEnabled());
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

