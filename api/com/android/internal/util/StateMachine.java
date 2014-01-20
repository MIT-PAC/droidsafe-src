package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class StateMachine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.233 -0500", hash_original_field = "9FD3B607C2F334E98D8FA0A2E04D6217", hash_generated_field = "CAD0D1AF78117508D5FE12695CB44B34")

    private static final String TAG = "StateMachine";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.238 -0500", hash_original_field = "D48849132123F15BD2EBE411A629A314", hash_generated_field = "2DF10E3674476E7DE2945B0A711F8281")

    public static final int SM_QUIT_CMD = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.240 -0500", hash_original_field = "71DE75F91179022D2F09E308A23AC237", hash_generated_field = "F4722196E019D2E6C260778CB0A7C91A")

    public static final int SM_INIT_CMD = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.243 -0500", hash_original_field = "4DF6DBBBF1478FF8012AD5D81A0774F2", hash_generated_field = "C37530D81C60F59480493B32E2235094")

    public static final boolean HANDLED = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.245 -0500", hash_original_field = "837B7FF2435A0DE90476EA9F8F31485B", hash_generated_field = "A7A249A527FCD19FBF4EEC3A15F4F044")

    public static final boolean NOT_HANDLED = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.235 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.459 -0500", hash_original_field = "5E9C641411F0CE80B07D05D82577ED91", hash_generated_field = "8DC42536419669DDCF0A80F5D8F0EF49")

    private SmHandler mSmHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.462 -0500", hash_original_field = "C68060FB502E47D48982B3171A8CC95B", hash_generated_field = "60795A86AEB0DA28C5A6A37DF9379911")

    private HandlerThread mSmThread;

    /**
     * Constructor creates a StateMachine with its own thread.
     *
     * @param name of the state machine
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.467 -0500", hash_original_method = "965279A1412D73A89A7122845884F290", hash_generated_method = "55E55FE7AC67CAFAB7BB404F0A6ECF67")
    
protected StateMachine(String name) {
        mSmThread = new HandlerThread(name);
        mSmThread.start();
        Looper looper = mSmThread.getLooper();

        initStateMachine(name, looper);
    }

    /**
     * Constructor creates an StateMachine using the looper.
     *
     * @param name of the state machine
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.470 -0500", hash_original_method = "8270C3E9AEADC5B23E7F677870CDA596", hash_generated_method = "8E79DE2F5393729EA7E7AF411DE90517")
    
protected StateMachine(String name, Looper looper) {
        initStateMachine(name, looper);
    }

    /**
     * Initialize.
     *
     * @param looper for this state machine
     * @param name of the state machine
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.464 -0500", hash_original_method = "DAD3CAAA263F09CC114EE283728F2037", hash_generated_method = "A1308E401E9B010467FCF73FB34174A7")
    
private void initStateMachine(String name, Looper looper) {
        mName = name;
        mSmHandler = new SmHandler(looper, this);
    }

    /**
     * Add a new state to the state machine
     * @param state the state to add
     * @param parent the parent of state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.472 -0500", hash_original_method = "9CB95CDEC2272D9103D9B302315B1CF0", hash_generated_method = "23C0CBA286C0E63CA9505736A14F161D")
    
protected final void addState(State state, State parent) {
        mSmHandler.addState(state, parent);
    }

    /**
     * @return current message
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.475 -0500", hash_original_method = "E9B863EE3D8BE2542840411248513D5A", hash_generated_method = "835B5761B2AC064E490F75E706214CC5")
    
protected final Message getCurrentMessage() {
        return mSmHandler.getCurrentMessage();
    }

    /**
     * @return current state
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.477 -0500", hash_original_method = "D598BDB56AFF58F966F9A8594C83023E", hash_generated_method = "2CE1E5E97AE24E2B81F6FA87D1175D10")
    
protected final IState getCurrentState() {
        return mSmHandler.getCurrentState();
    }

    /**
     * Add a new state to the state machine, parent will be null
     * @param state to add
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.480 -0500", hash_original_method = "3FDCC93D71F6B56C0FCF47E8C68EDFCE", hash_generated_method = "5BAA87DD4184D44E415CEACD0690D8AC")
    
protected final void addState(State state) {
        mSmHandler.addState(state, null);
    }

    /**
     * Set the initial state. This must be invoked before
     * and messages are sent to the state machine.
     *
     * @param initialState is the state which will receive the first message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.483 -0500", hash_original_method = "FA85C85D6842E1150C141EC2987FEC52", hash_generated_method = "0F917EDBFFB2D8AE57F94734B8B47C7A")
    
protected final void setInitialState(State initialState) {
        mSmHandler.setInitialState(initialState);
    }

    /**
     * transition to destination state. Upon returning
     * from processMessage the current state's exit will
     * be executed and upon the next message arriving
     * destState.enter will be invoked.
     *
     * this function can also be called inside the enter function of the
     * previous transition target, but the behavior is undefined when it is
     * called mid-way through a previous transition (for example, calling this
     * in the enter() routine of a intermediate node when the current transition
     * target is one of the nodes descendants).
     *
     * @param destState will be the state that receives the next message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.485 -0500", hash_original_method = "DDAEED1DEC80DD4893B8BEC6C1C4D0F1", hash_generated_method = "35F783713680EB8370629FE1B8AFEEA2")
    
protected final void transitionTo(IState destState) {
        mSmHandler.transitionTo(destState);
    }

    /**
     * transition to halt state. Upon returning
     * from processMessage we will exit all current
     * states, execute the halting() method and then
     * all subsequent messages haltedProcessMesage
     * will be called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.488 -0500", hash_original_method = "42225DFCDD57D6590F4D09D0862811E2", hash_generated_method = "91BF5452E2FC2358B7FC58DB9218920A")
    
protected final void transitionToHaltingState() {
        mSmHandler.transitionTo(mSmHandler.mHaltingState);
    }

    /**
     * Defer this message until next state transition.
     * Upon transitioning all deferred messages will be
     * placed on the queue and reprocessed in the original
     * order. (i.e. The next state the oldest messages will
     * be processed first)
     *
     * @param msg is deferred until the next transition.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.491 -0500", hash_original_method = "261AEA0DB1968E370C4ADDBA675B5E74", hash_generated_method = "3E38F4A58EB3BB7BBD86891532297B8F")
    
protected final void deferMessage(Message msg) {
        mSmHandler.deferMessage(msg);
    }

    /**
     * Called when message wasn't handled
     *
     * @param msg that couldn't be handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.493 -0500", hash_original_method = "7997D0B28C80AB12F09EF0050700F72A", hash_generated_method = "6CD09AE0D6A2C8361B72008D380C7BC9")
    
protected void unhandledMessage(Message msg) {
        if (mSmHandler.mDbg) Log.e(TAG, mName + " - unhandledMessage: msg.what=" + msg.what);
    }

    /**
     * Called for any message that is received after
     * transitionToHalting is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.496 -0500", hash_original_method = "056AA616A824F08818D1B78343E1C249", hash_generated_method = "28FB349096C79F28004E74C0CD161B7C")
    
protected void haltedProcessMessage(Message msg) {
    }

    /**
     * This will be called once after handling a message that called
     * transitionToHalting. All subsequent messages will invoke
     * {@link StateMachine#haltedProcessMessage(Message)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.498 -0500", hash_original_method = "4C387498336ED4C08F04A3A81289F626", hash_generated_method = "921152430BBFB9B74751BBD3BE91A970")
    
protected void halting() {
    }

    /**
     * This will be called once after a quit message that was NOT handled by
     * the derived StateMachine. The StateMachine will stop and any subsequent messages will be
     * ignored. In addition, if this StateMachine created the thread, the thread will
     * be stopped after this method returns.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.500 -0500", hash_original_method = "B35375ECAB57B816953617EBE5B4DD2F", hash_generated_method = "56C909299110BEF81A6B603458F1C204")
    
protected void quitting() {
    }

    /**
     * @return the name
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.502 -0500", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "180770248625D86846C6E10AC417237F")
    
public final String getName() {
        return mName;
    }

    /**
     * Set size of messages to maintain and clears all current messages.
     *
     * @param maxSize number of messages to maintain at anyone time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.505 -0500", hash_original_method = "3B515C020FBA4525296124D17148DAD9", hash_generated_method = "39018DD27B4DB95CD48D549EA71BD7D0")
    
public final void setProcessedMessagesSize(int maxSize) {
        mSmHandler.setProcessedMessagesSize(maxSize);
    }

    /**
     * @return number of messages processed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.507 -0500", hash_original_method = "9A0BF952A27C97CD544B7334CD0A8AD7", hash_generated_method = "69807B6D97FB3B7CAF274999734C6E7C")
    
public final int getProcessedMessagesSize() {
        return mSmHandler.getProcessedMessagesSize();
    }

    /**
     * @return the total number of messages processed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.510 -0500", hash_original_method = "7E321218401071A5914E48165DB351C0", hash_generated_method = "664E711FADADE89E4DA72B07FFF3EC0B")
    
public final int getProcessedMessagesCount() {
        return mSmHandler.getProcessedMessagesCount();
    }

    /**
     * @return a processed message information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.513 -0500", hash_original_method = "C801EF2BEB9E095EF75CD2E078DF8F4D", hash_generated_method = "295C309E490B7B8118A5F5459B2C34E8")
    
public final ProcessedMessageInfo getProcessedMessageInfo(int index) {
        return mSmHandler.getProcessedMessageInfo(index);
    }

    /**
     * @return Handler
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.515 -0500", hash_original_method = "467C85CDF2FD06F7E6D6E1A3F89DC6AE", hash_generated_method = "C94C0ABD705AEB3CD982EC1F972C7C7B")
    
public final Handler getHandler() {
        return mSmHandler;
    }

    /**
     * Get a message and set Message.target = this.
     *
     * @return message or null if SM has quit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.518 -0500", hash_original_method = "ECC92B44317075FA349076F0B0608CC3", hash_generated_method = "65116EA66D8224173DAB085A371A4E8B")
    
public final Message obtainMessage()
    {
        if (mSmHandler == null) return null;

        return Message.obtain(mSmHandler);
    }

    /**
     * Get a message and set Message.target = this and what
     *
     * @param what is the assigned to Message.what.
     * @return message or null if SM has quit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.520 -0500", hash_original_method = "F3ABD31C8A8A675CAB7BDC7D39B74873", hash_generated_method = "8B68C7DCD271490F38F6EC2B5AA72D48")
    
public final Message obtainMessage(int what) {
        if (mSmHandler == null) return null;

        return Message.obtain(mSmHandler, what);
    }

    /**
     * Get a message and set Message.target = this,
     * what and obj.
     *
     * @param what is the assigned to Message.what.
     * @param obj is assigned to Message.obj.
     * @return message or null if SM has quit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.523 -0500", hash_original_method = "2782AA628D17C295F1631BCDEC3DEA27", hash_generated_method = "FACA1C8BED9BA59978507A4ED38EC2B8")
    
public final Message obtainMessage(int what, Object obj)
    {
        if (mSmHandler == null) return null;

        return Message.obtain(mSmHandler, what, obj);
    }

    /**
     * Get a message and set Message.target = this,
     * what, arg1 and arg2
     *
     * @param what  is assigned to Message.what
     * @param arg1  is assigned to Message.arg1
     * @param arg2  is assigned to Message.arg2
     * @return  A Message object from the global pool or null if
     *          SM has quit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.526 -0500", hash_original_method = "90FE3D951CADE6238FC04DAF938292E8", hash_generated_method = "1DB46AD9CA62F7D83BB5C1D680DE0E09")
    
public final Message obtainMessage(int what, int arg1, int arg2)
    {
        if (mSmHandler == null) return null;

        return Message.obtain(mSmHandler, what, arg1, arg2);
    }

    /**
     * Get a message and set Message.target = this,
     * what, arg1, arg2 and obj
     *
     * @param what  is assigned to Message.what
     * @param arg1  is assigned to Message.arg1
     * @param arg2  is assigned to Message.arg2
     * @param obj is assigned to Message.obj
     * @return  A Message object from the global pool or null if
     *          SM has quit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.528 -0500", hash_original_method = "9FA101C66AEE3272C97FB43923C2AC9F", hash_generated_method = "E639B18E2655E8BD83F1660C454D28ED")
    
public final Message obtainMessage(int what, int arg1, int arg2, Object obj)
    {
        if (mSmHandler == null) return null;

        return Message.obtain(mSmHandler, what, arg1, arg2, obj);
    }

    /**
     * Enqueue a message to this state machine.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.531 -0500", hash_original_method = "4C17D9C303E0C63CA9FC8056DA52EF3D", hash_generated_method = "464B50AF5EE3FC5711804488EE9646B7")
    
public final void sendMessage(int what) {
        // mSmHandler can be null if the state machine has quit.
        if (mSmHandler == null) return;

        mSmHandler.sendMessage(obtainMessage(what));
    }

    /**
     * Enqueue a message to this state machine.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.533 -0500", hash_original_method = "FBA6CF7C9F3F790F28B53AD9439353BD", hash_generated_method = "1B4484E20414E2354C56FD473F632D9E")
    
public final void sendMessage(int what, Object obj) {
        // mSmHandler can be null if the state machine has quit.
        if (mSmHandler == null) return;

        mSmHandler.sendMessage(obtainMessage(what,obj));
    }

    /**
     * Enqueue a message to this state machine.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.536 -0500", hash_original_method = "6E13019DC70D12278C5C1075A86F8BFE", hash_generated_method = "7D47522DE1396B44E04041823D17AA3A")
    
public final void sendMessage(Message msg) {
        // mSmHandler can be null if the state machine has quit.
        if (mSmHandler == null) return;

        mSmHandler.sendMessage(msg);
    }

    /**
     * Enqueue a message to this state machine after a delay.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.538 -0500", hash_original_method = "6F45F99BF67AD2AF5583C8727970AA91", hash_generated_method = "97A13C5DA159D3B479CB785539ED33E8")
    
public final void sendMessageDelayed(int what, long delayMillis) {
        // mSmHandler can be null if the state machine has quit.
        if (mSmHandler == null) return;

        mSmHandler.sendMessageDelayed(obtainMessage(what), delayMillis);
    }

    /**
     * Enqueue a message to this state machine after a delay.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.541 -0500", hash_original_method = "39A6E49D71A514B448DAD14BF952A265", hash_generated_method = "04E6AC5DE73619CBEFDA60351FDE1B9C")
    
public final void sendMessageDelayed(int what, Object obj, long delayMillis) {
        // mSmHandler can be null if the state machine has quit.
        if (mSmHandler == null) return;

        mSmHandler.sendMessageDelayed(obtainMessage(what, obj), delayMillis);
    }

    /**
     * Enqueue a message to this state machine after a delay.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.544 -0500", hash_original_method = "9D9110C540430F2A7712B1C42CF073E5", hash_generated_method = "4ADF8EF58038DBFAB17BE2712E47AC52")
    
public final void sendMessageDelayed(Message msg, long delayMillis) {
        // mSmHandler can be null if the state machine has quit.
        if (mSmHandler == null) return;

        mSmHandler.sendMessageDelayed(msg, delayMillis);
    }

    /**
     * Enqueue a message to the front of the queue for this state machine.
     * Protected, may only be called by instances of StateMachine.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.547 -0500", hash_original_method = "687B3882728A203A122F07AED4E62B4F", hash_generated_method = "96C579179609D0A4B722153F85867919")
    
protected final void sendMessageAtFrontOfQueue(int what, Object obj) {
        mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(what, obj));
    }

    /**
     * Enqueue a message to the front of the queue for this state machine.
     * Protected, may only be called by instances of StateMachine.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.550 -0500", hash_original_method = "57A82123C5C1A73035060A1546C23399", hash_generated_method = "7AC6E4C88CB4899E1D5D6E8E841C247D")
    
protected final void sendMessageAtFrontOfQueue(int what) {
        mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(what));
    }

    /**
     * Enqueue a message to the front of the queue for this state machine.
     * Protected, may only be called by instances of StateMachine.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.552 -0500", hash_original_method = "DAD8B3BB967F6D568CBDEF14E7D7FC31", hash_generated_method = "9B11EFCAF424D0D01AAEA8CED2C46F16")
    
protected final void sendMessageAtFrontOfQueue(Message msg) {
        mSmHandler.sendMessageAtFrontOfQueue(msg);
    }

    /**
     * Removes a message from the message queue.
     * Protected, may only be called by instances of StateMachine.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.556 -0500", hash_original_method = "58582EEB8BE4D233D0E7915A49A3AF70", hash_generated_method = "070C2477A678FF92D3E830DC377C79A5")
    
protected final void removeMessages(int what) {
        mSmHandler.removeMessages(what);
    }
    
    public static class ProcessedMessageInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.249 -0500", hash_original_field = "6100FAC75E91CAC232945E82029A9682", hash_generated_field = "A000BD07D4DBA654B5ACE4EC76BBFFA1")

        private int what;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.251 -0500", hash_original_field = "05D925C5BEC5275A59607FB5FAF72E84", hash_generated_field = "1BABB00C62C02094F906A511C44D4ACB")

        private State state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.253 -0500", hash_original_field = "38AC96C43EEAAE91588CC98B647C7227", hash_generated_field = "31B05008E27000A3E17D4629DFC22D7C")

        private State orgState;

        /**
         * Constructor
         * @param message
         * @param state that handled the message
         * @param orgState is the first state the received the message but
         * did not processes the message.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.257 -0500", hash_original_method = "7EA9EE86A36AF0562D3C01EEF98869EA", hash_generated_method = "7EA9EE86A36AF0562D3C01EEF98869EA")
        
ProcessedMessageInfo(Message message, State state, State orgState) {
            update(message, state, orgState);
        }

        /**
         * Update the information in the record.
         * @param state that handled the message
         * @param orgState is the first state the received the message but
         * did not processes the message.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.259 -0500", hash_original_method = "AE92957E52CD2ECF48167D0FF23A4162", hash_generated_method = "1F9DE2609B1FAB3B656ADC2A516F906D")
        
public void update(Message message, State state, State orgState) {
            this.what = message.what;
            this.state = state;
            this.orgState = orgState;
        }

        /**
         * @return the command that was executing
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.262 -0500", hash_original_method = "4AA8DBE0617D26A2E34EC5BDBA364E43", hash_generated_method = "5E7B038D5CD0884C490060475A667189")
        
public int getWhat() {
            return what;
        }

        /**
         * @return the state that handled this message
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.264 -0500", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "501DC0DCEBE66E1C2384E415192C6550")
        
public State getState() {
            return state;
        }

        /**
         * @return the original state that received the message.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.266 -0500", hash_original_method = "6453845FB279EEE2A3A97B4923853CA9", hash_generated_method = "789056AEA241B442A7C93C8016C316E6")
        
public State getOriginalState() {
            return orgState;
        }

        /**
         * @return as string
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.269 -0500", hash_original_method = "1BEC9C7E840A94CA1F6D8F0CAE4CCE3D", hash_generated_method = "D73BDD99ECB32E0711BAA77596588488")
        
@Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("what=");
            sb.append(what);
            sb.append(" state=");
            sb.append(cn(state));
            sb.append(" orgState=");
            sb.append(cn(orgState));
            return sb.toString();
        }

        /**
         * @return an objects class name
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.272 -0500", hash_original_method = "BFE06EA51077266A4C3CDDB9CF5A61E9", hash_generated_method = "EF255C4030F3A9AD46E25889C3255795")
        
private String cn(Object n) {
            if (n == null) {
                return "null";
            } else {
                String name = n.getClass().getName();
                int lastDollar = name.lastIndexOf('$');
                return name.substring(lastDollar + 1);
            }
        }
        
    }
    
    private static class ProcessedMessages {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.277 -0500", hash_original_field = "44F7CCFF2EFD94D896EEBE71FDD95C96", hash_generated_field = "D046EB83567C8AE65CE2B140E78656A6")

        private static final int DEFAULT_SIZE = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.280 -0500", hash_original_field = "03A50413291C355D0F9AB94053EAC4FB", hash_generated_field = "E3B7DBE08CEF79947D2C5DA6C5D670A8")

        private Vector<ProcessedMessageInfo> mMessages = new Vector<ProcessedMessageInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.282 -0500", hash_original_field = "571AC8C77FA2A6993129ACA5C1312B57", hash_generated_field = "706F44912DCFEA7F4271168A8A5FEC7F")

        private int mMaxSize = DEFAULT_SIZE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.285 -0500", hash_original_field = "B0770EDD578B7BC557F5474905B73942", hash_generated_field = "ACB9E601905428D5F1514FA73B95CCB8")

        private int mOldestIndex = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.287 -0500", hash_original_field = "D01C96038701D525501067476D6E20FD", hash_generated_field = "FF64F9A7A53D85DAFE355CC940E3F92D")

        private int mCount = 0;

        /**
         * Constructor
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.290 -0500", hash_original_method = "8C2E4982B56D335A57BD25CE5A99A95E", hash_generated_method = "8C2E4982B56D335A57BD25CE5A99A95E")
        
ProcessedMessages() {
        }

        /**
         * Set size of messages to maintain and clears all current messages.
         *
         * @param maxSize number of messages to maintain at anyone time.
        */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.292 -0500", hash_original_method = "E690879E37418633C091A0E6D09F0FE8", hash_generated_method = "E690879E37418633C091A0E6D09F0FE8")
        
