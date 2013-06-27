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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.161 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.162 -0400", hash_original_method = "B4A348E139EC58BD28DD0F3A69B45AAD", hash_generated_method = "9205204DA58BEC015C262841C10BC546")
    public  NistSipMessageFactoryImpl(SipStackImpl sipStackImpl) {
        this.sipStack = sipStackImpl;
        // ---------- Original Method ----------
        //this.sipStack = sipStackImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.163 -0400", hash_original_method = "05D11288A97D40A10A9E1FF4BB412446", hash_generated_method = "974EC979EBBFC2F36B30659C5E5138B7")
    public ServerRequestInterface newSIPServerRequest(SIPRequest sipRequest,
            MessageChannel messageChannel) {
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_1881904948 = null; //Variable for return #1
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_1868367880 = null; //Variable for return #2
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
        varB4EAC82CA7396A68D541C85D26508E83_1881904948 = null;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_267215655 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "Returning request interface for "
                            + sipRequest.getFirstLine() + " " + retval
                            + " messageChannel = " + messageChannel);
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1868367880 = retval;
        addTaint(sipRequest.getTaint());
        addTaint(messageChannel.getTaint());
        ServerRequestInterface varA7E53CE21691AB073D9660D615818899_1309724982; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1309724982 = varB4EAC82CA7396A68D541C85D26508E83_1881904948;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1309724982 = varB4EAC82CA7396A68D541C85D26508E83_1868367880;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1309724982.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1309724982;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.167 -0400", hash_original_method = "683DE9908ACD912FB40AB2EA7112FC1F", hash_generated_method = "6EACED945A82FC1459CEA12FAF849B20")
    public ServerResponseInterface newSIPServerResponse(
            SIPResponse sipResponse, MessageChannel messageChannel) {
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1241375217 = null; //Variable for return #1
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1124571708 = null; //Variable for return #2
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1485566104 = null; //Variable for return #3
        SIPTransactionStack theStack;
        theStack = (SIPTransactionStack) messageChannel
                .getSIPStack();
        SIPTransaction tr;
        tr = (SIPTransaction) ((SIPTransactionStack) theStack)
                .findTransaction(sipResponse, false);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1808956586 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "Found Transaction " + tr + " for " + sipResponse);
        } //End collapsed parenthetic
        {
            {
                boolean var8CC30C2C6971973DCC4073D74B2A1698_138910450 = (tr.getState() == null);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1408701908 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug(
                            "Dropping response - null transaction state");
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1241375217 = null;
                } //End block
                {
                    boolean varD968AAC26EA8E18686FEA55040F790B4_418818343 = (TransactionState.COMPLETED == tr.getState()
                    && sipResponse.getStatusCode() / 100 == 1);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1907481137 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logDebug(
                            "Dropping response - late arriving "
                                    + sipResponse.getStatusCode());
                        } //End collapsed parenthetic
                        varB4EAC82CA7396A68D541C85D26508E83_1124571708 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1485566104 = retval;
        addTaint(sipResponse.getTaint());
        addTaint(messageChannel.getTaint());
        ServerResponseInterface varA7E53CE21691AB073D9660D615818899_1603358658; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1603358658 = varB4EAC82CA7396A68D541C85D26508E83_1241375217;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1603358658 = varB4EAC82CA7396A68D541C85D26508E83_1124571708;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1603358658 = varB4EAC82CA7396A68D541C85D26508E83_1485566104;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1603358658.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1603358658;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

