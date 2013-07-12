package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.CommandException;

public abstract class CallTracker extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.023 -0400", hash_original_field = "AFC27A2C0BFE1A5164DE0AD98E91F583", hash_generated_field = "FD6602A5A7D30569DE1750B9B6FB9D72")

    protected int pendingOperations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.023 -0400", hash_original_field = "56296C062950BFEB66120DF06BAB58A3", hash_generated_field = "DBD10C1829EDDA3D610F0C4F9AFC36B9")

    protected boolean needsPoll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.023 -0400", hash_original_field = "5F72D910043EAD18E712C620A92EDD4F", hash_generated_field = "2AAFFD5368487CE94C86E8724E0E0C17")

    protected Message lastRelevantPoll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.023 -0400", hash_original_field = "820EB5B696EA2A657C0DB1E258DC7D81", hash_generated_field = "05962FE0A208085D4571A76418F3A959")

    public CommandsInterface cm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.023 -0400", hash_original_method = "A8AA2346503563FF548E182F14163DE2", hash_generated_method = "A8AA2346503563FF548E182F14163DE2")
    public CallTracker ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.023 -0400", hash_original_method = "9E5AE1F19CA0B0DDA40DD7B38560CD23", hash_generated_method = "42A78FD8782117D0BA6B84E1D284E64E")
    protected void pollCallsWhenSafe() {
        needsPoll = true;
    if(checkNoOperationsPending())        
        {
            lastRelevantPoll = obtainMessage(EVENT_POLL_CALLS_RESULT);
            cm.getCurrentCalls(lastRelevantPoll);
        } //End block
        // ---------- Original Method ----------
        //needsPoll = true;
        //if (checkNoOperationsPending()) {
            //lastRelevantPoll = obtainMessage(EVENT_POLL_CALLS_RESULT);
            //cm.getCurrentCalls(lastRelevantPoll);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.024 -0400", hash_original_method = "33B1B958F6F144EDE51B6E4EC19481A6", hash_generated_method = "5697EE82B0FA539118EB2A4DD834458B")
    protected void pollCallsAfterDelay() {
        Message msg = obtainMessage();
        msg.what = EVENT_REPOLL_AFTER_DELAY;
        sendMessageDelayed(msg, POLL_DELAY_MSEC);
        // ---------- Original Method ----------
        //Message msg = obtainMessage();
        //msg.what = EVENT_REPOLL_AFTER_DELAY;
        //sendMessageDelayed(msg, POLL_DELAY_MSEC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.025 -0400", hash_original_method = "F4B21BAFF99BD772D70D384A80DFCDD5", hash_generated_method = "40F6D16995BC8C3F67598FA6234D9C9C")
    protected boolean isCommandExceptionRadioNotAvailable(Throwable e) {
        addTaint(e.getTaint());
        boolean varA69A7F4DE9978142380BCDA8EA16D02F_1654445763 = (e != null && e instanceof CommandException
                && ((CommandException)e).getCommandError()
                        == CommandException.Error.RADIO_NOT_AVAILABLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130244841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130244841;
        // ---------- Original Method ----------
        //return e != null && e instanceof CommandException
                //&& ((CommandException)e).getCommandError()
                        //== CommandException.Error.RADIO_NOT_AVAILABLE;
    }

    
    protected abstract void handlePollCalls(AsyncResult ar);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.025 -0400", hash_original_method = "EE2AAD2C27709A74385988B0D484AC09", hash_generated_method = "FE80939189D3C44DD3848560891262C1")
    protected void handleRadioAvailable() {
        pollCallsWhenSafe();
        // ---------- Original Method ----------
        //pollCallsWhenSafe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.026 -0400", hash_original_method = "91C44089CAD2AA24231C5131EC918B32", hash_generated_method = "FBA84ED209558326AB5A05EA52A2BFC5")
    protected Message obtainNoPollCompleteMessage(int what) {
        addTaint(what);
        pendingOperations++;
        lastRelevantPoll = null;
Message var7D44CBDF570B5CB81D544F0887CE90C1_816685199 =         obtainMessage(what);
        var7D44CBDF570B5CB81D544F0887CE90C1_816685199.addTaint(taint);
        return var7D44CBDF570B5CB81D544F0887CE90C1_816685199;
        // ---------- Original Method ----------
        //pendingOperations++;
        //lastRelevantPoll = null;
        //return obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.026 -0400", hash_original_method = "D0619E60C8BD0CE46928E7D6B87D3BBB", hash_generated_method = "DD95D240827D3CDD69EEA7F710EDD78C")
    private boolean checkNoOperationsPending() {
    if(DBG_POLL)        
        log("checkNoOperationsPending: pendingOperations=" +
                pendingOperations);
        boolean var933C45B81253A7391096056DC5AFD473_1814328863 = (pendingOperations == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821263113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_821263113;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.028 -0400", hash_original_field = "BA76C0C87FE0928477EB48E458A4151B", hash_generated_field = "5105F543721DFE6C6FC4422BBF3A00CF")

    private static final boolean DBG_POLL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.028 -0400", hash_original_field = "99310BE6570AE8EAE4FD4F57007F25AF", hash_generated_field = "3722F9939CFDCCF4951B6323D6314219")

    static final int POLL_DELAY_MSEC = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.028 -0400", hash_original_field = "83FB612F823345D937905FAB1FD61844", hash_generated_field = "0AAB0D534F207DC90FD988BA80852530")

    protected static final int EVENT_POLL_CALLS_RESULT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.028 -0400", hash_original_field = "EC9136091AEAE0FB13AC5884BBB6F88C", hash_generated_field = "163FADEF9D457FD295F323F42C3B5123")

    protected static final int EVENT_CALL_STATE_CHANGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.028 -0400", hash_original_field = "06E391BAB861B821D0434D87AA42914B", hash_generated_field = "9FC46E35DA88DB80AD7D65587CBE3243")

    protected static final int EVENT_REPOLL_AFTER_DELAY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.028 -0400", hash_original_field = "E63571FBAEDF70564D0D10621458097A", hash_generated_field = "B8355783D90CF560D13D8892E62CF95A")

    protected static final int EVENT_OPERATION_COMPLETE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.029 -0400", hash_original_field = "6F40BAEC4DDC722F4F8A7A30BF126FC4", hash_generated_field = "FFF42859AA2F336073D8FCCAF613F9BF")

    protected static final int EVENT_GET_LAST_CALL_FAIL_CAUSE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.029 -0400", hash_original_field = "B73AC58800552961DA8EFDBA7C2CD9A9", hash_generated_field = "3F4A13558D1AEA1280CB5BA444D5485E")

    protected static final int EVENT_SWITCH_RESULT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.029 -0400", hash_original_field = "291F82A21517EED9D1E59719B9F12BEC", hash_generated_field = "A36C43879CD8A12D7585FFA07C09E465")

    protected static final int EVENT_RADIO_AVAILABLE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.029 -0400", hash_original_field = "4CF0769F2B534C8752AF9C01DC9FEFB4", hash_generated_field = "E9A728199771324DA087BE5C82DDEF47")

    protected static final int EVENT_RADIO_NOT_AVAILABLE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.029 -0400", hash_original_field = "16B3D13C25F0D8A08F524CCCD742FC58", hash_generated_field = "B09BDF3B114CD10BD7455939B7EDA2E0")

    protected static final int EVENT_CONFERENCE_RESULT = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.029 -0400", hash_original_field = "9E8DBA75FFE9C5E6A94A8DEAEB3E8E4B", hash_generated_field = "E17B6E1FB41E9AB8BB3317003B53D49E")

    protected static final int EVENT_SEPARATE_RESULT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.029 -0400", hash_original_field = "85D41242FA6D98717FDCA0879C26E937", hash_generated_field = "08E27A9BC39741EC67075C8A169F0120")

    protected static final int EVENT_ECT_RESULT = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.029 -0400", hash_original_field = "9CC15A03BFD1E5CE7145A7BA42B4E672", hash_generated_field = "ECCD6F67971BB1FF1E0C399E4B27E77B")

    protected static final int EVENT_EXIT_ECM_RESPONSE_CDMA = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.030 -0400", hash_original_field = "F953418DDC9C9D235DDFEECA41AC154B", hash_generated_field = "023440637F9DC8FA6F54413F9C51A1DD")

    protected static final int EVENT_CALL_WAITING_INFO_CDMA = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.030 -0400", hash_original_field = "F7D67E312BED2961FB2960125995E728", hash_generated_field = "539107BFD932275233EB5B6804617F2E")

    protected static final int EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA = 16;
}

