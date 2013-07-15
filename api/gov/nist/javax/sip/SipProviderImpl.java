package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.DialogTimeoutEvent.Reason;
import gov.nist.javax.sip.address.RouterExt;
import gov.nist.javax.sip.header.CallID;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import gov.nist.javax.sip.stack.HopImpl;
import gov.nist.javax.sip.stack.MessageChannel;
import gov.nist.javax.sip.stack.SIPClientTransaction;
import gov.nist.javax.sip.stack.SIPDialog;
import gov.nist.javax.sip.stack.SIPDialogErrorEvent;
import gov.nist.javax.sip.stack.SIPDialogEventListener;
import gov.nist.javax.sip.stack.SIPServerTransaction;
import gov.nist.javax.sip.stack.SIPTransaction;
import gov.nist.javax.sip.stack.SIPTransactionErrorEvent;
import gov.nist.javax.sip.stack.SIPTransactionEventListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.EventObject;
import java.util.Iterator;
import java.util.TooManyListenersException;
import java.util.concurrent.ConcurrentHashMap;
import javax.sip.ClientTransaction;
import javax.sip.Dialog;
import javax.sip.DialogState;
import javax.sip.InvalidArgumentException;
import javax.sip.ListeningPoint;
import javax.sip.ObjectInUseException;
import javax.sip.RequestEvent;
import javax.sip.ResponseEvent;
import javax.sip.ServerTransaction;
import javax.sip.SipException;
import javax.sip.SipListener;
import javax.sip.SipStack;
import javax.sip.Timeout;
import javax.sip.TimeoutEvent;
import javax.sip.Transaction;
import javax.sip.TransactionAlreadyExistsException;
import javax.sip.TransactionState;
import javax.sip.TransactionUnavailableException;
import javax.sip.address.Hop;
import javax.sip.header.CallIdHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