void setSize(int maxSize) {
            mMaxSize = maxSize;
            mCount = 0;
            mMessages.clear();
        }

        /**
         * @return the number of recent messages.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.294 -0500", hash_original_method = "661C67FDA7F2FAF16A0B73519F701A14", hash_generated_method = "661C67FDA7F2FAF16A0B73519F701A14")
        
int size() {
            return mMessages.size();
        }

        /**
         * @return the total number of messages processed since size was set.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.297 -0500", hash_original_method = "173278F07A9E3F76B246C31AF2BEE799", hash_generated_method = "173278F07A9E3F76B246C31AF2BEE799")
        
int count() {
            return mCount;
        }

        /**
         * Clear the list of Processed Message Info.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.299 -0500", hash_original_method = "7C55F1E05538CA172591209F0EED6056", hash_generated_method = "7C55F1E05538CA172591209F0EED6056")
        
void cleanup() {
            mMessages.clear();
        }

        /**
         * @return the information on a particular record. 0 is the oldest
         * record and size()-1 is the newest record. If the index is to
         * large null is returned.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.302 -0500", hash_original_method = "9D508AC508F62C2D8A912ED09416EAAB", hash_generated_method = "9D508AC508F62C2D8A912ED09416EAAB")
        
ProcessedMessageInfo get(int index) {
            int nextIndex = mOldestIndex + index;
            if (nextIndex >= mMaxSize) {
                nextIndex -= mMaxSize;
            }
            if (nextIndex >= size()) {
                return null;
            } else {
                return mMessages.get(nextIndex);
            }
        }

        /**
         * Add a processed message.
         *
         * @param message
         * @param state that handled the message
         * @param orgState is the first state the received the message but
         * did not processes the message.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.305 -0500", hash_original_method = "43A85B457185E158137E22B107CD3124", hash_generated_method = "43A85B457185E158137E22B107CD3124")
        
void add(Message message, State state, State orgState) {
            mCount += 1;
            if (mMessages.size() < mMaxSize) {
                mMessages.add(new ProcessedMessageInfo(message, state, orgState));
            } else {
                ProcessedMessageInfo pmi = mMessages.get(mOldestIndex);
                mOldestIndex += 1;
                if (mOldestIndex >= mMaxSize) {
                    mOldestIndex = 0;
                }
                pmi.update(message, state, orgState);
            }
        }
    }
    
    private static class SmHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.313 -0500", hash_original_field = "D2C6479312C41E6B834286106428CBAE", hash_generated_field = "79B0F5D3D1C26EC177F0047971DE5AB2")

        private static final Object mQuitObj = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.310 -0500", hash_original_field = "C1D0D4D21780F6F4D32D467F7DD17115", hash_generated_field = "84BF5FE621A31FF82764E5E75B6B2B40")

        private boolean mDbg = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.315 -0500", hash_original_field = "305BF3E79C732EEF9711307DC47EF26A", hash_generated_field = "54E38D66DD7526E5701FBBAD9B009DFE")

        private Message mMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.317 -0500", hash_original_field = "6F6B227CDA11272928BE912904BE4160", hash_generated_field = "EFAC02A563A53F74A935F29F327B6CC6")

        private ProcessedMessages mProcessedMessages = new ProcessedMessages();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.320 -0500", hash_original_field = "63E51C50275B97C8F8596E20FD092AB7", hash_generated_field = "AD0490DB6C87F3957759A9A5591E811D")

        private boolean mIsConstructionCompleted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.322 -0500", hash_original_field = "20DBC30AB43E599703F8F750EAC7D34B", hash_generated_field = "C83A631E77C81B863F638A8667284991")

        private StateInfo mStateStack[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.325 -0500", hash_original_field = "B3122ECC06094D2715140CDF4D12C559", hash_generated_field = "5CD90CA8F874AD9DE38AB1A114D42E12")

        private int mStateStackTopIndex = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.328 -0500", hash_original_field = "F67C68CA871EAF811A802E8474588262", hash_generated_field = "195AFABD8F84AE5B999C5618E29EE0A7")

        private StateInfo mTempStateStack[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.330 -0500", hash_original_field = "50785194CB9EC3F02B3D9EAACD8A6F39", hash_generated_field = "D2085166BB400AAC15FE91947D0BFF38")

        private int mTempStateStackCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.333 -0500", hash_original_field = "C1E7210C236EEE92E9EBC90E7C9AE9DD", hash_generated_field = "3CD37F42E2372296C9C2572BA23C4A97")

        private HaltingState mHaltingState = new HaltingState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.335 -0500", hash_original_field = "884BDAC122AACB82590FEB047C883A55", hash_generated_field = "D53866FD4D0C4A9897E6FF6C3007B607")

        private QuittingState mQuittingState = new QuittingState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.337 -0500", hash_original_field = "D7082DDA1611DC66C1AB79591410EB5D", hash_generated_field = "AB776014D6CDB1ACE48E8228A4B89DB5")

        private StateMachine mSm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.353 -0500", hash_original_field = "A1613334F7C62B31C8197378FA745F76", hash_generated_field = "8E6100B795A7F8D492BA2A30C1BEF10A")

        private HashMap<State, StateInfo> mStateInfo =
            new HashMap<State, StateInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.355 -0500", hash_original_field = "3A93C19B6C1ED105BFDB97DA9BD6AEE0", hash_generated_field = "E1B8064614A214E3580105C073B6BA74")

        private State mInitialState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.358 -0500", hash_original_field = "C988CB3475EB164C742DAB6A11F0D1FD", hash_generated_field = "21253050F2EAF229CC27D2C6C469DC71")

        private State mDestState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.360 -0500", hash_original_field = "F6FE886D886DBF499745990BA492458B", hash_generated_field = "25F851047AB015EAE2C78DF11239F59E")

        private ArrayList<Message> mDeferredMessages = new ArrayList<Message>();

        /**
         * Constructor
         *
         * @param looper for dispatching messages
         * @param sm the hierarchical state machine
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.418 -0500", hash_original_method = "02CDDC1E29D68D2242CCC3ED8987E93B", hash_generated_method = "0C2DA2CD9FBC63B58CE3CA69A8133769")
        
private SmHandler(Looper looper, StateMachine sm) {
            super(looper);
            mSm = sm;

            addState(mHaltingState, null);
            addState(mQuittingState, null);
        }

        /**
         * Handle messages sent to the state machine by calling
         * the current state's processMessage. It also handles
         * the enter/exit calls and placing any deferred messages
         * back onto the queue when transitioning to a new state.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.375 -0500", hash_original_method = "47FB80A3CFEFEB59EA9B936E333C1DEB", hash_generated_method = "E154ED61341C3A58390581429D12F941")
        
@Override
        public final void handleMessage(Message msg) {
            if (mDbg) Log.d(TAG, "handleMessage: E msg.what=" + msg.what);

            /** Save the current message */
            mMsg = msg;

            /**
             * Check that construction was completed
             */
            if (!mIsConstructionCompleted) {
                Log.e(TAG, "The start method not called, ignore msg: " + msg);
                return;
            }

            /**
             * Process the message abiding by the hierarchical semantics
             * and perform any requested transitions.
             */
            processMsg(msg);
            performTransitions();

            if (mDbg) Log.d(TAG, "handleMessage: X");
        }

        /**
         * Do any transitions
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.378 -0500", hash_original_method = "A1FA2FFB8197AA42C7B119825051565B", hash_generated_method = "66B6388BD6DFE024922BB16B89670CD6")
        
private void performTransitions() {
            /**
             * If transitionTo has been called, exit and then enter
             * the appropriate states. We loop on this to allow
             * enter and exit methods to use transitionTo.
             */
            State destState = null;
            while (mDestState != null) {
                if (mDbg) Log.d(TAG, "handleMessage: new destination call exit");

                /**
                 * Save mDestState locally and set to null
                 * to know if enter/exit use transitionTo.
                 */
                destState = mDestState;
                mDestState = null;

                /**
                 * Determine the states to exit and enter and return the
                 * common ancestor state of the enter/exit states. Then
                 * invoke the exit methods then the enter methods.
                 */
                StateInfo commonStateInfo = setupTempStateStackWithStatesToEnter(destState);
                invokeExitMethods(commonStateInfo);
                int stateStackEnteringIndex = moveTempStateStackToStateStack();
                invokeEnterMethods(stateStackEnteringIndex);

                /**
                 * Since we have transitioned to a new state we need to have
                 * any deferred messages moved to the front of the message queue
                 * so they will be processed before any other messages in the
                 * message queue.
                 */
                moveDeferredMessageAtFrontOfQueue();
            }

            /**
             * After processing all transitions check and
             * see if the last transition was to quit or halt.
             */
            if (destState != null) {
                if (destState == mQuittingState) {
                    cleanupAfterQuitting();

                } else if (destState == mHaltingState) {
                    /**
                     * Call halting() if we've transitioned to the halting
                     * state. All subsequent messages will be processed in
                     * in the halting state which invokes haltedProcessMessage(msg);
                     */
                    mSm.halting();
                }
            }
        }

        /**
         * Cleanup all the static variables and the looper after the SM has been quit.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.381 -0500", hash_original_method = "7DAEABCEDA46187D72BCFC1924088344", hash_generated_method = "5639217F873C6F4B6BBBF8FD81B5AB76")
        
private final void cleanupAfterQuitting() {
            mSm.quitting();
            if (mSm.mSmThread != null) {
                // If we made the thread then quit looper which stops the thread.
                getLooper().quit();
                mSm.mSmThread = null;
            }

            mSm.mSmHandler = null;
            mSm = null;
            mMsg = null;
            mProcessedMessages.cleanup();
            mStateStack = null;
            mTempStateStack = null;
            mStateInfo.clear();
            mInitialState = null;
            mDestState = null;
            mDeferredMessages.clear();
        }

        /**
         * Complete the construction of the state machine.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.384 -0500", hash_original_method = "2988A35ECCAC86323C503A15399549F2", hash_generated_method = "ECBB610784E4A3BFAFD4A3D2BCFF736C")
        
private final void completeConstruction() {
            if (mDbg) Log.d(TAG, "completeConstruction: E");

            /**
             * Determine the maximum depth of the state hierarchy
             * so we can allocate the state stacks.
             */
            int maxDepth = 0;
            for (StateInfo si : mStateInfo.values()) {
                int depth = 0;
                for (StateInfo i = si; i != null; depth++) {
                    i = i.parentStateInfo;
                }
                if (maxDepth < depth) {
                    maxDepth = depth;
                }
            }
            if (mDbg) Log.d(TAG, "completeConstruction: maxDepth=" + maxDepth);

            mStateStack = new StateInfo[maxDepth];
            mTempStateStack = new StateInfo[maxDepth];
            setupInitialStateStack();

            /**
             * Construction is complete call all enter methods
             * starting at the first entry.
             */
            mIsConstructionCompleted = true;
            mMsg = obtainMessage(SM_INIT_CMD);
            invokeEnterMethods(0);

            /**
             * Perform any transitions requested by the enter methods
             */
            performTransitions();

            if (mDbg) Log.d(TAG, "completeConstruction: X");
        }

        /**
         * Process the message. If the current state doesn't handle
         * it, call the states parent and so on. If it is never handled then
         * call the state machines unhandledMessage method.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.387 -0500", hash_original_method = "01E4D9F834B911866303A5B2D2AF3A41", hash_generated_method = "22B5BDC7E79E593A8D2FF29BBCDCF246")
        
private final void processMsg(Message msg) {
            StateInfo curStateInfo = mStateStack[mStateStackTopIndex];
            if (mDbg) {
                Log.d(TAG, "processMsg: " + curStateInfo.state.getName());
            }
            while (!curStateInfo.state.processMessage(msg)) {
                /**
                 * Not processed
                 */
                curStateInfo = curStateInfo.parentStateInfo;
                if (curStateInfo == null) {
                    /**
                     * No parents left so it's not handled
                     */
                    mSm.unhandledMessage(msg);
                    if (isQuit(msg)) {
                        transitionTo(mQuittingState);
                    }
                    break;
                }
                if (mDbg) {
                    Log.d(TAG, "processMsg: " + curStateInfo.state.getName());
                }
            }

            /**
             * Record that we processed the message
             */
            if (curStateInfo != null) {
                State orgState = mStateStack[mStateStackTopIndex].state;
                mProcessedMessages.add(msg, curStateInfo.state, orgState);
            } else {
                mProcessedMessages.add(msg, null, null);
            }
        }

        /**
         * Call the exit method for each state from the top of stack
         * up to the common ancestor state.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.391 -0500", hash_original_method = "DE2778671ED61CA7054BB4798B489854", hash_generated_method = "E75B3D155A17C627E145C3DA4CEF5375")
        
private final void invokeExitMethods(StateInfo commonStateInfo) {
            while ((mStateStackTopIndex >= 0) &&
                    (mStateStack[mStateStackTopIndex] != commonStateInfo)) {
                State curState = mStateStack[mStateStackTopIndex].state;
                if (mDbg) Log.d(TAG, "invokeExitMethods: " + curState.getName());
                curState.exit();
                mStateStack[mStateStackTopIndex].active = false;
                mStateStackTopIndex -= 1;
            }
        }

        /**
         * Invoke the enter method starting at the entering index to top of state stack
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.393 -0500", hash_original_method = "BBB0EEA794A5EB08AF57745D59E4ED21", hash_generated_method = "8A569DEE210BC5DBEB5FC34B66E0FD8E")
        
private final void invokeEnterMethods(int stateStackEnteringIndex) {
            for (int i = stateStackEnteringIndex; i <= mStateStackTopIndex; i++) {
                if (mDbg) Log.d(TAG, "invokeEnterMethods: " + mStateStack[i].state.getName());
                mStateStack[i].state.enter();
                mStateStack[i].active = true;
            }
        }

        /**
         * Move the deferred message to the front of the message queue.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.396 -0500", hash_original_method = "C63EF04ECCAE1AA00B9666D00D691AB5", hash_generated_method = "9F54E8BA14C1EF1883138F7932DF7DB6")
        
private final void moveDeferredMessageAtFrontOfQueue() {
            /**
             * The oldest messages on the deferred list must be at
             * the front of the queue so start at the back, which
             * as the most resent message and end with the oldest
             * messages at the front of the queue.
             */
            for (int i = mDeferredMessages.size() - 1; i >= 0; i-- ) {
                Message curMsg = mDeferredMessages.get(i);
                if (mDbg) Log.d(TAG, "moveDeferredMessageAtFrontOfQueue; what=" + curMsg.what);
                sendMessageAtFrontOfQueue(curMsg);
            }
            mDeferredMessages.clear();
        }

        /**
         * Move the contents of the temporary stack to the state stack
         * reversing the order of the items on the temporary stack as
         * they are moved.
         *
         * @return index into mStateStack where entering needs to start
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.400 -0500", hash_original_method = "22489CF328AA5B68E3D4CD4685E1B0FF", hash_generated_method = "A172382E464D8A38BCB04CD76602C7D8")
        
private final int moveTempStateStackToStateStack() {
            int startingIndex = mStateStackTopIndex + 1;
            int i = mTempStateStackCount - 1;
            int j = startingIndex;
            while (i >= 0) {
                if (mDbg) Log.d(TAG, "moveTempStackToStateStack: i=" + i + ",j=" + j);
                mStateStack[j] = mTempStateStack[i];
                j += 1;
                i -= 1;
            }

            mStateStackTopIndex = j - 1;
            if (mDbg) {
                Log.d(TAG, "moveTempStackToStateStack: X mStateStackTop="
                      + mStateStackTopIndex + ",startingIndex=" + startingIndex
                      + ",Top=" + mStateStack[mStateStackTopIndex].state.getName());
            }
            return startingIndex;
        }

        /**
         * Setup the mTempStateStack with the states we are going to enter.
         *
         * This is found by searching up the destState's ancestors for a
         * state that is already active i.e. StateInfo.active == true.
         * The destStae and all of its inactive parents will be on the
         * TempStateStack as the list of states to enter.
         *
         * @return StateInfo of the common ancestor for the destState and
         * current state or null if there is no common parent.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.403 -0500", hash_original_method = "47EF66F8DA6A53298BD1106F4D1229BB", hash_generated_method = "BC946785CDF41BB86EDA969FA6F7A96D")
        
private final StateInfo setupTempStateStackWithStatesToEnter(State destState) {
            /**
             * Search up the parent list of the destination state for an active
             * state. Use a do while() loop as the destState must always be entered
             * even if it is active. This can happen if we are exiting/entering
             * the current state.
             */
            mTempStateStackCount = 0;
            StateInfo curStateInfo = mStateInfo.get(destState);
            do {
                mTempStateStack[mTempStateStackCount++] = curStateInfo;
                curStateInfo = curStateInfo.parentStateInfo;
            } while ((curStateInfo != null) && !curStateInfo.active);

            if (mDbg) {
                Log.d(TAG, "setupTempStateStackWithStatesToEnter: X mTempStateStackCount="
                      + mTempStateStackCount + ",curStateInfo: " + curStateInfo);
            }
            return curStateInfo;
        }

        /**
         * Initialize StateStack to mInitialState.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.406 -0500", hash_original_method = "1F517A6C2C8B64C63155F67495EF1EF9", hash_generated_method = "9EF35F9D468111E928F8FAA147529925")
        
private final void setupInitialStateStack() {
            if (mDbg) {
                Log.d(TAG, "setupInitialStateStack: E mInitialState="
                    + mInitialState.getName());
            }

            StateInfo curStateInfo = mStateInfo.get(mInitialState);
            for (mTempStateStackCount = 0; curStateInfo != null; mTempStateStackCount++) {
                mTempStateStack[mTempStateStackCount] = curStateInfo;
                curStateInfo = curStateInfo.parentStateInfo;
            }

            // Empty the StateStack
            mStateStackTopIndex = -1;

            moveTempStateStackToStateStack();
        }

        /**
         * @return current message
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.409 -0500", hash_original_method = "38EC5F2FF9273B7F113CC175A6D6CA55", hash_generated_method = "384257282751D922C30410AA46C794EB")
        
private final Message getCurrentMessage() {
            return mMsg;
        }

        /**
         * @return current state
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.411 -0500", hash_original_method = "4DAC448F0AE857FB37AA7C8477011F21", hash_generated_method = "5928D77CF18B653EF707623017562220")
        
private final IState getCurrentState() {
            return mStateStack[mStateStackTopIndex].state;
        }

        /**
         * Add a new state to the state machine. Bottom up addition
         * of states is allowed but the same state may only exist
         * in one hierarchy.
         *
         * @param state the state to add
         * @param parent the parent of state
         * @return stateInfo for this state
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.415 -0500", hash_original_method = "D4FAF1FE6F5065E5FE32CF44151438D5", hash_generated_method = "CB92EE77197D5318142CF3AE6E253A65")
        
private final StateInfo addState(State state, State parent) {
            if (mDbg) {
                Log.d(TAG, "addStateInternal: E state=" + state.getName()
                        + ",parent=" + ((parent == null) ? "" : parent.getName()));
            }
            StateInfo parentStateInfo = null;
            if (parent != null) {
                parentStateInfo = mStateInfo.get(parent);
                if (parentStateInfo == null) {
                    // Recursively add our parent as it's not been added yet.
                    parentStateInfo = addState(parent, null);
                }
            }
            StateInfo stateInfo = mStateInfo.get(state);
            if (stateInfo == null) {
                stateInfo = new StateInfo();
                mStateInfo.put(state, stateInfo);
            }

            // Validate that we aren't adding the same state in two different hierarchies.
            if ((stateInfo.parentStateInfo != null) &&
                    (stateInfo.parentStateInfo != parentStateInfo)) {
                    throw new RuntimeException("state already added");
            }
            stateInfo.state = state;
            stateInfo.parentStateInfo = parentStateInfo;
            stateInfo.active = false;
            if (mDbg) Log.d(TAG, "addStateInternal: X stateInfo: " + stateInfo);
            return stateInfo;
        }

        /** @see StateMachine#setInitialState(State) */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.421 -0500", hash_original_method = "6BCC70723A0A0266DFEF3F6F9EAE3DFA", hash_generated_method = "3B18F593C219C60CA3A0DC79B5D35734")
        
