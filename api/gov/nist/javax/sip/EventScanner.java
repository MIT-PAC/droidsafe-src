package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import gov.nist.javax.sip.stack.*;
import gov.nist.javax.sip.message.*;
import javax.sip.message.*;
import javax.sip.*;
import gov.nist.core.ThreadAuditor;

class EventScanner implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.465 -0400", hash_original_field = "DC3583D0854933870215DB386EA8D30E", hash_generated_field = "14EA4271F1CA4E544DF5B6D3AACE226C")

    private boolean isStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.466 -0400", hash_original_field = "1FDC49C806523B6E8C1509C3BF8BDC31", hash_generated_field = "FA603FB92FA509FB776643125A3C791C")

    private int refCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.466 -0400", hash_original_field = "2F257C654F11384A90D2E638E4BD28E3", hash_generated_field = "3C5E83405A53D5FBE5E156D2F74AA766")

    private LinkedList pendingEvents = new LinkedList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.466 -0400", hash_original_field = "C33F74E52313CD1C332E99C7F2371316", hash_generated_field = "467BA1CC5CE0750BC552D8D3070838DC")

    private int[] eventMutex = { 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.466 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.467 -0400", hash_original_method = "ABAFBB618BA49E3B8625E32FADC601ED", hash_generated_method = "640AE9DCA3DB4EFBAE34E349BE80A259")
    public  EventScanner(SipStackImpl sipStackImpl) {
        this.pendingEvents = new LinkedList();
        Thread myThread = new Thread(this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.467 -0400", hash_original_method = "ECD8E06DC4873A7C1CEDFF4BF8BB2937", hash_generated_method = "8922132426CA4DFC9E29A3D13CA8BAD1")
    public void incrementRefcount() {
        synchronized
(eventMutex)        {
            this.refCount++;
        } //End block
        // ---------- Original Method ----------
        //synchronized (eventMutex) {
            //this.refCount++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.468 -0400", hash_original_method = "A71B34BF35FB557BC1E9288C6E8DE3F6", hash_generated_method = "EE0F9CE3BD8341FB293279BC2F97C0A2")
    public void addEvent(EventWrapper eventWrapper) {
        addTaint(eventWrapper.getTaint());
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("addEvent " + eventWrapper);
        synchronized
(this.eventMutex)        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.472 -0400", hash_original_method = "66FF7F77E84125B131D0D04138A3FE42", hash_generated_method = "C1768E218AB02D6895B611755F1204FA")
    public void stop() {
        synchronized
(eventMutex)        {
    if(this.refCount > 0)            
            this.refCount--;
    if(this.refCount == 0)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.473 -0400", hash_original_method = "F0E51D59DB287FD1630B012799B48A4C", hash_generated_method = "5F44D689C5F207AE2B81454D4BA3AE06")
    public void forceStop() {
        synchronized
(this.eventMutex)        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.476 -0400", hash_original_method = "1FB221E344118E77FADF803461DF7CDF", hash_generated_method = "469FEA17AA20C391E32C7AED6A530B1E")
    public void deliverEvent(EventWrapper eventWrapper) {
        addTaint(eventWrapper.getTaint());
        EventObject sipEvent = eventWrapper.sipEvent;
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug(
                    "sipEvent = " + sipEvent + "source = "
                            + sipEvent.getSource());
        SipListener sipListener = null;
    if(!(sipEvent instanceof IOExceptionEvent))        
        {
            sipListener = ((SipProviderImpl) sipEvent.getSource()).getSipListener();
        } //End block
        else
        {
            sipListener = sipStack.getSipListener();
        } //End block
    if(sipEvent instanceof RequestEvent)        
        {
            try 
            {
                SIPRequest sipRequest = (SIPRequest) ((RequestEvent) sipEvent)
                        .getRequest();
    if(sipStack.isLoggingEnabled())                
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
                SIPServerTransaction tx = (SIPServerTransaction) sipStack
                        .findTransaction(sipRequest, true);
    if(tx != null && !tx.passToListener())                
                {
    if(sipRequest.getMethod().equals(Request.ACK)
                            && tx.isInviteTransaction() &&
                            ( tx.getLastResponse().getStatusCode()/100 == 2 ||
                                sipStack.isNon2XXAckPassedToListener()))                    
                    {
    if(sipStack.isLoggingEnabled())                        
                        sipStack
                                    .getStackLogger()
                                    .logDebug(
                                            "Detected broken client sending ACK with same branch! Passing...");
                    } //End block
                    else
                    {
    if(sipStack.isLoggingEnabled())                        
                        sipStack.getStackLogger().logDebug(
                                    "transaction already exists! " + tx);
                        return;
                    } //End block
                } //End block
                else
    if(sipStack.findPendingTransaction(sipRequest) != null)                
                {
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logDebug(
                                "transaction already exists!!");
                    return;
                } //End block
                else
                {
                    SIPServerTransaction st = (SIPServerTransaction) eventWrapper.transaction;
                    sipStack.putPendingTransaction(st);
                } //End block
                sipRequest.setTransaction(eventWrapper.transaction);
                try 
                {
    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger()
                                .logDebug(
                                        "Calling listener "
                                                + sipRequest.getFirstLine());
                        sipStack.getStackLogger().logDebug(
                                "Calling listener " + eventWrapper.transaction);
                    } //End block
    if(sipListener != null)                    
                    sipListener.processRequest((RequestEvent) sipEvent);
    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "Done processing Message "
                                        + sipRequest.getFirstLine());
                    } //End block
    if(eventWrapper.transaction != null)                    
                    {
                        SIPDialog dialog = (SIPDialog) eventWrapper.transaction
                                .getDialog();
    if(dialog != null)                        
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
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(
                            "Done processing Message "
                                    + ((SIPRequest) (((RequestEvent) sipEvent)
                                            .getRequest())).getFirstLine());
                } //End block
    if(eventWrapper.transaction != null
                        && ((SIPServerTransaction) eventWrapper.transaction)
                                .passToListener())                
                {
                    ((SIPServerTransaction) eventWrapper.transaction)
                            .releaseSem();
                } //End block
    if(eventWrapper.transaction != null)                
                sipStack
                            .removePendingTransaction((SIPServerTransaction) eventWrapper.transaction);
    if(eventWrapper.transaction.getOriginalRequest().getMethod()
                        .equals(Request.ACK))                
                {
                    eventWrapper.transaction
                            .setState(TransactionState.TERMINATED);
                } //End block
            } //End block
        } //End block
        else
    if(sipEvent instanceof ResponseEvent)        
        {
            try 
            {
                ResponseEvent responseEvent = (ResponseEvent) sipEvent;
                SIPResponse sipResponse = (SIPResponse) responseEvent
                        .getResponse();
                SIPDialog sipDialog = ((SIPDialog) responseEvent.getDialog());
                try 
                {
    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "Calling listener for "
                                        + sipResponse.getFirstLine());
                    } //End block
    if(sipListener != null)                    
                    {
                        SIPTransaction tx = eventWrapper.transaction;
    if(tx != null)                        
                        {
                            tx.setPassToListener();
                        } //End block
                        sipListener.processResponse((ResponseEvent) sipEvent);
                    } //End block
    if((sipDialog != null && (sipDialog.getState() == null || !sipDialog
                            .getState().equals(DialogState.TERMINATED)))
                            && (sipResponse.getStatusCode() == Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST || sipResponse
                                    .getStatusCode() == Response.REQUEST_TIMEOUT))                    
                    {
    if(sipStack.isLoggingEnabled())                        
                        {
                            sipStack.getStackLogger().logDebug(
                                    "Removing dialog on 408 or 481 response");
                        } //End block
                        sipDialog.doDeferredDelete();
                    } //End block
    if(sipResponse.getCSeq().getMethod()
                            .equals(Request.INVITE)
                            && sipDialog != null
                            && sipResponse.getStatusCode() == 200)                    
                    {
    if(sipStack.isLoggingEnabled())                        
                        {
                            sipStack.getStackLogger().logDebug(
                                    "Warning! unacknowledged dialog. " + sipDialog.getState());
                        } //End block
                        sipDialog.doDeferredDeleteIfNoAckSent(sipResponse.getCSeq().getSeqNumber());
                    } //End block
                } //End block
                catch (Exception ex)
                {
                    sipStack.getStackLogger().logException(ex);
                } //End block
                SIPClientTransaction ct = (SIPClientTransaction) eventWrapper.transaction;
    if(ct != null
                        && TransactionState.COMPLETED == ct.getState()
                        && ct.getOriginalRequest() != null
                        && !ct.getOriginalRequest().getMethod().equals(
                                Request.INVITE))                
                {
                    ct.clearState();
                } //End block
            } //End block
            finally 
            {
    if(eventWrapper.transaction != null
                        && eventWrapper.transaction.passToListener())                
                {
                    eventWrapper.transaction.releaseSem();
                } //End block
            } //End block
        } //End block
        else
    if(sipEvent instanceof TimeoutEvent)        
        {
            try 
            {
    if(sipListener != null)                
                sipListener.processTimeout((TimeoutEvent) sipEvent);
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
        } //End block
        else
    if(sipEvent instanceof DialogTimeoutEvent)        
        {
            try 
            {
    if(sipListener != null && sipListener instanceof SipListenerExt)                
                {
                    ((SipListenerExt)sipListener).processDialogTimeout((DialogTimeoutEvent) sipEvent);
                } //End block
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
        } //End block
        else
    if(sipEvent instanceof IOExceptionEvent)        
        {
            try 
            {
    if(sipListener != null)                
                sipListener.processIOException((IOExceptionEvent) sipEvent);
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
        } //End block
        else
    if(sipEvent instanceof TransactionTerminatedEvent)        
        {
            try 
            {
    if(sipStack.isLoggingEnabled())                
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
    if(sipListener != null)                
                sipListener
                            .processTransactionTerminated((TransactionTerminatedEvent) sipEvent);
            } //End block
            catch (AbstractMethodError ame)
            {
    if(sipStack.isLoggingEnabled())                
                sipStack
                        .getStackLogger()
                        .logWarning(
                                "Unable to call sipListener.processTransactionTerminated");
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
        } //End block
        else
    if(sipEvent instanceof DialogTerminatedEvent)        
        {
            try 
            {
    if(sipListener != null)                
                sipListener
                            .processDialogTerminated((DialogTerminatedEvent) sipEvent);
            } //End block
            catch (AbstractMethodError ame)
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logWarning(
                        "Unable to call sipListener.processDialogTerminated");
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
        } //End block
        else
        {
            sipStack.getStackLogger().logFatalError("bad event" + sipEvent);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.480 -0400", hash_original_method = "5CCAE779A521C5AA39F7D74A098F474A", hash_generated_method = "2529A2AAD0F5D7AA92835BB34E5EE903")
    public void run() {
        try 
        {
            ThreadAuditor.ThreadHandle threadHandle = sipStack.getThreadAuditor().addCurrentThread();
            while
(true)            
            {
                EventWrapper eventWrapper = null;
                LinkedList eventsToDeliver;
                synchronized
(this.eventMutex)                {
                    while
(pendingEvents.isEmpty())                    
                    {
    if(this.isStopped)                        
                        {
    if(sipStack.isLoggingEnabled())                            
                            sipStack.getStackLogger().logDebug(
                                        "Stopped event scanner!!");
                            return;
                        } //End block
                        try 
                        {
                            threadHandle.ping();
                            eventMutex.wait(threadHandle.getPingIntervalInMillisecs());
                        } //End block
                        catch (InterruptedException ex)
                        {
    if(sipStack.isLoggingEnabled())                            
                            sipStack.getStackLogger().logDebug("Interrupted!");
                            return;
                        } //End block
                    } //End block
                    eventsToDeliver = pendingEvents;
                    pendingEvents = new LinkedList();
                } //End block
                ListIterator iterator = eventsToDeliver.listIterator();
                while
(iterator.hasNext())                
                {
                    eventWrapper = (EventWrapper) iterator.next();
    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "Processing " + eventWrapper + "nevents "
                                        + eventsToDeliver.size());
                    } //End block
                    try 
                    {
                        deliverEvent(eventWrapper);
                    } //End block
                    catch (Exception e)
                    {
    if(sipStack.isLoggingEnabled())                        
                        {
                            sipStack.getStackLogger().logError(
                                    "Unexpected exception caught while delivering event -- carrying on bravely", e);
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        finally 
        {
    if(sipStack.isLoggingEnabled())            
            {
    if(!this.isStopped)                
                {
                    sipStack.getStackLogger().logFatalError("Event scanner exited abnormally");
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

