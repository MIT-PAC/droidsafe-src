package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.stack.*;
import gov.nist.javax.sip.message.*;
import javax.sip.*;

class NistSipMessageFactoryImpl implements StackMessageFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.530 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.531 -0400", hash_original_method = "B4A348E139EC58BD28DD0F3A69B45AAD", hash_generated_method = "9205204DA58BEC015C262841C10BC546")
    public  NistSipMessageFactoryImpl(SipStackImpl sipStackImpl) {
        this.sipStack = sipStackImpl;
        // ---------- Original Method ----------
        //this.sipStack = sipStackImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.532 -0400", hash_original_method = "05D11288A97D40A10A9E1FF4BB412446", hash_generated_method = "F77979128831AB5440B066D2C22E63DA")
    public ServerRequestInterface newSIPServerRequest(SIPRequest sipRequest,
            MessageChannel messageChannel) {
        addTaint(messageChannel.getTaint());
        addTaint(sipRequest.getTaint());
    if(messageChannel == null || sipRequest == null)        
        {
            IllegalArgumentException var98C918EACA170B9EBA9AB97F4457C25B_1412901593 = new IllegalArgumentException("Null Arg!");
            var98C918EACA170B9EBA9AB97F4457C25B_1412901593.addTaint(taint);
            throw var98C918EACA170B9EBA9AB97F4457C25B_1412901593;
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
ServerRequestInterface var540C13E9E156B687226421B24F2DF178_1959596788 =         null;
        var540C13E9E156B687226421B24F2DF178_1959596788.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1959596788;
        }
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug(
                    "Returning request interface for "
                            + sipRequest.getFirstLine() + " " + retval
                            + " messageChannel = " + messageChannel);
ServerRequestInterface varF9E19AD6135C970F387F77C6F3DE4477_1208490545 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1208490545.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1208490545;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.533 -0400", hash_original_method = "683DE9908ACD912FB40AB2EA7112FC1F", hash_generated_method = "2AFECAA58313CC962CA373E3EEC205B8")
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
ServerResponseInterface var540C13E9E156B687226421B24F2DF178_803248909 =                 null;
                var540C13E9E156B687226421B24F2DF178_803248909.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_803248909;
            } //End block
            else
    if(TransactionState.COMPLETED == tr.getState()
                    && sipResponse.getStatusCode() / 100 == 1)            
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                            "Dropping response - late arriving "
                                    + sipResponse.getStatusCode());
ServerResponseInterface var540C13E9E156B687226421B24F2DF178_43177941 =                 null;
                var540C13E9E156B687226421B24F2DF178_43177941.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_43177941;
            } //End block
        } //End block
        DialogFilter retval = new DialogFilter(
                sipStack);
        retval.transactionChannel = tr;
        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
ServerResponseInterface varF9E19AD6135C970F387F77C6F3DE4477_1530036713 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1530036713.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1530036713;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