public class SipProviderImpl implements javax.sip.SipProvider, gov.nist.javax.sip.SipProviderExt, SIPTransactionEventListener, SIPDialogEventListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.695 -0400", hash_original_field = "C2742B0786D982D4EE3DCECCEC00E889", hash_generated_field = "C372B5B3448581C0F5822346BC5BF6B5")

    private SipListener sipListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.695 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "4DAF551644AC41AE30E26F4ABCF55488")

    protected SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.695 -0400", hash_original_field = "3CEAB7318649FC55E6D462942E769E7E", hash_generated_field = "2A53AF8663A42FF261DC56019ACC7569")

    private ConcurrentHashMap listeningPoints;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.695 -0400", hash_original_field = "0C887D575D34CEEB43215C9C2EB3F7E0", hash_generated_field = "B13D933CCB9027F950F0F782A6866769")

    private EventScanner eventScanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.695 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "27AA4AB7415706F85D71A67C2AA547CB")

    private String address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.695 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.696 -0400", hash_original_field = "03F94425985D4F12F061598392CB27B5", hash_generated_field = "524F32CD9808C18576213A6E5A9B572D")

    private boolean automaticDialogSupportEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.696 -0400", hash_original_field = "B00F9FADF4204970C84368C656AF77CC", hash_generated_field = "5CCA946576EE027FCC33A16438A5DE7B")

    private String IN_ADDR_ANY = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.696 -0400", hash_original_field = "648F89EB1D64275F1AF190105C1418E4", hash_generated_field = "18A343C90CA0F147EDF9BB2788A149EF")

    private String IN6_ADDR_ANY = "::0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.696 -0400", hash_original_field = "48E1E0D9B22B9E0D75D9E59520D250FF", hash_generated_field = "51E780BD632743E190A61DB4A1929A94")

    private boolean dialogErrorsAutomaticallyHandled = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.696 -0400", hash_original_method = "D7A082BA7BBEB80ADC15AA42F366B72C", hash_generated_method = "58CC0CE0C4D98D56E1D4B23FD5EE5252")
    private  SipProviderImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.697 -0400", hash_original_method = "E70748599E06F3AAB45B7E3DFBC2B3DC", hash_generated_method = "C7D1CA44448B68E5234FA92ECF9809FE")
    protected  SipProviderImpl(SipStackImpl sipStack) {
        this.eventScanner = sipStack.getEventScanner();
        this.sipStack = sipStack;
        this.eventScanner.incrementRefcount();
        this.listeningPoints = new ConcurrentHashMap<String,ListeningPointImpl>();
        this.automaticDialogSupportEnabled = this.sipStack
                .isAutomaticDialogSupportEnabled();
        this.dialogErrorsAutomaticallyHandled = this.sipStack.isAutomaticDialogErrorHandlingEnabled();
        // ---------- Original Method ----------
        //this.eventScanner = sipStack.getEventScanner();
        //this.sipStack = sipStack;
        //this.eventScanner.incrementRefcount();
        //this.listeningPoints = new ConcurrentHashMap<String,ListeningPointImpl>();
        //this.automaticDialogSupportEnabled = this.sipStack
                //.isAutomaticDialogSupportEnabled();
        //this.dialogErrorsAutomaticallyHandled = this.sipStack.isAutomaticDialogErrorHandlingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.698 -0400", hash_original_method = "11E23C3DFA194FF115BF392A022E2577", hash_generated_method = "67AFF467EC49C2CA2FDCB644EA4903CD")
    protected void stop() {
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("Exiting provider");
for(Iterator it = listeningPoints.values().iterator();it.hasNext();)
        {
            ListeningPointImpl listeningPoint = (ListeningPointImpl) it.next();
            listeningPoint.removeSipProvider();
        } //End block
        this.eventScanner.stop();
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("Exiting provider");
        //for (Iterator it = listeningPoints.values().iterator(); it.hasNext();) {
            //ListeningPointImpl listeningPoint = (ListeningPointImpl) it.next();
            //listeningPoint.removeSipProvider();
        //}
        //this.eventScanner.stop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.698 -0400", hash_original_method = "1158BA9F135FC60D78E0B26F09E9CC9C", hash_generated_method = "966DA5B5EC285146EADB82910A9671D4")
    public ListeningPoint getListeningPoint(String transport) {
        addTaint(transport.getTaint());
    if(transport == null)        
        {
        NullPointerException var46F022E0F12AC8507F77AA51C220C7A0_1737456016 = new NullPointerException("Null transport param");
        var46F022E0F12AC8507F77AA51C220C7A0_1737456016.addTaint(taint);
        throw var46F022E0F12AC8507F77AA51C220C7A0_1737456016;
        }
ListeningPoint var159466560DE4F68332621D1854E33B2E_1069878008 =         (ListeningPoint) this.listeningPoints.get(transport
                .toUpperCase());
        var159466560DE4F68332621D1854E33B2E_1069878008.addTaint(taint);
        return var159466560DE4F68332621D1854E33B2E_1069878008;
        // ---------- Original Method ----------
        //if (transport == null)
            //throw new NullPointerException("Null transport param");
        //return (ListeningPoint) this.listeningPoints.get(transport
                //.toUpperCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.699 -0400", hash_original_method = "BA46457405F31389F30610967A0B78B2", hash_generated_method = "CC3F6AA0AA4151559BA2A0E28D11C12A")
    public void handleEvent(EventObject sipEvent, SIPTransaction transaction) {
        addTaint(transaction.getTaint());
        addTaint(sipEvent.getTaint());
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "handleEvent " + sipEvent + "currentTransaction = "
                            + transaction + "this.sipListener = "
                            + this.getSipListener() + "sipEvent.source = "
                            + sipEvent.getSource());
    if(sipEvent instanceof RequestEvent)            
            {
                Dialog dialog = ((RequestEvent) sipEvent).getDialog();
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("Dialog = " + dialog);
            } //End block
            else
    if(sipEvent instanceof ResponseEvent)            
            {
                Dialog dialog = ((ResponseEvent) sipEvent).getDialog();
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("Dialog = " + dialog);
            } //End block
            sipStack.getStackLogger().logStackTrace();
        } //End block
        EventWrapper eventWrapper = new EventWrapper(sipEvent, transaction);
    if(!sipStack.reEntrantListener)        
        {
            this.eventScanner.addEvent(eventWrapper);
        } //End block
        else
        {
            this.eventScanner.deliverEvent(eventWrapper);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.700 -0400", hash_original_method = "E6B31C0538AF64C15CAF5AB43FC9524E", hash_generated_method = "74FD8BB5BC06A8D20883FF8D9587AE9A")
    protected Object clone() throws java.lang.CloneNotSupportedException {
        java.lang.CloneNotSupportedException varAFB4B30DEC4E72FFAAFB13B14942ECC4_1024837557 = new java.lang.CloneNotSupportedException();
        varAFB4B30DEC4E72FFAAFB13B14942ECC4_1024837557.addTaint(taint);
        throw varAFB4B30DEC4E72FFAAFB13B14942ECC4_1024837557;
        // ---------- Original Method ----------
        //throw new java.lang.CloneNotSupportedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.700 -0400", hash_original_method = "C6DB78E4BFC94524622F655361F90AF4", hash_generated_method = "230EA225E628FE9F267E6806C396EAB5")
    public void addSipListener(SipListener sipListener) throws TooManyListenersException {
    if(sipStack.sipListener == null)        
        {
            sipStack.sipListener = sipListener;
        } //End block
        else
    if(sipStack.sipListener != sipListener)        
        {
            TooManyListenersException varE0E2213A8B80EB5DE9E878807363A47D_709730987 = new TooManyListenersException(
                    "Stack already has a listener. Only one listener per stack allowed");
            varE0E2213A8B80EB5DE9E878807363A47D_709730987.addTaint(taint);
            throw varE0E2213A8B80EB5DE9E878807363A47D_709730987;
        } //End block
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("add SipListener " + sipListener);
        this.sipListener = sipListener;
        // ---------- Original Method ----------
        //if (sipStack.sipListener == null) {
            //sipStack.sipListener = sipListener;
        //} else if (sipStack.sipListener != sipListener) {
            //throw new TooManyListenersException(
                    //"Stack already has a listener. Only one listener per stack allowed");
        //}
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("add SipListener " + sipListener);
        //this.sipListener = sipListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.701 -0400", hash_original_method = "8DF1BB234AEAFA11A00A3BD7891CCE00", hash_generated_method = "0D054630F36202034E5960D699DE7588")
    public ListeningPoint getListeningPoint() {
    if(this.listeningPoints.size() > 0)        
        {
ListeningPoint varF2DA4C3E03BF5FCB7623C5BC9AAAA768_2050351921 =         (ListeningPoint) this.listeningPoints.values().iterator()
                    .next();
        varF2DA4C3E03BF5FCB7623C5BC9AAAA768_2050351921.addTaint(taint);
        return varF2DA4C3E03BF5FCB7623C5BC9AAAA768_2050351921;
        }
        else
        {
ListeningPoint var540C13E9E156B687226421B24F2DF178_1210939683 =         null;
        var540C13E9E156B687226421B24F2DF178_1210939683.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1210939683;
        }
        // ---------- Original Method ----------
        //if (this.listeningPoints.size() > 0)
            //return (ListeningPoint) this.listeningPoints.values().iterator()
                    //.next();
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.701 -0400", hash_original_method = "19C35F549E02B2BEFD4FB9F187DBEB25", hash_generated_method = "3F89FDAE61D893D8186830E5DF9CDFDE")
    public CallIdHeader getNewCallId() {
        String callId = Utils.getInstance().generateCallIdentifier(this.getListeningPoint()
                .getIPAddress());
        CallID callid = new CallID();
        try 
        {
            callid.setCallId(callId);
        } //End block
        catch (java.text.ParseException ex)
        {
        } //End block
CallIdHeader varDC913DFF15C999609F003B03C8D38FA5_1384534676 =         callid;
        varDC913DFF15C999609F003B03C8D38FA5_1384534676.addTaint(taint);
        return varDC913DFF15C999609F003B03C8D38FA5_1384534676;
        // ---------- Original Method ----------
        //String callId = Utils.getInstance().generateCallIdentifier(this.getListeningPoint()
                //.getIPAddress());
        //CallID callid = new CallID();
        //try {
            //callid.setCallId(callId);
        //} catch (java.text.ParseException ex) {
        //}
        //return callid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.703 -0400", hash_original_method = "7DCA30FF9D29B59AA737512D4B93FBF9", hash_generated_method = "A530385138DA15C2B459E4A86055F48B")
    public ClientTransaction getNewClientTransaction(Request request) throws TransactionUnavailableException {
        addTaint(request.getTaint());
    if(request == null)        
        {
        NullPointerException var6C6FDE05CF32D117AF8834B591E44AE8_1845731349 = new NullPointerException("null request");
        var6C6FDE05CF32D117AF8834B591E44AE8_1845731349.addTaint(taint);
        throw var6C6FDE05CF32D117AF8834B591E44AE8_1845731349;
        }
    if(!sipStack.isAlive())        
        {
        TransactionUnavailableException varF4CBB593FCC8223602B58A94D8A5B993_1922714367 = new TransactionUnavailableException("Stack is stopped");
        varF4CBB593FCC8223602B58A94D8A5B993_1922714367.addTaint(taint);
        throw varF4CBB593FCC8223602B58A94D8A5B993_1922714367;
        }
        SIPRequest sipRequest = (SIPRequest) request;
    if(sipRequest.getTransaction() != null)        
        {
        TransactionUnavailableException var2A5D067CF6903CC290BC52E233FD6FDB_191250719 = new TransactionUnavailableException(
                    "Transaction already assigned to request");
        var2A5D067CF6903CC290BC52E233FD6FDB_191250719.addTaint(taint);
        throw var2A5D067CF6903CC290BC52E233FD6FDB_191250719;
        }
    if(sipRequest.getMethod().equals(Request.ACK))        
        {
            TransactionUnavailableException var90F5A5B8503446D44568D870FE98235B_1521935672 = new TransactionUnavailableException ("Cannot create client transaction for  " + Request.ACK);
            var90F5A5B8503446D44568D870FE98235B_1521935672.addTaint(taint);
            throw var90F5A5B8503446D44568D870FE98235B_1521935672;
        } //End block
    if(sipRequest.getTopmostVia() == null)        
        {
            ListeningPointImpl lp = (ListeningPointImpl) this
                    .getListeningPoint("udp");
            Via via = lp.getViaHeader();
            request.setHeader(via);
        } //End block
        try 
        {
            sipRequest.checkHeaders();
        } //End block
        catch (ParseException ex)
        {
            TransactionUnavailableException var17C76D8E69430D1D2BF0D253221FDD35_422270297 = new TransactionUnavailableException(ex.getMessage(), ex);
            var17C76D8E69430D1D2BF0D253221FDD35_422270297.addTaint(taint);
            throw var17C76D8E69430D1D2BF0D253221FDD35_422270297;
        } //End block
    if(sipRequest.getTopmostVia().getBranch() != null
                && sipRequest.getTopmostVia().getBranch().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE)
                && sipStack.findTransaction((SIPRequest) request, false) != null)        
        {
            TransactionUnavailableException var022377405FB8A798743C5A09B83F6CF3_246821341 = new TransactionUnavailableException(
                    "Transaction already exists!");
            var022377405FB8A798743C5A09B83F6CF3_246821341.addTaint(taint);
            throw var022377405FB8A798743C5A09B83F6CF3_246821341;
        } //End block
    if(request.getMethod().equalsIgnoreCase(Request.CANCEL))        
        {
            SIPClientTransaction ct = (SIPClientTransaction) sipStack
                    .findCancelTransaction((SIPRequest) request, false);
    if(ct != null)            
            {
                ClientTransaction retval = sipStack.createClientTransaction(
                        (SIPRequest) request, ct.getMessageChannel());
                ((SIPTransaction) retval).addEventListener(this);
                sipStack.addTransaction((SIPClientTransaction) retval);
    if(ct.getDialog() != null)                
                {
                    ((SIPClientTransaction) retval).setDialog((SIPDialog) ct
                            .getDialog(), sipRequest.getDialogId(false));
                } //End block
ClientTransaction varF9E19AD6135C970F387F77C6F3DE4477_1929513683 =                 retval;
                varF9E19AD6135C970F387F77C6F3DE4477_1929513683.addTaint(taint);
                return varF9E19AD6135C970F387F77C6F3DE4477_1929513683;
            } //End block
        } //End block
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug(
                    "could not find existing transaction for "
                            + ((SIPRequest) request).getFirstLine()
                            + " creating a new one ");
        Hop hop = null;
        try 
        {
            hop = sipStack.getNextHop((SIPRequest) request);
    if(hop == null)            
            {
            TransactionUnavailableException var467097DD5B61680E6AA912E818712A53_955751603 = new TransactionUnavailableException(
                        "Cannot resolve next hop -- transaction unavailable");
            var467097DD5B61680E6AA912E818712A53_955751603.addTaint(taint);
            throw var467097DD5B61680E6AA912E818712A53_955751603;
            }
        } //End block
        catch (SipException ex)
        {
            TransactionUnavailableException var0284F6A515A69410C8368EFE3B1DF26B_1932297923 = new TransactionUnavailableException(
                    "Cannot resolve next hop -- transaction unavailable", ex);
            var0284F6A515A69410C8368EFE3B1DF26B_1932297923.addTaint(taint);
            throw var0284F6A515A69410C8368EFE3B1DF26B_1932297923;
        } //End block
        String transport = hop.getTransport();
        ListeningPointImpl listeningPoint = (ListeningPointImpl) this
                .getListeningPoint(transport);
        String dialogId = sipRequest.getDialogId(false);
        SIPDialog dialog = sipStack.getDialog(dialogId);
    if(dialog != null && dialog.getState() == DialogState.TERMINATED)        
        {
            sipStack.removeDialog(dialog);
        } //End block
        try 
        {
            String branchId = null;
    if(sipRequest.getTopmostVia().getBranch() == null
                    || !sipRequest.getTopmostVia().getBranch().startsWith(
                            SIPConstants.BRANCH_MAGIC_COOKIE)
                            || sipStack.checkBranchId())            
            {
                branchId = Utils.getInstance().generateBranchId();
                sipRequest.getTopmostVia().setBranch(branchId);
            } //End block
            Via topmostVia = sipRequest.getTopmostVia();
    if(topmostVia.getTransport() == null)            
            topmostVia.setTransport(transport);
    if(topmostVia.getPort() == -1)            
            topmostVia.setPort(listeningPoint.getPort());
            branchId = sipRequest.getTopmostVia().getBranch();
            SIPClientTransaction ct = (SIPClientTransaction) sipStack
                    .createMessageChannel(sipRequest, listeningPoint
                            .getMessageProcessor(), hop);
    if(ct == null)            
            {
            TransactionUnavailableException var7CF74D98D10958C5B8675C8DE85D3D57_538315073 = new TransactionUnavailableException("Cound not create tx");
            var7CF74D98D10958C5B8675C8DE85D3D57_538315073.addTaint(taint);
            throw var7CF74D98D10958C5B8675C8DE85D3D57_538315073;
            }
            ct.setNextHop(hop);
            ct.setOriginalRequest(sipRequest);
            ct.setBranch(branchId);
    if(sipStack.isDialogCreated(request.getMethod()))            
            {
    if(dialog != null)                
                ct.setDialog(dialog, sipRequest.getDialogId(false));
                else
    if(this.isAutomaticDialogSupportEnabled())                
                {
                    SIPDialog sipDialog = sipStack.createDialog(ct);
                    ct.setDialog(sipDialog, sipRequest.getDialogId(false));
                } //End block
            } //End block
            else
            {
    if(dialog != null)                
                {
                    ct.setDialog(dialog, sipRequest.getDialogId(false));
                } //End block
            } //End block
            ct.addEventListener(this);
ClientTransaction varDE668896B699DC5E946E1C7C7A3C22A4_147082378 =             (ClientTransaction) ct;
            varDE668896B699DC5E946E1C7C7A3C22A4_147082378.addTaint(taint);
            return varDE668896B699DC5E946E1C7C7A3C22A4_147082378;
        } //End block
        catch (IOException ex)
        {
            TransactionUnavailableException varFA59300395164A34DDDCBEA55A884DAF_1031101067 = new TransactionUnavailableException(
                    "Could not resolve next hop or listening point unavailable! ",
                    ex);
            varFA59300395164A34DDDCBEA55A884DAF_1031101067.addTaint(taint);
            throw varFA59300395164A34DDDCBEA55A884DAF_1031101067;
        } //End block
        catch (java.text.ParseException ex)
        {
            InternalErrorHandler.handleException(ex);
            TransactionUnavailableException varAC405AD52B82FABD932B3ED7B7C057FD_1933597985 = new TransactionUnavailableException(
                    "Unexpected Exception FIXME! ", ex);
            varAC405AD52B82FABD932B3ED7B7C057FD_1933597985.addTaint(taint);
            throw varAC405AD52B82FABD932B3ED7B7C057FD_1933597985;
        } //End block
        catch (InvalidArgumentException ex)
        {
            InternalErrorHandler.handleException(ex);
            TransactionUnavailableException varAC405AD52B82FABD932B3ED7B7C057FD_1656508456 = new TransactionUnavailableException(
                    "Unexpected Exception FIXME! ", ex);
            varAC405AD52B82FABD932B3ED7B7C057FD_1656508456.addTaint(taint);
            throw varAC405AD52B82FABD932B3ED7B7C057FD_1656508456;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.706 -0400", hash_original_method = "569DCDD9EB405C75F83E1325FE87C1D4", hash_generated_method = "05C14844CE8C1A429D434E47377157DC")
    public ServerTransaction getNewServerTransaction(Request request) throws TransactionAlreadyExistsException,
            TransactionUnavailableException {
        addTaint(request.getTaint());
    if(!sipStack.isAlive())        
        {
        TransactionUnavailableException varF4CBB593FCC8223602B58A94D8A5B993_1840085114 = new TransactionUnavailableException("Stack is stopped");
        varF4CBB593FCC8223602B58A94D8A5B993_1840085114.addTaint(taint);
        throw varF4CBB593FCC8223602B58A94D8A5B993_1840085114;
        }
        SIPServerTransaction transaction = null;
        SIPRequest sipRequest = (SIPRequest) request;
        try 
        {
            sipRequest.checkHeaders();
        } //End block
        catch (ParseException ex)
        {
            TransactionUnavailableException var17C76D8E69430D1D2BF0D253221FDD35_1010921276 = new TransactionUnavailableException(ex.getMessage(), ex);
            var17C76D8E69430D1D2BF0D253221FDD35_1010921276.addTaint(taint);
            throw var17C76D8E69430D1D2BF0D253221FDD35_1010921276;
        } //End block
    if(request.getMethod().equals(Request.ACK))        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logError("Creating server transaction for ACK -- makes no sense!");
            TransactionUnavailableException var048CCBA01FD7A94D064E8369BCA43831_1999569754 = new TransactionUnavailableException("Cannot create Server transaction for ACK ");
            var048CCBA01FD7A94D064E8369BCA43831_1999569754.addTaint(taint);
            throw var048CCBA01FD7A94D064E8369BCA43831_1999569754;
        } //End block
    if(sipRequest.getMethod().equals(Request.NOTIFY)
                && sipRequest.getFromTag() != null
                && sipRequest.getToTag() == null)        
        {
            SIPClientTransaction ct = sipStack.findSubscribeTransaction(
                    sipRequest, (ListeningPointImpl) this.getListeningPoint());
    if(ct == null && ! sipStack.deliverUnsolicitedNotify)            
            {
                TransactionUnavailableException var39BDBD27905AC46995AB828A18FADF18_1127165370 = new TransactionUnavailableException(
                        "Cannot find matching Subscription (and gov.nist.javax.sip.DELIVER_UNSOLICITED_NOTIFY not set)");
                var39BDBD27905AC46995AB828A18FADF18_1127165370.addTaint(taint);
                throw var39BDBD27905AC46995AB828A18FADF18_1127165370;
            } //End block
        } //End block
    if(!sipStack.acquireSem())        
        {
            TransactionUnavailableException var66F9891DE38B0693E7AEEF0A6B42CB4A_2061785090 = new TransactionUnavailableException(
            "Transaction not available -- could not acquire stack lock");
            var66F9891DE38B0693E7AEEF0A6B42CB4A_2061785090.addTaint(taint);
            throw var66F9891DE38B0693E7AEEF0A6B42CB4A_2061785090;
        } //End block
        try 
        {
    if(sipStack.isDialogCreated(sipRequest.getMethod()))            
            {
    if(sipStack.findTransaction((SIPRequest) request, true) != null)                
                {
                TransactionAlreadyExistsException varE88801C2A17B8A83D69B53F46BFEE6BC_1229773856 = new TransactionAlreadyExistsException(
                    "server transaction already exists!");
                varE88801C2A17B8A83D69B53F46BFEE6BC_1229773856.addTaint(taint);
                throw varE88801C2A17B8A83D69B53F46BFEE6BC_1229773856;
                }
                transaction = (SIPServerTransaction) ((SIPRequest) request)
                .getTransaction();
    if(transaction == null)                
                {
                TransactionUnavailableException var6C863DF031B9E4B861A48D4E708625C8_873481750 = new TransactionUnavailableException(
                    "Transaction not available");
                var6C863DF031B9E4B861A48D4E708625C8_873481750.addTaint(taint);
                throw var6C863DF031B9E4B861A48D4E708625C8_873481750;
                }
    if(transaction.getOriginalRequest() == null)                
                transaction.setOriginalRequest(sipRequest);
                try 
                {
                    sipStack.addTransaction(transaction);
                } //End block
                catch (IOException ex)
                {
                    TransactionUnavailableException var57700A567860D06F7A2DEFABC9636FF5_1211737829 = new TransactionUnavailableException(
                    "Error sending provisional response");
                    var57700A567860D06F7A2DEFABC9636FF5_1211737829.addTaint(taint);
                    throw var57700A567860D06F7A2DEFABC9636FF5_1211737829;
                } //End block
                transaction.addEventListener(this);
    if(isAutomaticDialogSupportEnabled())                
                {
                    String dialogId = sipRequest.getDialogId(true);
                    SIPDialog dialog = sipStack.getDialog(dialogId);
    if(dialog == null)                    
                    {
                        dialog = sipStack.createDialog(transaction);
                    } //End block
                    transaction.setDialog(dialog, sipRequest.getDialogId(true));
    if(sipRequest.getMethod().equals(Request.INVITE) && this.isDialogErrorsAutomaticallyHandled())                    
                    {
                        sipStack.putInMergeTable(transaction, sipRequest);
                    } //End block
                    dialog.addRoute(sipRequest);
    if(dialog.getRemoteTag() != null
                            && dialog.getLocalTag() != null)                    
                    {
                        this.sipStack.putDialog(dialog);
                    } //End block
                } //End block
            } //End block
            else
            {
    if(isAutomaticDialogSupportEnabled())                
                {
                    transaction = (SIPServerTransaction) sipStack.findTransaction(
                            (SIPRequest) request, true);
    if(transaction != null)                    
                    {
                    TransactionAlreadyExistsException var4ECC8DAD62A04A154DA20DA68F6891D8_366473529 = new TransactionAlreadyExistsException(
                        "Transaction exists! ");
                    var4ECC8DAD62A04A154DA20DA68F6891D8_366473529.addTaint(taint);
                    throw var4ECC8DAD62A04A154DA20DA68F6891D8_366473529;
                    }
                    transaction = (SIPServerTransaction) ((SIPRequest) request)
                    .getTransaction();
    if(transaction == null)                    
                    {
                    TransactionUnavailableException varE2EC08DF2B9BEAAA6E13F5AC8733EE58_1165587815 = new TransactionUnavailableException(
                        "Transaction not available!");
                    varE2EC08DF2B9BEAAA6E13F5AC8733EE58_1165587815.addTaint(taint);
                    throw varE2EC08DF2B9BEAAA6E13F5AC8733EE58_1165587815;
                    }
    if(transaction.getOriginalRequest() == null)                    
                    transaction.setOriginalRequest(sipRequest);
                    try 
                    {
                        sipStack.addTransaction(transaction);
                    } //End block
                    catch (IOException ex)
                    {
                        TransactionUnavailableException var87052AF725BB773841B9ECBCBA4E8CED_1774631779 = new TransactionUnavailableException(
                        "Could not send back provisional response!");
                        var87052AF725BB773841B9ECBCBA4E8CED_1774631779.addTaint(taint);
                        throw var87052AF725BB773841B9ECBCBA4E8CED_1774631779;
                    } //End block
                    String dialogId = sipRequest.getDialogId(true);
                    SIPDialog dialog = sipStack.getDialog(dialogId);
    if(dialog != null)                    
                    {
                        dialog.addTransaction(transaction);
                        dialog.addRoute(sipRequest);
                        transaction.setDialog(dialog, sipRequest.getDialogId(true));
                    } //End block
                } //End block
                else
                {
                    transaction = (SIPServerTransaction) sipStack.findTransaction(
                            (SIPRequest) request, true);
    if(transaction != null)                    
                    {
                    TransactionAlreadyExistsException var4ECC8DAD62A04A154DA20DA68F6891D8_1063048997 = new TransactionAlreadyExistsException(
                        "Transaction exists! ");
                    var4ECC8DAD62A04A154DA20DA68F6891D8_1063048997.addTaint(taint);
                    throw var4ECC8DAD62A04A154DA20DA68F6891D8_1063048997;
                    }
                    transaction = (SIPServerTransaction) ((SIPRequest) request)
                    .getTransaction();
    if(transaction != null)                    
                    {
    if(transaction.getOriginalRequest() == null)                        
                        transaction.setOriginalRequest(sipRequest);
                        sipStack.mapTransaction(transaction);
                        String dialogId = sipRequest.getDialogId(true);
                        SIPDialog dialog = sipStack.getDialog(dialogId);
    if(dialog != null)                        
                        {
                            dialog.addTransaction(transaction);
                            dialog.addRoute(sipRequest);
                            transaction.setDialog(dialog, sipRequest
                                    .getDialogId(true));
                        } //End block
ServerTransaction var192CEA4506B8E6E6978C4B3CF08B433F_1189209710 =                         transaction;
                        var192CEA4506B8E6E6978C4B3CF08B433F_1189209710.addTaint(taint);
                        return var192CEA4506B8E6E6978C4B3CF08B433F_1189209710;
                    } //End block
                    else
                    {
                        MessageChannel mc = (MessageChannel) sipRequest
                        .getMessageChannel();
                        transaction = sipStack.createServerTransaction(mc);
    if(transaction == null)                        
                        {
                        TransactionUnavailableException varD0F25F2C94EC1E355A92AC7EA9C69173_1649278203 = new TransactionUnavailableException(
                            "Transaction unavailable -- too many servrer transactions");
                        varD0F25F2C94EC1E355A92AC7EA9C69173_1649278203.addTaint(taint);
                        throw varD0F25F2C94EC1E355A92AC7EA9C69173_1649278203;
                        }
                        transaction.setOriginalRequest(sipRequest);
                        sipStack.mapTransaction(transaction);
                        String dialogId = sipRequest.getDialogId(true);
                        SIPDialog dialog = sipStack.getDialog(dialogId);
    if(dialog != null)                        
                        {
                            dialog.addTransaction(transaction);
                            dialog.addRoute(sipRequest);
                            transaction.setDialog(dialog, sipRequest
                                    .getDialogId(true));
                        } //End block
ServerTransaction var192CEA4506B8E6E6978C4B3CF08B433F_550342226 =                         transaction;
                        var192CEA4506B8E6E6978C4B3CF08B433F_550342226.addTaint(taint);
                        return var192CEA4506B8E6E6978C4B3CF08B433F_550342226;
                    } //End block
                } //End block
            } //End block
ServerTransaction var192CEA4506B8E6E6978C4B3CF08B433F_1691120709 =             transaction;
            var192CEA4506B8E6E6978C4B3CF08B433F_1691120709.addTaint(taint);
            return var192CEA4506B8E6E6978C4B3CF08B433F_1691120709;
        } //End block
        finally 
        {
            sipStack.releaseSem();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.708 -0400", hash_original_method = "4583BF79BF08EE358F0E8CEF923996E7", hash_generated_method = "2482BE7DBAC003A721E841F43703F629")
    public SipStack getSipStack() {
SipStack var393C7523E246E572F880C7194691B5B6_788846314 =         (SipStack) this.sipStack;
        var393C7523E246E572F880C7194691B5B6_788846314.addTaint(taint);
        return var393C7523E246E572F880C7194691B5B6_788846314;
        // ---------- Original Method ----------
        //return (SipStack) this.sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.709 -0400", hash_original_method = "8E603E1E5B83B3D4BA739C213D2D52AF", hash_generated_method = "91F7D5C7D92072631D7D325D71D62E0F")
    public void removeSipListener(SipListener sipListener) {
    if(sipListener == this.getSipListener())        
        {
            this.sipListener = null;
        } //End block
        boolean found = false;
for(Iterator<SipProviderImpl> it = sipStack.getSipProviders();it.hasNext();)
        {
            SipProviderImpl nextProvider = (SipProviderImpl) it.next();
    if(nextProvider.getSipListener() != null)            
            found = true;
        } //End block
    if(!found)        
        {
            sipStack.sipListener = null;
        } //End block
        // ---------- Original Method ----------
        //if (sipListener == this.getSipListener()) {
            //this.sipListener = null;
        //}
        //boolean found = false;
        //for (Iterator<SipProviderImpl> it = sipStack.getSipProviders(); it.hasNext();) {
            //SipProviderImpl nextProvider = (SipProviderImpl) it.next();
            //if (nextProvider.getSipListener() != null)
                //found = true;
        //}
        //if (!found) {
            //sipStack.sipListener = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.711 -0400", hash_original_method = "5A8CC74B0BB93A3DC57DF48200955F60", hash_generated_method = "EFCAB42403857339517F60A8FB768881")
    public void sendRequest(Request request) throws SipException {
        addTaint(request.getTaint());
    if(!sipStack.isAlive())        
        {
        SipException var1BE68D407757E326A34821B5B2C442F1_1534163233 = new SipException("Stack is stopped.");
        var1BE68D407757E326A34821B5B2C442F1_1534163233.addTaint(taint);
        throw var1BE68D407757E326A34821B5B2C442F1_1534163233;
        }
    if(((SIPRequest) request).getRequestLine() != null
                && request.getMethod().equals(Request.ACK))        
        {
            Dialog dialog = sipStack.getDialog(((SIPRequest) request)
                    .getDialogId(false));
    if(dialog != null && dialog.getState() != null)            
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logWarning(
                        "Dialog exists -- you may want to use Dialog.sendAck() "
                                + dialog.getState());
            } //End block
        } //End block
        Hop hop = sipStack.getRouter((SIPRequest) request).getNextHop(request);
    if(hop == null)        
        {
        SipException var2B6B25586EDEBC5AFF799682D21CD986_1647555185 = new SipException("could not determine next hop!");
        var2B6B25586EDEBC5AFF799682D21CD986_1647555185.addTaint(taint);
        throw var2B6B25586EDEBC5AFF799682D21CD986_1647555185;
        }
        SIPRequest sipRequest = (SIPRequest) request;
    if((!sipRequest.isNullRequest()) && sipRequest.getTopmostVia() == null)        
        {
        SipException var8DB51C8BA6B458B82FAA0956F15A08D7_254223765 = new SipException("Invalid SipRequest -- no via header!");
        var8DB51C8BA6B458B82FAA0956F15A08D7_254223765.addTaint(taint);
        throw var8DB51C8BA6B458B82FAA0956F15A08D7_254223765;
        }
        try 
        {
    if(!sipRequest.isNullRequest())            
            {
                Via via = sipRequest.getTopmostVia();
                String branch = via.getBranch();
    if(branch == null || branch.length() == 0)                
                {
                    via.setBranch(sipRequest.getTransactionId());
                } //End block
            } //End block
            MessageChannel messageChannel = null;
    if(this.listeningPoints.containsKey(hop.getTransport()
                    .toUpperCase()))            
            messageChannel = sipStack.createRawMessageChannel(
                        this.getListeningPoint(hop.getTransport()).getIPAddress(),
                        this.getListeningPoint(hop.getTransport()).getPort(), hop);
    if(messageChannel != null)            
            {
                messageChannel.sendMessage((SIPMessage) sipRequest,hop);
            } //End block
            else
            {
                SipException var504C748DB9DB07F6E342B8BD6EF9F8DC_709707088 = new SipException(
                        "Could not create a message channel for "
                                + hop.toString());
                var504C748DB9DB07F6E342B8BD6EF9F8DC_709707088.addTaint(taint);
                throw var504C748DB9DB07F6E342B8BD6EF9F8DC_709707088;
            } //End block
        } //End block
        catch (IOException ex)
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logException(ex);
            } //End block
            SipException varB4F043DCA4B90AE218AE0BD953D6F1C4_688901996 = new SipException(
                    "IO Exception occured while Sending Request", ex);
            varB4F043DCA4B90AE218AE0BD953D6F1C4_688901996.addTaint(taint);
            throw varB4F043DCA4B90AE218AE0BD953D6F1C4_688901996;
        } //End block
        catch (ParseException ex1)
        {
            InternalErrorHandler.handleException(ex1);
        } //End block
        finally 
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug(
                        "done sending " + request.getMethod() + " to hop "
                                + hop);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.712 -0400", hash_original_method = "9E6954B352C971BA2053951D5F8763C5", hash_generated_method = "A2ADAD9CB9C62AD8A8F396BB95C493AE")
    public void sendResponse(Response response) throws SipException {
        addTaint(response.getTaint());
    if(!sipStack.isAlive())        
        {
        SipException var4EFA717E5C11A598B4E41CD4B5626BFD_536685925 = new SipException("Stack is stopped");
        var4EFA717E5C11A598B4E41CD4B5626BFD_536685925.addTaint(taint);
        throw var4EFA717E5C11A598B4E41CD4B5626BFD_536685925;
        }
        SIPResponse sipResponse = (SIPResponse) response;
        Via via = sipResponse.getTopmostVia();
    if(via == null)        
        {
        SipException var161FC58594F097CDB5224DCDE9DE0E54_462843719 = new SipException("No via header in response!");
        var161FC58594F097CDB5224DCDE9DE0E54_462843719.addTaint(taint);
        throw var161FC58594F097CDB5224DCDE9DE0E54_462843719;
        }
        SIPServerTransaction st = (SIPServerTransaction) sipStack.findTransaction((SIPMessage)response, true);
    if(st != null   && st.getState() != TransactionState.TERMINATED && this.isAutomaticDialogSupportEnabled())        
        {
            SipException var14695548156C78D32F2657D2A9CB1A5C_418090390 = new SipException("Transaction exists -- cannot send response statelessly");
            var14695548156C78D32F2657D2A9CB1A5C_418090390.addTaint(taint);
            throw var14695548156C78D32F2657D2A9CB1A5C_418090390;
        } //End block
        String transport = via.getTransport();
        String host = via.getReceived();
    if(host == null)        
        host = via.getHost();
        int port = via.getRPort();
    if(port == -1)        
        {
            port = via.getPort();
    if(port == -1)            
            {
    if(transport.equalsIgnoreCase("TLS"))                
                port = 5061;
                else
                port = 5060;
            } //End block
        } //End block
    if(host.indexOf(":") > 0)        
    if(host.indexOf("[") < 0)        
        host = "[" + host + "]";
        Hop hop = sipStack.getAddressResolver().resolveAddress(
                new HopImpl(host, port, transport));
        try 
        {
            ListeningPointImpl listeningPoint = (ListeningPointImpl) this
                    .getListeningPoint(transport);
    if(listeningPoint == null)            
            {
            SipException varF828814271111CC1718F08C49AE773F8_1997387046 = new SipException(
                        "whoopsa daisy! no listening point found for transport "
                                + transport);
            varF828814271111CC1718F08C49AE773F8_1997387046.addTaint(taint);
            throw varF828814271111CC1718F08C49AE773F8_1997387046;
            }
            MessageChannel messageChannel = sipStack.createRawMessageChannel(
                    this.getListeningPoint(hop.getTransport()).getIPAddress(),
                    listeningPoint.port, hop);
            messageChannel.sendMessage(sipResponse);
        } //End block
        catch (IOException ex)
        {
            SipException var892635990475903AE5F007B5D011DC38_1643928635 = new SipException(ex.getMessage());
            var892635990475903AE5F007B5D011DC38_1643928635.addTaint(taint);
            throw var892635990475903AE5F007B5D011DC38_1643928635;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.714 -0400", hash_original_method = "0E16D45CFEA7D246360E28B311FFB756", hash_generated_method = "F50A75AFD5EAC558A8AAD28E319C31FB")
    public synchronized void setListeningPoint(ListeningPoint listeningPoint) {
    if(listeningPoint == null)        
        {
        NullPointerException var6DD7D7A041F4030A2703304675187B9A_886640037 = new NullPointerException("Null listening point");
        var6DD7D7A041F4030A2703304675187B9A_886640037.addTaint(taint);
        throw var6DD7D7A041F4030A2703304675187B9A_886640037;
        }
        ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
        lp.sipProvider = this;
        String transport = lp.getTransport().toUpperCase();
        this.address = listeningPoint.getIPAddress();
        this.port = listeningPoint.getPort();
        this.listeningPoints.clear();
        this.listeningPoints.put(transport, listeningPoint);
        // ---------- Original Method ----------
        //if (listeningPoint == null)
            //throw new NullPointerException("Null listening point");
        //ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
        //lp.sipProvider = this;
        //String transport = lp.getTransport().toUpperCase();
        //this.address = listeningPoint.getIPAddress();
        //this.port = listeningPoint.getPort();
        //this.listeningPoints.clear();
        //this.listeningPoints.put(transport, listeningPoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.715 -0400", hash_original_method = "9D9F76163655F94EC324A9002FE39206", hash_generated_method = "BD60E75DD8E7BC45D89FE12752819ECB")
    public Dialog getNewDialog(Transaction transaction) throws SipException {
        addTaint(transaction.getTaint());
    if(transaction == null)        
        {
        NullPointerException var5B746D23CB236E6A98228CCB19C809C0_749455205 = new NullPointerException("Null transaction!");
        var5B746D23CB236E6A98228CCB19C809C0_749455205.addTaint(taint);
        throw var5B746D23CB236E6A98228CCB19C809C0_749455205;
        }
    if(!sipStack.isAlive())        
        {
        SipException var1BE68D407757E326A34821B5B2C442F1_799857789 = new SipException("Stack is stopped.");
        var1BE68D407757E326A34821B5B2C442F1_799857789.addTaint(taint);
        throw var1BE68D407757E326A34821B5B2C442F1_799857789;
        }
    if(isAutomaticDialogSupportEnabled())        
        {
        SipException varCA34E45A3945DE7090FC04299F1243D9_1578213750 = new SipException(" Error - AUTOMATIC_DIALOG_SUPPORT is on");
        varCA34E45A3945DE7090FC04299F1243D9_1578213750.addTaint(taint);
        throw varCA34E45A3945DE7090FC04299F1243D9_1578213750;
        }
    if(!sipStack.isDialogCreated(transaction.getRequest().getMethod()))        
        {
        SipException varF70B66C79B10A8B4DCD1889C2F9126E9_379233505 = new SipException("Dialog cannot be created for this method "
                    + transaction.getRequest().getMethod());
        varF70B66C79B10A8B4DCD1889C2F9126E9_379233505.addTaint(taint);
        throw varF70B66C79B10A8B4DCD1889C2F9126E9_379233505;
        }
        SIPDialog dialog = null;
        SIPTransaction sipTransaction = (SIPTransaction) transaction;
    if(transaction instanceof ServerTransaction)        
        {
            SIPServerTransaction st = (SIPServerTransaction) transaction;
            Response response = st.getLastResponse();
    if(response != null)            
            {
    if(response.getStatusCode() != 100)                
                {
                SipException varF01E1BFE896A8022573FB2D8616CA85B_1751651498 = new SipException(
                            "Cannot set dialog after response has been sent");
                varF01E1BFE896A8022573FB2D8616CA85B_1751651498.addTaint(taint);
                throw varF01E1BFE896A8022573FB2D8616CA85B_1751651498;
                }
            } //End block
            SIPRequest sipRequest = (SIPRequest) transaction.getRequest();
            String dialogId = sipRequest.getDialogId(true);
            dialog = sipStack.getDialog(dialogId);
    if(dialog == null)            
            {
                dialog = sipStack.createDialog((SIPTransaction) transaction);
                dialog.addTransaction(sipTransaction);
                dialog.addRoute(sipRequest);
                sipTransaction.setDialog(dialog, null);
            } //End block
            else
            {
                sipTransaction.setDialog(dialog, sipRequest.getDialogId(true));
            } //End block
    if(sipRequest.getMethod().equals(Request.INVITE) && this.isDialogErrorsAutomaticallyHandled())            
            {
                sipStack.putInMergeTable(st, sipRequest);
            } //End block
        } //End block
        else
        {
            SIPClientTransaction sipClientTx = (SIPClientTransaction) transaction;
            SIPResponse response = sipClientTx.getLastResponse();
    if(response == null)            
            {
                SIPRequest request = (SIPRequest) sipClientTx.getRequest();
                String dialogId = request.getDialogId(false);
                dialog = sipStack.getDialog(dialogId);
    if(dialog != null)                
                {
                    SipException var7F38B298D0617244352BF0B36A56BDCD_801915485 = new SipException("Dialog already exists!");
                    var7F38B298D0617244352BF0B36A56BDCD_801915485.addTaint(taint);
                    throw var7F38B298D0617244352BF0B36A56BDCD_801915485;
                } //End block
                else
                {
                    dialog = sipStack.createDialog(sipTransaction);
                } //End block
                sipClientTx.setDialog(dialog, null);
            } //End block
            else
            {
                SipException var37289FBBC6BC7717307793DE2F4BEBC0_10252824 = new SipException(
                        "Cannot call this method after response is received!");
                var37289FBBC6BC7717307793DE2F4BEBC0_10252824.addTaint(taint);
                throw var37289FBBC6BC7717307793DE2F4BEBC0_10252824;
            } //End block
        } //End block
        dialog.addEventListener(this);
Dialog varE19892282EF70932DF3A147A213BE89D_1450144983 =         dialog;
        varE19892282EF70932DF3A147A213BE89D_1450144983.addTaint(taint);
        return varE19892282EF70932DF3A147A213BE89D_1450144983;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.717 -0400", hash_original_method = "DDF38266DDD18665F4022DB956C0FE2D", hash_generated_method = "3C118F3287FE55111040A5068AA276C7")
    public void transactionErrorEvent(
            SIPTransactionErrorEvent transactionErrorEvent) {
        addTaint(transactionErrorEvent.getTaint());
        SIPTransaction transaction = (SIPTransaction) transactionErrorEvent
                .getSource();
    if(transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR)        
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "TransportError occured on " + transaction);
            } //End block
            Object errorObject = transactionErrorEvent.getSource();
            Timeout timeout = Timeout.TRANSACTION;
            TimeoutEvent ev = null;
    if(errorObject instanceof SIPServerTransaction)            
            {
                ev = new TimeoutEvent(this, (ServerTransaction) errorObject,
                        timeout);
            } //End block
            else
            {
                SIPClientTransaction clientTx = (SIPClientTransaction) errorObject;
                Hop hop = clientTx.getNextHop();
    if(sipStack.getRouter() instanceof RouterExt)                
                {
                    ((RouterExt) sipStack.getRouter()).transactionTimeout(hop);
                } //End block
                ev = new TimeoutEvent(this, (ClientTransaction) errorObject,
                        timeout);
            } //End block
            this.handleEvent(ev, (SIPTransaction) errorObject);
        } //End block
        else
    if(transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TIMEOUT_ERROR)        
        {
            Object errorObject = transactionErrorEvent.getSource();
            Timeout timeout = Timeout.TRANSACTION;
            TimeoutEvent ev = null;
    if(errorObject instanceof SIPServerTransaction)            
            {
                ev = new TimeoutEvent(this, (ServerTransaction) errorObject,
                        timeout);
            } //End block
            else
            {
                SIPClientTransaction clientTx = (SIPClientTransaction) errorObject;
                Hop hop = clientTx.getNextHop();
    if(sipStack.getRouter() instanceof RouterExt)                
                {
                    ((RouterExt) sipStack.getRouter()).transactionTimeout(hop);
                } //End block
                ev = new TimeoutEvent(this, (ClientTransaction) errorObject,
                        timeout);
            } //End block
            this.handleEvent(ev, (SIPTransaction) errorObject);
        } //End block
        else
    if(transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TIMEOUT_RETRANSMIT)        
        {
            Object errorObject = transactionErrorEvent.getSource();
            Transaction tx = (Transaction) errorObject;
    if(tx.getDialog() != null)            
            InternalErrorHandler.handleException("Unexpected event !",
                        this.sipStack.getStackLogger());
            Timeout timeout = Timeout.RETRANSMIT;
            TimeoutEvent ev = null;
    if(errorObject instanceof SIPServerTransaction)            
            {
                ev = new TimeoutEvent(this, (ServerTransaction) errorObject,
                        timeout);
            } //End block
            else
            {
                ev = new TimeoutEvent(this, (ClientTransaction) errorObject,
                        timeout);
            } //End block
            this.handleEvent(ev, (SIPTransaction) errorObject);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.719 -0400", hash_original_method = "3AE2B963E4C8A3C0E767E575A9114D58", hash_generated_method = "924F73FA97F08018484005AB029EDD6F")
    public synchronized void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent) {
        addTaint(dialogErrorEvent.getTaint());
        SIPDialog sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        Reason reason = Reason.AckNotReceived;
    if(dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT)        
        {
            reason= Reason.AckNotSent;
        } //End block
        else
    if(dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT)        
        {
            reason = Reason.ReInviteTimeout;
        } //End block
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "Dialog TimeoutError occured on " + sipDialog);
        } //End block
        DialogTimeoutEvent ev = new DialogTimeoutEvent(this, sipDialog, reason);
        this.handleEvent(ev, null);
        // ---------- Original Method ----------
        //SIPDialog sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        //Reason reason = Reason.AckNotReceived;
        //if (dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT) {
        	//reason= Reason.AckNotSent;
        //} else if (dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT) {
            //reason = Reason.ReInviteTimeout;
        //}
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug(
                    //"Dialog TimeoutError occured on " + sipDialog);
        //}
        //DialogTimeoutEvent ev = new DialogTimeoutEvent(this, sipDialog, reason);
        //this.handleEvent(ev, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.720 -0400", hash_original_method = "B3C6AC6D2F49AD76B9521CC6B14816A0", hash_generated_method = "F019DA1FBA2A2437B535EA41987549BB")
    public synchronized ListeningPoint[] getListeningPoints() {
        ListeningPoint[] retval = new ListeningPointImpl[this.listeningPoints
                .size()];
        this.listeningPoints.values().toArray(retval);
ListeningPoint[] varF9E19AD6135C970F387F77C6F3DE4477_418162781 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_418162781.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_418162781;
        // ---------- Original Method ----------
        //ListeningPoint[] retval = new ListeningPointImpl[this.listeningPoints
                //.size()];
        //this.listeningPoints.values().toArray(retval);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.722 -0400", hash_original_method = "EAE5E9A9D2E983810EEEE28894E73A1D", hash_generated_method = "4EE35003A8231242A001A3CB721DD097")
    public synchronized void addListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
    if(lp.sipProvider != null && lp.sipProvider != this)        
        {
        ObjectInUseException varB49A8120C7171DA973611197DE0B7D09_1618659172 = new ObjectInUseException(
                    "Listening point assigned to another provider");
        varB49A8120C7171DA973611197DE0B7D09_1618659172.addTaint(taint);
        throw varB49A8120C7171DA973611197DE0B7D09_1618659172;
        }
        String transport = lp.getTransport().toUpperCase();
    if(this.listeningPoints.isEmpty())        
        {
            this.address = listeningPoint.getIPAddress();
            this.port = listeningPoint.getPort();
        } //End block
        else
        {
    if((!this.address.equals(listeningPoint.getIPAddress()))
                    || this.port != listeningPoint.getPort())            
            {
            ObjectInUseException var74D25552AC8083153661526681CF69E9_1250896065 = new ObjectInUseException(
                        "Provider already has different IP Address associated");
            var74D25552AC8083153661526681CF69E9_1250896065.addTaint(taint);
            throw var74D25552AC8083153661526681CF69E9_1250896065;
            }
        } //End block
    if(this.listeningPoints.containsKey(transport)
                && this.listeningPoints.get(transport) != listeningPoint)        
        {
        ObjectInUseException var6117DB02A34F151353963423FAF52172_1153466849 = new ObjectInUseException(
                    "Listening point already assigned for transport!");
        var6117DB02A34F151353963423FAF52172_1153466849.addTaint(taint);
        throw var6117DB02A34F151353963423FAF52172_1153466849;
        }
        lp.sipProvider = this;
        this.listeningPoints.put(transport, lp);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.723 -0400", hash_original_method = "A95AFDBCCDB5259A8B494C5125AAB0DF", hash_generated_method = "202ED735F120870EA1F0CC19789B3EA2")
    public synchronized void removeListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        addTaint(listeningPoint.getTaint());
        ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
    if(lp.messageProcessor.inUse())        
        {
        ObjectInUseException var975C1DF82DF6EF9E77161B57A363C950_1064702515 = new ObjectInUseException("Object is in use");
        var975C1DF82DF6EF9E77161B57A363C950_1064702515.addTaint(taint);
        throw var975C1DF82DF6EF9E77161B57A363C950_1064702515;
        }
        this.listeningPoints.remove(lp.getTransport().toUpperCase());
        // ---------- Original Method ----------
        //ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
        //if (lp.messageProcessor.inUse())
            //throw new ObjectInUseException("Object is in use");
        //this.listeningPoints.remove(lp.getTransport().toUpperCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.724 -0400", hash_original_method = "6DABC4D6488D8CA07EA47E3AEA2A5D8B", hash_generated_method = "75002181214E8756F87A4097FF65FA47")
    public synchronized void removeListeningPoints() {
for(Iterator it = this.listeningPoints.values().iterator();it
                .hasNext();)
        {
            ListeningPointImpl lp = (ListeningPointImpl) it.next();
            lp.messageProcessor.stop();
            it.remove();
        } //End block
        // ---------- Original Method ----------
        //for (Iterator it = this.listeningPoints.values().iterator(); it
                //.hasNext();) {
            //ListeningPointImpl lp = (ListeningPointImpl) it.next();
            //lp.messageProcessor.stop();
            //it.remove();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.725 -0400", hash_original_method = "08917B93BCD125C29B1D418CFBD693FD", hash_generated_method = "E83707CC863E470E103C8E9703EE3ADB")
    public void setAutomaticDialogSupportEnabled(
            boolean automaticDialogSupportEnabled) {
        this.automaticDialogSupportEnabled = automaticDialogSupportEnabled;
    if(this.automaticDialogSupportEnabled)        
        {
            this.dialogErrorsAutomaticallyHandled = true;
        } //End block
        // ---------- Original Method ----------
        //this.automaticDialogSupportEnabled = automaticDialogSupportEnabled;
        //if ( this.automaticDialogSupportEnabled ) {
            //this.dialogErrorsAutomaticallyHandled = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.725 -0400", hash_original_method = "18DDE4A1FF25A19616718FBEC8927BCF", hash_generated_method = "D1FB7FDF961A372B54FA1B2507D8A67A")
    public boolean isAutomaticDialogSupportEnabled() {
        boolean var03F94425985D4F12F061598392CB27B5_893183781 = (automaticDialogSupportEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_205479369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_205479369;
        // ---------- Original Method ----------
        //return automaticDialogSupportEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.726 -0400", hash_original_method = "8E72F0F9A971C2A6E1313B02079A711A", hash_generated_method = "21A90BA4CDE53CBAB0B11EDE68F90954")
    public void setDialogErrorsAutomaticallyHandled() {
        this.dialogErrorsAutomaticallyHandled = true;
        // ---------- Original Method ----------
        //this.dialogErrorsAutomaticallyHandled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.726 -0400", hash_original_method = "D32D7DD8A91D988429F699F6AD4CC892", hash_generated_method = "FA776F844FA469CE76E9DF73B75807A9")
    public boolean isDialogErrorsAutomaticallyHandled() {
        boolean var9FAF01DB0C6EBC63EE0B9CD25587DE10_227359238 = (this.dialogErrorsAutomaticallyHandled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69297441 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69297441;
        // ---------- Original Method ----------
        //return this.dialogErrorsAutomaticallyHandled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.726 -0400", hash_original_method = "C4DC38CCAB12B1686E686A836D3DE2C4", hash_generated_method = "A9F03D086FB71A20A20D12BE21176E73")
    public SipListener getSipListener() {
SipListener var2F04D1225330169A0BE7000A79FE261F_730428452 =         sipListener;
        var2F04D1225330169A0BE7000A79FE261F_730428452.addTaint(taint);
        return var2F04D1225330169A0BE7000A79FE261F_730428452;
        // ---------- Original Method ----------
        //return sipListener;
    }

    
}

