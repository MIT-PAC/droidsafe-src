package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class StateMachine {
    private static final String TAG = "StateMachine";
    private String mName;
    public static final int SM_QUIT_CMD = -1;
    public static final int SM_INIT_CMD = -2;
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;
    private SmHandler mSmHandler;
    private HandlerThread mSmThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.674 -0400", hash_original_method = "965279A1412D73A89A7122845884F290", hash_generated_method = "601BA511E09B7C20317D918AEEFC98D1")
    @DSModeled(DSC.SAFE)
    protected StateMachine(String name) {
        dsTaint.addTaint(name);
        mSmThread = new HandlerThread(name);
        mSmThread.start();
        Looper looper;
        looper = mSmThread.getLooper();
        initStateMachine(name, looper);
        // ---------- Original Method ----------
        //mSmThread = new HandlerThread(name);
        //mSmThread.start();
        //Looper looper = mSmThread.getLooper();
        //initStateMachine(name, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.674 -0400", hash_original_method = "8270C3E9AEADC5B23E7F677870CDA596", hash_generated_method = "A31224D61AD8C2D0D8CABC72208521EB")
    @DSModeled(DSC.SAFE)
    protected StateMachine(String name, Looper looper) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(name);
        initStateMachine(name, looper);
        // ---------- Original Method ----------
        //initStateMachine(name, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.674 -0400", hash_original_method = "DAD3CAAA263F09CC114EE283728F2037", hash_generated_method = "32B8DBD73715EABEB122745E47D3599D")
    @DSModeled(DSC.SAFE)
    private void initStateMachine(String name, Looper looper) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(name);
        mSmHandler = new SmHandler(looper, this);
        // ---------- Original Method ----------
        //mName = name;
        //mSmHandler = new SmHandler(looper, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.674 -0400", hash_original_method = "9CB95CDEC2272D9103D9B302315B1CF0", hash_generated_method = "B6C25D46755D5ABCA00E539E1FB0BA59")
    @DSModeled(DSC.SAFE)
    protected final void addState(State state, State parent) {
        dsTaint.addTaint(state.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        mSmHandler.addState(state, parent);
        // ---------- Original Method ----------
        //mSmHandler.addState(state, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.674 -0400", hash_original_method = "E9B863EE3D8BE2542840411248513D5A", hash_generated_method = "1563A2C60C39A2CB66D236C9F8F517D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final Message getCurrentMessage() {
        Message var303D598FC0AD1EFF008CC2EEA6DE4950_138013042 = (mSmHandler.getCurrentMessage());
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSmHandler.getCurrentMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.674 -0400", hash_original_method = "D598BDB56AFF58F966F9A8594C83023E", hash_generated_method = "E6C0ABB47E9403DF4E5DA86948ED03DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final IState getCurrentState() {
        IState var3C37E01879824B8B7429BD9A8324AE5B_1590182114 = (mSmHandler.getCurrentState());
        return (IState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSmHandler.getCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "3FDCC93D71F6B56C0FCF47E8C68EDFCE", hash_generated_method = "631628E83B1E3757E8D500BD2DAF5B48")
    @DSModeled(DSC.SAFE)
    protected final void addState(State state) {
        dsTaint.addTaint(state.dsTaint);
        mSmHandler.addState(state, null);
        // ---------- Original Method ----------
        //mSmHandler.addState(state, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "FA85C85D6842E1150C141EC2987FEC52", hash_generated_method = "09DD1739FD375BEB26ECE67A875569E9")
    @DSModeled(DSC.SAFE)
    protected final void setInitialState(State initialState) {
        dsTaint.addTaint(initialState.dsTaint);
        mSmHandler.setInitialState(initialState);
        // ---------- Original Method ----------
        //mSmHandler.setInitialState(initialState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "DDAEED1DEC80DD4893B8BEC6C1C4D0F1", hash_generated_method = "69A2EA1F89FC0D5B39C15135B640E31B")
    @DSModeled(DSC.SAFE)
    protected final void transitionTo(IState destState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(destState.dsTaint);
        mSmHandler.transitionTo(destState);
        // ---------- Original Method ----------
        //mSmHandler.transitionTo(destState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "42225DFCDD57D6590F4D09D0862811E2", hash_generated_method = "54C55B3C9E00B312E3C0F20C3196DBD3")
    @DSModeled(DSC.SAFE)
    protected final void transitionToHaltingState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mSmHandler.transitionTo(mSmHandler.mHaltingState);
        // ---------- Original Method ----------
        //mSmHandler.transitionTo(mSmHandler.mHaltingState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "261AEA0DB1968E370C4ADDBA675B5E74", hash_generated_method = "FE6D26B3117150D4D2F8F1F0BE5D7007")
    @DSModeled(DSC.SAFE)
    protected final void deferMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        mSmHandler.deferMessage(msg);
        // ---------- Original Method ----------
        //mSmHandler.deferMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "7997D0B28C80AB12F09EF0050700F72A", hash_generated_method = "B3902D45CC4AA721A0A7E226B2817454")
    @DSModeled(DSC.SAFE)
    protected void unhandledMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        // ---------- Original Method ----------
        //if (mSmHandler.mDbg) Log.e(TAG, mName + " - unhandledMessage: msg.what=" + msg.what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "056AA616A824F08818D1B78343E1C249", hash_generated_method = "801BE5A46EDC275247AD57A25D2F6664")
    @DSModeled(DSC.SAFE)
    protected void haltedProcessMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "4C387498336ED4C08F04A3A81289F626", hash_generated_method = "1ECC731B00BC0E1EE45397FE88753645")
    @DSModeled(DSC.SAFE)
    protected void halting() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "B35375ECAB57B816953617EBE5B4DD2F", hash_generated_method = "2BCD37BC1DF50107AD087B580526AD8E")
    @DSModeled(DSC.SAFE)
    protected void quitting() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "DD37865B129D5B845F42DE68A67BAC0E")
    @DSModeled(DSC.SAFE)
    public final String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "3B515C020FBA4525296124D17148DAD9", hash_generated_method = "A3FFF129F68386CB384BED6E5BDE10A9")
    @DSModeled(DSC.SAFE)
    public final void setProcessedMessagesSize(int maxSize) {
        dsTaint.addTaint(maxSize);
        mSmHandler.setProcessedMessagesSize(maxSize);
        // ---------- Original Method ----------
        //mSmHandler.setProcessedMessagesSize(maxSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "9A0BF952A27C97CD544B7334CD0A8AD7", hash_generated_method = "4BC51DC1F6253AB6C8FA17A514DF3F50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getProcessedMessagesSize() {
        int varADB516616D44D9188EDE23425BBA855F_356082230 = (mSmHandler.getProcessedMessagesSize());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSmHandler.getProcessedMessagesSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "7E321218401071A5914E48165DB351C0", hash_generated_method = "E2089A6576D6D62F7BB5934A08C04019")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getProcessedMessagesCount() {
        int var8079425B963FA8795091F5002B0F237A_2112662694 = (mSmHandler.getProcessedMessagesCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSmHandler.getProcessedMessagesCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "C801EF2BEB9E095EF75CD2E078DF8F4D", hash_generated_method = "BC5B0106A3E5E74B7B1434792B7F4080")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ProcessedMessageInfo getProcessedMessageInfo(int index) {
        dsTaint.addTaint(index);
        ProcessedMessageInfo varE136C82955A553030FF8F35BB3084A65_1051067532 = (mSmHandler.getProcessedMessageInfo(index));
        return (ProcessedMessageInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSmHandler.getProcessedMessageInfo(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "467C85CDF2FD06F7E6D6E1A3F89DC6AE", hash_generated_method = "759D3C6B546A95B586890693602CF41C")
    @DSModeled(DSC.SAFE)
    public final Handler getHandler() {
        return (Handler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSmHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "ECC92B44317075FA349076F0B0608CC3", hash_generated_method = "20A41D3AC5FCC439F19C1073C76018A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage() {
        Message var8F4F4F083E33531649192052919B0956_1802742464 = (Message.obtain(mSmHandler));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mSmHandler == null) return null;
        //return Message.obtain(mSmHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "F3ABD31C8A8A675CAB7BDC7D39B74873", hash_generated_method = "DE679F090325496BCFFE889ECF5D3EC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what) {
        dsTaint.addTaint(what);
        Message varA78882C8B267892A4AAA02F826D7EF43_790752559 = (Message.obtain(mSmHandler, what));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mSmHandler == null) return null;
        //return Message.obtain(mSmHandler, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "2782AA628D17C295F1631BCDEC3DEA27", hash_generated_method = "E29351B7FCE606BC10BC1F5C41113905")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        Message var3601241A4754811E6EB41E765131E346_1810316287 = (Message.obtain(mSmHandler, what, obj));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mSmHandler == null) return null;
        //return Message.obtain(mSmHandler, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "90FE3D951CADE6238FC04DAF938292E8", hash_generated_method = "DDD6BC629ECB4AFAA619B7D7DF5F6B23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message varD79DD81231B3244A278A0CD5929B34DD_258393754 = (Message.obtain(mSmHandler, what, arg1, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mSmHandler == null) return null;
        //return Message.obtain(mSmHandler, what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.675 -0400", hash_original_method = "9FA101C66AEE3272C97FB43923C2AC9F", hash_generated_method = "A5AB8E506055297F9F1E4CEE02EFA05F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        Message var6E852079F2B91CB11C6BCC9A1C58DF7F_1460418038 = (Message.obtain(mSmHandler, what, arg1, arg2, obj));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mSmHandler == null) return null;
        //return Message.obtain(mSmHandler, what, arg1, arg2, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.676 -0400", hash_original_method = "4C17D9C303E0C63CA9FC8056DA52EF3D", hash_generated_method = "93C2B797EC8783D9C70D4A342448D440")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void sendMessage(int what) {
        dsTaint.addTaint(what);
        mSmHandler.sendMessage(obtainMessage(what));
        // ---------- Original Method ----------
        //if (mSmHandler == null) return;
        //mSmHandler.sendMessage(obtainMessage(what));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.676 -0400", hash_original_method = "FBA6CF7C9F3F790F28B53AD9439353BD", hash_generated_method = "E56BFB218D133636DBD529A6FF37A18A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void sendMessage(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        mSmHandler.sendMessage(obtainMessage(what,obj));
        // ---------- Original Method ----------
        //if (mSmHandler == null) return;
        //mSmHandler.sendMessage(obtainMessage(what,obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.679 -0400", hash_original_method = "6E13019DC70D12278C5C1075A86F8BFE", hash_generated_method = "0B41DD256C4EBC963439E46A572FC232")
    @DSModeled(DSC.SAFE)
    public final void sendMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        mSmHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //if (mSmHandler == null) return;
        //mSmHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.679 -0400", hash_original_method = "6F45F99BF67AD2AF5583C8727970AA91", hash_generated_method = "54B5CE11D037301EBDC1A7BD4A288A45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void sendMessageDelayed(int what, long delayMillis) {
        dsTaint.addTaint(delayMillis);
        dsTaint.addTaint(what);
        mSmHandler.sendMessageDelayed(obtainMessage(what), delayMillis);
        // ---------- Original Method ----------
        //if (mSmHandler == null) return;
        //mSmHandler.sendMessageDelayed(obtainMessage(what), delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.679 -0400", hash_original_method = "39A6E49D71A514B448DAD14BF952A265", hash_generated_method = "AA0018D9C1B238E86C461F14328DDB97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void sendMessageDelayed(int what, Object obj, long delayMillis) {
        dsTaint.addTaint(delayMillis);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        mSmHandler.sendMessageDelayed(obtainMessage(what, obj), delayMillis);
        // ---------- Original Method ----------
        //if (mSmHandler == null) return;
        //mSmHandler.sendMessageDelayed(obtainMessage(what, obj), delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.679 -0400", hash_original_method = "9D9110C540430F2A7712B1C42CF073E5", hash_generated_method = "E783B02D3DE5A93FCCB4A0D2057378F4")
    @DSModeled(DSC.SAFE)
    public final void sendMessageDelayed(Message msg, long delayMillis) {
        dsTaint.addTaint(delayMillis);
        dsTaint.addTaint(msg.dsTaint);
        mSmHandler.sendMessageDelayed(msg, delayMillis);
        // ---------- Original Method ----------
        //if (mSmHandler == null) return;
        //mSmHandler.sendMessageDelayed(msg, delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "687B3882728A203A122F07AED4E62B4F", hash_generated_method = "C98314797813D26898F2DFF5034142A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void sendMessageAtFrontOfQueue(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(what, obj));
        // ---------- Original Method ----------
        //mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(what, obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "57A82123C5C1A73035060A1546C23399", hash_generated_method = "F6E72855185791F6B65423F37301DB1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void sendMessageAtFrontOfQueue(int what) {
        dsTaint.addTaint(what);
        mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(what));
        // ---------- Original Method ----------
        //mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(what));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "DAD8B3BB967F6D568CBDEF14E7D7FC31", hash_generated_method = "6DE50C01F51B0504B480DA7B89A37A6D")
    @DSModeled(DSC.SAFE)
    protected final void sendMessageAtFrontOfQueue(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        mSmHandler.sendMessageAtFrontOfQueue(msg);
        // ---------- Original Method ----------
        //mSmHandler.sendMessageAtFrontOfQueue(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "58582EEB8BE4D233D0E7915A49A3AF70", hash_generated_method = "8AA83C62D149C485B815B2DD37AB6BFF")
    @DSModeled(DSC.SAFE)
    protected final void removeMessages(int what) {
        dsTaint.addTaint(what);
        mSmHandler.removeMessages(what);
        // ---------- Original Method ----------
        //mSmHandler.removeMessages(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "13321C8CCD65EA0BFC64015C162CADFF", hash_generated_method = "6CBE57C08B0A41E81CADFEA337F7CC6E")
    @DSModeled(DSC.SAFE)
    public final void quit() {
        mSmHandler.quit();
        // ---------- Original Method ----------
        //if (mSmHandler == null) return;
        //mSmHandler.quit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "E5B9CF023676BDCA212E1B122FA8A525", hash_generated_method = "D6D9F17BD6C5D032E439A718A792A051")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final boolean isQuit(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        boolean var2A8D6458325668C3536388AFF71BF89B_1186377215 = (mSmHandler.isQuit(msg));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSmHandler.isQuit(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "60458C30D1CF7065D8253B7B3CE713BC", hash_generated_method = "31074A15BD5C71986A32F16ADFA6453D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDbg() {
        boolean var1D9817B269DC7C83256BA20D04F9F774_1360754629 = (mSmHandler.isDbg());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mSmHandler == null) return false;
        //return mSmHandler.isDbg();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "DD47B988861B3BEC7B551FD48507E8F0", hash_generated_method = "BFEA97020C9AF3D979B8BD455A6425F7")
    @DSModeled(DSC.SAFE)
    public void setDbg(boolean dbg) {
        dsTaint.addTaint(dbg);
        mSmHandler.setDbg(dbg);
        // ---------- Original Method ----------
        //if (mSmHandler == null) return;
        //mSmHandler.setDbg(dbg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "25624AE7DCD0D0ACD27C83DB1C9CEB1E", hash_generated_method = "052795DAB516A7B5617E537E253D02EC")
    @DSModeled(DSC.SAFE)
    public void start() {
        mSmHandler.completeConstruction();
        // ---------- Original Method ----------
        //if (mSmHandler == null) return;
        //mSmHandler.completeConstruction();
    }

    
    public static class ProcessedMessageInfo {
        private int what;
        private State state;
        private State orgState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "7EA9EE86A36AF0562D3C01EEF98869EA", hash_generated_method = "6385572BEF52D25D6370AB2511C68E68")
        @DSModeled(DSC.SAFE)
         ProcessedMessageInfo(Message message, State state, State orgState) {
            dsTaint.addTaint(message.dsTaint);
            dsTaint.addTaint(orgState.dsTaint);
            dsTaint.addTaint(state.dsTaint);
            update(message, state, orgState);
            // ---------- Original Method ----------
            //update(message, state, orgState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "AE92957E52CD2ECF48167D0FF23A4162", hash_generated_method = "93B49FBD8DFF8F731037DF6B6201EA44")
        @DSModeled(DSC.SAFE)
        public void update(Message message, State state, State orgState) {
            dsTaint.addTaint(message.dsTaint);
            dsTaint.addTaint(orgState.dsTaint);
            dsTaint.addTaint(state.dsTaint);
            this.what = message.what;
            // ---------- Original Method ----------
            //this.what = message.what;
            //this.state = state;
            //this.orgState = orgState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "4AA8DBE0617D26A2E34EC5BDBA364E43", hash_generated_method = "F4F9E62CB8732533CB7D35249B709379")
        @DSModeled(DSC.SAFE)
        public int getWhat() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return what;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "8133026F827EEDDA12F622808DEDA458")
        @DSModeled(DSC.SAFE)
        public State getState() {
            return (State)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return state;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "6453845FB279EEE2A3A97B4923853CA9", hash_generated_method = "19BD17CD1D789532CBCF127B4703D026")
        @DSModeled(DSC.SAFE)
        public State getOriginalState() {
            return (State)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return orgState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "1BEC9C7E840A94CA1F6D8F0CAE4CCE3D", hash_generated_method = "528C62E2A9BB8B5E2EA7EDCF966F4BA7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append("what=");
            sb.append(what);
            sb.append(" state=");
            sb.append(cn(state));
            sb.append(" orgState=");
            sb.append(cn(orgState));
            String var01ED4A9DFA1C94365291AB096B854A7B_91856125 = (sb.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder sb = new StringBuilder();
            //sb.append("what=");
            //sb.append(what);
            //sb.append(" state=");
            //sb.append(cn(state));
            //sb.append(" orgState=");
            //sb.append(cn(orgState));
            //return sb.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.680 -0400", hash_original_method = "BFE06EA51077266A4C3CDDB9CF5A61E9", hash_generated_method = "F9453558FE97EE5E3275CCD23973CA27")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String cn(Object n) {
            dsTaint.addTaint(n.dsTaint);
            {
                String name;
                name = n.getClass().getName();
                int lastDollar;
                lastDollar = name.lastIndexOf('$');
                String varF92577399CF7E2C34189415EA1CF65F6_575411525 = (name.substring(lastDollar + 1));
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //if (n == null) {
                //return "null";
            //} else {
                //String name = n.getClass().getName();
                //int lastDollar = name.lastIndexOf('$');
                //return name.substring(lastDollar + 1);
            //}
        }

        
    }


    
    private static class ProcessedMessages {
        private static final int DEFAULT_SIZE = 20;
        private Vector<ProcessedMessageInfo> mMessages = new Vector<ProcessedMessageInfo>();
        private int mMaxSize = DEFAULT_SIZE;
        private int mOldestIndex = 0;
        private int mCount = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "8C2E4982B56D335A57BD25CE5A99A95E", hash_generated_method = "2FDEA4AC2A63CD54B9B1A99EA408AC65")
        @DSModeled(DSC.SAFE)
         ProcessedMessages() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "E690879E37418633C091A0E6D09F0FE8", hash_generated_method = "3D9ABA9AF761F61DE7F987322288B7D9")
        @DSModeled(DSC.SAFE)
         void setSize(int maxSize) {
            dsTaint.addTaint(maxSize);
            mCount = 0;
            mMessages.clear();
            // ---------- Original Method ----------
            //mMaxSize = maxSize;
            //mCount = 0;
            //mMessages.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "661C67FDA7F2FAF16A0B73519F701A14", hash_generated_method = "13FA5368180DB2C3B37E8FA46528CE06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         int size() {
            int var74A32522226B505A2B9E801F7AC22358_642564624 = (mMessages.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mMessages.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "173278F07A9E3F76B246C31AF2BEE799", hash_generated_method = "04CAA5A7BAD56F6F1FCCB2BE7A3D96F4")
        @DSModeled(DSC.SAFE)
         int count() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "7C55F1E05538CA172591209F0EED6056", hash_generated_method = "25808239CDA8B3BC2D4A6DE6F80DFFE0")
        @DSModeled(DSC.SAFE)
         void cleanup() {
            mMessages.clear();
            // ---------- Original Method ----------
            //mMessages.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "9D508AC508F62C2D8A912ED09416EAAB", hash_generated_method = "153C0E3E1AA7BDA9D4AEA23444ED7F4B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ProcessedMessageInfo get(int index) {
            dsTaint.addTaint(index);
            int nextIndex;
            nextIndex = mOldestIndex + index;
            {
                nextIndex -= mMaxSize;
            } //End block
            {
                boolean var7A7E76C00B0E5411DCE1739E06AE8795_1816468821 = (nextIndex >= size());
                {
                    ProcessedMessageInfo var4145C421544BCD7152957D784EFD7EC0_1279593324 = (mMessages.get(nextIndex));
                } //End block
            } //End collapsed parenthetic
            return (ProcessedMessageInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int nextIndex = mOldestIndex + index;
            //if (nextIndex >= mMaxSize) {
                //nextIndex -= mMaxSize;
            //}
            //if (nextIndex >= size()) {
                //return null;
            //} else {
                //return mMessages.get(nextIndex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "43A85B457185E158137E22B107CD3124", hash_generated_method = "B1AD97213F332C726D17CCC302E1F444")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void add(Message message, State state, State orgState) {
            dsTaint.addTaint(message.dsTaint);
            dsTaint.addTaint(orgState.dsTaint);
            dsTaint.addTaint(state.dsTaint);
            mCount += 1;
            {
                boolean varB4226A5C9FBC4A9560CE67F9F9C6A507_1724477560 = (mMessages.size() < mMaxSize);
                {
                    mMessages.add(new ProcessedMessageInfo(message, state, orgState));
                } //End block
                {
                    ProcessedMessageInfo pmi;
                    pmi = mMessages.get(mOldestIndex);
                    mOldestIndex += 1;
                    {
                        mOldestIndex = 0;
                    } //End block
                    pmi.update(message, state, orgState);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mCount += 1;
            //if (mMessages.size() < mMaxSize) {
                //mMessages.add(new ProcessedMessageInfo(message, state, orgState));
            //} else {
                //ProcessedMessageInfo pmi = mMessages.get(mOldestIndex);
                //mOldestIndex += 1;
                //if (mOldestIndex >= mMaxSize) {
                    //mOldestIndex = 0;
                //}
                //pmi.update(message, state, orgState);
            //}
        }

        
    }


    
    private static class SmHandler extends Handler {
        private boolean mDbg = false;
        private static final Object mQuitObj = new Object();
        private Message mMsg;
        private ProcessedMessages mProcessedMessages = new ProcessedMessages();
        private boolean mIsConstructionCompleted;
        private StateInfo mStateStack[];
        private int mStateStackTopIndex = -1;
        private StateInfo mTempStateStack[];
        private int mTempStateStackCount;
        private HaltingState mHaltingState = new HaltingState();
        private QuittingState mQuittingState = new QuittingState();
        private StateMachine mSm;
        private HashMap<State, StateInfo> mStateInfo =
            new HashMap<State, StateInfo>();
        private State mInitialState;
        private State mDestState;
        private ArrayList<Message> mDeferredMessages = new ArrayList<Message>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "02CDDC1E29D68D2242CCC3ED8987E93B", hash_generated_method = "8DBDF720351D258A37D0567B348AE3F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SmHandler(Looper looper, StateMachine sm) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            dsTaint.addTaint(sm.dsTaint);
            addState(mHaltingState, null);
            addState(mQuittingState, null);
            // ---------- Original Method ----------
            //mSm = sm;
            //addState(mHaltingState, null);
            //addState(mQuittingState, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "47FB80A3CFEFEB59EA9B936E333C1DEB", hash_generated_method = "96E266BB0363C6BCE5ADA52CBD78DCC8")
        @DSModeled(DSC.SAFE)
        @Override
        public final void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            Log.d(TAG, "handleMessage: E msg.what=" + msg.what);
            processMsg(msg);
            performTransitions();
            Log.d(TAG, "handleMessage: X");
            // ---------- Original Method ----------
            //if (mDbg) Log.d(TAG, "handleMessage: E msg.what=" + msg.what);
            //mMsg = msg;
            //if (!mIsConstructionCompleted) {
                //Log.e(TAG, "The start method not called, ignore msg: " + msg);
                //return;
            //}
            //processMsg(msg);
            //performTransitions();
            //if (mDbg) Log.d(TAG, "handleMessage: X");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "A1FA2FFB8197AA42C7B119825051565B", hash_generated_method = "777CF5DDDC486DC92758CC1E3E09CD10")
        @DSModeled(DSC.SAFE)
        private void performTransitions() {
            State destState;
            destState = null;
            {
                Log.d(TAG, "handleMessage: new destination call exit");
                destState = mDestState;
                mDestState = null;
                StateInfo commonStateInfo;
                commonStateInfo = setupTempStateStackWithStatesToEnter(destState);
                invokeExitMethods(commonStateInfo);
                int stateStackEnteringIndex;
                stateStackEnteringIndex = moveTempStateStackToStateStack();
                invokeEnterMethods(stateStackEnteringIndex);
                moveDeferredMessageAtFrontOfQueue();
            } //End block
            {
                {
                    cleanupAfterQuitting();
                } //End block
                {
                    mSm.halting();
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.681 -0400", hash_original_method = "7DAEABCEDA46187D72BCFC1924088344", hash_generated_method = "48D4135C26180FB5F7E62C3EC4F7E58B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final void cleanupAfterQuitting() {
            mSm.quitting();
            {
                getLooper().quit();
                mSm.mSmThread = null;
            } //End block
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
            // ---------- Original Method ----------
            //mSm.quitting();
            //if (mSm.mSmThread != null) {
                //getLooper().quit();
                //mSm.mSmThread = null;
            //}
            //mSm.mSmHandler = null;
            //mSm = null;
            //mMsg = null;
            //mProcessedMessages.cleanup();
            //mStateStack = null;
            //mTempStateStack = null;
            //mStateInfo.clear();
            //mInitialState = null;
            //mDestState = null;
            //mDeferredMessages.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.682 -0400", hash_original_method = "2988A35ECCAC86323C503A15399549F2", hash_generated_method = "24F2923921E0D81ECB25EB1EB22B30BF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final void completeConstruction() {
            Log.d(TAG, "completeConstruction: E");
            int maxDepth;
            maxDepth = 0;
            {
                Iterator<StateInfo> seatecAstronomy42 = mStateInfo.values().iterator();
                seatecAstronomy42.hasNext();
                StateInfo si = seatecAstronomy42.next();
                {
                    int depth;
                    depth = 0;
                    {
                        StateInfo i;
                        i = si;
                        {
                            i = i.parentStateInfo;
                        } //End block
                    } //End collapsed parenthetic
                    {
                        maxDepth = depth;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            Log.d(TAG, "completeConstruction: maxDepth=" + maxDepth);
            mStateStack = new StateInfo[maxDepth];
            mTempStateStack = new StateInfo[maxDepth];
            setupInitialStateStack();
            mIsConstructionCompleted = true;
            mMsg = obtainMessage(SM_INIT_CMD);
            invokeEnterMethods(0);
            performTransitions();
            Log.d(TAG, "completeConstruction: X");
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.682 -0400", hash_original_method = "01E4D9F834B911866303A5B2D2AF3A41", hash_generated_method = "3B52B587A362AA0C6AE69E0AB130F275")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final void processMsg(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            StateInfo curStateInfo;
            curStateInfo = mStateStack[mStateStackTopIndex];
            {
                Log.d(TAG, "processMsg: " + curStateInfo.state.getName());
            } //End block
            {
                boolean var5B75882492BC3F42AA5580C4F10745A9_2099936803 = (!curStateInfo.state.processMessage(msg));
                {
                    curStateInfo = curStateInfo.parentStateInfo;
                    {
                        mSm.unhandledMessage(msg);
                        {
                            boolean var980CF6578C138F02008BF1FB10188C29_1665800630 = (isQuit(msg));
                            {
                                transitionTo(mQuittingState);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        Log.d(TAG, "processMsg: " + curStateInfo.state.getName());
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                State orgState;
                orgState = mStateStack[mStateStackTopIndex].state;
                mProcessedMessages.add(msg, curStateInfo.state, orgState);
            } //End block
            {
                mProcessedMessages.add(msg, null, null);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.682 -0400", hash_original_method = "DE2778671ED61CA7054BB4798B489854", hash_generated_method = "C0135C2DF7BAA4922588A4594C01F563")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final void invokeExitMethods(StateInfo commonStateInfo) {
            dsTaint.addTaint(commonStateInfo.dsTaint);
            {
                State curState;
                curState = mStateStack[mStateStackTopIndex].state;
                Log.d(TAG, "invokeExitMethods: " + curState.getName());
                curState.exit();
                mStateStack[mStateStackTopIndex].active = false;
                mStateStackTopIndex -= 1;
            } //End block
            // ---------- Original Method ----------
            //while ((mStateStackTopIndex >= 0) &&
                    //(mStateStack[mStateStackTopIndex] != commonStateInfo)) {
                //State curState = mStateStack[mStateStackTopIndex].state;
                //if (mDbg) Log.d(TAG, "invokeExitMethods: " + curState.getName());
                //curState.exit();
                //mStateStack[mStateStackTopIndex].active = false;
                //mStateStackTopIndex -= 1;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.682 -0400", hash_original_method = "BBB0EEA794A5EB08AF57745D59E4ED21", hash_generated_method = "D5C7E591A0DF4BB161BA3F68A554902A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final void invokeEnterMethods(int stateStackEnteringIndex) {
            dsTaint.addTaint(stateStackEnteringIndex);
            {
                int i;
                i = stateStackEnteringIndex;
                {
                    Log.d(TAG, "invokeEnterMethods: " + mStateStack[i].state.getName());
                    mStateStack[i].state.enter();
                    mStateStack[i].active = true;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //for (int i = stateStackEnteringIndex; i <= mStateStackTopIndex; i++) {
                //if (mDbg) Log.d(TAG, "invokeEnterMethods: " + mStateStack[i].state.getName());
                //mStateStack[i].state.enter();
                //mStateStack[i].active = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.682 -0400", hash_original_method = "C63EF04ECCAE1AA00B9666D00D691AB5", hash_generated_method = "A37710C1E22931BD86BA51EFC060174A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final void moveDeferredMessageAtFrontOfQueue() {
            {
                int i;
                i = mDeferredMessages.size() - 1;
                {
                    Message curMsg;
                    curMsg = mDeferredMessages.get(i);
                    Log.d(TAG, "moveDeferredMessageAtFrontOfQueue; what=" + curMsg.what);
                    sendMessageAtFrontOfQueue(curMsg);
                } //End block
            } //End collapsed parenthetic
            mDeferredMessages.clear();
            // ---------- Original Method ----------
            //for (int i = mDeferredMessages.size() - 1; i >= 0; i-- ) {
                //Message curMsg = mDeferredMessages.get(i);
                //if (mDbg) Log.d(TAG, "moveDeferredMessageAtFrontOfQueue; what=" + curMsg.what);
                //sendMessageAtFrontOfQueue(curMsg);
            //}
            //mDeferredMessages.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.682 -0400", hash_original_method = "22489CF328AA5B68E3D4CD4685E1B0FF", hash_generated_method = "C36374E0C3C3C3EE1B520A0E881ABF89")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final int moveTempStateStackToStateStack() {
            int startingIndex;
            startingIndex = mStateStackTopIndex + 1;
            int i;
            i = mTempStateStackCount - 1;
            int j;
            j = startingIndex;
            {
                Log.d(TAG, "moveTempStackToStateStack: i=" + i + ",j=" + j);
                mStateStack[j] = mTempStateStack[i];
                j += 1;
                i -= 1;
            } //End block
            mStateStackTopIndex = j - 1;
            {
                Log.d(TAG, "moveTempStackToStateStack: X mStateStackTop="
                      + mStateStackTopIndex + ",startingIndex=" + startingIndex
                      + ",Top=" + mStateStack[mStateStackTopIndex].state.getName());
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int startingIndex = mStateStackTopIndex + 1;
            //int i = mTempStateStackCount - 1;
            //int j = startingIndex;
            //while (i >= 0) {
                //if (mDbg) Log.d(TAG, "moveTempStackToStateStack: i=" + i + ",j=" + j);
                //mStateStack[j] = mTempStateStack[i];
                //j += 1;
                //i -= 1;
            //}
            //mStateStackTopIndex = j - 1;
            //if (mDbg) {
                //Log.d(TAG, "moveTempStackToStateStack: X mStateStackTop="
                      //+ mStateStackTopIndex + ",startingIndex=" + startingIndex
                      //+ ",Top=" + mStateStack[mStateStackTopIndex].state.getName());
            //}
            //return startingIndex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "47EF66F8DA6A53298BD1106F4D1229BB", hash_generated_method = "DB34FB3B658C11FC6B48D2DF35234382")
        @DSModeled(DSC.SAFE)
        private final StateInfo setupTempStateStackWithStatesToEnter(State destState) {
            dsTaint.addTaint(destState.dsTaint);
            mTempStateStackCount = 0;
            StateInfo curStateInfo;
            curStateInfo = mStateInfo.get(destState);
            {
                mTempStateStack[mTempStateStackCount++] = curStateInfo;
                curStateInfo = curStateInfo.parentStateInfo;
            } //End block
            {
                Log.d(TAG, "setupTempStateStackWithStatesToEnter: X mTempStateStackCount="
                      + mTempStateStackCount + ",curStateInfo: " + curStateInfo);
            } //End block
            return (StateInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mTempStateStackCount = 0;
            //StateInfo curStateInfo = mStateInfo.get(destState);
            //do {
                //mTempStateStack[mTempStateStackCount++] = curStateInfo;
                //curStateInfo = curStateInfo.parentStateInfo;
            //} while ((curStateInfo != null) && !curStateInfo.active);
            //if (mDbg) {
                //Log.d(TAG, "setupTempStateStackWithStatesToEnter: X mTempStateStackCount="
                      //+ mTempStateStackCount + ",curStateInfo: " + curStateInfo);
            //}
            //return curStateInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "1F517A6C2C8B64C63155F67495EF1EF9", hash_generated_method = "4DDDE2C0F4258EF000BDA705CD575455")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final void setupInitialStateStack() {
            {
                Log.d(TAG, "setupInitialStateStack: E mInitialState="
                    + mInitialState.getName());
            } //End block
            StateInfo curStateInfo;
            curStateInfo = mStateInfo.get(mInitialState);
            {
                mTempStateStackCount = 0;
                {
                    mTempStateStack[mTempStateStackCount] = curStateInfo;
                    curStateInfo = curStateInfo.parentStateInfo;
                } //End block
            } //End collapsed parenthetic
            mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
            // ---------- Original Method ----------
            //if (mDbg) {
                //Log.d(TAG, "setupInitialStateStack: E mInitialState="
                    //+ mInitialState.getName());
            //}
            //StateInfo curStateInfo = mStateInfo.get(mInitialState);
            //for (mTempStateStackCount = 0; curStateInfo != null; mTempStateStackCount++) {
                //mTempStateStack[mTempStateStackCount] = curStateInfo;
                //curStateInfo = curStateInfo.parentStateInfo;
            //}
            //mStateStackTopIndex = -1;
            //moveTempStateStackToStateStack();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "38EC5F2FF9273B7F113CC175A6D6CA55", hash_generated_method = "9B7C47581740E34D7C0B2CEE82D94578")
        @DSModeled(DSC.SAFE)
        private final Message getCurrentMessage() {
            return (Message)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mMsg;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "4DAC448F0AE857FB37AA7C8477011F21", hash_generated_method = "78EFFC9C15720B0EFF829A7EF065163D")
        @DSModeled(DSC.SAFE)
        private final IState getCurrentState() {
            return (IState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mStateStack[mStateStackTopIndex].state;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "D4FAF1FE6F5065E5FE32CF44151438D5", hash_generated_method = "972D9671044565E63E4E1D7A9AA97FF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final StateInfo addState(State state, State parent) {
            dsTaint.addTaint(state.dsTaint);
            dsTaint.addTaint(parent.dsTaint);
            {
                Log.d(TAG, "addStateInternal: E state=" + state.getName()
                        + ",parent=" + ((parent == null) ? "" : parent.getName()));
            } //End block
            StateInfo parentStateInfo;
            parentStateInfo = null;
            {
                parentStateInfo = mStateInfo.get(parent);
                {
                    parentStateInfo = addState(parent, null);
                } //End block
            } //End block
            StateInfo stateInfo;
            stateInfo = mStateInfo.get(state);
            {
                stateInfo = new StateInfo();
                mStateInfo.put(state, stateInfo);
            } //End block
            {
                throw new RuntimeException("state already added");
            } //End block
            stateInfo.state = state;
            stateInfo.parentStateInfo = parentStateInfo;
            stateInfo.active = false;
            Log.d(TAG, "addStateInternal: X stateInfo: " + stateInfo);
            return (StateInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "6BCC70723A0A0266DFEF3F6F9EAE3DFA", hash_generated_method = "0879480300295483D1750B7D26B9687D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final void setInitialState(State initialState) {
            dsTaint.addTaint(initialState.dsTaint);
            Log.d(TAG, "setInitialState: initialState" + initialState.getName());
            // ---------- Original Method ----------
            //if (mDbg) Log.d(TAG, "setInitialState: initialState" + initialState.getName());
            //mInitialState = initialState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "21890E800BC5188E239893B522387EDA", hash_generated_method = "52CB3DA3524E8E347BA11D1FF12AE2C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final void transitionTo(IState destState) {
            dsTaint.addTaint(destState.dsTaint);
            mDestState = (State) destState;
            Log.d(TAG, "StateMachine.transitionTo EX destState" + mDestState.getName());
            // ---------- Original Method ----------
            //mDestState = (State) destState;
            //if (mDbg) Log.d(TAG, "StateMachine.transitionTo EX destState" + mDestState.getName());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "E228351895B227260722E6D77267BEC1", hash_generated_method = "B7F147C0AA737A9AD423B80071F3F924")
        @DSModeled(DSC.SAFE)
        private final void deferMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            Log.d(TAG, "deferMessage: msg=" + msg.what);
            Message newMsg;
            newMsg = obtainMessage();
            newMsg.copyFrom(msg);
            mDeferredMessages.add(newMsg);
            // ---------- Original Method ----------
            //if (mDbg) Log.d(TAG, "deferMessage: msg=" + msg.what);
            //Message newMsg = obtainMessage();
            //newMsg.copyFrom(msg);
            //mDeferredMessages.add(newMsg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "70D38ABCE91561514ACD98C85375A9A1", hash_generated_method = "1354C2DD1109B65E5EABADDD9EE35CA4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final void quit() {
            Log.d(TAG, "quit:");
            sendMessage(obtainMessage(SM_QUIT_CMD, mQuitObj));
            // ---------- Original Method ----------
            //if (mDbg) Log.d(TAG, "quit:");
            //sendMessage(obtainMessage(SM_QUIT_CMD, mQuitObj));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "BAB49FBE24A81490A5F317754A03EEE6", hash_generated_method = "0062C192B0C19E67B0B3CDDE7B4C74B0")
        @DSModeled(DSC.SAFE)
        private final boolean isQuit(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return (msg.what == SM_QUIT_CMD) && (msg.obj == mQuitObj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "0EC17970A8F6815D37F02ED3B599FE78", hash_generated_method = "F5BFBD07FAD0ADD82ECCE81002E3DB43")
        @DSModeled(DSC.SAFE)
        private final boolean isDbg() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mDbg;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.683 -0400", hash_original_method = "2FBE0CE6F45608217065DCE46294BFD1", hash_generated_method = "1160E047F28611E192FA03F4D6F6DBCF")
        @DSModeled(DSC.SAFE)
        private final void setDbg(boolean dbg) {
            dsTaint.addTaint(dbg);
            // ---------- Original Method ----------
            //mDbg = dbg;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.684 -0400", hash_original_method = "80DE9CB8772B169AC72245D032E86B1D", hash_generated_method = "68DC38439249B597A8388765D1352E66")
        @DSModeled(DSC.SAFE)
        private final void setProcessedMessagesSize(int maxSize) {
            dsTaint.addTaint(maxSize);
            mProcessedMessages.setSize(maxSize);
            // ---------- Original Method ----------
            //mProcessedMessages.setSize(maxSize);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.684 -0400", hash_original_method = "8FB0F44FDB0C5DC10452484BB601B3E7", hash_generated_method = "9A8098BBC553401A62F50AE447A24440")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final int getProcessedMessagesSize() {
            int var7094F3E812A5A7B9807ACDF8F0A83A82_530399903 = (mProcessedMessages.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mProcessedMessages.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.684 -0400", hash_original_method = "92EED68DA49DE907A6704035F6436DD3", hash_generated_method = "319B280596CF738E67E94DB65520AC89")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final int getProcessedMessagesCount() {
            int var35155D08ADED50853B800820545DA8A4_1505683140 = (mProcessedMessages.count());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mProcessedMessages.count();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.684 -0400", hash_original_method = "1E4BC1F21BF61852DF075DACE8E37071", hash_generated_method = "1F51275ECB7B0B50929A970E0AA4F269")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final ProcessedMessageInfo getProcessedMessageInfo(int index) {
            dsTaint.addTaint(index);
            ProcessedMessageInfo varBE6BDCED4CBDA5859807B9BA2E3FB80B_617620825 = (mProcessedMessages.get(index));
            return (ProcessedMessageInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mProcessedMessages.get(index);
        }

        
        private class StateInfo {
            State state;
            StateInfo parentStateInfo;
            boolean active;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.684 -0400", hash_original_method = "ABB8BC4D82891CF5369714A62A1A931C", hash_generated_method = "A05F4BCD46BBD1F85546DB68BEDD49B2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public String toString() {
                String varA273118D0825D5436D7C245451B3BC05_331071456 = ("state=" + state.getName() + ",active=" + active
                        + ",parent=" + ((parentStateInfo == null) ?
                                        "null" : parentStateInfo.state.getName())); //DSFIXME:  CODE0008: Nested ternary operator in expression
                return dsTaint.getTaintString();
                // ---------- Original Method ----------
                //return "state=" + state.getName() + ",active=" + active
                        //+ ",parent=" + ((parentStateInfo == null) ?
                                        //"null" : parentStateInfo.state.getName());
            }

            
        }


        
        private class HaltingState extends State {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.684 -0400", hash_original_method = "58076C952A23C34E44D31450392EEB12", hash_generated_method = "69B70A751266BF045BCD50D00A8EA7F1")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean processMessage(Message msg) {
                dsTaint.addTaint(msg.dsTaint);
                mSm.haltedProcessMessage(msg);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //mSm.haltedProcessMessage(msg);
                //return true;
            }

            
        }


        
        private class QuittingState extends State {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.684 -0400", hash_original_method = "5D2BC087464A61E35A06899EEE03AD06", hash_generated_method = "E2E248CFD7D3532C8E675247B7E916E2")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean processMessage(Message msg) {
                dsTaint.addTaint(msg.dsTaint);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return NOT_HANDLED;
            }

            
        }


        
    }


    
}