private final void setInitialState(State initialState) {
            if (mDbg) Log.d(TAG, "setInitialState: initialState" + initialState.getName());
            mInitialState = initialState;
        }

        /** @see StateMachine#transitionTo(IState) */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.424 -0500", hash_original_method = "21890E800BC5188E239893B522387EDA", hash_generated_method = "314E77170BF130061D377B333927F21B")
        
private final void transitionTo(IState destState) {
            mDestState = (State) destState;
            if (mDbg) Log.d(TAG, "StateMachine.transitionTo EX destState" + mDestState.getName());
        }

        /** @see StateMachine#deferMessage(Message) */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.426 -0500", hash_original_method = "E228351895B227260722E6D77267BEC1", hash_generated_method = "994B906B8A1E0957DF2C0ABC5F5962E2")
        
private final void deferMessage(Message msg) {
            if (mDbg) Log.d(TAG, "deferMessage: msg=" + msg.what);

            /* Copy the "msg" to "newMsg" as "msg" will be recycled */
            Message newMsg = obtainMessage();
            newMsg.copyFrom(msg);

            mDeferredMessages.add(newMsg);
        }

        /** @see StateMachine#deferMessage(Message) */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.429 -0500", hash_original_method = "70D38ABCE91561514ACD98C85375A9A1", hash_generated_method = "103A709794E1DE8E8719A94A81103C7C")
        
