package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.CommandException;

public abstract class CallTracker extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.429 -0400", hash_original_field = "AFC27A2C0BFE1A5164DE0AD98E91F583", hash_generated_field = "FD6602A5A7D30569DE1750B9B6FB9D72")

    protected int pendingOperations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.429 -0400", hash_original_field = "56296C062950BFEB66120DF06BAB58A3", hash_generated_field = "DBD10C1829EDDA3D610F0C4F9AFC36B9")

    protected boolean needsPoll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.429 -0400", hash_original_field = "5F72D910043EAD18E712C620A92EDD4F", hash_generated_field = "2AAFFD5368487CE94C86E8724E0E0C17")

    protected Message lastRelevantPoll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.430 -0400", hash_original_field = "820EB5B696EA2A657C0DB1E258DC7D81", hash_generated_field = "05962FE0A208085D4571A76418F3A959")

    public CommandsInterface cm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.430 -0400", hash_original_method = "A8AA2346503563FF548E182F14163DE2", hash_generated_method = "A8AA2346503563FF548E182F14163DE2")
    public CallTracker ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.430 -0400", hash_original_method = "9E5AE1F19CA0B0DDA40DD7B38560CD23", hash_generated_method = "D51CCBF342E6F9551556CFA2D876112E")
    protected void pollCallsWhenSafe() {
        needsPoll = true;
        {
            boolean var4CC7D5D72E4F1C67AFC4C6F8B2002952_861678406 = (checkNoOperationsPending());
            {
                lastRelevantPoll = obtainMessage(EVENT_POLL_CALLS_RESULT);
                cm.getCurrentCalls(lastRelevantPoll);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //needsPoll = true;
        //if (checkNoOperationsPending()) {
            //lastRelevantPoll = obtainMessage(EVENT_POLL_CALLS_RESULT);
            //cm.getCurrentCalls(lastRelevantPoll);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.430 -0400", hash_original_method = "33B1B958F6F144EDE51B6E4EC19481A6", hash_generated_method = "7025F76B26EFCA183210572B1B09B149")
    protected void pollCallsAfterDelay() {
        Message msg;
        msg = obtainMessage();
        msg.what = EVENT_REPOLL_AFTER_DELAY;
        sendMessageDelayed(msg, POLL_DELAY_MSEC);
        // ---------- Original Method ----------
        //Message msg = obtainMessage();
        //msg.what = EVENT_REPOLL_AFTER_DELAY;
        //sendMessageDelayed(msg, POLL_DELAY_MSEC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.431 -0400", hash_original_method = "F4B21BAFF99BD772D70D384A80DFCDD5", hash_generated_method = "9B3A0C66FE4B75B5BE261009FD359863")
    protected boolean isCommandExceptionRadioNotAvailable(Throwable e) {
        boolean var35FACE3E29BC603CF02727C2F654B8B3_1908403940 = (e != null && e instanceof CommandException
                && ((CommandException)e).getCommandError()
                        == CommandException.Error.RADIO_NOT_AVAILABLE);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_267428631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_267428631;
        // ---------- Original Method ----------
        //return e != null && e instanceof CommandException
                //&& ((CommandException)e).getCommandError()
                        //== CommandException.Error.RADIO_NOT_AVAILABLE;
    }

    
    protected abstract void handlePollCalls(AsyncResult ar);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.431 -0400", hash_original_method = "EE2AAD2C27709A74385988B0D484AC09", hash_generated_method = "FE80939189D3C44DD3848560891262C1")
    protected void handleRadioAvailable() {
        pollCallsWhenSafe();
        // ---------- Original Method ----------
        //pollCallsWhenSafe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.454 -0400", hash_original_method = "91C44089CAD2AA24231C5131EC918B32", hash_generated_method = "A11F21E05EB5590E4EE08104278C6FF8")
    protected Message obtainNoPollCompleteMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1736976913 = null; //Variable for return #1
        lastRelevantPoll = null;
        varB4EAC82CA7396A68D541C85D26508E83_1736976913 = obtainMessage(what);
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_1736976913.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1736976913;
        // ---------- Original Method ----------
        //pendingOperations++;
        //lastRelevantPoll = null;
        //return obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.454 -0400", hash_original_method = "D0619E60C8BD0CE46928E7D6B87D3BBB", hash_generated_method = "9C61926BC88C55B3A6B90F5D07134BEA")
    private boolean checkNoOperationsPending() {
        log("checkNoOperationsPending: pendingOperations=" +
                pendingOperations);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_320044990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_320044990;
        // ---------- Original Method ----------
        //if (DBG_POLL) log("checkNoOperationsPending: pendingOperations=" +
                //pendingOperations);
        //return pendingOperations == 0;
    }

    
    public abstract void handleMessage (Message msg);

    
    public abstract void registerForVoiceCallStarted(Handler h, int what, Object obj);

    
    public abstract void unregisterForVoiceCallStarted(Handler h);

    
    public abstract void registerForVoiceCallEnded(Handler h, int what, Object obj);

    
    public abstract void unregisterForVoiceCallEnded(Handler h);

    
    protected abstract void log(String msg);

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "BA76C0C87FE0928477EB48E458A4151B", hash_generated_field = "AF4E2F29C7D0C5C24239F77C6471B21A")

    private static boolean DBG_POLL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "99310BE6570AE8EAE4FD4F57007F25AF", hash_generated_field = "950BA9E28980D9255A12529C1B6F97AE")

    static int POLL_DELAY_MSEC = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "83FB612F823345D937905FAB1FD61844", hash_generated_field = "008D494961B0AA9471711F6F01C04804")

    protected static int EVENT_POLL_CALLS_RESULT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "EC9136091AEAE0FB13AC5884BBB6F88C", hash_generated_field = "B520BB58C8240DD8A99CFE0A6F1D46AE")

    protected static int EVENT_CALL_STATE_CHANGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "06E391BAB861B821D0434D87AA42914B", hash_generated_field = "D55B289F013D09F15626E3278551C935")

    protected static int EVENT_REPOLL_AFTER_DELAY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "E63571FBAEDF70564D0D10621458097A", hash_generated_field = "6AF9A2A346AFFCB3911510B7E3165E78")

    protected static int EVENT_OPERATION_COMPLETE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "6F40BAEC4DDC722F4F8A7A30BF126FC4", hash_generated_field = "FB4FF4C8C2F2E93044238215F6DA4A5B")

    protected static int EVENT_GET_LAST_CALL_FAIL_CAUSE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "B73AC58800552961DA8EFDBA7C2CD9A9", hash_generated_field = "DA95813512FDE4A610B56FC73AA9FDB4")

    protected static int EVENT_SWITCH_RESULT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "291F82A21517EED9D1E59719B9F12BEC", hash_generated_field = "1F4A9D0B5F1C309BB74DDE1D04D61FA6")

    protected static int EVENT_RADIO_AVAILABLE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "4CF0769F2B534C8752AF9C01DC9FEFB4", hash_generated_field = "F3FB1622FC7D5C7B2CC6AA4D513D2560")

    protected static int EVENT_RADIO_NOT_AVAILABLE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "16B3D13C25F0D8A08F524CCCD742FC58", hash_generated_field = "E652B5E801B715CA30CA54994B492BA4")

    protected static int EVENT_CONFERENCE_RESULT = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "9E8DBA75FFE9C5E6A94A8DEAEB3E8E4B", hash_generated_field = "483000EC638462B741CF15CED0BC6F1C")

    protected static int EVENT_SEPARATE_RESULT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "85D41242FA6D98717FDCA0879C26E937", hash_generated_field = "270984646070C73F0999359C3E678A14")

    protected static int EVENT_ECT_RESULT = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "9CC15A03BFD1E5CE7145A7BA42B4E672", hash_generated_field = "93293CEEB41A3F3B35C200F6C31581D0")

    protected static int EVENT_EXIT_ECM_RESPONSE_CDMA = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "F953418DDC9C9D235DDFEECA41AC154B", hash_generated_field = "203045AD88117E90ECBE7AA8DC0CE7EC")

    protected static int EVENT_CALL_WAITING_INFO_CDMA = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.455 -0400", hash_original_field = "F7D67E312BED2961FB2960125995E728", hash_generated_field = "8C45829E9057467A3856FAE2B0892D90")

    protected static int EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA = 16;
}

