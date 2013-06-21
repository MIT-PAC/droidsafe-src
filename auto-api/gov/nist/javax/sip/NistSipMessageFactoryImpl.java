package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.stack.*;
import gov.nist.javax.sip.message.*;
import javax.sip.*;

class NistSipMessageFactoryImpl implements StackMessageFactory {
    private SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.151 -0400", hash_original_method = "B4A348E139EC58BD28DD0F3A69B45AAD", hash_generated_method = "A874AD672256916CAF2C19CC83828B07")
    @DSModeled(DSC.SAFE)
    public NistSipMessageFactoryImpl(SipStackImpl sipStackImpl) {
        dsTaint.addTaint(sipStackImpl.dsTaint);
        // ---------- Original Method ----------
        //this.sipStack = sipStackImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.152 -0400", hash_original_method = "05D11288A97D40A10A9E1FF4BB412446", hash_generated_method = "67DD98FFDE09809DA2CEC11A6CACD3D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerRequestInterface newSIPServerRequest(SIPRequest sipRequest,
            MessageChannel messageChannel) {
        dsTaint.addTaint(sipRequest.dsTaint);
        dsTaint.addTaint(messageChannel.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null Arg!");
        } //End block
        SipStackImpl theStack;
        theStack = (SipStackImpl) messageChannel.getSIPStack();
        DialogFilter retval;
        retval = new DialogFilter(
                theStack);
        {
            retval.transactionChannel = (SIPTransaction) messageChannel;
        } //End block
        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1933783298 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "Returning request interface for "
                            + sipRequest.getFirstLine() + " " + retval
                            + " messageChannel = " + messageChannel);
        } //End collapsed parenthetic
        return (ServerRequestInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.154 -0400", hash_original_method = "683DE9908ACD912FB40AB2EA7112FC1F", hash_generated_method = "403FD861061A25C3590F9C2D6413EF55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerResponseInterface newSIPServerResponse(
            SIPResponse sipResponse, MessageChannel messageChannel) {
        dsTaint.addTaint(sipResponse.dsTaint);
        dsTaint.addTaint(messageChannel.dsTaint);
        SIPTransactionStack theStack;
        theStack = (SIPTransactionStack) messageChannel
                .getSIPStack();
        SIPTransaction tr;
        tr = (SIPTransaction) ((SIPTransactionStack) theStack)
                .findTransaction(sipResponse, false);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_912156614 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "Found Transaction " + tr + " for " + sipResponse);
        } //End collapsed parenthetic
        {
            {
                boolean var8CC30C2C6971973DCC4073D74B2A1698_279048260 = (tr.getState() == null);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_916394502 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug(
                            "Dropping response - null transaction state");
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varD968AAC26EA8E18686FEA55040F790B4_1482111278 = (TransactionState.COMPLETED == tr.getState()
                    && sipResponse.getStatusCode() / 100 == 1);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1941675916 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logDebug(
                            "Dropping response - late arriving "
                                    + sipResponse.getStatusCode());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        DialogFilter retval;
        retval = new DialogFilter(
                sipStack);
        retval.transactionChannel = tr;
        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
        return (ServerResponseInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