private final void quit() {
            if (mDbg) Log.d(TAG, "quit:");
            sendMessage(obtainMessage(SM_QUIT_CMD, mQuitObj));
        }

        /** @see StateMachine#isQuit(Message) */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.431 -0500", hash_original_method = "BAB49FBE24A81490A5F317754A03EEE6", hash_generated_method = "B536651E8B24FF5F06BAF122F73EEDB6")
        
private final boolean isQuit(Message msg) {
            return (msg.what == SM_QUIT_CMD) && (msg.obj == mQuitObj);
        }

        /** @see StateMachine#isDbg() */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.434 -0500", hash_original_method = "0EC17970A8F6815D37F02ED3B599FE78", hash_generated_method = "56881472EE7D3216A6DF0B15B01B73CC")
        
private final boolean isDbg() {
            return mDbg;
        }

        /** @see StateMachine#setDbg(boolean) */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.437 -0500", hash_original_method = "2FBE0CE6F45608217065DCE46294BFD1", hash_generated_method = "2074AE1EBD18EEDD5D44813780E2F771")
        
private final void setDbg(boolean dbg) {
            mDbg = dbg;
        }

        /** @see StateMachine#setProcessedMessagesSize(int) */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.440 -0500", hash_original_method = "80DE9CB8772B169AC72245D032E86B1D", hash_generated_method = "4EF3CDA6DD7D9EB19C0A720105467167")
        
