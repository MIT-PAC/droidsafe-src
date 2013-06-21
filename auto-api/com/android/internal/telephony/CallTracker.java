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
    protected int pendingOperations;
    protected boolean needsPoll;
    protected Message lastRelevantPoll;
    public CommandsInterface cm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.770 -0400", hash_original_method = "455BEDD67C86EF8A27211D344D36BAAA", hash_generated_method = "455BEDD67C86EF8A27211D344D36BAAA")
        public CallTracker ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.771 -0400", hash_original_method = "9E5AE1F19CA0B0DDA40DD7B38560CD23", hash_generated_method = "0507A88440837E9AFEAF9E5950F01761")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void pollCallsWhenSafe() {
        needsPoll = true;
        {
            boolean var4CC7D5D72E4F1C67AFC4C6F8B2002952_1374862470 = (checkNoOperationsPending());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.771 -0400", hash_original_method = "33B1B958F6F144EDE51B6E4EC19481A6", hash_generated_method = "7025F76B26EFCA183210572B1B09B149")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.771 -0400", hash_original_method = "F4B21BAFF99BD772D70D384A80DFCDD5", hash_generated_method = "B40F8D90B9C6EF5CCF70936662C828E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean isCommandExceptionRadioNotAvailable(Throwable e) {
        dsTaint.addTaint(e.dsTaint);
        boolean var35FACE3E29BC603CF02727C2F654B8B3_480922455 = (e != null && e instanceof CommandException
                && ((CommandException)e).getCommandError()
                        == CommandException.Error.RADIO_NOT_AVAILABLE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return e != null && e instanceof CommandException
                //&& ((CommandException)e).getCommandError()
                        //== CommandException.Error.RADIO_NOT_AVAILABLE;
    }

    
    protected abstract void handlePollCalls(AsyncResult ar);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.771 -0400", hash_original_method = "EE2AAD2C27709A74385988B0D484AC09", hash_generated_method = "FE80939189D3C44DD3848560891262C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void handleRadioAvailable() {
        pollCallsWhenSafe();
        // ---------- Original Method ----------
        //pollCallsWhenSafe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.772 -0400", hash_original_method = "91C44089CAD2AA24231C5131EC918B32", hash_generated_method = "3A302C7819B550EF0BC692E58D6BE381")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Message obtainNoPollCompleteMessage(int what) {
        dsTaint.addTaint(what);
        lastRelevantPoll = null;
        Message varC26248E20512DCE6AF1BDB5EAD201F8B_897696696 = (obtainMessage(what));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //pendingOperations++;
        //lastRelevantPoll = null;
        //return obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.772 -0400", hash_original_method = "D0619E60C8BD0CE46928E7D6B87D3BBB", hash_generated_method = "1E2EBAD41867F8EA87F11BAA2B88EB58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean checkNoOperationsPending() {
        log("checkNoOperationsPending: pendingOperations=" +
                pendingOperations);
        return dsTaint.getTaintBoolean();
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

    
    private static final boolean DBG_POLL = false;
    static final int POLL_DELAY_MSEC = 250;
    protected static final int EVENT_POLL_CALLS_RESULT             = 1;
    protected static final int EVENT_CALL_STATE_CHANGE             = 2;
    protected static final int EVENT_REPOLL_AFTER_DELAY            = 3;
    protected static final int EVENT_OPERATION_COMPLETE            = 4;
    protected static final int EVENT_GET_LAST_CALL_FAIL_CAUSE      = 5;
    protected static final int EVENT_SWITCH_RESULT                 = 8;
    protected static final int EVENT_RADIO_AVAILABLE               = 9;
    protected static final int EVENT_RADIO_NOT_AVAILABLE           = 10;
    protected static final int EVENT_CONFERENCE_RESULT             = 11;
    protected static final int EVENT_SEPARATE_RESULT               = 12;
    protected static final int EVENT_ECT_RESULT                    = 13;
    protected static final int EVENT_EXIT_ECM_RESPONSE_CDMA        = 14;
    protected static final int EVENT_CALL_WAITING_INFO_CDMA        = 15;
    protected static final int EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA = 16;
}

