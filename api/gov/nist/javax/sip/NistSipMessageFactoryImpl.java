package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.stack.*;
import gov.nist.javax.sip.message.*;
import javax.sip.*;

class NistSipMessageFactoryImpl implements StackMessageFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.482 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.483 -0400", hash_original_method = "B4A348E139EC58BD28DD0F3A69B45AAD", hash_generated_method = "9205204DA58BEC015C262841C10BC546")
    public  NistSipMessageFactoryImpl(SipStackImpl sipStackImpl) {
        this.sipStack = sipStackImpl;
        // ---------- Original Method ----------
        //this.sipStack = sipStackImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.483 -0400", hash_original_method = "05D11288A97D40A10A9E1FF4BB412446", hash_generated_method = "CA25179D9A7E946E6C33E18426F70307")
    public ServerRequestInterface newSIPServerRequest(SIPRequest sipRequest,
            MessageChannel messageChannel) {
        addTaint(messageChannel.getTaint());
        addTaint(sipRequest.getTaint());
        if(messageChannel == null || sipRequest == null)        
        {
            IllegalArgumentException var98C918EACA170B9EBA9AB97F4457C25B_468709072 = new IllegalArgumentException("Null Arg!");
            var98C918EACA170B9EBA9AB97F4457C25B_468709072.addTaint(taint);
            throw var98C918EACA170B9EBA9AB97F4457C25B_468709072;
        } //End block
        SipStackImpl theStack = (SipStackImpl) messageChannel.getSIPStack();
        DialogFilter retval = new DialogFilter(
                theStack);
        if(messageChannel instanceof SIPTransaction)        
        {
            retval.transactionChannel = (SIPTransaction) messageChannel;
        } //End block
        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
        if(retval.listeningPoint == null)        
        {
ServerRequestInterface var540C13E9E156B687226421B24F2DF178_1680116403 =         null;
        var540C13E9E156B687226421B24F2DF178_1680116403.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1680116403;
        }
        if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug(
                    "Returning request interface for "
                            + sipRequest.getFirstLine() + " " + retval
                            + " messageChannel = " + messageChannel);
ServerRequestInterface varF9E19AD6135C970F387F77C6F3DE4477_1792467797 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1792467797.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1792467797;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.485 -0400", hash_original_method = "683DE9908ACD912FB40AB2EA7112FC1F", hash_generated_method = "59AA0E7CDA8720F02A07654DEB6BF544")
    public ServerResponseInterface newSIPServerResponse(
            SIPResponse sipResponse, MessageChannel messageChannel) {
        addTaint(messageChannel.getTaint());
        addTaint(sipResponse.getTaint());
        SIPTransactionStack theStack = (SIPTransactionStack) messageChannel
                .getSIPStack();
        SIPTransaction tr = (SIPTransaction) ((SIPTransactionStack) theStack)
                .findTransaction(sipResponse, false);
        if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug(
                    "Found Transaction " + tr + " for " + sipResponse);
        if(tr != null)        
        {
            if(tr.getState() == null)            
            {
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                            "Dropping response - null transaction state");
ServerResponseInterface var540C13E9E156B687226421B24F2DF178_21942601 =                 null;
                var540C13E9E156B687226421B24F2DF178_21942601.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_21942601;
            } //End block
            else
            if(TransactionState.COMPLETED == tr.getState()
                    && sipResponse.getStatusCode() / 100 == 1)            
            {
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                            "Dropping response - late arriving "
                                    + sipResponse.getStatusCode());
ServerResponseInterface var540C13E9E156B687226421B24F2DF178_1451813882 =                 null;
                var540C13E9E156B687226421B24F2DF178_1451813882.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1451813882;
            } //End block
        } //End block
        DialogFilter retval = new DialogFilter(
                sipStack);
        retval.transactionChannel = tr;
        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
ServerResponseInterface varF9E19AD6135C970F387F77C6F3DE4477_1862187409 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1862187409.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1862187409;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