private final void setProcessedMessagesSize(int maxSize) {
            mProcessedMessages.setSize(maxSize);
        }

        /** @see StateMachine#getProcessedMessagesSize() */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.444 -0500", hash_original_method = "8FB0F44FDB0C5DC10452484BB601B3E7", hash_generated_method = "256350CA9CB0CFC5DA2D9DCE2109E35A")
        
private final int getProcessedMessagesSize() {
            return mProcessedMessages.size();
        }

        /** @see StateMachine#getProcessedMessagesCount() */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.447 -0500", hash_original_method = "92EED68DA49DE907A6704035F6436DD3", hash_generated_method = "048EFDA755A0B541196FC852EB3B5214")
        
private final int getProcessedMessagesCount() {
            return mProcessedMessages.count();
        }
        
        private class StateInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.340 -0500", hash_original_field = "05D925C5BEC5275A59607FB5FAF72E84", hash_generated_field = "05D925C5BEC5275A59607FB5FAF72E84")

            State state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.342 -0500", hash_original_field = "306C0C906AA6DAA2CF8E599E0B8563F9", hash_generated_field = "306C0C906AA6DAA2CF8E599E0B8563F9")

            StateInfo parentStateInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.345 -0500", hash_original_field = "51A28EFFDC4123E8CF1B6051031E7683", hash_generated_field = "51A28EFFDC4123E8CF1B6051031E7683")

            boolean active;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.937 -0400", hash_original_method = "87ADFE3F226D3DC74DE0940453A6AE41", hash_generated_method = "87ADFE3F226D3DC74DE0940453A6AE41")
            public StateInfo ()
            {
                //Synthesized constructor
            }

            /**
             * Convert StateInfo to string
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.348 -0500", hash_original_method = "ABB8BC4D82891CF5369714A62A1A931C", hash_generated_method = "B18D28F302F23880063E3FA5E3607879")
            
@Override
            public String toString() {
                return "state=" + state.getName() + ",active=" + active
                        + ",parent=" + ((parentStateInfo == null) ?
                                        "null" : parentStateInfo.state.getName());
            }
            
        }
        
        private class HaltingState extends State {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.938 -0400", hash_original_method = "F9537758E4D6CCA48E760EA40D22DF18", hash_generated_method = "F9537758E4D6CCA48E760EA40D22DF18")
            public HaltingState ()
            {
                //Synthesized constructor
            }
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.365 -0500", hash_original_method = "58076C952A23C34E44D31450392EEB12", hash_generated_method = "5BFEC8F08DDD3EEEAF66BF91518E8C31")
            
@Override
            public boolean processMessage(Message msg) {
                mSm.haltedProcessMessage(msg);
                return true;
            }
            
        }
        
        private class QuittingState extends State {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.939 -0400", hash_original_method = "769C07BAAE1E710E9D1020720F6EA4CE", hash_generated_method = "769C07BAAE1E710E9D1020720F6EA4CE")
            public QuittingState ()
            {
                //Synthesized constructor
            }
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.370 -0500", hash_original_method = "5D2BC087464A61E35A06899EEE03AD06", hash_generated_method = "03FB4DC820C20817E37684C2A0755084")
            
@Override
            public boolean processMessage(Message msg) {
                return NOT_HANDLED;
            }
            
        }

        /** @see StateMachine#getProcessedMessageInfo(int) */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.450 -0500", hash_original_method = "1E4BC1F21BF61852DF075DACE8E37071", hash_generated_method = "BF06C6C72B4DC54347B750F47C1CD890")
        
