package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.stack.*;
import gov.nist.javax.sip.message.*;
import javax.sip.*;

class NistSipMessageFactoryImpl implements StackMessageFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.671 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.672 -0400", hash_original_method = "B4A348E139EC58BD28DD0F3A69B45AAD", hash_generated_method = "9205204DA58BEC015C262841C10BC546")
    public  NistSipMessageFactoryImpl(SipStackImpl sipStackImpl) {
        this.sipStack = sipStackImpl;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.673 -0400", hash_original_method = "05D11288A97D40A10A9E1FF4BB412446", hash_generated_method = "5D930DC8D9666C4541B59C30B6C26AE5")
    public ServerRequestInterface newSIPServerRequest(SIPRequest sipRequest,
            MessageChannel messageChannel) {
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_1501469564 = null; 
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_113737243 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null Arg!");
        } 
        SipStackImpl theStack = (SipStackImpl) messageChannel.getSIPStack();
        DialogFilter retval = new DialogFilter(
                theStack);
        {
            retval.transactionChannel = (SIPTransaction) messageChannel;
        } 
        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
        varB4EAC82CA7396A68D541C85D26508E83_1501469564 = null;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_805765597 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "Returning request interface for "
                            + sipRequest.getFirstLine() + " " + retval
                            + " messageChannel = " + messageChannel);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_113737243 = retval;
        addTaint(sipRequest.getTaint());
        addTaint(messageChannel.getTaint());
        ServerRequestInterface varA7E53CE21691AB073D9660D615818899_2121478781; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2121478781 = varB4EAC82CA7396A68D541C85D26508E83_1501469564;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2121478781 = varB4EAC82CA7396A68D541C85D26508E83_113737243;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2121478781.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2121478781;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.674 -0400", hash_original_method = "683DE9908ACD912FB40AB2EA7112FC1F", hash_generated_method = "250D6271C80157309BDD00BD07421C0E")
    public ServerResponseInterface newSIPServerResponse(
            SIPResponse sipResponse, MessageChannel messageChannel) {
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_262395314 = null; 
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1064091877 = null; 
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1373635819 = null; 
        SIPTransactionStack theStack = (SIPTransactionStack) messageChannel
                .getSIPStack();
        SIPTransaction tr = (SIPTransaction) ((SIPTransactionStack) theStack)
                .findTransaction(sipResponse, false);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_606313337 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "Found Transaction " + tr + " for " + sipResponse);
        } 
        {
            {
                boolean var8CC30C2C6971973DCC4073D74B2A1698_1090351381 = (tr.getState() == null);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_607937791 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug(
                            "Dropping response - null transaction state");
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_262395314 = null;
                } 
                {
                    boolean varD968AAC26EA8E18686FEA55040F790B4_836242947 = (TransactionState.COMPLETED == tr.getState()
                    && sipResponse.getStatusCode() / 100 == 1);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_374757413 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logDebug(
                            "Dropping response - late arriving "
                                    + sipResponse.getStatusCode());
                        } 
                        varB4EAC82CA7396A68D541C85D26508E83_1064091877 = null;
                    } 
                } 
            } 
        } 
        DialogFilter retval = new DialogFilter(
                sipStack);
        retval.transactionChannel = tr;
        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
        varB4EAC82CA7396A68D541C85D26508E83_1373635819 = retval;
        addTaint(sipResponse.getTaint());
        addTaint(messageChannel.getTaint());
        ServerResponseInterface varA7E53CE21691AB073D9660D615818899_366140491; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_366140491 = varB4EAC82CA7396A68D541C85D26508E83_262395314;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_366140491 = varB4EAC82CA7396A68D541C85D26508E83_1064091877;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_366140491 = varB4EAC82CA7396A68D541C85D26508E83_1373635819;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_366140491.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_366140491;
        
        
    }

    
}

