package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;





public abstract class CallTracker extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.545 -0500", hash_original_field = "83EC3F78C66627469DFE7766D8BC2B63", hash_generated_field = "5105F543721DFE6C6FC4422BBF3A00CF")


    private static final boolean DBG_POLL = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.546 -0500", hash_original_field = "0ED71B911C6D069D7CFAAFAC303ABDB5", hash_generated_field = "3722F9939CFDCCF4951B6323D6314219")


    static final int POLL_DELAY_MSEC = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.551 -0500", hash_original_field = "35D7B342920402EC5081A17E447E2E1B", hash_generated_field = "0AAB0D534F207DC90FD988BA80852530")


    protected static final int EVENT_POLL_CALLS_RESULT             = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.552 -0500", hash_original_field = "A405429CBFB45673FDA5E664C3325F24", hash_generated_field = "163FADEF9D457FD295F323F42C3B5123")

    protected static final int EVENT_CALL_STATE_CHANGE             = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.552 -0500", hash_original_field = "C1A166CDF388DF4745CD12D5E717C0F8", hash_generated_field = "9FC46E35DA88DB80AD7D65587CBE3243")

    protected static final int EVENT_REPOLL_AFTER_DELAY            = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.553 -0500", hash_original_field = "CB8D6E92917D367CACD8C2D4DB53149B", hash_generated_field = "B8355783D90CF560D13D8892E62CF95A")

    protected static final int EVENT_OPERATION_COMPLETE            = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.554 -0500", hash_original_field = "AD8D5B4E3382A3FDD68552C4081F826B", hash_generated_field = "FFF42859AA2F336073D8FCCAF613F9BF")

    protected static final int EVENT_GET_LAST_CALL_FAIL_CAUSE      = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.555 -0500", hash_original_field = "A6A5E04ADE4C2BE6DC374568D9C63124", hash_generated_field = "3F4A13558D1AEA1280CB5BA444D5485E")


    protected static final int EVENT_SWITCH_RESULT                 = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.556 -0500", hash_original_field = "5FC7EADC7E6DC6ACD7505CB6DBB3197C", hash_generated_field = "A36C43879CD8A12D7585FFA07C09E465")

    protected static final int EVENT_RADIO_AVAILABLE               = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.557 -0500", hash_original_field = "FC2F22DAEE92BEA80D48666CAE066F9C", hash_generated_field = "E9A728199771324DA087BE5C82DDEF47")

    protected static final int EVENT_RADIO_NOT_AVAILABLE           = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.558 -0500", hash_original_field = "A95C6095A1159FEF5A59004D5CF2238D", hash_generated_field = "B09BDF3B114CD10BD7455939B7EDA2E0")

    protected static final int EVENT_CONFERENCE_RESULT             = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.558 -0500", hash_original_field = "308B77C2947889F14E8ECB7D2F319C92", hash_generated_field = "E17B6E1FB41E9AB8BB3317003B53D49E")

    protected static final int EVENT_SEPARATE_RESULT               = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.559 -0500", hash_original_field = "BFBD8841C7352442B2F7972D47EDDFF1", hash_generated_field = "08E27A9BC39741EC67075C8A169F0120")

    protected static final int EVENT_ECT_RESULT                    = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.560 -0500", hash_original_field = "35F04967D147885E0FDCCFBB527D2F83", hash_generated_field = "ECCD6F67971BB1FF1E0C399E4B27E77B")

    protected static final int EVENT_EXIT_ECM_RESPONSE_CDMA        = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.561 -0500", hash_original_field = "BE2A2A89E692807545C7D8586B4E033C", hash_generated_field = "023440637F9DC8FA6F54413F9C51A1DD")

    protected static final int EVENT_CALL_WAITING_INFO_CDMA        = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.562 -0500", hash_original_field = "D9284B0413E71DF59E58C4EC807F7BE2", hash_generated_field = "539107BFD932275233EB5B6804617F2E")

    protected static final int EVENT_THREE_WAY_DIAL_L2_RESULT_CDMA = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.547 -0500", hash_original_field = "E53991F0939FF29C580B93BD06CE0AC9", hash_generated_field = "FD6602A5A7D30569DE1750B9B6FB9D72")


    protected int pendingOperations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.548 -0500", hash_original_field = "CDF42ADC63460F76B52F6D43F4DA1257", hash_generated_field = "DBD10C1829EDDA3D610F0C4F9AFC36B9")

    protected boolean needsPoll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.548 -0500", hash_original_field = "6180C3D9A4D506A5FE6464C674890873", hash_generated_field = "2AAFFD5368487CE94C86E8724E0E0C17")

    protected Message lastRelevantPoll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.549 -0500", hash_original_field = "AD2081CF4152C993ABD262358732E864", hash_generated_field = "05962FE0A208085D4571A76418F3A959")


    public CommandsInterface cm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.520 -0400", hash_original_method = "A8AA2346503563FF548E182F14163DE2", hash_generated_method = "A8AA2346503563FF548E182F14163DE2")
    public CallTracker ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.563 -0500", hash_original_method = "9E5AE1F19CA0B0DDA40DD7B38560CD23", hash_generated_method = "E186395841829AC77C4B3B545E59FBCB")
    protected void pollCallsWhenSafe() {
        needsPoll = true;

        if (checkNoOperationsPending()) {
            lastRelevantPoll = obtainMessage(EVENT_POLL_CALLS_RESULT);
            cm.getCurrentCalls(lastRelevantPoll);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.564 -0500", hash_original_method = "33B1B958F6F144EDE51B6E4EC19481A6", hash_generated_method = "29352CE556803238213F83AEC7DFB73E")
    protected void
    pollCallsAfterDelay() {
        Message msg = obtainMessage();

        msg.what = EVENT_REPOLL_AFTER_DELAY;
        sendMessageDelayed(msg, POLL_DELAY_MSEC);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.564 -0500", hash_original_method = "F4B21BAFF99BD772D70D384A80DFCDD5", hash_generated_method = "BC7AC9C36515D563DF12D21DFA47B554")
    protected boolean
    isCommandExceptionRadioNotAvailable(Throwable e) {
        return e != null && e instanceof CommandException
                && ((CommandException)e).getCommandError()
                        == CommandException.Error.RADIO_NOT_AVAILABLE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.565 -0500", hash_original_method = "F4424A83FF577363504E072E232C6BA9", hash_generated_method = "56BDC45645BA9F68D2DF424D95218B58")
    protected abstract void handlePollCalls(AsyncResult ar);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.566 -0500", hash_original_method = "EE2AAD2C27709A74385988B0D484AC09", hash_generated_method = "32CAB74FFA4C20DE6E01FDB5D73B0AFB")
    protected void handleRadioAvailable() {
        pollCallsWhenSafe();
    }

    /**
     * Obtain a complete message that indicates that this operation
     * does not require polling of getCurrentCalls(). However, if other
     * operations that do need getCurrentCalls() are pending or are
     * scheduled while this operation is pending, the invocation
     * of getCurrentCalls() will be postponed until this
     * operation is also complete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.567 -0500", hash_original_method = "91C44089CAD2AA24231C5131EC918B32", hash_generated_method = "01BAEF5CCE5CB24D1DB173014C73734F")
    protected Message
    obtainNoPollCompleteMessage(int what) {
        pendingOperations++;
        lastRelevantPoll = null;
        return obtainMessage(what);
    }

    /**
     * @return true if we're idle or there's a call to getCurrentCalls() pending
     * but nothing else
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.568 -0500", hash_original_method = "D0619E60C8BD0CE46928E7D6B87D3BBB", hash_generated_method = "9A721E6D3B00ACE64A63C36A060B3C18")
    private boolean
    checkNoOperationsPending() {
        if (DBG_POLL) log("checkNoOperationsPending: pendingOperations=" +
                pendingOperations);
        return pendingOperations == 0;
    }


    //***** Overridden from Handler
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.568 -0500", hash_original_method = "DC212188FEA96E721DB2AE6D44B077BD", hash_generated_method = "818083ABEAD9789AFFD0CD112BC340FC")
    public abstract void handleMessage (Message msg);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.569 -0500", hash_original_method = "310390FA58C61D98035FB9F023EE00D7", hash_generated_method = "005E3D87745F420B2BB0107A7534048C")
    public abstract void registerForVoiceCallStarted(Handler h, int what, Object obj);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.570 -0500", hash_original_method = "8EA3EED1AB0CF98A30A1E0C1FD189AF6", hash_generated_method = "E4FB96C16FD3AD135B83DE423D1C73D1")
    public abstract void unregisterForVoiceCallStarted(Handler h);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.571 -0500", hash_original_method = "79961090D13E2ED83D67E92C24E032AD", hash_generated_method = "100CA775E61227FB64514461F3253CB5")
    public abstract void registerForVoiceCallEnded(Handler h, int what, Object obj);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.572 -0500", hash_original_method = "0C27A4B9F968C45822E289D3F01B1F79", hash_generated_method = "05547E723F0E4F66F186B18A9FB4E3B5")
    public abstract void unregisterForVoiceCallEnded(Handler h);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:15.573 -0500", hash_original_method = "1B0CB576F4EF5F2EF28DA50D10DF2025", hash_generated_method = "4B0D139DF3381DCA5257214505F38057")
    protected abstract void log(String msg);
}