private final ProcessedMessageInfo getProcessedMessageInfo(int index) {
            return mProcessedMessages.get(index);
        }
    }

    /**
     * Conditionally quit the looper and stop execution.
     *
     * This sends the SM_QUIT_MSG to the state machine and
     * if not handled by any state's processMessage then the
     * state machine will be stopped and no further messages
     * will be processed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.558 -0500", hash_original_method = "13321C8CCD65EA0BFC64015C162CADFF", hash_generated_method = "9C04F966A04CEC37802D3875FA6EFA0C")
    
public final void quit() {
        // mSmHandler can be null if the state machine has quit.
        if (mSmHandler == null) return;

        mSmHandler.quit();
    }

    /**
     * @return ture if msg is quit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.561 -0500", hash_original_method = "E5B9CF023676BDCA212E1B122FA8A525", hash_generated_method = "3251C81D88399B2E9B7EDE269ED73C98")
    
protected final boolean isQuit(Message msg) {
        return mSmHandler.isQuit(msg);
    }

    /**
     * @return if debugging is enabled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.563 -0500", hash_original_method = "60458C30D1CF7065D8253B7B3CE713BC", hash_generated_method = "5DD6AE2A42ACD315E0871FAA02802D05")
    
public boolean isDbg() {
        // mSmHandler can be null if the state machine has quit.
        if (mSmHandler == null) return false;

        return mSmHandler.isDbg();
    }

    /**
     * Set debug enable/disabled.
     *
     * @param dbg is true to enable debugging.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.565 -0500", hash_original_method = "DD47B988861B3BEC7B551FD48507E8F0", hash_generated_method = "E7D502168A1AF4F46C67480D562CF126")
    
public void setDbg(boolean dbg) {
        // mSmHandler can be null if the state machine has quit.
        if (mSmHandler == null) return;

        mSmHandler.setDbg(dbg);
    }

    /**
     * Start the state machine.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:47.567 -0500", hash_original_method = "25624AE7DCD0D0ACD27C83DB1C9CEB1E", hash_generated_method = "3E29CF8CFCA432C1931CBCB4734BC8CE")
    
public void start() {
        // mSmHandler can be null if the state machine has quit.
        if (mSmHandler == null) return;

        /** Send the complete construction message */
        mSmHandler.completeConstruction();
    }
}

